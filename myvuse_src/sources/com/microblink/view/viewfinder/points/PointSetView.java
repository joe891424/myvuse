package com.microblink.view.viewfinder.points;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.microblink.geometry.Point;
import com.microblink.geometry.PointSet;
import com.microblink.library.C3714R;
import com.microblink.metadata.detection.points.DisplayablePointsDetection;
import com.microblink.util.Log;
import java.util.List;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class PointSetView extends View implements IDisplayablePointsView, ValueAnimator.AnimatorUpdateListener {
    private final Handler IIlIIIllIl;
    private int IlIllIlIIl;
    private llIIlIlIIl IlIllIlllI;
    private PointSet IllIIIIllI;
    private int IllIIIllII;
    private int lIIIIIllll;
    private PointSet lIlIIIIlIl;
    private int llIIIlllll;
    private ValueAnimator llIIlIIlll;
    private Paint llIIlIlIIl;
    private int lllIIIlIlI;
    private int lllIlIlIIl;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: line */
    class llIIlIlIIl {
        public int IlIllIlIIl;
        public int llIIlIlIIl;

        public llIIlIlIIl(PointSetView pointSetView, int i, int i2) {
            this.llIIlIlIIl = i;
            this.IlIllIlIIl = i2;
        }
    }

    public PointSetView(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        super(context, attributeSet);
        this.IlIllIlIIl = -1;
        this.IllIIIllII = -1;
        this.llIIIlllll = 15;
        this.IllIIIIllI = null;
        this.lIlIIIIlIl = null;
        this.llIIlIIlll = null;
        this.IIlIIIllIl = new Handler();
        this.lIIIIIllll = -1;
        this.lllIIIlIlI = -1;
        this.lllIlIlIIl = 1;
        setBackgroundColor(0);
        this.lllIlIlIIl = i;
        this.llIIlIlIIl = new Paint(1);
        this.llIIlIlIIl.setStrokeWidth((context.getResources().getDisplayMetrics().densityDpi + 49) / 50);
        this.llIIlIlIIl.setStrokeCap(Paint.Cap.ROUND);
        this.llIIlIlIIl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.lIIIIIllll = i3;
        this.llIIIlllll = i2;
        this.lllIIIlIlI = 16777215 & i3;
        this.IlIllIlllI = new llIIlIlIIl(this, 0, i3);
        setLayerType(1, null);
    }

    @Override // com.microblink.view.viewfinder.points.IDisplayablePointsView
    public void addDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        setDisplayablePointsDetection(displayablePointsDetection);
    }

    @Override // com.microblink.view.viewfinder.IDetectionView
    public void clearDisplayedContent() {
        addDisplayablePointsDetection(null);
    }

    @Override // com.microblink.view.viewfinder.IDetectionView
    public View getView() {
        return this;
    }

    public boolean isAnimationInProgress() {
        ValueAnimator valueAnimator = this.llIIlIIlll;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.IlIllIlllI = (llIIlIlIIl) valueAnimator.getAnimatedValue();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.IlIllIlIIl == -1) {
            this.IlIllIlIIl = getWidth();
        }
        if (this.IllIIIllII == -1) {
            this.IllIIIllII = getHeight();
        }
        PointSet pointSet = this.IllIIIIllI;
        PointSet pointSet2 = this.lIlIIIIlIl;
        if (pointSet != null) {
            this.llIIlIlIIl.setColor(this.IlIllIlllI.llIIlIlIIl);
            pointSet.draw(canvas, this.llIIlIlIIl, this.llIIIlllll);
        }
        if (pointSet2 != null) {
            this.llIIlIlIIl.setColor(this.IlIllIlllI.IlIllIlIIl);
            pointSet2.draw(canvas, this.llIIlIlIIl, this.llIIIlllll);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.IlIllIlIIl = getWidth();
        this.IllIIIllII = getHeight();
        Log.m2713v(this, "PointSetView layouting to size: {}x{}", Integer.valueOf(this.IlIllIlIIl), Integer.valueOf(this.IllIIIllII));
    }

    @Override // com.microblink.view.viewfinder.points.IDisplayablePointsView
    public void setDisplayablePointsDetection(DisplayablePointsDetection displayablePointsDetection) {
        this.lIlIIIIlIl = this.IllIIIIllI;
        if (displayablePointsDetection != null) {
            List<Point> points = displayablePointsDetection.getTransformedPointSet().getPoints();
            for (Point point : points) {
                int i = this.lllIlIlIIl;
                if (i == 8 || i == 9) {
                    point.mirrorXYInPlace(1.0f, 1.0f);
                }
                float x = point.getX();
                float y = point.getY();
                int i2 = this.lllIlIlIIl;
                if (i2 == 1 || i2 == 9) {
                    point.setX((1.0f - y) * this.IlIllIlIIl);
                    point.setY(x * this.IllIIIllII);
                } else {
                    point.setX(x * this.IlIllIlIIl);
                    point.setY(y * this.IllIIIllII);
                }
            }
            this.IllIIIIllI = new PointSet(points);
        } else {
            this.IllIIIIllI = null;
        }
        this.IIlIIIllIl.post(new com.microblink.view.viewfinder.points.llIIlIlIIl(this));
    }

    @Override // com.microblink.view.viewfinder.IDetectionView
    public void setHostActivityOrientation(int i) {
        this.lllIlIlIIl = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: line */
    class IlIllIlIIl implements TypeEvaluator<llIIlIlIIl> {
        private ArgbEvaluator llIIlIlIIl;

        private IlIllIlIIl() {
            this.llIIlIlIIl = new ArgbEvaluator();
        }

        @Override // android.animation.TypeEvaluator
        public llIIlIlIIl evaluate(float f, llIIlIlIIl lliililiil, llIIlIlIIl lliililiil2) {
            llIIlIlIIl lliililiil3 = lliililiil;
            llIIlIlIIl lliililiil4 = lliililiil2;
            return new llIIlIlIIl(PointSetView.this, ((Integer) this.llIIlIlIIl.evaluate(f, Integer.valueOf(lliililiil3.llIIlIlIIl), Integer.valueOf(lliililiil4.llIIlIlIIl))).intValue(), ((Integer) this.llIIlIlIIl.evaluate(f, Integer.valueOf(lliililiil3.IlIllIlIIl), Integer.valueOf(lliililiil4.IlIllIlIIl))).intValue());
        }

        /* synthetic */ IlIllIlIIl(PointSetView pointSetView, com.microblink.view.viewfinder.points.llIIlIlIIl lliililiil) {
            this();
        }
    }

    public PointSetView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 15, context.getResources().getColor(C3714R.color.mb_recognized_frame));
    }
}
