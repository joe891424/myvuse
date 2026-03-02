package com.bat.sdk.payload;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PayloadRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadRequest;", "", ClientData.KEY_CHALLENGE, "", "country_code", "payload_code", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallenge", "()Ljava/lang/String;", "getCountry_code", "getPayload_code", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PayloadRequest {
    private final String challenge;
    private final String country_code;
    private final String payload_code;

    public static /* synthetic */ PayloadRequest copy$default(PayloadRequest payloadRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payloadRequest.challenge;
        }
        if ((i & 2) != 0) {
            str2 = payloadRequest.country_code;
        }
        if ((i & 4) != 0) {
            str3 = payloadRequest.payload_code;
        }
        return payloadRequest.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChallenge() {
        return this.challenge;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCountry_code() {
        return this.country_code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPayload_code() {
        return this.payload_code;
    }

    public final PayloadRequest copy(String challenge, String country_code, String payload_code) {
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(country_code, "country_code");
        Intrinsics.checkNotNullParameter(payload_code, "payload_code");
        return new PayloadRequest(challenge, country_code, payload_code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayloadRequest)) {
            return false;
        }
        PayloadRequest payloadRequest = (PayloadRequest) other;
        return Intrinsics.areEqual(this.challenge, payloadRequest.challenge) && Intrinsics.areEqual(this.country_code, payloadRequest.country_code) && Intrinsics.areEqual(this.payload_code, payloadRequest.payload_code);
    }

    public int hashCode() {
        return (((this.challenge.hashCode() * 31) + this.country_code.hashCode()) * 31) + this.payload_code.hashCode();
    }

    public PayloadRequest(String challenge, String country_code, String payload_code) {
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(country_code, "country_code");
        Intrinsics.checkNotNullParameter(payload_code, "payload_code");
        this.challenge = challenge;
        this.country_code = country_code;
        this.payload_code = payload_code;
    }

    public final String getChallenge() {
        return this.challenge;
    }

    public final String getCountry_code() {
        return this.country_code;
    }

    public final String getPayload_code() {
        return this.payload_code;
    }

    public String toString() {
        return "payload " + this.payload_code + ", country: " + this.country_code + ", challenge: " + this.challenge;
    }
}
