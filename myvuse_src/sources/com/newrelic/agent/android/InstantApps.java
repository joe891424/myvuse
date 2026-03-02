package com.newrelic.agent.android;

import android.content.Context;
import android.content.pm.PackageManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class InstantApps {
    private static Boolean isInstantApp;
    private static Context lastApplicationContext;
    private static PackageManagerWrapper packageManagerWrapper;

    private static boolean isAtLeastO() {
        return true;
    }

    public static boolean isInstantApp(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must be non-null");
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new IllegalStateException("Application context is null!");
        }
        if (isInstantApp != null && applicationContext.equals(lastApplicationContext)) {
            return isInstantApp.booleanValue();
        }
        Boolean boolIsInstantApp = null;
        isInstantApp = null;
        if (isAtLeastO()) {
            if (packageManagerWrapper == null || !applicationContext.equals(lastApplicationContext)) {
                packageManagerWrapper = new PackageManagerWrapper(applicationContext.getPackageManager());
            }
            boolIsInstantApp = packageManagerWrapper.isInstantApp();
        }
        lastApplicationContext = applicationContext;
        if (boolIsInstantApp != null) {
            isInstantApp = boolIsInstantApp;
        } else {
            try {
                applicationContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                isInstantApp = true;
            } catch (ClassNotFoundException unused) {
                isInstantApp = false;
            }
        }
        return isInstantApp.booleanValue();
    }

    static class PackageManagerWrapper {
        private static Method isInstantAppMethod;
        private final PackageManager packageManager;

        PackageManagerWrapper(PackageManager packageManager) {
            this.packageManager = packageManager;
        }

        Boolean isInstantApp() {
            if (isInstantAppMethod == null) {
                try {
                    isInstantAppMethod = PackageManager.class.getDeclaredMethod("isInstantApp", new Class[0]);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
            try {
                return (Boolean) isInstantAppMethod.invoke(this.packageManager, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return null;
            }
        }
    }
}
