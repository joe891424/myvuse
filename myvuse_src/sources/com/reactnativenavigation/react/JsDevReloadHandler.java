package com.reactnativenavigation.react;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.widget.EditText;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.reactnativenavigation.utils.UiUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class JsDevReloadHandler extends JsDevReloadHandlerFacade {
    private static final String RELOAD_BROADCAST = "com.reactnativenavigation.broadcast.RELOAD";
    private final DevSupportManager devSupportManager;
    private final BroadcastReceiver reloadReceiver = new BroadcastReceiver() { // from class: com.reactnativenavigation.react.JsDevReloadHandler.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            JsDevReloadHandler.this.reloadReactNative();
        }
    };
    private long firstRTimestamp = 0;
    private ReloadListener reloadListener = new ReloadListener() { // from class: com.reactnativenavigation.react.JsDevReloadHandler$$ExternalSyntheticLambda1
        @Override // com.reactnativenavigation.react.JsDevReloadHandler.ReloadListener
        public final void onReload() {
            JsDevReloadHandler.lambda$new$0();
        }
    };

    public interface ReloadListener {
        void onReload();
    }

    static /* synthetic */ void lambda$new$0() {
    }

    JsDevReloadHandler(DevSupportManager devSupportManager) {
        this.devSupportManager = devSupportManager;
    }

    @Override // com.reactnativenavigation.react.JsDevReloadHandlerFacade, com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
    public void onSuccess() {
        final ReloadListener reloadListener = this.reloadListener;
        Objects.requireNonNull(reloadListener);
        UiUtils.runOnMainThread(new Runnable() { // from class: com.reactnativenavigation.react.JsDevReloadHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                reloadListener.onReload();
            }
        });
    }

    public void setReloadListener(ReloadListener reloadListener) {
        this.reloadListener = reloadListener;
    }

    public void removeReloadListener(ReloadListener reloadListener) {
        if (this.reloadListener == reloadListener) {
            this.reloadListener = null;
        }
    }

    public void onActivityResumed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 34 && activity.getApplicationInfo().targetSdkVersion >= 34) {
            activity.registerReceiver(this.reloadReceiver, new IntentFilter(RELOAD_BROADCAST), 2);
        } else {
            activity.registerReceiver(this.reloadReceiver, new IntentFilter(RELOAD_BROADCAST));
        }
    }

    public void onActivityPaused(Activity activity) {
        activity.unregisterReceiver(this.reloadReceiver);
    }

    public boolean onKeyUp(Activity activity, int i) {
        if (!this.devSupportManager.getDevSupportEnabled()) {
            return false;
        }
        if (i == 82) {
            this.devSupportManager.showDevOptionsDialog();
            return true;
        }
        if (i == 46) {
            if (lessThan500MillisSinceLastR() && textViewIsNotFocused(activity)) {
                reloadReactNative();
                return true;
            }
            this.firstRTimestamp = System.currentTimeMillis();
        }
        return false;
    }

    private boolean lessThan500MillisSinceLastR() {
        return this.firstRTimestamp != 0 && System.currentTimeMillis() - this.firstRTimestamp < 1000;
    }

    private boolean textViewIsNotFocused(Activity activity) {
        return !(activity.getCurrentFocus() instanceof EditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadReactNative() {
        this.reloadListener.onReload();
        this.devSupportManager.handleReloadJS();
    }
}
