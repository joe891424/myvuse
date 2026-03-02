package com.facetec.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facetec.sdk.Z */
/* JADX INFO: loaded from: classes3.dex */
class C2133Z extends LinearLayout {
    public C2133Z(Context context) {
        super(context);
        setEnabled(false);
    }

    public C2133Z(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEnabled(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            setAlpha(0.4f);
            postInvalidate();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getX() < 0.0f || motionEvent.getX() > getWidth() || motionEvent.getY() < 0.0f || motionEvent.getY() > getHeight()) {
            setAlpha(1.0f);
            postInvalidate();
        }
        return true;
    }

    public void setOnClickRunnable(final Runnable runnable) {
        setEnabled(true);
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.facetec.sdk.Z.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (C2133Z.this.isEnabled()) {
                    C2133Z.this.setEnabled(false);
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }
        });
    }
}
