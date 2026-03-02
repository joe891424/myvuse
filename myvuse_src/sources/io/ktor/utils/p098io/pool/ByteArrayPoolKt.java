package io.ktor.utils.p098io.pool;

import kotlin.Metadata;

/* JADX INFO: compiled from: ByteArrayPool.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5598d2 = {"ByteArrayPool", "Lio/ktor/utils/io/pool/ObjectPool;", "", "getByteArrayPool$annotations", "()V", "getByteArrayPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteArrayPoolKt {
    private static final ObjectPool<byte[]> ByteArrayPool = new DefaultPool<byte[]>() { // from class: io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.p098io.pool.DefaultPool
        public byte[] produceInstance() {
            return new byte[4096];
        }
    };

    public static /* synthetic */ void getByteArrayPool$annotations() {
    }

    public static final ObjectPool<byte[]> getByteArrayPool() {
        return ByteArrayPool;
    }
}
