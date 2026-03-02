package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzdn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzez extends zzdn.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzdn.zzc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzez(zzdn.zzc zzcVar, Activity activity) {
        super(zzdn.this);
        this.zzc = activity;
        this.zzd = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdn.zzb
    final void zza() throws RemoteException {
        ((zzdc) Preconditions.checkNotNull(zzdn.this.zzj)).onActivityPaused(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}
