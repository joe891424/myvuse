package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.ChunkBufferKt;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.NumbersKt;
import io.ktor.utils.p098io.core.internal.UTF8Kt;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: AbstractOutput.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "AbstractOutput is deprecated and will be merged with Input in 2.0.0", replaceWith = @ReplaceWith(expression = "Output", imports = {}))
@ExperimentalIoApi
@Metadata(m5597d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b'\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007B\u0007\b\u0016¢\u0006\u0002\u0010\bB\u001d\b\u0000\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\nH\u0001J\r\u0010G\u001a\u00020EH\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020EH\u0007J\u0010\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020LH\u0016J$\u0010J\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0016J\u0012\u0010J\u001a\u00020\u00002\b\u0010M\u001a\u0004\u0018\u00010QH\u0016J\"\u0010J\u001a\u00020\u00002\b\u0010M\u001a\u0004\u0018\u00010Q2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0016J\u0015\u0010R\u001a\u00020E2\u0006\u0010*\u001a\u00020\u0006H\u0000¢\u0006\u0002\bSJ \u0010T\u001a\u00020E2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\nH\u0002J\u0010\u0010W\u001a\u00020E2\u0006\u0010K\u001a\u00020LH\u0002JG\u0010X\u001a\u00020\n2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2,\u0010Y\u001a(\u0012\u0004\u0012\u00020[\u0012\u0013\u0012\u00110\n¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\n0Z¢\u0006\u0002\b_H\u0082\bJ\b\u0010`\u001a\u00020aH\u0007J\b\u0010b\u001a\u00020\u0006H\u0002J\u0015\u0010c\u001a\u00020E2\u0006\u0010d\u001a\u00020\u0006H\u0000¢\u0006\u0002\beJ\u0006\u0010f\u001a\u00020EJ\b\u0010g\u001a\u00020EH$J\u0006\u0010h\u001a\u00020EJ*\u0010h\u001a\u00020E2\u0006\u0010i\u001a\u0002092\u0006\u0010j\u001a\u00020\n2\u0006\u0010k\u001a\u00020\nH$ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\b\u0010n\u001a\u00020EH\u0002J\u0015\u0010o\u001a\u00020E2\u0006\u0010d\u001a\u00020aH\u0011¢\u0006\u0002\bpJ\u0010\u0010q\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\nH\u0007J\u0006\u0010r\u001a\u00020EJ\b\u0010s\u001a\u00020EH\u0017J\u000f\u0010t\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\buJ(\u0010v\u001a\u00020\n2\u0006\u0010w\u001a\u00020\n2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\n0xH\u0081\bø\u0001\u0002J\u000e\u0010y\u001a\u00020E2\u0006\u0010z\u001a\u00020{J\u0010\u0010|\u001a\u00020E2\u0006\u0010z\u001a\u00020{H\u0002J\u0015\u0010}\u001a\u00020E2\u0006\u0010~\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u007fJ\u0011\u0010\u0080\u0001\u001a\u00020E2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\u0019\u0010\u0080\u0001\u001a\u00020E2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010F\u001a\u00020\nJ\u001a\u0010\u0080\u0001\u001a\u00020E2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010F\u001a\u00030\u0083\u0001J(\u0010\u0084\u0001\u001a\u00020E2\u0006\u00100\u001a\u00020\u00062\u0007\u0010\u0085\u0001\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020E2\u0007\u0010\u0085\u0001\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0002J\u0012\u0010\u0087\u0001\u001a\u00020E2\u0007\u0010\u0088\u0001\u001a\u00020QH\u0007J\u0013\u0010\u0087\u0001\u001a\u00020E2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0007J\u0016\u0010\u008b\u0001\u001a\u00020\n*\u00020[2\u0006\u0010z\u001a\u00020\nH\u0082\bR(\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n8D@EX\u0084\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R,\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u001b8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R*\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00068D@DX\u0085\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u0014\u0010*\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\b1\u0010\b\u001a\u0004\b2\u0010\u000fR$\u00103\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8@@BX\u0080\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017R$\u00106\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R*\u0010:\u001a\u0002092\u0006\u0010\f\u001a\u0002098@@@X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R\u0015\u0010B\u001a\u00020\n8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u008c\u0001"}, m5598d2 = {"Lio/ktor/utils/io/core/AbstractOutput;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lio/ktor/utils/io/core/Output;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "()V", "headerSizeHint", "", "(ILio/ktor/utils/io/pool/ObjectPool;)V", "value", "_head", "get_head", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "set_head", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "<anonymous parameter 0>", "_size", "get_size", "()I", "set_size", "(I)V", "_tail", "get_tail", "set_tail", "Lio/ktor/utils/io/core/ByteOrder;", "byteOrder", "getByteOrder$annotations", "getByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "chainedSize", "getChainedSize", "setChainedSize", "newValue", "currentTail", "getCurrentTail$annotations", "getCurrentTail", "setCurrentTail", "head", "getHead$ktor_io", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "state", "Lio/ktor/utils/io/core/AbstractOutputSharedState;", "tail", "getTail$annotations", "getTail", "tailEndExclusive", "getTailEndExclusive$ktor_io", "setTailEndExclusive", "tailInitialPosition", "getTailInitialPosition", "setTailInitialPosition", "Lio/ktor/utils/io/bits/Memory;", "tailMemory", "getTailMemory-SK3TCg8$ktor_io", "()Ljava/nio/ByteBuffer;", "setTailMemory-3GNKZMM$ktor_io", "(Ljava/nio/ByteBuffer;)V", "tailPosition", "getTailPosition$ktor_io", "setTailPosition$ktor_io", "tailRemaining", "getTailRemaining$ktor_io", "addSize", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "afterBytesStolen", "afterBytesStolen$ktor_io", "afterHeadWrite", "append", "c", "", "csq", "", "start", ViewProps.END, "", "appendChain", "appendChain$ktor_io", "appendChainImpl", "newTail", "chainedSizeDelta", "appendCharFallback", "appendCharsTemplate", "block", "Lkotlin/Function2;", "Lio/ktor/utils/io/core/Buffer;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Lkotlin/ExtensionFunctionType;", "appendNewBuffer", "Lio/ktor/utils/io/core/IoBuffer;", "appendNewChunk", "appendSingleChunk", "buffer", "appendSingleChunk$ktor_io", "close", "closeDestination", "flush", "source", TypedValues.CycleType.S_WAVE_OFFSET, "length", "flush-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)V", "flushChain", "last", "last$ktor_io", "prepareWriteHead", "release", "reset", "stealAll", "stealAll$ktor_io", "write", "size", "Lkotlin/Function1;", "writeByte", "v", "", "writeByteFallback", "writeChunkBuffer", "chunkBuffer", "writeChunkBuffer$ktor_io", "writePacket", "p", "Lio/ktor/utils/io/core/ByteReadPacket;", "", "writePacketMerging", "foreignStolen", "writePacketSlowPrepend", "writeStringUtf8", "cs", "s", "", "putUtf8Char", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public abstract class AbstractOutput implements Appendable, Output {
    private ByteOrder byteOrder;
    private final int headerSizeHint;
    private final ObjectPool<ChunkBuffer> pool;
    private final AbstractOutputSharedState state;

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is no longer supported. All operations are big endian by default. Use readXXXLittleEndian to read primitives in little endian")
    public static /* synthetic */ void getByteOrder$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Will be removed. Override flush(buffer) properly.")
    protected static /* synthetic */ void getCurrentTail$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Will be removed in future releases.")
    public static /* synthetic */ void getTail$annotations() {
    }

    protected abstract void closeDestination();

    /* JADX INFO: renamed from: flush-5Mw_xsg, reason: not valid java name */
    protected abstract void mo7104flush5Mw_xsg(ByteBuffer source, int offset, int length);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void reset() {
    }

    @Deprecated(message = "There is no need to update/reset this value anymore.")
    protected final void set_size(int i) {
    }

    public AbstractOutput(int i, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.headerSizeHint = i;
        this.pool = pool;
        this.state = new AbstractOutputSharedState();
        this.byteOrder = ByteOrder.BIG_ENDIAN;
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void fill(long j, byte b) {
        Output.DefaultImpls.fill(this, j, b);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeDouble(double d) {
        Output.DefaultImpls.writeDouble(this, d);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFloat(float f) {
        Output.DefaultImpls.writeFloat(this, f);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFully(IoBuffer ioBuffer, int i) {
        Output.DefaultImpls.writeFully(this, ioBuffer, i);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFully(ByteBuffer byteBuffer) {
        Output.DefaultImpls.writeFully(this, byteBuffer);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFully(byte[] bArr, int i, int i2) {
        Output.DefaultImpls.writeFully((Output) this, bArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFully(double[] dArr, int i, int i2) {
        Output.DefaultImpls.writeFully(this, dArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFully(float[] fArr, int i, int i2) {
        Output.DefaultImpls.writeFully((Output) this, fArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFully(int[] iArr, int i, int i2) {
        Output.DefaultImpls.writeFully((Output) this, iArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFully(long[] jArr, int i, int i2) {
        Output.DefaultImpls.writeFully((Output) this, jArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeFully(short[] sArr, int i, int i2) {
        Output.DefaultImpls.writeFully((Output) this, sArr, i, i2);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeInt(int i) {
        Output.DefaultImpls.writeInt(this, i);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeLong(long j) {
        Output.DefaultImpls.writeLong(this, j);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void writeShort(short s) {
        Output.DefaultImpls.writeShort(this, s);
    }

    protected final ObjectPool<ChunkBuffer> getPool() {
        return this.pool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractOutput(ObjectPool<ChunkBuffer> pool) {
        this(0, pool);
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    public AbstractOutput() {
        this(ChunkBuffer.INSTANCE.getPool());
    }

    private final ChunkBuffer get_head() {
        return this.state.getHead();
    }

    private final void set_head(ChunkBuffer chunkBuffer) {
        this.state.setHead(chunkBuffer);
    }

    private final ChunkBuffer get_tail() {
        return this.state.getTail();
    }

    private final void set_tail(ChunkBuffer chunkBuffer) {
        this.state.setTail(chunkBuffer);
    }

    public final ChunkBuffer getHead$ktor_io() {
        ChunkBuffer chunkBuffer = get_head();
        return chunkBuffer == null ? ChunkBuffer.INSTANCE.getEmpty() : chunkBuffer;
    }

    public final /* synthetic */ ChunkBuffer getTail() {
        return prepareWriteHead(1);
    }

    protected final ChunkBuffer getCurrentTail() {
        return prepareWriteHead(1);
    }

    protected final void setCurrentTail(ChunkBuffer newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        appendChain$ktor_io(newValue);
    }

    /* JADX INFO: renamed from: getTailMemory-SK3TCg8$ktor_io, reason: not valid java name */
    public final ByteBuffer m7105getTailMemorySK3TCg8$ktor_io() {
        return this.state.getTailMemory();
    }

    /* JADX INFO: renamed from: setTailMemory-3GNKZMM$ktor_io, reason: not valid java name */
    public final void m7106setTailMemory3GNKZMM$ktor_io(ByteBuffer value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state.m7108setTailMemory3GNKZMM(value);
    }

    public final int getTailPosition$ktor_io() {
        return this.state.getTailPosition();
    }

    public final void setTailPosition$ktor_io(int i) {
        this.state.setTailPosition(i);
    }

    public final int getTailEndExclusive$ktor_io() {
        return this.state.getTailEndExclusive();
    }

    private final void setTailEndExclusive(int i) {
        this.state.setTailEndExclusive(i);
    }

    private final int getTailInitialPosition() {
        return this.state.getTailInitialPosition();
    }

    private final void setTailInitialPosition(int i) {
        this.state.setTailInitialPosition(i);
    }

    private final int getChainedSize() {
        return this.state.getChainedSize();
    }

    private final void setChainedSize(int i) {
        this.state.setChainedSize(i);
    }

    public final int getTailRemaining$ktor_io() {
        return getTailEndExclusive$ktor_io() - getTailPosition$ktor_io();
    }

    protected final int get_size() {
        return getChainedSize() + (getTailPosition$ktor_io() - getTailInitialPosition());
    }

    @Override // io.ktor.utils.p098io.core.Output
    public final ByteOrder getByteOrder() {
        return this.byteOrder;
    }

    @Override // io.ktor.utils.p098io.core.Output
    public final void setByteOrder(ByteOrder value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.byteOrder = value;
        if (value != ByteOrder.BIG_ENDIAN) {
            throw new IllegalArgumentException("Only BIG_ENDIAN is supported. Use corresponding functions to read/writein the little endian");
        }
    }

    @Override // io.ktor.utils.p098io.core.Output
    public final void flush() {
        flushChain();
    }

    private final void flushChain() {
        ChunkBuffer chunkBufferStealAll$ktor_io = stealAll$ktor_io();
        if (chunkBufferStealAll$ktor_io == null) {
            return;
        }
        ChunkBuffer next = chunkBufferStealAll$ktor_io;
        do {
            try {
                ChunkBuffer chunkBuffer = next;
                mo7104flush5Mw_xsg(next.getMemory(), next.getReadPosition(), chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                next = next.getNext();
            } finally {
                BuffersKt.releaseAll(chunkBufferStealAll$ktor_io, this.pool);
            }
        } while (next != null);
    }

    public final ChunkBuffer stealAll$ktor_io() {
        ChunkBuffer chunkBuffer = get_head();
        if (chunkBuffer == null) {
            return null;
        }
        ChunkBuffer chunkBuffer2 = get_tail();
        if (chunkBuffer2 != null) {
            chunkBuffer2.commitWrittenUntilIndex(getTailPosition$ktor_io());
        }
        set_head(null);
        set_tail(null);
        setTailPosition$ktor_io(0);
        setTailEndExclusive(0);
        setTailInitialPosition(0);
        setChainedSize(0);
        m7106setTailMemory3GNKZMM$ktor_io(Memory.INSTANCE.m6967getEmptySK3TCg8());
        return chunkBuffer;
    }

    public final void afterBytesStolen$ktor_io() {
        ChunkBuffer head$ktor_io = getHead$ktor_io();
        if (head$ktor_io != ChunkBuffer.INSTANCE.getEmpty()) {
            if (!(head$ktor_io.getNext() == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            head$ktor_io.resetForWrite();
            head$ktor_io.reserveStartGap(this.headerSizeHint);
            head$ktor_io.reserveEndGap(8);
            setTailPosition$ktor_io(head$ktor_io.getWritePosition());
            setTailInitialPosition(getTailPosition$ktor_io());
            setTailEndExclusive(head$ktor_io.getLimit());
        }
    }

    public final void appendSingleChunk$ktor_io(ChunkBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (!(buffer.getNext() == null)) {
            throw new IllegalStateException("It should be a single buffer chunk.".toString());
        }
        appendChainImpl(buffer, buffer, 0);
    }

    public final void appendChain$ktor_io(ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        ChunkBuffer chunkBufferFindTail = BuffersKt.findTail(head);
        ChunkBuffer chunkBuffer = chunkBufferFindTail;
        long jRemainingAll = BuffersKt.remainingAll(head) - ((long) (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition()));
        if (jRemainingAll < 2147483647L) {
            appendChainImpl(head, chunkBufferFindTail, (int) jRemainingAll);
        } else {
            NumbersKt.failLongToIntConversion(jRemainingAll, "total size increase");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChunkBuffer appendNewChunk() {
        ChunkBuffer chunkBufferBorrow = this.pool.borrow();
        chunkBufferBorrow.reserveEndGap(8);
        appendSingleChunk$ktor_io(chunkBufferBorrow);
        return chunkBufferBorrow;
    }

    private final void appendChainImpl(ChunkBuffer head, ChunkBuffer newTail, int chainedSizeDelta) {
        ChunkBuffer chunkBuffer = get_tail();
        if (chunkBuffer == null) {
            set_head(head);
            setChainedSize(0);
        } else {
            chunkBuffer.setNext(head);
            int tailPosition$ktor_io = getTailPosition$ktor_io();
            chunkBuffer.commitWrittenUntilIndex(tailPosition$ktor_io);
            setChainedSize(getChainedSize() + (tailPosition$ktor_io - getTailInitialPosition()));
        }
        set_tail(newTail);
        setChainedSize(getChainedSize() + chainedSizeDelta);
        m7106setTailMemory3GNKZMM$ktor_io(newTail.getMemory());
        setTailPosition$ktor_io(newTail.getWritePosition());
        setTailInitialPosition(newTail.getReadPosition());
        setTailEndExclusive(newTail.getLimit());
    }

    @Override // io.ktor.utils.p098io.core.Output
    public final void writeByte(byte v) {
        int tailPosition$ktor_io = getTailPosition$ktor_io();
        if (tailPosition$ktor_io < getTailEndExclusive$ktor_io()) {
            setTailPosition$ktor_io(tailPosition$ktor_io + 1);
            m7105getTailMemorySK3TCg8$ktor_io().put(tailPosition$ktor_io, v);
        } else {
            writeByteFallback(v);
        }
    }

    private final void writeByteFallback(byte v) {
        appendNewChunk().writeByte(v);
        setTailPosition$ktor_io(getTailPosition$ktor_io() + 1);
    }

    @Override // io.ktor.utils.p098io.core.Output, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
        } finally {
            closeDestination();
        }
    }

    @Override // java.lang.Appendable
    public AbstractOutput append(char c) {
        int tailPosition$ktor_io = getTailPosition$ktor_io();
        int i = 3;
        if (getTailEndExclusive$ktor_io() - tailPosition$ktor_io >= 3) {
            ByteBuffer byteBufferM7105getTailMemorySK3TCg8$ktor_io = m7105getTailMemorySK3TCg8$ktor_io();
            if (c >= 0 && c <= 127) {
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io, (byte) c);
                i = 1;
            } else if (128 <= c && c <= 2047) {
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io, (byte) (((c >> 6) & 31) | JfifUtil.MARKER_SOFn));
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io + 1, (byte) ((c & '?') | 128));
                i = 2;
            } else if (2048 <= c && c <= 65535) {
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io, (byte) (((c >> '\f') & 15) | ISO7816Kt.INS_CREATE_FILE));
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io + 1, (byte) (((c >> 6) & 63) | 128));
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io + 2, (byte) ((c & '?') | 128));
            } else {
                if (0 > c || c > 65535) {
                    UTF8Kt.malformedCodePoint(c);
                    throw new KotlinNothingValueException();
                }
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io, (byte) (((c >> 18) & 7) | 240));
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io + 1, (byte) (((c >> '\f') & 63) | 128));
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io + 2, (byte) (((c >> 6) & 63) | 128));
                byteBufferM7105getTailMemorySK3TCg8$ktor_io.put(tailPosition$ktor_io + 3, (byte) ((c & '?') | 128));
                i = 4;
            }
            setTailPosition$ktor_io(tailPosition$ktor_io + i);
            return this;
        }
        appendCharFallback(c);
        return this;
    }

    @Override // java.lang.Appendable
    public AbstractOutput append(CharSequence csq) {
        if (csq == null) {
            append("null", 0, 4);
        } else {
            append(csq, 0, csq.length());
        }
        return this;
    }

    @Override // java.lang.Appendable
    public AbstractOutput append(CharSequence csq, int start, int end) {
        if (csq == null) {
            return append("null", start, end);
        }
        StringsKt.writeText(this, csq, start, end, Charsets.UTF_8);
        return this;
    }

    public final void writePacket(ByteReadPacket p) {
        Intrinsics.checkNotNullParameter(p, "p");
        ChunkBuffer chunkBufferStealAll$ktor_io = p.stealAll$ktor_io();
        if (chunkBufferStealAll$ktor_io == null) {
            p.release();
            return;
        }
        ChunkBuffer chunkBuffer = get_tail();
        if (chunkBuffer == null) {
            appendChain$ktor_io(chunkBufferStealAll$ktor_io);
        } else {
            writePacketMerging(chunkBuffer, chunkBufferStealAll$ktor_io, p.getPool());
        }
    }

    public final void writeChunkBuffer$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "chunkBuffer");
        ChunkBuffer chunkBuffer2 = get_tail();
        if (chunkBuffer2 == null) {
            appendChain$ktor_io(chunkBuffer);
        } else {
            writePacketMerging(chunkBuffer2, chunkBuffer, this.pool);
        }
    }

    private final void writePacketMerging(ChunkBuffer tail, ChunkBuffer foreignStolen, ObjectPool<ChunkBuffer> pool) {
        tail.commitWrittenUntilIndex(getTailPosition$ktor_io());
        ChunkBuffer chunkBuffer = tail;
        int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
        ChunkBuffer chunkBuffer2 = foreignStolen;
        int writePosition2 = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
        int packet_max_copy_size = PacketJVMKt.getPACKET_MAX_COPY_SIZE();
        if (writePosition2 >= packet_max_copy_size || writePosition2 > (chunkBuffer.getCapacity() - chunkBuffer.getLimit()) + (chunkBuffer.getLimit() - chunkBuffer.getWritePosition())) {
            writePosition2 = -1;
        }
        if (writePosition >= packet_max_copy_size || writePosition > foreignStolen.getStartGap() || !ChunkBufferKt.isExclusivelyOwned(foreignStolen)) {
            writePosition = -1;
        }
        if (writePosition2 == -1 && writePosition == -1) {
            appendChain$ktor_io(foreignStolen);
            return;
        }
        if (writePosition != -1 && writePosition2 > writePosition) {
            if (writePosition2 == -1 || writePosition < writePosition2) {
                writePacketSlowPrepend(foreignStolen, tail);
                return;
            }
            throw new IllegalStateException("prep = " + writePosition + ", app = " + writePosition2);
        }
        BufferAppendKt.writeBufferAppend(chunkBuffer, chunkBuffer2, (chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) + (chunkBuffer.getCapacity() - chunkBuffer.getLimit()));
        afterHeadWrite();
        ChunkBuffer chunkBufferCleanNext = foreignStolen.cleanNext();
        if (chunkBufferCleanNext != null) {
            appendChain$ktor_io(chunkBufferCleanNext);
        }
        foreignStolen.release(pool);
    }

    private final void writePacketSlowPrepend(ChunkBuffer foreignStolen, ChunkBuffer tail) {
        BufferAppendKt.writeBufferPrepend(foreignStolen, tail);
        ChunkBuffer chunkBuffer = get_head();
        if (chunkBuffer == null) {
            throw new IllegalStateException("head should't be null since it is already handled in the fast-path".toString());
        }
        if (chunkBuffer == tail) {
            set_head(foreignStolen);
        } else {
            while (true) {
                ChunkBuffer next = chunkBuffer.getNext();
                Intrinsics.checkNotNull(next);
                if (next == tail) {
                    break;
                } else {
                    chunkBuffer = next;
                }
            }
            chunkBuffer.setNext(foreignStolen);
        }
        tail.release(this.pool);
        set_tail(BuffersKt.findTail(foreignStolen));
    }

    public final void writePacket(ByteReadPacket p, int n) throws EOFException {
        Intrinsics.checkNotNullParameter(p, "p");
        while (n > 0) {
            ByteReadPacket byteReadPacket = p;
            int headEndExclusive = byteReadPacket.getHeadEndExclusive() - byteReadPacket.getHeadPosition();
            if (headEndExclusive <= n) {
                n -= headEndExclusive;
                ChunkBuffer chunkBufferSteal$ktor_io = p.steal$ktor_io();
                if (chunkBufferSteal$ktor_io == null) {
                    throw new EOFException("Unexpected end of packet");
                }
                appendSingleChunk$ktor_io(chunkBufferSteal$ktor_io);
            } else {
                ChunkBuffer chunkBufferPrepareRead = byteReadPacket.prepareRead(1);
                if (chunkBufferPrepareRead == null) {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
                int readPosition = chunkBufferPrepareRead.getReadPosition();
                try {
                    OutputKt.writeFully(this, chunkBufferPrepareRead, n);
                    int readPosition2 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition2 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition2 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                        return;
                    } else {
                        byteReadPacket.setHeadPosition(readPosition2);
                        return;
                    }
                } catch (Throwable th) {
                    int readPosition3 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition3 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                    } else {
                        byteReadPacket.setHeadPosition(readPosition3);
                    }
                    throw th;
                }
            }
        }
    }

    public final void writePacket(ByteReadPacket p, long n) throws EOFException {
        Intrinsics.checkNotNullParameter(p, "p");
        while (n > 0) {
            ByteReadPacket byteReadPacket = p;
            long headEndExclusive = byteReadPacket.getHeadEndExclusive() - byteReadPacket.getHeadPosition();
            if (headEndExclusive <= n) {
                n -= headEndExclusive;
                ChunkBuffer chunkBufferSteal$ktor_io = p.steal$ktor_io();
                if (chunkBufferSteal$ktor_io == null) {
                    throw new EOFException("Unexpected end of packet");
                }
                appendSingleChunk$ktor_io(chunkBufferSteal$ktor_io);
            } else {
                ChunkBuffer chunkBufferPrepareRead = byteReadPacket.prepareRead(1);
                if (chunkBufferPrepareRead == null) {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
                int readPosition = chunkBufferPrepareRead.getReadPosition();
                try {
                    OutputKt.writeFully(this, chunkBufferPrepareRead, (int) n);
                    int readPosition2 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition2 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition2 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                        return;
                    } else {
                        byteReadPacket.setHeadPosition(readPosition2);
                        return;
                    }
                } catch (Throwable th) {
                    int readPosition3 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition3 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                    } else {
                        byteReadPacket.setHeadPosition(readPosition3);
                    }
                    throw th;
                }
            }
        }
    }

    @Override // io.ktor.utils.p098io.core.Output
    public Appendable append(char[] csq, int start, int end) {
        Intrinsics.checkNotNullParameter(csq, "csq");
        StringsKt.writeText(this, csq, start, end, Charsets.UTF_8);
        return this;
    }

    private final int appendCharsTemplate(int start, int end, Function2<? super Buffer, ? super Integer, Integer> block) {
        if (start >= end) {
            return start;
        }
        int iIntValue = block.invoke(prepareWriteHead(1), Integer.valueOf(start)).intValue();
        afterHeadWrite();
        while (iIntValue < end) {
            iIntValue = block.invoke(appendNewChunk(), Integer.valueOf(iIntValue)).intValue();
            afterHeadWrite();
        }
        return iIntValue;
    }

    @Deprecated(message = "Use writeText instead", replaceWith = @ReplaceWith(expression = "writeText(s)", imports = {}))
    public final void writeStringUtf8(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        StringsKt.writeText$default(this, s, 0, 0, (Charset) null, 14, (Object) null);
    }

    @Deprecated(message = "Use writeText instead", replaceWith = @ReplaceWith(expression = "this.writeText(cs)", imports = {}))
    public final void writeStringUtf8(CharSequence cs) {
        Intrinsics.checkNotNullParameter(cs, "cs");
        StringsKt.writeText$default(this, cs, 0, 0, (Charset) null, 14, (Object) null);
    }

    private final int putUtf8Char(Buffer buffer, int i) throws InsufficientSpaceException {
        if (1 <= i && i <= 127) {
            buffer.writeByte((byte) i);
            return 1;
        }
        if (i > 2047) {
            ByteBuffer byteBufferM7109getMemorySK3TCg8 = buffer.getMemory();
            int writePosition = buffer.getWritePosition();
            int limit = buffer.getLimit() - writePosition;
            if (limit < 3) {
                throw new InsufficientSpaceException("3 bytes character", 3, limit);
            }
            byteBufferM7109getMemorySK3TCg8.put(writePosition, (byte) (((i >> 12) & 15) | ISO7816Kt.INS_CREATE_FILE));
            byteBufferM7109getMemorySK3TCg8.put(writePosition + 1, (byte) (((i >> 6) & 63) | 128));
            byteBufferM7109getMemorySK3TCg8.put(writePosition + 2, (byte) ((i & 63) | 128));
            buffer.commitWritten(3);
            return 3;
        }
        ByteBuffer byteBufferM7109getMemorySK3TCg82 = buffer.getMemory();
        int writePosition2 = buffer.getWritePosition();
        int limit2 = buffer.getLimit() - writePosition2;
        if (limit2 < 2) {
            throw new InsufficientSpaceException("2 bytes character", 2, limit2);
        }
        byteBufferM7109getMemorySK3TCg82.put(writePosition2, (byte) (((i >> 6) & 31) | JfifUtil.MARKER_SOFn));
        byteBufferM7109getMemorySK3TCg82.put(writePosition2 + 1, (byte) ((i & 63) | 128));
        buffer.commitWritten(2);
        return 2;
    }

    public final void release() {
        close();
    }

    @DangerousInternalIoApi
    public final void afterHeadWrite() {
        ChunkBuffer chunkBuffer = get_tail();
        if (chunkBuffer == null) {
            return;
        }
        setTailPosition$ktor_io(chunkBuffer.getWritePosition());
    }

    public final int write(int size, Function1<? super Buffer, Integer> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            int iIntValue = block.invoke(prepareWriteHead(size)).intValue();
            if (iIntValue >= 0) {
                return iIntValue;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            InlineMarker.finallyStart(1);
            afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void last$ktor_io(IoBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        appendSingleChunk$ktor_io(buffer);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use appendNewChunk instead", replaceWith = @ReplaceWith(expression = "appendNewChunk()", imports = {}))
    public final /* synthetic */ IoBuffer appendNewBuffer() {
        return (IoBuffer) appendNewChunk();
    }

    private final void appendCharFallback(char c) {
        int i = 3;
        try {
            ChunkBuffer chunkBufferPrepareWriteHead = prepareWriteHead(3);
            ByteBuffer byteBufferM7109getMemorySK3TCg8 = chunkBufferPrepareWriteHead.getMemory();
            int writePosition = chunkBufferPrepareWriteHead.getWritePosition();
            if (c >= 0 && c <= 127) {
                byteBufferM7109getMemorySK3TCg8.put(writePosition, (byte) c);
                i = 1;
            } else if (128 <= c && c <= 2047) {
                byteBufferM7109getMemorySK3TCg8.put(writePosition, (byte) (((c >> 6) & 31) | JfifUtil.MARKER_SOFn));
                byteBufferM7109getMemorySK3TCg8.put(writePosition + 1, (byte) ((c & '?') | 128));
                i = 2;
            } else if (2048 <= c && c <= 65535) {
                byteBufferM7109getMemorySK3TCg8.put(writePosition, (byte) (((c >> '\f') & 15) | ISO7816Kt.INS_CREATE_FILE));
                byteBufferM7109getMemorySK3TCg8.put(writePosition + 1, (byte) (((c >> 6) & 63) | 128));
                byteBufferM7109getMemorySK3TCg8.put(writePosition + 2, (byte) ((c & '?') | 128));
            } else {
                if (0 > c || c > 65535) {
                    UTF8Kt.malformedCodePoint(c);
                    throw new KotlinNothingValueException();
                }
                byteBufferM7109getMemorySK3TCg8.put(writePosition, (byte) (((c >> 18) & 7) | 240));
                byteBufferM7109getMemorySK3TCg8.put(writePosition + 1, (byte) (((c >> '\f') & 63) | 128));
                byteBufferM7109getMemorySK3TCg8.put(writePosition + 2, (byte) (((c >> 6) & 63) | 128));
                byteBufferM7109getMemorySK3TCg8.put(writePosition + 3, (byte) ((c & '?') | 128));
                i = 4;
            }
            chunkBufferPrepareWriteHead.commitWritten(i);
            if (!(i >= 0)) {
                throw new IllegalStateException("The returned value shouldn't be negative".toString());
            }
        } finally {
            afterHeadWrite();
        }
    }

    @DangerousInternalIoApi
    public final ChunkBuffer prepareWriteHead(int n) {
        ChunkBuffer chunkBuffer;
        if (getTailEndExclusive$ktor_io() - getTailPosition$ktor_io() >= n && (chunkBuffer = get_tail()) != null) {
            chunkBuffer.commitWrittenUntilIndex(getTailPosition$ktor_io());
            return chunkBuffer;
        }
        return appendNewChunk();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "There is no need to do that anymore.")
    public final /* synthetic */ void addSize(int n) {
        if (!(n >= 0)) {
            throw new IllegalStateException(Intrinsics.stringPlus("It should be non-negative size increment: ", Integer.valueOf(n)).toString());
        }
        if (!(n <= getTailEndExclusive$ktor_io() - getTailPosition$ktor_io())) {
            throw new IllegalStateException(("Unable to mark more bytes than available: " + n + " > " + (getTailEndExclusive$ktor_io() - getTailPosition$ktor_io())).toString());
        }
        setTailPosition$ktor_io(getTailPosition$ktor_io() + n);
    }
}
