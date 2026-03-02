package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;", "", "()V", "Error", "Loading", "Success", "VisibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$Loading;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$Success;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$Error;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentSelectionViewState {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$Error;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Error extends DocumentSelectionViewState {
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

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$Loading;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "(Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;)V", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Loading extends DocumentSelectionViewState {
        private final NavigationIcon navigationIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Loading(NavigationIcon navigationIcon) {
            super(null);
            Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
            this.navigationIcon = navigationIcon;
        }

        public static /* synthetic */ Loading copy$default(Loading loading, NavigationIcon navigationIcon, int i, Object obj) {
            if ((i & 1) != 0) {
                navigationIcon = loading.navigationIcon;
            }
            return loading.copy(navigationIcon);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final NavigationIcon getNavigationIcon() {
            return this.navigationIcon;
        }

        public final Loading copy(NavigationIcon navigationIcon) {
            Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
            return new Loading(navigationIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Loading) && this.navigationIcon == ((Loading) other).navigationIcon;
        }

        public final NavigationIcon getNavigationIcon() {
            return this.navigationIcon;
        }

        public int hashCode() {
            return this.navigationIcon.hashCode();
        }

        public String toString() {
            return "Loading(navigationIcon=" + this.navigationIcon + ')';
        }
    }

    @Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$Success;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;", "viewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "visibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$VisibilityToggles;", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$VisibilityToggles;Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;)V", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "getViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "getVisibilityToggles", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$VisibilityToggles;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Success extends DocumentSelectionViewState {
        private final NavigationIcon navigationIcon;
        private final DocumentSelectionViewData viewData;
        private final VisibilityToggles visibilityToggles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(DocumentSelectionViewData viewData, VisibilityToggles visibilityToggles, NavigationIcon navigationIcon) {
            super(null);
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            Intrinsics.checkNotNullParameter(visibilityToggles, "visibilityToggles");
            Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
            this.viewData = viewData;
            this.visibilityToggles = visibilityToggles;
            this.navigationIcon = navigationIcon;
        }

        public static /* synthetic */ Success copy$default(Success success, DocumentSelectionViewData documentSelectionViewData, VisibilityToggles visibilityToggles, NavigationIcon navigationIcon, int i, Object obj) {
            if ((i & 1) != 0) {
                documentSelectionViewData = success.viewData;
            }
            if ((i & 2) != 0) {
                visibilityToggles = success.visibilityToggles;
            }
            if ((i & 4) != 0) {
                navigationIcon = success.navigationIcon;
            }
            return success.copy(documentSelectionViewData, visibilityToggles, navigationIcon);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentSelectionViewData getViewData() {
            return this.viewData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final VisibilityToggles getVisibilityToggles() {
            return this.visibilityToggles;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final NavigationIcon getNavigationIcon() {
            return this.navigationIcon;
        }

        public final Success copy(DocumentSelectionViewData viewData, VisibilityToggles visibilityToggles, NavigationIcon navigationIcon) {
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            Intrinsics.checkNotNullParameter(visibilityToggles, "visibilityToggles");
            Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
            return new Success(viewData, visibilityToggles, navigationIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.viewData, success.viewData) && Intrinsics.areEqual(this.visibilityToggles, success.visibilityToggles) && this.navigationIcon == success.navigationIcon;
        }

        public final NavigationIcon getNavigationIcon() {
            return this.navigationIcon;
        }

        public final DocumentSelectionViewData getViewData() {
            return this.viewData;
        }

        public final VisibilityToggles getVisibilityToggles() {
            return this.visibilityToggles;
        }

        public int hashCode() {
            return (((this.viewData.hashCode() * 31) + this.visibilityToggles.hashCode()) * 31) + this.navigationIcon.hashCode();
        }

        public String toString() {
            return "Success(viewData=" + this.viewData + ", visibilityToggles=" + this.visibilityToggles + ", navigationIcon=" + this.navigationIcon + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$VisibilityToggles;", "", "showIdentityCheck", "", "showMoreAboutVerification", "showDoNotHaveDocuments", "(ZZZ)V", "getShowDoNotHaveDocuments", "()Z", "getShowIdentityCheck", "getShowMoreAboutVerification", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
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

    private DocumentSelectionViewState() {
    }

    public /* synthetic */ DocumentSelectionViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
