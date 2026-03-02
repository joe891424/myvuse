package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzec implements ObjectEncoder<zzgp> {
    static final zzec zza = new zzec();

    private zzec() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzgp zzgpVar = (zzgp) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("landmarkMode", zzgpVar.zza());
        objectEncoderContext2.add("classificationMode", zzgpVar.zzb());
        objectEncoderContext2.add("performanceMode", zzgpVar.zzc());
        objectEncoderContext2.add("contourMode", zzgpVar.zzd());
        objectEncoderContext2.add("isTrackingEnabled", zzgpVar.zze());
        objectEncoderContext2.add("minFaceSize", zzgpVar.zzf());
    }
}
