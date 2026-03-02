package com.reactnativenavigation.react;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.reactnativenavigation.NavigationActivity;
import com.reactnativenavigation.react.events.EventEmitter;

/* JADX INFO: loaded from: classes6.dex */
public class NavigationReactInitializer implements ReactInstanceManager.ReactInstanceEventListener {
    private final DevPermissionRequest devPermissionRequest;
    private final ReactInstanceManager reactInstanceManager;
    private boolean waitingForAppLaunchEvent = true;
    private boolean isActivityReadyForUi = false;

    NavigationReactInitializer(ReactInstanceManager reactInstanceManager, boolean z) {
        this.reactInstanceManager = reactInstanceManager;
        this.devPermissionRequest = new DevPermissionRequest(z);
    }

    void onActivityCreated() {
        this.reactInstanceManager.addReactInstanceEventListener(this);
        this.waitingForAppLaunchEvent = true;
    }

    void onActivityResumed(NavigationActivity navigationActivity) {
        if (this.devPermissionRequest.shouldAskPermission(navigationActivity)) {
            this.devPermissionRequest.askPermission(navigationActivity);
            return;
        }
        this.reactInstanceManager.onHostResume(navigationActivity, navigationActivity);
        this.isActivityReadyForUi = true;
        prepareReactApp();
    }

    void onActivityPaused(NavigationActivity navigationActivity) {
        this.isActivityReadyForUi = false;
        if (this.reactInstanceManager.hasStartedCreatingInitialContext()) {
            this.reactInstanceManager.onHostPause(navigationActivity);
        }
    }

    void onActivityDestroyed(NavigationActivity navigationActivity) {
        this.reactInstanceManager.removeReactInstanceEventListener(this);
        if (this.reactInstanceManager.hasStartedCreatingInitialContext()) {
            this.reactInstanceManager.onHostDestroy(navigationActivity);
        }
    }

    private void prepareReactApp() {
        if (shouldCreateContext()) {
            this.reactInstanceManager.createReactContextInBackground();
        } else {
            if (!this.waitingForAppLaunchEvent || this.reactInstanceManager.getCurrentReactContext() == null) {
                return;
            }
            emitAppLaunched(this.reactInstanceManager.getCurrentReactContext());
        }
    }

    private void emitAppLaunched(ReactContext reactContext) {
        if (this.isActivityReadyForUi) {
            this.waitingForAppLaunchEvent = false;
            new EventEmitter(reactContext).appLaunched();
        }
    }

    private boolean shouldCreateContext() {
        return !this.reactInstanceManager.hasStartedCreatingInitialContext();
    }

    @Override // com.facebook.react.ReactInstanceEventListener
    public void onReactContextInitialized(ReactContext reactContext) {
        emitAppLaunched(reactContext);
    }
}
