package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb = null;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zziz zze;

    zzjz(zziz zzizVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzizVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzu.zzr().zza(this.zza, (String) null, this.zzc, this.zzd);
    }
}
