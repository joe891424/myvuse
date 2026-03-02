package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzie {
    public static zzid zzh() {
        zzhv zzhvVar = new zzhv();
        zzhvVar.zzb("NA");
        zzhvVar.zzc(false);
        zzhvVar.zzd(false);
        zzhvVar.zze(ModelType.UNKNOWN);
        zzhvVar.zza(zzfy.NO_ERROR);
        zzhvVar.zzf(zzgf.UNKNOWN_STATUS);
        zzhvVar.zzg(0);
        return zzhvVar;
    }

    public abstract zzfy zza();

    public abstract String zzb();

    public abstract boolean zzc();

    public abstract boolean zzd();

    public abstract ModelType zze();

    public abstract zzgf zzf();

    public abstract int zzg();
}
