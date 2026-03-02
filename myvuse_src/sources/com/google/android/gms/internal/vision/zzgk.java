package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgk extends zzb implements zzgi {
    zzgk(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    @Override // com.google.android.gms.internal.vision.zzgi
    public final zzgh newFaceDetector(IObjectWrapper iObjectWrapper, zzgd zzgdVar) throws RemoteException {
        zzgh zzgjVar;
        Parcel parcelM2384a_ = m2384a_();
        zzd.zza(parcelM2384a_, iObjectWrapper);
        zzd.zza(parcelM2384a_, zzgdVar);
        Parcel parcelZza = zza(1, parcelM2384a_);
        IBinder strongBinder = parcelZza.readStrongBinder();
        if (strongBinder == null) {
            zzgjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetector");
            if (iInterfaceQueryLocalInterface instanceof zzgh) {
                zzgjVar = (zzgh) iInterfaceQueryLocalInterface;
            } else {
                zzgjVar = new zzgj(strongBinder);
            }
        }
        parcelZza.recycle();
        return zzgjVar;
    }
}
