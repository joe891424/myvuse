package com.yoti.mobile.android.documentscan.ui;

import com.microblink.metadata.recognition.FirstSideRecognitionCallback;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.h */
/* JADX INFO: loaded from: classes5.dex */
final class C4799h implements FirstSideRecognitionCallback {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ImageScanFragment f7110a;

    C4799h(ImageScanFragment imageScanFragment) {
        this.f7110a = imageScanFragment;
    }

    @Override // com.microblink.metadata.recognition.FirstSideRecognitionCallback
    public final void onFirstSideRecognitionFinished() {
        ImageScanFragment.access$getViewModel$p(this.f7110a).m4934b();
    }
}
