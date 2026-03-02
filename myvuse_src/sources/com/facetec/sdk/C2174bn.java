package com.facetec.sdk;

import java.io.Serializable;

/* JADX INFO: renamed from: com.facetec.sdk.bn */
/* JADX INFO: loaded from: classes3.dex */
class C2174bn implements Serializable {
    private final int Code;

    /* JADX INFO: renamed from: I */
    private final int f2908I;

    /* JADX INFO: renamed from: Z */
    private final byte[] f2909Z;

    private C2174bn(byte[] bArr, int i, int i2) {
        this.f2909Z = bArr;
        this.f2908I = i;
        this.Code = i2;
    }

    int getWidth() {
        return this.f2908I;
    }

    int getHeight() {
        return this.Code;
    }

    byte[] getBytes() {
        return this.f2909Z;
    }
}
