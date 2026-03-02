package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkg implements zzkh {
    zzkg() {
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Map<?, ?> zza(Object obj) {
        return (zzke) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final zzkf<?, ?> zzb(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Map<?, ?> zzc(Object obj) {
        return (zzke) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final boolean zzd(Object obj) {
        return !((zzke) obj).zzd();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zze(Object obj) {
        ((zzke) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zzf(Object obj) {
        return zzke.zza().zzb();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zza(Object obj, Object obj2) {
        zzke zzkeVarZzb = (zzke) obj;
        zzke zzkeVar = (zzke) obj2;
        if (!zzkeVar.isEmpty()) {
            if (!zzkeVarZzb.zzd()) {
                zzkeVarZzb = zzkeVarZzb.zzb();
            }
            zzkeVarZzb.zza(zzkeVar);
        }
        return zzkeVarZzb;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final int zza(int i, Object obj, Object obj2) {
        zzke zzkeVar = (zzke) obj;
        if (zzkeVar.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzkeVar.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
