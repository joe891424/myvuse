package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzoa implements zznx {
    private static final zzgw<Boolean> zza;
    private static final zzgw<Boolean> zzb;
    private static final zzgw<Boolean> zzc;

    static {
        zzhe zzheVarZza = new zzhe(zzgx.zza("com.google.android.gms.measurement")).zzb().zza();
        zzheVarZza.zza("measurement.client.ad_id_consent_fix", true);
        zzheVarZza.zza("measurement.service.consent.aiid_reset_fix", false);
        zzheVarZza.zza("measurement.service.consent.aiid_reset_fix2", true);
        zza = zzheVarZza.zza("measurement.service.consent.app_start_fix", true);
        zzb = zzheVarZza.zza("measurement.service.consent.params_on_fx", true);
        zzc = zzheVarZza.zza("measurement.service.consent.pfo_on_fx", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final boolean zza() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final boolean zzc() {
        return zzc.zza().booleanValue();
    }
}
