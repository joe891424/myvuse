package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.cu */
/* JADX INFO: loaded from: classes3.dex */
class C2207cu {

    /* JADX INFO: renamed from: I */
    private static int f3130I;

    C2207cu() {
    }

    static {
        System.loadLibrary("bf15");
        int i = f3130I;
        int i2 = ((i & 77) + (i | 77)) % 2;
    }
}
