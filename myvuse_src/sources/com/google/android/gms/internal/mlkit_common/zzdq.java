package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdq implements ObjectEncoder<zzgp> {
    static final zzdq zza = new zzdq();

    private zzdq() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("modelInfo", ((zzgp) obj).zza());
        objectEncoderContext2.add("initialDownloadConditions", (Object) null);
        objectEncoderContext2.add("updateDownloadConditions", (Object) null);
        objectEncoderContext2.add("isModelUpdateEnabled", (Object) null);
    }
}
