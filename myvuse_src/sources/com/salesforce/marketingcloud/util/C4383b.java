package com.salesforce.marketingcloud.util;

import android.os.Build;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4383b {

    /* JADX INFO: renamed from: a */
    private static final String f5752a = "Amazon";

    private C4383b() {
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4261a() {
        return Build.MANUFACTURER.equalsIgnoreCase(f5752a);
    }
}
