package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzdn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfb extends zzdn.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzda zzd;
    private final /* synthetic */ zzdn.zzc zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfb(zzdn.zzc zzcVar, Activity activity, zzda zzdaVar) {
        super(zzdn.this);
        this.zzc = activity;
        this.zzd = zzdaVar;
        this.zze = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    final void zza() throws RemoteException {
        ((zzdc) Preconditions.checkNotNull(zzdn.this.zzj)).onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
