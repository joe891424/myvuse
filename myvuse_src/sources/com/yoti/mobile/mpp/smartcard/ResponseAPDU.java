package com.yoti.mobile.mpp.smartcard;

import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.OutputKt;
import io.ktor.utils.p098io.core.PacketJVMKt;
import io.ktor.utils.p098io.core.StringsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResponseAPDU.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0000J\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rJ\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001d"}, m5598d2 = {"Lcom/yoti/mobile/mpp/smartcard/ResponseAPDU;", "", "apdu", "", "([B)V", "data", "getData", "()[B", "isSuccess", "", "()Z", "isWarning", "nr", "", "getNr", "()I", "sW1", "getSW1", "sW1SW2", "getSW1SW2", "sW2", "getSW2", "clone", "hasData", "isStatus", "statusWord", "toBytes", "toString", "", "smartcard-common"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class ResponseAPDU {
    private final byte[] data;
    private final boolean isSuccess;
    private final boolean isWarning;
    private final int sW1;
    private final int sW1SW2;
    private final int sW2;

    public ResponseAPDU(byte[] apdu) {
        byte[] bArrCopyOfRange;
        Intrinsics.checkNotNullParameter(apdu, "apdu");
        int i = apdu[apdu.length - 2] & 255;
        this.sW1 = i;
        boolean z = true;
        int i2 = apdu[apdu.length - 1] & 255;
        this.sW2 = i2;
        this.sW1SW2 = i2 | (i << 8);
        this.isSuccess = isStatus(ISO7816Kt.SW_SUCCESS);
        if (i != 99 && i != 98) {
            z = false;
        }
        this.isWarning = z;
        if (apdu.length < 2) {
            throw new IllegalArgumentException("APDU must be at least 2 bytes long");
        }
        if (apdu.length > 2) {
            bArrCopyOfRange = ArraysKt.copyOfRange(apdu, 0, apdu.length - 2);
        } else {
            bArrCopyOfRange = new byte[0];
        }
        this.data = bArrCopyOfRange;
    }

    public final int getSW1() {
        return this.sW1;
    }

    public final int getSW2() {
        return this.sW2;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final int getSW1SW2() {
        return this.sW1SW2;
    }

    /* JADX INFO: renamed from: isSuccess, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* JADX INFO: renamed from: isWarning, reason: from getter */
    public final boolean getIsWarning() {
        return this.isWarning;
    }

    public final int getNr() {
        return this.data.length;
    }

    public final boolean hasData() {
        return !(this.data.length == 0);
    }

    public final boolean isStatus(int statusWord) {
        return this.sW1SW2 == statusWord;
    }

    public String toString() {
        return "Response: | Data: " + this.data.length + " bytes | SW1SW2: " + IntKt.toStringHex(this.sW1SW2) + " |";
    }

    public final ResponseAPDU clone() {
        byte[] bytes = toBytes();
        byte[] bArrCopyOf = Arrays.copyOf(bytes, bytes.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return new ResponseAPDU(bArrCopyOf);
    }

    public byte[] toBytes() {
        BytePacketBuilder BytePacketBuilder = PacketJVMKt.BytePacketBuilder(0);
        try {
            OutputKt.writeFully((Output) BytePacketBuilder, getData(), 0, getData().length);
            BytePacketBuilder.writeByte((byte) (getSW1() & 255));
            BytePacketBuilder.writeByte((byte) (getSW2() & 255));
            return StringsKt.readBytes$default(BytePacketBuilder.build(), 0, 1, null);
        } catch (Throwable th) {
            BytePacketBuilder.release();
            throw th;
        }
    }
}
