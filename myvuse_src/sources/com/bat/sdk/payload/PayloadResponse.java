package com.bat.sdk.payload;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PayloadResponse.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, m5598d2 = {"Lcom/bat/sdk/payload/PayloadResponse;", "", "country_config", "", ClientData.KEY_CHALLENGE, "challenge_signature", "country_config_signature", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountry_config", "()Ljava/lang/String;", "getChallenge", "getChallenge_signature", "getCountry_config_signature", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PayloadResponse {
    private final String challenge;
    private final String challenge_signature;
    private final String country_config;
    private final String country_config_signature;

    public static /* synthetic */ PayloadResponse copy$default(PayloadResponse payloadResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payloadResponse.country_config;
        }
        if ((i & 2) != 0) {
            str2 = payloadResponse.challenge;
        }
        if ((i & 4) != 0) {
            str3 = payloadResponse.challenge_signature;
        }
        if ((i & 8) != 0) {
            str4 = payloadResponse.country_config_signature;
        }
        return payloadResponse.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCountry_config() {
        return this.country_config;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChallenge() {
        return this.challenge;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChallenge_signature() {
        return this.challenge_signature;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCountry_config_signature() {
        return this.country_config_signature;
    }

    public final PayloadResponse copy(String country_config, String challenge, String challenge_signature, String country_config_signature) {
        Intrinsics.checkNotNullParameter(country_config, "country_config");
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(challenge_signature, "challenge_signature");
        Intrinsics.checkNotNullParameter(country_config_signature, "country_config_signature");
        return new PayloadResponse(country_config, challenge, challenge_signature, country_config_signature);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayloadResponse)) {
            return false;
        }
        PayloadResponse payloadResponse = (PayloadResponse) other;
        return Intrinsics.areEqual(this.country_config, payloadResponse.country_config) && Intrinsics.areEqual(this.challenge, payloadResponse.challenge) && Intrinsics.areEqual(this.challenge_signature, payloadResponse.challenge_signature) && Intrinsics.areEqual(this.country_config_signature, payloadResponse.country_config_signature);
    }

    public int hashCode() {
        return (((((this.country_config.hashCode() * 31) + this.challenge.hashCode()) * 31) + this.challenge_signature.hashCode()) * 31) + this.country_config_signature.hashCode();
    }

    public String toString() {
        return "PayloadResponse(country_config=" + this.country_config + ", challenge=" + this.challenge + ", challenge_signature=" + this.challenge_signature + ", country_config_signature=" + this.country_config_signature + ')';
    }

    public PayloadResponse(String country_config, String challenge, String challenge_signature, String country_config_signature) {
        Intrinsics.checkNotNullParameter(country_config, "country_config");
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(challenge_signature, "challenge_signature");
        Intrinsics.checkNotNullParameter(country_config_signature, "country_config_signature");
        this.country_config = country_config;
        this.challenge = challenge;
        this.challenge_signature = challenge_signature;
        this.country_config_signature = country_config_signature;
    }

    public final String getCountry_config() {
        return this.country_config;
    }

    public final String getChallenge() {
        return this.challenge;
    }

    public final String getChallenge_signature() {
        return this.challenge_signature;
    }

    public final String getCountry_config_signature() {
        return this.country_config_signature;
    }
}
