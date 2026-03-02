package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznj implements zznk {
    private static final zzgw<Boolean> zza;
    private static final zzgw<Boolean> zzb;
    private static final zzgw<Boolean> zzc;

    static {
        zzhe zzheVarZza = new zzhe(zzgx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzheVarZza.zza("measurement.consent.stop_reset_on_storage_denied.client", true);
        zzb = zzheVarZza.zza("measurement.consent.stop_reset_on_storage_denied.service", true);
        zzheVarZza.zza("measurement.id.consent.stop_reset_on_storage_denied.service", 0L);
        zzc = zzheVarZza.zza("measurement.consent.scrub_audience_data_analytics_consent", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }
}
