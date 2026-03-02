package com.microblink.view;

import com.microblink.blinkid.secured.llllllllll;
import com.microblink.util.Log;
import com.microblink.view.surface.ICameraView;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llIIlIlIIl implements llllllllll.llIIlIlIIl {
    final /* synthetic */ BaseCameraView llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Runnable {
        IlIllIlIIl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEventsListener cameraEventsListener;
            if (!llIIlIlIIl.this.llIIlIlIIl.IlllIIIllI || (cameraEventsListener = llIIlIlIIl.this.llIIlIlIIl.llIIlIlIIl) == null) {
                return;
            }
            cameraEventsListener.onCameraPreviewStarted();
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements Runnable {
        final /* synthetic */ int IlIllIlIIl;
        final /* synthetic */ int llIIlIlIIl;

        IllIIIllII(int i, int i2) {
            this.llIIlIlIIl = i;
            this.IlIllIlIIl = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ICameraView iCameraView = llIIlIlIIl.this.llIIlIlIIl.IllIIIIllI;
            if (iCameraView != null) {
                iCameraView.setPreviewSize(this.llIIlIlIIl, this.IlIllIlIIl);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIIlllll implements Runnable {
        llIIIlllll() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEventsListener cameraEventsListener;
            if (llIIlIlIIl.this.llIIlIlIIl.IlllIIIllI || (cameraEventsListener = llIIlIlIIl.this.llIIlIlIIl.llIIlIlIIl) == null) {
                return;
            }
            cameraEventsListener.onCameraPreviewStopped();
        }
    }

    /* JADX INFO: renamed from: com.microblink.view.llIIlIlIIl$llIIlIlIIl, reason: collision with other inner class name */
    /* JADX INFO: compiled from: line */
    class RunnableC5990llIIlIlIIl implements Runnable {
        final /* synthetic */ Throwable llIIlIlIIl;

        RunnableC5990llIIlIlIIl(Throwable th) {
            this.llIIlIlIIl = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEventsListener cameraEventsListener = llIIlIlIIl.this.llIIlIlIIl.llIIlIlIIl;
            if (cameraEventsListener != null) {
                cameraEventsListener.onError(this.llIIlIlIIl);
            }
        }
    }

    llIIlIlIIl(BaseCameraView baseCameraView) {
        this.llIIlIlIIl = baseCameraView;
    }

    @Override // com.microblink.blinkid.secured.llllllllll.llIIlIlIIl
    public void IlIllIlIIl() {
        this.llIIlIlIIl.lllIIIlIlI();
        this.llIIlIlIIl.IlllIIIllI = false;
        BaseCameraView baseCameraView = this.llIIlIlIIl;
        if (baseCameraView.llIIlIlIIl != null) {
            baseCameraView.llIIlIlIIl(new llIIIlllll());
        }
    }

    @Override // com.microblink.blinkid.secured.llllllllll.llIIlIlIIl
    public void llIIlIlIIl(Throwable th) {
        Log.m2710e(this.llIIlIlIIl, th, "Exception caught on camera startup", new Object[0]);
        this.llIIlIlIIl.IlllIIIllI = false;
        BaseCameraView baseCameraView = this.llIIlIlIIl;
        baseCameraView.IlIllIlIIl = true;
        baseCameraView.IlIlIlIIlI.post(new RunnableC5990llIIlIlIIl(th));
    }

    @Override // com.microblink.blinkid.secured.llllllllll.llIIlIlIIl
    public void llIIlIlIIl() {
        this.llIIlIlIIl.lIIIIIllll();
        this.llIIlIlIIl.IlllIIIllI = true;
        BaseCameraView baseCameraView = this.llIIlIlIIl;
        if (baseCameraView.llIIlIlIIl != null) {
            baseCameraView.llIIlIlIIl(new IlIllIlIIl());
        }
    }

    @Override // com.microblink.blinkid.secured.llllllllll.llIIlIlIIl
    public void llIIlIlIIl(int i, int i2) {
        this.llIIlIlIIl.IlIlIlIIlI.post(new IllIIIllII(i, i2));
    }
}
