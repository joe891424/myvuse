package com.yoti.mobile.android.documentcapture.sup.view.review;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewFragmentArgs;", "Landroidx/navigation/NavArgs;", "captureViewData", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;)V", "getCaptureViewData", "()Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentReviewFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SupplementaryDocumentViewData captureViewData;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewFragmentArgs;", "bundle", "Landroid/os/Bundle;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DocumentReviewFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(DocumentReviewFragmentArgs.class.getClassLoader());
            if (!bundle.containsKey("captureViewData")) {
                throw new IllegalArgumentException("Required argument \"captureViewData\" is missing and does not have an android:defaultValue");
            }
            if (!Parcelable.class.isAssignableFrom(SupplementaryDocumentViewData.class) && !Serializable.class.isAssignableFrom(SupplementaryDocumentViewData.class)) {
                throw new UnsupportedOperationException(SupplementaryDocumentViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            SupplementaryDocumentViewData supplementaryDocumentViewData = (SupplementaryDocumentViewData) bundle.get("captureViewData");
            if (supplementaryDocumentViewData != null) {
                return new DocumentReviewFragmentArgs(supplementaryDocumentViewData);
            }
            throw new IllegalArgumentException("Argument \"captureViewData\" is marked as non-null but was passed a null value.");
        }
    }

    public DocumentReviewFragmentArgs(SupplementaryDocumentViewData captureViewData) {
        Intrinsics.checkNotNullParameter(captureViewData, "captureViewData");
        this.captureViewData = captureViewData;
    }

    public static /* synthetic */ DocumentReviewFragmentArgs copy$default(DocumentReviewFragmentArgs documentReviewFragmentArgs, SupplementaryDocumentViewData supplementaryDocumentViewData, int i, Object obj) {
        if ((i & 1) != 0) {
            supplementaryDocumentViewData = documentReviewFragmentArgs.captureViewData;
        }
        return documentReviewFragmentArgs.copy(supplementaryDocumentViewData);
    }

    @JvmStatic
    public static final DocumentReviewFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SupplementaryDocumentViewData getCaptureViewData() {
        return this.captureViewData;
    }

    public final DocumentReviewFragmentArgs copy(SupplementaryDocumentViewData captureViewData) {
        Intrinsics.checkNotNullParameter(captureViewData, "captureViewData");
        return new DocumentReviewFragmentArgs(captureViewData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DocumentReviewFragmentArgs) && Intrinsics.areEqual(this.captureViewData, ((DocumentReviewFragmentArgs) other).captureViewData);
    }

    public final SupplementaryDocumentViewData getCaptureViewData() {
        return this.captureViewData;
    }

    public int hashCode() {
        return this.captureViewData.hashCode();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (Parcelable.class.isAssignableFrom(SupplementaryDocumentViewData.class)) {
            bundle.putParcelable("captureViewData", this.captureViewData);
        } else {
            if (!Serializable.class.isAssignableFrom(SupplementaryDocumentViewData.class)) {
                throw new UnsupportedOperationException(SupplementaryDocumentViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            bundle.putSerializable("captureViewData", (Serializable) this.captureViewData);
        }
        return bundle;
    }

    public String toString() {
        return "DocumentReviewFragmentArgs(captureViewData=" + this.captureViewData + ')';
    }
}
