package com.facetec.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
final class Code extends TextureView {

    /* JADX INFO: renamed from: I */
    private int f2155I;

    /* JADX INFO: renamed from: V */
    private int f2156V;

    public Code(Context context) {
        this(context, null);
    }

    public Code(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Code(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2155I = 0;
        this.f2156V = 0;
    }

    public final void setAspectRatio(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.f2155I = i;
        this.f2156V = i2;
        requestLayout();
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.f2155I;
        if (i4 == 0 || (i3 = this.f2156V) == 0) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, (i3 * size) / i4);
        }
    }
}
