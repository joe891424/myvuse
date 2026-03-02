package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlo implements Runnable {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdd zzc;
    private final /* synthetic */ zzlb zzd;

    zzlo(zzlb zzlbVar, zzbf zzbfVar, String str, com.google.android.gms.internal.measurement.zzdd zzddVar) {
        this.zza = zzbfVar;
        this.zzb = str;
        this.zzc = zzddVar;
        this.zzd = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzfp zzfpVar = this.zzd.zzb;
            if (zzfpVar == null) {
                this.zzd.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] bArrZza = zzfpVar.zza(this.zza, this.zzb);
            this.zzd.zzaq();
            this.zzd.zzq().zza(this.zzc, bArrZza);
        } catch (RemoteException e) {
            this.zzd.zzj().zzg().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzq().zza(this.zzc, (byte[]) null);
        }
    }
}
