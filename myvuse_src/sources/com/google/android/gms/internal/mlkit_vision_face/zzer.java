package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzer implements ObjectEncoder<zzho> {
    static final zzer zza = new zzer();

    private zzer() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzho zzhoVar = (zzho) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("inferenceCommonLogEvent", zzhoVar.zza());
        objectEncoderContext2.add("options", (Object) null);
        objectEncoderContext2.add("imageInfo", zzhoVar.zzb());
        objectEncoderContext2.add("detectorOptions", zzhoVar.zzc());
        objectEncoderContext2.add("contourDetectedFaces", zzhoVar.zzd());
        objectEncoderContext2.add("nonContourDetectedFaces", zzhoVar.zze());
    }
}
