package com.microblink.blinkid.secured;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.microblink.hardware.SuccessCallback;
import com.microblink.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlIlIIlllI {
    private AtomicBoolean IllIIIllII;
    private AtomicInteger llIIIlllll;
    private boolean llIIlIlIIl = false;
    private AtomicReference<SuccessCallback> IlIllIlIIl = new AtomicReference<>(null);

    IlIlIIlllI() {
        IlIllIlIIl();
    }

    void IlIllIlIIl() {
        this.IllIIIllII = new AtomicBoolean(false);
        this.llIIIlllll = new AtomicInteger(0);
    }

    public boolean llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(CameraCharacteristics cameraCharacteristics) {
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null) {
            throw new RuntimeException("Unable to obtain information about LED torch availability. This is a bug in device!");
        }
        this.llIIlIlIIl = bool.booleanValue();
    }

    void llIIlIlIIl(boolean z, SuccessCallback successCallback) {
        this.IllIIIllII.set(z);
        this.IlIllIlIIl.set(successCallback);
        this.llIIIlllll.set(0);
    }

    void llIIlIlIIl(TotalCaptureResult totalCaptureResult) {
        if (this.IlIllIlIIl.get() == null) {
            return;
        }
        int iIncrementAndGet = this.llIIIlllll.incrementAndGet();
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
        Log.m2707d(this, "Torch state is {}", num);
        int i = IIIIIIIIII.llIIlIlIIl;
        if (num != null && num.intValue() != 2) {
            if (num.intValue() == 3) {
                if (this.IllIIIllII.get()) {
                    this.IlIllIlIIl.getAndSet(null).onOperationDone(true);
                    return;
                } else {
                    if (iIncrementAndGet > 30) {
                        SuccessCallback andSet = this.IlIllIlIIl.getAndSet(null);
                        this.IllIIIllII.set(false);
                        andSet.onOperationDone(false);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (!this.IllIIIllII.get()) {
            this.IlIllIlIIl.getAndSet(null).onOperationDone(true);
        } else if (iIncrementAndGet > 30) {
            SuccessCallback andSet2 = this.IlIllIlIIl.getAndSet(null);
            this.IllIIIllII.set(true);
            andSet2.onOperationDone(false);
        }
    }
}
