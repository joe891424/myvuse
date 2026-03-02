package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionUploadFailureType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragmentArgs;", "Landroidx/navigation/NavArgs;", "documentTextExtractionError", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "documentScanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;)V", "getDocumentScanResultViewData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "getDocumentTextExtractionError", "()Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionUploadFailureType$DocumentTextExtractionError;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentTextExtractionErrorFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DocumentScanResultViewData documentScanResultViewData;
    private final TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/DocumentTextExtractionErrorFragmentArgs;", "bundle", "Landroid/os/Bundle;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DocumentTextExtractionErrorFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(DocumentTextExtractionErrorFragmentArgs.class.getClassLoader());
            if (!bundle.containsKey("documentTextExtractionError")) {
                throw new IllegalArgumentException("Required argument \"documentTextExtractionError\" is missing and does not have an android:defaultValue");
            }
            if (!Parcelable.class.isAssignableFrom(TextExtractionUploadFailureType.DocumentTextExtractionError.class) && !Serializable.class.isAssignableFrom(TextExtractionUploadFailureType.DocumentTextExtractionError.class)) {
                throw new UnsupportedOperationException(TextExtractionUploadFailureType.DocumentTextExtractionError.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError = (TextExtractionUploadFailureType.DocumentTextExtractionError) bundle.get("documentTextExtractionError");
            if (documentTextExtractionError == null) {
                throw new IllegalArgumentException("Argument \"documentTextExtractionError\" is marked as non-null but was passed a null value.");
            }
            if (!bundle.containsKey("documentScanResultViewData")) {
                throw new IllegalArgumentException("Required argument \"documentScanResultViewData\" is missing and does not have an android:defaultValue");
            }
            if (!Parcelable.class.isAssignableFrom(DocumentScanResultViewData.class) && !Serializable.class.isAssignableFrom(DocumentScanResultViewData.class)) {
                throw new UnsupportedOperationException(DocumentScanResultViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            DocumentScanResultViewData documentScanResultViewData = (DocumentScanResultViewData) bundle.get("documentScanResultViewData");
            if (documentScanResultViewData != null) {
                return new DocumentTextExtractionErrorFragmentArgs(documentTextExtractionError, documentScanResultViewData);
            }
            throw new IllegalArgumentException("Argument \"documentScanResultViewData\" is marked as non-null but was passed a null value.");
        }
    }

    public DocumentTextExtractionErrorFragmentArgs(TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError, DocumentScanResultViewData documentScanResultViewData) {
        Intrinsics.checkNotNullParameter(documentTextExtractionError, "documentTextExtractionError");
        Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
        this.documentTextExtractionError = documentTextExtractionError;
        this.documentScanResultViewData = documentScanResultViewData;
    }

    public static /* synthetic */ DocumentTextExtractionErrorFragmentArgs copy$default(DocumentTextExtractionErrorFragmentArgs documentTextExtractionErrorFragmentArgs, TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError, DocumentScanResultViewData documentScanResultViewData, int i, Object obj) {
        if ((i & 1) != 0) {
            documentTextExtractionError = documentTextExtractionErrorFragmentArgs.documentTextExtractionError;
        }
        if ((i & 2) != 0) {
            documentScanResultViewData = documentTextExtractionErrorFragmentArgs.documentScanResultViewData;
        }
        return documentTextExtractionErrorFragmentArgs.copy(documentTextExtractionError, documentScanResultViewData);
    }

    @JvmStatic
    public static final DocumentTextExtractionErrorFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TextExtractionUploadFailureType.DocumentTextExtractionError getDocumentTextExtractionError() {
        return this.documentTextExtractionError;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DocumentScanResultViewData getDocumentScanResultViewData() {
        return this.documentScanResultViewData;
    }

    public final DocumentTextExtractionErrorFragmentArgs copy(TextExtractionUploadFailureType.DocumentTextExtractionError documentTextExtractionError, DocumentScanResultViewData documentScanResultViewData) {
        Intrinsics.checkNotNullParameter(documentTextExtractionError, "documentTextExtractionError");
        Intrinsics.checkNotNullParameter(documentScanResultViewData, "documentScanResultViewData");
        return new DocumentTextExtractionErrorFragmentArgs(documentTextExtractionError, documentScanResultViewData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentTextExtractionErrorFragmentArgs)) {
            return false;
        }
        DocumentTextExtractionErrorFragmentArgs documentTextExtractionErrorFragmentArgs = (DocumentTextExtractionErrorFragmentArgs) other;
        return Intrinsics.areEqual(this.documentTextExtractionError, documentTextExtractionErrorFragmentArgs.documentTextExtractionError) && Intrinsics.areEqual(this.documentScanResultViewData, documentTextExtractionErrorFragmentArgs.documentScanResultViewData);
    }

    public final DocumentScanResultViewData getDocumentScanResultViewData() {
        return this.documentScanResultViewData;
    }

    public final TextExtractionUploadFailureType.DocumentTextExtractionError getDocumentTextExtractionError() {
        return this.documentTextExtractionError;
    }

    public int hashCode() {
        return (this.documentTextExtractionError.hashCode() * 31) + this.documentScanResultViewData.hashCode();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (Parcelable.class.isAssignableFrom(TextExtractionUploadFailureType.DocumentTextExtractionError.class)) {
            bundle.putParcelable("documentTextExtractionError", this.documentTextExtractionError);
        } else {
            if (!Serializable.class.isAssignableFrom(TextExtractionUploadFailureType.DocumentTextExtractionError.class)) {
                throw new UnsupportedOperationException(TextExtractionUploadFailureType.DocumentTextExtractionError.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            bundle.putSerializable("documentTextExtractionError", (Serializable) this.documentTextExtractionError);
        }
        if (Parcelable.class.isAssignableFrom(DocumentScanResultViewData.class)) {
            bundle.putParcelable("documentScanResultViewData", this.documentScanResultViewData);
        } else {
            if (!Serializable.class.isAssignableFrom(DocumentScanResultViewData.class)) {
                throw new UnsupportedOperationException(DocumentScanResultViewData.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            bundle.putSerializable("documentScanResultViewData", (Serializable) this.documentScanResultViewData);
        }
        return bundle;
    }

    public String toString() {
        return "DocumentTextExtractionErrorFragmentArgs(documentTextExtractionError=" + this.documentTextExtractionError + ", documentScanResultViewData=" + this.documentScanResultViewData + ')';
    }
}
