package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzca {
    private final zzhb zza;
    private final Boolean zzb;
    private final zzgt zzc;
    private final zzgp zzd;
    private final Integer zze;
    private final Integer zzf;

    /* synthetic */ zzca(zzbz zzbzVar, zzbx zzbxVar) {
        this.zza = zzbzVar.zza;
        this.zzb = zzbzVar.zzb;
        this.zzc = zzbzVar.zzc;
        this.zzd = zzbzVar.zzd;
        this.zze = zzbzVar.zze;
        this.zzf = zzbzVar.zzf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzca)) {
            return false;
        }
        zzca zzcaVar = (zzca) obj;
        return Objects.equal(this.zza, zzcaVar.zza) && Objects.equal(this.zzb, zzcaVar.zzb) && Objects.equal(this.zzc, zzcaVar.zzc) && Objects.equal(this.zzd, zzcaVar.zzd) && Objects.equal(this.zze, zzcaVar.zze) && Objects.equal(this.zzf, zzcaVar.zzf);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    public final zzhb zza() {
        return this.zza;
    }

    public final Boolean zzb() {
        return this.zzb;
    }

    public final zzgt zzc() {
        return this.zzc;
    }

    public final zzgp zzd() {
        return this.zzd;
    }

    public final Integer zze() {
        return this.zze;
    }

    public final Integer zzf() {
        return this.zzf;
    }
}
