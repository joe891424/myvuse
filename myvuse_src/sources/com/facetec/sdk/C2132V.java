package com.facetec.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/* JADX INFO: renamed from: com.facetec.sdk.V */
/* JADX INFO: loaded from: classes3.dex */
final class C2132V extends SurfaceView {

    /* JADX INFO: renamed from: B */
    private int f2322B;
    private int Code;

    public C2132V(Context context) {
        this(context, null);
    }

    public C2132V(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C2132V(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Code = 0;
        this.f2322B = 0;
    }

    public final void setAspectRatio(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.Code = i;
        this.f2322B = i2;
        requestLayout();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.Code;
        if (i4 == 0 || (i3 = this.f2322B) == 0) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, (i3 * size) / i4);
        }
    }
}
