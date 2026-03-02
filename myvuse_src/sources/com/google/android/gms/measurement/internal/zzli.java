package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzli implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzlb zzc;

    zzli(zzlb zzlbVar, AtomicReference atomicReference, zzn zznVar) {
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                } catch (RemoteException e) {
                    this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
                }
                if (!this.zzc.zzk().zzn().zzj()) {
                    this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzm().zzc((String) null);
                    this.zzc.zzk().zze.zza(null);
                    this.zza.set(null);
                    return;
                }
                zzfp zzfpVar = this.zzc.zzb;
                if (zzfpVar == null) {
                    this.zzc.zzj().zzg().zza("Failed to get app instance id");
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzfpVar.zzb(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzm().zzc(str);
                    this.zzc.zzk().zze.zza(str);
                }
                this.zzc.zzaq();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
