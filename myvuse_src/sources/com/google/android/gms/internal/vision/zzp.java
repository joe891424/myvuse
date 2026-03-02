package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzp extends zzb implements zzn {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
    }

    @Override // com.google.android.gms.internal.vision.zzn
    public final zzl zza(IObjectWrapper iObjectWrapper, zzk zzkVar) throws RemoteException {
        zzl zzoVar;
        Parcel parcelM2384a_ = m2384a_();
        zzd.zza(parcelM2384a_, iObjectWrapper);
        zzd.zza(parcelM2384a_, zzkVar);
        Parcel parcelZza = zza(1, parcelM2384a_);
        IBinder strongBinder = parcelZza.readStrongBinder();
        if (strongBinder == null) {
            zzoVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            if (iInterfaceQueryLocalInterface instanceof zzl) {
                zzoVar = (zzl) iInterfaceQueryLocalInterface;
            } else {
                zzoVar = new zzo(strongBinder);
            }
        }
        parcelZza.recycle();
        return zzoVar;
    }
}
