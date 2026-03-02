package com.yoti.mobile.android.liveness.zoom.domain.model;

import com.facetec.sdk.FaceTecSDKStatus;
import com.facetec.sdk.FaceTecSessionStatus;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsFeatureError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError;", "Lcom/yoti/mobile/android/yotidocs/common/error/YotiDocsFeatureError;", "throwable", "", "isRetryAllowed", "", "(Ljava/lang/Throwable;Z)V", "LivenessFaceTecCaptureError", "LivenessFaceTecInitialisationError", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError$LivenessFaceTecCaptureError;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError$LivenessFaceTecInitialisationError;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class LivenessFaceTecError extends YotiDocsFeatureError {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError$LivenessFaceTecCaptureError;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError;", "faceTecSessionStatus", "Lcom/facetec/sdk/FaceTecSessionStatus;", "(Lcom/facetec/sdk/FaceTecSessionStatus;)V", "getFaceTecSessionStatus", "()Lcom/facetec/sdk/FaceTecSessionStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class LivenessFaceTecCaptureError extends LivenessFaceTecError {
        private final FaceTecSessionStatus faceTecSessionStatus;

        /* JADX WARN: Multi-variable type inference failed */
        public LivenessFaceTecCaptureError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public LivenessFaceTecCaptureError(FaceTecSessionStatus faceTecSessionStatus) {
            super(new Throwable("LivenessFaceTecCaptureError: " + (faceTecSessionStatus != null ? faceTecSessionStatus.name() : null)), LivenessFaceTecErrorKt.isRetryAllowed(faceTecSessionStatus), null);
            this.faceTecSessionStatus = faceTecSessionStatus;
        }

        public /* synthetic */ LivenessFaceTecCaptureError(FaceTecSessionStatus faceTecSessionStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : faceTecSessionStatus);
        }

        public static /* synthetic */ LivenessFaceTecCaptureError copy$default(LivenessFaceTecCaptureError livenessFaceTecCaptureError, FaceTecSessionStatus faceTecSessionStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                faceTecSessionStatus = livenessFaceTecCaptureError.faceTecSessionStatus;
            }
            return livenessFaceTecCaptureError.copy(faceTecSessionStatus);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FaceTecSessionStatus getFaceTecSessionStatus() {
            return this.faceTecSessionStatus;
        }

        public final LivenessFaceTecCaptureError copy(FaceTecSessionStatus faceTecSessionStatus) {
            return new LivenessFaceTecCaptureError(faceTecSessionStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LivenessFaceTecCaptureError) && this.faceTecSessionStatus == ((LivenessFaceTecCaptureError) other).faceTecSessionStatus;
        }

        public final FaceTecSessionStatus getFaceTecSessionStatus() {
            return this.faceTecSessionStatus;
        }

        public int hashCode() {
            FaceTecSessionStatus faceTecSessionStatus = this.faceTecSessionStatus;
            if (faceTecSessionStatus == null) {
                return 0;
            }
            return faceTecSessionStatus.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "LivenessFaceTecCaptureError(faceTecSessionStatus=" + this.faceTecSessionStatus + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError$LivenessFaceTecInitialisationError;", "Lcom/yoti/mobile/android/liveness/zoom/domain/model/LivenessFaceTecError;", "faceTecSDKStatus", "Lcom/facetec/sdk/FaceTecSDKStatus;", "(Lcom/facetec/sdk/FaceTecSDKStatus;)V", "getFaceTecSDKStatus", "()Lcom/facetec/sdk/FaceTecSDKStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class LivenessFaceTecInitialisationError extends LivenessFaceTecError {
        private final FaceTecSDKStatus faceTecSDKStatus;

        /* JADX WARN: Multi-variable type inference failed */
        public LivenessFaceTecInitialisationError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public LivenessFaceTecInitialisationError(FaceTecSDKStatus faceTecSDKStatus) {
            super(new Throwable("LivenessFaceTecInitialisationError: " + (faceTecSDKStatus != null ? faceTecSDKStatus.name() : null)), LivenessFaceTecErrorKt.isRetryAllowed(faceTecSDKStatus), null);
            this.faceTecSDKStatus = faceTecSDKStatus;
        }

        public /* synthetic */ LivenessFaceTecInitialisationError(FaceTecSDKStatus faceTecSDKStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : faceTecSDKStatus);
        }

        public static /* synthetic */ LivenessFaceTecInitialisationError copy$default(LivenessFaceTecInitialisationError livenessFaceTecInitialisationError, FaceTecSDKStatus faceTecSDKStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                faceTecSDKStatus = livenessFaceTecInitialisationError.faceTecSDKStatus;
            }
            return livenessFaceTecInitialisationError.copy(faceTecSDKStatus);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FaceTecSDKStatus getFaceTecSDKStatus() {
            return this.faceTecSDKStatus;
        }

        public final LivenessFaceTecInitialisationError copy(FaceTecSDKStatus faceTecSDKStatus) {
            return new LivenessFaceTecInitialisationError(faceTecSDKStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LivenessFaceTecInitialisationError) && this.faceTecSDKStatus == ((LivenessFaceTecInitialisationError) other).faceTecSDKStatus;
        }

        public final FaceTecSDKStatus getFaceTecSDKStatus() {
            return this.faceTecSDKStatus;
        }

        public int hashCode() {
            FaceTecSDKStatus faceTecSDKStatus = this.faceTecSDKStatus;
            if (faceTecSDKStatus == null) {
                return 0;
            }
            return faceTecSDKStatus.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "LivenessFaceTecInitialisationError(faceTecSDKStatus=" + this.faceTecSDKStatus + ')';
        }
    }

    private LivenessFaceTecError(Throwable th, boolean z) {
        super(th, z);
    }

    public /* synthetic */ LivenessFaceTecError(Throwable th, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? false : z, null);
    }

    public /* synthetic */ LivenessFaceTecError(Throwable th, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, z);
    }
}
