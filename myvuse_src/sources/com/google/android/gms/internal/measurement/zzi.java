package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzft;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzi {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzft.zzd.zzb.values().length];
        zza = iArr;
        try {
            iArr[zzft.zzd.zzb.STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[zzft.zzd.zzb.NUMBER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zza[zzft.zzd.zzb.BOOLEAN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            zza[zzft.zzd.zzb.STATEMENT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            zza[zzft.zzd.zzb.UNKNOWN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
