package com.google.android.gms.internal.mlkit_vision_face;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzao {
    static Object zza(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            return i <= 256 ? new byte[i] : i <= 65536 ? new short[i] : new int[i];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zzb(Object obj, int i) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i] : ((int[]) obj)[i];
    }

    static void zzc(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    static int zzd(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    static int zze(@NullableDecl Object obj, @NullableDecl Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, @NullableDecl Object[] objArr2) {
        int i2;
        int i3;
        int iZza = zzap.zza(obj);
        int i4 = iZza & i;
        int iZzb = zzb(obj3, i4);
        if (iZzb != 0) {
            int i5 = ~i;
            int i6 = iZza & i5;
            int i7 = -1;
            while (true) {
                i2 = iZzb - 1;
                i3 = iArr[i2];
                if ((i3 & i5) != i6 || !zzg.zza(obj, objArr[i2]) || (objArr2 != null && !zzg.zza(obj2, objArr2[i2]))) {
                    int i8 = i3 & i;
                    if (i8 == 0) {
                        break;
                    }
                    i7 = i2;
                    iZzb = i8;
                } else {
                    break;
                }
            }
            int i9 = i3 & i;
            if (i7 == -1) {
                zzc(obj3, i4, i9);
            } else {
                iArr[i7] = (i9 & i) | (iArr[i7] & i5);
            }
            return i2;
        }
        return -1;
    }
}
