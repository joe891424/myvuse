package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzni implements zznf {
    private static final zzgw<Long> zza;

    @Override // com.google.android.gms.internal.measurement.zznf
    public final long zza() {
        return zza.zza().longValue();
    }

    static {
        zzhe zzheVarZza = new zzhe(zzgx.zza("com.google.android.gms.measurement")).zzb().zza();
        zzheVarZza.zza("measurement.client.consent_state_v1", true);
        zzheVarZza.zza("measurement.client.3p_consent_state_v1", true);
        zzheVarZza.zza("measurement.service.consent_state_v1_W36", true);
        zza = zzheVarZza.zza("measurement.service.storage_consent_support_version", 203600L);
    }
}
