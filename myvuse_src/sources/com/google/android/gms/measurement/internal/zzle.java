package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzle implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzlb zzd;

    zzle(zzlb zzlbVar, AtomicReference atomicReference, zzn zznVar, boolean z) {
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = z;
        this.zzd = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfp zzfpVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfpVar = this.zzd.zzb;
                } catch (RemoteException e) {
                    this.zzd.zzj().zzg().zza("Failed to get all user properties; remote exception", e);
                }
                if (zzfpVar == null) {
                    this.zzd.zzj().zzg().zza("Failed to get all user properties; not connected to service");
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzfpVar.zza(this.zzb, this.zzc));
                this.zzd.zzaq();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
