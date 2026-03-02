package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzom implements zzoj {
    private static final zzgw<Boolean> zza;
    private static final zzgw<Boolean> zzb;
    private static final zzgw<Boolean> zzc;
    private static final zzgw<Boolean> zzd;

    static {
        zzhe zzheVarZza = new zzhe(zzgx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzheVarZza.zza("measurement.gbraid_campaign.deep_link_gbraid.client.dev", true);
        zzb = zzheVarZza.zza("measurement.gbraid_campaign.gbraid.client.dev", false);
        zzc = zzheVarZza.zza("measurement.gbraid_campaign.gbraid.service", false);
        zzd = zzheVarZza.zza("measurement.gbraid_campaign.market_referrer_gbraid.service", true);
        zzheVarZza.zza("measurement.id.gbraid_campaign.service", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzoj
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzoj
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoj
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoj
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoj
    public final boolean zze() {
        return zzd.zza().booleanValue();
    }
}
