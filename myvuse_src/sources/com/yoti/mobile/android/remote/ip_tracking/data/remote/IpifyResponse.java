package com.yoti.mobile.android.remote.ip_tracking.data.remote;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IpifyApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/ip_tracking/data/remote/IpifyResponse;", "", "ip", "", "(Ljava/lang/String;)V", "getIp", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class IpifyResponse {

    @SerializedName("ip")
    private final String ip;

    public static /* synthetic */ IpifyResponse copy$default(IpifyResponse ipifyResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ipifyResponse.ip;
        }
        return ipifyResponse.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIp() {
        return this.ip;
    }

    public final IpifyResponse copy(String ip) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        return new IpifyResponse(ip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof IpifyResponse) && Intrinsics.areEqual(this.ip, ((IpifyResponse) other).ip);
    }

    public int hashCode() {
        return this.ip.hashCode();
    }

    public String toString() {
        return "IpifyResponse(ip=" + this.ip + ')';
    }

    public IpifyResponse(String ip) {
        Intrinsics.checkNotNullParameter(ip, "ip");
        this.ip = ip;
    }

    public final String getIp() {
        return this.ip;
    }
}
