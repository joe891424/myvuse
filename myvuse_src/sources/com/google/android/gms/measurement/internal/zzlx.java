package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlx implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzn zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ zzlb zzg;

    zzlx(zzlb zzlbVar, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar, boolean z) {
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zznVar;
        this.zzf = z;
        this.zzg = zzlbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfp zzfpVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfpVar = this.zzg.zzb;
                } catch (RemoteException e) {
                    this.zzg.zzj().zzg().zza("(legacy) Failed to get user properties; remote exception", zzfw.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                }
                if (zzfpVar == null) {
                    this.zzg.zzj().zzg().zza("(legacy) Failed to get user properties; not connected to service", zzfw.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    Preconditions.checkNotNull(this.zze);
                    this.zza.set(zzfpVar.zza(this.zzc, this.zzd, this.zzf, this.zze));
                } else {
                    this.zza.set(zzfpVar.zza(this.zzb, this.zzc, this.zzd, this.zzf));
                }
                this.zzg.zzaq();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
