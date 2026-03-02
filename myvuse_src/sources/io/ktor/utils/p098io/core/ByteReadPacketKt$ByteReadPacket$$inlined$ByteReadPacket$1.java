package io.ktor.utils.p098io.core;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: ByteReadPacketExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¨\u0006\u0004"}, m5598d2 = {"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "io/ktor/utils/io/core/ByteReadPacketExtensionsKt$ByteReadPacket$1"}, m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1 extends Lambda implements Function1<ByteBuffer, Unit> {
    final /* synthetic */ byte[] $array;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteReadPacketKt$ByteReadPacket$$inlined$ByteReadPacket$1(byte[] bArr) {
        super(1);
        this.$array = bArr;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ByteBuffer it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
        invoke2(byteBuffer);
        return Unit.INSTANCE;
    }
}
