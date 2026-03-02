package com.bat.sdk.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AgeChallenge.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/model/AgeChallenge;", "", "deviceId", "", "randomData", "<init>", "([B[B)V", "getDeviceId", "()[B", "getRandomData", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class AgeChallenge {
    private final byte[] deviceId;
    private final byte[] randomData;

    public static /* synthetic */ AgeChallenge copy$default(AgeChallenge ageChallenge, byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = ageChallenge.deviceId;
        }
        if ((i & 2) != 0) {
            bArr2 = ageChallenge.randomData;
        }
        return ageChallenge.copy(bArr, bArr2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getRandomData() {
        return this.randomData;
    }

    public final AgeChallenge copy(byte[] deviceId, byte[] randomData) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(randomData, "randomData");
        return new AgeChallenge(deviceId, randomData);
    }

    public String toString() {
        return "AgeChallenge(deviceId=" + Arrays.toString(this.deviceId) + ", randomData=" + Arrays.toString(this.randomData) + ')';
    }

    public AgeChallenge(byte[] deviceId, byte[] randomData) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(randomData, "randomData");
        this.deviceId = deviceId;
        this.randomData = randomData;
    }

    public final byte[] getDeviceId() {
        return this.deviceId;
    }

    public final byte[] getRandomData() {
        return this.randomData;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.AgeChallenge");
        AgeChallenge ageChallenge = (AgeChallenge) other;
        return Arrays.equals(this.deviceId, ageChallenge.deviceId) && Arrays.equals(this.randomData, ageChallenge.randomData);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.deviceId) * 31) + Arrays.hashCode(this.randomData);
    }
}
