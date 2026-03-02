package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment$loadScreen$$inlined$CoroutineExceptionHandler$1 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, m5598d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C4631x66441263 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ DocumentPageReviewFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4631x66441263(CoroutineExceptionHandler.Companion companion, DocumentPageReviewFragment documentPageReviewFragment) {
        super(companion);
        this.this$0 = documentPageReviewFragment;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        PageScanReviewViewModel pageScanReviewViewModel = this.this$0.pageScanReviewViewModel;
        if (pageScanReviewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageScanReviewViewModel");
            pageScanReviewViewModel = null;
        }
        pageScanReviewViewModel.reviewError(exception);
    }
}
