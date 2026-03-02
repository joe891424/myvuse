package com.yoti.mobile.android.documentcapture.view.selection;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.view.DocumentScreen;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007B\u000f\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\tHÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\tHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DoNotHaveDocumentsViewData;", "Landroid/os/Parcelable;", "screen", "Lcom/yoti/mobile/android/documentcapture/view/DocumentScreen;", "documents", "", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentScreen;Ljava/util/List;)V", "labelId", "", "(I)V", "getLabelId", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DoNotHaveDocumentsViewData implements Parcelable {
    public static final Parcelable.Creator<DoNotHaveDocumentsViewData> CREATOR = new Creator();
    private final int labelId;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<DoNotHaveDocumentsViewData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DoNotHaveDocumentsViewData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DoNotHaveDocumentsViewData(parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DoNotHaveDocumentsViewData[] newArray(int i) {
            return new DoNotHaveDocumentsViewData[i];
        }
    }

    public DoNotHaveDocumentsViewData(int i) {
        this.labelId = i;
    }

    public static /* synthetic */ DoNotHaveDocumentsViewData copy$default(DoNotHaveDocumentsViewData doNotHaveDocumentsViewData, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = doNotHaveDocumentsViewData.labelId;
        }
        return doNotHaveDocumentsViewData.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLabelId() {
        return this.labelId;
    }

    public final DoNotHaveDocumentsViewData copy(int labelId) {
        return new DoNotHaveDocumentsViewData(labelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DoNotHaveDocumentsViewData) && this.labelId == ((DoNotHaveDocumentsViewData) other).labelId;
    }

    public final int getLabelId() {
        return this.labelId;
    }

    public int hashCode() {
        return Integer.hashCode(this.labelId);
    }

    public String toString() {
        return "DoNotHaveDocumentsViewData(labelId=" + this.labelId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.labelId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DoNotHaveDocumentsViewData(DocumentScreen screen, List<DocumentViewData> documents) {
        this(DoNotHaveDocumentsViewDataKt.getLabel(screen, documents.size()));
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(documents, "documents");
    }
}
