package com.yoti.mobile.android.documentscan.ui;

import com.microblink.entities.recognizers.Recognizer;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.A */
/* JADX INFO: loaded from: classes5.dex */
final class C4757A<T, R> implements Function<T, SingleSource<? extends R>> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideViewModel f6978a;

    C4757A(ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel) {
        this.f6978a = scanDocumentMultiSideViewModel;
    }

    @Override // io.reactivex.functions.Function
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Single<DocumentCaptureResult> apply(PageState it2) {
        Intrinsics.checkParameterIsNotNull(it2, "it");
        int pageNumber = this.f6978a.f7020f.m4959b().getPageNumber();
        Recognizer.Result resultM4810d = this.f6978a.f7021g.m4810d();
        if (pageNumber == 1) {
            this.f6978a.f7021g.m4803a(this.f6978a.f7022h.m4839a(resultM4810d));
        }
        return this.f6978a.f7022h.m4838a(pageNumber, resultM4810d);
    }
}
