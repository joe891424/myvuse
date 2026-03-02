package com.yoti.mobile.android.documentscan.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentscan.model.result.Address;
import com.yoti.mobile.android.documentscan.model.result.DocumentData;
import com.yoti.mobile.android.documentscan.model.result.Holder;
import com.yoti.mobile.android.documentscan.model.result.MetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, m5598d2 = {"Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "Landroid/os/Parcelable;", "address", "Lcom/yoti/mobile/android/documentscan/model/result/Address;", "metaData", "Lcom/yoti/mobile/android/documentscan/model/result/MetaData;", "holder", "Lcom/yoti/mobile/android/documentscan/model/result/Holder;", "holderAlias", "documentData", "Lcom/yoti/mobile/android/documentscan/model/result/DocumentData;", "(Lcom/yoti/mobile/android/documentscan/model/result/Address;Lcom/yoti/mobile/android/documentscan/model/result/MetaData;Lcom/yoti/mobile/android/documentscan/model/result/Holder;Lcom/yoti/mobile/android/documentscan/model/result/Holder;Lcom/yoti/mobile/android/documentscan/model/result/DocumentData;)V", "getAddress", "()Lcom/yoti/mobile/android/documentscan/model/result/Address;", "getDocumentData", "()Lcom/yoti/mobile/android/documentscan/model/result/DocumentData;", "getHolder", "()Lcom/yoti/mobile/android/documentscan/model/result/Holder;", "getHolderAlias", "getMetaData", "()Lcom/yoti/mobile/android/documentscan/model/result/MetaData;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentscan_release"}, m5599k = 1, m5600mv = {1, 1, 15})
public final /* data */ class DocumentCaptureResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final Address address;
    private final DocumentData documentData;
    private final Holder holder;
    private final Holder holderAlias;
    private final MetaData metaData;

    @Metadata(m5596bv = {1, 0, 3}, m5599k = 3, m5600mv = {1, 1, 15})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new DocumentCaptureResult(in.readInt() != 0 ? (Address) Address.CREATOR.createFromParcel(in) : null, in.readInt() != 0 ? (MetaData) MetaData.CREATOR.createFromParcel(in) : null, in.readInt() != 0 ? (Holder) Holder.CREATOR.createFromParcel(in) : null, in.readInt() != 0 ? (Holder) Holder.CREATOR.createFromParcel(in) : null, in.readInt() != 0 ? (DocumentData) DocumentData.CREATOR.createFromParcel(in) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new DocumentCaptureResult[i];
        }
    }

    public DocumentCaptureResult(Address address, MetaData metaData, Holder holder, Holder holder2, DocumentData documentData) {
        this.address = address;
        this.metaData = metaData;
        this.holder = holder;
        this.holderAlias = holder2;
        this.documentData = documentData;
    }

    public static /* synthetic */ DocumentCaptureResult copy$default(DocumentCaptureResult documentCaptureResult, Address address, MetaData metaData, Holder holder, Holder holder2, DocumentData documentData, int i, Object obj) {
        if ((i & 1) != 0) {
            address = documentCaptureResult.address;
        }
        if ((i & 2) != 0) {
            metaData = documentCaptureResult.metaData;
        }
        MetaData metaData2 = metaData;
        if ((i & 4) != 0) {
            holder = documentCaptureResult.holder;
        }
        Holder holder3 = holder;
        if ((i & 8) != 0) {
            holder2 = documentCaptureResult.holderAlias;
        }
        Holder holder4 = holder2;
        if ((i & 16) != 0) {
            documentData = documentCaptureResult.documentData;
        }
        return documentCaptureResult.copy(address, metaData2, holder3, holder4, documentData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Address getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MetaData getMetaData() {
        return this.metaData;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Holder getHolder() {
        return this.holder;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Holder getHolderAlias() {
        return this.holderAlias;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DocumentData getDocumentData() {
        return this.documentData;
    }

    public final DocumentCaptureResult copy(Address address, MetaData metaData, Holder holder, Holder holderAlias, DocumentData documentData) {
        return new DocumentCaptureResult(address, metaData, holder, holderAlias, documentData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentCaptureResult)) {
            return false;
        }
        DocumentCaptureResult documentCaptureResult = (DocumentCaptureResult) other;
        return Intrinsics.areEqual(this.address, documentCaptureResult.address) && Intrinsics.areEqual(this.metaData, documentCaptureResult.metaData) && Intrinsics.areEqual(this.holder, documentCaptureResult.holder) && Intrinsics.areEqual(this.holderAlias, documentCaptureResult.holderAlias) && Intrinsics.areEqual(this.documentData, documentCaptureResult.documentData);
    }

    public final Address getAddress() {
        return this.address;
    }

    public final DocumentData getDocumentData() {
        return this.documentData;
    }

    public final Holder getHolder() {
        return this.holder;
    }

    public final Holder getHolderAlias() {
        return this.holderAlias;
    }

    public final MetaData getMetaData() {
        return this.metaData;
    }

    public int hashCode() {
        Address address = this.address;
        int iHashCode = (address != null ? address.hashCode() : 0) * 31;
        MetaData metaData = this.metaData;
        int iHashCode2 = (iHashCode + (metaData != null ? metaData.hashCode() : 0)) * 31;
        Holder holder = this.holder;
        int iHashCode3 = (iHashCode2 + (holder != null ? holder.hashCode() : 0)) * 31;
        Holder holder2 = this.holderAlias;
        int iHashCode4 = (iHashCode3 + (holder2 != null ? holder2.hashCode() : 0)) * 31;
        DocumentData documentData = this.documentData;
        return iHashCode4 + (documentData != null ? documentData.hashCode() : 0);
    }

    public String toString() {
        return "DocumentCaptureResult(address=" + this.address + ", metaData=" + this.metaData + ", holder=" + this.holder + ", holderAlias=" + this.holderAlias + ", documentData=" + this.documentData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Address address = this.address;
        if (address != null) {
            parcel.writeInt(1);
            address.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        MetaData metaData = this.metaData;
        if (metaData != null) {
            parcel.writeInt(1);
            metaData.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Holder holder = this.holder;
        if (holder != null) {
            parcel.writeInt(1);
            holder.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Holder holder2 = this.holderAlias;
        if (holder2 != null) {
            parcel.writeInt(1);
            holder2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        DocumentData documentData = this.documentData;
        if (documentData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            documentData.writeToParcel(parcel, 0);
        }
    }
}
