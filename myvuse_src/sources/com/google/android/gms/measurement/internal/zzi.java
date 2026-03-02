package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzi implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdd zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ AppMeasurementDynamiteService zze;

    zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzdd zzddVar, String str, String str2, boolean z) {
        this.zza = zzddVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
        this.zze = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza.zzr().zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
