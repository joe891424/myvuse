package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkd implements zzka {
    private static <E> zzjq<E> zzc(Object obj, long j) {
        return (zzjq) zzmh.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final <L> List<L> zza(Object obj, long j) {
        zzjq zzjqVarZzc = zzc(obj, j);
        if (zzjqVarZzc.zzc()) {
            return zzjqVarZzc;
        }
        int size = zzjqVarZzc.size();
        zzjq zzjqVarZza = zzjqVarZzc.zza(size == 0 ? 10 : size << 1);
        zzmh.zza(obj, j, zzjqVarZza);
        return zzjqVarZza;
    }

    zzkd() {
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.measurement.zzjq] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.measurement.zzjq, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.measurement.zzka
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzjq zzjqVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzjqVarZzc.size();
        int size2 = Zzc.size();
        ?? r0 = zzjqVarZzc;
        r0 = zzjqVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZzc = zzjqVarZzc.zzc();
            ?? Zza = zzjqVarZzc;
            if (!zZzc) {
                Zza = zzjqVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r0 = Zza;
        }
        if (size > 0) {
            Zzc = r0;
        }
        zzmh.zza(obj, j, (Object) Zzc);
    }
}
