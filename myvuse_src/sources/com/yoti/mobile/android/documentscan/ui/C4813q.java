package com.yoti.mobile.android.documentscan.ui;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.q */
/* JADX INFO: loaded from: classes5.dex */
final class C4813q<T> implements Observer<ScanningState> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideFragment f7135a;

    C4813q(ScanDocumentMultiSideFragment scanDocumentMultiSideFragment) {
        this.f7135a = scanDocumentMultiSideFragment;
    }

    @Override // androidx.lifecycle.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void onChanged(ScanningState it2) {
        ScanDocumentMultiSideFragment scanDocumentMultiSideFragment = this.f7135a;
        Intrinsics.checkExpressionValueIsNotNull(it2, "it");
        scanDocumentMultiSideFragment.m4910a(it2);
    }
}
