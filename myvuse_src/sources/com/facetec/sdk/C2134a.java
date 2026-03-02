package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.a */
/* JADX INFO: loaded from: classes3.dex */
final class C2134a {

    /* JADX INFO: renamed from: Z */
    static boolean f2325Z = false;

    C2134a() {
    }

    /* JADX INFO: renamed from: V */
    static void m1432V() {
        String str;
        if (!FaceTecSDK.f2235I.f2219a.containsKey("ac_cpngi") || (str = FaceTecSDK.f2235I.f2219a.get("ac_cpngi")) == null) {
            return;
        }
        f2325Z = str.equals("040dfacf-ed9b-403e-81c2-564d932de5da");
    }
}
