package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.cp */
/* JADX INFO: loaded from: classes3.dex */
final class C2202cp {

    /* JADX INFO: renamed from: I */
    private static int f3067I = 1;

    /* JADX INFO: renamed from: Z */
    private static int f3068Z;

    C2202cp() {
    }

    /* JADX INFO: renamed from: B */
    public static long m2011B(String str) {
        int i = f3067I;
        int i2 = ((i | 119) << 1) - (i ^ 119);
        int i3 = i2 % 128;
        f3068Z = i3;
        int i4 = i2 % 2;
        long j = 0;
        if (str == null) {
            int i5 = ((i3 | 85) << 1) - (i3 ^ 85);
            f3067I = i5 % 128;
            return i5 % 2 == 0 ? 1L : 0L;
        }
        int i6 = (i & 47) + (i | 47);
        f3068Z = i6 % 128;
        int i7 = i6 % 2;
        int i8 = 0;
        while (i8 < str.length()) {
            int i9 = f3067I + 87;
            f3068Z = i9 % 128;
            int i10 = i9 % 2;
            char cCharAt = str.charAt(i8);
            i8++;
            j = ((j << 5) ^ (((-134217728) & j) >> 27)) ^ ((long) cCharAt);
        }
        int i11 = f3068Z;
        int i12 = (i11 ^ 41) + ((i11 & 41) << 1);
        f3067I = i12 % 128;
        int i13 = i12 % 2;
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        r8 = (r5 ^ 5) + ((r5 & 5) << 1);
        r9 = r8 % 128;
        com.facetec.sdk.C2202cp.f3067I = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        if ((r8 % 2) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r3 = r3 % 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r3 = (r3 & 1) + (r3 | 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        r9 = r9 + 95;
        com.facetec.sdk.C2202cp.f3068Z = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int Code(java.io.BufferedInputStream r8, long[] r9) {
        /*
            int r0 = com.facetec.sdk.C2202cp.f3068Z
            r1 = r0 | 115(0x73, float:1.61E-43)
            int r1 = r1 << 1
            r2 = r0 ^ 115(0x73, float:1.61E-43)
            int r1 = r1 - r2
            int r2 = r1 % 128
            com.facetec.sdk.C2202cp.f3067I = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L14
            r1 = 1
            goto L16
        L14:
            r1 = 0
        L16:
            r3 = r0 | 79
            int r3 = r3 << 1
            r0 = r0 ^ 79
            int r3 = r3 - r0
        L1d:
            int r0 = r3 % 128
            com.facetec.sdk.C2202cp.f3067I = r0
            int r3 = r3 % 2
            r0 = 0
            int r3 = r8.read()     // Catch: java.io.IOException -> L94
            r4 = -1
            if (r3 == r4) goto L85
            int r4 = com.facetec.sdk.C2202cp.f3068Z
            r5 = r4 | 69
            int r5 = r5 << 1
            r4 = r4 ^ 69
            int r5 = r5 - r4
            int r4 = r5 % 128
            com.facetec.sdk.C2202cp.f3067I = r4
            int r5 = r5 % 2
            char r3 = (char) r3
            r4 = 5
            long r1 = r1 << r4
            long r5 = (long) r3
            long r1 = r1 ^ r5
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r5
            r3 = r0
        L44:
            int r5 = r9.length     // Catch: java.io.IOException -> L94
            if (r3 >= r5) goto L7d
            int r5 = com.facetec.sdk.C2202cp.f3067I
            r6 = r5 & 83
            r5 = r5 | 83
            int r6 = r6 + r5
            int r5 = r6 % 128
            com.facetec.sdk.C2202cp.f3068Z = r5
            int r6 = r6 % 2
            r6 = r9[r3]     // Catch: java.io.IOException -> L94
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 != 0) goto L7a
            r8 = r5 ^ 5
            r9 = r5 & 5
            int r9 = r9 << 1
            int r8 = r8 + r9
            int r9 = r8 % 128
            com.facetec.sdk.C2202cp.f3067I = r9
            int r8 = r8 % 2
            if (r8 != 0) goto L6b
            int r3 = r3 % r0
            goto L71
        L6b:
            r8 = r3 & 1
            r0 = r3 | 1
            int r3 = r8 + r0
        L71:
            int r9 = r9 + 95
            int r8 = r9 % 128
            com.facetec.sdk.C2202cp.f3068Z = r8
            int r9 = r9 % 2
            return r3
        L7a:
            int r3 = r3 + 1
            goto L44
        L7d:
            int r0 = com.facetec.sdk.C2202cp.f3068Z
            r3 = r0 & 37
            r0 = r0 | 37
            int r3 = r3 + r0
            goto L1d
        L85:
            int r8 = com.facetec.sdk.C2202cp.f3068Z
            r9 = r8 | 103(0x67, float:1.44E-43)
            int r9 = r9 << 1
            r8 = r8 ^ 103(0x67, float:1.44E-43)
            int r9 = r9 - r8
            int r8 = r9 % 128
            com.facetec.sdk.C2202cp.f3067I = r8
            int r9 = r9 % 2
        L94:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2202cp.Code(java.io.BufferedInputStream, long[]):int");
    }
}
