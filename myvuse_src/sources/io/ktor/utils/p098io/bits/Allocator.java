package io.ktor.utils.p098io.bits;

import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: compiled from: MemoryFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000f"}, m5598d2 = {"Lio/ktor/utils/io/bits/Allocator;", "", "alloc", "Lio/ktor/utils/io/bits/Memory;", "size", "", "alloc-SK3TCg8", "(I)Ljava/nio/ByteBuffer;", "", "(J)Ljava/nio/ByteBuffer;", "free", "", "instance", "free-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
@DangerousInternalIoApi
public interface Allocator {
    /* JADX INFO: renamed from: alloc-SK3TCg8, reason: not valid java name */
    ByteBuffer mo6944allocSK3TCg8(int size);

    /* JADX INFO: renamed from: alloc-SK3TCg8, reason: not valid java name */
    ByteBuffer mo6945allocSK3TCg8(long size);

    /* JADX INFO: renamed from: free-3GNKZMM, reason: not valid java name */
    void mo6946free3GNKZMM(ByteBuffer instance);
}
