package com.reactnativenavigation.react.modal;

import android.app.Activity;
import android.graphics.Point;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m5598d2 = {"Lcom/reactnativenavigation/react/modal/ModalHostShadowNode;", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "()V", "addChildAt", "", "child", "Lcom/facebook/react/uimanager/ReactShadowNodeImpl;", ContextChain.TAG_INFRA, "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
final class ModalHostShadowNode extends LayoutShadowNode {
    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void addChildAt(ReactShadowNodeImpl child, int i) {
        Activity currentActivity;
        Intrinsics.checkNotNullParameter(child, "child");
        super.addChildAt(child, i);
        ThemedReactContext themedContext = getThemedContext();
        if (themedContext == null || (currentActivity = themedContext.getCurrentActivity()) == null) {
            return;
        }
        Point modalHostSize = ModalViewManagerKt.getModalHostSize(currentActivity);
        child.setStyleWidth(modalHostSize.x);
        child.setStyleHeight(modalHostSize.y);
    }
}
