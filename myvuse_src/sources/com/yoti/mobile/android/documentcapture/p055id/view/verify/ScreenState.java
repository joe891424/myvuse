package com.yoti.mobile.android.documentcapture.p055id.view.verify;

import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;", "", "()V", "Cancel", "CaptureDocument", "CaptureNfc", "Upload", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState$Upload;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState$CaptureNfc;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState$Cancel;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState$CaptureDocument;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class ScreenState {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState$Cancel;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Cancel extends ScreenState {
        public static final Cancel INSTANCE = new Cancel();

        private Cancel() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState$CaptureDocument;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CaptureDocument extends ScreenState {
        public static final CaptureDocument INSTANCE = new CaptureDocument();

        private CaptureDocument() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState$CaptureNfc;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;", "bacCredential", "Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "(Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;)V", "getBacCredential", "()Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CaptureNfc extends ScreenState {
        private final BacCredential bacCredential;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptureNfc(BacCredential bacCredential) {
            super(null);
            Intrinsics.checkNotNullParameter(bacCredential, "bacCredential");
            this.bacCredential = bacCredential;
        }

        public static /* synthetic */ CaptureNfc copy$default(CaptureNfc captureNfc, BacCredential bacCredential, int i, Object obj) {
            if ((i & 1) != 0) {
                bacCredential = captureNfc.bacCredential;
            }
            return captureNfc.copy(bacCredential);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BacCredential getBacCredential() {
            return this.bacCredential;
        }

        public final CaptureNfc copy(BacCredential bacCredential) {
            Intrinsics.checkNotNullParameter(bacCredential, "bacCredential");
            return new CaptureNfc(bacCredential);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CaptureNfc) && Intrinsics.areEqual(this.bacCredential, ((CaptureNfc) other).bacCredential);
        }

        public final BacCredential getBacCredential() {
            return this.bacCredential;
        }

        public int hashCode() {
            return this.bacCredential.hashCode();
        }

        public String toString() {
            return "CaptureNfc(bacCredential=" + this.bacCredential + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState$Upload;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;", "documentScanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;)V", "getDocumentScanResultViewData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Upload extends ScreenState {
        private final DocumentScanResultViewData documentScanResultViewData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Upload(DocumentScanResultViewData documentScanResultViewData) {
            super(null);
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            this.documentScanResultViewData = documentScanResultViewData;
        }

        public static /* synthetic */ Upload copy$default(Upload upload, DocumentScanResultViewData documentScanResultViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                documentScanResultViewData = upload.documentScanResultViewData;
            }
            return upload.copy(documentScanResultViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentScanResultViewData getDocumentScanResultViewData() {
            return this.documentScanResultViewData;
        }

        public final Upload copy(DocumentScanResultViewData documentScanResultViewData) {
            Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
            return new Upload(documentScanResultViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Upload) && Intrinsics.areEqual(this.documentScanResultViewData, ((Upload) other).documentScanResultViewData);
        }

        public final DocumentScanResultViewData getDocumentScanResultViewData() {
            return this.documentScanResultViewData;
        }

        public int hashCode() {
            return this.documentScanResultViewData.hashCode();
        }

        public String toString() {
            return "Upload(documentScanResultViewData=" + this.documentScanResultViewData + ')';
        }
    }

    private ScreenState() {
    }

    public /* synthetic */ ScreenState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
