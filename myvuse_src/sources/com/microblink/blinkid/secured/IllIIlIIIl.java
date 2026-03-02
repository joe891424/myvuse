package com.microblink.blinkid.secured;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;
import com.microblink.geometry.Point;
import com.microblink.geometry.Quadrilateral;
import com.microblink.library.C3714R;
import com.microblink.util.Log;
import com.microblink.view.OnSizeChangedListener;
import com.microblink.view.recognition.DetectionStatus;
import com.microblink.view.viewfinder.quadview.QuadViewAnimationListener;
import com.microblink.view.viewfinder.quadview.QuadViewManager;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class IllIIlIIIl extends View implements ValueAnimator.AnimatorUpdateListener {
    private int IIlIIIllIl;
    private final Animator.AnimatorListener IlIIlIIIII;
    private int IlIIlllIIl;
    private double IlIllIlIIl;
    private Quadrilateral IlIllIlllI;
    private IllllIIlII IlIlllllII;
    private int IllIIIIllI;
    private int IllIIIllII;
    private int IllIIlIIII;
    private boolean lIIIIIlIlI;
    private long lIIIIIllll;
    private int lIlIIIIlIl;
    private OnSizeChangedListener lIllIIlIIl;
    private boolean lIlllIlIlI;
    private int llIIIlllll;
    private ValueAnimator llIIlIIIll;
    private int llIIlIIlll;
    private double llIIlIlIIl;
    private boolean llIllIIlll;
    private Quadrilateral lllIIIlIlI;
    private QuadViewAnimationListener lllIIlIIlI;
    private int lllIlIlIIl;
    private final Handler lllllIlIll;

    /* JADX INFO: compiled from: line */
    class llIIlIlIIl implements Animator.AnimatorListener {
        llIIlIlIIl() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (IllIIlIIIl.this.lllIIlIIlI != null) {
                IllIIlIIIl.this.lllIIlIIlI.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (IllIIlIIIl.this.lllIIlIIlI != null) {
                IllIIlIIIl.this.lllIIlIIlI.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (IllIIlIIIl.this.lllIIlIIlI != null) {
                IllIIlIIIl.this.lllIIlIIlI.onAnimationEnd();
                IllIIlIIIl.this.lllIIlIIlI.onAnimationStart();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (IllIIlIIIl.this.lllIIlIIlI != null) {
                IllIIlIIIl.this.lllIIlIIlI.onAnimationStart();
            }
        }
    }

    public IllIIlIIIl(Context context, IllllIIlII illllIIlII, double d, double d2, int i) {
        super(context);
        this.llIIlIlIIl = 0.11d;
        this.IlIllIlIIl = 0.11d;
        this.IllIIIllII = -1;
        this.llIIIlllll = -1;
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = -1;
        this.llIIlIIlll = -1;
        this.IIlIIIllIl = -1;
        this.lIIIIIllll = 500L;
        this.lllIIIlIlI = new Quadrilateral();
        this.IlIllIlllI = new Quadrilateral();
        this.IlIlllllII = null;
        this.llIIlIIIll = null;
        this.IlIIlllIIl = 1;
        this.llIllIIlll = false;
        this.lllllIlIll = new Handler();
        this.lIlllIlIlI = true;
        this.IlIIlIIIII = new llIIlIlIIl();
        llIIlIlIIl(illllIIlII, d, d2, i);
    }

    public IllllIIlII getQuadDrawer() {
        return this.IlIlllllII;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.lllIIIlIlI = (Quadrilateral) valueAnimator.getAnimatedValue();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = this.IIlIIIllIl <= 0;
        if (this.IllIIIllII == -1) {
            this.IllIIIllII = getWidth();
        }
        if (this.llIIIlllll == -1) {
            this.llIIIlllll = getHeight();
        }
        int i = this.IllIIIllII;
        int i2 = (int) ((1.0d - this.llIIlIlIIl) * ((double) i));
        int i3 = this.llIIIlllll;
        int i4 = (i3 - ((int) ((1.0d - this.IlIllIlIIl) * ((double) i3)))) / 2;
        this.IllIIIIllI = i4;
        int i5 = (i - i2) / 2;
        this.lIlIIIIlIl = i5;
        int i6 = i - i5;
        this.llIIlIIlll = i6;
        int i7 = i3 - i4;
        this.IIlIIIllIl = i7;
        int i8 = this.IlIIlllIIl;
        if (i8 == 8 || i8 == 9) {
            this.IllIIIIllI = i7;
            this.IIlIIIllIl = i4;
            this.lIlIIIIlIl = i6;
            this.llIIlIIlll = i5;
        }
        if (z) {
            this.lllIIIlIlI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, i8);
            this.lllIIIlIlI.setColor(this.lllIlIlIIl);
            this.lllIIIlIlI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.lllIIIlIlI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
            this.IlIllIlllI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl);
            this.IlIllIlllI.setColor(this.lllIlIlIIl);
            this.IlIllIlllI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.IlIllIlllI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
        } else if (this.lllIIIlIlI.isDefaultQuad() && !this.lllIIIlIlI.matchesMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl)) {
            this.lllIIIlIlI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl);
            this.lllIIIlIlI.setColor(this.lllIlIlIIl);
            this.lllIIIlIlI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.lllIIIlIlI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
            this.IlIllIlllI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl);
            this.IlIllIlllI.setColor(this.lllIlIlIIl);
            this.IlIllIlllI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.IlIllIlllI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
        }
        this.IlIlllllII.llIIlIlIIl(this.lllIIIlIlI, canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.IllIIIllII = getWidth();
        this.llIIIlllll = getHeight();
        Log.m2707d(this, "QuadView layouting to size: {}x{}", Integer.valueOf(this.IllIIIllII), Integer.valueOf(this.llIIIlllll));
        OnSizeChangedListener onSizeChangedListener = this.lIllIIlIIl;
        if (onSizeChangedListener != null) {
            onSizeChangedListener.onSizeChanged(this.IllIIIllII, this.llIIIlllll);
        }
    }

    public void setAnimationDuration(long j) {
        this.lIIIIIllll = j;
    }

    public void setAnimationListener(QuadViewAnimationListener quadViewAnimationListener) {
        this.lllIIlIIlI = quadViewAnimationListener;
    }

    public void setDefaultQuadColor(int i) {
        this.lllIlIlIIl = i;
    }

    public void setDetectedQuadColor(int i) {
        this.IllIIlIIII = i;
    }

    public void setHostActivityOrientation(int i) {
        int i2 = this.IlIIlllIIl;
        boolean z = true;
        if (((i2 != 1 && i2 != 9) || (i != 0 && i != 8)) && ((i2 != 0 && i2 != 8) || (i != 1 && i != 9))) {
            z = false;
        }
        this.IlIIlllIIl = i;
        if (z) {
            double d = this.IlIllIlIIl;
            this.IlIllIlIIl = this.llIIlIlIIl;
            this.llIIlIlIIl = d;
        }
    }

    public void setMirrored(boolean z) {
        this.llIllIIlll = z;
    }

    public void setMovable(boolean z) {
        this.lIlllIlIlI = z;
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.lIllIIlIIl = onSizeChangedListener;
    }

    private void IlIllIlIIl(DetectionStatus detectionStatus) {
        if (detectionStatus == DetectionStatus.SUCCESS || (detectionStatus != DetectionStatus.FAIL && this.lIIIIIlIlI)) {
            this.IlIllIlllI.setColor(this.IllIIlIIII);
        } else {
            this.IlIllIlllI.setColor(this.lllIlIlIIl);
        }
        if (this.IllIIIIllI != this.IIlIIIllIl) {
            this.lllllIlIll.post(new IlllIIlIIl(this));
        }
    }

    private void llIIlIlIIl(IllllIIlII illllIIlII, double d, double d2, int i) {
        this.IlIlllllII = illllIIlII;
        this.IlIllIlIIl = d2;
        this.llIIlIlIIl = d;
        this.lllIlIlIIl = getResources().getColor(C3714R.color.mb_default_frame);
        this.IllIIlIIII = getResources().getColor(C3714R.color.mb_recognized_frame);
        setBackgroundColor(0);
        this.IlIIlllIIl = i;
        if (isInEditMode()) {
            return;
        }
        setLayerType(2, illllIIlII.llIIlIlIIl());
    }

    public void llIIlIlIIl(boolean z) {
        this.lIIIIIlIlI = z;
    }

    public boolean llIIlIlIIl() {
        ValueAnimator valueAnimator = this.llIIlIIIll;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public void llIIlIlIIl(Quadrilateral quadrilateral, DetectionStatus detectionStatus) {
        Quadrilateral quadrilateral2;
        if (this.lIlllIlIlI) {
            Quadrilateral sortedQuad = quadrilateral.getSortedQuad();
            Log.m2711i(QuadViewManager.class, "Building quad from unit quad {} and view size ({}x{}) in host activity orientation {}.", sortedQuad, Integer.valueOf(this.IllIIIllII), Integer.valueOf(this.llIIIlllll), Integer.valueOf(this.IlIIlllIIl));
            Point upperLeft = sortedQuad.getUpperLeft();
            Point upperRight = sortedQuad.getUpperRight();
            Point lowerLeft = sortedQuad.getLowerLeft();
            Point lowerRight = sortedQuad.getLowerRight();
            int i = this.IlIIlllIIl;
            if (i == 9 || i == 8) {
                upperLeft = upperLeft.mirrorXY(1.0f, 1.0f);
                upperRight = upperRight.mirrorXY(1.0f, 1.0f);
                lowerLeft = lowerLeft.mirrorXY(1.0f, 1.0f);
                lowerRight = lowerRight.mirrorXY(1.0f, 1.0f);
            }
            int i2 = this.IlIIlllIIl;
            if (i2 != 1 && i2 != 9) {
                quadrilateral2 = new Quadrilateral(new Point(upperLeft.getX() * this.IllIIIllII, upperLeft.getY() * this.llIIIlllll), new Point(upperRight.getX() * this.IllIIIllII, upperRight.getY() * this.llIIIlllll), new Point(lowerLeft.getX() * this.IllIIIllII, lowerLeft.getY() * this.llIIIlllll), new Point(lowerRight.getX() * this.IllIIIllII, lowerRight.getY() * this.llIIIlllll));
            } else {
                quadrilateral2 = new Quadrilateral(new Point((1.0f - upperLeft.getY()) * this.IllIIIllII, upperLeft.getX() * this.llIIIlllll), new Point((1.0f - upperRight.getY()) * this.IllIIIllII, upperRight.getX() * this.llIIIlllll), new Point((1.0f - lowerLeft.getY()) * this.IllIIIllII, lowerLeft.getX() * this.llIIIlllll), new Point((1.0f - lowerRight.getY()) * this.IllIIIllII, lowerRight.getX() * this.llIIIlllll));
            }
            this.IlIllIlllI = quadrilateral2;
            IlIllIlIIl(detectionStatus);
        }
    }

    public void llIIlIlIIl(DetectionStatus detectionStatus) {
        Quadrilateral quadrilateral;
        if (!this.lIlllIlIlI || (quadrilateral = this.IlIllIlllI) == null) {
            return;
        }
        quadrilateral.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, this.IlIIlllIIl);
        this.IlIllIlllI.setIsDefaultQuad(true);
        if (this.llIllIIlll) {
            this.IlIllIlllI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
        }
        IlIllIlIIl(detectionStatus);
    }

    public void llIIlIlIIl(double d, double d2) {
        this.llIIlIlIIl = d;
        this.IlIllIlIIl = d2;
        if (this.IllIIIIllI != this.IIlIIIllIl) {
            int i = this.IllIIIllII;
            int i2 = this.llIIIlllll;
            int i3 = (i2 - ((int) ((1.0d - d2) * ((double) i2)))) / 2;
            this.IllIIIIllI = i3;
            int i4 = (i - ((int) ((1.0d - d) * ((double) i)))) / 2;
            this.lIlIIIIlIl = i4;
            int i5 = i - i4;
            this.llIIlIIlll = i5;
            int i6 = i2 - i3;
            this.IIlIIIllIl = i6;
            int i7 = this.IlIIlllIIl;
            if (i7 == 8 || i7 == 9) {
                this.IllIIIIllI = i6;
                this.IIlIIIllIl = i3;
                this.lIlIIIIlIl = i5;
                this.llIIlIIlll = i4;
            }
            this.IlIllIlllI.setMargins(this.IllIIIIllI, this.IIlIIIllIl, this.lIlIIIIlIl, this.llIIlIIlll, i7);
            this.IlIllIlllI.setIsDefaultQuad(true);
            if (this.llIllIIlll) {
                this.IlIllIlllI.mirror(this.IllIIIllII, this.llIIIlllll, this.IlIIlllIIl);
            }
            this.lllIIIlIlI.setIsDefaultQuad(false);
            this.lllllIlIll.post(new IlllIIlIIl(this));
        }
    }
}
