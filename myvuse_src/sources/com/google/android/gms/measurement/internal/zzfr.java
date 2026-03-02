package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfr extends com.google.android.gms.internal.measurement.zzbu implements zzfp {
    @Override // com.google.android.gms.measurement.internal.zzfp
    public final zzal zza(zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        Parcel parcelZza = zza(21, parcelM2381a_);
        zzal zzalVar = (zzal) com.google.android.gms.internal.measurement.zzbw.zza(parcelZza, zzal.CREATOR);
        parcelZza.recycle();
        return zzalVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final String zzb(zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        Parcel parcelZza = zza(11, parcelM2381a_);
        String string = parcelZza.readString();
        parcelZza.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzmu> zza(zzn zznVar, Bundle bundle) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, bundle);
        Parcel parcelZza = zza(24, parcelM2381a_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzmu.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzno> zza(zzn zznVar, boolean z) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, z);
        Parcel parcelZza = zza(7, parcelM2381a_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzno.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzac> zza(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        Parcel parcelZza = zza(16, parcelM2381a_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzac.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzac> zza(String str, String str2, String str3) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        parcelM2381a_.writeString(str3);
        Parcel parcelZza = zza(17, parcelM2381a_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzac.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzno> zza(String str, String str2, boolean z, zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, z);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        Parcel parcelZza = zza(14, parcelM2381a_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzno.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzno> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        parcelM2381a_.writeString(str3);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, z);
        Parcel parcelZza = zza(15, parcelM2381a_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(zzno.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    zzfr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzc(zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(4, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzbf zzbfVar, zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zzbfVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(1, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzbf zzbfVar, String str, String str2) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zzbfVar);
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        zzb(5, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzd(zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(18, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzac zzacVar, zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zzacVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(12, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzac zzacVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zzacVar);
        zzb(13, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zze(zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(20, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeLong(j);
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        parcelM2381a_.writeString(str3);
        zzb(10, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(Bundle bundle, zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, bundle);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(19, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzf(zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(26, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzg(zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(6, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzh(zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(25, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzno zznoVar, zzn zznVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznoVar);
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zznVar);
        zzb(2, parcelM2381a_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final byte[] zza(zzbf zzbfVar, String str) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        com.google.android.gms.internal.measurement.zzbw.zza(parcelM2381a_, zzbfVar);
        parcelM2381a_.writeString(str);
        Parcel parcelZza = zza(9, parcelM2381a_);
        byte[] bArrCreateByteArray = parcelZza.createByteArray();
        parcelZza.recycle();
        return bArrCreateByteArray;
    }
}
