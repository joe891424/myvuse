package com.microblink.blinkid.secured;

import android.graphics.Rect;
import android.hardware.Camera;
import com.microblink.hardware.camera.AutofocusListener;
import com.microblink.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IllIIIllII implements IIIIIllIll {
    protected volatile boolean IllIIIllII;
    private lIlIllIIlI lIIIIIllll;
    private AutofocusListener llIIlIIlll;
    protected Camera llIIlIlIIl;
    protected volatile boolean IlIllIlIIl = false;
    protected Timer llIIIlllll = null;
    private volatile boolean IllIIIIllI = false;
    private int lIlIIIIlIl = 0;
    private Rect[] IIlIIIllIl = null;
    private volatile int lllIIIlIlI = 0;
    private final Camera.AutoFocusCallback IlIllIlllI = new llIIlIlIIl();

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Camera.AutoFocusCallback {
        llIIlIlIIl() {
        }

        private void llIIlIlIIl(String str) {
            Camera camera = IllIIIllII.this.llIIlIlIIl;
            if (camera == null) {
                return;
            }
            try {
                Camera.Parameters parameters = camera.getParameters();
                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                String focusMode = parameters.getFocusMode();
                if (supportedFocusModes == null || !supportedFocusModes.contains(str) || str.equals(focusMode)) {
                    return;
                }
                parameters.setFocusMode(str);
                Log.m2707d(IllIIIllII.this, "Setting focus mode to {}", str);
                try {
                    IllIIIllII.this.llIIlIlIIl.setParameters(parameters);
                } catch (RuntimeException e) {
                    Log.m2710e(IllIIIllII.this, e, "Setting new camera parameters failed!", new Object[0]);
                }
            } catch (RuntimeException e2) {
                Log.m2716w(this, e2, "Failed to get camera parameters! Cannot set focus mode!", new Object[0]);
            }
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Camera camera2;
            if (IllIIIllII.this.llIIlIIlll != null) {
                IllIIIllII.this.llIIlIIlll.onAutofocusStopped(IllIIIllII.this.IIlIIIllIl);
            }
            IllIIIllII.this.IllIIIllII = false;
            IllIIIllII.llIIIlllll(IllIIIllII.this);
            Log.m2711i(IllIIIllII.this, "Autofocus request ended with {}. Request count: {}", Boolean.valueOf(z), Integer.valueOf(IllIIIllII.this.lllIIIlIlI));
            if (IllIIIllII.this.lIIIIIllll.IlIIlllIIl()) {
                Log.m2711i(IllIIIllII.this, "This is a device with untrusty focus. We will assume that focus has succeeded!", new Object[0]);
                z = true;
            }
            IllIIIllII.this.IlIllIlIIl = z;
            int i = IIIIIIIIII.llIIlIlIIl;
            boolean z2 = IllIIIllII.this.IlIllIlIIl;
            int unused = IllIIIllII.this.lIlIIIIlIl;
            if (z) {
                IllIIIllII.IlIllIlIIl(IllIIIllII.this, 3000);
                IllIIIllII.this.lIlIIIIlIl = 0;
                return;
            }
            if (IllIIIllII.this.IllIIIIllI) {
                return;
            }
            IllIIIllII.llIIlIIlll(IllIIIllII.this);
            if (IllIIIllII.this.lIlIIIIlIl % 2 == 0 && (camera2 = IllIIIllII.this.llIIlIlIIl) != null) {
                try {
                    String focusMode = camera2.getParameters().getFocusMode();
                    if ("macro".equals(focusMode)) {
                        llIIlIlIIl("auto");
                    } else if ("auto".equals(focusMode)) {
                        llIIlIlIIl("macro");
                    }
                } catch (RuntimeException e) {
                    Log.m2716w(this, e, "Failed to get camera parameters. Cannot toggle autofocus mode!", new Object[0]);
                    int i2 = IIIIIIIIII.llIIlIlIIl;
                }
            }
            if (IllIIIllII.this.lIlIIIIlIl == 4 && IllIIIllII.this.llIIlIIlll != null) {
                IllIIIllII.this.llIIlIIlll.onAutofocusFailed();
            }
            IllIIIllII.IlIllIlIIl(IllIIIllII.this, 500);
        }
    }

    public IllIIIllII(AutofocusListener autofocusListener, lIlIllIIlI lililliili) {
        this.llIIlIIlll = autofocusListener;
        this.lIIIIIllll = lililliili;
        if (!lililliili.lIIIIIlIlI()) {
            throw new IllegalArgumentException("Device manager needs to have device lists loaded");
        }
    }

    static /* synthetic */ int llIIIlllll(IllIIIllII illIIIllII) {
        int i = illIIIllII.lllIIIlIlI;
        illIIIllII.lllIIIlIlI = i - 1;
        return i;
    }

    static /* synthetic */ int llIIlIIlll(IllIIIllII illIIIllII) {
        int i = illIIIllII.lIlIIIIlIl;
        illIIIllII.lIlIIIIlIl = i + 1;
        return i;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void dispose() {
        this.llIIlIlIIl = null;
        Timer timer = this.llIIIlllll;
        if (timer != null) {
            timer.cancel();
        }
        this.llIIIlllll = null;
        this.llIIlIIlll = null;
        this.IIlIIIllIl = null;
        this.lIIIIIllll = null;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void lIIIIIllll() {
        Log.m2713v(this, "invalidating focus", new Object[0]);
        this.IlIllIlIIl = false;
        Timer timer = this.llIIIlllll;
        if (timer != null) {
            timer.cancel();
        }
        this.llIIIlllll = null;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public boolean lIlIIIIlIl() {
        return false;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public boolean llIIlIlIIl() {
        return true;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void IIlIIIllIl() {
        this.IllIIIIllI = false;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public boolean IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void IllIIIIllI() {
        llIIlIlIIl(false);
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void IllIIIllII() {
        if (this.llIIlIlIIl == null || !this.IllIIIllII) {
            return;
        }
        try {
            this.llIIlIlIIl.cancelAutoFocus();
        } catch (RuntimeException e) {
            Log.m2716w(this, e, "There has been error in cancelling autofocus cycle. This probably a bug in device", new Object[0]);
            int i = IIIIIIIIII.llIIlIlIIl;
        }
        this.IllIIIllII = false;
        this.lllIIIlIlI--;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void llIIIlllll() {
        this.IllIIIIllI = true;
        this.IlIllIlIIl = false;
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public boolean llIIlIIlll() {
        return this.IllIIIllII;
    }

    static void IlIllIlIIl(IllIIIllII illIIIllII, int i) {
        Timer timer = illIIIllII.llIIIlllll;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        illIIIllII.llIIIlllll = timer2;
        timer2.schedule(new IlIllIlIIl(illIIIllII), 3000L);
        Log.m2713v(illIIIllII, "focus timer set", new Object[0]);
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void llIIlIlIIl(Camera camera) {
        this.llIIlIlIIl = camera;
        this.IllIIIllII = false;
        Timer timer = this.llIIIlllll;
        if (timer != null) {
            timer.cancel();
            this.llIIIlllll = null;
        }
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void llIIlIlIIl(boolean z) {
        if (this.llIIlIlIIl == null || this.IlIllIlllI == null || this.IllIIIIllI) {
            return;
        }
        if (!this.IlIllIlIIl || z) {
            if (this.IllIIIllII) {
                Log.m2713v(this, "Autofocus is in progress...", new Object[0]);
                return;
            }
            try {
                this.IllIIIllII = true;
                Timer timer = this.llIIIlllll;
                if (timer != null) {
                    timer.cancel();
                    this.llIIIlllll = null;
                }
                Log.m2707d(this, "requesting autofocus...", new Object[0]);
                this.lllIIIlIlI++;
                Log.m2711i(this, "Requests count: {}", Integer.valueOf(this.lllIIIlIlI));
                AutofocusListener autofocusListener = this.llIIlIIlll;
                if (autofocusListener != null) {
                    autofocusListener.onAutofocusStarted(this.IIlIIIllIl);
                }
                this.llIIlIlIIl.autoFocus(this.IlIllIlllI);
                Log.m2707d(this, "request issued", new Object[0]);
            } catch (RuntimeException e) {
                Log.m2716w(this, e, "Autofocus call failed!", new Object[0]);
                this.IlIllIlllI.onAutoFocus(false, this.llIIlIlIIl);
                int i = IIIIIIIIII.llIIlIlIIl;
            }
        }
    }

    @Override // com.microblink.blinkid.secured.IIIIIllIll
    public void llIIlIlIIl(Rect[] rectArr) {
        Camera camera = this.llIIlIlIIl;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (rectArr == null) {
                    parameters.setMeteringAreas(null);
                    parameters.setFocusAreas(null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < parameters.getMaxNumFocusAreas() && i < rectArr.length; i++) {
                        Log.m2707d(this, "Adding focus area {}", rectArr[i]);
                        arrayList.add(new Camera.Area(rectArr[i], 1000));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < parameters.getMaxNumMeteringAreas() && i2 < rectArr.length; i2++) {
                        Log.m2707d(this, "Adding metering area {}", rectArr[i2]);
                        arrayList2.add(new Camera.Area(rectArr[i2], 1000));
                    }
                    parameters.setMeteringAreas(arrayList2);
                    parameters.setFocusAreas(arrayList);
                }
                try {
                    this.llIIlIlIIl.setParameters(parameters);
                    this.IIlIIIllIl = rectArr;
                    lIIIIIllll();
                    llIIlIlIIl(false);
                    return;
                } catch (RuntimeException unused) {
                    Log.m2709e(this, "Failed to apply new camera parameters!", new Object[0]);
                    int i3 = IIIIIIIIII.llIIlIlIIl;
                    return;
                }
            } catch (RuntimeException e) {
                Log.m2716w(this, e, "Failed to get camera parameters. Cannot set metering areas!", new Object[0]);
                int i4 = IIIIIIIIII.llIIlIlIIl;
                return;
            }
        }
        Log.m2715w(this, "Cannot set focus area, camera is null", new Object[0]);
    }
}
