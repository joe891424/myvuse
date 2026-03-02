package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.ui.DocumentAction;
import io.reactivex.functions.Consumer;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.B */
/* JADX INFO: loaded from: classes5.dex */
final class C4758B<T> implements Consumer<DocumentCaptureResult> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideViewModel f6979a;

    C4758B(ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel) {
        this.f6979a = scanDocumentMultiSideViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(DocumentCaptureResult documentCaptureResult) {
        int pageNumber = this.f6979a.f7020f.m4959b().getPageNumber();
        if (pageNumber == 0) {
            this.f6979a.f7021g.m4807b(documentCaptureResult);
        } else if (pageNumber == 1) {
            this.f6979a.f7021g.m4802a(documentCaptureResult);
        }
        this.f6979a.f7020f.m4957a(DocumentAction.b.f7038a);
    }
}
