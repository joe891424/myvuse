package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.dc */
/* JADX INFO: loaded from: classes3.dex */
public final class C2214dc {

    /* JADX INFO: renamed from: B */
    private static int f3207B = 0;

    /* JADX INFO: renamed from: Z */
    private static int f3208Z = 1;

    /* JADX INFO: renamed from: I */
    private final int f3209I;

    /* JADX INFO: renamed from: V */
    private final int f3210V;

    public C2214dc(int i, int i2) {
        this.f3210V = i;
        this.f3209I = i2;
    }

    /* JADX INFO: renamed from: B */
    public final int m2073B() {
        int i = f3207B;
        int i2 = ((i | 77) << 1) - (i ^ 77);
        f3208Z = i2 % 128;
        int i3 = i2 % 2;
        return this.f3210V;
    }

    /* JADX INFO: renamed from: I */
    public final int m2074I() {
        int i = f3208Z + 91;
        f3207B = i % 128;
        if (i % 2 == 0) {
            return this.f3209I;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }
}
