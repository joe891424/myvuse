package io.ktor.utils.p098io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.core.ByteOrder;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import io.ktor.utils.p098io.core.IoBuffer;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ByteReadChannelJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 l2\u00020\u0001:\u0001lJ\u0011\u0010\u001a\u001a\u00020\u001bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H&JM\u0010\u001f\u001a\u00020\u001b2:\u0010 \u001a6\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b0!j\u0002`'H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H¦@ø\u0001\u0000¢\u0006\u0002\u0010+J,\u0010,\u001a\u0002H-\"\u0004\b\u0000\u0010-2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002H-0.¢\u0006\u0002\b0H'¢\u0006\u0002\u00101J@\u00102\u001a\u0002H-\"\u0004\b\u0000\u0010-2'\u0010 \u001a#\b\u0001\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-04\u0012\u0006\u0012\u0004\u0018\u00010\u00010!¢\u0006\u0002\b0H§@ø\u0001\u0000¢\u0006\u0002\u0010(JD\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00172\b\b\u0002\u00109\u001a\u00020\u00172\b\b\u0002\u0010:\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u0017H¦@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<J/\u0010=\u001a\u00020\u001b2\b\b\u0002\u0010:\u001a\u00020\u00032\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0.H¦@ø\u0001\u0000¢\u0006\u0002\u0010?J\u0019\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BH¦@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0019\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\"H¦@ø\u0001\u0000¢\u0006\u0002\u0010DJ)\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020E2\u0006\u00109\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010GJ&\u0010@\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020\u00032\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0.H&J\u0011\u0010I\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0011\u0010J\u001a\u00020KH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0011\u0010L\u001a\u00020MH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0011\u0010N\u001a\u00020OH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010P\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020B2\u0006\u0010Q\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010RJ\u0019\u0010P\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\"H¦@ø\u0001\u0000¢\u0006\u0002\u0010DJ)\u0010P\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020E2\u0006\u00109\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010GJ\u0011\u0010S\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0011\u0010T\u001a\u00020\u0017H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010YJ!\u0010Z\u001a\u00020V2\u0006\u0010[\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\\J!\u0010]\u001a\u00020\u001b2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020\u001b0.¢\u0006\u0002\b0H'J\u0011\u0010_\u001a\u00020`H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ:\u0010a\u001a\u00020\u001b2'\u0010>\u001a#\b\u0001\u0012\u0004\u0012\u00020b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b04\u0012\u0006\u0012\u0004\u0018\u00010\u00010!¢\u0006\u0002\b0H§@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010[\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010eJ/\u0010f\u001a\u00020\u000b\"\f\b\u0000\u0010g*\u00060hj\u0002`i2\u0006\u0010j\u001a\u0002Hg2\u0006\u0010[\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010kR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\"\u0010\u000e\u001a\u00020\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, m5598d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "availableForRead", "", "getAvailableForRead", "()I", "closedCause", "", "getClosedCause", "()Ljava/lang/Throwable;", "isClosedForRead", "", "()Z", "isClosedForWrite", "readByteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "getReadByteOrder$annotations", "()V", "getReadByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setReadByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "totalBytesRead", "", "getTotalBytesRead", "()J", "awaitContent", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", HexAttribute.HEX_ATTR_CAUSE, "consumeEachBufferRange", "visitor", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "last", "Lio/ktor/utils/io/ConsumeEachBufferVisitor;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discard", "max", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookAhead", "R", "Lkotlin/Function1;", "Lio/ktor/utils/io/LookAheadSession;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "lookAheadSuspend", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "peekTo", FirebaseAnalytics.Param.DESTINATION, "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", TypedValues.CycleType.S_WAVE_OFFSET, "min", "peekTo-vHUFkk8", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "consumer", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", C4352k.a.f5652f, "Lio/ktor/utils/io/core/IoBuffer;", "(Lio/ktor/utils/io/core/IoBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "length", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "readBoolean", "readByte", "", "readDouble", "", "readFloat", "", "readFully", RsaJsonWebKey.MODULUS_MEMBER_NAME, "(Lio/ktor/utils/io/core/IoBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readInt", "readLong", "readPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "size", "headerSizeHint", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRemaining", "limit", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readSession", "Lio/ktor/utils/io/ReadSession;", "readShort", "", "readSuspendableSession", "Lio/ktor/utils/io/SuspendableReadSession;", "readUTF8Line", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readUTF8LineTo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface ByteReadChannel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannel$consumeEachBufferRange$1 */
    /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteReadChannel$DefaultImpls", m5608f = "ByteReadChannelJVM.kt", m5609i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2}, m5610l = {383, 396, 399}, m5611m = "consumeEachBufferRange", m5612n = {"visitor", "$this$consumeEachBufferRange$iv", "continueFlag$iv", "lastChunkReported$iv", "$this$read_u24default$iv$iv", "visitor", "$this$consumeEachBufferRange$iv", "continueFlag$iv", "lastChunkReported$iv", "$this$read_u24default$iv$iv", "buffer$iv$iv", "bytesRead$iv$iv", "cause$iv$iv"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0"})
    static final class C53061 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C53061(Continuation<? super C53061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.consumeEachBufferRange(null, null, this);
        }
    }

    Object awaitContent(Continuation<? super Unit> continuation);

    boolean cancel(Throwable cause);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ Object consumeEachBufferRange(Function2 function2, Continuation continuation);

    Object discard(long j, Continuation<? super Long> continuation);

    int getAvailableForRead();

    Throwable getClosedCause();

    ByteOrder getReadByteOrder();

    long getTotalBytesRead();

    boolean isClosedForRead();

    boolean isClosedForWrite();

    @Deprecated(message = "Use read { } instead.")
    <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> visitor);

    @Deprecated(message = "Use read { } instead.")
    <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation);

    /* JADX INFO: renamed from: peekTo-vHUFkk8 */
    Object mo6940peekTovHUFkk8(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation<? super Long> continuation);

    Object read(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation);

    int readAvailable(int min, Function1<? super ByteBuffer, Unit> block);

    Object readAvailable(IoBuffer ioBuffer, Continuation<? super Integer> continuation);

    Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation);

    Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation);

    Object readBoolean(Continuation<? super Boolean> continuation);

    Object readByte(Continuation<? super Byte> continuation);

    Object readDouble(Continuation<? super Double> continuation);

    Object readFloat(Continuation<? super Float> continuation);

    Object readFully(IoBuffer ioBuffer, int i, Continuation<? super Unit> continuation);

    Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation);

    Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation);

    Object readInt(Continuation<? super Integer> continuation);

    Object readLong(Continuation<? super Long> continuation);

    Object readPacket(int i, int i2, Continuation<? super ByteReadPacket> continuation);

    Object readRemaining(long j, int i, Continuation<? super ByteReadPacket> continuation);

    @Deprecated(message = "Use read { } instead.")
    @ExperimentalIoApi
    void readSession(Function1<? super ReadSession, Unit> consumer);

    Object readShort(Continuation<? super Short> continuation);

    @Deprecated(message = "Use read { } instead.")
    @ExperimentalIoApi
    Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    Object readUTF8Line(int i, Continuation<? super String> continuation);

    <A extends Appendable> Object readUTF8LineTo(A a2, int i, Continuation<? super Boolean> continuation);

    void setReadByteOrder(ByteOrder byteOrder);

    /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
        public static /* synthetic */ void getReadByteOrder$annotations() {
        }

        public static /* synthetic */ int readAvailable$default(ByteReadChannel byteReadChannel, int i, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAvailable");
            }
            if ((i2 & 1) != 0) {
                i = 1;
            }
            return byteReadChannel.readAvailable(i, (Function1<? super ByteBuffer, Unit>) function1);
        }

        /* JADX WARN: Path cross not found for [B:37:0x00ed, B:40:0x00f5], limit reached: 65 */
        /* JADX WARN: Path cross not found for [B:40:0x00f5, B:37:0x00ed], limit reached: 65 */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00d7 A[Catch: all -> 0x013e, TryCatch #1 {all -> 0x013e, blocks: (B:31:0x00c5, B:33:0x00d7, B:35:0x00e3, B:37:0x00ed, B:41:0x00f6, B:34:0x00dd), top: B:63:0x00c5 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00dd A[Catch: all -> 0x013e, TryCatch #1 {all -> 0x013e, blocks: (B:31:0x00c5, B:33:0x00d7, B:35:0x00e3, B:37:0x00ed, B:41:0x00f6, B:34:0x00dd), top: B:63:0x00c5 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ed A[Catch: all -> 0x013e, TryCatch #1 {all -> 0x013e, blocks: (B:31:0x00c5, B:33:0x00d7, B:35:0x00e3, B:37:0x00ed, B:41:0x00f6, B:34:0x00dd), top: B:63:0x00c5 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0124 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0157 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0125 -> B:45:0x0128). Please report as a decompilation issue!!! */
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static /* synthetic */ java.lang.Object consumeEachBufferRange(io.ktor.utils.p098io.ByteReadChannel r18, kotlin.jvm.functions.Function2 r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannel.DefaultImpls.consumeEachBufferRange(io.ktor.utils.io.ByteReadChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static /* synthetic */ Object read$default(ByteReadChannel byteReadChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: read");
            }
            if ((i2 & 1) != 0) {
                i = 1;
            }
            return byteReadChannel.read(i, function1, continuation);
        }

        /* JADX INFO: renamed from: peekTo-vHUFkk8$default, reason: not valid java name */
        public static /* synthetic */ Object m6943peekTovHUFkk8$default(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return byteReadChannel.mo6940peekTovHUFkk8(byteBuffer, j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? 1L : j3, (i & 16) != 0 ? Long.MAX_VALUE : j4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: peekTo-vHUFkk8");
        }
    }

    /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m5598d2 = {"Lio/ktor/utils/io/ByteReadChannel$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/ByteReadChannel;", "getEmpty", "()Lio/ktor/utils/io/ByteReadChannel;", "Empty$delegate", "Lkotlin/Lazy;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: Empty$delegate, reason: from kotlin metadata */
        private static final Lazy<ByteChannel> Empty = LazyKt.lazy(new Function0<ByteChannel>() { // from class: io.ktor.utils.io.ByteReadChannel$Companion$Empty$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ByteChannel invoke() {
                ByteChannel byteChannelByteChannel$default = ByteChannelKt.ByteChannel$default(false, 1, null);
                ByteWriteChannelKt.close(byteChannelByteChannel$default);
                return byteChannelByteChannel$default;
            }
        });

        private Companion() {
        }

        public final ByteReadChannel getEmpty() {
            return Empty.getValue();
        }
    }
}
