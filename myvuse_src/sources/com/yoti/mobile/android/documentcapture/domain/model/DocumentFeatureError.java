package com.yoti.mobile.android.documentcapture.domain.model;

import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsFeatureError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u001d\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsFeatureError;", "error", "", "isRetryAllowed", "", "(Ljava/lang/Throwable;Z)V", "DocumentCountryNotListedError", "DocumentNotOwnedError", "DocumentResourceConfigError", "DocumentScanConfigError", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError$DocumentResourceConfigError;", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError$DocumentScanConfigError;", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError$DocumentNotOwnedError;", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError$DocumentCountryNotListedError;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentFeatureError extends YotiDocsFeatureError {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError$DocumentCountryNotListedError;", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DocumentCountryNotListedError extends DocumentFeatureError {
        public static final DocumentCountryNotListedError INSTANCE = new DocumentCountryNotListedError();

        /* JADX WARN: Multi-variable type inference failed */
        private DocumentCountryNotListedError() {
            super(null, false, 3, 0 == true ? 1 : 0);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError$DocumentNotOwnedError;", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DocumentNotOwnedError extends DocumentFeatureError {
        public static final DocumentNotOwnedError INSTANCE = new DocumentNotOwnedError();

        /* JADX WARN: Multi-variable type inference failed */
        private DocumentNotOwnedError() {
            super(null, false, 3, 0 == true ? 1 : 0);
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError$DocumentResourceConfigError;", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError;", "errorCause", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;)V", "getErrorCause", "()Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentResourceConfigError extends DocumentFeatureError {
        private final YotiDocsError errorCause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DocumentResourceConfigError(YotiDocsError errorCause) {
            super(errorCause, errorCause.getF7491a(), null);
            Intrinsics.checkNotNullParameter(errorCause, "errorCause");
            this.errorCause = errorCause;
        }

        public static /* synthetic */ DocumentResourceConfigError copy$default(DocumentResourceConfigError documentResourceConfigError, YotiDocsError yotiDocsError, int i, Object obj) {
            if ((i & 1) != 0) {
                yotiDocsError = documentResourceConfigError.errorCause;
            }
            return documentResourceConfigError.copy(yotiDocsError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final YotiDocsError getErrorCause() {
            return this.errorCause;
        }

        public final DocumentResourceConfigError copy(YotiDocsError errorCause) {
            Intrinsics.checkNotNullParameter(errorCause, "errorCause");
            return new DocumentResourceConfigError(errorCause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DocumentResourceConfigError) && Intrinsics.areEqual(this.errorCause, ((DocumentResourceConfigError) other).errorCause);
        }

        public final YotiDocsError getErrorCause() {
            return this.errorCause;
        }

        public int hashCode() {
            return this.errorCause.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "DocumentResourceConfigError(errorCause=" + this.errorCause + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError$DocumentScanConfigError;", "Lcom/yoti/mobile/android/documentcapture/domain/model/DocumentFeatureError;", "errorCause", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;)V", "getErrorCause", "()Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentScanConfigError extends DocumentFeatureError {
        private final YotiDocsError errorCause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DocumentScanConfigError(YotiDocsError errorCause) {
            super(errorCause, errorCause.getF7491a(), null);
            Intrinsics.checkNotNullParameter(errorCause, "errorCause");
            this.errorCause = errorCause;
        }

        public static /* synthetic */ DocumentScanConfigError copy$default(DocumentScanConfigError documentScanConfigError, YotiDocsError yotiDocsError, int i, Object obj) {
            if ((i & 1) != 0) {
                yotiDocsError = documentScanConfigError.errorCause;
            }
            return documentScanConfigError.copy(yotiDocsError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final YotiDocsError getErrorCause() {
            return this.errorCause;
        }

        public final DocumentScanConfigError copy(YotiDocsError errorCause) {
            Intrinsics.checkNotNullParameter(errorCause, "errorCause");
            return new DocumentScanConfigError(errorCause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DocumentScanConfigError) && Intrinsics.areEqual(this.errorCause, ((DocumentScanConfigError) other).errorCause);
        }

        public final YotiDocsError getErrorCause() {
            return this.errorCause;
        }

        public int hashCode() {
            return this.errorCause.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "DocumentScanConfigError(errorCause=" + this.errorCause + ')';
        }
    }

    public /* synthetic */ DocumentFeatureError(Throwable th, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th, (i & 2) != 0 ? false : z, null);
    }

    public /* synthetic */ DocumentFeatureError(Throwable th, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, z);
    }

    private DocumentFeatureError(Throwable th, boolean z) {
        super(th, z);
    }
}
