package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzho implements Runnable {
    private final /* synthetic */ zzix zza;
    private final /* synthetic */ zzhj zzb;

    zzho(zzhj zzhjVar, zzix zzixVar) {
        this.zza = zzixVar;
        this.zzb = zzhjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhj.zza(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
