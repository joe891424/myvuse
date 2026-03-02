package kotlinx.coroutines.flow;

import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5599k = 3, m5600mv = {1, 8, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1", m5608f = "Limit.kt", m5609i = {}, m5610l = {LockFreeTaskQueueCore.CLOSED_SHIFT, HtmlCompat.FROM_HTML_MODE_COMPACT}, m5611m = "emit", m5612n = {}, m5613s = {})
final class FlowKt__LimitKt$take$2$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__LimitKt$take$2$1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$take$2$1$emit$1(FlowKt__LimitKt$take$2$1<? super T> flowKt__LimitKt$take$2$1, Continuation<? super FlowKt__LimitKt$take$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = flowKt__LimitKt$take$2$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
