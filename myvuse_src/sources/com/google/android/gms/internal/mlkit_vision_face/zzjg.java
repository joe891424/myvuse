package com.google.android.gms.internal.mlkit_vision_face;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzjg {
    private static zzjg zza;

    private zzjg() {
    }

    public static synchronized zzjg zza() {
        if (zza == null) {
            zza = new zzjg();
        }
        return zza;
    }
}
