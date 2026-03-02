package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzk extends com.google.android.gms.internal.vision.zzb implements zzi {
    zzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzi
    public final zzh newFaceDetector(IObjectWrapper iObjectWrapper, zzf zzfVar) throws RemoteException {
        zzh zzjVar;
        Parcel parcelM2384a_ = m2384a_();
        com.google.android.gms.internal.vision.zzd.zza(parcelM2384a_, iObjectWrapper);
        com.google.android.gms.internal.vision.zzd.zza(parcelM2384a_, zzfVar);
        Parcel parcelZza = zza(1, parcelM2384a_);
        IBinder strongBinder = parcelZza.readStrongBinder();
        if (strongBinder == null) {
            zzjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            if (iInterfaceQueryLocalInterface instanceof zzh) {
                zzjVar = (zzh) iInterfaceQueryLocalInterface;
            } else {
                zzjVar = new zzj(strongBinder);
            }
        }
        parcelZza.recycle();
        return zzjVar;
    }
}
