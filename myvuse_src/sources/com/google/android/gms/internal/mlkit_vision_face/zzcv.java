package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcv implements ObjectEncoder<zzcb> {
    static final zzcv zza = new zzcv();

    private zzcv() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzcb zzcbVar = (zzcb) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("logEventKey", zzcbVar.zza());
        objectEncoderContext2.add("eventCount", zzcbVar.zzb());
        objectEncoderContext2.add("inferenceDurationStats", zzcbVar.zzc());
    }
}
