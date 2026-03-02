package com.reactnativenavigation.views.component;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.reactnativenavigation.options.ButtonOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.react.ReactView;
import com.reactnativenavigation.react.events.ComponentType;
import com.reactnativenavigation.utils.CoordinatorLayoutUtils;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener;
import com.reactnativenavigation.views.touch.OverlayTouchDelegate;

/* JADX INFO: loaded from: classes6.dex */
public class ComponentLayout extends CoordinatorLayout implements ReactComponent, ButtonController.OnClickListener {
    private ReactView reactView;
    private final OverlayTouchDelegate touchDelegate;
    private boolean willAppearSent;

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public ViewGroup asView() {
        return this;
    }

    public ComponentLayout(Context context, ReactView reactView) {
        super(context);
        this.willAppearSent = false;
        this.reactView = reactView;
        addView(reactView.asView(), CoordinatorLayoutUtils.matchParentLP());
        this.touchDelegate = new OverlayTouchDelegate(this, reactView);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public boolean isReady() {
        return this.reactView.isReady();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.Destroyable
    public void destroy() {
        this.reactView.destroy();
    }

    public void start() {
        this.reactView.start();
    }

    public void sendComponentWillStart() {
        if (!this.willAppearSent) {
            this.reactView.sendComponentWillStart(ComponentType.Component);
        }
        this.willAppearSent = true;
    }

    public void sendComponentStart() {
        this.reactView.sendComponentStart(ComponentType.Component);
    }

    public void sendComponentStop() {
        this.willAppearSent = false;
        this.reactView.sendComponentStop(ComponentType.Component);
    }

    public void applyOptions(Options options) {
        this.touchDelegate.setInterceptTouchOutside(options.overlayOptions.interceptTouchOutside);
    }

    public void setInterceptTouchOutside(Bool bool) {
        this.touchDelegate.setInterceptTouchOutside(bool);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public void sendOnNavigationButtonPressed(String str) {
        this.reactView.sendOnNavigationButtonPressed(str);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public ScrollEventListener getScrollEventListener() {
        return this.reactView.getScrollEventListener();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.IReactView
    public void dispatchTouchEventToJs(MotionEvent motionEvent) {
        this.reactView.dispatchTouchEventToJs(motionEvent);
    }

    @Override // com.reactnativenavigation.views.component.Renderable
    public boolean isRendered() {
        return this.reactView.isRendered();
    }

    @Override // com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController.OnClickListener
    public void onPress(ButtonOptions buttonOptions) {
        this.reactView.sendOnNavigationButtonPressed(buttonOptions.f4200id);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.touchDelegate.onInterceptTouchEvent(motionEvent);
    }

    public boolean superOnInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }
}
