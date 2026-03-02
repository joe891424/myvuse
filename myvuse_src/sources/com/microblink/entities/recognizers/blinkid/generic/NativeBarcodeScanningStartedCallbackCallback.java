package com.microblink.entities.recognizers.blinkid.generic;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeBarcodeScanningStartedCallbackCallback {
    BarcodeScanningStartedCallback llIIlIlIIl;

    public NativeBarcodeScanningStartedCallbackCallback(BarcodeScanningStartedCallback barcodeScanningStartedCallback) {
        this.llIIlIlIIl = barcodeScanningStartedCallback;
    }

    public void onBarcodeScanningStarted() {
        BarcodeScanningStartedCallback barcodeScanningStartedCallback = this.llIIlIlIIl;
        if (barcodeScanningStartedCallback != null) {
            barcodeScanningStartedCallback.onBarcodeScanningStarted();
        }
    }
}
