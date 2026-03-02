package com.microblink.blinkid.secured;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.microblink.geometry.Quadrilateral;
import com.microblink.geometry.quadTransform.IQuadTransformer;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IllIllIllI implements IllllIIlII {
    private Paint IlIllIlIIl;
    private IQuadTransformer llIIlIlIIl;

    public IllIllIllI(IQuadTransformer iQuadTransformer, Context context) {
        this.llIIlIlIIl = iQuadTransformer;
        Paint paint = new Paint(1);
        this.IlIllIlIIl = paint;
        paint.setColor(-1);
        this.IlIllIlIIl.setStrokeWidth((context.getResources().getDisplayMetrics().densityDpi + 49) / 50);
        this.IlIllIlIIl.setStrokeCap(Paint.Cap.ROUND);
        this.IlIllIlIIl.setStyle(Paint.Style.STROKE);
    }

    public IQuadTransformer IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    @Override // com.microblink.blinkid.secured.IllllIIlII
    public void llIIlIlIIl(Quadrilateral quadrilateral, Canvas canvas) {
        Quadrilateral sortedQuad = this.llIIlIlIIl.transformQuad(quadrilateral).getSortedQuad();
        canvas.drawRoundRect(new RectF(sortedQuad.getUpperLeft().getX(), sortedQuad.getUpperLeft().getY(), sortedQuad.getLowerRight().getX(), sortedQuad.getLowerRight().getY()), 30.0f, 30.0f, this.IlIllIlIIl);
    }

    @Override // com.microblink.blinkid.secured.IllllIIlII
    public Paint llIIlIlIIl() {
        return this.IlIllIlIIl;
    }
}
