package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zziq {
    private final zzhe zza;

    private zziq(zzhe zzheVar) {
        this.zza = zzheVar;
    }

    public static zziq zzc(zzhe zzheVar) {
        return new zziq(zzheVar);
    }

    public final byte[] zza() {
        try {
            zzjg.zza();
            return new JsonDataEncoderBuilder().configureWith(zzfp.zza).ignoreNullValues(true).build().encode(this.zza.zzf()).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public final String zzb() {
        zzim zzimVarZza = this.zza.zzf().zza();
        return (zzimVarZza == null || zzn.zza(zzimVarZza.zzd())) ? "NA" : (String) Preconditions.checkNotNull(zzimVarZza.zzd());
    }

    public final zziq zzd(zzim zzimVar) {
        this.zza.zza(zzimVar);
        return this;
    }

    public final zziq zze(zzhc zzhcVar) {
        this.zza.zzb(zzhcVar);
        return this;
    }
}
