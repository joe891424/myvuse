package com.bat.sdk.remote.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AsavResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/remote/data/AsavResponse;", "", "message", "", "signature", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getSignature", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class AsavResponse {
    private final String message;
    private final String signature;

    public static /* synthetic */ AsavResponse copy$default(AsavResponse asavResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = asavResponse.message;
        }
        if ((i & 2) != 0) {
            str2 = asavResponse.signature;
        }
        return asavResponse.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    public final AsavResponse copy(String message, String signature) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(signature, "signature");
        return new AsavResponse(message, signature);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AsavResponse)) {
            return false;
        }
        AsavResponse asavResponse = (AsavResponse) other;
        return Intrinsics.areEqual(this.message, asavResponse.message) && Intrinsics.areEqual(this.signature, asavResponse.signature);
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "AsavResponse(message=" + this.message + ", signature=" + this.signature + ')';
    }

    public AsavResponse(String message, String signature) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(signature, "signature");
        this.message = message;
        this.signature = signature;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getSignature() {
        return this.signature;
    }
}
