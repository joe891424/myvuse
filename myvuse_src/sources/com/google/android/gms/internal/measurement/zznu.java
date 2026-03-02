package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznu implements zznr {
    private static final zzgw<Boolean> zza;
    private static final zzgw<Boolean> zzb;
    private static final zzgw<Boolean> zzc;
    private static final zzgw<Boolean> zzd;

    static {
        zzhe zzheVarZza = new zzhe(zzgx.zza("com.google.android.gms.measurement")).zzb().zza();
        zzheVarZza.zza("measurement.dma_consent.client", true);
        zzheVarZza.zza("measurement.dma_consent.client_bow_check2", true);
        zza = zzheVarZza.zza("measurement.dma_consent.separate_service_calls_fix", false);
        zzheVarZza.zza("measurement.dma_consent.service", true);
        zzb = zzheVarZza.zza("measurement.dma_consent.service_database_update_fix", true);
        zzheVarZza.zza("measurement.dma_consent.service_dcu_event", true);
        zzc = zzheVarZza.zza("measurement.dma_consent.service_dcu_event2", true);
        zzheVarZza.zza("measurement.dma_consent.service_npa_remote_default", true);
        zzheVarZza.zza("measurement.dma_consent.service_split_batch_on_consent", true);
        zzd = zzheVarZza.zza("measurement.dma_consent.set_consent_inline_on_worker", false);
        zzheVarZza.zza("measurement.id.dma_consent.separate_service_calls_fix", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zznr
    public final boolean zza() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznr
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznr
    public final boolean zzc() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznr
    public final boolean zzd() {
        return zzd.zza().booleanValue();
    }
}
