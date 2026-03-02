package com.yoti.mobile.android.documentcapture.view.educational;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentViewData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalFragmentArgs;", "Landroidx/navigation/NavArgs;", "documentViewData", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "countryIso3Code", "", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;)V", "getCountryIso3Code", "()Ljava/lang/String;", "getDocumentViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "getObjective", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "Companion", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentEducationalFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String countryIso3Code;
    private final DocumentViewData documentViewData;
    private final CaptureObjectiveTypeViewData objective;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/documentcapture/view/educational/DocumentEducationalFragmentArgs;", "bundle", "Landroid/os/Bundle;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DocumentEducationalFragmentArgs fromBundle(Bundle bundle) {
            DocumentViewData documentViewData;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(DocumentEducationalFragmentArgs.class.getClassLoader());
            CaptureObjectiveTypeViewData captureObjectiveTypeViewData = null;
            if (!bundle.containsKey("documentViewData")) {
                documentViewData = null;
            } else {
                if (!Parcelable.class.isAssignableFrom(DocumentViewData.class) && !Serializable.class.isAssignableFrom(DocumentViewData.class)) {
                    throw new UnsupportedOperationException(DocumentViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                documentViewData = (DocumentViewData) bundle.get("documentViewData");
            }
            String string = bundle.containsKey("countryIso3Code") ? bundle.getString("countryIso3Code") : null;
            if (bundle.containsKey("objective")) {
                if (!Parcelable.class.isAssignableFrom(CaptureObjectiveTypeViewData.class) && !Serializable.class.isAssignableFrom(CaptureObjectiveTypeViewData.class)) {
                    throw new UnsupportedOperationException(CaptureObjectiveTypeViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                captureObjectiveTypeViewData = (CaptureObjectiveTypeViewData) bundle.get("objective");
            }
            return new DocumentEducationalFragmentArgs(documentViewData, string, captureObjectiveTypeViewData);
        }
    }

    public DocumentEducationalFragmentArgs() {
        this(null, null, null, 7, null);
    }

    public DocumentEducationalFragmentArgs(DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData) {
        this.documentViewData = documentViewData;
        this.countryIso3Code = str;
        this.objective = captureObjectiveTypeViewData;
    }

    public static /* synthetic */ DocumentEducationalFragmentArgs copy$default(DocumentEducationalFragmentArgs documentEducationalFragmentArgs, DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, int i, Object obj) {
        if ((i & 1) != 0) {
            documentViewData = documentEducationalFragmentArgs.documentViewData;
        }
        if ((i & 2) != 0) {
            str = documentEducationalFragmentArgs.countryIso3Code;
        }
        if ((i & 4) != 0) {
            captureObjectiveTypeViewData = documentEducationalFragmentArgs.objective;
        }
        return documentEducationalFragmentArgs.copy(documentViewData, str, captureObjectiveTypeViewData);
    }

    @JvmStatic
    public static final DocumentEducationalFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
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

    public final DocumentEducationalFragmentArgs copy(DocumentViewData documentViewData, String countryIso3Code, CaptureObjectiveTypeViewData objective) {
        return new DocumentEducationalFragmentArgs(documentViewData, countryIso3Code, objective);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentEducationalFragmentArgs)) {
            return false;
        }
        DocumentEducationalFragmentArgs documentEducationalFragmentArgs = (DocumentEducationalFragmentArgs) other;
        return Intrinsics.areEqual(this.documentViewData, documentEducationalFragmentArgs.documentViewData) && Intrinsics.areEqual(this.countryIso3Code, documentEducationalFragmentArgs.countryIso3Code) && this.objective == documentEducationalFragmentArgs.objective;
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

    public final Bundle toBundle() {
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

    public String toString() {
        return "DocumentEducationalFragmentArgs(documentViewData=" + this.documentViewData + ", countryIso3Code=" + this.countryIso3Code + ", objective=" + this.objective + ')';
    }

    public /* synthetic */ DocumentEducationalFragmentArgs(DocumentViewData documentViewData, String str, CaptureObjectiveTypeViewData captureObjectiveTypeViewData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : documentViewData, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : captureObjectiveTypeViewData);
    }
}
