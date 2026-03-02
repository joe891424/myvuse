package com.reactnativenavigation.utils;

import com.facebook.react.views.image.ReactImageView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactImageView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m5598d2 = {"getCornerRadius", "", "Lcom/facebook/react/views/image/ReactImageView;", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ReactImageViewKt {
    public static final float getCornerRadius(ReactImageView reactImageView) {
        Intrinsics.checkNotNullParameter(reactImageView, "<this>");
        com.facebook.drawee.generic.RoundingParams roundingParams = reactImageView.getHierarchy().getRoundingParams();
        Intrinsics.checkNotNull(roundingParams);
        float[] cornersRadii = roundingParams.getCornersRadii();
        Intrinsics.checkNotNull(cornersRadii);
        return ArraysKt.first(cornersRadii);
    }
}
