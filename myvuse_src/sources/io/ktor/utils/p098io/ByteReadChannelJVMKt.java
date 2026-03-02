package io.ktor.utils.p098io;

import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.internal.SequentialCopyToKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ByteReadChannelJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a%\u0010\r\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m5598d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", C4352k.a.f5652f, "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToImpl", "joinTo", "", "closeOnEnd", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinToImplSuspend", "close", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteReadChannelJVMKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelJVMKt$copyToImpl$1 */
    /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteReadChannelJVMKt", m5608f = "ByteReadChannelJVM.kt", m5609i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m5610l = {320, 323}, m5611m = "copyToImpl", m5612n = {"$this$copyToImpl", C4352k.a.f5652f, "buffer", "limit", "dstNeedsFlush", "copied", "$this$copyToImpl", C4352k.a.f5652f, "buffer", "limit", "dstNeedsFlush", "copied", "size"}, m5613s = {"L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "I$1"})
    static final class C53071 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C53071(Continuation<? super C53071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelJVMKt.copyToImpl(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1 */
    /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteReadChannelJVMKt", m5608f = "ByteReadChannelJVM.kt", m5609i = {0, 0}, m5610l = {279}, m5611m = "joinToImplSuspend", m5612n = {C4352k.a.f5652f, "close"}, m5613s = {"L$0", "Z$0"})
    static final class C53081 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C53081(Continuation<? super C53081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelJVMKt.joinToImplSuspend(null, null, false, this);
        }
    }

    public static final Object joinTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        if (!(byteWriteChannel != byteReadChannel)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) {
            Object objJoinFrom$ktor_io = ((ByteBufferChannel) byteWriteChannel).joinFrom$ktor_io((ByteBufferChannel) byteReadChannel, z, continuation);
            return objJoinFrom$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoinFrom$ktor_io : Unit.INSTANCE;
        }
        Object objJoinToImplSuspend = joinToImplSuspend(byteReadChannel, byteWriteChannel, z, continuation);
        return objJoinToImplSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoinToImplSuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object joinToImplSuspend(io.ktor.utils.p098io.ByteReadChannel r4, io.ktor.utils.p098io.ByteWriteChannel r5, boolean r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteReadChannelJVMKt.C53081
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1 r0 = (io.ktor.utils.p098io.ByteReadChannelJVMKt.C53081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1 r0 = new io.ktor.utils.io.ByteReadChannelJVMKt$joinToImplSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            boolean r6 = r0.Z$0
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.p098io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.Z$0 = r6
            r0.label = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r4 = copyTo(r4, r5, r2, r0)
            if (r4 != r1) goto L4e
            return r1
        L4e:
            if (r6 == 0) goto L54
            io.ktor.utils.p098io.ByteWriteChannelKt.close(r5)
            goto L57
        L54:
            r5.flush()
        L57:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteReadChannelJVMKt.joinToImplSuspend(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        if (!(byteReadChannel != byteWriteChannel)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (j == 0) {
            return Boxing.boxLong(0L);
        }
        if ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) {
            return ((ByteBufferChannel) byteWriteChannel).copyDirect$ktor_io((ByteBufferChannel) byteReadChannel, j, null, continuation);
        }
        if ((byteReadChannel instanceof ByteChannelSequentialBase) && (byteWriteChannel instanceof ByteChannelSequentialBase)) {
            return SequentialCopyToKt.copyToSequentialImpl((ByteChannelSequentialBase) byteReadChannel, (ByteChannelSequentialBase) byteWriteChannel, Long.MAX_VALUE, continuation);
        }
        return copyToImpl(byteReadChannel, byteWriteChannel, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092 A[Catch: all -> 0x0104, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0104, blocks: (B:42:0x00fa, B:44:0x0100, B:26:0x0092), top: B:54:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6 A[Catch: all -> 0x0069, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0069, blocks: (B:13:0x0041, B:33:0x00c8, B:30:0x00be, B:36:0x00d6, B:18:0x0065), top: B:58:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ed -> B:40:0x00f6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyToImpl(io.ktor.utils.p098io.ByteReadChannel r19, io.ktor.utils.p098io.ByteWriteChannel r20, long r21, kotlin.coroutines.Continuation<? super java.lang.Long> r23) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteReadChannelJVMKt.copyToImpl(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
