package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgp {
    private final zzgn zza;
    private final zzgl zzb;
    private final zzgo zzc;
    private final zzgm zzd;
    private final Boolean zze;
    private final Float zzf;

    /* synthetic */ zzgp(zzgk zzgkVar, zzgj zzgjVar) {
        this.zza = zzgkVar.zza;
        this.zzb = zzgkVar.zzb;
        this.zzc = zzgkVar.zzc;
        this.zzd = zzgkVar.zzd;
        this.zze = zzgkVar.zze;
        this.zzf = zzgkVar.zzf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgp)) {
            return false;
        }
        zzgp zzgpVar = (zzgp) obj;
        return Objects.equal(this.zza, zzgpVar.zza) && Objects.equal(this.zzb, zzgpVar.zzb) && Objects.equal(this.zzc, zzgpVar.zzc) && Objects.equal(this.zzd, zzgpVar.zzd) && Objects.equal(this.zze, zzgpVar.zze) && Objects.equal(this.zzf, zzgpVar.zzf);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    public final zzgn zza() {
        return this.zza;
    }

    public final zzgl zzb() {
        return this.zzb;
    }

    public final zzgo zzc() {
        return this.zzc;
    }

    public final zzgm zzd() {
        return this.zzd;
    }

    public final Boolean zze() {
        return this.zze;
    }

    public final Float zzf() {
        return this.zzf;
    }
}
