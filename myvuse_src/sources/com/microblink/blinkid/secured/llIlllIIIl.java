package com.microblink.blinkid.secured;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llIlllIIIl {
    private lIlIllIIlI llIIlIlIIl;
    private Rect IlIllIlIIl = null;
    private Rect IllIIIllII = null;
    private float llIIIlllll = 0.0f;
    private Rect[] IllIIIIllI = null;
    private int lIlIIIIlIl = 0;
    private int llIIlIIlll = 0;
    private int IIlIIIllIl = 0;

    llIlllIIIl(lIlIllIIlI lililliili) {
        this.llIIlIlIIl = lililliili;
    }

    void llIIlIlIIl(CameraCharacteristics cameraCharacteristics) {
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        this.IllIIIllII = rect;
        if (rect == null) {
            throw new RuntimeException("Unable to obtain sensor active array size. This is a bug in device!");
        }
        Log.m2711i(this, "Sensor active array size: {}x{}", Integer.valueOf(rect.width()), Integer.valueOf(this.IllIIIllII.height()));
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (num == null || num2 == null || num3 == null) {
            throw new RuntimeException("Unable to obtain max number of regions for AF, AE and AWB. This is a bug in device!");
        }
        this.lIlIIIIlIl = num.intValue();
        this.llIIlIIlll = num2.intValue();
        this.IIlIIIllIl = num3.intValue();
        Log.m2711i(this, "Max AF regions: {}, Max AE regions: {}, Max AWB regions: {}", Integer.valueOf(this.lIlIIIIlIl), Integer.valueOf(this.llIIlIIlll), Integer.valueOf(this.IIlIIIllIl));
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f == null) {
            throw new RuntimeException("Unable to obtain max digital zoom value. This is a bug in device!");
        }
        float fFloatValue = f.floatValue();
        this.llIIIlllll = fFloatValue;
        Log.m2711i(this, "Maximum digital zoom: {}", Float.valueOf(fFloatValue));
    }

    Rect[] llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    void llIIlIlIIl(CaptureRequest.Builder builder, Rect[] rectArr) {
        MeteringRectangle[] meteringRectangleArr;
        MeteringRectangle[] meteringRectangleArr2;
        MeteringRectangle[] meteringRectangleArr3;
        if (this.IlIllIlIIl == null) {
            return;
        }
        MeteringRectangle[] meteringRectangleArr4 = null;
        if (rectArr != null) {
            int length = this.lIlIIIIlIl;
            if (length > 0) {
                if (rectArr.length < length) {
                    length = rectArr.length;
                }
                meteringRectangleArr3 = new MeteringRectangle[length];
            } else {
                meteringRectangleArr3 = null;
            }
            int length2 = this.llIIlIIlll;
            if (length2 > 0) {
                if (rectArr.length < length2) {
                    length2 = rectArr.length;
                }
                meteringRectangleArr2 = new MeteringRectangle[length2];
            } else {
                meteringRectangleArr2 = null;
            }
            int length3 = this.IIlIIIllIl;
            if (length3 > 0) {
                if (rectArr.length < length3) {
                    length3 = rectArr.length;
                }
                meteringRectangleArr4 = new MeteringRectangle[length3];
            }
            for (int i = 0; i < rectArr.length; i++) {
                if (i < this.lIlIIIIlIl) {
                    meteringRectangleArr3[i] = new MeteringRectangle(llIIlIlIIl(rectArr[i]), 1000);
                }
                if (i < this.llIIlIIlll) {
                    meteringRectangleArr2[i] = new MeteringRectangle(llIIlIlIIl(rectArr[i]), 1000);
                }
                if (i < this.IIlIIIllIl) {
                    meteringRectangleArr4[i] = new MeteringRectangle(llIIlIlIIl(rectArr[i]), 1000);
                }
            }
            MeteringRectangle[] meteringRectangleArr5 = meteringRectangleArr3;
            meteringRectangleArr = meteringRectangleArr4;
            meteringRectangleArr4 = meteringRectangleArr5;
        } else {
            meteringRectangleArr = null;
            meteringRectangleArr2 = null;
        }
        if (meteringRectangleArr4 != null) {
            builder.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr4);
        } else if (this.lIlIIIIlIl > 0) {
            builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.IlIllIlIIl, 0)});
        }
        if (meteringRectangleArr2 != null) {
            builder.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        } else if (this.llIIlIIlll > 0) {
            builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.IlIllIlIIl, 0)});
        }
        if (meteringRectangleArr != null) {
            builder.set(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr);
        } else if (this.IIlIIIllIl > 0) {
            builder.set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.IlIllIlIIl, 0)});
        }
        this.IllIIIIllI = rectArr;
    }

    private Rect llIIlIlIIl(Rect rect) {
        float f = (rect.left + 1000) / 2000.0f;
        float f2 = (rect.right + 1000) / 2000.0f;
        float f3 = (rect.top + 1000) / 2000.0f;
        float f4 = (rect.bottom + 1000) / 2000.0f;
        int iRound = Math.round(f * r1.width()) + this.IlIllIlIIl.left;
        int iRound2 = Math.round(f2 * r1.width()) + this.IlIllIlIIl.left;
        return new Rect(iRound, Math.round(f3 * r2.height()) + this.IlIllIlIIl.top, iRound2, Math.round(f4 * r3.height()) + this.IlIllIlIIl.top);
    }

    void llIIlIlIIl(CaptureRequest.Builder builder, float f) {
        float fLlIIlIlIIl = this.llIIlIlIIl.llIIlIlIIl(f);
        if (fLlIIlIlIIl < 0.0f) {
            fLlIIlIlIIl = 0.0f;
        }
        if (fLlIIlIlIIl > 1.0f) {
            fLlIIlIlIIl = 1.0f;
        }
        float f2 = (((this.llIIIlllll - 1.0f) * fLlIIlIlIIl) + 1.0f) * 2.0f;
        int iRound = Math.round(this.IllIIIllII.width() / f2);
        int iRound2 = Math.round(this.IllIIIllII.height() / f2);
        int iWidth = this.IllIIIllII.width() / 2;
        int iHeight = this.IllIIIllII.height() / 2;
        Rect rect = new Rect(iWidth - iRound, iHeight - iRound2, iWidth + iRound, iHeight + iRound2);
        this.IlIllIlIIl = rect;
        builder.set(CaptureRequest.SCALER_CROP_REGION, rect);
    }
}
