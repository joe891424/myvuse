package com.yoti.mobile.android.documentcapture.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB%\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType;", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType$FeatureFailureType;", "icon", "", "messageTitleId", "messageTextId", "(III)V", "DocumentCountryNotListedFailureType", "DocumentNotOwnedFailureType", "DocumentResourceConfigFailureType", "DocumentScanConfigFailureType", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentResourceConfigFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentScanConfigFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentNotOwnedFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentCountryNotListedFailureType;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentFeatureFailureType extends YdsFailureType.FeatureFailureType {

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentCountryNotListedFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType;", "icon", "", "messageTitleId", "messageTextId", "(III)V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class DocumentCountryNotListedFailureType extends DocumentFeatureFailureType {
        public DocumentCountryNotListedFailureType(int i, int i2, int i3) {
            super(i, i2, i3, null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B/\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentNotOwnedFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType;", "dialogTextId", "", "icon", "messageTitleId", "messageTextId", "(Ljava/lang/Integer;III)V", "getDialogTextId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class DocumentNotOwnedFailureType extends DocumentFeatureFailureType {
        private final Integer dialogTextId;

        public DocumentNotOwnedFailureType(Integer num, int i, int i2, int i3) {
            super(i, i2, i3, null);
            this.dialogTextId = num;
        }

        public final Integer getDialogTextId() {
            return this.dialogTextId;
        }
    }

    @Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentResourceConfigFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType;", "failureCauseType", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;)V", "getFailureCauseType", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentResourceConfigFailureType extends DocumentFeatureFailureType {
        public static final Parcelable.Creator<DocumentResourceConfigFailureType> CREATOR = new Creator();
        private final YdsFailureType failureCauseType;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<DocumentResourceConfigFailureType> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentResourceConfigFailureType createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DocumentResourceConfigFailureType((YdsFailureType) parcel.readParcelable(DocumentResourceConfigFailureType.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentResourceConfigFailureType[] newArray(int i) {
                return new DocumentResourceConfigFailureType[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DocumentResourceConfigFailureType(YdsFailureType failureCauseType) {
            super(failureCauseType.getF7488a(), failureCauseType.getF7489b(), failureCauseType.getF7490c(), null);
            Intrinsics.checkNotNullParameter(failureCauseType, "failureCauseType");
            this.failureCauseType = failureCauseType;
        }

        public static /* synthetic */ DocumentResourceConfigFailureType copy$default(DocumentResourceConfigFailureType documentResourceConfigFailureType, YdsFailureType ydsFailureType, int i, Object obj) {
            if ((i & 1) != 0) {
                ydsFailureType = documentResourceConfigFailureType.failureCauseType;
            }
            return documentResourceConfigFailureType.copy(ydsFailureType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final YdsFailureType getFailureCauseType() {
            return this.failureCauseType;
        }

        public final DocumentResourceConfigFailureType copy(YdsFailureType failureCauseType) {
            Intrinsics.checkNotNullParameter(failureCauseType, "failureCauseType");
            return new DocumentResourceConfigFailureType(failureCauseType);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DocumentResourceConfigFailureType) && Intrinsics.areEqual(this.failureCauseType, ((DocumentResourceConfigFailureType) other).failureCauseType);
        }

        public final YdsFailureType getFailureCauseType() {
            return this.failureCauseType;
        }

        public int hashCode() {
            return this.failureCauseType.hashCode();
        }

        public String toString() {
            return "DocumentResourceConfigFailureType(failureCauseType=" + this.failureCauseType + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.failureCauseType, flags);
        }
    }

    @Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType$DocumentScanConfigFailureType;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentFeatureFailureType;", "failureCauseType", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;)V", "getFailureCauseType", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailureType;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentScanConfigFailureType extends DocumentFeatureFailureType {
        public static final Parcelable.Creator<DocumentScanConfigFailureType> CREATOR = new Creator();
        private final YdsFailureType failureCauseType;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<DocumentScanConfigFailureType> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentScanConfigFailureType createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DocumentScanConfigFailureType((YdsFailureType) parcel.readParcelable(DocumentScanConfigFailureType.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentScanConfigFailureType[] newArray(int i) {
                return new DocumentScanConfigFailureType[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DocumentScanConfigFailureType(YdsFailureType failureCauseType) {
            super(failureCauseType.getF7488a(), failureCauseType.getF7489b(), failureCauseType.getF7490c(), null);
            Intrinsics.checkNotNullParameter(failureCauseType, "failureCauseType");
            this.failureCauseType = failureCauseType;
        }

        public static /* synthetic */ DocumentScanConfigFailureType copy$default(DocumentScanConfigFailureType documentScanConfigFailureType, YdsFailureType ydsFailureType, int i, Object obj) {
            if ((i & 1) != 0) {
                ydsFailureType = documentScanConfigFailureType.failureCauseType;
            }
            return documentScanConfigFailureType.copy(ydsFailureType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final YdsFailureType getFailureCauseType() {
            return this.failureCauseType;
        }

        public final DocumentScanConfigFailureType copy(YdsFailureType failureCauseType) {
            Intrinsics.checkNotNullParameter(failureCauseType, "failureCauseType");
            return new DocumentScanConfigFailureType(failureCauseType);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DocumentScanConfigFailureType) && Intrinsics.areEqual(this.failureCauseType, ((DocumentScanConfigFailureType) other).failureCauseType);
        }

        public final YdsFailureType getFailureCauseType() {
            return this.failureCauseType;
        }

        public int hashCode() {
            return this.failureCauseType.hashCode();
        }

        public String toString() {
            return "DocumentScanConfigFailureType(failureCauseType=" + this.failureCauseType + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.failureCauseType, flags);
        }
    }

    private DocumentFeatureFailureType(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public /* synthetic */ DocumentFeatureFailureType(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }
}
