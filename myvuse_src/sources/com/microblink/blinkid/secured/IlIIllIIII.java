package com.microblink.blinkid.secured;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.microblink.geometry.Point;
import com.microblink.geometry.Quadrilateral;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IlIIllIIII implements IllllIIlII {
    private float llIIlIlIIl = 0.3f;
    private int IlIllIlIIl = -1;
    private Paint IllIIIllII = new Paint(1);

    public IlIIllIIII(Context context) {
        this.IllIIIllII.setStrokeWidth((context.getResources().getDisplayMetrics().densityDpi + 49) / 50);
        this.IllIIIllII.setStrokeCap(Paint.Cap.ROUND);
        this.IllIIIllII.setStyle(Paint.Style.STROKE);
    }

    @Override // com.microblink.blinkid.secured.IllllIIlII
    public Paint llIIlIlIIl() {
        return this.IllIIIllII;
    }

    public void llIIlIlIIl(int i) {
        this.IlIllIlIIl = i;
    }

    public void llIIlIlIIl(float f) {
        this.llIIlIlIIl = f;
    }

    @Override // com.microblink.blinkid.secured.IllllIIlII
    public void llIIlIlIIl(Quadrilateral quadrilateral, Canvas canvas) {
        Point pointClamp;
        Point pointNormalize;
        Point pointNormalize2;
        Point pointNormalize3;
        float fMax = Math.max(canvas.getWidth() / 8, canvas.getHeight() / 8);
        Point pointOperatorMultiply = quadrilateral.getUpperRight().operatorMinus(quadrilateral.getUpperLeft()).operatorMultiply(this.llIIlIlIIl);
        Point pointOperatorMultiply2 = quadrilateral.getLowerLeft().operatorMinus(quadrilateral.getUpperLeft()).operatorMultiply(this.llIIlIlIIl);
        Point pointOperatorMultiply3 = quadrilateral.getLowerRight().operatorMinus(quadrilateral.getLowerLeft()).operatorMultiply(this.llIIlIlIIl);
        Point pointOperatorMultiply4 = quadrilateral.getLowerRight().operatorMinus(quadrilateral.getUpperRight()).operatorMultiply(this.llIIlIlIIl);
        int i = this.IlIllIlIIl;
        if (i > 0) {
            pointNormalize = pointOperatorMultiply.normalize(i);
            pointNormalize2 = pointOperatorMultiply2.normalize(this.IlIllIlIIl);
            pointNormalize3 = pointOperatorMultiply4.normalize(this.IlIllIlIIl);
            pointClamp = pointOperatorMultiply3.normalize(this.IlIllIlIIl);
        } else {
            float fMin = Math.min(Math.min(Math.min(Math.min(fMax, pointOperatorMultiply.norm()), pointOperatorMultiply2.norm()), pointOperatorMultiply3.norm()), pointOperatorMultiply4.norm());
            Point pointClamp2 = pointOperatorMultiply.clamp(fMin);
            Point pointClamp3 = pointOperatorMultiply2.clamp(fMin);
            Point pointClamp4 = pointOperatorMultiply4.clamp(fMin);
            pointClamp = pointOperatorMultiply3.clamp(fMin);
            pointNormalize = pointClamp2;
            pointNormalize2 = pointClamp3;
            pointNormalize3 = pointClamp4;
        }
        this.IllIIIllII.setColor(quadrilateral.getColor());
        llIIlIlIIl(canvas, quadrilateral.getUpperLeft(), quadrilateral.getUpperLeft().operatorPlus(pointNormalize), quadrilateral.getUpperLeft().operatorPlus(pointNormalize2));
        llIIlIlIIl(canvas, quadrilateral.getUpperRight(), quadrilateral.getUpperRight().operatorMinus(pointNormalize), quadrilateral.getUpperRight().operatorPlus(pointNormalize3));
        llIIlIlIIl(canvas, quadrilateral.getLowerLeft(), quadrilateral.getLowerLeft().operatorMinus(pointNormalize2), quadrilateral.getLowerLeft().operatorPlus(pointClamp));
        llIIlIlIIl(canvas, quadrilateral.getLowerRight(), quadrilateral.getLowerRight().operatorMinus(pointNormalize3), quadrilateral.getLowerRight().operatorMinus(pointClamp));
    }

    private void llIIlIlIIl(Canvas canvas, Point point, Point point2, Point point3) {
        canvas.drawLine(point.getX(), point.getY(), point2.getX(), point2.getY(), this.IllIIIllII);
        canvas.drawLine(point.getX(), point.getY(), point3.getX(), point3.getY(), this.IllIIIllII);
    }
}
