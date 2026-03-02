package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgl {
    private final String zza;
    private final zzgk zzc;
    private final String zze;
    private final zzgj zzf;
    private final String zzb = null;
    private final String zzd = null;
    private final Long zzg = null;
    private final Boolean zzh = null;
    private final Boolean zzi = null;

    /* synthetic */ zzgl(zzgi zzgiVar, zzgh zzghVar) {
        this.zza = zzgiVar.zza;
        this.zzc = zzgiVar.zzb;
        this.zze = zzgiVar.zzc;
        this.zzf = zzgiVar.zzd;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgl)) {
            return false;
        }
        zzgl zzglVar = (zzgl) obj;
        if (Objects.equal(this.zza, zzglVar.zza)) {
            String str = zzglVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zzglVar.zzc)) {
                String str2 = zzglVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zzglVar.zze) && Objects.equal(this.zzf, zzglVar.zzf)) {
                    Long l = zzglVar.zzg;
                    if (Objects.equal(null, null)) {
                        Boolean bool = zzglVar.zzh;
                        if (Objects.equal(null, null)) {
                            Boolean bool2 = zzglVar.zzi;
                            if (Objects.equal(null, null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    public final String zza() {
        return this.zza;
    }

    public final zzgk zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zze;
    }

    public final zzgj zzd() {
        return this.zzf;
    }
}
