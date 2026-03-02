package com.microblink.fragment.overlay.blinkid.reticleui;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class PulseView extends View {
    private int IIlIIIllIl;
    private int IlIllIlIIl;
    PulseAnimator IllIIIIllI;
    private Runnable IllIIIllII;
    private int lIIIIIllll;
    private Paint lIlIIIIlIl;
    private boolean llIIIlllll;
    private int llIIlIIlll;
    private Handler llIIlIlIIl;

    /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.reticleui.PulseView$2 */
    /* JADX INFO: compiled from: line */
    class RunnableC36842 implements Runnable {
        RunnableC36842() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PulseView.this.IllIIIIllI.IllIIIIllI() || !PulseView.this.llIIIlllll) {
                return;
            }
            if (PulseView.this.IllIIIllII != null) {
                PulseView.this.llIIlIlIIl.removeCallbacks(PulseView.this.IllIIIllII);
            }
            PulseView.this.IllIIIllII = new Runnable() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.PulseView.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PulseView.this.IllIIIIllI.IllIIIIllI() || !PulseView.this.llIIIlllll) {
                        return;
                    }
                    PulseView.this.IllIIIIllI.llIIlIIlll();
                }
            };
            PulseView.this.llIIlIlIIl.postDelayed(PulseView.this.IllIIIllII, PulseView.this.IlIllIlIIl);
        }
    }

    public PulseView(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.lIlIIIIlIl.setAlpha((int) (this.lIIIIIllll * this.IllIIIIllI.IlIllIlIIl()));
        this.lIlIIIIlIl.setStrokeWidth(this.IIlIIIllIl * this.IllIIIIllI.llIIIlllll());
        float f = this.llIIlIIlll;
        canvas.drawCircle(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f, (this.IllIIIIllI.IllIIIllII() * f) + f, this.lIlIIIIlIl);
    }

    public void setAnimationEnabled(boolean z) {
        this.llIIIlllll = z;
        if (z && !this.IllIIIIllI.IllIIIIllI()) {
            this.llIIlIlIIl.post(new RunnableC36842());
        } else {
            if (this.llIIIlllll) {
                return;
            }
            this.IllIIIIllI.llIIlIlIIl();
        }
    }

    public void setup(int i) {
        Paint paint = new Paint();
        this.lIlIIIIlIl = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.lIlIIIIlIl.setColor(i);
        this.lIlIIIIlIl.setAntiAlias(true);
        Resources resources = getContext().getResources();
        this.llIIlIIlll = resources.getDimensionPixelOffset(C3714R.dimen.mb_pulse_size_offset);
        this.IIlIIIllIl = resources.getDimensionPixelOffset(C3714R.dimen.mb_pulse_stroke_width);
        this.lIIIIIllll = this.lIlIIIIlIl.getAlpha();
        PulseAnimator pulseAnimator = new PulseAnimator(this);
        this.IllIIIIllI = pulseAnimator;
        pulseAnimator.llIIlIlIIl(new AnimationEndListener() { // from class: com.microblink.fragment.overlay.blinkid.reticleui.PulseView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PulseView.this.IllIIIIllI.lIlIIIIlIl();
                PulseView.llIIlIlIIl(PulseView.this);
            }
        });
    }

    public PulseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static void llIIlIlIIl(PulseView pulseView) {
        pulseView.llIIlIlIIl.post(pulseView.new RunnableC36842());
    }

    public PulseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.llIIlIlIIl = new Handler(Looper.getMainLooper());
        this.IlIllIlIIl = 1000;
        this.llIIIlllll = true;
    }
}
