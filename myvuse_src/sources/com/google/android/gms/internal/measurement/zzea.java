package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzea extends zzdn.zzb {
    private final /* synthetic */ zzdn zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzea(zzdn zzdnVar) {
        super(zzdnVar);
        this.zzc = zzdnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    final void zza() throws RemoteException {
        ((zzdc) Preconditions.checkNotNull(this.zzc.zzj)).resetAnalyticsData(this.zza);
    }
}
