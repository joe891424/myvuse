package com.facetec.sdk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.I */
/* JADX INFO: loaded from: classes3.dex */
final class C2127I implements ZoomEncryptStrings {

    /* JADX INFO: renamed from: B */
    private static C2127I f2271B = null;

    /* JADX INFO: renamed from: C */
    private static int f2272C = 1;

    /* JADX INFO: renamed from: D */
    private static char[] f2273D;

    /* JADX INFO: renamed from: F */
    private static int f2274F;

    /* JADX INFO: renamed from: L */
    private static char f2275L;

    /* JADX INFO: renamed from: V */
    private static byte[] f2276V;
    private int Code;

    /* JADX INFO: renamed from: I */
    private I f2277I;

    /* JADX INFO: renamed from: Z */
    private boolean f2278Z;

    /* JADX INFO: renamed from: V */
    static void m1422V() {
        f2273D = new char[]{'r', 'e', 'm', 'a', 'i', 'n', 'g', 'Z', 'o', 's', 'D', 'v', 'M', 'd', 't', 'S', SafeJsonPrimitive.NULL_CHAR, '_', 'p', 'h', 'A', 'V', '2', 'K', 'y'};
        f2275L = (char) 5;
    }

    /* synthetic */ C2127I(Context context, byte b) {
        this(context);
    }

    static /* synthetic */ int Code(C2127I c2127i) {
        int i;
        int i2;
        int i3 = 2 % 2;
        int i4 = f2274F;
        int i5 = i4 + 15;
        f2272C = i5 % 128;
        if (i5 % 2 == 0) {
            i = c2127i.Code;
            i2 = i >>> 1;
        } else {
            i = c2127i.Code;
            i2 = i - 1;
        }
        c2127i.Code = i2;
        int i6 = i4 + 3;
        f2272C = i6 % 128;
        if (i6 % 2 != 0) {
            return i;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ I m1417I(C2127I c2127i, I i) {
        int i2 = 2 % 2;
        int i3 = f2272C;
        int i4 = i3 + 99;
        f2274F = i4 % 128;
        int i5 = i4 % 2;
        c2127i.f2277I = i;
        if (i5 != 0) {
            Object obj = null;
            super.hashCode();
            throw null;
        }
        int i6 = i3 + 85;
        f2274F = i6 % 128;
        int i7 = i6 % 2;
        return i;
    }

    /* JADX INFO: renamed from: V */
    static /* synthetic */ int m1420V(C2127I c2127i) {
        int i = 2 % 2;
        int i2 = f2272C;
        int i3 = i2 + 79;
        f2274F = i3 % 128;
        int i4 = i3 % 2;
        int i5 = c2127i.Code;
        if (i4 != 0) {
            int i6 = 80 / 0;
        }
        int i7 = i2 + 29;
        f2274F = i7 % 128;
        int i8 = i7 % 2;
        return i5;
    }

    /* JADX INFO: renamed from: V */
    static /* synthetic */ int m1421V(C2127I c2127i, int i) {
        int i2 = 2 % 2;
        int i3 = f2272C;
        int i4 = i3 + 91;
        f2274F = i4 % 128;
        int i5 = i4 % 2;
        c2127i.Code = i;
        int i6 = i3 + 51;
        f2274F = i6 % 128;
        int i7 = i6 % 2;
        return i;
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ boolean m1425Z(C2127I c2127i, boolean z) {
        int i = 2 % 2;
        int i2 = f2272C + 45;
        int i3 = i2 % 128;
        f2274F = i3;
        int i4 = i2 % 2;
        Object obj = null;
        c2127i.f2278Z = z;
        if (i4 != 0) {
            super.hashCode();
            throw null;
        }
        int i5 = i3 + 93;
        f2272C = i5 % 128;
        if (i5 % 2 != 0) {
            return z;
        }
        throw null;
    }

    static {
        m1422V();
        f2276V = null;
        f2271B = null;
        int i = f2274F + 123;
        f2272C = i % 128;
        int i2 = i % 2;
    }

    private C2127I(Context context) {
        this.Code = 0;
        this.f2278Z = true;
        this.f2277I = new I();
        try {
            byte[] bArrM2272V = C2225o.m2272V(context, m1419S(context), m1415C(context));
            JSONObject jSONObject = new JSONObject(new String(bArrM2272V, 0, bArrM2272V.length, StandardCharsets.UTF_8));
            this.Code = jSONObject.getInt(Code((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 15, "\u0001\u0002\u0003\u0004\u0000\t\u0000\t\u0007\b\u0087\u0087\u0004\u0007", (byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 25)).intern());
            this.f2278Z = jSONObject.optBoolean(Code(Color.alpha(0) + 9, "\t\u000e\u000b\u0000\f\r\r\u0012Ñ", (byte) (ImageFormat.getBitsPerPixel(0) + 109)).intern());
            String strOptString = jSONObject.optString(Code(8 - (ViewConfiguration.getDoubleTapTimeout() >> 16), "\u0006\u0004\u009a\u009a\u0000\t\u0007\u0005", (byte) (KeyEvent.getDeadChar(0, 0) + 38)).intern(), "");
            if (strOptString.isEmpty()) {
                return;
            }
            this.f2277I = I.m1428Z(new JSONObject(strOptString));
        } catch (Exception e) {
            C2121D.Code(e);
        }
    }

    /* JADX INFO: renamed from: B */
    private static synchronized C2127I m1413B(Context context) throws Exception {
        C2127I c2127i;
        int i = 2 % 2;
        int i2 = f2274F + 65;
        f2272C = i2 % 128;
        int i3 = i2 % 2;
        if (f2271B == null) {
            f2271B = new C2127I(context);
        }
        c2127i = f2271B;
        int i4 = f2274F + 23;
        f2272C = i4 % 128;
        if (i4 % 2 == 0) {
            throw null;
        }
        return c2127i;
    }

    private static synchronized I Code() {
        C2127I c2127i;
        int i = 2 % 2;
        int i2 = f2272C + OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_NEW_GROUP_ADDED;
        int i3 = i2 % 128;
        f2274F = i3;
        int i4 = i2 % 2;
        c2127i = f2271B;
        if (c2127i == null) {
            try {
                throw new RuntimeException(Code(17 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), "\u0010\u0000¯¯\u0000\t\u0007\u0005\u0011\u0001\t\u000e\u000e\t\u0006\u0007", (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 58)).intern());
            } catch (Exception e) {
                C2121D.Code(e);
                return new I();
            }
        }
        int i5 = i3 + 125;
        f2272C = i5 % 128;
        int i6 = i5 % 2;
        return c2127i.f2277I;
    }

    /* JADX INFO: renamed from: F */
    private static byte[] m1416F(Context context) throws Exception {
        byte[] bArrM1992I;
        int i = 2 % 2;
        String strM2263V = C2222k.m2263V(new StringBuilder().append(context.getPackageName()).append(Settings.Secure.getString(context.getContentResolver(), Code(View.MeasureSpec.makeMeasureSpec(0, 0) + 10, "\u0000\b\n\u0003\t\u0003\f\u0012\u0003\u000e", (byte) (44 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)))).intern())).append(Code(View.resolveSizeAndState(0, 0, 0) + 10, "\b\u0017\u0013\u0012\u0013\u000f\u0001\u0004\u0006\u0004", (byte) (100 - KeyEvent.keyCodeFromString(""))).intern()).toString());
        Object obj = null;
        try {
            bArrM1992I = C2225o.m2271V(context, strM2263V);
        } catch (FileNotFoundException unused) {
            bArrM1992I = null;
        }
        if (bArrM1992I == null) {
            try {
                bArrM1992I = C2225o.m2271V(context, C2222k.m2263V(new StringBuilder().append(context.getPackageName()).append(Code(View.getDefaultSize(0, 0) + 10, "\u0000\b\n\u0003\t\u0003\f\u0012\u0003\u000e", (byte) (45 - (ViewConfiguration.getMaximumFlingVelocity() >> 16))).intern()).append(Code(KeyEvent.normalizeMetaState(0) + 10, "\b\u0017\u0013\u0012\u0013\u000f\u0001\u0004\u0006\u0004", (byte) (KeyEvent.getDeadChar(0, 0) + 100)).intern()).toString()));
                C2225o.m2273Z(context, strM2263V, bArrM1992I);
            } catch (FileNotFoundException unused2) {
            }
        }
        if (bArrM1992I == null) {
            int i2 = f2272C + 49;
            f2274F = i2 % 128;
            if (i2 % 2 != 0) {
                bArrM1992I = C2188cb.m1992I(13, 28288);
                C2225o.m2273Z(context, strM2263V, bArrM1992I);
            } else {
                bArrM1992I = C2188cb.m1992I(32, 128);
                C2225o.m2273Z(context, strM2263V, bArrM1992I);
            }
        }
        int i3 = f2272C + 19;
        f2274F = i3 % 128;
        if (i3 % 2 == 0) {
            return bArrM1992I;
        }
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: Z */
    static byte[] m1426Z(Context context) throws Exception {
        int i = 2 % 2;
        int i2 = f2272C;
        int i3 = i2 + 109;
        f2274F = i3 % 128;
        int i4 = i3 % 2;
        if (f2276V == null) {
            int i5 = i2 + 113;
            f2274F = i5 % 128;
            if (i5 % 2 != 0) {
                f2276V = m1416F(context);
                throw null;
            }
            f2276V = m1416F(context);
            int i6 = f2272C + 119;
            f2274F = i6 % 128;
            int i7 = i6 % 2;
        }
        byte[] bArrM2264Z = C2222k.m2264Z(f2276V);
        int i8 = f2272C + 65;
        f2274F = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 40 / 0;
        }
        return bArrM2264Z;
    }

    /* JADX INFO: renamed from: V */
    static boolean m1424V(Context context) {
        int i = 2 % 2;
        int i2 = f2274F + 47;
        f2272C = i2 % 128;
        int i3 = i2 % 2;
        try {
            if (m1413B(context).Code <= 0) {
                return false;
            }
            int i4 = f2274F;
            int i5 = i4 + 7;
            f2272C = i5 % 128;
            int i6 = i5 % 2;
            int i7 = i4 + 71;
            f2272C = i7 % 128;
            int i8 = i7 % 2;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: V */
    static void m1423V(Context context, final I i) {
        int i2 = 2 % 2;
        new Code() { // from class: com.facetec.sdk.I.4

            /* JADX INFO: renamed from: V */
            private /* synthetic */ boolean f2280V = false;

            {
                super((byte) 0);
            }

            @Override // com.facetec.sdk.C2127I.Code
            /* JADX INFO: renamed from: B */
            final void mo1427B(C2127I c2127i) {
                C2127I.m1425Z(c2127i, this.f2280V);
                C2127I.m1421V(c2127i, i.f2285I.intValue());
                C2127I.m1417I(c2127i, i);
            }
        }.Code(context);
        int i3 = f2272C + 23;
        f2274F = i3 % 128;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: I */
    static void m1418I(Context context) {
        int i = 2 % 2;
        new Code() { // from class: com.facetec.sdk.I.1
            @Override // com.facetec.sdk.C2127I.Code
            /* JADX INFO: renamed from: B */
            final void mo1427B(C2127I c2127i) {
                if (C2127I.m1420V(c2127i) > 0) {
                    C2127I.Code(c2127i);
                }
            }
        }.Code(context);
        int i2 = f2274F + 121;
        f2272C = i2 % 128;
        int i3 = i2 % 2;
    }

    static boolean Code(Context context) {
        boolean z;
        int i = 2 % 2;
        int i2 = f2272C + 1;
        f2274F = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                z = m1413B(context).f2278Z;
                int i3 = 96 / 0;
            } else {
                z = m1413B(context).f2278Z;
            }
            int i4 = f2274F + 77;
            f2272C = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 69 / 0;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: B */
    static boolean m1414B() {
        int i = 2 % 2;
        int i2 = f2274F + 15;
        f2272C = i2 % 128;
        int i3 = i2 % 2;
        boolean zBooleanValue = Code().Code.booleanValue();
        int i4 = f2274F + 7;
        f2272C = i4 % 128;
        int i5 = i4 % 2;
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: S */
    private static String m1419S(Context context) throws Exception {
        int i = 2 % 2;
        int i2 = f2272C + 31;
        f2274F = i2 % 128;
        int i3 = i2 % 2;
        String strM2257B = C2222k.m2257B(m1426Z(context), Code((ViewConfiguration.getTapTimeout() >> 16) + 13, "\b\t\u0007\u0003\u0017\u000f\u000f\r\u0004\r\u0001\u0017¥", (byte) (115 - Gravity.getAbsoluteGravity(0, 0))).intern());
        int i4 = f2274F + 105;
        f2272C = i4 % 128;
        int i5 = i4 % 2;
        return strM2257B;
    }

    /* JADX INFO: renamed from: C */
    private static byte[] m1415C(Context context) throws Exception {
        int i = 2 % 2;
        int i2 = f2274F + 39;
        f2272C = i2 % 128;
        return i2 % 2 == 0 ? C2222k.m2260I(m1426Z(context), Code(ViewConfiguration.getEdgeSlop() + 99, "\b\t\u0007\u0003\u0017\u000f\u000f\r\u0004\r\b\u0003\u0004\u0015", (byte) (102 % Process.getGidForName(""))).intern()) : C2222k.m2260I(m1426Z(context), Code(14 - (ViewConfiguration.getEdgeSlop() >> 16), "\b\t\u0007\u0003\u0017\u000f\u000f\r\u0004\r\b\u0003\u0004\u0015", (byte) (Process.getGidForName("") + 78)).intern());
    }

    /* JADX INFO: renamed from: com.facetec.sdk.I$Code */
    static abstract class Code {
        /* JADX INFO: renamed from: B */
        abstract void mo1427B(C2127I c2127i);

        private Code() {
        }

        /* synthetic */ Code(byte b) {
            this();
        }

        final synchronized void Code(Context context) {
            try {
                C2127I c2127i = new C2127I(context, (byte) 0);
                mo1427B(c2127i);
                C2127I.Code(c2127i, context);
            } catch (Exception e) {
                C2121D.Code(e);
            }
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.I$I */
    static class I {

        /* JADX INFO: renamed from: B */
        private String f2282B;

        /* JADX INFO: renamed from: C */
        private Integer f2283C;

        /* JADX INFO: renamed from: S */
        private Integer f2287S;

        /* JADX INFO: renamed from: Z */
        private String f2289Z;
        Boolean Code = Boolean.FALSE;

        /* JADX INFO: renamed from: V */
        private Integer f2288V = 10;

        /* JADX INFO: renamed from: I */
        Integer f2285I = 0;

        /* JADX INFO: renamed from: D */
        private Boolean f2284D = Boolean.FALSE;

        /* JADX INFO: renamed from: L */
        private Boolean f2286L = Boolean.TRUE;

        I() {
        }

        /* JADX INFO: renamed from: com.facetec.sdk.I$I$Z */
        enum Z {
            ID("id"),
            APP_SEND_DIAGNOSTICS("sd"),
            DIAGNOSTICS_SIZE("ds"),
            GRACE_PERIOD("gp"),
            CACHE_KEY("ck"),
            IS_VERSION_DEPRECATED("vd"),
            RECENT_FAILURES("rf"),
            APPLICATION_ID("ai"),
            IS_LATEST_VERSION("lv");


            /* JADX INFO: renamed from: D */
            final String f2299D;

            Z(String str) {
                this.f2299D = str;
            }
        }

        /* JADX INFO: renamed from: Z */
        static I m1428Z(JSONObject jSONObject) throws JSONException {
            I i = new I();
            for (Z z : Z.values()) {
                switch (AnonymousClass5.f2281I[z.ordinal()]) {
                    case 1:
                        i.f2289Z = jSONObject.getString(z.f2299D);
                        break;
                    case 2:
                        i.Code = Boolean.valueOf(jSONObject.getBoolean(z.f2299D));
                        break;
                    case 3:
                        i.f2288V = Integer.valueOf(jSONObject.getInt(z.f2299D));
                        break;
                    case 4:
                        i.f2285I = Integer.valueOf(jSONObject.getInt(z.f2299D));
                        break;
                    case 5:
                        i.f2282B = jSONObject.getString(z.f2299D);
                        break;
                    case 6:
                        i.f2284D = Boolean.valueOf(jSONObject.getBoolean(z.f2299D));
                        break;
                    case 7:
                        i.f2287S = Integer.valueOf(jSONObject.getInt(z.f2299D));
                        break;
                    case 8:
                        i.f2283C = Integer.valueOf(jSONObject.getInt(z.f2299D));
                        break;
                    case 9:
                        i.f2286L = Boolean.valueOf(jSONObject.getBoolean(z.f2299D));
                        break;
                }
            }
            return i;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final java.lang.String Code() {
            /*
                r7 = this;
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                com.facetec.sdk.I$I$Z[] r1 = com.facetec.sdk.C2127I.I.Z.values()     // Catch: org.json.JSONException -> L65
                int r2 = r1.length     // Catch: org.json.JSONException -> L65
                r3 = 0
            Lb:
                if (r3 >= r2) goto L69
                r4 = r1[r3]     // Catch: org.json.JSONException -> L65
                int[] r5 = com.facetec.sdk.C2127I.AnonymousClass5.f2281I     // Catch: org.json.JSONException -> L65
                int r6 = r4.ordinal()     // Catch: org.json.JSONException -> L65
                r5 = r5[r6]     // Catch: org.json.JSONException -> L65
                switch(r5) {
                    case 1: goto L5b;
                    case 2: goto L53;
                    case 3: goto L4b;
                    case 4: goto L43;
                    case 5: goto L3b;
                    case 6: goto L33;
                    case 7: goto L2b;
                    case 8: goto L23;
                    case 9: goto L1b;
                    default: goto L1a;
                }     // Catch: org.json.JSONException -> L65
            L1a:
                goto L62
            L1b:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.Boolean r5 = r7.f2286L     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
                goto L62
            L23:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.Integer r5 = r7.f2283C     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
                goto L62
            L2b:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.Integer r5 = r7.f2287S     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
                goto L62
            L33:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.Boolean r5 = r7.f2284D     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
                goto L62
            L3b:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.String r5 = r7.f2282B     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
                goto L62
            L43:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.Integer r5 = r7.f2285I     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
                goto L62
            L4b:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.Integer r5 = r7.f2288V     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
                goto L62
            L53:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.Boolean r5 = r7.Code     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
                goto L62
            L5b:
                java.lang.String r4 = r4.f2299D     // Catch: org.json.JSONException -> L65
                java.lang.String r5 = r7.f2289Z     // Catch: org.json.JSONException -> L65
                r0.put(r4, r5)     // Catch: org.json.JSONException -> L65
            L62:
                int r3 = r3 + 1
                goto Lb
            L65:
                r1 = move-exception
                r1.printStackTrace()
            L69:
                boolean r1 = r0 instanceof org.json.JSONObject
                if (r1 != 0) goto L72
                java.lang.String r0 = r0.toString()
                goto L79
            L72:
                r1 = r0
                org.json.JSONObject r1 = (org.json.JSONObject) r1
                java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)
            L79:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2127I.I.Code():java.lang.String");
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.I$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f2281I;

        static {
            int[] iArr = new int[I.Z.values().length];
            f2281I = iArr;
            try {
                iArr[I.Z.ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2281I[I.Z.APP_SEND_DIAGNOSTICS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2281I[I.Z.DIAGNOSTICS_SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2281I[I.Z.GRACE_PERIOD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2281I[I.Z.CACHE_KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2281I[I.Z.IS_VERSION_DEPRECATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2281I[I.Z.RECENT_FAILURES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2281I[I.Z.APPLICATION_ID.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2281I[I.Z.IS_LATEST_VERSION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static /* synthetic */ void Code(C2127I c2127i, Context context) throws Exception {
        int i = 2 % 2;
        f2271B = c2127i;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Code(14 - (ViewConfiguration.getDoubleTapTimeout() >> 16), "\u0001\u0002\u0003\u0004\u0000\t\u0000\t\u0007\b\u0087\u0087\u0004\u0007", (byte) (24 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).intern(), c2127i.Code);
        jSONObject.put(Code(9 - ((Process.getThreadPriority(0) + 20) >> 6), "\t\u000e\u000b\u0000\f\r\r\u0012Ñ", (byte) (TextUtils.indexOf((CharSequence) "", '0') + 109)).intern(), c2127i.f2278Z);
        jSONObject.put(Code(Color.alpha(0) + 8, "\u0006\u0004\u009a\u009a\u0000\t\u0007\u0005", (byte) (38 - KeyEvent.keyCodeFromString(""))).intern(), c2127i.f2277I.Code());
        jSONObject.put(Code((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 6, "\u0001\u0004\b\n\u0007\u0003", (byte) (89 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).intern(), C2188cb.Code(32));
        C2225o.m2273Z(context, m1419S(context), new C2159ay(m1415C(context)).m1797B((!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).getBytes(StandardCharsets.UTF_8)));
        int i2 = f2272C + 11;
        f2274F = i2 % 128;
        int i3 = i2 % 2;
    }

    private static String Code(int i, String str, byte b) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (C2190cd.f3022F) {
            char[] cArr2 = f2273D;
            char c = f2275L;
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
