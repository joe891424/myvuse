package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhv extends zzid {
    private zzfy zza;
    private String zzb;
    private Boolean zzc;
    private Boolean zzd;
    private ModelType zze;
    private zzgf zzf;
    private Integer zzg;

    zzhv() {
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzid
    public final zzid zza(zzfy zzfyVar) {
        if (zzfyVar == null) {
            throw new NullPointerException("Null errorCode");
        }
        this.zza = zzfyVar;
        return this;
    }

    public final zzid zzb(String str) {
        this.zzb = "NA";
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzid
    public final zzid zzc(boolean z) {
        this.zzc = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzid
    public final zzid zzd(boolean z) {
        this.zzd = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzid
    public final zzid zze(ModelType modelType) {
        if (modelType == null) {
            throw new NullPointerException("Null modelType");
        }
        this.zze = modelType;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzid
    public final zzid zzf(zzgf zzgfVar) {
        if (zzgfVar == null) {
            throw new NullPointerException("Null downloadStatus");
        }
        this.zzf = zzgfVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzid
    public final zzid zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzid
    public final zzie zzh() {
        String strConcat = this.zza == null ? " errorCode" : "";
        if (this.zzb == null) {
            strConcat = strConcat.concat(" tfliteSchemaVersion");
        }
        if (this.zzc == null) {
            strConcat = String.valueOf(strConcat).concat(" shouldLogRoughDownloadTime");
        }
        if (this.zzd == null) {
            strConcat = String.valueOf(strConcat).concat(" shouldLogExactDownloadTime");
        }
        if (this.zze == null) {
            strConcat = String.valueOf(strConcat).concat(" modelType");
        }
        if (this.zzf == null) {
            strConcat = String.valueOf(strConcat).concat(" downloadStatus");
        }
        if (this.zzg == null) {
            strConcat = String.valueOf(strConcat).concat(" failureStatusCode");
        }
        if (strConcat.isEmpty()) {
            return new zzhw(this.zza, this.zzb, this.zzc.booleanValue(), this.zzd.booleanValue(), this.zze, this.zzf, this.zzg.intValue(), null);
        }
        String strValueOf = String.valueOf(strConcat);
        throw new IllegalStateException(strValueOf.length() != 0 ? "Missing required properties:".concat(strValueOf) : new String("Missing required properties:"));
    }
}
