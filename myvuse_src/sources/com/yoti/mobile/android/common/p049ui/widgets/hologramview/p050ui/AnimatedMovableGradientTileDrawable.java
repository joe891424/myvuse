package com.yoti.mobile.android.common.p049ui.widgets.hologramview.p050ui;

import android.animation.TimeAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.callercontext.ContextChain;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.OctetSequenceJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B)\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*B+\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010-J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ)\u0010\u0013\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006/"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/AnimatedMovableGradientTileDrawable;", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/MovableGradientDrawable;", "Landroid/animation/TimeAnimator$TimeListener;", "", "a", "(I)I", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "start", "()V", BackgroundFetch.ACTION_STOP, "Landroid/animation/TimeAnimator;", "animation", "", "totalTime", "deltaTime", "onTimeUpdate", "(Landroid/animation/TimeAnimator;JJ)V", "", ContextChain.TAG_INFRA, "F", "timeAnimatedValue", OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME, "I", "colorRepeatCount", "j", "Landroid/animation/TimeAnimator;", "animator", "Landroid/graphics/BitmapShader;", "h", "Landroid/graphics/BitmapShader;", "bitmapShader", "Landroid/graphics/Bitmap;", "bitmap", "", "colors", "Landroid/graphics/Shader$TileMode;", "tileMode", "<init>", "(Landroid/graphics/Bitmap;[IILandroid/graphics/Shader$TileMode;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;[IILandroid/graphics/Shader$TileMode;)V", "Companion", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class AnimatedMovableGradientTileDrawable extends MovableGradientDrawable implements TimeAnimator.TimeListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final BitmapShader bitmapShader;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private float timeAnimatedValue;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final TimeAnimator animator;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final int colorRepeatCount;

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/hologramview/ui/AnimatedMovableGradientTileDrawable$Companion;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap;", "a", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;", "<init>", "()V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public final Bitmap m4669a(Drawable drawable) {
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.bitmap");
                return bitmap;
            }
            Bitmap bmp = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(bmp);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            Intrinsics.checkNotNullExpressionValue(bmp, "bmp");
            return bmp;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedMovableGradientTileDrawable(Bitmap bitmap, int[] colors, int i, Shader.TileMode tileMode) {
        super(i, colors);
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(tileMode, "tileMode");
        this.colorRepeatCount = i;
        this.bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        TimeAnimator timeAnimator = new TimeAnimator();
        timeAnimator.setTimeListener(this);
        this.animator = timeAnimator;
    }

    public /* synthetic */ AnimatedMovableGradientTileDrawable(Bitmap bitmap, int[] iArr, int i, Shader.TileMode tileMode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bitmap, iArr, i, (i2 & 8) != 0 ? Shader.TileMode.REPEAT : tileMode);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimatedMovableGradientTileDrawable(Drawable drawable, int[] colors, int i, Shader.TileMode tileMode) {
        this(INSTANCE.m4669a(drawable), colors, i, tileMode);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(tileMode, "tileMode");
    }

    public /* synthetic */ AnimatedMovableGradientTileDrawable(Drawable drawable, int[] iArr, int i, Shader.TileMode tileMode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, iArr, i, (i2 & 8) != 0 ? Shader.TileMode.REPEAT : tileMode);
    }

    /* JADX INFO: renamed from: a */
    private final int m4668a(int i) {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
        return (int) (i * system.getDisplayMetrics().density);
    }

    @Override // com.yoti.mobile.android.common.p049ui.widgets.hologramview.p050ui.MovableGradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BitmapShader bitmapShader = this.bitmapShader;
        Matrix matrix = getMatrix();
        matrix.reset();
        matrix.postTranslate(0.0f, -this.timeAnimatedValue);
        bitmapShader.setLocalMatrix(matrix);
        float fWidth = (((this.colorRepeatCount * getDrawRect().width()) * 2) - getDrawRect().width()) * getProgress();
        Shader shaderM4673b = m4673b();
        Matrix matrix2 = getMatrix();
        matrix2.reset();
        matrix2.postTranslate(-fWidth, 0.0f);
        shaderM4673b.setLocalMatrix(matrix2);
        getPaint().setShader(new ComposeShader(this.bitmapShader, m4673b(), PorterDuff.Mode.SRC_IN));
        canvas.drawPaint(getPaint());
    }

    @Override // android.animation.TimeAnimator.TimeListener
    public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
        this.timeAnimatedValue = (((long) m4668a(16)) * totalTime) / 1000.0f;
        invalidateSelf();
    }

    public final void start() {
        this.animator.start();
    }

    public final void stop() {
        this.animator.cancel();
    }
}
