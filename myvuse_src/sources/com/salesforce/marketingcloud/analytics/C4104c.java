package com.salesforce.marketingcloud.analytics;

import java.util.List;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.c */
/* JADX INFO: loaded from: classes6.dex */
public final class C4104c {
    private C4104c() {
    }

    /* JADX INFO: renamed from: a */
    public static String[] m2906a(String str) {
        return str.split("\\s*,\\s*");
    }

    /* JADX INFO: renamed from: a */
    public static String m2905a(List<C4103b> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (C4103b c4103b : list) {
            if (c4103b != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(c4103b.m2896d());
            }
        }
        return sb.toString();
    }
}
