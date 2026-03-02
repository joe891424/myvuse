package com.reactnativenavigation.react.modal;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.facebook.react.bridge.ReactContext;
import com.reactnativenavigation.utils.SystemUiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalFrameLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m5598d2 = {"Lcom/reactnativenavigation/react/modal/ModalFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "modalContentLayout", "Lcom/reactnativenavigation/react/modal/ModalContentLayout;", "getModalContentLayout", "()Lcom/reactnativenavigation/react/modal/ModalContentLayout;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ModalFrameLayout extends FrameLayout {
    private final ModalContentLayout modalContentLayout;

    /* JADX WARN: Illegal instructions before constructor call */
    public ModalFrameLayout(ReactContext context) {
        boolean zIsTranslucent;
        Window window;
        Intrinsics.checkNotNullParameter(context, "context");
        ReactContext reactContext = context;
        super(reactContext);
        ModalContentLayout modalContentLayout = new ModalContentLayout(reactContext);
        this.modalContentLayout = modalContentLayout;
        ModalContentLayout modalContentLayout2 = modalContentLayout;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        Activity currentActivity = context.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null) {
            zIsTranslucent = false;
        } else {
            Intrinsics.checkNotNull(window);
            zIsTranslucent = SystemUiUtils.isTranslucent(window);
        }
        marginLayoutParams.topMargin = zIsTranslucent ? 0 : SystemUiUtils.getStatusBarHeight(context.getCurrentActivity());
        Unit unit = Unit.INSTANCE;
        addView(modalContentLayout2, marginLayoutParams);
    }

    public final ModalContentLayout getModalContentLayout() {
        return this.modalContentLayout;
    }
}
