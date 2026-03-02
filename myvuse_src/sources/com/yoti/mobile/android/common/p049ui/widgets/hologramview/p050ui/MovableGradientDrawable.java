package com.yoti.mobile.android.common.p049ui.widgets.hologramview.p050ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010'\u001a\u00020\u0011\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b;\u0010<J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\u00020\u001b8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\u00020!8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&R\"\u0010.\u001a\u00020(8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b\u001c\u0010+\"\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u0010\n\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b3\u00105\"\u0004\b6\u0010\fR\u001c\u0010:\u001a\u0002078\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\b)\u00109¨\u0006="}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/MovableGradientDrawable;", "Landroid/graphics/drawable/Drawable;", "", "f", "()V", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "(Landroid/graphics/Rect;)V", "", "progress", "update", "(F)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "", "alpha", "setAlpha", "(I)V", "getOpacity", "()I", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "Landroid/graphics/RectF;", "b", "Landroid/graphics/RectF;", "a", "()Landroid/graphics/RectF;", "drawRect", "Landroid/graphics/Matrix;", "c", "Landroid/graphics/Matrix;", "()Landroid/graphics/Matrix;", "matrix", "I", "colorRepeatCount", "Landroid/graphics/Shader;", "d", "Landroid/graphics/Shader;", "()Landroid/graphics/Shader;", "setGradientShader", "(Landroid/graphics/Shader;)V", "gradientShader", "", "g", "[I", "colors", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "F", "()F", "setProgress", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "()Landroid/graphics/Paint;", "paint", "<init>", "(I[I)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public class MovableGradientDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Paint paint;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final RectF drawRect;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Matrix matrix;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    protected Shader gradientShader;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private float progress;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final int colorRepeatCount;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final int[] colors;

    public MovableGradientDrawable(int i, int[] colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.colorRepeatCount = i;
        this.colors = colors;
        this.paint = new Paint();
        this.drawRect = new RectF();
        this.matrix = new Matrix();
        this.progress = 0.5f;
    }

    /* JADX INFO: renamed from: f */
    private final void m4671f() {
        if (this.drawRect.isEmpty()) {
            return;
        }
        Integer[][] numArr = new Integer[0][];
        int i = this.colorRepeatCount;
        for (int i2 = 0; i2 < i; i2++) {
            numArr = (Integer[][]) ArraysKt.plus(numArr, ArraysKt.toTypedArray(this.colors));
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.colorRepeatCount * 2 * this.drawRect.width(), 0.0f, CollectionsKt.toIntArray(ArraysKt.flatten(numArr)), (float[]) null, Shader.TileMode.CLAMP);
        this.gradientShader = linearGradient;
        this.paint.setShader(linearGradient);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    protected final RectF getDrawRect() {
        return this.drawRect;
    }

    /* JADX INFO: renamed from: b */
    protected final Shader m4673b() {
        Shader shader = this.gradientShader;
        if (shader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradientShader");
        }
        return shader;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    protected final Matrix getMatrix() {
        return this.matrix;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    protected final Paint getPaint() {
        return this.paint;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float fWidth = (((this.colorRepeatCount * this.drawRect.width()) * 2) - this.drawRect.width()) * this.progress;
        Shader shader = this.paint.getShader();
        Matrix matrix = this.matrix;
        matrix.reset();
        matrix.postTranslate(-fWidth, 0.0f);
        shader.setLocalMatrix(matrix);
        canvas.drawRect(this.drawRect, this.paint);
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    protected final float getProgress() {
        return this.progress;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.drawRect.set(0.0f, 0.0f, bounds != null ? bounds.width() : 0, bounds != null ? bounds.height() : 0);
        m4671f();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public final void update(float progress) {
        this.progress = progress;
        invalidateSelf();
    }
}
