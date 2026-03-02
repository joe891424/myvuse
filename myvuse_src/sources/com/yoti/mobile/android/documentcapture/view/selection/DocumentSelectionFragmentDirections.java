package com.yoti.mobile.android.documentcapture.view.selection;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.DocumentSelectionNavGraphDirections;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionFragmentDirections;", "", "()V", "ActionDocumentSelectionFragmentToDocumentEducational", "Companion", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentSelectionFragmentDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J*\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionFragmentDirections$Companion;", "", "()V", "actionDocumentSelectionFragmentToCountrySelectionFragment", "Landroidx/navigation/NavDirections;", "actionDocumentSelectionFragmentToDocumentEducational", "documentViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "countryIso3Code", "", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "actionDocumentSelectionFragmentToDocumentRequirements", "actionGlobalToAdditionalInstructions", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavDirections actionDocumentSelectionFragmentToDocumentEducational$default(Companion companion, DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                documentViewData = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                captureObjectiveTypeViewData = null;
            }
            return companion.actionDocumentSelectionFragmentToDocumentEducational(documentViewData, str, captureObjectiveTypeViewData);
        }

        public final NavDirections actionDocumentSelectionFragmentToCountrySelectionFragment() {
            return new ActionOnlyNavDirections(C4597R.id.action_documentSelectionFragment_to_countrySelectionFragment);
        }

        public final NavDirections actionDocumentSelectionFragmentToDocumentEducational(DocumentViewData documentViewData, String countryIso3Code, CaptureObjectiveTypeViewData objective) {
            return new ActionDocumentSelectionFragmentToDocumentEducational(documentViewData, countryIso3Code, objective);
        }

        public final NavDirections actionDocumentSelectionFragmentToDocumentRequirements() {
            return new ActionOnlyNavDirections(C4597R.id.action_documentSelectionFragment_to_document_requirements);
        }

        public final NavDirections actionGlobalToAdditionalInstructions() {
            return DocumentSelectionNavGraphDirections.INSTANCE.actionGlobalToAdditionalInstructions();
        }
    }

    private DocumentSelectionFragmentDirections() {
    }

    @Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionFragmentDirections$ActionDocumentSelectionFragmentToDocumentEducational;", "Landroidx/navigation/NavDirections;", "documentViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "countryIso3Code", "", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "getObjective", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionDocumentSelectionFragmentToDocumentEducational implements NavDirections {
        private final String countryIso3Code;
        private final DocumentViewData documentViewData;
        private final CaptureObjectiveTypeViewData objective;

        public ActionDocumentSelectionFragmentToDocumentEducational() {
            this(null, null, null, 7, null);
        }

        public ActionDocumentSelectionFragmentToDocumentEducational(DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData) {
            this.documentViewData = documentViewData;
            this.countryIso3Code = str;
            this.objective = captureObjectiveTypeViewData;
        }

        public static /* synthetic */ ActionDocumentSelectionFragmentToDocumentEducational copy$default(ActionDocumentSelectionFragmentToDocumentEducational actionDocumentSelectionFragmentToDocumentEducational, DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, int i, Object obj) {
            if ((i & 1) != 0) {
                documentViewData = actionDocumentSelectionFragmentToDocumentEducational.documentViewData;
            }
            if ((i & 2) != 0) {
                str = actionDocumentSelectionFragmentToDocumentEducational.countryIso3Code;
            }
            if ((i & 4) != 0) {
                captureObjectiveTypeViewData = actionDocumentSelectionFragmentToDocumentEducational.objective;
            }
            return actionDocumentSelectionFragmentToDocumentEducational.copy(documentViewData, str, captureObjectiveTypeViewData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentViewData getDocumentViewData() {
            return this.documentViewData;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCountryIso3Code() {
            return this.countryIso3Code;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CaptureObjectiveTypeViewData getObjective() {
            return this.objective;
        }

        public final ActionDocumentSelectionFragmentToDocumentEducational copy(DocumentViewData documentViewData, String countryIso3Code, CaptureObjectiveTypeViewData objective) {
            return new ActionDocumentSelectionFragmentToDocumentEducational(documentViewData, countryIso3Code, objective);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActionDocumentSelectionFragmentToDocumentEducational)) {
                return false;
            }
            ActionDocumentSelectionFragmentToDocumentEducational actionDocumentSelectionFragmentToDocumentEducational = (ActionDocumentSelectionFragmentToDocumentEducational) other;
            return Intrinsics.areEqual(this.documentViewData, actionDocumentSelectionFragmentToDocumentEducational.documentViewData) && Intrinsics.areEqual(this.countryIso3Code, actionDocumentSelectionFragmentToDocumentEducational.countryIso3Code) && this.objective == actionDocumentSelectionFragmentToDocumentEducational.objective;
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4597R.id.action_documentSelectionFragment_to_document_educational;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(DocumentViewData.class)) {
                bundle.putParcelable("documentViewData", this.documentViewData);
            } else if (Serializable.class.isAssignableFrom(DocumentViewData.class)) {
                bundle.putSerializable("documentViewData", (Serializable) this.documentViewData);
            }
            bundle.putString("countryIso3Code", this.countryIso3Code);
            if (Parcelable.class.isAssignableFrom(CaptureObjectiveTypeViewData.class)) {
                bundle.putParcelable("objective", this.objective);
            } else if (Serializable.class.isAssignableFrom(CaptureObjectiveTypeViewData.class)) {
                bundle.putSerializable("objective", this.objective);
            }
            return bundle;
        }

        public final String getCountryIso3Code() {
            return this.countryIso3Code;
        }

        public final DocumentViewData getDocumentViewData() {
            return this.documentViewData;
        }

        public final CaptureObjectiveTypeViewData getObjective() {
            return this.objective;
        }

        public int hashCode() {
            DocumentViewData documentViewData = this.documentViewData;
            int iHashCode = (documentViewData == null ? 0 : documentViewData.hashCode()) * 31;
            String str = this.countryIso3Code;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            CaptureObjectiveTypeViewData captureObjectiveTypeViewData = this.objective;
            return iHashCode2 + (captureObjectiveTypeViewData != null ? captureObjectiveTypeViewData.hashCode() : 0);
        }

        public String toString() {
            return "ActionDocumentSelectionFragmentToDocumentEducational(documentViewData=" + this.documentViewData + ", countryIso3Code=" + this.countryIso3Code + ", objective=" + this.objective + ')';
        }

        public /* synthetic */ ActionDocumentSelectionFragmentToDocumentEducational(DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : documentViewData, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : captureObjectiveTypeViewData);
        }
    }
}
