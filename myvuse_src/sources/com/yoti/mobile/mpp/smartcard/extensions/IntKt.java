package com.yoti.mobile.mpp.smartcard.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Int.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0001H\u0007¨\u0006\b"}, m5598d2 = {"calcNumBytes", "", "value", "toByteArray", "", "capacity", "toStringHex", "", "smartcard-common"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IntKt {
    public static final byte[] toByteArray(int i) {
        return toByteArray(i, calcNumBytes(i));
    }

    public static final byte[] toByteArray(int i, int i2) {
        if (i2 < 0 || i2 > 4) {
            throw new IllegalArgumentException("Capacity must be in the range (0, 4]");
        }
        if (i2 < calcNumBytes(i)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Not enough capacity to represent ", Integer.valueOf(i)));
        }
        byte[] bArr = new byte[i2];
        int i3 = i2 - 1;
        if (i3 >= 0) {
            int i4 = 0;
            while (true) {
                int i5 = i3 - 1;
                bArr[i3] = (byte) (i >>> i4);
                i4 += 8;
                if (i5 < 0) {
                    break;
                }
                i3 = i5;
            }
        }
        return bArr;
    }

    private static final int calcNumBytes(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Only positive numbers allowed");
        }
        int i2 = 0;
        do {
            i2++;
            i >>= 8;
        } while (i > 0);
        return i2;
    }

    public static final String toStringHex(int i) {
        return ByteArrayKt.toStringHex(toByteArray(i));
    }
}
