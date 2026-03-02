package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzme extends zzmc<zzmf, zzmf> {
    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ int zza(zzmf zzmfVar) {
        return zzmfVar.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final boolean zza(zzlj zzljVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ int zzb(zzmf zzmfVar) {
        return zzmfVar.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ zzmf zzc(Object obj) {
        zzmf zzmfVar = ((zzjk) obj).zzb;
        if (zzmfVar != zzmf.zzc()) {
            return zzmfVar;
        }
        zzmf zzmfVarZzd = zzmf.zzd();
        zza(obj, zzmfVarZzd);
        return zzmfVarZzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ zzmf zzd(Object obj) {
        return ((zzjk) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ zzmf zza(zzmf zzmfVar, zzmf zzmfVar2) {
        zzmf zzmfVar3 = zzmfVar;
        zzmf zzmfVar4 = zzmfVar2;
        if (zzmf.zzc().equals(zzmfVar4)) {
            return zzmfVar3;
        }
        if (zzmf.zzc().equals(zzmfVar3)) {
            return zzmf.zza(zzmfVar3, zzmfVar4);
        }
        return zzmfVar3.zza(zzmfVar4);
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ zzmf zza() {
        return zzmf.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ zzmf zze(zzmf zzmfVar) {
        zzmf zzmfVar2 = zzmfVar;
        zzmfVar2.zze();
        return zzmfVar2;
    }

    zzme() {
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zza(zzmf zzmfVar, int i, int i2) {
        zzmfVar.zza((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zza(zzmf zzmfVar, int i, long j) {
        zzmfVar.zza((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zza(zzmf zzmfVar, int i, zzmf zzmfVar2) {
        zzmfVar.zza((i << 3) | 3, zzmfVar2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zza(zzmf zzmfVar, int i, zzhx zzhxVar) {
        zzmfVar.zza((i << 3) | 2, zzhxVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zzb(zzmf zzmfVar, int i, long j) {
        zzmfVar.zza(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final void zzf(Object obj) {
        ((zzjk) obj).zzb.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zzb(Object obj, zzmf zzmfVar) {
        zza(obj, zzmfVar);
    }

    private static void zza(Object obj, zzmf zzmfVar) {
        ((zzjk) obj).zzb = zzmfVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zzc(Object obj, zzmf zzmfVar) {
        zza(obj, zzmfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zza(zzmf zzmfVar, zzmx zzmxVar) throws IOException {
        zzmfVar.zza(zzmxVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmc
    final /* synthetic */ void zzb(zzmf zzmfVar, zzmx zzmxVar) throws IOException {
        zzmfVar.zzb(zzmxVar);
    }
}
