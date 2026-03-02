package com.bat.sdk.fota;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FotaSetupData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006,"}, m5598d2 = {"Lcom/bat/sdk/fota/FotaSetupData;", "Landroid/os/Parcelable;", "versionMajor", "", "versionMinor", "versionRevision", "fileObjectId", "gitTag", "", "fileUri", "Landroid/net/Uri;", "<init>", "(IIIILjava/lang/String;Landroid/net/Uri;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getVersionMajor", "()I", "getVersionMinor", "getVersionRevision", "getFileObjectId", "getGitTag", "()Ljava/lang/String;", "getFileUri", "()Landroid/net/Uri;", "describeContents", "writeToParcel", "", "dest", "flags", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final /* data */ class FotaSetupData implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int fileObjectId;
    private final Uri fileUri;
    private final String gitTag;
    private final int versionMajor;
    private final int versionMinor;
    private final int versionRevision;

    public static /* synthetic */ FotaSetupData copy$default(FotaSetupData fotaSetupData, int i, int i2, int i3, int i4, String str, Uri uri, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = fotaSetupData.versionMajor;
        }
        if ((i5 & 2) != 0) {
            i2 = fotaSetupData.versionMinor;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = fotaSetupData.versionRevision;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = fotaSetupData.fileObjectId;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            str = fotaSetupData.gitTag;
        }
        String str2 = str;
        if ((i5 & 32) != 0) {
            uri = fotaSetupData.fileUri;
        }
        return fotaSetupData.copy(i, i6, i7, i8, str2, uri);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVersionMajor() {
        return this.versionMajor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getVersionMinor() {
        return this.versionMinor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getVersionRevision() {
        return this.versionRevision;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFileObjectId() {
        return this.fileObjectId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGitTag() {
        return this.gitTag;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Uri getFileUri() {
        return this.fileUri;
    }

    public final FotaSetupData copy(int versionMajor, int versionMinor, int versionRevision, int fileObjectId, String gitTag, Uri fileUri) {
        Intrinsics.checkNotNullParameter(gitTag, "gitTag");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        return new FotaSetupData(versionMajor, versionMinor, versionRevision, fileObjectId, gitTag, fileUri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FotaSetupData)) {
            return false;
        }
        FotaSetupData fotaSetupData = (FotaSetupData) other;
        return this.versionMajor == fotaSetupData.versionMajor && this.versionMinor == fotaSetupData.versionMinor && this.versionRevision == fotaSetupData.versionRevision && this.fileObjectId == fotaSetupData.fileObjectId && Intrinsics.areEqual(this.gitTag, fotaSetupData.gitTag) && Intrinsics.areEqual(this.fileUri, fotaSetupData.fileUri);
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.versionMajor) * 31) + Integer.hashCode(this.versionMinor)) * 31) + Integer.hashCode(this.versionRevision)) * 31) + Integer.hashCode(this.fileObjectId)) * 31) + this.gitTag.hashCode()) * 31) + this.fileUri.hashCode();
    }

    public String toString() {
        return "FotaSetupData(versionMajor=" + this.versionMajor + ", versionMinor=" + this.versionMinor + ", versionRevision=" + this.versionRevision + ", fileObjectId=" + this.fileObjectId + ", gitTag=" + this.gitTag + ", fileUri=" + this.fileUri + ')';
    }

    public FotaSetupData(int i, int i2, int i3, int i4, String gitTag, Uri fileUri) {
        Intrinsics.checkNotNullParameter(gitTag, "gitTag");
        Intrinsics.checkNotNullParameter(fileUri, "fileUri");
        this.versionMajor = i;
        this.versionMinor = i2;
        this.versionRevision = i3;
        this.fileObjectId = i4;
        this.gitTag = gitTag;
        this.fileUri = fileUri;
    }

    public final int getVersionMajor() {
        return this.versionMajor;
    }

    public final int getVersionMinor() {
        return this.versionMinor;
    }

    public final int getVersionRevision() {
        return this.versionRevision;
    }

    public final int getFileObjectId() {
        return this.fileObjectId;
    }

    public final String getGitTag() {
        return this.gitTag;
    }

    public final Uri getFileUri() {
        return this.fileUri;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FotaSetupData(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        int i2 = parcel.readInt();
        int i3 = parcel.readInt();
        int i4 = parcel.readInt();
        String string = parcel.readString();
        String str = string == null ? "tag_missing" : string;
        Parcelable parcelable = parcel.readParcelable(Uri.class.getClassLoader());
        Intrinsics.checkNotNull(parcelable);
        this(i, i2, i3, i4, str, (Uri) parcelable);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.versionMajor);
        dest.writeInt(this.versionMinor);
        dest.writeInt(this.versionRevision);
        dest.writeInt(this.fileObjectId);
        dest.writeString(this.gitTag);
        dest.writeParcelable(this.fileUri, 0);
    }

    /* JADX INFO: renamed from: com.bat.sdk.fota.FotaSetupData$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: FotaSetupData.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/bat/sdk/fota/FotaSetupData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/bat/sdk/fota/FotaSetupData;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/bat/sdk/fota/FotaSetupData;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
    public static final class Companion implements Parcelable.Creator<FotaSetupData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FotaSetupData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FotaSetupData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FotaSetupData[] newArray(int size) {
            return new FotaSetupData[size];
        }
    }
}
