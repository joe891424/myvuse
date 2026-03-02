package it.sephiroth.android.library.xtooltip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: TooltipOverlayDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\u00020\u0001:\u0001@B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u000204H\u0014J\b\u00105\u001a\u00020,H\u0002J\b\u00106\u001a\u00020,H\u0002J\u0010\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0005H\u0016J\u0012\u00109\u001a\u00020,2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0018\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#H\u0016J\b\u0010?\u001a\u00020,H\u0002R$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\fR$\u0010'\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0011¨\u0006A"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/TooltipOverlayDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "defStyleResId", "", "(Landroid/content/Context;I)V", "value", "innerAlpha", "getInnerAlpha", "()I", "setInnerAlpha", "(I)V", "rippleRadius", "", "innerRadius", "setInnerRadius", "(F)V", "mDuration", "", "mFirstAnimator", "Landroid/animation/ValueAnimator;", "mFirstAnimatorSet", "Landroid/animation/AnimatorSet;", "mInnerAlpha", "mInnerPaint", "Landroid/graphics/Paint;", "mOuterAlpha", "mOuterPaint", "mOuterRadius", "mRepeatCount", "mRepeatIndex", "mSecondAnimator", "mSecondAnimatorSet", "mStarted", "", "outerAlpha", "getOuterAlpha", "setOuterAlpha", "outerRadius", "getOuterRadius", "()F", "setOuterRadius", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "play", "replay", "setAlpha", ContextChain.TAG_INFRA, "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setVisible", ViewProps.VISIBLE, "restart", BackgroundFetch.ACTION_STOP, "Companion", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
public final class TooltipOverlayDrawable extends Drawable {
    public static final float ALPHA_MAX = 255.0f;
    public static final double FADEIN_DURATION = 0.3d;
    public static final double FADEOUT_START_DELAY = 0.55d;
    public static final double SECOND_ANIM_START_DELAY = 0.25d;
    private float innerRadius;
    private long mDuration;
    private final ValueAnimator mFirstAnimator;
    private final AnimatorSet mFirstAnimatorSet;
    private final int mInnerAlpha;
    private final Paint mInnerPaint;
    private final int mOuterAlpha;
    private final Paint mOuterPaint;
    private float mOuterRadius;
    private int mRepeatCount;
    private int mRepeatIndex;
    private final ValueAnimator mSecondAnimator;
    private final AnimatorSet mSecondAnimatorSet;
    private boolean mStarted;

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return 96;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return 96;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public TooltipOverlayDrawable(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Paint paint = new Paint(1);
        this.mOuterPaint = paint;
        Paint paint2 = new Paint(1);
        this.mInnerPaint = paint2;
        this.mRepeatCount = 1;
        this.mDuration = 400L;
        paint.setStyle(Paint.Style.FILL);
        paint2.setStyle(Paint.Style.FILL);
        TypedArray array = context.getTheme().obtainStyledAttributes(i, C5487R.styleable.TooltipOverlay);
        Intrinsics.checkExpressionValueIsNotNull(array, "array");
        int indexCount = array.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = array.getIndex(i2);
            if (index == C5487R.styleable.TooltipOverlay_android_color) {
                int color = array.getColor(index, 0);
                this.mOuterPaint.setColor(color);
                this.mInnerPaint.setColor(color);
            } else if (index == C5487R.styleable.TooltipOverlay_ttlm_repeatCount) {
                this.mRepeatCount = array.getInt(index, 1);
            } else if (index == C5487R.styleable.TooltipOverlay_android_alpha) {
                int i3 = (int) (array.getFloat(index, this.mInnerPaint.getAlpha() / 255.0f) * 255);
                this.mInnerPaint.setAlpha(i3);
                this.mOuterPaint.setAlpha(i3);
            } else if (index == C5487R.styleable.TooltipOverlay_ttlm_duration) {
                this.mDuration = array.getInt(index, 400);
            }
        }
        array.recycle();
        int outerAlpha = getOuterAlpha();
        this.mOuterAlpha = outerAlpha;
        int innerAlpha = getInnerAlpha();
        this.mInnerAlpha = innerAlpha;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "outerAlpha", 0, outerAlpha);
        Intrinsics.checkExpressionValueIsNotNull(objectAnimatorOfInt, "ObjectAnimator.ofInt(thi…erAlpha\", 0, mOuterAlpha)");
        ObjectAnimator objectAnimator = objectAnimatorOfInt;
        objectAnimator.setDuration((long) (this.mDuration * 0.3d));
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this, "outerAlpha", outerAlpha, 0, 0);
        Intrinsics.checkExpressionValueIsNotNull(objectAnimatorOfInt2, "ObjectAnimator.ofInt(thi…lpha\", mOuterAlpha, 0, 0)");
        ObjectAnimator objectAnimator2 = objectAnimatorOfInt2;
        objectAnimator2.setStartDelay((long) (this.mDuration * 0.55d));
        objectAnimator2.setDuration((long) (this.mDuration * 0.44999999999999996d));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "outerRadius", 0.0f, 1.0f);
        Intrinsics.checkExpressionValueIsNotNull(objectAnimatorOfFloat, "ObjectAnimator.ofFloat(t…s, \"outerRadius\", 0f, 1f)");
        ObjectAnimator objectAnimator3 = objectAnimatorOfFloat;
        this.mFirstAnimator = objectAnimator3;
        objectAnimator3.setDuration(this.mDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mFirstAnimatorSet = animatorSet;
        animatorSet.playTogether(objectAnimator, objectAnimator3, objectAnimator2);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(this.mDuration);
        ObjectAnimator objectAnimatorOfInt3 = ObjectAnimator.ofInt(this, "innerAlpha", 0, innerAlpha);
        Intrinsics.checkExpressionValueIsNotNull(objectAnimatorOfInt3, "ObjectAnimator.ofInt(thi…erAlpha\", 0, mInnerAlpha)");
        ObjectAnimator objectAnimator4 = objectAnimatorOfInt3;
        objectAnimator4.setDuration((long) (this.mDuration * 0.3d));
        ObjectAnimator objectAnimatorOfInt4 = ObjectAnimator.ofInt(this, "innerAlpha", innerAlpha, 0, 0);
        Intrinsics.checkExpressionValueIsNotNull(objectAnimatorOfInt4, "ObjectAnimator.ofInt(thi…lpha\", mInnerAlpha, 0, 0)");
        ObjectAnimator objectAnimator5 = objectAnimatorOfInt4;
        objectAnimator5.setStartDelay((long) (this.mDuration * 0.55d));
        objectAnimator5.setDuration((long) (this.mDuration * 0.44999999999999996d));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "innerRadius", 0.0f, 1.0f);
        Intrinsics.checkExpressionValueIsNotNull(objectAnimatorOfFloat2, "ObjectAnimator.ofFloat(t…s, \"innerRadius\", 0f, 1f)");
        ObjectAnimator objectAnimator6 = objectAnimatorOfFloat2;
        this.mSecondAnimator = objectAnimator6;
        objectAnimator6.setDuration(this.mDuration);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mSecondAnimatorSet = animatorSet2;
        animatorSet2.playTogether(objectAnimator4, objectAnimator6, objectAnimator5);
        animatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet2.setStartDelay((long) (this.mDuration * 0.25d));
        animatorSet2.setDuration(this.mDuration);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: it.sephiroth.android.library.xtooltip.TooltipOverlayDrawable.1
            private boolean cancelled;

            public final boolean getCancelled() {
                return this.cancelled;
            }

            public final void setCancelled(boolean z) {
                this.cancelled = z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                super.onAnimationCancel(animation);
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                if (this.cancelled || !TooltipOverlayDrawable.this.isVisible()) {
                    return;
                }
                TooltipOverlayDrawable tooltipOverlayDrawable = TooltipOverlayDrawable.this;
                tooltipOverlayDrawable.mRepeatIndex++;
                if (tooltipOverlayDrawable.mRepeatIndex < TooltipOverlayDrawable.this.mRepeatCount) {
                    TooltipOverlayDrawable.this.mFirstAnimatorSet.start();
                }
            }
        });
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: it.sephiroth.android.library.xtooltip.TooltipOverlayDrawable.2
            private boolean cancelled;

            public final boolean getCancelled() {
                return this.cancelled;
            }

            public final void setCancelled(boolean z) {
                this.cancelled = z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                super.onAnimationCancel(animation);
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                if (this.cancelled || !TooltipOverlayDrawable.this.isVisible() || TooltipOverlayDrawable.this.mRepeatIndex >= TooltipOverlayDrawable.this.mRepeatCount) {
                    return;
                }
                TooltipOverlayDrawable.this.mSecondAnimatorSet.setStartDelay(0L);
                TooltipOverlayDrawable.this.mSecondAnimatorSet.start();
            }
        });
    }

    private final void setInnerRadius(float f) {
        this.innerRadius = f;
        invalidateSelf();
    }

    private final int getOuterAlpha() {
        return this.mOuterPaint.getAlpha();
    }

    private final void setOuterAlpha(int i) {
        this.mOuterPaint.setAlpha(i);
        invalidateSelf();
    }

    private final int getInnerAlpha() {
        return this.mInnerPaint.getAlpha();
    }

    private final void setInnerAlpha(int i) {
        this.mInnerPaint.setAlpha(i);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: getOuterRadius, reason: from getter */
    private final float getMOuterRadius() {
        return this.mOuterRadius;
    }

    private final void setOuterRadius(float f) {
        this.mOuterRadius = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Rect bounds = getBounds();
        float fWidth = bounds.width() / 2;
        float fHeight = bounds.height() / 2;
        canvas.drawCircle(fWidth, fHeight, this.mOuterRadius, this.mOuterPaint);
        canvas.drawCircle(fWidth, fHeight, this.innerRadius, this.mInnerPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean z = isVisible() != visible;
        if (visible) {
            if (restart || !this.mStarted) {
                replay();
            }
        } else {
            stop();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkParameterIsNotNull(bounds, "bounds");
        Timber.m5656i("onBoundsChange: " + bounds, new Object[0]);
        super.onBoundsChange(bounds);
        float fMin = Math.min(bounds.width(), bounds.height()) / 2;
        this.mOuterRadius = fMin;
        this.mFirstAnimator.setFloatValues(0.0f, fMin);
        this.mSecondAnimator.setFloatValues(0.0f, this.mOuterRadius);
    }

    private final void play() {
        this.mRepeatIndex = 0;
        this.mStarted = true;
        this.mFirstAnimatorSet.start();
        this.mSecondAnimatorSet.setStartDelay((long) (this.mDuration * 0.25d));
        this.mSecondAnimatorSet.start();
    }

    private final void replay() {
        stop();
        play();
    }

    private final void stop() {
        this.mFirstAnimatorSet.cancel();
        this.mSecondAnimatorSet.cancel();
        this.mRepeatIndex = 0;
        this.mStarted = false;
        setInnerRadius(0.0f);
        setOuterRadius(0.0f);
    }
}
