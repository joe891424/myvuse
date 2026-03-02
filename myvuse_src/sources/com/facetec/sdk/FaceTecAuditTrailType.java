package com.facetec.sdk;

/* JADX INFO: loaded from: classes3.dex */
public enum FaceTecAuditTrailType {
    DISABLED("Audit trail images will not be returned"),
    FULL_RESOLUTION("The full resolution image will be returned for the audit trail"),
    HEIGHT_640("An image of height 640 will be returned for the audit trail");

    private final String Code;

    FaceTecAuditTrailType(String str) {
        this.Code = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.Code;
    }
}
