package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzek extends zzdn.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzda zzf;
    private final /* synthetic */ zzdn zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzek(zzdn zzdnVar, String str, String str2, boolean z, zzda zzdaVar) {
        super(zzdnVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = z;
        this.zzf = zzdaVar;
        this.zzg = zzdnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    protected final void zzb() {
        this.zzf.zza((Bundle) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    final void zza() throws RemoteException {
        ((zzdc) Preconditions.checkNotNull(this.zzg.zzj)).getUserProperties(this.zzc, this.zzd, this.zze, this.zzf);
    }
}
