package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IScanConfigurationContainer;", "Landroid/os/Parcelable;", "()V", "CaptureCompleted", "Error", "PageApproved", "PageRejected", "ReviewScreen", "ScanFront", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$ScanFront;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$ReviewScreen;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$PageApproved;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$PageRejected;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$CaptureCompleted;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$Error;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class ScanState implements IScanConfigurationContainer, Parcelable {

    @Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$CaptureCompleted;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "data", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;)V", "getData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CaptureCompleted extends ScanState {
        public static final Parcelable.Creator<CaptureCompleted> CREATOR = new Creator();
        private final DocumentScanResultViewData data;
        private final IdScanConfigurationViewData scanConfiguration;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<CaptureCompleted> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CaptureCompleted createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CaptureCompleted(IdScanConfigurationViewData.CREATOR.createFromParcel(parcel), DocumentScanResultViewData.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CaptureCompleted[] newArray(int i) {
                return new CaptureCompleted[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptureCompleted(IdScanConfigurationViewData scanConfiguration, DocumentScanResultViewData data) {
            super(null);
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Intrinsics.checkNotNullParameter(data, "data");
            this.scanConfiguration = scanConfiguration;
            this.data = data;
        }

        public static /* synthetic */ CaptureCompleted copy$default(CaptureCompleted captureCompleted, IdScanConfigurationViewData idScanConfigurationViewData, DocumentScanResultViewData documentScanResultViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                idScanConfigurationViewData = captureCompleted.getScanConfiguration();
            }
            if ((i & 2) != 0) {
                documentScanResultViewData = captureCompleted.data;
            }
            return captureCompleted.copy(idScanConfigurationViewData, documentScanResultViewData);
        }

        public final IdScanConfigurationViewData component1() {
            return getScanConfiguration();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DocumentScanResultViewData getData() {
            return this.data;
        }

        public final CaptureCompleted copy(IdScanConfigurationViewData scanConfiguration, DocumentScanResultViewData data) {
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Intrinsics.checkNotNullParameter(data, "data");
            return new CaptureCompleted(scanConfiguration, data);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CaptureCompleted)) {
                return false;
            }
            CaptureCompleted captureCompleted = (CaptureCompleted) other;
            return Intrinsics.areEqual(getScanConfiguration(), captureCompleted.getScanConfiguration()) && Intrinsics.areEqual(this.data, captureCompleted.data);
        }

        public final DocumentScanResultViewData getData() {
            return this.data;
        }

        @Override // com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanConfigurationContainer
        public IdScanConfigurationViewData getScanConfiguration() {
            return this.scanConfiguration;
        }

        public int hashCode() {
            return (getScanConfiguration().hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "CaptureCompleted(scanConfiguration=" + getScanConfiguration() + ", data=" + this.data + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.scanConfiguration.writeToParcel(parcel, flags);
            this.data.writeToParcel(parcel, flags);
        }
    }

    @Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$Error;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "error", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getError", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Error extends ScanState {
        public static final Parcelable.Creator<Error> CREATOR = new Creator();
        private final YdsFailure error;
        private final IdScanConfigurationViewData scanConfiguration;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<Error> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Error createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Error(IdScanConfigurationViewData.CREATOR.createFromParcel(parcel), (YdsFailure) parcel.readParcelable(Error.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Error[] newArray(int i) {
                return new Error[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(IdScanConfigurationViewData scanConfiguration, YdsFailure error) {
            super(null);
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Intrinsics.checkNotNullParameter(error, "error");
            this.scanConfiguration = scanConfiguration;
            this.error = error;
        }

        public static /* synthetic */ Error copy$default(Error error, IdScanConfigurationViewData idScanConfigurationViewData, YdsFailure ydsFailure, int i, Object obj) {
            if ((i & 1) != 0) {
                idScanConfigurationViewData = error.getScanConfiguration();
            }
            if ((i & 2) != 0) {
                ydsFailure = error.error;
            }
            return error.copy(idScanConfigurationViewData, ydsFailure);
        }

        public final IdScanConfigurationViewData component1() {
            return getScanConfiguration();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final YdsFailure getError() {
            return this.error;
        }

        public final Error copy(IdScanConfigurationViewData scanConfiguration, YdsFailure error) {
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(scanConfiguration, error);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(getScanConfiguration(), error.getScanConfiguration()) && Intrinsics.areEqual(this.error, error.error);
        }

        public final YdsFailure getError() {
            return this.error;
        }

        @Override // com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanConfigurationContainer
        public IdScanConfigurationViewData getScanConfiguration() {
            return this.scanConfiguration;
        }

        public int hashCode() {
            return (getScanConfiguration().hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            return "Error(scanConfiguration=" + getScanConfiguration() + ", error=" + this.error + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.scanConfiguration.writeToParcel(parcel, flags);
            parcel.writeParcelable(this.error, flags);
        }
    }

    @Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$PageApproved;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;)V", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class PageApproved extends ScanState {
        public static final Parcelable.Creator<PageApproved> CREATOR = new Creator();
        private final IdScanConfigurationViewData scanConfiguration;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<PageApproved> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PageApproved createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PageApproved(IdScanConfigurationViewData.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PageApproved[] newArray(int i) {
                return new PageApproved[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageApproved(IdScanConfigurationViewData scanConfiguration) {
            super(null);
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            this.scanConfiguration = scanConfiguration;
        }

        public static /* synthetic */ PageApproved copy$default(PageApproved pageApproved, IdScanConfigurationViewData idScanConfigurationViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                idScanConfigurationViewData = pageApproved.getScanConfiguration();
            }
            return pageApproved.copy(idScanConfigurationViewData);
        }

        public final IdScanConfigurationViewData component1() {
            return getScanConfiguration();
        }

        public final PageApproved copy(IdScanConfigurationViewData scanConfiguration) {
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            return new PageApproved(scanConfiguration);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PageApproved) && Intrinsics.areEqual(getScanConfiguration(), ((PageApproved) other).getScanConfiguration());
        }

        @Override // com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanConfigurationContainer
        public IdScanConfigurationViewData getScanConfiguration() {
            return this.scanConfiguration;
        }

        public int hashCode() {
            return getScanConfiguration().hashCode();
        }

        public String toString() {
            return "PageApproved(scanConfiguration=" + getScanConfiguration() + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.scanConfiguration.writeToParcel(parcel, flags);
        }
    }

    @Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$PageRejected;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;)V", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class PageRejected extends ScanState {
        public static final Parcelable.Creator<PageRejected> CREATOR = new Creator();
        private final IdScanConfigurationViewData scanConfiguration;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<PageRejected> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PageRejected createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PageRejected(IdScanConfigurationViewData.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PageRejected[] newArray(int i) {
                return new PageRejected[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageRejected(IdScanConfigurationViewData scanConfiguration) {
            super(null);
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            this.scanConfiguration = scanConfiguration;
        }

        public static /* synthetic */ PageRejected copy$default(PageRejected pageRejected, IdScanConfigurationViewData idScanConfigurationViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                idScanConfigurationViewData = pageRejected.getScanConfiguration();
            }
            return pageRejected.copy(idScanConfigurationViewData);
        }

        public final IdScanConfigurationViewData component1() {
            return getScanConfiguration();
        }

        public final PageRejected copy(IdScanConfigurationViewData scanConfiguration) {
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            return new PageRejected(scanConfiguration);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PageRejected) && Intrinsics.areEqual(getScanConfiguration(), ((PageRejected) other).getScanConfiguration());
        }

        @Override // com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanConfigurationContainer
        public IdScanConfigurationViewData getScanConfiguration() {
            return this.scanConfiguration;
        }

        public int hashCode() {
            return getScanConfiguration().hashCode();
        }

        public String toString() {
            return "PageRejected(scanConfiguration=" + getScanConfiguration() + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.scanConfiguration.writeToParcel(parcel, flags);
        }
    }

    @Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$ReviewScreen;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "data", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;)V", "getData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class ReviewScreen extends ScanState {
        public static final Parcelable.Creator<ReviewScreen> CREATOR = new Creator();
        private final PageScanReviewViewData data;
        private final IdScanConfigurationViewData scanConfiguration;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<ReviewScreen> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ReviewScreen createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ReviewScreen(IdScanConfigurationViewData.CREATOR.createFromParcel(parcel), PageScanReviewViewData.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ReviewScreen[] newArray(int i) {
                return new ReviewScreen[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReviewScreen(IdScanConfigurationViewData scanConfiguration, PageScanReviewViewData data) {
            super(null);
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Intrinsics.checkNotNullParameter(data, "data");
            this.scanConfiguration = scanConfiguration;
            this.data = data;
        }

        public static /* synthetic */ ReviewScreen copy$default(ReviewScreen reviewScreen, IdScanConfigurationViewData idScanConfigurationViewData, PageScanReviewViewData pageScanReviewViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                idScanConfigurationViewData = reviewScreen.getScanConfiguration();
            }
            if ((i & 2) != 0) {
                pageScanReviewViewData = reviewScreen.data;
            }
            return reviewScreen.copy(idScanConfigurationViewData, pageScanReviewViewData);
        }

        public final IdScanConfigurationViewData component1() {
            return getScanConfiguration();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PageScanReviewViewData getData() {
            return this.data;
        }

        public final ReviewScreen copy(IdScanConfigurationViewData scanConfiguration, PageScanReviewViewData data) {
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            Intrinsics.checkNotNullParameter(data, "data");
            return new ReviewScreen(scanConfiguration, data);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReviewScreen)) {
                return false;
            }
            ReviewScreen reviewScreen = (ReviewScreen) other;
            return Intrinsics.areEqual(getScanConfiguration(), reviewScreen.getScanConfiguration()) && Intrinsics.areEqual(this.data, reviewScreen.data);
        }

        public final PageScanReviewViewData getData() {
            return this.data;
        }

        @Override // com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanConfigurationContainer
        public IdScanConfigurationViewData getScanConfiguration() {
            return this.scanConfiguration;
        }

        public int hashCode() {
            return (getScanConfiguration().hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "ReviewScreen(scanConfiguration=" + getScanConfiguration() + ", data=" + this.data + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.scanConfiguration.writeToParcel(parcel, flags);
            this.data.writeToParcel(parcel, flags);
        }
    }

    @Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState$ScanFront;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;)V", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class ScanFront extends ScanState {
        public static final Parcelable.Creator<ScanFront> CREATOR = new Creator();
        private final IdScanConfigurationViewData scanConfiguration;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<ScanFront> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ScanFront createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ScanFront(IdScanConfigurationViewData.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ScanFront[] newArray(int i) {
                return new ScanFront[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScanFront(IdScanConfigurationViewData scanConfiguration) {
            super(null);
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            this.scanConfiguration = scanConfiguration;
        }

        public static /* synthetic */ ScanFront copy$default(ScanFront scanFront, IdScanConfigurationViewData idScanConfigurationViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                idScanConfigurationViewData = scanFront.getScanConfiguration();
            }
            return scanFront.copy(idScanConfigurationViewData);
        }

        public final IdScanConfigurationViewData component1() {
            return getScanConfiguration();
        }

        public final ScanFront copy(IdScanConfigurationViewData scanConfiguration) {
            Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
            return new ScanFront(scanConfiguration);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ScanFront) && Intrinsics.areEqual(getScanConfiguration(), ((ScanFront) other).getScanConfiguration());
        }

        @Override // com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanConfigurationContainer
        public IdScanConfigurationViewData getScanConfiguration() {
            return this.scanConfiguration;
        }

        public int hashCode() {
            return getScanConfiguration().hashCode();
        }

        public String toString() {
            return "ScanFront(scanConfiguration=" + getScanConfiguration() + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.scanConfiguration.writeToParcel(parcel, flags);
        }
    }

    private ScanState() {
    }

    public /* synthetic */ ScanState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
