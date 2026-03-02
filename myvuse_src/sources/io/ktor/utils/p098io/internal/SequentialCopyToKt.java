package io.ktor.utils.p098io.internal;

import androidx.core.text.HtmlCompat;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SequentialCopyTo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m5598d2 = {"copyToSequentialImpl", "", "Lio/ktor/utils/io/ByteChannelSequentialBase;", C4352k.a.f5652f, "limit", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToTail", "joinToImpl", "", "closeOnEnd", "", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class SequentialCopyToKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1 */
    /* JADX INFO: compiled from: SequentialCopyTo.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.internal.SequentialCopyToKt", m5608f = "SequentialCopyTo.kt", m5609i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m5610l = {27, 33, 41}, m5611m = "copyToSequentialImpl", m5612n = {"$this$copyToSequentialImpl", C4352k.a.f5652f, "limit", "remainingLimit", "$this$copyToSequentialImpl", C4352k.a.f5652f, "limit", "remainingLimit", "$this$copyToSequentialImpl", C4352k.a.f5652f, "limit", "remainingLimit", "transferred"}, m5613s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$2"})
    static final class C53431 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53431(Continuation<? super C53431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.copyToSequentialImpl(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1 */
    /* JADX INFO: compiled from: SequentialCopyTo.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.internal.SequentialCopyToKt", m5608f = "SequentialCopyTo.kt", m5609i = {0, 0, 1, 1}, m5610l = {57, HtmlCompat.FROM_HTML_MODE_COMPACT}, m5611m = "copyToTail", m5612n = {C4352k.a.f5652f, "lastPiece", "lastPiece", "rc"}, m5613s = {"L$0", "L$1", "L$0", "I$0"})
    static final class C53441 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53441(Continuation<? super C53441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.copyToTail(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1 */
    /* JADX INFO: compiled from: SequentialCopyTo.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.internal.SequentialCopyToKt", m5608f = "SequentialCopyTo.kt", m5609i = {0, 0}, m5610l = {8}, m5611m = "joinToImpl", m5612n = {C4352k.a.f5652f, "closeOnEnd"}, m5613s = {"L$0", "Z$0"})
    static final class C53451 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C53451(Continuation<? super C53451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.joinToImpl(null, null, false, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object joinToImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r4, io.ktor.utils.p098io.ByteChannelSequentialBase r5, boolean r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.internal.SequentialCopyToKt.C53451
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1 r0 = (io.ktor.utils.p098io.internal.SequentialCopyToKt.C53451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1 r0 = new io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1
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
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.p098io.ByteChannelSequentialBase) r5
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
            java.lang.Object r4 = copyToSequentialImpl(r4, r5, r2, r0)
            if (r4 != r1) goto L4e
            return r1
        L4e:
            if (r6 == 0) goto L55
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.p098io.ByteWriteChannel) r5
            io.ktor.utils.p098io.ByteWriteChannelKt.close(r5)
        L55:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.internal.SequentialCopyToKt.joinToImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00de -> B:53:0x0100). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00e4 -> B:52:0x00f9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00f6 -> B:52:0x00f9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyToSequentialImpl(io.ktor.utils.p098io.ByteChannelSequentialBase r18, io.ktor.utils.p098io.ByteChannelSequentialBase r19, long r20, kotlin.coroutines.Continuation<? super java.lang.Long> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.internal.SequentialCopyToKt.copyToSequentialImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r8v0, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r9v0, types: [io.ktor.utils.io.ByteChannelSequentialBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2, types: [io.ktor.utils.io.core.internal.ChunkBuffer] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v9, types: [io.ktor.utils.io.core.internal.ChunkBuffer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyToTail(io.ktor.utils.p098io.ByteChannelSequentialBase r8, io.ktor.utils.p098io.ByteChannelSequentialBase r9, long r10, kotlin.coroutines.Continuation<? super java.lang.Long> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.internal.SequentialCopyToKt.copyToTail(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
