package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgt {
    private final zzgs zza;
    private final Integer zzb;
    private final Integer zzc = null;

    /* synthetic */ zzgt(zzgr zzgrVar, zzgq zzgqVar) {
        this.zza = zzgrVar.zza;
        this.zzb = zzgrVar.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgt)) {
            return false;
        }
        zzgt zzgtVar = (zzgt) obj;
        if (Objects.equal(this.zza, zzgtVar.zza) && Objects.equal(this.zzb, zzgtVar.zzb)) {
            Integer num = zzgtVar.zzc;
            if (Objects.equal(null, null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null);
    }

    public final zzgs zza() {
        return this.zza;
    }

    public final Integer zzb() {
        return this.zzb;
    }
}
