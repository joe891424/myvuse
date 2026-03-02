package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
class SynchronizedCaptureSessionImpl extends SynchronizedCaptureSessionBaseImpl {
    private static final String TAG = "SyncCaptureSessionImpl";
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;
    CallbackToFutureAdapter.Completer<Void> mClosingDeferrableSurfaceCompleter;
    private final ListenableFuture<Void> mClosingDeferrableSurfaceFuture;
    private List<DeferrableSurface> mDeferrableSurfaces;
    private final Set<String> mEnabledFeature;
    private boolean mHasSubmittedRepeating;
    private final Object mObjectLock;
    ListenableFuture<Void> mOpeningCaptureSession;
    CallbackToFutureAdapter.Completer<Void> mStartStreamingCompleter;
    private final ListenableFuture<Void> mStartStreamingFuture;
    ListenableFuture<List<Surface>> mStartingSurface;

    SynchronizedCaptureSessionImpl(Set<String> enabledFeature, CaptureSessionRepository repository, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler compatHandler) {
        super(repository, executor, scheduledExecutorService, compatHandler);
        this.mObjectLock = new Object();
        this.mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl.1
            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureStarted(CameraCaptureSession session, CaptureRequest request, long timestamp, long frameNumber) {
                if (SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter != null) {
                    SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter.set(null);
                    SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter = null;
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
            public void onCaptureSequenceAborted(CameraCaptureSession session, int sequenceId) {
                if (SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter != null) {
                    SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter.setCancelled();
                    SynchronizedCaptureSessionImpl.this.mStartStreamingCompleter = null;
                }
            }
        };
        this.mEnabledFeature = enabledFeature;
        if (enabledFeature.contains("wait_for_request")) {
            this.mStartStreamingFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f$0.m1110x847c421b(completer);
                }
            });
        } else {
            this.mStartStreamingFuture = Futures.immediateFuture(null);
        }
        if (enabledFeature.contains("deferrableSurface_close")) {
            this.mClosingDeferrableSurfaceFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda2
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f$0.m1111xd23bba1c(completer);
                }
            });
        } else {
            this.mClosingDeferrableSurfaceFuture = Futures.immediateFuture(null);
        }
    }

    /* JADX INFO: renamed from: lambda$new$0$androidx-camera-camera2-internal-SynchronizedCaptureSessionImpl */
    /* synthetic */ Object m1110x847c421b(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mStartStreamingCompleter = completer;
        return "StartStreamingFuture[session=" + this + "]";
    }

    /* JADX INFO: renamed from: lambda$new$1$androidx-camera-camera2-internal-SynchronizedCaptureSessionImpl */
    /* synthetic */ Object m1111xd23bba1c(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mClosingDeferrableSurfaceCompleter = completer;
        return "ClosingDeferrableSurfaceFuture[session=" + this + "]";
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    public ListenableFuture<Void> openCaptureSession(final CameraDevice cameraDevice, final SessionConfigurationCompat sessionConfigurationCompat) {
        ListenableFuture<Void> listenableFutureNonCancellationPropagating;
        synchronized (this.mObjectLock) {
            FutureChain futureChainTransformAsync = FutureChain.from(Futures.successfulAsList(getBlockerFuture("wait_for_request", this.mCaptureSessionRepository.getClosingCaptureSession()))).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return this.f$0.m1112xa9844f31(cameraDevice, sessionConfigurationCompat, (List) obj);
                }
            }, CameraXExecutors.directExecutor());
            this.mOpeningCaptureSession = futureChainTransformAsync;
            listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(futureChainTransformAsync);
        }
        return listenableFutureNonCancellationPropagating;
    }

    /* JADX INFO: renamed from: lambda$openCaptureSession$2$androidx-camera-camera2-internal-SynchronizedCaptureSessionImpl */
    /* synthetic */ ListenableFuture m1112xa9844f31(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) throws Exception {
        return super.openCaptureSession(cameraDevice, sessionConfigurationCompat);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public ListenableFuture<Void> getSynchronizedBlocker(String feature) {
        feature.hashCode();
        if (feature.equals("wait_for_request")) {
            return Futures.nonCancellationPropagating(this.mStartStreamingFuture);
        }
        if (feature.equals("deferrableSurface_close")) {
            return Futures.nonCancellationPropagating(this.mClosingDeferrableSurfaceFuture);
        }
        return super.getSynchronizedBlocker(feature);
    }

    private List<ListenableFuture<Void>> getBlockerFuture(String feature, List<SynchronizedCaptureSession> sessions) {
        ArrayList arrayList = new ArrayList();
        Iterator<SynchronizedCaptureSession> it2 = sessions.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getSynchronizedBlocker(feature));
        }
        return arrayList;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    public ListenableFuture<List<Surface>> startWithDeferrableSurface(final List<DeferrableSurface> deferrableSurfaces, final long timeout) {
        ListenableFuture<List<Surface>> listenableFutureNonCancellationPropagating;
        synchronized (this.mObjectLock) {
            this.mDeferrableSurfaces = deferrableSurfaces;
            List<ListenableFuture<Void>> listEmptyList = Collections.emptyList();
            if (this.mEnabledFeature.contains("force_close")) {
                Map<SynchronizedCaptureSession, List<DeferrableSurface>> mapRegisterDeferrableSurface = this.mCaptureSessionRepository.registerDeferrableSurface(this, deferrableSurfaces);
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<SynchronizedCaptureSession, List<DeferrableSurface>> entry : mapRegisterDeferrableSurface.entrySet()) {
                    if (entry.getKey() != this && !Collections.disjoint(entry.getValue(), this.mDeferrableSurfaces)) {
                        arrayList.add(entry.getKey());
                    }
                }
                listEmptyList = getBlockerFuture("deferrableSurface_close", arrayList);
            }
            FutureChain futureChainTransformAsync = FutureChain.from(Futures.successfulAsList(listEmptyList)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda3
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return this.f$0.m1113xb287cbe3(deferrableSurfaces, timeout, (List) obj);
                }
            }, getExecutor());
            this.mStartingSurface = futureChainTransformAsync;
            listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(futureChainTransformAsync);
        }
        return listenableFutureNonCancellationPropagating;
    }

    /* JADX INFO: renamed from: lambda$startWithDeferrableSurface$3$androidx-camera-camera2-internal-SynchronizedCaptureSessionImpl */
    /* synthetic */ ListenableFuture m1113xb287cbe3(List list, long j, List list2) throws Exception {
        return super.startWithDeferrableSurface(list, j);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener.OpenerImpl
    public boolean stop() {
        boolean zStop;
        synchronized (this.mObjectLock) {
            if (isCameraCaptureSessionOpen()) {
                closeConfiguredDeferrableSurfaces();
            } else {
                ListenableFuture<Void> listenableFuture = this.mOpeningCaptureSession;
                if (listenableFuture != null) {
                    listenableFuture.cancel(true);
                }
                ListenableFuture<List<Surface>> listenableFuture2 = this.mStartingSurface;
                if (listenableFuture2 != null) {
                    listenableFuture2.cancel(true);
                }
                stopDeferrableSurface();
            }
            zStop = super.stop();
        }
        return zStop;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(CaptureRequest request, CameraCaptureSession.CaptureCallback listener) throws CameraAccessException {
        int singleRepeatingRequest;
        if (this.mEnabledFeature.contains("wait_for_request")) {
            synchronized (this.mObjectLock) {
                this.mHasSubmittedRepeating = true;
                singleRepeatingRequest = super.setSingleRepeatingRequest(request, Camera2CaptureCallbacks.createComboCallback(this.mCaptureCallback, listener));
            }
            return singleRepeatingRequest;
        }
        return super.setSingleRepeatingRequest(request, listener);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(SynchronizedCaptureSession session) {
        SynchronizedCaptureSession next;
        SynchronizedCaptureSession next2;
        debugLog("Session onConfigured()");
        if (this.mEnabledFeature.contains("force_close")) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it2 = this.mCaptureSessionRepository.getCreatingCaptureSessions().iterator();
            while (it2.hasNext() && (next2 = it2.next()) != session) {
                linkedHashSet.add(next2);
            }
            forceOnConfigureFailed(linkedHashSet);
        }
        super.onConfigured(session);
        if (this.mEnabledFeature.contains("force_close")) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it3 = this.mCaptureSessionRepository.getCaptureSessions().iterator();
            while (it3.hasNext() && (next = it3.next()) != session) {
                linkedHashSet2.add(next);
            }
            forceOnClosed(linkedHashSet2);
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        debugLog("Session call close()");
        if (this.mEnabledFeature.contains("wait_for_request")) {
            synchronized (this.mObjectLock) {
                if (!this.mHasSubmittedRepeating) {
                    this.mStartStreamingFuture.cancel(true);
                }
            }
        }
        this.mStartStreamingFuture.addListener(new Runnable() { // from class: androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1109x958733b7();
            }
        }, getExecutor());
    }

    /* JADX INFO: renamed from: lambda$close$4$androidx-camera-camera2-internal-SynchronizedCaptureSessionImpl */
    /* synthetic */ void m1109x958733b7() {
        debugLog("Session call super.close()");
        super.close();
    }

    void closeConfiguredDeferrableSurfaces() {
        synchronized (this.mObjectLock) {
            if (this.mDeferrableSurfaces == null) {
                debugLog("deferrableSurface == null, maybe forceClose, skip close");
                return;
            }
            if (this.mEnabledFeature.contains("deferrableSurface_close")) {
                Iterator<DeferrableSurface> it2 = this.mDeferrableSurfaces.iterator();
                while (it2.hasNext()) {
                    it2.next().close();
                }
                debugLog("deferrableSurface closed");
                stopDeferrableSurface();
            }
        }
    }

    void stopDeferrableSurface() {
        if (this.mEnabledFeature.contains("deferrableSurface_close")) {
            this.mCaptureSessionRepository.unregisterDeferrableSurface(this);
            CallbackToFutureAdapter.Completer<Void> completer = this.mClosingDeferrableSurfaceCompleter;
            if (completer != null) {
                completer.set(null);
            }
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(SynchronizedCaptureSession session) {
        closeConfiguredDeferrableSurfaces();
        debugLog("onClosed()");
        super.onClosed(session);
    }

    static void forceOnClosed(Set<SynchronizedCaptureSession> sessions) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : sessions) {
            synchronizedCaptureSession.getStateCallback().onClosed(synchronizedCaptureSession);
        }
    }

    private void forceOnConfigureFailed(Set<SynchronizedCaptureSession> sessions) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : sessions) {
            synchronizedCaptureSession.getStateCallback().onConfigureFailed(synchronizedCaptureSession);
        }
    }

    void debugLog(String message) {
        Logger.m1137d(TAG, "[" + this + "] " + message);
    }
}
