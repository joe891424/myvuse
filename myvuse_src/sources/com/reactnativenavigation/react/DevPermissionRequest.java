package com.reactnativenavigation.react;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.facebook.react.common.ReactConstants;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes6.dex */
public class DevPermissionRequest {
    private final boolean isDebug;

    public boolean shouldAskPermission(Activity activity) {
        return false;
    }

    public DevPermissionRequest(boolean z) {
        this.isDebug = z;
    }

    public void askPermission(Activity activity) {
        if (shouldAskPermission(activity)) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.addFlags(268435456);
            activity.startActivity(intent);
            LogInstrumentation.m2734w(ReactConstants.TAG, "======================================\n\n");
            LogInstrumentation.m2734w(ReactConstants.TAG, "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
            LogInstrumentation.m2734w(ReactConstants.TAG, "\n\n======================================");
            Toast.makeText(activity, "Overlay permissions needs to be granted in order for react native apps to run in dev mode", 1).show();
        }
    }
}
