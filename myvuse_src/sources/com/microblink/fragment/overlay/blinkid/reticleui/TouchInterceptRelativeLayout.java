package com.microblink.fragment.overlay.blinkid.reticleui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class TouchInterceptRelativeLayout extends RelativeLayout {
    private TouchListener llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    public interface TouchListener {
        void onTouch();
    }

    public TouchInterceptRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchListener touchListener = this.llIIlIlIIl;
        if (touchListener == null) {
            return false;
        }
        touchListener.onTouch();
        return false;
    }

    public void setTouchListener(TouchListener touchListener) {
        this.llIIlIlIIl = touchListener;
    }

    public TouchInterceptRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchInterceptRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TouchInterceptRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
