package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzim {
    private static zzil zza;

    public static synchronized zzic zza(String str) {
        if (zza == null) {
            zza = new zzil(null);
        }
        return zza.get("common");
    }
}
