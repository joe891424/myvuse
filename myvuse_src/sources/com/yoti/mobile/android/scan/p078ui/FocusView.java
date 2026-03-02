package com.yoti.mobile.android.scan.p078ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.color.MaterialColors;
import com.yoti.mobile.android.scan.C4928R;

/* JADX INFO: loaded from: classes4.dex */
public class FocusView extends View {

    /* JADX INFO: renamed from: a */
    private final float f7433a;

    /* JADX INFO: renamed from: b */
    private Rect f7434b;

    /* JADX INFO: renamed from: c */
    private final Paint f7435c;

    public FocusView(Context context) {
        this(context, null, 0);
    }

    public FocusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7433a = context.getResources().getDimension(C4928R.dimen.yoti_lib_scan_focus_area_corner_radius);
        Paint paint = new Paint();
        this.f7435c = paint;
        paint.setColor(0);
        setLayerType(1, null);
    }

    /* JADX INFO: renamed from: a */
    private Path m5071a(float f, float f2, float f3, float f4, float f5, float f6) {
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        float f7 = f3 - f;
        float f8 = f4 - f2;
        float f9 = f7 / 2.0f;
        if (f5 > f9) {
            f5 = f9;
        }
        float f10 = f8 / 2.0f;
        if (f6 > f10) {
            f6 = f10;
        }
        float f11 = f7 - (f5 * 2.0f);
        float f12 = f8 - (2.0f * f6);
        Path path = new Path();
        path.moveTo(f3, f2 + f6);
        float f13 = -f6;
        float f14 = -f5;
        path.rQuadTo(0.0f, f13, f14, f13);
        path.rLineTo(-f11, 0.0f);
        path.rQuadTo(f14, 0.0f, f14, f6);
        path.rLineTo(0.0f, f12);
        path.rQuadTo(0.0f, f6, f5, f6);
        path.rLineTo(f11, 0.0f);
        path.rQuadTo(f5, 0.0f, f5, f13);
        path.rLineTo(0.0f, -f12);
        path.close();
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        return path;
    }

    /* JADX INFO: renamed from: a */
    public void m5072a(Rect rect) {
        this.f7434b = rect;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.f7434b;
        if (rect != null) {
            float f = rect.left;
            float f2 = rect.top;
            float f3 = rect.right;
            float f4 = rect.bottom;
            float f5 = this.f7433a;
            Path pathM5071a = m5071a(f, f2, f3, f4, f5, f5);
            canvas.drawPath(pathM5071a, this.f7435c);
            canvas.clipPath(pathM5071a);
        }
        canvas.drawColor(MaterialColors.getColor(this, C4928R.attr.background_overlay_QRscan));
    }
}
