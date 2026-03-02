package com.facetec.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.facetec.sdk.be */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractC2165be {

    /* JADX INFO: renamed from: C */
    static int f2776C = -1;
    static boolean Code = false;

    /* JADX INFO: renamed from: F */
    static int f2777F = -1;

    /* JADX INFO: renamed from: I */
    static float f2778I = 0.0f;

    /* JADX INFO: renamed from: L */
    private static C2175bo f2779L = null;

    /* JADX INFO: renamed from: S */
    static float f2780S = -1.0f;

    /* JADX INFO: renamed from: V */
    static float f2781V = -1.0f;

    /* JADX INFO: renamed from: Z */
    static float f2782Z = 1.7f;

    /* JADX INFO: renamed from: B */
    protected boolean f2783B = false;

    /* JADX INFO: renamed from: B */
    abstract void mo1833B();

    public abstract void Code();

    abstract void Code(boolean z);

    /* JADX INFO: renamed from: V */
    abstract void mo1834V(MotionEvent motionEvent, ViewGroup viewGroup);

    /* JADX INFO: renamed from: V */
    abstract void mo1835V(boolean z);

    /* JADX INFO: renamed from: Z */
    public abstract View mo1836Z();

    /* JADX INFO: renamed from: Z */
    abstract void mo1837Z(boolean z);

    AbstractC2165be() {
    }

    /* JADX INFO: renamed from: Z */
    static AbstractC2165be m1843Z(ViewGroup viewGroup, Activity activity, boolean z) throws C2167bg {
        AbstractC2165be surfaceHolderCallbackC2168bh;
        AbstractC2165be c2166bf;
        Code = z;
        f2779L = null;
        m1838B(activity);
        if (m1839I().booleanValue()) {
            c2166bf = new C2166bf();
        } else {
            if (!z && m1840I(activity).booleanValue()) {
                surfaceHolderCallbackC2168bh = new C2164bd(activity);
            } else {
                surfaceHolderCallbackC2168bh = new SurfaceHolderCallbackC2168bh(activity);
            }
            c2166bf = surfaceHolderCallbackC2168bh;
        }
        View viewMo1836Z = c2166bf.mo1836Z();
        viewGroup.addView(viewMo1836Z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        viewMo1836Z.setLayoutParams(layoutParams);
        return c2166bf;
    }

    /* JADX INFO: renamed from: I */
    private static Boolean m1839I() {
        try {
            return Boolean.FALSE;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.be$B */
    static final class B {

        /* JADX INFO: renamed from: B */
        private static int f2791B = 0;
        static final String[] Code;

        /* JADX INFO: renamed from: I */
        private static long f2792I = 0;

        /* JADX INFO: renamed from: Z */
        private static int f2793Z = 1;

        /* JADX INFO: renamed from: I */
        static void m1846I() {
            f2792I = 2013094300103438067L;
        }

        B() {
        }

        static {
            m1846I();
            Code = new String[]{m1845I("溠W댌∂", TextUtils.indexOf("", "", 0, 0) + 28393).intern(), m1845I("溠䚽㻘ᚽ컊ꛋ黑", 10242 - ((byte) KeyEvent.getModifierMetaStateMask())).intern(), m1845I("溠圯᷼숇袁焗㞤", TextUtils.indexOf("", "") + 14737).intern(), m1845I("溠샙㈐斅흘ہ碩", KeyEvent.normalizeMetaState(0) + 44647).intern(), m1845I("溠㯱쑀酙㯹쑉鄜", 21838 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern(), m1845I("溠쑗㬌渏앢㡍澷", 43753 - (ViewConfiguration.getTouchSlop() >> 8)).intern(), m1845I("溠榉悰笑爙䫑䖉", 1847 - Color.red(0)).intern(), m1845I("溿轿굜쯷\ue9ce؆⑅", 57793 - (ViewConfiguration.getKeyRepeatDelay() >> 16)).intern(), m1845I("溠蘛뾔흏챐\ue5fcᴚ㈦⮗", View.getDefaultSize(0, 0) + 59557).intern()};
            int i = f2793Z + 51;
            f2791B = i % 128;
            if (i % 2 != 0) {
                throw null;
            }
        }

        /* JADX INFO: renamed from: I */
        private static String m1845I(String str, int i) {
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
                    cArr2[C2191ce.f3027I] = (char) (((long) (cArr[C2191ce.f3027I] ^ (C2191ce.f3027I * C2191ce.Code))) ^ f2792I);
                    C2191ce.f3027I++;
                }
                str2 = new String(cArr2);
            }
            return str2;
        }
    }

    /* JADX INFO: renamed from: I */
    static Boolean m1840I(Context context) throws C2167bg {
        for (String str : B.Code) {
            if (Build.MODEL.contains(str)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.valueOf(C2164bd.m1827V(context));
    }

    /* JADX INFO: renamed from: V */
    static float m1841V(Activity activity) throws C2167bg {
        return C2164bd.m1813B(activity);
    }

    /* JADX INFO: renamed from: B */
    static synchronized void m1838B(Context context) {
        if (f2779L == null) {
            try {
                f2779L = !Code ? C2164bd.m1829Z(context) : SurfaceHolderCallbackC2168bh.m1856F();
                f2782Z = r2.f2911Z / f2779L.f2910B;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: V */
    static synchronized C2175bo m1842V() {
        return f2779L;
    }

    /* JADX INFO: renamed from: B */
    public final void m1844B(final Runnable runnable) {
        final Timer timer = new Timer();
        final Handler handler = new Handler(Looper.getMainLooper());
        final TimerTask timerTask = new TimerTask() { // from class: com.facetec.sdk.be.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                if (AbstractC2165be.this.f2783B) {
                    synchronized (timer) {
                        cancel();
                        handler.removeCallbacksAndMessages(null);
                        handler.post(new Runnable() { // from class: com.facetec.sdk.be.5.5
                            @Override // java.lang.Runnable
                            public final void run() {
                                runnable.run();
                            }
                        });
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0L, 100L);
        handler.postDelayed(new Runnable() { // from class: com.facetec.sdk.be.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (timer) {
                    timerTask.cancel();
                    runnable.run();
                }
            }
        }, 8000L);
    }
}
