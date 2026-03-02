package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcd extends zzcj {
    private String zza;
    private zzcm zzb;
    private byte zzc;

    public final zzcj zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final zzcj zza(zzcm zzcmVar) {
        if (zzcmVar == null) {
            throw new NullPointerException("Null filePurpose");
        }
        this.zzb = zzcmVar;
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final zzcj zza(boolean z) {
        this.zzc = (byte) (this.zzc | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final zzcj zzb(boolean z) {
        this.zzc = (byte) (this.zzc | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzcj
    public final zzck zza() {
        if (this.zzc != 3 || this.zza == null || this.zzb == null) {
            StringBuilder sb = new StringBuilder();
            if (this.zza == null) {
                sb.append(" fileOwner");
            }
            if ((this.zzc & 1) == 0) {
                sb.append(" hasDifferentDmaOwner");
            }
            if ((this.zzc & 2) == 0) {
                sb.append(" skipChecks");
            }
            if (this.zzb == null) {
                sb.append(" filePurpose");
            }
            throw new IllegalStateException("Missing required properties:" + String.valueOf(sb));
        }
        return new zzce(this.zza, this.zzb);
    }

    zzcd() {
    }
}
