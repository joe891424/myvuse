package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlt implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzbf zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzlb zzf;

    zzlt(zzlb zzlbVar, boolean z, zzn zznVar, boolean z2, zzbf zzbfVar, String str) {
        this.zza = z;
        this.zzb = zznVar;
        this.zzc = z2;
        this.zzd = zzbfVar;
        this.zze = str;
        this.zzf = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzfp zzfpVar = this.zzf.zzb;
        if (zzfpVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfpVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    Preconditions.checkNotNull(this.zzb);
                    zzfpVar.zza(this.zzd, this.zzb);
                } else {
                    zzfpVar.zza(this.zzd, this.zze, this.zzf.zzj().zzx());
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzaq();
    }
}
