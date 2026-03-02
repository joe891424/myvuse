package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzik implements Callable<List<zznq>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzhn zzb;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zznq> call() throws Exception {
        this.zzb.zza.zzr();
        return this.zzb.zza.zzf().zzk(this.zza);
    }

    zzik(zzhn zzhnVar, String str) {
        this.zza = str;
        this.zzb = zzhnVar;
    }
}
