package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlr implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzlb zzb;

    zzlr(zzlb zzlbVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfp zzfpVar = this.zzb.zzb;
        if (zzfpVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfpVar.zzg(this.zza);
            this.zzb.zzaq();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
