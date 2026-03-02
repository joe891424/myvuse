package com.reactnativenavigation.react.modal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.branch.rnbranch.RNBranchModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ModalContentLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J$\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J(\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0014J\u0012\u0010&\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m5598d2 = {"Lcom/reactnativenavigation/react/modal/ModalContentLayout;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/facebook/react/uimanager/RootView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hasAdjustedSize", "", "mJSTouchDispatcher", "Lcom/facebook/react/uimanager/JSTouchDispatcher;", "viewHeight", "", "viewWidth", "addView", "", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "getEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getReactContext", "Lcom/facebook/react/bridge/ReactContext;", "handleException", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "", "onChildEndedNativeGesture", "androidEvent", "Landroid/view/MotionEvent;", "onChildStartedNativeGesture", "onInterceptTouchEvent", NotificationCompat.CATEGORY_EVENT, "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "requestDisallowInterceptTouchEvent", "disallowIntercept", "updateFirstChildView", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ModalContentLayout extends ReactViewGroup implements RootView {
    private boolean hasAdjustedSize;
    private final JSTouchDispatcher mJSTouchDispatcher;
    private int viewHeight;
    private int viewWidth;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public ModalContentLayout(Context context) {
        super(context);
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.viewWidth = w;
        this.viewHeight = h;
        updateFirstChildView();
    }

    private final void updateFirstChildView() {
        if (getChildCount() > 0) {
            this.hasAdjustedSize = false;
            final int id = getChildAt(0).getId();
            ReactContext reactContext = getReactContext();
            reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) { // from class: com.reactnativenavigation.react.modal.ModalContentLayout.updateFirstChildView.1
                @Override // com.facebook.react.bridge.GuardedRunnable
                public void runGuarded() {
                    NativeModule nativeModule = this.getReactContext().getNativeModule(UIManagerModule.class);
                    Intrinsics.checkNotNull(nativeModule, "null cannot be cast to non-null type com.facebook.react.uimanager.UIManagerModule");
                    ((UIManagerModule) nativeModule).updateNodeSize(id, this.viewWidth, this.viewHeight);
                }
            });
            return;
        }
        this.hasAdjustedSize = true;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (this.hasAdjustedSize) {
            updateFirstChildView();
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(View child, MotionEvent androidEvent) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.mJSTouchDispatcher.onChildStartedNativeGesture(androidEvent, getEventDispatcher());
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(MotionEvent androidEvent) {
        this.mJSTouchDispatcher.onChildStartedNativeGesture(androidEvent, getEventDispatcher());
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildEndedNativeGesture(View child, MotionEvent androidEvent) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.mJSTouchDispatcher.onChildEndedNativeGesture(androidEvent, getEventDispatcher());
    }

    private final EventDispatcher getEventDispatcher() {
        NativeModule nativeModule = getReactContext().getNativeModule(UIManagerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        return ((UIManagerModule) nativeModule).getEventDispatcher();
    }

    @Override // com.facebook.react.uimanager.RootView
    public void handleException(Throwable t) {
        getReactContext().handleException(new RuntimeException(t));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReactContext getReactContext() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        return (ReactContext) context;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        this.mJSTouchDispatcher.handleTouchEvent(event, getEventDispatcher());
        return super.onInterceptTouchEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        this.mJSTouchDispatcher.handleTouchEvent(event, getEventDispatcher());
        super.onTouchEvent(event);
        return true;
    }
}
