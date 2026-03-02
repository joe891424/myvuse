package com.bat.sdk.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AgeSignature.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m5598d2 = {"Lcom/bat/sdk/model/AgeSignature;", "", "originalData", "", "signature", "<init>", "([B[B)V", "getOriginalData", "()[B", "getSignature", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "toString", "", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class AgeSignature {
    private final byte[] originalData;
    private final byte[] signature;

    public static /* synthetic */ AgeSignature copy$default(AgeSignature ageSignature, byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = ageSignature.originalData;
        }
        if ((i & 2) != 0) {
            bArr2 = ageSignature.signature;
        }
        return ageSignature.copy(bArr, bArr2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getOriginalData() {
        return this.originalData;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getSignature() {
        return this.signature;
    }

    public final AgeSignature copy(byte[] originalData, byte[] signature) {
        return new AgeSignature(originalData, signature);
    }

    public String toString() {
        return "AgeSignature(originalData=" + Arrays.toString(this.originalData) + ", signature=" + Arrays.toString(this.signature) + ')';
    }

    public AgeSignature(byte[] bArr, byte[] bArr2) {
        this.originalData = bArr;
        this.signature = bArr2;
    }

    public final byte[] getOriginalData() {
        return this.originalData;
    }

    public final byte[] getSignature() {
        return this.signature;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bat.sdk.model.AgeSignature");
        AgeSignature ageSignature = (AgeSignature) other;
        byte[] bArr = this.originalData;
        if (bArr != null) {
            byte[] bArr2 = ageSignature.originalData;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (ageSignature.originalData != null) {
            return false;
        }
        byte[] bArr3 = this.signature;
        if (bArr3 != null) {
            byte[] bArr4 = ageSignature.signature;
            if (bArr4 == null || !Arrays.equals(bArr3, bArr4)) {
                return false;
            }
        } else if (ageSignature.signature != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        byte[] bArr = this.originalData;
        int iHashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        byte[] bArr2 = this.signature;
        return iHashCode + (bArr2 != null ? Arrays.hashCode(bArr2) : 0);
    }
}
