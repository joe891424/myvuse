package com.newrelic.mobile.fbs;

import com.facebook.react.common.ReactConstants;

/* JADX INFO: loaded from: classes6.dex */
public final class Framework {
    public static final byte Native = 0;
    public static final byte ReactNative = 1;
    public static final String[] names = {"Native", ReactConstants.TAG};

    private Framework() {
    }

    public static String name(int i) {
        return names[i];
    }
}
