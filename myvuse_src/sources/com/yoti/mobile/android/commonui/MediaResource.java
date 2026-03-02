package com.yoti.mobile.android.commonui;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaResource.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/MediaResource;", "Landroid/os/Parcelable;", "mediaType", "Lcom/yoti/mobile/android/commonui/MediaResource$MediaType;", "mediaResId", "", "(Lcom/yoti/mobile/android/commonui/MediaResource$MediaType;I)V", "getMediaResId", "()I", "getMediaType", "()Lcom/yoti/mobile/android/commonui/MediaResource$MediaType;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "MediaType", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class MediaResource implements Parcelable {
    public static final Parcelable.Creator<MediaResource> CREATOR = new Creator();
    private final int mediaResId;
    private final MediaType mediaType;

    /* JADX INFO: compiled from: MediaResource.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<MediaResource> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MediaResource createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaResource(MediaType.valueOf(parcel.readString()), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MediaResource[] newArray(int i) {
            return new MediaResource[i];
        }
    }

    /* JADX INFO: compiled from: MediaResource.kt */
    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/MediaResource$MediaType;", "", "(Ljava/lang/String;I)V", "VIDEO", "IMAGE", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum MediaType {
        VIDEO,
        IMAGE
    }

    public static /* synthetic */ MediaResource copy$default(MediaResource mediaResource, MediaType mediaType, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mediaType = mediaResource.mediaType;
        }
        if ((i2 & 2) != 0) {
            i = mediaResource.mediaResId;
        }
        return mediaResource.copy(mediaType, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MediaType getMediaType() {
        return this.mediaType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMediaResId() {
        return this.mediaResId;
    }

    public final MediaResource copy(MediaType mediaType, int mediaResId) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return new MediaResource(mediaType, mediaResId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaResource)) {
            return false;
        }
        MediaResource mediaResource = (MediaResource) other;
        return this.mediaType == mediaResource.mediaType && this.mediaResId == mediaResource.mediaResId;
    }

    public int hashCode() {
        return (this.mediaType.hashCode() * 31) + Integer.hashCode(this.mediaResId);
    }

    public String toString() {
        return "MediaResource(mediaType=" + this.mediaType + ", mediaResId=" + this.mediaResId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.mediaType.name());
        parcel.writeInt(this.mediaResId);
    }

    public MediaResource(MediaType mediaType, int i) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        this.mediaType = mediaType;
        this.mediaResId = i;
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final int getMediaResId() {
        return this.mediaResId;
    }
}
