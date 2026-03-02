package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkm implements zzkn {
    @Override // com.google.android.gms.internal.measurement.zzkn
    public final int zza(int i, Object obj, Object obj2) {
        zzkk zzkkVar = (zzkk) obj;
        if (zzkkVar.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzkkVar.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final zzkl<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final Object zza(Object obj, Object obj2) {
        zzkk zzkkVarZzb = (zzkk) obj;
        zzkk zzkkVar = (zzkk) obj2;
        if (!zzkkVar.isEmpty()) {
            if (!zzkkVarZzb.zzd()) {
                zzkkVarZzb = zzkkVarZzb.zzb();
            }
            zzkkVarZzb.zza(zzkkVar);
        }
        return zzkkVarZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final Object zzb(Object obj) {
        return zzkk.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final Object zzc(Object obj) {
        ((zzkk) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final Map<?, ?> zzd(Object obj) {
        return (zzkk) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final Map<?, ?> zze(Object obj) {
        return (zzkk) obj;
    }

    zzkm() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final boolean zzf(Object obj) {
        return !((zzkk) obj).zzd();
    }
}
