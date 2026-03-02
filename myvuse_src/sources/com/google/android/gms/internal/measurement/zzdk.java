package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdk extends zzbu implements zzdi {
    @Override // com.google.android.gms.internal.measurement.zzdi
    public final int zza() throws RemoteException {
        Parcel parcelZza = zza(2, m2381a_());
        int i = parcelZza.readInt();
        parcelZza.recycle();
        return i;
    }

    zzdk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzdi
    public final void zza(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        zzbw.zza(parcelM2381a_, bundle);
        parcelM2381a_.writeLong(j);
        zzb(1, parcelM2381a_);
    }
}
