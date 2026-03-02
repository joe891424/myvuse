package io.ktor.utils.p098io.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Builder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\n\u0010\t\u001a\u00020\u0007*\u00020\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, m5598d2 = {"buildPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "headerSizeHint", "", "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "", "Lkotlin/ExtensionFunctionType;", "reset", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class BuilderKt {
    public static /* synthetic */ ByteReadPacket buildPacket$default(int i, Function1 block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(i);
        try {
            block.invoke(BytePacketBuilder);
            return BytePacketBuilder.build();
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }

    public static final ByteReadPacket buildPacket(int i, Function1<? super BytePacketBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(i);
        try {
            block.invoke(BytePacketBuilder);
            return BytePacketBuilder.build();
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }

    public static final void reset(BytePacketBuilder bytePacketBuilder) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        bytePacketBuilder.release();
    }
}
