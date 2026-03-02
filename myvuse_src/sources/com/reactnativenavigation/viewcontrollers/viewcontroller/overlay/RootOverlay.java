package com.reactnativenavigation.viewcontrollers.viewcontroller.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootOverlay.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/viewcontroller/overlay/RootOverlay;", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/overlay/ViewControllerOverlay;", "context", "Landroid/content/Context;", "contentLayout", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "add", "", "parent", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class RootOverlay extends ViewControllerOverlay {
    private final ViewGroup contentLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RootOverlay(Context context, ViewGroup contentLayout) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentLayout, "contentLayout");
        this.contentLayout = contentLayout;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay
    public void add(ViewGroup parent, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        super.add(this.contentLayout, view, layoutParams);
    }
}
