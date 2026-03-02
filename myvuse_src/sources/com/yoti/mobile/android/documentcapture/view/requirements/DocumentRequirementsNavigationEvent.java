package com.yoti.mobile.android.documentcapture.view.requirements;

import com.yoti.mobile.android.commonui.GuidelinesViewData;
import com.yoti.mobile.android.documentcapture.view.DocumentNavigationEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsNavigationEvent;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$AbstractDocumentNavigationEvent;", "()V", "CloseSdk", "NavigateToScanningGuidelines", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsNavigationEvent$NavigateToScanningGuidelines;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsNavigationEvent$CloseSdk;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentRequirementsNavigationEvent extends DocumentNavigationEvent.AbstractDocumentNavigationEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsNavigationEvent$CloseSdk;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class CloseSdk extends DocumentRequirementsNavigationEvent {
        public static final CloseSdk INSTANCE = new CloseSdk();

        private CloseSdk() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsNavigationEvent$NavigateToScanningGuidelines;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsNavigationEvent;", "viewData", "Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "(Lcom/yoti/mobile/android/commonui/GuidelinesViewData;)V", "getViewData", "()Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NavigateToScanningGuidelines extends DocumentRequirementsNavigationEvent {
        private final GuidelinesViewData viewData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToScanningGuidelines(GuidelinesViewData viewData) {
            super(null);
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            this.viewData = viewData;
        }

        public static /* synthetic */ NavigateToScanningGuidelines copy$default(NavigateToScanningGuidelines navigateToScanningGuidelines, GuidelinesViewData guidelinesViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                guidelinesViewData = navigateToScanningGuidelines.viewData;
            }
            return navigateToScanningGuidelines.copy(guidelinesViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuidelinesViewData getViewData() {
            return this.viewData;
        }

        public final NavigateToScanningGuidelines copy(GuidelinesViewData viewData) {
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            return new NavigateToScanningGuidelines(viewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToScanningGuidelines) && Intrinsics.areEqual(this.viewData, ((NavigateToScanningGuidelines) other).viewData);
        }

        public final GuidelinesViewData getViewData() {
            return this.viewData;
        }

        public int hashCode() {
            return this.viewData.hashCode();
        }

        public String toString() {
            return "NavigateToScanningGuidelines(viewData=" + this.viewData + ')';
        }
    }

    private DocumentRequirementsNavigationEvent() {
    }

    public /* synthetic */ DocumentRequirementsNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
