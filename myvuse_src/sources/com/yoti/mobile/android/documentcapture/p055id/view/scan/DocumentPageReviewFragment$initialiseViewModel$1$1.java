package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.documentcapture.p055id.view.scan.PageScanReviewViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class DocumentPageReviewFragment$initialiseViewModel$1$1 extends FunctionReferenceImpl implements Function1<PageScanReviewViewModel.ReviewState, Unit> {
    DocumentPageReviewFragment$initialiseViewModel$1$1(Object obj) {
        super(1, obj, DocumentPageReviewFragment.class, "onCurrentStateChanged", "onCurrentStateChanged(Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewModel$ReviewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PageScanReviewViewModel.ReviewState reviewState) {
        invoke2(reviewState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PageScanReviewViewModel.ReviewState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DocumentPageReviewFragment) this.receiver).onCurrentStateChanged(p0);
    }
}
