package io.ktor.utils.p098io;

import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.IoBuffer;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ByteReadChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a'\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0015\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0018\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u00020\u0019*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001d\u0010\u001c\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a!\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\n\u0010 \u001a\u00060!j\u0002`\"H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m5598d2 = {"cancel", "", "Lio/ktor/utils/io/ByteReadChannel;", "copyAndClose", "", C4352k.a.f5652f, "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discard", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discardExact", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "(Lio/ktor/utils/io/ByteReadChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "", "", "(Lio/ktor/utils/io/ByteReadChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFully", "Lio/ktor/utils/io/core/IoBuffer;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/IoBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "size", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemaining", "readUTF8Line", "", "readUTF8LineTo", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteReadChannelKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1 */
    /* JADX INFO: compiled from: ByteReadChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteReadChannelKt", m5608f = "ByteReadChannel.kt", m5609i = {0}, m5610l = {271}, m5611m = "copyAndClose", m5612n = {C4352k.a.f5652f}, m5613s = {"L$0"})
    static final class C53091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53091(Continuation<? super C53091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelKt.copyAndClose(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelKt$discardExact$1 */
    /* JADX INFO: compiled from: ByteReadChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteReadChannelKt", m5608f = "ByteReadChannel.kt", m5609i = {0}, m5610l = {242}, m5611m = "discardExact", m5612n = {RsaJsonWebKey.MODULUS_MEMBER_NAME}, m5613s = {"J$0"})
    static final class C53101 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        C53101(Continuation<? super C53101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelKt.discardExact(null, 0L, this);
        }
    }

    public static final Object readPacket(ByteReadChannel byteReadChannel, int i, Continuation<? super ByteReadPacket> continuation) {
        return byteReadChannel.readPacket(i, 0, continuation);
    }

    public static final Object readRemaining(ByteReadChannel byteReadChannel, long j, Continuation<? super ByteReadPacket> continuation) {
        return byteReadChannel.readRemaining(j, 0, continuation);
    }

    public static final Object readRemaining(ByteReadChannel byteReadChannel, Continuation<? super ByteReadPacket> continuation) {
        return byteReadChannel.readRemaining(Long.MAX_VALUE, 0, continuation);
    }

    public static final Object readFully(ByteReadChannel byteReadChannel, IoBuffer ioBuffer, Continuation<? super Unit> continuation) {
        IoBuffer ioBuffer2 = ioBuffer;
        Object fully = byteReadChannel.readFully(ioBuffer, ioBuffer2.getLimit() - ioBuffer2.getWritePosition(), continuation);
        return fully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fully : Unit.INSTANCE;
    }

    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, Continuation<? super Boolean> continuation) {
        return byteReadChannel.readUTF8LineTo(appendable, Integer.MAX_VALUE, continuation);
    }

    public static final Object readUTF8Line(ByteReadChannel byteReadChannel, Continuation<? super String> continuation) {
        return byteReadChannel.readUTF8Line(Integer.MAX_VALUE, continuation);
    }

    public static final boolean cancel(ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return byteReadChannel.cancel(null);
    }

    public static final Object discard(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        return byteReadChannel.discard(Long.MAX_VALUE, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object discardExact(io.ktor.utils.p098io.ByteReadChannel r4, long r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.io.EOFException {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteReadChannelKt.C53101
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteReadChannelKt$discardExact$1 r0 = (io.ktor.utils.p098io.ByteReadChannelKt.C53101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelKt$discardExact$1 r0 = new io.ktor.utils.io.ByteReadChannelKt$discardExact$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L42
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r7 = r4.discard(r5, r0)
            if (r7 != r1) goto L42
            return r1
        L42:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            int r4 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r4 != 0) goto L4f
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L4f:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to discard "
            r7.<init>(r0)
            java.lang.StringBuilder r5 = r7.append(r5)
            java.lang.String r6 = " bytes"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteReadChannelKt.discardExact(io.ktor.utils.io.ByteReadChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object discardExact$$forInline(ByteReadChannel byteReadChannel, long j, Continuation<? super Unit> continuation) throws EOFException {
        InlineMarker.mark(0);
        Object objDiscard = byteReadChannel.discard(j, continuation);
        InlineMarker.mark(1);
        if (((Number) objDiscard).longValue() != j) {
            throw new EOFException("Unable to discard " + j + " bytes");
        }
        return Unit.INSTANCE;
    }

    public static final Object readAvailable(ByteReadChannel byteReadChannel, byte[] bArr, Continuation<? super Integer> continuation) {
        return byteReadChannel.readAvailable(bArr, 0, bArr.length, continuation);
    }

    public static final Object readFully(ByteReadChannel byteReadChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Object fully = byteReadChannel.readFully(bArr, 0, bArr.length, continuation);
        return fully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fully : Unit.INSTANCE;
    }

    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Continuation<? super Long> continuation) {
        return ByteReadChannelJVMKt.copyTo(byteReadChannel, byteWriteChannel, Long.MAX_VALUE, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyAndClose(io.ktor.utils.p098io.ByteReadChannel r4, io.ktor.utils.p098io.ByteWriteChannel r5, long r6, kotlin.coroutines.Continuation<? super java.lang.Long> r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteReadChannelKt.C53091
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1 r0 = (io.ktor.utils.p098io.ByteReadChannelKt.C53091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1 r0 = new io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.p098io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = io.ktor.utils.p098io.ByteReadChannelJVMKt.copyTo(r4, r5, r6, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            java.lang.Number r8 = (java.lang.Number) r8
            long r6 = r8.longValue()
            io.ktor.utils.p098io.ByteWriteChannelKt.close(r5)
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteReadChannelKt.copyAndClose(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyAndClose$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyAndClose(byteReadChannel, byteWriteChannel, j, continuation);
    }
}
