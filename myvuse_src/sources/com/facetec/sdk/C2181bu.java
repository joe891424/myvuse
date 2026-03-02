package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.bu */
/* JADX INFO: loaded from: classes3.dex */
final class C2181bu extends Exception {
    C2181bu(String str) {
        super(str);
    }

    C2181bu(Throwable th) {
        super(th.getMessage(), th);
    }

    C2181bu(String str, Throwable th) {
        super(str, th);
    }

    final boolean Code() {
        return getCause() instanceof IllegalAccessException;
    }
}
