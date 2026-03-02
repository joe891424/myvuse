package com.reactnativenavigation.react;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativenavigation.react.events.ComponentType;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener;
import com.reactnativenavigation.views.component.Renderable;

/* JADX INFO: loaded from: classes6.dex */
public class ReactView extends ReactRootView implements IReactView, Renderable {
    private final String componentId;
    private final String componentName;
    private boolean isAttachedToReactInstance;
    private final JSTouchDispatcher jsTouchDispatcher;
    private final ReactInstanceManager reactInstanceManager;

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public ReactView asView() {
        return this;
    }

    public ReactView(Context context, ReactInstanceManager reactInstanceManager, String str, String str2) {
        super(context);
        this.isAttachedToReactInstance = false;
        this.reactInstanceManager = reactInstanceManager;
        this.componentId = str;
        this.componentName = str2;
        this.jsTouchDispatcher = new JSTouchDispatcher(this);
        setIsFabric(ReactFeatureFlags.enableFabricRenderer);
    }

    @Override // com.facebook.react.ReactRootView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    public void start() {
        if (this.isAttachedToReactInstance) {
            return;
        }
        this.isAttachedToReactInstance = true;
        Bundle bundle = new Bundle();
        bundle.putString("componentId", this.componentId);
        startReactApplication(this.reactInstanceManager, this.componentName, bundle);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public boolean isReady() {
        return this.isAttachedToReactInstance;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.Destroyable
    public void destroy() {
        unmountReactApplication();
    }

    public void sendComponentWillStart(final ComponentType componentType) {
        post(new Runnable() { // from class: com.reactnativenavigation.react.ReactView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendComponentWillStart$0(componentType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendComponentWillStart$0(ComponentType componentType) {
        ReactContext currentReactContext;
        ReactInstanceManager reactInstanceManager = this.reactInstanceManager;
        if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
            return;
        }
        new EventEmitter(currentReactContext).emitComponentWillAppear(this.componentId, this.componentName, componentType);
    }

    public void sendComponentStart(final ComponentType componentType) {
        post(new Runnable() { // from class: com.reactnativenavigation.react.ReactView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendComponentStart$1(componentType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendComponentStart$1(ComponentType componentType) {
        ReactContext currentReactContext;
        ReactInstanceManager reactInstanceManager = this.reactInstanceManager;
        if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
            return;
        }
        new EventEmitter(currentReactContext).emitComponentDidAppear(this.componentId, this.componentName, componentType);
    }

    public void sendComponentStop(ComponentType componentType) {
        ReactContext currentReactContext;
        ReactInstanceManager reactInstanceManager = this.reactInstanceManager;
        if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
            return;
        }
        new EventEmitter(currentReactContext).emitComponentDidDisappear(this.componentId, this.componentName, componentType);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public void sendOnNavigationButtonPressed(String str) {
        ReactContext currentReactContext;
        ReactInstanceManager reactInstanceManager = this.reactInstanceManager;
        if (reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null) {
            return;
        }
        new EventEmitter(currentReactContext).emitOnNavigationButtonPressed(this.componentId, str);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public ScrollEventListener getScrollEventListener() {
        return new ScrollEventListener(getEventDispatcher());
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public void dispatchTouchEventToJs(MotionEvent motionEvent) {
        this.jsTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView, com.reactnativenavigation.views.component.Renderable
    public boolean isRendered() {
        return getChildCount() >= 1;
    }

    public EventDispatcher getEventDispatcher() {
        ReactContext currentReactContext = this.reactInstanceManager.getCurrentReactContext();
        if (currentReactContext == null) {
            return null;
        }
        return ((UIManagerModule) currentReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public String getComponentName() {
        return this.componentName;
    }
}
