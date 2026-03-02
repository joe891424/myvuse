package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgj {
    private final zzez zza;

    private zzgj(zzez zzezVar) {
        this.zza = zzezVar;
    }

    public static zzgj zzc(zzez zzezVar) {
        return new zzgj(zzezVar);
    }

    public final byte[] zza() {
        try {
            zzgz.zza();
            return new JsonDataEncoderBuilder().configureWith(zzdu.zza).ignoreNullValues(true).build().encode(this.zza.zzd()).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public final String zzb() {
        zzgf zzgfVarZza = this.zza.zzd().zza();
        return (zzgfVarZza == null || zzg.zza(zzgfVarZza.zzd())) ? "NA" : (String) Preconditions.checkNotNull(zzgfVarZza.zzd());
    }

    public final zzgj zzd(zzgf zzgfVar) {
        this.zza.zza(zzgfVar);
        return this;
    }

    public final zzgj zze(zzex zzexVar) {
        this.zza.zzb(zzexVar);
        return this;
    }
}
