package com.yoti.mobile.android.documentscan.ui.helpers.scan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.google.android.material.color.MaterialColors;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.yoti.mobile.android.documentscan.C4695R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u001c\u0010\u0016\u001a\u00020\u000e2\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/RoundedCornerRectangleFrameShape;", "Lcom/yoti/mobile/android/documentscan/ui/helpers/scan/IScanFrameShape;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cornerRadius", "", "paint", "Landroid/graphics/Paint;", "shape", "Landroid/graphics/Path;", "window", "Landroid/graphics/RectF;", RemoteConfigComponent.ACTIVATE_FILE_NAME, "", "deactivate", "draw", "canvas", "Landroid/graphics/Canvas;", "getShape", "setCorners", "windowRect", "setGradient", "colorStart", "", "colorEnd", "setRatio", "ratio", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final class RoundedCornerRectangleFrameShape implements IScanFrameShape {
    private final Context context;
    private final float cornerRadius;
    private final Paint paint;
    private final Path shape;
    private RectF window;

    public RoundedCornerRectangleFrameShape(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        this.shape = new Path();
        Paint paint = new Paint(1);
        this.paint = paint;
        float dimension = context.getResources().getDimension(C4695R.dimen.document_reader_scan_corners_rounding_v2);
        this.cornerRadius = dimension;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimension(C4695R.dimen.document_reader_scan_border_width_v2));
        paint.setPathEffect(new CornerPathEffect(dimension));
    }

    private final void setGradient(int colorStart, int colorEnd) {
        RectF rectF = this.window;
        if (rectF == null) {
            throw new IllegalArgumentException("Must call setCorners before setGradient");
        }
        this.paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.right, 0.0f, MaterialColors.getColor(this.context, colorStart, (String) null), MaterialColors.getColor(this.context, colorEnd, (String) null), Shader.TileMode.CLAMP));
    }

    @Override // com.yoti.mobile.android.documentscan.ui.helpers.scan.IScanFrameShape
    public void activate() {
        setGradient(C4695R.attr.border_scan_gradient_success1, C4695R.attr.border_scan_gradient_success2);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.helpers.scan.IScanFrameShape
    public void deactivate() {
        setGradient(C4695R.attr.border_scan_gradient1, C4695R.attr.border_scan_gradient2);
    }

    @Override // com.yoti.mobile.android.documentscan.ui.helpers.scan.IScanFrameShape
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        RectF rectF = this.window;
        if (rectF != null) {
            canvas.drawRect(rectF, this.paint);
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.helpers.scan.IScanFrameShape
    public Path getShape() {
        return this.shape;
    }

    @Override // com.yoti.mobile.android.documentscan.ui.helpers.scan.IScanFrameShape
    public void setCorners(RectF windowRect) {
        Intrinsics.checkParameterIsNotNull(windowRect, "windowRect");
        this.window = windowRect;
        Path path = this.shape;
        float f = windowRect.left;
        float f2 = windowRect.top;
        float f3 = windowRect.right;
        float f4 = windowRect.bottom;
        float f5 = this.cornerRadius;
        path.addRoundRect(f, f2, f3, f4, f5, f5, Path.Direction.CW);
        deactivate();
    }

    @Override // com.yoti.mobile.android.documentscan.ui.helpers.scan.IScanFrameShape
    public void setRatio(float ratio) {
    }
}
