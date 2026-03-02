package com.facetec.sdk;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import java.util.Random;

/* JADX INFO: renamed from: com.facetec.sdk.ax */
/* JADX INFO: loaded from: classes3.dex */
class C2158ax extends FrameLayout {

    /* JADX INFO: renamed from: B */
    private RoundedBitmapDrawable[] f2661B;

    /* JADX INFO: renamed from: C */
    private int[] f2662C;
    private boolean Code;

    /* JADX INFO: renamed from: D */
    private int f2663D;

    /* JADX INFO: renamed from: F */
    private Handler f2664F;

    /* JADX INFO: renamed from: I */
    private ImageView f2665I;

    /* JADX INFO: renamed from: L */
    private boolean f2666L;

    /* JADX INFO: renamed from: V */
    private ImageView f2667V;

    public C2158ax(Context context) {
        super(context);
        this.f2661B = new RoundedBitmapDrawable[0];
        this.f2662C = new int[0];
        this.f2663D = 0;
        this.f2666L = true;
        m1790I(context);
    }

    public C2158ax(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2661B = new RoundedBitmapDrawable[0];
        this.f2662C = new int[0];
        this.f2663D = 0;
        this.f2666L = true;
        m1790I(context);
    }

    public C2158ax(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2661B = new RoundedBitmapDrawable[0];
        this.f2662C = new int[0];
        this.f2663D = 0;
        this.f2666L = true;
        m1790I(context);
    }

    /* JADX INFO: renamed from: I */
    private void m1790I(Context context) {
        if (C2156av.m1701aE().length == 0) {
            return;
        }
        this.f2664F = new Handler(Looper.getMainLooper());
        this.f2665I = new ImageView(context);
        this.f2667V = new ImageView(context);
        this.f2665I.setAlpha(1.0f);
        this.f2667V.setAlpha(0.0f);
        this.f2665I.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f2665I.setAdjustViewBounds(true);
        this.f2667V.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f2667V.setAdjustViewBounds(true);
        this.Code = true;
        addView(this.f2665I);
        addView(this.f2667V);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(C2188cb.m1993V((int) (C2156av.m1772o() * C2156av.Code())));
        gradientDrawable.setStroke((int) C2188cb.m1993V(Math.max(C2156av.m1668S() == 0 ? 0 : 1, (int) (C2156av.m1668S() * C2156av.Code()))), C2156av.m1761g(context));
        gradientDrawable.setColor(0);
        setBackground(gradientDrawable);
        setClipToOutline(true);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        m1789I();
    }

    /* JADX INFO: renamed from: I */
    private void m1789I() {
        if (FaceTecSDK.f2235I.f2215L.enableRetryScreenSlideshowShuffle) {
            int[] iArrM1701aE = C2156av.m1701aE();
            Random random = new Random();
            for (int i = 0; i < iArrM1701aE.length; i++) {
                int iNextInt = random.nextInt(iArrM1701aE.length);
                int i2 = iArrM1701aE[iNextInt];
                iArrM1701aE[iNextInt] = iArrM1701aE[i];
                iArrM1701aE[i] = i2;
            }
            this.f2662C = iArrM1701aE;
        } else {
            this.f2662C = C2156av.m1701aE();
        }
        this.f2661B = new RoundedBitmapDrawable[this.f2662C.length];
        for (int i3 = 0; i3 < this.f2662C.length; i3++) {
            this.f2661B[i3] = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactoryInstrumentation.decodeResource(getResources(), this.f2662C[i3]));
        }
        this.f2665I.setImageDrawable(this.f2661B[this.f2663D]);
    }

    /* JADX INFO: renamed from: Z */
    final void m1795Z() {
        if (this.f2662C.length == 0) {
            return;
        }
        this.f2663D = 0;
        this.f2666L = true;
        m1788D();
        Code();
    }

    /* JADX INFO: renamed from: B */
    final void m1794B() {
        Handler handler = this.f2664F;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f2664F = null;
        }
    }

    /* JADX INFO: renamed from: V */
    private int m1792V() {
        int i = this.f2663D;
        if (i == this.f2661B.length - 1) {
            return 0;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code() {
        int iM1792V = m1792V();
        this.f2663D = iM1792V;
        RoundedBitmapDrawable roundedBitmapDrawable = this.f2661B[iM1792V];
        if (this.Code) {
            this.f2667V.setImageDrawable(roundedBitmapDrawable);
        } else {
            this.f2665I.setImageDrawable(roundedBitmapDrawable);
        }
    }

    /* JADX INFO: renamed from: S */
    private void m1791S() {
        if (this.Code) {
            this.f2667V.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
            this.f2665I.animate().alpha(0.0f).setDuration(800L).setListener(null).start();
        } else {
            this.f2667V.animate().alpha(0.0f).setDuration(800L).setListener(null).start();
            this.f2665I.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
        }
        this.Code = !this.Code;
        Handler handler = this.f2664F;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.facetec.sdk.ax.4
                @Override // java.lang.Runnable
                public final void run() {
                    C2158ax.this.Code();
                }
            }, 800L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: D */
    public void m1788D() {
        Handler handler;
        if (!this.f2666L) {
            m1791S();
        }
        int i = FaceTecSDK.f2235I.f2215L.retryScreenSlideshowInterval;
        if (this.f2666L) {
            i /= 2;
            this.f2666L = false;
        }
        int iMax = Math.max(500, i);
        if (this.f2662C.length <= 1 || (handler = this.f2664F) == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.facetec.sdk.ax.5
            @Override // java.lang.Runnable
            public final void run() {
                C2158ax.this.m1788D();
            }
        }, iMax);
    }
}
