package com.yoti.mobile.android.documentscan.ui;

import com.microblink.metadata.recognition.FirstSideRecognitionCallback;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.v */
/* JADX INFO: loaded from: classes5.dex */
final class C4827v implements FirstSideRecognitionCallback {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideFragment f7163a;

    C4827v(ScanDocumentMultiSideFragment scanDocumentMultiSideFragment) {
        this.f7163a = scanDocumentMultiSideFragment;
    }

    @Override // com.microblink.metadata.recognition.FirstSideRecognitionCallback
    public final void onFirstSideRecognitionFinished() {
        ScanDocumentMultiSideFragment.m4906a(this.f7163a).m4934b();
    }
}
