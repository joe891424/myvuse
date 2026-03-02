package io.ktor.utils.p098io.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BufferPrimitivesJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, m5598d2 = {"readFully", "", "Lio/ktor/utils/io/core/Buffer;", FirebaseAnalytics.Param.DESTINATION, "Ljava/nio/ByteBuffer;", "writeFully", "source", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class BufferPrimitivesJvmKt {
    public static final void readFully(Buffer buffer, ByteBuffer destination) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int iRemaining = destination.remaining();
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= iRemaining) {
            MemoryJvmKt.m6969copyTojqM8g04(memory, destination, readPosition);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(iRemaining);
            return;
        }
        new BufferPrimitivesKt$readExact$lambda56$$inlined$require$1("buffer content", iRemaining).doFail();
        throw new KotlinNothingValueException();
    }

    public static final void writeFully(Buffer buffer, ByteBuffer source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= iRemaining) {
            MemoryJvmKt.m6972copyTorDIWIdE(source, memory, writePosition);
            buffer.commitWritten(iRemaining);
            return;
        }
        throw new InsufficientSpaceException("buffer content", iRemaining, limit);
    }
}
