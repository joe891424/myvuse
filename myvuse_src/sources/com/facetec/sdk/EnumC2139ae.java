package com.facetec.sdk;

/* JADX INFO: renamed from: com.facetec.sdk.ae */
/* JADX INFO: loaded from: classes3.dex */
enum EnumC2139ae {
    ZOOM_CLOSE,
    ZOOM_FAR,
    PROCESSING_COMPLETE_TIMED_OUT,
    PROCESSING_COMPLETE_SUCCESS,
    PROCESSING_COMPLETE_RETRY,
    PROCESSING_COMPLETE_STILL_COMPUTING;

    /* JADX INFO: renamed from: B */
    final boolean m1481B() {
        return this == PROCESSING_COMPLETE_RETRY || this == PROCESSING_COMPLETE_SUCCESS;
    }
}
