package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzad<E> extends zzae<E> {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    zzad(int i) {
    }

    private final void zzb(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length >= i) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
                this.zzc = false;
                return;
            }
            return;
        }
        int i2 = length + (length >> 1) + 1;
        if (i2 < i) {
            int iHighestOneBit = Integer.highestOneBit(i - 1);
            i2 = iHighestOneBit + iHighestOneBit;
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.zza = Arrays.copyOf(objArr, i2);
        this.zzc = false;
    }

    public final zzad<E> zza(E e) {
        e.getClass();
        zzb(this.zzb + 1);
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = e;
        return this;
    }
}
