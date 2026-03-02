package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpr implements zzps {
    private static final zzgw<Boolean> zza;
    private static final zzgw<Boolean> zzb;

    static {
        zzhe zzheVarZza = new zzhe(zzgx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzheVarZza.zza("measurement.tcf.client", true);
        zzb = zzheVarZza.zza("measurement.tcf.service", true);
        zzheVarZza.zza("measurement.id.tcf.service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
