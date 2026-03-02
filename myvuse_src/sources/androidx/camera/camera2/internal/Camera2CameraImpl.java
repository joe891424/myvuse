package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
final class Camera2CameraImpl implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera2CameraImpl";
    private final CameraAvailability mCameraAvailability;
    private final Camera2CameraControlImpl mCameraControlInternal;
    SessionConfig mCameraControlSessionConfig;
    CameraDevice mCameraDevice;
    int mCameraDeviceError;
    final Camera2CameraInfoImpl mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    private final CameraStateRegistry mCameraStateRegistry;
    CaptureSession mCaptureSession;
    private final SynchronizedCaptureSessionOpener.Builder mCaptureSessionOpenerBuilder;
    private final CaptureSessionRepository mCaptureSessionRepository;
    final Set<CaptureSession> mConfiguringForClose;
    private final Executor mExecutor;
    private MeteringRepeatingSession mMeteringRepeatingSession;
    private final Set<String> mNotifyStateAttachedSet;
    private final LiveDataObservable<CameraInternal.State> mObservableState;
    final AtomicInteger mReleaseRequestCount;
    final Map<CaptureSession, ListenableFuture<Void>> mReleasedCaptureSessions;
    volatile InternalState mState = InternalState.INITIALIZED;
    private final StateCallback mStateCallback;
    private final UseCaseAttachState mUseCaseAttachState;
    ListenableFuture<Void> mUserReleaseFuture;
    CallbackToFutureAdapter.Completer<Void> mUserReleaseNotifier;

    enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CLOSING,
        REOPENING,
        RELEASING,
        RELEASED
    }

    Camera2CameraImpl(CameraManagerCompat cameraManager, String cameraId, Camera2CameraInfoImpl cameraInfoImpl, CameraStateRegistry cameraStateRegistry, Executor executor, Handler schedulerHandler) throws CameraUnavailableException {
        LiveDataObservable<CameraInternal.State> liveDataObservable = new LiveDataObservable<>();
        this.mObservableState = liveDataObservable;
        this.mCameraDeviceError = 0;
        this.mCameraControlSessionConfig = SessionConfig.defaultEmptySessionConfig();
        this.mReleaseRequestCount = new AtomicInteger(0);
        this.mReleasedCaptureSessions = new LinkedHashMap();
        this.mConfiguringForClose = new HashSet();
        this.mNotifyStateAttachedSet = new HashSet();
        this.mCameraManager = cameraManager;
        this.mCameraStateRegistry = cameraStateRegistry;
        ScheduledExecutorService scheduledExecutorServiceNewHandlerExecutor = CameraXExecutors.newHandlerExecutor(schedulerHandler);
        Executor executorNewSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = executorNewSequentialExecutor;
        this.mStateCallback = new StateCallback(executorNewSequentialExecutor, scheduledExecutorServiceNewHandlerExecutor);
        this.mUseCaseAttachState = new UseCaseAttachState(cameraId);
        liveDataObservable.postValue(CameraInternal.State.CLOSED);
        CaptureSessionRepository captureSessionRepository = new CaptureSessionRepository(executorNewSequentialExecutor);
        this.mCaptureSessionRepository = captureSessionRepository;
        this.mCaptureSession = new CaptureSession();
        try {
            Camera2CameraControlImpl camera2CameraControlImpl = new Camera2CameraControlImpl(cameraManager.getCameraCharacteristicsCompat(cameraId), scheduledExecutorServiceNewHandlerExecutor, executorNewSequentialExecutor, new ControlUpdateListenerInternal(), cameraInfoImpl.getCameraQuirks());
            this.mCameraControlInternal = camera2CameraControlImpl;
            this.mCameraInfoInternal = cameraInfoImpl;
            cameraInfoImpl.linkWithCameraControl(camera2CameraControlImpl);
            this.mCaptureSessionOpenerBuilder = new SynchronizedCaptureSessionOpener.Builder(executorNewSequentialExecutor, scheduledExecutorServiceNewHandlerExecutor, schedulerHandler, captureSessionRepository, cameraInfoImpl.getSupportedHardwareLevel());
            CameraAvailability cameraAvailability = new CameraAvailability(cameraId);
            this.mCameraAvailability = cameraAvailability;
            cameraStateRegistry.registerCamera(this, executorNewSequentialExecutor, cameraAvailability);
            cameraManager.registerAvailabilityCallback(executorNewSequentialExecutor, cameraAvailability);
        } catch (CameraAccessExceptionCompat e) {
            throw CameraUnavailableExceptionHelper.createFrom(e);
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.openInternal();
            }
        });
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.Camera2CameraImpl$3 */
    static /* synthetic */ class C03903 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState */
        static final /* synthetic */ int[] f1705x193044d6;

        static {
            int[] iArr = new int[InternalState.values().length];
            f1705x193044d6 = iArr;
            try {
                iArr[InternalState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1705x193044d6[InternalState.CLOSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1705x193044d6[InternalState.OPENED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1705x193044d6[InternalState.OPENING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1705x193044d6[InternalState.REOPENING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1705x193044d6[InternalState.PENDING_OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1705x193044d6[InternalState.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1705x193044d6[InternalState.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openInternal() {
        int i = C03903.f1705x193044d6[this.mState.ordinal()];
        if (i == 1) {
            openCameraDevice();
            return;
        }
        if (i == 2) {
            setState(InternalState.REOPENING);
            if (isSessionCloseComplete() || this.mCameraDeviceError != 0) {
                return;
            }
            Preconditions.checkState(this.mCameraDevice != null, "Camera Device should be open if session close is not complete");
            setState(InternalState.OPENED);
            openCaptureSession();
            return;
        }
        debugLog("open() ignored due to being in state: " + this.mState);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.closeInternal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInternal() {
        debugLog("Closing camera.");
        int i = C03903.f1705x193044d6[this.mState.ordinal()];
        if (i == 3) {
            setState(InternalState.CLOSING);
            closeCamera(false);
            return;
        }
        if (i != 4 && i != 5) {
            if (i == 6) {
                Preconditions.checkState(this.mCameraDevice == null);
                setState(InternalState.INITIALIZED);
                return;
            } else {
                debugLog("close() ignored due to being in state: " + this.mState);
                return;
            }
        }
        boolean zCancelScheduledReopen = this.mStateCallback.cancelScheduledReopen();
        setState(InternalState.CLOSING);
        if (zCancelScheduledReopen) {
            Preconditions.checkState(isSessionCloseComplete());
            finishClose();
        }
    }

    private void configAndClose(boolean abortInFlightCaptures) {
        final CaptureSession captureSession = new CaptureSession();
        this.mConfiguringForClose.add(captureSession);
        resetCaptureSession(abortInFlightCaptures);
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        final Surface surface = new Surface(surfaceTexture);
        final Runnable runnable = new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.lambda$configAndClose$0(surface, surfaceTexture);
            }
        };
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.addNonRepeatingSurface(new ImmediateSurface(surface));
        builder.setTemplateType(1);
        debugLog("Start configAndClose.");
        captureSession.open(builder.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()).addListener(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1082x2a0cb35d(captureSession, runnable);
            }
        }, this.mExecutor);
    }

    static /* synthetic */ void lambda$configAndClose$0(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: releaseNoOpSession, reason: merged with bridge method [inline-methods] */
    public void m1082x2a0cb35d(CaptureSession noOpSession, Runnable closeAndCleanupRunner) {
        this.mConfiguringForClose.remove(noOpSession);
        releaseSession(noOpSession, false).addListener(closeAndCleanupRunner, CameraXExecutors.directExecutor());
    }

    boolean isSessionCloseComplete() {
        return this.mReleasedCaptureSessions.isEmpty() && this.mConfiguringForClose.isEmpty();
    }

    void finishClose() {
        Preconditions.checkState(this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState == InternalState.CLOSING) {
            setState(InternalState.INITIALIZED);
            return;
        }
        this.mCameraManager.unregisterAvailabilityCallback(this.mCameraAvailability);
        setState(InternalState.RELEASED);
        CallbackToFutureAdapter.Completer<Void> completer = this.mUserReleaseNotifier;
        if (completer != null) {
            completer.set(null);
            this.mUserReleaseNotifier = null;
        }
    }

    void closeCamera(boolean abortInFlightCaptures) {
        Preconditions.checkState(this.mState == InternalState.CLOSING || this.mState == InternalState.RELEASING || (this.mState == InternalState.REOPENING && this.mCameraDeviceError != 0), "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.mState + " (error: " + getErrorMessage(this.mCameraDeviceError) + ")");
        if (Build.VERSION.SDK_INT < 29 && isLegacyDevice() && this.mCameraDeviceError == 0) {
            configAndClose(abortInFlightCaptures);
        } else {
            resetCaptureSession(abortInFlightCaptures);
        }
        this.mCaptureSession.cancelIssuedCaptureRequests();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda15
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.m1092xc715f071(completer);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$release$3$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ Object m1092xc715f071(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1091x993d5612(completer);
            }
        });
        return "Release[request=" + this.mReleaseRequestCount.getAndIncrement() + "]";
    }

    /* JADX INFO: renamed from: lambda$release$2$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ void m1091x993d5612(CallbackToFutureAdapter.Completer completer) {
        Futures.propagate(releaseInternal(), completer);
    }

    private ListenableFuture<Void> releaseInternal() {
        ListenableFuture<Void> orCreateUserReleaseFuture = getOrCreateUserReleaseFuture();
        switch (C03903.f1705x193044d6[this.mState.ordinal()]) {
            case 1:
            case 6:
                Preconditions.checkState(this.mCameraDevice == null);
                setState(InternalState.RELEASING);
                Preconditions.checkState(isSessionCloseComplete());
                finishClose();
                return orCreateUserReleaseFuture;
            case 2:
            case 4:
            case 5:
            case 7:
                boolean zCancelScheduledReopen = this.mStateCallback.cancelScheduledReopen();
                setState(InternalState.RELEASING);
                if (zCancelScheduledReopen) {
                    Preconditions.checkState(isSessionCloseComplete());
                    finishClose();
                }
                return orCreateUserReleaseFuture;
            case 3:
                setState(InternalState.RELEASING);
                closeCamera(false);
                return orCreateUserReleaseFuture;
            default:
                debugLog("release() ignored due to being in state: " + this.mState);
                return orCreateUserReleaseFuture;
        }
    }

    private ListenableFuture<Void> getOrCreateUserReleaseFuture() {
        if (this.mUserReleaseFuture == null) {
            if (this.mState != InternalState.RELEASED) {
                this.mUserReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda4
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return this.f$0.m1084x42886673(completer);
                    }
                });
            } else {
                this.mUserReleaseFuture = Futures.immediateFuture(null);
            }
        }
        return this.mUserReleaseFuture;
    }

    /* JADX INFO: renamed from: lambda$getOrCreateUserReleaseFuture$4$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ Object m1084x42886673(CallbackToFutureAdapter.Completer completer) throws Exception {
        Preconditions.checkState(this.mUserReleaseNotifier == null, "Camera can only be released once, so release completer should be null on creation.");
        this.mUserReleaseNotifier = completer;
        return "Release[camera=" + this + "]";
    }

    ListenableFuture<Void> releaseSession(final CaptureSession captureSession, boolean abortInFlightCaptures) {
        captureSession.close();
        ListenableFuture<Void> listenableFutureRelease = captureSession.release(abortInFlightCaptures);
        debugLog("Releasing session in state " + this.mState.name());
        this.mReleasedCaptureSessions.put(captureSession, listenableFutureRelease);
        Futures.addCallback(listenableFutureRelease, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable t) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void result) {
                Camera2CameraImpl.this.mReleasedCaptureSessions.remove(captureSession);
                int i = C03903.f1705x193044d6[Camera2CameraImpl.this.mState.ordinal()];
                if (i != 2) {
                    if (i != 5) {
                        if (i != 7) {
                            return;
                        }
                    } else if (Camera2CameraImpl.this.mCameraDeviceError == 0) {
                        return;
                    }
                }
                if (!Camera2CameraImpl.this.isSessionCloseComplete() || Camera2CameraImpl.this.mCameraDevice == null) {
                    return;
                }
                Camera2CameraImpl.this.mCameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            }
        }, CameraXExecutors.directExecutor());
        return listenableFutureRelease;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public Observable<CameraInternal.State> getCameraState() {
        return this.mObservableState;
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseActive(final UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1087xeff284f8(useCase);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onUseCaseActive$5$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ void m1087xeff284f8(UseCase useCase) {
        debugLog("Use case " + useCase + " ACTIVE");
        try {
            this.mUseCaseAttachState.setUseCaseActive(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
            this.mUseCaseAttachState.updateUseCase(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
            updateCaptureSessionConfig();
        } catch (NullPointerException unused) {
            debugLog("Failed to set already detached use case active");
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseInactive(final UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1088x8da1a1d2(useCase);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onUseCaseInactive$6$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ void m1088x8da1a1d2(UseCase useCase) {
        debugLog("Use case " + useCase + " INACTIVE");
        this.mUseCaseAttachState.setUseCaseInactive(useCase.getName() + useCase.hashCode());
        updateCaptureSessionConfig();
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseUpdated(final UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1090xe8973177(useCase);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onUseCaseUpdated$7$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ void m1090xe8973177(UseCase useCase) {
        debugLog("Use case " + useCase + " UPDATED");
        this.mUseCaseAttachState.updateUseCase(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
        updateCaptureSessionConfig();
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseReset(final UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1089x7c3de682(useCase);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onUseCaseReset$8$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ void m1089x7c3de682(UseCase useCase) {
        debugLog("Use case " + useCase + " RESET");
        this.mUseCaseAttachState.updateUseCase(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
        resetCaptureSession(false);
        updateCaptureSessionConfig();
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean isUseCaseAttached(final UseCase useCase) {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda3
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f$0.m1085x9bdb441b(useCase, completer);
                }
            }).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unable to check if use case is attached.", e);
        }
    }

    /* JADX INFO: renamed from: lambda$isUseCaseAttached$10$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ Object m1085x9bdb441b(final UseCase useCase, final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1086x93ceab21(completer, useCase);
                }
            });
            return "isUseCaseAttached";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if use case is attached. Camera executor shut down."));
            return "isUseCaseAttached";
        }
    }

    /* JADX INFO: renamed from: lambda$isUseCaseAttached$9$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ void m1086x93ceab21(CallbackToFutureAdapter.Completer completer, UseCase useCase) {
        completer.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseAttached(useCase.getName() + useCase.hashCode())));
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(final Collection<UseCase> useCases) {
        if (useCases.isEmpty()) {
            return;
        }
        this.mCameraControlInternal.incrementUseCount();
        notifyStateAttachedToUseCases(new ArrayList(useCases));
        try {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1081x65960ee4(useCases);
                }
            });
        } catch (RejectedExecutionException e) {
            debugLog("Unable to attach use cases.", e);
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    /* JADX INFO: renamed from: lambda$attachUseCases$11$androidx-camera-camera2-internal-Camera2CameraImpl */
    /* synthetic */ void m1081x65960ee4(Collection collection) {
        try {
            tryAttachUseCases(collection);
        } finally {
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    private void tryAttachUseCases(Collection<UseCase> toAdd) {
        boolean zIsEmpty = this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty();
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : toAdd) {
            if (!this.mUseCaseAttachState.isUseCaseAttached(useCase.getName() + useCase.hashCode())) {
                try {
                    this.mUseCaseAttachState.setUseCaseAttached(useCase.getName() + useCase.hashCode(), useCase.getSessionConfig());
                    arrayList.add(useCase);
                } catch (NullPointerException unused) {
                    debugLog("Failed to attach a detached use case");
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        debugLog("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
        if (zIsEmpty) {
            this.mCameraControlInternal.setActive(true);
            this.mCameraControlInternal.incrementUseCount();
        }
        addOrRemoveMeteringRepeatingUseCase();
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        } else {
            openInternal();
        }
        updateCameraControlPreviewAspectRatio(arrayList);
    }

    private void notifyStateAttachedToUseCases(List<UseCase> useCases) {
        for (UseCase useCase : useCases) {
            if (!this.mNotifyStateAttachedSet.contains(useCase.getName() + useCase.hashCode())) {
                this.mNotifyStateAttachedSet.add(useCase.getName() + useCase.hashCode());
                useCase.onStateAttached();
            }
        }
    }

    private void notifyStateDetachedToUseCases(List<UseCase> useCases) {
        for (UseCase useCase : useCases) {
            if (this.mNotifyStateAttachedSet.contains(useCase.getName() + useCase.hashCode())) {
                useCase.onStateDetached();
                this.mNotifyStateAttachedSet.remove(useCase.getName() + useCase.hashCode());
            }
        }
    }

    private void updateCameraControlPreviewAspectRatio(Collection<UseCase> useCases) {
        for (UseCase useCase : useCases) {
            if (useCase instanceof Preview) {
                Size attachedSurfaceResolution = useCase.getAttachedSurfaceResolution();
                if (attachedSurfaceResolution != null) {
                    this.mCameraControlInternal.setPreviewAspectRatio(new Rational(attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight()));
                    return;
                }
                return;
            }
        }
    }

    private void clearCameraControlPreviewAspectRatio(Collection<UseCase> removedUseCases) {
        Iterator<UseCase> it2 = removedUseCases.iterator();
        while (it2.hasNext()) {
            if (it2.next() instanceof Preview) {
                this.mCameraControlInternal.setPreviewAspectRatio(null);
                return;
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(final Collection<UseCase> useCases) {
        if (useCases.isEmpty()) {
            return;
        }
        notifyStateDetachedToUseCases(new ArrayList(useCases));
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1083x88625e11(useCases);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: tryDetachUseCases, reason: merged with bridge method [inline-methods] */
    public void m1083x88625e11(Collection<UseCase> toRemove) {
        ArrayList arrayList = new ArrayList();
        for (UseCase useCase : toRemove) {
            if (this.mUseCaseAttachState.isUseCaseAttached(useCase.getName() + useCase.hashCode())) {
                this.mUseCaseAttachState.removeUseCase(useCase.getName() + useCase.hashCode());
                arrayList.add(useCase);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        debugLog("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
        clearCameraControlPreviewAspectRatio(arrayList);
        addOrRemoveMeteringRepeatingUseCase();
        if (this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty()) {
            this.mCameraControlInternal.decrementUseCount();
            resetCaptureSession(false);
            this.mCameraControlInternal.setActive(false);
            this.mCaptureSession = new CaptureSession();
            closeInternal();
            return;
        }
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    private void addOrRemoveMeteringRepeatingUseCase() {
        SessionConfig sessionConfigBuild = this.mUseCaseAttachState.getAttachedBuilder().build();
        CaptureConfig repeatingCaptureConfig = sessionConfigBuild.getRepeatingCaptureConfig();
        int size = repeatingCaptureConfig.getSurfaces().size();
        int size2 = sessionConfigBuild.getSurfaces().size();
        if (sessionConfigBuild.getSurfaces().isEmpty()) {
            return;
        }
        if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
            if (this.mMeteringRepeatingSession == null) {
                this.mMeteringRepeatingSession = new MeteringRepeatingSession(this.mCameraInfoInternal.getCameraCharacteristicsCompat());
            }
            addMeteringRepeating();
        } else if (size2 == 1 && size == 1) {
            removeMeteringRepeating();
        } else if (size >= 2) {
            removeMeteringRepeating();
        } else {
            Logger.m1137d(TAG, "mMeteringRepeating is ATTACHED, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
        }
    }

    private void removeMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            this.mUseCaseAttachState.setUseCaseDetached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            this.mUseCaseAttachState.setUseCaseInactive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            this.mMeteringRepeatingSession.clear();
            this.mMeteringRepeatingSession = null;
        }
    }

    private void addMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            this.mUseCaseAttachState.setUseCaseAttached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode(), this.mMeteringRepeatingSession.getSessionConfig());
            this.mUseCaseAttachState.setUseCaseActive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode(), this.mMeteringRepeatingSession.getSessionConfig());
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    void openCameraDevice() {
        this.mStateCallback.cancelScheduledReopen();
        if (!this.mCameraAvailability.isCameraAvailable() || !this.mCameraStateRegistry.tryOpenCamera(this)) {
            debugLog("No cameras available. Waiting for available camera before opening camera.");
            setState(InternalState.PENDING_OPEN);
            return;
        }
        setState(InternalState.OPENING);
        debugLog("Opening camera.");
        try {
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, createDeviceStateCallback());
        } catch (CameraAccessExceptionCompat e) {
            debugLog("Unable to open camera due to " + e.getMessage());
            if (e.getReason() != 10001) {
                return;
            }
            setState(InternalState.INITIALIZED);
        } catch (SecurityException e2) {
            debugLog("Unable to open camera due to " + e2.getMessage());
            setState(InternalState.REOPENING);
            this.mStateCallback.scheduleCameraReopen();
        }
    }

    void updateCaptureSessionConfig() {
        SessionConfig.ValidatingBuilder activeAndAttachedBuilder = this.mUseCaseAttachState.getActiveAndAttachedBuilder();
        if (activeAndAttachedBuilder.isValid()) {
            activeAndAttachedBuilder.add(this.mCameraControlSessionConfig);
            this.mCaptureSession.setSessionConfig(activeAndAttachedBuilder.build());
            return;
        }
        this.mCaptureSession.setSessionConfig(this.mCameraControlSessionConfig);
    }

    void openCaptureSession() {
        Preconditions.checkState(this.mState == InternalState.OPENED);
        SessionConfig.ValidatingBuilder attachedBuilder = this.mUseCaseAttachState.getAttachedBuilder();
        if (!attachedBuilder.isValid()) {
            debugLog("Unable to create capture session due to conflicting configurations");
        } else {
            Futures.addCallback(this.mCaptureSession.open(attachedBuilder.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void result) {
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable t) {
                    if (t instanceof CameraAccessException) {
                        Camera2CameraImpl.this.debugLog("Unable to configure camera due to " + t.getMessage());
                        return;
                    }
                    if (t instanceof CancellationException) {
                        Camera2CameraImpl.this.debugLog("Unable to configure camera cancelled");
                        return;
                    }
                    if (t instanceof DeferrableSurface.SurfaceClosedException) {
                        SessionConfig sessionConfigFindSessionConfigForSurface = Camera2CameraImpl.this.findSessionConfigForSurface(((DeferrableSurface.SurfaceClosedException) t).getDeferrableSurface());
                        if (sessionConfigFindSessionConfigForSurface != null) {
                            Camera2CameraImpl.this.postSurfaceClosedError(sessionConfigFindSessionConfigForSurface);
                            return;
                        }
                        return;
                    }
                    if (t instanceof TimeoutException) {
                        Logger.m1139e(Camera2CameraImpl.TAG, "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + ", timeout!");
                        return;
                    }
                    throw new RuntimeException(t);
                }
            }, this.mExecutor);
        }
    }

    private boolean isLegacyDevice() {
        return ((Camera2CameraInfoImpl) getCameraInfoInternal()).getSupportedHardwareLevel() == 2;
    }

    SessionConfig findSessionConfigForSurface(DeferrableSurface surface) {
        for (SessionConfig sessionConfig : this.mUseCaseAttachState.getAttachedSessionConfigs()) {
            if (sessionConfig.getSurfaces().contains(surface)) {
                return sessionConfig;
            }
        }
        return null;
    }

    void postSurfaceClosedError(final SessionConfig sessionConfig) {
        ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        List<SessionConfig.ErrorListener> errorListeners = sessionConfig.getErrorListeners();
        if (errorListeners.isEmpty()) {
            return;
        }
        final SessionConfig.ErrorListener errorListener = errorListeners.get(0);
        debugLog("Posting surface closed", new Throwable());
        scheduledExecutorServiceMainThreadExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                errorListener.onError(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        });
    }

    void resetCaptureSession(boolean abortInFlightCaptures) {
        Preconditions.checkState(this.mCaptureSession != null);
        debugLog("Resetting Capture Session");
        CaptureSession captureSession = this.mCaptureSession;
        SessionConfig sessionConfig = captureSession.getSessionConfig();
        List<CaptureConfig> captureConfigs = captureSession.getCaptureConfigs();
        CaptureSession captureSession2 = new CaptureSession();
        this.mCaptureSession = captureSession2;
        captureSession2.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(captureConfigs);
        releaseSession(captureSession, abortInFlightCaptures);
    }

    private CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());
        arrayList.add(this.mStateCallback);
        arrayList.add(this.mCaptureSessionRepository.getCameraStateCallback());
        return CameraDeviceStateCallbacks.createComboCallback(arrayList);
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig.Builder captureConfigBuilder) {
        if (!captureConfigBuilder.getSurfaces().isEmpty()) {
            Logger.m1143w(TAG, "The capture config builder already has surface inside.");
            return false;
        }
        Iterator<SessionConfig> it2 = this.mUseCaseAttachState.getActiveAndAttachedSessionConfigs().iterator();
        while (it2.hasNext()) {
            List<DeferrableSurface> surfaces = it2.next().getRepeatingCaptureConfig().getSurfaces();
            if (!surfaces.isEmpty()) {
                Iterator<DeferrableSurface> it3 = surfaces.iterator();
                while (it3.hasNext()) {
                    captureConfigBuilder.addSurface(it3.next());
                }
            }
        }
        if (!captureConfigBuilder.getSurfaces().isEmpty()) {
            return true;
        }
        Logger.m1143w(TAG, "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    void submitCaptureRequests(List<CaptureConfig> captureConfigs) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig captureConfig : captureConfigs) {
            CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(captureConfig);
            if (!captureConfig.getSurfaces().isEmpty() || !captureConfig.isUseRepeatingSurface() || checkAndAttachRepeatingSurface(builderFrom)) {
                arrayList.add(builderFrom.build());
            }
        }
        debugLog("Issue capture request");
        this.mCaptureSession.issueCaptureRequests(arrayList);
    }

    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.mCameraInfoInternal.getCameraId());
    }

    void debugLog(String msg) {
        debugLog(msg, null);
    }

    private void debugLog(String msg, Throwable throwable) {
        Logger.m1138d(TAG, String.format("{%s} %s", toString(), msg), throwable);
    }

    void setState(InternalState state) {
        CameraInternal.State state2;
        debugLog("Transitioning camera internal state: " + this.mState + " --> " + state);
        this.mState = state;
        switch (C03903.f1705x193044d6[state.ordinal()]) {
            case 1:
                state2 = CameraInternal.State.CLOSED;
                break;
            case 2:
                state2 = CameraInternal.State.CLOSING;
                break;
            case 3:
                state2 = CameraInternal.State.OPEN;
                break;
            case 4:
            case 5:
                state2 = CameraInternal.State.OPENING;
                break;
            case 6:
                state2 = CameraInternal.State.PENDING_OPEN;
                break;
            case 7:
                state2 = CameraInternal.State.RELEASING;
                break;
            case 8:
                state2 = CameraInternal.State.RELEASED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + state);
        }
        this.mCameraStateRegistry.markCameraState(this, state2);
        this.mObservableState.postValue(state2);
    }

    static String getErrorMessage(int errorCode) {
        if (errorCode == 0) {
            return "ERROR_NONE";
        }
        if (errorCode == 1) {
            return "ERROR_CAMERA_IN_USE";
        }
        if (errorCode == 2) {
            return "ERROR_MAX_CAMERAS_IN_USE";
        }
        if (errorCode == 3) {
            return "ERROR_CAMERA_DISABLED";
        }
        if (errorCode == 4) {
            return "ERROR_CAMERA_DEVICE";
        }
        if (errorCode == 5) {
            return "ERROR_CAMERA_SERVICE";
        }
        return "UNKNOWN ERROR";
    }

    final class StateCallback extends CameraDevice.StateCallback {
        private static final int REOPEN_DELAY_MS = 700;
        private final Executor mExecutor;
        ScheduledFuture<?> mScheduledReopenHandle;
        private ScheduledReopen mScheduledReopenRunnable;
        private final ScheduledExecutorService mScheduler;

        StateCallback(Executor executor, ScheduledExecutorService scheduler) {
            this.mExecutor = executor;
            this.mScheduler = scheduler;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onOpened()");
            Camera2CameraImpl.this.mCameraDevice = cameraDevice;
            Camera2CameraImpl.this.updateDefaultRequestBuilderToCameraControl(cameraDevice);
            Camera2CameraImpl.this.mCameraDeviceError = 0;
            int i = C03903.f1705x193044d6[Camera2CameraImpl.this.mState.ordinal()];
            if (i == 2 || i == 7) {
                Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
                Camera2CameraImpl.this.mCameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            } else {
                if (i == 4 || i == 5) {
                    Camera2CameraImpl.this.setState(InternalState.OPENED);
                    Camera2CameraImpl.this.openCaptureSession();
                    return;
                }
                throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.mState);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onClosed()");
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDevice == null, "Unexpected onClose callback on camera device: " + cameraDevice);
            int i = C03903.f1705x193044d6[Camera2CameraImpl.this.mState.ordinal()];
            if (i != 2) {
                if (i == 5) {
                    if (Camera2CameraImpl.this.mCameraDeviceError != 0) {
                        Camera2CameraImpl.this.debugLog("Camera closed due to error: " + Camera2CameraImpl.getErrorMessage(Camera2CameraImpl.this.mCameraDeviceError));
                        scheduleCameraReopen();
                        return;
                    } else {
                        Camera2CameraImpl.this.openCameraDevice();
                        return;
                    }
                }
                if (i != 7) {
                    throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.mState);
                }
            }
            Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
            Camera2CameraImpl.this.finishClose();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int error) {
            Camera2CameraImpl.this.mCameraDevice = cameraDevice;
            Camera2CameraImpl.this.mCameraDeviceError = error;
            int i = C03903.f1705x193044d6[Camera2CameraImpl.this.mState.ordinal()];
            if (i != 2) {
                if (i == 3 || i == 4 || i == 5) {
                    Logger.m1137d(Camera2CameraImpl.TAG, String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(error), Camera2CameraImpl.this.mState.name()));
                    handleErrorOnOpen(cameraDevice, error);
                    return;
                } else if (i != 7) {
                    throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.mState);
                }
            }
            Logger.m1139e(Camera2CameraImpl.TAG, String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(error), Camera2CameraImpl.this.mState.name()));
            Camera2CameraImpl.this.closeCamera(false);
        }

        private void handleErrorOnOpen(CameraDevice cameraDevice, int error) {
            Preconditions.checkState(Camera2CameraImpl.this.mState == InternalState.OPENING || Camera2CameraImpl.this.mState == InternalState.OPENED || Camera2CameraImpl.this.mState == InternalState.REOPENING, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.mState);
            if (error == 1 || error == 2 || error == 4) {
                Logger.m1137d(Camera2CameraImpl.TAG, String.format("Attempt to reopen camera[%s] after error[%s]", cameraDevice.getId(), Camera2CameraImpl.getErrorMessage(error)));
                reopenCameraAfterError();
            } else {
                Logger.m1139e(Camera2CameraImpl.TAG, "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.getErrorMessage(error) + " closing camera.");
                Camera2CameraImpl.this.setState(InternalState.CLOSING);
                Camera2CameraImpl.this.closeCamera(false);
            }
        }

        private void reopenCameraAfterError() {
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDeviceError != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            Camera2CameraImpl.this.setState(InternalState.REOPENING);
            Camera2CameraImpl.this.closeCamera(false);
        }

        void scheduleCameraReopen() {
            Preconditions.checkState(this.mScheduledReopenRunnable == null);
            Preconditions.checkState(this.mScheduledReopenHandle == null);
            this.mScheduledReopenRunnable = new ScheduledReopen(this.mExecutor);
            Camera2CameraImpl.this.debugLog("Attempting camera re-open in 700ms: " + this.mScheduledReopenRunnable);
            this.mScheduledReopenHandle = this.mScheduler.schedule(this.mScheduledReopenRunnable, 700L, TimeUnit.MILLISECONDS);
        }

        boolean cancelScheduledReopen() {
            if (this.mScheduledReopenHandle == null) {
                return false;
            }
            Camera2CameraImpl.this.debugLog("Cancelling scheduled re-open: " + this.mScheduledReopenRunnable);
            this.mScheduledReopenRunnable.cancel();
            this.mScheduledReopenRunnable = null;
            this.mScheduledReopenHandle.cancel(false);
            this.mScheduledReopenHandle = null;
            return true;
        }

        class ScheduledReopen implements Runnable {
            private boolean mCancelled = false;
            private Executor mExecutor;

            ScheduledReopen(Executor executor) {
                this.mExecutor = executor;
            }

            void cancel() {
                this.mCancelled = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl$StateCallback$ScheduledReopen$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m1093x10b58748();
                    }
                });
            }

            /* JADX INFO: renamed from: lambda$run$0$androidx-camera-camera2-internal-Camera2CameraImpl$StateCallback$ScheduledReopen */
            /* synthetic */ void m1093x10b58748() {
                if (this.mCancelled) {
                    return;
                }
                Preconditions.checkState(Camera2CameraImpl.this.mState == InternalState.REOPENING);
                Camera2CameraImpl.this.openCameraDevice();
            }
        }
    }

    void updateDefaultRequestBuilderToCameraControl(CameraDevice cameraDevice) {
        try {
            this.mCameraControlInternal.setDefaultRequestBuilder(cameraDevice.createCaptureRequest(this.mCameraControlInternal.getDefaultTemplate()));
        } catch (CameraAccessException e) {
            Logger.m1140e(TAG, "fail to create capture request.", e);
        }
    }

    final class CameraAvailability extends CameraManager.AvailabilityCallback implements CameraStateRegistry.OnOpenAvailableListener {
        private boolean mCameraAvailable = true;
        private final String mCameraId;

        CameraAvailability(String cameraId) {
            this.mCameraId = cameraId;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String cameraId) {
            if (this.mCameraId.equals(cameraId)) {
                this.mCameraAvailable = true;
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.openCameraDevice();
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String cameraId) {
            if (this.mCameraId.equals(cameraId)) {
                this.mCameraAvailable = false;
            }
        }

        @Override // androidx.camera.core.impl.CameraStateRegistry.OnOpenAvailableListener
        public void onOpenAvailable() {
            if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.openCameraDevice();
            }
        }

        boolean isCameraAvailable() {
            return this.mCameraAvailable;
        }
    }

    final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        ControlUpdateListenerInternal() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlUpdateSessionConfig(SessionConfig sessionConfig) {
            Camera2CameraImpl.this.mCameraControlSessionConfig = (SessionConfig) Preconditions.checkNotNull(sessionConfig);
            Camera2CameraImpl.this.updateCaptureSessionConfig();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlCaptureRequests(List<CaptureConfig> captureConfigs) {
            Camera2CameraImpl.this.submitCaptureRequests((List) Preconditions.checkNotNull(captureConfigs));
        }
    }
}
