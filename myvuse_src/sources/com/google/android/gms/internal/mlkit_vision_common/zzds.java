package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzds implements ObjectEncoder<zzgf> {
    static final zzds zza = new zzds();

    private zzds() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzgf zzgfVar = (zzgf) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("appId", zzgfVar.zza());
        objectEncoderContext2.add("appVersion", zzgfVar.zzb());
        objectEncoderContext2.add("firebaseProjectId", (Object) null);
        objectEncoderContext2.add("mlSdkVersion", zzgfVar.zzc());
        objectEncoderContext2.add("tfliteSchemaVersion", zzgfVar.zzd());
        objectEncoderContext2.add("gcmSenderId", (Object) null);
        objectEncoderContext2.add("apiKey", (Object) null);
        objectEncoderContext2.add("languages", zzgfVar.zze());
        objectEncoderContext2.add("mlSdkInstanceId", zzgfVar.zzf());
        objectEncoderContext2.add("isClearcutClient", (Object) null);
        objectEncoderContext2.add("isStandaloneMlkit", zzgfVar.zzg());
        objectEncoderContext2.add("isJsonLogging", zzgfVar.zzh());
        objectEncoderContext2.add("buildLevel", zzgfVar.zzi());
    }
}
