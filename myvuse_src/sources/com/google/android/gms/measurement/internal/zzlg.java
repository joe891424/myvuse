package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlg implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzno zzc;
    private final /* synthetic */ zzlb zzd;

    zzlg(zzlb zzlbVar, zzn zznVar, boolean z, zzno zznoVar) {
        this.zza = zznVar;
        this.zzb = z;
        this.zzc = zznoVar;
        this.zzd = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzfp zzfpVar = this.zzd.zzb;
        if (zzfpVar == null) {
            this.zzd.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zza(zzfpVar, this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzaq();
    }
}
