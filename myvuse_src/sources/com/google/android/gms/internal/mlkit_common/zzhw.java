package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhw extends zzie {
    private final zzfy zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final ModelType zze;
    private final zzgf zzf;
    private final int zzg;

    /* synthetic */ zzhw(zzfy zzfyVar, String str, boolean z, boolean z2, ModelType modelType, zzgf zzgfVar, int i, zzhu zzhuVar) {
        this.zza = zzfyVar;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = modelType;
        this.zzf = zzgfVar;
        this.zzg = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzie) {
            zzie zzieVar = (zzie) obj;
            if (this.zza.equals(zzieVar.zza()) && this.zzb.equals(zzieVar.zzb()) && this.zzc == zzieVar.zzc() && this.zzd == zzieVar.zzd() && this.zze.equals(zzieVar.zze()) && this.zzf.equals(zzieVar.zzf()) && this.zzg == zzieVar.zzg()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ (true != this.zzc ? 1237 : 1231)) * 1000003) ^ (true == this.zzd ? 1231 : 1237)) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode()) * 1000003) ^ this.zzg;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        String str = this.zzb;
        boolean z = this.zzc;
        boolean z2 = this.zzd;
        String strValueOf2 = String.valueOf(this.zze);
        String strValueOf3 = String.valueOf(this.zzf);
        int i = this.zzg;
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 187 + length2 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length());
        sb.append("RemoteModelLoggingOptions{errorCode=");
        sb.append(strValueOf);
        sb.append(", tfliteSchemaVersion=");
        sb.append(str);
        sb.append(", shouldLogRoughDownloadTime=");
        sb.append(z);
        sb.append(", shouldLogExactDownloadTime=");
        sb.append(z2);
        sb.append(", modelType=");
        sb.append(strValueOf2);
        sb.append(", downloadStatus=");
        sb.append(strValueOf3);
        sb.append(", failureStatusCode=");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzie
    public final zzfy zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzie
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzie
    public final boolean zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzie
    public final boolean zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzie
    public final ModelType zze() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzie
    public final zzgf zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzie
    public final int zzg() {
        return this.zzg;
    }
}
