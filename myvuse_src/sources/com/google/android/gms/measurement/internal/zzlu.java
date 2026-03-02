package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlu implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdd zzd;
    private final /* synthetic */ zzlb zze;

    zzlu(zzlb zzlbVar, String str, String str2, zzn zznVar, com.google.android.gms.internal.measurement.zzdd zzddVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zznVar;
        this.zzd = zzddVar;
        this.zze = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzfp zzfpVar = this.zze.zzb;
            if (zzfpVar == null) {
                this.zze.zzj().zzg().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            ArrayList<Bundle> arrayListZzb = zznt.zzb(zzfpVar.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzaq();
            this.zze.zzq().zza(this.zzd, arrayListZzb);
        } catch (RemoteException e) {
            this.zze.zzj().zzg().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } finally {
            this.zze.zzq().zza(this.zzd, arrayList);
        }
    }
}
