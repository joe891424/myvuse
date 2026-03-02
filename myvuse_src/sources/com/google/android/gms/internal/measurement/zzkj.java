package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkj implements zzkr {
    private zzkr[] zza;

    @Override // com.google.android.gms.internal.measurement.zzkr
    public final zzko zza(Class<?> cls) {
        for (zzkr zzkrVar : this.zza) {
            if (zzkrVar.zzb(cls)) {
                return zzkrVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    zzkj(zzkr... zzkrVarArr) {
        this.zza = zzkrVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzkr
    public final boolean zzb(Class<?> cls) {
        for (zzkr zzkrVar : this.zza) {
            if (zzkrVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
