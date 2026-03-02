package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.pool.ObjectPool;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Builder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "Will be removed in future releases.")
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lio/ktor/utils/io/core/BytePacketBuilderPlatformBase;", "Lio/ktor/utils/io/core/BytePacketBuilderBase;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
@DangerousInternalIoApi
public abstract class BytePacketBuilderPlatformBase extends BytePacketBuilderBase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytePacketBuilderPlatformBase(ObjectPool<ChunkBuffer> pool) {
        super(pool);
        Intrinsics.checkNotNullParameter(pool, "pool");
    }
}
