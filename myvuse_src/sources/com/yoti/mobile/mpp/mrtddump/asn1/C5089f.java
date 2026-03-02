package com.yoti.mobile.mpp.mrtddump.asn1;

import io.ktor.utils.p098io.core.ByteReadPacket;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.f */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m5598d2 = {"readByteJavaCompliant", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5089f {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static final int m5452b(ByteReadPacket byteReadPacket) {
        if (byteReadPacket.getRemaining() <= 0) {
            return -1;
        }
        return byteReadPacket.readByte() & 255;
    }
}
