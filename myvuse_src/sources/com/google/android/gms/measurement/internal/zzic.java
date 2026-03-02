package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzic implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhn zzb;

    zzic(zzhn zzhnVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        this.zzb.zza.zzd(this.zza);
    }
}
