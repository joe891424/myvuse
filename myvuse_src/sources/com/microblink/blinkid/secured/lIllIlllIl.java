package com.microblink.blinkid.secured;

import android.content.Context;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.util.Log;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lIllIlllIl extends ViewGroup {
    private Orientation IlIllIlIIl;
    private int IllIIIIllI;
    private Orientation IllIIIllII;
    private int lIlIIIIlIl;
    private boolean llIIIlllll;
    private Matrix llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    private class llIIlIlIIl extends Animation {
        private float IlIllIlIIl;
        private float IllIIIIllI;
        private float IllIIIllII;
        private float lIlIIIIlIl;
        private float llIIIlllll;
        private float llIIlIlIIl;

        public llIIlIlIIl(lIllIlllIl lillilllil, float f, float f2, float f3, float f4, boolean z) {
            this.llIIlIlIIl = f;
            this.IlIllIlIIl = f2;
            if (z) {
                this.IllIIIllII = (f3 - f4) * 0.5f;
                this.llIIIlllll = (f4 - f3) * 0.5f;
            } else {
                this.IllIIIllII = 0.0f;
                this.llIIIlllll = 0.0f;
            }
            if (z) {
                this.IllIIIIllI = f4 * 0.5f;
                this.lIlIIIIlIl = f3 * 0.5f;
            } else {
                this.IllIIIIllI = f3 * 0.5f;
                this.lIlIIIIlIl = f4 * 0.5f;
            }
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            transformation.getMatrix().preTranslate(this.IllIIIllII, this.llIIIlllll);
            Matrix matrix = transformation.getMatrix();
            float f2 = this.llIIlIlIIl;
            matrix.preRotate(((this.IlIllIlIIl - f2) * f) + f2, this.IllIIIIllI, this.lIlIIIIlIl);
        }
    }

    public lIllIlllIl(Context context, int i, Orientation orientation, boolean z, int i2) {
        super(context);
        this.llIIlIlIIl = new Matrix();
        Orientation orientation2 = Orientation.ORIENTATION_PORTRAIT;
        this.IlIllIlIIl = orientation2;
        this.IllIIIllII = orientation2;
        this.llIIIlllll = true;
        this.IllIIIIllI = 500;
        this.lIlIIIIlIl = 1;
        setClipChildren(false);
        this.lIlIIIIlIl = i;
        this.IllIIIllII = orientation;
        this.IlIllIlIIl = llIIlIlIIl(orientation);
        this.llIIIlllll = z;
        this.IllIIIIllI = i2;
        if (isInEditMode()) {
            return;
        }
        setLayerType(2, null);
    }

    private Orientation llIIlIlIIl(Orientation orientation) {
        int iOrdinal = orientation.ordinal();
        int i = this.lIlIIIIlIl;
        Orientation orientation2 = Orientation.values()[(iOrdinal + (i != 0 ? i != 8 ? i != 9 ? 0 : 2 : 1 : 3)) % 4];
        Log.m2707d(this, "Normalized orientation {} to {}", orientation, orientation2);
        return orientation2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float[] fArr = {motionEventObtain.getRawX(), motionEventObtain.getRawY()};
        Log.m2707d(this, "Tap coordinate: ({}, {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Log.m2707d(this, "Location on screen: ({}, {})", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        float f = fArr[0] - iArr[0];
        fArr[0] = f;
        fArr[1] = fArr[1] - iArr[1];
        Log.m2707d(this, "View-normalized tap coordinate: ({}, {})", Float.valueOf(f), Float.valueOf(fArr[1]));
        this.llIIlIlIIl.mapPoints(fArr);
        Log.m2707d(this, "Mapped tap coordinate: ({} {})", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        motionEventObtain.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEventObtain);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        Log.m2707d(this, "Rotatable view group ({} childs) layouting to: top: {} bottom: {}, left: {}, right: {} (changed: {}) ", Integer.valueOf(childCount), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
        int width = getWidth();
        int height = getHeight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(getChildDrawingOrder(childCount, i5));
            if (this.IlIllIlIIl.isHorizontal()) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(height, 1073741824), View.MeasureSpec.makeMeasureSpec(width, 1073741824));
                Log.m2711i(this, "Horizontal layouting child {} to: top: {} bottom: {}, left: {}, right: {}", Integer.valueOf(i5), 0, Integer.valueOf(width), 0, Integer.valueOf(height));
                childAt.layout(0, 0, height, width);
            } else {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                Log.m2711i(this, "Vertical layouting child {} to: top: {} bottom: {}, left: {}, right: {}", Integer.valueOf(i5), 0, Integer.valueOf(height), 0, Integer.valueOf(width));
                childAt.layout(0, 0, width, height);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iResolveSize = ViewGroup.resolveSize(getSuggestedMinimumWidth(), i);
        int iResolveSize2 = ViewGroup.resolveSize(getSuggestedMinimumHeight(), i2);
        if (!this.IlIllIlIIl.isHorizontal()) {
            iResolveSize2 = iResolveSize;
            iResolveSize = iResolveSize2;
        }
        Log.m2707d(this, "Measured dimension: {}x{}", Integer.valueOf(iResolveSize2), Integer.valueOf(iResolveSize));
        setMeasuredDimension(iResolveSize2, iResolveSize);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.m2707d(this, "[RotatableViewGroup] size changed from {}x{} to {}x{}", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == i3 && i2 == i4) {
            return;
        }
        Animation animationLlIIlIlIIl = llIIlIlIIl(Orientation.ORIENTATION_PORTRAIT, this.IlIllIlIIl);
        if (animationLlIIlIlIIl != null) {
            animationLlIIlIlIIl.setFillEnabled(true);
            animationLlIIlIlIIl.setDuration(0L);
            animationLlIIlIlIIl.setFillAfter(true);
            animationLlIIlIlIIl.setFillBefore(true);
            setLayoutAnimation(new LayoutAnimationController(animationLlIIlIlIIl));
            startLayoutAnimation();
        }
        llIIlIlIIl();
    }

    public void setAnimateRotation(boolean z) {
        this.llIIIlllll = z;
    }

    public void setAnimationDuration(int i) {
        this.IllIIIIllI = i;
    }

    public void setHostActivityOrientation(int i) {
        this.lIlIIIIlIl = i;
        setOrientation(this.IllIIIllII);
    }

    public void setInitialOrientation(Orientation orientation) {
        this.IllIIIllII = orientation;
        this.IlIllIlIIl = llIIlIlIIl(orientation);
    }

    public void setOrientation(Orientation orientation) {
        invalidate();
        this.IllIIIllII = orientation;
        Orientation orientationLlIIlIlIIl = llIIlIlIIl(orientation);
        Animation animationLlIIlIlIIl = llIIlIlIIl(this.IlIllIlIIl, orientationLlIIlIlIIl);
        if (animationLlIIlIlIIl != null) {
            animationLlIIlIlIIl.setFillAfter(true);
            if (this.llIIIlllll) {
                animationLlIIlIlIIl.setDuration(this.IllIIIIllI);
            } else {
                animationLlIIlIlIIl.setDuration(0L);
            }
            setLayoutAnimation(new LayoutAnimationController(animationLlIIlIlIIl));
            startLayoutAnimation();
        } else {
            requestLayout();
        }
        this.IlIllIlIIl = orientationLlIIlIlIIl;
        llIIlIlIIl();
        Log.m2707d(this, IIllIllIIl.llIIlIlIIl("Set orientation: ").append(this.IlIllIlIIl).toString(), new Object[0]);
    }

    private Animation llIIlIlIIl(Orientation orientation, Orientation orientation2) {
        Log.m2707d(this, "Creating animation from {} to {}", orientation, orientation2);
        Log.m2707d(this, "Width: {},  heigth: {}", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        Orientation orientation3 = Orientation.ORIENTATION_PORTRAIT;
        if (orientation == orientation3) {
            if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
                return new llIIlIlIIl(this, 0.0f, 90.0f, getWidth(), getHeight(), true);
            }
            if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                return new llIIlIlIIl(this, 0.0f, -90.0f, getWidth(), getHeight(), true);
            }
            if (orientation2 == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
                return new llIIlIlIIl(this, 0.0f, 180.0f, getWidth(), getHeight(), false);
            }
            return null;
        }
        Orientation orientation4 = Orientation.ORIENTATION_LANDSCAPE_RIGHT;
        if (orientation == orientation4) {
            if (orientation2 == orientation3) {
                return new llIIlIlIIl(this, 90.0f, 0.0f, getWidth(), getHeight(), false);
            }
            if (orientation2 == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
                return new llIIlIlIIl(this, 90.0f, 180.0f, getWidth(), getHeight(), false);
            }
            if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                return new llIIlIlIIl(this, 90.0f, -90.0f, getWidth(), getHeight(), true);
            }
            return null;
        }
        Orientation orientation5 = Orientation.ORIENTATION_PORTRAIT_UPSIDE;
        if (orientation == orientation5) {
            if (orientation2 == orientation4) {
                return new llIIlIlIIl(this, 180.0f, 90.0f, getWidth(), getHeight(), true);
            }
            if (orientation2 == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                return new llIIlIlIIl(this, 180.0f, 270.0f, getWidth(), getHeight(), true);
            }
            if (orientation2 == orientation3) {
                return new llIIlIlIIl(this, 180.0f, 0.0f, getWidth(), getHeight(), false);
            }
            return null;
        }
        if (orientation == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
            if (orientation2 == orientation3) {
                return new llIIlIlIIl(this, -90.0f, 0.0f, getWidth(), getHeight(), false);
            }
            if (orientation2 == orientation5) {
                return new llIIlIlIIl(this, 270.0f, 180.0f, getWidth(), getHeight(), false);
            }
            if (orientation2 == orientation4) {
                return new llIIlIlIIl(this, -90.0f, 90.0f, getWidth(), getHeight(), true);
            }
        }
        return null;
    }

    private void llIIlIlIIl() {
        int width = getWidth();
        int height = getHeight();
        Matrix matrix = new Matrix();
        Orientation orientation = this.IlIllIlIIl;
        if (orientation == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
            matrix.preTranslate(width, 0.0f);
            matrix.preRotate(90.0f);
        } else if (orientation == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
            matrix.preTranslate(0.0f, height);
            matrix.preRotate(-90.0f);
        } else if (orientation != Orientation.ORIENTATION_PORTRAIT && orientation == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
            matrix.preTranslate(width, height);
            matrix.preRotate(180.0f);
        }
        matrix.invert(this.llIIlIlIIl);
    }
}
