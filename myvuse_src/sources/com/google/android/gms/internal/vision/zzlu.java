package com.google.android.gms.internal.vision;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzlu<T, B> {
    zzlu() {
    }

    abstract B zza();

    abstract T zza(B b);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzht zzhtVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzmr zzmrVar) throws IOException;

    abstract void zza(Object obj, T t);

    abstract boolean zza(zzld zzldVar);

    abstract T zzb(Object obj);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zzmr zzmrVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract T zzc(T t, T t2);

    abstract void zzd(Object obj);

    abstract int zze(T t);

    abstract int zzf(T t);

    final boolean zza(B b, zzld zzldVar) throws IOException {
        int iZzb = zzldVar.zzb();
        int i = iZzb >>> 3;
        int i2 = iZzb & 7;
        if (i2 == 0) {
            zza(b, i, zzldVar.zzg());
            return true;
        }
        if (i2 == 1) {
            zzb(b, i, zzldVar.zzi());
            return true;
        }
        if (i2 == 2) {
            zza((Object) b, i, zzldVar.zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzjk.zzf();
            }
            zza((Object) b, i, zzldVar.zzj());
            return true;
        }
        B bZza = zza();
        int i3 = 4 | (i << 3);
        while (zzldVar.zza() != Integer.MAX_VALUE && zza((Object) bZza, zzldVar)) {
        }
        if (i3 != zzldVar.zzb()) {
            throw zzjk.zze();
        }
        zza(b, i, zza(bZza));
        return true;
    }
}
