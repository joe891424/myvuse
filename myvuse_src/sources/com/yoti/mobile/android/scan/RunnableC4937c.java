package com.yoti.mobile.android.scan;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.c */
/* JADX INFO: loaded from: classes4.dex */
final class RunnableC4937c implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScannerViewBaseFragment f7421a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f7422b;

    RunnableC4937c(ScannerViewBaseFragment scannerViewBaseFragment, String str) {
        this.f7421a = scannerViewBaseFragment;
        this.f7422b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (ScannerViewBaseFragment.access$getCameraLifecycle$p(this.f7421a).getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            ScannerViewBaseFragment.access$getCameraLifecycle$p(this.f7421a).stopCamera();
            OnQrCodeFoundListener onQrCodeFoundListener = this.f7421a.f7402d;
            if (onQrCodeFoundListener != null) {
                onQrCodeFoundListener.onQrCodeFound(this.f7422b);
            }
        }
    }
}
