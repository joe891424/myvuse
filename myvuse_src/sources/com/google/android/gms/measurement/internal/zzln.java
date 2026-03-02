package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzln implements Runnable {
    private final /* synthetic */ zzkt zza;
    private final /* synthetic */ zzlb zzb;

    zzln(zzlb zzlbVar, zzkt zzktVar) {
        this.zza = zzktVar;
        this.zzb = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfp zzfpVar = this.zzb.zzb;
        if (zzfpVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzkt zzktVar = this.zza;
            if (zzktVar == null) {
                zzfpVar.zza(0L, (String) null, (String) null, this.zzb.zza().getPackageName());
            } else {
                zzfpVar.zza(zzktVar.zzc, this.zza.zza, this.zza.zzb, this.zzb.zza().getPackageName());
            }
            this.zzb.zzaq();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to the service", e);
        }
    }
}
