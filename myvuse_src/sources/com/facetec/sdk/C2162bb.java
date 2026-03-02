package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.facetec.sdk.FaceTecSDK;

/* JADX INFO: renamed from: com.facetec.sdk.bb */
/* JADX INFO: loaded from: classes3.dex */
class C2162bb extends AppCompatButton {

    /* JADX INFO: renamed from: B */
    int f2704B;

    /* JADX INFO: renamed from: C */
    FaceTecSDK.EnumC2125B f2705C;
    int Code;

    /* JADX INFO: renamed from: D */
    int f2706D;

    /* JADX INFO: renamed from: F */
    int f2707F;

    /* JADX INFO: renamed from: I */
    Drawable f2708I;

    /* JADX INFO: renamed from: L */
    boolean f2709L;

    /* JADX INFO: renamed from: S */
    int f2710S;

    /* JADX INFO: renamed from: V */
    int f2711V;

    /* JADX INFO: renamed from: a */
    private Typeface f2712a;

    /* JADX INFO: renamed from: b */
    private V f2713b;

    /* JADX INFO: renamed from: c */
    private boolean f2714c;

    /* JADX INFO: renamed from: d */
    private boolean f2715d;

    /* JADX INFO: renamed from: e */
    private int f2716e;

    /* JADX INFO: renamed from: g */
    private ValueAnimator f2717g;

    /* JADX INFO: renamed from: i */
    private ValueAnimator f2718i;

    /* JADX INFO: renamed from: j */
    private ValueAnimator f2719j;

    /* JADX INFO: renamed from: com.facetec.sdk.bb$V */
    enum V {
        Guidance,
        IDScan,
        OCRConfirmation
    }

    public C2162bb(Context context) {
        super(context);
        this.f2707F = 200;
        this.f2709L = false;
        this.f2714c = false;
        this.f2715d = false;
        this.f2713b = V.Guidance;
        this.f2705C = FaceTecSDK.EnumC2125B.NORMAL;
    }

    public C2162bb(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2707F = 200;
        this.f2709L = false;
        this.f2714c = false;
        this.f2715d = false;
        this.f2713b = V.Guidance;
        this.f2705C = FaceTecSDK.EnumC2125B.NORMAL;
    }

    public C2162bb(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2707F = 200;
        this.f2709L = false;
        this.f2714c = false;
        this.f2715d = false;
        this.f2713b = V.Guidance;
        this.f2705C = FaceTecSDK.EnumC2125B.NORMAL;
    }

    public void setOnClickListenerRunnable(final Runnable runnable) {
        setOnClickListener(new View.OnClickListener() { // from class: com.facetec.sdk.bb.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2162bb.this.setHighlighted(false, true);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    public void setupButton() {
        if (this.f2715d) {
            return;
        }
        this.f2715d = true;
        Context context = getContext();
        this.f2708I = ContextCompat.getDrawable(context, C2130R.drawable.facetec_button_background);
        int i = AnonymousClass7.f2725Z[this.f2713b.ordinal()];
        if (i == 1) {
            this.f2711V = C2156av.m1647I(context, isEnabled() ? C2156av.m1657J() : C2156av.m1664O());
            this.Code = C2156av.m1647I(context, isEnabled() ? C2156av.m1638E() : C2156av.m1663N());
            this.f2704B = C2156av.m1647I(context, C2156av.m1667R());
            this.f2710S = C2156av.m1694a();
            this.f2706D = C2156av.m1773p();
            this.f2716e = C2156av.f2646g;
            this.f2712a = FaceTecSDK.f2235I.f2215L.buttonFont;
        } else if (i == 2) {
            this.f2711V = C2156av.m1647I(context, isEnabled() ? C2156av.m1665P() : C2156av.m1686X());
            this.Code = C2156av.m1647I(context, isEnabled() ? C2156av.m1673T() : C2156av.m1674U());
            this.f2704B = C2156av.m1647I(context, C2156av.m1687Y());
            this.f2710S = C2156av.m1749b();
            this.f2706D = C2156av.m1775r();
            this.f2716e = C2156av.f2646g;
            this.f2712a = FaceTecSDK.f2235I.f2214I.buttonFont;
        } else if (i == 3) {
            this.f2711V = C2156av.m1647I(context, isEnabled() ? C2156av.m1729ag() : C2156av.m1726ad());
            this.Code = C2156av.m1647I(context, isEnabled() ? C2156av.m1723aa() : C2156av.m1728af());
            this.f2704B = C2156av.m1647I(context, C2156av.m1727ae());
            this.f2710S = C2156av.m1752c();
            this.f2706D = C2156av.m1774q();
            this.f2716e = C2156av.f2646g;
            this.f2712a = FaceTecSDK.f2235I.f2217V.buttonFont;
        }
        setTextSize(2, this.f2716e * C2156av.m1644I() * C2156av.Code());
        setTypeface(this.f2712a);
        setMaxLines(1);
        m1812I(false);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.bb.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!C2162bb.this.isEnabled()) {
                    return true;
                }
                if (motionEvent.getAction() == 0) {
                    C2162bb.this.setHighlighted(true, false);
                } else if (motionEvent.getAction() == 3 || motionEvent.getX() < 0.0f || motionEvent.getX() > C2162bb.this.getWidth() || motionEvent.getY() < 0.0f || motionEvent.getY() > C2162bb.this.getHeight()) {
                    C2162bb.this.setHighlighted(false, true);
                } else if (motionEvent.getAction() == 1) {
                    C2162bb.this.performClick();
                }
                return true;
            }
        });
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bb$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* JADX INFO: renamed from: Z */
        static final /* synthetic */ int[] f2725Z;

        static {
            int[] iArr = new int[V.values().length];
            f2725Z = iArr;
            try {
                iArr[V.Guidance.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2725Z[V.IDScan.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2725Z[V.OCRConfirmation.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void setupButtonForIdentityCheck() {
        this.f2713b = V.IDScan;
        this.f2715d = false;
        setupButton();
    }

    public void setupButtonForOCRConfirmation() {
        this.f2713b = V.OCRConfirmation;
        this.f2715d = false;
        setupButton();
    }

    /* JADX INFO: renamed from: I */
    final void m1812I(boolean z) {
        int iM1647I;
        int iM1647I2;
        int iM1647I3;
        int i;
        if (this.f2709L) {
            m1811Z();
        }
        this.f2709L = true;
        Context context = getContext();
        final float fCode = C2156av.Code();
        int i2 = 0;
        int i3 = z ? this.f2707F : 0;
        int i4 = this.f2711V;
        int i5 = this.f2704B;
        int i6 = this.Code;
        int i7 = AnonymousClass7.f2725Z[this.f2713b.ordinal()];
        if (i7 == 1) {
            iM1647I = C2156av.m1647I(context, C2156av.m1667R());
            if (!isEnabled()) {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1664O());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1663N());
            } else if (this.f2714c) {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1658K());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1662M());
            } else {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1657J());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1638E());
            }
        } else if (i7 == 2) {
            iM1647I = C2156av.m1647I(context, C2156av.m1687Y());
            if (!isEnabled()) {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1686X());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1674U());
            } else if (this.f2714c) {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1724ab());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1666Q());
            } else {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1665P());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1673T());
            }
        } else if (i7 == 3) {
            iM1647I = C2156av.m1647I(context, C2156av.m1727ae());
            if (!isEnabled()) {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1726ad());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1728af());
            } else if (this.f2714c) {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1725ac());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1685W());
            } else {
                iM1647I2 = C2156av.m1647I(context, C2156av.m1729ag());
                iM1647I3 = C2156av.m1647I(context, C2156av.m1723aa());
            }
        } else {
            i = 0;
            iM1647I3 = 0;
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i4), Integer.valueOf(i2));
            this.f2719j = valueAnimatorOfObject;
            long j = i3;
            valueAnimatorOfObject.setDuration(j);
            this.f2719j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bb.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C2162bb.this.f2711V = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    C2156av.m1651I(C2162bb.this.f2708I, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.f2719j.start();
            ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i5), Integer.valueOf(i));
            this.f2717g = valueAnimatorOfObject2;
            valueAnimatorOfObject2.setDuration(j);
            this.f2717g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bb.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C2162bb.this.f2704B = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    C2156av.m1628B(C2162bb.this.f2708I, ((Integer) valueAnimator.getAnimatedValue()).intValue(), Math.round(C2188cb.m1993V(C2162bb.this.f2710S) * fCode), C2188cb.m1993V(C2162bb.this.f2706D) * fCode);
                    C2162bb c2162bb = C2162bb.this;
                    c2162bb.setBackground(c2162bb.f2708I);
                    C2162bb.this.postInvalidate();
                }
            });
            this.f2717g.start();
            ValueAnimator valueAnimatorOfObject3 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i6), Integer.valueOf(iM1647I3));
            this.f2718i = valueAnimatorOfObject3;
            valueAnimatorOfObject3.setDuration(j);
            this.f2718i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bb.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    C2162bb.this.Code = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    C2162bb.this.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.f2718i.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.bb.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    C2162bb.this.f2709L = false;
                }
            });
            this.f2718i.start();
        }
        int i8 = iM1647I;
        i2 = iM1647I2;
        i = i8;
        ValueAnimator valueAnimatorOfObject4 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i4), Integer.valueOf(i2));
        this.f2719j = valueAnimatorOfObject4;
        long j2 = i3;
        valueAnimatorOfObject4.setDuration(j2);
        this.f2719j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bb.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C2162bb.this.f2711V = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                C2156av.m1651I(C2162bb.this.f2708I, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f2719j.start();
        ValueAnimator valueAnimatorOfObject22 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i5), Integer.valueOf(i));
        this.f2717g = valueAnimatorOfObject22;
        valueAnimatorOfObject22.setDuration(j2);
        this.f2717g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bb.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C2162bb.this.f2704B = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                C2156av.m1628B(C2162bb.this.f2708I, ((Integer) valueAnimator.getAnimatedValue()).intValue(), Math.round(C2188cb.m1993V(C2162bb.this.f2710S) * fCode), C2188cb.m1993V(C2162bb.this.f2706D) * fCode);
                C2162bb c2162bb = C2162bb.this;
                c2162bb.setBackground(c2162bb.f2708I);
                C2162bb.this.postInvalidate();
            }
        });
        this.f2717g.start();
        ValueAnimator valueAnimatorOfObject32 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i6), Integer.valueOf(iM1647I3));
        this.f2718i = valueAnimatorOfObject32;
        valueAnimatorOfObject32.setDuration(j2);
        this.f2718i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.bb.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C2162bb.this.Code = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                C2162bb.this.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f2718i.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.bb.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                C2162bb.this.f2709L = false;
            }
        });
        this.f2718i.start();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        m1812I(false);
    }

    public void setEnabled(boolean z, boolean z2) {
        if (isEnabled() == z) {
            if (this.f2709L) {
                return;
            }
            m1812I(false);
        } else {
            super.setEnabled(z);
            this.f2707F = 200;
            m1812I(z2);
        }
    }

    public void setHighlighted(boolean z) {
        setHighlighted(z, false);
    }

    public void setHighlighted(boolean z, boolean z2) {
        if (this.f2714c == z || !isEnabled()) {
            return;
        }
        this.f2714c = z;
        m1812I(z2);
    }

    /* JADX INFO: renamed from: Z */
    private void m1811Z() {
        this.f2719j.cancel();
        this.f2717g.cancel();
        this.f2718i.cancel();
    }
}
