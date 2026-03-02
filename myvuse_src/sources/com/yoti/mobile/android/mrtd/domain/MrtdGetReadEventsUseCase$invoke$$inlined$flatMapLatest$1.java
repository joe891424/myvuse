package com.yoti.mobile.android.mrtd.domain;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import com.yoti.mobile.android.mrtd.domain.model.MrtdReadState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.yoti.mobile.android.mrtd.domain.MrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1", m5608f = "MrtdGetReadEventsUseCase.kt", m5609i = {}, m5610l = {JfifUtil.MARKER_SOI}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
public final class MrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super MrtdReadState>, MrtdReadState, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MrtdGetReadEventsUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1(Continuation continuation, MrtdGetReadEventsUseCase mrtdGetReadEventsUseCase) {
        super(3, continuation);
        this.this$0 = mrtdGetReadEventsUseCase;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super MrtdReadState> flowCollector, MrtdReadState mrtdReadState, Continuation<? super Unit> continuation) {
        MrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1 mrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1 = new MrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1(continuation, this.this$0);
        mrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1.L$0 = flowCollector;
        mrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1.L$1 = mrtdReadState;
        return mrtdGetReadEventsUseCase$invoke$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = FlowKt.flow(new MrtdGetReadEventsUseCase$invoke$1$1((MrtdReadState) this.L$1, this.this$0, null));
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
