package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.documentscan.ui.ScanningState;
import io.reactivex.functions.Consumer;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.y */
/* JADX INFO: loaded from: classes5.dex */
final class C4830y<T> implements Consumer<PageState> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideViewModel f7166a;

    C4830y(ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel) {
        this.f7166a = scanDocumentMultiSideViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(PageState pageState) {
        this.f7166a.f7021g.m4800a(250L);
        this.f7166a.f7015a.setValue(ScanningState.c.f6992a);
    }
}
