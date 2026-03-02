package io.ktor.utils.p098io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ByteChannelSequential.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
@DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialBase", m5608f = "ByteChannelSequential.kt", m5609i = {0}, m5610l = {TypedValues.Custom.TYPE_BOOLEAN}, m5611m = "peekTo-vHUFkk8", m5612n = {"bytesCopied"}, m5613s = {"L$0"})
final class ByteChannelSequentialBase$peekTo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteChannelSequentialBase$peekTo$1(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$peekTo$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo6940peekTovHUFkk8(null, 0L, 0L, 0L, 0L, this);
    }
}
