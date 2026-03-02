package com.reactnativenavigation.viewcontrollers.viewcontroller;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.reactnativenavigation.options.Options;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutDirectionApplier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/viewcontroller/LayoutDirectionApplier;", "", "()V", "apply", "", "root", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "options", "Lcom/reactnativenavigation/options/Options;", "instanceManager", "Lcom/facebook/react/ReactInstanceManager;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class LayoutDirectionApplier {
    public final void apply(ViewController<?> root, Options options, ReactInstanceManager instanceManager) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(instanceManager, "instanceManager");
        if (!options.layout.direction.hasValue() || instanceManager.getCurrentReactContext() == null) {
            return;
        }
        root.getActivity().getWindow().getDecorView().setLayoutDirection(options.layout.direction.get());
        I18nUtil.getInstance().allowRTL(instanceManager.getCurrentReactContext(), options.layout.direction.isRtl());
        I18nUtil.getInstance().forceRTL(instanceManager.getCurrentReactContext(), options.layout.direction.isRtl());
    }
}
