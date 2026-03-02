package com.reactnativenavigation.options.interpolators;

import android.animation.TimeInterpolator;
import kotlin.Metadata;

/* JADX INFO: compiled from: DecelerateAccelerateInterpolator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, m5598d2 = {"Lcom/reactnativenavigation/options/interpolators/DecelerateAccelerateInterpolator;", "Landroid/animation/TimeInterpolator;", "()V", "getInterpolation", "", "input", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class DecelerateAccelerateInterpolator implements TimeInterpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        return ((float) (Math.cos(((double) (input + 1)) * 3.141592653589793d) / ((double) 2.0f))) + 0.5f;
    }
}
