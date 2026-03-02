package com.yoti.mobile.mpp.mrtddump.reader;

import com.yoti.mobile.mpp.mrtddump.MrtdException;
import com.yoti.mobile.mpp.mrtddump.asn1.PartialTlvObject;
import com.yoti.mobile.mpp.mrtddump.asn1.TlvParser;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.reader.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\bj\u0002`\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00060\bj\u0002`\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/reader/TlvFileBuilder;", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdFileBuilder;", "()V", "currentSize", "", "getCurrentSize", "()I", "rawValue", "", "Lcom/yoti/mobile/mpp/mrtddump/FileData;", "getRawValue", "()[B", "requiredSize", "getRequiredSize", "tlvObject", "Lcom/yoti/mobile/mpp/mrtddump/asn1/PartialTlvObject;", "appendBytes", "", "newBytes", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TlvFileBuilder implements MrtdFileBuilder {

    /* JADX INFO: renamed from: a */
    private PartialTlvObject f8185a;

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: a */
    public void mo5547a(byte[] newBytes) throws MrtdException {
        Intrinsics.checkNotNullParameter(newBytes, "newBytes");
        PartialTlvObject partialTlvObject = this.f8185a;
        if (partialTlvObject == null) {
            PartialTlvObject partialTlvObjectM5447b = new TlvParser(newBytes).m5447b();
            if (partialTlvObjectM5447b == null) {
                throw new MrtdException("Invalid TLV data", null, 2, null);
            }
            this.f8185a = partialTlvObjectM5447b;
            return;
        }
        if (partialTlvObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tlvObject");
            partialTlvObject = null;
        }
        partialTlvObject.m5422b(newBytes);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: a */
    public boolean mo5548a() {
        return MrtdFileBuilder.a.m5554b(this);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: b */
    public int mo5549b() {
        PartialTlvObject partialTlvObject = this.f8185a;
        if (partialTlvObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tlvObject");
            partialTlvObject = null;
        }
        return partialTlvObject.getF8013c();
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: c */
    public byte[] mo5550c() {
        PartialTlvObject partialTlvObject = this.f8185a;
        if (partialTlvObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tlvObject");
            partialTlvObject = null;
        }
        return partialTlvObject.m5440b();
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: d */
    public int mo5551d() {
        return MrtdFileBuilder.a.m5553a(this);
    }

    @Override // com.yoti.mobile.mpp.mrtddump.reader.MrtdFileBuilder
    /* JADX INFO: renamed from: e */
    public int mo5552e() {
        PartialTlvObject partialTlvObject = this.f8185a;
        if (partialTlvObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tlvObject");
            partialTlvObject = null;
        }
        return partialTlvObject.getF8037b().length;
    }
}
