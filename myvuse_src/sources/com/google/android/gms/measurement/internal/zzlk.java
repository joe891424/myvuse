package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlk implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzlb zzb;

    zzlk(zzlb zzlbVar, zzn zznVar) {
        this.zza = zznVar;
        this.zzb = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzfp zzfpVar = this.zzb.zzb;
        if (zzfpVar == null) {
            this.zzb.zzj().zzg().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfpVar.zzc(this.zza);
            this.zzb.zzh().zzac();
            this.zzb.zza(zzfpVar, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzaq();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send app launch to the service", e);
        }
    }
}
