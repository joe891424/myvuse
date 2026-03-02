package com.yoti.mobile.android.documentcapture.sup.view.review;

import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class DocumentReviewFragment$onViewCreated$1$2 extends FunctionReferenceImpl implements Function1<DocumentReviewViewModel.NavigationEvent, Unit> {
    DocumentReviewFragment$onViewCreated$1$2(Object obj) {
        super(1, obj, DocumentReviewFragment.class, "onNavigationEventReceived", "onNavigationEventReceived(Lcom/yoti/mobile/android/documentcapture/sup/view/review/DocumentReviewViewModel$NavigationEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DocumentReviewViewModel.NavigationEvent navigationEvent) {
        invoke2(navigationEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DocumentReviewViewModel.NavigationEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DocumentReviewFragment) this.receiver).onNavigationEventReceived(p0);
    }
}
