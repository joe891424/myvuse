package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgl extends zza implements zzgi {
    public zzgl() {
        super("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
    }

    public static zzgi asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.face.aidls.IFaceDetectorCreator");
        if (iInterfaceQueryLocalInterface instanceof zzgi) {
            return (zzgi) iInterfaceQueryLocalInterface;
        }
        return new zzgk(iBinder);
    }

    @Override // com.google.android.gms.internal.vision.zza
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzgh zzghVarNewFaceDetector = newFaceDetector(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzgd) zzd.zza(parcel, zzgd.CREATOR));
        parcel2.writeNoException();
        zzd.zza(parcel2, zzghVarNewFaceDetector);
        return true;
    }
}
