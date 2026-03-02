package com.yoti.mobile.android.mrtd.domain;

import com.yoti.mobile.android.mrtd.domain.model.MrtdReadState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.yoti.mobile.android.mrtd.domain.MrtdGetReadEventsUseCase$invoke$1$1", m5608f = "MrtdGetReadEventsUseCase.kt", m5609i = {0, 1}, m5610l = {23, 25, 26, 30, 33, 35}, m5611m = "invokeSuspend", m5612n = {"$this$flow", "$this$flow"}, m5613s = {"L$0", "L$0"})
final class MrtdGetReadEventsUseCase$invoke$1$1 extends SuspendLambda implements Function2<FlowCollector<? super MrtdReadState>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MrtdReadState $event;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MrtdGetReadEventsUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MrtdGetReadEventsUseCase$invoke$1$1(MrtdReadState mrtdReadState, MrtdGetReadEventsUseCase mrtdGetReadEventsUseCase, Continuation<? super MrtdGetReadEventsUseCase$invoke$1$1> continuation) {
        super(2, continuation);
        this.$event = mrtdReadState;
        this.this$0 = mrtdGetReadEventsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MrtdGetReadEventsUseCase$invoke$1$1 mrtdGetReadEventsUseCase$invoke$1$1 = new MrtdGetReadEventsUseCase$invoke$1$1(this.$event, this.this$0, continuation);
        mrtdGetReadEventsUseCase$invoke$1$1.L$0 = obj;
        return mrtdGetReadEventsUseCase$invoke$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super MrtdReadState> flowCollector, Continuation<? super Unit> continuation) {
        return ((MrtdGetReadEventsUseCase$invoke$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.mrtd.domain.MrtdGetReadEventsUseCase$invoke$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
