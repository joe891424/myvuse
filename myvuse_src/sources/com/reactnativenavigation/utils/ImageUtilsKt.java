package com.reactnativenavigation.utils;

import android.view.View;
import android.view.ViewParent;
import com.reactnativenavigation.react.ReactView;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.OverlayLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\n"}, m5598d2 = {"areDimensionsWithInheritedScaleEqual", "", "a", "Landroid/view/View;", "b", "computeInheritedScale", "Lcom/reactnativenavigation/utils/Scale;", "v", "Landroid/view/ViewParent;", "childrenScale", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ImageUtilsKt {
    public static final boolean areDimensionsWithInheritedScaleEqual(View a2, View b) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Scale scaleComputeInheritedScale = computeInheritedScale(a2);
        float x = scaleComputeInheritedScale.getX();
        float y = scaleComputeInheritedScale.getY();
        Scale scaleComputeInheritedScale2 = computeInheritedScale(b);
        return ((float) a2.getWidth()) * x == ((float) b.getWidth()) * scaleComputeInheritedScale2.getX() && ((float) a2.getHeight()) * y == ((float) b.getHeight()) * scaleComputeInheritedScale2.getY();
    }

    public static final Scale computeInheritedScale(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        ViewParent parent = v.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
        return computeInheritedScale(parent, new Scale(v.getScaleX(), v.getScaleY()));
    }

    private static final Scale computeInheritedScale(ViewParent viewParent, Scale scale) {
        if ((viewParent instanceof ReactView) || (viewParent instanceof OverlayLayout) || viewParent.getParent() == null) {
            return scale;
        }
        ViewParent parent = viewParent.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
        return computeInheritedScale(parent, new Scale(scale.getX() * ViewParentKt.getScaleX(viewParent), scale.getY() * ViewParentKt.getScaleY(viewParent)));
    }
}
