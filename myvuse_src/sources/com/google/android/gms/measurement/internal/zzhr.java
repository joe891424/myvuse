package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhr implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhn zzb;

    zzhr(zzhn zzhnVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        zznc zzncVar = this.zzb.zza;
        zzn zznVar = this.zza;
        zzncVar.zzl().zzt();
        zzncVar.zzs();
        Preconditions.checkNotEmpty(zznVar.zza);
        zzncVar.zza(zznVar);
    }
}
