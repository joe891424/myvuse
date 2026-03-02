package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeq implements ObjectEncoder<zzhq> {
    static final zzeq zza = new zzeq();

    private zzeq() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzhq zzhqVar = (zzhq) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("appId", zzhqVar.zza());
        objectEncoderContext2.add("appVersion", zzhqVar.zzb());
        objectEncoderContext2.add("firebaseProjectId", (Object) null);
        objectEncoderContext2.add("mlSdkVersion", zzhqVar.zzc());
        objectEncoderContext2.add("tfliteSchemaVersion", zzhqVar.zzd());
        objectEncoderContext2.add("gcmSenderId", (Object) null);
        objectEncoderContext2.add("apiKey", (Object) null);
        objectEncoderContext2.add("languages", zzhqVar.zze());
        objectEncoderContext2.add("mlSdkInstanceId", zzhqVar.zzf());
        objectEncoderContext2.add("isClearcutClient", (Object) null);
        objectEncoderContext2.add("isStandaloneMlkit", zzhqVar.zzg());
        objectEncoderContext2.add("isJsonLogging", zzhqVar.zzh());
        objectEncoderContext2.add("buildLevel", zzhqVar.zzi());
    }
}
