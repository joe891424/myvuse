package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.ch */
/* JADX INFO: loaded from: classes3.dex */
public final class C2194ch {
    public static final Object Code = new Object();

    /* JADX INFO: renamed from: I */
    public static int f3034I;

    /* JADX INFO: renamed from: V */
    public static int f3035V;

    public static char[] Code(long j, char[] cArr, int i) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        int i2 = 0;
        int i3 = 4;
        for (int i4 = 0; i4 < cArr.length; i4++) {
            if ((((j >>> i4) & 1) != i || i2 >= 4) && i3 < length) {
                cArr2[i3] = cArr[i4];
                i3++;
            } else {
                cArr2[i2] = cArr[i4];
                i2++;
            }
        }
        return cArr2;
    }
}
