package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.pool.ObjectPool;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteReadPacket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "Will be removed in future releases.", replaceWith = @ReplaceWith(expression = "AbstractInput", imports = {"io.ktor.utils.io.core.AbstractInput"}))
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m5598d2 = {"Lio/ktor/utils/io/core/ByteReadPacketPlatformBase;", "Lio/ktor/utils/io/core/ByteReadPacketBase;", "head", "Lio/ktor/utils/io/core/IoBuffer;", "remaining", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/core/IoBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
@DangerousInternalIoApi
public abstract class ByteReadPacketPlatformBase extends ByteReadPacketBase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected ByteReadPacketPlatformBase(ChunkBuffer head, long j, ObjectPool<ChunkBuffer> pool) {
        super(head, j, pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ ByteReadPacketPlatformBase(IoBuffer head, long j, ObjectPool pool) {
        this((ChunkBuffer) head, j, (ObjectPool<ChunkBuffer>) pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
    }
}
