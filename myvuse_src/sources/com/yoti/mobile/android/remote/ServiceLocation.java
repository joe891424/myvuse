package com.yoti.mobile.android.remote;

import kotlin.Metadata;

/* JADX INFO: compiled from: RemoteDefs.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ServiceLocation;", "", "url", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "UNITED_KINGDOM", "CANADA", "DEFAULT", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum ServiceLocation {
    UNITED_KINGDOM(ApiServiceDefsKt.GBR_SERVER_URL),
    CANADA(ApiServiceDefsKt.CAN_SERVER_URL),
    DEFAULT(ApiServiceDefsKt.GBR_SERVER_URL);

    private final String url;

    ServiceLocation(String str) {
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }
}
