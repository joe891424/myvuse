package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjc;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zziz<T extends zzjc<T>> {
    zziz() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract zzja<T> zza(Object obj);

    abstract Object zza(zzix zzixVar, zzkq zzkqVar, int i);

    abstract <UT, UB> UB zza(Object obj, zzlj zzljVar, Object obj2, zzix zzixVar, zzja<T> zzjaVar, UB ub, zzmc<UT, UB> zzmcVar) throws IOException;

    abstract void zza(zzhx zzhxVar, Object obj, zzix zzixVar, zzja<T> zzjaVar) throws IOException;

    abstract void zza(zzlj zzljVar, Object obj, zzix zzixVar, zzja<T> zzjaVar) throws IOException;

    abstract void zza(zzmx zzmxVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zza(zzkq zzkqVar);

    abstract zzja<T> zzb(Object obj);

    abstract void zzc(Object obj);
}
