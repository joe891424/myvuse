package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzio {
    private static zzio zza;

    private zzio() {
    }

    public static synchronized zzio zza() {
        if (zza == null) {
            zza = new zzio();
        }
        return zza;
    }
}
