package com.reactnativenavigation.react.modal;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.Constants;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.YellowBoxDelegate;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalLayoutController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\u001f\u001a\u00020\u001dR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, m5598d2 = {"Lcom/reactnativenavigation/react/modal/ModalLayoutController;", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "Lcom/reactnativenavigation/react/modal/ModalFrameLayout;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "activity", "Landroid/app/Activity;", "id", "", "yellowBoxDelegate", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/YellowBoxDelegate;", "initialOptions", "Lcom/reactnativenavigation/options/Options;", "overlay", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/overlay/ViewControllerOverlay;", "getHostId", "Lkotlin/Function0;", "", "(Lcom/facebook/react/bridge/ReactContext;Landroid/app/Activity;Ljava/lang/String;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/YellowBoxDelegate;Lcom/reactnativenavigation/options/Options;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/overlay/ViewControllerOverlay;Lkotlin/jvm/functions/Function0;)V", "getGetHostId", "()Lkotlin/jvm/functions/Function0;", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "createView", "getCurrentComponentName", "isRendered", "", "isViewShown", "sendOnNavigationButtonPressed", "", "buttonId", "sendShowEvent", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ModalLayoutController extends ViewController<ModalFrameLayout> {
    private final Function0<Integer> getHostId;
    private final ReactContext reactContext;

    public final ReactContext getReactContext() {
        return this.reactContext;
    }

    public final Function0<Integer> getGetHostId() {
        return this.getHostId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalLayoutController(ReactContext reactContext, Activity activity, String str, YellowBoxDelegate yellowBoxDelegate, Options options, ViewControllerOverlay viewControllerOverlay, Function0<Integer> getHostId) {
        super(activity, str, yellowBoxDelegate, options, viewControllerOverlay);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(getHostId, "getHostId");
        this.reactContext = reactContext;
        this.getHostId = getHostId;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean isViewShown() {
        if (!isDestroyed() && this.view != 0) {
            T t = this.view;
            Intrinsics.checkNotNull(t);
            if (((ModalFrameLayout) t).isShown()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean isRendered() {
        return isViewCreated();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public String getCurrentComponentName() {
        return "ModalLayoutController";
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ModalFrameLayout createView() {
        return new ModalFrameLayout(this.reactContext);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String buttonId) {
        if (Intrinsics.areEqual(buttonId, Constants.HARDWARE_BACK_BUTTON_ID)) {
            UIManagerModule uIManagerModule = (UIManagerModule) this.reactContext.getNativeModule(UIManagerModule.class);
            EventDispatcher eventDispatcher = uIManagerModule != null ? uIManagerModule.getEventDispatcher() : null;
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(new RequestCloseModalEvent(this.getHostId.invoke().intValue()));
            }
        }
    }

    public final void sendShowEvent() {
        UIManagerModule uIManagerModule = (UIManagerModule) this.reactContext.getNativeModule(UIManagerModule.class);
        EventDispatcher eventDispatcher = uIManagerModule != null ? uIManagerModule.getEventDispatcher() : null;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new ShowModalEvent(this.getHostId.invoke().intValue()));
        }
    }
}
