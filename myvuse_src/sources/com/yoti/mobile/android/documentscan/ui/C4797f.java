package com.yoti.mobile.android.documentscan.ui;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.f */
/* JADX INFO: loaded from: classes5.dex */
final class C4797f<T> implements Observer<ScanningState> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ImageScanFragment f7108a;

    C4797f(ImageScanFragment imageScanFragment) {
        this.f7108a = imageScanFragment;
    }

    @Override // androidx.lifecycle.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onChanged(ScanningState it2) {
        ImageScanFragment imageScanFragment = this.f7108a;
        Intrinsics.checkExpressionValueIsNotNull(it2, "it");
        imageScanFragment.handleScanningState(it2);
    }
}
