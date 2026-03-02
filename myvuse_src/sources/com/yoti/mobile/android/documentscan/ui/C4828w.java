package com.yoti.mobile.android.documentscan.ui;

import androidx.lifecycle.MutableLiveData;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedPageConfig;
import com.yoti.mobile.android.documentscan.ui.DocumentState;
import com.yoti.mobile.android.documentscan.ui.ScanningState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentscan.ui.w */
/* JADX INFO: loaded from: classes5.dex */
final class C4828w<T> implements Consumer<DocumentState> {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScanDocumentMultiSideViewModel f7164a;

    C4828w(ScanDocumentMultiSideViewModel scanDocumentMultiSideViewModel) {
        this.f7164a = scanDocumentMultiSideViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(DocumentState documentState) {
        MutableLiveData mutableLiveData;
        ScanningState bVar;
        this.f7164a.m4922d();
        if (!Intrinsics.areEqual(documentState, DocumentState.d.f7105a)) {
            if (Intrinsics.areEqual(documentState, DocumentState.b.f7103a)) {
                mutableLiveData = this.f7164a.f7015a;
                bVar = new ScanningState.h(this.f7164a.f7021g.m4808c());
            } else if (Intrinsics.areEqual(documentState, DocumentState.c.f7104a)) {
                DocumentScanDetailedPageConfig documentScanDetailedPageConfigM4959b = this.f7164a.f7020f.m4959b();
                this.f7164a.f7021g.m4799a(documentScanDetailedPageConfigM4959b.getWantedNbOfHolograms());
                this.f7164a.f7015a.setValue(new ScanningState.i(documentScanDetailedPageConfigM4959b.getOcrSupported()));
            } else if (Intrinsics.areEqual(documentState, DocumentState.a.f7102a)) {
                mutableLiveData = this.f7164a.f7015a;
                bVar = new ScanningState.g(this.f7164a.f7021g.m4805b());
            } else {
                if (!Intrinsics.areEqual(documentState, DocumentState.e.f7106a)) {
                    return;
                }
                mutableLiveData = this.f7164a.f7015a;
                bVar = new ScanningState.b(this.f7164a.f7021g.m4808c(), this.f7164a.f7021g.m4805b());
            }
            mutableLiveData.setValue(bVar);
            return;
        }
        this.f7164a.f7015a.setValue(new ScanningState.j(this.f7164a.f7020f.m4959b().getOcrSupported()));
        this.f7164a.m4928h();
    }
}
