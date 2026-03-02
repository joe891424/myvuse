package io.ktor.utils.p098io.nio;

import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Output.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, m5598d2 = {"asOutput", "Lio/ktor/utils/io/core/Output;", "Ljava/nio/channels/WritableByteChannel;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class OutputKt {
    public static /* synthetic */ Output asOutput$default(WritableByteChannel writableByteChannel, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            objectPool = ChunkBuffer.INSTANCE.getPool();
        }
        return asOutput(writableByteChannel, objectPool);
    }

    public static final Output asOutput(WritableByteChannel writableByteChannel, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(pool, "pool");
        return new ChannelAsOutput(pool, writableByteChannel);
    }
}
