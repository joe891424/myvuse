package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdu extends zzdn.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzda zze;
    private final /* synthetic */ zzdn zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdu(zzdn zzdnVar, String str, String str2, zzda zzdaVar) {
        super(zzdnVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzdaVar;
        this.zzf = zzdnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    protected final void zzb() {
        this.zze.zza((Bundle) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    final void zza() throws RemoteException {
        ((zzdc) Preconditions.checkNotNull(this.zzf.zzj)).getConditionalUserProperties(this.zzc, this.zzd, this.zze);
    }
}
