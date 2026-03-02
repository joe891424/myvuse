package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class CaptureSessionRepository {
    final Executor mExecutor;
    final Object mLock = new Object();
    final Set<SynchronizedCaptureSession> mCaptureSessions = new LinkedHashSet();
    final Set<SynchronizedCaptureSession> mClosingCaptureSession = new LinkedHashSet();
    final Set<SynchronizedCaptureSession> mCreatingCaptureSessions = new LinkedHashSet();
    final Map<SynchronizedCaptureSession, List<DeferrableSurface>> mDeferrableSurfaceMap = new HashMap();
    private final CameraDevice.StateCallback mCameraStateCallback = new C03971();

    CaptureSessionRepository(Executor executor) {
        this.mExecutor = executor;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.internal.CaptureSessionRepository$1 */
    class C03971 extends CameraDevice.StateCallback {
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice camera) {
        }

        C03971() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice camera, int error) {
            forceOnClosedCaptureSessions();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice camera) {
            forceOnClosedCaptureSessions();
        }

        private void forceOnClosedCaptureSessions() {
            CaptureSessionRepository.this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.CaptureSessionRepository$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1095x52ad1c5();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$forceOnClosedCaptureSessions$0$androidx-camera-camera2-internal-CaptureSessionRepository$1 */
        /* synthetic */ void m1095x52ad1c5() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (CaptureSessionRepository.this.mLock) {
                linkedHashSet.addAll(new LinkedHashSet(CaptureSessionRepository.this.mCreatingCaptureSessions));
                linkedHashSet.addAll(new LinkedHashSet(CaptureSessionRepository.this.mCaptureSessions));
            }
            CaptureSessionRepository.forceOnClosed(linkedHashSet);
        }
    }

    CameraDevice.StateCallback getCameraStateCallback() {
        return this.mCameraStateCallback;
    }

    static void forceOnClosed(Set<SynchronizedCaptureSession> sessions) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : sessions) {
            synchronizedCaptureSession.getStateCallback().onClosed(synchronizedCaptureSession);
        }
    }

    List<SynchronizedCaptureSession> getCaptureSessions() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCaptureSessions);
        }
        return arrayList;
    }

    List<SynchronizedCaptureSession> getClosingCaptureSession() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mClosingCaptureSession);
        }
        return arrayList;
    }

    List<SynchronizedCaptureSession> getCreatingCaptureSessions() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCreatingCaptureSessions);
        }
        return arrayList;
    }

    Map<SynchronizedCaptureSession, List<DeferrableSurface>> registerDeferrableSurface(SynchronizedCaptureSession synchronizedCaptureSession, List<DeferrableSurface> deferrableSurfaces) {
        HashMap map;
        synchronized (this.mLock) {
            this.mDeferrableSurfaceMap.put(synchronizedCaptureSession, deferrableSurfaces);
            map = new HashMap(this.mDeferrableSurfaceMap);
        }
        return map;
    }

    void unregisterDeferrableSurface(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mDeferrableSurfaceMap.remove(synchronizedCaptureSession);
        }
    }

    void onCreateCaptureSession(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCreatingCaptureSessions.add(synchronizedCaptureSession);
        }
    }

    void onCaptureSessionConfigureFail(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCreatingCaptureSessions.remove(synchronizedCaptureSession);
        }
    }

    void onCaptureSessionCreated(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCaptureSessions.add(synchronizedCaptureSession);
            this.mCreatingCaptureSessions.remove(synchronizedCaptureSession);
        }
    }

    void onCaptureSessionClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mCaptureSessions.remove(synchronizedCaptureSession);
            this.mClosingCaptureSession.remove(synchronizedCaptureSession);
        }
    }

    void onCaptureSessionClosing(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mLock) {
            this.mClosingCaptureSession.add(synchronizedCaptureSession);
        }
    }
}
