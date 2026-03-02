package com.facetec.sdk;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: renamed from: com.facetec.sdk.ct */
/* JADX INFO: loaded from: classes3.dex */
public final class ServiceC2206ct extends Service {
    private static long Code = 5327978474297818350L;

    /* JADX INFO: renamed from: F */
    private static int f3123F;

    /* JADX INFO: renamed from: I */
    private Messenger f3125I;

    /* JADX INFO: renamed from: Z */
    Messenger f3126Z;

    /* JADX INFO: renamed from: B */
    private static final long[] f3121B = {472001035, -601740789};

    /* JADX INFO: renamed from: V */
    private static final long[] f3124V = {221583250};

    /* JADX INFO: renamed from: C */
    private static int f3122C = 109 % 128;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Messenger messenger = new Messenger(new I(Looper.getMainLooper()));
        this.f3125I = messenger;
        IBinder binder = messenger.getBinder();
        int i = f3122C + 5;
        f3123F = i % 128;
        if (i % 2 == 0) {
            return binder;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ct$I */
    class I extends Handler {

        /* JADX INFO: renamed from: V */
        private static int f3128V;

        public I(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Message messageObtain;
            Messenger messenger;
            Object obj = null;
            try {
                if ((f3128V + 103) % 2 == 0) {
                    ServiceC2206ct.this.f3126Z = message.replyTo;
                    messageObtain = Message.obtain(null, 0, ServiceC2206ct.m2046Z(message.arg1), 0, null);
                    messenger = ServiceC2206ct.this.f3126Z;
                } else {
                    ServiceC2206ct.this.f3126Z = message.replyTo;
                    messageObtain = Message.obtain(null, 1, ServiceC2206ct.m2046Z(message.arg1), 0, null);
                    messenger = ServiceC2206ct.this.f3126Z;
                }
                messenger.send(messageObtain);
                if ((f3128V + 103) % 2 != 0) {
                    return;
                }
                super.hashCode();
                throw null;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        int i = 109 % 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    private static int Code(int i) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ?? Code2 = "ﳁ\uf2d5\ue00a홠얡뮶꥟领軚簫爯憺圅䕔㒚⫿ᠭ";
        m2045B("ﲍ舿ǹ肦١蕓ӕ讎॓蠁ྠ赮", (Process.myPid() >> 22) + 32441);
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(m2045B("ﳁ\uf2d5\ue00a홠얡뮶꥟领軚簫爯憺圅䕔㒚⫿ᠭ", (ViewConfiguration.getLongPressTimeout() >> 16) + 3659)));
            try {
            } finally {
            }
        } catch (IOException unused) {
        }
        if ((C2202cp.Code(bufferedInputStream, f3121B) != 0 ? '?' : 'B') != 'B') {
            m2045B("ﲝ\ud946뜘路毺䆂ṏ\uf400틨ꢯ蚟持㤑៨\uedb6쮙ꁟ縚哪㊪࣊\ue552쌑駢矶䶃⩝\u0002\udeea뒲銛", 9676 - ExpandableListView.getPackedPositionChild(0L));
            int i2 = i ^ 240;
            int i3 = f3123F + 11;
            f3122C = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return i2;
            }
            Object obj = null;
            super.hashCode();
            throw null;
        }
        bufferedInputStream.close();
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(m2045B("ﳁ\uf2d5\ue00a홠얡뮶꥟领軚簫爯憺圅䕔㒚⫿ᠭ", TextUtils.lastIndexOf("", '0') + 3660)));
            } catch (IOException unused2) {
                Code2 = 0;
            }
        } catch (IOException unused3) {
        }
        try {
            Code2 = C2202cp.Code(bufferedInputStream, f3124V);
            if (Code2 != 0) {
                try {
                    m2045B("ﳁ贝ᾚꠈ㪁쭁喕\ue608烖Ę鎟\u1c3a꺤㼽즡娧\ue4fe甪ޱ連⊺덱㷄칂壂\ue940篐і雞✄놆", (ViewConfiguration.getPressedStateDuration() >> 16) + 29059);
                    return i;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
            bufferedInputStream.close();
            if (Code2 == 0) {
                File[] fileArrListFiles = new File(m2045B("ﳁ杧쭮⽪鍩\uf71c", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 39928)).listFiles(new FileFilter() { // from class: com.facetec.sdk.ct.1

                    /* JADX INFO: renamed from: B */
                    private static int f3127B = 1;

                    @Override // java.io.FileFilter
                    public final boolean accept(File file) {
                        int i4 = f3127B;
                        int i5 = ((i4 & 43) + (i4 | 43)) % 2;
                        boolean zIsDirectory = file.isDirectory();
                        int i6 = (f3127B + 99) % 2;
                        return zIsDirectory;
                    }
                });
                int i4 = f3122C + 83;
                f3123F = i4 % 128;
                int i5 = i4 % 2;
                for (File file : fileArrListFiles) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(new StringBuilder().append(file.getAbsolutePath()).append(m2045B("ﳁ\udaa4냏軮搜䉙ᡷ", 9767 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).toString()));
                    } catch (IOException unused4) {
                    }
                    try {
                        if (C2202cp.Code(bufferedInputStream, f3121B) != 0) {
                            m2045B("ﲃṼ㥡呷睮鉬괠졦\ueb69٥ⅸ㱐彛穙镋뀝퍓\uee42ृ␉䝂扎紣頽묳혨", 58109 - Color.red(0));
                            return i ^ 241;
                        }
                        bufferedInputStream.close();
                    } finally {
                    }
                }
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: B */
    private static int m2044B(int i) {
        BufferedInputStream bufferedInputStream;
        int i2;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(m2045B("ﳁ뎢择ᄠ쀽炳⟧홸蕥㖼\ue4f4鬲䩴直ꧤ塰\u0f6e뾮滬ᴪ챡粼", TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 20288)));
            try {
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException unused) {
        }
        if (C2202cp.Code(bufferedInputStream, f3121B) == 0) {
            bufferedInputStream.close();
            return i;
        }
        int i3 = f3122C + 75;
        f3123F = i3 % 128;
        if (i3 % 2 != 0) {
            m2045B("ﲞ뉀愀Ⴤ잉畒⑈\udbcf誏㡋\uef01麅䶁͌눎懕႟왖甒Ⓨ\udbda襖㠙\uefde黖䱟̕닆憚\u1756옃", 22232 >> Color.argb(1, 1, 0, 1));
            i2 = i | 15138;
        } else {
            m2045B("ﲞ뉀愀Ⴤ잉畒⑈\udbcf誏㡋\uef01麅䶁͌눎懕႟왖甒Ⓨ\udbda襖㠙\uefde黖䱟̕닆憚\u1756옃", 20161 - Color.argb(0, 0, 0, 0));
            i2 = i ^ 242;
        }
        int i4 = f3123F + 87;
        f3122C = i4 % 128;
        int i5 = i4 % 2;
        return i2;
    }

    /* JADX INFO: renamed from: Z */
    public static int m2046Z(int i) throws Throwable {
        int iCode = Code(i);
        if (iCode == i) {
            iCode = m2044B(i);
            if (iCode != i) {
                int i2 = f3122C + 103;
                f3123F = i2 % 128;
                int i3 = i2 % 2;
            } else {
                iCode = i;
            }
        } else {
            int i4 = f3122C;
            int i5 = i4 + 13;
            f3123F = i5 % 128;
            int i6 = i5 % 2;
            int i7 = i4 + 91;
            f3123F = i7 % 128;
            int i8 = i7 % 2;
        }
        Object obj = null;
        if (iCode == i) {
            int i9 = f3122C + 39;
            f3123F = i9 % 128;
            if (i9 % 2 == 0) {
                return i;
            }
            super.hashCode();
            throw null;
        }
        int i10 = f3122C + 89;
        f3123F = i10 % 128;
        if (i10 % 2 == 0) {
            return iCode;
        }
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: B */
    private static String m2045B(String str, int i) {
        String str2;
        char[] charArray = str.toCharArray();
        synchronized (C2201co.f3064B) {
            C2201co.f3066V = i;
            char[] cArr = new char[charArray.length];
            C2201co.f3065I = 0;
            while (C2201co.f3065I < charArray.length) {
                cArr[C2201co.f3065I] = (char) (((long) (charArray[C2201co.f3065I] ^ (C2201co.f3065I * C2201co.f3066V))) ^ Code);
                C2201co.f3065I++;
            }
            str2 = new String(cArr);
        }
        return str2;
    }
}
