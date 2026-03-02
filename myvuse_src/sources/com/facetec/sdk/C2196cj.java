package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.cj */
/* JADX INFO: loaded from: classes3.dex */
public final class C2196cj {

    /* JADX INFO: renamed from: B */
    public static int f3038B;
    public static int Code;

    /* JADX INFO: renamed from: V */
    public static int f3039V;

    /* JADX INFO: renamed from: Z */
    public static final Object f3040Z = new Object();

    /* JADX INFO: renamed from: V */
    public static void m1998V(int[] iArr) {
        for (int i = 0; i < iArr.length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(iArr.length - i) - 1];
            iArr[(iArr.length - i) - 1] = i2;
        }
    }

    public static int Code(int i) {
        C2192cf c2192cf = C2192cf.f3029B;
        return ((c2192cf.Code[0][i >>> 24] + c2192cf.Code[1][(i >>> 16) & 255]) ^ c2192cf.Code[2][(i >>> 8) & 255]) + c2192cf.Code[3][i & 255];
    }
}
