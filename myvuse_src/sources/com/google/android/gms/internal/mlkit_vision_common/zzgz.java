package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgz {
    private static zzgz zza;

    private zzgz() {
    }

    public static synchronized zzgz zza() {
        if (zza == null) {
            zza = new zzgz();
        }
        return zza;
    }
}
