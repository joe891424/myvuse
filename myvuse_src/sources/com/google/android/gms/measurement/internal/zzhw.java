package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhw implements Runnable {
    private final /* synthetic */ zzac zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzhn zzc;

    zzhw(zzhn zzhnVar, zzac zzacVar, zzn zznVar) {
        this.zza = zzacVar;
        this.zzb = zznVar;
        this.zzc = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zza(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzb(this.zza, this.zzb);
        }
    }
}
