package com.facetec.sdk;

import java.util.List;

/* JADX INFO: renamed from: com.facetec.sdk.df */
/* JADX INFO: loaded from: classes3.dex */
public final class C2217df {

    /* JADX INFO: renamed from: I */
    private static int f3215I = 0;

    /* JADX INFO: renamed from: V */
    private static int f3216V = 1;

    /* JADX INFO: renamed from: B */
    private final int f3217B;
    private final List<String> Code;

    /* JADX INFO: renamed from: Z */
    private final List<String> f3218Z;

    public C2217df(int i, List<String> list, List<String> list2) {
        this.f3217B = i;
        this.Code = list;
        this.f3218Z = list2;
    }

    /* JADX INFO: renamed from: B */
    public final int m2075B() {
        int i = f3216V + 103;
        int i2 = i % 128;
        f3215I = i2;
        int i3 = i % 2;
        int i4 = this.f3217B;
        int i5 = i2 + 57;
        f3216V = i5 % 128;
        int i6 = i5 % 2;
        return i4;
    }

    public final List<String> Code() {
        int i = f3216V;
        int i2 = i + 29;
        f3215I = i2 % 128;
        int i3 = i2 % 2;
        List<String> list = this.Code;
        int i4 = i + 41;
        f3215I = i4 % 128;
        int i5 = i4 % 2;
        return list;
    }

    /* JADX INFO: renamed from: V */
    public final List<String> m2076V() {
        int i = f3216V + 43;
        int i2 = i % 128;
        f3215I = i2;
        int i3 = i % 2;
        List<String> list = this.f3218Z;
        int i4 = i2 + 3;
        f3216V = i4 % 128;
        int i5 = i4 % 2;
        return list;
    }
}
