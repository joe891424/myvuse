package com.reactnativenavigation.viewcontrollers.viewcontroller.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalOverlay.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/viewcontroller/overlay/ModalOverlay;", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/overlay/ViewControllerOverlay;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "modalsLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "getModalsLayout", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "setModalsLayout", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;)V", "add", "", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ModalOverlay extends ViewControllerOverlay {
    public CoordinatorLayout modalsLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalOverlay(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final CoordinatorLayout getModalsLayout() {
        CoordinatorLayout coordinatorLayout = this.modalsLayout;
        if (coordinatorLayout != null) {
            return coordinatorLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("modalsLayout");
        return null;
    }

    public final void setModalsLayout(CoordinatorLayout coordinatorLayout) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "<set-?>");
        this.modalsLayout = coordinatorLayout;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay
    public void add(ViewGroup parent, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        super.add(getModalsLayout(), view, layoutParams);
    }
}
