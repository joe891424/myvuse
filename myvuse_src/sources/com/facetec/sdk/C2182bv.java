package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.google.logging.type.LogSeverity;

/* JADX INFO: renamed from: com.facetec.sdk.bv */
/* JADX INFO: loaded from: classes3.dex */
class C2182bv extends View {

    /* JADX INFO: renamed from: i */
    private static final int f2953i = (int) C2188cb.m1993V(10);

    /* JADX INFO: renamed from: B */
    private final Context f2954B;

    /* JADX INFO: renamed from: C */
    protected RectF f2955C;
    protected Paint Code;

    /* JADX INFO: renamed from: D */
    private Paint f2956D;

    /* JADX INFO: renamed from: F */
    protected RectF f2957F;

    /* JADX INFO: renamed from: I */
    protected Paint f2958I;

    /* JADX INFO: renamed from: L */
    private RectF f2959L;

    /* JADX INFO: renamed from: S */
    private boolean f2960S;

    /* JADX INFO: renamed from: V */
    protected RectF f2961V;

    /* JADX INFO: renamed from: a */
    private AnimatorSet f2962a;

    /* JADX INFO: renamed from: b */
    private AnimatorSet f2963b;

    /* JADX INFO: renamed from: c */
    private final float f2964c;

    /* JADX INFO: renamed from: d */
    private final float f2965d;

    /* JADX INFO: renamed from: e */
    private AnimatorSet f2966e;

    /* JADX INFO: renamed from: f */
    private Z f2967f;

    /* JADX INFO: renamed from: g */
    private final Handler f2968g;

    /* JADX INFO: renamed from: h */
    private AnimatorSet f2969h;

    /* JADX INFO: renamed from: j */
    private boolean f2970j;

    public C2182bv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2970j = false;
        this.f2968g = new Handler();
        this.f2954B = context;
        this.f2965d = C2188cb.m1993V(C2156av.m1764i()) * C2156av.Code();
        this.f2964c = C2188cb.m1993V(C2156av.m1762h()) * C2156av.Code();
        this.f2961V = null;
        post(new Runnable() { // from class: com.facetec.sdk.bv.1
            @Override // java.lang.Runnable
            public final void run() {
                C2182bv.this.m1963V(false);
                C2182bv.this.m1952I();
                C2182bv.m1950B(C2182bv.this);
            }
        });
    }

    /* JADX INFO: renamed from: V */
    public final void m1962V() {
        Z z = this.f2967f;
        if (z != null) {
            z.m1968V();
        }
    }

    /* JADX INFO: renamed from: S */
    public final void m1961S() {
        Code();
        invalidate();
    }

    public void setTransparentBackground() {
        if (this.f2956D == null) {
            m1952I();
            Code();
        }
        this.f2956D.setColor(0);
        invalidate();
    }

    public void setOvalStrokeWidth(int i) {
        if (this.Code == null) {
            m1952I();
            Code();
        }
        this.Code.setStrokeWidth(i);
        invalidate();
    }

    /* JADX INFO: renamed from: L */
    public final RectF m1960L() {
        return this.f2961V;
    }

    /* JADX INFO: renamed from: D */
    public final int m1957D() {
        return (int) this.f2959L.bottom;
    }

    /* JADX INFO: renamed from: C */
    public final int m1956C() {
        return (int) this.f2961V.bottom;
    }

    /* JADX INFO: renamed from: F */
    public final boolean m1958F() {
        return this.f2960S;
    }

    public void setOvalHasExpanded(boolean z) {
        this.f2960S = z;
    }

    /* JADX INFO: renamed from: e */
    public final void m1966e() {
        setOvalHasExpanded(true);
        m1949B(this.f2966e);
    }

    /* JADX INFO: renamed from: b */
    public final void m1964b() {
        setOvalHasExpanded(false);
        m1949B(this.f2969h);
    }

    /* JADX INFO: renamed from: B */
    private void m1949B(final AnimatorSet animatorSet) {
        this.f2968g.post(new Runnable() { // from class: com.facetec.sdk.bv.2
            @Override // java.lang.Runnable
            public final void run() {
                AnimatorSet animatorSet2 = animatorSet;
                if (animatorSet2 == null) {
                    Context unused = C2182bv.this.f2954B;
                    EnumC2119B enumC2119B = EnumC2119B.NON_FATAL_ERROR;
                    C2120C.m1362B();
                    return;
                }
                animatorSet2.start();
            }
        });
    }

    /* JADX INFO: renamed from: d */
    public final void m1965d() {
        this.f2966e.cancel();
        this.f2963b.cancel();
        this.f2969h.cancel();
    }

    /* JADX INFO: renamed from: I */
    public final void m1959I(final Runnable runnable, boolean z) {
        float f;
        m1961S();
        FaceTecExitAnimationStyle faceTecExitAnimationStyle = z ? FaceTecSDK.f2235I.f2223e : FaceTecSDK.f2235I.f2220b;
        int i = AnonymousClass3.f2973B[faceTecExitAnimationStyle.ordinal()];
        float f2 = 1.0f;
        int i2 = LogSeverity.EMERGENCY_VALUE;
        if (i != 2) {
            f = 2.1f;
            if (i != 3) {
                if (i == 4) {
                    this.Code.setColor(C2156av.m1753c(this.f2954B));
                    i2 = 1000;
                }
                f = 1.0f;
            }
            f2 = 1.8f;
        } else {
            f = 1.0f;
        }
        if (faceTecExitAnimationStyle != FaceTecExitAnimationStyle.NONE) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<C2182bv, Float>) View.SCALE_X, getScaleX(), f2);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<C2182bv, Float>) View.SCALE_Y, getScaleY(), f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(i2);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.bv.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    C2182bv.this.setVisibility(4);
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
            m1949B(animatorSet);
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bv$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: B */
        static final /* synthetic */ int[] f2973B;

        static {
            int[] iArr = new int[FaceTecExitAnimationStyle.values().length];
            f2973B = iArr;
            try {
                iArr[FaceTecExitAnimationStyle.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2973B[FaceTecExitAnimationStyle.RIPPLE_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2973B[FaceTecExitAnimationStyle.RIPPLE_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2973B[FaceTecExitAnimationStyle.CIRCLE_FADE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2961V != null) {
            canvas.drawRect(-400.0f, -400.0f, getWidth() + LogSeverity.EMERGENCY_VALUE, getHeight() + LogSeverity.EMERGENCY_VALUE, this.f2956D);
            canvas.drawOval(this.f2961V, this.f2958I);
            canvas.drawOval(this.f2957F, this.Code);
        }
        Z z = this.f2967f;
        if (z != null) {
            z.m1969Z(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I */
    public void m1952I() {
        setLayerType(1, null);
        Paint paint = new Paint(1);
        this.f2958I = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2958I.setAlpha(0);
        this.f2958I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setLayerType(2, null);
        Paint paint2 = new Paint(1);
        this.Code = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.Code.setStrokeWidth(this.f2965d);
        if (Build.MODEL.equals("Nokia 2.2") || Build.MODEL.equals("Nokia_2_2") || Build.MODEL.equals("LM-X520") || Build.MODEL.equals("G5") || Build.MODEL.equals("G5_Plus")) {
            this.Code.setAntiAlias(false);
        }
        Paint paint3 = new Paint(1);
        this.f2956D = paint3;
        paint3.setStyle(Paint.Style.FILL);
        Code();
    }

    /* JADX INFO: renamed from: V */
    final synchronized void m1963V(boolean z) {
        if (!this.f2970j || z) {
            this.f2970j = true;
            int width = getWidth();
            int height = C2156av.Code() < 1.0f ? Resources.getSystem().getDisplayMetrics().heightPixels : getHeight();
            float f = width;
            float f2 = 0.65f * f;
            float f3 = (f - f2) / 2.0f;
            float height2 = (getHeight() - (f2 * 1.48f)) / 2.0f;
            RectF rectF = new RectF();
            this.f2961V = rectF;
            rectF.set(f3, height2, f - f3, getHeight() - height2);
            RectF rectF2 = new RectF();
            this.f2957F = rectF2;
            rectF2.set(this.f2961V.left + (this.f2965d / 2.0f), this.f2961V.top + (this.f2965d / 2.0f), this.f2961V.right - (this.f2965d / 2.0f), this.f2961V.bottom - (this.f2965d / 2.0f));
            RectF rectF3 = new RectF();
            this.f2955C = rectF3;
            rectF3.set(this.f2961V.left + this.f2965d, this.f2961V.top + this.f2965d, this.f2961V.right - this.f2965d, this.f2961V.bottom - this.f2965d);
            float f4 = 0.98f * f;
            float f5 = (f - f4) / 2.0f;
            float f6 = f4 * 1.7f;
            float f7 = height - (f2953i << 1);
            if (f7 <= f6) {
                f6 = f7;
            }
            float height3 = (getHeight() - f6) / 2.0f;
            RectF rectF4 = new RectF();
            this.f2959L = rectF4;
            rectF4.set(f5, height3, f - f5, getHeight() - height3);
            this.f2967f = new Z();
        }
    }

    private void Code() {
        if (this.f2956D != null) {
            this.Code.setColor(C2156av.m1750b(this.f2954B));
            this.f2956D.setColor(C2156av.m1753c(this.f2954B));
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bv$Z */
    class Z implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: C */
        private final TimeInterpolator f2976C;
        private final int Code;

        /* JADX INFO: renamed from: F */
        private final int f2978F;

        /* JADX INFO: renamed from: V */
        private final Paint f2982V;

        /* JADX INFO: renamed from: Z */
        private final Paint f2983Z;

        /* JADX INFO: renamed from: B */
        private AnimatorSet f2975B = null;

        /* JADX INFO: renamed from: I */
        private RectF f2979I = null;

        /* JADX INFO: renamed from: S */
        private float f2981S = 0.0f;

        /* JADX INFO: renamed from: D */
        private float f2977D = 0.0f;

        /* JADX INFO: renamed from: L */
        private final ValueAnimator.AnimatorUpdateListener f2980L = this;

        Z() {
            int iM1647I = C2156av.m1647I(C2182bv.this.f2954B, FaceTecSDK.f2235I.f2221c.progressColor1);
            int iM1647I2 = C2156av.m1647I(C2182bv.this.f2954B, FaceTecSDK.f2235I.f2221c.progressColor2);
            this.f2982V = m1967B(iM1647I);
            this.f2983Z = m1967B(iM1647I2);
            this.Code = C2156av.m1678V(C2182bv.this.f2954B, FaceTecSDK.f2235I.f2221c.progressColor1);
            this.f2978F = C2156av.m1678V(C2182bv.this.f2954B, FaceTecSDK.f2235I.f2221c.progressColor2);
            this.f2976C = new AccelerateDecelerateInterpolator();
        }

        public final void setStartStrokePosition(float f) {
            this.f2981S = f;
        }

        public final void setEndStrokePosition(float f) {
            this.f2977D = f;
        }

        private boolean Code() {
            AnimatorSet animatorSet = this.f2975B;
            return animatorSet != null && animatorSet.isStarted();
        }

        /* JADX INFO: renamed from: V */
        final void m1968V() {
            if (Code()) {
                return;
            }
            if (this.f2979I == null) {
                float fM1993V = FaceTecSDK.f2235I.f2221c.progressRadialOffset == 0 ? C2182bv.this.f2964c + C2182bv.this.f2965d : C2188cb.m1993V((int) (FaceTecSDK.f2235I.f2221c.progressRadialOffset * C2156av.Code()));
                this.f2979I = new RectF(C2182bv.this.f2957F.left + fM1993V, C2182bv.this.f2957F.top + fM1993V, C2182bv.this.f2957F.right - fM1993V, C2182bv.this.f2957F.bottom - fM1993V);
            }
            ObjectAnimator objectAnimatorCode = Code(this.f2982V, this.Code);
            ObjectAnimator objectAnimatorCode2 = Code(this.f2983Z, this.f2978F);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "startStrokePosition", 0.0f, 360.0f);
            objectAnimatorOfFloat.addUpdateListener(this.f2980L);
            objectAnimatorOfFloat.setInterpolator(this.f2976C);
            objectAnimatorOfFloat.setDuration(C2182bv.this.f2960S ? 1000L : 800L);
            this.f2977D = 0.0f;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "endStrokePosition", 0.0f, 360.0f);
            objectAnimatorOfFloat2.setDuration(C2182bv.this.f2960S ? 1000L : 800L);
            objectAnimatorOfFloat2.addUpdateListener(this.f2980L);
            objectAnimatorOfFloat2.setInterpolator(this.f2976C);
            objectAnimatorOfFloat2.setStartDelay(C2182bv.this.f2960S ? 200L : 100L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f2975B = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorCode, objectAnimatorCode2);
            this.f2975B.start();
        }

        /* JADX INFO: renamed from: Z */
        final void m1969Z(Canvas canvas) {
            if (this.f2975B != null) {
                float f = this.f2981S;
                float f2 = -(f - this.f2977D);
                canvas.drawArc(this.f2979I, f, f2, false, this.f2983Z);
                canvas.drawArc(this.f2979I, (this.f2981S + 180.0f) % 360.0f, f2, false, this.f2982V);
            }
        }

        private ObjectAnimator Code(Paint paint, int i) {
            paint.setAlpha(Math.max(0, i - 50));
            double d = i;
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(paint, "alpha", (int) (0.8d * d), (int) (d * 0.24d));
            objectAnimatorOfInt.setDuration(500L);
            objectAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfInt.setStartDelay(C2182bv.this.f2960S ? 600L : 400L);
            return objectAnimatorOfInt;
        }

        /* JADX INFO: renamed from: B */
        private Paint m1967B(int i) {
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(C2182bv.this.f2964c);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setColor(i);
            return paint;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2182bv.this.invalidate();
        }
    }

    /* JADX INFO: renamed from: B */
    static /* synthetic */ void m1950B(C2182bv c2182bv) {
        float fWidth = c2182bv.f2959L.width() / c2182bv.f2961V.width();
        float fHeight = c2182bv.f2959L.height() / c2182bv.f2961V.height();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(c2182bv, (Property<C2182bv, Float>) View.SCALE_X, 1.0f, fWidth);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(c2182bv, (Property<C2182bv, Float>) View.SCALE_Y, 1.0f, fHeight);
        AnimatorSet animatorSet = new AnimatorSet();
        c2182bv.f2963b = animatorSet;
        animatorSet.setInterpolator(new OvershootInterpolator(0.8f));
        c2182bv.f2963b.setDuration(1600L);
        c2182bv.f2963b.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        c2182bv.f2962a = animatorSet2;
        animatorSet2.setDuration(0L);
        c2182bv.f2962a.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(c2182bv, (Property<C2182bv, Float>) View.SCALE_X, 1.0f, fWidth);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(c2182bv, (Property<C2182bv, Float>) View.SCALE_Y, 1.0f, fHeight);
        AnimatorSet animatorSet3 = new AnimatorSet();
        c2182bv.f2966e = animatorSet3;
        animatorSet3.setInterpolator(new OvershootInterpolator(1.5f));
        c2182bv.f2966e.setDuration(1200L);
        c2182bv.f2966e.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(c2182bv, (Property<C2182bv, Float>) View.SCALE_X, fWidth, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(c2182bv, (Property<C2182bv, Float>) View.SCALE_Y, fHeight, 1.0f);
        AnimatorSet animatorSet4 = new AnimatorSet();
        c2182bv.f2969h = animatorSet4;
        animatorSet4.setDuration(700L);
        c2182bv.f2969h.playTogether(objectAnimatorOfFloat5, objectAnimatorOfFloat6);
    }
}
