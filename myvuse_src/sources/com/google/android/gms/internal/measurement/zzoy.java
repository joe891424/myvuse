package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzoy implements zzov {
    private static final zzgw<Boolean> zza;
    private static final zzgw<Boolean> zzb;
    private static final zzgw<Boolean> zzc;

    static {
        zzhe zzheVarZza = new zzhe(zzgx.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzheVarZza.zza("measurement.sdk.collection.deep_link_gclid.client.dev", false);
        zzheVarZza.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzheVarZza.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzb = zzheVarZza.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzc = zzheVarZza.zza("measurement.sdk.collection.market_referrer_gclid.service", false);
        zzheVarZza.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final boolean zza() {
        return zza.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzov
    public final boolean zzc() {
        return zzc.zza().booleanValue();
    }
}
