package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzki<K, V> {
    static <K, V> int zza(zzkl<K, V> zzklVar, K k, V v) {
        return zzja.zza(zzklVar.zza, 1, k) + zzja.zza(zzklVar.zzc, 2, v);
    }

    static <K, V> void zza(zzir zzirVar, zzkl<K, V> zzklVar, K k, V v) throws IOException {
        zzja.zza(zzirVar, zzklVar.zza, 1, k);
        zzja.zza(zzirVar, zzklVar.zzc, 2, v);
    }
}
