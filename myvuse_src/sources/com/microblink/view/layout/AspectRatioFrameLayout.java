package com.microblink.view.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.microblink.library.C3714R;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class AspectRatioFrameLayout extends FrameLayout {
    private float llIIlIlIIl;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public float getAspectRatio() {
        return this.llIIlIlIIl;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.llIIlIlIIl == 0.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        float f = size;
        float f2 = this.llIIlIlIIl;
        float f3 = f / f2;
        float f4 = size2;
        if (f3 > f4) {
            f = f4 * f2;
            f3 = f4;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) f, 1073741824), View.MeasureSpec.makeMeasureSpec((int) f3, 1073741824));
    }

    public void setAspectRatio(float f) {
        this.llIIlIlIIl = f;
        invalidate();
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3714R.styleable.AspectRatioFrameLayout, i, 0);
        this.llIIlIlIIl = typedArrayObtainStyledAttributes.getFloat(C3714R.styleable.AspectRatioFrameLayout_mb_aspectRatio, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }
}
