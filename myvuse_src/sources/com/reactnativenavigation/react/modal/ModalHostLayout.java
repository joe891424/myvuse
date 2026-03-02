package com.reactnativenavigation.react.modal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.utils.CompatUtils;
import com.reactnativenavigation.viewcontrollers.viewcontroller.YellowBoxDelegate;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ModalHostLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016J\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\rH\u0016J0\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0014H\u0014J\u0012\u0010(\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010)\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006*"}, m5598d2 = {"Lcom/reactnativenavigation/react/modal/ModalHostLayout;", "Landroid/view/ViewGroup;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "mHostView", "Lcom/reactnativenavigation/react/modal/ModalContentLayout;", "viewController", "Lcom/reactnativenavigation/react/modal/ModalLayoutController;", "getViewController", "()Lcom/reactnativenavigation/react/modal/ModalLayoutController;", "addChildrenForAccessibility", "", "outChildren", "Ljava/util/ArrayList;", "Landroid/view/View;", "addView", "child", FirebaseAnalytics.Param.INDEX, "", "dispatchPopulateAccessibilityEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/accessibility/AccessibilityEvent;", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "getChildAt", "getChildCount", "onDropInstance", "onHostDestroy", "onHostPause", "onHostResume", ViewProps.ON_LAYOUT, "changed", "l", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME, "b", "removeView", "removeViewAt", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ModalHostLayout extends ViewGroup implements LifecycleEventListener {
    private final ModalContentLayout mHostView;
    private final ModalLayoutController viewController;

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ModalHostLayout(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ThemedReactContext themedReactContext = reactContext;
        super(themedReactContext);
        ThemedReactContext themedReactContext2 = reactContext;
        Activity currentActivity = reactContext.getCurrentActivity();
        String strValueOf = String.valueOf(CompatUtils.generateViewId());
        YellowBoxDelegate yellowBoxDelegate = new YellowBoxDelegate(themedReactContext);
        Options options = new Options();
        options.hardwareBack.dismissModalOnPress = new Bool(false);
        Unit unit = Unit.INSTANCE;
        ModalLayoutController modalLayoutController = new ModalLayoutController(themedReactContext2, currentActivity, strValueOf, yellowBoxDelegate, options, new ViewControllerOverlay(themedReactContext), new Function0<Integer>() { // from class: com.reactnativenavigation.react.modal.ModalHostLayout$viewController$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(this.this$0.getId());
            }
        });
        this.viewController = modalLayoutController;
        this.mHostView = modalLayoutController.getView().getModalContentLayout();
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ((ReactContext) context).addLifecycleEventListener(this);
    }

    public final ModalLayoutController getViewController() {
        return this.viewController;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure structure) {
        this.mHostView.dispatchProvideStructure(structure);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.addView(child, index);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return this.mHostView.getChildCount();
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int index) {
        return this.mHostView.getChildAt(index);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View child) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.removeView(child);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int index) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.removeView(getChildAt(index));
    }

    public void onDropInstance() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ((ReactContext) context).removeLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        onDropInstance();
    }
}
