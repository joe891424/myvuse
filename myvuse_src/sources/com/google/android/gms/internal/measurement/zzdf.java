package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdf extends zzbu implements zzdd {
    zzdf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public final void zza(Bundle bundle) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, bundle);
        zzb(1, parcelM2381a_);
    }
}
