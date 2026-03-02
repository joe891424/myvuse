package io.ktor.utils.p098io.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.uimanager.ViewProps;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.RequireFailureCapture;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BytePacketBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0014\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u0014\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\b\u0014J\u0017\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\b\u0014J'\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0014J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020 H\u0004J*\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0004ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020\u001eH\u0001J6\u0010(\u001a\u0002H)\"\u0004\b\u0000\u0010)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H)0+H\u0007¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020 H\u0007J\b\u00101\u001a\u000202H\u0016R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058@X\u0081\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, m5598d2 = {"Lio/ktor/utils/io/core/BytePacketBuilder;", "Lio/ktor/utils/io/core/BytePacketBuilderPlatformBase;", "headerSizeHint", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(ILio/ktor/utils/io/pool/ObjectPool;)V", "_pool", "get_pool$annotations", "()V", "get_pool", "()Lio/ktor/utils/io/pool/ObjectPool;", "isEmpty", "", "()Z", "isNotEmpty", "size", "getSize", "()I", "append", "c", "", "csq", "", "start", ViewProps.END, "appendOld", "Lio/ktor/utils/io/core/BytePacketBuilderBase;", "build", "Lio/ktor/utils/io/core/ByteReadPacket;", "closeDestination", "", "flush", "source", "Lio/ktor/utils/io/bits/Memory;", TypedValues.CycleType.S_WAVE_OFFSET, "length", "flush-5Mw_xsg", "(Ljava/nio/ByteBuffer;II)V", "preview", "R", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tmp", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "reset", "toString", "", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class BytePacketBuilder extends BytePacketBuilderPlatformBase {
    private int headerSizeHint;

    public static /* synthetic */ void get_pool$annotations() {
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput
    protected final void closeDestination() {
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput
    /* JADX INFO: renamed from: flush-5Mw_xsg */
    protected final void mo7104flush5Mw_xsg(ByteBuffer source, int offset, int length) {
        Intrinsics.checkNotNullParameter(source, "source");
    }

    public /* synthetic */ BytePacketBuilder(int i, ObjectPool objectPool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, objectPool);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytePacketBuilder(int i, ObjectPool<ChunkBuffer> pool) {
        super(pool);
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.headerSizeHint = i;
        if (i >= 0) {
            return;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.BytePacketBuilder$special$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("shouldn't be negative: headerSizeHint = ", Integer.valueOf(this.this$0.headerSizeHint)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    public final int getSize() {
        return get_size();
    }

    public final boolean isEmpty() {
        return get_size() == 0;
    }

    public final boolean isNotEmpty() {
        return get_size() > 0;
    }

    public final ObjectPool<ChunkBuffer> get_pool() {
        return getPool();
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput, java.lang.Appendable
    public BytePacketBuilder append(char c) {
        return (BytePacketBuilder) super.append(c);
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput, java.lang.Appendable
    public BytePacketBuilder append(CharSequence csq) {
        return (BytePacketBuilder) super.append(csq);
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput, java.lang.Appendable
    public BytePacketBuilder append(CharSequence csq, int start, int end) {
        return (BytePacketBuilder) super.append(csq, start, end);
    }

    public final ByteReadPacket build() {
        int size = getSize();
        ChunkBuffer chunkBufferStealAll$ktor_io = stealAll$ktor_io();
        if (chunkBufferStealAll$ktor_io == null) {
            return ByteReadPacket.INSTANCE.getEmpty();
        }
        return new ByteReadPacket(chunkBufferStealAll$ktor_io, size, getPool());
    }

    @Override // io.ktor.utils.p098io.core.AbstractOutput
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ void reset() {
        release();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ ByteReadPacket preview() {
        return PreviewKt.preview(this);
    }

    public String toString() {
        return "BytePacketBuilder(" + getSize() + " bytes written)";
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public final /* synthetic */ Object preview(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ByteReadPacket byteReadPacketPreview = PreviewKt.preview(this);
        try {
            return block.invoke(byteReadPacketPreview);
        } finally {
            byteReadPacketPreview.release();
        }
    }
}
