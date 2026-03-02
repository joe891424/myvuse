package com.microblink.blinkid.secured;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import com.microblink.blinkid.secured.llllllllll;
import com.microblink.hardware.camera.CameraType;
import com.microblink.util.Log;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IIlIlllIIl {
    private static Semaphore lIIIIIllll = new Semaphore(1);
    private IIIIIlIIII IlIllIlIIl;
    private llllllllll.llIIlIlIIl IllIIIIllI;
    private CameraManager IllIIIllII;
    private IlIllIlIIl lIlIIIIlIl;
    private CameraDevice llIIlIlIIl;
    private int llIIlIIlll = 1;
    private CameraDevice.StateCallback IIlIIIllIl = new llIIlIlIIl();
    private lIlIIIlIll llIIIlllll = new lIlIIIlIll();

    /* JADX INFO: compiled from: line */
    interface IlIllIlIIl {
    }

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl extends CameraDevice.StateCallback {
        llIIlIlIIl() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Log.m2707d(IIlIlllIIl.this, IIllIllIIl.llIIlIlIIl("Closing from disconnected ").append(IIlIlllIIl.this.hashCode()).toString(), new Object[0]);
            IIlIlllIIl.this.llIIIlllll();
            IIlIlllIIl.this.IllIIIIllI.llIIlIlIIl(new Exception("Camera has been disconnected!"));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            Log.m2707d(IIlIlllIIl.this, IIllIllIIl.llIIlIlIIl("Closing from error ").append(IIlIlllIIl.this.hashCode()).toString(), new Object[0]);
            IIlIlllIIl.this.llIIIlllll();
            IIlIlllIIl.this.IllIIIIllI.llIIlIlIIl(new Exception(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "Unknown camera error: " + i : "Camera service has encountered a fatal error. Please reboot the device!" : "Camera device has encountered a fatal error." : "Camera device could not be opened due to a device policy." : "Too many other open camera devices" : "Camera device is already in use."));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Log.m2707d(IIlIlllIIl.this, IIllIllIIl.llIIlIlIIl("OPENED ").append(IIlIlllIIl.this.hashCode()).toString(), new Object[0]);
            IIlIlllIIl.this.llIIlIlIIl = cameraDevice;
            if (IIlIlllIIl.this.llIIlIIlll == 4) {
                Log.m2707d(IIlIlllIIl.this, IIllIllIIl.llIIlIlIIl("Closing from on opened ").append(IIlIlllIIl.this.hashCode()).toString(), new Object[0]);
                IIlIlllIIl.this.llIIIlllll();
            } else {
                IIlIlllIIl.this.llIIlIlIIl(5);
                lllIIlIIlI.this.lIIIIIlIlI();
            }
        }
    }

    IIlIlllIIl(Context context, IIIIIlIIII iIIIIlIIII) {
        this.IlIllIlIIl = iIIIIlIIII;
        this.IllIIIllII = (CameraManager) context.getSystemService("camera");
    }

    boolean IIlIIIllIl() {
        return this.llIIlIlIIl != null;
    }

    void IlIllIlllI() {
        if (this.llIIlIIlll == 2) {
            llIIlIlIIl(4);
        } else {
            llIIlIlIIl(3);
        }
    }

    CaptureRequest.Builder IllIIIIllI() throws CameraAccessException {
        return this.llIIlIlIIl.createCaptureRequest(1);
    }

    boolean lIIIIIllll() {
        int i = this.llIIlIIlll;
        return i == 4 || i == 3;
    }

    public int lIlIIIIlIl() {
        return this.llIIIlllll.IllIIIllII();
    }

    void llIIIlllll() {
        Log.m2707d(this, IIllIllIIl.llIIlIlIIl("CLOSING ").append(hashCode()).toString(), new Object[0]);
        CameraDevice cameraDevice = this.llIIlIlIIl;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.llIIlIlIIl = null;
            llIIlIlIIl(1);
            Log.m2707d(this, IIllIllIIl.llIIlIlIIl("CLOSED ").append(hashCode()).toString(), new Object[0]);
            lIIIIIllll.release();
        }
    }

    CameraType llIIlIIlll() {
        return this.llIIIlllll.llIIIlllll();
    }

    boolean lllIIIlIlI() {
        if (this.llIIlIIlll != 1) {
            return false;
        }
        llIIlIlIIl(2);
        return true;
    }

    boolean IlIllIlIIl() {
        return IIlIIIllIl() && this.llIIlIIlll == 5;
    }

    void IllIIIllII() {
        this.llIIIlllll.IlIllIlIIl();
        llIIlIlIIl(1);
    }

    void llIIlIlIIl(List<Surface> list, CameraCaptureSession.StateCallback stateCallback) throws CameraAccessException {
        this.llIIlIlIIl.createCaptureSession(list, stateCallback, this.IlIllIlIIl.llIIlIlIIl());
    }

    CameraCharacteristics llIIlIlIIl(CameraType cameraType, llllllllll.llIIlIlIIl lliililiil, IlIllIlIIl ilIllIlIIl) throws CameraAccessException, SecurityException {
        this.IllIIIIllI = lliililiil;
        this.lIlIIIIlIl = ilIllIlIIl;
        String strLlIIlIlIIl = this.llIIIlllll.llIIlIlIIl(this.IllIIIllII, cameraType);
        if (strLlIIlIlIIl != null) {
            try {
                Log.m2707d(this, "WAIT TO OPEN " + hashCode(), new Object[0]);
                if (!lIIIIIllll.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                    return null;
                }
                Log.m2707d(this, "AQUIRED OPEN LOCK " + hashCode(), new Object[0]);
                this.IllIIIllII.openCamera(strLlIIlIlIIl, this.IIlIIIllIl, this.IlIllIlIIl.llIIlIlIIl());
                return this.IllIIIllII.getCameraCharacteristics(strLlIIlIlIIl);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while trying to lock camera opening.", e);
            }
        }
        throw new RuntimeException("Unable to select camera. External cameras are currently not supported.");
    }

    boolean llIIlIlIIl() {
        return this.llIIIlllll.llIIlIlIIl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl(int i) {
        Log.m2707d(this, "SState " + IIIllIlIIl.llIIlIlIIl(i) + " " + hashCode(), new Object[0]);
        this.llIIlIIlll = i;
    }
}
