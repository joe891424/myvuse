package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzee implements ObjectEncoder<zzgt> {
    static final zzee zza = new zzee();

    private zzee() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzgt zzgtVar = (zzgt) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("imageFormat", zzgtVar.zza());
        objectEncoderContext2.add("originalImageSize", zzgtVar.zzb());
        objectEncoderContext2.add("compressedImageSize", (Object) null);
    }
}
