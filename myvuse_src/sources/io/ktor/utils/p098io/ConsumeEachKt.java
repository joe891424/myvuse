package io.ktor.utils.p098io;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: compiled from: ConsumeEach.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022:\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\u000bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\f*j\u0010\r\"2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u000422\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m5598d2 = {"consumeEachBufferRange", "", "Lio/ktor/utils/io/ByteReadChannel;", "visitor", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "", "last", "Lio/ktor/utils/io/ConsumeEachBufferVisitor;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ConsumeEachBufferVisitor", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ConsumeEachKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ConsumeEachKt$consumeEachBufferRange$1 */
    /* JADX INFO: compiled from: ConsumeEach.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ConsumeEachKt", m5608f = "ConsumeEach.kt", m5609i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2}, m5610l = {46, 50, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m5611m = "consumeEachBufferRange", m5612n = {"$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "buffer$iv", "bytesRead$iv", "cause$iv"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0"})
    static final class C53221 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C53221(Continuation<? super C53221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConsumeEachKt.consumeEachBufferRange(null, null, this);
        }
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object consumeEachBufferRange(io.ktor.utils.p098io.ByteReadChannel r18, kotlin.jvm.functions.Function2<? super java.nio.ByteBuffer, ? super java.lang.Boolean, java.lang.Boolean> r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ConsumeEachKt.consumeEachBufferRange(io.ktor.utils.io.ByteReadChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object consumeEachBufferRange$$forInline(ByteReadChannel byteReadChannel, Function2<? super ByteBuffer, ? super Boolean, Boolean> function2, Continuation<? super Unit> continuation) {
        ByteBuffer byteBufferM6967getEmptySK3TCg8;
        boolean zBooleanValue;
        do {
            InlineMarker.mark(0);
            Object objRequestBuffer = ReadSessionKt.requestBuffer(byteReadChannel, 1, continuation);
            InlineMarker.mark(1);
            Buffer empty = (Buffer) objRequestBuffer;
            if (empty == null) {
                empty = Buffer.INSTANCE.getEmpty();
            }
            try {
                ByteBuffer memory = empty.getMemory();
                long readPosition = empty.getReadPosition();
                long writePosition = empty.getWritePosition();
                if (writePosition > readPosition) {
                    byteBufferM6967getEmptySK3TCg8 = Memory.m6962sliceSK3TCg8(memory, readPosition, writePosition - readPosition);
                } else {
                    byteBufferM6967getEmptySK3TCg8 = Memory.INSTANCE.m6967getEmptySK3TCg8();
                }
                boolean z = byteBufferM6967getEmptySK3TCg8.remaining() == byteReadChannel.getAvailableForRead() && byteReadChannel.isClosedForWrite();
                zBooleanValue = function2.invoke(byteBufferM6967getEmptySK3TCg8, Boolean.valueOf(z)).booleanValue();
                int iPosition = byteBufferM6967getEmptySK3TCg8.position();
                InlineMarker.mark(0);
                ReadSessionKt.completeReadingFromBuffer(byteReadChannel, empty, iPosition, continuation);
                InlineMarker.mark(1);
                if (z && byteReadChannel.isClosedForRead()) {
                    break;
                }
            } catch (Throwable th) {
                InlineMarker.mark(0);
                ReadSessionKt.completeReadingFromBuffer(byteReadChannel, empty, 0, continuation);
                InlineMarker.mark(1);
                throw th;
            }
        } while (zBooleanValue);
        return Unit.INSTANCE;
    }
}
