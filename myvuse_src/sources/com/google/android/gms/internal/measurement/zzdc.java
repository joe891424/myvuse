package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzdc extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(zzdd zzddVar) throws RemoteException;

    void getAppInstanceId(zzdd zzddVar) throws RemoteException;

    void getCachedAppInstanceId(zzdd zzddVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, zzdd zzddVar) throws RemoteException;

    void getCurrentScreenClass(zzdd zzddVar) throws RemoteException;

    void getCurrentScreenName(zzdd zzddVar) throws RemoteException;

    void getGmpAppId(zzdd zzddVar) throws RemoteException;

    void getMaxUserProperties(String str, zzdd zzddVar) throws RemoteException;

    void getSessionId(zzdd zzddVar) throws RemoteException;

    void getTestFlag(zzdd zzddVar, int i) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, zzdd zzddVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(IObjectWrapper iObjectWrapper, zzdl zzdlVar, long j) throws RemoteException;

    void isDataCollectionEnabled(zzdd zzddVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, zzdd zzddVar, long j) throws RemoteException;

    void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdd zzddVar, long j) throws RemoteException;

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void performAction(Bundle bundle, zzdd zzddVar, long j) throws RemoteException;

    void registerOnMeasurementEventListener(zzdi zzdiVar) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setConsent(Bundle bundle, long j) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(zzdi zzdiVar) throws RemoteException;

    void setInstanceIdProvider(zzdj zzdjVar) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setSgtmDebugInfo(Intent intent) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(zzdi zzdiVar) throws RemoteException;
}
