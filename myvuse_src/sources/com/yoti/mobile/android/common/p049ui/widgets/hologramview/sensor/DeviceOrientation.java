package com.yoti.mobile.android.common.p049ui.widgets.hologramview.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import androidx.core.app.NotificationCompat;
import com.brentvatne.react.ReactVideoView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010,\u001a\u00020)¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0005\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/widgets/hologramview/sensor/DeviceOrientation;", "Landroid/hardware/SensorEventListener;", "", "rotationVector", "", "a", "([F)V", "input", "newValues", "", "alpha", "([F[FF)V", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/sensor/SensorListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startListening", "(Lcom/yoti/mobile/android/common/ui/widgets/hologramview/sensor/SensorListener;)V", "stopListening", "()V", "Landroid/hardware/Sensor;", "sensor", "", "accuracy", "onAccuracyChanged", "(Landroid/hardware/Sensor;I)V", "Landroid/hardware/SensorEvent;", NotificationCompat.CATEGORY_EVENT, "onSensorChanged", "(Landroid/hardware/SensorEvent;)V", "I", "lastAccuracy", "d", "[F", "adjustedRotationMatrix", RsaJsonWebKey.EXPONENT_MEMBER_NAME, ReactVideoView.EVENT_PROP_ORIENTATION, "c", "rotationMatrix", "Landroid/hardware/SensorManager;", "g", "Landroid/hardware/SensorManager;", "sensorManager", "Landroid/view/Display;", "h", "Landroid/view/Display;", "display", "f", "b", "Lcom/yoti/mobile/android/common/ui/widgets/hologramview/sensor/SensorListener;", "<init>", "(Landroid/hardware/SensorManager;Landroid/view/Display;)V", "uiWidgets_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class DeviceOrientation implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private int lastAccuracy;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private SensorListener listener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final float[] rotationMatrix;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final float[] adjustedRotationMatrix;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final float[] orientation;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final float[] rotationVector;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final SensorManager sensorManager;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Display display;

    public DeviceOrientation(SensorManager sensorManager, Display display) {
        Intrinsics.checkNotNullParameter(sensorManager, "sensorManager");
        Intrinsics.checkNotNullParameter(display, "display");
        this.sensorManager = sensorManager;
        this.display = display;
        this.lastAccuracy = 3;
        this.rotationMatrix = new float[9];
        this.adjustedRotationMatrix = new float[9];
        this.orientation = new float[3];
        this.rotationVector = new float[3];
    }

    /* JADX INFO: renamed from: a */
    private final void m4666a(float[] rotationVector) {
        SensorManager.getRotationMatrixFromVector(this.rotationMatrix, rotationVector);
        int rotation = this.display.getRotation();
        Pair pair = rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? new Pair(1, 2) : new Pair(Integer.valueOf(ISO7816Kt.INS_EXTERNAL_AUTHENTICATE), 1) : new Pair(129, Integer.valueOf(ISO7816Kt.INS_EXTERNAL_AUTHENTICATE)) : new Pair(2, 129) : new Pair(1, 2);
        SensorManager.remapCoordinateSystem(this.rotationMatrix, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue(), this.adjustedRotationMatrix);
        SensorManager.getOrientation(this.adjustedRotationMatrix, this.orientation);
        float degrees = (float) Math.toDegrees(this.orientation[0]);
        float degrees2 = (float) Math.toDegrees(this.orientation[1]);
        float degrees3 = (float) Math.toDegrees(this.orientation[2]);
        SensorListener sensorListener = this.listener;
        if (sensorListener != null) {
            sensorListener.onOrientationChanged(degrees, degrees2, degrees3);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m4667a(float[] input, float[] newValues, float alpha) {
        int length = input.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            input[i2] = (input[i] * alpha) + ((1 - alpha) * newValues[i2]);
            i++;
            i2++;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
        if (this.lastAccuracy != accuracy) {
            this.lastAccuracy = accuracy;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor;
        if (this.lastAccuracy == 0) {
            return;
        }
        Integer numValueOf = (event == null || (sensor = event.sensor) == null) ? null : Integer.valueOf(sensor.getType());
        if (numValueOf != null && numValueOf.intValue() == 11) {
            float[] fArr = this.rotationVector;
            float[] fArr2 = event.values;
            Intrinsics.checkNotNullExpressionValue(fArr2, "event.values");
            m4667a(fArr, fArr2, 0.97f);
            m4666a(this.rotationVector);
        }
    }

    public final void startListening(SensorListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.listener == listener) {
            return;
        }
        this.listener = listener;
        Sensor defaultSensor = this.sensorManager.getDefaultSensor(11);
        if (defaultSensor != null) {
            this.sensorManager.registerListener(this, defaultSensor, 1);
        }
    }

    public final void stopListening() {
        this.sensorManager.unregisterListener(this);
        this.listener = null;
    }
}
