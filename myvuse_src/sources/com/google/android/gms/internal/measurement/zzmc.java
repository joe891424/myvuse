package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzmc<T, B> {
    zzmc() {
    }

    abstract int zza(T t);

    abstract B zza();

    abstract T zza(T t, T t2);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzhx zzhxVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzmx zzmxVar) throws IOException;

    abstract boolean zza(zzlj zzljVar);

    abstract int zzb(T t);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zzmx zzmxVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract void zzc(Object obj, T t);

    abstract T zzd(Object obj);

    abstract T zze(B b);

    abstract void zzf(Object obj);

    final boolean zza(B b, zzlj zzljVar) throws IOException {
        int iZzd = zzljVar.zzd();
        int i = iZzd >>> 3;
        int i2 = iZzd & 7;
        if (i2 == 0) {
            zzb(b, i, zzljVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zza(b, i, zzljVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zza((Object) b, i, zzljVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzjt.zza();
            }
            zza((Object) b, i, zzljVar.zzf());
            return true;
        }
        B bZza = zza();
        int i3 = 4 | (i << 3);
        while (zzljVar.zzc() != Integer.MAX_VALUE && zza((Object) bZza, zzljVar)) {
        }
        if (i3 != zzljVar.zzd()) {
            throw zzjt.zzb();
        }
        zza(b, i, zze(bZza));
        return true;
    }
}
