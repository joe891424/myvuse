package com.yoti.mobile.android.documentcapture.sup.view.review;

import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class DocumentReviewFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function1<DocumentReviewViewModel.DocumentReviewState, Unit> {
    DocumentReviewFragment$onViewCreated$1$1(Object obj) {
        super(1, obj, DocumentReviewFragment.class, "onReviewStateChanged", "onReviewStateChanged(Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$DocumentReviewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DocumentReviewViewModel.DocumentReviewState documentReviewState) {
        invoke2(documentReviewState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DocumentReviewViewModel.DocumentReviewState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DocumentReviewFragment) this.receiver).onReviewStateChanged(p0);
    }
}
