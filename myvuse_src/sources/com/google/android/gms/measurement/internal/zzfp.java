package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzfp extends IInterface {
    zzal zza(zzn zznVar) throws RemoteException;

    List<zzmu> zza(zzn zznVar, Bundle bundle) throws RemoteException;

    List<zzno> zza(zzn zznVar, boolean z) throws RemoteException;

    List<zzac> zza(String str, String str2, zzn zznVar) throws RemoteException;

    List<zzac> zza(String str, String str2, String str3) throws RemoteException;

    List<zzno> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzno> zza(String str, String str2, boolean z, zzn zznVar) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzn zznVar) throws RemoteException;

    void zza(zzac zzacVar) throws RemoteException;

    void zza(zzac zzacVar, zzn zznVar) throws RemoteException;

    void zza(zzbf zzbfVar, zzn zznVar) throws RemoteException;

    void zza(zzbf zzbfVar, String str, String str2) throws RemoteException;

    void zza(zzno zznoVar, zzn zznVar) throws RemoteException;

    byte[] zza(zzbf zzbfVar, String str) throws RemoteException;

    String zzb(zzn zznVar) throws RemoteException;

    void zzc(zzn zznVar) throws RemoteException;

    void zzd(zzn zznVar) throws RemoteException;

    void zze(zzn zznVar) throws RemoteException;

    void zzf(zzn zznVar) throws RemoteException;

    void zzg(zzn zznVar) throws RemoteException;

    void zzh(zzn zznVar) throws RemoteException;
}
