package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgj extends zzb implements zzgh {
    zzgj(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetector");
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final void zza() throws RemoteException {
        zzb(1, m2384a_());
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final void zzb() throws RemoteException {
        zzb(2, m2384a_());
    }

    @Override // com.google.android.gms.internal.vision.zzgh
    public final List<zzgf> zza(IObjectWrapper iObjectWrapper, zzfz zzfzVar) throws RemoteException {
        Parcel parcelM2384a_ = m2384a_();
        zzd.zza(parcelM2384a_, iObjectWrapper);
        zzd.zza(parcelM2384a_, zzfzVar);
        Parcel parcelZza = zza(3, parcelM2384a_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzgf.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }
}
