package com.facetec.sdk;

import android.content.Context;
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
import androidx.core.view.PointerIconCompat;
import com.bat.sdk.domain.device.FirmwareInstallationState;
import com.facebook.imageutils.TiffUtil;
import com.facetec.sdk.C2210cx;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import net.lingala.zip4j.util.InternalZipConstants;
import okhttp3.internal.p103ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facetec.sdk.cq */
/* JADX INFO: loaded from: classes3.dex */
public final class C2203cq extends C2207cu {

    /* JADX INFO: renamed from: B */
    private static final String[] f3069B;

    /* JADX INFO: renamed from: C */
    private static final Code[] f3070C;
    private static final Code[] Code;

    /* JADX INFO: renamed from: D */
    private static C2210cx.Z f3071D = null;

    /* JADX INFO: renamed from: F */
    private static char[] f3072F = null;

    /* JADX INFO: renamed from: I */
    private static final String[] f3073I;

    /* JADX INFO: renamed from: L */
    private static long f3074L = 0;

    /* JADX INFO: renamed from: S */
    private static final Code[] f3075S;

    /* JADX INFO: renamed from: V */
    private static final String[] f3076V;

    /* JADX INFO: renamed from: Z */
    private static final String[] f3077Z;

    /* JADX INFO: renamed from: c */
    private static int f3078c = 0;

    /* JADX INFO: renamed from: d */
    private static int f3079d = 1;

    /* JADX INFO: renamed from: b */
    private static native long m2018b(int i);

    /* JADX INFO: renamed from: com.facetec.sdk.cq$Code */
    static class Code {

        /* JADX INFO: renamed from: B */
        private static int f3080B = 1;
        private static int Code;

        /* JADX INFO: renamed from: I */
        private final String[] f3081I;

        /* JADX INFO: renamed from: Z */
        private final String f3082Z;

        static /* synthetic */ String[] Code(Code code) {
            int i = Code;
            int i2 = (i & 45) + (i | 45);
            f3080B = i2 % 128;
            int i3 = i2 % 2;
            return code.f3081I;
        }

        /* JADX INFO: renamed from: Z */
        static /* synthetic */ String m2019Z(Code code) {
            int i = f3080B + 67;
            int i2 = i % 128;
            Code = i2;
            int i3 = i % 2;
            String str = code.f3082Z;
            int i4 = (i2 ^ 9) + ((i2 & 9) << 1);
            f3080B = i4 % 128;
            int i5 = i4 % 2;
            return str;
        }

        Code(String str, String... strArr) {
            this.f3082Z = str;
            this.f3081I = strArr;
        }

        Code(String str) {
            this.f3082Z = str;
            this.f3081I = null;
        }
    }

    /* JADX INFO: renamed from: I */
    private static C2217df m2016I(Context context, int i) throws Throwable {
        Code[] codeArr;
        long j = 0;
        m2017I((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 40, 86 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
        ArrayList arrayList = new ArrayList();
        try {
            try {
                if (!C2210cx.Code(context, m2017I(35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getEdgeSlop() >> 16) + WebSocketProtocol.PAYLOAD_SHORT, (char) (33782 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)))).intern(), f3071D)) {
                    m2017I(69 - View.MeasureSpec.makeMeasureSpec(0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 161, (char) (5662 - Drawable.resolveOpacity(0, 0)));
                    return new C2217df(i, null, null);
                }
                try {
                    char c = '0';
                    Object objCode = C2210cx.Code(m2017I(16 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), Color.green(0) + TiffUtil.TIFF_TAG_ORIENTATION, (char) (Process.myTid() >> 22)), Class.forName(m2017I(23 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 229 - ImageFormat.getBitsPerPixel(0), (char) (TextUtils.indexOf("", "") + 23770))).getMethod(m2017I(21 - (ViewConfiguration.getWindowTouchSlop() >> 8), ((Process.getThreadPriority(0) + 20) >> 6) + 253, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 5481)), null).invoke(context, null), new Class[]{String.class}, new Object[]{m2017I(5 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 291 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))}, f3071D);
                    if (objCode == null) {
                        C2217df c2217df = new C2217df(i ^ 102, null, null);
                        int i2 = f3079d + 73;
                        f3078c = i2 % 128;
                        int i3 = i2 % 2;
                        return c2217df;
                    }
                    int i4 = i;
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        Code[] codeArr2 = f3070C;
                        if (i5 >= codeArr2.length) {
                            break;
                        }
                        Code.m2019Z(codeArr2[i5]).equals(m2017I(ExpandableListView.getPackedPositionChild(j) + 19, 295 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (3003 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))));
                        try {
                            String str = (String) C2210cx.Code(Code.m2019Z(codeArr2[i5]), objCode, f3071D);
                            int i7 = 0;
                            while (true) {
                                codeArr = f3070C;
                                if (i7 < Code.Code(codeArr[i5]).length) {
                                    if (str.equalsIgnoreCase(Code.Code(codeArr[i5])[i7])) {
                                        break;
                                    }
                                    int i8 = f3078c + 55;
                                    f3079d = i8 % 128;
                                    int i9 = i8 % 2;
                                    if (str.endsWith(Code.Code(codeArr[i5])[i7])) {
                                        break;
                                    }
                                    i7++;
                                } else {
                                    break;
                                }
                            }
                            i4 = i ^ (i5 + 104);
                            arrayList.add(new StringBuilder().append(Code.m2019Z(codeArr[i5])).append(m2017I(-TextUtils.indexOf("", c), 41 - Color.red(0), (char) ((-16754401) - Color.rgb(0, 0, 0)))).append(Code.Code(codeArr[i5])[i7]).toString());
                            m2017I(22 - TextUtils.indexOf("", "", 0, 0), 313 - TextUtils.getOffsetAfter("", 0), (char) (View.MeasureSpec.getMode(0) + 44531));
                            Code.m2019Z(codeArr[i5]);
                            m2017I(2 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getJumpTapTimeout() >> 16) + 335, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                            Code.Code(codeArr[i5]);
                            i6++;
                        } catch (Exception unused) {
                        }
                        i5++;
                        j = 0;
                        c = '0';
                    }
                    int i10 = f3079d + 79;
                    f3078c = i10 % 128;
                    int i11 = i10 % 2;
                    return i6 > 1 ? new C2217df(i4, null, arrayList) : new C2217df(i, null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                return new C2217df(i ^ 103, null, null);
            }
        } catch (Exception unused3) {
            return new C2217df(i ^ 101, null, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
    
        continue;
     */
    /* JADX INFO: renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int m2012B(int r11) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2203cq.m2012B(int):int");
    }

    /* JADX INFO: renamed from: I */
    private static int m2015I(int i) {
        m2017I((KeyEvent.getMaxKeyCode() >> 16) + 32, ExpandableListView.getPackedPositionGroup(0L) + 394, (char) (ExpandableListView.getPackedPositionChild(0L) + 27862));
        try {
            if (C2210cx.m2062Z(m2017I(13 - Color.argb(0, 0, 0, 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 426, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 128)), f3071D).contains(m2017I(View.MeasureSpec.makeMeasureSpec(0, 0) + 8, (KeyEvent.getMaxKeyCode() >> 16) + 439, (char) (9529 - (ViewConfiguration.getScrollDefaultDelay() >> 16))))) {
                int i2 = f3078c + 53;
                f3079d = i2 % 128;
                int i3 = i2 % 2;
                m2017I(View.combineMeasuredStates(0, 0) + 15, 446 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                int i4 = i ^ 150;
                int i5 = f3078c + 53;
                f3079d = i5 % 128;
                int i6 = i5 % 2;
                return i4;
            }
            int i7 = f3078c + 29;
            f3079d = i7 % 128;
            int i8 = i7 % 2;
            return i;
        } catch (Exception unused) {
            return i ^ 151;
        }
    }

    /* JADX INFO: renamed from: B */
    private static int m2013B(int i, C2210cx.Z z) {
        int i2 = f3079d + 15;
        int i3 = i2 % 128;
        f3078c = i3;
        int i4 = i2 % 2;
        if (z == null) {
            return i;
        }
        int i5 = i3 + 113;
        f3079d = i5 % 128;
        int i6 = i5 % 2;
        if (!z.m2068I()) {
            return i;
        }
        if (!z.Code()) {
            return z.m2066I(i);
        }
        int i7 = f3079d + 57;
        int i8 = i7 % 128;
        f3078c = i8;
        if (i7 % 2 != 0) {
            return z.m2066I(i);
        }
        int i9 = i8 + 79;
        f3079d = i9 % 128;
        int i10 = i9 % 2;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02e4  */
    /* JADX INFO: renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m2014B(android.content.Context r18, int r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2203cq.m2014B(android.content.Context, int):int");
    }

    /* JADX INFO: renamed from: I */
    private static String m2017I(int i, int i2, char c) {
        String str;
        synchronized (C2216de.f3214Z) {
            char[] cArr = new char[i];
            C2216de.f3213B = 0;
            while (C2216de.f3213B < i) {
                cArr[C2216de.f3213B] = (char) ((((long) f3072F[C2216de.f3213B + i2]) ^ (((long) C2216de.f3213B) * f3074L)) ^ ((long) c));
                C2216de.f3213B++;
            }
            str = new String(cArr);
        }
        return str;
    }

    static {
        char[] cArr = new char[2256];
        ByteBuffer.wrap("\u0000EßH¾?\u009d\u0003|õ[Í:±\u001aqù\bØ.·\u001a\u0096òußT\u008a4&\u0013\u0006òpÑ\u0006°ã\u008fÌn\u0090Nl-C\fsë\bÊï©\u00ad\u0088\u0097hiGC&\"\u0005\u0012äÅÃ¶¢Ê\u0082la\\@<\u001f\u001dþÈÝæY%\u0000\tßu¾8\u009d\u0000|ä[Ü:¬\u001awùQØm\u0000 ßV¾\"\u009d\u0000|á[Õ:º\u001a#ù@Ø,·\u0004\u0096òu\u009cT\u00834c\u0013Nò>ÑU°ÿ\u008fÒn\u0094N}-W\f}A\u0095\u009eöÿ\u0093Ü»=F\u001ak{\u000e[Ò¸³\u0000EßH¾?\u009d\u0003|õ[Í:±\u001aqù\bØ.·\u001a\u0096òußT\u008a4&\u0013\u0006òpÑ\u0001°ÿ\u008fÓn\u0081Ny-F\f<ë\u0016Êä©â\u0088\u008ahmG_&7\u0005\u001cäÅÃ·¢Ê\u0082la\\@<\u001f\u001dþÈÝæ\u0083\u0096\\¼=Ù\u001eêÿ\fØ'¹M\u0099Úz¯[ß4÷\u0015\rö\"×e·\u0082\u0090µqÈRì3C\f\u001aíVÍ¿®\u009d\u008fûhßI\"*z\u000b^ë¾Ä\u0099¥ò\u0086Øg\u0016@f!X\u0016[ÉV¨!\u008b\u001djëMÓ,¯\foï\u0016Î0¡\u0004\u0080ìcÁB\u0094\"8\u0005\u0018änÇ?¦á\u0099Íx\u009fXg;X\u001a\"ý\bÜú¿ü\u009e\u0094~sQA0)\u0013\u0002òÛÕ©´Ô\u0094ewOV4\t\u0014èÎËöª\u0080\u008agm@L2/ï\u000eÝá±ÀÂ +\u0083Hb Eù$Ü\u0007¹æ\u0083Æa¹\u0003\u0098\f{üZÀ=¢\u001c\u0081üvß-¾\u0012\u0091ûpßSä\\»\u0083\u0091âôÁÇ !\u0007\nf`F÷¥\u0091\u0084øëÆÊ9)\u0003\bUh¨Oß®É\u008dÀì.Ó\u00112[\u0012«q\u0080\u0015\u000fÊ(«V\u0088Fi\u008cN¡/Ú\u000f\u0002ì#ÍD¢n\u0083\u0096`»Aç!-\u0006,çVÄi¥\u0097\u009a¯{ø\u0000gß@¾>\u009d<|í[Ê:ª\u001afùEØ\u001e·\u0017\u0096åuÊT\u00884e\u0013N\u0000pßM¾%\u009d\u0001|ñ\u000bÜÔûµ\u0085\u0096\u0087wFPo16\u0011ÝòáÓ\u009f¼¨\u009d@~I_/?Ð\u0018òù\u008eÚ¼\u00adúr\u0090\u0013Ö0éÑ\tö.\u0097\r·\u009dTºuÊ\u001aâ;\fØ&ù|\u0099\u0092¾ø_Ç|ç\u001d\u001d\"-Ã,ãÚ\u0000;ß\u0005Ë1\u0014<uKVw·\u0081\u0090¹ñÅÑ\u00052|\u0013Z|n]\u0086¾«\u009fþÿRØr9\u0004\u001aG{\u0087D§¥õ\u0085]æ.ÇH g\u0001\u008cbØC³£\u000b\u008c&íCÎa/ú\u0000\tßc¾%\u009d\u001a|ú[Ý:þ\u001awùGØ&·\u0017\u0096ùu\u0086TÁ\u0000 ßL¾$\u009dO|ò[Ð:²\u001afù\u0012Øml\u0090³\u009dÒêñÖ\u0010 7\u0018Vdv¤\u0095Ý´ûÛÏú'\u0019\n8_Xó\u007fÓ\u009e¥½ÃÜ?ã\u001f\u0002\u0011\"µA\u0095`à\u0087Â¦hÅtäZ\u0004¼+\u0087Jèi\u0080\u0000¯ßÕ¾¸\u009d\u0080|w[\u0016:=\u001aóùÝØ¤·\u009c\u0096quS%~ús\u009b\u001f¸2YË~é\u001f\u0094?R\u0000\tßc¾%\u009d\u001a|ú[Ý:þ\u001aDùGØ!·\u0016\u0096ñuÕT\u00924nêl5zT\u001aw5\u0096Å±êÐÀð\u001d\u001362S]l|\u0089\u009f¢¾ÿÞ\bùm\u0004~Ûpº\u0012\u00991xÂ_á>\u0087\u001e\u001eýgÜ\u0015³;\u0092ßqóP²0x\u0017yö\tÕ-´\u0087\u008b¢jéJL^õ\u0081øà\u008fÃ³\"E\u0005}d\u0001DÁ§¸\u0086\u009eéªÈB+o\n:j\u0096M¶¬À\u008f¡îOÑy0=\u0010ÚsûRÃµ¡\u0094C÷\u0016Ö>6ß\u0019àx\u0092[¢º~\u009d\u0012üzÜÙ?í\u001e\u0085A« `\u0083Xâ>ÂÊ%â\u0004\u008fgZF8\u0000EßH¾?\u009d\u0003|õ[Í:±\u001aqù\bØ.·\u001a\u0096òußT\u008a4&\u0013\u0006òpÑ3°ó\u008fÓn\u0081Nz-\u000e\f ë\u001bÊü©¬\u0088É\u0000/ßA¾/\u009d\u0019|»[È:»\u001anù]Ø\u0012·\u0002\u0096þuÌT\u0084íÕ2»SÕpã\u0091A¶0×K÷\u009a\u0014¹5ÒZü{B\u0098$¹zÙ\u008fþ´\u001fÈ<î]\u000eb!\u0083A£\u0094À±áÇ\u0006û'\u0003\u0000/ßA¾/\u009d\u0019|»[Ê:±\u001a`ùCØ(·\u0006\u0096¸uÛT\u00844h\u0013Rò4\u0000/ßA¾/\u009d\u0019|»[Ê:±\u001a`ùCØ(·\u0006\u0096¸uÍT\u00844k\u0013^ò4\u0000/ßV¾3\u009d\u001c|»[È:»\u001anù]Ø\u0012·\u0006\u0096åuÝT\u00824c\u001d\u0006Â\u007f£\u001a\u00805aÉFõ'\u009a\u0007\u0005ämÅ\rª9\u008b\u0091hùI¡)M\u000eaï&Ì1\u00adÒ\u0092ús¡SO0d\u0011%ö5×Ñ´\u0089\u0095»uBZG;\u000e\u00187ùäÞ\u0099¿í\u009fU|rýã\"\u008dCã`Õ\u0081w¦\u0017Çaç»\u0004»%æJÎk(A\u0080\u009eîÿ\u0080Ü¶=\u0014\u001at{\u0002[Ø¸Ø\u0099\u0096ö´×U4v[\u0081\u0084ïå\u0081Æ·'\u0015\u0000da\u001fAÎ¢í\u0083\u0086ì¨Í\u0016.p\u000f<oÜHã©\u0091\u008a·ëPÔt58\u0015Ã,åó\u009c\u0092ù±ÖP*w\u0016\u0016y6æÕ\u008eôî\u009bÚºrY\u001axB\u0018®?\u0083ÞéýË\u009c6£\u001aBBb§\u0001\u0081 ëÇíæ=\u0085f¤DDèk\u0088\nó²7mY\f7/\u0001Î£éÃ\u0088µ¨oKQj6\u0005\t$ê\u0000/ßA¾/\u009d\u0019|»[Û:\u00ad\u001awùOØ4·\u0000\u0096ø\u0000/ßA¾/\u009d\u0019|»[Û:\u00ad\u001awùEØ(·\u0015\u0096ù\u0000/ßA¾/\u009d\u0019|»[Û:\u00ad\u001awùGØ?·\u001b\u0096ò\u0000/ßA¾/\u009d\u0019|»[Û:\u00ad\u001awù^Ø ·\u0001\u0096ðµDj*\u000bD(rÉÐî°\u008fÆ¯\u001cL3mA\u0002x#\u0095À§áéê©5ÇT©w\u009f\u0096=±]Ð+ðñ\u0013ñ2¢]\u0099|t\u0000/ßA¾+\u009d\u001b|õ[\u0096:º\u001alù_Ø#·\u001e\u0096øuÝT\u00854u\u0013\u0004ò~Ñ\r°ø\u008f\u0090n\u0086Nz-Z\f8\u0000/ßH¾$\u009d\u001b|»[Î:·\u001amùLØ\"·\u0005\u0096äu\u0093T£4u\u0013_ò\u0003Ñ\u001d°û\u008fÍn\u0081Nm-h\f<ë\u0014Êù©§\u0088\u0095ào?\u0016^s}\\\u009cû»\u009dÚûú5\u0019\u00018nWWv¤\u0095Ó´ÒÔ?ó\u0018\u0012d1PP·oÐ\u008eÇ®9Í\u001bì<\u000b[*\u00adI÷h\u0097\u0088c§\u0012ÆfåN\u0004\u0086#÷BÏb>\u0081[ zÿN\u001e\u0096=á\\Ã|4\u009b\u0018ºCÙ¢ø\u0093\u0017ù6ïV3u\b\u0094z³µ\u0000rßJ¾d\u009d\u001f|æ[Ö:º\u001avùKØ9·\\\u0096úuÝT\u008f4s\u0013Mò1Ñ\u0016°î\u008fÊn\u0096Nl-\\\u0093\u0098L\u009f-û\u000eÉï&È\t©u\u0089µj\u0098Kü\u0000ußK¾!\u009d\u0001|û[Î:°\u0000cßM¾8\u009d\u0000|ù[Ð:«\u001an=Gâ\u007f\u0083Q *AÓfã\u0007\u008f'CÄ~å\f\u008ai«ÆHìi¢\tZ.}Ï\u0000:Ïåþ\u0084\u009c§®F\u0015a6\u0000\u0017\u0000gß@¾$\u009d\n|æ[Ð:½\u0000gß@¾$\u009d\n|æ[Ð:½\u001a\\ùPØu·D\u0000gß@¾$\u009d\n|æ[Ð:½\u001a\\ùPØu·D\u0096Èu\u008aTÕ\u001a\fÅ4¤\u001a\u0087af\u0098A¨ Ä\u0000\bã5ÂG\u00ad\"\u008c\u0084o\u00adNû.\u001d\t9\u0000sßA¾!Es\u009a^û)Ø\u00159ã\u001eÛ\u007f§_g\u0000AßU¾:\u009dO|Æ[Ì:°\u001awùAØ ·\u0017\u0096·uÚT\u008e4t\u0013\u000bò\u0013Ñ\u001d°è\u008fÐn\u0089Nl\u0000AßK¾.\u009d\u001d|û[Ð:º\u001a#ù{Ø\t·9\u0096·uÞT\u00944o\u0013Gò$ÑU°ü\u008fÐn\u0096N)-V\fkëNä\u009f;\u0095ZðyÃ\u0098%¿\u000eÞdþý\u001d¥<×Sçri\u0091\u0000°JÐ±÷\u0099\u0016ú5\u008bT\"k\u000e\u008aHª÷É\u0088èµ\u000f\u0090.\u001cM*l\r\u0000rßJ¾d\u009d\u0007|õ[Ë:º\u001atùIØ?·\u0017\u0000gßJ¾&\u009d\u000b|ò[Ð:\u00ad\u001ak\u0084ú[Ë:©\u0019\u009bø ß\u0003\u0000rßD¾$\u009d\f|ü[Ìnø±ÀÐîó\u0095\u0012l5\\T0tü\u0097Á¶³ÙÖø\u007f\u001bD:\nZâ}Å\u0000rßJ¾d\u009d\u0004|ñ[Ë:°\u001afùDØc·\u0003\u0096òuÑT\u0094\u00001\u0000rßJ¾d\u009d\u001c|ñ[Ú:«\u001aqùM\u00000\u0000rßJ¾d\u009d\r|á[Ð:²\u001agù\u0006Ø=·\u0000\u0096øuØT\u00944e\u0013_Ýö\u0002Àc¶@\u0093¡[\u0086QçvÇ¥\u0000rßJ¾d\u009d\r|á[Ð:²\u001agù\u0006Ø+·\u001b\u0096ùuÛT\u00844t\u0013[ò\"Ñ\u001c°ô\u008fË\u0000gß@¾$\u009d\n|æ[Ð:½\u001a,ù[Ø)·\u0019\u0096¸uÛT\u00844h\u0013Nò\"Ñ\u001c°ù\u0000gß@¾$\u009d\n|æ[Ð:½\u001a\\ùPØu·D\u0096¸uÏT\u00854m\u0013tò(ÑM°¬\u008f\u0090n\u0083Nl-@\f6ë\nÊô©¡\u0088¸htG\t&`¥Îzé\u001b\u008d8£ÙOþy\u009f\u0014¿\u0085\\æ}\u008b\u0012´3YÐyñ-\u0091ð¶ñW\u009dt·\u0015\u001c*qË(ëÎ\u0088â©\u0088N¸oWáQ>v_\u0012|<\u009dÐºæÛ\u008bû\u001a\u0018h9\u0019V+wÙ\u0094²µáÕ@ò2\u0013\u00100!QÃnñ\u008fê¯\tÌhb©½\u0084ÜëÿÆ\u001e69\u0012X?x¾\u009b\u0082ºèÕãô>\u0017\u00026GV§q\u008b\u0090û³äÒ,íI\f\u001c,èO\u0087nø\u0089Ø¨6Ë~ê@\n¡% Dàg\u008d\u0086Xÿ¯ \u0097A¹bÐ\u0083&¤\u000bÅwå²\u0006\u009a'ñHËi/\u008a\u0013\u0000rßJ¾d\u009d\r|û[Ö:ª\u001ajùEØ,·\u0015\u0096òu\u0092T\u00834s\u0013Bò<Ñ\u0011°´\u008fÙn\u008dNg-I\f6ë\nÊí©°\u0088\u008ehbGEío2eS\u0000p3\u0091Õ¶þ×\u0094÷\u0000\u0014~5[Zj\u0080\u000e_6>\u0018\u001dqü\u009dÛ¬ºÎ\u009a\u001byzXU7g\u0016\u0098õ°Ôñ´\u001b\u0093.r\u0002Q`0\u0082\u0000tß@¾9\u009d\u001b|¹\u0005\u009dÚ¿»×\u0098ïyN^>?\\\u001f\u0094üòÝÈ²ã\u0093\u000ep=Q81\u0082\u0016\u00ad÷ËÔñµ\u001dt?«\u000eÊiéT\bô/\u009fNçnc\u008d\u000b¬bÃUâ·\u0001\u0099 Ê@1g\u0016Hd\u0097Uö2Õ\u000f4¯\u0013ßr\u00adR8±[\u00909ÿ\fÞç=ö\u001c\u0097|r[Sº \u0099\u0012øî\u0000qß@¾'\u009d\u001a|º[Ê:¸\u001a-ùDØ.·\u0016\u0096ÈuØT\u00844h\u0013Xò9Ñ\u0001°ã\u0000rßJ¾d\u009d\u0004|ñ[Ë:°\u001afùDØc·\u0013\u0096ùuØT\u00934i\u0013Bò4Ñ[°ë\u008fÚn\u0089N|-J\u0000rßJ¾d\u009d\r|û[Ö:ª\u001a-ùYØ(·\u001f\u0096âu\u0092T\u00804p\u0013Oò\u000fÑ\u001b°û\u008fÒn\u0081\u0010lÏT®z\u008d\u001elîKÊ*î\n\u007féCÈ:§\u0000\u0086íe\u008cD\u0099$q\u0003[â)Á\u000e ö\u009fÑ~\u0088^~=^\u001c9\u0000rßJ¾d\u009d\u001f|æ[Ö:º\u001avùKØ9·\\\u0096õuÉT\u00884j\u0013Oò~Ñ\u0013°ó\u008fÑn\u0083Nl-\\\f#ë\nÊô©¬\u0088\u0093\u0000rßJ¾d\u009d\u001c|í[Ê:ª\u001afùEØc·\u0010\u0096âuÕT\u008d4b\u0013\u0005ò6Ñ\u001c°ô\u008fØn\u0081N{-^\f!ë\u0011Êó©¶\u0000rßJ¾d\u009d\u001c|í[Ê:ª\u001afùEØ\u0012·\u0017\u0096ïuÈTÏ4d\u0013^ò9Ñ\u0019°þ\u008f\u0091n\u0082N`-@\f4ë\u001dÊï©²\u0088\u0095heG_&\"\u0000rßJ¾d\u009d\u0019|ñ[×:º\u001alùZØc·\u0010\u0096âuÕT\u008d4b\u0013\u0005ò6Ñ\u001c°ô\u008fØn\u0081N{-^\f!ë\u0011Êó©¶ÕR\njkDH9©Ñ\u008e÷ï\u009aÏL,z\r2b6CÛ ÷\u0081¬á\bÆi'\u0005\u0004<eÖZû»ê\u009bOøgÙ\u001d>?\u001fØ|\u0090]·½^\u0092xó\u0018Ð/\u0000gß@¾>\u009d#|ý[×:»\u001a2ùfØ8·\u001f\u0096õuÙT\u0093\u00001ß\u0010¾\u007f\u009dZ|¡[\u008b:ï\u001a6ù\u001dØx·F\u00001ß\u0010¾\u007f\u009dZ|¡[\u008b:ï\u001a6ù\u001dØx·Dº\u0000e!\u0004N'kÆ\u0090áº\u0080Þ \u0007C,bI\r{i\u009b¶º×Õôð\u0015\u000b2!SEs\u009c\u0090·±ÑÞè\u0005ÅÚä»\u008b\u0098®yU^\u007f?\u001b\u001fÂüéÝ\u008f²´\u00001ß\u0010¾\u007f\u009dZ|¡[\u008b:ï\u001a6ù\u001dØ{·F\u0092LMm,\u0002\u000f'îÜÉö¨\u0092\u0088Kk`J\u0006%9\u00001ß\u0010¾\u007f\u009dZ|¡[\u008b:ï\u001a6ù\u001dØ{·J\u0013,Ì\r\u00adb\u008eGo¼H\u0096)ò\t+ê\u0000Ëg¤_\u0017\u0006È'©H\u008amk\u0096L¼-Ø\r\u0001î*ÏM w¤´{\u0095\u001aú9ßØ$ÿ\u000e\u009ej¾³]\u0098|ÿ\u0013Ã\u00001ß\u0010¾\u007f\u009dZ|¡[\u008b:ï\u001a6ù\u001dØz·D¤Å{ä\u001a\u008b9®ØUÿ\u007f\u009e\u001b¾Â]é|\u008e\u0013¾äâ;ÃZ¬y\u0089\u0098r¿XÞ<þå\u001dÎ<¦S\u0091\u00001ß\u0010¾\u007f\u009dZ|¡[\u008b:ï\u001a6ù\u001dØu·@\u00001ß\u0010¾\u007f\u009dZ|¡[\u008b:ï\u001a6ù\u001dØu·F\u0000gß@¾>\u009d!|ñ[Í:©\u001alùZØ&·=\u0096çuÙT\u00934g\u0013_ò?Ñ\u0007°Ô\u008fÞn\u0089Nl\u009b\u001eD\u0014%q\u0006Bç¤À\u008f¡å\u00008ß\u001c¾z\u009d^| [\u0088:î\u001a0ù\u001aØ|·C\u0096¦u\u008dTÙ43\u0013\u001aò`ÑB°¨\u008f\u008fÅ\u009f\u001a¸{ÆXÄ¹\u0019\u009e#ÿUß\u0098<¢\u001dÜrèS\n°6\u0091Pñ\u009a¢S}t\u001c\u001a?=ÞÂùé\u0098\u008e¸S[xz\u001d\u0015\"4Ç×ìö±\u0096V\u0000gß@¾>\u009d+|ñ[Ï:·\u001a`ùMØ\u0004·\u0016\u00000ß\u0015¾z\u009d_|¤[\u0089:î\u001a3ù\u0018Ø}·B\u0096§u\u008cTÑ46gU¸'ÙKúg\u001b\u0097<º]Ü}\u0000\u009e-¿\u001fÐtñÂ\u0012é3·S\u0007t+\u00000ß\u0014¾x\u009d\\| [\u008c:è\u001a4ù\u0010Øt·C\u0096¥u\u008fTÕ43\u0000/ßU¾8\u009d\u0000|÷[\u0096:·\u001alùXØ\"·\u0000\u0096ãuÏ\u00000ßC¾,\u009dO|®\u0000/ßU¾8\u009d\u0000|÷[\u0096:\u00ad\u001afùDØ+·]\u0096úuÝT\u00914uÙ-\u0006\u001dgaDI¥²\u0082\u009cã÷Ãg \u0005\u0001hnTO¹¬\u0090\u008dÂí?Ê\t+4\bLi¿Å\u009e\u001a¾{ÚXÚ¹*\u009e\u000eÿ\u007fß®<¸\u001dÌrôSK°=\u0091|ïl0\u0003Q}rO\u0093ø´\u0097Õøõ$\u0016\u00027oXny·\u009a\u0090»ÆÛ ü\u000b\u001d`>\u0018_¡`\u0091\u0081Ë³Álê\r\u009c.©ÏDèn\u0089\u001c©ÃJàk\u009d\u0000/ß@¾>\u009d\f|»[Ô:±\u001avùFØ9·\u0001?\fà=\u0081_¢mC\u009dd¥\u0000/ßA¾+\u009d\u001b|õ[\u0096:º\u001alù_Ø#·\u001e\u0096øuÝT\u00854u\u0013\u0004ò~Ñ\u0011°ê\u008f\u0090n\u0085Ny-^\f ëVÊå©¯\u0088\u008b".getBytes(InternalZipConstants.AES_HASH_CHARSET)).asCharBuffer().get(cArr, 0, 2256);
        f3072F = cArr;
        f3074L = -6227568207689228507L;
        String strM2017I = m2017I(TextUtils.lastIndexOf("", '0', 0) + 9, 1093 - TextUtils.getOffsetAfter("", 0), (char) (17686 - (KeyEvent.getMaxKeyCode() >> 16)));
        String[] strArr = {m2017I(14 - (ViewConfiguration.getTapTimeout() >> 16), 574 - TextUtils.lastIndexOf("", '0', 0), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), m2017I(View.getDefaultSize(0, 0) + 26, 588 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (60922 - (ViewConfiguration.getJumpTapTimeout() >> 16))), m2017I(Color.rgb(0, 0, 0) + 16777233, 615 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getScrollBarSize() >> 8)), m2017I(Color.rgb(0, 0, 0) + 16777233, 632 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (AndroidCharacter.getMirror('0') - '0')), m2017I('?' - AndroidCharacter.getMirror('0'), 649 - View.getDefaultSize(0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16)), m2017I((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 37, 665 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ExpandableListView.getPackedPositionGroup(0L) + 7465))};
        f3076V = strArr;
        String[] strArr2 = {m2017I(Color.red(0) + 12, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + TypedValues.TransitionType.TYPE_FROM, (char) (64972 - Color.alpha(0))), m2017I(13 - (KeyEvent.getMaxKeyCode() >> 16), 713 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (TextUtils.indexOf("", "", 0) + 16815)), m2017I(TextUtils.indexOf("", "", 0, 0) + 22, 726 - KeyEvent.normalizeMetaState(0), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 23470)), m2017I((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 31, 748 - KeyEvent.normalizeMetaState(0), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 11466)), m2017I(11 - TextUtils.lastIndexOf("", '0', 0), 780 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 45592)), m2017I(TextUtils.getOffsetBefore("", 0) + 12, 791 - View.resolveSizeAndState(0, 0, 0), (char) Color.green(0)), m2017I(Drawable.resolveOpacity(0, 0) + 12, 803 - TextUtils.getTrimmedLength(""), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), m2017I(12 - TextUtils.getTrimmedLength(""), (ViewConfiguration.getJumpTapTimeout() >> 16) + 815, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1)), m2017I(KeyEvent.getDeadChar(0, 0) + 12, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 826, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), m2017I(14 - ((Process.getThreadPriority(0) + 20) >> 6), ExpandableListView.getPackedPositionType(0L) + 839, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 46444)), m2017I(11 - TextUtils.indexOf((CharSequence) "", '0', 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 853, (char) (60038 - KeyEvent.getDeadChar(0, 0))), m2017I(TextUtils.indexOf("", "") + 24, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 865, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), m2017I(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 29, 889 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))};
        f3077Z = strArr2;
        String[] strArr3 = (String[]) Arrays.copyOf(strArr, strArr.length + strArr2.length);
        f3069B = strArr3;
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        f3073I = new String[]{m2017I((ViewConfiguration.getWindowTouchSlop() >> 8) + 53, 917 - (Process.myPid() >> 22), (char) (ExpandableListView.getPackedPositionGroup(0L) + 57408))};
        Code = new Code[]{new Code(m2017I((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 22, (ViewConfiguration.getTapTimeout() >> 16) + 970, (char) View.MeasureSpec.makeMeasureSpec(0, 0)), m2017I((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 10, 992 - TextUtils.lastIndexOf("", '0'), (char) (37856 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)))), m2017I(7 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 1003 - ExpandableListView.getPackedPositionType(0L), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), m2017I(8 - TextUtils.indexOf("", "", 0), 1010 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))), new Code(m2017I(17 - (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getLongPressTimeout() >> 16) + PointerIconCompat.TYPE_ZOOM_IN, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 15668)), m2017I(7 - (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 1035, (char) (Color.alpha(0) + 15033)), m2017I(TextUtils.getOffsetAfter("", 0) + 7, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1041, (char) ((-16777216) - Color.rgb(0, 0, 0))), m2017I(11 - (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1049, (char) ExpandableListView.getPackedPositionGroup(0L)), m2017I(AndroidCharacter.getMirror('0') - '\"', (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1060, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))), new Code(m2017I(16 - (ViewConfiguration.getTouchSlop() >> 8), 1074 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 6782)), m2017I(3 - TextUtils.indexOf("", ""), ImageFormat.getBitsPerPixel(0) + 1091, (char) (ViewConfiguration.getScrollBarSize() >> 8)), strM2017I, m2017I((-16777194) - Color.rgb(0, 0, 0), 1101 - TextUtils.indexOf("", "", 0, 0), (char) View.MeasureSpec.getMode(0)), m2017I((ViewConfiguration.getTapTimeout() >> 16) + 25, ExpandableListView.getPackedPositionChild(0L) + 1124, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1)), m2017I(29 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 1148 - View.resolveSizeAndState(0, 0, 0), (char) (58590 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)))), new Code(m2017I(11 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 1175 - Process.getGidForName(""), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1)), m2017I((ViewConfiguration.getScrollDefaultDelay() >> 16) + 8, TextUtils.indexOf((CharSequence) "", '0') + 1188, (char) View.combineMeasuredStates(0, 0)), m2017I((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 5, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1194, (char) (33932 - View.combineMeasuredStates(0, 0))), m2017I((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 6, 1201 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0))), new Code(m2017I((ViewConfiguration.getScrollDefaultDelay() >> 16) + 16, 1207 - View.resolveSize(0, 0), (char) (Color.argb(0, 0, 0, 0) + 28298)), m2017I(7 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 1043 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) View.resolveSize(0, 0)), m2017I(8 - TextUtils.indexOf("", ""), 1010 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (AndroidCharacter.getMirror('0') - '0'))), new Code(m2017I(15 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1223, (char) KeyEvent.normalizeMetaState(0)), m2017I(1 - TextUtils.indexOf("", ""), 1237 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) Color.blue(0))), new Code(m2017I((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 9, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1238, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)))), m2017I(-TextUtils.lastIndexOf("", '0', 0), Drawable.resolveOpacity(0, 0) + 1247, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))), new Code(m2017I((ViewConfiguration.getScrollBarSize() >> 8) + 16, 1248 - (Process.myPid() >> 22), (char) View.resolveSizeAndState(0, 0, 0)), m2017I(4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), TextUtils.indexOf("", "") + 1090, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), m2017I(7 - (Process.myPid() >> 22), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + FirmwareInstallationState.Error.ERROR_POSTVALIDATION, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 15033)), m2017I(Color.alpha(0) + 8, TextUtils.indexOf((CharSequence) "", '0', 0) + 1265, (char) (56720 - (ViewConfiguration.getTouchSlop() >> 8))), m2017I(Drawable.resolveOpacity(0, 0) + 11, 1049 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) TextUtils.getOffsetAfter("", 0)), m2017I(14 - Drawable.resolveOpacity(0, 0), 1060 - Color.argb(0, 0, 0, 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))), new Code(m2017I(TextUtils.indexOf("", "", 0) + 20, View.MeasureSpec.makeMeasureSpec(0, 0) + 1272, (char) Color.alpha(0)), m2017I(19 - (ViewConfiguration.getEdgeSlop() >> 16), AndroidCharacter.getMirror('0') + 1244, (char) KeyEvent.normalizeMetaState(0)), m2017I(31 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 1310 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask()))), m2017I(TextUtils.indexOf("", "", 0) + 26, View.MeasureSpec.getSize(0) + 1342, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 42409)), m2017I(TextUtils.getOffsetBefore("", 0) + 23, TextUtils.getCapsMode("", 0, 0) + 1368, (char) (View.MeasureSpec.getSize(0) + 57654)), m2017I(32 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (-16775825) - Color.rgb(0, 0, 0), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 25294)), strM2017I), new Code(m2017I(TextUtils.getOffsetBefore("", 0) + 13, ExpandableListView.getPackedPositionType(0L) + 1424, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 65502)), m2017I(7 - TextUtils.getCapsMode("", 0, 0), 1003 - Color.green(0), (char) (Process.myPid() >> 22))), new Code(m2017I(30 - Color.alpha(0), TextUtils.indexOf("", "") + 1437, (char) Drawable.resolveOpacity(0, 0)), m2017I(Color.blue(0) + 11, (ViewConfiguration.getJumpTapTimeout() >> 16) + 1467, (char) (60718 - View.MeasureSpec.makeMeasureSpec(0, 0)))), new Code(m2017I(20 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 1478 - KeyEvent.normalizeMetaState(0), (char) (32892 - ExpandableListView.getPackedPositionType(0L))), m2017I(TextUtils.lastIndexOf("", '0') + 6, 1497 - KeyEvent.getDeadChar(0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))), new Code(m2017I((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 19, Color.argb(0, 0, 0, 0) + 1502, (char) (1524 - (ViewConfiguration.getWindowTouchSlop() >> 8)))), new Code(m2017I(16 - ExpandableListView.getPackedPositionType(0L), 1521 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (29773 - ExpandableListView.getPackedPositionChild(0L)))), new Code(m2017I(19 - Color.green(0), Color.alpha(0) + 1537, (char) (18453 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)))), new Code(m2017I(19 - (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 1556, (char) (ImageFormat.getBitsPerPixel(0) + 1))), new Code(m2017I(23 - View.combineMeasuredStates(0, 0), 1575 - ExpandableListView.getPackedPositionGroup(0L), (char) ExpandableListView.getPackedPositionType(0L))), new Code(m2017I(21 - TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getPressedStateDuration() >> 16) + 1598, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))), new Code(m2017I(23 - TextUtils.lastIndexOf("", '0', 0, 0), View.getDefaultSize(0, 0) + 1619, (char) (4125 - ImageFormat.getBitsPerPixel(0))), strM2017I), new Code(m2017I((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 28, 1643 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), strM2017I), new Code(m2017I(27 - View.MeasureSpec.getMode(0), 1671 - (Process.myTid() >> 22), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16)), strM2017I), new Code(m2017I(30 - TextUtils.indexOf((CharSequence) "", '0'), 1698 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (Process.myTid() >> 22)), strM2017I), new Code(m2017I(27 - View.MeasureSpec.makeMeasureSpec(0, 0), 1729 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16)), strM2017I), new Code(m2017I(32 - Color.blue(0), 1756 - View.resolveSizeAndState(0, 0, 0), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 54560)), strM2017I)};
        f3070C = new Code[]{new Code(m2017I(TextUtils.lastIndexOf("", '0', 0, 0) + 15, 1788 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ExpandableListView.getPackedPositionChild(0L) + 1)), m2017I(11 - View.MeasureSpec.getSize(0), 1802 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) Drawable.resolveOpacity(0, 0)), m2017I(View.resolveSizeAndState(0, 0, 0) + 11, 1812 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ExpandableListView.getPackedPositionType(0L)), m2017I(12 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 1824 - (KeyEvent.getMaxKeyCode() >> 16), (char) (47665 - TextUtils.getOffsetAfter("", 0))), m2017I(12 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1835, (char) (View.MeasureSpec.getMode(0) + 27050)), m2017I(11 - Color.alpha(0), AndroidCharacter.getMirror('0') + 1798, (char) (1524 - (ViewConfiguration.getMaximumFlingVelocity() >> 16))), m2017I(11 - Color.green(0), 1857 - View.MeasureSpec.getSize(0), (char) ('0' - AndroidCharacter.getMirror('0'))), m2017I(11 - View.MeasureSpec.getSize(0), 1868 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (37501 - (ViewConfiguration.getScrollBarSize() >> 8))), m2017I((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 10, (ViewConfiguration.getJumpTapTimeout() >> 16) + 1879, (char) TextUtils.getOffsetBefore("", 0)), m2017I(Color.rgb(0, 0, 0) + 16777227, View.MeasureSpec.makeMeasureSpec(0, 0) + 1890, (char) (4892 - ExpandableListView.getPackedPositionChild(0L))), m2017I(11 - (Process.myTid() >> 22), 1901 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (5943 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))), m2017I(11 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 1912, (char) (Color.blue(0) + 42117)), m2017I(12 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 1922 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16)), m2017I(11 - TextUtils.indexOf("", "", 0, 0), 1935 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (TextUtils.getOffsetBefore("", 0) + 42228)), m2017I((ViewConfiguration.getFadingEdgeLength() >> 16) + 11, Color.rgb(0, 0, 0) + 16779161, (char) (58579 - (ViewConfiguration.getMinimumFlingVelocity() >> 16))), m2017I(TextUtils.indexOf("", "", 0) + 11, 1956 - TextUtils.getOffsetAfter("", 0), (char) Color.blue(0)), m2017I(((Process.getThreadPriority(0) + 20) >> 6) + 11, ExpandableListView.getPackedPositionChild(0L) + 1968, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))), new Code(m2017I(22 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 1978, (char) (ViewConfiguration.getFadingEdgeLength() >> 16)), m2017I(7 - Color.green(0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2000, (char) (39775 - View.getDefaultSize(0, 0)))), new Code(m2017I((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, 295 - ExpandableListView.getPackedPositionGroup(0L), (char) (3004 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))), m2017I(((Process.getThreadPriority(0) + 20) >> 6) + 20, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2006, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))), new Code(m2017I(14 - Process.getGidForName(""), (-16775189) - Color.rgb(0, 0, 0), (char) (KeyEvent.normalizeMetaState(0) + 50680)), m2017I(16 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), TextUtils.indexOf("", "") + 2042, (char) (41568 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))), new Code(m2017I(Color.alpha(0) + 11, 2057 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) Color.red(0)), m2017I(TextUtils.indexOf("", "", 0, 0) + 15, 2068 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), m2017I(TextUtils.indexOf((CharSequence) "", '0', 0) + 17, 2083 - Color.red(0), (char) (Color.red(0) + 26416)), m2017I(15 - (Process.myTid() >> 22), 2099 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (Process.getGidForName("") + 1)))};
        f3075S = new Code[]{new Code(m2017I((ViewConfiguration.getTouchSlop() >> 8) + 13, TextUtils.lastIndexOf("", '0') + 2115, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16)), m2017I(View.MeasureSpec.makeMeasureSpec(0, 0) + 5, (ViewConfiguration.getScrollBarSize() >> 8) + 2127, (char) View.getDefaultSize(0, 0))), new Code(m2017I(View.combineMeasuredStates(0, 0) + 15, 2132 - TextUtils.getCapsMode("", 0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6)), m2017I((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 18, TextUtils.getOffsetBefore("", 0) + 2147, (char) (55626 - (ViewConfiguration.getDoubleTapTimeout() >> 16))), m2017I(TextUtils.lastIndexOf("", '0', 0) + 15, 2167 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (50674 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)))), new Code(m2017I(KeyEvent.getDeadChar(0, 0) + 21, 2180 - TextUtils.getTrimmedLength(""), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 61251)), m2017I(Color.red(0) + 10, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2200, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 45987))), new Code(m2017I(11 - (ViewConfiguration.getPressedStateDuration() >> 16), 2210 - TextUtils.indexOf((CharSequence) "", '0'), (char) ExpandableListView.getPackedPositionGroup(0L)), m2017I(AndroidCharacter.getMirror('0') - '*', Color.alpha(0) + 2222, (char) (16250 - TextUtils.indexOf("", "")))), new Code(m2017I(AndroidCharacter.getMirror('0') - 20, 2228 - Drawable.resolveOpacity(0, 0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), m2017I(10 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 2200 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (45988 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)))))};
        f3071D = new C2210cx.Z();
        int i = f3079d + 31;
        f3078c = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }
}
