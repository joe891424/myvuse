package com.yoti.mobile.android.scan;

import android.view.View;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.h */
/* JADX INFO: loaded from: classes4.dex */
final class ViewOnClickListenerC4942h implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScannerViewFragment f7427a;

    ViewOnClickListenerC4942h(ScannerViewFragment scannerViewFragment) {
        this.f7427a = scannerViewFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ScannerViewFragment.access$getViewModel$p(this.f7427a).m5075b();
    }
}
