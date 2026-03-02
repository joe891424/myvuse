package com.bat.sdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: compiled from: PayloadVersion.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006#"}, m5598d2 = {"Lcom/bat/sdk/model/PayloadVersion;", "", "major", "", "minor", "revision", HeaderParameterNames.AUTHENTICATION_TAG, "", "fileLength", "fileObjectId", "fileMd5Sum", "<init>", "(IIILjava/lang/String;IILjava/lang/String;)V", "getMajor", "()I", "getMinor", "getRevision", "getTag", "()Ljava/lang/String;", "getFileLength", "getFileObjectId", "getFileMd5Sum", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class PayloadVersion {
    private final int fileLength;
    private final String fileMd5Sum;
    private final int fileObjectId;
    private final int major;
    private final int minor;
    private final int revision;
    private final String tag;

    public PayloadVersion() {
        this(0, 0, 0, null, 0, 0, null, 127, null);
    }

    public static /* synthetic */ PayloadVersion copy$default(PayloadVersion payloadVersion, int i, int i2, int i3, String str, int i4, int i5, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = payloadVersion.major;
        }
        if ((i6 & 2) != 0) {
            i2 = payloadVersion.minor;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = payloadVersion.revision;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            str = payloadVersion.tag;
        }
        String str3 = str;
        if ((i6 & 16) != 0) {
            i4 = payloadVersion.fileLength;
        }
        int i9 = i4;
        if ((i6 & 32) != 0) {
            i5 = payloadVersion.fileObjectId;
        }
        int i10 = i5;
        if ((i6 & 64) != 0) {
            str2 = payloadVersion.fileMd5Sum;
        }
        return payloadVersion.copy(i, i7, i8, str3, i9, i10, str2);
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
    public final int getFileLength() {
        return this.fileLength;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getFileObjectId() {
        return this.fileObjectId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFileMd5Sum() {
        return this.fileMd5Sum;
    }

    public final PayloadVersion copy(int major, int minor, int revision, String tag, int fileLength, int fileObjectId, String fileMd5Sum) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(fileMd5Sum, "fileMd5Sum");
        return new PayloadVersion(major, minor, revision, tag, fileLength, fileObjectId, fileMd5Sum);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayloadVersion)) {
            return false;
        }
        PayloadVersion payloadVersion = (PayloadVersion) other;
        return this.major == payloadVersion.major && this.minor == payloadVersion.minor && this.revision == payloadVersion.revision && Intrinsics.areEqual(this.tag, payloadVersion.tag) && this.fileLength == payloadVersion.fileLength && this.fileObjectId == payloadVersion.fileObjectId && Intrinsics.areEqual(this.fileMd5Sum, payloadVersion.fileMd5Sum);
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.major) * 31) + Integer.hashCode(this.minor)) * 31) + Integer.hashCode(this.revision)) * 31) + this.tag.hashCode()) * 31) + Integer.hashCode(this.fileLength)) * 31) + Integer.hashCode(this.fileObjectId)) * 31) + this.fileMd5Sum.hashCode();
    }

    public String toString() {
        return "PayloadVersion(major=" + this.major + ", minor=" + this.minor + ", revision=" + this.revision + ", tag=" + this.tag + ", fileLength=" + this.fileLength + ", fileObjectId=" + this.fileObjectId + ", fileMd5Sum=" + this.fileMd5Sum + ')';
    }

    public PayloadVersion(int i, int i2, int i3, String tag, int i4, int i5, String fileMd5Sum) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(fileMd5Sum, "fileMd5Sum");
        this.major = i;
        this.minor = i2;
        this.revision = i3;
        this.tag = tag;
        this.fileLength = i4;
        this.fileObjectId = i5;
        this.fileMd5Sum = fileMd5Sum;
    }

    public /* synthetic */ PayloadVersion(int i, int i2, int i3, String str, int i4, int i5, String str2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? "" : str, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) == 0 ? i5 : 0, (i6 & 64) != 0 ? "" : str2);
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

    public final int getFileLength() {
        return this.fileLength;
    }

    public final int getFileObjectId() {
        return this.fileObjectId;
    }

    public final String getFileMd5Sum() {
        return this.fileMd5Sum;
    }
}
