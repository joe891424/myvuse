package com.reactnativenavigation.views.bottomtabs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ShadowLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\nH\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0010H\u0014J\b\u00100\u001a\u00020.H\u0014J\u0018\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0014J\b\u00104\u001a\u00020.H\u0016J\b\u00105\u001a\u00020.H\u0002J\b\u00106\u001a\u00020.H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001e\u0010$\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u001e\u0010&\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R$\u0010(\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0016@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001a¨\u00067"}, m5598d2 = {"Lcom/reactnativenavigation/views/bottomtabs/ShadowLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bitmap", "Landroid/graphics/Bitmap;", "bounds", "Landroid/graphics/Rect;", "invalidateShadow", "", "isShadowed", "()Z", "setShadowed", "(Z)V", "mainCanvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "shadowAlpha", "", "shadowAngle", "", "getShadowAngle", "()F", "setShadowAngle", "(F)V", ViewProps.SHADOW_COLOR, "getShadowColor", "()I", "setShadowColor", "(I)V", "shadowDistance", "getShadowDistance", "setShadowDistance", "<set-?>", "shadowDx", "getShadowDx", "shadowDy", "getShadowDy", "shadowRadius", "getShadowRadius", "setShadowRadius", "adjustShadowAlpha", "adjust", "dispatchDraw", "", "canvas", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "resetShadow", "updatePadding", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ShadowLayout extends FrameLayout {
    private Bitmap bitmap;
    private final Rect bounds;
    private boolean invalidateShadow;
    private boolean isShadowed;
    private final Canvas mainCanvas;
    private final Paint paint;
    private int shadowAlpha;
    private float shadowAngle;
    private int shadowColor;
    private float shadowDistance;
    private float shadowDx;
    private float shadowDy;
    private float shadowRadius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        this.paint = paint;
        this.mainCanvas = new Canvas();
        this.bounds = new Rect();
        this.invalidateShadow = true;
        super.setWillNotDraw(false);
        super.setLayerType(2, paint);
    }

    public final float getShadowDx() {
        return this.shadowDx;
    }

    public final float getShadowDy() {
        return this.shadowDy;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.bitmap = null;
    }

    /* JADX INFO: renamed from: isShadowed, reason: from getter */
    public final boolean getIsShadowed() {
        return this.isShadowed;
    }

    public final void setShadowed(boolean z) {
        this.isShadowed = z;
        updatePadding();
        postInvalidate();
    }

    public final float getShadowDistance() {
        return this.shadowDistance;
    }

    public final void setShadowDistance(float f) {
        this.shadowDistance = f;
        resetShadow();
    }

    public final float getShadowAngle() {
        return this.shadowAngle;
    }

    public final void setShadowAngle(float f) {
        this.shadowAngle = RangesKt.coerceAtLeast(0.0f, RangesKt.coerceAtMost(f, 360.0f));
        resetShadow();
    }

    public float getShadowRadius() {
        return this.shadowRadius;
    }

    public void setShadowRadius(float f) {
        this.shadowRadius = RangesKt.coerceAtLeast(0.1f, f);
        this.paint.setMaskFilter(new BlurMaskFilter(this.shadowRadius, BlurMaskFilter.Blur.NORMAL));
        resetShadow();
    }

    public final int getShadowColor() {
        return this.shadowColor;
    }

    public final void setShadowColor(int i) {
        this.shadowColor = i;
        this.shadowAlpha = Color.alpha(i);
        resetShadow();
    }

    private final void resetShadow() {
        this.shadowDx = (float) (((double) this.shadowDistance) * Math.cos(((double) (this.shadowAngle / 180.0f)) * 3.141592653589793d));
        this.shadowDy = (float) (((double) this.shadowDistance) * Math.sin(((double) (this.shadowAngle / 180.0f)) * 3.141592653589793d));
        updatePadding();
        requestLayout();
    }

    private final void updatePadding() {
        setPadding(0, this.isShadowed ? (int) (this.shadowDistance + getShadowRadius()) : 0, 0, 0);
    }

    private final int adjustShadowAlpha(boolean adjust) {
        return Color.argb(adjust ? 255 : this.shadowAlpha, Color.red(this.shadowColor), Color.green(this.shadowColor), Color.blue(this.shadowColor));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.bounds.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.invalidateShadow = true;
        super.requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isShadowed) {
            if (this.invalidateShadow) {
                if (this.bounds.width() != 0 && this.bounds.height() != 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.bounds.width(), this.bounds.height(), Bitmap.Config.ARGB_8888);
                    this.bitmap = bitmapCreateBitmap;
                    if (bitmapCreateBitmap != null) {
                        this.mainCanvas.setBitmap(bitmapCreateBitmap);
                        this.invalidateShadow = false;
                        super.dispatchDraw(this.mainCanvas);
                        Bitmap bitmapExtractAlpha = bitmapCreateBitmap.extractAlpha();
                        Intrinsics.checkNotNullExpressionValue(bitmapExtractAlpha, "extractAlpha(...)");
                        this.mainCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        this.paint.setColor(adjustShadowAlpha(false));
                        this.mainCanvas.drawBitmap(bitmapExtractAlpha, this.shadowDx, this.shadowDy, this.paint);
                        bitmapExtractAlpha.recycle();
                    }
                } else {
                    this.bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
                }
            }
            this.paint.setColor(adjustShadowAlpha(true));
            Bitmap bitmap = this.bitmap;
            if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                Bitmap bitmap2 = this.bitmap;
                Intrinsics.checkNotNull(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.paint);
            }
        }
        super.dispatchDraw(canvas);
    }
}
