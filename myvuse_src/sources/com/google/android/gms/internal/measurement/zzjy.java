package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public class zzjy {
    private volatile zzkq zza;
    private volatile zzhx zzb;

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return this.zzb.zzb();
        }
        if (this.zza != null) {
            return this.zza.zzby();
        }
        return 0;
    }

    public final zzhx zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                return this.zzb;
            }
            if (this.zza == null) {
                this.zzb = zzhx.zza;
            } else {
                this.zzb = this.zza.zzbw();
            }
            return this.zzb;
        }
    }

    private final zzkq zzb(zzkq zzkqVar) {
        if (this.zza == null) {
            synchronized (this) {
                if (this.zza == null) {
                    try {
                        this.zza = zzkqVar;
                        this.zzb = zzhx.zza;
                    } catch (zzjt unused) {
                        this.zza = zzkqVar;
                        this.zzb = zzhx.zza;
                    }
                }
            }
        }
        return this.zza;
    }

    public final zzkq zza(zzkq zzkqVar) {
        zzkq zzkqVar2 = this.zza;
        this.zzb = null;
        this.zza = zzkqVar;
        return zzkqVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjy)) {
            return false;
        }
        zzjy zzjyVar = (zzjy) obj;
        zzkq zzkqVar = this.zza;
        zzkq zzkqVar2 = zzjyVar.zza;
        if (zzkqVar == null && zzkqVar2 == null) {
            return zzb().equals(zzjyVar.zzb());
        }
        if (zzkqVar != null && zzkqVar2 != null) {
            return zzkqVar.equals(zzkqVar2);
        }
        if (zzkqVar != null) {
            return zzkqVar.equals(zzjyVar.zzb(zzkqVar.zzai()));
        }
        return zzb(zzkqVar2.zzai()).equals(zzkqVar2);
    }
}
