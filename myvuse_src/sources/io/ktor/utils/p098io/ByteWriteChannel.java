package io.ktor.utils.p098io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.common.callercontext.ContextChain;
import com.newrelic.agent.android.agentdata.HexAttribute;
import io.ktor.utils.p098io.core.Buffer;
import io.ktor.utils.p098io.core.ByteOrder;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import io.ktor.utils.p098io.core.IoBuffer;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ByteWriteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u001b\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH&J\b\u0010 \u001a\u00020\u001cH&J/\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u00072\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001c0$H¦@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H¦@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020%H¦@ø\u0001\u0000¢\u0006\u0002\u0010+J)\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010/J&\u0010'\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u00072\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001c0$H&J\u0019\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u000202H¦@ø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u000206H¦@ø\u0001\u0000¢\u0006\u0002\u00107J\u0019\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020:H¦@ø\u0001\u0000¢\u0006\u0002\u0010;J.\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H¦@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0019\u0010<\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020CH¦@ø\u0001\u0000¢\u0006\u0002\u0010DJ\u0019\u0010<\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H¦@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010<\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020%H¦@ø\u0001\u0000¢\u0006\u0002\u0010+J)\u0010<\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0019\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010GJ\u0019\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u0019\u0010K\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020MH¦@ø\u0001\u0000¢\u0006\u0002\u0010NJ\u0019\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020QH¦@ø\u0001\u0000¢\u0006\u0002\u0010RJ:\u0010S\u001a\u00020\u001c2'\u0010T\u001a#\b\u0001\u0012\u0004\u0012\u00020V\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0W\u0012\u0006\u0012\u0004\u0018\u00010\u00010U¢\u0006\u0002\bXH§@ø\u0001\u0000¢\u0006\u0002\u0010YJ%\u0010Z\u001a\u00020\u001c2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030$H¦@ø\u0001\u0000¢\u0006\u0002\u0010[R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, m5598d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "autoFlush", "", "getAutoFlush", "()Z", "availableForWrite", "", "getAvailableForWrite", "()I", "closedCause", "", "getClosedCause", "()Ljava/lang/Throwable;", "isClosedForWrite", "totalBytesWritten", "", "getTotalBytesWritten", "()J", "writeByteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "getWriteByteOrder$annotations", "()V", "getWriteByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setWriteByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "awaitFreeSpace", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", HexAttribute.HEX_ATTR_CAUSE, "flush", "write", "min", "block", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeAvailable", ReactVideoViewManager.PROP_SRC, "Lio/ktor/utils/io/core/IoBuffer;", "(Lio/ktor/utils/io/core/IoBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeByte", "b", "", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeDouble", "d", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloat", "f", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "memory", "Lio/ktor/utils/io/bits/Memory;", "startIndex", "endIndex", "writeFully-rGWNHyQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/Buffer;", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeInt", ContextChain.TAG_INFRA, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLong", "l", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacket", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "s", "", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSuspendSession", "visitor", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterSuspendSession;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface ByteWriteChannel {
    @ExperimentalIoApi
    Object awaitFreeSpace(Continuation<? super Unit> continuation);

    boolean close(Throwable cause);

    void flush();

    boolean getAutoFlush();

    int getAvailableForWrite();

    Throwable getClosedCause();

    long getTotalBytesWritten();

    ByteOrder getWriteByteOrder();

    boolean isClosedForWrite();

    void setWriteByteOrder(ByteOrder byteOrder);

    Object write(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation);

    int writeAvailable(int min, Function1<? super ByteBuffer, Unit> block);

    Object writeAvailable(IoBuffer ioBuffer, Continuation<? super Integer> continuation);

    Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation);

    Object writeAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation);

    Object writeByte(byte b, Continuation<? super Unit> continuation);

    Object writeDouble(double d, Continuation<? super Unit> continuation);

    Object writeFloat(float f, Continuation<? super Unit> continuation);

    Object writeFully(Buffer buffer, Continuation<? super Unit> continuation);

    Object writeFully(IoBuffer ioBuffer, Continuation<? super Unit> continuation);

    Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation);

    Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation);

    /* JADX INFO: renamed from: writeFully-rGWNHyQ */
    Object mo6941writeFullyrGWNHyQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation);

    Object writeInt(int i, Continuation<? super Unit> continuation);

    Object writeLong(long j, Continuation<? super Unit> continuation);

    Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation);

    Object writeShort(short s, Continuation<? super Unit> continuation);

    @Deprecated(message = "Use write { } instead.")
    @ExperimentalIoApi
    Object writeSuspendSession(Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    Object writeWhile(Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: ByteWriteChannel.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
        public static /* synthetic */ void getWriteByteOrder$annotations() {
        }

        public static /* synthetic */ int writeAvailable$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeAvailable");
            }
            if ((i2 & 1) != 0) {
                i = 1;
            }
            return byteWriteChannel.writeAvailable(i, (Function1<? super ByteBuffer, Unit>) function1);
        }

        public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
            }
            if ((i2 & 1) != 0) {
                i = 1;
            }
            return byteWriteChannel.write(i, function1, continuation);
        }
    }
}
