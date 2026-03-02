package com.salesforce.marketingcloud.util;

import android.text.TextUtils;
import java.util.Collection;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.util.j */
/* JADX INFO: loaded from: classes6.dex */
public final class C4391j {
    private C4391j() {
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4328a(boolean z, String str) {
        if (z) {
            return true;
        }
        throw new IllegalArgumentException(str);
    }

    /* JADX INFO: renamed from: a */
    public static <T extends CharSequence> T m4325a(T t, String str) {
        if (TextUtils.isEmpty(t)) {
            throw new IllegalArgumentException(str);
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Collection> T m4327a(T t, String str) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException(str);
        }
        return t;
    }

    /* JADX INFO: renamed from: a */
    public static <T> T m4326a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
