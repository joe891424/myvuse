package io.ktor.utils.p098io;

import com.brentvatne.react.ReactVideoViewManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ByteBufferChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
@DebugMetadata(m5607c = "io.ktor.utils.io.ByteBufferChannel", m5608f = "ByteBufferChannel.kt", m5609i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, m5610l = {1217, 1288, 1296}, m5611m = "copyDirect$ktor_io", m5612n = {"this", ReactVideoViewManager.PROP_SRC, "joined", "byteOrder", "copied", "this_$iv", "capacity$iv", "current$iv", "state", "dstBuffer", "$this$copyDirect_u24lambda_u2d77", "limit", "autoFlush", "before$iv", "this", ReactVideoViewManager.PROP_SRC, "joined", "byteOrder", "copied", "limit", "autoFlush", "this", ReactVideoViewManager.PROP_SRC, "joined", "byteOrder", "copied", "limit", "autoFlush"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "Z$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "Z$0"})
final class ByteBufferChannel$copyDirect$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$copyDirect$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$copyDirect$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.copyDirect$ktor_io(null, 0L, null, this);
    }
}
