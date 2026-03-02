package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdo implements ObjectEncoder<zzgg> {
    static final zzdo zza = new zzdo();

    private zzdo() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzgg zzggVar = (zzgg) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("options", zzggVar.zza());
        objectEncoderContext2.add("roughDownloadDurationMs", zzggVar.zzb());
        objectEncoderContext2.add("errorCode", zzggVar.zzc());
        objectEncoderContext2.add("exactDownloadDurationMs", zzggVar.zzd());
        objectEncoderContext2.add("downloadStatus", zzggVar.zze());
        objectEncoderContext2.add("downloadFailureStatus", zzggVar.zzf());
        objectEncoderContext2.add("mddDownloadErrorCodes", (Object) null);
    }
}
