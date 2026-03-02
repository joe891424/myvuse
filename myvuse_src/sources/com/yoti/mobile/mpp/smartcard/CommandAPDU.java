package com.yoti.mobile.mpp.smartcard;

import com.yoti.mobile.mpp.smartcard.extensions.ByteArrayKt;
import com.yoti.mobile.mpp.smartcard.extensions.IntKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommandAPDU.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u001d\u001a\u00020\u0000J\u0006\u0010\u001e\u001a\u00020\u000bJ\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000e¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/mpp/smartcard/CommandAPDU;", "", "cla", "", "ins", "p1", "p2", "data", "", "le", "forceExtendedMode", "", "(IIII[BLjava/lang/Integer;Z)V", "getCla", "()I", "commandCase", "getData", "()[B", "extendedMode", "getExtendedMode", "()Z", "getIns", "lc", "getLc", "getLe", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getP1", "getP2", "clone", "hasData", "toBytes", "toString", "", "smartcard-common"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class CommandAPDU {
    private final int cla;
    private final int commandCase;
    private final byte[] data;
    private final boolean extendedMode;
    private final boolean forceExtendedMode;
    private final int ins;
    private final Integer le;
    private final int p1;
    private final int p2;

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CommandAPDU(int r1, int r2, int r3, int r4, byte[] r5, java.lang.Integer r6, boolean r7) {
        /*
            r0 = this;
            r0.<init>()
            r0.cla = r1
            r0.ins = r2
            r0.p1 = r3
            r0.p2 = r4
            r0.data = r5
            r0.le = r6
            r0.forceExtendedMode = r7
            r1 = 0
            if (r5 != 0) goto L16
            r2 = r1
            goto L17
        L16:
            int r2 = r5.length
        L17:
            r3 = 65536(0x10000, float:9.1835E-41)
            if (r2 > r3) goto L53
            r2 = 1
            if (r5 == 0) goto L2c
            int r3 = r5.length
            if (r3 != 0) goto L23
            r3 = r2
            goto L24
        L23:
            r3 = r1
        L24:
            if (r3 != 0) goto L2c
            if (r6 == 0) goto L2a
            r3 = 4
            goto L31
        L2a:
            r3 = 3
            goto L31
        L2c:
            if (r6 == 0) goto L30
            r3 = 2
            goto L31
        L30:
            r3 = r2
        L31:
            r0.commandCase = r3
            if (r7 == 0) goto L37
            if (r3 != r2) goto L4f
        L37:
            boolean r3 = r0.hasData()
            r4 = 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L45
            int r3 = r0.getLc()
            if (r3 > r4) goto L4f
        L45:
            if (r6 != 0) goto L49
            r3 = r1
            goto L4d
        L49:
            int r3 = r6.intValue()
        L4d:
            if (r3 <= r4) goto L50
        L4f:
            r1 = r2
        L50:
            r0.extendedMode = r1
            return
        L53:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Extended APDU not supported. Data must be 0..65536 bytes"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.smartcard.CommandAPDU.<init>(int, int, int, int, byte[], java.lang.Integer, boolean):void");
    }

    public /* synthetic */ CommandAPDU(int i, int i2, int i3, int i4, byte[] bArr, Integer num, boolean z, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, (i5 & 16) != 0 ? null : bArr, (i5 & 32) != 0 ? null : num, (i5 & 64) != 0 ? false : z);
    }

    public final int getCla() {
        return this.cla;
    }

    public final int getIns() {
        return this.ins;
    }

    public final int getP1() {
        return this.p1;
    }

    public final int getP2() {
        return this.p2;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final Integer getLe() {
        return this.le;
    }

    public final boolean getExtendedMode() {
        return this.extendedMode;
    }

    public final boolean hasData() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return false;
        }
        return !(bArr.length == 0);
    }

    public final int getLc() {
        if (!hasData()) {
            throw new IllegalStateException("This command does not have data".toString());
        }
        byte[] bArr = this.data;
        Intrinsics.checkNotNull(bArr);
        return bArr.length;
    }

    public byte[] toBytes() {
        boolean z = this.extendedMode;
        int length = 5;
        int length2 = z ? 5 : 4;
        int i = z ? 2 : 1;
        if (hasData()) {
            byte[] bArr = this.data;
            Intrinsics.checkNotNull(bArr);
            length2 = length2 + i + bArr.length;
        }
        if (this.le != null) {
            length2 += i;
        }
        byte[] bArr2 = new byte[length2];
        bArr2[0] = (byte) this.cla;
        bArr2[1] = (byte) this.ins;
        bArr2[2] = (byte) this.p1;
        bArr2[3] = (byte) this.p2;
        if (this.extendedMode) {
            bArr2[4] = 0;
        } else {
            length = 4;
        }
        if (hasData()) {
            if (this.extendedMode) {
                bArr2[length] = (byte) (getLc() >>> 8);
                length++;
            }
            int i2 = length + 1;
            bArr2[length] = (byte) getLc();
            byte[] bArr3 = this.data;
            Intrinsics.checkNotNull(bArr3);
            ArraysKt.copyInto$default(bArr3, bArr2, i2, 0, 0, 12, (Object) null);
            length = this.data.length + i2;
        }
        Integer num = this.le;
        if (num != null) {
            if (this.extendedMode) {
                bArr2[length] = (byte) (num.intValue() >>> 8);
                length++;
            }
            bArr2[length] = (byte) this.le.intValue();
        }
        return bArr2;
    }

    public final CommandAPDU clone() {
        byte[] bArrCopyOf;
        byte[] bArr = this.data;
        if (bArr == null) {
            bArrCopyOf = null;
        } else {
            bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        }
        return new CommandAPDU(this.cla, this.ins, this.p1, this.p2, bArrCopyOf, this.le, this.forceExtendedMode);
    }

    public String toString() {
        String str = "Command: " + ByteArrayKt.toStringHex(toBytes()) + "\nExtended: " + this.extendedMode + "\nCase " + this.commandCase + " -> | CLA: " + IntKt.toStringHex(this.cla) + " | INS: " + IntKt.toStringHex(this.ins) + " | P1: " + IntKt.toStringHex(this.p1) + " | P2: " + IntKt.toStringHex(this.p2) + " |";
        if (this.data != null) {
            str = str + " Lc: " + IntKt.toStringHex(getLc()) + " | Data: " + this.data.length + " bytes |";
        }
        return this.le != null ? str + " Le: " + IntKt.toStringHex(this.le.intValue()) + " |" : str;
    }
}
