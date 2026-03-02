package com.yoti.mobile.android.documentcapture.sup.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/SupDocumentNotOwnedFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentNotOwnedFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentNotOwnedFailureType extends DocumentFeatureFailureType.DocumentNotOwnedFailureType {
    public static final SupDocumentNotOwnedFailureType INSTANCE = new SupDocumentNotOwnedFailureType();
    public static final Parcelable.Creator<SupDocumentNotOwnedFailureType> CREATOR = new Creator();

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<SupDocumentNotOwnedFailureType> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SupDocumentNotOwnedFailureType createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return SupDocumentNotOwnedFailureType.INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SupDocumentNotOwnedFailureType[] newArray(int i) {
            return new SupDocumentNotOwnedFailureType[i];
        }
    }

    private SupDocumentNotOwnedFailureType() {
        super(Integer.valueOf(C4653R.string.ios_android_yds_non_id_document_selection_modal_description), C4653R.drawable.yds_ic_wrong_document, C4653R.string.yds_no_document_provided_header_non_id_doc, C4653R.string.yds_no_document_provided_description_non_id_doc);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
