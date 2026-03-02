package com.yoti.mobile.android.documentcapture.p055id.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/IdDocumentCountryNotListedFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentCountryNotListedFailureType;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentCountryNotListedFailureType extends DocumentFeatureFailureType.DocumentCountryNotListedFailureType {
    public static final IdDocumentCountryNotListedFailureType INSTANCE = new IdDocumentCountryNotListedFailureType();
    public static final Parcelable.Creator<IdDocumentCountryNotListedFailureType> CREATOR = new Creator();

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Creator implements Parcelable.Creator<IdDocumentCountryNotListedFailureType> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IdDocumentCountryNotListedFailureType createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return IdDocumentCountryNotListedFailureType.INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final IdDocumentCountryNotListedFailureType[] newArray(int i) {
            return new IdDocumentCountryNotListedFailureType[i];
        }
    }

    private IdDocumentCountryNotListedFailureType() {
        super(C4608R.drawable.yds_ic_wrong_document, C4608R.string.yds_no_document_provided_header_unsupported_country, C4608R.string.yds_no_document_provided_description_unsupported_country_id_doc);
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
