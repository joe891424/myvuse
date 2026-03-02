package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzfv {
    UNKNOWN(0),
    TRANSLATE(1);

    private final int zzc;

    zzfv(int i) {
        this.zzc = i;
    }

    public static zzfv zza(int i) {
        for (zzfv zzfvVar : values()) {
            if (zzfvVar.zzc == i) {
                return zzfvVar;
            }
        }
        return UNKNOWN;
    }
}
