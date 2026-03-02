package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.Input;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.p098io.core.internal.RequireFailureCapture;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DebugKt;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: AbstractInput.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "AbstractInput is deprecated and will be merged with Input in 2.0.0", replaceWith = @ReplaceWith(expression = "Input", imports = {}))
@Metadata(m5597d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b'\u0018\u0000 ¬\u00012\u00020\u0001:\u0002¬\u0001B+\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010I\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\bH\u0002J\u0015\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\bH\u0000¢\u0006\u0002\bMJ\u0010\u0010N\u001a\u00020J2\u0006\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\"H\u0002J\u0006\u0010S\u001a\u00020\u001bJ\u0006\u0010T\u001a\u00020JJ\b\u0010U\u001a\u00020JH$J\u000e\u0010V\u001a\u00020\"2\u0006\u0010W\u001a\u00020\"J\u000e\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0005J\u0018\u0010X\u001a\u00020\"2\u0006\u0010W\u001a\u00020\"2\u0006\u0010Y\u001a\u00020\"H\u0002J\u0019\u0010X\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005H\u0082\u0010J\u000e\u0010Z\u001a\u00020J2\u0006\u0010W\u001a\u00020\"J\n\u0010[\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\\\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u0005H\u0002J\u0012\u0010]\u001a\u0004\u0018\u00010\b2\u0006\u0010^\u001a\u00020\bH\u0001J\u001b\u0010]\u001a\u0004\u0018\u00010\b2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\bH\u0082\u0010J\u0012\u0010`\u001a\u0004\u0018\u00010\b2\u0006\u0010^\u001a\u00020\bH\u0007J\n\u0010a\u001a\u0004\u0018\u00010\bH\u0014J*\u0010a\u001a\u00020\"2\u0006\u0010b\u001a\u00020)2\u0006\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u00020\"H$ø\u0001\u0000¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020J2\u0006\u0010^\u001a\u00020\bH\u0007J\u0010\u0010h\u001a\u00020J2\u0006\u0010^\u001a\u00020\bH\u0002J \u0010i\u001a\u00020J2\u0006\u0010^\u001a\u00020\b2\u0006\u0010j\u001a\u00020\"2\u0006\u0010k\u001a\u00020\"H\u0002J\u000e\u0010l\u001a\u00020\u001b2\u0006\u0010W\u001a\u00020\"J\b\u0010m\u001a\u00020JH\u0004J\u0018\u0010n\u001a\u00020Q2\u0006\u0010R\u001a\u00020\"2\u0006\u0010o\u001a\u00020\"H\u0002J\u0010\u0010p\u001a\u00020Q2\u0006\u0010q\u001a\u00020\"H\u0002J\u0010\u0010r\u001a\u00020Q2\u0006\u0010W\u001a\u00020\"H\u0002J8\u0010s\u001a\u00020\u00052\u0006\u0010b\u001a\u00020)2\u0006\u0010t\u001a\u00020\u00052\u0006\u0010c\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0006\u0010o\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ\u0010\u0010s\u001a\u00020\"2\u0006\u0010w\u001a\u00020\u0003H\u0007J\u0015\u0010x\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u0005H\u0000¢\u0006\u0002\byJ\u0018\u0010z\u001a\u00020Q2\u0006\u0010R\u001a\u00020\"2\u0006\u0010{\u001a\u00020\"H\u0002J\u0012\u0010|\u001a\u0004\u0018\u00010\b2\u0006\u0010q\u001a\u00020\"H\u0001J\u001a\u0010|\u001a\u0004\u0018\u00010\b2\u0006\u0010q\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\bH\u0001J\u0012\u0010}\u001a\u0004\u0018\u00010\b2\u0006\u0010q\u001a\u00020\"H\u0007J\u001b\u0010~\u001a\u0004\u0018\u00010\b2\u0006\u0010q\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\bH\u0082\u0010J#\u0010\u007f\u001a\u00020J2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020J0\u0081\u0001H\u0081\bø\u0001\u0002J+\u0010\u007f\u001a\u00020J2\u0006\u0010W\u001a\u00020\"2\u0015\u0010\u0080\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0004\u0012\u00020J0\u0081\u0001H\u0081\bø\u0001\u0002J(\u0010\u0083\u0001\u001a\u00020\"2\r\u0010\u0084\u0001\u001a\b0\u0085\u0001j\u0003`\u0086\u00012\u0006\u0010R\u001a\u00020\"2\u0006\u0010o\u001a\u00020\"H\u0002J,\u0010\u0087\u0001\u001a\u00020\"2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u00020\"2\u0006\u0010{\u001a\u00020\"H\u0082\u0010J*\u0010\u008a\u0001\u001a\u00020\"2\u0007\u0010b\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020\"2\u0007\u0010\u008d\u0001\u001a\u00020\"H\u0000¢\u0006\u0003\b\u008e\u0001J\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\n\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0007J\n\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0007J#\u0010\u0096\u0001\u001a\u00020J2\b\u0010\u0097\u0001\u001a\u00030\u0089\u00012\u0006\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u00020\"H\u0007J\t\u0010\u0098\u0001\u001a\u00020\"H\u0007J\t\u0010\u0099\u0001\u001a\u00020\u0005H\u0007J\n\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0007J\u001c\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\b\u0002\u0010R\u001a\u00020\"2\b\b\u0002\u0010o\u001a\u00020\"J*\u0010\u009c\u0001\u001a\u00020\"2\r\u0010\u0084\u0001\u001a\b0\u0085\u0001j\u0003`\u0086\u00012\b\b\u0002\u0010R\u001a\u00020\"2\b\b\u0002\u0010o\u001a\u00020\"J\u0011\u0010\u009e\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009f\u0001\u001a\u00020\"J\u001f\u0010\u009e\u0001\u001a\u00020J2\r\u0010\u0084\u0001\u001a\b0\u0085\u0001j\u0003`\u0086\u00012\u0007\u0010\u009f\u0001\u001a\u00020\"J(\u0010 \u0001\u001a\u00020\"2\r\u0010\u0084\u0001\u001a\b0\u0085\u0001j\u0003`\u0086\u00012\u0006\u0010R\u001a\u00020\"2\u0006\u0010o\u001a\u00020\"H\u0002J\u0007\u0010¡\u0001\u001a\u00020JJ\u0017\u0010¢\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0000¢\u0006\u0003\b£\u0001J\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0003\b¥\u0001J\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0003\b§\u0001J\u0007\u0010¨\u0001\u001a\u00020\"J\u0017\u0010©\u0001\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020\bH\u0000¢\u0006\u0003\bª\u0001J\u0011\u0010«\u0001\u001a\u00020J2\u0006\u0010\u0004\u001a\u00020\"H\u0007R$\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR*\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8@@AX\u0081\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R*\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8@@@X\u0081\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u0010*\u001a\u00020)2\u0006\u0010!\u001a\u00020)8@@@X\u0081\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\u0012\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R*\u00100\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"8@@@X\u0081\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\u0015\u001a\u0004\b2\u0010&\"\u0004\b3\u0010(R+\u00105\u001a\u00020\"2\u0006\u00104\u001a\u00020\"8À\u0002@AX\u0081\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\u0015\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R\u001a\u00109\u001a\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0015\u001a\u0004\b9\u0010\u001dR\u001a\u0010;\u001a\u00020\u001b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0015\u001a\u0004\b;\u0010\u001dR\u000e\u0010=\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010E\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00058B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bF\u0010A\"\u0004\bG\u0010H\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u00ad\u0001"}, m5598d2 = {"Lio/ktor/utils/io/core/AbstractInput;", "Lio/ktor/utils/io/core/Input;", "head", "Lio/ktor/utils/io/core/IoBuffer;", "remaining", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/core/IoBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "newHead", "_head", "get_head", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "set_head", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "newOrder", "Lio/ktor/utils/io/core/ByteOrder;", "byteOrder", "getByteOrder$annotations", "()V", "getByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "endOfInput", "", "getEndOfInput", "()Z", "getHead$annotations", "getHead", "setHead", "value", "", "headEndExclusive", "getHeadEndExclusive$annotations", "getHeadEndExclusive", "()I", "setHeadEndExclusive", "(I)V", "Lio/ktor/utils/io/bits/Memory;", "headMemory", "getHeadMemory-SK3TCg8$annotations", "getHeadMemory-SK3TCg8", "()Ljava/nio/ByteBuffer;", "setHeadMemory-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "headPosition", "getHeadPosition$annotations", "getHeadPosition", "setHeadPosition", "newRemaining", "headRemaining", "getHeadRemaining$annotations", "getHeadRemaining", "setHeadRemaining", "isEmpty", "isEmpty$annotations", "isNotEmpty", "isNotEmpty$annotations", "noMoreChunksAvailable", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "getRemaining", "()J", "state", "Lio/ktor/utils/io/core/AbstractInputSharedState;", "newValue", "tailRemaining", "getTailRemaining", "setTailRemaining", "(J)V", "afterRead", "", "append", "chain", "append$ktor_io", "appendView", "chunk", "atLeastMinCharactersRequire", "", "min", "canRead", "close", "closeSource", "discard", RsaJsonWebKey.MODULUS_MEMBER_NAME, "discardAsMuchAsPossible", "skipped", "discardExact", "doFill", "doPrefetch", "ensureNext", "current", "empty", "ensureNextHead", "fill", FirebaseAnalytics.Param.DESTINATION, TypedValues.CycleType.S_WAVE_OFFSET, "length", "fill-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)I", "fixGapAfterRead", "fixGapAfterReadFallback", "fixGapAfterReadFallbackUnreserved", "size", "overrun", "hasBytes", "markNoMoreChunksAvailable", "minShouldBeLess", "max", "minSizeIsTooBig", "minSize", "notEnoughBytesAvailable", "peekTo", "destinationOffset", "peekTo-1dgeIsk", "(Ljava/nio/ByteBuffer;JJJJ)J", "buffer", "prefetch", "prefetch$ktor_io", "prematureEndOfStreamChars", "copied", "prepareRead", "prepareReadHead", "prepareReadLoop", "read", "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "readASCII", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readAsMuchAsPossible", "array", "", "readAvailableCharacters", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "readAvailableCharacters$ktor_io", "readByte", "", "readByteSlow", "readDouble", "", "readFloat", "", "readFully", C4352k.a.f5652f, "readInt", "readLong", "readShort", "", "readText", "", "readTextExact", "exactCharacters", "readUtf8", "release", "releaseHead", "releaseHead$ktor_io", "steal", "steal$ktor_io", "stealAll", "stealAll$ktor_io", "tryPeek", "tryWriteAppend", "tryWriteAppend$ktor_io", "updateHeadRemaining", "Companion", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public abstract class AbstractInput implements Input {
    private boolean noMoreChunksAvailable;
    private final ObjectPool<ChunkBuffer> pool;
    private final AbstractInputSharedState state;

    public AbstractInput() {
        this((ChunkBuffer) null, 0L, (ObjectPool) null, 7, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Not supported anymore. All operations are big endian by default.")
    public static /* synthetic */ void getByteOrder$annotations() {
    }

    public static /* synthetic */ void getHead$annotations() {
    }

    public static /* synthetic */ void getHeadEndExclusive$annotations() {
    }

    /* JADX INFO: renamed from: getHeadMemory-SK3TCg8$annotations, reason: not valid java name */
    public static /* synthetic */ void m7097getHeadMemorySK3TCg8$annotations() {
    }

    public static /* synthetic */ void getHeadPosition$annotations() {
    }

    public static /* synthetic */ void getHeadRemaining$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static /* synthetic */ void isEmpty$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public static /* synthetic */ void isNotEmpty$annotations() {
    }

    protected abstract void closeSource();

    /* JADX INFO: renamed from: fill-5Mw_xsg, reason: not valid java name */
    protected abstract int mo7098fill5Mw_xsg(ByteBuffer destination, int offset, int length);

    public AbstractInput(ChunkBuffer head, long j, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.pool = pool;
        this.state = new AbstractInputSharedState(head, j);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int readAvailable(IoBuffer ioBuffer, int i) {
        return Input.DefaultImpls.readAvailable(this, ioBuffer, i);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int readAvailable(ByteBuffer byteBuffer, int i) {
        return Input.DefaultImpls.readAvailable(this, byteBuffer, i);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int readAvailable(byte[] bArr, int i, int i2) {
        return Input.DefaultImpls.readAvailable((Input) this, bArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int readAvailable(double[] dArr, int i, int i2) {
        return Input.DefaultImpls.readAvailable(this, dArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int readAvailable(float[] fArr, int i, int i2) {
        return Input.DefaultImpls.readAvailable((Input) this, fArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int readAvailable(int[] iArr, int i, int i2) {
        return Input.DefaultImpls.readAvailable((Input) this, iArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int readAvailable(long[] jArr, int i, int i2) {
        return Input.DefaultImpls.readAvailable((Input) this, jArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ int readAvailable(short[] sArr, int i, int i2) {
        return Input.DefaultImpls.readAvailable((Input) this, sArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void readFully(IoBuffer ioBuffer, int i) {
        Input.DefaultImpls.readFully(this, ioBuffer, i);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void readFully(ByteBuffer byteBuffer, int i) {
        Input.DefaultImpls.readFully(this, byteBuffer, i);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void readFully(double[] dArr, int i, int i2) {
        Input.DefaultImpls.readFully(this, dArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void readFully(float[] fArr, int i, int i2) {
        Input.DefaultImpls.readFully((Input) this, fArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void readFully(int[] iArr, int i, int i2) {
        Input.DefaultImpls.readFully((Input) this, iArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void readFully(long[] jArr, int i, int i2) {
        Input.DefaultImpls.readFully((Input) this, jArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void readFully(short[] sArr, int i, int i2) {
        Input.DefaultImpls.readFully((Input) this, sArr, i, i2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AbstractInput(ChunkBuffer chunkBuffer, long j, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        chunkBuffer = (i & 1) != 0 ? ChunkBuffer.INSTANCE.getEmpty() : chunkBuffer;
        this(chunkBuffer, (i & 2) != 0 ? BuffersKt.remainingAll(chunkBuffer) : j, (ObjectPool<ChunkBuffer>) ((i & 4) != 0 ? ChunkBuffer.INSTANCE.getPool() : objectPool));
    }

    public final ObjectPool<ChunkBuffer> getPool() {
        return this.pool;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AbstractInput(IoBuffer ioBuffer, long j, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ioBuffer = (i & 1) != 0 ? IoBuffer.INSTANCE.getEmpty() : ioBuffer;
        this(ioBuffer, (i & 2) != 0 ? BuffersKt.remainingAll((ChunkBuffer) ioBuffer) : j, (i & 4) != 0 ? ChunkBuffer.INSTANCE.getPool() : objectPool);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ AbstractInput(IoBuffer head, long j, ObjectPool pool) {
        this((ChunkBuffer) head, j, (ObjectPool<ChunkBuffer>) pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    private final ChunkBuffer get_head() {
        return this.state.getHead();
    }

    private final void set_head(ChunkBuffer chunkBuffer) {
        this.state.setHead(chunkBuffer);
        this.state.m7103setHeadMemory3GNKZMM(chunkBuffer.getMemory());
        this.state.setHeadPosition(chunkBuffer.getReadPosition());
        this.state.setHeadEndExclusive(chunkBuffer.getWritePosition());
    }

    public final ChunkBuffer getHead() {
        ChunkBuffer chunkBuffer = get_head();
        chunkBuffer.discardUntilIndex$ktor_io(getHeadPosition());
        return chunkBuffer;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Binary compatibility.")
    public final void setHead(ChunkBuffer newHead) {
        Intrinsics.checkNotNullParameter(newHead, "newHead");
        set_head(newHead);
    }

    /* JADX INFO: renamed from: getHeadMemory-SK3TCg8, reason: not valid java name */
    public final ByteBuffer m7099getHeadMemorySK3TCg8() {
        return this.state.getHeadMemory();
    }

    /* JADX INFO: renamed from: setHeadMemory-3GNKZMM, reason: not valid java name */
    public final void m7101setHeadMemory3GNKZMM(ByteBuffer value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state.m7103setHeadMemory3GNKZMM(value);
    }

    public final int getHeadPosition() {
        return this.state.getHeadPosition();
    }

    public final void setHeadPosition(int i) {
        this.state.setHeadPosition(i);
    }

    public final int getHeadEndExclusive() {
        return this.state.getHeadEndExclusive();
    }

    public final void setHeadEndExclusive(int i) {
        this.state.setHeadEndExclusive(i);
    }

    public final int getHeadRemaining() {
        return getHeadEndExclusive() - getHeadPosition();
    }

    private final long getTailRemaining() {
        return this.state.getTailRemaining();
    }

    private final void setTailRemaining(final long j) {
        if (j >= 0) {
            this.state.setTailRemaining(j);
        } else {
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.AbstractInput$special$$inlined$require$1
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("tailRemaining shouldn't be negative: ", Long.valueOf(j)));
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
    }

    @Override // io.ktor.utils.p098io.core.Input
    public final ByteOrder getByteOrder() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.ktor.utils.p098io.core.Input
    public final void setByteOrder(ByteOrder newOrder) {
        Intrinsics.checkNotNullParameter(newOrder, "newOrder");
        if (newOrder != ByteOrder.BIG_ENDIAN) {
            throw new IllegalArgumentException("Only BIG_ENDIAN is supported.");
        }
    }

    @Override // io.ktor.utils.p098io.core.Input
    /* JADX INFO: renamed from: peekTo-1dgeIsk, reason: not valid java name */
    public final long mo7100peekTo1dgeIsk(ByteBuffer destination, long destinationOffset, long offset, long min, long max) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        prefetch$ktor_io(min + offset);
        ChunkBuffer head = getHead();
        long jMin = Math.min(max, ((long) destination.limit()) - destinationOffset);
        long j = destinationOffset;
        ChunkBuffer next = head;
        long j2 = 0;
        long j3 = offset;
        while (j2 < min && j2 < jMin) {
            ChunkBuffer chunkBuffer = next;
            long writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
            if (writePosition > j3) {
                long jMin2 = Math.min(writePosition - j3, jMin - j2);
                Memory.m6953copyToiAfECsU(next.getMemory(), destination, ((long) next.getReadPosition()) + j3, jMin2, j);
                j2 += jMin2;
                j += jMin2;
                j3 = 0;
            } else {
                j3 -= writePosition;
            }
            next = next.getNext();
            if (next == null) {
                break;
            }
        }
        return j2;
    }

    private final boolean doPrefetch(long min) {
        ChunkBuffer chunkBufferFindTail = BuffersKt.findTail(get_head());
        long headEndExclusive = ((long) (getHeadEndExclusive() - getHeadPosition())) + getTailRemaining();
        do {
            ChunkBuffer chunkBufferFill = fill();
            if (chunkBufferFill == null) {
                this.noMoreChunksAvailable = true;
                return false;
            }
            ChunkBuffer chunkBuffer = chunkBufferFill;
            int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
            if (chunkBufferFindTail == ChunkBuffer.INSTANCE.getEmpty()) {
                set_head(chunkBufferFill);
                chunkBufferFindTail = chunkBufferFill;
            } else {
                chunkBufferFindTail.setNext(chunkBufferFill);
                setTailRemaining(getTailRemaining() + ((long) writePosition));
            }
            headEndExclusive += (long) writePosition;
        } while (headEndExclusive < min);
        return true;
    }

    public final boolean canRead() {
        return (getHeadPosition() == getHeadEndExclusive() && getTailRemaining() == 0) ? false : true;
    }

    public final /* synthetic */ boolean isNotEmpty() {
        return PacketKt.isNotEmpty(this);
    }

    public final void release() {
        ChunkBuffer head = getHead();
        ChunkBuffer empty = ChunkBuffer.INSTANCE.getEmpty();
        if (head != empty) {
            set_head(empty);
            setTailRemaining(0L);
            BuffersKt.releaseAll(head, this.pool);
        }
    }

    @Override // io.ktor.utils.p098io.core.Input, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        release();
        if (!this.noMoreChunksAvailable) {
            this.noMoreChunksAvailable = true;
        }
        closeSource();
    }

    public final ChunkBuffer stealAll$ktor_io() {
        ChunkBuffer head = getHead();
        ChunkBuffer empty = ChunkBuffer.INSTANCE.getEmpty();
        if (head == empty) {
            return null;
        }
        set_head(empty);
        setTailRemaining(0L);
        return head;
    }

    public final ChunkBuffer steal$ktor_io() {
        ChunkBuffer head = getHead();
        ChunkBuffer next = head.getNext();
        ChunkBuffer empty = ChunkBuffer.INSTANCE.getEmpty();
        if (head == empty) {
            return null;
        }
        if (next == null) {
            set_head(empty);
            setTailRemaining(0L);
        } else {
            set_head(next);
            ChunkBuffer chunkBuffer = next;
            setTailRemaining(getTailRemaining() - ((long) (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition())));
        }
        head.setNext(null);
        return head;
    }

    public final void append$ktor_io(ChunkBuffer chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (chain == ChunkBuffer.INSTANCE.getEmpty()) {
            return;
        }
        long jRemainingAll = BuffersKt.remainingAll(chain);
        if (get_head() == ChunkBuffer.INSTANCE.getEmpty()) {
            set_head(chain);
            setTailRemaining(jRemainingAll - ((long) (getHeadEndExclusive() - getHeadPosition())));
        } else {
            BuffersKt.findTail(get_head()).setNext(chain);
            setTailRemaining(getTailRemaining() + jRemainingAll);
        }
    }

    public final boolean tryWriteAppend$ktor_io(ChunkBuffer chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        ChunkBuffer chunkBufferFindTail = BuffersKt.findTail(getHead());
        ChunkBuffer chunkBuffer = chain;
        int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
        if (writePosition == 0) {
            return false;
        }
        ChunkBuffer chunkBuffer2 = chunkBufferFindTail;
        if (chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition() < writePosition) {
            return false;
        }
        BufferAppendKt.writeBufferAppend(chunkBuffer2, chunkBuffer, writePosition);
        if (getHead() == chunkBufferFindTail) {
            setHeadEndExclusive(chunkBufferFindTail.getWritePosition());
            return true;
        }
        setTailRemaining(getTailRemaining() + ((long) writePosition));
        return true;
    }

    @Override // io.ktor.utils.p098io.core.Input
    public final byte readByte() {
        int headPosition = getHeadPosition();
        int i = headPosition + 1;
        if (i < getHeadEndExclusive()) {
            setHeadPosition(i);
            return m7099getHeadMemorySK3TCg8().get(headPosition);
        }
        return readByteSlow();
    }

    private final byte readByteSlow() throws EOFException {
        int headPosition = getHeadPosition();
        if (headPosition >= getHeadEndExclusive()) {
            ChunkBuffer chunkBufferPrepareRead = prepareRead(1);
            if (chunkBufferPrepareRead == null) {
                StringsKt.prematureEndOfStream(1);
                throw new KotlinNothingValueException();
            }
            byte b = chunkBufferPrepareRead.readByte();
            UnsafeKt.completeReadHead(this, chunkBufferPrepareRead);
            return b;
        }
        byte b2 = m7099getHeadMemorySK3TCg8().get(headPosition);
        setHeadPosition(headPosition);
        ChunkBuffer chunkBuffer = get_head();
        chunkBuffer.discardUntilIndex$ktor_io(headPosition);
        ensureNext(chunkBuffer);
        return b2;
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ short readShort() {
        return InputPrimitivesKt.readShort(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ float readFloat() {
        return InputPrimitivesKt.readFloat(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ double readDouble() {
        return InputPrimitivesKt.readDouble(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ int readInt() {
        return InputPrimitivesKt.readInt(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ long readLong() {
        return InputPrimitivesKt.readLong(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void readFully(byte[] dst, int offset, int length) throws EOFException {
        Intrinsics.checkNotNullParameter(dst, "dst");
        int available = InputArraysKt.readAvailable((Input) this, dst, offset, length);
        if (available != length) {
            throw new EOFException("Not enough data in packet to fill buffer: " + (length - available) + " more bytes required");
        }
    }

    public final int discard(final int n) {
        if (n >= 0) {
            return discardAsMuchAsPossible(n, 0);
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.AbstractInput$discard$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Negative discard is not allowed: ", Integer.valueOf(n)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    public final void discardExact(int n) throws EOFException {
        if (discard(n) != n) {
            throw new EOFException("Unable to discard " + n + " bytes due to end of packet");
        }
    }

    @Override // io.ktor.utils.p098io.core.Input
    public final int tryPeek() {
        ChunkBuffer chunkBufferPrepareReadLoop;
        ChunkBuffer head = getHead();
        if (getHeadEndExclusive() - getHeadPosition() > 0) {
            return head.tryPeekByte();
        }
        if ((getTailRemaining() == 0 && this.noMoreChunksAvailable) || (chunkBufferPrepareReadLoop = prepareReadLoop(1, head)) == null) {
            return -1;
        }
        return chunkBufferPrepareReadLoop.tryPeekByte();
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ int peekTo(IoBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ChunkBuffer chunkBufferPrepareReadHead = prepareReadHead(1);
        if (chunkBufferPrepareReadHead == null) {
            return -1;
        }
        IoBuffer ioBuffer = buffer;
        ChunkBuffer chunkBuffer = chunkBufferPrepareReadHead;
        int iMin = Math.min(ioBuffer.getLimit() - ioBuffer.getWritePosition(), chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
        BufferPrimitivesKt.writeFully(ioBuffer, chunkBuffer, iMin);
        return iMin;
    }

    @Override // io.ktor.utils.p098io.core.Input
    public final long discard(long n) {
        if (n <= 0) {
            return 0L;
        }
        return discardAsMuchAsPossible(n, 0L);
    }

    public final int readAvailableCharacters$ktor_io(final char[] destination, final int off, int len) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (isEmpty()) {
            return -1;
        }
        return readText(new Appendable(off, destination) { // from class: io.ktor.utils.io.core.AbstractInput$readAvailableCharacters$out$1
            final /* synthetic */ char[] $destination;
            final /* synthetic */ int $off;
            private int idx;

            {
                this.$off = off;
                this.$destination = destination;
                this.idx = off;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c) {
                char[] cArr = this.$destination;
                int i = this.idx;
                this.idx = i + 1;
                cArr[i] = c;
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence csq) {
                int length;
                if (csq instanceof String) {
                    String str = (String) csq;
                    StringsJVMKt.getCharsInternal(str, this.$destination, this.idx);
                    this.idx += str.length();
                } else if (csq != null && (length = csq.length()) > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        char[] cArr = this.$destination;
                        int i3 = this.idx;
                        this.idx = i3 + 1;
                        cArr[i3] = csq.charAt(i);
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    }
                }
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence csq, int start, int end) {
                throw new UnsupportedOperationException();
            }
        }, 0, len);
    }

    public static /* synthetic */ int readText$default(AbstractInput abstractInput, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return abstractInput.readText(appendable, i, i2);
    }

    public final int readText(Appendable out, int min, int max) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        if (max >= getRemaining()) {
            String textExactBytes$default = StringsKt.readTextExactBytes$default(this, (int) getRemaining(), (Charset) null, 2, (Object) null);
            out.append(textExactBytes$default);
            return textExactBytes$default.length();
        }
        return readASCII(out, min, max);
    }

    public final void readTextExact(Appendable out, int exactCharacters) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        readText(out, exactCharacters, exactCharacters);
    }

    public static /* synthetic */ String readText$default(AbstractInput abstractInput, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return abstractInput.readText(i, i2);
    }

    public final String readText(int min, int max) throws Throwable {
        if (min == 0 && (max == 0 || isEmpty())) {
            return "";
        }
        long remaining = getRemaining();
        if (remaining > 0 && max >= remaining) {
            return StringsKt.readTextExactBytes$default(this, (int) remaining, (Charset) null, 2, (Object) null);
        }
        StringBuilder sb = new StringBuilder(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(min, 16), max));
        readASCII(sb, min, max);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public final String readTextExact(int exactCharacters) {
        return readText(exactCharacters, exactCharacters);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
    
        r10.discardExact(r14 - r12);
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int readASCII(java.lang.Appendable r18, int r19, int r20) throws java.lang.Throwable {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            r4 = 0
            if (r3 != 0) goto Le
            if (r2 != 0) goto Le
            return r4
        Le:
            boolean r5 = r17.isEmpty()
            if (r5 == 0) goto L20
            if (r2 != 0) goto L17
            return r4
        L17:
            r1.atLeastMinCharactersRequire(r2)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L20:
            if (r3 < r2) goto Lb5
            r5 = r1
            io.ktor.utils.io.core.Input r5 = (io.ktor.utils.p098io.core.Input) r5
            r6 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r7 = io.ktor.utils.p098io.core.internal.UnsafeKt.m7223prepareReadFirstHead(r5, r6)
            if (r7 != 0) goto L2f
            r8 = r4
            goto L91
        L2f:
            r8 = r4
            r9 = r8
        L31:
            r10 = r7
            io.ktor.utils.io.core.Buffer r10 = (io.ktor.utils.p098io.core.Buffer) r10     // Catch: java.lang.Throwable -> Lad
            java.nio.ByteBuffer r11 = r10.getMemory()     // Catch: java.lang.Throwable -> Lad
            int r12 = r10.getReadPosition()     // Catch: java.lang.Throwable -> Lad
            int r13 = r10.getWritePosition()     // Catch: java.lang.Throwable -> Lad
            if (r12 >= r13) goto L6f
            r14 = r12
        L43:
            int r15 = r14 + 1
            byte r4 = r11.get(r14)     // Catch: java.lang.Throwable -> Lad
            r6 = r4 & 255(0xff, float:3.57E-43)
            r16 = r9
            r9 = 128(0x80, float:1.8E-43)
            r4 = r4 & r9
            if (r4 == r9) goto L69
            char r4 = (char) r6     // Catch: java.lang.Throwable -> Lad
            if (r8 != r3) goto L57
            r4 = 0
            goto L5d
        L57:
            r0.append(r4)     // Catch: java.lang.Throwable -> Lad
            int r8 = r8 + 1
            r4 = 1
        L5d:
            if (r4 != 0) goto L60
            goto L69
        L60:
            if (r15 < r13) goto L63
            goto L71
        L63:
            r14 = r15
            r9 = r16
            r4 = 0
            r6 = 1
            goto L43
        L69:
            int r14 = r14 - r12
            r10.discardExact(r14)     // Catch: java.lang.Throwable -> Lad
            r4 = 0
            goto L76
        L6f:
            r16 = r9
        L71:
            int r13 = r13 - r12
            r10.discardExact(r13)     // Catch: java.lang.Throwable -> Lad
            r4 = 1
        L76:
            if (r4 == 0) goto L7c
            r9 = r16
            r4 = 1
            goto L84
        L7c:
            if (r8 != r3) goto L82
            r9 = r16
            r4 = 0
            goto L84
        L82:
            r4 = 0
            r9 = 1
        L84:
            if (r4 != 0) goto L8a
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r5, r7)
            goto L90
        L8a:
            io.ktor.utils.io.core.internal.ChunkBuffer r7 = io.ktor.utils.p098io.core.internal.UnsafeKt.prepareReadNextHead(r5, r7)     // Catch: java.lang.Throwable -> Laa
            if (r7 != 0) goto La7
        L90:
            r4 = r9
        L91:
            if (r4 == 0) goto L9b
            int r2 = r2 - r8
            int r3 = r3 - r8
            int r0 = r1.readUtf8(r0, r2, r3)
            int r8 = r8 + r0
            return r8
        L9b:
            if (r8 < r2) goto L9e
            return r8
        L9e:
            r1.prematureEndOfStreamChars(r2, r8)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        La7:
            r4 = 0
            r6 = 1
            goto L31
        Laa:
            r0 = move-exception
            r4 = 0
            goto Laf
        Lad:
            r0 = move-exception
            r4 = 1
        Laf:
            if (r4 == 0) goto Lb4
            io.ktor.utils.p098io.core.internal.UnsafeKt.completeReadHead(r5, r7)
        Lb4:
            throw r0
        Lb5:
            r1.minShouldBeLess(r2, r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.AbstractInput.readASCII(java.lang.Appendable, int, int):int");
    }

    private final Void atLeastMinCharactersRequire(int min) throws EOFException {
        throw new EOFException("at least " + min + " characters required but no bytes available");
    }

    private final Void minShouldBeLess(int min, int max) {
        throw new IllegalArgumentException("min should be less or equal to max but min = " + min + ", max = " + max);
    }

    private final Void prematureEndOfStreamChars(int min, int copied) throws MalformedUTF8InputException {
        throw new MalformedUTF8InputException("Premature end of stream: expected at least " + min + " chars but had only " + copied);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e9, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ee, code lost:
    
        r8.discardExact(((r13 - r11) - r16) + 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0100 A[LOOP:1: B:12:0x003b->B:69:0x0100, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int readUtf8(java.lang.Appendable r21, int r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.core.AbstractInput.readUtf8(java.lang.Appendable, int, int):int");
    }

    private final long discardAsMuchAsPossible(long n, long skipped) {
        ChunkBuffer chunkBufferPrepareRead;
        while (n != 0 && (chunkBufferPrepareRead = prepareRead(1)) != null) {
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            int iMin = (int) Math.min(chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition(), n);
            chunkBufferPrepareRead.discardExact(iMin);
            setHeadPosition(getHeadPosition() + iMin);
            afterRead(chunkBufferPrepareRead);
            long j = iMin;
            n -= j;
            skipped += j;
        }
        return skipped;
    }

    private final int discardAsMuchAsPossible(int n, int skipped) {
        while (n != 0) {
            ChunkBuffer chunkBufferPrepareRead = prepareRead(1);
            if (chunkBufferPrepareRead == null) {
                return skipped;
            }
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            int iMin = Math.min(chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition(), n);
            chunkBufferPrepareRead.discardExact(iMin);
            setHeadPosition(getHeadPosition() + iMin);
            afterRead(chunkBufferPrepareRead);
            n -= iMin;
            skipped += iMin;
        }
        return skipped;
    }

    private final int readAsMuchAsPossible(byte[] array, int offset, int length, int copied) {
        while (length != 0) {
            ChunkBuffer chunkBufferPrepareRead = prepareRead(1);
            if (chunkBufferPrepareRead == null) {
                return copied;
            }
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            int iMin = Math.min(length, chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
            BufferPrimitivesKt.readFully((Buffer) chunkBuffer, array, offset, iMin);
            setHeadPosition(chunkBufferPrepareRead.getReadPosition());
            if (iMin == length && chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() != 0) {
                return copied + iMin;
            }
            afterRead(chunkBufferPrepareRead);
            offset += iMin;
            length -= iMin;
            copied += iMin;
        }
        return copied;
    }

    private final Void notEnoughBytesAvailable(int n) throws EOFException {
        throw new EOFException("Not enough data in packet (" + getRemaining() + ") to read " + n + " byte(s)");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Not supported anymore.")
    /* JADX INFO: renamed from: updateHeadRemaining, reason: merged with bridge method [inline-methods] */
    public final void setHeadRemaining(int remaining) {
        int headEndExclusive = getHeadEndExclusive() - remaining;
        if (headEndExclusive < 0) {
            throw new IllegalArgumentException("Unable to update position to negative. newRemaining is too big.");
        }
        setHeadPosition(headEndExclusive);
    }

    @DangerousInternalIoApi
    public final ChunkBuffer prepareReadHead(int minSize) {
        return prepareReadLoop(minSize, getHead());
    }

    @DangerousInternalIoApi
    public final ChunkBuffer ensureNextHead(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return ensureNext(current);
    }

    public final ChunkBuffer ensureNext(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return ensureNext(current, ChunkBuffer.INSTANCE.getEmpty());
    }

    @DangerousInternalIoApi
    public final void fixGapAfterRead(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        ChunkBuffer next = current.getNext();
        if (next == null) {
            fixGapAfterReadFallback(current);
            return;
        }
        ChunkBuffer chunkBuffer = current;
        int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
        int iMin = Math.min(writePosition, 8 - (chunkBuffer.getCapacity() - chunkBuffer.getLimit()));
        if (next.getStartGap() < iMin) {
            fixGapAfterReadFallback(current);
            return;
        }
        ChunkBuffer chunkBuffer2 = next;
        BufferKt.restoreStartGap(chunkBuffer2, iMin);
        if (writePosition > iMin) {
            current.releaseEndGap$ktor_io();
            setHeadEndExclusive(current.getWritePosition());
            setTailRemaining(getTailRemaining() + ((long) iMin));
        } else {
            set_head(next);
            setTailRemaining(getTailRemaining() - ((long) ((chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition()) - iMin)));
            current.cleanNext();
            current.release(this.pool);
        }
    }

    private final void fixGapAfterReadFallback(ChunkBuffer current) {
        if (this.noMoreChunksAvailable && current.getNext() == null) {
            setHeadPosition(current.getReadPosition());
            setHeadEndExclusive(current.getWritePosition());
            setTailRemaining(0L);
            return;
        }
        ChunkBuffer chunkBuffer = current;
        int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
        int iMin = Math.min(writePosition, 8 - (chunkBuffer.getCapacity() - chunkBuffer.getLimit()));
        if (writePosition > iMin) {
            fixGapAfterReadFallbackUnreserved(current, writePosition, iMin);
        } else {
            ChunkBuffer chunkBufferBorrow = this.pool.borrow();
            chunkBufferBorrow.reserveEndGap(8);
            chunkBufferBorrow.setNext(current.cleanNext());
            BufferAppendKt.writeBufferAppend(chunkBufferBorrow, chunkBuffer, writePosition);
            set_head(chunkBufferBorrow);
        }
        current.release(this.pool);
    }

    private final void fixGapAfterReadFallbackUnreserved(ChunkBuffer current, int size, int overrun) {
        ChunkBuffer chunkBufferBorrow = this.pool.borrow();
        ChunkBuffer chunkBufferBorrow2 = this.pool.borrow();
        chunkBufferBorrow.reserveEndGap(8);
        chunkBufferBorrow2.reserveEndGap(8);
        chunkBufferBorrow.setNext(chunkBufferBorrow2);
        chunkBufferBorrow2.setNext(current.cleanNext());
        ChunkBuffer chunkBuffer = current;
        BufferAppendKt.writeBufferAppend(chunkBufferBorrow, chunkBuffer, size - overrun);
        BufferAppendKt.writeBufferAppend(chunkBufferBorrow2, chunkBuffer, overrun);
        set_head(chunkBufferBorrow);
        setTailRemaining(BuffersKt.remainingAll(chunkBufferBorrow2));
    }

    private final ChunkBuffer ensureNext(ChunkBuffer current, ChunkBuffer empty) {
        while (current != empty) {
            ChunkBuffer chunkBufferCleanNext = current.cleanNext();
            current.release(this.pool);
            if (chunkBufferCleanNext == null) {
                set_head(empty);
                setTailRemaining(0L);
                current = empty;
            } else {
                ChunkBuffer chunkBuffer = chunkBufferCleanNext;
                if (chunkBuffer.getWritePosition() > chunkBuffer.getReadPosition()) {
                    set_head(chunkBufferCleanNext);
                    setTailRemaining(getTailRemaining() - ((long) (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition())));
                    return chunkBufferCleanNext;
                }
                current = chunkBufferCleanNext;
            }
        }
        return doFill();
    }

    protected ChunkBuffer fill() {
        ChunkBuffer chunkBufferBorrow = this.pool.borrow();
        try {
            chunkBufferBorrow.reserveEndGap(8);
            ChunkBuffer chunkBuffer = chunkBufferBorrow;
            int iMo7098fill5Mw_xsg = mo7098fill5Mw_xsg(chunkBufferBorrow.getMemory(), chunkBufferBorrow.getWritePosition(), chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
            if (iMo7098fill5Mw_xsg == 0) {
                this.noMoreChunksAvailable = true;
                ChunkBuffer chunkBuffer2 = chunkBufferBorrow;
                if (chunkBuffer2.getWritePosition() <= chunkBuffer2.getReadPosition()) {
                    chunkBufferBorrow.release(this.pool);
                    return null;
                }
            }
            chunkBufferBorrow.commitWritten(iMo7098fill5Mw_xsg);
            return chunkBufferBorrow;
        } catch (Throwable th) {
            chunkBufferBorrow.release(this.pool);
            throw th;
        }
    }

    protected final void markNoMoreChunksAvailable() {
        if (this.noMoreChunksAvailable) {
            return;
        }
        this.noMoreChunksAvailable = true;
    }

    private final ChunkBuffer doFill() {
        if (this.noMoreChunksAvailable) {
            return null;
        }
        ChunkBuffer chunkBufferFill = fill();
        if (chunkBufferFill == null) {
            this.noMoreChunksAvailable = true;
            return null;
        }
        appendView(chunkBufferFill);
        return chunkBufferFill;
    }

    private final void appendView(ChunkBuffer chunk) {
        ChunkBuffer chunkBufferFindTail = BuffersKt.findTail(get_head());
        if (chunkBufferFindTail == ChunkBuffer.INSTANCE.getEmpty()) {
            set_head(chunk);
            if (getTailRemaining() == 0) {
                ChunkBuffer next = chunk.getNext();
                setTailRemaining(next != null ? BuffersKt.remainingAll(next) : 0L);
                return;
            } else {
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.AbstractInput$appendView$$inlined$require$1
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
        }
        chunkBufferFindTail.setNext(chunk);
        setTailRemaining(getTailRemaining() + BuffersKt.remainingAll(chunk));
    }

    public final ChunkBuffer prepareRead(int minSize) {
        ChunkBuffer head = getHead();
        return getHeadEndExclusive() - getHeadPosition() >= minSize ? head : prepareReadLoop(minSize, head);
    }

    public final ChunkBuffer prepareRead(int minSize, ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        return getHeadEndExclusive() - getHeadPosition() >= minSize ? head : prepareReadLoop(minSize, head);
    }

    private final Void minSizeIsTooBig(int minSize) {
        throw new IllegalStateException("minSize of " + minSize + " is too big (should be less than 8)");
    }

    private final void afterRead(ChunkBuffer head) {
        ChunkBuffer chunkBuffer = head;
        if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() == 0) {
            releaseHead$ktor_io(head);
        }
    }

    public final ChunkBuffer releaseHead$ktor_io(ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        ChunkBuffer chunkBufferCleanNext = head.cleanNext();
        if (chunkBufferCleanNext == null) {
            chunkBufferCleanNext = ChunkBuffer.INSTANCE.getEmpty();
        }
        set_head(chunkBufferCleanNext);
        ChunkBuffer chunkBuffer = chunkBufferCleanNext;
        setTailRemaining(getTailRemaining() - ((long) (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition())));
        head.release(this.pool);
        return chunkBufferCleanNext;
    }

    public final boolean prefetch$ktor_io(long min) {
        if (min <= 0) {
            return true;
        }
        long headEndExclusive = getHeadEndExclusive() - getHeadPosition();
        if (headEndExclusive >= min || headEndExclusive + getTailRemaining() >= min) {
            return true;
        }
        return doPrefetch(min);
    }

    public final long getRemaining() {
        return ((long) (getHeadEndExclusive() - getHeadPosition())) + getTailRemaining();
    }

    public final boolean hasBytes(int n) {
        return ((long) (getHeadEndExclusive() - getHeadPosition())) + getTailRemaining() >= ((long) n);
    }

    @Override // io.ktor.utils.p098io.core.Input
    /* JADX INFO: renamed from: getEndOfInput, reason: merged with bridge method [inline-methods] */
    public final boolean isEmpty() {
        return getHeadEndExclusive() - getHeadPosition() == 0 && getTailRemaining() == 0 && (this.noMoreChunksAvailable || doFill() == null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void read(Function1<? super Buffer, Unit> block) throws EOFException {
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareRead = prepareRead(1);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(1);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            block.invoke(chunkBufferPrepareRead);
            InlineMarker.finallyStart(1);
            int readPosition2 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition2 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition2 == chunkBufferPrepareRead.getWritePosition()) {
                ensureNext(chunkBufferPrepareRead);
            } else {
                setHeadPosition(readPosition2);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                ensureNext(chunkBufferPrepareRead);
            } else {
                setHeadPosition(readPosition3);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void read(int n, Function1<? super Buffer, Unit> block) throws EOFException {
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareRead = prepareRead(n);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(n);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            block.invoke(chunkBufferPrepareRead);
            InlineMarker.finallyStart(1);
            int readPosition2 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition2 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition2 == chunkBufferPrepareRead.getWritePosition()) {
                ensureNext(chunkBufferPrepareRead);
            } else {
                setHeadPosition(readPosition2);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                ensureNext(chunkBufferPrepareRead);
            } else {
                setHeadPosition(readPosition3);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final ChunkBuffer prepareReadLoop(int minSize, ChunkBuffer head) {
        while (true) {
            int headEndExclusive = getHeadEndExclusive() - getHeadPosition();
            if (headEndExclusive >= minSize) {
                return head;
            }
            ChunkBuffer next = head.getNext();
            if (next == null && (next = doFill()) == null) {
                return null;
            }
            if (headEndExclusive == 0) {
                if (head != ChunkBuffer.INSTANCE.getEmpty()) {
                    releaseHead$ktor_io(head);
                }
                head = next;
            } else {
                ChunkBuffer chunkBuffer = head;
                ChunkBuffer chunkBuffer2 = next;
                int iWriteBufferAppend = BufferAppendKt.writeBufferAppend(chunkBuffer, chunkBuffer2, minSize - headEndExclusive);
                setHeadEndExclusive(head.getWritePosition());
                setTailRemaining(getTailRemaining() - ((long) iWriteBufferAppend));
                if (chunkBuffer2.getWritePosition() <= chunkBuffer2.getReadPosition()) {
                    head.setNext(null);
                    head.setNext(next.cleanNext());
                    next.release(this.pool);
                } else {
                    next.reserveStartGap(iWriteBufferAppend);
                }
                if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() >= minSize) {
                    return head;
                }
                if (minSize > 8) {
                    minSizeIsTooBig(minSize);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }
}
