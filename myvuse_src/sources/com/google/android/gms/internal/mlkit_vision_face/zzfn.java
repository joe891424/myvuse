package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfn implements ObjectEncoder<zzim> {
    static final zzfn zza = new zzfn();

    private zzfn() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzim zzimVar = (zzim) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("appId", zzimVar.zza());
        objectEncoderContext2.add("appVersion", zzimVar.zzb());
        objectEncoderContext2.add("firebaseProjectId", (Object) null);
        objectEncoderContext2.add("mlSdkVersion", zzimVar.zzc());
        objectEncoderContext2.add("tfliteSchemaVersion", zzimVar.zzd());
        objectEncoderContext2.add("gcmSenderId", (Object) null);
        objectEncoderContext2.add("apiKey", (Object) null);
        objectEncoderContext2.add("languages", zzimVar.zze());
        objectEncoderContext2.add("mlSdkInstanceId", zzimVar.zzf());
        objectEncoderContext2.add("isClearcutClient", (Object) null);
        objectEncoderContext2.add("isStandaloneMlkit", zzimVar.zzg());
        objectEncoderContext2.add("isJsonLogging", zzimVar.zzh());
        objectEncoderContext2.add("buildLevel", zzimVar.zzi());
    }
}
