package com.yoti.mobile.android.facecapture.view.capture.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.facebook.common.callercontext.ContextChain;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/util/LightSensor;", "Landroid/hardware/SensorEventListener;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mSensorManager", "Landroid/hardware/SensorManager;", "(Landroid/hardware/SensorManager;)V", "<set-?>", "", "lastLightLevel", "getLastLightLevel", "()F", "disable", "", "enable", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", ContextChain.TAG_INFRA, "", "onSensorChanged", "sensorEvent", "Landroid/hardware/SensorEvent;", "Companion", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LightSensor implements SensorEventListener, LifecycleObserver {
    public static final float BRIGHTNESS_UNKNOWN = 2000.0f;
    private float lastLightLevel;
    private final SensorManager mSensorManager;

    public LightSensor(SensorManager mSensorManager) {
        Intrinsics.checkNotNullParameter(mSensorManager, "mSensorManager");
        this.mSensorManager = mSensorManager;
        this.lastLightLevel = 2000.0f;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void disable() {
        this.mSensorManager.unregisterListener(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void enable() {
        Sensor defaultSensor = this.mSensorManager.getDefaultSensor(5);
        if (defaultSensor != null) {
            this.mSensorManager.registerListener(this, defaultSensor, 2);
        }
    }

    public final float getLastLightLevel() {
        return this.lastLightLevel;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        this.lastLightLevel = sensorEvent.values[0];
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Inject
    public LightSensor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("sensor");
        if (systemService != null) {
            this((SensorManager) systemService);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
    }
}
