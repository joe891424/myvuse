package com.microblink.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.microblink.blinkid.secured.lIIlllIIlI;
import com.microblink.blinkid.secured.lIllIlllIl;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.hardware.orientation.OrientationChangeListener;
import com.microblink.util.Log;
import com.microblink.view.BaseCameraView;
import java.util.Iterator;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraViewGroup extends BaseCameraView {
    private boolean IIIIlIllIl;
    private lIllIlllIl IIllllllll;
    private lIIlllIIlI IlIIIlIIIl;
    private boolean lIlIIIlIll;
    private int llllIllllI;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: line */
    public class CameraViewGroupOrientationChangeListener extends BaseCameraView.BaseOrientationChangeListener {
        protected CameraViewGroupOrientationChangeListener() {
            super();
        }

        @Override // com.microblink.view.BaseCameraView.BaseOrientationChangeListener, com.microblink.hardware.orientation.OrientationChangeListener
        public void onOrientationChange(Orientation orientation) {
            super.onOrientationChange(orientation);
            if (CameraViewGroup.this.llIIlIlIIl(orientation)) {
                if (CameraViewGroup.this.IIllllllll != null) {
                    CameraViewGroup.this.IIllllllll.setOrientation(orientation);
                }
                Iterator<OrientationChangeListener> it2 = CameraViewGroup.this.llIIlIIIll.iterator();
                while (it2.hasNext()) {
                    it2.next().onOrientationChange(orientation);
                }
            }
        }
    }

    public CameraViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IIIIlIllIl = false;
        this.llllIllllI = 250;
        this.lIlIIIlIll = false;
        if (attributeSet != null) {
            this.IIIIlIllIl = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "mb_animateRotation", false);
            this.llllIllllI = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "mb_animationDuration", this.llllIllllI);
        }
        llIIlIlIIl(context);
    }

    @Override // com.microblink.view.BaseCameraView
    protected OrientationChangeListener IllIIIIllI() {
        return new BaseCameraView.BaseOrientationChangeListener();
    }

    public void addChildView(View view, boolean z) {
        if (z) {
            this.IIllllllll.addView(view);
        } else {
            this.IlIIIlIIIl.addView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (this.lIlIIIlIll) {
            addView(view, (ViewGroup.LayoutParams) null);
        } else {
            super.addView(view);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.microblink.view.BaseCameraView
    public void create() {
        this.lIlIIIlIll = false;
        super.create();
        this.lIlIIIlIll = true;
    }

    @Override // com.microblink.view.BaseCameraView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = this.IIllllllll.dispatchTouchEvent(motionEvent);
        Log.m2713v(this, "Rotatable view responded: {}", Boolean.valueOf(zDispatchTouchEvent));
        if (zDispatchTouchEvent) {
            return true;
        }
        boolean zDispatchTouchEvent2 = this.IlIIIlIIIl.dispatchTouchEvent(motionEvent);
        Log.m2713v(this, "Fixed view responded: {}", Boolean.valueOf(zDispatchTouchEvent2));
        return zDispatchTouchEvent2 || super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final int getRotationAnimationDuration() {
        return this.llllIllllI;
    }

    public final void setAnimateRotation(boolean z) {
        this.IIIIlIllIl = z;
        this.IIllllllll.setAnimateRotation(z);
    }

    @Override // com.microblink.view.BaseCameraView
    public final void setInitialOrientation(Orientation orientation) {
        super.setInitialOrientation(orientation);
        this.IIllllllll.setInitialOrientation(getInitialOrientation());
    }

    public final void setRotationAnimationDuration(int i) {
        this.llllIllllI = i;
        this.IIllllllll.setAnimationDuration(i);
    }

    public final boolean shouldAnimateRotation() {
        return this.IIIIlIllIl;
    }

    private void llIIlIlIIl(Context context) {
        setBackgroundColor(0);
        lIIlllIIlI liillliili = new lIIlllIIlI(context);
        this.IlIIIlIIIl = liillliili;
        liillliili.setBackgroundColor(0);
        this.IlIIIlIIIl.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.IlIIIlIIIl.setVisibility(0);
        if (getInitialOrientation() == null) {
            this.IlIlllllII = Orientation.fromActivityInfoCode(this.IIlIIIllIl);
        }
        lIllIlllIl lillilllil = new lIllIlllIl(context, this.IIlIIIllIl, getInitialOrientation(), this.IIIIlIllIl, this.llllIllllI);
        this.IIllllllll = lillilllil;
        lillilllil.setBackgroundColor(0);
        this.IIllllllll.setVisibility(0);
        addView(this.IlIIIlIIIl);
        addView(this.IIllllllll);
        this.lIlIIIlIll = true;
    }

    public void addChildView(View view, boolean z, int i) {
        if (z) {
            this.IIllllllll.addView(view, i);
        } else {
            this.IlIIIlIIIl.addView(view, i);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (this.lIlIIIlIll) {
            addView(view, i, (ViewGroup.LayoutParams) null);
        } else {
            super.addView(view, i);
        }
    }

    /* JADX INFO: compiled from: line */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        private boolean llIIlIlIIl;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.llIIlIlIIl = false;
            if (attributeSet != null) {
                this.llIIlIlIIl = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "mb_rotatable", false);
            }
        }

        public boolean isRotatable() {
            return this.llIIlIlIIl;
        }

        public void setRotatable(boolean z) {
            this.llIIlIlIIl = z;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.llIIlIlIIl = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.llIIlIlIIl = false;
            if (layoutParams instanceof LayoutParams) {
                this.llIIlIlIIl = ((LayoutParams) layoutParams).llIIlIlIIl;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.lIlIIIlIll) {
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            if (layoutParams instanceof LayoutParams) {
                if (((LayoutParams) layoutParams).isRotatable()) {
                    this.IIllllllll.addView(view, i);
                    return;
                } else {
                    this.IlIIIlIIIl.addView(view, i);
                    return;
                }
            }
            throw new RuntimeException("BaseCameraView.LayoutParams are only allowed type of params");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // com.microblink.view.BaseCameraView
    protected void llIIlIlIIl(Configuration configuration) {
        super.llIIlIlIIl(configuration);
        this.IIllllllll.setHostActivityOrientation(this.IIlIIIllIl);
        this.IIllllllll.dispatchConfigurationChanged(configuration);
        this.IlIIIlIIIl.dispatchConfigurationChanged(configuration);
        if (llIIlIIlll()) {
            this.IllIIlIIII.onOrientationChange(Orientation.fromActivityInfoCode(this.IIlIIIllIl));
        }
    }

    public CameraViewGroup(Context context) {
        super(context);
        this.IIIIlIllIl = false;
        this.llllIllllI = 250;
        this.lIlIIIlIll = false;
        llIIlIlIIl(context);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.lIlIIIlIll) {
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            if (layoutParams instanceof LayoutParams) {
                if (((LayoutParams) layoutParams).isRotatable()) {
                    this.IIllllllll.addView(view);
                    return;
                } else {
                    this.IlIIIlIIIl.addView(view);
                    return;
                }
            }
            throw new RuntimeException("BaseCameraView.LayoutParams are only allowed type of params");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        if (!this.lIlIIIlIll) {
            super.addView(view, i, i2);
            return;
        }
        throw new RuntimeException("addView method has been disabled in CameraView. Please use addChildView(View, boolean).");
    }
}
