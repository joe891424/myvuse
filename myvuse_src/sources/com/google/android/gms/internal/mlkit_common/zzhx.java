package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhx {
    private final zzgb zza;

    private zzhx(zzgb zzgbVar) {
        this.zza = zzgbVar;
    }

    public static zzhx zzc(zzgb zzgbVar) {
        return new zzhx(zzgbVar);
    }

    public static zzhx zzd() {
        return new zzhx(new zzgb());
    }

    public final byte[] zza() {
        try {
            zzio.zza();
            return new JsonDataEncoderBuilder().configureWith(zzes.zza).ignoreNullValues(true).build().encode(this.zza.zzg()).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public final String zzb() {
        zzhq zzhqVarZza = this.zza.zzg().zza();
        return (zzhqVarZza == null || zzaa.zzb(zzhqVarZza.zzd())) ? "NA" : (String) Preconditions.checkNotNull(zzhqVarZza.zzd());
    }

    public final zzhx zze(zzhq zzhqVar) {
        this.zza.zza(zzhqVar);
        return this;
    }

    public final zzhx zzf(zzfz zzfzVar) {
        this.zza.zzb(zzfzVar);
        return this;
    }

    public final zzhx zzg(zzgg zzggVar) {
        this.zza.zzc(zzggVar);
        return this;
    }
}
