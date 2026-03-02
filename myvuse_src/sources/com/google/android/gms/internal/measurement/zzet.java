package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzet extends zzdn.zzb {
    private final /* synthetic */ zzdn.zzd zzc;
    private final /* synthetic */ zzdn zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzet(zzdn zzdnVar, zzdn.zzd zzdVar) {
        super(zzdnVar);
        this.zzc = zzdVar;
        this.zzd = zzdnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    final void zza() throws RemoteException {
        ((zzdc) Preconditions.checkNotNull(this.zzd.zzj)).registerOnMeasurementEventListener(this.zzc);
    }
}
