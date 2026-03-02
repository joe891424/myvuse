package io.ktor.utils.p098io.jvm.nio;

import io.ktor.utils.p098io.ByteReadChannel;
import java.nio.channels.Pipe;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Writing.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, m5598d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "pipe", "Ljava/nio/channels/Pipe;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/Pipe;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channel", "Ljava/nio/channels/WritableByteChannel;", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/WritableByteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class WritingKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1 */
    /* JADX INFO: compiled from: Writing.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.jvm.nio.WritingKt", m5608f = "Writing.kt", m5609i = {0, 0, 0, 0}, m5610l = {46}, m5611m = "copyTo", m5612n = {"$this$copyTo", "copied", "copy", "limit"}, m5613s = {"L$0", "L$1", "L$2", "J$0"})
    static final class C53521 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C53521(Continuation<? super C53521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WritingKt.copyTo((ByteReadChannel) null, (WritableByteChannel) null, 0L, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081 A[PHI: r2 r8 r10 r12
      0x0081: PHI (r2v3 kotlin.jvm.functions.Function1<java.nio.ByteBuffer, kotlin.Unit>) = 
      (r2v2 kotlin.jvm.functions.Function1<java.nio.ByteBuffer, kotlin.Unit>)
      (r2v4 kotlin.jvm.functions.Function1<java.nio.ByteBuffer, kotlin.Unit>)
     binds: [B:30:0x0075, B:37:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r8v8 io.ktor.utils.io.ByteReadChannel) = (r8v0 io.ktor.utils.io.ByteReadChannel), (r8v9 io.ktor.utils.io.ByteReadChannel) binds: [B:30:0x0075, B:37:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r10v1 long) = (r10v0 long), (r10v2 long) binds: [B:30:0x0075, B:37:0x009c] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r12v13 kotlin.jvm.internal.Ref$LongRef) = (r12v7 kotlin.jvm.internal.Ref$LongRef), (r12v14 kotlin.jvm.internal.Ref$LongRef) binds: [B:30:0x0075, B:37:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0095 -> B:36:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.p098io.ByteReadChannel r8, final java.nio.channels.WritableByteChannel r9, final long r10, kotlin.coroutines.Continuation<? super java.lang.Long> r12) {
        /*
            boolean r0 = r12 instanceof io.ktor.utils.p098io.jvm.nio.WritingKt.C53521
            if (r0 == 0) goto L14
            r0 = r12
            io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1 r0 = (io.ktor.utils.p098io.jvm.nio.WritingKt.C53521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1 r0 = new io.ktor.utils.io.jvm.nio.WritingKt$copyTo$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 != r4) goto L3e
            long r8 = r0.J$0
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.p098io.ByteReadChannel) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            r7 = r2
            r2 = r10
            r10 = r8
            r8 = r7
            goto L98
        L3e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L46:
            kotlin.ResultKt.throwOnFailure(r12)
            r5 = 0
            int r12 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r12 < 0) goto L51
            r12 = r4
            goto L52
        L51:
            r12 = r3
        L52:
            if (r12 == 0) goto La5
            boolean r12 = r9 instanceof java.nio.channels.SelectableChannel
            if (r12 == 0) goto L6a
            r12 = r9
            java.nio.channels.SelectableChannel r12 = (java.nio.channels.SelectableChannel) r12
            boolean r12 = r12.isBlocking()
            if (r12 == 0) goto L62
            goto L6a
        L62:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Non-blocking channels are not supported"
            r8.<init>(r9)
            throw r8
        L6a:
            boolean r12 = r8.isClosedForRead()
            if (r12 == 0) goto L75
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            return r8
        L75:
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            io.ktor.utils.io.jvm.nio.WritingKt$copyTo$copy$1 r2 = new io.ktor.utils.io.jvm.nio.WritingKt$copyTo$copy$1
            r2.<init>()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
        L81:
            long r5 = r12.element
            int r9 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r9 >= 0) goto L9e
            r0.L$0 = r8
            r0.L$1 = r12
            r0.L$2 = r2
            r0.J$0 = r10
            r0.label = r4
            java.lang.Object r9 = r8.read(r3, r2, r0)
            if (r9 != r1) goto L98
            return r1
        L98:
            boolean r9 = r8.isClosedForRead()
            if (r9 == 0) goto L81
        L9e:
            long r8 = r12.element
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)
            return r8
        La5:
            java.lang.String r8 = "Limit shouldn't be negative: "
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r9)
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.jvm.nio.WritingKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.nio.channels.WritableByteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, WritableByteChannel writableByteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, writableByteChannel, j, (Continuation<? super Long>) continuation);
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, Pipe pipe, long j, Continuation<? super Long> continuation) {
        Pipe.SinkChannel sinkChannelSink = pipe.sink();
        Intrinsics.checkNotNullExpressionValue(sinkChannelSink, "pipe.sink()");
        return copyTo(byteReadChannel, sinkChannelSink, j, continuation);
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, Pipe pipe, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, pipe, j, (Continuation<? super Long>) continuation);
    }
}
