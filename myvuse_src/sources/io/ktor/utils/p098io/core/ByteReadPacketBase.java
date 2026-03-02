package io.ktor.utils.p098io.core;

import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.core.internal.DangerousInternalIoApi;
import io.ktor.utils.p098io.pool.ObjectPool;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Packet.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "Will be removed in the future releases. Use Input or AbstractInput instead.", replaceWith = @ReplaceWith(expression = "AbstractInput", imports = {"io.ktor.utils.io.core.AbstractInput"}))
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB#\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\n¨\u0006\f"}, m5598d2 = {"Lio/ktor/utils/io/core/ByteReadPacketBase;", "Lio/ktor/utils/io/core/AbstractInput;", "head", "Lio/ktor/utils/io/core/IoBuffer;", "remaining", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/core/IoBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "Companion", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
@DangerousInternalIoApi
public abstract class ByteReadPacketBase extends AbstractInput {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteReadPacketBase(ChunkBuffer head, long j, ObjectPool<ChunkBuffer> pool) {
        super(head, j, pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ ByteReadPacketBase(IoBuffer head, long j, ObjectPool pool) {
        this((ChunkBuffer) head, j, (ObjectPool<ChunkBuffer>) pool);
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    /* JADX INFO: compiled from: Packet.kt */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lio/ktor/utils/io/core/ByteReadPacketBase$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/core/ByteReadPacket;", "getEmpty$annotations", "getEmpty", "()Lio/ktor/utils/io/core/ByteReadPacket;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use ByteReadPacket.Empty instead", replaceWith = @ReplaceWith(expression = "ByteReadPacket.Empty", imports = {}))
        public static /* synthetic */ void getEmpty$annotations() {
        }

        private Companion() {
        }

        public final ByteReadPacket getEmpty() {
            return ByteReadPacket.INSTANCE.getEmpty();
        }
    }
}
