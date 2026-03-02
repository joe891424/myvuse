package com.yoti.mobile.android.documentcapture.sup.view.upload;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/upload/UnprocessableMedia;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$FeatureFailureType;", "buttonTextId", "", "buttonIcon", "(II)V", "getButtonIcon", "()I", "getButtonTextId", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class UnprocessableMedia extends YdsFailureType.FeatureFailureType {
    public static final Parcelable.Creator<UnprocessableMedia> CREATOR = new Creator();
    private final int buttonIcon;
    private final int buttonTextId;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<UnprocessableMedia> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnprocessableMedia createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UnprocessableMedia(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UnprocessableMedia[] newArray(int i) {
            return new UnprocessableMedia[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public UnprocessableMedia() {
        int i = 0;
        this(i, i, 3, null);
    }

    public /* synthetic */ UnprocessableMedia(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? C4653R.string.yds_common_try_again : i, (i3 & 2) != 0 ? C4653R.drawable.yds_ico_retry : i2);
    }

    public static /* synthetic */ UnprocessableMedia copy$default(UnprocessableMedia unprocessableMedia, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = unprocessableMedia.buttonTextId;
        }
        if ((i3 & 2) != 0) {
            i2 = unprocessableMedia.buttonIcon;
        }
        return unprocessableMedia.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getButtonTextId() {
        return this.buttonTextId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getButtonIcon() {
        return this.buttonIcon;
    }

    public final UnprocessableMedia copy(int buttonTextId, int buttonIcon) {
        return new UnprocessableMedia(buttonTextId, buttonIcon);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnprocessableMedia)) {
            return false;
        }
        UnprocessableMedia unprocessableMedia = (UnprocessableMedia) other;
        return this.buttonTextId == unprocessableMedia.buttonTextId && this.buttonIcon == unprocessableMedia.buttonIcon;
    }

    public final int getButtonIcon() {
        return this.buttonIcon;
    }

    public final int getButtonTextId() {
        return this.buttonTextId;
    }

    public int hashCode() {
        return (Integer.hashCode(this.buttonTextId) * 31) + Integer.hashCode(this.buttonIcon);
    }

    public String toString() {
        return "UnprocessableMedia(buttonTextId=" + this.buttonTextId + ", buttonIcon=" + this.buttonIcon + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.buttonTextId);
        parcel.writeInt(this.buttonIcon);
    }

    public UnprocessableMedia(int i, int i2) {
        super(C4653R.drawable.yds_ic_error, C4653R.string.yds_non_id_document_failed_upload_header, C4653R.string.ios_android_yds_non_id_document_failed_upload_description);
        this.buttonTextId = i;
        this.buttonIcon = i2;
    }
}
