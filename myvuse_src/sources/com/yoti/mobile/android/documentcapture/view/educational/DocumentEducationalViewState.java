package com.yoti.mobile.android.documentcapture.view.educational;

import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState;", "", "()V", "Error", "Loading", "Success", "VisibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$Loading;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$Success;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$Error;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentEducationalViewState {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$Error;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Error extends DocumentEducationalViewState {
        private final YdsFailure failure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(YdsFailure failure) {
            super(null);
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.failure = failure;
        }

        public static /* synthetic */ Error copy$default(Error error, YdsFailure ydsFailure, int i, Object obj) {
            if ((i & 1) != 0) {
                ydsFailure = error.failure;
            }
            return error.copy(ydsFailure);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final YdsFailure getFailure() {
            return this.failure;
        }

        public final Error copy(YdsFailure failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new Error(failure);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.failure, ((Error) other).failure);
        }

        public final YdsFailure getFailure() {
            return this.failure;
        }

        public int hashCode() {
            return this.failure.hashCode();
        }

        public String toString() {
            return "Error(failure=" + this.failure + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$Loading;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState;", "visibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;", "(Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;)V", "getVisibilityToggles", "()Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Loading extends DocumentEducationalViewState {
        private final VisibilityToggles visibilityToggles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loading(VisibilityToggles visibilityToggles) {
            super(null);
            Intrinsics.checkNotNullParameter(visibilityToggles, "visibilityToggles");
            this.visibilityToggles = visibilityToggles;
        }

        public static /* synthetic */ Loading copy$default(Loading loading, VisibilityToggles visibilityToggles, int i, Object obj) {
            if ((i & 1) != 0) {
                visibilityToggles = loading.visibilityToggles;
            }
            return loading.copy(visibilityToggles);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VisibilityToggles getVisibilityToggles() {
            return this.visibilityToggles;
        }

        public final Loading copy(VisibilityToggles visibilityToggles) {
            Intrinsics.checkNotNullParameter(visibilityToggles, "visibilityToggles");
            return new Loading(visibilityToggles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Loading) && Intrinsics.areEqual(this.visibilityToggles, ((Loading) other).visibilityToggles);
        }

        public final VisibilityToggles getVisibilityToggles() {
            return this.visibilityToggles;
        }

        public int hashCode() {
            return this.visibilityToggles.hashCode();
        }

        public String toString() {
            return "Loading(visibilityToggles=" + this.visibilityToggles + ')';
        }
    }

    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$Success;", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState;", "viewData", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;", "visibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;", "(Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;)V", "getViewData", "()Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewData;", "getVisibilityToggles", "()Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Success extends DocumentEducationalViewState {
        private final DocumentEducationalViewData viewData;
        private final VisibilityToggles visibilityToggles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(DocumentEducationalViewData viewData, VisibilityToggles visibilityToggles) {
            super(null);
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            Intrinsics.checkNotNullParameter(visibilityToggles, "visibilityToggles");
            this.viewData = viewData;
            this.visibilityToggles = visibilityToggles;
        }

        public static /* synthetic */ Success copy$default(Success success, DocumentEducationalViewData documentEducationalViewData, VisibilityToggles visibilityToggles, int i, Object obj) {
            if ((i & 1) != 0) {
                documentEducationalViewData = success.viewData;
            }
            if ((i & 2) != 0) {
                visibilityToggles = success.visibilityToggles;
            }
            return success.copy(documentEducationalViewData, visibilityToggles);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentEducationalViewData getViewData() {
            return this.viewData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final VisibilityToggles getVisibilityToggles() {
            return this.visibilityToggles;
        }

        public final Success copy(DocumentEducationalViewData viewData, VisibilityToggles visibilityToggles) {
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            Intrinsics.checkNotNullParameter(visibilityToggles, "visibilityToggles");
            return new Success(viewData, visibilityToggles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.viewData, success.viewData) && Intrinsics.areEqual(this.visibilityToggles, success.visibilityToggles);
        }

        public final DocumentEducationalViewData getViewData() {
            return this.viewData;
        }

        public final VisibilityToggles getVisibilityToggles() {
            return this.visibilityToggles;
        }

        public int hashCode() {
            return (this.viewData.hashCode() * 31) + this.visibilityToggles.hashCode();
        }

        public String toString() {
            return "Success(viewData=" + this.viewData + ", visibilityToggles=" + this.visibilityToggles + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalViewState$VisibilityToggles;", "", "showIdentityCheck", "", "showMoreAboutVerification", "showDoNotHaveDocuments", "(ZZZ)V", "getShowDoNotHaveDocuments", "()Z", "getShowIdentityCheck", "getShowMoreAboutVerification", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class VisibilityToggles {
        private final boolean showDoNotHaveDocuments;
        private final boolean showIdentityCheck;
        private final boolean showMoreAboutVerification;

        public VisibilityToggles(boolean z, boolean z2, boolean z3) {
            this.showIdentityCheck = z;
            this.showMoreAboutVerification = z2;
            this.showDoNotHaveDocuments = z3;
        }

        public static /* synthetic */ VisibilityToggles copy$default(VisibilityToggles visibilityToggles, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = visibilityToggles.showIdentityCheck;
            }
            if ((i & 2) != 0) {
                z2 = visibilityToggles.showMoreAboutVerification;
            }
            if ((i & 4) != 0) {
                z3 = visibilityToggles.showDoNotHaveDocuments;
            }
            return visibilityToggles.copy(z, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowIdentityCheck() {
            return this.showIdentityCheck;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowMoreAboutVerification() {
            return this.showMoreAboutVerification;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShowDoNotHaveDocuments() {
            return this.showDoNotHaveDocuments;
        }

        public final VisibilityToggles copy(boolean showIdentityCheck, boolean showMoreAboutVerification, boolean showDoNotHaveDocuments) {
            return new VisibilityToggles(showIdentityCheck, showMoreAboutVerification, showDoNotHaveDocuments);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VisibilityToggles)) {
                return false;
            }
            VisibilityToggles visibilityToggles = (VisibilityToggles) other;
            return this.showIdentityCheck == visibilityToggles.showIdentityCheck && this.showMoreAboutVerification == visibilityToggles.showMoreAboutVerification && this.showDoNotHaveDocuments == visibilityToggles.showDoNotHaveDocuments;
        }

        public final boolean getShowDoNotHaveDocuments() {
            return this.showDoNotHaveDocuments;
        }

        public final boolean getShowIdentityCheck() {
            return this.showIdentityCheck;
        }

        public final boolean getShowMoreAboutVerification() {
            return this.showMoreAboutVerification;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            boolean z = this.showIdentityCheck;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z2 = this.showMoreAboutVerification;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z3 = this.showDoNotHaveDocuments;
            return i2 + (z3 ? 1 : z3);
        }

        public String toString() {
            return "VisibilityToggles(showIdentityCheck=" + this.showIdentityCheck + ", showMoreAboutVerification=" + this.showMoreAboutVerification + ", showDoNotHaveDocuments=" + this.showDoNotHaveDocuments + ')';
        }
    }

    private DocumentEducationalViewState() {
    }

    public /* synthetic */ DocumentEducationalViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
