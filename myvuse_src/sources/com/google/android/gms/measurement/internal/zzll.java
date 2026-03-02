package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzll implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdd zzb;
    private final /* synthetic */ zzlb zzc;

    zzll(zzlb zzlbVar, zzn zznVar, com.google.android.gms.internal.measurement.zzdd zzddVar) {
        this.zza = zznVar;
        this.zzb = zzddVar;
        this.zzc = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!this.zzc.zzk().zzn().zzj()) {
                this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zzc((String) null);
                this.zzc.zzk().zze.zza(null);
                return;
            }
            zzfp zzfpVar = this.zzc.zzb;
            if (zzfpVar == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(this.zza);
            String strZzb = zzfpVar.zzb(this.zza);
            if (strZzb != null) {
                this.zzc.zzm().zzc(strZzb);
                this.zzc.zzk().zze.zza(strZzb);
            }
            this.zzc.zzaq();
            this.zzc.zzq().zza(this.zzb, strZzb);
        } catch (RemoteException e) {
            this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzq().zza(this.zzb, (String) null);
        }
    }
}
