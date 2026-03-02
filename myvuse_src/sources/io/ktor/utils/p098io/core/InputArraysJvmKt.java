package io.ktor.utils.p098io.core;

import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.MemoryJvmKt;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputArraysJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001¨\u0006\b"}, m5598d2 = {"readAvailable", "", "Lio/ktor/utils/io/core/Input;", C4352k.a.f5652f, "Ljava/nio/ByteBuffer;", "length", "readFully", "", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class InputArraysJvmKt {
    public static /* synthetic */ void readFully$default(Input input, ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        readFully(input, byteBuffer, i);
    }

    public static final void readFully(Input input, ByteBuffer dst, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (readAvailable(input, dst, i) >= i) {
            return;
        }
        StringsKt.prematureEndOfStream(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ int readAvailable$default(Input input, ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        return readAvailable(input, byteBuffer, i);
    }

    public static final int readAvailable(Input input, ByteBuffer dst, int i) throws Throwable {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        boolean z = true;
        ChunkBuffer chunkBufferM7223prepareReadFirstHead = UnsafeKt.m7223prepareReadFirstHead(input, 1);
        if (chunkBufferM7223prepareReadFirstHead == null) {
            return 0;
        }
        int i2 = 0;
        do {
            try {
                ChunkBuffer chunkBuffer = chunkBufferM7223prepareReadFirstHead;
                int iLimit = dst.limit();
                int iRemaining = dst.remaining();
                MemoryJvmKt.m6969copyTojqM8g04(chunkBuffer.getMemory(), dst, chunkBuffer.getReadPosition());
                i2 += iRemaining;
                if (dst.hasRemaining() && i2 < i) {
                    try {
                        chunkBufferM7223prepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferM7223prepareReadFirstHead);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (z) {
                            UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                        }
                        throw th;
                    }
                } else {
                    UnsafeKt.completeReadHead(input, chunkBufferM7223prepareReadFirstHead);
                    break;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } while (chunkBufferM7223prepareReadFirstHead != null);
        return i2;
    }
}
