package io.ktor.utils.p098io.jvm.nio;

import io.ktor.utils.p098io.ByteWriteChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Reading.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, m5598d2 = {"copyTo", "", "Ljava/nio/channels/Pipe;", "ch", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Ljava/nio/channels/Pipe;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/ReadableByteChannel;", "(Ljava/nio/channels/ReadableByteChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ReadingKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1 */
    /* JADX INFO: compiled from: Reading.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.jvm.nio.ReadingKt", m5608f = "Reading.kt", m5609i = {0, 0, 0, 0, 0, 0}, m5610l = {40}, m5611m = "copyTo", m5612n = {"ch", "copied", "eof", "copy", "limit", "needFlush"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0"})
    static final class C53511 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C53511(Continuation<? super C53511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadingKt.copyTo((ReadableByteChannel) null, (ByteWriteChannel) null, 0L, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a6 -> B:34:0x00a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(final java.nio.channels.ReadableByteChannel r11, io.ktor.utils.p098io.ByteWriteChannel r12, final long r13, kotlin.coroutines.Continuation<? super java.lang.Long> r15) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.jvm.nio.ReadingKt.copyTo(java.nio.channels.ReadableByteChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ReadableByteChannel readableByteChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(readableByteChannel, byteWriteChannel, j, (Continuation<? super Long>) continuation);
    }

    public static final Object copyTo(Pipe pipe, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        Pipe.SourceChannel sourceChannelSource = pipe.source();
        Intrinsics.checkNotNullExpressionValue(sourceChannelSource, "source()");
        return copyTo(sourceChannelSource, byteWriteChannel, j, continuation);
    }

    public static /* synthetic */ Object copyTo$default(Pipe pipe, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(pipe, byteWriteChannel, j, (Continuation<? super Long>) continuation);
    }
}
