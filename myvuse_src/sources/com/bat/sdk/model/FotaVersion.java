package com.bat.sdk.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: FotaVersion.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m5598d2 = {"Lcom/bat/sdk/model/FotaVersion;", "", "major", "", "minor", "revision", HeaderParameterNames.AUTHENTICATION_TAG, "", "length", "firmwareObjectId", "firmwareMd5", "", "<init>", "(IIILjava/lang/String;II[B)V", "getMajor", "()I", "getMinor", "getRevision", "getTag", "()Ljava/lang/String;", "getLength", "getFirmwareObjectId", "getFirmwareMd5", "()[B", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class FotaVersion {
    private final byte[] firmwareMd5;
    private final int firmwareObjectId;
    private final int length;
    private final int major;
    private final int minor;
    private final int revision;
    private final String tag;

    public static /* synthetic */ FotaVersion copy$default(FotaVersion fotaVersion, int i, int i2, int i3, String str, int i4, int i5, byte[] bArr, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = fotaVersion.major;
        }
        if ((i6 & 2) != 0) {
            i2 = fotaVersion.minor;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = fotaVersion.revision;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            str = fotaVersion.tag;
        }
        String str2 = str;
        if ((i6 & 16) != 0) {
            i4 = fotaVersion.length;
        }
        int i9 = i4;
        if ((i6 & 32) != 0) {
            i5 = fotaVersion.firmwareObjectId;
        }
        int i10 = i5;
        if ((i6 & 64) != 0) {
            bArr = fotaVersion.firmwareMd5;
        }
        return fotaVersion.copy(i, i7, i8, str2, i9, i10, bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMajor() {
        return this.major;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMinor() {
        return this.minor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLength() {
        return this.length;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getFirmwareObjectId() {
        return this.firmwareObjectId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final byte[] getFirmwareMd5() {
        return this.firmwareMd5;
    }

    public final FotaVersion copy(int major, int minor, int revision, String tag, int length, int firmwareObjectId, byte[] firmwareMd5) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(firmwareMd5, "firmwareMd5");
        return new FotaVersion(major, minor, revision, tag, length, firmwareObjectId, firmwareMd5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FotaVersion)) {
            return false;
        }
        FotaVersion fotaVersion = (FotaVersion) other;
        return this.major == fotaVersion.major && this.minor == fotaVersion.minor && this.revision == fotaVersion.revision && Intrinsics.areEqual(this.tag, fotaVersion.tag) && this.length == fotaVersion.length && this.firmwareObjectId == fotaVersion.firmwareObjectId && Intrinsics.areEqual(this.firmwareMd5, fotaVersion.firmwareMd5);
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.major) * 31) + Integer.hashCode(this.minor)) * 31) + Integer.hashCode(this.revision)) * 31) + this.tag.hashCode()) * 31) + Integer.hashCode(this.length)) * 31) + Integer.hashCode(this.firmwareObjectId)) * 31) + Arrays.hashCode(this.firmwareMd5);
    }

    public String toString() {
        return "FotaVersion(major=" + this.major + ", minor=" + this.minor + ", revision=" + this.revision + ", tag=" + this.tag + ", length=" + this.length + ", firmwareObjectId=" + this.firmwareObjectId + ", firmwareMd5=" + Arrays.toString(this.firmwareMd5) + ')';
    }

    public FotaVersion(int i, int i2, int i3, String tag, int i4, int i5, byte[] firmwareMd5) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(firmwareMd5, "firmwareMd5");
        this.major = i;
        this.minor = i2;
        this.revision = i3;
        this.tag = tag;
        this.length = i4;
        this.firmwareObjectId = i5;
        this.firmwareMd5 = firmwareMd5;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getFirmwareObjectId() {
        return this.firmwareObjectId;
    }

    public final byte[] getFirmwareMd5() {
        return this.firmwareMd5;
    }
}
