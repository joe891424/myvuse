package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlp extends zzav {
    private final /* synthetic */ zzlb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlp(zzlb zzlbVar, zzil zzilVar) {
        super(zzilVar);
        this.zza = zzlbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() {
        this.zza.zzj().zzu().zza("Tasks have been queued for a long time");
    }
}
