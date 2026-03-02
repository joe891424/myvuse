package com.google.android.gms.internal.mlkit_vision_face;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzje {
    private static zzjd zza;

    public static synchronized zziw zza(String str) {
        if (zza == null) {
            zza = new zzjd(null);
        }
        return zza.get("play-services-mlkit-face-detection");
    }
}
