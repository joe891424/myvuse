package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.dd */
/* JADX INFO: loaded from: classes3.dex */
public final class C2215dd {
    private static int Code = 1;

    /* JADX INFO: renamed from: Z */
    private static int f3211Z;

    /* JADX INFO: renamed from: I */
    private final int f3212I;

    public C2215dd(int i, byte b) {
        this.f3212I = i;
    }

    public C2215dd(int i) {
        this.f3212I = i;
    }

    public final int Code() {
        int i = f3211Z;
        int i2 = (i ^ 15) + ((i & 15) << 1);
        int i3 = i2 % 128;
        Code = i3;
        int i4 = i2 % 2;
        int i5 = this.f3212I;
        int i6 = (i3 ^ 9) + ((i3 & 9) << 1);
        f3211Z = i6 % 128;
        int i7 = i6 % 2;
        return i5;
    }
}
