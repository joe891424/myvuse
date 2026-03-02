package com.yoti.mobile.mpp.mrtddump.reader;

import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.OutputKt;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.StringsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.e, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\bj\u0002`\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00060\bj\u0002`\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/TransparentFileBuilder;", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileBuilder;", "()V", "currentSize", "", "getCurrentSize", "()I", "rawValue", "", "Lcom/yoti/mobile/mpp/mrtddump/FileData;", "getRawValue", "()[B", "requiredSize", "getRequiredSize", "stream", "Lio/ktor/utils/io/core/BytePacketBuilder;", "appendBytes", "", "newBytes", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TransparentFileBuilder implements MrtdFileBuilder {

    /* JADX INFO: renamed from: a */
    private final BytePacketBuilder f8186a = PacketJVMKt.BytePacketBuilder$default(0, 1, null);

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: a */
    public void mo5547a(byte[] newBytes) {
        Intrinsics.checkNotNullParameter(newBytes, "newBytes");
        OutputKt.writeFully((Output) this.f8186a, newBytes, 0, newBytes.length);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: a */
    public boolean mo5548a() {
        return MrtdFileBuilder.a.m5554b(this);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: b */
    public int mo5549b() {
        return mo5552e();
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: c */
    public byte[] mo5550c() {
        return StringsKt.readBytes$default(this.f8186a.build(), 0, 1, null);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: d */
    public int mo5551d() {
        return MrtdFileBuilder.a.m5553a(this);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: e */
    public int mo5552e() {
        return this.f8186a.getSize();
    }
}
