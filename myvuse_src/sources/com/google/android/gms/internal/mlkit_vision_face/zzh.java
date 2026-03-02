package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzh<T> implements Serializable {
    zzh() {
    }

    public static <T> zzh<T> zzc() {
        return zza.zza;
    }

    public static <T> zzh<T> zzd(T t) {
        return new zzm(t);
    }

    public abstract boolean zza();

    public abstract T zzb(T t);
}
