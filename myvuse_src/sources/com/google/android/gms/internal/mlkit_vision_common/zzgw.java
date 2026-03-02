package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgw {
    private static zzgv zza;

    public static synchronized zzgo zza(String str) {
        if (zza == null) {
            zza = new zzgv(null);
        }
        return zza.get("vision-common");
    }
}
