package com.yoti.mobile.mpp.mrtddump.p096j;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.j.a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000\u001a(\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000\u001a2\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000\u001a&\u0010\u0006\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000\u001a0\u0010\u0006\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\b"}, m5598d2 = {"concatenate", "", "array1", "array2", "array3", "array4", "concatenateNonNull", "xor", "mrtddump_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class C5117a {
    /* JADX INFO: renamed from: a */
    public static final byte[] m5521a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null) {
            return bArr;
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        ArraysKt.copyInto$default(bArr, bArr3, 0, 0, 0, 14, (Object) null);
        ArraysKt.copyInto$default(bArr2, bArr3, bArr.length, 0, 0, 12, (Object) null);
        return bArr3;
    }

    /* JADX INFO: renamed from: a */
    public static final byte[] m5522a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return m5521a(bArr2, bArr3);
        }
        if (bArr2 == null) {
            return m5521a(bArr, bArr3);
        }
        if (bArr3 == null) {
            return m5521a(bArr, bArr2);
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        ArraysKt.copyInto$default(bArr, bArr4, 0, 0, 0, 14, (Object) null);
        ArraysKt.copyInto$default(bArr2, bArr4, bArr.length, 0, 0, 12, (Object) null);
        ArraysKt.copyInto$default(bArr3, bArr4, bArr.length + bArr2.length, 0, 0, 12, (Object) null);
        return bArr4;
    }

    /* JADX INFO: renamed from: a */
    public static final byte[] m5523a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr == null) {
            return m5522a(bArr2, bArr3, bArr4);
        }
        if (bArr2 == null) {
            return m5522a(bArr, bArr3, bArr4);
        }
        if (bArr3 == null) {
            return m5522a(bArr, bArr2, bArr4);
        }
        if (bArr4 == null) {
            return m5522a(bArr, bArr2, bArr3);
        }
        byte[] bArr5 = new byte[bArr.length + bArr2.length + bArr3.length + bArr4.length];
        ArraysKt.copyInto$default(bArr, bArr5, 0, 0, 0, 14, (Object) null);
        ArraysKt.copyInto$default(bArr2, bArr5, bArr.length, 0, 0, 12, (Object) null);
        ArraysKt.copyInto$default(bArr3, bArr5, bArr.length + bArr2.length, 0, 0, 12, (Object) null);
        ArraysKt.copyInto$default(bArr4, bArr5, bArr.length + bArr2.length + bArr3.length, 0, 0, 12, (Object) null);
        return bArr5;
    }

    /* JADX INFO: renamed from: b */
    public static final byte[] m5524b(byte[] bArr, byte[] bArr2) {
        byte[] bArrM5521a = m5521a(bArr, bArr2);
        Intrinsics.checkNotNull(bArrM5521a);
        return bArrM5521a;
    }

    /* JADX INFO: renamed from: b */
    public static final byte[] m5525b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrM5522a = m5522a(bArr, bArr2, bArr3);
        Intrinsics.checkNotNull(bArrM5522a);
        return bArrM5522a;
    }

    /* JADX INFO: renamed from: b */
    public static final byte[] m5526b(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] bArrM5523a = m5523a(bArr, bArr2, bArr3, bArr4);
        Intrinsics.checkNotNull(bArrM5523a);
        return bArrM5523a;
    }

    /* JADX INFO: renamed from: c */
    public static final byte[] m5527c(byte[] array1, byte[] array2) {
        Intrinsics.checkNotNullParameter(array1, "array1");
        Intrinsics.checkNotNullParameter(array2, "array2");
        int length = array1.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (array1[i] ^ array2[i]);
        }
        return bArr;
    }
}
