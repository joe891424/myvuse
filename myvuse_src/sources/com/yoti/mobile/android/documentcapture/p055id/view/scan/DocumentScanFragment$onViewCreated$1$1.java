package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class DocumentScanFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function1<ScanState, Unit> {
    DocumentScanFragment$onViewCreated$1$1(Object obj) {
        super(1, obj, DocumentScanFragment.class, "onViewStateChanged", "onViewStateChanged(Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScanState scanState) {
        invoke2(scanState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ScanState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DocumentScanFragment) this.receiver).onViewStateChanged(p0);
    }
}
