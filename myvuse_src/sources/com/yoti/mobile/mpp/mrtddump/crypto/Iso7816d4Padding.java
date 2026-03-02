package com.yoti.mobile.mpp.mrtddump.crypto;

import com.yoti.mobile.mpp.mrtddump.MrtdCryptoException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.h.c, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/crypto/Iso7816d4Padding;", "", "()V", "pad", "", "toPad", "blockSizeBytes", "", "unpad", "toUnpad", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class Iso7816d4Padding {
    /* JADX INFO: renamed from: a */
    public final byte[] m5484a(byte[] toUnpad) throws MrtdCryptoException {
        byte b;
        Intrinsics.checkNotNullParameter(toUnpad, "toUnpad");
        int length = toUnpad.length;
        do {
            length--;
            b = toUnpad[length];
        } while (b == 0);
        if (b == -128) {
            return ArraysKt.sliceArray(toUnpad, RangesKt.until(0, length));
        }
        throw new MrtdCryptoException(Intrinsics.stringPlus("Invalid padding in decrypted block: ", Byte.valueOf(toUnpad[length])), null, 2, null);
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m5485a(byte[] toPad, int i) {
        Intrinsics.checkNotNullParameter(toPad, "toPad");
        byte[] bArr = new byte[i];
        bArr[0] = -128;
        int length = i - (toPad.length % i);
        byte[] bArr2 = new byte[toPad.length + length];
        ArraysKt.copyInto$default(toPad, bArr2, 0, 0, 0, 14, (Object) null);
        return ArraysKt.copyInto(bArr, bArr2, toPad.length, 0, length);
    }
}
