package com.microblink.blinkid.secured;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.microblink.geometry.Quadrilateral;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIllIlIlIl implements IllllIIlII {
    private Paint llIIlIlIIl;

    public lIllIlIlIl() {
        this.llIIlIlIIl = null;
        Paint paint = new Paint();
        this.llIIlIlIIl = paint;
        paint.setAlpha(100);
    }

    @Override // com.microblink.blinkid.secured.IllllIIlII
    public void llIIlIlIIl(Quadrilateral quadrilateral, Canvas canvas) {
        Paint paint = this.llIIlIlIIl;
        Path path = new Path();
        path.moveTo(quadrilateral.getUpperLeft().getX(), quadrilateral.getUpperLeft().getY());
        path.lineTo(canvas.getWidth(), 0.0f);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(quadrilateral.getUpperRight().getX(), quadrilateral.getUpperRight().getY());
        canvas.drawPath(path, paint);
        Path path2 = new Path();
        path2.moveTo(quadrilateral.getUpperRight().getX(), quadrilateral.getUpperRight().getY());
        path2.lineTo(0.0f, 0.0f);
        path2.lineTo(0.0f, canvas.getHeight());
        path2.lineTo(quadrilateral.getLowerRight().getX(), quadrilateral.getLowerRight().getY());
        canvas.drawPath(path2, paint);
        Path path3 = new Path();
        path3.moveTo(quadrilateral.getLowerRight().getX(), quadrilateral.getLowerRight().getY());
        path3.lineTo(0.0f, canvas.getHeight());
        path3.lineTo(canvas.getWidth(), canvas.getHeight());
        path3.lineTo(quadrilateral.getLowerLeft().getX(), quadrilateral.getLowerLeft().getY());
        canvas.drawPath(path3, paint);
        Path path4 = new Path();
        path4.moveTo(quadrilateral.getLowerLeft().getX(), quadrilateral.getLowerLeft().getY());
        path4.lineTo(canvas.getWidth(), canvas.getHeight());
        path4.lineTo(canvas.getWidth(), 0.0f);
        path4.lineTo(quadrilateral.getUpperLeft().getX(), quadrilateral.getUpperLeft().getY());
        canvas.drawPath(path4, paint);
    }

    @Override // com.microblink.blinkid.secured.IllllIIlII
    public Paint llIIlIlIIl() {
        return this.llIIlIlIIl;
    }
}
