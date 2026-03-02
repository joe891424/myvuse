package com.facetec.sdk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.facetec.sdk.cx */
/* JADX INFO: loaded from: classes3.dex */
class C2210cx {

    /* JADX INFO: renamed from: B */
    private static List<B> f3138B = new ArrayList();

    /* JADX INFO: renamed from: C */
    private static Map<Member, Object> f3139C = null;
    private static Class Code = null;

    /* JADX INFO: renamed from: D */
    private static char f3140D = 61678;

    /* JADX INFO: renamed from: F */
    private static Field f3141F = null;

    /* JADX INFO: renamed from: I */
    private static Class f3142I = null;

    /* JADX INFO: renamed from: L */
    private static Method f3143L = null;

    /* JADX INFO: renamed from: S */
    private static char f3144S = 12164;

    /* JADX INFO: renamed from: V */
    private static V f3145V = null;

    /* JADX INFO: renamed from: Z */
    private static Class f3146Z = null;

    /* JADX INFO: renamed from: a */
    private static int f3147a = 1;

    /* JADX INFO: renamed from: b */
    private static int f3148b = 0;

    /* JADX INFO: renamed from: c */
    private static char f3149c = 4504;

    /* JADX INFO: renamed from: d */
    private static long f3150d = -3013480983923001460L;

    /* JADX INFO: renamed from: e */
    private static char f3151e = 54987;

    C2210cx() {
    }

    static {
        V v;
        String property = System.getProperty(Code("\uf45f钱䖘ƞꈓ㴤\u20fc輌ꊞ켻봊送鈄鸃Ꞹ뇢", 15 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))));
        f3145V = V.f3170B;
        try {
            if (property == null) {
                v = V.f3170B;
            } else if (Integer.parseInt(property.substring(0, 1)) < 2) {
                v = V.f3175Z;
            } else {
                int i = f3147a + 53;
                f3148b = i % 128;
                int i2 = i % 2;
                v = V.f3174V;
            }
            f3145V = v;
            int i3 = f3148b + 77;
            f3147a = i3 % 128;
            int i4 = i3 % 2;
        } catch (NumberFormatException unused) {
        }
        try {
            Class<?> cls = Class.forName(Code("ꚝ譵㐼뒻矧ቈ㎮ࡥᬉ姤蘣㈤異\uf4b2筦╣嵯珧謬㼃\uf72b⤰ℏ忧檬떶鈪屃퀢䣉쵀ᒅ䍇ꬪ㯤︨", (Process.myTid() >> 22) + 35).intern(), true, ClassLoader.getSystemClassLoader());
            f3146Z = cls;
            if (cls != null) {
                f3138B.add(B.f3162V);
                try {
                    Field declaredField = f3146Z.getDeclaredField(Code("פֿ樷琹뜂㦐㤬얁\uee5c肋\u2fe3㋂輥\uf38b浨锾픘⥪涾\ue139\ue4cb䭊ઓ", 22 - Color.blue(0)).intern());
                    declaredField.setAccessible(true);
                    f3139C = (HashMap) declaredField.get(f3146Z);
                    Field declaredField2 = f3146Z.getDeclaredField(Code("浜\u038b䅸䃒\ue3e3\u20c4참퀏琹뜂䭊ઓ", Color.rgb(0, 0, 0) + 16777228).intern());
                    f3141F = declaredField2;
                    declaredField2.setAccessible(true);
                    f3143L = f3146Z.getDeclaredMethod(m2053I("\uf7e5\ud99b\uab08粈七ᾴ\ue115늱萭喪❟࣑\uda41ꯅ絟仾ၨ\ue1ed덡蔓", TextUtils.getOffsetBefore("", 0) + 11897).intern(), Member.class, Object.class, Object[].class);
                    Code = Class.forName(m2053I("\uf7e8婢\ued70\udfc5쉇듣ꞌꩽ鲥轓燲摽圏妰䱖㺅Ⅴᐅځऴﯝ\uee75키쎻똗뢒꭫鷺肄猁断桟嫤䵪】⊼", 3432 - Process.getGidForName("")).intern(), true, ClassLoader.getSystemClassLoader());
                    f3146Z.getDeclaredMethod(Code("荥辥㋂輥溘㕃᳥ᶡ\uec90ໜ\uf52d턤", 13 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))).intern(), Member.class, Code);
                } catch (ClassNotFoundException | Exception unused2) {
                }
            }
        } catch (ClassNotFoundException unused3) {
            if (C2213da.Code((Z) null).contains(Code("嵯珧謬㼃\uf72b⤰", (KeyEvent.getMaxKeyCode() >> 16) + 6))) {
                f3138B.add(B.f3162V);
            }
        }
        f3145V.equals(V.f3175Z);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cx$V */
    enum V {
        f3174V,
        f3175Z,
        f3170B;

        private static long Code = 931708880140549831L;

        /* JADX INFO: renamed from: L */
        private static int f3172L = 0;

        /* JADX INFO: renamed from: S */
        private static int f3173S = 1;

        public static V valueOf(String str) {
            int i = f3173S + 37;
            f3172L = i % 128;
            int i2 = i % 2;
            V v = (V) Enum.valueOf(V.class, str);
            int i3 = f3172L + 23;
            f3173S = i3 % 128;
            int i4 = i3 % 2;
            return v;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static V[] valuesCustom() {
            int i = f3173S + 59;
            f3172L = i % 128;
            if (i % 2 != 0) {
                Object obj = null;
                super.hashCode();
                throw null;
            }
            V[] vArr = (V[]) values().clone();
            int i2 = f3172L + 101;
            f3173S = i2 % 128;
            int i3 = i2 % 2;
            return vArr;
        }

        static {
            int i = f3173S + 21;
            f3172L = i % 128;
            int i2 = i % 2;
        }

        /* JADX INFO: renamed from: V */
        private static String m2064V(String str, int i) {
            String str2;
            char[] charArray = str.toCharArray();
            synchronized (C2194ch.Code) {
                char[] cArrCode = C2194ch.Code(Code, charArray, i);
                C2194ch.f3035V = 4;
                while (C2194ch.f3035V < cArrCode.length) {
                    C2194ch.f3034I = C2194ch.f3035V - 4;
                    cArrCode[C2194ch.f3035V] = (char) (((long) (cArrCode[C2194ch.f3035V] ^ cArrCode[C2194ch.f3035V % 4])) ^ (((long) C2194ch.f3034I) * Code));
                    C2194ch.f3035V++;
                }
                str2 = new String(cArrCode, 4, cArrCode.length - 4);
            }
            return str2;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cx$B */
    enum B {
        f3162V,
        Code,
        f3159I,
        f3163Z;


        /* JADX INFO: renamed from: C */
        private static int f3156C = 1;

        /* JADX INFO: renamed from: D */
        private static int f3157D = 0;

        /* JADX INFO: renamed from: F */
        private static char f3158F = 0;

        /* JADX INFO: renamed from: L */
        private static int f3160L = 0;

        /* JADX INFO: renamed from: S */
        private static long f3161S = 9134524051538470407L;

        public static B valueOf(String str) {
            int i = f3157D + 107;
            f3156C = i % 128;
            int i2 = i % 2;
            B b = (B) Enum.valueOf(B.class, str);
            int i3 = f3156C + 85;
            f3157D = i3 % 128;
            if (i3 % 2 == 0) {
                return b;
            }
            Object obj = null;
            super.hashCode();
            throw null;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static B[] valuesCustom() {
            int i = f3157D + 19;
            f3156C = i % 128;
            int i2 = i % 2;
            B[] bArr = (B[]) values().clone();
            int i3 = f3156C + 33;
            f3157D = i3 % 128;
            int i4 = i3 % 2;
            return bArr;
        }

        static {
            int i = f3157D + 17;
            f3156C = i % 128;
            int i2 = i % 2;
        }

        /* JADX INFO: renamed from: Z */
        private static String m2063Z(String str, int i, String str2, char c, String str3) {
            String str4;
            char[] charArray = str3.toCharArray();
            char[] charArray2 = str2.toCharArray();
            char[] charArray3 = str.toCharArray();
            synchronized (C2199cm.f3048V) {
                char[] cArr = (char[]) charArray2.clone();
                char[] cArr2 = (char[]) charArray.clone();
                cArr[0] = (char) (c ^ cArr[0]);
                cArr2[2] = (char) (cArr2[2] + ((char) i));
                int length = charArray3.length;
                char[] cArr3 = new char[length];
                C2199cm.f3047I = 0;
                while (C2199cm.f3047I < length) {
                    int i2 = (C2199cm.f3047I + 2) % 4;
                    int i3 = (C2199cm.f3047I + 3) % 4;
                    C2199cm.f3049Z = (char) (((cArr[C2199cm.f3047I % 4] * 32718) + cArr2[i2]) % 65535);
                    cArr2[i3] = (char) (((cArr[i3] * 32718) + cArr2[i2]) / 65535);
                    cArr[i3] = C2199cm.f3049Z;
                    cArr3[C2199cm.f3047I] = (char) (((((long) (cArr[i3] ^ charArray3[C2199cm.f3047I])) ^ f3161S) ^ ((long) f3160L)) ^ ((long) f3158F));
                    C2199cm.f3047I++;
                }
                str4 = new String(cArr3);
            }
            return str4;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cx$Code */
    enum Code {
        f3164B,
        f3169Z,
        Code;


        /* JADX INFO: renamed from: C */
        private static int f3165C = 1;

        /* JADX INFO: renamed from: D */
        private static int f3166D;

        /* JADX INFO: renamed from: I */
        private static char[] f3167I = {SafeJsonPrimitive.NULL_CHAR, 'F', 'J', 'Q', 'O', 'D', 'F', 'K', 'K', 'N', 'N', '+', 'K', 'P', 'U', 'L', 'F', 'B', 'D', 'L', 'S', 'K', '(', 'Q', 'Y', '`', 'X', 'Z', 'X', ']', 'b', 'Y', 'S', ']', 'f', '^', '['};

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Code[] valuesCustom() {
            int i = f3166D + 93;
            f3165C = i % 128;
            Code[] codeArr = (Code[]) (i % 2 == 0 ? values().clone() : values().clone());
            int i2 = f3166D + 71;
            f3165C = i2 % 128;
            if (i2 % 2 != 0) {
                return codeArr;
            }
            Object obj = null;
            super.hashCode();
            throw null;
        }

        private static String Code(int[] iArr, boolean z, String str) throws UnsupportedEncodingException {
            String str2;
            byte[] bytes = str.getBytes(InternalZipConstants.AES_HASH_CHARSET);
            synchronized (C2211cy.f3180V) {
                int i = iArr[0];
                int i2 = iArr[1];
                int i3 = iArr[2];
                int i4 = iArr[3];
                char[] cArr = new char[i2];
                System.arraycopy(f3167I, i, cArr, 0, i2);
                if (bytes != null) {
                    char[] cArr2 = new char[i2];
                    C2211cy.f3179I = 0;
                    char c = 0;
                    while (C2211cy.f3179I < i2) {
                        if (bytes[C2211cy.f3179I] == 1) {
                            cArr2[C2211cy.f3179I] = (char) (((cArr[C2211cy.f3179I] << 1) + 1) - c);
                        } else {
                            cArr2[C2211cy.f3179I] = (char) ((cArr[C2211cy.f3179I] << 1) - c);
                        }
                        c = cArr2[C2211cy.f3179I];
                        C2211cy.f3179I++;
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
                    C2211cy.f3179I = 0;
                    while (C2211cy.f3179I < i2) {
                        cArr4[C2211cy.f3179I] = cArr[(i2 - C2211cy.f3179I) - 1];
                        C2211cy.f3179I++;
                    }
                    cArr = cArr4;
                }
                if (i3 > 0) {
                    C2211cy.f3179I = 0;
                    while (C2211cy.f3179I < i2) {
                        cArr[C2211cy.f3179I] = (char) (cArr[C2211cy.f3179I] - iArr[2]);
                        C2211cy.f3179I++;
                    }
                }
                str2 = new String(cArr);
            }
            return str2;
        }

        static {
            int i = f3165C + 63;
            f3166D = i % 128;
            int i2 = i % 2;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cx$Z */
    static class Z {

        /* JADX INFO: renamed from: B */
        private static int f3176B = 0;

        /* JADX INFO: renamed from: Z */
        private static int f3177Z = 1;
        private Code Code = Code.f3164B;

        /* JADX INFO: renamed from: V */
        private Set<B> f3178V = EnumSet.noneOf(B.class);

        /* JADX INFO: renamed from: Z */
        static /* synthetic */ Set m2065Z(Z z) {
            int i = f3176B + 123;
            int i2 = i % 128;
            f3177Z = i2;
            int i3 = i % 2;
            Set<B> set = z.f3178V;
            int i4 = i2 + 31;
            f3176B = i4 % 128;
            int i5 = i4 % 2;
            return set;
        }

        /* JADX INFO: renamed from: I */
        public final void m2067I(boolean z) {
            Code code;
            int i = f3176B;
            int i2 = ((i | 11) << 1) - (i ^ 11);
            f3177Z = i2 % 128;
            int i3 = i2 % 2;
            int i4 = AnonymousClass5.f3152B[this.Code.ordinal()];
            if (i4 == 1 || i4 == 2) {
                if (!(!z)) {
                    int i5 = f3177Z + 99;
                    f3176B = i5 % 128;
                    int i6 = i5 % 2;
                    code = Code.f3169Z;
                } else {
                    code = Code.Code;
                    int i7 = f3176B;
                    int i8 = (i7 & 67) + (i7 | 67);
                    f3177Z = i8 % 128;
                    int i9 = i8 % 2;
                }
                this.Code = code;
                int i10 = f3176B;
                int i11 = (i10 ^ 103) + ((i10 & 103) << 1);
                f3177Z = i11 % 128;
                int i12 = i11 % 2;
            }
        }

        public final boolean Code() {
            int i = f3176B;
            int i2 = ((i | 7) << 1) - (i ^ 7);
            f3177Z = i2 % 128;
            int i3 = i2 % 2;
            Code code = this.Code;
            if (i3 == 0) {
                if (code != Code.f3169Z) {
                    return false;
                }
            } else if (code != Code.f3169Z) {
                return false;
            }
            int i4 = f3176B;
            int i5 = (i4 ^ 33) + ((i4 & 33) << 1);
            f3177Z = i5 % 128;
            int i6 = i5 % 2;
            return true;
        }

        public final void Code(Z z) {
            int i = f3176B + 85;
            f3177Z = i % 128;
            if (i % 2 == 0) {
                z.m2068I();
                Object obj = null;
                super.hashCode();
                throw null;
            }
            if (z.m2068I()) {
                this.f3178V.addAll(z.f3178V);
                m2067I(z.Code());
            }
            int i2 = f3177Z;
            int i3 = (i2 ^ 119) + ((i2 & 119) << 1);
            f3176B = i3 % 128;
            int i4 = i3 % 2;
        }

        /* JADX INFO: renamed from: I */
        public final boolean m2068I() {
            int i = f3177Z;
            int i2 = (i ^ 109) + ((i & 109) << 1);
            f3176B = i2 % 128;
            int i3 = i2 % 2;
            if (!(!this.f3178V.isEmpty())) {
                return false;
            }
            int i4 = f3176B;
            int i5 = ((i4 | 37) << 1) - (i4 ^ 37);
            int i6 = i5 % 128;
            f3177Z = i6;
            boolean z = i5 % 2 != 0;
            int i7 = i6 + 49;
            f3176B = i7 % 128;
            int i8 = i7 % 2;
            return z;
        }

        /* JADX INFO: renamed from: I */
        public final int m2066I(int i) {
            int i2;
            if (this.f3178V.isEmpty()) {
                int i3 = f3177Z + 27;
                f3176B = i3 % 128;
                int i4 = i3 % 2;
            } else {
                i = (i & Integer.MIN_VALUE) | (i ^ Integer.MIN_VALUE);
                int i5 = f3177Z;
                int i6 = (i5 ^ 41) + ((i5 & 41) << 1);
                f3176B = i6 % 128;
                int i7 = i6 % 2;
            }
            if (!Code()) {
                i2 = 0;
            } else {
                int i8 = f3177Z;
                int i9 = (i8 ^ 99) + ((i8 & 99) << 1);
                f3176B = i9 % 128;
                int i10 = i9 % 2;
                int i11 = i8 + 121;
                f3176B = i11 % 128;
                int i12 = i11 % 2;
                i2 = 1073741824;
            }
            int i13 = (i & i2) | (i ^ i2);
            Iterator<B> it2 = this.f3178V.iterator();
            int i14 = f3176B + OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_NEW_GROUP_ADDED;
            while (true) {
                f3177Z = i14 % 128;
                int i15 = i14 % 2;
                if (!it2.hasNext()) {
                    int i16 = f3176B + 89;
                    f3177Z = i16 % 128;
                    int i17 = i16 % 2;
                    return i13;
                }
                int i18 = f3177Z;
                int i19 = (i18 ^ 91) + ((i18 & 91) << 1);
                f3176B = i19 % 128;
                int i20 = i19 % 2;
                int i21 = -it2.next().ordinal();
                int i22 = 1 << (((i21 | 29) << 1) - (i21 ^ 29));
                i13 = (i13 & i22) | (i13 ^ i22);
                i14 = f3176B + 119;
            }
        }
    }

    public static Object Code(String str, Object obj, Z z) throws IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        int i = f3147a + 109;
        f3148b = i % 128;
        int i2 = i % 2;
        Object objCode = Code(str, obj, null, null, z);
        int i3 = f3148b + 55;
        f3147a = i3 % 128;
        int i4 = i3 % 2;
        return objCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object Code(String str, Object obj, Class[] clsArr, Object[] objArr, Z z) throws IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Class cls;
        if (obj instanceof Class) {
            int i = f3147a + 109;
            f3148b = i % 128;
            int i2 = i % 2;
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        if (clsArr == null) {
            int i3 = f3148b + 41;
            f3147a = i3 % 128;
            clsArr = i3 % 2 == 0 ? new Class[0] : new Class[0];
        }
        try {
            return m2058V(cls.getMethod(str, clsArr), obj, objArr, z);
        } catch (InstantiationException unused) {
            new RuntimeException();
            return null;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.cx$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: B */
        static final /* synthetic */ int[] f3152B;

        /* JADX INFO: renamed from: I */
        private static int f3153I = 1;

        /* JADX INFO: renamed from: Z */
        static final /* synthetic */ int[] f3154Z;

        static {
            int[] iArr = new int[B.valuesCustom().length];
            f3154Z = iArr;
            try {
                iArr[B.f3162V.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[Code.valuesCustom().length];
            f3152B = iArr2;
            try {
                iArr2[Code.f3164B.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3152B[Code.f3169Z.ordinal()] = 2;
                int i = (f3153I + 83) % 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3152B[Code.Code.ordinal()] = 3;
                int i2 = f3153I;
                int i3 = (((i2 | 19) << 1) - (i2 ^ 19)) % 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: Z */
    private static int m2060Z(Member member) {
        int i = f3147a;
        int i2 = i + 59;
        f3148b = i2 % 128;
        int i3 = i2 % 2;
        if (!(member instanceof Method)) {
            int i4 = i + 3;
            f3148b = i4 % 128;
            if (i4 % 2 == 0 ? !(member instanceof Constructor) : !(member instanceof Constructor)) {
                throw new IllegalArgumentException(Code("᳥ᶡ臏㈔蘶\uf15f帕䕛惫꺁黑\uf7ed\ua7d4⠦帕䕛肋\u2fe3㋂輥థ寜\ue6ea밲\ueb0a카\udfa3捜씓\uee64젽焳詥ࣁ\ue6ea밲궵嶉虮\u2fef絋攵\ue7b4ﻙ", TextUtils.indexOf((CharSequence) "", '0') + 45));
            }
        }
        try {
            if (f3145V == V.f3174V) {
                int i5 = f3147a + 89;
                f3148b = i5 % 128;
                int i6 = i5 % 2;
            }
        } catch (Throwable unused) {
        }
        return member.getModifiers();
    }

    /* JADX INFO: renamed from: V */
    private static boolean m2059V() {
        int i = f3147a + ModuleDescriptor.MODULE_VERSION;
        f3148b = i % 128;
        if (i % 2 != 0 && Build.VERSION.SDK_INT < 57) {
            return false;
        }
        int i2 = f3148b + 83;
        f3147a = i2 % 128;
        int i3 = i2 % 2;
        return !Build.VERSION.RELEASE.startsWith(Code("쩃䬞쩃䬞晀釖", TextUtils.getTrimmedLength("") + 5));
    }

    /* JADX INFO: renamed from: B */
    public static String m2051B(String str, boolean z, long j, Z z2) throws IOException {
        int i = f3147a + OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_NEW_GROUP_ADDED;
        f3148b = i % 128;
        if (i % 2 == 0) {
            return Code(new String[]{str}, z, j, z2);
        }
        String[] strArr = new String[0];
        strArr[1] = str;
        return Code(strArr, z, j, z2);
    }

    private static String Code(String[] strArr, boolean z, long j, Z z2) throws IOException {
        if (z) {
            int i = f3148b + 19;
            f3147a = i % 128;
            int i2 = i % 2;
            if (!m2059V()) {
                m2053I("\uf785뀟硙\u206f\ue8d8邮壃á줁煩㥚\ue19c꧰凐᧢숚訿㉔全ꊎ櫨ዝ\udb1d茤䭇\uf370뮜掯⯙펥鰄䐠ౘ드粳Ⓝ\uecf1锎崶Վ쵪疎㷮\ue5f1긙嘻ṛ왭躕㚤ﻕꚫ漇ᜣ\udf32螃侼\uf7d0뿭硃․\ue840遼墆¯죴煚㥻\ue14bꥶ冋ᦷ쇔觠㈀穀ꈰ檁\u12bf\udacc苨䭏", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 18396);
                return "";
            }
        }
        try {
            try {
                Process process = (Process) Code(m2053I("\uf7e9䅷髯푦", (ViewConfiguration.getLongPressTimeout() >> 16) + 46723), Runtime.getRuntime(), new Class[]{String[].class, String[].class, File.class}, new Object[]{new String[]{Code("煘ⶓ", 1 - TextUtils.lastIndexOf("", '0', 0, 0))}, null, null}, z2);
                C2205cs c2205cs = new C2205cs(process.getInputStream());
                C2205cs c2205cs2 = new C2205cs(process.getErrorStream());
                DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
                c2205cs.start();
                c2205cs2.start();
                for (int i3 = 0; i3 <= 0; i3++) {
                    dataOutputStream.write(new StringBuilder().append(strArr[0]).append(Code("ﶗ꺚", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))).toString().getBytes(m2053I("\uf7d9寃꿼\uf3f0䟘", TextUtils.indexOf((CharSequence) "", '0') + 44060)));
                    dataOutputStream.flush();
                }
                dataOutputStream.write(Code("ꖧ챤\ud8f8煖ﶗ꺚", KeyEvent.getDeadChar(0, 0) + 5).getBytes(m2053I("\uf7d9寃꿼\uf3f0䟘", 44059 - (KeyEvent.getMaxKeyCode() >> 16))));
                dataOutputStream.flush();
                try {
                    if (j < 0) {
                        int i4 = f3148b + 3;
                        f3147a = i4 % 128;
                        int i5 = i4 % 2;
                        process.waitFor();
                        int i6 = f3148b + 121;
                        f3147a = i6 % 128;
                        int i7 = i6 % 2;
                    } else {
                        m2055I(process, j, TimeUnit.MILLISECONDS);
                    }
                    try {
                        dataOutputStream.close();
                    } catch (IOException unused) {
                    }
                    c2205cs.join(100L);
                    c2205cs2.join(10L);
                    try {
                        process.destroy();
                    } catch (Exception unused2) {
                    }
                    return new StringBuilder().append(c2205cs.m2043Z()).append(c2205cs2.m2043Z()).toString();
                } catch (InterruptedException e) {
                    throw e;
                } catch (Throwable th) {
                    try {
                        process.destroy();
                    } catch (Exception unused3) {
                    }
                    throw th;
                }
            } catch (Exception unused4) {
                m2053I("\uf7d9\u0cf5Ǉڱᮠႚᕥ⩙⽑␧㥊㸔㋠㟄䲫䆥䚈孢偽啗橠漆搘碽緁狋瞿貂腋虸魓逨锍ꨕ껦ꎇ", 64278 - TextUtils.lastIndexOf("", '0', 0, 0));
                throw new IOException(m2053I("\uf7ca칂蒻嫭ᅕ힃궶搱㪛\uf08b뜹赻䏝ᨎ큪隨浜⍲梨뀁癒䲸˥\ud950龗嗨Ɽ", (ViewConfiguration.getEdgeSlop() >> 16) + 14767));
            }
        } catch (InvocationTargetException e2) {
            Exception exc = (Exception) e2.getCause();
            if (!(exc instanceof NullPointerException) && !(exc instanceof IllegalArgumentException)) {
                int i8 = f3148b + 1;
                f3147a = i8 % 128;
                int i9 = i8 % 2;
                if (!(exc instanceof SecurityException)) {
                    if (exc instanceof IOException) {
                        throw ((IOException) exc);
                    }
                    m2053I("\uf7d9\u0cf5Ǉڱᮠႚᕥ⩙⽑␧㥊㸔㋠㟄䲫䆥䚈孢偽啗橠漆搘碽緁狋瞿貂腋虸魓逨锍ꨕ껦ꎇ", 64279 - KeyEvent.normalizeMetaState(0));
                    throw new IOException(m2053I("\uf7ca칂蒻嫭ᅕ힃궶搱㪛\uf08b뜹赻䏝ᨎ큪隨浜⍲梨뀁癒䲸˥\ud950龗嗨Ɽ", (ViewConfiguration.getEdgeSlop() >> 16) + 14767));
                }
            }
            throw ((RuntimeException) exc);
        }
    }

    /* JADX INFO: renamed from: I */
    private static boolean m2055I(Process process, long j, TimeUnit timeUnit) throws InterruptedException {
        long jNanoTime = System.nanoTime();
        long nanos = timeUnit.toNanos(j);
        do {
            try {
                process.exitValue();
                int i = f3148b + 93;
                f3147a = i % 128;
                int i2 = i % 2;
                return true;
            } catch (IllegalThreadStateException unused) {
                if (nanos > 0) {
                    Thread.sleep(Math.min(TimeUnit.NANOSECONDS.toMillis(nanos) + 1, 3L));
                }
                nanos = timeUnit.toNanos(j) - (System.nanoTime() - jNanoTime);
            }
        } while (nanos > 0);
        int i3 = f3148b + 45;
        f3147a = i3 % 128;
        return i3 % 2 == 0;
    }

    /* JADX INFO: renamed from: I */
    public static boolean m2056I(String str, Z z) {
        int i = f3148b + 93;
        f3147a = i % 128;
        int i2 = i % 2;
        boolean zM2054I = m2054I(Code(str, z), z);
        int i3 = f3147a + 85;
        f3148b = i3 % 128;
        int i4 = i3 % 2;
        return zM2054I;
    }

    public static File Code(String str, Z z) {
        int i = f3147a + 35;
        f3148b = i % 128;
        int i2 = i % 2;
        try {
            File file = (File) m2058V(File.class.getConstructor(String.class), File.class, new Object[]{str}, z);
            int i3 = f3148b + 119;
            f3147a = i3 % 128;
            int i4 = i3 % 2;
            return file;
        } catch (Exception unused) {
            return new File(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059  */
    /* JADX INFO: renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean m2054I(java.io.File r6, com.facetec.sdk.C2210cx.Z r7) {
        /*
            int r0 = com.facetec.sdk.C2210cx.f3147a
            int r0 = r0 + 5
            int r1 = r0 % 128
            com.facetec.sdk.C2210cx.f3148b = r1
            int r0 = r0 % 2
            r1 = 1
            java.lang.String r2 = "ꖧ챤覽\uf75e얶\uef14"
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L2a
            int r0 = android.view.KeyEvent.normalizeMetaState(r1)     // Catch: java.lang.Exception -> L81
            r5 = 40
            int r5 = r5 / r0
            java.lang.String r0 = Code(r2, r5)     // Catch: java.lang.Exception -> L81
            java.lang.Object r0 = Code(r0, r6, r4, r4, r7)     // Catch: java.lang.Exception -> L81
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L81
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L81
            if (r0 != 0) goto L80
            goto L40
        L2a:
            int r0 = android.view.KeyEvent.normalizeMetaState(r3)     // Catch: java.lang.Exception -> L81
            int r0 = 6 - r0
            java.lang.String r0 = Code(r2, r0)     // Catch: java.lang.Exception -> L81
            java.lang.Object r0 = Code(r0, r6, r4, r4, r7)     // Catch: java.lang.Exception -> L81
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L81
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L81
            if (r0 != 0) goto L80
        L40:
            java.lang.String r0 = "覽\uf75e橮ⵝ蛕網詥ࣁ\ue6ea밲搽ꨚ"
            int r2 = android.view.View.resolveSize(r3, r3)     // Catch: java.lang.Exception -> L81
            int r2 = r2 + 11
            java.lang.String r0 = Code(r0, r2)     // Catch: java.lang.Exception -> L81
            java.lang.Object r0 = Code(r0, r6, r4, r4, r7)     // Catch: java.lang.Exception -> L81
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L81
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L81
            if (r0 != 0) goto L80
            int r0 = com.facetec.sdk.C2210cx.f3148b
            int r0 = r0 + 69
            int r2 = r0 % 128
            com.facetec.sdk.C2210cx.f3147a = r2
            int r0 = r0 % 2
            java.lang.String r0 = "\uf7e5턐먔茨汜㕂"
            int r2 = android.view.ViewConfiguration.getEdgeSlop()     // Catch: java.lang.Exception -> L81
            int r2 = r2 >> 16
            int r2 = 9967 - r2
            java.lang.String r0 = m2053I(r0, r2)     // Catch: java.lang.Exception -> L81
            java.lang.Object r7 = Code(r0, r6, r4, r4, r7)     // Catch: java.lang.Exception -> L81
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> L81
            boolean r6 = r7.booleanValue()     // Catch: java.lang.Exception -> L81
            if (r6 == 0) goto L7f
            goto L80
        L7f:
            return r3
        L80:
            return r1
        L81:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            r7.<init>()
            boolean r6 = r6.exists()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2210cx.m2054I(java.io.File, com.facetec.sdk.cx$Z):boolean");
    }

    /* JADX INFO: renamed from: Z */
    public static String m2062Z(String str, Z z) {
        int i = f3148b + 37;
        f3147a = i % 128;
        return Code(str, i % 2 == 0 ? Code("ꍧ\ue0f4", 4 % (TypedValue.complexToFloat(0) > 2.0f ? 1 : (TypedValue.complexToFloat(0) == 2.0f ? 0 : -1))) : Code("ꍧ\ue0f4", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 2), z);
    }

    public static String Code(String str, String str2, Z z) {
        String next;
        int i = f3147a + 21;
        f3148b = i % 128;
        if (i % 2 == 0) {
            File fileCode = Code(str, z);
            if (fileCode != null && m2054I(fileCode, z) && fileCode.isFile()) {
                try {
                    Scanner scannerUseDelimiter = new Scanner(new FileInputStream(fileCode)).useDelimiter(str2);
                    if (scannerUseDelimiter.hasNext()) {
                        next = scannerUseDelimiter.next();
                        int i2 = f3148b + 67;
                        f3147a = i2 % 128;
                        int i3 = i2 % 2;
                    } else {
                        next = "";
                    }
                    scannerUseDelimiter.close();
                    return next;
                } catch (IOException unused) {
                }
            }
            return "";
        }
        Code(str, z);
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: Z */
    public static int m2061Z(String[] strArr, Z z) {
        int i = f3147a + 23;
        f3148b = i % 128;
        int i2 = i % 2;
        int i3 = 0;
        while (i3 < strArr.length) {
            if (m2056I(strArr[i3], z)) {
                int i4 = f3148b + 47;
                f3147a = i4 % 128;
                int i5 = i4 % 2;
                m2053I("\uf785胑᧓銱⮅ꐫ㵋뙉伽\ud80c僶\ue9d6拲ﯳ", View.MeasureSpec.getSize(0) + 30491);
                return i3;
            }
            i3++;
            int i6 = f3148b + 13;
            f3147a = i6 % 128;
            int i7 = i6 % 2;
        }
        return -1;
    }

    /* JADX INFO: renamed from: V */
    public static int m2057V(String[] strArr, Z z) {
        int i = f3147a + 101;
        f3148b = i % 128;
        int i2 = i % 2 != 0 ? 1 : 0;
        while (i2 < strArr.length) {
            File fileCode = Code(strArr[i2], z);
            if (m2054I(fileCode, z)) {
                int i3 = f3147a + 125;
                f3148b = i3 % 128;
                int i4 = i3 % 2;
                m2053I("\uf785胑᧓銱⮅ꐫ㵋뙉伽\ud80c僶\ue9d6拲ﯳ", View.MeasureSpec.getSize(0) + 30491);
                Code("嘮䚥衷袃䀾\ud993ໜ崒穞ﻋ鼃翚\ude31㡇얶\uef14㠭\uef60ꠌ䯬뀛⣙\ue3e3\u20c4숌ꑡ", TextUtils.getCapsMode("", 0, 0) + 26);
                try {
                    if (((Boolean) Code(m2053I("\uf7e5턐먔茨汜㕂", 9967 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), fileCode, null, null, z)).booleanValue() && !((Boolean) Code(Code("࠺ᱺි\uf724ꠌ䯬ⲝ于", 7 - Color.green(0)), fileCode, null, null, z)).booleanValue()) {
                        int i5 = f3148b + 89;
                        f3147a = i5 % 128;
                        int i6 = i5 % 2;
                        m2053I("\uf785棩즣⪉譥\uec03䴻긁\u0efd濄삦ⅾ興\ue32a䐈ꓥ֜暱잕㡡餐﨡嫫믈Რ綆\ude60㽑逽\uf141冶", TextUtils.lastIndexOf("", '0', 0) + 40740);
                        return i2;
                    }
                } catch (Exception unused) {
                    new RuntimeException();
                    if (!fileCode.isFile()) {
                        continue;
                    } else if (!fileCode.canRead()) {
                        int i7 = f3148b + 15;
                        f3147a = i7 % 128;
                        m2053I("\uf785棩즣⪉譥\uec03䴻긁\u0efd濄삦ⅾ興\ue32a䐈ꓥ֜暱잕㡡餐﨡嫫믈Რ綆\ude60㽑逽\uf141冶", i7 % 2 == 0 ? 40740 << ImageFormat.getBitsPerPixel(0) : ImageFormat.getBitsPerPixel(0) + 40740);
                        return i2;
                    }
                }
            }
            i2++;
            int i8 = f3148b + 33;
            f3147a = i8 % 128;
            int i9 = i8 % 2;
        }
        return -1;
    }

    /* JADX INFO: renamed from: I */
    public static String m2052I(Context context, String str, Z z) {
        String str2;
        int i = f3147a + 119;
        f3148b = i % 128;
        int i2 = i % 2;
        if (f3142I == null) {
            ClassLoader classLoader = context.getClassLoader();
            String[] strArr = {m2053I("\uf7ed危뻎ᩇ斯섺Ⲛ瞧퍻㻔騜\ue58e䄑겈\uf7f2却뻑᨟斨섊Ⲁ矦퍜㻍騭\ue5b2䄑", 42131 - (ViewConfiguration.getWindowTouchSlop() >> 8)), m2053I("\uf7ed鷥⏦짫忿\ue5c6诂ᆓꟛ䷀폤禱ྪ閸㮞솀垎ﶏ莛⥬뽳", 27143 - KeyEvent.normalizeMetaState(0))};
            for (int i3 = 0; i3 < 2; i3++) {
                int i4 = f3147a + 3;
                f3148b = i4 % 128;
                int i5 = i4 % 2;
                try {
                    f3142I = classLoader.loadClass(strArr[i3]);
                    break;
                } catch (ClassNotFoundException unused) {
                    m2053I("\uf7ebҨᅺ⸟㫺㞦䑺儮淶窱睿葼邠궧멣뜪쏰킸\ued7a奔\uf6ecζ်ⴽ㧽㚻䍲偷泳禽癳茠鿟곍뤉", Color.blue(0) + 62273);
                    m2053I("\uf7ab", 4129 - Color.alpha(0));
                }
            }
        }
        String strTrim = null;
        if (f3142I != null) {
            try {
                str2 = (String) Code(m2053I("\uf7eb㚲畎", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 49499), f3142I, new Class[]{String.class}, new Object[]{str}, z);
            } catch (Exception unused2) {
                str2 = null;
            }
        } else {
            str2 = null;
        }
        try {
            strTrim = Code(new String[]{new StringBuilder().append(Code("晐る逛ꀝ\uabfcལ\u16fa邇", 8 - Color.green(0))).append(str).toString()}, false, -1L, z).trim();
        } catch (IOException unused3) {
        }
        if (str2 != null) {
            int i6 = f3148b + 59;
            f3147a = i6 % 128;
            int i7 = i6 % 2;
            return str2;
        }
        if (strTrim == null) {
            return "";
        }
        int i8 = f3147a + 49;
        f3148b = i8 % 128;
        int i9 = i8 % 2;
        return strTrim;
    }

    public static boolean Code(Context context, String str, Z z) throws Throwable {
        int i = f3148b + 73;
        f3147a = i % 128;
        int i2 = i % 2;
        try {
            return ((Integer) Code(Code("듚\ued1f絋攵눽ꗋ锾픘\n\uf6e4糀셨魥镏其ꎵ炩靻錤ѡ菽朒覽\uf75e\uf5d6ﾾ\udfa3捜", 29 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), context, new Class[]{String.class}, new Object[]{str}, z)).intValue() == 0;
        } catch (Exception unused) {
            new RuntimeException();
            try {
                if (((Integer) Class.forName(Code("ᬉ姤蘣㈤異\uf4b2筦╣匈ಣ錪㴬⑇\uf1e7\ue7b4ﻙ\ue87b᷼錪㴬ꖧ챤祋'", Drawable.resolveOpacity(0, 0) + 23)).getMethod(Code("듚\ued1f絋攵눽ꗋ锾픘\n\uf6e4糀셨魥镏其ꎵ炩靻錤ѡ菽朒覽\uf75e\uf5d6ﾾ\udfa3捜", (ViewConfiguration.getFadingEdgeLength() >> 16) + 28), String.class).invoke(context, str)).intValue() != 0) {
                    int i3 = f3147a + 95;
                    f3148b = i3 % 128;
                    int i4 = i3 % 2;
                    return false;
                }
                int i5 = f3147a + 77;
                int i6 = i5 % 128;
                f3148b = i6;
                int i7 = i5 % 2;
                int i8 = i6 + 13;
                f3147a = i8 % 128;
                int i9 = i8 % 2;
                return true;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: V */
    private static Object m2058V(Member member, Object obj, Object[] objArr, Z z) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        boolean z2 = member instanceof Method;
        if (!z2 && !(member instanceof Constructor)) {
            throw new IllegalArgumentException(Code("᳥ᶡ臏㈔蘶\uf15f帕䕛惫꺁黑\uf7ed\ua7d4⠦帕䕛肋\u2fe3㋂輥థ寜\ue6ea밲\ueb0a카\udfa3捜씓\uee64젽焳詥ࣁ\ue6ea밲궵嶉虮\u2fef絋攵\ue7b4ﻙ", 44 - Color.red(0)));
        }
        ArrayList arrayList = new ArrayList(0);
        if (f3138B.contains(B.f3162V)) {
            int iM2060Z = m2060Z(member);
            if ((iM2060Z & 256) != 0 || (iM2060Z & 268435456) != 0) {
                arrayList.add(B.f3162V);
            } else {
                Map<Member, Object> map = f3139C;
                if (map != null && map.keySet().contains(member)) {
                    arrayList.add(B.f3162V);
                }
            }
        }
        if ((f3138B.isEmpty() || f3138B.contains(B.f3163Z)) && (member.getModifiers() & 256) != 0) {
            arrayList.add(B.f3163Z);
        }
        if (z != null) {
            Z.m2065Z(z).addAll(arrayList);
        }
        if (arrayList.isEmpty() || arrayList.size() != 1 || AnonymousClass5.f3154Z[((B) arrayList.get(0)).ordinal()] != 1) {
            if (z != null) {
                z.m2067I(false);
            }
            if (member instanceof Constructor) {
                return ((Constructor) member).newInstance(objArr);
            }
            return ((Method) member).invoke(obj, objArr);
        }
        if (z != null) {
            z.m2067I(true);
        }
        if (z2) {
            return f3143L.invoke(f3146Z, member, obj, objArr);
        }
        synchronized (C2210cx.class) {
            f3141F.setBoolean(f3146Z, true);
            objNewInstance = ((Constructor) member).newInstance(objArr);
            f3141F.setBoolean(f3146Z, false);
        }
        return objNewInstance;
    }

    private static String Code(String str, int i) {
        String str2;
        char[] charArray = str.toCharArray();
        synchronized (C2209cw.f3136B) {
            char[] cArr = new char[charArray.length];
            C2209cw.f3137I = 0;
            char[] cArr2 = new char[2];
            while (C2209cw.f3137I < charArray.length) {
                cArr2[0] = charArray[C2209cw.f3137I];
                cArr2[1] = charArray[C2209cw.f3137I + 1];
                int i2 = 58224;
                for (int i3 = 0; i3 < 16; i3++) {
                    char c = cArr2[1];
                    char c2 = cArr2[0];
                    char c3 = (char) (c - (((c2 + i2) ^ ((c2 << 4) + f3149c)) ^ ((c2 >>> 5) + f3151e)));
                    cArr2[1] = c3;
                    cArr2[0] = (char) (c2 - (((c3 >>> 5) + f3140D) ^ ((c3 + i2) ^ ((c3 << 4) + f3144S))));
                    i2 -= 40503;
                }
                cArr[C2209cw.f3137I] = cArr2[0];
                cArr[C2209cw.f3137I + 1] = cArr2[1];
                C2209cw.f3137I += 2;
            }
            str2 = new String(cArr, 0, i);
        }
        return str2;
    }

    /* JADX INFO: renamed from: I */
    private static String m2053I(String str, int i) {
        String str2;
        char[] charArray = str.toCharArray();
        synchronized (C2201co.f3064B) {
            C2201co.f3066V = i;
            char[] cArr = new char[charArray.length];
            C2201co.f3065I = 0;
            while (C2201co.f3065I < charArray.length) {
                cArr[C2201co.f3065I] = (char) (((long) (charArray[C2201co.f3065I] ^ (C2201co.f3065I * C2201co.f3066V))) ^ f3150d);
                C2201co.f3065I++;
            }
            str2 = new String(cArr);
        }
        return str2;
    }
}
