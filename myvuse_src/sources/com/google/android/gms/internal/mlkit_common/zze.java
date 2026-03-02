package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zze {
    private final zzag<zzp> zza = zzaj.zzj();
    private Boolean zzb;

    private zze() {
    }

    /* synthetic */ zze(zzd zzdVar) {
    }

    public final zze zza() {
        zzz.zza(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = true;
        return this;
    }

    public final zze zzb() {
        zzz.zza(this.zzb == null, "A SourcePolicy can only set internal() or external() once.");
        this.zzb = false;
        return this;
    }

    public final zzf zzc() {
        Boolean bool = this.zzb;
        if (bool == null) {
            throw new NullPointerException("Must call internal() or external() when building a SourcePolicy.");
        }
        return new zzf(bool.booleanValue(), false, this.zza.zzc(), null);
    }
}
