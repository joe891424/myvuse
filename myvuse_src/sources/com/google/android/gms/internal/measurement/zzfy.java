package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfy {
    private static zzfx zza;

    public static synchronized zzfx zza() {
        if (zza == null) {
            zza(new zzga());
        }
        return zza;
    }

    private static synchronized void zza(zzfx zzfxVar) {
        if (zza != null) {
            throw new IllegalStateException("init() already called");
        }
        zza = zzfxVar;
    }
}
