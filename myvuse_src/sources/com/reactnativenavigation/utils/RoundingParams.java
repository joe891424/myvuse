package com.reactnativenavigation.utils;

import com.surajit.rnrg.RadialGradientManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundingParams.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Lcom/reactnativenavigation/utils/RoundingParams;", "", "()V", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class RoundingParams {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: RoundingParams.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/reactnativenavigation/utils/RoundingParams$Companion;", "", "()V", "fromCornersRadii", "Lcom/facebook/drawee/generic/RoundingParams;", RadialGradientManager.PROP_RADIUS, "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final com.facebook.drawee.generic.RoundingParams fromCornersRadii(float radius) {
            float[] fArr = new float[8];
            for (int i = 0; i < 8; i++) {
                fArr[i] = radius;
            }
            com.facebook.drawee.generic.RoundingParams roundingParamsFromCornersRadii = com.facebook.drawee.generic.RoundingParams.fromCornersRadii(fArr);
            Intrinsics.checkNotNullExpressionValue(roundingParamsFromCornersRadii, "fromCornersRadii(...)");
            return roundingParamsFromCornersRadii;
        }
    }
}
