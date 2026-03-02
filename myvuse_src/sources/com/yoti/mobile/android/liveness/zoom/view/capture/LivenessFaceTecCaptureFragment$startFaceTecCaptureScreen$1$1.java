package com.yoti.mobile.android.liveness.zoom.view.capture;

import com.facetec.sdk.FaceTecFaceScanResultCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureFragment$startFaceTecCaptureScreen$1$1", m5608f = "LivenessFaceTecCaptureFragment.kt", m5609i = {}, m5610l = {74}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class LivenessFaceTecCaptureFragment$startFaceTecCaptureScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FaceTecFaceScanResultCallback $faceTecFaceMapResultCallback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LivenessFaceTecCaptureFragment$startFaceTecCaptureScreen$1$1(FaceTecFaceScanResultCallback faceTecFaceScanResultCallback, Continuation<? super LivenessFaceTecCaptureFragment$startFaceTecCaptureScreen$1$1> continuation) {
        super(2, continuation);
        this.$faceTecFaceMapResultCallback = faceTecFaceScanResultCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LivenessFaceTecCaptureFragment$startFaceTecCaptureScreen$1$1(this.$faceTecFaceMapResultCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LivenessFaceTecCaptureFragment$startFaceTecCaptureScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$faceTecFaceMapResultCallback.cancel();
        return Unit.INSTANCE;
    }
}
