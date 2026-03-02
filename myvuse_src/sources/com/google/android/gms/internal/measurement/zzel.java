package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzel extends zzdn.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzda zzd;
    private final /* synthetic */ zzdn zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzel(zzdn zzdnVar, Bundle bundle, zzda zzdaVar) {
        super(zzdnVar);
        this.zzc = bundle;
        this.zzd = zzdaVar;
        this.zze = zzdnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    protected final void zzb() {
        this.zzd.zza((Bundle) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    final void zza() throws RemoteException {
        ((zzdc) Preconditions.checkNotNull(this.zze.zzj)).performAction(this.zzc, this.zzd, this.zza);
    }
}
