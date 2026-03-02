package com.facetec.sdk;

import android.content.Context;
import com.facetec.sdk.C2204cr;
import java.util.Random;

/* JADX INFO: renamed from: com.facetec.sdk.p */
/* JADX INFO: loaded from: classes3.dex */
final class C2226p implements ZoomEncryptStrings {

    /* JADX INFO: renamed from: B */
    private static char f3524B = 0;
    private static int Code = 0;

    /* JADX INFO: renamed from: F */
    private static int f3525F = 1;

    /* JADX INFO: renamed from: I */
    private static char[] f3526I;

    /* JADX INFO: renamed from: V */
    private static boolean f3527V;

    /* JADX INFO: renamed from: Z */
    private static int f3528Z;

    /* JADX INFO: renamed from: I */
    static void m2277I() {
        f3526I = new char[]{'x', '8', '6', 'y'};
        f3524B = (char) 2;
    }

    C2226p() {
    }

    static /* synthetic */ int Code(int i) {
        int i2 = 2 % 2;
        int i3 = Code + 93;
        int i4 = i3 % 128;
        f3525F = i4;
        int i5 = i3 % 2 == 0 ? i & f3528Z : i | f3528Z;
        f3528Z = i5;
        int i6 = i4 + 67;
        Code = i6 % 128;
        int i7 = i6 % 2;
        return i5;
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m2278I(Context context, boolean z) {
        int i = 2 % 2;
        int i2 = Code + 77;
        f3525F = i2 % 128;
        int i3 = i2 % 2;
        m2279V(context, z);
        int i4 = Code + 1;
        f3525F = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 71 / 0;
        }
    }

    static {
        m2277I();
        f3528Z = 0;
        f3527V = false;
        int i = f3525F + 63;
        Code = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.p$B */
    enum B {
        EmulatorAbiDetected(1),
        DexGuardEmulatorDetected(2),
        DexGuardRootDetected(4),
        DexGuardHookDetected(8),
        DexGuardVirtualEnvDetected(16),
        DexGuardApkTamper(32),
        DexGuardDebuggerAttached(64),
        Next(128);


        /* JADX INFO: renamed from: Z */
        final int f3540Z;

        B(int i) {
            this.f3540Z = i;
        }
    }

    static void Code(final Context context) {
        int i = 2 % 2;
        AbstractAsyncTaskC2155au.m1616Z(new Runnable() { // from class: com.facetec.sdk.p.1
            @Override // java.lang.Runnable
            public final void run() {
                C2226p.m2278I(context, true);
            }
        });
        int i2 = Code + 7;
        f3525F = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x00a4, TryCatch #2 {, blocks: (B:5:0x0004, B:7:0x000b, B:9:0x001a, B:11:0x0043, B:12:0x004d, B:13:0x0050, B:15:0x005b, B:18:0x0063, B:20:0x006e, B:21:0x007d, B:25:0x0085, B:26:0x0086, B:28:0x008a, B:30:0x0095, B:31:0x0099, B:35:0x00a1, B:32:0x009c, B:33:0x009f, B:22:0x0080, B:23:0x0083), top: B:45:0x0004, inners: #0, #1 }] */
    /* JADX INFO: renamed from: V */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized void m2279V(android.content.Context r11, boolean r12) {
        /*
            java.lang.Class<com.facetec.sdk.p> r0 = com.facetec.sdk.C2226p.class
            monitor-enter(r0)
            r1 = 2
            int r2 = r1 % r1
            boolean r2 = com.facetec.sdk.C2226p.f3527V     // Catch: java.lang.Throwable -> La4
            r3 = 1
            if (r2 == r3) goto L60
            int r2 = com.facetec.sdk.C2226p.f3525F     // Catch: java.lang.Throwable -> La4
            int r2 = r2 + 23
            int r4 = r2 % 128
            com.facetec.sdk.C2226p.Code = r4     // Catch: java.lang.Throwable -> La4
            int r2 = r2 % r1
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS     // Catch: java.lang.Throwable -> La4
            int r4 = r2.length     // Catch: java.lang.Throwable -> La4
            r5 = 0
        L18:
            if (r5 >= r4) goto L50
            r6 = r2[r5]     // Catch: java.lang.Throwable -> La4
            java.lang.String r6 = r6.toLowerCase()     // Catch: java.lang.Throwable -> La4
            long r7 = android.os.Process.getElapsedCpuTime()     // Catch: java.lang.Throwable -> La4
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            int r7 = 4 - r7
            java.lang.String r8 = "\u0001\u0000\u0098"
            int r9 = android.view.ViewConfiguration.getFadingEdgeLength()     // Catch: java.lang.Throwable -> La4
            int r9 = r9 >> 16
            int r9 = 98 - r9
            byte r9 = (byte) r9     // Catch: java.lang.Throwable -> La4
            java.lang.String r7 = m2276B(r7, r8, r9)     // Catch: java.lang.Throwable -> La4
            java.lang.String r7 = r7.intern()     // Catch: java.lang.Throwable -> La4
            boolean r6 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> La4
            if (r6 == 0) goto L4d
            int r2 = com.facetec.sdk.C2226p.f3528Z     // Catch: java.lang.Throwable -> La4
            com.facetec.sdk.p$B r4 = com.facetec.sdk.C2226p.B.EmulatorAbiDetected     // Catch: java.lang.Throwable -> La4
            int r4 = r4.f3540Z     // Catch: java.lang.Throwable -> La4
            r2 = r2 | r4
            com.facetec.sdk.C2226p.f3528Z = r2     // Catch: java.lang.Throwable -> La4
            goto L50
        L4d:
            int r5 = r5 + 1
            goto L18
        L50:
            com.facetec.sdk.C2226p.f3527V = r3     // Catch: java.lang.Throwable -> La4
            int r2 = com.facetec.sdk.C2226p.f3528Z     // Catch: java.lang.Throwable -> La4
            com.facetec.sdk.p$B r3 = com.facetec.sdk.C2226p.B.EmulatorAbiDetected     // Catch: java.lang.Throwable -> La4
            int r3 = r3.f3540Z     // Catch: java.lang.Throwable -> La4
            r2 = r2 & r3
            if (r2 <= 0) goto L60
            int r2 = com.facetec.sdk.C2226p.f3528Z     // Catch: java.lang.Throwable -> La4
            com.facetec.sdk.C2140af.m1490E(r2)     // Catch: java.lang.Throwable -> La4
        L60:
            r2 = 0
            if (r12 == 0) goto L86
            int r12 = com.facetec.sdk.C2226p.Code     // Catch: java.lang.Throwable -> La4
            int r12 = r12 + 55
            int r3 = r12 % 128
            com.facetec.sdk.C2226p.f3525F = r3     // Catch: java.lang.Throwable -> La4
            int r12 = r12 % r1
            if (r12 == 0) goto L7d
            m2280Z(r11)     // Catch: java.lang.Throwable -> La4
            int r11 = com.facetec.sdk.C2226p.Code     // Catch: java.lang.Throwable -> La4
            int r11 = r11 + 89
            int r12 = r11 % 128
            com.facetec.sdk.C2226p.f3525F = r12     // Catch: java.lang.Throwable -> La4
            int r11 = r11 % r1
            int r11 = r1 % r1
            goto L86
        L7d:
            m2280Z(r11)     // Catch: java.lang.Throwable -> La4
            super.hashCode()     // Catch: java.lang.Throwable -> L84
            throw r2     // Catch: java.lang.Throwable -> L84
        L84:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> La4
        L86:
            int r11 = com.facetec.sdk.C2226p.f3528Z     // Catch: java.lang.Throwable -> La4
            if (r11 == 0) goto La2
            int r12 = com.facetec.sdk.C2226p.f3525F     // Catch: java.lang.Throwable -> La4
            int r12 = r12 + 91
            int r3 = r12 % 128
            com.facetec.sdk.C2226p.Code = r3     // Catch: java.lang.Throwable -> La4
            int r12 = r12 % r1
            if (r12 != 0) goto L99
            com.facetec.sdk.C2140af.m1490E(r11)     // Catch: java.lang.Throwable -> La4
            goto La2
        L99:
            com.facetec.sdk.C2140af.m1490E(r11)     // Catch: java.lang.Throwable -> La4
            super.hashCode()     // Catch: java.lang.Throwable -> La0
            throw r2     // Catch: java.lang.Throwable -> La0
        La0:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> La4
        La2:
            monitor-exit(r0)
            return
        La4:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La4
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2226p.m2279V(android.content.Context, boolean):void");
    }

    /* JADX INFO: renamed from: Z */
    private static synchronized void m2280Z(final Context context) {
        int i = 2 % 2;
        final int iNextInt = new Random().nextInt();
        if (iNextInt != C2203cq.m2014B(context, iNextInt)) {
            int i2 = f3525F + 43;
            Code = i2 % 128;
            int i3 = i2 % 2;
            f3528Z |= B.DexGuardEmulatorDetected.f3540Z;
        }
        if (iNextInt != C2200cn.m2002I(iNextInt)) {
            int i4 = Code + 11;
            f3525F = i4 % 128;
            if (i4 % 2 == 0) {
                f3528Z ^= B.DexGuardHookDetected.f3540Z;
            } else {
                f3528Z |= B.DexGuardHookDetected.f3540Z;
            }
            int i5 = 2 % 2;
        }
        C2204cr.Code(context, iNextInt, new C2204cr.V() { // from class: com.facetec.sdk.p.3
            @Override // com.facetec.sdk.C2204cr.V
            /* JADX INFO: renamed from: V */
            public final void mo2042V(int i6, int i7) {
                if (i6 == i7 && i7 == iNextInt) {
                    return;
                }
                C2226p.Code(B.DexGuardRootDetected.f3540Z);
                C2226p.m2278I(context, false);
            }
        });
        int i6 = Code + 93;
        f3525F = i6 % 128;
        int i7 = i6 % 2;
    }

    /* JADX INFO: renamed from: B */
    private static String m2276B(int i, String str, byte b) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (C2190cd.f3022F) {
            char[] cArr2 = f3526I;
            char c = f3524B;
            char[] cArr3 = new char[i];
            if (i % 2 != 0) {
                i--;
                cArr3[i] = (char) (cArr[i] - b);
            }
            if (i > 1) {
                C2190cd.f3020B = 0;
                while (C2190cd.f3020B < i) {
                    C2190cd.f3025V = cArr[C2190cd.f3020B];
                    C2190cd.f3026Z = cArr[C2190cd.f3020B + 1];
                    if (C2190cd.f3025V == C2190cd.f3026Z) {
                        cArr3[C2190cd.f3020B] = (char) (C2190cd.f3025V - b);
                        cArr3[C2190cd.f3020B + 1] = (char) (C2190cd.f3026Z - b);
                    } else {
                        C2190cd.f3023I = C2190cd.f3025V / c;
                        C2190cd.f3024S = C2190cd.f3025V % c;
                        C2190cd.Code = C2190cd.f3026Z / c;
                        C2190cd.f3021C = C2190cd.f3026Z % c;
                        if (C2190cd.f3024S == C2190cd.f3021C) {
                            C2190cd.f3023I = ((C2190cd.f3023I + c) - 1) % c;
                            C2190cd.Code = ((C2190cd.Code + c) - 1) % c;
                            int i2 = (C2190cd.f3023I * c) + C2190cd.f3024S;
                            int i3 = (C2190cd.Code * c) + C2190cd.f3021C;
                            cArr3[C2190cd.f3020B] = cArr2[i2];
                            cArr3[C2190cd.f3020B + 1] = cArr2[i3];
                        } else if (C2190cd.f3023I == C2190cd.Code) {
                            C2190cd.f3024S = ((C2190cd.f3024S + c) - 1) % c;
                            C2190cd.f3021C = ((C2190cd.f3021C + c) - 1) % c;
                            int i4 = (C2190cd.f3023I * c) + C2190cd.f3024S;
                            int i5 = (C2190cd.Code * c) + C2190cd.f3021C;
                            cArr3[C2190cd.f3020B] = cArr2[i4];
                            cArr3[C2190cd.f3020B + 1] = cArr2[i5];
                        } else {
                            int i6 = (C2190cd.f3023I * c) + C2190cd.f3021C;
                            int i7 = (C2190cd.Code * c) + C2190cd.f3024S;
                            cArr3[C2190cd.f3020B] = cArr2[i6];
                            cArr3[C2190cd.f3020B + 1] = cArr2[i7];
                        }
                    }
                    C2190cd.f3020B += 2;
                }
            }
            str2 = new String(cArr3);
        }
        return str2;
    }
}
