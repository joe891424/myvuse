package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcl implements ObjectEncoder<zzet> {
    static final zzcl zza = new zzcl();

    private zzcl() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzet zzetVar = (zzet) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("durationMs", zzetVar.zza());
        objectEncoderContext2.add("imageSource", zzetVar.zzb());
        objectEncoderContext2.add("imageFormat", zzetVar.zzc());
        objectEncoderContext2.add("imageByteSize", zzetVar.zzd());
        objectEncoderContext2.add("imageWidth", zzetVar.zze());
        objectEncoderContext2.add("imageHeight", zzetVar.zzf());
        objectEncoderContext2.add("rotationDegrees", zzetVar.zzg());
    }
}
