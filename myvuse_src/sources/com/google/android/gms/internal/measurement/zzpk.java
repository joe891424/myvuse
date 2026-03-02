package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpk implements zzph {
    private static final zzgw<Boolean> zza;
    private static final zzgw<Boolean> zzb;

    static {
        zzhe zzheVarZza = new zzhe(zzgx.zza("com.google.android.gms.measurement")).zzb().zza();
        zzheVarZza.zza("measurement.collection.enable_session_stitching_token.client.dev", true);
        zza = zzheVarZza.zza("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        zzb = zzheVarZza.zza("measurement.session_stitching_token_enabled", false);
        zzheVarZza.zza("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzph
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzph
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzph
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
