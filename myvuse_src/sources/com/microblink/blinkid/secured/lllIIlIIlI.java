package com.microblink.blinkid.secured;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import com.microblink.blinkid.secured.IIlIlllIIl;
import com.microblink.blinkid.secured.IlllIIIllI;
import com.microblink.blinkid.secured.IlllllIIll;
import com.microblink.blinkid.secured.llllllllll;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.hardware.camera.CameraType;
import com.microblink.util.Log;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lllIIlIIlI implements llllllllll {
    private IIlIlllIIl IIIIIIIIII;
    private llllIIIllI IIlIIIllIl;
    private CaptureRequest IlIIlllIIl;
    protected IIllllllll IlIllIlIIl;
    private llllllllll.llIIlIlIIl IlIllIlllI;
    private CaptureRequest.Builder IlIlllllII;
    private IlIlIIlllI IllIIIIllI;
    private ShakeCallback IllIIlIIII;
    private CameraCaptureSession lIIIIIlIlI;
    private IIlIlIIlll lIIIIIllll;
    private llIlllIIIl lIlIIIIlIl;
    private IIIIIlIIII lIllIIlIIl;
    private lIIlIIlIll lIlllIlIlI;
    private IlllIIIllI llIIIlllll;
    private IlllllIIll llIIlIIIll;
    private com.microblink.blinkid.secured.llIIIlllll llIIlIIlll;
    protected com.microblink.blinkid.secured.llIIlIlIIl llIIlIlIIl;
    private IlllllIIll llIllIIlll;
    protected llIlIlIlIl lllIIIlIlI;
    private CaptureRequest lllllIlIll;
    private ShakeCallback lllIlIlIIl = ShakeCallback.EMPTY;
    private boolean lllIIlIIlI = false;
    private boolean IlIIlIIIII = false;
    private boolean IlllIIIllI = false;
    private AtomicBoolean IlIlIlIIlI = new AtomicBoolean(false);
    private boolean IlIIIIIlll = false;
    private CameraCaptureSession.CaptureCallback IIlIlllIIl = new IlIllIlIIl();
    private lIlIllIIlI IllIIIllII = lIlIllIIlI.llIIlIIlll();

    /* JADX INFO: compiled from: line */
    class IIlIIIllIl implements Runnable {
        final /* synthetic */ SuccessCallback IlIllIlIIl;
        final /* synthetic */ boolean llIIlIlIIl;

        IIlIIIllIl(boolean z, SuccessCallback successCallback) {
            this.llIIlIlIIl = z;
            this.IlIllIlIIl = successCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lllIIlIIlI.this.IlIlllllII == null || lllIIlIIlI.this.lIIIIIlIlI == null) {
                return;
            }
            IlIlIIlllI ilIlIIlllI = lllIIlIIlI.this.IllIIIIllI;
            CaptureRequest.Builder builder = lllIIlIIlI.this.IlIlllllII;
            boolean z = this.llIIlIlIIl;
            ilIlIIlllI.getClass();
            if (z) {
                builder.set(CaptureRequest.FLASH_MODE, 2);
            } else {
                builder.set(CaptureRequest.FLASH_MODE, 0);
            }
            try {
                lllIIlIIlI.this.llIIlIIIll();
                lllIIlIIlI.this.IllIIIIllI.llIIlIlIIl(this.llIIlIlIIl, this.IlIllIlIIl);
            } catch (CameraAccessException | IllegalStateException unused) {
                this.IlIllIlIIl.onOperationDone(false);
                int i = IIIIIIIIII.llIIlIlIIl;
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IlIllIlIIl extends CameraCaptureSession.CaptureCallback {
        IlIllIlIIl() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            Log.m2713v(lllIIlIIlI.this, "Capture completed", new Object[0]);
            lllIIlIIlI.this.IllIIIIllI.llIIlIlIIl(totalCaptureResult);
            com.microblink.blinkid.secured.llIIIlllll lliiilllll = lllIIlIIlI.this.llIIlIIlll;
            lllIIlIIlI llliiliili = lllIIlIIlI.this;
            if (lliiilllll.llIIlIlIIl(totalCaptureResult, llliiliili.lllIIIlIlI, llliiliili.lIlIIIIlIl)) {
                lllIIlIIlI.IllIIlIIII(lllIIlIIlI.this);
            }
            if (Log.getCurrentLogLevel().ordinal() < Log.LogLevel.LOG_VERBOSE.ordinal()) {
                return;
            }
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    Log.m2713v(lllIIlIIlI.class, "AE inactive", new Object[0]);
                } else if (iIntValue == 1) {
                    Log.m2713v(lllIIlIIlI.class, "AE searching", new Object[0]);
                } else if (iIntValue == 2) {
                    Log.m2713v(lllIIlIIlI.class, "AE converged", new Object[0]);
                } else if (iIntValue == 3) {
                    Log.m2713v(lllIIlIIlI.class, "AE locked", new Object[0]);
                } else if (iIntValue == 4) {
                    Log.m2713v(lllIIlIIlI.class, "AE flash required", new Object[0]);
                } else if (iIntValue == 5) {
                    Log.m2713v(lllIIlIIlI.class, "AE precapture", new Object[0]);
                }
            } else {
                Log.m2713v(lllIIlIIlI.class, "AE null", new Object[0]);
            }
            Log.m2713v(lllIIlIIlI.class, "ISO: {}", totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY));
            Log.m2713v(lllIIlIIlI.class, "Exposure time: {}", totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME));
            Log.m2713v(lllIIlIIlI.class, "Frame duration: {}", totalCaptureResult.get(CaptureResult.SENSOR_FRAME_DURATION));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
            Log.m2713v(lllIIlIIlI.this, "Capture started", new Object[0]);
            if (lllIIlIIlI.this.IlIlIlIIlI.compareAndSet(false, true)) {
                lllIIlIIlI.this.IlIllIlllI.llIIlIlIIl();
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIIllI implements Runnable {
        IllIIIIllI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                lllIIlIIlI.this.IlIlllllII();
            } catch (Throwable th) {
                lllIIlIIlI.this.IIIIIIIIII.IllIIIllII();
                lllIIlIIlI.this.IlIllIlllI.llIIlIlIIl(th);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class IllIIIllII implements IlllIIIllI.llIIIlllll {
        IllIIIllII() {
        }
    }

    /* JADX INFO: compiled from: line */
    class lIIIIIllll implements Runnable {
        lIIIIIllll() {
        }

        @Override // java.lang.Runnable
        public void run() {
            lllIIlIIlI llliiliili = lllIIlIIlI.this;
            if (llliiliili.llIIlIlIIl != null) {
                Log.m2711i(llliiliili, "Pausing accelerometer", new Object[0]);
                lllIIlIIlI.this.llIIlIlIIl.llIIIlllll();
            }
            if (lllIIlIIlI.this.IIIIIIIIII.IIlIIIllIl()) {
                if (lllIIlIIlI.this.lIIIIIlIlI != null) {
                    Log.m2711i(lllIIlIIlI.this, "Closing preview session", new Object[0]);
                    lllIIlIIlI.this.lIIIIIlIlI.close();
                    lllIIlIIlI.this.lIIIIIlIlI = null;
                }
                lllIIlIIlI.this.IlIllIlllI.IlIllIlIIl();
                lllIIlIIlI.this.llIIlIIIll.IllIIIllII();
                lllIIlIIlI.this.llIllIIlll.IllIIIllII();
                Log.m2711i(lllIIlIIlI.this, "Closing camera device", new Object[0]);
                lllIIlIIlI.this.IIIIIIIIII.llIIIlllll();
                Log.m2711i(lllIIlIIlI.this, "Closed", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class lIlIIIIlIl implements IIlIlllIIl.IlIllIlIIl {
        lIlIIIIlIl() {
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIIlllll implements Runnable {
        llIIIlllll() {
        }

        @Override // java.lang.Runnable
        public void run() {
            lllIIlIIlI llliiliili = lllIIlIIlI.this;
            llliiliili.llIIlIlIIl = null;
            llliiliili.IlIllIlIIl = null;
            lllIIlIIlI.llIIlIlIIl(llliiliili, (IIIIIlIIII) null);
            lllIIlIIlI.llIIlIlIIl(lllIIlIIlI.this, (lIlIllIIlI) null);
            lllIIlIIlI.this.llIIlIIIll.llIIlIlIIl();
            lllIIlIIlI.this.llIllIIlll.llIIlIlIIl();
            lllIIlIIlI.this.lIlllIlIlI.IlIllIlIIl();
            lllIIlIIlI.llIIlIlIIl(lllIIlIIlI.this, (lIIlIIlIll) null);
        }
    }

    /* JADX INFO: compiled from: line */
    class llIIlIIlll implements Runnable {
        llIIlIIlll() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lllIIlIIlI.this.IlIlllllII == null || lllIIlIIlI.this.lIIIIIlIlI == null || lllIIlIIlI.this.lIlllIlIlI == null || !lllIIlIIlI.this.lllIIlIIlI) {
                Log.m2715w(lllIIlIIlI.this, "Cannot trigger autofocus. Camera session is closed!", new Object[0]);
                return;
            }
            Log.m2707d(lllIIlIIlI.this, "Triggering autofocus", new Object[0]);
            IIllllllll iIllllllll = lllIIlIIlI.this.IlIllIlIIl;
            if (iIllllllll == null || !iIllllllll.IllIIlIIII()) {
                lllIIlIIlI.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_MODE, 1);
            } else {
                lllIIlIIlI.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_MODE, 2);
            }
            try {
                lllIIlIIlI.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                lllIIlIIlI.this.llIIlIIIll();
                lllIIlIIlI.this.llIIlIIlll.llIIlIlIIl(false);
                lllIIlIIlI.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                lllIIlIIlI.this.lIIIIIlIlI.capture(lllIIlIIlI.this.IlIlllllII.build(), lllIIlIIlI.this.IIlIlllIIl, lllIIlIIlI.this.lIlllIlIlI.llIIlIlIIl());
                lllIIlIIlI.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            } catch (Exception unused) {
                lllIIlIIlI.this.lllIIIlIlI.onAutofocusFailed();
            }
        }
    }

    /* JADX INFO: compiled from: line */
    class lllIIIlIlI implements Runnable {
        lllIIIlIlI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (lllIIlIIlI.this.lIIIIIlIlI == null || lllIIlIIlI.this.IlIlllllII == null) {
                return;
            }
            try {
                lllIIlIIlI.this.llIIlIIIll();
            } catch (CameraAccessException e) {
                Log.m2716w(this, e, "Failed to set capture request with new parameters", new Object[0]);
            } catch (IllegalStateException e2) {
                Log.m2716w(this, e2, "Failed to set capture request with new parameters - capture session is already closed", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: line */
    private class lllIlIlIIl implements ShakeCallback {
        private lllIlIlIIl() {
        }

        @Override // com.microblink.hardware.accelerometer.ShakeCallback
        public void onShakingStarted() {
            Log.m2713v(this, "Shaking started", new Object[0]);
            lllIIlIIlI.this.IllIIlIIII.onShakingStarted();
            lllIIlIIlI.this.lllIlIlIIl.onShakingStarted();
        }

        @Override // com.microblink.hardware.accelerometer.ShakeCallback
        public void onShakingStopped() {
            Log.m2713v(this, "Shaking stopped", new Object[0]);
            lllIIlIIlI.this.IllIIlIIII.onShakingStopped();
            lllIIlIIlI.this.lllIlIlIIl.onShakingStopped();
            IIllllllll iIllllllll = lllIIlIIlI.this.IlIllIlIIl;
            if (iIllllllll == null || !iIllllllll.lllIIIlIlI()) {
                return;
            }
            lllIIlIIlI.this.lIIIIIllll();
        }

        /* synthetic */ lllIlIlIIl(lllIIlIIlI llliiliili, IllIIIllII illIIIllII) {
            this();
        }
    }

    public lllIIlIIlI(Context context, com.microblink.blinkid.secured.llIIlIlIIl lliililiil, llIlIlIlIl llilililil, IIllllllll iIllllllll) {
        IllIIIllII illIIIllII = null;
        this.llIIlIlIIl = null;
        this.IlIllIlIIl = null;
        this.lllIIIlIlI = null;
        this.llIIlIlIIl = lliililiil;
        this.lllIIIlIlI = llilililil;
        this.IlIllIlIIl = iIllllllll;
        this.IllIIlIIII = iIllllllll.llIIlIIlll();
        if (this.llIIlIlIIl == null) {
            throw new NullPointerException("Camera manager requires accelerometer manager and camera strategy factory to be non-null");
        }
        if (this.lllIIIlIlI == null) {
            throw new NullPointerException("Camera delegate can't be null.");
        }
        if (this.IlIllIlIIl == null) {
            this.IlIllIlIIl = new IIllllllll();
        }
        this.llIIlIlIIl.llIIlIlIIl(new lllIlIlIIl(this, illIIIllII));
        lIIlIIlIll liiliilill = new lIIlIIlIll(IIllIllIIl.llIIlIlIIl("Camera2Control ").append(hashCode()).toString());
        this.lIlllIlIlI = liiliilill;
        liiliilill.start();
        this.lIllIIlIIl = new lIIllIIIll();
        this.IIIIIIIIII = new IIlIlllIIl(context, this.lIlllIlIlI);
        this.IllIIIIllI = new IlIlIIlllI();
        lIlIllIIlI lililliili = this.IllIIIllII;
        this.lIlIIIIlIl = new llIlllIIIl(lililliili);
        this.llIIlIIlll = new com.microblink.blinkid.secured.llIIIlllll();
        this.IIlIIIllIl = new llllIIIllI();
        this.lIIIIIllll = new IIlIlIIlll(lililliili);
        this.llIIlIIIll = IllIIlIIII();
        this.llIllIIlll = lllIlIlIIl();
        this.llIIIlllll = new IlllIIIllI(this.lIlllIlIlI, new IllIIIllII());
    }

    static void IllIIlIIII(lllIIlIIlI llliiliili) {
        llliiliili.getClass();
        try {
            llliiliili.IlIlllllII.set(CaptureRequest.CONTROL_AF_MODE, 4);
            llliiliili.llIIlIIIll();
            llliiliili.llIIlIIlll.llIIlIlIIl(true);
        } catch (Exception e) {
            Log.m2716w(llliiliili, e, "Failed to resume continuous autofocus", new Object[0]);
        }
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void dispose() {
        if (this.IlllIIIllI) {
            return;
        }
        this.IlllIIIllI = true;
        this.lIlllIlIlI.llIIlIlIIl(new llIIIlllll());
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements IlllllIIll.IllIIIllII {
        llIIlIlIIl() {
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public boolean IlIllIlIIl() {
            com.microblink.blinkid.secured.llIIlIlIIl lliililiil = lllIIlIIlI.this.llIIlIlIIl;
            return lliililiil == null || lliililiil.IlIllIlIIl();
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public void IllIIIllII() {
            if (lllIIlIIlI.this.IIIIIIIIII.lIIIIIllll()) {
                return;
            }
            lllIIlIIlI llliiliili = lllIIlIIlI.this;
            llliiliili.llIIlIlIIl(llliiliili.IlIIlllIIl);
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public boolean canReceiveFrame() {
            llIlIlIlIl llilililil = lllIIlIIlI.this.lllIIIlIlI;
            return llilililil != null && llilililil.canReceiveFrame();
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public void llIIlIlIIl(IIllIllIII iIllIllIII) {
            llIlIlIlIl llilililil = lllIIlIIlI.this.lllIIIlIlI;
            if (llilililil != null) {
                llilililil.onCameraFrame(iIllIllIII);
            }
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public boolean llIIlIlIIl() {
            return lllIIlIIlI.this.llIIlIIlll.IlIllIlIIl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlIIlllIIl() {
        if (!this.IIIIIIIIII.IlIllIlIIl() || this.lIIIIIlIlI == null) {
            return;
        }
        try {
            this.IlIlllllII.set(CaptureRequest.CONTROL_MODE, 1);
            this.llIIlIIlll.llIIlIlIIl(this.IlIlllllII);
            this.IlIlllllII.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.IlIlllllII.set(CaptureRequest.CONTROL_AWB_MODE, 1);
            this.IIlIIIllIl.llIIlIlIIl(this.IlIlllllII);
            if (this.IlIllIlIIl.IllIIlIIII() && this.IlIllIlIIl.llIIIlllll() == 0.0f) {
                this.IlIllIlIIl.llIIlIlIIl(0.2f);
            }
            this.lIlIIIIlIl.llIIlIlIIl(this.IlIlllllII, this.IlIllIlIIl.llIIIlllll());
            llIIlIIIll();
            com.microblink.blinkid.secured.llIIlIlIIl lliililiil = this.llIIlIlIIl;
            if (lliililiil != null) {
                lliililiil.IllIIIllII();
            }
            for (int i = 0; i < 3; i++) {
                llIIlIlIIl(this.IlIIlllIIl);
            }
        } catch (CameraAccessException e) {
            Log.m2710e(this, e, "Failed to start capturing frames", new Object[0]);
            this.IlIllIlllI.llIIlIlIIl(e);
        } catch (IllegalStateException e2) {
            Log.wtf(this, e2, "Camera session was just created and is already invalid?!?", new Object[0]);
            this.IlIllIlllI.llIIlIlIIl(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlIlllllII() {
        if (!this.IIIIIIIIII.lllIIIlIlI()) {
            Log.m2711i(this, "Camera is already being opened.", new Object[0]);
            return;
        }
        try {
            CameraCharacteristics cameraCharacteristicsLlIIlIlIIl = this.IIIIIIIIII.llIIlIlIIl(this.IlIllIlIIl.IlIllIlIIl(), this.IlIllIlllI, new lIlIIIIlIl());
            if (cameraCharacteristicsLlIIlIlIIl == null) {
                return;
            }
            this.llIIlIIlll.llIIlIlIIl(cameraCharacteristicsLlIIlIlIIl, this.IllIIIllII);
            if (!this.llIIlIIlll.llIIlIlIIl() && this.IlIllIlIIl.lllIlIlIIl()) {
                throw new AutoFocusRequiredButNotSupportedException("Autofocus is required, but not supported on this device");
            }
            this.IIlIIIllIl.llIIlIlIIl(cameraCharacteristicsLlIIlIlIIl);
            this.lIlIIIIlIl.llIIlIlIIl(cameraCharacteristicsLlIIlIlIIl);
            this.IllIIIIllI.llIIlIlIIl(cameraCharacteristicsLlIIlIlIIl);
            this.lIIIIIllll.llIIlIlIIl(cameraCharacteristicsLlIIlIlIIl, this.IlIllIlIIl);
            Size sizeIllIIIllII = this.lIIIIIllll.IllIIIllII();
            this.IlIllIlllI.llIIlIlIIl(sizeIllIIIllII.getWidth(), sizeIllIIIllII.getHeight());
            this.llIIIlllll.llIIlIlIIl(this.lIIIIIllll.llIIIlllll(), this.lIllIIlIIl);
        } catch (CameraAccessException e) {
            this.IlIllIlllI.llIIlIlIIl(e);
        } catch (NullPointerException e2) {
            int i = lIlIllIIlI.lIlIIIIlIl;
            Log.m2710e(this, e2, "Camera2 API not supported on this device: {}", new IlllllIIIl(Build.DEVICE, Build.MODEL));
            this.IlIllIlllI.llIIlIlIIl(e2);
        } catch (SecurityException e3) {
            Log.m2710e(this, e3, "User has not granted permission to use camera!", new Object[0]);
            this.IlIllIlllI.llIIlIlIIl(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lIIIIIlIlI() {
        if (this.IlIIIIIlll) {
            Log.m2711i(this, "Preview is already starting... Ignoring this call...", new Object[0]);
            return;
        }
        if (!this.IIIIIIIIII.IIlIIIllIl() || !this.llIIIlllll.llIIIlllll()) {
            Log.m2715w(this, "Cannot start preview. CameraDevice: {}, surface ready: {}, PreviewSize: {}", Boolean.valueOf(this.IIIIIIIIII.IIlIIIllIl()), Boolean.valueOf(this.llIIIlllll.llIIIlllll()), this.lIIIIIllll.IllIIIllII());
            return;
        }
        try {
            this.IlIIIIIlll = true;
            Surface surfaceIllIIIllII = this.llIIIlllll.IllIIIllII();
            this.llIIlIIIll.IlIllIlIIl(this.lIIIIIllll, 3, this.IlIllIlIIl.llIIlIlIIl());
            if (this.IlIllIlIIl.lIIIIIllll()) {
                this.llIllIIlll.llIIlIlIIl(this.lIIIIIllll, this.IlIllIlIIl.IllIIIllII(), this.IlIllIlIIl.llIIlIlIIl());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(surfaceIllIIIllII);
            Surface surfaceIlIllIlIIl = this.llIIlIIIll.IlIllIlIIl();
            if (surfaceIlIllIlIIl != null) {
                arrayList.add(surfaceIlIllIlIIl);
            }
            Surface surfaceIlIllIlIIl2 = this.llIllIIlll.IlIllIlIIl();
            if (surfaceIlIllIlIIl2 != null) {
                arrayList.add(surfaceIlIllIlIIl2);
            }
            CaptureRequest.Builder builderIllIIIIllI = this.IIIIIIIIII.IllIIIIllI();
            this.IlIlllllII = builderIllIIIIllI;
            builderIllIIIIllI.addTarget(surfaceIllIIIllII);
            this.lllIIlIIlI = false;
            this.IIIIIIIIII.llIIlIlIIl(arrayList, new IlIIlIIIII(this));
        } catch (CameraAccessException e) {
            this.IlIIIIIlll = false;
            this.IlIllIlllI.llIIlIlIIl(e);
        } catch (IllegalStateException e2) {
            this.IlIIIIIlll = false;
            this.IlIllIlllI.llIIlIlIIl(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIIIll() throws CameraAccessException {
        Surface surfaceIlIllIlIIl = this.llIIlIIIll.IlIllIlIIl();
        if (surfaceIlIllIlIIl != null) {
            this.IlIlllllII.addTarget(surfaceIlIllIlIIl);
            this.IlIIlllIIl = this.IlIlllllII.build();
            this.IlIlllllII.removeTarget(surfaceIlIllIlIIl);
        }
        Surface surfaceIlIllIlIIl2 = this.llIllIIlll.IlIllIlIIl();
        if (surfaceIlIllIlIIl2 != null) {
            this.IlIlllllII.addTarget(surfaceIlIllIlIIl2);
            this.lllllIlIll = this.IlIlllllII.build();
            this.IlIlllllII.removeTarget(surfaceIlIllIlIIl2);
        }
        this.lIIIIIlIlI.setRepeatingRequest(this.IlIlllllII.build(), this.IIlIlllIIl, this.lIlllIlIlI.llIIlIlIIl());
    }

    private IlllllIIll lllIlIlIIl() {
        return new IlllllIIll(IIIllIIlIl.INSTANCE.IlIllIlIIl(), new IlIllIlllI());
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void IIlIIIllIl() {
        llIIlIlIIl(this.lllllIlIll);
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public boolean IlIllIlllI() {
        return this.IllIIIIllI.llIIlIlIIl();
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public IIllIlIIII IllIIIIllI() {
        return this.llIIIlllll;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public int IllIIIllII() {
        return this.IIIIIIIIII.lIlIIIIlIl();
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void lIIIIIllll() {
        lIIlIIlIll liiliilill;
        if (!this.llIIlIIlll.llIIlIlIIl()) {
            Log.m2715w(this, "Autofocus not supported, unable to trigger it", new Object[0]);
        } else if (this.IlIlllllII == null || this.lIIIIIlIlI == null || (liiliilill = this.lIlllIlIlI) == null) {
            Log.m2715w(this, "Cannot trigger autofocus. Camera session is closed!", new Object[0]);
        } else {
            liiliilill.llIIlIlIIl(new llIIlIIlll());
        }
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public CameraType lIlIIIIlIl() {
        return this.IIIIIIIIII.llIIlIIlll();
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public boolean llIIIlllll() {
        return this.IIIIIIIIII.llIIlIlIIl();
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public Boolean llIIlIIlll() {
        if (this.IlIlIlIIlI.get()) {
            return Boolean.valueOf(this.llIIlIIlll.llIIlIlIIl());
        }
        return null;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void lllIIIlIlI() {
        if (!this.IlIIlIIIII) {
            Log.m2711i(this, "Stop preview has already been called. Ignoring this call!", new Object[0]);
            return;
        }
        this.IlIIlIIIII = false;
        this.IIIIIIIIII.IlIllIlllI();
        Log.m2711i(this, "Camera2Manager.stopPreview", new Object[0]);
        this.lIlllIlIlI.llIIlIlIIl(new lIIIIIllll());
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public boolean IlIllIlIIl() {
        return this.llIIlIlIIl.IlIllIlIIl();
    }

    /* JADX INFO: compiled from: line */
    class IlIllIlllI implements IlllllIIll.IllIIIllII {
        IlIllIlllI() {
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public boolean IlIllIlIIl() {
            com.microblink.blinkid.secured.llIIlIlIIl lliililiil = lllIIlIIlI.this.llIIlIlIIl;
            return lliililiil != null && lliililiil.IlIllIlIIl();
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public void IllIIIllII() {
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public boolean canReceiveFrame() {
            return true;
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public void llIIlIlIIl(IIllIllIII iIllIllIII) {
            llIlIlIlIl llilililil = lllIIlIIlI.this.lllIIIlIlI;
            if (llilililil != null) {
                llilililil.onHighResFrame(iIllIllIII);
            }
            ((com.microblink.blinkid.secured.IIlIIIllIl) iIllIllIII).IllIIIllII();
        }

        @Override // com.microblink.blinkid.secured.IlllllIIll.IllIIIllII
        public boolean llIIlIlIIl() {
            return lllIIlIIlI.this.llIIlIIlll.IlIllIlIIl();
        }
    }

    static /* synthetic */ IIIIIlIIII llIIlIlIIl(lllIIlIIlI llliiliili, IIIIIlIIII iIIIIlIIII) {
        llliiliili.lIllIIlIIl = null;
        return null;
    }

    static /* synthetic */ lIlIllIIlI llIIlIlIIl(lllIIlIIlI llliiliili, lIlIllIIlI lililliili) {
        llliiliili.IllIIIllII = null;
        return null;
    }

    static /* synthetic */ lIIlIIlIll llIIlIlIIl(lllIIlIIlI llliiliili, lIIlIIlIll liiliilill) {
        llliiliili.lIlllIlIlI = null;
        return null;
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(ShakeCallback shakeCallback) {
        if (shakeCallback == null) {
            this.lllIlIlIIl = ShakeCallback.EMPTY;
        } else {
            this.lllIlIlIIl = shakeCallback;
        }
    }

    private IlllllIIll IllIIlIIII() {
        return new IlllllIIll(IIIllIIlIl.INSTANCE.llIIlIlIIl(), new llIIlIlIIl());
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(float f) {
        CaptureRequest.Builder builder = this.IlIlllllII;
        if (builder == null || this.lIIIIIlIlI == null) {
            return;
        }
        this.lIlIIIIlIl.llIIlIlIIl(builder, f);
        llIIlIlIIl(this.lIlIIIIlIl.llIIlIlIIl());
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(Context context, IIllllllll iIllllllll, llllllllll.llIIlIlIIl lliililiil) {
        if (this.IlIIlIIIII) {
            Log.m2711i(this, "Start preview has already been called. Ignoring this call!", new Object[0]);
            return;
        }
        this.llIIlIIIll.llIIlIlIIl();
        this.llIllIIlll.llIIlIlIIl();
        Log.m2711i(this, "Camera2Manager.startPreview", new Object[0]);
        this.IlIIlIIIII = true;
        this.IlIllIlllI = lliililiil;
        this.IlIllIlIIl = iIllllllll;
        this.IlIlIlIIlI = new AtomicBoolean(false);
        this.llIIlIIIll.llIIIlllll();
        this.llIllIIlll.llIIIlllll();
        this.IlIIIIIlll = false;
        this.IllIIIIllI.IlIllIlIIl();
        this.llIIlIIlll.IllIIIllII();
        this.lIlllIlIlI.llIIlIlIIl(new IllIIIIllI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl(CaptureRequest captureRequest) {
        try {
            CameraCaptureSession cameraCaptureSession = this.lIIIIIlIlI;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.capture(captureRequest, null, this.lIlllIlIlI.llIIlIlIIl());
            } else {
                Log.m2713v(this, "Session is already closed. Cannot capture another frame.", new Object[0]);
            }
        } catch (Exception e) {
            Log.m2710e(this, e, "Failed to capture frame", new Object[0]);
        }
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(boolean z, SuccessCallback successCallback) {
        if (this.IlIlllllII == null || this.lIIIIIlIlI == null) {
            return;
        }
        this.lIlllIlIlI.llIIlIlIIl(new IIlIIIllIl(z, successCallback));
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public boolean llIIlIlIIl() {
        return this.llIIlIIlll.IlIllIlIIl();
    }

    @Override // com.microblink.blinkid.secured.llllllllll
    public void llIIlIlIIl(Rect[] rectArr) {
        if (this.IlIlllllII == null || this.lIIIIIlIlI == null || this.IllIIIllII.lllllIlIll()) {
            return;
        }
        this.lIlIIIIlIl.llIIlIlIIl(this.IlIlllllII, rectArr);
        this.lIlllIlIlI.llIIlIlIIl(new lllIIIlIlI());
    }
}
