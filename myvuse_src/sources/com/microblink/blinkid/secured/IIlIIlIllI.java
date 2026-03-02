package com.microblink.blinkid.secured;

import android.content.Context;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class IIlIIlIllI {
    public static final void IlIllIlIIl(float[] fArr, int i, float f, float f2) {
        if (i == 1) {
            float f3 = fArr[1];
            float f4 = f - fArr[0];
            fArr[0] = f3;
            fArr[1] = f4;
            return;
        }
        if (i == 8) {
            float f5 = f - fArr[0];
            float f6 = f2 - fArr[1];
            fArr[0] = f5;
            fArr[1] = f6;
            return;
        }
        if (i != 9) {
            return;
        }
        float f7 = f2 - fArr[1];
        float f8 = fArr[0];
        fArr[0] = f7;
        fArr[1] = f8;
    }

    public static final void llIIlIlIIl(RectF rectF) {
        if (rectF.left < 0.0f) {
            rectF.left = 0.0f;
        }
        if (rectF.left > 1.0f) {
            rectF.left = 1.0f;
        }
        if (rectF.top < 0.0f) {
            rectF.top = 0.0f;
        }
        if (rectF.top > 1.0f) {
            rectF.top = 1.0f;
        }
        if (rectF.right < 0.0f) {
            rectF.right = 0.0f;
        }
        if (rectF.right > 1.0f) {
            rectF.right = 1.0f;
        }
        if (rectF.bottom < 0.0f) {
            rectF.bottom = 0.0f;
        }
        if (rectF.bottom > 1.0f) {
            rectF.bottom = 1.0f;
        }
    }

    public static final void llIIlIlIIl(float[] fArr, int i, float f, float f2) {
        if (i == 1) {
            float f3 = f - fArr[1];
            float f4 = fArr[0];
            fArr[0] = f3;
            fArr[1] = f4;
            return;
        }
        if (i == 8) {
            float f5 = f - fArr[0];
            float f6 = f2 - fArr[1];
            fArr[0] = f5;
            fArr[1] = f6;
            return;
        }
        if (i != 9) {
            return;
        }
        float f7 = fArr[1];
        float f8 = f2 - fArr[0];
        fArr[0] = f7;
        fArr[1] = f8;
    }

    public static final void IlIllIlIIl(float[] fArr, float f, float f2) {
        fArr[0] = fArr[0] / f;
        fArr[1] = fArr[1] / f2;
    }

    public static final void llIIlIlIIl(float[] fArr, float f, float f2) {
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f2;
    }

    public static boolean llIIlIlIIl(Context context) {
        WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels < displayMetrics.heightPixels;
    }
}
