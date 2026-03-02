package com.facetec.sdk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.facetec.sdk.C2210cx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: com.facetec.sdk.da */
/* JADX INFO: loaded from: classes3.dex */
class C2213da {

    /* JADX INFO: renamed from: B */
    static BigInteger f3183B = null;
    static BigInteger Code = null;

    /* JADX INFO: renamed from: D */
    static BigInteger f3185D = null;

    /* JADX INFO: renamed from: F */
    private static BigInteger f3186F = null;

    /* JADX INFO: renamed from: S */
    private static final String[] f3189S;

    /* JADX INFO: renamed from: a */
    private static final C2210cx.Z f3192a;

    /* JADX INFO: renamed from: b */
    private static final C2210cx.Z f3193b;

    /* JADX INFO: renamed from: c */
    private static String f3194c = null;

    /* JADX INFO: renamed from: d */
    private static Set<BigInteger> f3195d = null;

    /* JADX INFO: renamed from: e */
    private static String f3196e = null;

    /* JADX INFO: renamed from: f */
    private static long f3197f = 0;

    /* JADX INFO: renamed from: g */
    private static char f3198g = 32588;

    /* JADX INFO: renamed from: h */
    private static int f3199h = 1545777160;

    /* JADX INFO: renamed from: i */
    private static final C2210cx.Z f3200i;

    /* JADX INFO: renamed from: j */
    private static char f3201j = 0;

    /* JADX INFO: renamed from: k */
    private static char f3202k = 34341;

    /* JADX INFO: renamed from: l */
    private static char f3203l = 36493;

    /* JADX INFO: renamed from: m */
    private static int f3204m = 1;

    /* JADX INFO: renamed from: n */
    private static char f3205n = 28262;

    /* JADX INFO: renamed from: o */
    private static int f3206o;

    /* JADX INFO: renamed from: V */
    static BigInteger f3190V = new BigInteger(m2071V((char) (14239 - Color.alpha(0)), KeyEvent.normalizeMetaState(0), "\ueb8f쑋\uf081裝\ufada\u196f\u09bb镮\ude3dݥ⨐ꞑ꾤桯\uf712ǵ睿ﳘ㭪ᔲ㏞䇏ฬ\uf4c3뤽〞\u008dꄱ箟ﾷ嗴堖", "ᶄ\ued26齰鼷", "\u0000\u0000\u0000\u0000"), 16);

    /* JADX INFO: renamed from: L */
    private static BigInteger f3188L = new BigInteger(m2071V((char) (Color.rgb(0, 0, 0) + 16814037), Color.argb(0, 0, 0, 0), "ﴴ\uefbb驃붼䄂䁒ⅴ弻ꍆ奒í⍑\ueec1\ue968䋔쪚ꊵظ䑰\ue319㬒絭\uf6cfꊭ옍㳩繅༁ﷳ繃繜喚", "嫄\ue796핔亏", "\u0000\u0000\u0000\u0000"), 16);

    /* JADX INFO: renamed from: C */
    private static BigInteger f3184C = new BigInteger(m2072V("Ḱ昳ⷠ폊༎\ufbcc\ue230깏눯䴛컜༄右벺쵋콲\uf256茭ၦ訁\u196e鼻᛭컹䬵\ue4fb뎍촫钰\udcf1觢섳", 32 - TextUtils.getOffsetAfter("", 0)), 16);

    /* JADX INFO: renamed from: I */
    static BigInteger f3187I = new BigInteger(m2071V((char) (View.MeasureSpec.getMode(0) + 50576), ViewConfiguration.getScrollDefaultDelay() >> 16, "蟬ળ햽헇ޯ\udafe闺茊빳㷏\uf506\ue832虎꩗\uf06a騞\u2004\u1ad0\ue719௩⇬幱돀럍墳㌳宆镙鷈ꁓ㾟鈭", "复䓲達ễ", "\u0000\u0000\u0000\u0000"), 16);

    /* JADX INFO: renamed from: Z */
    static BigInteger f3191Z = new BigInteger(m2072V("ݞ\ua636\uf539\uee33\uda60縅쏚㋭✳蠊짞띘᪐㷞⢌鲋黉嶝\uf06dꦧឆ緗눯䴛ཱ欱\udd94䄅钰\udcf1Ᏺﰿ", TextUtils.lastIndexOf("", '0') + 33), 16);

    C2213da() {
    }

    static {
        new BigInteger(m2072V("ᤐΊ\uf328ᣮử\u09ba鞂粯펽␉蟹\uf576ꭳ\u181fㄉ햏₉捖᪐㷞\u196e鼻٧뇭鞂粯졎쌾멝쨳꺬㴩", (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 32), 16);
        f3186F = new BigInteger(m2072V("⢌鲋顉ըꢟ笾霰褴趟묭₉捖ꡰ볒⢌鲋煩ᛷ檭諃嵴㛕⢌鲋\uea39᧢鮸\uea64趟묭⏶鹶", 32 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), 16);
        f3183B = new BigInteger(m2071V((char) (TextUtils.getOffsetBefore("", 0) + 64427), ViewConfiguration.getScrollBarSize() >> 8, "濧詐胣\u20c7〉㰘鐭꼷⿑缻璉ឈ뛒眝샠믌\uf36b膦ꐪѵ廧虋璜殾\ue361䆜ᝣ\ue43e铠汰蠶\uf186", "㺇눕ꮬ勻", "\u0000\u0000\u0000\u0000"), 16);
        Code = new BigInteger(m2071V((char) (Drawable.resolveOpacity(0, 0) + 49222), ViewConfiguration.getScrollBarFadeDuration() >> 16, "ኹဤﯻ䦪鏍᪖㕯色䱲\ue900ᑮ덭橀ע⠶ኬ홙랝嫙룼\ue6ff睟\ueba5麍육오抧頰瀾눼䵜襉", "\u1311촞䙫鏀", "\u0000\u0000\u0000\u0000"), 16);
        f3185D = new BigInteger(m2072V("䆟劫鋮瘕붯ᄲ鋮瘕ﴇ잰ꏘਐ檥弼䂆께铲ᙕ\uea39᧢\uf850ȡֽ亚\uf256茭Ꟶ萱顉ը⏶鹶", 32 - ExpandableListView.getPackedPositionGroup(0L)), 16);
        f3189S = new String[]{m2071V((char) (TextUtils.getOffsetBefore("", 0) + 24760), 1317359946 - ExpandableListView.getPackedPositionType(0L), "鸞뚨쇯海㪆⛔鬥楆ナ\ud828ﴓ鞦\uf217", "䪬蕑롎鱠", "\u0000\u0000\u0000\u0000"), m2072V("ॿ骸䊤疊ॿ骸呾듀牲쁋\ue073㌠둉\ue115ᰰ黰", (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 17), m2071V((char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 445721037 - (ViewConfiguration.getLongPressTimeout() >> 16), "乍娑\uf278ნོ᧗핕脩メﲹ竉\ue7a4瀐㊨ḍᶫ傉ᔦ韩毧假\uf880汮", "촩鄩⨚\uf860", "\u0000\u0000\u0000\u0000"), m2072V("ॿ骸䊤疊ॿ骸呾듀牲쁋쁡䂎晬䛴䵍Ｎ緋㞖桳忥㩦痗洠ꃭ牲쁋㱹㕽쀭ډ", 31 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)))};
        f3196e = null;
        f3193b = new C2210cx.Z();
        f3194c = null;
        f3192a = new C2210cx.Z();
        f3195d = null;
        f3200i = new C2210cx.Z();
        int i = f3206o + 27;
        f3204m = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: renamed from: I */
    public static Set<BigInteger> m2070I(Context context, C2210cx.Z z) {
        synchronized (C2213da.class) {
            if (f3195d == null) {
                f3195d = new HashSet();
                try {
                    BufferedReader bufferedReader = null;
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(C2210cx.Code(m2071V((char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 5475), ViewConfiguration.getJumpTapTimeout() >> 16, "穅秴鿒\ue2c9࠽ẑ흀䜵\ue307娼⅐↾ῶ⚶\uf148\ue469鮻ಮ", "홦\ue9f2捄క", "\u0000\u0000\u0000\u0000"), f3200i)));
                        while (true) {
                            try {
                                byte[] bArrCode = Code(bufferedReader2.readLine());
                                if (bArrCode == null) {
                                    break;
                                }
                                f3195d.add(new BigInteger(1, bArrCode));
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        }
                        bufferedReader2.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException | Exception unused2) {
                }
                if (f3195d.isEmpty()) {
                    int i = 0;
                    while (true) {
                        String[] strArr = f3189S;
                        if (i >= strArr.length) {
                            break;
                        }
                        String strM2052I = C2210cx.m2052I(context, strArr[i], f3200i);
                        if (!TextUtils.isEmpty(strM2052I)) {
                            f3195d.add(new BigInteger(1, Code(new StringBuilder().append(strArr[i]).append(m2071V((char) ((Process.myPid() >> 22) + 6458), TextUtils.getOffsetAfter("", 0) - 1685120705, "⾎", "㾒輙㪛⨙", "\u0000\u0000\u0000\u0000")).append(strM2052I).toString())));
                        }
                        i++;
                    }
                }
                f3195d.retainAll(Arrays.asList(f3190V, f3188L, f3184C, f3187I, f3191Z, f3186F, Code, f3183B, f3185D));
            }
        }
        if (z != null) {
            z.Code(f3200i);
        }
        return f3195d;
    }

    /* JADX INFO: renamed from: I */
    public static String m2069I(C2210cx.Z z) throws Exception {
        synchronized (C2213da.class) {
            if (f3196e == null) {
                if (Build.VERSION.SDK_INT <= 26) {
                    f3196e = C2210cx.m2051B(m2071V((char) (58817 - View.resolveSizeAndState(0, 0, 0)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), "簛\udab2", "ꭟ홱쇝쏥", "\u0000\u0000\u0000\u0000"), false, -1L, f3193b);
                } else {
                    f3196e = C2210cx.m2051B(m2071V((char) (32981 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), 881516842 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), "ꥅᙘﱄ吡穅", "⥜諡퐴ƀ", "\u0000\u0000\u0000\u0000"), false, -1L, f3193b);
                }
            }
        }
        if (z != null) {
            z.Code(f3193b);
        }
        return f3196e;
    }

    public static String Code(C2210cx.Z z) {
        synchronized (C2213da.class) {
            if (f3194c == null) {
                for (String str : new File(m2071V((char) (10817 - TextUtils.getCapsMode("", 0, 0)), 213526823 - ExpandableListView.getPackedPositionChild(0L), "\uf517檘\udd59䱽綕", "⡄먩䄌됪", "\u0000\u0000\u0000\u0000")).list()) {
                    String strCode = C2210cx.Code(new StringBuilder().append(m2072V("阮ꪚॿ骸ദ嶌", KeyEvent.normalizeMetaState(0) + 6)).append(str).append(m2072V("֔굷츺\uf8f2꾋ᯮ߸ȳ", Color.green(0) + 8)).toString(), m2071V((char) (47369 - TextUtils.indexOf((CharSequence) "", '0')), TextUtils.indexOf("", "") - 1659614795, "\ueba1", "떛ᑉઝᆹ", "\u0000\u0000\u0000\u0000"), f3192a);
                    f3194c = new StringBuilder().append(f3194c).append(TextUtils.isEmpty(strCode) ? "" : new StringBuilder().append(strCode).append(m2071V((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 60353), TextUtils.lastIndexOf("", '0', 0, 0) + 21080841, "飅", "࡙䆫쀁ᇫ", "\u0000\u0000\u0000\u0000")).toString()).toString();
                }
            }
        }
        if (z != null) {
            z.Code(f3192a);
        }
        return f3194c;
    }

    private static byte[] Code(String str) throws Throwable {
        int i = f3204m + 9;
        f3206o = i % 128;
        int i2 = i % 2;
        try {
            String strM2071V = m2071V((char) (TextUtils.lastIndexOf("", '0') + 20370), ExpandableListView.getPackedPositionType(0L) + 1309892408, "\ue12f蛔鋨", "㢫፟酎\ueb4f", "\u0000\u0000\u0000\u0000");
            int i3 = f3204m + 39;
            f3206o = i3 % 128;
            int i4 = i3 % 2;
            try {
                MessageDigest messageDigest = (MessageDigest) Class.forName(m2071V((char) (17232 - View.MeasureSpec.getMode(0)), 2137128617 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), "\u0005阁퐥Ⓐପ쀞禝띏뻈\ue129曄벳禅뙠黕\uee39羡펊疸嘀\ueb87៸錣Ⲟ뗰\uece2쭽", "ꤞ懾偿㉃", "\u0000\u0000\u0000\u0000")).getMethod(m2071V((char) TextUtils.indexOf("", "", 0, 0), TextUtils.indexOf("", "") + 88013858, "횥覢侈輏㈸Ԋ潆\ufaeb㩸Ꝙ䈎", "∌㻼怅콺", "\u0000\u0000\u0000\u0000"), String.class).invoke(null, strM2071V);
                messageDigest.update(str.getBytes());
                int i5 = f3204m + 87;
                f3206o = i5 % 128;
                int i6 = i5 % 2;
                try {
                    return (byte[]) Class.forName(m2071V((char) (17232 - (ViewConfiguration.getTapTimeout() >> 16)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 2137128617, "\u0005阁퐥Ⓐପ쀞禝띏뻈\ue129曄벳禅뙠黕\uee39羡펊疸嘀\ueb87៸錣Ⲟ뗰\uece2쭽", "ꤞ懾偿㉃", "\u0000\u0000\u0000\u0000")).getMethod(m2071V((char) (Color.rgb(0, 0, 0) + 16806720), Color.rgb(0, 0, 0) + 16777216, "쒉酕踎푭Ӗ\u1af2", "ંﴞ䂝╳", "\u0000\u0000\u0000\u0000"), null).invoke(messageDigest, null);
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
        } catch (NoSuchAlgorithmException unused) {
            return new byte[0];
        }
    }

    /* JADX INFO: renamed from: V */
    private static String m2071V(char c, int i, String str, String str2, String str3) {
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
                cArr3[C2199cm.f3047I] = (char) (((((long) (cArr[i3] ^ charArray3[C2199cm.f3047I])) ^ f3197f) ^ ((long) f3199h)) ^ ((long) f3201j));
                C2199cm.f3047I++;
            }
            str4 = new String(cArr3);
        }
        return str4;
    }

    /* JADX INFO: renamed from: V */
    private static String m2072V(String str, int i) {
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
                    char c3 = (char) (c - (((c2 + i2) ^ ((c2 << 4) + f3205n)) ^ ((c2 >>> 5) + f3202k)));
                    cArr2[1] = c3;
                    cArr2[0] = (char) (c2 - (((c3 >>> 5) + f3203l) ^ ((c3 + i2) ^ ((c3 << 4) + f3198g))));
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
}
