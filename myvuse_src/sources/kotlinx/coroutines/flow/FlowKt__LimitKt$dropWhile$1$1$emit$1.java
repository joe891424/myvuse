package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5599k = 3, m5600mv = {1, 8, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", m5608f = "Limit.kt", m5609i = {1, 1}, m5610l = {37, 38, 40}, m5611m = "emit", m5612n = {"this", "value"}, m5613s = {"L$0", "L$1"})
final class FlowKt__LimitKt$dropWhile$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__LimitKt$dropWhile$1$1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$dropWhile$1$1$emit$1(FlowKt__LimitKt$dropWhile$1$1<? super T> flowKt__LimitKt$dropWhile$1$1, Continuation<? super FlowKt__LimitKt$dropWhile$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = flowKt__LimitKt$dropWhile$1$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
