package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzj extends com.google.android.gms.internal.vision.zzb implements zzh {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) throws RemoteException {
        Parcel parcelM2384a_ = m2384a_();
        com.google.android.gms.internal.vision.zzd.zza(parcelM2384a_, iObjectWrapper);
        com.google.android.gms.internal.vision.zzd.zza(parcelM2384a_, zzsVar);
        Parcel parcelZza = zza(1, parcelM2384a_);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelZza.createTypedArray(FaceParcel.CREATOR);
        parcelZza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i, int i2, int i3, int i4, int i5, int i6, zzs zzsVar) throws RemoteException {
        Parcel parcelM2384a_ = m2384a_();
        com.google.android.gms.internal.vision.zzd.zza(parcelM2384a_, iObjectWrapper);
        com.google.android.gms.internal.vision.zzd.zza(parcelM2384a_, iObjectWrapper2);
        com.google.android.gms.internal.vision.zzd.zza(parcelM2384a_, iObjectWrapper3);
        parcelM2384a_.writeInt(i);
        parcelM2384a_.writeInt(i2);
        parcelM2384a_.writeInt(i3);
        parcelM2384a_.writeInt(i4);
        parcelM2384a_.writeInt(i5);
        parcelM2384a_.writeInt(i6);
        com.google.android.gms.internal.vision.zzd.zza(parcelM2384a_, zzsVar);
        Parcel parcelZza = zza(4, parcelM2384a_);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelZza.createTypedArray(FaceParcel.CREATOR);
        parcelZza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final boolean zza(int i) throws RemoteException {
        Parcel parcelM2384a_ = m2384a_();
        parcelM2384a_.writeInt(i);
        Parcel parcelZza = zza(2, parcelM2384a_);
        boolean zZza = com.google.android.gms.internal.vision.zzd.zza(parcelZza);
        parcelZza.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zza() throws RemoteException {
        zzb(3, m2384a_());
    }
}
