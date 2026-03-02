package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.TextExtractionErrorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
/* synthetic */ class DocumentTextExtractionErrorFragment$onViewCreated$1$2 extends FunctionReferenceImpl implements Function1<SingleEvent<? extends TextExtractionErrorViewModel.TextExtractionErrorNavigationEvent>, Unit> {
    DocumentTextExtractionErrorFragment$onViewCreated$1$2(Object obj) {
        super(1, obj, DocumentTextExtractionErrorFragment.class, "onNavigationEvent", "onNavigationEvent(Lcom/yoti/mobile/android/commonui/SingleEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SingleEvent<? extends TextExtractionErrorViewModel.TextExtractionErrorNavigationEvent> singleEvent) {
        invoke2(singleEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SingleEvent<? extends TextExtractionErrorViewModel.TextExtractionErrorNavigationEvent> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DocumentTextExtractionErrorFragment) this.receiver).onNavigationEvent(p0);
    }
}
