package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class DocumentTextExtractionErrorFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function1<TextExtractionErrorViewModel.TextExtractionErrorViewState, Unit> {
    DocumentTextExtractionErrorFragment$onViewCreated$1$1(Object obj) {
        super(1, obj, DocumentTextExtractionErrorFragment.class, "onViewStateChanged", "onViewStateChanged(Lcom/yoti/mobile/android/documentcapture/id/view/upload/TextExtractionErrorViewModel$TextExtractionErrorViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextExtractionErrorViewModel.TextExtractionErrorViewState textExtractionErrorViewState) {
        invoke2(textExtractionErrorViewState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TextExtractionErrorViewModel.TextExtractionErrorViewState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DocumentTextExtractionErrorFragment) this.receiver).onViewStateChanged(p0);
    }
}
