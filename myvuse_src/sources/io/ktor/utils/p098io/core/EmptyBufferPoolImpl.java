package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.pool.NoPoolImpl;
import kotlin.Metadata;

/* JADX INFO: compiled from: Buffers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, m5598d2 = {"Lio/ktor/utils/io/core/EmptyBufferPoolImpl;", "Lio/ktor/utils/io/pool/NoPoolImpl;", "Lio/ktor/utils/io/core/IoBuffer;", "()V", "borrow", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class EmptyBufferPoolImpl extends NoPoolImpl<IoBuffer> {
    public static final EmptyBufferPoolImpl INSTANCE = new EmptyBufferPoolImpl();

    private EmptyBufferPoolImpl() {
    }

    @Override // io.ktor.utils.p098io.pool.ObjectPool
    public IoBuffer borrow() {
        return IoBuffer.INSTANCE.getEmpty();
    }
}
