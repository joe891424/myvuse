package it.sephiroth.android.library.xtooltip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.util.ObjectsCompat;
import com.facebook.react.uimanager.ViewProps;
import com.surajit.rnrg.RadialGradientManager;
import it.sephiroth.android.library.xtooltip.Tooltip;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: TooltipTextDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 72\u00020\u0001:\u00017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002JP\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\nH\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0017J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u0010H\u0014J\u0010\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\nH\u0016J \u00103\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0012\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/TooltipTextDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "builder", "Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;", "(Landroid/content/Context;Lit/sephiroth/android/library/xtooltip/Tooltip$Builder;)V", "arrowRatio", "", "arrowWeight", "", "bgPaint", "Landroid/graphics/Paint;", "gravity", "Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", "outlineRect", "Landroid/graphics/Rect;", ViewProps.PADDING, "path", "Landroid/graphics/Path;", "point", "Landroid/graphics/Point;", RadialGradientManager.PROP_RADIUS, "rectF", "Landroid/graphics/RectF;", "stPaint", "tmpPoint", "calculatePath", "", "outBounds", "calculatePathWithGravity", ViewProps.LEFT, ViewProps.TOP, ViewProps.RIGHT, ViewProps.BOTTOM, "maxY", "maxX", "minY", "minX", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getOpacity", "getOutline", "outline", "Landroid/graphics/Outline;", "onBoundsChange", "bounds", "setAlpha", "alpha", "setAnchor", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "Companion", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
public final class TooltipTextDrawable extends Drawable {
    public static final float ARROW_RATIO_DEFAULT = 1.4f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float arrowRatio;
    private int arrowWeight;
    private final Paint bgPaint;
    private Tooltip.Gravity gravity;
    private final Rect outlineRect;
    private int padding;
    private final Path path;
    private Point point;
    private final float radius;
    private final RectF rectF;
    private final Paint stPaint;
    private final Point tmpPoint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    public TooltipTextDrawable(Context context, Tooltip.Builder builder) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        this.tmpPoint = new Point();
        this.outlineRect = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, C5487R.styleable.TooltipLayout, builder.getDefStyleAttr(), builder.getDefStyleRes());
        this.radius = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5487R.styleable.TooltipLayout_ttlm_cornerRadius, 4);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C5487R.styleable.TooltipLayout_ttlm_strokeWeight, 2);
        int color = typedArrayObtainStyledAttributes.getColor(C5487R.styleable.TooltipLayout_ttlm_backgroundColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(C5487R.styleable.TooltipLayout_ttlm_strokeColor, 0);
        this.arrowRatio = typedArrayObtainStyledAttributes.getFloat(C5487R.styleable.TooltipLayout_ttlm_arrowRatio, 1.4f);
        typedArrayObtainStyledAttributes.recycle();
        this.rectF = new RectF();
        if (color != 0) {
            Paint paint = new Paint(1);
            this.bgPaint = paint;
            paint.setColor(color);
            paint.setStyle(Paint.Style.FILL);
        } else {
            this.bgPaint = null;
        }
        if (color2 != 0) {
            Paint paint2 = new Paint(1);
            this.stPaint = paint2;
            paint2.setColor(color2);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(dimensionPixelSize);
        } else {
            this.stPaint = null;
        }
        this.path = new Path();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Paint paint = this.bgPaint;
        if (paint != null) {
            canvas.drawPath(this.path, paint);
        }
        Paint paint2 = this.stPaint;
        if (paint2 != null) {
            canvas.drawPath(this.path, paint2);
        }
    }

    public final void setAnchor(Tooltip.Gravity gravity, int padding, Point point) {
        Intrinsics.checkParameterIsNotNull(gravity, "gravity");
        Timber.m5656i("setAnchor(" + gravity + ", " + padding + ", " + point + ')', new Object[0]);
        if (gravity == this.gravity && padding == this.padding && ObjectsCompat.equals(this.point, point)) {
            return;
        }
        this.gravity = gravity;
        this.padding = padding;
        this.arrowWeight = (int) (padding / this.arrowRatio);
        if (point != null) {
            this.point = new Point(point);
        } else {
            this.point = null;
        }
        Rect bounds = getBounds();
        Intrinsics.checkExpressionValueIsNotNull(bounds, "bounds");
        if (bounds.isEmpty()) {
            return;
        }
        Rect bounds2 = getBounds();
        Intrinsics.checkExpressionValueIsNotNull(bounds2, "bounds");
        calculatePath(bounds2);
        invalidateSelf();
    }

    private final void calculatePath(Rect outBounds) {
        Timber.m5656i("calculatePath: " + outBounds + ", radius: " + this.radius, new Object[0]);
        int i = outBounds.left + this.padding;
        int i2 = outBounds.top + this.padding;
        int i3 = outBounds.right - this.padding;
        int i4 = outBounds.bottom - this.padding;
        float f = i4;
        float f2 = this.radius;
        float f3 = f - f2;
        float f4 = i3;
        float f5 = f4 - f2;
        float f6 = i2;
        float f7 = f6 + f2;
        float f8 = i;
        float f9 = f2 + f8;
        if (this.point != null && this.gravity != null) {
            calculatePathWithGravity(outBounds, i, i2, i3, i4, f3, f5, f7, f9);
            return;
        }
        this.rectF.set(f8, f6, f4, f);
        Path path = this.path;
        RectF rectF = this.rectF;
        float f10 = this.radius;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
    }

    private final void calculatePathWithGravity(Rect outBounds, int left, int top, int right, int bottom, float maxY, float maxX, float minY, float minX) {
        Rect rect;
        if (this.gravity == Tooltip.Gravity.LEFT || this.gravity == Tooltip.Gravity.RIGHT) {
            if (maxY - minY < this.arrowWeight * 2) {
                this.arrowWeight = (int) Math.floor(r2 / 2);
                Timber.m5662w("adjusted arrowWeight to " + this.arrowWeight, new Object[0]);
            }
        } else if (this.gravity == Tooltip.Gravity.BOTTOM || this.gravity == Tooltip.Gravity.TOP) {
            if (maxX - minX < this.arrowWeight * 2) {
                this.arrowWeight = (int) Math.floor(r2 / 2);
                Timber.m5662w("adjusted arrowWeight to " + this.arrowWeight, new Object[0]);
            }
        }
        Companion companion = INSTANCE;
        Point point = this.tmpPoint;
        Point point2 = this.point;
        if (point2 == null) {
            Intrinsics.throwNpe();
        }
        boolean zIsDrawPoint = companion.isDrawPoint(left, top, right, bottom, maxY, maxX, minY, minX, point, point2, this.gravity, this.arrowWeight);
        Timber.m5659v("drawPoint: " + zIsDrawPoint + ", point: " + this.point + ", tmpPoint: " + this.tmpPoint, new Object[0]);
        companion.clampPoint(left, top, right, bottom, this.tmpPoint);
        this.path.reset();
        float f = left;
        float f2 = top;
        this.path.moveTo(this.radius + f, f2);
        if (zIsDrawPoint && this.gravity == Tooltip.Gravity.BOTTOM) {
            this.path.lineTo((this.tmpPoint.x + left) - this.arrowWeight, f2);
            rect = outBounds;
            this.path.lineTo(this.tmpPoint.x + left, rect.top);
            this.path.lineTo(this.tmpPoint.x + left + this.arrowWeight, f2);
        } else {
            rect = outBounds;
        }
        float f3 = right;
        this.path.lineTo(f3 - this.radius, f2);
        this.path.quadTo(f3, f2, f3, this.radius + f2);
        if (zIsDrawPoint && this.gravity == Tooltip.Gravity.LEFT) {
            this.path.lineTo(f3, (this.tmpPoint.y + top) - this.arrowWeight);
            this.path.lineTo(rect.right, this.tmpPoint.y + top);
            this.path.lineTo(f3, this.tmpPoint.y + top + this.arrowWeight);
        }
        float f4 = bottom;
        this.path.lineTo(f3, f4 - this.radius);
        this.path.quadTo(f3, f4, f3 - this.radius, f4);
        if (zIsDrawPoint && this.gravity == Tooltip.Gravity.TOP) {
            this.path.lineTo(this.tmpPoint.x + left + this.arrowWeight, f4);
            this.path.lineTo(this.tmpPoint.x + left, rect.bottom);
            this.path.lineTo((this.tmpPoint.x + left) - this.arrowWeight, f4);
        }
        this.path.lineTo(this.radius + f, f4);
        this.path.quadTo(f, f4, f, f4 - this.radius);
        if (zIsDrawPoint && this.gravity == Tooltip.Gravity.RIGHT) {
            this.path.lineTo(f, this.tmpPoint.y + top + this.arrowWeight);
            this.path.lineTo(rect.left, this.tmpPoint.y + top);
            this.path.lineTo(f, (this.tmpPoint.y + top) - this.arrowWeight);
        }
        this.path.lineTo(f, this.radius + f2);
        this.path.quadTo(f, f2, this.radius + f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkParameterIsNotNull(bounds, "bounds");
        super.onBoundsChange(bounds);
        calculatePath(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Paint paint = this.bgPaint;
        if (paint != null) {
            return paint.getAlpha();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Paint paint = this.bgPaint;
        if (paint != null) {
            paint.setAlpha(alpha);
        }
        Paint paint2 = this.stPaint;
        if (paint2 != null) {
            paint2.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Intrinsics.checkParameterIsNotNull(outline, "outline");
        copyBounds(this.outlineRect);
        Rect rect = this.outlineRect;
        int i = this.padding;
        rect.inset(i, i);
        outline.setRoundRect(this.outlineRect, this.radius);
        if (getAlpha() < 255) {
            outline.setAlpha(0.0f);
        }
    }

    /* JADX INFO: compiled from: TooltipTextDrawable.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002Jj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/TooltipTextDrawable$Companion;", "", "()V", "ARROW_RATIO_DEFAULT", "", "clampPoint", "", ViewProps.LEFT, "", ViewProps.TOP, ViewProps.RIGHT, ViewProps.BOTTOM, "tmpPoint", "Landroid/graphics/Point;", "isDrawPoint", "", "maxY", "maxX", "minY", "minX", "point", "gravity", "Lit/sephiroth/android/library/xtooltip/Tooltip$Gravity;", "arrowWeight", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean isDrawPoint(int r4, int r5, int r6, int r7, float r8, float r9, float r10, float r11, android.graphics.Point r12, android.graphics.Point r13, it.sephiroth.android.library.xtooltip.Tooltip.Gravity r14, int r15) {
            /*
                Method dump skipped, instruction units count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.xtooltip.TooltipTextDrawable.Companion.isDrawPoint(int, int, int, int, float, float, float, float, android.graphics.Point, android.graphics.Point, it.sephiroth.android.library.xtooltip.Tooltip$Gravity, int):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clampPoint(int left, int top, int right, int bottom, Point tmpPoint) {
            if (tmpPoint.y < top) {
                tmpPoint.y = top;
            } else if (tmpPoint.y > bottom) {
                tmpPoint.y = bottom;
            }
            if (tmpPoint.x < left) {
                tmpPoint.x = left;
            }
            if (tmpPoint.x > right) {
                tmpPoint.x = right;
            }
        }
    }
}
