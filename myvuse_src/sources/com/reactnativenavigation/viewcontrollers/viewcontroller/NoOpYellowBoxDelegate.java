package com.reactnativenavigation.viewcontrollers.viewcontroller;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpYellowBoxDelegate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/viewcontroller/NoOpYellowBoxDelegate;", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/YellowBoxDelegate;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onChildViewAdded", "", "parent", "Landroid/view/View;", "child", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class NoOpYellowBoxDelegate extends YellowBoxDelegate {
    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.YellowBoxDelegate
    public void onChildViewAdded(View parent, View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoOpYellowBoxDelegate(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
