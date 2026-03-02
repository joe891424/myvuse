package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzce extends zzck {
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final zzcc zze;
    private final zzcb zzf;
    private final zzcm zzg;

    public final int hashCode() {
        int iHashCode = (((((this.zzb.hashCode() ^ 1000003) * 1000003) ^ (this.zzc ? 1231 : 1237)) * 1000003) ^ (this.zzd ? 1231 : 1237)) * 1000003;
        zzcc zzccVar = this.zze;
        int iHashCode2 = (iHashCode ^ (zzccVar == null ? 0 : zzccVar.hashCode())) * 1000003;
        zzcb zzcbVar = this.zzf;
        return ((iHashCode2 ^ (zzcbVar != null ? zzcbVar.hashCode() : 0)) * 1000003) ^ this.zzg.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzck
    public final zzcc zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzck
    public final zzcb zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzck
    public final zzcm zzc() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.measurement.zzck
    public final String zzd() {
        return this.zzb;
    }

    public final String toString() {
        return "FileComplianceOptions{fileOwner=" + this.zzb + ", hasDifferentDmaOwner=" + this.zzc + ", skipChecks=" + this.zzd + ", dataForwardingNotAllowedResolver=" + String.valueOf(this.zze) + ", multipleProductIdGroupsResolver=" + String.valueOf(this.zzf) + ", filePurpose=" + String.valueOf(this.zzg) + "}";
    }

    private zzce(String str, boolean z, boolean z2, zzcc zzccVar, zzcb zzcbVar, zzcm zzcmVar) {
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = null;
        this.zzf = null;
        this.zzg = zzcmVar;
    }

    public final boolean equals(Object obj) {
        zzcc zzccVar;
        zzcb zzcbVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzck) {
            zzck zzckVar = (zzck) obj;
            if (this.zzb.equals(zzckVar.zzd()) && this.zzc == zzckVar.zze() && this.zzd == zzckVar.zzf() && ((zzccVar = this.zze) != null ? zzccVar.equals(zzckVar.zza()) : zzckVar.zza() == null) && ((zzcbVar = this.zzf) != null ? zzcbVar.equals(zzckVar.zzb()) : zzckVar.zzb() == null) && this.zzg.equals(zzckVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzck
    public final boolean zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzck
    public final boolean zzf() {
        return this.zzd;
    }
}
