package com.reactnativenavigation.react.modal;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.reactnativenavigation.NavigationActivity;
import com.reactnativenavigation.options.ModalPresentationStyle;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.TransitionAnimationOptions;
import com.reactnativenavigation.options.TransitionAnimationOptionsKt;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.parsers.JSONParser;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.react.CommandListenerAdapter;
import com.reactnativenavigation.viewcontrollers.navigator.Navigator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModalViewManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = "RNNModalViewManager")
@Metadata(m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0011H\u0014J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0014J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\"H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006%"}, m5598d2 = {"Lcom/reactnativenavigation/react/modal/ModalViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/reactnativenavigation/react/modal/ModalHostLayout;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "jsonParser", "Lcom/reactnativenavigation/options/parsers/JSONParser;", "navigator", "Lcom/reactnativenavigation/viewcontrollers/navigator/Navigator;", "getNavigator", "()Lcom/reactnativenavigation/viewcontrollers/navigator/Navigator;", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "createShadowNodeInstance", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "createViewInstance", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "getShadowNodeClass", "Ljava/lang/Class;", "onAfterUpdateTransaction", "", "modal", "onDropViewInstance", "setAnimation", "animation", "Lcom/facebook/react/bridge/ReadableMap;", "setBlurOnUnmount", "blurOnUnmount", "", "setTransparent", "transparent", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ModalViewManager extends ViewGroupManager<ModalHostLayout> {
    private final JSONParser jsonParser;
    private final ReactContext reactContext;

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ModalHostShadowNode.class;
    }

    public ModalViewManager(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.jsonParser = new JSONParser();
    }

    public final ReactContext getReactContext() {
        return this.reactContext;
    }

    private final Navigator getNavigator() {
        Activity currentActivity = this.reactContext.getCurrentActivity();
        NavigationActivity navigationActivity = currentActivity instanceof NavigationActivity ? (NavigationActivity) currentActivity : null;
        if (navigationActivity == null || navigationActivity.isFinishing() || navigationActivity.isDestroyed()) {
            return null;
        }
        return navigationActivity.getNavigator();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNNModalViewManager";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ModalHostLayout createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ModalHostLayout(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new ModalHostShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ModalHostLayout modal) {
        Intrinsics.checkNotNullParameter(modal, "modal");
        super.onDropViewInstance(modal);
        Navigator navigator = getNavigator();
        if (navigator != null) {
            navigator.dismissModal(modal.getViewController().getId(), new CommandListenerAdapter());
            modal.onDropInstance();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(final ModalHostLayout modal) {
        Intrinsics.checkNotNullParameter(modal, "modal");
        super.onAfterUpdateTransaction(modal);
        Navigator navigator = getNavigator();
        if (navigator != null) {
            navigator.showModal(modal.getViewController(), new CommandListenerAdapter(new CommandListener() { // from class: com.reactnativenavigation.react.modal.ModalViewManager.onAfterUpdateTransaction.1
                @Override // com.reactnativenavigation.react.CommandListener
                public void onError(String message) {
                }

                @Override // com.reactnativenavigation.react.CommandListener
                public void onSuccess(String childId) {
                    modal.getViewController().sendShowEvent();
                }
            }));
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("topRequestClose", MapBuilder.m1349of("registrationName", "onRequestClose")).put("topShow", MapBuilder.m1349of("registrationName", "onShow")).build();
    }

    @ReactProp(name = "animation")
    public final void setAnimation(ModalHostLayout modal, ReadableMap animation) {
        Intrinsics.checkNotNullParameter(modal, "modal");
        Intrinsics.checkNotNullParameter(animation, "animation");
        ModalLayoutController viewController = modal.getViewController();
        Options options = new Options();
        JSONObject jSONObject = this.jsonParser.parse(animation);
        TransitionAnimationOptions transitionAnimationOptions = TransitionAnimationOptionsKt.parseTransitionAnimationOptions(jSONObject.optJSONObject("showModal"));
        TransitionAnimationOptions transitionAnimationOptions2 = TransitionAnimationOptionsKt.parseTransitionAnimationOptions(jSONObject.optJSONObject("dismissModal"));
        options.animations.showModal = transitionAnimationOptions;
        options.animations.dismissModal = transitionAnimationOptions2;
        viewController.mergeOptions(options);
    }

    @ReactProp(name = "blurOnUnmount")
    public final void setBlurOnUnmount(ModalHostLayout modal, boolean blurOnUnmount) {
        Intrinsics.checkNotNullParameter(modal, "modal");
        ModalLayoutController viewController = modal.getViewController();
        Options options = new Options();
        options.modal.blurOnUnmount = new Bool(Boolean.valueOf(blurOnUnmount));
        viewController.mergeOptions(options);
    }

    @ReactProp(name = "transparent")
    public final void setTransparent(ModalHostLayout modal, boolean transparent) {
        Intrinsics.checkNotNullParameter(modal, "modal");
        ModalLayoutController viewController = modal.getViewController();
        Options options = new Options();
        options.modal.presentationStyle = transparent ? ModalPresentationStyle.OverCurrentContext : ModalPresentationStyle.None;
        viewController.mergeOptions(options);
    }
}
