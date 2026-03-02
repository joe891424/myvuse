package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcw implements ObjectEncoder<zzca> {
    static final zzcw zza = new zzcw();

    private zzcw() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzca zzcaVar = (zzca) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("errorCode", zzcaVar.zza());
        objectEncoderContext2.add("isColdCall", zzcaVar.zzb());
        objectEncoderContext2.add("imageInfo", zzcaVar.zzc());
        objectEncoderContext2.add("detectorOptions", zzcaVar.zzd());
        objectEncoderContext2.add("contourDetectedFaces", zzcaVar.zze());
        objectEncoderContext2.add("nonContourDetectedFaces", zzcaVar.zzf());
    }
}
