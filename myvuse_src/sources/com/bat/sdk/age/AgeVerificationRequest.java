package com.bat.sdk.age;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AgeVerificationRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m5598d2 = {"Lcom/bat/sdk/age/AgeVerificationRequest;", "", "message", "", "deviceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getDeviceType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class AgeVerificationRequest {

    @SerializedName("device_type")
    private final String deviceType;
    private final String message;

    public static /* synthetic */ AgeVerificationRequest copy$default(AgeVerificationRequest ageVerificationRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ageVerificationRequest.message;
        }
        if ((i & 2) != 0) {
            str2 = ageVerificationRequest.deviceType;
        }
        return ageVerificationRequest.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    public final AgeVerificationRequest copy(String message, String deviceType) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        return new AgeVerificationRequest(message, deviceType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgeVerificationRequest)) {
            return false;
        }
        AgeVerificationRequest ageVerificationRequest = (AgeVerificationRequest) other;
        return Intrinsics.areEqual(this.message, ageVerificationRequest.message) && Intrinsics.areEqual(this.deviceType, ageVerificationRequest.deviceType);
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.deviceType.hashCode();
    }

    public String toString() {
        return "AgeVerificationRequest(message=" + this.message + ", deviceType=" + this.deviceType + ')';
    }

    public AgeVerificationRequest(String message, String deviceType) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        this.message = message;
        this.deviceType = deviceType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }
}
