package com.yoti.mobile.android.documentcapture.p055id.domain.model;

import com.yoti.mobile.android.yotidocs.common.error.YotiDocsFeatureError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsFeatureError;", "throwable", "", "isRetryAllowed", "", "(Ljava/lang/Throwable;Z)V", "ScanResultConversionError", "UnexpectedScanError", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanError$ScanResultConversionError;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanError$UnexpectedScanError;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class IdDocumentScanError extends YotiDocsFeatureError {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanError$ScanResultConversionError;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanError;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class ScanResultConversionError extends IdDocumentScanError {
        private final Throwable throwable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScanResultConversionError(Throwable throwable) {
            super(throwable, false, null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.throwable = throwable;
        }

        public static /* synthetic */ ScanResultConversionError copy$default(ScanResultConversionError scanResultConversionError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = scanResultConversionError.throwable;
            }
            return scanResultConversionError.copy(th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final ScanResultConversionError copy(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return new ScanResultConversionError(throwable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ScanResultConversionError) && Intrinsics.areEqual(this.throwable, ((ScanResultConversionError) other).throwable);
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "ScanResultConversionError(throwable=" + this.throwable + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanError$UnexpectedScanError;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanError;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class UnexpectedScanError extends IdDocumentScanError {
        private final Throwable throwable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnexpectedScanError(Throwable throwable) {
            super(throwable, true, null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.throwable = throwable;
        }

        public static /* synthetic */ UnexpectedScanError copy$default(UnexpectedScanError unexpectedScanError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = unexpectedScanError.throwable;
            }
            return unexpectedScanError.copy(th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final UnexpectedScanError copy(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return new UnexpectedScanError(throwable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnexpectedScanError) && Intrinsics.areEqual(this.throwable, ((UnexpectedScanError) other).throwable);
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "UnexpectedScanError(throwable=" + this.throwable + ')';
        }
    }

    public /* synthetic */ IdDocumentScanError(Throwable th, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? false : z, null);
    }

    public /* synthetic */ IdDocumentScanError(Throwable th, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, z);
    }

    private IdDocumentScanError(Throwable th, boolean z) {
        super(th, z);
    }
}
