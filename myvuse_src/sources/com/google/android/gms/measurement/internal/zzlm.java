package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlm implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzlb zzc;

    zzlm(zzlb zzlbVar, zzn zznVar, Bundle bundle) {
        this.zza = zznVar;
        this.zzb = bundle;
        this.zzc = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfp zzfpVar = this.zzc.zzb;
        if (zzfpVar == null) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfpVar.zza(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service", e);
        }
    }
}
