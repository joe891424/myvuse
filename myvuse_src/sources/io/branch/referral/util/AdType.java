package io.branch.referral.util;

/* JADX INFO: loaded from: classes4.dex */
public enum AdType {
    BANNER("BANNER"),
    INTERSTITIAL("INTERSTITIAL"),
    REWARDED_VIDEO("REWARDED_VIDEO"),
    NATIVE("NATIVE");

    private final String name;

    AdType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
