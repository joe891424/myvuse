package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeb implements ObjectEncoder<zzgi> {
    static final zzeb zza = new zzeb();

    private zzeb() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzgi zzgiVar = (zzgi) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("maxMs", zzgiVar.zza());
        objectEncoderContext2.add("minMs", zzgiVar.zzb());
        objectEncoderContext2.add("avgMs", zzgiVar.zzc());
        objectEncoderContext2.add("firstQuartileMs", zzgiVar.zzd());
        objectEncoderContext2.add("medianMs", zzgiVar.zze());
        objectEncoderContext2.add("thirdQuartileMs", zzgiVar.zzf());
    }
}
