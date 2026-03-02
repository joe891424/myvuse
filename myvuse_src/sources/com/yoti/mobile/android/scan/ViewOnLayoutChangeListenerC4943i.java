package com.yoti.mobile.android.scan;

import android.view.View;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.i */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewOnLayoutChangeListenerC4943i implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScannerViewFragment f7428a;

    ViewOnLayoutChangeListenerC4943i(ScannerViewFragment scannerViewFragment) {
        this.f7428a = scannerViewFragment;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 - i == 0 || i4 - i2 == 0) {
            return;
        }
        this.f7428a.m5054e();
        ScannerViewFragment.access$getFocusContainerView$p(this.f7428a).removeOnLayoutChangeListener(this);
    }
}
