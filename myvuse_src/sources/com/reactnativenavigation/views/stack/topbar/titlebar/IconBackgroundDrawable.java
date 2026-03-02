package com.reactnativenavigation.views.stack.topbar.titlebar;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.reactnativenavigation.options.params.DensityPixel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: IconBackgroundDrawable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0001H\u0007J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0011H\u0014J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0011H\u0016J(\u0010%\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010&\u001a\u00020.H\u0002R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m5598d2 = {"Lcom/reactnativenavigation/views/stack/topbar/titlebar/IconBackgroundDrawable;", "Landroid/graphics/drawable/Drawable;", "wrapped", "cornerRadius", "Lcom/reactnativenavigation/options/params/DensityPixel;", "backgroundWidth", "", "backgroundHeight", OTUXParamsKeys.OT_UX_ICON_COLOR, "backgroundColor", "(Landroid/graphics/drawable/Drawable;Lcom/reactnativenavigation/options/params/DensityPixel;IILjava/lang/Integer;Ljava/lang/Integer;)V", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "backgroundPaint", "Landroid/graphics/Paint;", "backgroundRect", "Landroid/graphics/Rect;", "bitmapHeight", "bitmapPaint", "bitmapRect", "bitmapWidth", "path", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawBackgroundColor", "drawBitmap", "drawPath", "getOpacity", "getWrappedDrawable", "onBoundsChange", "bounds", "setAlpha", "alpha", "setBounds", RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME, "l", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "b", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "updatePath", "Landroid/graphics/RectF;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class IconBackgroundDrawable extends Drawable {
    private final Integer backgroundColor;
    private final int backgroundHeight;
    private final Paint backgroundPaint;
    private Rect backgroundRect;
    private final int backgroundWidth;
    private final int bitmapHeight;
    private final Paint bitmapPaint;
    private Rect bitmapRect;
    private final int bitmapWidth;
    private final DensityPixel cornerRadius;
    private final Integer iconColor;
    private final Path path;
    private final Drawable wrapped;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public IconBackgroundDrawable(Drawable wrapped, DensityPixel cornerRadius, int i, int i2, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        this.wrapped = wrapped;
        this.cornerRadius = cornerRadius;
        this.backgroundWidth = i;
        this.backgroundHeight = i2;
        this.iconColor = num;
        this.backgroundColor = num2;
        this.path = new Path();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setColorFilter(num != null ? new PorterDuffColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN) : null);
        this.bitmapPaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
        if (num2 != null) {
            paint2.setColor(num2.intValue());
        }
        this.backgroundPaint = paint2;
        this.bitmapWidth = wrapped.getIntrinsicWidth();
        this.bitmapHeight = wrapped.getIntrinsicHeight();
        this.backgroundRect = new Rect();
        this.bitmapRect = new Rect();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        drawPath(canvas);
        drawBackgroundColor(canvas);
        drawBitmap(canvas);
    }

    private final void drawBackgroundColor(Canvas canvas) {
        Integer num = this.backgroundColor;
        if (num != null) {
            num.intValue();
            canvas.drawRect(this.backgroundRect, this.backgroundPaint);
        }
    }

    private final void drawPath(Canvas canvas) {
        if (this.cornerRadius.hasValue()) {
            canvas.clipPath(this.path);
        }
    }

    private final void drawBitmap(Canvas canvas) {
        canvas.drawBitmap(DrawableKt.toBitmap$default(this.wrapped, 0, 0, null, 7, null), (Rect) null, this.bitmapRect, this.bitmapPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int l, int t, int r, int b) {
        updatePath(new RectF(l, t, this.backgroundWidth, this.backgroundHeight));
        super.setBounds(l, t, this.backgroundWidth, this.backgroundHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect r) {
        Intrinsics.checkNotNullParameter(r, "r");
        r.right = this.backgroundWidth;
        r.bottom = this.backgroundHeight;
        updatePath(new RectF(r));
        super.setBounds(r);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.backgroundRect = new Rect((bounds.width() - this.backgroundWidth) / 2, (bounds.height() - this.backgroundHeight) / 2, bounds.width() - ((bounds.width() - this.backgroundWidth) / 2), bounds.height() - ((bounds.height() - this.backgroundHeight) / 2));
        this.bitmapRect = new Rect((bounds.width() - this.bitmapWidth) / 2, (bounds.height() - this.bitmapHeight) / 2, bounds.width() - ((bounds.width() - this.bitmapWidth) / 2), bounds.height() - ((bounds.height() - this.bitmapHeight) / 2));
        super.onBoundsChange(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.wrapped.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }

    private final void updatePath(RectF r) {
        if (this.cornerRadius.hasValue()) {
            this.path.reset();
            float fIntValue = this.cornerRadius.get(0).intValue();
            this.path.addRoundRect(r, fIntValue, fIntValue, Path.Direction.CW);
        }
    }

    /* JADX INFO: renamed from: getWrappedDrawable, reason: from getter */
    public final Drawable getWrapped() {
        return this.wrapped;
    }
}
