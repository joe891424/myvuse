package com.airbnb.lottie.utils;

/* JADX INFO: loaded from: classes.dex */
public class MeanCalculator {

    /* JADX INFO: renamed from: n */
    private int f1859n;
    private float sum;

    public void add(float f) {
        float f2 = this.sum + f;
        this.sum = f2;
        int i = this.f1859n + 1;
        this.f1859n = i;
        if (i == Integer.MAX_VALUE) {
            this.sum = f2 / 2.0f;
            this.f1859n = i / 2;
        }
    }

    public float getMean() {
        int i = this.f1859n;
        if (i == 0) {
            return 0.0f;
        }
        return this.sum / i;
    }
}
