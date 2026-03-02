package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzji implements zzkr {
    private static final zzji zza = new zzji();

    public static zzji zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkr
    public final zzko zza(Class<?> cls) {
        if (!zzjk.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (zzko) zzjk.zza(cls.asSubclass(zzjk.class)).zza(zzjk.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    private zzji() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkr
    public final boolean zzb(Class<?> cls) {
        return zzjk.class.isAssignableFrom(cls);
    }
}
