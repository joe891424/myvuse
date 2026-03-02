package com.microblink.blinkid.secured;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Looper;
import com.facebook.imagepipeline.common.RotationOptions;
import com.microblink.blinkid.secured.llllllllll;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.hardware.camera.CameraResolutionTooSmallException;
import com.microblink.hardware.camera.CameraType;
import com.microblink.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIlllllII implements llllllllll {
    private IIllllllll IIlIIIllIl;
    private com.microblink.blinkid.secured.llIIlIlIIl IlIllIlIIl;
    private lIIIllIIlI IlIlllllII;
    private lIlllIlIlI IllIIIIllI;
    private llIlIlIlIl IllIIIllII;
    private llllllllll.llIIlIlIIl lIllIIlIIl;
    private ShakeCallback lllIIIlIlI;
    private lIlIllIIlI lllIlIlIIl;
    private IIIIIlIIII lllllIlIll;
    private Camera llIIlIlIIl = null;
    private IlIIIlIIIl llIIIlllll = null;
    private volatile boolean lIlIIIIlIl = false;
    private lllllIlIll llIIlIIlll = null;
    private ShakeCallback lIIIIIllll = null;
    private Boolean IlIllIlllI = null;
    private boolean IllIIlIIII = false;
    private IIIIIllIll lIIIIIlIlI = null;
    private Camera.Size llIIlIIIll = null;
    private CameraType IlIIlllIIl = null;
    private int llIllIIlll = 0;
    private AtomicBoolean lIlllIlIlI = new AtomicBoolean(false);
    private Boolean lllIIlIIlI = null;
    private int IlIIlIIIII = -1;
    private boolean IlllIIIllI = false;
    private volatile int IlIlIlIIlI = 1;
    private final Camera.PictureCallback IlIIIIIlll = new IIlIIIllIl();
    private final Camera.PreviewCallback IIIIIIIIII = new llIIIlllll();

    /* JADX INFO: compiled from: line */
    class IIlIIIllIl implements Camera.PictureCallback {
        private long llIIlIlIIl = 3000000;

        /* JADX INFO: compiled from: line */
        class llIIlIlIIl implements Runnable {
            final /* synthetic */ llIllIIlll llIIlIlIIl;

            llIIlIlIIl(llIllIIlll llilliilll) {
                this.llIIlIlIIl = llilliilll;
            }

            @Override // java.lang.Runnable
            public void run() {
                IIIIIllIll iIIIIllIllIllIIlIIII = IlIlllllII.IllIIlIIII(IlIlllllII.this);
                if (iIIIIllIllIllIIlIIII != null) {
                    iIIIIllIllIllIIlIIII.IIlIIIllIl();
                    iIIIIllIllIllIIlIIII.IllIIIIllI();
                }
                IlIlllllII.this.lIlIIIIlIl = true;
                IlIlllllII.this.IlIlIlIIlI = 1;
                if (IlIlllllII.this.IllIIIllII != null) {
                    IlIlllllII.this.IllIIIllII.onHighResFrame(this.llIIlIlIIl);
                }
                this.llIIlIlIIl.llIIlIlIIl();
            }
        }

        IIlIIIllIl() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            Log.m2711i(this, "on picture taken", new Object[0]);
            if (bArr == null) {
                IlIlllllII.this.IlIlIlIIlI = 1;
                return;
            }
            IlIlllllII.this.lIlIIIIlIl = false;
            IlIlllllII.this.llIIlIlIIl.stopPreview();
            Camera.Size pictureSize = camera.getParameters().getPictureSize();
            llIllIIlll llilliilllLlIIlIlIIl = llIllIIlll.llIIlIlIIl(pictureSize.width, pictureSize.height, bArr);
            long j = this.llIIlIlIIl;
            this.llIIlIlIIl = 1 + j;
            llilliilllLlIIlIlIIl.IlIllIlIIl(j);
            try {
                IlIlllllII.this.llIIlIlIIl.setPreviewCallbackWithBuffer(IlIlllllII.this.IIIIIIIIII);
                IlIlllllII.this.llIIlIlIIl.startPreview();
                IlIlllllII.IlIlllllII(IlIlllllII.this).llIIlIlIIl(new llIIlIlIIl(llilliilllLlIIlIlIIl), IlIlllllII.this.llIIIlllll.llIIlIlIIl());
            } catch (RuntimeException e) {
                Log.m2710e(this, e, "Unable to restart camera preview", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements Runnable {
        IlIllIlIIl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IlIlllllII.this.llIIlIIlll != null) {
                IlIlllllII.this.llIIlIIlll.llIIlIlIIl();
            }
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (lllllIlIll) null);
            if (IlIlllllII.this.lIIIIIlIlI != null) {
                IlIlllllII.this.lIIIIIlIlI.dispose();
            }
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (IIIIIllIll) null);
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (com.microblink.blinkid.secured.llIIlIlIIl) null);
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (IIllllllll) null);
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (llIlIlIlIl) null);
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (lIIIllIIlI) null);
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (ShakeCallback) null);
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (Camera.Size) null);
            IlIlllllII.IlIllIlIIl(IlIlllllII.this, (CameraType) null);
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (lIlIllIIlI) null);
            IlIlllllII.llIIlIlIIl(IlIlllllII.this, (llllllllll.llIIlIlIIl) null);
            IlIlllllII.IlIllIlIIl(IlIlllllII.this, (ShakeCallback) null);
        }
    }

    /* JADX INFO: compiled from: line */
    class IlIllIlllI implements Runnable {
        final /* synthetic */ boolean IlIllIlIIl;
        final /* synthetic */ SuccessCallback llIIlIlIIl;

        IlIllIlllI(SuccessCallback successCallback, boolean z) {
            this.llIIlIlIIl = successCallback;
            this.IlIllIlIIl = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IlIlllllII.this.llIIlIlIIl == null) {
                Log.m2709e(IlIlllllII.this, "Camera not yet initialized. Unable to change torch state!", new Object[0]);
                SuccessCallback successCallback = this.llIIlIlIIl;
                if (successCallback != null) {
                    successCallback.onOperationDone(false);
                }
            }
            IIIIIllIll iIIIIllIll = IlIlllllII.this.lIIIIIlIlI;
            if (iIIIIllIll != null && IlIlllllII.this.lllIlIlIIl()) {
                iIIIIllIll.IllIIIllII();
            }
            try {
                IlIlIIllll ilIlIIllll = new IlIlIIllll(IlIlllllII.this.llIIlIlIIl);
                if (ilIlIIllll.IlIllIlIIl(this.IlIllIlIIl)) {
                    int i = IIIIIIIIII.llIIlIlIIl;
                } else {
                    int i2 = IIIIIIIIII.llIIlIlIIl;
                    new Exception("FLASH_MODE_OFF not supported");
                }
                ilIlIIllll.llIIlIlIIl(IlIlllllII.this.llIIlIlIIl);
                IlIlllllII.this.lIIIIIllll();
                SuccessCallback successCallback2 = this.llIIlIlIIl;
                if (successCallback2 != null) {
                    successCallback2.onOperationDone(true);
                }
            } catch (RuntimeException unused) {
                SuccessCallback successCallback3 = this.llIIlIlIIl;
                if (successCallback3 != null) {
                    successCallback3.onOperationDone(false);
                }
                int i3 = IIIIIIIIII.llIIlIlIIl;
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIIllI implements Runnable {
        final /* synthetic */ Context IlIllIlIIl;
        final /* synthetic */ IIllllllll llIIlIlIIl;

        IllIIIIllI(IIllllllll iIllllllll, Context context) {
            this.llIIlIlIIl = iIllllllll;
            this.IlIllIlIIl = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.m2711i(IlIlllllII.this, "Opening camera...", new Object[0]);
                IlIlllllII ilIlllllII = IlIlllllII.this;
                ilIlllllII.llIIlIlIIl = IlIlllllII.llIIlIlIIl(ilIlllllII, this.llIIlIlIIl.IlIllIlIIl());
                IlIlllllII ilIlllllII2 = IlIlllllII.this;
                ilIlllllII2.llIIIlllll = ((IlIIlllIll) ilIlllllII2.IlIlllllII).llIIlIlIIl(this.IlIllIlIIl, IlIlllllII.this.llIIlIlIIl, this.llIIlIlIIl);
                IlIlllllII ilIlllllII3 = IlIlllllII.this;
                Log.m2711i(ilIlllllII3, "Camera strategy: {}", ilIlllllII3.llIIIlllll);
                IlIlllllII ilIlllllII4 = IlIlllllII.this;
                Log.m2711i(ilIlllllII4, "Camera sensor orientation is {}", Integer.valueOf(ilIlllllII4.IlIIlIIIII));
                if (IlIlllllII.this.IlIIlIIIII == 0) {
                    if (IlIlllllII.this.IlIIlllIIl == CameraType.CAMERA_BACKFACE) {
                        IlIlllllII.this.IlIIlIIIII = 90;
                    } else if (IlIlllllII.this.IlIIlllIIl == CameraType.CAMERA_FRONTFACE) {
                        IlIlllllII.this.IlIIlIIIII = RotationOptions.ROTATE_270;
                    }
                }
                if (IlIlllllII.this.llIllIIlll != 0) {
                    IlIlllllII ilIlllllII5 = IlIlllllII.this;
                    Log.m2711i(ilIlllllII5, "Rotating camera preview by {} degrees!", Integer.valueOf(ilIlllllII5.llIllIIlll));
                    IlIIIIIlll.llIIlIlIIl(IlIlllllII.this.llIIlIlIIl, IlIlllllII.this.llIllIIlll, IlIlllllII.this.IlIIlIIIII, IlIlllllII.this.IlIIlllIIl == CameraType.CAMERA_FRONTFACE);
                }
                IlIlllllII.lllIlIlIIl(IlIlllllII.this);
            } catch (Throwable th) {
                if (IlIlllllII.this.llIIlIlIIl != null) {
                    IlIlllllII.this.llIIlIlIIl.release();
                    IlIlllllII.this.llIIlIlIIl = null;
                }
                if (IlIlllllII.this.lIlllIlIlI.get()) {
                    return;
                }
                IlIlllllII.this.lIllIIlIIl.llIIlIlIIl(th);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements Runnable {
        final /* synthetic */ com.microblink.blinkid.secured.IllIIlIIII llIIlIlIIl;

        IllIIIllII(com.microblink.blinkid.secured.IllIIlIIII illIIlIIII) {
            this.llIIlIlIIl = illIIlIIII;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IlIlllllII.this.llIIlIlIIl == null || IlIlllllII.this.IllIIlIIII) {
                Log.m2715w(IlIlllllII.this, "Camera is released, cannot request another frame", new Object[0]);
                return;
            }
            if (this.llIIlIlIIl.llIIlIIlll() != null) {
                IlIlllllII.this.llIIlIlIIl.addCallbackBuffer(this.llIIlIlIIl.llIIlIIlll());
            }
            IIIIIllIll iIIIIllIll = IlIlllllII.this.lIIIIIlIlI;
            if (iIIIIllIll != null) {
                iIIIIllIll.IllIIIIllI();
            }
        }
    }

    /* JADX INFO: compiled from: line */
    private class IllIIlIIII implements ShakeCallback {

        /* JADX INFO: compiled from: line */
        class IlIllIlIIl implements Runnable {
            IlIllIlIIl() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IIIIIllIll iIIIIllIll = IlIlllllII.this.lIIIIIlIlI;
                if (iIIIIllIll != null) {
                    iIIIIllIll.IIlIIIllIl();
                    if (!iIIIIllIll.lIlIIIIlIl() || IlIlllllII.this.IIlIIIllIl.lllIIIlIlI()) {
                        iIIIIllIll.lIIIIIllll();
                    }
                    iIIIIllIll.llIIlIlIIl(false);
                }
            }
        }

        /* JADX INFO: compiled from: line */
        class llIIlIlIIl implements Runnable {
            llIIlIlIIl() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IIIIIllIll iIIIIllIll = IlIlllllII.this.lIIIIIlIlI;
                if (iIIIIllIll != null) {
                    iIIIIllIll.llIIIlllll();
                }
            }
        }

        private IllIIlIIII() {
        }

        @Override // com.microblink.hardware.accelerometer.ShakeCallback
        public void onShakingStarted() {
            Log.m2713v(this, "shaking started, this = {}, focus manager: {}, camera queue: {}", this, IlIlllllII.this.lIIIIIlIlI, IlIlllllII.this.lllllIlIll);
            if (IlIlllllII.this.lIIIIIlIlI != null) {
                IlIlllllII.this.lllllIlIll.llIIlIlIIl(new llIIlIlIIl());
            }
            if (IlIlllllII.this.lIIIIIllll != null) {
                IlIlllllII.this.lIIIIIllll.onShakingStarted();
            }
            if (IlIlllllII.this.lllIIIlIlI != null) {
                IlIlllllII.this.lllIIIlIlI.onShakingStarted();
            }
        }

        @Override // com.microblink.hardware.accelerometer.ShakeCallback
        public void onShakingStopped() {
            Log.m2713v(this, "shaking stopped, this = {}, focus manager: {}, camera queue: {}", this, IlIlllllII.this.lIIIIIlIlI, IlIlllllII.this.lllllIlIll);
            if (IlIlllllII.this.lIIIIIlIlI != null) {
                IlIlllllII.this.lllllIlIll.llIIlIlIIl(new IlIllIlIIl());
            }
            if (IlIlllllII.this.lIIIIIllll != null) {
                IlIlllllII.this.lIIIIIllll.onShakingStopped();
            }
            if (IlIlllllII.this.lllIIIlIlI != null) {
                IlIlllllII.this.lllIIIlIlI.onShakingStopped();
            }
        }

        /* synthetic */ IllIIlIIII(IlIlllllII ilIlllllII, lIIIIIlIlI liiiiilili) {
            this();
        }
    }

    /* JADX INFO: compiled from: line */
    class lIIIIIllll implements Runnable {
        final /* synthetic */ int llIIlIlIIl;

        lIIIIIllll(int i) {
            this.llIIlIlIIl = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            IIIIIllIll iIIIIllIll = IlIlllllII.this.lIIIIIlIlI;
            if (iIIIIllIll.llIIlIIlll()) {
                iIIIIllIll.IllIIIllII();
            }
            Log.m2711i(IlIlllllII.this, "Rotating camera preview by {} degrees!", Integer.valueOf(this.llIIlIlIIl));
            IlIIIIIlll.llIIlIlIIl(IlIlllllII.this.llIIlIlIIl, this.llIIlIlIIl, IlIlllllII.this.IlIIlIIIII, IlIlllllII.this.IlIIlllIIl == CameraType.CAMERA_FRONTFACE);
            IlIlllllII.this.llIllIIlll = this.llIIlIlIIl;
        }
    }

    /* JADX INFO: compiled from: line */
    class lIlIIIIlIl implements Runnable {
        lIlIIIIlIl() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IIIIIllIll iIIIIllIll = IlIlllllII.this.lIIIIIlIlI;
            if (iIIIIllIll != null) {
                Log.m2711i(IlIlllllII.this, "Pausing focus manager", new Object[0]);
                iIIIIllIll.llIIIlllll();
            }
            com.microblink.blinkid.secured.llIIlIlIIl lliililiil = IlIlllllII.this.IlIllIlIIl;
            if (lliililiil != null) {
                Log.m2711i(IlIlllllII.this, "Pausing accelerometer", new Object[0]);
                lliililiil.llIIIlllll();
            }
            IlIlllllII.llIIlIIlll(IlIlllllII.this);
            IlIlllllII.this.llIIIlllll = null;
            IlIlllllII.this.IllIIlIIII = false;
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIIlllll implements Camera.PreviewCallback {
        private long llIIlIlIIl = 0;

        llIIIlllll() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (IlIlllllII.this.llIIlIIlll == null) {
                Log.m2715w(IlIlllllII.this, "Cannot obtain frame by its buffer because frame pool has been disposed", new Object[0]);
                return;
            }
            com.microblink.blinkid.secured.llIIlIIlll lliiliilllLlIIlIlIIl = IlIlllllII.this.llIIlIIlll.llIIlIlIIl(bArr);
            if (lliiliilllLlIIlIlIIl == null) {
                Log.m2707d(IlIlllllII.this, "Cannot find frame by its buffer. This is OK if buffered callback is disabled. Otherwise this is an error!", new Object[0]);
                lliiliilllLlIIlIlIIl = IlIlllllII.this.llIIlIIlll.IlIllIlIIl();
                lliiliilllLlIIlIlIIl.llIIlIlIIl(bArr);
            }
            long j = this.llIIlIlIIl;
            this.llIIlIlIIl = 1 + j;
            lliiliilllLlIIlIlIIl.IlIllIlIIl(j);
            lliiliilllLlIIlIlIIl.llIIlIlIIl(IlIlllllII.this.IlIllIlIIl.IlIllIlIIl());
            lliiliilllLlIIlIlIIl.IlIllIlIIl(IlIlllllII.this.llIIlIlIIl());
            Log.m2713v(IlIlllllII.this, "Frame {} has arrived from camera", Long.valueOf(lliiliilllLlIIlIlIIl.lIlIIIIlIl()));
            if (IlIlllllII.this.IllIIIllII == null || !IlIlllllII.this.IllIIIllII.canReceiveFrame()) {
                lliiliilllLlIIlIlIIl.IllIIIllII();
            } else {
                IlIlllllII.this.IllIIIllII.onCameraFrame(lliiliilllLlIIlIlIIl);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIIlll implements Runnable {
        llIIlIIlll() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IlIlllllII.this.llIIlIlIIl == null || IlIlllllII.this.IlIlIlIIlI == 2 || !IlIlllllII.this.lIlIIIIlIl) {
                return;
            }
            IlIlllllII.this.IlIlIlIIlI = 2;
            IlIlllllII.this.llIIlIlIIl.takePicture(null, null, IlIlllllII.this.IlIIIIIlll);
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Runnable {
        final /* synthetic */ Rect[] llIIlIlIIl;

        llIIlIlIIl(Rect[] rectArr) {
            this.llIIlIlIIl = rectArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            IIIIIllIll iIIIIllIll = IlIlllllII.this.lIIIIIlIlI;
            if (iIIIIllIll != null) {
                iIIIIllIll.llIIlIlIIl(this.llIIlIlIIl);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class lllIIIlIlI implements Runnable {
        lllIIIlIlI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.m2707d(IlIlllllII.this, "Triggering autofocus", new Object[0]);
            IIIIIllIll iIIIIllIll = IlIlllllII.this.lIIIIIlIlI;
            if (iIIIIllIll == null || iIIIIllIll.llIIlIIlll()) {
                return;
            }
            iIIIIllIll.llIIlIlIIl(true);
        }
    }

    /* JADX INFO: compiled from: line */
    class lllIlIlIIl implements Runnable {
        final /* synthetic */ float llIIlIlIIl;

        lllIlIlIIl(float f) {
            this.llIIlIlIIl = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IlIlllllII.this.llIIlIlIIl != null) {
                try {
                    new IlIlIIllll(IlIlllllII.this.llIIlIlIIl).llIIlIlIIl(IlIlllllII.this.lllIlIlIIl.llIIlIlIIl(this.llIIlIlIIl)).llIIlIlIIl(IlIlllllII.this.llIIlIlIIl);
                } catch (RuntimeException unused) {
                    Log.m2709e(IlIlllllII.this, "Failed to set zoom level to {}", Float.valueOf(this.llIIlIlIIl));
                }
            }
        }
    }

    public IlIlllllII(com.microblink.blinkid.secured.llIIlIlIIl lliililiil, lIIIllIIlI liiilliili, llIlIlIlIl llilililil, IIllllllll iIllllllll) {
        lIIIIIlIlI liiiiilili = null;
        this.IlIllIlIIl = null;
        this.IllIIIllII = null;
        this.IIlIIIllIl = null;
        this.IlIlllllII = null;
        this.IlIllIlIIl = lliililiil;
        lIlIllIIlI lililliiliLlIIlIIlll = lIlIllIIlI.llIIlIIlll();
        this.lllIlIlIIl = lililliiliLlIIlIIlll;
        if (!lililliiliLlIIlIIlll.lIIIIIlIlI()) {
            throw new IllegalArgumentException("Provided device manager must have device lists loaded!");
        }
        this.IllIIIllII = llilililil;
        this.IIlIIIllIl = iIllllllll;
        this.IlIlllllII = liiilliili;
        if (this.IlIllIlIIl == null || liiilliili == null) {
            throw new NullPointerException("Camera manager requires accelerometer manager and camera strategy factory to be non-null");
        }
        if (llilililil == null) {
            throw new NullPointerException("Camera delegate can't be null.");
        }
        if (iIllllllll == null) {
            this.IIlIIIllIl = new IIllllllll();
        }
        this.IlIllIlIIl.llIIlIlIIl(new IllIIlIIII(this, liiiiilili));
        this.lllIIIlIlI = iIllllllll.llIIlIIlll();
        IIIIIlIIII iIIIIlIIIILlIIlIlIIl = llllIllllI.INSTANCE.llIIlIlIIl();
        this.lllllIlIll = iIIIIlIIIILlIIlIlIIl;
        this.IllIIIIllI = new lIlllIlIlI(this.lllIlIlIIl, iIIIIlIIIILlIIlIlIIl, new lIIIIIlIlI(this));
    }

    static IIIIIlIIII IlIlllllII(IlIlllllII ilIlllllII) {
        return ilIlllllII.lllllIlIll;
    }

    static IIIIIllIll IllIIlIIII(IlIlllllII ilIlllllII) {
        return ilIlllllII.lIIIIIlIlI;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void dispose() {
        if (this.lIlllIlIlI.compareAndSet(false, true)) {
            this.lllllIlIll.llIIlIlIIl(new IlIllIlIIl());
        }
    }

    protected void finalize() throws Throwable {
        dispose();
        super.finalize();
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public Boolean llIIlIIlll() {
        return this.IlIllIlllI;
    }

    public boolean lllIlIlIIl() {
        IIIIIllIll iIIIIllIll = this.lIIIIIlIlI;
        return iIIIIllIll != null && iIIIIllIll.llIIlIIlll();
    }

    static void llIIlIIlll(IlIlllllII ilIlllllII) {
        Camera camera = ilIlllllII.llIIlIlIIl;
        if (camera == null) {
            return;
        }
        camera.setPreviewCallbackWithBuffer(null);
        Log.m2711i(ilIlllllII, "Stopping camera preview", new Object[0]);
        ilIlllllII.lIlIIIIlIl = false;
        ilIlllllII.llIIlIlIIl.stopPreview();
        if (!ilIlllllII.lIlllIlIlI.get()) {
            ilIlllllII.lIllIIlIIl.IlIllIlIIl();
        }
        Log.m2711i(ilIlllllII, "Releasing camera", new Object[0]);
        ilIlllllII.llIIlIlIIl.release();
        Log.m2711i(ilIlllllII, "Camera released", new Object[0]);
        ilIlllllII.llIIlIlIIl = null;
        ilIlllllII.lllIIlIIlI = null;
        ilIlllllII.IlIllIlllI = null;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void IIlIIIllIl() {
        this.lllllIlIll.llIIlIlIIl(new llIIlIIlll());
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public boolean IlIllIlllI() {
        Boolean bool = this.lllIIlIIlI;
        if (bool != null) {
            return bool.booleanValue();
        }
        Log.m2709e(this, "Camera not yet initialized. Unable to determine if torch is supported!", new Object[0]);
        return false;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public IIllIlIIII IllIIIIllI() {
        return this.IllIIIIllI;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void lIIIIIllll() {
        IIIIIllIll iIIIIllIll = this.lIIIIIlIlI;
        if (iIIIIllIll == null || iIIIIllIll.llIIlIIlll()) {
            return;
        }
        this.lllllIlIll.llIIlIlIIl(new lllIIIlIlI());
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public final CameraType lIlIIIIlIl() {
        return this.IlIIlllIIl;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public boolean llIIIlllll() {
        return this.IlIIlIIIII == 270;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void lllIIIlIlI() {
        if (!this.IlllIIIllI) {
            Log.m2711i(this, "Stop preview has already been called. Ignoring this call!", new Object[0]);
            return;
        }
        this.IlllIIIllI = false;
        Log.m2711i(this, "Camera1Manager.stopPreview", new Object[0]);
        this.IllIIlIIII = true;
        this.lllllIlIll.llIIlIlIIl(new lIlIIIIlIl());
    }

    static void lllIlIlIIl(IlIlllllII ilIlllllII) {
        Camera camera;
        if (ilIlllllII.lIlIIIIlIl) {
            Log.m2715w(ilIlllllII, "Preview is already active", new Object[0]);
            return;
        }
        try {
            lIlllIlIlI lilllilili = ilIlllllII.IllIIIIllI;
            if (lilllilili.IllIIIIllI() && !ilIlllllII.lIlIIIIlIl && (camera = ilIlllllII.llIIlIlIIl) != null) {
                lilllilili.llIIlIlIIl(camera);
                IlIlIIllll ilIlIIllll = new IlIlIIllll(ilIlllllII.llIIlIlIIl);
                if (ilIlllllII.llIIlIIIll == null) {
                    ilIlllllII.llIIlIlIIl(lilllilili);
                }
                llllllllll.llIIlIlIIl lliililiil = ilIlllllII.lIllIIlIIl;
                Camera.Size size = ilIlllllII.llIIlIIIll;
                lliililiil.llIIlIlIIl(size.width, size.height);
                Log.m2707d(ilIlllllII, "Resuming camera with preview size {}x{}", Integer.valueOf(ilIlllllII.llIIlIIIll.width), Integer.valueOf(ilIlllllII.llIIlIIIll.height));
                ilIlIIllll.llIIlIlIIl(ilIlllllII.llIIlIIIll).llIIlIlIIl(ilIlllllII.lllIlIlIIl.llIIlIlIIl(ilIlllllII.IIlIIIllIl.llIIIlllll()));
                ilIlllllII.lIIIIIlIlI = ilIlllllII.llIIlIlIIl(ilIlIIllll);
                int i = IIIIIIIIII.llIIlIlIIl;
                try {
                    Log.m2713v(ilIlllllII, "Setting following parameters to camera: {}", ilIlIIllll.toString());
                    ilIlIIllll.llIIlIlIIl(ilIlllllII.llIIlIlIIl);
                } catch (RuntimeException e) {
                    Log.m2710e(ilIlllllII, e, "Setting camera parameters failed!", new Object[0]);
                    Log.m2709e(ilIlllllII, "Preview width: {} height: {}", Integer.valueOf(ilIlllllII.llIIlIIIll.width), Integer.valueOf(ilIlllllII.llIIlIIIll.height));
                }
                Camera.Size size2 = ilIlllllII.llIIlIIIll;
                int bitsPerPixel = ImageFormat.getBitsPerPixel(ilIlIIllll.IllIIIllII().getPreviewFormat());
                if (bitsPerPixel == -1) {
                    bitsPerPixel = 24;
                }
                int i2 = ((size2.width * size2.height) * bitsPerPixel) / 8;
                ilIlllllII.llIIlIlIIl.setPreviewCallbackWithBuffer(ilIlllllII.IIIIIIIIII);
                int i3 = lIlIllIIlI.IlIllIlllI() == 1 ? 1 : 3;
                Camera.Size size3 = ilIlllllII.llIIlIIIll;
                ilIlllllII.llIIlIIlll = new lllllIlIll(size3.width, size3.height, i2, i3, ilIlllllII, ilIlllllII.IIlIIIllIl.llIIlIlIIl());
                com.microblink.blinkid.secured.llIIlIIlll[] lliiliilllArr = new com.microblink.blinkid.secured.llIIlIIlll[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    lliiliilllArr[i4] = ilIlllllII.llIIlIIlll.IlIllIlIIl();
                }
                for (int i5 = 0; i5 < i3; i5++) {
                    lliiliilllArr[i5].IllIIIllII();
                }
                IIIIIllIll iIIIIllIll = ilIlllllII.lIIIIIlIlI;
                Log.m2713v(ilIlllllII, "Focus manager: {}", iIIIIllIll);
                if (iIIIIllIll != null) {
                    iIIIIllIll.llIIlIlIIl(ilIlllllII.llIIlIlIIl);
                    iIIIIllIll.IIlIIIllIl();
                    ilIlllllII.llIIlIlIIl.startPreview();
                    ilIlllllII.lIlIIIIlIl = true;
                    if (ilIlllllII.llIIlIlIIl != null) {
                        Boolean boolIllIIIIllI = new IlIlIIllll(ilIlllllII.llIIlIlIIl).IllIIIIllI();
                        ilIlllllII.lllIIlIIlI = boolIllIIIIllI;
                        int i6 = IIIIIIIIII.llIIlIlIIl;
                        boolIllIIIIllI.booleanValue();
                    }
                    int iLlIIlIlIIl = ilIlllllII.llIIIlllll.llIIlIlIIl();
                    if (iLlIIlIlIIl > 0) {
                        ilIlllllII.lllllIlIll.llIIlIlIIl(new llIIlIIIll(ilIlllllII), iLlIIlIlIIl);
                    } else {
                        com.microblink.blinkid.secured.llIIlIlIIl lliililiil2 = ilIlllllII.IlIllIlIIl;
                        if (lliililiil2 != null) {
                            lliililiil2.IllIIIllII();
                        }
                    }
                    ilIlllllII.lIllIIlIIl.llIIlIlIIl();
                    return;
                }
                throw new IllegalStateException("Method prepareCameraParametersAndFocusManager did not prepare focus manager!");
            }
            Log.m2707d(ilIlllllII, "Camera still hasn't got surface or preview already active or camera is null (due to error). Cannot start preview!", new Object[0]);
            Log.m2707d(ilIlllllII, "surface sane: {}; previewActive: {}, camera: {}", Boolean.valueOf(ilIlllllII.IllIIIIllI.IllIIIIllI()), Boolean.valueOf(ilIlllllII.lIlIIIIlIl), ilIlllllII.llIIlIlIIl);
        } catch (Throwable th) {
            if (ilIlllllII.lIlllIlIlI.get()) {
                return;
            }
            ilIlllllII.lIllIIlIIl.llIIlIlIIl(th);
            ilIlllllII.lIlIIIIlIl = false;
            ilIlllllII.llIIlIlIIl.release();
            ilIlllllII.llIIlIlIIl = null;
        }
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public int IllIIIllII() {
        return this.IlIIlIIIII;
    }

    static /* synthetic */ ShakeCallback IlIllIlIIl(IlIlllllII ilIlllllII, ShakeCallback shakeCallback) {
        ilIlllllII.lllIIIlIlI = null;
        return null;
    }

    static /* synthetic */ llllllllll.llIIlIlIIl llIIlIlIIl(IlIlllllII ilIlllllII, llllllllll.llIIlIlIIl lliililiil) {
        ilIlllllII.lIllIIlIIl = null;
        return null;
    }

    static /* synthetic */ CameraType IlIllIlIIl(IlIlllllII ilIlllllII, CameraType cameraType) {
        ilIlllllII.IlIIlllIIl = null;
        return null;
    }

    static /* synthetic */ IIIIIllIll llIIlIlIIl(IlIlllllII ilIlllllII, IIIIIllIll iIIIIllIll) {
        ilIlllllII.lIIIIIlIlI = null;
        return null;
    }

    static /* synthetic */ com.microblink.blinkid.secured.llIIlIlIIl llIIlIlIIl(IlIlllllII ilIlllllII, com.microblink.blinkid.secured.llIIlIlIIl lliililiil) {
        ilIlllllII.IlIllIlIIl = null;
        return null;
    }

    public void IlIllIlIIl(int i) {
        this.llIllIIlll = i;
        if (this.lIlIIIIlIl) {
            this.lllllIlIll.llIIlIlIIl(new lIIIIIllll(i));
        }
    }

    static /* synthetic */ llIlIlIlIl llIIlIlIIl(IlIlllllII ilIlllllII, llIlIlIlIl llilililil) {
        ilIlllllII.IllIIIllII = null;
        return null;
    }

    static /* synthetic */ lIlIllIIlI llIIlIlIIl(IlIlllllII ilIlllllII, lIlIllIIlI lililliili) {
        ilIlllllII.lllIlIlIIl = null;
        return null;
    }

    static /* synthetic */ lllllIlIll llIIlIlIIl(IlIlllllII ilIlllllII, lllllIlIll lllllilill) {
        ilIlllllII.llIIlIIlll = null;
        return null;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public boolean IlIllIlIIl() {
        return this.IlIllIlIIl.IlIllIlIIl();
    }

    static /* synthetic */ IIllllllll llIIlIlIIl(IlIlllllII ilIlllllII, IIllllllll iIllllllll) {
        ilIlllllII.IIlIIIllIl = null;
        return null;
    }

    static /* synthetic */ ShakeCallback llIIlIlIIl(IlIlllllII ilIlllllII, ShakeCallback shakeCallback) {
        ilIlllllII.lIIIIIllll = null;
        return null;
    }

    static /* synthetic */ Camera.Size llIIlIlIIl(IlIlllllII ilIlllllII, Camera.Size size) {
        ilIlllllII.llIIlIIIll = null;
        return null;
    }

    static Camera llIIlIlIIl(IlIlllllII ilIlllllII, CameraType cameraType) {
        ilIlllllII.getClass();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        boolean zLlIIlIlIIl = false;
        boolean zLlIIlIlIIl2 = false;
        for (int i5 = 0; i5 < numberOfCameras; i5++) {
            Camera.getCameraInfo(i5, cameraInfo);
            int i6 = cameraInfo.facing;
            if (i6 == 1) {
                if (i2 == -1) {
                    i4 = cameraInfo.orientation;
                    Log.m2711i(ilIlllllII, "Front facing orientation: {}", Integer.valueOf(i4));
                    zLlIIlIlIIl = ilIlllllII.llIIlIlIIl(i5);
                    i2 = i5;
                } else if (!zLlIIlIlIIl) {
                    if (ilIlllllII.llIIlIlIIl(i5)) {
                        i4 = cameraInfo.orientation;
                        Log.m2711i(ilIlllllII, "Front facing orientation: {}", Integer.valueOf(i4));
                        i2 = i5;
                        zLlIIlIlIIl = true;
                    }
                } else {
                    Log.m2715w(ilIlllllII, "Handling multiple front cameras with autofocus currently not supported! Will use the first found '{}'", Integer.valueOf(i2));
                }
            } else if (i6 == 0) {
                if (i == -1) {
                    i3 = cameraInfo.orientation;
                    Log.m2711i(ilIlllllII, "Back facing orientation: {}", Integer.valueOf(i3));
                    zLlIIlIlIIl2 = ilIlllllII.llIIlIlIIl(i5);
                    i = i5;
                } else if (!zLlIIlIlIIl2) {
                    if (ilIlllllII.llIIlIlIIl(i5)) {
                        i3 = cameraInfo.orientation;
                        i = i5;
                        zLlIIlIlIIl2 = true;
                    }
                } else {
                    Log.m2715w(ilIlllllII, "Handling multiple back cameras with autofocus currently not supported. Will use the first found '{}'", Integer.valueOf(i));
                }
            }
        }
        CameraType cameraType2 = CameraType.CAMERA_BACKFACE;
        if (cameraType == cameraType2) {
            if (i > -1) {
                ilIlllllII.IlIIlllIIl = cameraType2;
                ilIlllllII.IlIIlIIIII = i3;
                return Camera.open(i);
            }
            throw new RuntimeException("Device does not have back facing camera!");
        }
        CameraType cameraType3 = CameraType.CAMERA_FRONTFACE;
        if (cameraType == cameraType3) {
            if (i2 > -1) {
                ilIlllllII.IlIIlllIIl = cameraType3;
                ilIlllllII.IlIIlIIIII = i4;
                return Camera.open(i2);
            }
            throw new RuntimeException("Device does not have front facing camera!");
        }
        if (i > -1) {
            ilIlllllII.IlIIlllIIl = cameraType2;
            ilIlllllII.IlIIlIIIII = i3;
            return Camera.open(i);
        }
        if (i2 > -1) {
            ilIlllllII.IlIIlllIIl = cameraType3;
            ilIlllllII.IlIIlIIIII = i4;
            return Camera.open(i2);
        }
        throw new RuntimeException("Device does not have cameras!");
    }

    static /* synthetic */ lIIIllIIlI llIIlIlIIl(IlIlllllII ilIlllllII, lIIIllIIlI liiilliili) {
        ilIlllllII.IlIlllllII = null;
        return null;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(ShakeCallback shakeCallback) {
        this.lIIIIIllll = shakeCallback;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(Context context, IIllllllll iIllllllll, llllllllll.llIIlIlIIl lliililiil) {
        if (this.IlllIIIllI) {
            Log.m2711i(this, "Start preview has already been called. Ignoring this call!", new Object[0]);
            return;
        }
        Log.m2711i(this, "Camera1Manager.startPreview", new Object[0]);
        this.IlllIIIllI = true;
        this.lIllIIlIIl = lliililiil;
        this.IIlIIIllIl = iIllllllll;
        this.lllllIlIll.llIIlIlIIl(new IllIIIIllI(iIllllllll, context));
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public boolean llIIlIlIIl() {
        IIIIIllIll iIIIIllIll = this.lIIIIIlIlI;
        return iIIIIllIll != null && iIIIIllIll.IlIllIlIIl();
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(boolean z, SuccessCallback successCallback) {
        boolean zBooleanValue;
        Boolean bool = this.lllIIlIIlI;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            Log.m2709e(this, "Camera not yet initialized. Unable to determine if torch is supported!", new Object[0]);
            zBooleanValue = false;
        }
        if (!zBooleanValue) {
            Log.m2709e(this, "Camera does not support torch! Cannot change torch state!", new Object[0]);
            if (successCallback != null) {
                successCallback.onOperationDone(false);
                return;
            }
            return;
        }
        this.lllllIlIll.llIIlIlIIl(new IlIllIlllI(successCallback, z));
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(float f) {
        this.lllllIlIll.llIIlIlIIl(new lllIlIlIIl(f));
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(Rect[] rectArr) {
        if (!this.lllIlIlIIl.lllllIlIll()) {
            IIIIIlIIII iIIIIlIIII = this.lllllIlIll;
            if (iIIIIlIIII == null || this.lIIIIIlIlI == null) {
                return;
            }
            iIIIIlIIII.llIIlIlIIl(new llIIlIlIIl(rectArr));
            return;
        }
        Log.m2709e(this, "Setting metering areas not supported on this device", new Object[0]);
    }

    private IIIIIllIll llIIlIlIIl(IlIlIIllll ilIlIIllll) {
        boolean zIllIIlIIII;
        String strIIlIIIllIl;
        lIlIllIIlI lililliili;
        IIllllllll iIllllllll;
        llIlIlIlIl llilililil;
        IIIIIllIll illIIIllII;
        zIllIIlIIII = this.IIlIIIllIl.IllIIlIIII();
        if (zIllIIlIIII && this.IIlIIIllIl.llIIIlllll() == 0.0f) {
            this.IIlIIIllIl.llIIlIlIIl(0.2f);
        }
        if (zIllIIlIIII) {
            Log.m2711i(this, "Optimizing camera parameters for near scanning", new Object[0]);
            strIIlIIIllIl = ilIlIIllll.llIIlIIlll();
        } else {
            strIIlIIIllIl = ilIlIIllll.IIlIIIllIl();
        }
        lililliili = this.lllIlIlIIl;
        iIllllllll = this.IIlIIIllIl;
        llilililil = this.IllIIIllII;
        strIIlIIIllIl.getClass();
        strIIlIIIllIl.hashCode();
        switch (strIIlIIIllIl) {
            case "auto":
                Log.m2713v(null, "Activated autofocus", new Object[0]);
                illIIIllII = new com.microblink.blinkid.secured.IllIIIllII(llilililil, lililliili);
                break;
            case "macro":
                Log.m2713v(null, "Activated macro focus mode", new Object[0]);
                illIIIllII = new com.microblink.blinkid.secured.IllIIIllII(llilililil, lililliili);
                break;
            case "continuous-picture":
                Log.m2707d(null, "Activated continous picture autofocus", new Object[0]);
                illIIIllII = new llIIllIlII(llilililil, lililliili, zIllIIlIIII);
                break;
            default:
                Log.m2709e(null, "Autofocus not supported", new Object[0]);
                if (!iIllllllll.lllIlIlIIl()) {
                    illIIIllII = new llIlllIIll();
                    break;
                } else {
                    throw new AutoFocusRequiredButNotSupportedException("Autofocus is required, but not supported on this camera");
                }
                break;
        }
        this.IlIllIlllI = Boolean.valueOf(illIIIllII.llIIlIlIIl());
        ilIlIIllll.IlIllIlIIl(false);
        ilIlIIllll.llIIlIlIIl();
        ilIlIIllll.lIlIIIIlIl();
        ilIlIIllll.IlIllIlIIl();
        ilIlIIllll.IlIllIlllI();
        int i = lIlIllIIlI.lIlIIIIlIl;
        String str = Build.MODEL;
        if ("Nexus 4".equals(str)) {
            ilIlIIllll.lllIIIlIlI();
        } else if (str.contains("Glass")) {
            ilIlIIllll.lIIIIIllll();
        } else {
            ilIlIIllll.llIIlIlIIl(30);
        }
        Log.m2713v(this, "Final parameters: {}", ilIlIIllll.toString());
        return illIIIllII;
    }

    private boolean llIIlIlIIl(int i) {
        Camera cameraOpen = Camera.open(i);
        boolean zLlIIIlllll = new IlIlIIllll(cameraOpen).llIIIlllll();
        cameraOpen.release();
        return zLlIIIlllll;
    }

    private void llIIlIlIIl(lIlllIlIlI lilllilili) {
        Camera.Size sizeLlIIlIlIIl = this.llIIIlllll.llIIlIlIIl(lilllilili.llIIIlllll(), lilllilili.IllIIIllII(), this.IlIIlllIIl);
        this.llIIlIIIll = sizeLlIIlIlIIl;
        if (sizeLlIIlIlIIl != null) {
            Log.m2711i(this, "For surface size {}x{} and preset {}, selected preview size is {}x{}", Integer.valueOf(lilllilili.llIIIlllll()), Integer.valueOf(lilllilili.IllIIIllII()), this.IIlIIIllIl.IIlIIIllIl(), Integer.valueOf(this.llIIlIIIll.width), Integer.valueOf(this.llIIlIIIll.height));
            return;
        }
        throw new CameraResolutionTooSmallException("Camera preview size could not be chosen!");
    }

    public void llIIlIlIIl(com.microblink.blinkid.secured.IllIIlIIII illIIlIIII) {
        IllIIIllII illIIIllII = new IllIIIllII(illIIlIIII);
        if (this.lllllIlIll != null) {
            if (Looper.myLooper() == this.lllllIlIll.llIIlIlIIl().getLooper()) {
                illIIIllII.run();
            } else {
                this.lllllIlIll.llIIlIlIIl(illIIIllII);
            }
        }
    }
}
