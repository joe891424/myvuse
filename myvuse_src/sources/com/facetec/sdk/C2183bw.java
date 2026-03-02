package com.facetec.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.facetec.sdk.C2138ad;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.facetec.sdk.bw */
/* JADX INFO: loaded from: classes3.dex */
final class C2183bw implements SensorEventListener {

    /* JADX INFO: renamed from: B */
    private Timer f2985B;

    /* JADX INFO: renamed from: D */
    private boolean f2987D;

    /* JADX INFO: renamed from: F */
    private boolean f2988F;

    /* JADX INFO: renamed from: I */
    private final SensorManager f2989I;

    /* JADX INFO: renamed from: S */
    private int f2990S;

    /* JADX INFO: renamed from: V */
    private Sensor f2991V;

    /* JADX INFO: renamed from: Z */
    private Timer f2992Z;
    private WeakReference<V> Code = new WeakReference<>(null);

    /* JADX INFO: renamed from: C */
    private WeakReference<C2138ad> f2986C = new WeakReference<>(null);

    /* JADX INFO: renamed from: com.facetec.sdk.bw$V */
    interface V {
        /* JADX INFO: renamed from: V */
        void mo1398V();
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    C2183bw(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f2989I = sensorManager;
        this.f2991V = sensorManager.getDefaultSensor(5);
        this.f2988F = false;
        this.f2987D = false;
        this.f2990S = 0;
    }

    /* JADX INFO: renamed from: B */
    final synchronized void m1974B(V v, C2138ad c2138ad) {
        this.Code = new WeakReference<>(v);
        this.f2986C = new WeakReference<>(c2138ad);
        if (this.f2991V != null) {
            new Handler().postDelayed(new Runnable() { // from class: com.facetec.sdk.bw.2
                @Override // java.lang.Runnable
                public final void run() {
                    C2183bw.this.f2989I.registerListener(this, C2183bw.this.f2991V, 0);
                }
            }, 50L);
            this.f2987D = true;
        }
        TimerTask timerTask = new TimerTask() { // from class: com.facetec.sdk.bw.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                C2183bw.m1971I(C2183bw.this);
            }
        };
        Timer timer = new Timer();
        this.f2985B = timer;
        try {
            timer.scheduleAtFixedRate(timerTask, 500L, 1000L);
        } catch (IllegalStateException unused) {
        }
    }

    private synchronized void Code() {
        if (this.f2992Z == null) {
            Timer timer = new Timer();
            this.f2992Z = timer;
            try {
                timer.schedule(new TimerTask() { // from class: com.facetec.sdk.bw.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public final void run() {
                        V v = (V) C2183bw.this.Code.get();
                        if (v != null) {
                            v.mo1398V();
                            C2183bw.this.m1975Z();
                        }
                    }
                }, 200L);
            } catch (IllegalStateException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: B */
    private void m1970B() {
        Timer timer = this.f2992Z;
        if (timer != null) {
            timer.cancel();
            this.f2992Z = null;
        }
    }

    /* JADX INFO: renamed from: Z */
    final void m1975Z() {
        this.f2988F = true;
        final Sensor sensor = this.f2991V;
        if (sensor != null) {
            this.f2991V = null;
            AbstractAsyncTaskC2155au.m1616Z(new Runnable() { // from class: com.facetec.sdk.bw.5
                @Override // java.lang.Runnable
                public final void run() {
                    C2183bw.this.f2989I.unregisterListener(C2183bw.this, sensor);
                }
            });
        }
        m1970B();
        Timer timer = this.f2985B;
        if (timer != null) {
            timer.cancel();
            this.f2985B = null;
        }
        WeakReference<V> weakReference = this.Code;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (this.f2988F) {
            return;
        }
        this.f2990S = 0;
        if (sensorEvent.values[0] < 3.0f) {
            Code();
        } else {
            m1970B();
        }
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m1971I(C2183bw c2183bw) {
        C2138ad.Code codeM1472V;
        c2183bw.f2990S++;
        C2138ad c2138ad = c2183bw.f2986C.get();
        if (c2138ad != null) {
            boolean z = c2183bw.f2987D;
            if ((z && (!z || c2183bw.f2990S <= 1)) || (codeM1472V = c2138ad.m1472V()) == null || codeM1472V.f2387V == null) {
                return;
            }
            byte[] bArr = codeM1472V.f2387V;
            int i = codeM1472V.f2386B * codeM1472V.f2388Z;
            int i2 = i / 4;
            float f = 0.0f;
            int i3 = 0;
            for (int i4 = 1; i4 <= i; i4 += 4) {
                i3 += bArr[i4 - 1] & 255;
                if (i4 % 8421504 == 0) {
                    f += i3 / i2;
                    i3 = 0;
                }
            }
            if (((int) (f + (i3 / i2))) < 75.0f) {
                c2183bw.Code();
            } else {
                c2183bw.m1970B();
            }
        }
    }
}
