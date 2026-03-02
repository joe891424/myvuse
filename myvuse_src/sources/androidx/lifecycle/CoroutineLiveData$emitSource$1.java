package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5599k = 3, m5600mv = {1, 8, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "androidx.lifecycle.CoroutineLiveData", m5608f = "CoroutineLiveData.kt", m5609i = {0, 0, 1}, m5610l = {228, 229}, m5611m = "emitSource$lifecycle_livedata_release", m5612n = {"this", "source", "this"}, m5613s = {"L$0", "L$1", "L$0"})
final class CoroutineLiveData$emitSource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineLiveData$emitSource$1(CoroutineLiveData<T> coroutineLiveData, Continuation<? super CoroutineLiveData$emitSource$1> continuation) {
        super(continuation);
        this.this$0 = coroutineLiveData;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emitSource$lifecycle_livedata_release(null, this);
    }
}
