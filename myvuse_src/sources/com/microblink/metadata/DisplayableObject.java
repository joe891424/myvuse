package com.microblink.metadata;

import android.graphics.Matrix;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DisplayableObject {
    protected Matrix llIIlIlIIl;

    protected DisplayableObject(float[] fArr) {
        Matrix matrix = new Matrix();
        this.llIIlIlIIl = matrix;
        matrix.setValues(fArr);
    }

    public final Matrix getTransformMatrix() {
        return this.llIIlIlIIl;
    }
}
