package com.yoti.mobile.android.documentcapture.view;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\r\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\r\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "", "()V", "AbstractDocumentViewEvent", "CameraPermissionGranted", "CameraPermissionsDenied", "CancelDoNotHaveDocument", "CancelGetDocumentResourceConfig", "CancelGetScanConfiguration", "ConfirmDoNotHaveDocument", "DoNotHaveDocument", "MoreAboutVerification", "RetryGetDocumentResourceConfig", "RetryGetScanConfiguration", "StartScan", "ViewCreated", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$ViewCreated;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$StartScan;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CameraPermissionGranted;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CameraPermissionsDenied;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$MoreAboutVerification;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$DoNotHaveDocument;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$ConfirmDoNotHaveDocument;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CancelDoNotHaveDocument;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$RetryGetDocumentResourceConfig;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CancelGetDocumentResourceConfig;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$RetryGetScanConfiguration;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CancelGetScanConfiguration;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$AbstractDocumentViewEvent;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentViewEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$AbstractDocumentViewEvent;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class AbstractDocumentViewEvent extends DocumentViewEvent {
        public AbstractDocumentViewEvent() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CameraPermissionGranted;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CameraPermissionGranted extends DocumentViewEvent {
        public static final CameraPermissionGranted INSTANCE = new CameraPermissionGranted();

        private CameraPermissionGranted() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CameraPermissionsDenied;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "shouldShowRationale", "", "(Z)V", "getShouldShowRationale", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CameraPermissionsDenied extends DocumentViewEvent {
        private final boolean shouldShowRationale;

        public CameraPermissionsDenied(boolean z) {
            super(null);
            this.shouldShowRationale = z;
        }

        public static /* synthetic */ CameraPermissionsDenied copy$default(CameraPermissionsDenied cameraPermissionsDenied, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = cameraPermissionsDenied.shouldShowRationale;
            }
            return cameraPermissionsDenied.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShouldShowRationale() {
            return this.shouldShowRationale;
        }

        public final CameraPermissionsDenied copy(boolean shouldShowRationale) {
            return new CameraPermissionsDenied(shouldShowRationale);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CameraPermissionsDenied) && this.shouldShowRationale == ((CameraPermissionsDenied) other).shouldShowRationale;
        }

        public final boolean getShouldShowRationale() {
            return this.shouldShowRationale;
        }

        public int hashCode() {
            boolean z = this.shouldShowRationale;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "CameraPermissionsDenied(shouldShowRationale=" + this.shouldShowRationale + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CancelDoNotHaveDocument;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CancelDoNotHaveDocument extends DocumentViewEvent {
        public static final CancelDoNotHaveDocument INSTANCE = new CancelDoNotHaveDocument();

        private CancelDoNotHaveDocument() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CancelGetDocumentResourceConfig;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CancelGetDocumentResourceConfig extends DocumentViewEvent {
        public static final CancelGetDocumentResourceConfig INSTANCE = new CancelGetDocumentResourceConfig();

        private CancelGetDocumentResourceConfig() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$CancelGetScanConfiguration;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CancelGetScanConfiguration extends DocumentViewEvent {
        public static final CancelGetScanConfiguration INSTANCE = new CancelGetScanConfiguration();

        private CancelGetScanConfiguration() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$ConfirmDoNotHaveDocument;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ConfirmDoNotHaveDocument extends DocumentViewEvent {
        public static final ConfirmDoNotHaveDocument INSTANCE = new ConfirmDoNotHaveDocument();

        private ConfirmDoNotHaveDocument() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$DoNotHaveDocument;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DoNotHaveDocument extends DocumentViewEvent {
        public static final DoNotHaveDocument INSTANCE = new DoNotHaveDocument();

        private DoNotHaveDocument() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$MoreAboutVerification;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MoreAboutVerification extends DocumentViewEvent {
        public static final MoreAboutVerification INSTANCE = new MoreAboutVerification();

        private MoreAboutVerification() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$RetryGetDocumentResourceConfig;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class RetryGetDocumentResourceConfig extends DocumentViewEvent {
        public static final RetryGetDocumentResourceConfig INSTANCE = new RetryGetDocumentResourceConfig();

        private RetryGetDocumentResourceConfig() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$RetryGetScanConfiguration;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "isCameraPermissionNeeded", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class RetryGetScanConfiguration extends DocumentViewEvent {
        private final boolean isCameraPermissionNeeded;

        public RetryGetScanConfiguration(boolean z) {
            super(null);
            this.isCameraPermissionNeeded = z;
        }

        public static /* synthetic */ RetryGetScanConfiguration copy$default(RetryGetScanConfiguration retryGetScanConfiguration, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = retryGetScanConfiguration.isCameraPermissionNeeded;
            }
            return retryGetScanConfiguration.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsCameraPermissionNeeded() {
            return this.isCameraPermissionNeeded;
        }

        public final RetryGetScanConfiguration copy(boolean isCameraPermissionNeeded) {
            return new RetryGetScanConfiguration(isCameraPermissionNeeded);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RetryGetScanConfiguration) && this.isCameraPermissionNeeded == ((RetryGetScanConfiguration) other).isCameraPermissionNeeded;
        }

        public int hashCode() {
            boolean z = this.isCameraPermissionNeeded;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isCameraPermissionNeeded() {
            return this.isCameraPermissionNeeded;
        }

        public String toString() {
            return "RetryGetScanConfiguration(isCameraPermissionNeeded=" + this.isCameraPermissionNeeded + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$StartScan;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "isCameraPermissionNeeded", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class StartScan extends DocumentViewEvent {
        private final boolean isCameraPermissionNeeded;

        public StartScan(boolean z) {
            super(null);
            this.isCameraPermissionNeeded = z;
        }

        public static /* synthetic */ StartScan copy$default(StartScan startScan, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = startScan.isCameraPermissionNeeded;
            }
            return startScan.copy(z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsCameraPermissionNeeded() {
            return this.isCameraPermissionNeeded;
        }

        public final StartScan copy(boolean isCameraPermissionNeeded) {
            return new StartScan(isCameraPermissionNeeded);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StartScan) && this.isCameraPermissionNeeded == ((StartScan) other).isCameraPermissionNeeded;
        }

        public int hashCode() {
            boolean z = this.isCameraPermissionNeeded;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isCameraPermissionNeeded() {
            return this.isCameraPermissionNeeded;
        }

        public String toString() {
            return "StartScan(isCameraPermissionNeeded=" + this.isCameraPermissionNeeded + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent$ViewCreated;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class ViewCreated extends DocumentViewEvent {
        public static final ViewCreated INSTANCE = new ViewCreated();

        private ViewCreated() {
            super(null);
        }
    }

    private DocumentViewEvent() {
    }

    public /* synthetic */ DocumentViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
