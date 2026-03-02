package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class DocumentScanFragment$onViewCreated$1$2 extends FunctionReferenceImpl implements Function1<DocumentScanViewModel.DocumentScanNavigationEvent, Unit> {
    DocumentScanFragment$onViewCreated$1$2(Object obj) {
        super(1, obj, DocumentScanFragment.class, "onNavigationEvent", "onNavigationEvent(Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DocumentScanViewModel.DocumentScanNavigationEvent documentScanNavigationEvent) {
        invoke2(documentScanNavigationEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DocumentScanViewModel.DocumentScanNavigationEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DocumentScanFragment) this.receiver).onNavigationEvent(p0);
    }
}
