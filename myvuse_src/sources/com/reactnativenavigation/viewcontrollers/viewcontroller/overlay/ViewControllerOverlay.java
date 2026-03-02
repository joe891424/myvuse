package com.reactnativenavigation.viewcontrollers.viewcontroller.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.reactnativenavigation.utils.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewControllerOverlay.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/viewcontroller/overlay/ViewControllerOverlay;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "overlay", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/overlay/OverlayLayout;", "add", "", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "attachOverlayToParent", "remove", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ViewControllerOverlay {
    private final OverlayLayout overlay;

    public ViewControllerOverlay(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.overlay = new OverlayLayout(context);
    }

    public void add(ViewGroup parent, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        attachOverlayToParent(parent);
        this.overlay.addView(view, layoutParams);
    }

    public final void remove(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.overlay.removeView(view);
        if (this.overlay.getChildCount() == 0) {
            ViewExtensionsKt.removeFromParent(this.overlay);
        }
    }

    private final void attachOverlayToParent(ViewGroup parent) {
        if (this.overlay.getParent() == null) {
            parent.addView(this.overlay, -1, -1);
        }
    }
}
