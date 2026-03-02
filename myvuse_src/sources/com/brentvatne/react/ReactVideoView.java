package com.brentvatne.react;

import android.app.Activity;
import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.media.TimedMetaData;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.yqritc.scalablevideoview.ScalableType;
import com.yqritc.scalablevideoview.ScalableVideoView;
import com.yqritc.scalablevideoview.ScaleManager;
import com.yqritc.scalablevideoview.Size;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes3.dex */
public class ReactVideoView extends ScalableVideoView implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, LifecycleEventListener, MediaController.MediaPlayerControl {
    public static final String EVENT_PROP_CURRENT_TIME = "currentTime";
    public static final String EVENT_PROP_DURATION = "duration";
    public static final String EVENT_PROP_ERROR = "error";
    public static final String EVENT_PROP_EXTRA = "extra";
    public static final String EVENT_PROP_FAST_FORWARD = "canPlayFastForward";
    public static final String EVENT_PROP_HEIGHT = "height";
    public static final String EVENT_PROP_METADATA = "metadata";
    public static final String EVENT_PROP_METADATA_IDENTIFIER = "identifier";
    public static final String EVENT_PROP_METADATA_VALUE = "value";
    public static final String EVENT_PROP_NATURALSIZE = "naturalSize";
    public static final String EVENT_PROP_ORIENTATION = "orientation";
    public static final String EVENT_PROP_PLAYABLE_DURATION = "playableDuration";
    public static final String EVENT_PROP_REVERSE = "canPlayReverse";
    public static final String EVENT_PROP_SEEKABLE_DURATION = "seekableDuration";
    public static final String EVENT_PROP_SEEK_TIME = "seekTime";
    public static final String EVENT_PROP_SLOW_FORWARD = "canPlaySlowForward";
    public static final String EVENT_PROP_SLOW_REVERSE = "canPlaySlowReverse";
    public static final String EVENT_PROP_STEP_BACKWARD = "canStepBackward";
    public static final String EVENT_PROP_STEP_FORWARD = "canStepForward";
    public static final String EVENT_PROP_TARGET = "target";
    public static final String EVENT_PROP_WHAT = "what";
    public static final String EVENT_PROP_WIDTH = "width";
    private boolean isCompleted;
    private float mActiveRate;
    private boolean mBackgroundPaused;
    private RCTEventEmitter mEventEmitter;
    private boolean mIsFullscreen;
    private int mMainVer;
    private boolean mMediaPlayerValid;
    private boolean mMuted;
    private int mPatchVer;
    private boolean mPaused;
    private boolean mPlayInBackground;
    private boolean mPreventsDisplaySleepDuringVideoPlayback;
    private Handler mProgressUpdateHandler;
    private float mProgressUpdateInterval;
    private Runnable mProgressUpdateRunnable;
    private float mRate;
    private boolean mRepeat;
    private ReadableMap mRequestHeaders;
    private ScalableType mResizeMode;
    private long mSeekTime;
    private boolean mSrcIsAsset;
    private boolean mSrcIsNetwork;
    private String mSrcType;
    private String mSrcUriString;
    private float mStereoPan;
    private ThemedReactContext mThemedReactContext;
    private boolean mUseNativeControls;
    private int mVideoBufferedDuration;
    private int mVideoDuration;
    private float mVolume;
    private MediaController mediaController;
    private Handler videoControlHandler;

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    public enum Events {
        EVENT_LOAD_START("onVideoLoadStart"),
        EVENT_LOAD("onVideoLoad"),
        EVENT_ERROR("onVideoError"),
        EVENT_PROGRESS("onVideoProgress"),
        EVENT_TIMED_METADATA("onTimedMetadata"),
        EVENT_SEEK("onVideoSeek"),
        EVENT_END("onVideoEnd"),
        EVENT_STALLED("onPlaybackStalled"),
        EVENT_RESUME("onPlaybackResume"),
        EVENT_READY_FOR_DISPLAY("onReadyForDisplay"),
        EVENT_FULLSCREEN_WILL_PRESENT("onVideoFullscreenPlayerWillPresent"),
        EVENT_FULLSCREEN_DID_PRESENT("onVideoFullscreenPlayerDidPresent"),
        EVENT_FULLSCREEN_WILL_DISMISS("onVideoFullscreenPlayerWillDismiss"),
        EVENT_FULLSCREEN_DID_DISMISS("onVideoFullscreenPlayerDidDismiss");

        private final String mName;

        Events(String str) {
            this.mName = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mName;
        }
    }

    public ReactVideoView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.mProgressUpdateHandler = new Handler();
        this.mProgressUpdateRunnable = null;
        this.videoControlHandler = new Handler();
        this.mSrcUriString = null;
        this.mSrcType = "mp4";
        this.mRequestHeaders = null;
        this.mSrcIsNetwork = false;
        this.mSrcIsAsset = false;
        this.mResizeMode = ScalableType.LEFT_TOP;
        this.mRepeat = false;
        this.mPaused = false;
        this.mMuted = false;
        this.mPreventsDisplaySleepDuringVideoPlayback = true;
        this.mVolume = 1.0f;
        this.mStereoPan = 0.0f;
        this.mProgressUpdateInterval = 250.0f;
        this.mRate = 1.0f;
        this.mActiveRate = 1.0f;
        this.mSeekTime = 0L;
        this.mPlayInBackground = false;
        this.mBackgroundPaused = false;
        this.mIsFullscreen = false;
        this.mMainVer = 0;
        this.mPatchVer = 0;
        this.mMediaPlayerValid = false;
        this.mVideoDuration = 0;
        this.mVideoBufferedDuration = 0;
        this.isCompleted = false;
        this.mUseNativeControls = false;
        this.mThemedReactContext = themedReactContext;
        this.mEventEmitter = (RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class);
        themedReactContext.addLifecycleEventListener(this);
        initializeMediaPlayerIfNeeded();
        setSurfaceTextureListener(this);
        this.mProgressUpdateRunnable = new Runnable() { // from class: com.brentvatne.react.ReactVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!ReactVideoView.this.mMediaPlayerValid || ReactVideoView.this.isCompleted || ReactVideoView.this.mPaused || ReactVideoView.this.mBackgroundPaused) {
                    return;
                }
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putDouble(ReactVideoView.EVENT_PROP_CURRENT_TIME, ((double) ReactVideoView.this.mMediaPlayer.getCurrentPosition()) / 1000.0d);
                writableMapCreateMap.putDouble(ReactVideoView.EVENT_PROP_PLAYABLE_DURATION, ((double) ReactVideoView.this.mVideoBufferedDuration) / 1000.0d);
                writableMapCreateMap.putDouble(ReactVideoView.EVENT_PROP_SEEKABLE_DURATION, ((double) ReactVideoView.this.mVideoDuration) / 1000.0d);
                ReactVideoView.this.mEventEmitter.receiveEvent(ReactVideoView.this.getId(), Events.EVENT_PROGRESS.toString(), writableMapCreateMap);
                ReactVideoView.this.mProgressUpdateHandler.postDelayed(ReactVideoView.this.mProgressUpdateRunnable, Math.round(ReactVideoView.this.mProgressUpdateInterval));
            }
        };
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mUseNativeControls) {
            initializeMediaControllerIfNeeded();
            this.mediaController.show();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Matrix scaleMatrix;
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.mMediaPlayerValid) {
            int videoWidth = getVideoWidth();
            int videoHeight = getVideoHeight();
            if (videoWidth == 0 || videoHeight == 0 || (scaleMatrix = new ScaleManager(new Size(getWidth(), getHeight()), new Size(videoWidth, videoHeight)).getScaleMatrix(this.mScalableType)) == null) {
                return;
            }
            setTransform(scaleMatrix);
        }
    }

    private void initializeMediaPlayerIfNeeded() {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayerValid = false;
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setOnVideoSizeChangedListener(this);
            this.mMediaPlayer.setOnErrorListener(this);
            this.mMediaPlayer.setOnPreparedListener(this);
            this.mMediaPlayer.setOnBufferingUpdateListener(this);
            this.mMediaPlayer.setOnSeekCompleteListener(this);
            this.mMediaPlayer.setOnCompletionListener(this);
            this.mMediaPlayer.setOnInfoListener(this);
            this.mMediaPlayer.setOnTimedMetaDataAvailableListener(new TimedMetaDataAvailableListener());
        }
    }

    private void initializeMediaControllerIfNeeded() {
        if (this.mediaController == null) {
            this.mediaController = new MediaController(getContext());
        }
    }

    public void cleanupMediaPlayerResources() {
        MediaController mediaController = this.mediaController;
        if (mediaController != null) {
            mediaController.hide();
        }
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnTimedMetaDataAvailableListener(null);
            this.mMediaPlayerValid = false;
            release();
        }
        if (this.mIsFullscreen) {
            setFullscreen(false);
        }
        ThemedReactContext themedReactContext = this.mThemedReactContext;
        if (themedReactContext != null) {
            themedReactContext.removeLifecycleEventListener(this);
            this.mThemedReactContext = null;
        }
    }

    public void setSrc(String str, String str2, boolean z, boolean z2, ReadableMap readableMap) {
        setSrc(str, str2, z, z2, readableMap, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7 A[Catch: Exception -> 0x0057, TryCatch #1 {Exception -> 0x0057, blocks: (B:4:0x0021, B:6:0x0040, B:7:0x0045, B:9:0x0049, B:10:0x0050, B:14:0x005c, B:16:0x0064, B:17:0x006f, B:18:0x0073, B:20:0x0077, B:28:0x00a7, B:30:0x00bb, B:31:0x00cd, B:32:0x00d1, B:23:0x009c, B:25:0x00a1), top: B:46:0x001f, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d1 A[Catch: Exception -> 0x0057, TRY_LEAVE, TryCatch #1 {Exception -> 0x0057, blocks: (B:4:0x0021, B:6:0x0040, B:7:0x0045, B:9:0x0049, B:10:0x0050, B:14:0x005c, B:16:0x0064, B:17:0x006f, B:18:0x0073, B:20:0x0077, B:28:0x00a7, B:30:0x00bb, B:31:0x00cd, B:32:0x00d1, B:23:0x009c, B:25:0x00a1), top: B:46:0x001f, inners: #4 }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSrc(java.lang.String r7, java.lang.String r8, boolean r9, boolean r10, com.facebook.react.bridge.ReadableMap r11, int r12, int r13) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.react.ReactVideoView.setSrc(java.lang.String, java.lang.String, boolean, boolean, com.facebook.react.bridge.ReadableMap, int, int):void");
    }

    public void setResizeModeModifier(ScalableType scalableType) {
        this.mResizeMode = scalableType;
        if (this.mMediaPlayerValid) {
            setScalableType(scalableType);
            invalidate();
        }
    }

    public void setRepeatModifier(boolean z) {
        this.mRepeat = z;
        if (this.mMediaPlayerValid) {
            setLooping(z);
        }
    }

    public void setPausedModifier(boolean z) {
        this.mPaused = z;
        if (this.mMediaPlayerValid) {
            if (z) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                }
            } else {
                if (this.mMediaPlayer.isPlaying()) {
                    return;
                }
                start();
                float f = this.mRate;
                if (f != this.mActiveRate) {
                    setRateModifier(f);
                }
                this.mProgressUpdateHandler.post(this.mProgressUpdateRunnable);
            }
        }
    }

    private float calulateRelativeVolume() {
        return new BigDecimal(this.mVolume * (1.0f - Math.abs(this.mStereoPan))).setScale(1, 4).floatValue();
    }

    public void setPreventsDisplaySleepDuringVideoPlaybackModifier(boolean z) {
        this.mPreventsDisplaySleepDuringVideoPlayback = z;
        if (this.mMediaPlayerValid) {
            this.mMediaPlayer.setScreenOnWhilePlaying(this.mPreventsDisplaySleepDuringVideoPlayback);
        }
    }

    public void setMutedModifier(boolean z) {
        this.mMuted = z;
        if (this.mMediaPlayerValid) {
            if (z) {
                setVolume(0.0f, 0.0f);
                return;
            }
            float f = this.mStereoPan;
            if (f < 0.0f) {
                setVolume(this.mVolume, calulateRelativeVolume());
            } else if (f > 0.0f) {
                setVolume(calulateRelativeVolume(), this.mVolume);
            } else {
                float f2 = this.mVolume;
                setVolume(f2, f2);
            }
        }
    }

    public void setVolumeModifier(float f) {
        this.mVolume = f;
        setMutedModifier(this.mMuted);
    }

    public void setStereoPan(float f) {
        this.mStereoPan = f;
        setMutedModifier(this.mMuted);
    }

    public void setProgressUpdateInterval(float f) {
        this.mProgressUpdateInterval = f;
    }

    public void setRateModifier(float f) {
        this.mRate = f;
        if (!this.mMediaPlayerValid || this.mPaused) {
            return;
        }
        try {
            this.mMediaPlayer.setPlaybackParams(this.mMediaPlayer.getPlaybackParams().setSpeed(f));
            this.mActiveRate = f;
        } catch (Exception unused) {
            LogInstrumentation.m2728e(ReactVideoViewManager.REACT_CLASS, "Unable to set rate, unsupported on this device");
        }
    }

    public void setFullscreen(boolean z) {
        if (z == this.mIsFullscreen) {
            return;
        }
        this.mIsFullscreen = z;
        Activity currentActivity = this.mThemedReactContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        if (this.mIsFullscreen) {
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_FULLSCREEN_WILL_PRESENT.toString(), null);
            decorView.setSystemUiVisibility(DfuBaseService.ERROR_SERVICE_NOT_FOUND);
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_FULLSCREEN_DID_PRESENT.toString(), null);
        } else {
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_FULLSCREEN_WILL_DISMISS.toString(), null);
            decorView.setSystemUiVisibility(0);
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_FULLSCREEN_DID_DISMISS.toString(), null);
        }
    }

    public void applyModifiers() {
        setResizeModeModifier(this.mResizeMode);
        setRepeatModifier(this.mRepeat);
        setPausedModifier(this.mPaused);
        setMutedModifier(this.mMuted);
        setPreventsDisplaySleepDuringVideoPlaybackModifier(this.mPreventsDisplaySleepDuringVideoPlayback);
        setProgressUpdateInterval(this.mProgressUpdateInterval);
        setRateModifier(this.mRate);
    }

    public void setPlayInBackground(boolean z) {
        this.mPlayInBackground = z;
    }

    public void setControls(boolean z) {
        this.mUseNativeControls = z;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mMediaPlayerValid = true;
        this.mVideoDuration = mediaPlayer.getDuration();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("width", mediaPlayer.getVideoWidth());
        writableMapCreateMap.putInt("height", mediaPlayer.getVideoHeight());
        if (mediaPlayer.getVideoWidth() > mediaPlayer.getVideoHeight()) {
            writableMapCreateMap.putString(EVENT_PROP_ORIENTATION, "landscape");
        } else {
            writableMapCreateMap.putString(EVENT_PROP_ORIENTATION, "portrait");
        }
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("duration", ((double) this.mVideoDuration) / 1000.0d);
        writableMapCreateMap2.putDouble(EVENT_PROP_CURRENT_TIME, ((double) mediaPlayer.getCurrentPosition()) / 1000.0d);
        writableMapCreateMap2.putMap(EVENT_PROP_NATURALSIZE, writableMapCreateMap);
        writableMapCreateMap2.putBoolean(EVENT_PROP_FAST_FORWARD, true);
        writableMapCreateMap2.putBoolean(EVENT_PROP_SLOW_FORWARD, true);
        writableMapCreateMap2.putBoolean(EVENT_PROP_SLOW_REVERSE, true);
        writableMapCreateMap2.putBoolean(EVENT_PROP_REVERSE, true);
        writableMapCreateMap2.putBoolean(EVENT_PROP_FAST_FORWARD, true);
        writableMapCreateMap2.putBoolean(EVENT_PROP_STEP_BACKWARD, true);
        writableMapCreateMap2.putBoolean(EVENT_PROP_STEP_FORWARD, true);
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_LOAD.toString(), writableMapCreateMap2);
        applyModifiers();
        if (this.mUseNativeControls) {
            initializeMediaControllerIfNeeded();
            this.mediaController.setMediaPlayer(this);
            this.mediaController.setAnchorView(this);
            this.videoControlHandler.post(new Runnable() { // from class: com.brentvatne.react.ReactVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    ReactVideoView.this.mediaController.setEnabled(true);
                    ReactVideoView.this.mediaController.show();
                }
            });
        }
        selectTimedMetadataTrack(mediaPlayer);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(EVENT_PROP_WHAT, i);
        writableMapCreateMap.putInt(EVENT_PROP_EXTRA, i2);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap("error", writableMapCreateMap);
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_ERROR.toString(), writableMapCreateMap2);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 3) {
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_READY_FOR_DISPLAY.toString(), Arguments.createMap());
            return false;
        }
        if (i == 701) {
            this.mEventEmitter.receiveEvent(getId(), Events.EVENT_STALLED.toString(), Arguments.createMap());
            return false;
        }
        if (i != 702) {
            return false;
        }
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_RESUME.toString(), Arguments.createMap());
        return false;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        selectTimedMetadataTrack(mediaPlayer);
        this.mVideoBufferedDuration = (int) Math.round(((double) (this.mVideoDuration * i)) / 100.0d);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(EVENT_PROP_CURRENT_TIME, ((double) getCurrentPosition()) / 1000.0d);
        writableMapCreateMap.putDouble(EVENT_PROP_SEEK_TIME, this.mSeekTime / 1000.0d);
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_SEEK.toString(), writableMapCreateMap);
        this.mSeekTime = 0L;
    }

    @Override // com.yqritc.scalablevideoview.ScalableVideoView, android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        int i2;
        if (this.mMediaPlayerValid) {
            this.mSeekTime = i;
            super.seekTo(i);
            if (!this.isCompleted || (i2 = this.mVideoDuration) == 0 || i >= i2) {
                return;
            }
            this.isCompleted = false;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.isCompleted = true;
        this.mEventEmitter.receiveEvent(getId(), Events.EVENT_END.toString(), null);
    }

    public class TimedMetaDataAvailableListener implements MediaPlayer.OnTimedMetaDataAvailableListener {
        public TimedMetaDataAvailableListener() {
        }

        @Override // android.media.MediaPlayer.OnTimedMetaDataAvailableListener
        public void onTimedMetaDataAvailable(MediaPlayer mediaPlayer, TimedMetaData timedMetaData) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            try {
                String str = new String(timedMetaData.getMetaData(), "UTF-8");
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putString("value", str.substring(str.lastIndexOf("\u0003") + 1));
                writableMapCreateMap2.putString(ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER, "id3/TDEN");
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                writableNativeArray.pushMap(writableMapCreateMap2);
                writableMapCreateMap.putArray(ReactVideoView.EVENT_PROP_METADATA, writableNativeArray);
                writableMapCreateMap.putDouble("target", ReactVideoView.this.getId());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            ReactVideoView.this.mEventEmitter.receiveEvent(ReactVideoView.this.getId(), Events.EVENT_TIMED_METADATA.toString(), writableMapCreateMap);
        }
    }

    @Override // com.yqritc.scalablevideoview.ScalableVideoView, android.view.View
    protected void onDetachedFromWindow() {
        this.mMediaPlayerValid = false;
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.mMainVer;
        if (i > 0) {
            setSrc(this.mSrcUriString, this.mSrcType, this.mSrcIsNetwork, this.mSrcIsAsset, this.mRequestHeaders, i, this.mPatchVer);
        } else {
            setSrc(this.mSrcUriString, this.mSrcType, this.mSrcIsNetwork, this.mSrcIsAsset, this.mRequestHeaders);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        if (!this.mMediaPlayerValid || this.mPaused || this.mPlayInBackground) {
            return;
        }
        this.mBackgroundPaused = true;
        this.mMediaPlayer.pause();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.mBackgroundPaused = false;
        if (!this.mMediaPlayerValid || this.mPlayInBackground || this.mPaused) {
            return;
        }
        new Handler().post(new Runnable() { // from class: com.brentvatne.react.ReactVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                ReactVideoView.this.setPausedModifier(false);
            }
        });
    }

    public static Map<String, String> toStringMap(@Nullable ReadableMap readableMap) {
        HashMap map = new HashMap();
        if (readableMap == null) {
            return map;
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            map.put(strNextKey, readableMap.getString(strNextKey));
        }
        return map;
    }

    private void selectTimedMetadataTrack(MediaPlayer mediaPlayer) {
        try {
            MediaPlayer.TrackInfo[] trackInfo = mediaPlayer.getTrackInfo();
            for (int i = 0; i < trackInfo.length; i++) {
                if (trackInfo[i].getTrackType() == 3) {
                    mediaPlayer.selectTrack(i);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }
}
