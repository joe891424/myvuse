package com.salesforce.marketingcloud.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.salesforce.marketingcloud.C4170g;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.h */
/* JADX INFO: loaded from: classes6.dex */
public final class C4389h {

    /* JADX INFO: renamed from: a */
    private static String f5806a;

    /* JADX INFO: renamed from: b */
    public static final String[] f5807b;

    static {
        f5807b = Build.VERSION.SDK_INT >= 29 ? new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"} : new String[]{"android.permission.ACCESS_FINE_LOCATION"};
    }

    private C4389h() {
    }

    /* JADX INFO: renamed from: a */
    public static String m4319a(Context context) {
        if (!TextUtils.isEmpty(f5806a)) {
            return f5806a;
        }
        f5806a = "";
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            f5806a = String.format("%s : %s", packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            C4170g.m3207b(C4393l.f5819c, e, "Failed to get Application Version from the PackageManager.", new Object[0]);
        }
        return f5806a;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4322b(Context context) {
        if (context == null) {
            return false;
        }
        for (String str : f5807b) {
            if (!m4320a(context, str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4324c(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return m4320a(context, "android.permission.BLUETOOTH_SCAN") && m4320a(context, "android.permission.BLUETOOTH_CONNECT");
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4320a(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4323b(PackageManager packageManager, Intent intent) {
        return packageManager.queryIntentServices(intent, 65536).size() > 0;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4321a(PackageManager packageManager, Intent intent) {
        return packageManager.queryBroadcastReceivers(intent, 0).size() > 0;
    }
}
