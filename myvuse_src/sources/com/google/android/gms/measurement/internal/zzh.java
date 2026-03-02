package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzh implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdd zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdd zzddVar) {
        this.zza = zzddVar;
        this.zzb = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzr().zza(this.zza);
    }
}
