package io.ktor.utils.p098io.bits;

import io.ktor.utils.p098io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryFactoryJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, m5598d2 = {"Lio/ktor/utils/io/bits/DefaultAllocator;", "Lio/ktor/utils/io/bits/Allocator;", "()V", "alloc", "Lio/ktor/utils/io/bits/Memory;", "size", "", "alloc-SK3TCg8", "(I)Ljava/nio/ByteBuffer;", "", "(J)Ljava/nio/ByteBuffer;", "free", "", "instance", "free-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class DefaultAllocator implements Allocator {
    public static final DefaultAllocator INSTANCE = new DefaultAllocator();

    @Override // io.ktor.utils.p098io.bits.Allocator
    /* JADX INFO: renamed from: free-3GNKZMM */
    public void mo6946free3GNKZMM(ByteBuffer instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    private DefaultAllocator() {
    }

    @Override // io.ktor.utils.p098io.bits.Allocator
    /* JADX INFO: renamed from: alloc-SK3TCg8 */
    public ByteBuffer mo6944allocSK3TCg8(int size) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(size)");
        return Memory.m6951constructorimpl(byteBufferAllocate);
    }

    @Override // io.ktor.utils.p098io.bits.Allocator
    /* JADX INFO: renamed from: alloc-SK3TCg8 */
    public ByteBuffer mo6945allocSK3TCg8(long size) {
        if (size < 2147483647L) {
            return mo6944allocSK3TCg8((int) size);
        }
        NumbersKt.failLongToIntConversion(size, "size");
        throw new KotlinNothingValueException();
    }
}
