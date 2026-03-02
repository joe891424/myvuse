package com.microblink.blinkid.secured;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class llIIlIlIIl implements SensorEventListener {
    private SensorManager IllIIIIllI;
    private Handler lIIIIIllll;
    private int lIlIIIIlIl;
    private Sensor llIIIlllll;
    private llIllllIIl llIIlIlIIl;
    private ShakeCallback IlIllIlIIl = null;
    private AtomicBoolean IllIIIllII = new AtomicBoolean(true);
    private long llIIlIIlll = -1;
    private Timer IIlIIIllIl = null;

    /* JADX INFO: renamed from: com.microblink.blinkid.secured.llIIlIlIIl$llIIlIlIIl, reason: collision with other inner class name */
    /* JADX INFO: compiled from: line */
    private class C5988llIIlIlIIl extends TimerTask {
        private float[] llIIlIlIIl = {0.0f, 0.0f, 0.0f};

        /* JADX INFO: renamed from: com.microblink.blinkid.secured.llIIlIlIIl$llIIlIlIIl$llIIlIlIIl, reason: collision with other inner class name */
        /* JADX INFO: compiled from: line */
        class RunnableC5989llIIlIlIIl implements Runnable {
            RunnableC5989llIIlIlIIl() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C5988llIIlIlIIl c5988llIIlIlIIl = C5988llIIlIlIIl.this;
                llIIlIlIIl.this.llIIlIlIIl(c5988llIIlIlIIl.llIIlIlIIl);
            }
        }

        C5988llIIlIlIIl() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            llIIlIlIIl.this.lIIIIIllll.post(new RunnableC5989llIIlIlIIl());
        }
    }

    public llIIlIlIIl(Context context, llIllllIIl llilllliil, float f) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.IllIIIIllI = sensorManager;
        this.llIIlIlIIl = llilllliil;
        this.llIIIlllll = sensorManager.getDefaultSensor(1);
        this.lIlIIIIlIl = Math.round(f * 1000.0f) * 1000;
        this.lIIIIIllll = new Handler();
    }

    public boolean IlIllIlIIl() {
        return this.IllIIIllII.get();
    }

    public void IllIIIllII() {
        Log.m2713v(this, "Registering accelerometer sensor listener {}", this);
        boolean zRegisterListener = this.IllIIIIllI.registerListener(this, this.llIIIlllll, this.lIlIIIIlIl);
        llIIlIlIIl(true);
        if (!zRegisterListener) {
            Log.m2709e(this, "unable to register accelerometer sensor with sample period {} microseconds. Trying SENSOR_DELAY_NORMAL...", Integer.valueOf(this.lIlIIIIlIl));
            zRegisterListener = this.IllIIIIllI.registerListener(this, this.llIIIlllll, 3);
            if (!zRegisterListener) {
                Log.m2715w(this, "unable to register accelerometer sensor at all", new Object[0]);
                llIIlIlIIl(false);
            }
        }
        if (zRegisterListener) {
            Timer timer = new Timer("Accelerometer timer");
            this.IIlIIIllIl = timer;
            timer.schedule(new C5988llIIlIlIIl(), 0L, this.lIlIIIIlIl);
        }
    }

    public void llIIIlllll() {
        Log.m2713v(this, "Unregistering accelerometer sensor listener {}", this);
        Timer timer = this.IIlIIIllIl;
        if (timer != null) {
            timer.cancel();
            this.IIlIIIllIl = null;
        }
        this.IllIIIIllI.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.m2711i(this, "Accelerometer accuracy has changed", new Object[0]);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        llIIlIlIIl(sensorEvent.values);
        int i = IIIIIIIIII.llIIlIlIIl;
    }

    public void llIIlIlIIl(ShakeCallback shakeCallback) {
        this.IlIllIlIIl = shakeCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void llIIlIlIIl(float[] fArr) {
        if (this.llIIlIIlll >= 0) {
            if (System.currentTimeMillis() - this.llIIlIIlll > 0) {
                int i = (int) ((r0 * 1000 * 0.33999997f) + (this.lIlIIIIlIl * 0.66f));
                this.lIlIIIIlIl = i;
                this.llIIlIlIIl.llIIlIlIIl((i / 1000.0f) / 1000.0f);
            }
        }
        this.llIIlIlIIl.llIIlIlIIl(fArr[0], fArr[1], fArr[2]);
        if (!this.IllIIIllII.get() && llIIlIlIIl() > 0.47f) {
            llIIlIlIIl(true);
        } else if (this.IllIIIllII.get() && llIIlIlIIl() < 0.2f) {
            llIIlIlIIl(false);
        }
        this.llIIlIIlll = System.currentTimeMillis();
    }

    private float llIIlIlIIl() {
        float fLlIIlIlIIl = this.llIIlIlIIl.llIIlIlIIl();
        float fIlIllIlIIl = this.llIIlIlIIl.IlIllIlIIl();
        float fIllIIIllII = this.llIIlIlIIl.IllIIIllII();
        return (float) Math.sqrt((fIllIIIllII * fIllIIIllII) + (fIlIllIlIIl * fIlIllIlIIl) + (fLlIIlIlIIl * fLlIIlIlIIl));
    }

    private void llIIlIlIIl(boolean z) {
        this.IllIIIllII.set(z);
        if (z) {
            this.IlIllIlIIl.onShakingStarted();
        } else {
            this.IlIllIlIIl.onShakingStopped();
        }
        int i = IIIIIIIIII.llIIlIlIIl;
    }
}
