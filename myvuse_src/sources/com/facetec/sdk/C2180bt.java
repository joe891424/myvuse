package com.facetec.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: renamed from: com.facetec.sdk.bt */
/* JADX INFO: loaded from: classes3.dex */
final class C2180bt {
    C2180bt() {
    }

    /* JADX INFO: renamed from: B */
    static boolean m1948B(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.isConnected() & (activeNetworkInfo.getType() == 1)) {
                return true;
            }
        }
        return false;
    }
}
