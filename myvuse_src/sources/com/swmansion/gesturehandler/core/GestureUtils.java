package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.p035BV.LinearGradient.LinearGradientManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GestureUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, m5598d2 = {"Lcom/swmansion/gesturehandler/core/GestureUtils;", "", "()V", "coneToDeviation", "", LinearGradientManager.PROP_ANGLE, "getLastPointerX", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "averageTouches", "", "getLastPointerY", "react-native-gesture-handler_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class GestureUtils {
    public static final GestureUtils INSTANCE = new GestureUtils();

    private GestureUtils() {
    }

    public final float getLastPointerX(MotionEvent event, boolean averageTouches) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionIndex = event.getActionMasked() == 6 ? event.getActionIndex() : -1;
        if (averageTouches) {
            int pointerCount = event.getPointerCount();
            float x = 0.0f;
            int i = 0;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != actionIndex) {
                    x += event.getX(i2);
                    i++;
                }
            }
            return x / i;
        }
        int pointerCount2 = event.getPointerCount();
        int i3 = pointerCount2 - 1;
        if (i3 == actionIndex) {
            i3 = pointerCount2 - 2;
        }
        return event.getX(i3);
    }

    public final float getLastPointerY(MotionEvent event, boolean averageTouches) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionIndex = event.getActionMasked() == 6 ? event.getActionIndex() : -1;
        if (averageTouches) {
            int pointerCount = event.getPointerCount();
            float y = 0.0f;
            int i = 0;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != actionIndex) {
                    y += event.getY(i2);
                    i++;
                }
            }
            return y / i;
        }
        int pointerCount2 = event.getPointerCount();
        int i3 = pointerCount2 - 1;
        if (i3 == actionIndex) {
            i3 = pointerCount2 - 2;
        }
        return event.getY(i3);
    }

    public final double coneToDeviation(double angle) {
        return Math.cos(Math.toRadians(angle / 2.0d));
    }
}
