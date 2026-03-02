package com.facetec.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.bs */
/* JADX INFO: loaded from: classes3.dex */
final class C2179bs {

    /* JADX INFO: renamed from: B */
    private static String f2943B = null;

    /* JADX INFO: renamed from: C */
    private static long f2944C = 0;
    private static boolean Code = false;

    /* JADX INFO: renamed from: D */
    private static int f2945D = 0;

    /* JADX INFO: renamed from: F */
    private static boolean f2946F = false;

    /* JADX INFO: renamed from: I */
    static boolean f2947I = false;

    /* JADX INFO: renamed from: L */
    private static long f2948L = 0;

    /* JADX INFO: renamed from: S */
    private static int f2949S = 1;

    /* JADX INFO: renamed from: V */
    private static String f2950V;

    /* JADX INFO: renamed from: Z */
    private static LinkedList<Long> f2951Z;

    /* JADX INFO: renamed from: I */
    static void m1941I() {
        f2948L = 370711628366175210L;
    }

    C2179bs() {
    }

    static {
        m1941I();
        f2950V = "";
        Code = false;
        f2943B = "";
        f2947I = false;
        int i = f2949S + 35;
        f2945D = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if ((r1 % 2) == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        r5 = 71 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        com.facetec.sdk.C2179bs.f2951Z = new java.util.LinkedList<>();
        com.facetec.sdk.C2179bs.f2944C = 0;
        com.facetec.sdk.C2179bs.f2946F = false;
        com.facetec.sdk.C2179bs.f2950V = r5.getPackageName();
        com.facetec.sdk.C2179bs.f2943B = android.provider.Settings.Secure.getString(r5.getContentResolver(), "android_id");
        m1939D(r5);
        com.facetec.sdk.C2179bs.Code = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        if (com.facetec.sdk.C2179bs.Code != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (com.facetec.sdk.C2179bs.Code != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r1 = r1 + 33;
        com.facetec.sdk.C2179bs.f2945D = r1 % 128;
     */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m1947Z(android.content.Context r5) {
        /*
            r0 = 2
            int r1 = r0 % r0
            int r1 = com.facetec.sdk.C2179bs.f2949S
            int r2 = r1 + 53
            int r3 = r2 % 128
            com.facetec.sdk.C2179bs.f2945D = r3
            int r2 = r2 % r0
            r3 = 0
            if (r2 == 0) goto L17
            boolean r2 = com.facetec.sdk.C2179bs.Code
            r4 = 94
            int r4 = r4 / r3
            if (r2 == 0) goto L28
            goto L1b
        L17:
            boolean r2 = com.facetec.sdk.C2179bs.Code
            if (r2 == 0) goto L28
        L1b:
            int r1 = r1 + 33
            int r5 = r1 % 128
            com.facetec.sdk.C2179bs.f2945D = r5
            int r1 = r1 % r0
            if (r1 == 0) goto L27
            r5 = 71
            int r5 = r5 / r3
        L27:
            return
        L28:
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            com.facetec.sdk.C2179bs.f2951Z = r0
            r0 = 0
            com.facetec.sdk.C2179bs.f2944C = r0
            com.facetec.sdk.C2179bs.f2946F = r3
            java.lang.String r0 = r5.getPackageName()
            com.facetec.sdk.C2179bs.f2950V = r0
            android.content.ContentResolver r0 = r5.getContentResolver()
            java.lang.String r1 = "android_id"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r1)
            com.facetec.sdk.C2179bs.f2943B = r0
            m1939D(r5)
            r5 = 1
            com.facetec.sdk.C2179bs.Code = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2179bs.m1947Z(android.content.Context):void");
    }

    static void Code(Context context) {
        int i = 2 % 2;
        if (Code) {
            f2951Z.add(Long.valueOf(new Date().getTime()));
            m1940F(context);
            int i2 = f2945D + ModuleDescriptor.MODULE_VERSION;
            f2949S = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        int i4 = f2949S + 63;
        f2945D = i4 % 128;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: V */
    static void m1945V(Context context) {
        int i = 2 % 2;
        int i2 = f2949S;
        int i3 = i2 + 95;
        f2945D = i3 % 128;
        if (i3 % 2 == 0) {
            if (!Code) {
                int i4 = i2 + 21;
                f2945D = i4 % 128;
                int i5 = i4 % 2;
                return;
            } else {
                if (!f2951Z.isEmpty()) {
                    f2951Z.removeLast();
                    int i6 = f2949S + 119;
                    f2945D = i6 % 128;
                    int i7 = i6 % 2;
                }
                Code(context);
                return;
            }
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: I */
    static void m1942I(Context context) {
        int i = 2 % 2;
        int i2 = f2949S + 109;
        int i3 = i2 % 128;
        f2945D = i3;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (!f2946F) {
            int i4 = i3 + 67;
            f2949S = i4 % 128;
            int i5 = i4 % 2;
            f2946F = true;
            while (f2951Z.size() > 3) {
                int i6 = f2945D + 37;
                f2949S = i6 % 128;
                if (i6 % 2 == 0) {
                    f2951Z.removeFirst();
                    int i7 = 14 / 0;
                } else {
                    f2951Z.removeFirst();
                }
            }
            m1940F(context);
        }
        int i8 = f2945D + 117;
        f2949S = i8 % 128;
        int i9 = i8 % 2;
    }

    /* JADX INFO: renamed from: B */
    static void m1935B(Context context) {
        int i = 2 % 2;
        int i2 = f2945D + 43;
        f2949S = i2 % 128;
        if (i2 % 2 != 0) {
            if (Code && !f2951Z.isEmpty()) {
                f2951Z.removeLast();
                m1940F(context);
                int i3 = f2945D + 89;
                f2949S = i3 % 128;
                int i4 = i3 % 2;
                return;
            }
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: C */
    static long m1938C(Context context) {
        long j;
        int i = 2 % 2;
        if (!f2951Z.isEmpty()) {
            long size = f2951Z.size();
            long jLongValue = f2951Z.peekLast().longValue();
            long j2 = jLongValue - (!f2947I ? 300000L : 600000L);
            while (!f2951Z.isEmpty() && f2951Z.peekFirst().longValue() < j2) {
                f2951Z.removeFirst();
            }
            Object obj = null;
            if (f2947I) {
                int i2 = f2945D + 125;
                f2949S = i2 % 128;
                if (i2 % 2 == 0) {
                    super.hashCode();
                    throw null;
                }
                j = 12;
            } else {
                int i3 = f2949S + 35;
                f2945D = i3 % 128;
                int i4 = i3 % 2;
                j = 10;
            }
            if (f2951Z.size() >= j) {
                int i5 = f2949S + 83;
                f2945D = i5 % 128;
                if (i5 % 2 != 0) {
                    f2944C = jLongValue;
                    f2951Z.clear();
                    super.hashCode();
                    throw null;
                }
                f2944C = jLongValue;
                f2951Z.clear();
            }
            if (f2951Z.size() != size) {
                m1940F(context);
            }
        }
        long j3 = f2944C;
        if (j3 == 0) {
            return 0L;
        }
        int i6 = f2945D + 77;
        f2949S = i6 % 128;
        int i7 = i6 % 2;
        return j3 + PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    /* JADX INFO: renamed from: S */
    static boolean m1943S(Context context) {
        int i = 2 % 2;
        int i2 = f2945D + 67;
        f2949S = i2 % 128;
        int i3 = i2 % 2;
        long jM1938C = m1938C(context);
        if (jM1938C > 0) {
            if (new Date().getTime() >= jM1938C) {
                return false;
            }
            int i4 = f2949S + 21;
            f2945D = i4 % 128;
            int i5 = i4 % 2;
            return true;
        }
        int i6 = f2945D + 101;
        f2949S = i6 % 128;
        if (i6 % 2 != 0) {
            return false;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: D */
    private static boolean m1939D(Context context) {
        int i = 2 % 2;
        try {
            byte[] bArrM2270B = C2225o.m2270B(new File(context.getCacheDir(), m1944V()), m1937B());
            JSONObject jSONObject = new JSONObject(new String(bArrM2270B, 0, bArrM2270B.length, StandardCharsets.UTF_8));
            f2951Z.clear();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(m1946Z("完Ρ", (ViewConfiguration.getFadingEdgeLength() >> 16) + 22567).intern());
            if (jSONArrayOptJSONArray != null) {
                int i2 = f2949S + 91;
                f2945D = i2 % 128;
                int i3 = i2 % 2;
                int i4 = 0;
                while (i4 < jSONArrayOptJSONArray.length()) {
                    int i5 = f2949S + 77;
                    f2945D = i5 % 128;
                    if (i5 % 2 != 0) {
                        f2951Z.add(Long.valueOf(jSONArrayOptJSONArray.getLong(i4)));
                        i4 += 120;
                    } else {
                        f2951Z.add(Long.valueOf(jSONArrayOptJSONArray.getLong(i4)));
                        i4++;
                    }
                }
                Collections.sort(f2951Z);
            }
            f2944C = jSONObject.optLong(m1946Z("宆圭", ExpandableListView.getPackedPositionType(0L) + 3251).intern(), 0L);
            f2946F = jSONObject.optBoolean(m1946Z("宂ꉲ", 63997 - View.combineMeasuredStates(0, 0)).intern(), false);
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        } catch (Exception e) {
            C2188cb.m1995V(e.getMessage());
            e.getStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: F */
    private static void m1940F(Context context) {
        int i = 2 % 2;
        int i2 = f2949S + 89;
        int i3 = i2 % 128;
        f2945D = i3;
        int i4 = i2 % 2;
        if (context == null) {
            int i5 = i3 + 65;
            f2949S = i5 % 128;
            int i6 = i5 % 2;
            return;
        }
        Thread thread = new Thread(new Z(context));
        thread.setPriority(1);
        thread.start();
        int i7 = f2945D + 59;
        f2949S = i7 % 128;
        if (i7 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bs$Z */
    static class Z implements Runnable {

        /* JADX INFO: renamed from: I */
        private final WeakReference<Context> f2952I;

        Z(Context context) {
            this.f2952I = new WeakReference<>(context.getApplicationContext());
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = this.f2952I.get();
            if (context == null) {
                return;
            }
            try {
                C2179bs.m1936B(context.getCacheDir());
            } catch (Exception e) {
                C2188cb.m1995V(e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: V */
    private static String m1944V() throws Exception {
        int i = 2 % 2;
        String strM2263V = C2222k.m2263V(new StringBuilder().append(f2950V).append(f2943B).append(m1946Z("宆䝼扻൪⡡쭂\uf648酺뱄彂稼攼\u0019⌦츚\ue909鐟뜑分緰ᣲ", (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 7416).intern()).toString());
        int i2 = f2949S + 61;
        f2945D = i2 % 128;
        if (i2 % 2 == 0) {
            return strM2263V;
        }
        throw null;
    }

    /* JADX INFO: renamed from: B */
    private static byte[] m1937B() throws Exception {
        int i = 2 % 2;
        byte[] bArrM2258B = C2222k.m2258B(new StringBuilder().append(f2950V).append(f2943B).append(m1946Z("宆謜請⩊᧡䥢레\uef9a\udf49\u0eee繩", (ViewConfiguration.getLongPressTimeout() >> 16) + 53401).intern()).toString());
        int i2 = f2945D + 95;
        f2949S = i2 % 128;
        if (i2 % 2 != 0) {
            return bArrM2258B;
        }
        throw null;
    }

    /* JADX INFO: renamed from: B */
    static /* synthetic */ void m1936B(File file) throws Exception {
        int i = 2 % 2;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<Long> it2 = f2951Z.iterator();
        while (it2.hasNext()) {
            int i2 = f2945D + 9;
            f2949S = i2 % 128;
            if (i2 % 2 == 0) {
                jSONArray.put(it2.next().longValue());
                Object obj = null;
                super.hashCode();
                throw null;
            }
            jSONArray.put(it2.next().longValue());
        }
        jSONObject.put(m1946Z("完Ρ", 22566 - ((byte) KeyEvent.getModifierMetaStateMask())).intern(), jSONArray);
        jSONObject.put(m1946Z("宆圭", TextUtils.indexOf("", "") + 3251).intern(), f2944C);
        jSONObject.put(m1946Z("宂ꉲ", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 63996).intern(), f2946F);
        jSONObject.put(m1946Z("官", 30181 - KeyEvent.normalizeMetaState(0)).intern(), C2188cb.Code(128));
        C2225o.m2274Z(new File(file, m1944V()), m1937B(), (!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).getBytes(StandardCharsets.UTF_8));
        int i3 = f2949S + 121;
        f2945D = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX INFO: renamed from: Z */
    private static String m1946Z(String str, int i) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (C2191ce.f3028V) {
            C2191ce.Code = i;
            char[] cArr2 = new char[cArr.length];
            C2191ce.f3027I = 0;
            while (C2191ce.f3027I < cArr.length) {
                cArr2[C2191ce.f3027I] = (char) (((long) (cArr[C2191ce.f3027I] ^ (C2191ce.f3027I * C2191ce.Code))) ^ f2948L);
                C2191ce.f3027I++;
            }
            str2 = new String(cArr2);
        }
        return str2;
    }
}
