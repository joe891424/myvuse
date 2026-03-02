package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkx implements Runnable {
    private final /* synthetic */ zzks zza;

    zzkx(zzks zzksVar) {
        this.zza = zzksVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzks zzksVar = this.zza;
        zzksVar.zza = zzksVar.zzh;
    }
}
