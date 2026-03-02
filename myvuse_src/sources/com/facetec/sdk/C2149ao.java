package com.facetec.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.zxing.pdf417.PDF417Common;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.facetec.sdk.ao */
/* JADX INFO: loaded from: classes3.dex */
final class C2149ao implements ZoomEncryptStrings {

    /* JADX INFO: renamed from: C */
    private static long f2564C = 0;

    /* JADX INFO: renamed from: F */
    private static char[] f2565F = null;

    /* JADX INFO: renamed from: S */
    private static int f2566S = 0;

    /* JADX INFO: renamed from: d */
    private static int f2567d = 1;

    /* JADX INFO: renamed from: B */
    private final String[] f2568B;

    /* JADX INFO: renamed from: D */
    private final String[] f2569D;

    /* JADX INFO: renamed from: L */
    private final String[] f2571L;

    /* JADX INFO: renamed from: V */
    private final Context f2572V;
    private boolean Code = false;

    /* JADX INFO: renamed from: Z */
    boolean f2573Z = false;

    /* JADX INFO: renamed from: I */
    String f2570I = "";

    static {
        char[] cArr = new char[1262];
        ByteBuffer.wrap("\u0000c\u0000\u0084\u0001»\u0002ï\u0000o\u0000\u0099\u0001±\u0002ï\u0000c\u0000\u0084\u0001»\u0002ï\u0003Â\u0004ø\u0005ñ\u0006\u0005\u0007-\b%\tA\nl\u000b*\u000b\u008e\f´\r¡\u000eÂ\u000fô\u0010ï\u0011\u0015\u0012r\u00134\u0014G\u0000c\u0000\u0084\u0001»\u0002ï\u0003Â\u0004ø\u0005ñ\u0006\u0005\u0007-\b%\tA\nl\u000b*\u000b\u008e\f´\r¡\u000eÂ\u000fô\u0010ï\u0011\u0015\u0012r\u00134\u0014G\u00153\u0016m\u0016\u009f\u0017·\u0018½\u0019ÑÛ\u008aÛqÚ\u0017ÙMØ+ß\u0019Þ\u0004ÝìÜÑÓÅÒ³Ñ\u0093ÐÅÐs×@ÖZÕ:Ô\u0006Ë\u001aÊë\u009a°\u009aW\u009bh\u0098<\u0099\u0014\u009e+\u009f$\u009cÍ\u009dã\u0092ù\u0093\u0096\u0090®\u0091¢\u0091H\u0096}\u0097w\u0094M\u0095;\u008a \u008bÒ\u0088ê\u0089æ\u008e\u0094\u008f½\u008c¾\u008cR\bß\b8\t\u0007\nS\u000bd\fC\rW\u000e£\u000f\u0080\u0000\u008f\u0001ó\u0002×\u0003Ì\u0003*\u0004H\u0005\n\u0006y\u0007W\u0018_\u0019¿\u001a\u0095\u001b\u0088\u001cë\u001dÓgXg¿f\u0080eÔdîcÉbÕa:`\fo\u000fnpmQl\u0011l§k\u00944ó4\u00145+6\u007f7H0h1b2\u00973§<»=Ð>þ?á?Q8'94:G;b$e%\u008a&3&Ô'ë$¿%\u0097\"®#¼ Z!z.|/\u0011,=-z-Ô*ã+û(\u0087)¾6¥7D4~\u0000c\u0000\u0084\u0001»\u0002ï\u0003Ç\u0004þ\u0005ì\u0006\n\u00077\bm\t\\\nv\u000bk\u000b\u009bæsæ\u0094ç«äÿåÏâêã÷à\u0019á!î2ïRì`ízí\u0094êäëºèÎéîöõ÷\rô%õ4òIó\u007fðwð\u008cñºpjp\u008dq²ræsßtöuâv\u0015w$x:yLz>{\u007f{\u0089|¼}¸~\u0097\u007fõ`ãa\u0017b7c/dW\u0000c\u0000\u0084\u0001»\u0002ï\u0003Í\u0004û\u0005ç\u0006\u001d\u00070\b9\tO\np\u000bj\u000bÁ\f¼\r·\u000eÑ\u000fö\u0010ç\u0011\u0003\u00123\u0013(\u0014F5±5V4i7=6\u00151*0%3Ì2â=ø<\u0097?¯>£>I9|8v;L:;%;$Î'ã&ô!\u008e ®#½#D\"~\u0000c\u0000\u0084\u0001»\u0002ï\u0003Ç\u0004ø\u0005÷\u0006\u001e\u00070\b*\tE\n}\u000bq\u000b\u009b\f®\r¤\u000e\u009e\u000fé\u0010é\u0011\u001c\u00121\u0013&\u0014\\\u0015|\u0016o\u0016\u0096\u0017¬\u0018ç\u0019Ø\u001aö\u001bé\u001c\u0010\u001d\u000e\u001e8\u001fS\u0000c\u0000\u0084\u0001»\u0002ï\u0003È\u0004þ\u0005ï\u0006\u0002\u00076\b5\tG\n}\u000ba\u000b\u0080\fô\r©\u000eÅ\u000fø\u0010í\u0011\b\u0012,\u0013&\u0014F\u0015~\u0016`\u0016\u0096\u0017¬¿\u0014¿ó¾Ì½\u0098¼¸»\u0088º\u0090¹v¸_·A¶*µ@´\u001f´ù³Î²Ù±¾°\u009c¯\u0090®r\u00adH¬XCÝC:B\u0005AQ@`GHFQE·D\u0094K\u0092JùIÃH\u0094H0O\u0014N\u000bM\u007fLPSYR½Q\u0083P\u0097WøVÊUØU(&&&Á'þ$ª%\u009b\"³#ª L!o.i/\u0002,8-o-Ë*ï+ð(\u0084)«6¢7F4x5l2\u0003310#0Ó1ë>þ?\u009eöóö\u0014÷+ô\u007fõ]òióvð\u008fñ§þºÿÚü§ýâý\u001aú$û1øIùeæqçÏä®å¾âÎãáàñà\rá)îwïmìaí[ê\u0095ë\u0080è\u0099éÏÖÝ×ð×\u000eÔ\u001cÕ:Ò{ÓVÐlÑ\u009fÞ\u009dß¼ÜÏÝ\u009bÚÃÚ$Û?Ø\u000f'\u000f'è&×%\u0083$¡#\u0095\"\u008a!s [/F.&-[,\u001e,æ+Ø*Í)µ(\u00997\u008d635R4B322\u001d1\r1ñ0Õ?\u008b>\u0091=\u009d<§;i:|9e83\u0007!\u0006\f\u0006ò\u0005à\u0004Æ\u0003\u0087\u0002ª\u0001\u0090\u0000c\u000fa\u000e@\r3\fg\u000b0\u000bÂ\nÉ\töÅ!ÅÆÄùÇ\u00adÆ\u008dÁ½À¥ÃCÂjÍtÌ\u001fÏuÎ*ÎØÉûÈìË\u008bÊ©Õ¥ÔG×}ÖmÑ\u0015Ð-x^x¹y\u0086zÒ{ó|Æ}Þ~3\u007f\u000ep\u0013qrrVsMs³t\u008bu\u0088våwÇ\u0000o\u0000\u0099\u0001±\u0002ï\u0003Î\u0004û\u0005ã\u0006\u000e\u00073\b.\tO\nk\u000bp\u000bÁ\f·\r¤\u000eÂ\u000fð\u0010ã\u0011\u0005\u0000c\u0000\u0084\u0001»\u0002ï\u0003Í\u0004û\u0005î\u0006\u0004\u00076\b,\t@\n|\u000b*\u000b\u0089\f¨\r \u000eÕ\u0000c\u0000\u0084\u0001»\u0002ï\u0003Þ\u0004ò\u0005ò\u0006\u0002\u0007<\b1\tA\np\u000b`\u000bÁ\f»\rµ\u000eÀ·\u0086·p¶Xµ\u0006´&³\f²\u000e±á°Á¿Æ¾¦½\u0089¼\u009e¼(»[ºM¹:¸\u0019\u0000c\u0000\u0084\u0001»\u0002ï\u0003Î\u0004ö\u0005ñ\u0006\b\u00079\b3\t^\n\u007f\u000bq\u000b\u0083\f¶\rë\u000eÖ\u000fì\u0010â\u0000c\u0000\u0084\u0001»\u0002ï\u0003Ö\u0004ú\u0005ã\u0006\u001d\u0007(&f&\u0081'¾$ê%Í\"ä#© \u0005!<.4/@,y-u-\u0087*°+¤(\u009b)÷6í7\u00074-5#2[3t0h0\u0084\u0000o\u0000\u0099\u0001±\u0002ï\u0003Á\u0004ø\u0005à\u0006\u0004\u00074\b*\t]\nt\u000b*\u000b\u008e\f´\r¡\u000eÂ\u000fô\u0010ï\u0011\u0015\u0099\u0005\u0099â\u0098Ý\u009b\u0089\u009a«\u009d\u009f\u009c\u0080\u009fy\u009eQ\u0091L\u0090,\u0093Q\u0092\u0015\u0092ù\u0095\u0092\u0094Í\u0097³\u0096\u0089\u0089Î\u0088{\u008bU\u008aF\rÊ\r-\f\u0012\u000fF\u000ed\tP\bO\u000b¶\n\u009e\u0005\u0083\u0004ã\u0007\u009e\u0006Î\u0006'\u0001\u001e\u0000\t\u0003k\u0002S\u001d\u0001\u001c\u00ad\u001f\u0085\u001e\u008a\u0019ú\u0018À\u001bÄhTh¿iÏj\u009bkúlÄmÞn3o\u001b`\u0011a7bHcAc½d\u0088e\u0096fègÁ!ë!\f 3#g\"W%p$f'\u008a&¸)¸(Ó+¿*í*\t-6,?/W.z1j0×3±2«5Â4å7®7\u0016679/8];p:g=\u008fÊPÊ¦Ë\u008eÈÐÉþÎÍÏÒÌ%Í\u0004Â\u001dÃeÀ\bÁ^Á´Æ\u009dÇ\u008aÄàÅ×ÚÜÛ*ØMÙ\u0015ÞlßLÜVÜ«Ý\u0084Ò\u0084\u0000c\u0000\u0084\u0001»\u0002ï\u0003Ô\u0004ú\u0005í\u0006\t\u0007?\b\"\tC\n|\u0000c\u0000\u0084\u0001»\u0002ï\u0003Ï\u0004þ\u0005ê\u0006C\u0007?\b\"\tC\n|\u000b[\u000b\u008c\f³\r\u00ad^q^\u0096_©\\ý]ÝZí[ñX\rY&V4WOT%UzU\u008dR§S¦PÃQúNñO\u0011L:!î!\u0007 /#/\"I%E$!'\u008d&°)\u0091(\u008d+ý*ï*=-y,1/R.c1T0Ò3²2«5Ñ4ÏÔÎÔnÕVÖT×,\u0087_\u0087è\u0086ß\u0085Â\u0084¨\u0083\u0082\u0082\u009fÖ\u000eÖ¦×\u0098Ô\u0083ÕìÒÚû*û\u008cúºùªùBùâøÚûØú ýÕü\u0083ÿoþVñOð/ó[\u0000/\u0000\u008f\u0001·\u0002µ\u0003Í\u0004¸\u0005î\u0006\u0002\u0007;\b\"\tB\n6\u000bf\u000b\u0086\f´\rêõ\u001aõºô\u0082÷\u0080öøñ\u008dðÛó7ò\u000eý\u0017üwÿ\u0003þIþ¸ù\u0086ø\u009eûª5í5Z4v7j6\u00001z\u001ff\u001fÑ\u001eê\u001d§\u001c\u0087\u001b·\u001a¥\u0019\u000b\u009b2\u009b\u0085\u009a²\u0099¯\u0098Å\u009fï\u009eò\u009d_\u009c'\u00937\u0092]\u0091+ÇNÇùÆÎÅÓÄ¹Ã\u0093Â\u008eÁ#À[ÏKÎ!ÍWÌKÌëËÃÊÐÉþ\u000b%\u000b\u0092\n¥\t¸\bÒ\u000fø\u000eå\rH\f0\u0003 \u0002J\u0001<\u0000h\u0000\u0084\u0007¹\u0006£\u0005É\u0004ð\u001bê\u001a\u001e\u0019y\u0000/\u0000\u0098\u0001¯\u0002²\u0003Ø\u0004ò\u0005ï\u0006B\u0007+\b'\t\u0001\na\u000bf\u000b\u0086\f´\rê\u0000/\u0000\u0098\u0001¯\u0002²\u0003Ø\u0004ò\u0005ï\u0006B\u0007-\b0\t\\\n6\u000bs\u000b\u008a\f÷\r«\u000eÕ\u000fþ\u0010â\u0011\\\u0012.\u0013(\u0014]\u0015i\u0016'\u0084\u0010\u0084§\u0085\u0090\u0086\u008d\u0087ç\u0080Í\u0081Ð\u0082}\u0083\u001f\u008c\u001e\u008dx\u008eH\u008f\u00142\u00862!3\u001e0\u000b1m6[7\u0004°K°ë±Ó²Ñ³©´Üª\u0015ªµ«\u0089¨\u008d©¹\u009d±\u009d\u0006\u009c1\u009f,\u009eF\u0099l\u0098q\u009bÜ\u009a¤\u0095´\u0094Þ\u0000/\u0000\u0098\u0001¯\u0002²\u0003Ø\u0004ò\u0005ï\u0006B\u0007+\b!\tG\nwÀ©À\u001eÁ)Â4Ã^ÄtÅiÆÄÇ¦È§ÉÁÊñÝ\u0083Ý1Ü\u001fß\u0003ÞdÙTØ\\ÛîÚ\u0096Õ\u0086Ôì\u0000/\u0000\u0098\u0001´\u0002¨\u0003Âü\u0085ü$ý\bþ\bM\u0013Mþ\ti\t\u008e\bµ\u000b¬\nÛ\rø\u0000P\u0000ª\u0001\u0082\u0002\u0089)yÈÑ\u0000r\u0000\u0084\u0001ø\u0002¥\u0003É\u0004õ\u0005÷\u0006\n\u0007?\b\"\tL\nu\u000ba\u00001\u0000r\u0000\u0084\u0001ø\u0002²\u0003É\u0004ô\u0005÷\u0006\u001f\u0007=&4\u0000g\u0000\u008e\u0001¢\u0002±\u0003Þ\u0004ø\u0005ò\u0000\\\u0000ª«õ\u0000[}Ù\u0092\u0081\u0092h\u0093O\u0090C\u00914\u0005^ç]ôv\u0013æ\u0000r\u0000\u009c\u0000t\u0000\u008e\u0001¥\u0002µ\u0003\u0081\u0004ü\u0005ç\u0006\u0014\u0007+\u0087ã\u0087\u0017\u0086+\u00856\u0084P".getBytes(InternalZipConstants.AES_HASH_CHARSET)).asCharBuffer().get(cArr, 0, 1262);
        f2565F = cArr;
        f2564C = 5563090519153443051L;
    }

    C2149ao(Context context) {
        Code((char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.indexOf("", "", 0) + 4).intern();
        Code((char) KeyEvent.normalizeMetaState(0), 4 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 4).intern();
        this.f2568B = new String[]{Code((char) TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 8, 23 - KeyEvent.keyCodeFromString("")).intern(), Code((char) View.getDefaultSize(0, 0), Gravity.getAbsoluteGravity(0, 0) + 31, 29 - Gravity.getAbsoluteGravity(0, 0)).intern(), Code((char) (Color.blue(0) + 56303), ExpandableListView.getPackedPositionGroup(0L) + 60, 21 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern(), Code((char) (39635 - View.resolveSizeAndState(0, 0, 0)), (ViewConfiguration.getTouchSlop() >> 8) + 80, 26 - Color.blue(0)).intern(), Code((char) (ImageFormat.getBitsPerPixel(0) + 2237), TextUtils.getCapsMode("", 0, 0) + 106, 24 - TextUtils.indexOf("", "", 0, 0)).intern(), Code((char) (ExpandableListView.getPackedPositionGroup(0L) + 26427), (ViewConfiguration.getScrollBarSize() >> 8) + ISO7816Kt.INS_EXTERNAL_AUTHENTICATE, 15 - ((Process.getThreadPriority(0) + 20) >> 6)).intern(), Code((char) ((Process.myTid() >> 22) + 13456), MotionEvent.axisFromString("") + 146, 21 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), Code((char) (9808 - (ViewConfiguration.getJumpTapTimeout() >> 16)), 165 - View.MeasureSpec.getMode(0), (ViewConfiguration.getTapTimeout() >> 16) + 21).intern(), Code((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 185 - TextUtils.indexOf((CharSequence) "", '0'), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 15).intern(), Code((char) (58896 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), 200 - (ViewConfiguration.getJumpTapTimeout() >> 16), 27 - ExpandableListView.getPackedPositionType(0L)).intern(), Code((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 28680), 227 - (ViewConfiguration.getTapTimeout() >> 16), 23 - Gravity.getAbsoluteGravity(0, 0)).intern(), Code((char) (Process.myPid() >> 22), 250 - Color.argb(0, 0, 0, 0), 23 - (ViewConfiguration.getTapTimeout() >> 16)).intern(), Code((char) (Color.argb(0, 0, 0, 0) + 13778), 273 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 27 - ((Process.getThreadPriority(0) + 20) >> 6)).intern(), Code((char) TextUtils.indexOf("", ""), 300 - View.resolveSize(0, 0), ExpandableListView.getPackedPositionType(0L) + 35).intern(), Code((char) TextUtils.indexOf("", ""), 335 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 27 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern(), Code((char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 49014), (ViewConfiguration.getFadingEdgeLength() >> 16) + 362, ImageFormat.getBitsPerPixel(0) + 23).intern(), Code((char) (KeyEvent.normalizeMetaState(0) + 17342), MotionEvent.axisFromString("") + 385, 25 - TextUtils.lastIndexOf("", '0', 0, 0)).intern(), Code((char) (View.combineMeasuredStates(0, 0) + 9797), 410 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 28 - TextUtils.lastIndexOf("", '0')).intern(), Code((char) (63168 - AndroidCharacter.getMirror('0')), Color.red(0) + 439, 52 - Color.argb(0, 0, 0, 0)).intern(), Code((char) ((Process.myTid() >> 22) + 10092), Color.red(0) + 491, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 52).intern(), Code((char) (50498 - ((Process.getThreadPriority(0) + 20) >> 6)), 544 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), Color.alpha(0) + 24).intern(), Code((char) (30781 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), 567 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.indexOf("", "", 0) + 18).intern(), Code((char) ExpandableListView.getPackedPositionGroup(0L), ((Process.getThreadPriority(0) + 20) >> 6) + 585, TextUtils.indexOf((CharSequence) "", '0', 0) + 21).intern(), Code((char) (ViewConfiguration.getEdgeSlop() >> 16), 605 - TextUtils.indexOf("", "", 0, 0), 18 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), Code((char) (Color.rgb(0, 0, 0) + 16777216), 622 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 17 - View.resolveSize(0, 0)).intern(), Code((char) (47082 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 639, 18 - TextUtils.indexOf("", "")).intern(), Code((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 656 - TextUtils.indexOf((CharSequence) "", '0'), 20 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), Code((char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), 675 - TextUtils.indexOf((CharSequence) "", '0'), 9 - (ViewConfiguration.getTouchSlop() >> 8)).intern(), Code((char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 9733), View.resolveSizeAndState(0, 0, 0) + 685, Color.green(0) + 26).intern(), Code((char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), 710 - MotionEvent.axisFromString(""), TextUtils.indexOf((CharSequence) "", '0') + 21).intern(), Code((char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 39270), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 731, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 21).intern(), Code((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3497), 754 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), Color.rgb(0, 0, 0) + 16777241).intern(), Code((char) (26679 - (ViewConfiguration.getScrollBarSize() >> 8)), 778 - View.MeasureSpec.getSize(0), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), Code((char) (View.resolveSize(0, 0) + 8584), 796 - KeyEvent.keyCodeFromString(""), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 31).intern(), Code((char) (51823 - AndroidCharacter.getMirror('0')), 828 - Color.argb(0, 0, 0, 0), TextUtils.indexOf((CharSequence) "", '0') + 29).intern(), Code((char) (ViewConfiguration.getTapTimeout() >> 16), ((byte) KeyEvent.getModifierMetaStateMask()) + 857, 13 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))).intern(), Code((char) (ViewConfiguration.getTapTimeout() >> 16), View.getDefaultSize(0, 0) + 868, Color.red(0) + 16).intern(), Code((char) (MotionEvent.axisFromString("") + 24083), TextUtils.lastIndexOf("", '0') + 885, View.MeasureSpec.makeMeasureSpec(0, 0) + 21).intern(), Code((char) (TextUtils.indexOf("", "", 0, 0) + 8589), 905 - ExpandableListView.getPackedPositionGroup(0L), TextUtils.getCapsMode("", 0, 0) + 24).intern()};
        Code((char) (54497 - (Process.myPid() >> 22)), KeyEvent.keyCodeFromString("") + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 4).intern();
        Code((char) (34672 - TextUtils.indexOf("", "", 0, 0)), 935 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), TextUtils.getCapsMode("", 0, 0) + 7).intern();
        Code((char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 54817), KeyEvent.getDeadChar(0, 0) + 941, 7 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern();
        Code((char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 64261), 947 - KeyEvent.keyCodeFromString(""), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 3).intern();
        this.f2569D = new String[]{Code((char) (63853 - Color.green(0)), View.MeasureSpec.getSize(0) + 951, TextUtils.lastIndexOf("", '0', 0, 0) + 13).intern(), Code((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 963 - ((Process.getThreadPriority(0) + 20) >> 6), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 15).intern(), Code((char) (62774 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), ExpandableListView.getPackedPositionGroup(0L) + 979, 17 - TextUtils.getTrimmedLength("")).intern(), Code((char) (13762 - (KeyEvent.getMaxKeyCode() >> 16)), ExpandableListView.getPackedPositionType(0L) + 996, 6 - (KeyEvent.getMaxKeyCode() >> 16)).intern(), Code((char) ((Process.myPid() >> 22) + 8009), 1002 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 8 - (Process.myTid() >> 22)).intern(), Code((char) (View.getDefaultSize(0, 0) + 39709), 1011 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 13 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern(), Code((char) (51042 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 1023 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 17 - (ViewConfiguration.getScrollBarSize() >> 8)).intern(), Code((char) ((KeyEvent.getMaxKeyCode() >> 16) + 2826), ExpandableListView.getPackedPositionGroup(0L) + 1039, 21 - (ViewConfiguration.getTouchSlop() >> 8)).intern(), Code((char) (ViewConfiguration.getPressedStateDuration() >> 16), 1060 - (ViewConfiguration.getTapTimeout() >> 16), 16 - View.resolveSizeAndState(0, 0, 0)).intern(), Code((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1076, 24 - Process.getGidForName("")).intern(), Code((char) (KeyEvent.keyCodeFromString("") + 33855), 1101 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), View.MeasureSpec.getSize(0) + 13).intern(), Code((char) (KeyEvent.keyCodeFromString("") + 12969), 1114 - TextUtils.getOffsetBefore("", 0), 7 - (ViewConfiguration.getEdgeSlop() >> 16)).intern(), Code((char) (TextUtils.lastIndexOf("", '0') + 45157), TextUtils.getOffsetBefore("", 0) + 1121, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 5).intern(), Code((char) (View.resolveSize(0, 0) + 43578), 1127 - Color.alpha(0), 4 - Process.getGidForName("")).intern()};
        this.f2571L = new String[]{Code((char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 34672), View.resolveSizeAndState(0, 0, 0) + 934, 7 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern(), Code((char) (ExpandableListView.getPackedPositionChild(0L) + 40351), 1131 - MotionEvent.axisFromString(""), View.getDefaultSize(0, 0) + 11).intern(), Code((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.indexOf("", "", 0, 0) + 1143, 12 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), Code((char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49287), 1155 - (ViewConfiguration.getLongPressTimeout() >> 16), (-16777204) - Color.rgb(0, 0, 0)).intern(), Code((char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 56748), TextUtils.lastIndexOf("", '0', 0, 0) + 1168, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 12).intern(), Code((char) (ViewConfiguration.getLongPressTimeout() >> 16), 1178 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), (ViewConfiguration.getTapTimeout() >> 16) + 5).intern(), Code((char) (64682 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), 1183 - Color.green(0), 5 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern()};
        this.f2572V = context;
    }

    /* JADX INFO: renamed from: B */
    final void m1600B() {
        int i = 2 % 2;
        int i2 = f2566S + 89;
        f2567d = i2 % 128;
        int i3 = i2 % 2;
        if (this.Code) {
            return;
        }
        boolean z = true;
        this.Code = true;
        if (!m1599Z()) {
            int i4 = f2567d + 109;
            f2566S = i4 % 128;
            if (i4 % 2 != 0) {
                m1598V();
                throw null;
            }
            if (!m1598V() && !m1595B(Code((char) (KeyEvent.keyCodeFromString("") + 19808), 1187 - View.MeasureSpec.makeMeasureSpec(0, 0), View.getDefaultSize(0, 0) + 2).intern())) {
                int i5 = f2566S + 57;
                f2567d = i5 % 128;
                if (i5 % 2 != 0 ? !m1595B(Code((char) (MotionEvent.axisFromString("") + 2309), (ViewConfiguration.getWindowTouchSlop() >> 8) + 1189, View.MeasureSpec.getSize(0) + 6).intern()) : !m1595B(Code((char) (15896 - MotionEvent.axisFromString("")), 10721 - (ViewConfiguration.getWindowTouchSlop() << 69), 95 / View.MeasureSpec.getSize(0)).intern())) {
                    if (!Code()) {
                        int i6 = f2566S + 121;
                        f2567d = i6 % 128;
                        int i7 = i6 % 2;
                        if (!m1597I() && (!m1596F())) {
                            z = false;
                        }
                    }
                }
            }
        }
        this.f2573Z = z;
    }

    /* JADX INFO: renamed from: Z */
    private boolean m1599Z() {
        int i = 2 % 2;
        ArrayList arrayList = new ArrayList(Arrays.asList(this.f2568B));
        PackageManager packageManager = this.f2572V.getPackageManager();
        Iterator it2 = arrayList.iterator();
        int i2 = f2567d + 1;
        f2566S = i2 % 128;
        int i3 = i2 % 2;
        while (it2.hasNext()) {
            int i4 = f2566S + 49;
            f2567d = i4 % 128;
            try {
                if (i4 % 2 != 0) {
                    String str = (String) it2.next();
                    packageManager.getPackageInfo(str, 0);
                    this.f2570I = str;
                    return true;
                }
                String str2 = (String) it2.next();
                packageManager.getPackageInfo(str2, 0);
                this.f2570I = str2;
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00cd A[PHI: r8
      0x00cd: PHI (r8v6 java.lang.String) = (r8v5 java.lang.String), (r8v11 java.lang.String) binds: [B:17:0x00cb, B:14:0x00a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fa  */
    /* JADX INFO: renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m1595B(java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2149ao.m1595B(java.lang.String):boolean");
    }

    private boolean Code() {
        int i;
        int i2 = 2;
        int i3 = 2 % 2;
        HashMap map = new HashMap();
        map.put(Code((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), 1201 - TextUtils.indexOf("", ""), 13 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern(), Code((char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > 0.0d ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == 0.0d ? 0 : -1)), TextUtils.getOffsetAfter("", 0) + 1214, -TextUtils.lastIndexOf("", '0', 0, 0)).intern());
        map.put(Code((char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 1216 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 10 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), Code((char) (9731 - MotionEvent.axisFromString("")), 1224 - View.MeasureSpec.getSize(0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern());
        try {
            InputStream inputStream = Runtime.getRuntime().exec(Code((char) View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.getMode(0) + 1225, 7 - View.MeasureSpec.getMode(0)).intern()).getInputStream();
            if (inputStream == null) {
                return false;
            }
            String[] strArrSplit = new Scanner(inputStream).useDelimiter(Code((char) Color.blue(0), 1232 - View.getDefaultSize(0, 0), (ViewConfiguration.getEdgeSlop() >> 16) + 2).intern()).next().split(Code((char) (44031 - (ViewConfiguration.getTapTimeout() >> 16)), 1233 - TextUtils.indexOf((CharSequence) "", '0'), 1 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)).intern());
            int i4 = f2567d + 125;
            f2566S = i4 % 128;
            int i5 = i4 % 2;
            int length = strArrSplit.length;
            int i6 = 0;
            while (i6 < length) {
                String str = strArrSplit[i6];
                for (String str2 : map.keySet()) {
                    if (str.contains(str2)) {
                        String string = new StringBuilder().append(Code((char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1236, -TextUtils.indexOf((CharSequence) "", '0', 0)).intern()).append((String) map.get(str2)).append(Code((char) (32133 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 1235 - TextUtils.indexOf((CharSequence) "", '0', 0), 1 - View.MeasureSpec.getMode(0)).intern()).toString();
                        if (str.contains(string)) {
                            this.f2570I = string;
                            int i7 = f2567d + 35;
                            f2566S = i7 % 128;
                            if (i7 % 2 != 0) {
                                int i8 = 3 / 0;
                            }
                            return true;
                        }
                        i = 2;
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
                i6++;
                int i9 = f2566S + ModuleDescriptor.MODULE_VERSION;
                f2567d = i9 % 128;
                int i10 = i9 % i2;
            }
            return false;
        } catch (IOException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: I */
    private boolean m1597I() {
        String[] strArrSplit;
        String str;
        long j;
        String str2 = "";
        int i = 2;
        int i2 = 2 % 2;
        int i3 = 0;
        try {
            long j2 = 0;
            int i4 = 6;
            InputStream inputStream = Runtime.getRuntime().exec(Code((char) (ExpandableListView.getPackedPositionType(0L) + 37612), 1237 - Color.red(0), ((Process.getThreadPriority(0) + 20) >> 6) + 5).intern()).getInputStream();
            if (inputStream == null) {
                return false;
            }
            int i5 = 1;
            String[] strArrSplit2 = new Scanner(inputStream).useDelimiter(Code((char) ((-1) - TextUtils.lastIndexOf("", '0')), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1231, 2 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern()).next().split(Code((char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 44031), 1234 - (ViewConfiguration.getFadingEdgeLength() >> 16), 1 - KeyEvent.getDeadChar(0, 0)).intern());
            int i6 = Build.VERSION.SDK_INT;
            int length = strArrSplit2.length;
            int i7 = f2567d + 43;
            f2566S = i7 % 128;
            int i8 = 4;
            if (i7 % 2 != 0) {
                int i9 = 5 / 4;
            }
            int i10 = 0;
            while (i10 < length) {
                int i11 = f2567d + 3;
                f2566S = i11 % 128;
                if (i11 % i != 0) {
                    strArrSplit = strArrSplit2[i10].split(Code((char) ((ExpandableListView.getPackedPositionForChild(i5, i3) > 1L ? 1 : (ExpandableListView.getPackedPositionForChild(i5, i3) == 1L ? 0 : -1)) + 8874), 7614 % (ViewConfiguration.getDoubleTapTimeout() % 32), (SystemClock.elapsedRealtimeNanos() > 1L ? 1 : (SystemClock.elapsedRealtimeNanos() == 1L ? 0 : -1))).intern());
                    if (i6 > 126 || strArrSplit.length >= i8) {
                    }
                    i10++;
                    i5 = 1;
                    j2 = j2;
                    str2 = str2;
                    i = 2;
                    i3 = 0;
                    i4 = 6;
                    i8 = 4;
                } else {
                    strArrSplit = strArrSplit2[i10].split(Code((char) (1405 - (ExpandableListView.getPackedPositionForChild(i3, i3) > j2 ? 1 : (ExpandableListView.getPackedPositionForChild(i3, i3) == j2 ? 0 : -1))), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1242, (SystemClock.elapsedRealtimeNanos() > j2 ? 1 : (SystemClock.elapsedRealtimeNanos() == j2 ? 0 : -1))).intern());
                }
                if (strArrSplit.length >= i4) {
                    String str3 = strArrSplit[i];
                    String str4 = strArrSplit[5];
                    String[] strArr = this.f2571L;
                    int length2 = strArr.length;
                    int i12 = i3;
                    while (i12 < length2) {
                        String str5 = strArr[i12];
                        if (str3.equalsIgnoreCase(str5)) {
                            int i13 = f2566S + 29;
                            f2567d = i13 % 128;
                            int i14 = i13 % i;
                            j = 0;
                            String strReplace = str4.replace(Code((char) (TextUtils.lastIndexOf(str2, '0', i3) + 59254), 1243 - (TypedValue.complexToFraction(i3, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(i3, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1).intern(), str2).replace(Code((char) (62607 - AndroidCharacter.getMirror('0')), (ExpandableListView.getPackedPositionForGroup(i3) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(i3) == 0L ? 0 : -1)) + 1244, 1 - KeyEvent.normalizeMetaState(i3)).intern(), str2);
                            String[] strArrSplit3 = strReplace.split(Code((char) (5066 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), 1245 - ((Process.getThreadPriority(i3) + 20) >> 6), -TextUtils.lastIndexOf(str2, '0')).intern());
                            int length3 = strArrSplit3.length;
                            int i15 = 0;
                            while (i15 < length3) {
                                String str6 = strReplace;
                                String[] strArr2 = strArrSplit3;
                                String str7 = str2;
                                if (strArrSplit3[i15].equalsIgnoreCase(Code((char) TextUtils.getOffsetAfter(str2, 0), TextUtils.getTrimmedLength(str2) + 1246, '2' - AndroidCharacter.getMirror('0')).intern())) {
                                    this.f2570I = str5;
                                    return true;
                                }
                                i15++;
                                strReplace = str6;
                                strArrSplit3 = strArr2;
                                str2 = str7;
                            }
                            str = str2;
                            str4 = strReplace;
                        } else {
                            str = str2;
                            j = j2;
                        }
                        i12++;
                        j2 = j;
                        str2 = str;
                        i = 2;
                        i3 = 0;
                    }
                }
                i10++;
                i5 = 1;
                j2 = j2;
                str2 = str2;
                i = 2;
                i3 = 0;
                i4 = 6;
                i8 = 4;
            }
            return i3;
        } catch (IOException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: V */
    private boolean m1598V() {
        int i = 2 % 2;
        int i2 = f2566S + 27;
        f2567d = i2 % 128;
        if (i2 % 2 != 0) {
            String str = Build.TAGS;
            if (str == null || !str.contains(Code((char) (ExpandableListView.getPackedPositionChild(0L) + 1), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1248, 8 - TextUtils.lastIndexOf("", '0', 0)).intern())) {
                return false;
            }
            this.f2570I = Code((char) (Process.myPid() >> 22), View.MeasureSpec.makeMeasureSpec(0, 0) + 1248, 8 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern();
            int i3 = f2567d + 97;
            f2566S = i3 % 128;
            if (i3 % 2 == 0) {
                return true;
            }
            throw null;
        }
        String str2 = Build.TAGS;
        throw null;
    }

    /* JADX INFO: renamed from: F */
    private boolean m1596F() {
        int i = 2 % 2;
        Process process = null;
        try {
            Process processExec = Runtime.getRuntime().exec(new String[]{Code((char) (34709 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), View.combineMeasuredStates(0, 0) + 1257, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 5).intern(), Code((char) (19808 - (ViewConfiguration.getPressedStateDuration() >> 16)), Color.blue(0) + 1187, 2 - (ViewConfiguration.getScrollDefaultDelay() >> 16)).intern()});
            try {
                if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() == null) {
                    if (processExec != null) {
                        int i2 = f2567d + 79;
                        f2566S = i2 % 128;
                        if (i2 % 2 != 0) {
                            processExec.destroy();
                            int i3 = 45 / 0;
                        } else {
                            processExec.destroy();
                        }
                    }
                    return false;
                }
                this.f2570I = Code((char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 19808), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1186, 2 - TextUtils.indexOf("", "", 0)).intern();
                if (processExec != null) {
                    int i4 = f2567d + 87;
                    f2566S = i4 % 128;
                    if (i4 % 2 != 0) {
                        processExec.destroy();
                        super.hashCode();
                        throw null;
                    }
                    processExec.destroy();
                }
                return true;
            } catch (Throwable unused) {
                process = processExec;
                if (process != null) {
                    process.destroy();
                    int i5 = f2566S + 119;
                    f2567d = i5 % 128;
                    int i6 = i5 % 2;
                }
                return false;
            }
        } catch (Throwable unused2) {
        }
    }

    private static String Code(char c, int i, int i2) {
        String str;
        synchronized (C2195ci.f3036B) {
            char[] cArr = new char[i2];
            C2195ci.f3037V = 0;
            while (C2195ci.f3037V < i2) {
                cArr[C2195ci.f3037V] = (char) ((((long) f2565F[C2195ci.f3037V + i]) ^ (((long) C2195ci.f3037V) * f2564C)) ^ ((long) c));
                C2195ci.f3037V++;
            }
            str = new String(cArr);
        }
        return str;
    }
}
