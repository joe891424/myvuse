package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgg extends zza implements zzgh {
    public zzgg() {
        super("com.google.mlkit.vision.face.aidls.IFaceDetector");
    }

    @Override // com.google.android.gms.internal.vision.zza
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza();
            parcel2.writeNoException();
        } else if (i == 2) {
            zzb();
            parcel2.writeNoException();
        } else {
            if (i != 3) {
                return false;
            }
            List<zzgf> listZza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzfz) zzd.zza(parcel, zzfz.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedList(listZza);
        }
        return true;
    }
}
