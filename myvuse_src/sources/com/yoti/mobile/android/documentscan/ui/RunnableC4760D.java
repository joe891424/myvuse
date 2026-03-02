package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedPageConfig;
import com.yoti.mobile.android.documentscan.ui.PageState;
import com.yoti.mobile.android.documentscan.ui.ScanningState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.D */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC4760D implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideViewModel f6981a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ DocumentScanDetailedPageConfig f6982b;

    RunnableC4760D(ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel, DocumentScanDetailedPageConfig documentScanDetailedPageConfig) {
        this.f6981a = scanDocumentMultiSideViewModel;
        this.f6982b = documentScanDetailedPageConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Intrinsics.areEqual(this.f6981a.f7020f.m4960c().getValue(), PageState.e.f7131a) || Intrinsics.areEqual(this.f6981a.f7020f.m4960c().getValue(), PageState.b.f7128a)) {
            this.f6981a.f7015a.setValue(new ScanningState.a(this.f6982b.getPageNumber()));
        }
    }
}
