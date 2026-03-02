package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdk implements ObjectEncoder<zzfs> {
    static final zzdk zza = new zzdk();

    private zzdk() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzfs zzfsVar = (zzfs) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("modelType", zzfsVar.zza());
        objectEncoderContext2.add("isDownloaded", zzfsVar.zzb());
        objectEncoderContext2.add("modelName", (Object) null);
    }
}
