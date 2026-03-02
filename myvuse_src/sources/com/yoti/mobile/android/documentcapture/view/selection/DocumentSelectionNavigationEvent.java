package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.documentcapture.view.DocumentNavigationEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionNavigationEvent;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent$AbstractDocumentNavigationEvent;", "()V", "NavigateToCountrySelection", "NavigateToDocumentEducational", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionNavigationEvent$NavigateToDocumentEducational;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionNavigationEvent$NavigateToCountrySelection;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class DocumentSelectionNavigationEvent extends DocumentNavigationEvent.AbstractDocumentNavigationEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionNavigationEvent$NavigateToCountrySelection;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionNavigationEvent;", "()V", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class NavigateToCountrySelection extends DocumentSelectionNavigationEvent {
        public static final NavigateToCountrySelection INSTANCE = new NavigateToCountrySelection();

        private NavigateToCountrySelection() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionNavigationEvent$NavigateToDocumentEducational;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionNavigationEvent;", "viewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "countryIso3Code", "", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getObjective", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "getViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class NavigateToDocumentEducational extends DocumentSelectionNavigationEvent {
        private final String countryIso3Code;
        private final CaptureObjectiveTypeViewData objective;
        private final DocumentViewData viewData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToDocumentEducational(DocumentViewData viewData, String countryIso3Code, CaptureObjectiveTypeViewData objective) {
            super(null);
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
            Intrinsics.checkNotNullParameter(objective, "objective");
            this.viewData = viewData;
            this.countryIso3Code = countryIso3Code;
            this.objective = objective;
        }

        public static /* synthetic */ NavigateToDocumentEducational copy$default(NavigateToDocumentEducational navigateToDocumentEducational, DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                documentViewData = navigateToDocumentEducational.viewData;
            }
            if ((i & 2) != 0) {
                str = navigateToDocumentEducational.countryIso3Code;
            }
            if ((i & 4) != 0) {
                captureObjectiveTypeViewData = navigateToDocumentEducational.objective;
            }
            return navigateToDocumentEducational.copy(documentViewData, str, captureObjectiveTypeViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentViewData getViewData() {
            return this.viewData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCountryIso3Code() {
            return this.countryIso3Code;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CaptureObjectiveTypeViewData getObjective() {
            return this.objective;
        }

        public final NavigateToDocumentEducational copy(DocumentViewData viewData, String countryIso3Code, CaptureObjectiveTypeViewData objective) {
            Intrinsics.checkNotNullParameter(viewData, "viewData");
            Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
            Intrinsics.checkNotNullParameter(objective, "objective");
            return new NavigateToDocumentEducational(viewData, countryIso3Code, objective);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateToDocumentEducational)) {
                return false;
            }
            NavigateToDocumentEducational navigateToDocumentEducational = (NavigateToDocumentEducational) other;
            return Intrinsics.areEqual(this.viewData, navigateToDocumentEducational.viewData) && Intrinsics.areEqual(this.countryIso3Code, navigateToDocumentEducational.countryIso3Code) && this.objective == navigateToDocumentEducational.objective;
        }

        public final String getCountryIso3Code() {
            return this.countryIso3Code;
        }

        public final CaptureObjectiveTypeViewData getObjective() {
            return this.objective;
        }

        public final DocumentViewData getViewData() {
            return this.viewData;
        }

        public int hashCode() {
            return (((this.viewData.hashCode() * 31) + this.countryIso3Code.hashCode()) * 31) + this.objective.hashCode();
        }

        public String toString() {
            return "NavigateToDocumentEducational(viewData=" + this.viewData + ", countryIso3Code=" + this.countryIso3Code + ", objective=" + this.objective + ')';
        }
    }

    private DocumentSelectionNavigationEvent() {
    }

    public /* synthetic */ DocumentSelectionNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
