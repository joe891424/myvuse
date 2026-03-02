package com.facetec.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facetec.sdk.C2161ba;
import com.facetec.sdk.C2167bg;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facetec.sdk.bd */
/* JADX INFO: loaded from: classes3.dex */
class C2164bd extends AbstractC2165be {

    /* JADX INFO: renamed from: L */
    private static final SparseIntArray f2747L;

    /* JADX INFO: renamed from: q */
    private static /* synthetic */ boolean f2748q = false;

    /* JADX INFO: renamed from: r */
    private static int f2749r = 0;

    /* JADX INFO: renamed from: s */
    private static int[] f2750s = null;

    /* JADX INFO: renamed from: u */
    private static int f2751u = 1;

    /* JADX INFO: renamed from: D */
    private final WeakReference<AbstractActivityC2220h> f2752D;

    /* JADX INFO: renamed from: a */
    private CameraCharacteristics f2753a;

    /* JADX INFO: renamed from: b */
    private final com.facetec.sdk.Code f2754b;

    /* JADX INFO: renamed from: c */
    private String f2755c;

    /* JADX INFO: renamed from: d */
    private CameraCaptureSession f2756d;

    /* JADX INFO: renamed from: e */
    private CameraDevice f2757e;

    /* JADX INFO: renamed from: f */
    private int f2758f;

    /* JADX INFO: renamed from: h */
    private CaptureRequest.Builder f2760h;

    /* JADX INFO: renamed from: i */
    private HandlerThread f2761i;

    /* JADX INFO: renamed from: j */
    private Handler f2762j;

    /* JADX INFO: renamed from: m */
    private final C2175bo f2765m;

    /* JADX INFO: renamed from: o */
    private C2161ba f2767o;

    /* JADX INFO: renamed from: t */
    private final TextureView.SurfaceTextureListener f2769t;

    /* JADX INFO: renamed from: g */
    private final Semaphore f2759g = new Semaphore(1);

    /* JADX INFO: renamed from: n */
    private boolean f2766n = false;

    /* JADX INFO: renamed from: k */
    private boolean f2763k = false;

    /* JADX INFO: renamed from: l */
    private final C2161ba.I f2764l = new C2161ba.I() { // from class: com.facetec.sdk.bd.4
        @Override // com.facetec.sdk.C2161ba.I
        public final void Code(byte[] bArr, Size size) {
            C2138ad c2138ad;
            C2164bd.this.f2783B = true;
            AbstractActivityC2219g abstractActivityC2219g = (AbstractActivityC2219g) C2164bd.m1825V(C2164bd.this).get();
            if (abstractActivityC2219g == null || (c2138ad = abstractActivityC2219g.f3470B) == null || !c2138ad.m1474Z()) {
                return;
            }
            c2138ad.m1468I(bArr, size.getWidth(), size.getHeight(), C2164bd.m1814B(C2164bd.this), Boolean.TRUE);
        }
    };

    /* JADX INFO: renamed from: p */
    private final CameraDevice.StateCallback f2768p = new CameraDevice.StateCallback() { // from class: com.facetec.sdk.bd.5
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice cameraDevice) {
            C2164bd.m1821L(C2164bd.this).release();
            C2164bd.m1824V(C2164bd.this, cameraDevice);
            C2164bd.m1817F(C2164bd.this);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice cameraDevice) {
            C2164bd.m1821L(C2164bd.this).release();
            cameraDevice.close();
            C2164bd.m1824V(C2164bd.this, (CameraDevice) null);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice cameraDevice, int i) {
            C2164bd.m1821L(C2164bd.this).release();
            cameraDevice.close();
            C2164bd.m1824V(C2164bd.this, (CameraDevice) null);
            AbstractActivityC2220h abstractActivityC2220h = (AbstractActivityC2220h) C2164bd.m1825V(C2164bd.this).get();
            if (abstractActivityC2220h != null) {
                abstractActivityC2220h.mo2180B("Camera2 device error: ".concat(String.valueOf(i)));
            }
        }
    };

    /* JADX INFO: renamed from: I */
    static void m1819I() {
        f2750s = new int[]{1066418101, 1537371690, 399946985, -1087869108, -1883177697, 1241107370, 220981133, -1626611217, 711980461, -1494069018, 1440759351, 640497238, -946138539, 206554985, -672416242, 1763068346, 1910935665, 1721353296};
    }

    @Override // com.facetec.sdk.AbstractC2165be
    final void Code(boolean z) {
        int i = 2 % 2;
        int i2 = f2749r + 83;
        f2751u = i2 % 128;
        if (i2 % 2 != 0) {
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: V */
    final void mo1834V(MotionEvent motionEvent, ViewGroup viewGroup) {
        int i = 2 % 2;
        int i2 = f2751u + 27;
        f2749r = i2 % 128;
        int i3 = i2 % 2;
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: V */
    final void mo1835V(boolean z) {
        int i = 2 % 2;
        int i2 = f2749r + 61;
        f2751u = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 66 / 0;
        }
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: Z */
    final void mo1837Z(boolean z) {
        int i = 2 % 2;
        int i2 = f2749r + 107;
        f2751u = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    static {
        m1819I();
        f2748q = true;
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2747L = sparseIntArray;
        sparseIntArray.append(0, 90);
        sparseIntArray.append(1, 0);
        sparseIntArray.append(2, RotationOptions.ROTATE_270);
        sparseIntArray.append(3, RotationOptions.ROTATE_180);
        int i = f2751u + 51;
        f2749r = i % 128;
        if (i % 2 == 0) {
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: B */
    static /* synthetic */ int m1814B(C2164bd c2164bd) {
        int i = 2 % 2;
        int i2 = f2751u;
        int i3 = i2 + 113;
        f2749r = i3 % 128;
        int i4 = i3 % 2;
        int i5 = c2164bd.f2758f;
        if (i4 != 0) {
            int i6 = 80 / 0;
        }
        int i7 = i2 + 113;
        f2749r = i7 % 128;
        int i8 = i7 % 2;
        return i5;
    }

    /* JADX INFO: renamed from: B */
    static /* synthetic */ CameraCaptureSession m1815B(C2164bd c2164bd, CameraCaptureSession cameraCaptureSession) {
        int i = 2 % 2;
        int i2 = f2751u + 65;
        f2749r = i2 % 128;
        int i3 = i2 % 2;
        c2164bd.f2756d = cameraCaptureSession;
        if (i3 == 0) {
            return cameraCaptureSession;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    static /* synthetic */ CaptureRequest.Builder Code(C2164bd c2164bd) {
        int i = 2 % 2;
        int i2 = f2749r + 27;
        f2751u = i2 % 128;
        int i3 = i2 % 2;
        CaptureRequest.Builder builder = c2164bd.f2760h;
        if (i3 != 0) {
            return builder;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    static /* synthetic */ void Code(C2164bd c2164bd, Activity activity, int i, int i2) throws C2167bg {
        int i3 = 2 % 2;
        int i4 = f2751u + 61;
        f2749r = i4 % 128;
        int i5 = i4 % 2;
        c2164bd.m1820I(activity, i, i2);
        if (i5 != 0) {
            int i6 = 22 / 0;
        }
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ CameraDevice m1818I(C2164bd c2164bd) {
        int i = 2 % 2;
        int i2 = f2751u + 121;
        int i3 = i2 % 128;
        f2749r = i3;
        int i4 = i2 % 2;
        CameraDevice cameraDevice = c2164bd.f2757e;
        if (i4 != 0) {
            Object obj = null;
            super.hashCode();
            throw null;
        }
        int i5 = i3 + 21;
        f2751u = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 65 / 0;
        }
        return cameraDevice;
    }

    /* JADX INFO: renamed from: L */
    static /* synthetic */ Semaphore m1821L(C2164bd c2164bd) {
        int i = 2 % 2;
        int i2 = f2749r + 9;
        int i3 = i2 % 128;
        f2751u = i3;
        int i4 = i2 % 2;
        Object obj = null;
        Semaphore semaphore = c2164bd.f2759g;
        if (i4 == 0) {
            super.hashCode();
            throw null;
        }
        int i5 = i3 + 75;
        f2749r = i5 % 128;
        if (i5 % 2 == 0) {
            return semaphore;
        }
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: S */
    static /* synthetic */ void m1823S(C2164bd c2164bd) throws C2167bg {
        int i = 2 % 2;
        int i2 = f2751u + 81;
        f2749r = i2 % 128;
        int i3 = i2 % 2;
        c2164bd.m1822L();
        int i4 = f2751u + 53;
        f2749r = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX INFO: renamed from: V */
    static /* synthetic */ CameraDevice m1824V(C2164bd c2164bd, CameraDevice cameraDevice) {
        int i = 2 % 2;
        int i2 = f2749r + 71;
        f2751u = i2 % 128;
        int i3 = i2 % 2;
        c2164bd.f2757e = cameraDevice;
        if (i3 != 0) {
            return cameraDevice;
        }
        throw null;
    }

    /* JADX INFO: renamed from: V */
    static /* synthetic */ WeakReference m1825V(C2164bd c2164bd) {
        int i = 2 % 2;
        int i2 = f2749r + 119;
        f2751u = i2 % 128;
        int i3 = i2 % 2;
        WeakReference<AbstractActivityC2220h> weakReference = c2164bd.f2752D;
        if (i3 != 0) {
            return weakReference;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: V */
    static /* synthetic */ void m1826V(C2164bd c2164bd, int i, int i2) {
        int i3 = 2 % 2;
        int i4 = f2751u + 49;
        f2749r = i4 % 128;
        int i5 = i4 % 2;
        c2164bd.Code(i, i2);
        if (i5 == 0) {
            return;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ CameraCaptureSession m1828Z(C2164bd c2164bd) {
        int i = 2 % 2;
        int i2 = f2749r + 125;
        f2751u = i2 % 128;
        int i3 = i2 % 2;
        CameraCaptureSession cameraCaptureSession = c2164bd.f2756d;
        if (i3 == 0) {
            int i4 = 27 / 0;
        }
        return cameraCaptureSession;
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ boolean m1832Z(C2164bd c2164bd, CameraCharacteristics.Key key, int i) {
        int i2 = 2 % 2;
        int i3 = f2749r + 91;
        f2751u = i3 % 128;
        int i4 = i3 % 2;
        boolean zCode = c2164bd.Code((CameraCharacteristics.Key<int[]>) key, i);
        if (i4 == 0) {
            int i5 = 14 / 0;
        }
        int i6 = f2749r + 107;
        f2751u = i6 % 128;
        if (i6 % 2 != 0) {
            return zCode;
        }
        Object obj = null;
        super.hashCode();
        throw null;
    }

    C2164bd(Activity activity) throws C2167bg {
        TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.facetec.sdk.bd.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                AbstractActivityC2220h abstractActivityC2220h = (AbstractActivityC2220h) C2164bd.m1825V(C2164bd.this).get();
                if (abstractActivityC2220h == null) {
                    return;
                }
                try {
                    C2164bd.Code(C2164bd.this, abstractActivityC2220h, i, i2);
                } catch (Throwable th) {
                    C2121D.Code(th);
                    abstractActivityC2220h.mo2180B(th.getMessage());
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                C2164bd.m1826V(C2164bd.this, i, i2);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                try {
                    C2164bd.m1823S(C2164bd.this);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
        };
        this.f2769t = surfaceTextureListener;
        this.f2752D = new WeakReference<>((AbstractActivityC2220h) activity);
        this.f2765m = m1842V();
        com.facetec.sdk.Code code = new com.facetec.sdk.Code(activity);
        this.f2754b = code;
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.f2761i = handlerThread;
        handlerThread.start();
        this.f2762j = new Handler(this.f2761i.getLooper());
        if (code.isAvailable()) {
            m1820I(activity, code.getWidth(), code.getHeight());
        } else {
            code.setSurfaceTextureListener(surfaceTextureListener);
        }
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: B */
    final void mo1833B() {
        int i = 2 % 2;
        int i2 = f2749r + 11;
        int i3 = i2 % 128;
        f2751u = i3;
        int i4 = i2 % 2;
        if (this.f2766n) {
            return;
        }
        this.f2766n = true;
        C2161ba c2161ba = this.f2767o;
        if (c2161ba != null) {
            int i5 = i3 + 93;
            f2749r = i5 % 128;
            int i6 = i5 % 2;
            c2161ba.m1810V(this.f2764l);
        }
    }

    @Override // com.facetec.sdk.AbstractC2165be
    public final void Code() {
        int i = 2 % 2;
        int i2 = f2751u + 5;
        f2749r = i2 % 128;
        int i3 = i2 % 2;
        HandlerThread handlerThread = this.f2761i;
        Object obj = null;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.f2761i.join();
                this.f2761i = null;
                this.f2762j.removeCallbacksAndMessages(null);
                this.f2762j = null;
            } catch (InterruptedException e) {
                C2121D.Code(e);
            }
        }
        try {
            m1822L();
        } catch (Exception unused) {
        }
        C2161ba c2161ba = this.f2767o;
        if (c2161ba != null) {
            int i4 = f2749r + 97;
            f2751u = i4 % 128;
            if (i4 % 2 != 0) {
                c2161ba.m1808B();
                this.f2767o = null;
            } else {
                c2161ba.m1808B();
                this.f2767o = null;
                super.hashCode();
                throw null;
            }
        }
        this.f2763k = true;
        int i5 = f2749r + 61;
        f2751u = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 27 / 0;
        }
    }

    @Override // com.facetec.sdk.AbstractC2165be
    /* JADX INFO: renamed from: Z */
    public final View mo1836Z() {
        int i = 2 % 2;
        int i2 = f2751u + 13;
        f2749r = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f2754b;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0064 A[PHI: r8 r9
      0x0064: PHI (r8v4 android.util.Size) = (r8v3 android.util.Size), (r8v5 android.util.Size) binds: [B:10:0x0062, B:7:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x0064: PHI (r9v3 int) = (r9v2 int), (r9v8 int) binds: [B:10:0x0062, B:7:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m1831Z(android.content.Context r12, android.hardware.camera2.params.StreamConfigurationMap r13) {
        /*
            r11 = this;
            r0 = 2
            int r1 = r0 % r0
            java.lang.Class<android.renderscript.Allocation> r1 = android.renderscript.Allocation.class
            android.util.Size[] r13 = r13.getOutputSizes(r1)
            com.facetec.sdk.bd$2 r1 = new com.facetec.sdk.bd$2
            r1.<init>()
            java.util.Arrays.sort(r13, r1)
            android.util.Size r1 = new android.util.Size
            r2 = 640(0x280, float:8.97E-43)
            r3 = 360(0x168, float:5.04E-43)
            r1.<init>(r2, r3)
            com.facetec.sdk.bo r2 = r11.f2765m
            int r2 = r2.f2911Z
            float r2 = (float) r2
            com.facetec.sdk.bo r3 = r11.f2765m
            int r3 = r3.f2910B
            float r3 = (float) r3
            float r2 = r2 / r3
            int r3 = r1.getWidth()
            int r4 = r1.getHeight()
            int r3 = r3 * r4
            int r4 = r3 << 2
            int r5 = r13.length
            int r6 = com.facetec.sdk.C2164bd.f2751u
            int r6 = r6 + 67
            int r7 = r6 % 128
            com.facetec.sdk.C2164bd.f2749r = r7
            int r6 = r6 % r0
            r6 = 0
            r7 = 0
        L3c:
            if (r7 >= r5) goto L82
            int r8 = com.facetec.sdk.C2164bd.f2751u
            int r8 = r8 + 9
            int r9 = r8 % 128
            com.facetec.sdk.C2164bd.f2749r = r9
            int r8 = r8 % r0
            if (r8 == 0) goto L57
            r8 = r13[r7]
            int r9 = r8.getHeight()
            int r10 = r8.getWidth()
            int r9 = r9 >>> r10
            if (r9 < r3) goto L7f
            goto L64
        L57:
            r8 = r13[r7]
            int r9 = r8.getHeight()
            int r10 = r8.getWidth()
            int r9 = r9 * r10
            if (r9 < r3) goto L7f
        L64:
            if (r9 > r4) goto L7f
            int r9 = r8.getWidth()
            float r9 = (float) r9
            int r10 = r8.getHeight()
            float r10 = (float) r10
            float r9 = r9 / r10
            r10 = 1077936128(0x40400000, float:3.0)
            int r10 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r10 > 0) goto L7f
            int r6 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r6 == 0) goto L7d
            r6 = r8
            goto L7f
        L7d:
            r6 = r8
            goto L82
        L7f:
            int r7 = r7 + 1
            goto L3c
        L82:
            if (r6 != 0) goto L85
            goto L86
        L85:
            r1 = r6
        L86:
            r1.getWidth()
            r1.getHeight()
            com.facetec.sdk.ba r13 = new com.facetec.sdk.ba     // Catch: java.lang.Throwable -> La6
            r13.<init>(r12, r1)     // Catch: java.lang.Throwable -> La6
            r11.f2767o = r13     // Catch: java.lang.Throwable -> La6
            boolean r12 = r11.f2766n     // Catch: java.lang.Throwable -> La6
            if (r12 == 0) goto La5
            com.facetec.sdk.ba$I r12 = r11.f2764l     // Catch: java.lang.Throwable -> La6
            r13.m1810V(r12)     // Catch: java.lang.Throwable -> La6
            int r12 = com.facetec.sdk.C2164bd.f2751u
            int r12 = r12 + 31
            int r13 = r12 % 128
            com.facetec.sdk.C2164bd.f2749r = r13
            int r12 = r12 % r0
        La5:
            return
        La6:
            r12 = move-exception
            com.facetec.sdk.C2121D.Code(r12)
            java.lang.String r13 = r12.getMessage()
            com.facetec.sdk.C2188cb.m1995V(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2164bd.m1831Z(android.content.Context, android.hardware.camera2.params.StreamConfigurationMap):void");
    }

    /* JADX INFO: renamed from: Z */
    private void m1830Z(Activity activity) throws CameraAccessException, C2167bg {
        int i = 2 % 2;
        Code Code2 = Code(activity);
        if (Code2 == null) {
            throw new C2167bg(C2167bg.B.FRONT_FACING_NOT_FOUND);
        }
        String str = Code2.f2773I;
        CameraCharacteristics cameraCharacteristics = Code2.f2775Z;
        StreamConfigurationMap streamConfigurationMap = Code2.f2772B;
        activity.getWindowManager().getDefaultDisplay().getRotation();
        this.f2758f = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        activity.getWindowManager().getDefaultDisplay().getSize(new Point());
        activity.getWindowManager().getDefaultDisplay().getRealSize(new Point());
        if (activity.getResources().getConfiguration().orientation == 2) {
            this.f2754b.setAspectRatio(this.f2765m.f2911Z, this.f2765m.f2910B);
            AbstractC2165be.f2778I = this.f2765m.f2910B / this.f2765m.f2911Z;
            int i2 = f2749r + 91;
            f2751u = i2 % 128;
            if (i2 % 2 == 0) {
                int i3 = 4 / 5;
            }
        } else {
            this.f2754b.setAspectRatio(this.f2765m.f2910B, this.f2765m.f2911Z);
            AbstractC2165be.f2778I = this.f2765m.f2911Z / this.f2765m.f2910B;
            int i4 = f2749r + 51;
            f2751u = i4 % 128;
            int i5 = i4 % 2;
        }
        m1831Z(activity, streamConfigurationMap);
        this.f2755c = str;
        this.f2753a = cameraCharacteristics;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bd$Code */
    static class Code {

        /* JADX INFO: renamed from: B */
        StreamConfigurationMap f2772B;

        /* JADX INFO: renamed from: I */
        String f2773I;

        /* JADX INFO: renamed from: V */
        boolean f2774V;

        /* JADX INFO: renamed from: Z */
        CameraCharacteristics f2775Z;

        private Code() {
            this.f2774V = false;
        }

        /* synthetic */ Code(byte b) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.facetec.sdk.C2164bd.Code Code(android.content.Context r13) throws com.facetec.sdk.C2167bg {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2164bd.Code(android.content.Context):com.facetec.sdk.bd$Code");
    }

    /* JADX INFO: renamed from: V */
    static boolean m1827V(Context context) throws C2167bg {
        int i = 2 % 2;
        Code Code2 = Code(context);
        Object obj = null;
        if (Code2 != null) {
            int i2 = f2751u + 25;
            f2749r = i2 % 128;
            int i3 = i2 % 2;
            boolean z = Code2.f2774V;
            if (i3 != 0) {
                throw null;
            }
            if (z) {
                int i4 = f2749r + 95;
                f2751u = i4 % 128;
                int i5 = i4 % 2;
                return true;
            }
        }
        int i6 = f2749r + 59;
        f2751u = i6 % 128;
        if (i6 % 2 != 0) {
            return false;
        }
        super.hashCode();
        throw null;
    }

    /* JADX INFO: renamed from: I */
    private void m1820I(Activity activity, int i, int i2) throws C2167bg {
        int i3 = 2 % 2;
        if (this.f2763k) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(activity, "android.permission.CAMERA") != 0) {
            throw new C2167bg(C2167bg.B.PERMISSION_DENIED);
        }
        try {
            m1830Z(activity);
            Code(i, i2);
            CameraManager cameraManager = (CameraManager) activity.getSystemService("camera");
            if (cameraManager == null) {
                throw new C2167bg(C2167bg.B.PERMISSION_DENIED);
            }
            try {
                if (!this.f2759g.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                    throw new C2167bg(C2167bg.B.OPEN_TIMEOUT);
                }
                int i4 = f2751u + 53;
                int i5 = i4 % 128;
                f2749r = i5;
                int i6 = i4 % 2;
                int i7 = i5 + 107;
                f2751u = i7 % 128;
                int i8 = i7 % 2;
                try {
                    cameraManager.openCamera(this.f2755c, this.f2768p, (Handler) null);
                } catch (Exception e) {
                    this.f2759g.release();
                    throw new C2167bg(C2167bg.B.UNKNOWN, e.getMessage());
                }
            } catch (InterruptedException e2) {
                C2121D.Code(e2);
                throw new C2167bg(C2167bg.B.LOCK_OPEN_TIMEOUT, e2);
            }
        } catch (CameraAccessException e3) {
            throw new C2167bg(C2167bg.B.UNKNOWN, e3.getMessage());
        }
    }

    /* JADX INFO: renamed from: L */
    private void m1822L() throws C2167bg {
        boolean zTryAcquire;
        int i = 2 % 2;
        try {
            zTryAcquire = this.f2759g.tryAcquire(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C2121D.Code(e);
            zTryAcquire = false;
        }
        try {
            try {
                CameraCaptureSession cameraCaptureSession = this.f2756d;
                Object obj = null;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.f2756d = null;
                }
                CameraDevice cameraDevice = this.f2757e;
                if (cameraDevice != null) {
                    int i2 = f2751u + 69;
                    f2749r = i2 % 128;
                    int i3 = i2 % 2;
                    cameraDevice.close();
                    this.f2757e = null;
                }
                if (!zTryAcquire) {
                    int i4 = f2751u + 13;
                    f2749r = i4 % 128;
                    if (i4 % 2 != 0) {
                        throw null;
                    }
                    return;
                }
                int i5 = f2749r + 89;
                f2751u = i5 % 128;
                if (i5 % 2 != 0) {
                    this.f2759g.release();
                } else {
                    this.f2759g.release();
                    super.hashCode();
                    throw null;
                }
            } catch (Exception e2) {
                throw new C2167bg(C2167bg.B.CLOSE_ERROR, e2);
            }
        } catch (Throwable th) {
            if (zTryAcquire) {
                this.f2759g.release();
            }
            throw th;
        }
    }

    private boolean Code(CameraCharacteristics.Key<int[]> key, int i) {
        int i2 = 2 % 2;
        int i3 = f2749r + 29;
        f2751u = i3 % 128;
        int i4 = i3 % 2;
        int[] iArr = (int[]) this.f2753a.get(key);
        Object obj = null;
        if (iArr != null) {
            int length = iArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = f2749r + 67;
                f2751u = i6 % 128;
                if (i6 % 2 != 0) {
                    if (iArr[i5] == i) {
                        return true;
                    }
                } else {
                    int i7 = iArr[i5];
                    super.hashCode();
                    throw null;
                }
            }
        }
        int i8 = f2749r + 37;
        f2751u = i8 % 128;
        if (i8 % 2 != 0) {
            return false;
        }
        super.hashCode();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Code(int r10, int r11) {
        /*
            r9 = this;
            r0 = 2
            int r1 = r0 % r0
            java.lang.ref.WeakReference<com.facetec.sdk.h> r1 = r9.f2752D
            java.lang.Object r1 = r1.get()
            com.facetec.sdk.h r1 = (com.facetec.sdk.AbstractActivityC2220h) r1
            com.facetec.sdk.Code r2 = r9.f2754b
            if (r2 == 0) goto La6
            int r2 = com.facetec.sdk.C2164bd.f2749r
            int r2 = r2 + 61
            int r3 = r2 % 128
            com.facetec.sdk.C2164bd.f2751u = r3
            int r2 = r2 % r0
            if (r1 != 0) goto L1c
            goto La6
        L1c:
            android.view.WindowManager r1 = r1.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            int r1 = r1.getRotation()
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            android.graphics.RectF r3 = new android.graphics.RectF
            float r10 = (float) r10
            float r11 = (float) r11
            r4 = 0
            r3.<init>(r4, r4, r10, r11)
            android.graphics.RectF r5 = new android.graphics.RectF
            com.facetec.sdk.bo r6 = r9.f2765m
            int r6 = r6.f2910B
            float r6 = (float) r6
            com.facetec.sdk.bo r7 = r9.f2765m
            int r7 = r7.f2911Z
            float r7 = (float) r7
            r5.<init>(r4, r4, r6, r7)
            float r4 = r3.centerX()
            float r6 = r3.centerY()
            r7 = 1
            if (r7 == r1) goto L6a
            int r7 = com.facetec.sdk.C2164bd.f2751u
            int r7 = r7 + 97
            int r8 = r7 % 128
            com.facetec.sdk.C2164bd.f2749r = r8
            int r7 = r7 % r0
            if (r7 == 0) goto L5e
            r7 = 4
            if (r7 != r1) goto L62
            goto L6a
        L5e:
            r7 = 3
            if (r7 != r1) goto L62
            goto L6a
        L62:
            if (r0 != r1) goto L98
            r10 = 1127481344(0x43340000, float:180.0)
            r2.postRotate(r10, r4, r6)
            goto L98
        L6a:
            float r7 = r5.centerX()
            float r7 = r4 - r7
            float r8 = r5.centerY()
            float r8 = r6 - r8
            r5.offset(r7, r8)
            android.graphics.Matrix$ScaleToFit r7 = android.graphics.Matrix.ScaleToFit.FILL
            r2.setRectToRect(r3, r5, r7)
            com.facetec.sdk.bo r3 = r9.f2765m
            int r3 = r3.f2910B
            float r3 = (float) r3
            float r11 = r11 / r3
            com.facetec.sdk.bo r3 = r9.f2765m
            int r3 = r3.f2911Z
            float r3 = (float) r3
            float r10 = r10 / r3
            float r10 = java.lang.Math.max(r11, r10)
            r2.postScale(r10, r10, r4, r6)
            int r1 = r1 - r0
            int r1 = r1 * 90
            float r10 = (float) r1
            r2.postRotate(r10, r4, r6)
        L98:
            com.facetec.sdk.Code r10 = r9.f2754b
            r10.setTransform(r2)
            int r10 = com.facetec.sdk.C2164bd.f2751u
            int r10 = r10 + 109
            int r11 = r10 % 128
            com.facetec.sdk.C2164bd.f2749r = r11
            int r10 = r10 % r0
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2164bd.Code(int, int):void");
    }

    /* JADX INFO: renamed from: B */
    static float m1813B(Activity activity) throws C2167bg {
        int i = 2 % 2;
        int i2 = f2749r + 23;
        f2751u = i2 % 128;
        if (i2 % 2 == 0) {
            C2175bo c2175boM1829Z = m1829Z((Context) activity);
            return c2175boM1829Z.f2911Z - c2175boM1829Z.f2910B;
        }
        C2175bo c2175boM1829Z2 = m1829Z((Context) activity);
        return c2175boM1829Z2.f2911Z / c2175boM1829Z2.f2910B;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facetec.sdk.C2175bo m1829Z(android.content.Context r18) throws com.facetec.sdk.C2167bg {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facetec.sdk.C2164bd.m1829Z(android.content.Context):com.facetec.sdk.bo");
    }

    /* JADX INFO: renamed from: F */
    static /* synthetic */ void m1817F(C2164bd c2164bd) {
        int i = 2 % 2;
        int i2 = f2749r + 75;
        f2751u = i2 % 128;
        int i3 = i2 % 2;
        try {
            if (c2164bd.f2767o == null) {
                return;
            }
            SurfaceTexture surfaceTexture = c2164bd.f2754b.getSurfaceTexture();
            if (!f2748q && surfaceTexture == null) {
                throw new AssertionError();
            }
            surfaceTexture.setDefaultBufferSize(c2164bd.f2765m.f2911Z, c2164bd.f2765m.f2910B);
            Surface surface = new Surface(surfaceTexture);
            Surface surfaceM1809I = c2164bd.f2767o.m1809I();
            CaptureRequest.Builder builderCreateCaptureRequest = c2164bd.f2757e.createCaptureRequest(1);
            c2164bd.f2760h = builderCreateCaptureRequest;
            builderCreateCaptureRequest.addTarget(surface);
            c2164bd.f2760h.addTarget(surfaceM1809I);
            c2164bd.f2760h.set(CaptureRequest.CONTROL_MODE, 1);
            if (c2164bd.Code(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES, 11)) {
                int i4 = f2749r + 103;
                f2751u = i4 % 128;
                int i5 = i4 % 2;
                c2164bd.f2760h.set(CaptureRequest.CONTROL_SCENE_MODE, 11);
            }
            c2164bd.f2760h.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.FALSE);
            c2164bd.f2760h.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            c2164bd.f2760h.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
            c2164bd.f2757e.createCaptureSession(Arrays.asList(surface, surfaceM1809I), new CameraCaptureSession.StateCallback() { // from class: com.facetec.sdk.bd.3
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    if (C2164bd.m1818I(C2164bd.this) == null) {
                        return;
                    }
                    C2164bd.m1815B(C2164bd.this, cameraCaptureSession);
                    try {
                        if (C2164bd.m1832Z(C2164bd.this, CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, 4)) {
                            C2164bd.Code(C2164bd.this).set(CaptureRequest.CONTROL_AF_MODE, 4);
                        }
                        if (C2164bd.m1832Z(C2164bd.this, CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, 1)) {
                            C2164bd.Code(C2164bd.this).set(CaptureRequest.CONTROL_AE_MODE, 1);
                        }
                        C2164bd.m1828Z(C2164bd.this).setRepeatingRequest(C2164bd.Code(C2164bd.this).build(), null, null);
                    } catch (CameraAccessException e) {
                        C2121D.Code(e);
                    }
                }
            }, null);
        } catch (CameraAccessException e) {
            C2121D.Code(e);
        }
    }

    /* JADX INFO: renamed from: B */
    private static String m1816B(int[] iArr, int i) {
        String str;
        synchronized (C2196cj.f3040Z) {
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length << 1];
            int[] iArr2 = (int[]) f2750s.clone();
            C2196cj.f3039V = 0;
            while (C2196cj.f3039V < iArr.length) {
                cArr[0] = (char) (iArr[C2196cj.f3039V] >> 16);
                cArr[1] = (char) iArr[C2196cj.f3039V];
                cArr[2] = (char) (iArr[C2196cj.f3039V + 1] >> 16);
                cArr[3] = (char) iArr[C2196cj.f3039V + 1];
                C2196cj.Code = (cArr[0] << 16) + cArr[1];
                C2196cj.f3038B = (cArr[2] << 16) + cArr[3];
                C2196cj.m1998V(iArr2);
                for (int i2 = 0; i2 < 16; i2++) {
                    int i3 = C2196cj.Code ^ iArr2[i2];
                    C2196cj.Code = i3;
                    C2196cj.f3038B = C2196cj.Code(i3) ^ C2196cj.f3038B;
                    int i4 = C2196cj.Code;
                    C2196cj.Code = C2196cj.f3038B;
                    C2196cj.f3038B = i4;
                }
                int i5 = C2196cj.Code;
                C2196cj.Code = C2196cj.f3038B;
                C2196cj.f3038B = i5;
                C2196cj.f3038B = i5 ^ iArr2[16];
                C2196cj.Code ^= iArr2[17];
                int i6 = C2196cj.Code;
                int i7 = C2196cj.f3038B;
                cArr[0] = (char) (C2196cj.Code >>> 16);
                cArr[1] = (char) C2196cj.Code;
                cArr[2] = (char) (C2196cj.f3038B >>> 16);
                cArr[3] = (char) C2196cj.f3038B;
                C2196cj.m1998V(iArr2);
                cArr2[C2196cj.f3039V << 1] = cArr[0];
                cArr2[(C2196cj.f3039V << 1) + 1] = cArr[1];
                cArr2[(C2196cj.f3039V << 1) + 2] = cArr[2];
                cArr2[(C2196cj.f3039V << 1) + 3] = cArr[3];
                C2196cj.f3039V += 2;
            }
            str = new String(cArr2, 0, i);
        }
        return str;
    }
}
