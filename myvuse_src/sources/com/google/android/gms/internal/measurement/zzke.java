package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzke implements zzll {
    private static final zzkr zza = new zzkh();
    private final zzkr zzb;

    @Override // com.google.android.gms.internal.measurement.zzll
    public final <T> zzli<T> zza(Class<T> cls) {
        zzlk.zza((Class<?>) cls);
        zzko zzkoVarZza = this.zzb.zza(cls);
        if (zzkoVarZza.zzc()) {
            return zzkw.zza(zzlk.zza(), zzjb.zza(), zzkoVarZza.zza());
        }
        return zzku.zza(cls, zzkoVarZza, zzla.zza(), zzkc.zza(), zzlk.zza(), zzkg.zza[zzkoVarZza.zzb().ordinal()] != 1 ? zzjb.zza() : null, zzkp.zza());
    }

    public zzke() {
        this(new zzkj(zzji.zza(), zza));
    }

    private zzke(zzkr zzkrVar) {
        this.zzb = (zzkr) zzjn.zza(zzkrVar, "messageInfoFactory");
    }
}
