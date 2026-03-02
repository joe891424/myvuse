package com.bat.myvuse.mobile.rncomponents.nodes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bat.myvuse.mobile.rncomponents.nodes.NodesModule;
import com.bat.sdk.client.CharacteristicClient;
import com.bat.sdk.model.LogRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: NodesModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.myvuse.mobile.rncomponents.nodes.NodesModule$7$1", m5608f = "NodesModule.kt", m5609i = {0, 0, 0}, m5610l = {580, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE}, m5611m = "emit", m5612n = {"this", "record", "deviceType"}, m5613s = {"L$0", "L$1", "L$2"})
final class NodesModule$7$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NodesModule.C14267.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NodesModule$7$1$emit$1(NodesModule.C14267.AnonymousClass1<? super T> anonymousClass1, Continuation<? super NodesModule$7$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((CharacteristicClient<Unit, LogRecord>.Response) null, (Continuation<? super Unit>) this);
    }
}
