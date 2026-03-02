package com.bat.sdk.model;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PayloadChallengeResponse.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m5598d2 = {"Lcom/bat/sdk/model/PayloadChallengeResponse;", "", ClientData.KEY_CHALLENGE, "", "<init>", "(Ljava/lang/String;)V", "getChallenge", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PayloadChallengeResponse {
    private final String challenge;

    public static /* synthetic */ PayloadChallengeResponse copy$default(PayloadChallengeResponse payloadChallengeResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payloadChallengeResponse.challenge;
        }
        return payloadChallengeResponse.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChallenge() {
        return this.challenge;
    }

    public final PayloadChallengeResponse copy(String challenge) {
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        return new PayloadChallengeResponse(challenge);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PayloadChallengeResponse) && Intrinsics.areEqual(this.challenge, ((PayloadChallengeResponse) other).challenge);
    }

    public int hashCode() {
        return this.challenge.hashCode();
    }

    public String toString() {
        return "PayloadChallengeResponse(challenge=" + this.challenge + ')';
    }

    public PayloadChallengeResponse(String challenge) {
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        this.challenge = challenge;
    }

    public final String getChallenge() {
        return this.challenge;
    }
}
