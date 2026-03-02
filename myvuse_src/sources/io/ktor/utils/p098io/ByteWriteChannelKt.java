package io.ktor.utils.p098io;

import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.common.callercontext.ContextChain;
import io.ktor.utils.p098io.core.ByteOrder;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteWriteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0013\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0013\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a8\u0010\u001a\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00042\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u001fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010 \u001a>\u0010!\u001a\u00020\t*\u00020\u00022'\u0010\u001c\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"¢\u0006\u0002\b\u001fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u001d\u0010&\u001a\u00020\t*\u00020\u00022\u0006\u0010'\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a%\u0010&\u001a\u00020\t*\u00020\u00022\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\t*\u00020\u00022\u0006\u0010'\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a\u001d\u0010)\u001a\u00020\t*\u00020\u00022\u0006\u0010'\u001a\u00020,H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m5598d2 = {"close", "", "Lio/ktor/utils/io/ByteWriteChannel;", "writeAvailable", "", ReactVideoViewManager.PROP_SRC, "", "(Lio/ktor/utils/io/ByteWriteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeBoolean", "", "b", "(Lio/ktor/utils/io/ByteWriteChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeByte", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeChar", "ch", "", "(Lio/ktor/utils/io/ByteWriteChannel;CLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "writeInt", ContextChain.TAG_INFRA, "", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/ByteWriteChannel;JLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacket", "headerSizeHint", "builder", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacketSuspend", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "s", "(Lio/ktor/utils/io/ByteWriteChannel;ILio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeStringUtf8", "", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/CharSequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteWriteChannelKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 */
    /* JADX INFO: compiled from: ByteWriteChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteWriteChannelKt", m5608f = "ByteWriteChannel.kt", m5609i = {0}, m5610l = {221, 221}, m5611m = "writePacketSuspend", m5612n = {"builder$iv"}, m5613s = {"L$0"})
    static final class C53111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53111(Continuation<? super C53111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteWriteChannelKt.writePacketSuspend(null, null, this);
        }
    }

    public static final Object writeAvailable(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Integer> continuation) {
        return byteWriteChannel.writeAvailable(bArr, 0, bArr.length, continuation);
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Object objWriteFully = byteWriteChannel.writeFully(bArr, 0, bArr.length, continuation);
        return objWriteFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFully : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object objWriteShort = byteWriteChannel.writeShort((short) (i & 65535), continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, int i, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        Object objWriteShort = ChannelLittleEndianKt.writeShort(byteWriteChannel, (short) (i & 65535), byteOrder, continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    public static final Object writeByte(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object objWriteByte = byteWriteChannel.writeByte((byte) (i & 255), continuation);
        return objWriteByte == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteByte : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        Object objWriteInt = byteWriteChannel.writeInt((int) j, continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, long j, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        Object objWriteInt = ChannelLittleEndianKt.writeInt(byteWriteChannel, (int) j, byteOrder, continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    public static final boolean close(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return byteWriteChannel.close(null);
    }

    public static final Object writeBoolean(ByteWriteChannel byteWriteChannel, boolean z, Continuation<? super Unit> continuation) {
        Object objWriteByte = byteWriteChannel.writeByte(z ? (byte) 1 : (byte) 0, continuation);
        return objWriteByte == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteByte : Unit.INSTANCE;
    }

    public static final Object writeChar(ByteWriteChannel byteWriteChannel, char c, Continuation<? super Unit> continuation) {
        Object objWriteShort = writeShort(byteWriteChannel, c, continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writePacketSuspend(io.ktor.utils.p098io.ByteWriteChannel r5, kotlin.jvm.functions.Function2<? super io.ktor.utils.p098io.core.BytePacketBuilder, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteWriteChannelKt.C53111
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 r0 = (io.ktor.utils.p098io.ByteWriteChannelKt.C53111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6b
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.p098io.ByteWriteChannel) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.core.BytePacketBuilder r6 = (io.ktor.utils.p098io.core.BytePacketBuilder) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L41
            goto L59
        L41:
            r5 = move-exception
            goto L70
        L43:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            io.ktor.utils.io.core.BytePacketBuilder r7 = io.ktor.utils.p098io.core.PacketJVMKt.BytePacketBuilder(r7)
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L6e
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L6e
            r0.label = r4     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r6 = r6.invoke(r7, r0)     // Catch: java.lang.Throwable -> L6e
            if (r6 != r1) goto L58
            return r1
        L58:
            r6 = r7
        L59:
            io.ktor.utils.io.core.ByteReadPacket r6 = r6.build()     // Catch: java.lang.Throwable -> L41
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r5 = r5.writePacket(r6, r0)
            if (r5 != r1) goto L6b
            return r1
        L6b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L6e:
            r5 = move-exception
            r6 = r7
        L70:
            r6.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteWriteChannelKt.writePacketSuspend(io.ktor.utils.io.ByteWriteChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, CharSequence charSequence, Continuation<? super Unit> continuation) {
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(0);
        try {
            BytePacketBuilder.writeStringUtf8(charSequence);
            Object objWritePacket = byteWriteChannel.writePacket(BytePacketBuilder.build(), continuation);
            return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }

    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, String str, Continuation<? super Unit> continuation) {
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(0);
        try {
            StringsKt.writeText$default(BytePacketBuilder, str, 0, 0, (Charset) null, 14, (Object) null);
            Object objWritePacket = byteWriteChannel.writePacket(BytePacketBuilder.build(), continuation);
            return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }

    public static final Object writePacket(ByteWriteChannel byteWriteChannel, int i, Function1<? super BytePacketBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(i);
        try {
            function1.invoke(BytePacketBuilder);
            Object objWritePacket = byteWriteChannel.writePacket(BytePacketBuilder.build(), continuation);
            return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }

    private static final Object writePacket$$forInline(ByteWriteChannel byteWriteChannel, int i, Function1<? super BytePacketBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(i);
        try {
            function1.invoke(BytePacketBuilder);
            ByteReadPacket byteReadPacketBuild = BytePacketBuilder.build();
            InlineMarker.mark(0);
            byteWriteChannel.writePacket(byteReadPacketBuild, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }

    public static /* synthetic */ Object writePacket$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(i);
        try {
            function1.invoke(BytePacketBuilder);
            ByteReadPacket byteReadPacketBuild = BytePacketBuilder.build();
            InlineMarker.mark(0);
            byteWriteChannel.writePacket(byteReadPacketBuild, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }
}
