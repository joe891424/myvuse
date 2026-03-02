package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzef implements ObjectEncoder<zzgw> {
    static final zzef zza = new zzef();

    private zzef() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzgw zzgwVar = (zzgw) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("durationMs", zzgwVar.zza());
        objectEncoderContext2.add("errorCode", zzgwVar.zzb());
        objectEncoderContext2.add("isColdCall", zzgwVar.zzc());
        objectEncoderContext2.add("autoManageModelOnBackground", zzgwVar.zzd());
        objectEncoderContext2.add("autoManageModelOnLowMemory", zzgwVar.zze());
        objectEncoderContext2.add("isNnApiEnabled", (Object) null);
        objectEncoderContext2.add("eventsCount", (Object) null);
        objectEncoderContext2.add("otherErrors", (Object) null);
        objectEncoderContext2.add("remoteConfigValueForAcceleration", (Object) null);
        objectEncoderContext2.add("isAccelerated", (Object) null);
    }
}
