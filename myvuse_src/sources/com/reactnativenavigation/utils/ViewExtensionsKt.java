package com.reactnativenavigation.utils;

import android.view.View;
import android.view.ViewManager;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0007"}, m5598d2 = {"isRTL", "", "Landroid/view/View;", "removeFromParent", "", "(Landroid/view/View;)Lkotlin/Unit;", "resetViewProperties", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ViewExtensionsKt {
    public static final Unit removeFromParent(View view) {
        ViewParent parent = view != null ? view.getParent() : null;
        ViewManager viewManager = parent instanceof ViewManager ? (ViewManager) parent : null;
        if (viewManager == null) {
            return null;
        }
        viewManager.removeView(view);
        return Unit.INSTANCE;
    }

    public static final boolean isRTL(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getLayoutDirection() == 1;
    }

    public static final void resetViewProperties(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setX(0.0f);
        view.setY(0.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
    }
}
