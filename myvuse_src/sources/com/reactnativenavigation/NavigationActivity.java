package com.reactnativenavigation;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.reactnativenavigation.react.CommandListenerAdapter;
import com.reactnativenavigation.react.JsDevReloadHandler;
import com.reactnativenavigation.react.ReactGateway;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.modal.ModalStack;
import com.reactnativenavigation.viewcontrollers.navigator.Navigator;
import com.reactnativenavigation.viewcontrollers.overlay.OverlayManager;
import com.reactnativenavigation.viewcontrollers.viewcontroller.RootPresenter;

/* JADX INFO: loaded from: classes6.dex */
public class NavigationActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity, JsDevReloadHandler.ReloadListener, TraceFieldInterface {
    public Trace _nr_trace;
    private OnBackPressedCallback callback;
    private PermissionListener mPermissionListener;
    protected Navigator navigator;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        TraceMachine.startTracing("NavigationActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "NavigationActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "NavigationActivity#onCreate", null);
        }
        super.onCreate(bundle);
        if (isFinishing()) {
            TraceMachine.exitMethod();
            return;
        }
        addDefaultSplashLayout();
        Navigator navigator = new Navigator(this, new ChildControllersRegistry(), new ModalStack(this), new OverlayManager(), new RootPresenter());
        this.navigator = navigator;
        navigator.bindViews();
        getReactGateway().onActivityCreated(this);
        setBackPressedCallback();
        TraceMachine.exitMethod();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getReactGateway().onConfigurationChanged(this, configuration);
        this.navigator.onConfigurationChanged(configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.navigator.setContentLayout((ViewGroup) findViewById(android.R.id.content));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        getReactGateway().onActivityResumed(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (getReactGateway().onNewIntent(intent)) {
            return;
        }
        super.onNewIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        getReactGateway().onActivityPaused(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Navigator navigator = this.navigator;
        if (navigator != null) {
            navigator.destroy();
        }
        getReactGateway().onActivityDestroyed(this);
    }

    @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public void invokeDefaultOnBackPressed() {
        if (this.navigator.handleBack(new CommandListenerAdapter())) {
            return;
        }
        this.callback.setEnabled(false);
        super.onBackPressed();
        this.callback.setEnabled(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getReactGateway().onActivityResult(this, i, i2, intent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return getReactGateway().onKeyUp(this, i) || super.onKeyUp(i, keyEvent);
    }

    public ReactGateway getReactGateway() {
        return app().getReactGateway();
    }

    private NavigationApplication app() {
        return (NavigationApplication) getApplication();
    }

    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        requestPermissions(strArr, i);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        NavigationApplication.instance.onRequestPermissionsResult(i, strArr, iArr);
        PermissionListener permissionListener = this.mPermissionListener;
        if (permissionListener == null || !permissionListener.onRequestPermissionsResult(i, strArr, iArr)) {
            return;
        }
        this.mPermissionListener = null;
    }

    @Override // com.reactnativenavigation.react.JsDevReloadHandler.ReloadListener
    public void onReload() {
        this.navigator.destroyViews();
    }

    protected void addDefaultSplashLayout() {
        setContentView(new View(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCatalystInstanceDestroy$0() {
        this.navigator.destroyViews();
    }

    public void onCatalystInstanceDestroy() {
        runOnUiThread(new Runnable() { // from class: com.reactnativenavigation.NavigationActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCatalystInstanceDestroy$0();
            }
        });
    }

    private void setBackPressedCallback() {
        this.callback = new OnBackPressedCallback(true) { // from class: com.reactnativenavigation.NavigationActivity.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                NavigationActivity.this.getReactGateway().onBackPressed();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, this.callback);
    }
}
