package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzau implements Runnable {
    private final /* synthetic */ zzil zza;
    private final /* synthetic */ zzav zzb;

    zzau(zzav zzavVar, zzil zzilVar) {
        this.zza = zzilVar;
        this.zzb = zzavVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzd();
        if (zzad.zza()) {
            this.zza.zzl().zzb(this);
            return;
        }
        boolean zZzc = this.zzb.zzc();
        this.zzb.zzd = 0L;
        if (zZzc) {
            this.zzb.zzb();
        }
    }
}
