package com.facetec.sdk;

/* JADX INFO: loaded from: classes3.dex */
public interface FaceTecIDScanResultCallback {
    void cancel();

    boolean proceedToNextStep(String str);

    void uploadMessageOverride(String str);

    void uploadProgress(float f);
}
