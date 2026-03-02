package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.core.ByteOrder;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.ChunkBufferKt;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.RequireFailureCapture;
import io.ktor.utils.p098io.internal.jvm.ErrorsKt;
import io.ktor.utils.p098io.pool.DefaultPool;
import io.ktor.utils.p098io.pool.NoPoolImpl;
import io.ktor.utils.p098io.pool.ObjectPool;
import io.ktor.utils.p098io.utils.AtomicKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharsetDecoder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: IoBufferJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "Use ChunkBuffer instead.", replaceWith = @ReplaceWith(expression = "ChunkBuffer", imports = {"io.ktor.utils.io.core.ChunkBuffer"}))
@Metadata(m5597d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0011\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000 z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001zB\u001c\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001d\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\f¢\u0006\u0002\u0010\rB,\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\t\u0010'\u001a\u00020(H\u0081\bJ\u0014\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010,\u001a\u00020-H\u0017J$\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0007J\u0016\u0010)\u001a\u00060*j\u0002`+2\b\u0010.\u001a\u0004\u0018\u000103H\u0007J&\u0010)\u001a\u00060*j\u0002`+2\b\u0010.\u001a\u0004\u0018\u0001032\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0007J \u00104\u001a\u0002012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0007J \u00104\u001a\u0002012\u0006\u0010.\u001a\u0002032\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0007J\b\u00105\u001a\u00020\u001aH\u0007J\b\u00106\u001a\u00020\u001aH\u0007J\b\u00107\u001a\u00020(H\u0016J\b\u00108\u001a\u00020\u0000H\u0016J\u0018\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0007J\u0006\u0010>\u001a\u00020(J\n\u0010?\u001a\u0004\u0018\u00010\u0000H\u0007J\b\u0010@\u001a\u00020\u001aH\u0007J\b\u0010A\u001a\u00020\u0000H\u0007J8\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020;ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ\u0010\u0010B\u001a\u0002012\u0006\u0010J\u001a\u00020\u0000H\u0007J\u0010\u0010K\u001a\u00020(2\u0006\u0010:\u001a\u000201H\u0007J\u0018\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u000201H\u0007J \u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020O2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J\u0018\u0010Q\u001a\u0002012\u0006\u0010M\u001a\u00020\u00002\u0006\u0010P\u001a\u000201H\u0007J\u0018\u0010Q\u001a\u0002012\u0006\u0010M\u001a\u00020\t2\u0006\u0010P\u001a\u000201H\u0007J \u0010Q\u001a\u0002012\u0006\u0010M\u001a\u00020O2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010Q\u001a\u0002012\u0006\u0010M\u001a\u00020R2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010Q\u001a\u0002012\u0006\u0010M\u001a\u00020S2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010Q\u001a\u0002012\u0006\u0010M\u001a\u00020T2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010Q\u001a\u0002012\u0006\u0010M\u001a\u00020U2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010Q\u001a\u0002012\u0006\u0010M\u001a\u00020V2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010W\u001a\u0002012\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0YH\u0086\bø\u0001\u0001J\b\u0010Z\u001a\u00020[H\u0007J\b\u0010\\\u001a\u00020]H\u0007J\u0018\u0010^\u001a\u00020(2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010P\u001a\u000201H\u0007J\u0018\u0010^\u001a\u00020(2\u0006\u0010M\u001a\u00020\t2\u0006\u0010P\u001a\u000201H\u0007J \u0010^\u001a\u00020(2\u0006\u0010M\u001a\u00020O2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010^\u001a\u00020(2\u0006\u0010M\u001a\u00020R2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010^\u001a\u00020(2\u0006\u0010M\u001a\u00020S2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010^\u001a\u00020(2\u0006\u0010M\u001a\u00020T2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010^\u001a\u00020(2\u0006\u0010M\u001a\u00020U2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010^\u001a\u00020(2\u0006\u0010M\u001a\u00020V2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J\b\u0010_\u001a\u000201H\u0007J\b\u0010`\u001a\u00020;H\u0007J\b\u0010a\u001a\u00020bH\u0007J.\u0010c\u001a\u0002012\u0006\u0010d\u001a\u00020e2\n\u0010f\u001a\u00060*j\u0002`+2\u0006\u0010g\u001a\u00020\u001a2\b\b\u0002\u0010G\u001a\u000201H\u0007J\u0014\u0010h\u001a\u00020(2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fJ\u0010\u0010i\u001a\u00020(2\u0006\u0010j\u001a\u00020\tH\u0007J\u0012\u0010k\u001a\u00020(2\b\u0010l\u001a\u0004\u0018\u00010\u0000H\u0007J\b\u0010m\u001a\u00020nH\u0016J\u0006\u0010o\u001a\u000201J\u0010\u0010p\u001a\u00020(2\u0006\u0010q\u001a\u00020\tH\u0007J \u0010p\u001a\u00020(2\u0006\u0010q\u001a\u00020O2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J\u0018\u0010#\u001a\u0002012\u0006\u0010q\u001a\u00020\u00002\u0006\u0010P\u001a\u000201H\u0007J(\u0010r\u001a\u0002012\u0006\u0010N\u001a\u0002012\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0YH\u0086\bø\u0001\u0001J\u0010\u0010s\u001a\u00020(2\u0006\u0010<\u001a\u00020[H\u0007J\u0010\u0010t\u001a\u00020(2\u0006\u0010<\u001a\u00020]H\u0007J\u0018\u0010u\u001a\u00020(2\u0006\u0010q\u001a\u00020\u00002\u0006\u0010P\u001a\u000201H\u0007J\u0010\u0010u\u001a\u00020(2\u0006\u0010v\u001a\u00020\tH\u0017J \u0010u\u001a\u00020(2\u0006\u0010q\u001a\u00020O2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010u\u001a\u00020(2\u0006\u0010q\u001a\u00020R2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010u\u001a\u00020(2\u0006\u0010q\u001a\u00020S2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010u\u001a\u00020(2\u0006\u0010q\u001a\u00020T2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010u\u001a\u00020(2\u0006\u0010q\u001a\u00020U2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J \u0010u\u001a\u00020(2\u0006\u0010q\u001a\u00020V2\u0006\u0010E\u001a\u0002012\u0006\u0010P\u001a\u000201H\u0007J\u0010\u0010w\u001a\u00020(2\u0006\u0010<\u001a\u000201H\u0007J\u0010\u0010x\u001a\u00020(2\u0006\u0010<\u001a\u00020;H\u0007J\u0010\u0010y\u001a\u00020(2\u0006\u0010<\u001a\u00020bH\u0007R*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR*\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t8@@AX\u0081\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\nR*\u0010#\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t8@@@X\u0081\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010!\"\u0004\b&\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006{"}, m5598d2 = {"Lio/ktor/utils/io/core/IoBuffer;", "Lio/ktor/utils/io/core/Input;", "Lio/ktor/utils/io/core/Output;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "memory", "Lio/ktor/utils/io/bits/Memory;", "origin", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "external", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/pool/ObjectPool;)V", "parentPool", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/pool/ObjectPool;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "Lio/ktor/utils/io/core/ByteOrder;", "byteOrder", "getByteOrder$annotations", "()V", "getByteOrder", "()Lio/ktor/utils/io/core/ByteOrder;", "setByteOrder", "(Lio/ktor/utils/io/core/ByteOrder;)V", "endOfInput", "", "getEndOfInput", "()Z", "<anonymous parameter 0>", "readBuffer", "getReadBuffer$annotations", "getReadBuffer", "()Ljava/nio/ByteBuffer;", "setReadBuffer", "writeBuffer", "getWriteBuffer$annotations", "getWriteBuffer", "setWriteBuffer", "afterWrite", "", "append", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "c", "", "csq", "", "start", "", ViewProps.END, "", "appendChars", "canRead", "canWrite", "close", "duplicate", "fill", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "v", "", "flush", "getNext", "isExclusivelyOwned", "makeView", "peekTo", FirebaseAnalytics.Param.DESTINATION, "destinationOffset", TypedValues.CycleType.S_WAVE_OFFSET, "min", "max", "peekTo-1dgeIsk", "(Ljava/nio/ByteBuffer;JJJJ)J", "buffer", "pushBack", "read", C4352k.a.f5652f, "size", "", "length", "readAvailable", "", "", "", "", "", "readDirect", "block", "Lkotlin/Function1;", "readDouble", "", "readFloat", "", "readFully", "readInt", "readLong", "readShort", "", "readText", "decoder", "Ljava/nio/charset/CharsetDecoder;", "out", "lastBuffer", "release", "resetFromContentToWrite", "child", "setNext", "newNext", "toString", "", "tryPeek", "write", ReactVideoViewManager.PROP_SRC, "writeDirect", "writeDouble", "writeFloat", "writeFully", "bb", "writeInt", "writeLong", "writeShort", "Companion", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class IoBuffer extends ChunkBuffer implements Input, Output {
    private static final int DEFAULT_BUFFER_POOL_DIRECT;
    private static final int DEFAULT_BUFFER_POOL_SIZE;
    private static final IoBuffer Empty;
    private static final ObjectPool<IoBuffer> EmptyPool;
    private static final ObjectPool<IoBuffer> NoPool;
    private static final ObjectPool<IoBuffer> Pool;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_BUFFER_SIZE = AtomicKt.getIOIntProperty("buffer.size", 4096);

    public /* synthetic */ IoBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool objectPool, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, chunkBuffer, (ObjectPool<IoBuffer>) objectPool);
    }

    public /* synthetic */ IoBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, chunkBuffer);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "All read operations are big endian by default except functions with LittleEndian suffix. Read/write with readXXXLittleEndian/writeXXXLittleEndian or do readXXX/writeXXX with X.reverseByteOrder() instead.")
    public static /* synthetic */ void getByteOrder$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getReadBuffer$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getWriteBuffer$annotations() {
    }

    public final void afterWrite() {
    }

    @Override // io.ktor.utils.p098io.core.Output
    public final void flush() {
    }

    private IoBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool<IoBuffer> objectPool) {
        super(byteBuffer, chunkBuffer, objectPool == null ? null : objectPool, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IoBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer) {
        this(byteBuffer, chunkBuffer, null, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public IoBuffer(ByteBuffer external) {
        Intrinsics.checkNotNullParameter(external, "external");
        Memory.Companion companion = Memory.INSTANCE;
        ByteBuffer byteBufferOrder = external.slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        this(Memory.m6951constructorimpl(byteBufferOrder), (ChunkBuffer) null, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public IoBuffer(ByteBuffer external, ObjectPool<IoBuffer> pool) {
        Intrinsics.checkNotNullParameter(external, "external");
        Intrinsics.checkNotNullParameter(pool, "pool");
        Memory.Companion companion = Memory.INSTANCE;
        ByteBuffer byteBufferOrder = external.slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        this(Memory.m6951constructorimpl(byteBufferOrder), null, pool, 0 == true ? 1 : 0);
    }

    public final ByteBuffer getReadBuffer() {
        IoBuffer ioBuffer = this;
        return MemoryJvmKt.sliceSafe(getMemory(), getReadPosition(), ioBuffer.getWritePosition() - ioBuffer.getReadPosition());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "")
    public final void setReadBuffer(ByteBuffer noName_0) {
        Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
        throw new NotImplementedError(null, 1, null);
    }

    public final ByteBuffer getWriteBuffer() {
        IoBuffer ioBuffer = this;
        return MemoryJvmKt.sliceSafe(getMemory(), getWritePosition(), ioBuffer.getLimit() - ioBuffer.getWritePosition());
    }

    public final void setWriteBuffer(ByteBuffer noName_0) {
        Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ boolean canRead() {
        IoBuffer ioBuffer = this;
        return ioBuffer.getWritePosition() > ioBuffer.getReadPosition();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ boolean canWrite() {
        IoBuffer ioBuffer = this;
        return ioBuffer.getLimit() > ioBuffer.getWritePosition();
    }

    @Override // io.ktor.utils.p098io.core.internal.ChunkBuffer
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ IoBuffer getNext() {
        return (IoBuffer) getNext();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void setNext(IoBuffer newNext) {
        setNext((ChunkBuffer) newNext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void read(ByteBuffer dst, int size) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        IoBufferJVMKt.readFully(this, dst, size);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void read(byte[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        BufferPrimitivesKt.readFully((Buffer) this, dst, offset, length);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void write(ByteBuffer src) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesJvmKt.writeFully(this, src);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void write(byte[] src, int offset, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesKt.writeFully((Buffer) this, src, offset, length);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ int writeBuffer(IoBuffer src, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesKt.writeFully(this, src, length);
        return length;
    }

    @Override // io.ktor.utils.p098io.core.Input
    /* JADX INFO: renamed from: getEndOfInput */
    public boolean isEmpty() {
        IoBuffer ioBuffer = this;
        return !(ioBuffer.getWritePosition() > ioBuffer.getReadPosition());
    }

    @Override // io.ktor.utils.p098io.core.Input
    public final ByteOrder getByteOrder() {
        ByteOrder.Companion companion = ByteOrder.INSTANCE;
        java.nio.ByteOrder byteOrderOrder = getReadBuffer().order();
        Intrinsics.checkNotNullExpressionValue(byteOrderOrder, "readBuffer.order()");
        return companion.m5582of(byteOrderOrder);
    }

    @Override // io.ktor.utils.p098io.core.Input
    public final void setByteOrder(ByteOrder value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != ByteOrder.BIG_ENDIAN) {
            throw new UnsupportedOperationException("Only BIG_ENDIAN is supported");
        }
    }

    @Override // io.ktor.utils.p098io.core.Input
    /* JADX INFO: renamed from: peekTo-1dgeIsk */
    public final long mo7100peekTo1dgeIsk(ByteBuffer destination, long destinationOffset, long offset, long min, long max) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return BuffersKt.m7143peekToxGVKfY(this, destination, destinationOffset, offset, min, max);
    }

    @Override // io.ktor.utils.p098io.core.Input
    public final int tryPeek() {
        return tryPeekByte();
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeShort(short v) {
        BufferPrimitivesKt.writeShort((Buffer) this, v);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeInt(int v) {
        BufferPrimitivesKt.writeInt((Buffer) this, v);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeLong(long v) {
        BufferPrimitivesKt.writeLong((Buffer) this, v);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFloat(float v) {
        BufferPrimitivesKt.writeFloat((Buffer) this, v);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeDouble(double v) {
        BufferPrimitivesKt.writeDouble((Buffer) this, v);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFully(byte[] src, int offset, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesKt.writeFully((Buffer) this, src, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFully(short[] src, int offset, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesKt.writeFully((Buffer) this, src, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFully(int[] src, int offset, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        ByteBuffer writeBuffer = getWriteBuffer();
        int i = length + offset;
        if (offset >= i) {
            return;
        }
        while (true) {
            int i2 = offset + 1;
            writeBuffer.putInt(src[offset]);
            if (i2 >= i) {
                return;
            } else {
                offset = i2;
            }
        }
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFully(long[] src, int offset, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesKt.writeFully((Buffer) this, src, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFully(float[] src, int offset, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesKt.writeFully((Buffer) this, src, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFully(double[] src, int offset, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesKt.writeFully(this, src, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void writeFully(IoBuffer src, int length) {
        Intrinsics.checkNotNullParameter(src, "src");
        BufferPrimitivesKt.writeFully(this, src, length);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public /* synthetic */ void writeFully(ByteBuffer bb) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        BufferPrimitivesJvmKt.writeFully(this, bb);
    }

    @Override // java.lang.Appendable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ Appendable append(CharSequence csq, int start, int end) {
        BufferCompatibilityKt.append(this, csq, start, end);
        return this;
    }

    @Override // java.lang.Appendable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ Appendable append(CharSequence csq) {
        BufferCompatibilityKt.append(this, csq);
        return this;
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ Appendable append(char[] csq, int start, int end) {
        Intrinsics.checkNotNullParameter(csq, "csq");
        if (BufferCompatibilityKt.appendChars(this, csq, start, end) != end) {
            throw new IllegalStateException("Not enough free space to append char sequence");
        }
        return this;
    }

    @Override // java.lang.Appendable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public /* synthetic */ Appendable append(char c) {
        BufferCompatibilityKt.append(this, c);
        return this;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int appendChars(char[] csq, int start, int end) {
        Intrinsics.checkNotNullParameter(csq, "csq");
        return BufferCompatibilityKt.appendChars(this, csq, start, end);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int appendChars(CharSequence csq, int start, int end) {
        Intrinsics.checkNotNullParameter(csq, "csq");
        return BufferCompatibilityKt.appendChars(this, csq, start, end);
    }

    @Override // io.ktor.utils.p098io.core.Output
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void fill(long n, byte v) {
        BufferCompatibilityKt.fill(this, n, v);
    }

    public final int readDirect(Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int readPosition = getReadPosition();
        int writePosition = getWritePosition();
        ByteBuffer byteBufferDuplicate = getMemory().duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        block.invoke(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() - readPosition;
        if (iPosition < 0) {
            ErrorsKt.negativeShiftError(iPosition);
            throw new KotlinNothingValueException();
        }
        if (byteBufferDuplicate.limit() != writePosition) {
            ErrorsKt.limitChangeError();
            throw new KotlinNothingValueException();
        }
        discard(iPosition);
        return iPosition;
    }

    public final int writeDirect(final int size, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        IoBuffer ioBuffer = this;
        final int limit = ioBuffer.getLimit() - ioBuffer.getWritePosition();
        if (size <= limit) {
            ByteBuffer byteBufferDuplicate = getMemory().duplicate();
            Intrinsics.checkNotNull(byteBufferDuplicate);
            int writePosition = getWritePosition();
            block.invoke(byteBufferDuplicate);
            int iPosition = byteBufferDuplicate.position() - writePosition;
            if (iPosition < 0 || iPosition > limit) {
                ErrorsKt.wrongBufferPositionChangeError(iPosition, size);
                throw new KotlinNothingValueException();
            }
            commitWritten(iPosition);
            return iPosition;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.IoBuffer$writeDirect$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException("size " + size + " is greater than buffer's remaining capacity " + limit);
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ short readShort() {
        return InputPrimitivesKt.readShort(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readInt() {
        return InputPrimitivesKt.readInt(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ long readLong() {
        return InputPrimitivesKt.readLong(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ float readFloat() {
        return InputPrimitivesKt.readFloat(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ double readDouble() {
        return InputPrimitivesKt.readDouble(this);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(byte[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        BufferPrimitivesKt.readFully((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readAvailable(byte[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return BufferPrimitivesKt.readAvailable((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(IoBuffer dst, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        BufferPrimitivesKt.readFully(this, dst, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readAvailable(IoBuffer dst, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return BufferPrimitivesKt.readAvailable(this, dst, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(short[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        BufferPrimitivesKt.readFully((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(int[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        BufferPrimitivesKt.readFully((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(long[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        BufferPrimitivesKt.readFully((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(double[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        BufferPrimitivesKt.readFully(this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(float[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        BufferPrimitivesKt.readFully((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readAvailable(short[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return BufferPrimitivesKt.readAvailable((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readAvailable(int[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return BufferPrimitivesKt.readAvailable((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readAvailable(long[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return BufferPrimitivesKt.readAvailable((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readAvailable(float[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return BufferPrimitivesKt.readAvailable((Buffer) this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readAvailable(double[] dst, int offset, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return BufferPrimitivesKt.readAvailable(this, dst, offset, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readAvailable(ByteBuffer dst, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return IoBufferJVMKt.readAvailable(this, dst, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void readFully(ByteBuffer dst, int length) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        IoBufferJVMKt.readFully(this, dst, length);
    }

    @Override // io.ktor.utils.p098io.core.Input
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int peekTo(IoBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return InputPeekKt.peekTo$default((Input) this, (Buffer) buffer, 0, 0, 0, 14, (Object) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ void pushBack(int n) {
        rewind(n);
    }

    @DangerousInternalIoApi
    public final void resetFromContentToWrite(ByteBuffer child) {
        Intrinsics.checkNotNullParameter(child, "child");
        resetForWrite(child.limit());
        commitWrittenUntilIndex(child.position());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ boolean isExclusivelyOwned() {
        return ChunkBufferKt.isExclusivelyOwned(this);
    }

    @Override // io.ktor.utils.p098io.core.internal.ChunkBuffer, io.ktor.utils.p098io.core.Buffer
    /* JADX INFO: renamed from: duplicate, reason: merged with bridge method [inline-methods] */
    public IoBuffer makeView() {
        IoBuffer origin = getOrigin();
        if (origin == null) {
            origin = this;
        }
        origin.acquire$ktor_io();
        ByteBuffer byteBuffer = getMemory();
        ObjectPool<ChunkBuffer> parentPool$ktor_io = getParentPool$ktor_io();
        if (parentPool$ktor_io != null) {
            IoBuffer ioBuffer = new IoBuffer(byteBuffer, origin, parentPool$ktor_io, null);
            duplicateTo(ioBuffer);
            return ioBuffer;
        }
        throw new NullPointerException("null cannot be cast to non-null type io.ktor.utils.io.pool.ObjectPool<io.ktor.utils.io.core.IoBuffer>");
    }

    @Override // io.ktor.utils.p098io.core.Input, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("close for buffer view is not supported");
    }

    public static /* synthetic */ int readText$default(IoBuffer ioBuffer, CharsetDecoder charsetDecoder, Appendable appendable, boolean z, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        return ioBuffer.readText(charsetDecoder, appendable, z, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public final /* synthetic */ int readText(CharsetDecoder decoder, Appendable out, boolean lastBuffer, int max) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(out, "out");
        return BufferCompatibilityKt.readText(this, decoder, out, lastBuffer, max);
    }

    @Override // io.ktor.utils.p098io.core.internal.ChunkBuffer
    public final void release(ObjectPool<IoBuffer> pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        BuffersKt.releaseImpl(this, pool);
    }

    @Override // io.ktor.utils.p098io.core.Buffer
    public String toString() {
        IoBuffer ioBuffer = this;
        return "Buffer[readable = " + (ioBuffer.getWritePosition() - ioBuffer.getReadPosition()) + ", writable = " + (ioBuffer.getLimit() - ioBuffer.getWritePosition()) + ", startGap = " + getStartGap() + ", endGap = " + (ioBuffer.getCapacity() - ioBuffer.getLimit()) + ']';
    }

    /* JADX INFO: compiled from: IoBufferJVM.kt */
    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m5598d2 = {"Lio/ktor/utils/io/core/IoBuffer$Companion;", "", "()V", "DEFAULT_BUFFER_POOL_DIRECT", "", "DEFAULT_BUFFER_POOL_SIZE", "DEFAULT_BUFFER_SIZE", "Empty", "Lio/ktor/utils/io/core/IoBuffer;", "getEmpty", "()Lio/ktor/utils/io/core/IoBuffer;", "EmptyPool", "Lio/ktor/utils/io/pool/ObjectPool;", "getEmptyPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "NoPool", "getNoPool", "Pool", "getPool", "ReservedSize", "getReservedSize$annotations", "getReservedSize", "()I", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @DangerousInternalIoApi
        public static /* synthetic */ void getReservedSize$annotations() {
        }

        public final int getReservedSize() {
            return 8;
        }

        private Companion() {
        }

        public final IoBuffer getEmpty() {
            return IoBuffer.Empty;
        }

        public final ObjectPool<IoBuffer> getPool() {
            return IoBuffer.Pool;
        }

        public final ObjectPool<IoBuffer> getNoPool() {
            return IoBuffer.NoPool;
        }

        public final ObjectPool<IoBuffer> getEmptyPool() {
            return IoBuffer.EmptyPool;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final int iOIntProperty = AtomicKt.getIOIntProperty("buffer.pool.size", 100);
        DEFAULT_BUFFER_POOL_SIZE = iOIntProperty;
        DEFAULT_BUFFER_POOL_DIRECT = AtomicKt.getIOIntProperty("buffer.pool.direct", 0);
        Empty = new IoBuffer(Memory.INSTANCE.m6967getEmptySK3TCg8(), 0 == true ? 1 : 0, EmptyBufferPoolImpl.INSTANCE, 0 == true ? 1 : 0);
        Pool = new DefaultPool<IoBuffer>(iOIntProperty) { // from class: io.ktor.utils.io.core.IoBuffer$Companion$Pool$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.ktor.utils.p098io.pool.DefaultPool
            public IoBuffer produceInstance() {
                ByteBuffer buffer = IoBuffer.DEFAULT_BUFFER_POOL_DIRECT == 0 ? ByteBuffer.allocate(IoBuffer.DEFAULT_BUFFER_SIZE) : ByteBuffer.allocateDirect(IoBuffer.DEFAULT_BUFFER_SIZE);
                Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
                return new IoBuffer(buffer);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.ktor.utils.p098io.pool.DefaultPool
            public void disposeInstance(IoBuffer instance) {
                Intrinsics.checkNotNullParameter(instance, "instance");
                instance.unlink$ktor_io();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.ktor.utils.p098io.pool.DefaultPool
            public IoBuffer clearInstance(IoBuffer instance) {
                Intrinsics.checkNotNullParameter(instance, "instance");
                instance.unpark$ktor_io();
                instance.reset();
                return instance;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.ktor.utils.p098io.pool.DefaultPool
            public void validateInstance(IoBuffer instance) {
                Intrinsics.checkNotNullParameter(instance, "instance");
                if (instance.getRefCount() == 0) {
                    if (instance.getOrigin() == null) {
                        return;
                    }
                    new RequireFailureCapture() { // from class: io.ktor.utils.io.core.IoBuffer$Companion$Pool$1$validateInstance$$inlined$require$2
                        @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                        public Void doFail() {
                            throw new IllegalArgumentException("Unable to recycle buffer view, only origin buffers are applicable");
                        }
                    }.doFail();
                    throw new KotlinNothingValueException();
                }
                new RequireFailureCapture() { // from class: io.ktor.utils.io.core.IoBuffer$Companion$Pool$1$validateInstance$$inlined$require$1
                    @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                    public Void doFail() {
                        throw new IllegalArgumentException("Buffer is not yet released but tried to recycle");
                    }
                }.doFail();
                throw new KotlinNothingValueException();
            }
        };
        NoPool = new NoPoolImpl<IoBuffer>() { // from class: io.ktor.utils.io.core.IoBuffer$Companion$NoPool$1
            @Override // io.ktor.utils.p098io.pool.ObjectPool
            public IoBuffer borrow() {
                ByteBuffer buffer = IoBuffer.DEFAULT_BUFFER_POOL_DIRECT == 0 ? ByteBuffer.allocate(IoBuffer.DEFAULT_BUFFER_SIZE) : ByteBuffer.allocateDirect(IoBuffer.DEFAULT_BUFFER_SIZE);
                Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
                return new IoBuffer(buffer);
            }
        };
        EmptyPool = EmptyBufferPoolImpl.INSTANCE;
    }
}
