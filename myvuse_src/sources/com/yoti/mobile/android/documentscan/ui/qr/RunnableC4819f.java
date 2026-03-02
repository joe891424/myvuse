package com.yoti.mobile.android.documentscan.ui.qr;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.qr.f */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC4819f implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ QrCodeFragment f7151a;

    RunnableC4819f(QrCodeFragment qrCodeFragment) {
        this.f7151a = qrCodeFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QrCodeFragment.m5012a(this.f7151a).reset();
    }
}
