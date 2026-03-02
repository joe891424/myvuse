package com.yoti.mobile.android.documentscan.ui;

import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.documentscan.ui.ScanningState;
import io.reactivex.functions.Consumer;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.C */
/* JADX INFO: loaded from: classes5.dex */
final class C4759C<T> implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideViewModel f6980a;

    C4759C(ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel) {
        this.f6980a = scanDocumentMultiSideViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Throwable th) {
        this.f6980a.f7015a.setValue(new ScanningState.f(new DocumentCaptureException.ScanResultConversionException(th)));
    }
}
