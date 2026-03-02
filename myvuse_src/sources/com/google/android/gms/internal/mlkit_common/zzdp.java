package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdp implements ObjectEncoder<zzgl> {
    static final zzdp zza = new zzdp();

    private zzdp() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzgl zzglVar = (zzgl) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("name", zzglVar.zza());
        objectEncoderContext2.add("version", (Object) null);
        objectEncoderContext2.add("source", zzglVar.zzb());
        objectEncoderContext2.add("uri", (Object) null);
        objectEncoderContext2.add("hash", zzglVar.zzc());
        objectEncoderContext2.add("modelType", zzglVar.zzd());
        objectEncoderContext2.add("size", (Object) null);
        objectEncoderContext2.add("hasLabelMap", (Object) null);
        objectEncoderContext2.add("isManifestModel", (Object) null);
    }
}
