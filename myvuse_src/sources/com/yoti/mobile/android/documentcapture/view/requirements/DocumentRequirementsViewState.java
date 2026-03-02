package com.yoti.mobile.android.documentcapture.view.requirements;

import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentRequirementsViewData;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState;", "", "()V", "Error", "Loading", "Success", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState$Loading;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState$Success;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState$Error;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentRequirementsViewState {

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState$Error;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Error extends DocumentRequirementsViewState {
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

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState$Loading;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState;", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "(Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;)V", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Loading extends DocumentRequirementsViewState {
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

    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState$Success;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState;", "viewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementsViewData;", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementsViewData;Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;)V", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "getViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementsViewData;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Success extends DocumentRequirementsViewState {
        private final NavigationIcon navigationIcon;
        private final DocumentRequirementsViewData viewData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(DocumentRequirementsViewData viewData, NavigationIcon navigationIcon) {
            super(null);
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
            this.viewData = viewData;
            this.navigationIcon = navigationIcon;
        }

        public static /* synthetic */ Success copy$default(Success success, DocumentRequirementsViewData documentRequirementsViewData, NavigationIcon navigationIcon, int i, Object obj) {
            if ((i & 1) != 0) {
                documentRequirementsViewData = success.viewData;
            }
            if ((i & 2) != 0) {
                navigationIcon = success.navigationIcon;
            }
            return success.copy(documentRequirementsViewData, navigationIcon);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentRequirementsViewData getViewData() {
            return this.viewData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final NavigationIcon getNavigationIcon() {
            return this.navigationIcon;
        }

        public final Success copy(DocumentRequirementsViewData viewData, NavigationIcon navigationIcon) {
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            Intrinsics.checkNotNullParameter(navigationIcon, "navigationIcon");
            return new Success(viewData, navigationIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.viewData, success.viewData) && this.navigationIcon == success.navigationIcon;
        }

        public final NavigationIcon getNavigationIcon() {
            return this.navigationIcon;
        }

        public final DocumentRequirementsViewData getViewData() {
            return this.viewData;
        }

        public int hashCode() {
            return (this.viewData.hashCode() * 31) + this.navigationIcon.hashCode();
        }

        public String toString() {
            return "Success(viewData=" + this.viewData + ", navigationIcon=" + this.navigationIcon + ')';
        }
    }

    private DocumentRequirementsViewState() {
    }

    public /* synthetic */ DocumentRequirementsViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
