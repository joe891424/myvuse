package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhj;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zziu;
import com.google.android.gms.measurement.internal.zziv;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzkq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zza;
    private final zza zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
    public static class ConditionalUserProperty {
        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;

        public ConditionalUserProperty() {
        }

        ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzio.zza(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzio.zza(bundle, "origin", String.class, null);
            this.mName = (String) zzio.zza(bundle, "name", String.class, null);
            this.mValue = zzio.zza(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
            this.mTriggerTimeout = ((Long) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
            this.mTimedOutEventParams = (Bundle) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            this.mTriggeredEventName = (String) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
            this.mTriggeredEventParams = (Bundle) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            this.mTimeToLive = ((Long) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
            this.mExpiredEventParams = (Bundle) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
            this.mActive = ((Boolean) zzio.zza(bundle, "active", Boolean.class, false)).booleanValue();
            this.mCreationTimestamp = ((Long) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzio.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object objZza = zzkq.zza(obj);
                this.mValue = objZza;
                if (objZza == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
    public interface EventInterceptor extends zziv {
        @Override // com.google.android.gms.measurement.internal.zziv
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
    public interface OnEventListener extends zziu {
        @Override // com.google.android.gms.measurement.internal.zziu
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
    static abstract class zza implements zzkk {
        private zza() {
        }

        abstract Map<String, Object> zza(boolean z);

        abstract Boolean zzb();

        abstract Double zzc();

        abstract Integer zzd();

        abstract Long zze();

        abstract String zzj();
    }

    public int getMaxUserProperties(String str) {
        return this.zzb.zza(str);
    }

    public long generateEventId() {
        return this.zzb.zza();
    }

    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zza(context, null, null);
    }

    private static AppMeasurement zza(Context context, String str, String str2) {
        if (zza == null) {
            synchronized (AppMeasurement.class) {
                if (zza == null) {
                    zzkk zzkkVarZza = zza(context, null);
                    if (zzkkVarZza != null) {
                        zza = new AppMeasurement(zzkkVarZza);
                    } else {
                        zza = new AppMeasurement(zzhj.zza(context, new zzdl(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return zza;
    }

    private static zzkk zza(Context context, Bundle bundle) {
        try {
            return (zzkk) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
        } catch (ClassNotFoundException | Exception unused) {
            return null;
        }
    }

    public Boolean getBoolean() {
        return this.zzb.zzb();
    }

    public Double getDouble() {
        return this.zzb.zzc();
    }

    public Integer getInteger() {
        return this.zzb.zzd();
    }

    public Long getLong() {
        return this.zzb.zze();
    }

    public String getAppInstanceId() {
        return this.zzb.zzf();
    }

    public String getCurrentScreenClass() {
        return this.zzb.zzg();
    }

    public String getCurrentScreenName() {
        return this.zzb.zzh();
    }

    public String getGmpAppId() {
        return this.zzb.zzi();
    }

    public String getString() {
        return this.zzb.zzj();
    }

    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> listZza = this.zzb.zza(str, str2);
        ArrayList arrayList = new ArrayList(listZza == null ? 0 : listZza.size());
        Iterator<Bundle> it2 = listZza.iterator();
        while (it2.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it2.next()));
        }
        return arrayList;
    }

    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzb.zza(z);
    }

    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzb.zza(str, str2, z);
    }

    private AppMeasurement(zzhj zzhjVar) {
        this.zzb = new com.google.android.gms.measurement.zza(zzhjVar);
    }

    private AppMeasurement(zzkk zzkkVar) {
        this.zzb = new zzc(zzkkVar);
    }

    public void beginAdUnitExposure(String str) {
        this.zzb.zzb(str);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzb.zza(str, str2, bundle);
    }

    public void endAdUnitExposure(String str) {
        this.zzb.zzc(str);
    }

    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.zzb.zzb(str, str2, bundle);
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzb.zza(str, str2, bundle, j);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzb.zza(onEventListener);
    }

    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zza zzaVar = this.zzb;
        Bundle bundle = new Bundle();
        if (conditionalUserProperty.mAppId != null) {
            bundle.putString("app_id", conditionalUserProperty.mAppId);
        }
        if (conditionalUserProperty.mOrigin != null) {
            bundle.putString("origin", conditionalUserProperty.mOrigin);
        }
        if (conditionalUserProperty.mName != null) {
            bundle.putString("name", conditionalUserProperty.mName);
        }
        if (conditionalUserProperty.mValue != null) {
            zzio.zza(bundle, conditionalUserProperty.mValue);
        }
        if (conditionalUserProperty.mTriggerEventName != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, conditionalUserProperty.mTriggerEventName);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.mTriggerTimeout);
        if (conditionalUserProperty.mTimedOutEventName != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, conditionalUserProperty.mTimedOutEventName);
        }
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, conditionalUserProperty.mTimedOutEventParams);
        }
        if (conditionalUserProperty.mTriggeredEventName != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, conditionalUserProperty.mTriggeredEventName);
        }
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, conditionalUserProperty.mTriggeredEventParams);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.mTimeToLive);
        if (conditionalUserProperty.mExpiredEventName != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, conditionalUserProperty.mExpiredEventName);
        }
        if (conditionalUserProperty.mExpiredEventParams != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, conditionalUserProperty.mExpiredEventParams);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.mTriggeredTimestamp);
        zzaVar.zza(bundle);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zzb.zza(eventInterceptor);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzb.zzb(onEventListener);
    }
}
