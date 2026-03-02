package io.ktor.utils.p098io.core;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import io.ktor.utils.p098io.charsets.CharsetJVMKt;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import io.ktor.utils.p098io.utils.AtomicKt;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: PacketJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u001a\u001e\u0010\u0007\u001a\u00020\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f\u001a*\u0010\r\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003*\n\u0010\u0014\"\u00020\u00152\u00020\u0015¨\u0006\u0016"}, m5598d2 = {"PACKET_MAX_COPY_SIZE", "", "getPACKET_MAX_COPY_SIZE", "()I", "BytePacketBuilder", "Lio/ktor/utils/io/core/BytePacketBuilder;", "headerSizeHint", "readByteBuffer", "Ljava/nio/ByteBuffer;", "Lio/ktor/utils/io/core/ByteReadPacket;", RsaJsonWebKey.MODULUS_MEMBER_NAME, DevicePublicKeyStringDef.DIRECT, "", "readText", "decoder", "Ljava/nio/charset/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "EOFException", "Ljava/io/EOFException;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class PacketJVMKt {
    private static final int PACKET_MAX_COPY_SIZE = AtomicKt.getIOIntProperty("max.copy.size", 500);

    public static final int getPACKET_MAX_COPY_SIZE() {
        return PACKET_MAX_COPY_SIZE;
    }

    public static /* synthetic */ BytePacketBuilder BytePacketBuilder$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return BytePacketBuilder(i);
    }

    public static final BytePacketBuilder BytePacketBuilder(int i) {
        return new BytePacketBuilder(i, ChunkBuffer.INSTANCE.getPool());
    }

    public static /* synthetic */ ByteBuffer readByteBuffer$default(ByteReadPacket byteReadPacket, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            long remaining = byteReadPacket.getRemaining();
            if (remaining > 2147483647L) {
                throw new IllegalArgumentException("Unable to make a ByteBuffer: packet is too big");
            }
            i = (int) remaining;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return readByteBuffer(byteReadPacket, i, z);
    }

    public static final ByteBuffer readByteBuffer(ByteReadPacket byteReadPacket, int i, boolean z) {
        ByteBuffer byteBufferAllocate;
        String str;
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (z) {
            byteBufferAllocate = ByteBuffer.allocateDirect(i);
            str = "allocateDirect(n)";
        } else {
            byteBufferAllocate = ByteBuffer.allocate(i);
            str = "allocate(n)";
        }
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, str);
        ByteBuffersKt.readFully(byteReadPacket, byteBufferAllocate);
        return byteBufferAllocate;
    }

    public static /* synthetic */ int readText$default(ByteReadPacket byteReadPacket, CharsetDecoder charsetDecoder, Appendable appendable, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(byteReadPacket, charsetDecoder, appendable, i);
    }

    @Deprecated(message = "Migrate parameters order", replaceWith = @ReplaceWith(expression = "readText(out, decoder, max)", imports = {}))
    public static final int readText(ByteReadPacket byteReadPacket, CharsetDecoder decoder, Appendable out, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(out, "out");
        return CharsetJVMKt.decode(decoder, byteReadPacket, out, i);
    }
}
