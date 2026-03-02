package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkd implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zziz zzb;

    zzkd(zziz zzizVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzizVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Long.valueOf(this.zzb.zze().zzc(this.zzb.zzg().zzad(), zzbh.zzam)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
