package io.ktor.utils.p098io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ByteBufferChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
@DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0}, m5610l = {2430}, m5611m = "peekTo-vHUFkk8$suspendImpl", m5612n = {"bytesCopied"}, m5613s = {"L$0"})
final class ByteBufferChannel$peekTo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$peekTo$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$peekTo$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteBufferChannel.m6938peekTovHUFkk8$suspendImpl(this.this$0, null, 0L, 0L, 0L, 0L, this);
    }
}
