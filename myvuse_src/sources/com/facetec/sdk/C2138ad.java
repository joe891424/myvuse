package com.facetec.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Base64;
import androidx.work.WorkRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facetec.sdk.ad */
/* JADX INFO: loaded from: classes3.dex */
final class C2138ad {

    /* JADX INFO: renamed from: B */
    private static C2138ad f2348B = null;

    /* JADX INFO: renamed from: C */
    private static volatile String f2349C = "";

    /* JADX INFO: renamed from: Z */
    static volatile String f2350Z = "";

    /* JADX INFO: renamed from: F */
    private EnumC2139ae f2352F;

    /* JADX INFO: renamed from: L */
    private EnumC2136ab f2354L;

    /* JADX INFO: renamed from: S */
    private final WeakReference<Activity> f2355S;

    /* JADX INFO: renamed from: a */
    private EnumC2143ai f2357a;

    /* JADX INFO: renamed from: b */
    private EnumC2142ah f2358b;

    /* JADX INFO: renamed from: c */
    private EnumC2137ac f2359c;

    /* JADX INFO: renamed from: d */
    private EnumC2135aa f2360d;

    /* JADX INFO: renamed from: e */
    private EnumC2147am f2361e;

    /* JADX INFO: renamed from: f */
    private EnumC2141ag f2362f;

    /* JADX INFO: renamed from: g */
    private int f2363g;

    /* JADX INFO: renamed from: h */
    private Code f2364h;

    /* JADX INFO: renamed from: j */
    private V f2366j = V.NOT_STARTED;

    /* JADX INFO: renamed from: i */
    private final Object f2365i = new Object();

    /* JADX INFO: renamed from: n */
    private final Timer f2370n = new Timer();

    /* JADX INFO: renamed from: k */
    private TimerTask f2367k = null;

    /* JADX INFO: renamed from: m */
    private Date f2369m = null;

    /* JADX INFO: renamed from: l */
    private final Semaphore f2368l = new Semaphore(1);

    /* JADX INFO: renamed from: o */
    private boolean f2371o = false;

    /* JADX INFO: renamed from: D */
    private final ExecutorService f2351D = Executors.newSingleThreadExecutor();
    private final ArrayList<WeakReference<B>> Code = new ArrayList<>(2);

    /* JADX INFO: renamed from: V */
    private final ArrayList<WeakReference<I>> f2356V = new ArrayList<>(2);

    /* JADX INFO: renamed from: I */
    private final ArrayList<WeakReference<Z>> f2353I = new ArrayList<>(2);

    /* JADX INFO: renamed from: com.facetec.sdk.ad$B */
    interface B {
        /* JADX INFO: renamed from: V */
        void mo1399V(EnumC2147am enumC2147am, EnumC2142ah enumC2142ah, EnumC2143ai enumC2143ai, EnumC2141ag enumC2141ag);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ad$I */
    interface I {
        /* JADX INFO: renamed from: B */
        void mo1478B();

        void Code(EnumC2139ae enumC2139ae, EnumC2136ab enumC2136ab);

        /* JADX INFO: renamed from: I */
        void mo1479I();

        /* JADX INFO: renamed from: Z */
        void mo1480Z();
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ad$V */
    enum V {
        NOT_STARTED,
        PRE_SESSION,
        PROCESSING,
        ID_SCAN,
        WAITING_TO_FINISH,
        FINISHED
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ad$Z */
    interface Z {
        void Code(EnumC2137ac enumC2137ac, EnumC2135aa enumC2135aa);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ad$Code */
    static class Code {

        /* JADX INFO: renamed from: B */
        final int f2386B;

        /* JADX INFO: renamed from: V */
        final byte[] f2387V;

        /* JADX INFO: renamed from: Z */
        final int f2388Z;

        Code(byte[] bArr, int i, int i2) {
            this.f2387V = bArr;
            this.f2386B = i;
            this.f2388Z = i2;
        }
    }

    static synchronized C2138ad Code(Activity activity) throws Throwable {
        if (f2348B == null) {
            f2348B = new C2138ad(activity);
            C2140af.Code(activity);
        }
        return f2348B;
    }

    /* JADX INFO: renamed from: I */
    static synchronized void m1440I() {
        C2138ad c2138ad = f2348B;
        if (c2138ad != null) {
            c2138ad.m1470L();
            c2138ad.m1467I(true);
            try {
                c2138ad.f2351D.awaitTermination(2L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
            f2348B = null;
        }
    }

    static synchronized void Code() {
        if (f2348B == null) {
            C2140af.m1483B();
        }
    }

    private C2138ad(Activity activity) {
        this.f2355S = new WeakReference<>(activity);
        f2350Z = null;
    }

    /* JADX INFO: renamed from: B */
    static void m1433B() {
        f2349C = UUID.randomUUID().toString();
    }

    final synchronized void Code(I i) {
        this.f2356V.add(new WeakReference<>(i));
    }

    final synchronized void Code(B b) {
        this.Code.add(new WeakReference<>(b));
    }

    /* JADX INFO: renamed from: B */
    final synchronized void m1464B(Z z) {
        this.f2353I.add(new WeakReference<>(z));
    }

    /* JADX INFO: renamed from: Z */
    final synchronized void m1473Z(I i) {
        Iterator<WeakReference<I>> it2 = this.f2356V.iterator();
        while (it2.hasNext()) {
            if (it2.next().get() == i) {
                it2.remove();
            }
        }
    }

    /* JADX INFO: renamed from: B */
    final synchronized void m1463B(B b) {
        Iterator<WeakReference<B>> it2 = this.Code.iterator();
        while (it2.hasNext()) {
            if (it2.next().get() == b) {
                it2.remove();
            }
        }
    }

    /* JADX INFO: renamed from: V */
    final Code m1472V() {
        return this.f2364h;
    }

    /* JADX INFO: renamed from: Z */
    final boolean m1474Z() {
        boolean z;
        synchronized (this.f2365i) {
            z = (this.f2366j == V.PRE_SESSION || this.f2366j == V.PROCESSING || this.f2366j == V.ID_SCAN) && !this.f2371o;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    private static void m1448a() {
        if (f2350Z == null) {
            f2350Z = UUID.randomUUID().toString();
        } else {
            if (f2350Z.equals("")) {
                return;
            }
            f2350Z = UUID.randomUUID().toString();
        }
    }

    private static void Code(Context context) {
        C2140af.m1562z(f2350Z);
        C2140af.m1482A(UUID.nameUUIDFromBytes(C2221j.m2242S(context).getBytes()).toString());
        C2140af.m1489D(C2140af.Code);
        C2140af.m1487C(Build.MODEL);
        C2140af.m1494H(context.getPackageName());
        C2140af.m1492F("9.4.12");
        C2140af.m1493G(C2178br.Code());
        C2140af.m1496I(C2178br.m1928I(context));
    }

    /* JADX INFO: renamed from: I */
    final synchronized boolean m1469I(Context context) {
        this.f2363g = 0;
        this.f2361e = EnumC2147am.DETECTING_LIGHT_MODE;
        int i = AnonymousClass3.f2376I[this.f2366j.ordinal()];
        if (i == 1 || i == 2) {
            if (!C2140af.m1520a()) {
                return false;
            }
            this.f2366j = V.PRE_SESSION;
            m1443V(context);
            m1448a();
            Code(context);
        } else if (i == 3 || i == 4) {
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ad$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f2376I;

        static {
            int[] iArr = new int[V.values().length];
            f2376I = iArr;
            try {
                iArr[V.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2376I[V.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2376I[V.WAITING_TO_FINISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2376I[V.PRE_SESSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2376I[V.PROCESSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030 A[Catch: all -> 0x0071, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0002, B:22:0x0052, B:23:0x0054, B:26:0x0069, B:30:0x006f, B:31:0x0070, B:13:0x001b, B:15:0x001f, B:16:0x0025, B:17:0x0030, B:21:0x0038, B:24:0x0055, B:25:0x0068), top: B:35:0x0002, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final synchronized boolean m1475Z(final android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            r9.f2363g = r0     // Catch: java.lang.Throwable -> L71
            int[] r1 = com.facetec.sdk.C2138ad.AnonymousClass3.f2376I     // Catch: java.lang.Throwable -> L71
            com.facetec.sdk.ad$V r2 = r9.f2366j     // Catch: java.lang.Throwable -> L71
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> L71
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L71
            r2 = 1
            if (r1 == r2) goto L30
            r3 = 2
            if (r1 == r3) goto L30
            r3 = 3
            if (r1 == r3) goto L1b
            r3 = 4
            if (r1 == r3) goto L30
            goto L52
        L1b:
            boolean r0 = com.facetec.sdk.AbstractC2165be.Code     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L25
            com.facetec.sdk.C2140af.m1529b(r2)     // Catch: java.lang.Throwable -> L71
            com.facetec.sdk.C2140af.m1532d(r11)     // Catch: java.lang.Throwable -> L71
        L25:
            com.facetec.sdk.C2140af.m1511V()     // Catch: java.lang.Throwable -> L71
            com.facetec.sdk.ad$V r11 = com.facetec.sdk.C2138ad.V.PROCESSING     // Catch: java.lang.Throwable -> L71
            r9.f2366j = r11     // Catch: java.lang.Throwable -> L71
            m1448a()     // Catch: java.lang.Throwable -> L71
            goto L52
        L30:
            boolean r11 = com.facetec.sdk.C2140af.m1532d(r11)     // Catch: java.lang.Throwable -> L71
            if (r11 != 0) goto L38
            monitor-exit(r9)
            return r0
        L38:
            com.facetec.sdk.ad$V r11 = com.facetec.sdk.C2138ad.V.PROCESSING     // Catch: java.lang.Throwable -> L71
            r9.f2366j = r11     // Catch: java.lang.Throwable -> L71
            m1443V(r10)     // Catch: java.lang.Throwable -> L71
            m1448a()     // Catch: java.lang.Throwable -> L71
            com.facetec.sdk.ad$4 r11 = new com.facetec.sdk.ad$4     // Catch: java.lang.Throwable -> L71
            r11.<init>()     // Catch: java.lang.Throwable -> L71
            com.facetec.sdk.AbstractAsyncTaskC2155au.m1615B(r11)     // Catch: java.lang.Throwable -> L71
            com.facetec.sdk.ad$2 r11 = new com.facetec.sdk.ad$2     // Catch: java.lang.Throwable -> L71
            r11.<init>()     // Catch: java.lang.Throwable -> L71
            com.facetec.sdk.AbstractAsyncTaskC2155au.m1615B(r11)     // Catch: java.lang.Throwable -> L71
        L52:
            java.util.Timer r11 = r9.f2370n     // Catch: java.lang.Throwable -> L71
            monitor-enter(r11)     // Catch: java.lang.Throwable -> L71
            r9.m1449b()     // Catch: java.lang.Throwable -> L6e
            com.facetec.sdk.ad$9 r4 = new com.facetec.sdk.ad$9     // Catch: java.lang.Throwable -> L6e
            r4.<init>()     // Catch: java.lang.Throwable -> L6e
            r9.f2367k = r4     // Catch: java.lang.Throwable -> L6e
            java.util.Timer r3 = r9.f2370n     // Catch: java.lang.Throwable -> L6e
            r5 = 60
            r7 = 10000(0x2710, double:4.9407E-320)
            r3.scheduleAtFixedRate(r4, r5, r7)     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L6e
            Code(r10)     // Catch: java.lang.Throwable -> L71
            monitor-exit(r9)
            return r2
        L6e:
            r10 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L71
            throw r10     // Catch: java.lang.Throwable -> L71
        L71:
            r10 = move-exception
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L71
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2138ad.m1475Z(android.content.Context, java.lang.String):boolean");
    }

    final synchronized boolean Code(boolean z) {
        this.f2363g = 0;
        int i = AnonymousClass3.f2376I[this.f2366j.ordinal()];
        if (i == 1 || i == 2) {
            if (!C2140af.m1541i(z)) {
                return false;
            }
            this.f2366j = V.ID_SCAN;
        } else {
            if (i == 3 || i == 4) {
                return false;
            }
            if (i == 5) {
                return false;
            }
        }
        synchronized (this.f2370n) {
            m1449b();
            TimerTask timerTask = new TimerTask() { // from class: com.facetec.sdk.ad.6
                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    C2138ad.m1434B(C2138ad.this);
                }
            };
            this.f2367k = timerTask;
            this.f2370n.scheduleAtFixedRate(timerTask, 60L, WorkRequest.MIN_BACKOFF_MILLIS);
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    private void m1449b() {
        synchronized (this.f2370n) {
            this.f2369m = null;
            TimerTask timerTask = this.f2367k;
            if (timerTask != null) {
                timerTask.cancel();
                this.f2367k = null;
            }
        }
    }

    /* JADX INFO: renamed from: V */
    private static void m1443V(Context context) {
        if (C2180bt.m1948B(context)) {
            C2140af.m1555s();
        }
        if (C2127I.Code(context)) {
            C2140af.m1553q();
        }
    }

    /* JADX INFO: renamed from: D */
    final synchronized void m1465D() {
        boolean z;
        synchronized (this.f2365i) {
            if (this.f2366j == V.PRE_SESSION || this.f2366j == V.PROCESSING || this.f2366j == V.WAITING_TO_FINISH) {
                this.f2366j = V.FINISHED;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            C2140af.m1535f(true);
        }
    }

    /* JADX INFO: renamed from: F */
    final synchronized void m1466F() {
        boolean z;
        synchronized (this.f2365i) {
            if (this.f2366j == V.ID_SCAN || this.f2366j == V.PRE_SESSION || this.f2366j == V.PROCESSING || this.f2366j == V.WAITING_TO_FINISH) {
                this.f2366j = V.FINISHED;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            C2140af.m1539h(false);
        }
    }

    /* JADX INFO: renamed from: S */
    final synchronized void m1471S() {
        synchronized (this.f2365i) {
            if (this.f2366j == V.PROCESSING || this.f2366j == V.WAITING_TO_FINISH) {
                this.f2366j = V.FINISHED;
            }
        }
        m1449b();
        this.Code.clear();
        this.f2356V.clear();
    }

    /* JADX INFO: renamed from: I */
    final synchronized void m1467I(boolean z) {
        boolean z2;
        synchronized (this.f2365i) {
            if (this.f2366j == V.PROCESSING || this.f2366j == V.WAITING_TO_FINISH) {
                this.f2366j = V.FINISHED;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        m1449b();
        if (z2) {
            C2140af.m1529b(z);
        }
    }

    /* JADX INFO: renamed from: L */
    final void m1470L() {
        synchronized (this.f2365i) {
            if (this.f2366j == V.PRE_SESSION || this.f2366j == V.PROCESSING || this.f2366j == V.ID_SCAN) {
                this.f2366j = V.WAITING_TO_FINISH;
            }
        }
        m1449b();
        this.Code.clear();
        this.f2356V.clear();
        this.f2353I.clear();
        this.f2351D.shutdown();
    }

    /* JADX INFO: renamed from: C */
    static boolean m1436C() {
        return C2140af.m1500L();
    }

    /* JADX INFO: renamed from: c */
    final EnumC2147am m1476c() {
        EnumC2147am enumC2147amM1488D = C2140af.m1488D();
        this.f2361e = enumC2147amM1488D;
        return enumC2147amM1488D;
    }

    /* JADX INFO: renamed from: e */
    final EnumC2143ai m1477e() {
        EnumC2143ai enumC2143aiM1491F = C2140af.m1491F();
        this.f2357a = enumC2143aiM1491F;
        return enumC2143aiM1491F;
    }

    /* JADX INFO: renamed from: I */
    final void m1468I(final byte[] bArr, final int i, final int i2, final int i3, final Boolean bool) {
        this.f2364h = new Code(bArr, i, i2);
        if (this.f2369m == null) {
            this.f2369m = new Date();
        }
        if (m1474Z() && this.f2368l.tryAcquire()) {
            this.f2371o = true;
            try {
                this.f2351D.execute(new Runnable() { // from class: com.facetec.sdk.ad.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (C2138ad.this.f2366j != V.PRE_SESSION) {
                                if (C2138ad.this.f2366j == V.ID_SCAN) {
                                    C2138ad.m1447Z(C2138ad.this, bArr, i, i2, i3, bool);
                                } else {
                                    C2138ad.m1445V(C2138ad.this, bArr, i, i2, i3, bool);
                                }
                            } else {
                                C2138ad.m1441I(C2138ad.this, bArr, i, i2, i3, bool);
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
                m1450d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m1450d() {
        this.f2371o = false;
        this.f2368l.release();
    }

    /* JADX INFO: renamed from: g */
    private synchronized void m1452g() {
        Activity activity = this.f2355S.get();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.ad.8
            @Override // java.lang.Runnable
            public final void run() {
                C2138ad.this.m1462r();
            }
        });
    }

    /* JADX INFO: renamed from: h */
    private synchronized void m1453h() {
        Activity activity = this.f2355S.get();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.ad.10
            @Override // java.lang.Runnable
            public final void run() {
                C2138ad.this.m1461q();
            }
        });
    }

    /* JADX INFO: renamed from: j */
    private synchronized void m1455j() {
        Activity activity = this.f2355S.get();
        if (activity == null) {
            return;
        }
        if (this.f2352F == EnumC2139ae.PROCESSING_COMPLETE_STILL_COMPUTING) {
            return;
        }
        if (this.f2352F == EnumC2139ae.PROCESSING_COMPLETE_TIMED_OUT) {
            activity.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.ad.15
                @Override // java.lang.Runnable
                public final void run() {
                    C2138ad.this.m1460o();
                }
            });
            return;
        }
        if (this.f2352F == EnumC2139ae.PROCESSING_COMPLETE_RETRY) {
            activity.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.ad.11
                @Override // java.lang.Runnable
                public final void run() {
                    C2138ad.this.m1456k();
                }
            });
        } else if (this.f2352F == EnumC2139ae.PROCESSING_COMPLETE_SUCCESS) {
            activity.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.ad.5
                @Override // java.lang.Runnable
                public final void run() {
                    C2138ad.this.m1457l();
                }
            });
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.ad.1
                @Override // java.lang.Runnable
                public final void run() {
                    C2138ad.this.m1458m();
                }
            });
        }
    }

    /* JADX INFO: renamed from: i */
    private synchronized List<I> m1454i() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f2356V.size());
        Iterator<WeakReference<I>> it2 = this.f2356V.iterator();
        while (it2.hasNext()) {
            I i = it2.next().get();
            if (i != null) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: f */
    private synchronized List<B> m1451f() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.Code.size());
        Iterator<WeakReference<B>> it2 = this.Code.iterator();
        while (it2.hasNext()) {
            B b = it2.next().get();
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: n */
    private synchronized List<Z> m1459n() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f2353I.size());
        Iterator<WeakReference<Z>> it2 = this.f2353I.iterator();
        while (it2.hasNext()) {
            Z z = it2.next().get();
            if (z != null) {
                arrayList.add(z);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o */
    public synchronized void m1460o() {
        Iterator<I> it2 = m1454i().iterator();
        while (it2.hasNext()) {
            it2.next().mo1479I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k */
    public synchronized void m1456k() {
        Iterator<I> it2 = m1454i().iterator();
        while (it2.hasNext()) {
            it2.next().mo1478B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l */
    public synchronized void m1457l() {
        Iterator<I> it2 = m1454i().iterator();
        while (it2.hasNext()) {
            it2.next().mo1480Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public synchronized void m1458m() {
        Iterator<I> it2 = m1454i().iterator();
        while (it2.hasNext()) {
            it2.next().Code(this.f2352F, this.f2354L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public synchronized void m1461q() {
        Iterator<B> it2 = m1451f().iterator();
        while (it2.hasNext()) {
            it2.next().mo1399V(this.f2361e, this.f2358b, this.f2357a, this.f2362f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public synchronized void m1462r() {
        Iterator<Z> it2 = m1459n().iterator();
        while (it2.hasNext()) {
            it2.next().Code(this.f2359c, this.f2360d);
        }
    }

    /* JADX INFO: renamed from: B */
    static /* synthetic */ void m1434B(C2138ad c2138ad) {
        synchronized (c2138ad.f2365i) {
            if (c2138ad.f2366j == V.FINISHED || c2138ad.f2366j == V.WAITING_TO_FINISH) {
                return;
            }
            if (c2138ad.f2369m == null || new Date().getTime() - c2138ad.f2369m.getTime() <= 615000) {
                return;
            }
            C2121D.Code(new Throwable("Phoenix hang was detected"));
            c2138ad.m1467I(false);
            c2138ad.f2352F = EnumC2139ae.PROCESSING_COMPLETE_TIMED_OUT;
            c2138ad.m1455j();
        }
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m1441I(C2138ad c2138ad, byte[] bArr, int i, int i2, int i3, Boolean bool) {
        synchronized (c2138ad.f2365i) {
            if (c2138ad.f2366j != V.PRE_SESSION) {
                return;
            }
            int i4 = c2138ad.f2363g + 1;
            c2138ad.f2363g = i4;
            if (i4 >= 4) {
                if (!C2134a.f2325Z) {
                    C2140af.m1537g("", bArr, bool.booleanValue(), i, i2, i3, true);
                } else {
                    C2140af.m1537g(Base64.encodeToString(bArr, 2), bArr, bool.booleanValue(), i, i2, i3, true);
                }
                c2138ad.f2361e = C2140af.m1488D();
                c2138ad.f2358b = C2140af.m1507S();
                c2138ad.f2357a = C2140af.m1491F();
                c2138ad.f2362f = C2140af.m1486C();
                c2138ad.m1453h();
            }
        }
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ void m1447Z(C2138ad c2138ad, byte[] bArr, int i, int i2, int i3, Boolean bool) {
        synchronized (c2138ad.f2365i) {
            if (c2138ad.f2366j != V.ID_SCAN) {
                return;
            }
            int i4 = c2138ad.f2363g + 1;
            c2138ad.f2363g = i4;
            if (i4 >= 4) {
                C2140af.m1544j(bArr, bool.booleanValue(), i, i2, i3);
                c2138ad.f2359c = C2140af.m1528b();
                c2138ad.f2360d = C2140af.m1543j();
                c2138ad.m1452g();
            }
        }
    }

    /* JADX INFO: renamed from: V */
    static /* synthetic */ void m1445V(C2138ad c2138ad, byte[] bArr, int i, int i2, int i3, Boolean bool) {
        String strEncodeToString;
        synchronized (c2138ad.f2365i) {
            if (c2138ad.f2366j == V.FINISHED || c2138ad.f2366j == V.WAITING_TO_FINISH) {
                return;
            }
            int i4 = c2138ad.f2363g + 1;
            c2138ad.f2363g = i4;
            if (i4 >= 4) {
                if (!C2134a.f2325Z) {
                    strEncodeToString = "";
                } else {
                    strEncodeToString = Base64.encodeToString(bArr, 2);
                }
                C2140af.m1537g(strEncodeToString, bArr, bool.booleanValue(), i, i2, i3, false);
                c2138ad.f2352F = C2140af.m1495I();
                c2138ad.f2354L = C2140af.m1533e();
                if (c2138ad.f2352F.m1481B()) {
                    c2138ad.f2366j = V.WAITING_TO_FINISH;
                }
                if (c2138ad.f2352F == EnumC2139ae.PROCESSING_COMPLETE_TIMED_OUT || c2138ad.f2352F == EnumC2139ae.PROCESSING_COMPLETE_RETRY || c2138ad.f2352F == EnumC2139ae.PROCESSING_COMPLETE_SUCCESS) {
                    c2138ad.f2366j = V.WAITING_TO_FINISH;
                }
                c2138ad.m1455j();
            }
        }
    }
}
