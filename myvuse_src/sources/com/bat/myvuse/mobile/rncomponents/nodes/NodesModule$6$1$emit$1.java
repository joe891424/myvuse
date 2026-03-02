package com.bat.myvuse.mobile.rncomponents.nodes;

import com.bat.myvuse.mobile.rncomponents.nodes.NodesModule;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.model.PuffRecord;
import com.bat.sdk.model.PuffRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: NodesModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$6$1", m5608f = "NodesModule.kt", m5609i = {0, 0}, m5610l = {414, 460}, m5611m = "emit", m5612n = {"this", "record"}, m5613s = {"L$0", "L$1"})
final class NodesModule$6$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NodesModule.C14256.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NodesModule$6$1$emit$1(NodesModule.C14256.AnonymousClass1<? super T> anonymousClass1, Continuation<? super NodesModule$6$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((CharacteristicClient<PuffRequest, PuffRecord>.Response) null, (Continuation<? super Unit>) this);
    }
}
