package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends zzb implements zzl {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final Barcode[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) throws RemoteException {
        Parcel parcelM2384a_ = m2384a_();
        zzd.zza(parcelM2384a_, iObjectWrapper);
        zzd.zza(parcelM2384a_, zzsVar);
        Parcel parcelZza = zza(1, parcelM2384a_);
        Barcode[] barcodeArr = (Barcode[]) parcelZza.createTypedArray(Barcode.CREATOR);
        parcelZza.recycle();
        return barcodeArr;
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final Barcode[] zzb(IObjectWrapper iObjectWrapper, zzs zzsVar) throws RemoteException {
        Parcel parcelM2384a_ = m2384a_();
        zzd.zza(parcelM2384a_, iObjectWrapper);
        zzd.zza(parcelM2384a_, zzsVar);
        Parcel parcelZza = zza(2, parcelM2384a_);
        Barcode[] barcodeArr = (Barcode[]) parcelZza.createTypedArray(Barcode.CREATOR);
        parcelZza.recycle();
        return barcodeArr;
    }

    @Override // com.google.android.gms.internal.vision.zzl
    public final void zza() throws RemoteException {
        zzb(3, m2384a_());
    }
}
