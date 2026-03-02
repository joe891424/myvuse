package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.io.EOFException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputPrimitives.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\u0002H\u0002\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0002\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0002H\u0002\u001aK\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u000e0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0014H\u0082\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u000e0\u0018H\u0082\b¢\u0006\u0002\u0010\u001a\u001a\n\u0010\u001b\u001a\u00020\u001c*\u00020\u0002\u001a\f\u0010\u001d\u001a\u00020\u001c*\u00020\u0002H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m5598d2 = {"readDouble", "", "Lio/ktor/utils/io/core/Input;", "readDoubleFallback", "readFloat", "", "readFloatFallback", "readInt", "", "readIntFallback", "readLong", "", "readLongFallback", "readPrimitive", "R", "size", "main", "Lkotlin/Function2;", "Lio/ktor/utils/io/bits/Memory;", "fallback", "Lkotlin/Function0;", "(Lio/ktor/utils/io/core/Input;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "readPrimitiveFallback", "read", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "(Lio/ktor/utils/io/core/Input;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "readShort", "", "readShortFallback", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class InputPrimitivesKt {
    private static final <R> R readPrimitive(Input input, int i, Function2<? super Memory, ? super Integer, ? extends R> function2, Function0<? extends R> function0) {
        if (input instanceof AbstractInput) {
            AbstractInput abstractInput = (AbstractInput) input;
            if (abstractInput.getHeadEndExclusive() - abstractInput.getHeadPosition() > i) {
                int headPosition = abstractInput.getHeadPosition();
                abstractInput.setHeadPosition(i + headPosition);
                return function2.invoke(Memory.m6950boximpl(abstractInput.m7099getHeadMemorySK3TCg8()), Integer.valueOf(headPosition));
            }
        }
        return function0.invoke();
    }

    private static final <R> R readPrimitiveFallback(Input input, int i, Function1<? super Buffer, ? extends R> function1) throws EOFException {
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, i);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        R rInvoke = function1.invoke(chunkBufferM7223prepareReadFirstHead);
        UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
        return rInvoke;
    }

    public static final short readShort(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input instanceof AbstractInput) {
            AbstractInput abstractInput = (AbstractInput) input;
            if (abstractInput.getHeadEndExclusive() - abstractInput.getHeadPosition() > 2) {
                int headPosition = abstractInput.getHeadPosition();
                abstractInput.setHeadPosition(headPosition + 2);
                return abstractInput.m7099getHeadMemorySK3TCg8().getShort(headPosition);
            }
        }
        return readShortFallback(input);
    }

    private static final short readShortFallback(Input input) throws EOFException {
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 2);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            short s = BufferPrimitivesKt.readShort(chunkBufferM7223prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            return s;
        }
        StringsKt.prematureEndOfStream(2);
        throw new KotlinNothingValueException();
    }

    public static final int readInt(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input instanceof AbstractInput) {
            AbstractInput abstractInput = (AbstractInput) input;
            if (abstractInput.getHeadEndExclusive() - abstractInput.getHeadPosition() > 4) {
                int headPosition = abstractInput.getHeadPosition();
                abstractInput.setHeadPosition(headPosition + 4);
                return abstractInput.m7099getHeadMemorySK3TCg8().getInt(headPosition);
            }
        }
        return readIntFallback(input);
    }

    private static final int readIntFallback(Input input) throws EOFException {
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 4);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            int i = BufferPrimitivesKt.readInt(chunkBufferM7223prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            return i;
        }
        StringsKt.prematureEndOfStream(4);
        throw new KotlinNothingValueException();
    }

    public static final long readLong(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input instanceof AbstractInput) {
            AbstractInput abstractInput = (AbstractInput) input;
            if (abstractInput.getHeadEndExclusive() - abstractInput.getHeadPosition() > 8) {
                int headPosition = abstractInput.getHeadPosition();
                abstractInput.setHeadPosition(headPosition + 8);
                return abstractInput.m7099getHeadMemorySK3TCg8().getLong(headPosition);
            }
        }
        return readLongFallback(input);
    }

    private static final long readLongFallback(Input input) throws EOFException {
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 8);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            long j = BufferPrimitivesKt.readLong(chunkBufferM7223prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            return j;
        }
        StringsKt.prematureEndOfStream(8);
        throw new KotlinNothingValueException();
    }

    public static final float readFloat(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input instanceof AbstractInput) {
            AbstractInput abstractInput = (AbstractInput) input;
            if (abstractInput.getHeadEndExclusive() - abstractInput.getHeadPosition() > 4) {
                int headPosition = abstractInput.getHeadPosition();
                abstractInput.setHeadPosition(headPosition + 4);
                return abstractInput.m7099getHeadMemorySK3TCg8().getFloat(headPosition);
            }
        }
        return readFloatFallback(input);
    }

    public static final float readFloatFallback(Input input) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 4);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            float f = BufferPrimitivesKt.readFloat(chunkBufferM7223prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            return f;
        }
        StringsKt.prematureEndOfStream(4);
        throw new KotlinNothingValueException();
    }

    public static final double readDouble(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input instanceof AbstractInput) {
            AbstractInput abstractInput = (AbstractInput) input;
            if (abstractInput.getHeadEndExclusive() - abstractInput.getHeadPosition() > 8) {
                int headPosition = abstractInput.getHeadPosition();
                abstractInput.setHeadPosition(headPosition + 8);
                return abstractInput.m7099getHeadMemorySK3TCg8().getDouble(headPosition);
            }
        }
        return readDoubleFallback(input);
    }

    public static final double readDoubleFallback(Input input) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 8);
        if (chunkBufferM7223prepareReadFirstHead != null) {
            double d = BufferPrimitivesKt.readDouble(chunkBufferM7223prepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
            return d;
        }
        StringsKt.prematureEndOfStream(8);
        throw new KotlinNothingValueException();
    }
}
