package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzep extends zzdn.zzb {
    private final /* synthetic */ zzda zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzdn zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzep(zzdn zzdnVar, zzda zzdaVar, int i) {
        super(zzdnVar);
        this.zzc = zzdaVar;
        this.zzd = i;
        this.zze = zzdnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    protected final void zzb() {
        this.zzc.zza((Bundle) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    final void zza() throws RemoteException {
        ((zzdc) Preconditions.checkNotNull(this.zze.zzj)).getTestFlag(this.zzc, this.zzd);
    }
}
