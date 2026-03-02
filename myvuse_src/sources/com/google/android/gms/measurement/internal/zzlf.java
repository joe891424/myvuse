package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlf implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdd zze;
    private final /* synthetic */ zzlb zzf;

    zzlf(zzlb zzlbVar, String str, String str2, zzn zznVar, boolean z, com.google.android.gms.internal.measurement.zzdd zzddVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zznVar;
        this.zzd = z;
        this.zze = zzddVar;
        this.zzf = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzfp zzfpVar = this.zzf.zzb;
            if (zzfpVar == null) {
                this.zzf.zzj().zzg().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            Bundle bundleZza = zznt.zza(zzfpVar.zza(this.zza, this.zzb, this.zzd, this.zzc));
            this.zzf.zzaq();
            this.zzf.zzq().zza(this.zze, bundleZza);
        } catch (RemoteException e) {
            this.zzf.zzj().zzg().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzq().zza(this.zze, bundle);
        }
    }
}
