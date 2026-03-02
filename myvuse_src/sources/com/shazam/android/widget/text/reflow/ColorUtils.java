package com.shazam.android.widget.text.reflow;

/* JADX INFO: loaded from: classes6.dex */
public class ColorUtils {
    public static double[] colorToLAB(int i) {
        double[] dArr = new double[3];
        androidx.core.graphics.ColorUtils.colorToLAB(i, dArr);
        return dArr;
    }

    public static int labToColor(double[] dArr) {
        return androidx.core.graphics.ColorUtils.LABToColor(dArr[0], dArr[1], dArr[2]);
    }

    public static void blendLab(double[] dArr, double[] dArr2, float f, double[] dArr3) {
        androidx.core.graphics.ColorUtils.blendLAB(dArr, dArr2, f, dArr3);
    }
}
