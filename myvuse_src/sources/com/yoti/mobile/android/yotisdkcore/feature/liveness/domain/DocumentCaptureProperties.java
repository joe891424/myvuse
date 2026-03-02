package com.yoti.mobile.android.yotisdkcore.feature.liveness.domain;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/DocumentCaptureProperties;", "", "isSupplementaryDocumentUploadAllowed", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentCaptureProperties {
    private final boolean isSupplementaryDocumentUploadAllowed;

    public DocumentCaptureProperties(boolean z) {
        this.isSupplementaryDocumentUploadAllowed = z;
    }

    public static /* synthetic */ DocumentCaptureProperties copy$default(DocumentCaptureProperties documentCaptureProperties, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = documentCaptureProperties.isSupplementaryDocumentUploadAllowed;
        }
        return documentCaptureProperties.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSupplementaryDocumentUploadAllowed() {
        return this.isSupplementaryDocumentUploadAllowed;
    }

    public final DocumentCaptureProperties copy(boolean isSupplementaryDocumentUploadAllowed) {
        return new DocumentCaptureProperties(isSupplementaryDocumentUploadAllowed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DocumentCaptureProperties) && this.isSupplementaryDocumentUploadAllowed == ((DocumentCaptureProperties) other).isSupplementaryDocumentUploadAllowed;
    }

    public int hashCode() {
        boolean z = this.isSupplementaryDocumentUploadAllowed;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean isSupplementaryDocumentUploadAllowed() {
        return this.isSupplementaryDocumentUploadAllowed;
    }

    public String toString() {
        return "DocumentCaptureProperties(isSupplementaryDocumentUploadAllowed=" + this.isSupplementaryDocumentUploadAllowed + ')';
    }
}
