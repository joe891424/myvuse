package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgp {
    private final zzgl zza;
    private final zzgo zzb = null;
    private final zzgo zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzgp(zzgn zzgnVar, zzgm zzgmVar) {
        this.zza = zzgnVar.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgp)) {
            return false;
        }
        zzgp zzgpVar = (zzgp) obj;
        if (Objects.equal(this.zza, zzgpVar.zza)) {
            zzgo zzgoVar = zzgpVar.zzb;
            if (Objects.equal(null, null)) {
                zzgo zzgoVar2 = zzgpVar.zzc;
                if (Objects.equal(null, null)) {
                    Boolean bool = zzgpVar.zzd;
                    if (Objects.equal(null, null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    public final zzgl zza() {
        return this.zza;
    }
}
