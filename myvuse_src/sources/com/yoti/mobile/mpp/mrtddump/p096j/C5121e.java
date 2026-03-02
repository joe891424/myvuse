package com.yoti.mobile.mpp.mrtddump.p096j;

import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.InputPrimitivesKt;
import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.OutputKt;
import io.ktor.utils.p098io.core.OutputPrimitivesKt;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.StringsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.j.e */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\t\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m5598d2 = {"LONG_BYTES", "", "toByteArray", "", "", "toLong", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5121e {
    /* JADX INFO: renamed from: a */
    public static final long m5542a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(0);
        try {
            OutputKt.writeFully((Output) BytePacketBuilder, bArr, 0, 8);
            return InputPrimitivesKt.readLong(BytePacketBuilder.build());
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final byte[] m5543a(long j) {
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(0);
        try {
            OutputPrimitivesKt.writeLong(BytePacketBuilder, j);
            return StringsKt.readBytes(BytePacketBuilder.build(), 8);
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }
}
