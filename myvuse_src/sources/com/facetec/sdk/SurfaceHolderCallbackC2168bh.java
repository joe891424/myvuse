package com.facetec.sdk;

import android.app.Activity;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.google.logging.type.LogSeverity;
import com.newrelic.agent.android.util.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: renamed from: com.facetec.sdk.bh */
/* JADX INFO: loaded from: classes3.dex */
class SurfaceHolderCallbackC2168bh extends AbstractC2165be implements Camera.AutoFocusCallback, Camera.ErrorCallback, Camera.PreviewCallback, SurfaceHolder.Callback {

    /* JADX INFO: renamed from: q */
    private static /* synthetic */ boolean f2803q = true;

    /* JADX INFO: renamed from: b */
    private int f2807b;

    /* JADX INFO: renamed from: c */
    private final WeakReference<AbstractActivityC2220h> f2808c;

    /* JADX INFO: renamed from: d */
    private final C2132V f2809d;

    /* JADX INFO: renamed from: g */
    private SurfaceHolder f2812g;

    /* JADX INFO: renamed from: h */
    private final C2175bo f2813h;

    /* JADX INFO: renamed from: j */
    private boolean f2815j;

    /* JADX INFO: renamed from: L */
    private boolean f2805L = false;

    /* JADX INFO: renamed from: a */
    private Camera f2806a = null;

    /* JADX INFO: renamed from: f */
    private boolean f2811f = false;

    /* JADX INFO: renamed from: i */
    private boolean f2814i = false;

    /* JADX INFO: renamed from: k */
    private boolean f2816k = false;

    /* JADX INFO: renamed from: m */
    private boolean f2818m = false;

    /* JADX INFO: renamed from: l */
    private Handler f2817l = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: n */
    private String f2819n = "";

    /* JADX INFO: renamed from: D */
    protected long f2804D = -1;

    /* JADX INFO: renamed from: o */
    private final Camera.AutoFocusMoveCallback f2820o = new Camera.AutoFocusMoveCallback() { // from class: com.facetec.sdk.bh.5
        @Override // android.hardware.Camera.AutoFocusMoveCallback
        public final void onAutoFocusMoving(boolean z, Camera camera) {
            SurfaceHolderCallbackC2168bh.this.f2816k = !z;
            SurfaceHolderCallbackC2168bh.this.f2805L = z;
            SurfaceHolderCallbackC2168bh.this.f2804D = System.nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE;
            boolean unused = SurfaceHolderCallbackC2168bh.this.f2816k;
            if (SurfaceHolderCallbackC2168bh.this.f2811f && SurfaceHolderCallbackC2168bh.this.f2816k) {
                C2140af.m1549m(true);
                SurfaceHolderCallbackC2168bh.m1861L(SurfaceHolderCallbackC2168bh.this);
            }
        }
    };

    /* JADX INFO: renamed from: r */
    private final Camera.AutoFocusCallback f2821r = new Camera.AutoFocusCallback() { // from class: com.facetec.sdk.bh.6
        @Override // android.hardware.Camera.AutoFocusCallback
        public final void onAutoFocus(boolean z, Camera camera) {
            SurfaceHolderCallbackC2168bh.this.f2816k = z;
            SurfaceHolderCallbackC2168bh.this.f2804D = System.nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE;
            SurfaceHolderCallbackC2168bh.this.m1873d();
            if (SurfaceHolderCallbackC2168bh.this.m1870a()) {
                SurfaceHolderCallbackC2168bh.this.m1871b();
            }
            if (SurfaceHolderCallbackC2168bh.this.f2811f && z) {
                C2140af.m1549m(true);
                SurfaceHolderCallbackC2168bh.m1861L(SurfaceHolderCallbackC2168bh.this);
            }
        }
    };

    /* JADX INFO: renamed from: e */
    private Handler f2810e = new Handler();

    /* JADX INFO: renamed from: S */
    static /* synthetic */ boolean m1863S() {
        return true;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    /* JADX INFO: renamed from: L */
    static /* synthetic */ boolean m1861L(SurfaceHolderCallbackC2168bh surfaceHolderCallbackC2168bh) {
        surfaceHolderCallbackC2168bh.f2811f = false;
        return false;
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ boolean m1869Z(SurfaceHolderCallbackC2168bh surfaceHolderCallbackC2168bh) {
        surfaceHolderCallbackC2168bh.f2818m = false;
        return false;
    }

    SurfaceHolderCallbackC2168bh(Activity activity) {
        this.f2808c = new WeakReference<>((AbstractActivityC2220h) activity);
        C2132V c2132v = new C2132V(activity);
        this.f2809d = c2132v;
        c2132v.getHolder().addCallback(this);
        this.f2815j = true;
        C2175bo c2175boV = m1842V();
        this.f2813h = c2175boV;
        if (!f2803q && c2175boV == null) {
            throw new AssertionError();
        }
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: B */
    final void mo1833B() {
        if (AbstractC2165be.Code) {
            mo1835V(true);
            mo1835V(false);
        }
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: V */
    final void mo1835V(boolean z) {
        Camera camera = this.f2806a;
        if (camera == null || this.f2814i == (!z)) {
            return;
        }
        if (z) {
            camera.stopPreview();
            this.f2814i = false;
            return;
        }
        try {
            camera.setPreviewCallback(this);
            this.f2806a.startPreview();
            this.f2814i = true;
        } catch (Exception e) {
            e.getMessage();
            this.f2808c.get();
            EnumC2119B enumC2119B = EnumC2119B.STARTPREVIEW_EXCEPTION;
            this.f2808c.get();
            C2120C.m1364V();
            C2120C.m1362B();
        }
    }

    @Override // com.facetec.sdk.AbstractC2165be
    final void Code(boolean z) {
        if (z) {
            this.f2811f = true;
        }
        if (this.f2818m) {
            return;
        }
        if (this.f2816k) {
            final Runnable runnable = new Runnable() { // from class: com.facetec.sdk.bh.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (SurfaceHolderCallbackC2168bh.this.m1852C() > 0) {
                        return;
                    }
                    SurfaceHolderCallbackC2168bh.this.m1875e();
                }
            };
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facetec.sdk.bh.2
                @Override // java.lang.Runnable
                public final void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, m1852C());
            return;
        }
        m1875e();
    }

    @Override // com.facetec.sdk.AbstractC2165be
    public final void Code() {
        m1854D();
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: Z */
    public final View mo1836Z() {
        return this.f2809d;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f2812g = surfaceHolder;
        if (this.f2810e == null) {
            this.f2810e = new Handler();
        }
        this.f2810e.post(new Runnable() { // from class: com.facetec.sdk.bh.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    SurfaceHolderCallbackC2168bh.this.m1872c();
                    SurfaceHolderCallbackC2168bh.m1863S();
                } catch (Exception e) {
                    C2121D.Code(e);
                    C2188cb.m1995V(e.getMessage());
                    SurfaceHolderCallbackC2168bh.this.Code(e.getMessage());
                }
            }
        });
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        m1854D();
        if (surfaceHolder == null || surfaceHolder.getSurface() == null) {
            return;
        }
        surfaceHolder.removeCallback(this);
        surfaceHolder.getSurface().release();
        this.f2815j = false;
    }

    /* JADX INFO: renamed from: I */
    final void m1876I() {
        if (this.f2815j) {
            return;
        }
        this.f2809d.getHolder().addCallback(this);
        this.f2815j = true;
    }

    /* JADX INFO: renamed from: D */
    private synchronized void m1854D() {
        Camera camera = this.f2806a;
        if (camera != null) {
            try {
                try {
                    camera.cancelAutoFocus();
                    this.f2806a.stopPreview();
                    this.f2806a.setPreviewCallback(null);
                    this.f2806a.release();
                } catch (Exception e) {
                    C2188cb.m1995V(e.getMessage());
                }
            } finally {
                this.f2806a = null;
            }
        }
        Handler handler = this.f2810e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f2810e = null;
        }
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: Z */
    final void mo1837Z(boolean z) {
        Camera camera = this.f2806a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null && supportedFlashModes.size() > 0) {
            if (z && supportedFlashModes.contains("torch")) {
                parameters.setFlashMode("torch");
            } else if (!z && supportedFlashModes.contains(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
        }
        this.f2806a.setParameters(parameters);
        mo1835V(false);
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: V */
    final void mo1834V(MotionEvent motionEvent, ViewGroup viewGroup) {
        if (this.f2806a == null || !this.f2814i) {
            return;
        }
        this.f2818m = true;
        this.f2817l.removeCallbacksAndMessages(null);
        this.f2817l.postDelayed(new Runnable() { // from class: com.facetec.sdk.bh.3
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceHolderCallbackC2168bh.m1869Z(SurfaceHolderCallbackC2168bh.this);
            }
        }, 6000L);
        try {
            m1873d();
            m1868Z(Code(motionEvent.getX(), motionEvent.getY(), viewGroup));
        } catch (Exception unused) {
            m1873d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: C */
    public long m1852C() {
        if (this.f2804D != -1) {
            long jNanoTime = (System.nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE) - this.f2804D;
            if (jNanoTime < 8000) {
                return 8000 - jNanoTime;
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m1875e() {
        if (this.f2806a == null || this.f2805L) {
            return;
        }
        m1868Z(Code(AbstractC2165be.f2781V, AbstractC2165be.f2780S, null));
    }

    /* JADX INFO: renamed from: Z */
    private void m1868Z(Rect rect) {
        if (this.f2805L || this.f2806a == null || !this.f2814i) {
            return;
        }
        this.f2805L = true;
        this.f2804D = System.nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE;
        try {
            Camera.Parameters parameters = this.f2806a.getParameters();
            if (parameters.getSupportedFocusModes().contains("auto")) {
                parameters.setFocusMode("auto");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(rect, LogSeverity.EMERGENCY_VALUE));
            if (parameters.getMaxNumFocusAreas() > 0) {
                parameters.setFocusAreas(arrayList);
            }
            this.f2806a.setParameters(parameters);
            mo1835V(false);
            this.f2806a.autoFocus(this.f2821r);
        } catch (Exception e) {
            e.getMessage();
            m1873d();
            m1871b();
        }
    }

    private static Rect Code(float f, float f2, ViewGroup viewGroup) {
        int width;
        int height;
        if (viewGroup != null) {
            width = viewGroup.getWidth();
            height = viewGroup.getHeight();
        } else {
            width = AbstractC2165be.f2777F;
            height = AbstractC2165be.f2776C;
        }
        int iM1858I = m1858I(Float.valueOf(((f / width) * 2000.0f) - 1000.0f).intValue());
        int iM1858I2 = m1858I(Float.valueOf(((f2 / height) * 2000.0f) - 1000.0f).intValue());
        return new Rect(iM1858I, iM1858I2, iM1858I + 300, iM1858I2 + 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m1873d() {
        this.f2805L = false;
        Camera camera = this.f2806a;
        if (camera == null) {
            return;
        }
        try {
            camera.cancelAutoFocus();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m1871b() {
        if (this.f2806a == null || this.f2819n.isEmpty()) {
            return;
        }
        try {
            Camera.Parameters parameters = this.f2806a.getParameters();
            parameters.setFocusMode(this.f2819n);
            if (parameters.getMaxNumFocusAreas() > 0) {
                parameters.setFocusAreas(null);
            }
            if (parameters.getMaxNumMeteringAreas() > 0) {
                parameters.setMeteringAreas(null);
            }
            this.f2806a.setParameters(parameters);
            mo1835V(false);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: renamed from: I */
    private static int m1858I(int i) {
        int iRound = Math.round(150.0f);
        return Math.abs(i) + iRound > 1000 ? i > 0 ? 1000 - iRound : iRound - 1000 : i - iRound;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        C2138ad c2138ad;
        this.f2783B = true;
        AbstractActivityC2219g abstractActivityC2219g = (AbstractActivityC2219g) this.f2808c.get();
        if (abstractActivityC2219g == null || (c2138ad = abstractActivityC2219g.f3470B) == null) {
            return;
        }
        if (Code && abstractActivityC2219g.f3261X) {
            c2138ad.m1468I(bArr, this.f2813h.f2911Z, this.f2813h.f2910B, this.f2807b, Boolean.FALSE);
        } else {
            if (!c2138ad.m1474Z() || Code) {
                return;
            }
            c2138ad.m1468I(bArr, this.f2813h.f2911Z, this.f2813h.f2910B, this.f2807b, Boolean.FALSE);
        }
    }

    /* JADX INFO: renamed from: Z */
    private static Camera m1867Z(Camera.CameraInfo cameraInfo) throws Exception {
        int i = 0;
        if (AbstractC2165be.Code) {
            try {
                Camera.getCameraInfo(0, cameraInfo);
            } catch (RuntimeException unused) {
                i = 1;
            }
            return Camera.open(i);
        }
        try {
            Camera.getCameraInfo(1, cameraInfo);
            i = 1;
        } catch (RuntimeException unused2) {
            Camera.getCameraInfo(0, cameraInfo);
        }
        if (cameraInfo.facing == 1) {
            return Camera.open(i);
        }
        throw new C2181bu("Front facing camera not available");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056 A[Catch: all -> 0x015e, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000e, B:10:0x0016, B:21:0x0047, B:23:0x0056, B:24:0x005d, B:28:0x006d, B:30:0x0088, B:32:0x008c, B:33:0x0099, B:35:0x00be, B:49:0x00ed, B:51:0x00f6, B:53:0x00fc, B:54:0x0103, B:56:0x0109, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:62:0x0144, B:63:0x0149, B:38:0x00c9, B:41:0x00d4, B:44:0x00df, B:29:0x007b), top: B:69:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c A[Catch: all -> 0x015e, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000e, B:10:0x0016, B:21:0x0047, B:23:0x0056, B:24:0x005d, B:28:0x006d, B:30:0x0088, B:32:0x008c, B:33:0x0099, B:35:0x00be, B:49:0x00ed, B:51:0x00f6, B:53:0x00fc, B:54:0x0103, B:56:0x0109, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:62:0x0144, B:63:0x0149, B:38:0x00c9, B:41:0x00d4, B:44:0x00df, B:29:0x007b), top: B:69:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4 A[Catch: all -> 0x015e, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000e, B:10:0x0016, B:21:0x0047, B:23:0x0056, B:24:0x005d, B:28:0x006d, B:30:0x0088, B:32:0x008c, B:33:0x0099, B:35:0x00be, B:49:0x00ed, B:51:0x00f6, B:53:0x00fc, B:54:0x0103, B:56:0x0109, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:62:0x0144, B:63:0x0149, B:38:0x00c9, B:41:0x00d4, B:44:0x00df, B:29:0x007b), top: B:69:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ed A[Catch: all -> 0x015e, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000e, B:10:0x0016, B:21:0x0047, B:23:0x0056, B:24:0x005d, B:28:0x006d, B:30:0x0088, B:32:0x008c, B:33:0x0099, B:35:0x00be, B:49:0x00ed, B:51:0x00f6, B:53:0x00fc, B:54:0x0103, B:56:0x0109, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:62:0x0144, B:63:0x0149, B:38:0x00c9, B:41:0x00d4, B:44:0x00df, B:29:0x007b), top: B:69:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0109 A[Catch: all -> 0x015e, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000e, B:10:0x0016, B:21:0x0047, B:23:0x0056, B:24:0x005d, B:28:0x006d, B:30:0x0088, B:32:0x008c, B:33:0x0099, B:35:0x00be, B:49:0x00ed, B:51:0x00f6, B:53:0x00fc, B:54:0x0103, B:56:0x0109, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:62:0x0144, B:63:0x0149, B:38:0x00c9, B:41:0x00d4, B:44:0x00df, B:29:0x007b), top: B:69:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0112 A[Catch: all -> 0x015e, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000e, B:10:0x0016, B:21:0x0047, B:23:0x0056, B:24:0x005d, B:28:0x006d, B:30:0x0088, B:32:0x008c, B:33:0x0099, B:35:0x00be, B:49:0x00ed, B:51:0x00f6, B:53:0x00fc, B:54:0x0103, B:56:0x0109, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:62:0x0144, B:63:0x0149, B:38:0x00c9, B:41:0x00d4, B:44:0x00df, B:29:0x007b), top: B:69:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0144 A[Catch: all -> 0x015e, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000e, B:10:0x0016, B:21:0x0047, B:23:0x0056, B:24:0x005d, B:28:0x006d, B:30:0x0088, B:32:0x008c, B:33:0x0099, B:35:0x00be, B:49:0x00ed, B:51:0x00f6, B:53:0x00fc, B:54:0x0103, B:56:0x0109, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:62:0x0144, B:63:0x0149, B:38:0x00c9, B:41:0x00d4, B:44:0x00df, B:29:0x007b), top: B:69:0x0001 }] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m1872c() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.SurfaceHolderCallbackC2168bh.m1872c():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m1870a() {
        String str = this.f2819n;
        return str == "continuous-picture" || str == "continuous-video";
    }

    /* JADX INFO: renamed from: V */
    private static Camera.Size m1864V(Camera.Parameters parameters, float f) {
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        Collections.sort(supportedPictureSizes, new Comparator<Camera.Size>() { // from class: com.facetec.sdk.bh.9
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                return (size4.width * size4.height) - (size3.width * size3.height);
            }
        });
        for (Camera.Size size : supportedPictureSizes) {
            if (size.width / size.height == f) {
                return size;
            }
        }
        return supportedPictureSizes.get(0);
    }

    /* JADX INFO: renamed from: F */
    public static synchronized C2175bo m1856F() throws Exception {
        ArrayList arrayList;
        float[] fArr = {1.7f, 1.6f, 1.5f, 1.4f, 1.3f};
        arrayList = new ArrayList();
        Camera cameraM1867Z = m1867Z(new Camera.CameraInfo());
        List<Camera.Size> supportedPreviewSizes = cameraM1867Z.getParameters().getSupportedPreviewSizes();
        Collections.sort(supportedPreviewSizes, new Comparator<Camera.Size>() { // from class: com.facetec.sdk.bh.8
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                return (size4.width * size4.height) - (size3.width * size3.height);
            }
        });
        int i = supportedPreviewSizes.get(0).width;
        int i2 = supportedPreviewSizes.get(0).height;
        if (!Code) {
            for (int i3 = 0; i3 < 5; i3++) {
                float f = fArr[i3];
                for (Camera.Size size : supportedPreviewSizes) {
                    float f2 = size.width;
                    float f3 = f2 / size.height;
                    if (f3 >= f && f3 <= 1.9f && f2 >= 640.0f && f2 <= 1920.0f) {
                        arrayList.add(size);
                    }
                }
                if (arrayList.size() > 0) {
                    break;
                }
            }
        } else {
            for (Camera.Size size2 : supportedPreviewSizes) {
                float f4 = size2.width;
                if (f4 / size2.height == f2782Z && f4 <= 1920.0f) {
                    arrayList.add(size2);
                }
            }
        }
        cameraM1867Z.stopPreview();
        cameraM1867Z.release();
        return new C2175bo(((Camera.Size) arrayList.get(0)).width, ((Camera.Size) arrayList.get(0)).height);
    }

    /* JADX INFO: renamed from: L */
    static float m1860L() {
        C2175bo c2175boM1842V = AbstractC2165be.m1842V();
        return c2175boM1842V.f2911Z / c2175boM1842V.f2910B;
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i, Camera camera) {
        if (i == 100) {
            try {
                m1854D();
                m1872c();
                return;
            } catch (Exception e) {
                C2121D.Code(e);
                Code(e.getMessage());
                return;
            }
        }
        try {
            throw new RuntimeException("Legacy camera error: ".concat(String.valueOf(i)));
        } catch (Exception e2) {
            C2121D.Code(e2);
            Code("Unknown camera error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        AbstractActivityC2220h abstractActivityC2220h = this.f2808c.get();
        if (abstractActivityC2220h != null) {
            abstractActivityC2220h.mo2180B(str);
        }
    }
}
