package com.facetec.sdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import com.facetec.sdk.JNI;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.facetec.sdk.af */
/* JADX INFO: loaded from: classes3.dex */
final class C2140af implements ZoomEncryptStrings {

    /* JADX INFO: renamed from: B */
    private static boolean f2401B = false;
    public static String Code = null;

    /* JADX INFO: renamed from: D */
    private static int f2402D = 1;

    /* JADX INFO: renamed from: F */
    private static int f2403F;

    /* JADX INFO: renamed from: I */
    private static boolean f2404I;

    /* JADX INFO: renamed from: V */
    private static String f2405V;

    /* JADX INFO: renamed from: Z */
    private static char[] f2406Z;

    @JNI.InterfaceC2128I(m1430I = 957213713)
    /* JADX INFO: renamed from: A */
    static native void m1482A(String str);

    @JNI.InterfaceC2128I(m1430I = 579690330)
    /* JADX INFO: renamed from: B */
    static native void m1485B(String str, int i);

    @JNI.InterfaceC2128I(m1430I = 774884799)
    /* JADX INFO: renamed from: C */
    static native void m1487C(String str);

    @JNI.InterfaceC2128I(m1430I = 435246041)
    /* JADX INFO: renamed from: D */
    static native void m1489D(String str);

    @JNI.InterfaceC2128I(m1430I = 536412578)
    /* JADX INFO: renamed from: E */
    static native void m1490E(int i);

    @JNI.InterfaceC2128I(m1430I = 534730124)
    /* JADX INFO: renamed from: F */
    static native void m1492F(String str);

    @JNI.InterfaceC2128I(m1430I = 218119279)
    /* JADX INFO: renamed from: G */
    static native void m1493G(String str);

    @JNI.InterfaceC2128I(m1430I = 426837000)
    /* JADX INFO: renamed from: H */
    static native void m1494H(String str);

    @JNI.InterfaceC2128I(m1430I = 802163113)
    /* JADX INFO: renamed from: I */
    static native void m1496I(int i);

    @JNI.InterfaceC2128I(m1430I = 419417896)
    /* JADX INFO: renamed from: J */
    private static native void m1498J(Class<C2174bn> cls);

    @JNI.InterfaceC2128I(m1430I = 251547157)
    /* JADX INFO: renamed from: K */
    static native String m1499K(String str, boolean z);

    @JNI.InterfaceC2128I(m1430I = 854339086)
    /* JADX INFO: renamed from: L */
    static native boolean m1500L();

    @JNI.InterfaceC2128I(m1430I = 801550182)
    /* JADX INFO: renamed from: M */
    static native void m1501M();

    @JNI.InterfaceC2128I(m1430I = 953865493)
    /* JADX INFO: renamed from: N */
    static native void m1502N();

    @JNI.InterfaceC2128I(m1430I = 559139395)
    /* JADX INFO: renamed from: O */
    private static native void m1503O();

    @JNI.InterfaceC2128I(m1430I = 828862140)
    /* JADX INFO: renamed from: P */
    private static native int m1504P();

    @JNI.InterfaceC2128I(m1430I = 417661065)
    /* JADX INFO: renamed from: Q */
    private static native int m1505Q();

    @JNI.InterfaceC2128I(m1430I = 331891646)
    /* JADX INFO: renamed from: R */
    private static native void m1506R(String str, String str2, int i) throws Throwable;

    @JNI.InterfaceC2128I(m1430I = 492857316)
    /* JADX INFO: renamed from: T */
    private static native int m1508T();

    @JNI.InterfaceC2128I(m1430I = 241053919)
    /* JADX INFO: renamed from: U */
    private static native int m1509U();

    /* JADX INFO: renamed from: V */
    static void m1511V() {
        int i = 2 % 2;
        int i2 = f2402D + 89;
        f2403F = i2 % 128;
        int i3 = i2 % 2;
    }

    @JNI.InterfaceC2128I(m1430I = 236851259)
    /* JADX INFO: renamed from: W */
    private static native int m1515W();

    @JNI.InterfaceC2128I(m1430I = 942861196)
    /* JADX INFO: renamed from: X */
    private static native int m1516X();

    @JNI.InterfaceC2128I(m1430I = 184271543)
    /* JADX INFO: renamed from: Y */
    private static native int m1517Y();

    @JNI.InterfaceC2128I(m1430I = 123942655)
    /* JADX INFO: renamed from: a */
    static native boolean m1520a();

    @JNI.InterfaceC2128I(m1430I = 476130761)
    /* JADX INFO: renamed from: aa */
    private static native int m1521aa();

    @JNI.InterfaceC2128I(m1430I = 233296901)
    /* JADX INFO: renamed from: ab */
    private static native int m1522ab();

    @JNI.InterfaceC2128I(m1430I = 895617849)
    /* JADX INFO: renamed from: ac */
    private static native Object[] m1523ac();

    @JNI.InterfaceC2128I(m1430I = 340304317)
    /* JADX INFO: renamed from: ad */
    private static native Object[] m1524ad();

    @JNI.InterfaceC2128I(m1430I = 276274731)
    /* JADX INFO: renamed from: ae */
    private static native void m1525ae(int i);

    @JNI.InterfaceC2128I(m1430I = 532200877)
    /* JADX INFO: renamed from: af */
    private static native Object[] m1526af();

    @JNI.InterfaceC2128I(m1430I = 845714052)
    /* JADX INFO: renamed from: ah */
    private static native Object[] m1527ah();

    @JNI.InterfaceC2128I(m1430I = 465999614)
    /* JADX INFO: renamed from: b */
    static native void m1529b(boolean z);

    @JNI.InterfaceC2128I(m1430I = 280142536)
    /* JADX INFO: renamed from: c */
    static native void m1530c();

    @JNI.InterfaceC2128I(m1430I = 946822600)
    /* JADX INFO: renamed from: d */
    static native boolean m1532d(String str);

    @JNI.InterfaceC2128I(m1430I = 410261680)
    /* JADX INFO: renamed from: e */
    static native void m1534e(String str, String str2);

    @JNI.InterfaceC2128I(m1430I = 759707868)
    /* JADX INFO: renamed from: f */
    static native void m1535f(boolean z);

    @JNI.InterfaceC2128I(m1430I = 986922517)
    /* JADX INFO: renamed from: g */
    static native void m1537g(String str, byte[] bArr, boolean z, int i, int i2, int i3, boolean z2);

    @JNI.InterfaceC2128I(m1430I = 363975514)
    /* JADX INFO: renamed from: h */
    static native void m1539h(boolean z);

    @JNI.InterfaceC2128I(m1430I = 663820916)
    /* JADX INFO: renamed from: i */
    static native boolean m1541i(boolean z);

    @JNI.InterfaceC2128I(m1430I = 936399077)
    /* JADX INFO: renamed from: j */
    static native void m1544j(byte[] bArr, boolean z, int i, int i2, int i3);

    /* JADX INFO: renamed from: k */
    static void m1545k() {
        f2406Z = new char[]{')', 'C', 'T', '\\', 'X', 'N', '?', 'b', 'o', 'j', 'l', 'Q', '4', 'C', 'g', ']', 'Y', 'b', ']', 'U', 'B', 'C', Typography.less, 'C', 'Q', 'R', 'L', ']', 'w', 's', 'd', 'W', ']', 'V', ']', '\\', ']', 'k', Typography.less, 'o', 'g', 'm', 'k', 'm', 'K', 'B', 'l', 'j', 'c', 'h', '^', '8', SafeJsonPrimitive.NULL_CHAR, '\'', Typography.less, 'G', 'K', '[', 'd', '\\', '\\', 'd', 'b', 'S', '3', 'B', 'o', 'q', 'j', 'f', 'e', 'n', 'n', 'k', 'k', 'D', 'G', 'q', 'J', 'B', 'h', 'g', 'a', 'g', 'a', 'd', 'l', 'h', 'p', 's', 'I', 'B', 'k', 'i', 'k', 'n', 'k', 'p', 'a', '8', 'I', 's', 'r', 't', 'L', 'F', 138, 133, 131, 'c', '`', '`', 'i', 138, 140, 'k', 'b', 139, 139, 134, '~', 'o', 'g', 'k', 'Y', 'b', 134, 142, 'j', 'c', 138, 139, 145, 145, 138, 134, 133, 142, 142, 139, 139, 'd', 'b', 139, 147, 145, 281, 238, 242, 278, 273, 278, 277, 277, 289, 248, 239, 271, 273, 278, 276, 272, 238, 246, 285, 243, 242, 281, 276, 270, 251, 217, 227, 259, 278, 282, 23, '=', 't', 'o', 'n', 'g', 'k', 't', 'n', 'J', '.', '0', '4', '5', '0', '1', '5', '9', 'j', 'b', 'b', 'e', 'f', 'b', 'j', 'w', 'o', 'k', 's', 't', 'k', 'm', 's', 'k', 'q', 'm', 'f', 'n', 'o', 'q', 'q', 'h', 'g', 130, 256, 254, 247, 241, 246, 249, 250, 249, 210, 213, 253, 248, 243, 247, 254, 216, 218, 254, 244, 207, 191, 233, 258, 251, 251, 239, 230, 246, 246, 243, 245, 250, 235, 226, 244, 249, 255, 258, 250, 209, 218, 254, 247, 249, 247, 209, '2', 'k', 'p', 'l', 'f', 'b', 'g'};
    }

    @JNI.InterfaceC2128I(m1430I = 634933143)
    /* JADX INFO: renamed from: k */
    static native byte[] m1546k(String str, String str2, String str3);

    @JNI.InterfaceC2128I(m1430I = 444410178)
    /* JADX INFO: renamed from: l */
    static native void m1547l(boolean z, boolean z2);

    @JNI.InterfaceC2128I(m1430I = 779218783)
    /* JADX INFO: renamed from: m */
    static native void m1549m(boolean z);

    @JNI.InterfaceC2128I(m1430I = 785930769)
    /* JADX INFO: renamed from: n */
    static native void m1550n();

    @JNI.InterfaceC2128I(m1430I = 853861522)
    /* JADX INFO: renamed from: o */
    static native byte[] m1551o();

    @JNI.InterfaceC2128I(m1430I = 108889513)
    /* JADX INFO: renamed from: p */
    static native byte[] m1552p(String str, String str2, boolean z, boolean z2);

    @JNI.InterfaceC2128I(m1430I = 122908087)
    /* JADX INFO: renamed from: q */
    static native void m1553q();

    @JNI.InterfaceC2128I(m1430I = 336358377)
    /* JADX INFO: renamed from: r */
    static native void m1554r();

    @JNI.InterfaceC2128I(m1430I = 605746527)
    /* JADX INFO: renamed from: s */
    static native void m1555s();

    @JNI.InterfaceC2128I(m1430I = 895026767)
    /* JADX INFO: renamed from: t */
    static native void m1556t(Map<String, String> map);

    @JNI.InterfaceC2128I(m1430I = 542860974)
    /* JADX INFO: renamed from: u */
    static native void m1557u(String str, int i);

    @JNI.InterfaceC2128I(m1430I = 764687447)
    /* JADX INFO: renamed from: v */
    static native void m1558v(boolean z);

    @JNI.InterfaceC2128I(m1430I = 718243112)
    /* JADX INFO: renamed from: w */
    static native void m1559w(String str, int i);

    @JNI.InterfaceC2128I(m1430I = 845177302)
    /* JADX INFO: renamed from: x */
    static native void m1560x(String str, String str2);

    @JNI.InterfaceC2128I(m1430I = 507506694)
    /* JADX INFO: renamed from: y */
    static native void m1561y(String str, String str2);

    @JNI.InterfaceC2128I(m1430I = 980875271)
    /* JADX INFO: renamed from: z */
    static native void m1562z(String str);

    C2140af() {
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ void m1519Z(Context context) throws C2181bu {
        int i = 2 % 2;
        int i2 = f2402D + 117;
        f2403F = i2 % 128;
        m1497I(context, i2 % 2 == 0);
        int i3 = f2403F + 17;
        f2402D = i3 % 128;
        int i4 = i3 % 2;
    }

    static {
        m1545k();
        f2405V = null;
        f2404I = false;
        Code = m1510V("\u0000\u0000\u0001\u0000\u0001\u0001\u0001", new int[]{266, 7, 0, 5}, false).intern();
        f2401B = false;
        int i = f2402D + 107;
        f2403F = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: B */
    static synchronized void m1484B(Context context) {
        int i = 2 % 2;
        I i2 = new I(context);
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (i2 instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor(i2, executor, voidArr);
        } else {
            i2.executeOnExecutor(executor, voidArr);
        }
        int i3 = f2402D + 13;
        f2403F = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX INFO: renamed from: m */
    private static int m1548m() {
        int i = 2 % 2;
        int i2 = f2403F + 123;
        f2402D = i2 % 128;
        int i3 = i2 % 2;
        if (C2221j.f3485V != FaceTecAuditTrailType.FULL_RESOLUTION) {
            return 640;
        }
        int i4 = f2402D + 105;
        f2403F = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 54 / 0;
        }
        return -1;
    }

    /* JADX INFO: renamed from: Z */
    static void m1518Z() {
        int i = 2 % 2;
        int i2 = f2402D;
        int i3 = i2 + 73;
        f2403F = i3 % 128;
        int i4 = i3 % 2;
        if (!f2404I) {
            return;
        }
        int i5 = i2 + 19;
        f2403F = i5 % 128;
        int i6 = i5 % 2;
        m1525ae(m1548m());
    }

    /* JADX INFO: renamed from: com.facetec.sdk.af$I */
    static class I extends AbstractAsyncTaskC2155au {
        I(Context context) {
            super(context);
        }

        @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
        /* JADX INFO: renamed from: B */
        final void mo1563B() {
            try {
                C2140af.m1519Z(this.Code);
                C2140af.Code();
            } catch (Throwable unused) {
                cancel(false);
            }
        }

        @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
        /* JADX INFO: renamed from: Z */
        protected final void mo1564Z() {
            try {
                C2140af.Code(this.Code);
                C2226p.Code(this.Code);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (com.facetec.sdk.C2140af.f2401B != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static synchronized void Code(android.content.Context r9) throws java.lang.Throwable {
        /*
            java.lang.Class<com.facetec.sdk.af> r0 = com.facetec.sdk.C2140af.class
            monitor-enter(r0)
            r1 = 2
            int r2 = r1 % r1
            int r2 = com.facetec.sdk.C2140af.f2402D     // Catch: java.lang.Throwable -> Lb1
            int r2 = r2 + 115
            int r3 = r2 % 128
            com.facetec.sdk.C2140af.f2403F = r3     // Catch: java.lang.Throwable -> Lb1
            int r2 = r2 % r1
            r3 = 38
            r4 = 105(0x69, float:1.47E-43)
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L26
            m1497I(r9, r6)     // Catch: java.lang.Throwable -> L22 com.facetec.sdk.C2181bu -> L24
            Code()     // Catch: java.lang.Throwable -> L22 com.facetec.sdk.C2181bu -> L24
            boolean r2 = com.facetec.sdk.C2140af.f2401B     // Catch: java.lang.Throwable -> L22 com.facetec.sdk.C2181bu -> L24
            if (r2 == 0) goto L47
            goto L30
        L22:
            r9 = move-exception
            goto L6c
        L24:
            r9 = move-exception
            goto L8c
        L26:
            m1497I(r9, r5)     // Catch: java.lang.Throwable -> L22 com.facetec.sdk.C2181bu -> L24
            Code()     // Catch: java.lang.Throwable -> L22 com.facetec.sdk.C2181bu -> L24
            boolean r2 = com.facetec.sdk.C2140af.f2401B     // Catch: java.lang.Throwable -> L22 com.facetec.sdk.C2181bu -> L24
            if (r2 == 0) goto L47
        L30:
            int r2 = com.facetec.sdk.C2140af.f2403F     // Catch: java.lang.Throwable -> Lb1
            int r2 = r2 + r6
            int r7 = r2 % 128
            com.facetec.sdk.C2140af.f2402D = r7     // Catch: java.lang.Throwable -> Lb1
            int r2 = r2 % r1
            if (r2 != 0) goto L42
            m1512V(r9)     // Catch: java.lang.Throwable -> L22 com.facetec.sdk.C2181bu -> L24
            r9 = 40
            int r9 = r9 / r5
            monitor-exit(r0)
            return
        L42:
            m1512V(r9)     // Catch: java.lang.Throwable -> L22 com.facetec.sdk.C2181bu -> L24
            monitor-exit(r0)
            return
        L47:
            java.lang.String r1 = "\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001"
            r2 = 12
            int[] r2 = new int[]{r5, r3, r5, r2}     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = m1510V(r1, r2, r6)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = r1.intern()     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r2 = com.facetec.sdk.C2140af.f2405V     // Catch: java.lang.Throwable -> Lb1
            int r3 = m1548m()     // Catch: java.lang.Throwable -> Lb1
            m1506R(r1, r2, r3)     // Catch: java.lang.Throwable -> Lb1
            com.facetec.sdk.C2140af.f2401B = r6     // Catch: java.lang.Throwable -> Lb1
            java.lang.Class<com.facetec.sdk.bn> r1 = com.facetec.sdk.C2174bn.class
            m1498J(r1)     // Catch: java.lang.Throwable -> Lb1
            m1512V(r9)     // Catch: java.lang.Throwable -> Lb1
            monitor-exit(r0)
            return
        L6c:
            com.facetec.sdk.C2121D.Code(r9)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = "\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"
            r2 = 16
            r3 = 40
            r5 = 32
            int[] r2 = new int[]{r4, r3, r5, r2}     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = m1510V(r1, r2, r6)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = r1.intern()     // Catch: java.lang.Throwable -> Lb1
            com.facetec.sdk.C2131S.m1431V(r1)     // Catch: java.lang.Throwable -> Lb1
            com.facetec.sdk.bu r1 = new com.facetec.sdk.bu     // Catch: java.lang.Throwable -> Lb1
            r1.<init>(r9)     // Catch: java.lang.Throwable -> Lb1
            throw r1     // Catch: java.lang.Throwable -> Lb1
        L8c:
            boolean r2 = r9.Code()     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto Lb0
            java.lang.String r2 = "\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0001"
            r7 = 47
            r8 = 67
            int[] r3 = new int[]{r3, r8, r5, r7}     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r2 = m1510V(r2, r3, r6)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r2 = r2.intern()     // Catch: java.lang.Throwable -> Lb1
            com.facetec.sdk.C2131S.m1431V(r2)     // Catch: java.lang.Throwable -> Lb1
            int r2 = com.facetec.sdk.C2140af.f2403F     // Catch: java.lang.Throwable -> Lb1
            int r2 = r2 + r4
            int r3 = r2 % 128
            com.facetec.sdk.C2140af.f2402D = r3     // Catch: java.lang.Throwable -> Lb1
            int r2 = r2 % r1
            int r1 = r1 % r1
        Lb0:
            throw r9     // Catch: java.lang.Throwable -> Lb1
        Lb1:
            r9 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb1
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2140af.Code(android.content.Context):void");
    }

    /* JADX INFO: renamed from: B */
    static synchronized void m1483B() {
        int i = 2 % 2;
        int i2 = f2402D + 53;
        int i3 = i2 % 128;
        f2403F = i3;
        int i4 = i2 % 2;
        if (!(!f2404I)) {
            int i5 = i3 + 9;
            f2402D = i5 % 128;
            if (i5 % 2 == 0) {
                m1503O();
                throw null;
            }
            m1503O();
        }
        f2401B = false;
    }

    static synchronized void Code() throws C2181bu {
        int i = 2 % 2;
        int i2 = f2402D + 101;
        int i3 = i2 % 128;
        f2403F = i3;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (f2404I) {
            int i4 = i3 + 49;
            f2402D = i4 % 128;
            int i5 = i4 % 2;
            return;
        }
        try {
            System.loadLibrary("PhoenixAndroid");
            f2404I = true;
            Method[] declaredMethods = C2140af.class.getDeclaredMethods();
            int length = declaredMethods.length;
            int i6 = 0;
            while (i6 < length) {
                Method method = declaredMethods[i6];
                JNI.InterfaceC2128I interfaceC2128I = (JNI.InterfaceC2128I) method.getAnnotation(JNI.InterfaceC2128I.class);
                if (interfaceC2128I != null) {
                    JNI.m1429B(interfaceC2128I.m1430I(), method);
                    int i7 = 2 % 2;
                }
                i6++;
                int i8 = 2 % 2;
            }
            JNI.finalizeNativeMethods(C2140af.class, C2187ca.class);
            return;
        } catch (Throwable th) {
            C2131S.m1431V(new StringBuilder().append(m1510V("\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0001", new int[]{145, 31, 172, 27}, false).intern()).append(th.getMessage()).toString());
            throw new C2181bu(th);
        }
    }

    /* JADX INFO: renamed from: V */
    private static void m1512V(Context context) {
        int i = 2 % 2;
        int i2 = f2402D + 43;
        f2403F = i2 % 128;
        if (i2 % 2 == 0) {
            if (C2221j.f3486Z == null) {
                return;
            }
            final Context applicationContext = context.getApplicationContext();
            AbstractAsyncTaskC2155au.m1615B(new Runnable() { // from class: com.facetec.sdk.af.4
                @Override // java.lang.Runnable
                public final void run() {
                    C2140af.m1561y("fnkey_ZOOMSDK_VERSION", FaceTecSDK.version());
                    C2140af.m1561y("fnkey_ZOOMSDK_CLIENT_PACKAGE", applicationContext.getPackageName());
                    C2140af.m1561y("fnkey_ZOOMSDK_CLIENT_APPTOKEN", C2221j.f3486Z);
                    C2140af.m1561y("fnkey_ZOOMSDK_DEVICEMODEL", Build.MODEL);
                }
            });
            int i3 = f2402D + 35;
            f2403F = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 41 / 0;
                return;
            }
            return;
        }
        String str = C2221j.f3486Z;
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: I */
    private static synchronized void m1497I(Context context, boolean z) throws C2181bu {
        int i = 2 % 2;
        int i2 = f2403F + 125;
        f2402D = i2 % 128;
        int i3 = i2 % 2;
        try {
            if (f2405V != null && z && !new File(f2405V).exists()) {
                f2405V = null;
            }
            if (f2405V == null) {
                String string = new StringBuilder().append(context.getCacheDir().getPath()).append(m1510V("\u0001", new int[]{ISO7816Kt.INS_READ_BINARY, 1, 0, 1}, true).intern()).append(m1510V("\u0000\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000", new int[]{177, 16, 0, 0}, false).intern()).toString();
                new File(string).mkdirs();
                File file = new File(new StringBuilder().append(string).append(m1510V("\u0001", new int[]{ISO7816Kt.INS_READ_BINARY, 1, 0, 1}, true).intern()).append(m1510V("\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0000\u0001", new int[]{193, 26, 0, 1}, false).intern()).toString());
                m1514V(file);
                m1513V(context.getAssets(), m1510V("\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0000\u0001", new int[]{193, 26, 0, 1}, false).intern(), file.getAbsolutePath());
                f2405V = string;
                int i4 = f2403F + 67;
                f2402D = i4 % 128;
                if (i4 % 2 != 0) {
                    int i5 = 2 % 2;
                }
            }
        } catch (Throwable th) {
            throw new C2181bu(m1510V("\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001", new int[]{219, 47, 143, 33}, false).intern(), th);
        }
    }

    /* JADX INFO: renamed from: V */
    private static void m1514V(File file) {
        int i = 2 % 2;
        if (file.exists()) {
            if (file.isDirectory()) {
                int i2 = f2402D + 87;
                f2403F = i2 % 128;
                if (i2 % 2 == 0) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null) {
                        int length = fileArrListFiles.length;
                        int i3 = 0;
                        while (i3 < length) {
                            int i4 = f2402D + 69;
                            f2403F = i4 % 128;
                            if (i4 % 2 != 0) {
                                m1514V(fileArrListFiles[i3]);
                                i3 += ModuleDescriptor.MODULE_VERSION;
                            } else {
                                m1514V(fileArrListFiles[i3]);
                                i3++;
                            }
                        }
                    }
                } else {
                    file.listFiles();
                    throw null;
                }
            }
            file.delete();
            int i5 = f2403F + 107;
            f2402D = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    /* JADX INFO: renamed from: V */
    private static synchronized void m1513V(AssetManager assetManager, String str, String str2) throws Exception {
        InputStream inputStreamOpen;
        int i = 2 % 2;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            inputStreamOpen = assetManager.open(str, 2);
            int i2 = f2402D + 101;
            f2403F = i2 % 128;
            int i3 = i2 % 2;
            int i4 = 2 % 2;
        } catch (FileNotFoundException unused) {
            inputStreamOpen = null;
        }
        if (inputStreamOpen == null) {
            String[] list = assetManager.list(str);
            new File(str2).mkdirs();
            for (String str3 : list) {
                m1513V(assetManager, new StringBuilder().append(str).append(m1510V("\u0001", new int[]{ISO7816Kt.INS_READ_BINARY, 1, 0, 1}, true).intern()).append(str3).toString(), new StringBuilder().append(str2).append(m1510V("\u0001", new int[]{ISO7816Kt.INS_READ_BINARY, 1, 0, 1}, true).intern()).append(str3).toString());
            }
            return;
        }
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                byte[] bArr = new byte[2097152];
                while (true) {
                    int i5 = inputStreamOpen.read(bArr);
                    if (i5 <= 0) {
                        bufferedOutputStream2.close();
                        inputStreamOpen.close();
                        return;
                    } else {
                        int i6 = f2402D + 19;
                        f2403F = i6 % 128;
                        int i7 = i6 % 2;
                        bufferedOutputStream2.write(bArr, 0, i5);
                        int i8 = 2 % 2;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                    int i9 = f2402D + 113;
                    f2403F = i9 % 128;
                    if (i9 % 2 != 0) {
                        int i10 = 3 / 4;
                    } else {
                        int i11 = 2 % 2;
                    }
                }
                inputStreamOpen.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: I */
    static EnumC2139ae m1495I() {
        int i = 2 % 2;
        int i2 = f2403F + 5;
        f2402D = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 83 / 0;
            return EnumC2139ae.values()[m1505Q()];
        }
        return EnumC2139ae.values()[m1505Q()];
    }

    /* JADX INFO: renamed from: S */
    static EnumC2142ah m1507S() {
        EnumC2142ah enumC2142ah;
        int i = 2 % 2;
        int i2 = f2402D + 79;
        f2403F = i2 % 128;
        if (i2 % 2 != 0) {
            enumC2142ah = EnumC2142ah.values()[m1504P()];
            int i3 = 9 / 0;
        } else {
            enumC2142ah = EnumC2142ah.values()[m1504P()];
        }
        int i4 = f2403F + 117;
        f2402D = i4 % 128;
        int i5 = i4 % 2;
        return enumC2142ah;
    }

    /* JADX INFO: renamed from: D */
    static EnumC2147am m1488D() {
        int i = 2 % 2;
        int i2 = f2402D + 3;
        f2403F = i2 % 128;
        int i3 = i2 % 2;
        EnumC2147am enumC2147am = EnumC2147am.values()[m1515W()];
        int i4 = f2402D + 19;
        f2403F = i4 % 128;
        if (i4 % 2 == 0) {
            return enumC2147am;
        }
        throw null;
    }

    /* JADX INFO: renamed from: F */
    static EnumC2143ai m1491F() {
        int i = 2 % 2;
        int i2 = f2403F + 15;
        f2402D = i2 % 128;
        int i3 = i2 % 2;
        EnumC2143ai enumC2143ai = EnumC2143ai.values()[m1516X()];
        int i4 = f2403F + 39;
        f2402D = i4 % 128;
        if (i4 % 2 != 0) {
            return enumC2143ai;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: C */
    static EnumC2141ag m1486C() {
        int i = 2 % 2;
        int i2 = f2402D + 55;
        f2403F = i2 % 128;
        int i3 = i2 % 2;
        EnumC2141ag enumC2141ag = EnumC2141ag.values()[m1508T()];
        int i4 = f2402D + 67;
        f2403F = i4 % 128;
        int i5 = i4 % 2;
        return enumC2141ag;
    }

    /* JADX INFO: renamed from: d */
    static EnumC2152ar m1531d() {
        int i = 2 % 2;
        int i2 = f2403F + 19;
        f2402D = i2 % 128;
        Object obj = null;
        if (i2 % 2 != 0) {
            EnumC2152ar enumC2152ar = EnumC2152ar.values()[m1517Y()];
            int i3 = f2403F + 81;
            f2402D = i3 % 128;
            if (i3 % 2 != 0) {
                return enumC2152ar;
            }
            super.hashCode();
            throw null;
        }
        EnumC2152ar enumC2152ar2 = EnumC2152ar.values()[m1517Y()];
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: e */
    static EnumC2136ab m1533e() {
        int i = 2 % 2;
        int i2 = f2402D + 35;
        f2403F = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 66 / 0;
            return EnumC2136ab.values()[m1509U()];
        }
        return EnumC2136ab.values()[m1509U()];
    }

    /* JADX INFO: renamed from: b */
    static EnumC2137ac m1528b() {
        EnumC2137ac enumC2137ac;
        int i = 2 % 2;
        int i2 = f2403F + 39;
        f2402D = i2 % 128;
        if (i2 % 2 == 0) {
            enumC2137ac = EnumC2137ac.values()[m1522ab()];
            int i3 = 26 / 0;
        } else {
            enumC2137ac = EnumC2137ac.values()[m1522ab()];
        }
        int i4 = f2403F + 51;
        f2402D = i4 % 128;
        int i5 = i4 % 2;
        return enumC2137ac;
    }

    /* JADX INFO: renamed from: j */
    static EnumC2135aa m1543j() {
        EnumC2135aa enumC2135aa;
        int i = 2 % 2;
        int i2 = f2402D + 51;
        f2403F = i2 % 128;
        if (i2 % 2 != 0) {
            enumC2135aa = EnumC2135aa.values()[m1521aa()];
            int i3 = 22 / 0;
        } else {
            enumC2135aa = EnumC2135aa.values()[m1521aa()];
        }
        int i4 = f2402D + 73;
        f2403F = i4 % 128;
        if (i4 % 2 == 0) {
            return enumC2135aa;
        }
        throw null;
    }

    /* JADX INFO: renamed from: h */
    static byte[][] m1540h() {
        Object[] objArrM1524ad;
        byte[][] bArr;
        int i;
        int i2 = 2 % 2;
        int i3 = f2402D + 77;
        f2403F = i3 % 128;
        if (i3 % 2 != 0) {
            objArrM1524ad = m1524ad();
            bArr = new byte[objArrM1524ad.length][];
            i = 1;
        } else {
            objArrM1524ad = m1524ad();
            bArr = new byte[objArrM1524ad.length][];
            i = 0;
        }
        while (i < objArrM1524ad.length) {
            bArr[i] = (byte[]) objArrM1524ad[i];
            i++;
            int i4 = f2402D + 19;
            f2403F = i4 % 128;
            int i5 = i4 % 2;
        }
        return bArr;
    }

    /* JADX INFO: renamed from: i */
    static byte[][] m1542i() {
        int i = 2 % 2;
        Object[] objArrM1527ah = m1527ah();
        byte[][] bArr = new byte[objArrM1527ah.length][];
        int i2 = f2402D + 37;
        f2403F = i2 % 128;
        int i3 = i2 % 2;
        int i4 = 0;
        while (i4 < objArrM1527ah.length) {
            int i5 = f2402D + 69;
            f2403F = i5 % 128;
            if (i5 % 2 != 0) {
                bArr[i4] = (byte[]) objArrM1527ah[i4];
                i4 += 125;
            } else {
                bArr[i4] = (byte[]) objArrM1527ah[i4];
                i4++;
            }
        }
        return bArr;
    }

    /* JADX INFO: renamed from: f */
    static byte[][] m1536f() {
        int i = 2 % 2;
        int i2 = f2402D + 85;
        f2403F = i2 % 128;
        int i3 = i2 % 2;
        Object[] objArrM1523ac = m1523ac();
        byte[][] bArr = new byte[objArrM1523ac.length][];
        int i4 = 0;
        while (i4 < objArrM1523ac.length) {
            int i5 = f2403F + 31;
            f2402D = i5 % 128;
            if (i5 % 2 == 0) {
                bArr[i4] = (byte[]) objArrM1523ac[i4];
                i4 += 74;
            } else {
                bArr[i4] = (byte[]) objArrM1523ac[i4];
                i4++;
            }
        }
        return bArr;
    }

    /* JADX INFO: renamed from: g */
    static byte[][] m1538g() {
        int i = 2 % 2;
        Object[] objArrM1526af = m1526af();
        byte[][] bArr = new byte[objArrM1526af.length][];
        for (int i2 = 0; i2 < objArrM1526af.length; i2++) {
            int i3 = f2402D + 41;
            f2403F = i3 % 128;
            int i4 = i3 % 2;
            bArr[i2] = (byte[]) objArrM1526af[i2];
        }
        int i5 = f2402D + 103;
        f2403F = i5 % 128;
        if (i5 % 2 != 0) {
            int i6 = 29 / 0;
        }
        return bArr;
    }

    /* JADX INFO: renamed from: V */
    private static String m1510V(String str, int[] iArr, boolean z) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes(InternalZipConstants.AES_HASH_CHARSET);
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (C2198cl.f3046V) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            char[] cArr = new char[i2];
            System.arraycopy(f2406Z, i, cArr, 0, i2);
            if (bArr != null) {
                char[] cArr2 = new char[i2];
                C2198cl.Code = 0;
                char c = 0;
                while (C2198cl.Code < i2) {
                    if (bArr[C2198cl.Code] == 1) {
                        cArr2[C2198cl.Code] = (char) (((cArr[C2198cl.Code] << 1) + 1) - c);
                    } else {
                        cArr2[C2198cl.Code] = (char) ((cArr[C2198cl.Code] << 1) - c);
                    }
                    c = cArr2[C2198cl.Code];
                    C2198cl.Code++;
                }
                cArr = cArr2;
            }
            if (i4 > 0) {
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr, 0, cArr3, 0, i2);
                int i5 = i2 - i4;
                System.arraycopy(cArr3, 0, cArr, i5, i4);
                System.arraycopy(cArr3, i4, cArr, 0, i5);
            }
            if (z) {
                char[] cArr4 = new char[i2];
                C2198cl.Code = 0;
                while (C2198cl.Code < i2) {
                    cArr4[C2198cl.Code] = cArr[(i2 - C2198cl.Code) - 1];
                    C2198cl.Code++;
                }
                cArr = cArr4;
            }
            if (i3 > 0) {
                C2198cl.Code = 0;
                while (C2198cl.Code < i2) {
                    cArr[C2198cl.Code] = (char) (cArr[C2198cl.Code] - iArr[2]);
                    C2198cl.Code++;
                }
            }
            str2 = new String(cArr);
        }
        return str2;
    }
}
