package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhv implements Runnable {
    private final /* synthetic */ zzac zza;
    private final /* synthetic */ zzhn zzb;

    zzhv(zzhn zzhnVar, zzac zzacVar) {
        this.zza = zzacVar;
        this.zzb = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zza(this.zza);
        } else {
            this.zzb.zza.zzb(this.zza);
        }
    }
}
