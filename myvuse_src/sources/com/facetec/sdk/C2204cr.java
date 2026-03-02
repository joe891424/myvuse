package com.facetec.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facetec.sdk.C2210cx;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.facetec.sdk.cr */
/* JADX INFO: loaded from: classes3.dex */
public final class C2204cr extends C2207cu {

    /* JADX INFO: renamed from: B */
    public static C2214dc f3083B = null;

    /* JADX INFO: renamed from: C */
    private static final long[] f3084C;
    private static final long[] Code;

    /* JADX INFO: renamed from: D */
    private static final long[] f3085D;

    /* JADX INFO: renamed from: F */
    private static final String[] f3086F;

    /* JADX INFO: renamed from: I */
    private static final long[] f3087I;

    /* JADX INFO: renamed from: L */
    private static final String[] f3088L;

    /* JADX INFO: renamed from: S */
    private static final long[] f3089S;

    /* JADX INFO: renamed from: V */
    private static final long[] f3090V;

    /* JADX INFO: renamed from: Z */
    private static final long[] f3091Z;

    /* JADX INFO: renamed from: a */
    private static B f3092a = null;

    /* JADX INFO: renamed from: b */
    private static B f3093b = null;

    /* JADX INFO: renamed from: c */
    private static B f3094c = null;

    /* JADX INFO: renamed from: d */
    private static B f3095d = null;

    /* JADX INFO: renamed from: e */
    private static final String[] f3096e;

    /* JADX INFO: renamed from: f */
    private static B f3097f = null;

    /* JADX INFO: renamed from: g */
    private static B f3098g = null;

    /* JADX INFO: renamed from: h */
    private static long f3099h = 0;

    /* JADX INFO: renamed from: i */
    private static char[] f3100i = null;

    /* JADX INFO: renamed from: j */
    private static C2210cx.Z f3101j = null;

    /* JADX INFO: renamed from: l */
    private static int f3102l = 0;

    /* JADX INFO: renamed from: m */
    private static int f3103m = 1;

    /* JADX INFO: renamed from: com.facetec.sdk.cr$V */
    public interface V {
        /* JADX INFO: renamed from: V */
        void mo2042V(int i, int i2);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cr$Z */
    public interface Z {
        /* JADX INFO: renamed from: V */
        void mo2040V(C2214dc c2214dc);
    }

    /* JADX INFO: renamed from: a */
    private static native int m2037a(int i);

    /* JADX INFO: renamed from: b */
    private static native int m2038b(int i);

    /* JADX INFO: renamed from: c */
    private static native int m2039c(int i);

    static /* synthetic */ int Code(int i) {
        int i2 = f3103m + 11;
        f3102l = i2 % 128;
        int i3 = i2 % 2;
        return m2037a(i);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cr$B */
    static class B {

        /* JADX INFO: renamed from: F */
        private static int f3109F = 1;

        /* JADX INFO: renamed from: I */
        private static int f3110I;

        /* JADX INFO: renamed from: B */
        private long[] f3111B;
        private int Code;

        /* JADX INFO: renamed from: V */
        private long f3112V;

        /* JADX INFO: renamed from: Z */
        private int f3113Z;

        B(int i, long[] jArr, int i2, long j) {
            this.f3113Z = i;
            this.f3111B = jArr;
            this.Code = i2;
            this.f3112V = j;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
        /* JADX INFO: renamed from: B */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int m2041B(java.lang.String r14) {
            /*
                Method dump skipped, instruction units count: 214
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2204cr.B.m2041B(java.lang.String):int");
        }
    }

    /* JADX INFO: renamed from: V */
    private static boolean m2032V(String str) {
        try {
            ZipFile zipFile = new ZipFile(str);
            try {
                if (zipFile.size() > 1200) {
                    return false;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(zipFile.getEntry(m2036Z(KeyEvent.getDeadChar(0, 0) + 93, (char) ((-16720154) - Color.rgb(0, 0, 0)), 20 - KeyEvent.getDeadChar(0, 0))))));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            int i = f3103m + 45;
                            f3102l = i % 128;
                            int i2 = i % 2;
                            break;
                        }
                        int iIndexOf = line.indexOf(58);
                        if (iIndexOf > 0) {
                            int i3 = f3102l + 79;
                            f3103m = i3 % 128;
                            int i4 = i3 % 2;
                            long jM2011B = C2202cp.m2011B(line.substring(iIndexOf + 1).trim());
                            if (jM2011B == 2936865290432783596L || jM2011B == 7910848591899845890L) {
                                break;
                            }
                        }
                    } finally {
                        bufferedReader.close();
                    }
                }
                return true;
            } finally {
                zipFile.close();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: renamed from: V */
    private static boolean m2033V(String str, String str2) {
        if (str.startsWith(m2036Z(TextUtils.indexOf("", "", 0, 0) + 113, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 4))) {
            int i = f3102l + 9;
            f3103m = i % 128;
            int i2 = i % 2;
            if (str.length() == 20) {
                int i3 = f3103m + 119;
                f3102l = i3 % 128;
                int i4 = i3 % 2;
                if (!str.contains(m2036Z(ImageFormat.getBitsPerPixel(0) + 118, (char) (Process.myTid() >> 22), (ViewConfiguration.getScrollBarSize() >> 8) + 6)) && !str.contains(m2036Z(124 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 50854), ImageFormat.getBitsPerPixel(0) + 8))) {
                    int i5 = f3103m + 99;
                    f3102l = i5 % 128;
                    if (i5 % 2 == 0 ? str2.startsWith(m2036Z(130 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ExpandableListView.getPackedPositionGroup(0L) + 1520), 9 - TextUtils.indexOf((CharSequence) "", '0', 0))) : str2.startsWith(m2036Z(16373 % View.MeasureSpec.makeMeasureSpec(1, 0), (char) (25466 >>> ExpandableListView.getPackedPositionGroup(1L)), 46 >> TextUtils.indexOf((CharSequence) "", '\\', 0)))) {
                        int i6 = f3102l + 43;
                        f3103m = i6 % 128;
                        int i7 = i6 % 2;
                        return true;
                    }
                }
            }
        }
        int i8 = f3103m + 119;
        f3102l = i8 % 128;
        int i9 = i8 % 2;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x014a  */
    /* JADX INFO: renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized int m2025I(int r16, com.facetec.sdk.C2204cr.B[] r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2204cr.m2025I(int, com.facetec.sdk.cr$B[], boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0256  */
    /* JADX INFO: renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int m2021B(int r18, android.content.Context r19, com.facetec.sdk.C2204cr.B[] r20, boolean r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 843
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2204cr.m2021B(int, android.content.Context, com.facetec.sdk.cr$B[], boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[PHI: r3
      0x0019: PHI (r3v4 com.facetec.sdk.cr$B) = (r3v2 com.facetec.sdk.cr$B), (r3v5 com.facetec.sdk.cr$B) binds: [B:10:0x0017, B:7:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int m2022B(int r5, com.facetec.sdk.C2204cr.B[] r6, java.lang.String r7) {
        /*
            int r0 = r6.length
            r1 = 0
        L2:
            if (r1 >= r0) goto L3f
            int r2 = com.facetec.sdk.C2204cr.f3102l
            int r3 = r2 + 45
            int r4 = r3 % 128
            com.facetec.sdk.C2204cr.f3103m = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L15
            r3 = r6[r1]
            if (r3 == 0) goto L32
            goto L19
        L15:
            r3 = r6[r1]
            if (r3 == 0) goto L32
        L19:
            int r2 = r2 + 81
            int r4 = r2 % 128
            com.facetec.sdk.C2204cr.f3103m = r4
            int r2 = r2 % 2
            if (r2 != 0) goto L2a
            int r2 = r3.m2041B(r7)
            if (r2 == 0) goto L32
            goto L30
        L2a:
            int r2 = r3.m2041B(r7)
            if (r2 == 0) goto L32
        L30:
            r5 = r5 ^ r2
            return r5
        L32:
            int r1 = r1 + 1
            int r2 = com.facetec.sdk.C2204cr.f3102l
            int r2 = r2 + 47
            int r3 = r2 % 128
            com.facetec.sdk.C2204cr.f3103m = r3
            int r2 = r2 % 2
            goto L2
        L3f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2204cr.m2022B(int, com.facetec.sdk.cr$B[], java.lang.String):int");
    }

    /* JADX INFO: renamed from: V */
    private static int m2029V(int i, Context context) throws Throwable {
        m2036Z(465 - TextUtils.getOffsetAfter("", 0), (char) KeyEvent.normalizeMetaState(0), 75 - (ViewConfiguration.getScrollBarFadeDuration() >> 16));
        try {
            try {
                PackageManager packageManager = (PackageManager) Class.forName(m2036Z((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 269, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getTapTimeout() >> 16) + 23)).getMethod(m2036Z(291 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (ViewConfiguration.getFadingEdgeLength() >> 16), 17 - (ViewConfiguration.getTapTimeout() >> 16)), null).invoke(context, null);
                try {
                    List list = (List) Class.forName(m2036Z(View.MeasureSpec.getMode(0) + 309, (char) (TextUtils.indexOf((CharSequence) "", '0') + 47457), 33 - TextUtils.getOffsetBefore("", 0))).getMethod(m2036Z(ImageFormat.getBitsPerPixel(0) + 343, (char) TextUtils.indexOf("", "", 0), 24 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), Integer.TYPE).invoke(packageManager, 0);
                    if (list.size() > 0) {
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            String str = (String) Class.forName(m2036Z((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 365, (char) (ImageFormat.getBitsPerPixel(0) + 23997), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 34)).getField(m2036Z((ViewConfiguration.getLongPressTimeout() >> 16) + 400, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 23968), Color.green(0) + 9)).get(it2.next());
                            if (str != null) {
                                int i2 = f3102l + 91;
                                f3103m = i2 % 128;
                                if (i2 % 2 == 0) {
                                    if (C2202cp.m2011B(str) == -7031551473171390769L) {
                                        m2036Z(409 - TextUtils.indexOf("", "", 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), 30 - (ViewConfiguration.getEdgeSlop() >> 16));
                                        int i3 = i ^ 230;
                                        int i4 = f3103m + 73;
                                        f3102l = i4 % 128;
                                        int i5 = i4 % 2;
                                        return i3;
                                    }
                                } else if (C2202cp.m2011B(str) == -7031551473171390769L) {
                                    m2036Z(409 - TextUtils.indexOf("", "", 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), 30 - (ViewConfiguration.getEdgeSlop() >> 16));
                                    int i32 = i ^ 230;
                                    int i42 = f3103m + 73;
                                    f3102l = i42 % 128;
                                    int i52 = i42 % 2;
                                    return i32;
                                }
                            }
                        }
                    } else {
                        Iterator<ResolveInfo> it3 = packageManager.queryIntentActivities(new Intent(m2036Z((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 438, (char) TextUtils.indexOf("", "", 0), View.combineMeasuredStates(0, 0) + 26)), 0).iterator();
                        int i6 = f3103m + 17;
                        f3102l = i6 % 128;
                        int i7 = i6 % 2;
                        while (it3.hasNext()) {
                            String str2 = (String) Class.forName(m2036Z(365 - TextUtils.lastIndexOf("", '0'), (char) (23996 - (ViewConfiguration.getTouchSlop() >> 8)), (Process.myPid() >> 22) + 34)).getField(m2036Z((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 400, (char) (23968 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 8)).get(((ComponentInfo) it3.next().activityInfo).applicationInfo);
                            if (str2 != null && C2202cp.m2011B(str2) == -7031551473171390769L) {
                                m2036Z(408 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getTapTimeout() >> 16), View.resolveSize(0, 0) + 30);
                                return i ^ 230;
                            }
                        }
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } catch (RuntimeException unused) {
        }
        return i;
    }

    /* JADX INFO: renamed from: B */
    private static int m2020B(int i) {
        int i2 = f3103m + 101;
        f3102l = i2 % 128;
        int i3 = i2 % 2;
        m2036Z((ViewConfiguration.getDoubleTapTimeout() >> 16) + 540, (char) (23458 - TextUtils.indexOf("", "", 0, 0)), 23 - Color.argb(0, 0, 0, 0));
        try {
            if (!C2210cx.m2051B(m2036Z((ViewConfiguration.getScrollDefaultDelay() >> 16) + 563, (char) (ViewConfiguration.getTapTimeout() >> 16), '8' - AndroidCharacter.getMirror('0')), true, -1L, f3101j).contains(m2036Z((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 570, (char) View.getDefaultSize(0, 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 3))) {
                int i4 = f3102l + 27;
                f3103m = i4 % 128;
                int i5 = i4 % 2;
                return i;
            }
            int i6 = f3103m + 97;
            f3102l = i6 % 128;
            if (i6 % 2 != 0) {
                m2036Z(19659 << View.MeasureSpec.makeMeasureSpec(1, 0), (char) (Color.alpha(1) + 34901), ExpandableListView.getPackedPositionGroup(0L) * 14);
                return i | 6;
            }
            m2036Z(575 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (34901 - Color.alpha(0)), 21 - ExpandableListView.getPackedPositionGroup(0L));
            return i ^ 80;
        } catch (IOException unused) {
            return i;
        }
    }

    /* JADX INFO: renamed from: V */
    private static int m2030V(int i, String str) {
        String line;
        int i2;
        m2036Z(667 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (Color.red(0) + 2571), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 37);
        try {
            m2036Z((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 703, (char) (16938 - (ViewConfiguration.getTouchSlop() >> 8)), Drawable.resolveOpacity(0, 0) + 15);
            if (str.contains(m2036Z((Process.myTid() >> 22) + TypedValues.TransitionType.TYPE_AUTO_TRANSITION, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 16938), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15))) {
                int i3 = f3102l + 71;
                f3103m = i3 % 128;
                int i4 = i3 % 2;
                m2036Z(719 - View.resolveSize(0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 636), Color.red(0) + 39);
                int i5 = i ^ OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_NEW_GROUP_ADDED;
                int i6 = f3102l + 5;
                f3103m = i6 % 128;
                int i7 = i6 % 2;
                return i5;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(m2036Z(758 - (Process.myTid() >> 22), (char) ((ViewConfiguration.getTouchSlop() >> 8) + 62772), 11 - TextUtils.lastIndexOf("", '0', 0))));
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                    }
                } finally {
                    bufferedReader.close();
                }
            } while (!line.contains(m2036Z((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 703, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 16938), 15 - (ViewConfiguration.getMinimumFlingVelocity() >> 16))));
            int i8 = f3103m + 85;
            f3102l = i8 % 128;
            if (i8 % 2 != 0) {
                m2036Z(14754 >> (ViewConfiguration.getScrollBarSize() << 97), (char) (6775 / KeyEvent.normalizeMetaState(1)), ViewConfiguration.getTapTimeout() + 45);
                i2 = i & 5167;
            } else {
                m2036Z(770 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (29314 - KeyEvent.normalizeMetaState(0)), (ViewConfiguration.getTapTimeout() >> 16) + 30);
                i2 = i ^ 212;
            }
            int i9 = f3102l + 19;
            f3103m = i9 % 128;
            if (i9 % 2 != 0) {
                return i2;
            }
            Object obj = null;
            super.hashCode();
            throw null;
        } catch (IOException unused) {
        }
        return i;
    }

    /* JADX INFO: renamed from: V */
    private static int m2028V(int i) {
        m2036Z(800 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (Color.rgb(0, 0, 0) + 16777216), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 24);
        try {
            String string = new StringBuilder().append(C2213da.Code(f3101j)).append(C2213da.m2069I(f3101j)).toString();
            B[] bArr = {f3097f, f3094c, f3098g};
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = f3103m + 107;
                f3102l = i3 % 128;
                int i4 = i3 % 2;
                int iM2041B = bArr[i2].m2041B(string);
                if (iM2041B != 0) {
                    int i5 = f3103m + 17;
                    f3102l = i5 % 128;
                    int i6 = i5 % 2;
                    return i ^ iM2041B;
                }
            }
            int i7 = f3102l + 95;
            f3103m = i7 % 128;
            int i8 = i7 % 2;
        } catch (Exception unused) {
        }
        return i;
    }

    /* JADX INFO: renamed from: Z */
    private static int m2035Z(int i, String str) {
        m2036Z((KeyEvent.getMaxKeyCode() >> 16) + 825, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 24978), (-16777189) - Color.rgb(0, 0, 0));
        int i2 = 0;
        while (true) {
            try {
                String[] strArr = f3086F;
                if (i2 >= strArr.length) {
                    break;
                }
                if (C2210cx.m2056I(new StringBuilder().append(strArr[i2]).append(str).toString(), f3101j)) {
                    m2036Z((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 851, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 1);
                    m2036Z(853 - TextUtils.indexOf("", "", 0, 0), (char) (10811 - View.MeasureSpec.getMode(0)), 7 - View.combineMeasuredStates(0, 0));
                    return i ^ (i2 + OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED);
                }
                i2++;
                int i3 = f3102l + 7;
                f3103m = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception unused) {
            }
        }
        int i5 = f3103m + 51;
        f3102l = i5 % 128;
        int i6 = i5 % 2;
        return i;
    }

    /* JADX INFO: renamed from: Z */
    private static int m2034Z(int i) {
        int i2 = f3103m + 7;
        f3102l = i2 % 128;
        int i3 = i2 % 2;
        m2036Z(TextUtils.indexOf("", "", 0) + 860, (char) ExpandableListView.getPackedPositionGroup(0L), ((Process.getThreadPriority(0) + 20) >> 6) + 28);
        try {
            Class<?> cls = Class.forName(m2036Z(888 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (7576 - KeyEvent.normalizeMetaState(0)), 27 - (KeyEvent.getMaxKeyCode() >> 16)));
            int iIntValue = ((Integer) cls.getMethod(m2036Z(915 - TextUtils.getCapsMode("", 0, 0), (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 60827), 6 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), String.class, Integer.TYPE).invoke(null, m2036Z(921 - ExpandableListView.getPackedPositionType(0L), (char) View.resolveSizeAndState(0, 0, 0), Color.blue(0) + 23), 0)).intValue();
            if (((String) cls.getMethod(m2036Z((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 944, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 35047), 4 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), String.class, String.class).invoke(null, m2036Z((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 947, (char) (ViewConfiguration.getPressedStateDuration() >> 16), 18 - ((Process.getThreadPriority(0) + 20) >> 6)), m2036Z(964 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 29312), 6 - View.MeasureSpec.getMode(0)))).equals(m2036Z(970 - TextUtils.indexOf((CharSequence) "", '0'), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 62401), 7 - (ViewConfiguration.getWindowTouchSlop() >> 8)))) {
                if (iIntValue != 1 && iIntValue != 2) {
                    int i4 = f3102l + 59;
                    f3103m = i4 % 128;
                    if (i4 % 2 != 0) {
                    }
                }
                return i ^ (iIntValue + 170);
            }
        } catch (Exception unused) {
        }
        int i5 = f3102l + 55;
        f3103m = i5 % 128;
        int i6 = i5 % 2;
        return i;
    }

    /* JADX INFO: renamed from: I */
    private static int m2024I(int i) {
        int i2 = f3103m + 91;
        f3102l = i2 % 128;
        int i3 = i2 % 2;
        m2036Z(Color.rgb(0, 0, 0) + 16778194, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 59485), KeyEvent.normalizeMetaState(0) + 57);
        try {
            if (C2210cx.m2051B(m2036Z(KeyEvent.getDeadChar(0, 0) + 1035, (char) (ViewConfiguration.getTapTimeout() >> 16), 20 - ExpandableListView.getPackedPositionChild(0L)), false, -1L, f3101j).trim().equals(m2036Z(TextUtils.lastIndexOf("", '0', 0) + 1057, (char) (ViewConfiguration.getEdgeSlop() >> 16), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))) {
                int i4 = f3102l + OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_NEW_GROUP_ADDED;
                f3103m = i4 % 128;
                if (i4 % 2 == 0) {
                    m2036Z(628 << (ViewConfiguration.getDoubleTapTimeout() >> 45), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 103 - (ViewConfiguration.getJumpTapTimeout() << 51));
                    i &= 18017;
                } else {
                    m2036Z(1057 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 24);
                    i ^= 260;
                }
                int i5 = f3102l + 35;
                f3103m = i5 % 128;
                int i6 = i5 % 2;
            }
        } catch (Exception unused) {
        }
        return i;
    }

    /* JADX INFO: renamed from: L */
    private static int m2027L(int i) {
        int i2;
        m2036Z(1081 - KeyEvent.normalizeMetaState(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.resolveSize(0, 0) + 68);
        try {
            int i3 = 0;
            for (String str : f3096e) {
                if (C2210cx.m2056I(new StringBuilder().append(m2036Z(1149 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (34826 - Process.getGidForName("")), 12 - TextUtils.indexOf("", "", 0, 0))).append(str).toString(), f3101j)) {
                    int i4 = f3103m;
                    int i5 = i4 + 103;
                    f3102l = i5 % 128;
                    int i6 = i5 % 2;
                    int i7 = i4 + 41;
                    f3102l = i7 % 128;
                    int i8 = i7 % 2;
                    i2 = 1;
                } else {
                    int i9 = f3103m + 105;
                    f3102l = i9 % 128;
                    int i10 = i9 % 2;
                    i2 = 0;
                }
                i3 += i2;
            }
            if (i3 < ((double) f3096e.length) * 0.9d) {
                return i;
            }
            m2036Z((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1160, (char) (Color.rgb(0, 0, 0) + 16811862), (ViewConfiguration.getLongPressTimeout() >> 16) + 48);
            return i ^ 261;
        } catch (Exception unused) {
            return i;
        }
    }

    public static void Code(Context context, int i, V v) throws Throwable {
        int i2 = f3103m + 117;
        f3102l = i2 % 128;
        m2031V(context, i, i2 % 2 != 0 ? 1 : 0, v);
        int i3 = f3103m + 31;
        f3102l = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX INFO: renamed from: V */
    private static void m2031V(Context context, int i, int i2, final V v) throws Throwable {
        m2026I(context, i, i2, new Z() { // from class: com.facetec.sdk.cr.5
            private static int Code = 1;

            /* JADX INFO: renamed from: V */
            private static int f3107V;

            @Override // com.facetec.sdk.C2204cr.Z
            /* JADX INFO: renamed from: V */
            public final void mo2040V(C2214dc c2214dc) {
                int i3 = f3107V + 121;
                int i4 = i3 % 128;
                Code = i4;
                int i5 = i3 % 2;
                V v2 = v;
                if (v2 != null) {
                    int i6 = ((i4 | 89) << 1) - (i4 ^ 89);
                    f3107V = i6 % 128;
                    int i7 = i6 % 2;
                    v2.mo2042V(c2214dc.m2073B(), c2214dc.m2074I());
                    int i8 = Code;
                    int i9 = (i8 ^ 105) + ((i8 & 105) << 1);
                    f3107V = i9 % 128;
                    int i10 = i9 % 2;
                }
                int i11 = Code;
                int i12 = (i11 ^ 107) + ((i11 & 107) << 1);
                f3107V = i12 % 128;
                int i13 = i12 % 2;
            }
        });
        int i3 = f3102l + 65;
        f3103m = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:0|2|(3:211|3|(2:7|(3:9|10|(4:12|(4:14|15|(1:17)(1:18)|(2:20|21))|22|(4:24|25|(1:27)(1:28)|(2:30|31))))(0)))|32|(3:34|(1:37)|(2:39|40))|41|(2:43|(3:45|(1:51)|(2:53|54))(3:48|(0)|(0)))|55|(34:61|(1:63)(1:64)|65|(1:67)(1:68)|69|(1:71)(1:72)|73|(1:75)(1:76)|77|(1:79)(1:80)|81|(1:83)(1:84)|85|(2:87|(2:96|(1:98)(1:(0)(1:101)))(2:90|(1:(1:93)(0))(2:94|95)))(0)|(3:104|(1:106)(1:107)|(2:109|110))|209|111|114|(2:(2:116|(2:117|(3:119|(2:213|123)|125)))(2:212|127)|126)|(4:129|(1:132)|133|(2:135|136))|137|(4:139|(1:142)|143|(2:145|146))|147|(4:151|(1:154)|155|(2:157|158))|159|(4:166|(1:169)|170|(2:172|173))|174|(4:176|(1:179)|180|(2:182|183))|184|(4:189|(1:192)|193|(2:195|196))|197|(4:199|(1:202)|201|(2:204|205))|206|207)(1:60)|102|(0)|209|111|114|(2:(0)(0)|126)|(0)|137|(0)|147|(5:149|151|(0)|155|(0))|159|(6:161|164|166|(0)|170|(0))|174|(0)|184|(5:187|189|(0)|193|(0))|197|(0)|206|207) */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0255, code lost:
    
        r0 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0099 A[Catch: IOException -> 0x00e3, TRY_LEAVE, TryCatch #1 {IOException -> 0x00e3, blocks: (B:3:0x0015, B:5:0x005b, B:7:0x0080, B:10:0x0091, B:12:0x0099, B:15:0x00a8, B:20:0x00b5, B:18:0x00af, B:22:0x00be, B:24:0x00c4, B:30:0x00da, B:28:0x00d4), top: B:211:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x032c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011e A[PHI: r13
      0x011e: PHI (r13v18 com.facetec.sdk.cx$Z) = (r13v17 com.facetec.sdk.cx$Z), (r13v19 com.facetec.sdk.cx$Z) binds: [B:49:0x011b, B:46:0x0114] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fd  */
    /* JADX INFO: renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.facetec.sdk.C2214dc m2026I(android.content.Context r23, int r24, int r25, final com.facetec.sdk.C2204cr.Z r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2204cr.m2026I(android.content.Context, int, int, com.facetec.sdk.cr$Z):com.facetec.sdk.dc");
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cr$Code */
    static class Code extends Thread {

        /* JADX INFO: renamed from: Z */
        private static int f3114Z = 1;

        /* JADX INFO: renamed from: B */
        private final Z f3115B;

        /* JADX INFO: renamed from: V */
        private final int f3116V;

        Code(Z z, int i) {
            this.f3115B = z;
            this.f3116V = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int i = f3114Z;
            int i2 = ((i ^ 85) + ((i & 85) << 1)) % 2;
            int i3 = this.f3116V;
            C2204cr.m2023B(i3, C2204cr.Code(i3), this.f3115B);
            int i4 = f3114Z;
            int i5 = ((i4 & 99) + (i4 | 99)) % 2;
        }
    }

    /* JADX INFO: renamed from: B */
    static C2214dc m2023B(int i, int i2, Z z) {
        C2214dc c2214dc = new C2214dc(i, i2);
        if (z != null) {
            z.mo2040V(c2214dc);
            int i3 = f3103m + 3;
            f3102l = i3 % 128;
            int i4 = i3 % 2;
        }
        int i5 = f3103m + 107;
        f3102l = i5 % 128;
        int i6 = i5 % 2;
        return c2214dc;
    }

    /* JADX INFO: renamed from: Z */
    private static String m2036Z(int i, char c, int i2) {
        String str;
        synchronized (C2216de.f3214Z) {
            char[] cArr = new char[i2];
            C2216de.f3213B = 0;
            while (C2216de.f3213B < i2) {
                cArr[C2216de.f3213B] = (char) ((((long) f3100i[C2216de.f3213B + i]) ^ (((long) C2216de.f3213B) * f3099h)) ^ ((long) c));
                C2216de.f3213B++;
            }
            str = new String(cArr);
        }
        return str;
    }

    static {
        char[] cArr = new char[1711];
        ByteBuffer.wrap("\u0000R½²{Õ9ã÷Tµ%sK1xî\u009c¬åj\u008f(_æ/¤Zbw\u001f\u009dÝð\u009bÝYë\u0017\u0004Õ/\u0093@P\u0099\u000e¾ÌË\u0000a½³{Þ9å÷\u001bµ8sJ1%î\u0098¬ jÐ(\u0012æ5¤Jbe\u001f\u009aÝ¿\u009bÃY¤\u00176Õ\u0011\u0093dP¬\u000e\u0082Ìç\u008aÔH>\u0006\u0003Äs\u0082Y?§ý\u0080»ëy<7\u001dõr³G|<ÁÜ\u0007»E\u008d\u008b:ÉK\u000f%M\u0016\u0092òÐ\u008b\u0016áT1\u009a_Ø>\u001e\u000bcî¡×ç\u00ad%\u0083k)©Zï*,ârØ°¿ö\u00884ozH¸-þ\tCûÞ«c~¥\bç0)¿kþ\u00ad\u0086ï«0!rn´\u0005ö×8óz\u0099¼µÁF\u0003bEe\u0087!ÉÇ\u0000c½²{×9¹\u0000g½²{Õ9ð÷\u0018µ4ÆÇ{\u0015½xÿC1½s\u009eµì\u0005ß¸I~+<\u0013òå°\u008ev¿4\u008bëh©\u001aE²øR>5|\u0003²´ðÅ6«t\u0098«|é\u0005/om¿£Ïáº'\u0097Z}\u0098\u0010Þ=\u001c\u000bRä\u0090ÏÖ \u0015yK^\u0089+ÏU\r¿C\u008f\u0081¿Ç\u0085zi¸T\u0094,)ìïÆ\u00ad§cA!~ç\u0006¥wzÄ8øþ\u009d¼Hra0\u0002ö/\u008bÜI¬\u000fÜÍ°\u0000\n:<\u0087ðA\u0095\u0003°ÍY\u008fzI\u0007\u000b}0`\u008d±KÔ\tºÇ\u0010\u0085=CB\u0001oÞ\u0087\u009c£Z\u008f\u0000c½²{×9¹÷\u0015µ?sJ1yî\u0087¬¬jÆ(QSdî\u0095(ôj\u009e¤\u001cæ( Lb\u0002½§ÿ\u00839þ{8µ\u0011÷1?ï\u0082\u000fDh\u0006^Èé\u008a\u0098Lö\u000eÅÑ!\u0093XU2\u0017âÙ\u0092\u009bç]Ê  âM¤`fV(¹ê\u0092¬ýo$1\u0003óvµ\bwâ9Òû÷½Õ\u0000(Â\n\u0000a½³{Þ9å÷\u001bµ8sJ1%î\u008b¬ªjÌ(\u000bæ9¤Wbb\u001fÝÝ\u0093\u009bÂYä\u0017\u0013Õ!\u0093YP\u008a\u0000g½¸{Î9Ç÷\u0015µ2sE1jî\u008f¬ jï(\u001eæ2¤Xbq\u001f\u0096Ý¢¹\u0001\u0004ÓÂ¾\u0080\u0085N{\fXÊ*\u0088EWë\u0015ÊÓ¬\u0091k_Y\u001d7Û\u0002¦½dÀ\" àÄ®WlE*\"éõ·Úu¿3\u0090ñ_¿N}\";\b\u0086áDÆ\u0002²\u0000g½¸{Î9Þ÷\u001aµ\"sZ1jî\u0084¬©jÇ(\u001bæ\u001d¤Ibf\u001f\u009fÝ¹\u009bÎYë\u0017\u0013Õ-\u0093NP\u0090\u000e¨]Ýà\u000f&bdYª§è\u0084.öl\u0099³7ñ\u00167pu·»\u0085ùë?ÞBa\u0080\u001cÆ|\u0004\u0018J\u009a\u0088\u0088Îí\r.S\u000e\u0091g×H\u0015º[\u009a\u0099ÿßÛb\u0013 \u0011æz$®]Ãà\u0011&{dDª§è¿.ïlÆ³-\u0000\t½\u009b{Õ9â÷\u001aµ5s\u000e1Fî\u0089¬¢jË(\fæ7¤tbw\u001f\u009dÝ±\u009bÊYï\u0017\u0015Õd\u0093BP\u0092\u000eºÌË\u008aæH<\u0006.ÄA\u0082l\u0000a½³{Þ9å÷\u001bµ8sJ1%î\u0081¬«jÖ(\u001aæ2¤Mb8\u001f\u0092Ý³\u009bÙYã\u0017\bÕ*\u0093\u000fP³\u000e\u009aÌñ\u008aÛ\u0000R½²{Õ9ã÷Tµ%sK1xî\u009c¬åj\u008f(_æ?¤Qbs\u001f\u0090Ý»\u009b\u008dYã\u0017\tÕ7\u0093UP\u009f\u000e·ÌÔ\u008aðH\u0016\u0006oÄM\u0082y?\u0096ý¯»Éy\u001e7;õC³}p\u009e. ìØª¨h\u0011&-ä?¡\u008f_¼\u001dÓÛ³\u0099\u0019W+\u0015\nÓJ\u0090\u0085N¦\f¾Ê6\u00889F[\u0004sÁ\u0088\u007f©=Ûû¦¹\nw35=ò\u0093°¹nÇ,åê\u000f¨'fD$`á\u0086[ðæ\u0010 wbA¬öî\u0087(éjÚµ>÷G1-sý½\u009bÿã9ÑD2\u0086\u0007À{\u0002MLå\u008e\u0095Èö\u000br\u0000s½¨{\u009a9º÷\u0017µqsG1o\u0000r½²{Õ9ã\u0088\\5Åó\u008e±¬\u007f@=cû\u001e¹:f\u009d$äâ\u0098 \nnl,\u0014ê&\u0097ÅU¥\u0013ßÑ¬\u009fG]6\u001f\u0084¢dd\u0003&5è\u0082ªól\u009d.®ñJ³3uY7\u0089ùé»\u0087}¥\u0000FÂm\u0084[F:\bÞÊà\u008c×O_\u0011\u007fÓ\u0007\u00957WÁ\u0019øÛ\u0098\u009d³ Uâ5¤\u001bfÄ(ùê\u008f¬¶oT16Þ]eüØs\u001e\u0011\u0000\t½\u009b{Õ9â÷\u001aµ5s\u000e1|î\u009a¬¬jÖ(\u001eæ>¤Ubs\u001fÓÝ¼\u009bÂYé\u0017\u0006Õ0\u0093HP\u0091\u000eµÌ\u0098\u008aÎ\u0000]\nY·¹qÞ3èý_¿.y@;sä\u0097¦î`\u0084\"Tì4®Zhx\u0015\u009b×°\u0091\u0086Sç\u001d\u0003ß=\u0099\nZ\u0086\u0004¥Æ\u009d\u0080úB\u001b\fdÎN\u0088l5Í÷¥±Äs\u0003=?ÿH¹lzÔBNÿ\u00969ä{Üµ<÷\u001a1wsD¬±îÀ(ûj ¤Xæw ^\u0002r¿ày®;\u0099õa·Nqu3Wìà®Ëh÷*`äE¦e`M\u001dáßÅ\u0099ö[\u009c\u0015s×J\u00914Rñ\f\u0080Î \u0088\u0081Jd\u0004YÆ6\u0080\u001c=ùÿ\u0098¹´{s5U÷<±\u001arþ,Æõ\u001bH\u0099\u008eüÌÌ\u0002#@J\u0086wÄP\u001b©Y\u009f\u009fâÝ8r\u008bÏ\u0019\tWK`\u0085\u0098Ç·\u0001\u008cC®\u009c\u0019Þ2\u0018\u000eZ\u0099\u0094¼Ö\u009c\u0010´m\u0018¯<é\u000f+'e\u0095§´áÌ\"\u001f|v¾Wøx:\u0085t£¶Úðø\u0000R½²{Õ9ã÷Tµ%sK1xî\u009c¬åj\u008f(_æ,¤Kby\u001f\u0090Ýµ\u009bÞYù\u0017GÕ7\u0093BP\u009f\u000eµÌ\u0096aÀÜ \u001aGXq\u0096ÆÔ·\u0012ÙPê\u008f\u000eÍw\u000b\u001dIÍ\u0087½ÅÎ\u0003å~\u0013¼!úW88v\u0097´¿òÝ1\ro;\u00adSë<)À\u0000\t*\u001b\u0097\u0080Qî\u0013ÙÝ!\u009f\u000eY;\u0000R½²{Õ9ã÷Tµ%sK1xî\u009c¬åj\u008f(_æ\u001f¤tb6\u001f¡Ý¿\u009bÂYþ\u0017GÕ\u0017\u0093DP\u008a\u000e¯ÌÑ\u008aûH\u0015\u0006<\u001dù +fF$}ê\u0083¨ nÒ,½ó\u001f±.w\u00145´û½¹Ò\u007fú\u0002\u000eÀ%\u0086eD`\n\u0090È¬\u008eÜM\u0014\u00137ÑI\u0097hU\u0099íüP#\u0096UÔE\u001a\u0081X¾\u0000p½¸{È9ä÷\u001dµ\"sZ1%î\u009b¬¼jÑ(Qæ.¤Vby\u001f\u0087Ý\u008f\u009bÌYé\u0017\u0004Õ!\u0093RP\u008d\u0088\u00805_ó)\u0000i½³{Ó9ã÷Zµ\"sX1hîÆ¬¶j×( æ8¤Xbs\u001f\u009eÝ¿\u009bÃráÏ?\tIKr\u0085\u009aÇ¥ó²Nh\u0088\u0014Ê9\u0004ÝFÿ\u0080\u0089è\u000fUï\u0093\u0088Ñ¾\u001f\t]x\u009b\u0016Ù%\u0006ÁD¸\u0082×Àc\u000eoL\u0000\u008a9÷Á5äs\u0094±÷ÿi=m{\t¸Çæï$\u008abè Jî\u007f,\u0004j8×Ú\u0015êS\u0092\u0091Rß.\u001dJ[d\u0098\u008cÆð\u0004\u009eB°\u0080[Ît\fbIÓ·ëõÅ3ªqH¿rý\u0002;=xÞ¦ýä¡\"J``\u0000g½¸{Î9ç÷\u0006µ>s^1+î\u009a¬ªj\u008c(\u001bæ9¤[bc\u001f\u0094Ý·\u009bÌYè\u0017\u000bÕ!\u00001\u0000\t½¯{Õ9¹÷\u0010µ4sL1~î\u008f¬¢jÃ(\u001dæ0¤\\b6\u001f\u0080Ýµ\u009bÙYª\u0017\u0013Õ+\u0093\u0001PÏ\u000eõ\u0000R½²{Õ9ã÷Tµ%sK1xî\u009c¬åj\u008a(>æ2¤]bd\u001f\u009cÝ¹\u009bÉYª\u00174Õ0\u0093TP\u009a\u000e²Ì×\u008aµH\u0017\u0006\"ÄY\u0082e?\u0087ý·»Ïy\u000f7sõ\u0017³9pÑ.\u00adìÄªýh\u000b&6ä?¡\u0091_¸\u001dÄÛø\u0099\u0015W)\u0015\nÓ(\u0090\u0097N¸\fíÊ\u000f\u0088=FX\u0004=Á\u008d\u007f¥=Çû¦¹\u0005w)5qò\u009f°¤\u0088$5¥óÈ±ï\u007f\u000b=?ûH¹/f\u0081$§âÇ [\u0087_:êü\u0098¾ápN2bô\u0019¶.iÊ+³íÍ¯\u0019a/#Oå/\u0098ÃZ¦\u001c\u0096Þ½\u0090CRy\u0014\u0012×Ì\u0089\u00adKÁ\r°Ï]\u0081jC\u000e\u0005:¸Ýzº<\u0094þB°brA4$÷Î©ôk\u0098-\u00adï\u0013¡rc&&ßØá\u009a\u0084\\ëÞ[c\u0084¥òçÛ):k\u0002\u00adbï\u00170¦r\u0096´°ö+8\u0001zw¼NÁ¸\u0003\u008dEã\u0087ÓH#õí3\u0085q¥¿Mýuº\u009f\u0007JÁ.\u0083\u000bMê\u000fÀÉ¥\u008b\u009b\u0000m½²{Ï9ù÷\u0000QÁì\u001aÆõ{c½\u0001ÿ91Ïs¤µ\u0098÷¾(Qj~¬\u0014î\u008aA\u0018ü\u008e:ìxÔ¶\"ôI2upS¯¼í\u0093+ùig§\tåg#O^ë\u0000/½¹{Û9ã÷\u0015µ~sB1dî\u008b¬¤jÎ(Pæ$¤[b\u007f\u001f\u009dÝÿ£ï\u001enØ\u0018\u009a>TÚ\u0016¾2¥\u008f$II\u000bnÅ\u008a\u0087¾AÉ\u0003®Ü\u0000\u009e&XF\u001aÚÔø\u0096ÖPä-\rïu%ð\u0098q^\u001c\u001c;Òß\u0090ëV\u009c\u0014ûËU\u0089sO\u0013\r\u008fÃå\u0081\u0087G :@ø|¾\u0013|32Ýð´\u0000/½®{Ã9ä÷\u0000µ4sC1$î\u009b¬¡j\u008d(\u0007æ>¤Pbx\u001fÜ}\nÀ\u008b\u0006æDÁ\u008a%È\u0011\u000efL\u0001\u0093¸Ñ\u0093\u0017õUu\u009b\u000eÙy\u001f\u001eb¸ \u0090æí$Ëjo¨\u0013îk-´s\u008a±²\u0000/½®{Ã9ä÷\u0000µ4sC1$î\u0090¬§jË(\u0011æs\u0013º®;hV*qä\u0095¦¡`Ö\u0000/½®{Ã9ä÷\u0000µ4sC1$î\u008a¬¬jÌ\u0000/½®{Ã9ä÷\u0000µ4sC1$î\u009b¬§jË(\u0011\u0000/½®{Ã9ä÷\u0000µ4sC1$î\u0090¬§jË(\u0011\u0000/½«{ß9ù÷\u0010µ>s\\1$î\u008a¬¬jÌ\u000bä¶ep\u001325üÑ\u0000/½¸{Î9ô\u0000a½¹{Ø9È÷\u001fµ4sW1x\u0000a½¯{Ê9þ÷\u001aµ6é(Tü\u0092\u0083Ð¨\u001e]\\o\u009a\u0006\u0000g½¹{Ø9ä÷\u0011µ#sX1nî\u009a\u0000i½¹{Ö9ô÷\u0018µ8Öýk'\u00adGïw!Íc¡¥ßçý8\tz6¼\u0018þ\u00990«\t¶´mr\u00110'þÛ¸\u0099\u0005]Ã/\u0081\u0015Oâ\r\u0092\u0000i½ª\u0000l½²{Ý9ç÷\u0011µ#s]1bî\u009b¬±j\u008c(\fæ(¤Xbd\u001f\u00877Þ\u008a\u0000Lo\u000eQÀ§\u0082\u0084Dø\u0006\u0097Ù(\u009b\u0014ø\fEÓ\u0083©Á\u0088\u000fzML\u008b<É\u001c\u0000p½¯{Õ9ñ÷\u0017µ>sB1gî\u008d¬¦jÖ(\u001b\u0000p½¯{Õ9ñ÷\u0017µ>sB1gî\u008d¬¦jÖ(\u001cæ(¤U5ö\u0088<NS\f|Â\u0085\u0080»FÞ\u0000s½µ{Õ9à÷\u0019µ0s^T×é\b/rmZ£¤á\u0090'¹\u0012¬¯q,F\u0091\u009cWî\u0015ÐÛ5\u0099;_l\u001dWÂ©\u0080\u0098FÈ\u0004&Ê\u0006\u0088oNH3§ñ\u0082·ýuÑ;&\u0000s½©{È9ö÷\u0017µ4\u0000s½¼{Ô9þ÷\u0000µ8sT1nî\u009a¬èjÑ(\u000bæ=¤Mbc\u001f\u0080\u0000t½¯{Û9ô÷\u0011µ!sO1\u007fî\u0080\u0000t½¯{Û9ô÷\u0011µ!sO1\u007fî\u0080¬óìvQ\u00ad\u0097ÙÕö\u001b\u0013Y!\u009fCÝ|\u0002\u009e@¢\u0086\u0096\u0085b8¤þÚ¼ér\r0\"öf´uk\u0091)´ïÚ\u0000x½¾{À9ó÷\u0017µ8s|1tî\u0080¬¯jð(\u001bæ?¤Rbt\u0000u½³{Í9þ÷\u001aµ5sq1xî\u0091¬¨jÀ(\u0010æ0¤J".getBytes(InternalZipConstants.AES_HASH_CHARSET)).asCharBuffer().get(cArr, 0, 1711);
        f3100i = cArr;
        f3099h = 2849698249498017245L;
        long[] jArr = {5346983579176056341L, 2009081199365669074L, 5956613504184305173L, 8899588629242527954L, 375079373922271629L, 1599531319238017234L, 5109561905117738517L, 2755552837602328786L};
        f3091Z = jArr;
        long[] jArr2 = {-8080523676569222304L, 6247535792709053186L, -7821137391702040246L, -3922916112654851522L, 8839175558035598718L, -2890535829032981914L, 4113801434712603158L, 5835755100867204884L};
        f3090V = jArr2;
        long[] jArr3 = {4085212954298587426L, 3012439845812021669L, 5769587637170450507L, 2969396325011468692L, 7867099544161923476L, 1598132056504805899L};
        Code = jArr3;
        long[] jArr4 = {2018191094461008829L, -3135287916255501627L, -6543530224906774004L, 6873030840008565331L, 3232606552312898193L, 6330987359265341719L};
        f3087I = jArr4;
        long[] jArr5 = {1312179212427599182L, 8085699055651459282L, 6329818986207784146L, 7581214046858337288L, 222271138232253650L, 1524944220437646053L};
        f3084C = jArr5;
        long[] jArr6 = {2414330307756640011L, -3593916909785094185L, 7092956718875610598L, -5964681408332242700L, 8518732971232906945L, -3109682652025013662L};
        f3089S = jArr6;
        f3086F = new String[]{m2036Z(1249 - TextUtils.getOffsetBefore("", 0), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 50906), 12 - KeyEvent.getDeadChar(0, 0)), m2036Z(1261 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (16696 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 17 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), m2036Z(KeyEvent.normalizeMetaState(0) + 1277, (char) (ViewConfiguration.getLongPressTimeout() >> 16), 18 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), m2036Z(1294 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (41920 - KeyEvent.normalizeMetaState(0)), 6 - Color.red(0)), m2036Z(1149 - View.getDefaultSize(0, 0), (char) (34826 - TextUtils.indexOf((CharSequence) "", '0')), 12 - (ViewConfiguration.getJumpTapTimeout() >> 16)), m2036Z(TextUtils.getCapsMode("", 0, 0) + 1300, (char) (Drawable.resolveOpacity(0, 0) + 12938), 16 - TextUtils.lastIndexOf("", '0')), m2036Z(1317 - View.MeasureSpec.getSize(0), (char) ((KeyEvent.getMaxKeyCode() >> 16) + 9695), 21 - Color.alpha(0)), m2036Z(ExpandableListView.getPackedPositionGroup(0L) + 1338, (char) Color.argb(0, 0, 0, 0), TextUtils.indexOf((CharSequence) "", '0') + 17), m2036Z(1354 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (32037 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 24), m2036Z(1379 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 13)};
        f3088L = new String[]{m2036Z((Process.myTid() >> 22) + 1392, (char) (5013 - Color.alpha(0)), TextUtils.lastIndexOf("", '0', 0, 0) + 8), m2036Z(ImageFormat.getBitsPerPixel(0) + 1400, (char) ExpandableListView.getPackedPositionType(0L), 11 - View.MeasureSpec.makeMeasureSpec(0, 0)), m2036Z(1410 - View.MeasureSpec.getSize(0), (char) TextUtils.indexOf("", ""), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 11), m2036Z(1422 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getTapTimeout() >> 16), (Process.myTid() >> 22) + 12), m2036Z(1434 - (ViewConfiguration.getTouchSlop() >> 8), (char) (Process.myPid() >> 22), 11 - (ViewConfiguration.getTouchSlop() >> 8)), m2036Z(1445 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (3019 - (ViewConfiguration.getJumpTapTimeout() >> 16)), 6 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), m2036Z(ImageFormat.getBitsPerPixel(0) + 1451, (char) View.resolveSize(0, 0), (ViewConfiguration.getPressedStateDuration() >> 16) + 4)};
        long[] jArr7 = {216413717};
        f3085D = jArr7;
        f3096e = new String[]{m2036Z(View.resolveSizeAndState(0, 0, 0) + 1454, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 7 - TextUtils.indexOf((CharSequence) "", '0')), m2036Z(Drawable.resolveOpacity(0, 0) + 1462, (char) View.resolveSize(0, 0), 6 - Color.red(0)), m2036Z(Process.getGidForName("") + 1469, (char) (59724 - TextUtils.getOffsetAfter("", 0)), 7 - (ViewConfiguration.getJumpTapTimeout() >> 16)), m2036Z(Color.green(0) + 1475, (char) Drawable.resolveOpacity(0, 0), TextUtils.indexOf("", "", 0, 0) + 9), m2036Z(1485 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (-16777210) - Color.rgb(0, 0, 0)), m2036Z(1489 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((ViewConfiguration.getTapTimeout() >> 16) + 54932), 13 - ExpandableListView.getPackedPositionType(0L)), m2036Z((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1503, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2526), TextUtils.indexOf((CharSequence) "", '0', 0) + 6), m2036Z((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1508, (char) (47345 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 6 - KeyEvent.normalizeMetaState(0)), m2036Z(1514 - View.combineMeasuredStates(0, 0), (char) TextUtils.getTrimmedLength(""), Process.getGidForName("") + 3), m2036Z(1515 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) Color.alpha(0), 16 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), m2036Z(1532 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ExpandableListView.getPackedPositionType(0L) + 14258), 11 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), m2036Z((ViewConfiguration.getPressedStateDuration() >> 16) + 1542, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 63613), 8 - (ViewConfiguration.getLongPressTimeout() >> 16)), m2036Z(Color.red(0) + 1550, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), (Process.myPid() >> 22) + 12), m2036Z(1562 - (KeyEvent.getMaxKeyCode() >> 16), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 14 - ExpandableListView.getPackedPositionType(0L)), m2036Z(1575 - ImageFormat.getBitsPerPixel(0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 13701), 7 - (ViewConfiguration.getLongPressTimeout() >> 16)), m2036Z(1583 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), Color.red(0) + 7), m2036Z(ImageFormat.getBitsPerPixel(0) + 1591, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 21668), 7 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), m2036Z(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1598, (char) (4830 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), TextUtils.getOffsetBefore("", 0) + 2), m2036Z(1599 - (ViewConfiguration.getTapTimeout() >> 16), (char) (11317 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), ExpandableListView.getPackedPositionChild(0L) + 21), m2036Z((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1619, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 6), m2036Z(1248 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (20914 - TextUtils.indexOf("", "", 0, 0)), View.MeasureSpec.makeMeasureSpec(0, 0) + 2), m2036Z((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1624, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 15), m2036Z(1641 - ExpandableListView.getPackedPositionType(0L), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), TextUtils.getOffsetBefore("", 0) + 9), m2036Z((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1649, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 10 - View.MeasureSpec.getMode(0)), m2036Z(TextUtils.getOffsetAfter("", 0) + 1660, (char) (ImageFormat.getBitsPerPixel(0) + 60419), (ViewConfiguration.getEdgeSlop() >> 16) + 11), m2036Z(1670 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 34072), (ViewConfiguration.getEdgeSlop() >> 16) + 11), m2036Z((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1682, (char) ((ViewConfiguration.getTouchSlop() >> 8) + 13), TextUtils.indexOf("", "") + 15), m2036Z(TextUtils.lastIndexOf("", '0', 0) + 1698, (char) (ViewConfiguration.getFadingEdgeLength() >> 16), ExpandableListView.getPackedPositionType(0L) + 14)};
        f3092a = new B(40, jArr4, 0, 0L);
        f3093b = new B(20, jArr2, 0, 0L);
        f3095d = new B(60, jArr6, 0, 0L);
        f3094c = new B(40, jArr3, 5, Long.MAX_VALUE);
        f3097f = new B(20, jArr, 5, Long.MAX_VALUE);
        new B(60, jArr5, 5, Long.MAX_VALUE);
        f3098g = new B(150, jArr7, 5, LockFreeTaskQueueCore.HEAD_MASK);
        f3101j = new C2210cx.Z();
        int i = f3102l + 51;
        f3103m = i % 128;
        int i2 = i % 2;
    }
}
