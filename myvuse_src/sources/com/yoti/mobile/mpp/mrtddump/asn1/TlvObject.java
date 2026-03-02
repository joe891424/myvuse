package com.yoti.mobile.mpp.mrtddump.asn1;

import com.yoti.mobile.mpp.mrtddump.MrtdUnexpectedDataFormatException;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.OutputKt;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.StringsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwx.HeaderParameterNames;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.e.d, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0003H\u0002J$\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u0003H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/asn1/TlvObject;", "", HeaderParameterNames.AUTHENTICATION_TAG, "", "_data", "", "(I[B)V", "get_data", "()[B", "set_data", "([B)V", "data", "getData", "encoded", "getEncoded", "intValue", "getIntValue", "()I", "stringValue", "", "getStringValue$annotations", "()V", "getStringValue", "()Ljava/lang/String;", "getTag", "writeLength", "", "outputStream", "Lio/ktor/utils/io/core/BytePacketBuilder;", "length", "writeTag", "flags", "tagNo", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class TlvObject {

    /* JADX INFO: renamed from: a */
    private final int f8036a;

    /* JADX INFO: renamed from: b */
    private byte[] f8037b;

    public TlvObject(int i, byte[] _data) {
        Intrinsics.checkNotNullParameter(_data, "_data");
        this.f8036a = i;
        this.f8037b = _data;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m5434a(TlvObject tlvObject, BytePacketBuilder bytePacketBuilder, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeTag");
        }
        if ((i3 & 2) != 0) {
            i = tlvObject.f8036a & ISO7816Kt.INS_CREATE_FILE;
        }
        if ((i3 & 4) != 0) {
            i2 = tlvObject.f8036a & 31;
        }
        tlvObject.m5437a(bytePacketBuilder, i, i2);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m5435a(TlvObject tlvObject, BytePacketBuilder bytePacketBuilder, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeLength");
        }
        if ((i2 & 2) != 0) {
            i = tlvObject.f8037b.length;
        }
        tlvObject.m5436a(bytePacketBuilder, i);
    }

    /* JADX INFO: renamed from: a */
    private final void m5436a(BytePacketBuilder bytePacketBuilder, int i) {
        if (i <= 127) {
            bytePacketBuilder.writeByte((byte) i);
            return;
        }
        byte[] byteArray = IntKt.toByteArray(i);
        bytePacketBuilder.writeByte((byte) (byteArray.length | 128));
        OutputKt.writeFully((Output) bytePacketBuilder, byteArray, 0, byteArray.length);
    }

    /* JADX INFO: renamed from: a */
    private final void m5437a(BytePacketBuilder bytePacketBuilder, int i, int i2) {
        byte b;
        if (i2 < 31) {
            b = (byte) (i | i2);
        } else {
            bytePacketBuilder.writeByte((byte) (i | 31));
            if (i2 >= 128) {
                byte[] bArr = new byte[5];
                int i3 = 4;
                bArr[4] = (byte) (i2 & 127);
                do {
                    i2 >>= 7;
                    i3--;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                } while (i2 > 127);
                OutputKt.writeFully((Output) bytePacketBuilder, bArr, i3, 5 - i3);
                return;
            }
            b = (byte) i2;
        }
        bytePacketBuilder.writeByte(b);
    }

    /* JADX INFO: renamed from: a */
    protected final void m5438a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.f8037b = bArr;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final byte[] getF8037b() {
        return this.f8037b;
    }

    /* JADX INFO: renamed from: b */
    public final byte[] m5440b() {
        BytePacketBuilder bytePacketBuilderBytePacketBuilder$default = PacketJVMKt.BytePacketBuilder$default(0, 1, null);
        m5434a(this, bytePacketBuilderBytePacketBuilder$default, 0, 0, 6, null);
        m5435a(this, bytePacketBuilderBytePacketBuilder$default, 0, 2, null);
        OutputKt.writeFully((Output) bytePacketBuilderBytePacketBuilder$default, getF8037b(), 0, getF8037b().length);
        return StringsKt.readBytes$default(bytePacketBuilderBytePacketBuilder$default.build(), 0, 1, null);
    }

    /* JADX INFO: renamed from: c */
    public final int m5441c() throws MrtdUnexpectedDataFormatException {
        if (getF8037b().length > 4) {
            throw new MrtdUnexpectedDataFormatException("Unexpected length for TLV int", null, 2, null);
        }
        byte[] f8037b = getF8037b();
        int length = f8037b.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = f8037b[i];
            i++;
            i2 = (i2 << 8) | (b & 255);
        }
        return i2;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getF8036a() {
        return this.f8036a;
    }

    /* JADX INFO: renamed from: e */
    protected final byte[] m5443e() {
        return this.f8037b;
    }
}
