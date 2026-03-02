package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.work.WorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class VideoCapture extends UseCase {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int DEQUE_TIMEOUT_USEC = 10000;
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_FILE_IO = 4;
    public static final int ERROR_INVALID_CAMERA = 5;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;
    private static final String TAG = "VideoCapture";
    private static final String VIDEO_MIME_TYPE = "video/avc";
    private int mAudioBitRate;
    private final MediaCodec.BufferInfo mAudioBufferInfo;
    private int mAudioBufferSize;
    private int mAudioChannelCount;
    private MediaCodec mAudioEncoder;
    private Handler mAudioHandler;
    private HandlerThread mAudioHandlerThread;
    private AudioRecord mAudioRecorder;
    private int mAudioSampleRate;
    private int mAudioTrackIndex;
    Surface mCameraSurface;
    private DeferrableSurface mDeferrableSurface;
    private final AtomicBoolean mEndOfAudioStreamSignal;
    private final AtomicBoolean mEndOfAudioVideoSignal;
    private final AtomicBoolean mEndOfVideoStreamSignal;
    private final AtomicBoolean mIsFirstAudioSampleWrite;
    private final AtomicBoolean mIsFirstVideoSampleWrite;
    private boolean mIsRecording;
    private MediaMuxer mMuxer;
    private final Object mMuxerLock;
    private boolean mMuxerStarted;
    private ParcelFileDescriptor mParcelFileDescriptor;
    private ListenableFuture<Void> mRecordingFuture;
    Uri mSavedVideoUri;
    private final MediaCodec.BufferInfo mVideoBufferInfo;
    MediaCodec mVideoEncoder;
    private Handler mVideoHandler;
    private HandlerThread mVideoHandlerThread;
    private int mVideoTrackIndex;
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int[] CamcorderQuality = {8, 6, 5, 4};
    private static final short[] sAudioEncoding = {2, 3, 4};

    public static final class Metadata {
        public Location location;
    }

    public interface OnVideoSavedCallback {
        void onError(int videoCaptureError, String message, Throwable cause);

        void onVideoSaved(OutputFileResults outputFileResults);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoCaptureError {
    }

    VideoCapture(VideoCaptureConfig config) {
        super(config);
        this.mVideoBufferInfo = new MediaCodec.BufferInfo();
        this.mMuxerLock = new Object();
        this.mEndOfVideoStreamSignal = new AtomicBoolean(true);
        this.mEndOfAudioStreamSignal = new AtomicBoolean(true);
        this.mEndOfAudioVideoSignal = new AtomicBoolean(true);
        this.mAudioBufferInfo = new MediaCodec.BufferInfo();
        this.mIsFirstVideoSampleWrite = new AtomicBoolean(false);
        this.mIsFirstAudioSampleWrite = new AtomicBoolean(false);
        this.mRecordingFuture = null;
        this.mMuxerStarted = false;
        this.mIsRecording = false;
    }

    private static MediaFormat createMediaFormat(VideoCaptureConfig config, Size resolution) {
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, resolution.getWidth(), resolution.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", config.getBitRate());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", config.getVideoFrameRate());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", config.getIFrameInterval());
        return mediaFormatCreateVideoFormat;
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig<?> getDefaultConfig(boolean applyDefaultConfig, UseCaseConfigFactory factory) {
        Config config = factory.getConfig(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE);
        if (applyDefaultConfig) {
            config = Config.mergeConfigs(config, DEFAULT_CONFIG.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public void onAttached() {
        this.mVideoHandlerThread = new HandlerThread("CameraX-video encoding thread");
        this.mAudioHandlerThread = new HandlerThread("CameraX-audio encoding thread");
        this.mVideoHandlerThread.start();
        this.mVideoHandler = new Handler(this.mVideoHandlerThread.getLooper());
        this.mAudioHandlerThread.start();
        this.mAudioHandler = new Handler(this.mAudioHandlerThread.getLooper());
    }

    @Override // androidx.camera.core.UseCase
    protected Size onSuggestedResolutionUpdated(Size suggestedResolution) {
        if (this.mCameraSurface != null) {
            this.mVideoEncoder.stop();
            this.mVideoEncoder.release();
            this.mAudioEncoder.stop();
            this.mAudioEncoder.release();
            releaseCameraSurface(false);
        }
        try {
            this.mVideoEncoder = MediaCodec.createEncoderByType(VIDEO_MIME_TYPE);
            this.mAudioEncoder = MediaCodec.createEncoderByType(AUDIO_MIME_TYPE);
            setupEncoder(getCameraId(), suggestedResolution);
            return suggestedResolution;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to create MediaCodec due to: " + e.getCause());
        }
    }

    /* JADX INFO: renamed from: startRecording, reason: merged with bridge method [inline-methods] */
    public void m5744lambda$startRecording$0$androidxcameracoreVideoCapture(final OutputFileOptions outputFileOptions, final Executor executor, final OnVideoSavedCallback callback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5744lambda$startRecording$0$androidxcameracoreVideoCapture(outputFileOptions, executor, callback);
                }
            });
            return;
        }
        Logger.m1141i(TAG, "startRecording");
        this.mIsFirstVideoSampleWrite.set(false);
        this.mIsFirstAudioSampleWrite.set(false);
        final VideoSavedListenerWrapper videoSavedListenerWrapper = new VideoSavedListenerWrapper(executor, callback);
        CameraInternal camera = getCamera();
        if (camera == null) {
            videoSavedListenerWrapper.onError(5, "Not bound to a Camera [" + this + "]", null);
            return;
        }
        if (!this.mEndOfAudioVideoSignal.get()) {
            videoSavedListenerWrapper.onError(3, "It is still in video recording!", null);
            return;
        }
        try {
            this.mAudioRecorder.startRecording();
            final AtomicReference atomicReference = new AtomicReference();
            this.mRecordingFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda3
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return VideoCapture.lambda$startRecording$1(atomicReference, completer);
                }
            });
            final CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
            this.mRecordingFuture.addListener(new Runnable() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5745lambda$startRecording$2$androidxcameracoreVideoCapture();
                }
            }, CameraXExecutors.mainThreadExecutor());
            try {
                Logger.m1141i(TAG, "videoEncoder start");
                this.mVideoEncoder.start();
                Logger.m1141i(TAG, "audioEncoder start");
                this.mAudioEncoder.start();
                try {
                    synchronized (this.mMuxerLock) {
                        MediaMuxer mediaMuxerInitMediaMuxer = initMediaMuxer(outputFileOptions);
                        this.mMuxer = mediaMuxerInitMediaMuxer;
                        Preconditions.checkNotNull(mediaMuxerInitMediaMuxer);
                        this.mMuxer.setOrientationHint(getRelativeRotation(camera));
                        Metadata metadata = outputFileOptions.getMetadata();
                        if (metadata != null && metadata.location != null) {
                            this.mMuxer.setLocation((float) metadata.location.getLatitude(), (float) metadata.location.getLongitude());
                        }
                    }
                    this.mEndOfVideoStreamSignal.set(false);
                    this.mEndOfAudioStreamSignal.set(false);
                    this.mEndOfAudioVideoSignal.set(false);
                    this.mIsRecording = true;
                    notifyActive();
                    this.mAudioHandler.post(new Runnable() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m5746lambda$startRecording$3$androidxcameracoreVideoCapture(videoSavedListenerWrapper);
                        }
                    });
                    final String cameraId = getCameraId();
                    final Size attachedSurfaceResolution = getAttachedSurfaceResolution();
                    this.mVideoHandler.post(new Runnable() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m5747lambda$startRecording$4$androidxcameracoreVideoCapture(videoSavedListenerWrapper, cameraId, attachedSurfaceResolution, completer);
                        }
                    });
                } catch (IOException e) {
                    completer.set(null);
                    videoSavedListenerWrapper.onError(2, "MediaMuxer creation failed!", e);
                }
            } catch (IllegalStateException e2) {
                completer.set(null);
                videoSavedListenerWrapper.onError(1, "Audio/Video encoder start fail", e2);
            }
        } catch (IllegalStateException e3) {
            videoSavedListenerWrapper.onError(1, "AudioRecorder start fail", e3);
        }
    }

    static /* synthetic */ Object lambda$startRecording$1(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
        atomicReference.set(completer);
        return "startRecording";
    }

    /* JADX INFO: renamed from: lambda$startRecording$2$androidx-camera-core-VideoCapture, reason: not valid java name */
    /* synthetic */ void m5745lambda$startRecording$2$androidxcameracoreVideoCapture() {
        this.mRecordingFuture = null;
        if (getCamera() != null) {
            setupEncoder(getCameraId(), getAttachedSurfaceResolution());
            notifyReset();
        }
    }

    /* JADX INFO: renamed from: lambda$startRecording$4$androidx-camera-core-VideoCapture, reason: not valid java name */
    /* synthetic */ void m5747lambda$startRecording$4$androidxcameracoreVideoCapture(OnVideoSavedCallback onVideoSavedCallback, String str, Size size, CallbackToFutureAdapter.Completer completer) {
        if (!videoEncode(onVideoSavedCallback, str, size)) {
            onVideoSavedCallback.onVideoSaved(new OutputFileResults(this.mSavedVideoUri));
            this.mSavedVideoUri = null;
        }
        completer.set(null);
    }

    /* JADX INFO: renamed from: stopRecording, reason: merged with bridge method [inline-methods] */
    public void m5748lambda$stopRecording$5$androidxcameracoreVideoCapture() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5748lambda$stopRecording$5$androidxcameracoreVideoCapture();
                }
            });
            return;
        }
        Logger.m1141i(TAG, "stopRecording");
        notifyInactive();
        if (this.mEndOfAudioVideoSignal.get() || !this.mIsRecording) {
            return;
        }
        this.mEndOfAudioStreamSignal.set(true);
    }

    @Override // androidx.camera.core.UseCase
    public void onDetached() {
        m5748lambda$stopRecording$5$androidxcameracoreVideoCapture();
        ListenableFuture<Void> listenableFuture = this.mRecordingFuture;
        if (listenableFuture != null) {
            listenableFuture.addListener(new Runnable() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5743lambda$onDetached$6$androidxcameracoreVideoCapture();
                }
            }, CameraXExecutors.mainThreadExecutor());
        } else {
            m5743lambda$onDetached$6$androidxcameracoreVideoCapture();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: releaseResources, reason: merged with bridge method [inline-methods] */
    public void m5743lambda$onDetached$6$androidxcameracoreVideoCapture() {
        this.mVideoHandlerThread.quitSafely();
        this.mAudioHandlerThread.quitSafely();
        MediaCodec mediaCodec = this.mAudioEncoder;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.mAudioEncoder = null;
        }
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            audioRecord.release();
            this.mAudioRecorder = null;
        }
        if (this.mCameraSurface != null) {
            releaseCameraSurface(true);
        }
    }

    @Override // androidx.camera.core.UseCase
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig(config);
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        m5748lambda$stopRecording$5$androidxcameracoreVideoCapture();
    }

    private void releaseCameraSurface(final boolean releaseVideoEncoder) {
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface == null) {
            return;
        }
        final MediaCodec mediaCodec = this.mVideoEncoder;
        deferrableSurface.close();
        this.mDeferrableSurface.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                VideoCapture.lambda$releaseCameraSurface$7(releaseVideoEncoder, mediaCodec);
            }
        }, CameraXExecutors.mainThreadExecutor());
        if (releaseVideoEncoder) {
            this.mVideoEncoder = null;
        }
        this.mCameraSurface = null;
        this.mDeferrableSurface = null;
    }

    static /* synthetic */ void lambda$releaseCameraSurface$7(boolean z, MediaCodec mediaCodec) {
        if (!z || mediaCodec == null) {
            return;
        }
        mediaCodec.release();
    }

    public void setTargetRotation(int rotation) {
        setTargetRotationInternal(rotation);
    }

    void setupEncoder(final String cameraId, final Size resolution) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getCurrentConfig();
        this.mVideoEncoder.reset();
        this.mVideoEncoder.configure(createMediaFormat(videoCaptureConfig, resolution), (Surface) null, (MediaCrypto) null, 1);
        if (this.mCameraSurface != null) {
            releaseCameraSurface(false);
        }
        final Surface surfaceCreateInputSurface = this.mVideoEncoder.createInputSurface();
        this.mCameraSurface = surfaceCreateInputSurface;
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(videoCaptureConfig);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(this.mCameraSurface);
        this.mDeferrableSurface = immediateSurface;
        ListenableFuture<Void> terminationFuture = immediateSurface.getTerminationFuture();
        Objects.requireNonNull(surfaceCreateInputSurface);
        terminationFuture.addListener(new Runnable() { // from class: androidx.camera.core.VideoCapture$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                surfaceCreateInputSurface.release();
            }
        }, CameraXExecutors.mainThreadExecutor());
        builderCreateFrom.addSurface(this.mDeferrableSurface);
        builderCreateFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.VideoCapture.1
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public void onError(SessionConfig sessionConfig, SessionConfig.SessionError error) {
                if (VideoCapture.this.isCurrentCamera(cameraId)) {
                    VideoCapture.this.setupEncoder(cameraId, resolution);
                    VideoCapture.this.notifyReset();
                }
            }
        });
        updateSessionConfig(builderCreateFrom.build());
        setAudioParametersByCamcorderProfile(resolution, cameraId);
        this.mAudioEncoder.reset();
        this.mAudioEncoder.configure(createAudioMediaFormat(), (Surface) null, (MediaCrypto) null, 1);
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            audioRecord.release();
        }
        AudioRecord audioRecordAutoConfigAudioRecordSource = autoConfigAudioRecordSource(videoCaptureConfig);
        this.mAudioRecorder = audioRecordAutoConfigAudioRecordSource;
        if (audioRecordAutoConfigAudioRecordSource == null) {
            Logger.m1139e(TAG, "AudioRecord object cannot initialized correctly!");
        }
        this.mVideoTrackIndex = -1;
        this.mAudioTrackIndex = -1;
        this.mIsRecording = false;
    }

    private boolean writeVideoEncodedBuffer(int bufferIndex) {
        if (bufferIndex < 0) {
            Logger.m1139e(TAG, "Output buffer should not have negative index: " + bufferIndex);
            return false;
        }
        ByteBuffer outputBuffer = this.mVideoEncoder.getOutputBuffer(bufferIndex);
        if (outputBuffer == null) {
            Logger.m1137d(TAG, "OutputBuffer was null.");
            return false;
        }
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0 && this.mVideoBufferInfo.size > 0) {
            outputBuffer.position(this.mVideoBufferInfo.offset);
            outputBuffer.limit(this.mVideoBufferInfo.offset + this.mVideoBufferInfo.size);
            this.mVideoBufferInfo.presentationTimeUs = System.nanoTime() / 1000;
            synchronized (this.mMuxerLock) {
                if (!this.mIsFirstVideoSampleWrite.get()) {
                    Logger.m1141i(TAG, "First video sample written.");
                    this.mIsFirstVideoSampleWrite.set(true);
                }
                this.mMuxer.writeSampleData(this.mVideoTrackIndex, outputBuffer, this.mVideoBufferInfo);
            }
        }
        this.mVideoEncoder.releaseOutputBuffer(bufferIndex, false);
        return (this.mVideoBufferInfo.flags & 4) != 0;
    }

    private boolean writeAudioEncodedBuffer(int bufferIndex) {
        ByteBuffer outputBuffer = getOutputBuffer(this.mAudioEncoder, bufferIndex);
        outputBuffer.position(this.mAudioBufferInfo.offset);
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0 && this.mAudioBufferInfo.size > 0 && this.mAudioBufferInfo.presentationTimeUs > 0) {
            try {
                synchronized (this.mMuxerLock) {
                    if (!this.mIsFirstAudioSampleWrite.get()) {
                        Logger.m1141i(TAG, "First audio sample written.");
                        this.mIsFirstAudioSampleWrite.set(true);
                    }
                    this.mMuxer.writeSampleData(this.mAudioTrackIndex, outputBuffer, this.mAudioBufferInfo);
                }
            } catch (Exception e) {
                Logger.m1139e(TAG, "audio error:size=" + this.mAudioBufferInfo.size + "/offset=" + this.mAudioBufferInfo.offset + "/timeUs=" + this.mAudioBufferInfo.presentationTimeUs);
                e.printStackTrace();
            }
        }
        this.mAudioEncoder.releaseOutputBuffer(bufferIndex, false);
        return (this.mAudioBufferInfo.flags & 4) != 0;
    }

    boolean videoEncode(OnVideoSavedCallback videoSavedCallback, String cameraId, Size resolution) {
        boolean zWriteVideoEncodedBuffer = false;
        boolean z = false;
        while (!zWriteVideoEncodedBuffer && !z) {
            if (this.mEndOfVideoStreamSignal.get()) {
                this.mVideoEncoder.signalEndOfInputStream();
                this.mEndOfVideoStreamSignal.set(false);
            }
            int iDequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, WorkRequest.MIN_BACKOFF_MILLIS);
            if (iDequeueOutputBuffer == -2) {
                if (this.mMuxerStarted) {
                    videoSavedCallback.onError(1, "Unexpected change in video encoding format.", null);
                    z = true;
                }
                synchronized (this.mMuxerLock) {
                    int iAddTrack = this.mMuxer.addTrack(this.mVideoEncoder.getOutputFormat());
                    this.mVideoTrackIndex = iAddTrack;
                    if (this.mAudioTrackIndex >= 0 && iAddTrack >= 0) {
                        this.mMuxerStarted = true;
                        Logger.m1141i(TAG, "media mMuxer start");
                        this.mMuxer.start();
                    }
                }
            } else if (iDequeueOutputBuffer != -1) {
                zWriteVideoEncodedBuffer = writeVideoEncodedBuffer(iDequeueOutputBuffer);
            }
        }
        try {
            Logger.m1141i(TAG, "videoEncoder stop");
            this.mVideoEncoder.stop();
        } catch (IllegalStateException e) {
            videoSavedCallback.onError(1, "Video encoder stop failed!", e);
            z = true;
        }
        try {
            synchronized (this.mMuxerLock) {
                MediaMuxer mediaMuxer = this.mMuxer;
                if (mediaMuxer != null) {
                    if (this.mMuxerStarted) {
                        mediaMuxer.stop();
                    }
                    this.mMuxer.release();
                    this.mMuxer = null;
                }
            }
        } catch (IllegalStateException e2) {
            videoSavedCallback.onError(2, "Muxer stop failed!", e2);
            z = true;
        }
        ParcelFileDescriptor parcelFileDescriptor = this.mParcelFileDescriptor;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
                this.mParcelFileDescriptor = null;
            } catch (IOException e3) {
                videoSavedCallback.onError(2, "File descriptor close failed!", e3);
                z = true;
            }
        }
        this.mMuxerStarted = false;
        this.mEndOfAudioVideoSignal.set(true);
        Logger.m1141i(TAG, "Video encode thread end.");
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: audioEncode, reason: merged with bridge method [inline-methods] */
    public boolean m5746lambda$startRecording$3$androidxcameracoreVideoCapture(OnVideoSavedCallback videoSavedCallback) {
        boolean zWriteAudioEncodedBuffer = false;
        while (!zWriteAudioEncodedBuffer && this.mIsRecording) {
            if (this.mEndOfAudioStreamSignal.get()) {
                this.mEndOfAudioStreamSignal.set(false);
                this.mIsRecording = false;
            }
            MediaCodec mediaCodec = this.mAudioEncoder;
            if (mediaCodec != null && this.mAudioRecorder != null) {
                int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1L);
                if (iDequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = getInputBuffer(this.mAudioEncoder, iDequeueInputBuffer);
                    inputBuffer.clear();
                    int i = this.mAudioRecorder.read(inputBuffer, this.mAudioBufferSize);
                    if (i > 0) {
                        this.mAudioEncoder.queueInputBuffer(iDequeueInputBuffer, 0, i, System.nanoTime() / 1000, this.mIsRecording ? 0 : 4);
                    }
                }
                do {
                    int iDequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0L);
                    if (iDequeueOutputBuffer == -2) {
                        synchronized (this.mMuxerLock) {
                            int iAddTrack = this.mMuxer.addTrack(this.mAudioEncoder.getOutputFormat());
                            this.mAudioTrackIndex = iAddTrack;
                            if (iAddTrack >= 0 && this.mVideoTrackIndex >= 0) {
                                this.mMuxerStarted = true;
                                this.mMuxer.start();
                            }
                        }
                    } else if (iDequeueOutputBuffer != -1) {
                        zWriteAudioEncodedBuffer = writeAudioEncodedBuffer(iDequeueOutputBuffer);
                    }
                    if (iDequeueOutputBuffer >= 0) {
                    }
                } while (!zWriteAudioEncodedBuffer);
            }
        }
        try {
            Logger.m1141i(TAG, "audioRecorder stop");
            this.mAudioRecorder.stop();
        } catch (IllegalStateException e) {
            videoSavedCallback.onError(1, "Audio recorder stop failed!", e);
        }
        try {
            this.mAudioEncoder.stop();
        } catch (IllegalStateException e2) {
            videoSavedCallback.onError(1, "Audio encoder stop failed!", e2);
        }
        Logger.m1141i(TAG, "Audio encode thread end");
        this.mEndOfVideoStreamSignal.set(true);
        return false;
    }

    private ByteBuffer getInputBuffer(MediaCodec codec, int index) {
        return codec.getInputBuffer(index);
    }

    private ByteBuffer getOutputBuffer(MediaCodec codec, int index) {
        return codec.getOutputBuffer(index);
    }

    private MediaFormat createAudioMediaFormat() {
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(AUDIO_MIME_TYPE, this.mAudioSampleRate, this.mAudioChannelCount);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger("bitrate", this.mAudioBitRate);
        return mediaFormatCreateAudioFormat;
    }

    private AudioRecord autoConfigAudioRecordSource(VideoCaptureConfig config) {
        for (short s : sAudioEncoding) {
            int i = this.mAudioChannelCount == 1 ? 16 : 12;
            int audioRecordSource = config.getAudioRecordSource();
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(this.mAudioSampleRate, i, s);
                if (minBufferSize <= 0) {
                    minBufferSize = config.getAudioMinBufferSize();
                }
                int i2 = minBufferSize;
                AudioRecord audioRecord = new AudioRecord(audioRecordSource, this.mAudioSampleRate, i, s, i2 * 2);
                if (audioRecord.getState() == 1) {
                    this.mAudioBufferSize = i2;
                    Logger.m1141i(TAG, "source: " + audioRecordSource + " audioSampleRate: " + this.mAudioSampleRate + " channelConfig: " + i + " audioFormat: " + ((int) s) + " bufferSize: " + i2);
                    return audioRecord;
                }
                continue;
            } catch (Exception e) {
                Logger.m1140e(TAG, "Exception, keep trying.", e);
            }
        }
        return null;
    }

    private void setAudioParametersByCamcorderProfile(Size currentResolution, String cameraId) {
        int i;
        try {
        } catch (NumberFormatException unused) {
            Logger.m1141i(TAG, "The camera Id is not an integer because the camera may be a removable device. Use the default values for the audio related settings.");
        }
        for (int i2 : CamcorderQuality) {
            if (CamcorderProfile.hasProfile(Integer.parseInt(cameraId), i2)) {
                CamcorderProfile camcorderProfile = CamcorderProfile.get(Integer.parseInt(cameraId), i2);
                if (currentResolution.getWidth() == camcorderProfile.videoFrameWidth && currentResolution.getHeight() == camcorderProfile.videoFrameHeight) {
                    this.mAudioChannelCount = camcorderProfile.audioChannels;
                    this.mAudioSampleRate = camcorderProfile.audioSampleRate;
                    this.mAudioBitRate = camcorderProfile.audioBitRate;
                    return;
                }
                VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getCurrentConfig();
                this.mAudioChannelCount = videoCaptureConfig.getAudioChannelCount();
                this.mAudioSampleRate = videoCaptureConfig.getAudioSampleRate();
                this.mAudioBitRate = videoCaptureConfig.getAudioBitRate();
            }
        }
        VideoCaptureConfig videoCaptureConfig2 = (VideoCaptureConfig) getCurrentConfig();
        this.mAudioChannelCount = videoCaptureConfig2.getAudioChannelCount();
        this.mAudioSampleRate = videoCaptureConfig2.getAudioSampleRate();
        this.mAudioBitRate = videoCaptureConfig2.getAudioBitRate();
    }

    private MediaMuxer initMediaMuxer(OutputFileOptions outputFileOptions) throws IOException {
        ContentValues contentValues;
        if (outputFileOptions.isSavingToFile()) {
            File file = outputFileOptions.getFile();
            this.mSavedVideoUri = Uri.fromFile(outputFileOptions.getFile());
            return new MediaMuxer(file.getAbsolutePath(), 0);
        }
        if (outputFileOptions.isSavingToFileDescriptor()) {
            return new MediaMuxer(outputFileOptions.getFileDescriptor(), 0);
        }
        if (outputFileOptions.isSavingToMediaStore()) {
            if (outputFileOptions.getContentValues() != null) {
                contentValues = new ContentValues(outputFileOptions.getContentValues());
            } else {
                contentValues = new ContentValues();
            }
            Uri uriInsert = outputFileOptions.getContentResolver().insert(outputFileOptions.getSaveCollection(), contentValues);
            this.mSavedVideoUri = uriInsert;
            if (uriInsert == null) {
                throw new IOException("Invalid Uri!");
            }
            try {
                this.mParcelFileDescriptor = outputFileOptions.getContentResolver().openFileDescriptor(this.mSavedVideoUri, "rw");
                return new MediaMuxer(this.mParcelFileDescriptor.getFileDescriptor(), 0);
            } catch (IOException e) {
                this.mSavedVideoUri = null;
                throw e;
            }
        }
        throw new IllegalArgumentException("The OutputFileOptions should assign before recording");
    }

    public static final class Defaults implements ConfigProvider<VideoCaptureConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 1;
        private static final int DEFAULT_AUDIO_BIT_RATE = 64000;
        private static final int DEFAULT_AUDIO_CHANNEL_COUNT = 1;
        private static final int DEFAULT_AUDIO_MIN_BUFFER_SIZE = 1024;
        private static final int DEFAULT_AUDIO_RECORD_SOURCE = 1;
        private static final int DEFAULT_AUDIO_SAMPLE_RATE = 8000;
        private static final int DEFAULT_BIT_RATE = 8388608;
        private static final VideoCaptureConfig DEFAULT_CONFIG;
        private static final int DEFAULT_INTRA_FRAME_INTERVAL = 1;
        private static final Size DEFAULT_MAX_RESOLUTION;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 3;
        private static final int DEFAULT_VIDEO_FRAME_RATE = 30;

        static {
            Size size = new Size(1920, 1080);
            DEFAULT_MAX_RESOLUTION = size;
            DEFAULT_CONFIG = new Builder().setVideoFrameRate(30).setBitRate(8388608).setIFrameInterval(1).setAudioBitRate(DEFAULT_AUDIO_BIT_RATE).setAudioSampleRate(DEFAULT_AUDIO_SAMPLE_RATE).setAudioChannelCount(1).setAudioRecordSource(1).setAudioMinBufferSize(1024).setMaxResolution(size).setSurfaceOccupancyPriority(3).setTargetAspectRatio(1).getUseCaseConfig();
        }

        @Override // androidx.camera.core.impl.ConfigProvider
        public VideoCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class VideoSavedListenerWrapper implements OnVideoSavedCallback {
        Executor mExecutor;
        OnVideoSavedCallback mOnVideoSavedCallback;

        VideoSavedListenerWrapper(Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
            this.mExecutor = executor;
            this.mOnVideoSavedCallback = onVideoSavedCallback;
        }

        /* JADX INFO: renamed from: lambda$onVideoSaved$0$androidx-camera-core-VideoCapture$VideoSavedListenerWrapper */
        /* synthetic */ void m1152x99849d14(OutputFileResults outputFileResults) {
            this.mOnVideoSavedCallback.onVideoSaved(outputFileResults);
        }

        @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
        public void onVideoSaved(final OutputFileResults outputFileResults) {
            try {
                this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.VideoCapture$VideoSavedListenerWrapper$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1152x99849d14(outputFileResults);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.m1139e(VideoCapture.TAG, "Unable to post to the supplied executor.");
            }
        }

        @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
        public void onError(final int videoCaptureError, final String message, final Throwable cause) {
            try {
                this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.VideoCapture$VideoSavedListenerWrapper$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1151xe8a64259(videoCaptureError, message, cause);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.m1139e(VideoCapture.TAG, "Unable to post to the supplied executor.");
            }
        }

        /* JADX INFO: renamed from: lambda$onError$1$androidx-camera-core-VideoCapture$VideoSavedListenerWrapper */
        /* synthetic */ void m1151xe8a64259(int i, String str, Throwable th) {
            this.mOnVideoSavedCallback.onError(i, str, th);
        }
    }

    public static final class Builder implements UseCaseConfig.Builder<VideoCapture, VideoCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public /* bridge */ /* synthetic */ Builder setSupportedResolutions(List resolutions) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) resolutions);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Object setTargetClass(Class targetClass) {
            return setTargetClass((Class<VideoCapture>) targetClass);
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private Builder(MutableOptionsBundle mutableConfig) {
            this.mMutableConfig = mutableConfig;
            Class cls = (Class) mutableConfig.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls != null && !cls.equals(VideoCapture.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            setTargetClass(VideoCapture.class);
        }

        static Builder fromConfig(Config configuration) {
            return new Builder(MutableOptionsBundle.from(configuration));
        }

        public static Builder fromConfig(VideoCaptureConfig configuration) {
            return new Builder(MutableOptionsBundle.from((Config) configuration));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public VideoCaptureConfig getUseCaseConfig() {
            return new VideoCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public VideoCapture build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) != null && getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) != null) {
                throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
            }
            return new VideoCapture(getUseCaseConfig());
        }

        public Builder setVideoFrameRate(int videoFrameRate) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_FRAME_RATE, Integer.valueOf(videoFrameRate));
            return this;
        }

        public Builder setBitRate(int bitRate) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_BIT_RATE, Integer.valueOf(bitRate));
            return this;
        }

        public Builder setIFrameInterval(int interval) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_INTRA_FRAME_INTERVAL, Integer.valueOf(interval));
            return this;
        }

        public Builder setAudioBitRate(int bitRate) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_BIT_RATE, Integer.valueOf(bitRate));
            return this;
        }

        public Builder setAudioSampleRate(int sampleRate) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_SAMPLE_RATE, Integer.valueOf(sampleRate));
            return this;
        }

        public Builder setAudioChannelCount(int channelCount) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_CHANNEL_COUNT, Integer.valueOf(channelCount));
            return this;
        }

        public Builder setAudioRecordSource(int source) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_RECORD_SOURCE, Integer.valueOf(source));
            return this;
        }

        public Builder setAudioMinBufferSize(int minBufferSize) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_MIN_BUFFER_SIZE, Integer.valueOf(minBufferSize));
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetClass(Class<VideoCapture> targetClass) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, targetClass);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(targetClass.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetName(String targetName) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, targetName);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetAspectRatio(int aspectRatio) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(aspectRatio));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetRotation(int rotation) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(rotation));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setTargetResolution(Size resolution) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, resolution);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setDefaultResolution(Size resolution) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, resolution);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setMaxResolution(Size resolution) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, resolution);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> resolutions) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, resolutions);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        public Builder setBackgroundExecutor(Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setSurfaceOccupancyPriority(int priority) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(priority));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        public Builder setCameraSelector(CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        @Override // androidx.camera.core.internal.UseCaseEventConfig.Builder
        public Builder setUseCaseEventCallback(UseCase.EventCallback useCaseEventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, useCaseEventCallback);
            return this;
        }
    }

    public static class OutputFileResults {
        private Uri mSavedUri;

        OutputFileResults(Uri savedUri) {
            this.mSavedUri = savedUri;
        }

        public Uri getSavedUri() {
            return this.mSavedUri;
        }
    }

    public static final class OutputFileOptions {
        private static final Metadata EMPTY_METADATA = new Metadata();
        private final ContentResolver mContentResolver;
        private final ContentValues mContentValues;
        private final File mFile;
        private final FileDescriptor mFileDescriptor;
        private final Metadata mMetadata;
        private final Uri mSaveCollection;

        OutputFileOptions(File file, FileDescriptor fileDescriptor, ContentResolver contentResolver, Uri saveCollection, ContentValues contentValues, Metadata metadata) {
            this.mFile = file;
            this.mFileDescriptor = fileDescriptor;
            this.mContentResolver = contentResolver;
            this.mSaveCollection = saveCollection;
            this.mContentValues = contentValues;
            this.mMetadata = metadata == null ? EMPTY_METADATA : metadata;
        }

        File getFile() {
            return this.mFile;
        }

        FileDescriptor getFileDescriptor() {
            return this.mFileDescriptor;
        }

        ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        ContentValues getContentValues() {
            return this.mContentValues;
        }

        Metadata getMetadata() {
            return this.mMetadata;
        }

        boolean isSavingToMediaStore() {
            return (getSaveCollection() == null || getContentResolver() == null || getContentValues() == null) ? false : true;
        }

        boolean isSavingToFile() {
            return getFile() != null;
        }

        boolean isSavingToFileDescriptor() {
            return getFileDescriptor() != null;
        }

        public static final class Builder {
            private ContentResolver mContentResolver;
            private ContentValues mContentValues;
            private File mFile;
            private FileDescriptor mFileDescriptor;
            private Metadata mMetadata;
            private Uri mSaveCollection;

            public Builder(File file) {
                this.mFile = file;
            }

            public Builder(FileDescriptor fileDescriptor) {
                Preconditions.checkArgument(true, "Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
                this.mFileDescriptor = fileDescriptor;
            }

            public Builder(ContentResolver contentResolver, Uri saveCollection, ContentValues contentValues) {
                this.mContentResolver = contentResolver;
                this.mSaveCollection = saveCollection;
                this.mContentValues = contentValues;
            }

            public Builder setMetadata(Metadata metadata) {
                this.mMetadata = metadata;
                return this;
            }

            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mFileDescriptor, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mMetadata);
            }
        }
    }
}
