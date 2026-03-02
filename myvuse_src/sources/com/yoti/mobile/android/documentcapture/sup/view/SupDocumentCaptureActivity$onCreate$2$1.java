package com.yoti.mobile.android.documentcapture.sup.view;

import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class SupDocumentCaptureActivity$onCreate$2$1 extends FunctionReferenceImpl implements Function1<SupDocumentScanViewModel.ViewState, Unit> {
    SupDocumentCaptureActivity$onCreate$2$1(Object obj) {
        super(1, obj, SupDocumentCaptureActivity.class, "onViewState", "onViewState(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SupDocumentScanViewModel.ViewState viewState) {
        invoke2(viewState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SupDocumentScanViewModel.ViewState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SupDocumentCaptureActivity) this.receiver).onViewState(p0);
    }
}
