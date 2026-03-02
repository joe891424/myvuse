package com.reactnativenavigation.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes6.dex */
public final class LaunchArgsParser {
    private static final String LAUNCH_ARGS = "launchArgs";

    public static WritableMap parse(Activity activity) {
        Intent intent;
        Bundle bundleExtra;
        if (activity != null && (intent = activity.getIntent()) != null && (bundleExtra = intent.getBundleExtra(LAUNCH_ARGS)) != null) {
            return Arguments.fromBundle(bundleExtra);
        }
        return Arguments.createMap();
    }
}
