package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzde extends zzbu implements zzdc {
    zzde(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeLong(j);
        zzb(23, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        zzbw.zza(parcelM2381a_, bundle);
        zzb(9, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeLong(j);
        zzb(43, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeLong(j);
        zzb(24, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void generateEventId(zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(22, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getAppInstanceId(zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(20, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getCachedAppInstanceId(zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(19, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getConditionalUserProperties(String str, String str2, zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(10, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getCurrentScreenClass(zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(17, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getCurrentScreenName(zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(16, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getGmpAppId(zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(21, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getMaxUserProperties(String str, zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(6, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getSessionId(zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(46, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getTestFlag(zzdd zzddVar, int i) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        parcelM2381a_.writeInt(i);
        zzb(38, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void getUserProperties(String str, String str2, boolean z, zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        zzbw.zza(parcelM2381a_, z);
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(5, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void initForTests(Map map) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeMap(map);
        zzb(37, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void initialize(IObjectWrapper iObjectWrapper, zzdl zzdlVar, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        zzbw.zza(parcelM2381a_, zzdlVar);
        parcelM2381a_.writeLong(j);
        zzb(1, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void isDataCollectionEnabled(zzdd zzddVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzddVar);
        zzb(40, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        zzbw.zza(parcelM2381a_, bundle);
        zzbw.zza(parcelM2381a_, z);
        zzbw.zza(parcelM2381a_, z2);
        parcelM2381a_.writeLong(j);
        zzb(2, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzdd zzddVar, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        zzbw.zza(parcelM2381a_, bundle);
        zzbw.zza(parcelM2381a_, zzddVar);
        parcelM2381a_.writeLong(j);
        zzb(3, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeInt(i);
        parcelM2381a_.writeString(str);
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        zzbw.zza(parcelM2381a_, iObjectWrapper2);
        zzbw.zza(parcelM2381a_, iObjectWrapper3);
        zzb(33, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        zzbw.zza(parcelM2381a_, bundle);
        parcelM2381a_.writeLong(j);
        zzb(27, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        parcelM2381a_.writeLong(j);
        zzb(28, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        parcelM2381a_.writeLong(j);
        zzb(29, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        parcelM2381a_.writeLong(j);
        zzb(30, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdd zzddVar, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        zzbw.zza(parcelM2381a_, zzddVar);
        parcelM2381a_.writeLong(j);
        zzb(31, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        parcelM2381a_.writeLong(j);
        zzb(25, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        parcelM2381a_.writeLong(j);
        zzb(26, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void performAction(Bundle bundle, zzdd zzddVar, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, bundle);
        zzbw.zza(parcelM2381a_, zzddVar);
        parcelM2381a_.writeLong(j);
        zzb(32, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void registerOnMeasurementEventListener(zzdi zzdiVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzdiVar);
        zzb(35, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeLong(j);
        zzb(12, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, bundle);
        parcelM2381a_.writeLong(j);
        zzb(8, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setConsent(Bundle bundle, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, bundle);
        parcelM2381a_.writeLong(j);
        zzb(44, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, bundle);
        parcelM2381a_.writeLong(j);
        zzb(45, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        parcelM2381a_.writeLong(j);
        zzb(15, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, z);
        zzb(39, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, bundle);
        zzb(42, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setEventInterceptor(zzdi zzdiVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzdiVar);
        zzb(34, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setInstanceIdProvider(zzdj zzdjVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzdjVar);
        zzb(18, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, z);
        parcelM2381a_.writeLong(j);
        zzb(11, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeLong(j);
        zzb(13, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeLong(j);
        zzb(14, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setSgtmDebugInfo(Intent intent) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, intent);
        zzb(48, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeLong(j);
        zzb(7, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        parcelM2381a_.writeString(str);
        parcelM2381a_.writeString(str2);
        zzbw.zza(parcelM2381a_, iObjectWrapper);
        zzbw.zza(parcelM2381a_, z);
        parcelM2381a_.writeLong(j);
        zzb(4, parcelM2381a_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public final void unregisterOnMeasurementEventListener(zzdi zzdiVar) throws RemoteException {
        Parcel parcelM2381a_ = m2381a_();
        zzbw.zza(parcelM2381a_, zzdiVar);
        zzb(36, parcelM2381a_);
    }
}
