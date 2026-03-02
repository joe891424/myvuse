package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\f\r\u000e\u000f\u0010\u0011B9\b\u0004\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n\u0082\u0001\u0006\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$FeatureFailureType;", "icon", "", "messageTitleId", "messageTextId", "buttonTextId", "buttonIcon", "(IIIII)V", "getButtonIcon", "()I", "getButtonTextId", "DocumentExpired", "DocumentTextExtractionError", "DuplicatedDocument", "InvalidDocument", "NoMoreAttempts", "WrongNumberOfPages", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DuplicatedDocument;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$InvalidDocument;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$WrongNumberOfPages;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentExpired;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class TextExtractionUploadFailureType extends YdsFailureType.FeatureFailureType {
    private final int buttonIcon;
    private final int buttonTextId;

    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentExpired;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "isSelectableDocumentFlow", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentExpired extends TextExtractionUploadFailureType {
        public static final Parcelable.Creator<DocumentExpired> CREATOR = new Creator();
        private final boolean isSelectableDocumentFlow;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<DocumentExpired> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentExpired createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DocumentExpired(parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentExpired[] newArray(int i) {
                return new DocumentExpired[i];
            }
        }

        public DocumentExpired() {
            this(false, 1, null);
        }

        public /* synthetic */ DocumentExpired(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public static /* synthetic */ DocumentExpired copy$default(DocumentExpired documentExpired, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = documentExpired.isSelectableDocumentFlow;
            }
            return documentExpired.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsSelectableDocumentFlow() {
            return this.isSelectableDocumentFlow;
        }

        public final DocumentExpired copy(boolean isSelectableDocumentFlow) {
            return new DocumentExpired(isSelectableDocumentFlow);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DocumentExpired) && this.isSelectableDocumentFlow == ((DocumentExpired) other).isSelectableDocumentFlow;
        }

        public int hashCode() {
            boolean z = this.isSelectableDocumentFlow;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isSelectableDocumentFlow() {
            return this.isSelectableDocumentFlow;
        }

        public String toString() {
            return "DocumentExpired(isSelectableDocumentFlow=" + this.isSelectableDocumentFlow + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isSelectableDocumentFlow ? 1 : 0);
        }

        public DocumentExpired(boolean z) {
            super(C4608R.drawable.yds_ic_unsupported_document, C4608R.string.yds_document_expired_header, z ? C4608R.string.yds_document_expired_description_multi_doc_select : C4608R.string.yds_document_expired_description_no_doc_select, z ? C4608R.string.yds_common_change_document : C4608R.string.yds_common_try_again, z ? C4608R.drawable.yds_ic_document : C4608R.drawable.yds_ico_retry, null);
            this.isSelectableDocumentFlow = z;
        }
    }

    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DuplicatedDocument;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "isSelectableDocumentFlow", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DuplicatedDocument extends TextExtractionUploadFailureType {
        public static final Parcelable.Creator<DuplicatedDocument> CREATOR = new Creator();
        private final boolean isSelectableDocumentFlow;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<DuplicatedDocument> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DuplicatedDocument createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DuplicatedDocument(parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DuplicatedDocument[] newArray(int i) {
                return new DuplicatedDocument[i];
            }
        }

        public DuplicatedDocument() {
            this(false, 1, null);
        }

        public /* synthetic */ DuplicatedDocument(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public static /* synthetic */ DuplicatedDocument copy$default(DuplicatedDocument duplicatedDocument, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = duplicatedDocument.isSelectableDocumentFlow;
            }
            return duplicatedDocument.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsSelectableDocumentFlow() {
            return this.isSelectableDocumentFlow;
        }

        public final DuplicatedDocument copy(boolean isSelectableDocumentFlow) {
            return new DuplicatedDocument(isSelectableDocumentFlow);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DuplicatedDocument) && this.isSelectableDocumentFlow == ((DuplicatedDocument) other).isSelectableDocumentFlow;
        }

        public int hashCode() {
            boolean z = this.isSelectableDocumentFlow;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isSelectableDocumentFlow() {
            return this.isSelectableDocumentFlow;
        }

        public String toString() {
            return "DuplicatedDocument(isSelectableDocumentFlow=" + this.isSelectableDocumentFlow + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isSelectableDocumentFlow ? 1 : 0);
        }

        public DuplicatedDocument(boolean z) {
            super(C4608R.drawable.yds_ic_duplicated_document, C4608R.string.yds_wrong_doc_or_country_duplicated_document_header, z ? C4608R.string.f6729xf16b87f9 : C4608R.string.f6730x2cd9875c, 0, 0, 24, null);
            this.isSelectableDocumentFlow = z;
        }
    }

    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$InvalidDocument;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "isSelectableDocumentFlow", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class InvalidDocument extends TextExtractionUploadFailureType {
        public static final Parcelable.Creator<InvalidDocument> CREATOR = new Creator();
        private final boolean isSelectableDocumentFlow;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<InvalidDocument> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InvalidDocument createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new InvalidDocument(parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InvalidDocument[] newArray(int i) {
                return new InvalidDocument[i];
            }
        }

        public InvalidDocument() {
            this(false, 1, null);
        }

        public /* synthetic */ InvalidDocument(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public static /* synthetic */ InvalidDocument copy$default(InvalidDocument invalidDocument, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = invalidDocument.isSelectableDocumentFlow;
            }
            return invalidDocument.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsSelectableDocumentFlow() {
            return this.isSelectableDocumentFlow;
        }

        public final InvalidDocument copy(boolean isSelectableDocumentFlow) {
            return new InvalidDocument(isSelectableDocumentFlow);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InvalidDocument) && this.isSelectableDocumentFlow == ((InvalidDocument) other).isSelectableDocumentFlow;
        }

        public int hashCode() {
            boolean z = this.isSelectableDocumentFlow;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isSelectableDocumentFlow() {
            return this.isSelectableDocumentFlow;
        }

        public String toString() {
            return "InvalidDocument(isSelectableDocumentFlow=" + this.isSelectableDocumentFlow + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isSelectableDocumentFlow ? 1 : 0);
        }

        public InvalidDocument(boolean z) {
            super(C4608R.drawable.yds_ic_unsupported_document, C4608R.string.yds_wrong_doc_or_country_wrong_number_of_pages_header, z ? C4608R.string.f6733xcf3b75ab : C4608R.string.f6734xf36dc6ea, 0, 0, 24, null);
            this.isSelectableDocumentFlow = z;
        }
    }

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB%\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "icon", "", "messageTitleId", "messageTextId", "(III)V", "NoMoreAttemptsExpiration", "NoMoreAttemptsQuality", "NoMoreAttemptsReclassification", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts$NoMoreAttemptsReclassification;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts$NoMoreAttemptsExpiration;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts$NoMoreAttemptsQuality;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class NoMoreAttempts extends TextExtractionUploadFailureType {

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts$NoMoreAttemptsExpiration;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NoMoreAttemptsExpiration extends NoMoreAttempts {
            public static final NoMoreAttemptsExpiration INSTANCE = new NoMoreAttemptsExpiration();
            public static final Parcelable.Creator<NoMoreAttemptsExpiration> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<NoMoreAttemptsExpiration> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoMoreAttemptsExpiration createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return NoMoreAttemptsExpiration.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoMoreAttemptsExpiration[] newArray(int i) {
                    return new NoMoreAttemptsExpiration[i];
                }
            }

            private NoMoreAttemptsExpiration() {
                super(C4608R.drawable.yds_ic_unsupported_document, C4608R.string.yds_document_expired_header, C4608R.string.yds_document_expired_failure_description, null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts$NoMoreAttemptsQuality;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NoMoreAttemptsQuality extends NoMoreAttempts {
            public static final NoMoreAttemptsQuality INSTANCE = new NoMoreAttemptsQuality();
            public static final Parcelable.Creator<NoMoreAttemptsQuality> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<NoMoreAttemptsQuality> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoMoreAttemptsQuality createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return NoMoreAttemptsQuality.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoMoreAttemptsQuality[] newArray(int i) {
                    return new NoMoreAttemptsQuality[i];
                }
            }

            private NoMoreAttemptsQuality() {
                super(C4608R.drawable.yds_ic_wrong_document, C4608R.string.yds_quality_processing_issue_exit_header, C4608R.string.yds_quality_processing_issue_exit_description, null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts$NoMoreAttemptsReclassification;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$NoMoreAttempts;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NoMoreAttemptsReclassification extends NoMoreAttempts {
            public static final NoMoreAttemptsReclassification INSTANCE = new NoMoreAttemptsReclassification();
            public static final Parcelable.Creator<NoMoreAttemptsReclassification> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<NoMoreAttemptsReclassification> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoMoreAttemptsReclassification createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return NoMoreAttemptsReclassification.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoMoreAttemptsReclassification[] newArray(int i) {
                    return new NoMoreAttemptsReclassification[i];
                }
            }

            private NoMoreAttemptsReclassification() {
                super(C4608R.drawable.yds_ic_error, C4608R.string.yds_wrong_doc_or_country_reclassification_failure_header, C4608R.string.yds_wrong_doc_or_country_reclassification_failure_description, null);
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

        private NoMoreAttempts(int i, int i2, int i3) {
            super(i, i2, i3, C4608R.string.yds_common_exit, 0, null);
        }

        public /* synthetic */ NoMoreAttempts(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, i3);
        }
    }

    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$WrongNumberOfPages;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "isSelectableDocumentFlow", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class WrongNumberOfPages extends TextExtractionUploadFailureType {
        public static final Parcelable.Creator<WrongNumberOfPages> CREATOR = new Creator();
        private final boolean isSelectableDocumentFlow;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<WrongNumberOfPages> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final WrongNumberOfPages createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new WrongNumberOfPages(parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final WrongNumberOfPages[] newArray(int i) {
                return new WrongNumberOfPages[i];
            }
        }

        public WrongNumberOfPages() {
            this(false, 1, null);
        }

        public /* synthetic */ WrongNumberOfPages(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public static /* synthetic */ WrongNumberOfPages copy$default(WrongNumberOfPages wrongNumberOfPages, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = wrongNumberOfPages.isSelectableDocumentFlow;
            }
            return wrongNumberOfPages.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsSelectableDocumentFlow() {
            return this.isSelectableDocumentFlow;
        }

        public final WrongNumberOfPages copy(boolean isSelectableDocumentFlow) {
            return new WrongNumberOfPages(isSelectableDocumentFlow);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WrongNumberOfPages) && this.isSelectableDocumentFlow == ((WrongNumberOfPages) other).isSelectableDocumentFlow;
        }

        public int hashCode() {
            boolean z = this.isSelectableDocumentFlow;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isSelectableDocumentFlow() {
            return this.isSelectableDocumentFlow;
        }

        public String toString() {
            return "WrongNumberOfPages(isSelectableDocumentFlow=" + this.isSelectableDocumentFlow + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isSelectableDocumentFlow ? 1 : 0);
        }

        public WrongNumberOfPages(boolean z) {
            super(C4608R.drawable.yds_ic_wrong_document, C4608R.string.yds_wrong_doc_or_country_wrong_number_of_pages_header, z ? C4608R.string.f6731xd7610bba : C4608R.string.f6732x44c3833b, 0, 0, 24, null);
            this.isSelectableDocumentFlow = z;
        }
    }

    public /* synthetic */ TextExtractionUploadFailureType(int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? C4608R.string.yds_common_try_again : i4, (i6 & 16) != 0 ? C4608R.drawable.yds_ico_retry : i5, null);
    }

    public /* synthetic */ TextExtractionUploadFailureType(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5);
    }

    public final int getButtonIcon() {
        return this.buttonIcon;
    }

    public final int getButtonTextId() {
        return this.buttonTextId;
    }

    @Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B+\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\n\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType;", "titleId", "", "textId", "instructionItems", "", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$InstructionItem;", "(IILjava/util/List;)V", "getInstructionItems", "()Ljava/util/List;", "Blurry", "FaceNotFound", "Generic", "GlareObstruction", "IncorrectlyFramed", "InstructionItem", "MissingBackPage", "NoColor", "NoDocument", "ScreenCapture", "UnableToReadBarcode", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$NoDocument;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$FaceNotFound;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$IncorrectlyFramed;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$ScreenCapture;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$Blurry;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$GlareObstruction;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$NoColor;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$UnableToReadBarcode;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$MissingBackPage;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$Generic;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class DocumentTextExtractionError extends TextExtractionUploadFailureType {
        private final List<InstructionItem> instructionItems;

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$Blurry;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Blurry extends DocumentTextExtractionError {
            public static final Blurry INSTANCE = new Blurry();
            public static final Parcelable.Creator<Blurry> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<Blurry> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Blurry createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Blurry.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Blurry[] newArray(int i) {
                    return new Blurry[i];
                }
            }

            private Blurry() {
                super(C4608R.string.yds_failed_ocr_cant_see_details_title, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf((Object[]) new InstructionItem[]{new InstructionItem(C4608R.drawable.yds_ic_my_data, C4608R.string.yds_failed_ocr_guideline_covered_details), new InstructionItem(C4608R.drawable.yds_ic_show, C4608R.string.yds_failed_ocr_guidelines_clear_details)}), null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$FaceNotFound;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class FaceNotFound extends DocumentTextExtractionError {
            public static final FaceNotFound INSTANCE = new FaceNotFound();
            public static final Parcelable.Creator<FaceNotFound> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<FaceNotFound> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final FaceNotFound createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return FaceNotFound.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final FaceNotFound[] newArray(int i) {
                    return new FaceNotFound[i];
                }
            }

            private FaceNotFound() {
                super(C4608R.string.yds_failed_ocr_face_not_found_title, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf((Object[]) new InstructionItem[]{new InstructionItem(C4608R.drawable.yds_ic_documents, C4608R.string.yds_failed_ocr_guideline_correct_document), new InstructionItem(C4608R.drawable.yds_ic_document_image, C4608R.string.yds_failed_ocr_guideline_whole_document), new InstructionItem(C4608R.drawable.yds_ic_my_data, C4608R.string.yds_failed_ocr_guideline_covered_details)}), null);
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

        @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$Generic;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "isSelectableDocumentFlow", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class Generic extends DocumentTextExtractionError {
            public static final Parcelable.Creator<Generic> CREATOR = new Creator();
            private final boolean isSelectableDocumentFlow;

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<Generic> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Generic createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Generic(parcel.readInt() != 0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final Generic[] newArray(int i) {
                    return new Generic[i];
                }
            }

            public Generic(boolean z) {
                super(C4608R.string.yds_failed_ocr_title, z ? C4608R.string.yds_failed_ocr_capture_description_select : C4608R.string.yds_failed_ocr_capture_description, null, 4, null);
                this.isSelectableDocumentFlow = z;
            }

            public static /* synthetic */ Generic copy$default(Generic generic, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = generic.isSelectableDocumentFlow;
                }
                return generic.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsSelectableDocumentFlow() {
                return this.isSelectableDocumentFlow;
            }

            public final Generic copy(boolean isSelectableDocumentFlow) {
                return new Generic(isSelectableDocumentFlow);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Generic) && this.isSelectableDocumentFlow == ((Generic) other).isSelectableDocumentFlow;
            }

            public int hashCode() {
                boolean z = this.isSelectableDocumentFlow;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public final boolean isSelectableDocumentFlow() {
                return this.isSelectableDocumentFlow;
            }

            public String toString() {
                return "Generic(isSelectableDocumentFlow=" + this.isSelectableDocumentFlow + ')';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.isSelectableDocumentFlow ? 1 : 0);
            }
        }

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$GlareObstruction;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class GlareObstruction extends DocumentTextExtractionError {
            public static final GlareObstruction INSTANCE = new GlareObstruction();
            public static final Parcelable.Creator<GlareObstruction> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<GlareObstruction> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final GlareObstruction createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return GlareObstruction.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final GlareObstruction[] newArray(int i) {
                    return new GlareObstruction[i];
                }
            }

            private GlareObstruction() {
                super(C4608R.string.yds_failed_ocr_glare_obstruction_title, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf((Object[]) new InstructionItem[]{new InstructionItem(C4608R.drawable.yds_ic_lighter, C4608R.string.yds_failed_ocr_guidelines_glare), new InstructionItem(C4608R.drawable.yds_ic_show, C4608R.string.yds_failed_ocr_guidelines_clear_details)}), null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$IncorrectlyFramed;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class IncorrectlyFramed extends DocumentTextExtractionError {
            public static final IncorrectlyFramed INSTANCE = new IncorrectlyFramed();
            public static final Parcelable.Creator<IncorrectlyFramed> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<IncorrectlyFramed> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final IncorrectlyFramed createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return IncorrectlyFramed.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final IncorrectlyFramed[] newArray(int i) {
                    return new IncorrectlyFramed[i];
                }
            }

            private IncorrectlyFramed() {
                super(C4608R.string.yds_failed_ocr_cant_see_details_title, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf((Object[]) new InstructionItem[]{new InstructionItem(C4608R.drawable.yds_ic_document_image, C4608R.string.yds_failed_ocr_guideline_whole_document), new InstructionItem(C4608R.drawable.yds_ic_my_data, C4608R.string.yds_failed_ocr_guideline_covered_details), new InstructionItem(C4608R.drawable.yds_ic_doc_pass_card, C4608R.string.yds_failed_ocr_guideline_straight_document)}), null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$InstructionItem;", "", "imageId", "", "textId", "(II)V", "getImageId", "()I", "getTextId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class InstructionItem {
            private final int imageId;
            private final int textId;

            public InstructionItem(int i, int i2) {
                this.imageId = i;
                this.textId = i2;
            }

            public static /* synthetic */ InstructionItem copy$default(InstructionItem instructionItem, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = instructionItem.imageId;
                }
                if ((i3 & 2) != 0) {
                    i2 = instructionItem.textId;
                }
                return instructionItem.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getImageId() {
                return this.imageId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getTextId() {
                return this.textId;
            }

            public final InstructionItem copy(int imageId, int textId) {
                return new InstructionItem(imageId, textId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InstructionItem)) {
                    return false;
                }
                InstructionItem instructionItem = (InstructionItem) other;
                return this.imageId == instructionItem.imageId && this.textId == instructionItem.textId;
            }

            public final int getImageId() {
                return this.imageId;
            }

            public final int getTextId() {
                return this.textId;
            }

            public int hashCode() {
                return (Integer.hashCode(this.imageId) * 31) + Integer.hashCode(this.textId);
            }

            public String toString() {
                return "InstructionItem(imageId=" + this.imageId + ", textId=" + this.textId + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$MissingBackPage;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class MissingBackPage extends DocumentTextExtractionError {
            public static final MissingBackPage INSTANCE = new MissingBackPage();
            public static final Parcelable.Creator<MissingBackPage> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<MissingBackPage> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final MissingBackPage createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return MissingBackPage.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final MissingBackPage[] newArray(int i) {
                    return new MissingBackPage[i];
                }
            }

            private MissingBackPage() {
                super(C4608R.string.yds_failed_ocr_document_back_missing_header, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf((Object[]) new InstructionItem[]{new InstructionItem(C4608R.drawable.yds_ic_documents, C4608R.string.yds_failed_ocr_guideline_correct_document), new InstructionItem(C4608R.drawable.yds_ic_document_image, C4608R.string.yds_failed_ocr_guideline_whole_document), new InstructionItem(C4608R.drawable.yds_ic_my_data, C4608R.string.yds_failed_ocr_guideline_covered_details)}), null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$NoColor;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NoColor extends DocumentTextExtractionError {
            public static final NoColor INSTANCE = new NoColor();
            public static final Parcelable.Creator<NoColor> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<NoColor> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoColor createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return NoColor.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoColor[] newArray(int i) {
                    return new NoColor[i];
                }
            }

            private NoColor() {
                super(C4608R.string.yds_failed_ocr_no_colour_title, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf(new InstructionItem(C4608R.drawable.yds_ic_camera, C4608R.string.yds_failed_ocr_guidelines_colour)), null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$NoDocument;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class NoDocument extends DocumentTextExtractionError {
            public static final NoDocument INSTANCE = new NoDocument();
            public static final Parcelable.Creator<NoDocument> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<NoDocument> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoDocument createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return NoDocument.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final NoDocument[] newArray(int i) {
                    return new NoDocument[i];
                }
            }

            private NoDocument() {
                super(C4608R.string.yds_failed_ocr_no_document_title, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf((Object[]) new InstructionItem[]{new InstructionItem(C4608R.drawable.yds_ic_documents, C4608R.string.yds_failed_ocr_guideline_correct_document), new InstructionItem(C4608R.drawable.yds_ic_document_image, C4608R.string.yds_failed_ocr_guideline_whole_document), new InstructionItem(C4608R.drawable.yds_ic_my_data, C4608R.string.yds_failed_ocr_guideline_covered_details)}), null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$ScreenCapture;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class ScreenCapture extends DocumentTextExtractionError {
            public static final ScreenCapture INSTANCE = new ScreenCapture();
            public static final Parcelable.Creator<ScreenCapture> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<ScreenCapture> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final ScreenCapture createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return ScreenCapture.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final ScreenCapture[] newArray(int i) {
                    return new ScreenCapture[i];
                }
            }

            private ScreenCapture() {
                super(C4608R.string.yds_failed_ocr_screen_capture_title, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf((Object[]) new InstructionItem[]{new InstructionItem(C4608R.drawable.yds_ic_documents, C4608R.string.yds_failed_ocr_guideline_correct_document), new InstructionItem(C4608R.drawable.yds_ic_document_image, C4608R.string.yds_failed_ocr_guideline_whole_document), new InstructionItem(C4608R.drawable.yds_ic_my_data, C4608R.string.yds_failed_ocr_guideline_covered_details)}), null);
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

        @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError$UnableToReadBarcode;", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class UnableToReadBarcode extends DocumentTextExtractionError {
            public static final UnableToReadBarcode INSTANCE = new UnableToReadBarcode();
            public static final Parcelable.Creator<UnableToReadBarcode> CREATOR = new Creator();

            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
            public static final class Creator implements Parcelable.Creator<UnableToReadBarcode> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final UnableToReadBarcode createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return UnableToReadBarcode.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final UnableToReadBarcode[] newArray(int i) {
                    return new UnableToReadBarcode[i];
                }
            }

            private UnableToReadBarcode() {
                super(C4608R.string.yds_failed_ocr_barcode_missing_header, C4608R.string.yds_failed_ocr_description, CollectionsKt.listOf((Object[]) new InstructionItem[]{new InstructionItem(C4608R.drawable.yds_ic_my_data, C4608R.string.yds_failed_ocr_guideline_barcode_clear), new InstructionItem(C4608R.drawable.yds_ic_documents, C4608R.string.yds_failed_ocr_guideline_correct_document), new InstructionItem(C4608R.drawable.yds_ic_document_image, C4608R.string.yds_failed_ocr_guideline_whole_document)}), null);
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

        public /* synthetic */ DocumentTextExtractionError(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, null);
        }

        public /* synthetic */ DocumentTextExtractionError(int i, int i2, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, list);
        }

        public final List<InstructionItem> getInstructionItems() {
            return this.instructionItems;
        }

        private DocumentTextExtractionError(int i, int i2, List<InstructionItem> list) {
            super(0, i, i2, C4608R.string.yds_common_try_again, C4608R.drawable.yds_ico_retry, 1, null);
            this.instructionItems = list;
        }
    }

    private TextExtractionUploadFailureType(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3);
        this.buttonTextId = i4;
        this.buttonIcon = i5;
    }
}
