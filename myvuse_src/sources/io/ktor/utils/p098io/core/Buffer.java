package io.ktor.utils.p098io.core;

import com.facebook.react.uimanager.ViewProps;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.core.internal.RequireFailureCapture;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u0000 K2\u00020\u0001:\u0001KB\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0010H\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0010H\u0001J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0007J\u0010\u0010/\u001a\u0002002\u0006\u0010+\u001a\u000200H\u0007J\u0010\u00101\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0010J\u0015\u00102\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0010H\u0000¢\u0006\u0002\b3J\b\u00104\u001a\u00020\u0000H\u0016J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u0000H\u0014J\u0006\u00107\u001a\u000208J\r\u00109\u001a\u00020*H\u0000¢\u0006\u0002\b:J\r\u0010;\u001a\u00020*H\u0000¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u0010H\u0000¢\u0006\u0002\b?J\u000e\u0010@\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010A\u001a\u00020*2\u0006\u0010!\u001a\u00020\u0010J\b\u0010B\u001a\u00020*H\u0016J\u0006\u0010C\u001a\u00020*J\u0006\u0010D\u001a\u00020*J\u000e\u0010D\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010E\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0010J\b\u0010F\u001a\u00020GH\u0016J\u0006\u0010H\u001a\u00020\u0010J\u0006\u0010I\u001a\u00020\u0010J\u000e\u0010J\u001a\u00020*2\u0006\u0010\u0005\u001a\u000208R.\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00018F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0018R\u0012\u0010\u001f\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b \u0010\u0012R$\u0010!\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0018R$\u0010$\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0018R\u0012\u0010'\u001a\u00020\u00108Æ\u0002¢\u0006\u0006\u001a\u0004\b(\u0010\u0012\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006L"}, m5598d2 = {"Lio/ktor/utils/io/core/Buffer;", "", "memory", "Lio/ktor/utils/io/bits/Memory;", "(Ljava/nio/ByteBuffer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "attachment", "getAttachment$annotations", "()V", "getAttachment", "()Ljava/lang/Object;", "setAttachment", "(Ljava/lang/Object;)V", "bufferState", "Lio/ktor/utils/io/core/BufferSharedState;", "capacity", "", "getCapacity", "()I", "endGap", "getEndGap", "limit", "getLimit", "setLimit", "(I)V", "getMemory-SK3TCg8", "()Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "readPosition", "getReadPosition", "setReadPosition", "readRemaining", "getReadRemaining", "startGap", "getStartGap", "setStartGap", "writePosition", "getWritePosition", "setWritePosition", "writeRemaining", "getWriteRemaining", "commitWritten", "", NewHtcHomeBadger.COUNT, "commitWrittenUntilIndex", "", ViewProps.POSITION, "discard", "", "discardExact", "discardUntilIndex", "discardUntilIndex$ktor_io", "duplicate", "duplicateTo", "copy", "readByte", "", "releaseEndGap", "releaseEndGap$ktor_io", "releaseGaps", "releaseGaps$ktor_io", "releaseStartGap", "newReadPosition", "releaseStartGap$ktor_io", "reserveEndGap", "reserveStartGap", "reset", "resetForRead", "resetForWrite", "rewind", "toString", "", "tryPeekByte", "tryReadByte", "writeByte", "Companion", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
@DangerousInternalIoApi
public class Buffer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int ReservedSize = 8;
    private final BufferSharedState bufferState;
    private final int capacity;
    private final ByteBuffer memory;

    public /* synthetic */ Buffer(ByteBuffer byteBuffer, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer);
    }

    @Deprecated(message = "Will be removed. Inherit Buffer and add required fields instead.")
    @ExperimentalIoApi
    public static /* synthetic */ void getAttachment$annotations() {
    }

    private Buffer(ByteBuffer byteBuffer) {
        this.memory = byteBuffer;
        this.bufferState = new BufferSharedState(getMemory().limit());
        this.capacity = getMemory().limit();
    }

    /* JADX INFO: renamed from: getMemory-SK3TCg8, reason: not valid java name and from getter */
    public final ByteBuffer getMemory() {
        return this.memory;
    }

    public final int getReadPosition() {
        return this.bufferState.getReadPosition();
    }

    private final void setReadPosition(int i) {
        this.bufferState.setReadPosition(i);
    }

    public final int getWritePosition() {
        return this.bufferState.getWritePosition();
    }

    private final void setWritePosition(int i) {
        this.bufferState.setWritePosition(i);
    }

    public final int getStartGap() {
        return this.bufferState.getStartGap();
    }

    private final void setStartGap(int i) {
        this.bufferState.setStartGap(i);
    }

    public final int getLimit() {
        return this.bufferState.getLimit();
    }

    private final void setLimit(int i) {
        this.bufferState.setLimit(i);
    }

    public final int getEndGap() {
        return getCapacity() - getLimit();
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final int getReadRemaining() {
        return getWritePosition() - getReadPosition();
    }

    public final int getWriteRemaining() {
        return getLimit() - getWritePosition();
    }

    public final Object getAttachment() {
        return this.bufferState.getAttachment();
    }

    public final void setAttachment(Object obj) {
        this.bufferState.setAttachment(obj);
    }

    public final void discardExact(int count) {
        if (count == 0) {
            return;
        }
        int readPosition = getReadPosition() + count;
        if (count < 0 || readPosition > getWritePosition()) {
            BufferKt.discardFailed(count, getWritePosition() - getReadPosition());
            throw new KotlinNothingValueException();
        }
        setReadPosition(readPosition);
    }

    @DangerousInternalIoApi
    public final void commitWritten(int count) {
        int writePosition = getWritePosition() + count;
        if (count < 0 || writePosition > getLimit()) {
            BufferKt.commitWrittenFailed(count, getLimit() - getWritePosition());
            throw new KotlinNothingValueException();
        }
        setWritePosition(writePosition);
    }

    public final boolean commitWrittenUntilIndex(int position) {
        int limit = getLimit();
        if (position < getWritePosition()) {
            BufferKt.commitWrittenFailed(position - getWritePosition(), getLimit() - getWritePosition());
            throw new KotlinNothingValueException();
        }
        if (position < limit) {
            setWritePosition(position);
            return true;
        }
        if (position == limit) {
            setWritePosition(position);
            return false;
        }
        BufferKt.commitWrittenFailed(position - getWritePosition(), getLimit() - getWritePosition());
        throw new KotlinNothingValueException();
    }

    public final void discardUntilIndex$ktor_io(int position) {
        if (position < 0 || position > getWritePosition()) {
            BufferKt.discardFailed(position - getReadPosition(), getWritePosition() - getReadPosition());
            throw new KotlinNothingValueException();
        }
        if (getReadPosition() != position) {
            setReadPosition(position);
        }
    }

    public static /* synthetic */ void rewind$default(Buffer buffer, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rewind");
        }
        if ((i2 & 1) != 0) {
            i = buffer.getReadPosition() - buffer.getStartGap();
        }
        buffer.rewind(i);
    }

    public final void rewind(int count) {
        int readPosition = getReadPosition() - count;
        if (readPosition < getStartGap()) {
            BufferKt.rewindFailed(count, getReadPosition() - getStartGap());
            throw new KotlinNothingValueException();
        }
        setReadPosition(readPosition);
    }

    public final void reserveStartGap(final int startGap) {
        if (startGap >= 0) {
            if (getReadPosition() >= startGap) {
                setStartGap(startGap);
                return;
            }
            if (getReadPosition() == getWritePosition()) {
                if (startGap > getLimit()) {
                    BufferKt.startGapReservationFailedDueToLimit(this, startGap);
                    throw new KotlinNothingValueException();
                }
                setWritePosition(startGap);
                setReadPosition(startGap);
                setStartGap(startGap);
                return;
            }
            BufferKt.startGapReservationFailed(this, startGap);
            throw new KotlinNothingValueException();
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.Buffer$reserveStartGap$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("startGap shouldn't be negative: ", Integer.valueOf(startGap)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    public final void reserveEndGap(final int endGap) {
        if (endGap >= 0) {
            int i = this.capacity - endGap;
            if (i >= getWritePosition()) {
                setLimit(i);
                return;
            }
            if (i < 0) {
                BufferKt.endGapReservationFailedDueToCapacity(this, endGap);
            }
            if (i < getStartGap()) {
                BufferKt.endGapReservationFailedDueToStartGap(this, endGap);
            }
            if (getReadPosition() == getWritePosition()) {
                setLimit(i);
                setReadPosition(i);
                setWritePosition(i);
                return;
            }
            BufferKt.endGapReservationFailedDueToContent(this, endGap);
            return;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.Buffer$reserveEndGap$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("endGap shouldn't be negative: ", Integer.valueOf(endGap)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    public final void resetForRead() {
        setStartGap(0);
        setReadPosition(0);
        setWritePosition(this.capacity);
    }

    public final void resetForWrite() {
        resetForWrite(this.capacity - getStartGap());
    }

    public final void resetForWrite(int limit) {
        int startGap = getStartGap();
        setReadPosition(startGap);
        setWritePosition(startGap);
        setLimit(limit);
    }

    public final void releaseGaps$ktor_io() {
        releaseStartGap$ktor_io(0);
        releaseEndGap$ktor_io();
    }

    public final void releaseEndGap$ktor_io() {
        setLimit(this.capacity);
    }

    public final void releaseStartGap$ktor_io(final int newReadPosition) {
        if (newReadPosition >= 0) {
            if (newReadPosition <= getReadPosition()) {
                setReadPosition(newReadPosition);
                if (getStartGap() > newReadPosition) {
                    setStartGap(newReadPosition);
                    return;
                }
                return;
            }
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.Buffer$releaseStartGap$$inlined$require$2
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException("newReadPosition shouldn't be ahead of the read position: " + newReadPosition + " > " + this.getReadPosition());
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.Buffer$releaseStartGap$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException(Intrinsics.stringPlus("newReadPosition shouldn't be negative: ", Integer.valueOf(newReadPosition)));
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    protected void duplicateTo(Buffer copy) {
        Intrinsics.checkNotNullParameter(copy, "copy");
        copy.setLimit(getLimit());
        copy.setStartGap(getStartGap());
        copy.setReadPosition(getReadPosition());
        copy.setWritePosition(getWritePosition());
    }

    /* JADX INFO: renamed from: duplicate */
    public Buffer makeView() {
        Buffer buffer = new Buffer(getMemory(), null);
        buffer.duplicateTo(buffer);
        return buffer;
    }

    public final int tryPeekByte() {
        int readPosition = getReadPosition();
        if (readPosition == getWritePosition()) {
            return -1;
        }
        return getMemory().get(readPosition) & 255;
    }

    public final int tryReadByte() {
        int readPosition = getReadPosition();
        if (readPosition == getWritePosition()) {
            return -1;
        }
        setReadPosition(readPosition + 1);
        return getMemory().get(readPosition) & 255;
    }

    public final byte readByte() throws EOFException {
        int readPosition = getReadPosition();
        if (readPosition == getWritePosition()) {
            throw new EOFException("No readable bytes available.");
        }
        setReadPosition(readPosition + 1);
        return getMemory().get(readPosition);
    }

    public final void writeByte(byte value) {
        int writePosition = getWritePosition();
        if (writePosition == getLimit()) {
            throw new InsufficientSpaceException("No free space in the buffer to write a byte");
        }
        getMemory().put(writePosition, value);
        setWritePosition(writePosition + 1);
    }

    public void reset() {
        releaseGaps$ktor_io();
        resetForWrite();
    }

    public String toString() {
        return "Buffer(" + (getWritePosition() - getReadPosition()) + " used, " + (getLimit() - getWritePosition()) + " free, " + (getStartGap() + (getCapacity() - getLimit())) + " reserved of " + this.capacity + ')';
    }

    /* JADX INFO: compiled from: Buffer.kt */
    @Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u00048F¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002¨\u0006\u000b"}, m5598d2 = {"Lio/ktor/utils/io/core/Buffer$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/core/Buffer;", "getEmpty$annotations", "getEmpty", "()Lio/ktor/utils/io/core/Buffer;", "ReservedSize", "", "getReservedSize$annotations", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEmpty$annotations() {
        }

        @DangerousInternalIoApi
        public static /* synthetic */ void getReservedSize$annotations() {
        }

        private Companion() {
        }

        public final Buffer getEmpty() {
            return IoBuffer.INSTANCE.getEmpty();
        }
    }

    public static /* synthetic */ void discardExact$default(Buffer buffer, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: discardExact");
        }
        if ((i2 & 1) != 0) {
            i = buffer.getWritePosition() - buffer.getReadPosition();
        }
        buffer.discardExact(i);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use discardExact instead.")
    public final int discard(int count) {
        int iMin = Math.min(count, getWritePosition() - getReadPosition());
        discardExact(iMin);
        return iMin;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use discardExact instead.")
    public final long discard(long count) {
        int iMin = (int) Math.min(count, getWritePosition() - getReadPosition());
        discardExact(iMin);
        return iMin;
    }
}
