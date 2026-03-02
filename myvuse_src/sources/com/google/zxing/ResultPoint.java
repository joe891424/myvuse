package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ResultPoint {

    /* JADX INFO: renamed from: x */
    private final float f3943x;

    /* JADX INFO: renamed from: y */
    private final float f3944y;

    public ResultPoint(float f, float f2) {
        this.f3943x = f;
        this.f3944y = f2;
    }

    public final float getX() {
        return this.f3943x;
    }

    public final float getY() {
        return this.f3944y;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f3943x == resultPoint.f3943x && this.f3944y == resultPoint.f3944y) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f3943x) * 31) + Float.floatToIntBits(this.f3944y);
    }

    public final String toString() {
        return "(" + this.f3943x + ',' + this.f3944y + ')';
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float fDistance = distance(resultPointArr[0], resultPointArr[1]);
        float fDistance2 = distance(resultPointArr[1], resultPointArr[2]);
        float fDistance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fDistance3 >= fDistance2 && fDistance3 >= fDistance) {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        } else {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f3943x, resultPoint.f3944y, resultPoint2.f3943x, resultPoint2.f3944y);
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f = resultPoint2.f3943x;
        float f2 = resultPoint2.f3944y;
        return ((resultPoint3.f3943x - f) * (resultPoint.f3944y - f2)) - ((resultPoint3.f3944y - f2) * (resultPoint.f3943x - f));
    }
}
