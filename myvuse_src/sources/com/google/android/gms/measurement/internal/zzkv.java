package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkv implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzkt zzb;
    private final /* synthetic */ zzkt zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzks zze;

    zzkv(zzks zzksVar, Bundle bundle, zzkt zzktVar, zzkt zzktVar2, long j) {
        this.zza = bundle;
        this.zzb = zzktVar;
        this.zzc = zzktVar2;
        this.zzd = j;
        this.zze = zzksVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzks.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
