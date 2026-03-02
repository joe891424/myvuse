package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzdb {
    zzhj zza = null;
    private final Map<Integer, zziu> zzb = new ArrayMap();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@22.0.1 */
    class zza implements zziv {
        private com.google.android.gms.internal.measurement.zzdi zza;

        zza(com.google.android.gms.internal.measurement.zzdi zzdiVar) {
            this.zza = zzdiVar;
        }

        @Override // com.google.android.gms.measurement.internal.zziv
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                if (AppMeasurementDynamiteService.this.zza != null) {
                    AppMeasurementDynamiteService.this.zza.zzj().zzu().zza("Event interceptor threw exception", e);
                }
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@22.0.1 */
    class zzb implements zziu {
        private com.google.android.gms.internal.measurement.zzdi zza;

        zzb(com.google.android.gms.internal.measurement.zzdi zzdiVar) {
            this.zza = zzdiVar;
        }

        @Override // com.google.android.gms.measurement.internal.zziu
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                if (AppMeasurementDynamiteService.this.zza != null) {
                    AppMeasurementDynamiteService.this.zza.zzj().zzu().zza("Event listener threw exception", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zze().zza(str, j);
    }

    @EnsuresNonNull({"scion"})
    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void clearMeasurementEnabled(long j) throws RemoteException {
        zza();
        this.zza.zzp().zza((Boolean) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zze().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void generateEventId(com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        long jZzm = this.zza.zzt().zzm();
        zza();
        this.zza.zzt().zza(zzddVar, jZzm);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzh(this, zzddVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        zza(zzddVar, this.zza.zzp().zzag());
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzk(this, zzddVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        zza(zzddVar, this.zza.zzp().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        zza(zzddVar, this.zza.zzp().zzai());
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        zza(zzddVar, this.zza.zzp().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        this.zza.zzp();
        zziz.zza(str);
        zza();
        this.zza.zzt().zza(zzddVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getSessionId(com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        this.zza.zzp().zza(zzddVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getTestFlag(com.google.android.gms.internal.measurement.zzdd zzddVar, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzt().zza(zzddVar, this.zza.zzp().zzak());
            return;
        }
        if (i == 1) {
            this.zza.zzt().zza(zzddVar, this.zza.zzp().zzaf().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzt().zza(zzddVar, this.zza.zzp().zzae().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzt().zza(zzddVar, this.zza.zzp().zzac().booleanValue());
                return;
            }
        }
        zznt zzntVarZzt = this.zza.zzt();
        double dDoubleValue = this.zza.zzp().zzad().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble(RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME, dDoubleValue);
        try {
            zzddVar.zza(bundle);
        } catch (RemoteException e) {
            zzntVarZzt.zzu.zzj().zzu().zza("Error returning double value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzi(this, zzddVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdl zzdlVar, long j) throws RemoteException {
        zzhj zzhjVar = this.zza;
        if (zzhjVar == null) {
            this.zza = zzhj.zza((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdlVar, Long.valueOf(j));
        } else {
            zzhjVar.zzj().zzu().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzdd zzddVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzm(this, zzddVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzdd zzddVar, long j) throws RemoteException {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzl().zzb(new zzj(this, zzddVar, new zzbf(str2, new zzba(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        this.zza.zzj().zza(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksZzaa = this.zza.zzp().zzaa();
        if (activityLifecycleCallbacksZzaa != null) {
            this.zza.zzp().zzan();
            activityLifecycleCallbacksZzaa.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksZzaa = this.zza.zzp().zzaa();
        if (activityLifecycleCallbacksZzaa != null) {
            this.zza.zzp().zzan();
            activityLifecycleCallbacksZzaa.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksZzaa = this.zza.zzp().zzaa();
        if (activityLifecycleCallbacksZzaa != null) {
            this.zza.zzp().zzan();
            activityLifecycleCallbacksZzaa.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksZzaa = this.zza.zzp().zzaa();
        if (activityLifecycleCallbacksZzaa != null) {
            this.zza.zzp().zzan();
            activityLifecycleCallbacksZzaa.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdd zzddVar, long j) throws RemoteException {
        zza();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksZzaa = this.zza.zzp().zzaa();
        Bundle bundle = new Bundle();
        if (activityLifecycleCallbacksZzaa != null) {
            this.zza.zzp().zzan();
            activityLifecycleCallbacksZzaa.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzddVar.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzj().zzu().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksZzaa = this.zza.zzp().zzaa();
        if (activityLifecycleCallbacksZzaa != null) {
            this.zza.zzp().zzan();
            activityLifecycleCallbacksZzaa.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksZzaa = this.zza.zzp().zzaa();
        if (activityLifecycleCallbacksZzaa != null) {
            this.zza.zzp().zzan();
            activityLifecycleCallbacksZzaa.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzdd zzddVar, long j) throws RemoteException {
        zza();
        zzddVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zziu zzbVar;
        zza();
        synchronized (this.zzb) {
            zzbVar = this.zzb.get(Integer.valueOf(zzdiVar.zza()));
            if (zzbVar == null) {
                zzbVar = new zzb(zzdiVar);
                this.zzb.put(Integer.valueOf(zzdiVar.zza()), zzbVar);
            }
        }
        this.zza.zzp().zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(j);
    }

    private final void zza(com.google.android.gms.internal.measurement.zzdd zzddVar, String str) {
        zza();
        this.zza.zzt().zza(zzddVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzj().zzg().zza("Conditional user property must not be null");
        } else {
            this.zza.zzp().zzb(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setConsent(Bundle bundle, long j) throws RemoteException {
        zza();
        this.zza.zzp().zzc(bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zza();
        this.zza.zzp().zzd(bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzq().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        this.zza.zzp().zzc(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        this.zza.zzp().zzc(bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza zzaVar = new zza(zzdiVar);
        if (this.zza.zzl().zzg()) {
            this.zza.zzp().zza(zzaVar);
        } else {
            this.zza.zzl().zzb(new zzl(this, zzaVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        this.zza.zzp().zzc(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setSgtmDebugInfo(Intent intent) throws RemoteException {
        zza();
        this.zza.zzp().zza(intent);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzdc
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zziu zziuVarRemove;
        zza();
        synchronized (this.zzb) {
            zziuVarRemove = this.zzb.remove(Integer.valueOf(zzdiVar.zza()));
        }
        if (zziuVarRemove == null) {
            zziuVarRemove = new zzb(zzdiVar);
        }
        this.zza.zzp().zzb(zziuVarRemove);
    }
}
