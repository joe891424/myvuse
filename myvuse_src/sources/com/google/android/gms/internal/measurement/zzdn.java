package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Pair;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.newrelic.agent.android.payload.PayloadController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public class zzdn {
    private static volatile zzdn zzb;
    protected final Clock zza;
    private final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<com.google.android.gms.measurement.internal.zziu, zzd>> zzf;
    private int zzg;
    private boolean zzh;
    private String zzi;
    private volatile zzdc zzj;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
    static class zza extends zzdh {
        private final com.google.android.gms.measurement.internal.zziv zza;

        @Override // com.google.android.gms.internal.measurement.zzdi
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        zza(com.google.android.gms.measurement.internal.zziv zzivVar) {
            this.zza = zzivVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdi
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
    class zzc implements Application.ActivityLifecycleCallbacks {
        zzc() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzdn.this.zza(new zzey(this, bundle, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzdn.this.zza(new zzfd(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzdn.this.zza(new zzez(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzdn.this.zza(new zzfa(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzda zzdaVar = new zzda();
            zzdn.this.zza(new zzfb(this, activity, zzdaVar));
            Bundle bundleZza = zzdaVar.zza(50L);
            if (bundleZza != null) {
                bundle.putAll(bundleZza);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzdn.this.zza(new zzex(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzdn.this.zza(new zzfc(this, activity));
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
    static class zzd extends zzdh {
        private final com.google.android.gms.measurement.internal.zziu zza;

        @Override // com.google.android.gms.internal.measurement.zzdi
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        zzd(com.google.android.gms.measurement.internal.zziu zziuVar) {
            this.zza = zziuVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdi
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }
    }

    public final int zza(String str) {
        zzda zzdaVar = new zzda();
        zza(new zzeo(this, str, zzdaVar));
        Integer num = (Integer) zzda.zza(zzdaVar.zza(WorkRequest.MIN_BACKOFF_MILLIS), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.0.1 */
    abstract class zzb implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zzb(zzdn zzdnVar) {
            this(true);
        }

        abstract void zza() throws RemoteException;

        protected void zzb() {
        }

        zzb(boolean z) {
            this.zza = zzdn.this.zza.currentTimeMillis();
            this.zzb = zzdn.this.zza.elapsedRealtime();
            this.zzc = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzdn.this.zzh) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzdn.this.zza(e, false, this.zzc);
                zzb();
            }
        }
    }

    public final long zza() {
        zzda zzdaVar = new zzda();
        zza(new zzef(this, zzdaVar));
        Long lZzb = zzdaVar.zzb(500L);
        if (lZzb == null) {
            long jNextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i = this.zzg + 1;
            this.zzg = i;
            return jNextLong + ((long) i);
        }
        return lZzb.longValue();
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzda zzdaVar = new zzda();
        zza(new zzel(this, bundle, zzdaVar));
        if (z) {
            return zzdaVar.zza(5000L);
        }
        return null;
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    protected final zzdc zza(Context context, boolean z) {
        try {
            return zzdb.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zza((Exception) e, true, false);
            return null;
        }
    }

    public static zzdn zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static zzdn zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzdn.class) {
                if (zzb == null) {
                    zzb = new zzdn(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    public final Long zzc() {
        zzda zzdaVar = new zzda();
        zza(new zzeq(this, zzdaVar));
        return zzdaVar.zzb(PayloadController.PAYLOAD_REQUEUE_PERIOD_MS);
    }

    public final Object zza(int i) {
        zzda zzdaVar = new zzda();
        zza(new zzep(this, zzdaVar, i));
        return zzda.zza(zzdaVar.zza(15000L), Object.class);
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        zzda zzdaVar = new zzda();
        zza(new zzen(this, zzdaVar));
        return zzdaVar.zzc(PayloadController.PAYLOAD_REQUEUE_PERIOD_MS);
    }

    public final String zzf() {
        zzda zzdaVar = new zzda();
        zza(new zzeg(this, zzdaVar));
        return zzdaVar.zzc(50L);
    }

    public final String zzg() {
        zzda zzdaVar = new zzda();
        zza(new zzeh(this, zzdaVar));
        return zzdaVar.zzc(500L);
    }

    public final String zzh() {
        zzda zzdaVar = new zzda();
        zza(new zzei(this, zzdaVar));
        return zzdaVar.zzc(500L);
    }

    public final String zzi() {
        zzda zzdaVar = new zzda();
        zza(new zzed(this, zzdaVar));
        return zzdaVar.zzc(500L);
    }

    public final List<Bundle> zza(String str, String str2) {
        zzda zzdaVar = new zzda();
        zza(new zzdu(this, str, str2, zzdaVar));
        List<Bundle> list = (List) zzda.zza(zzdaVar.zza(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzda zzdaVar = new zzda();
        zza(new zzek(this, str, str2, z, zzdaVar));
        Bundle bundleZza = zzdaVar.zza(5000L);
        if (bundleZza == null || bundleZza.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleZza.size());
        for (String str3 : bundleZza.keySet()) {
            Object obj = bundleZza.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    private zzdn(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzcr.zza().zza(new zzdz(this), 1);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        if (zzb(context) && !zzk()) {
            this.zzi = null;
            this.zzh = true;
            LogInstrumentation.m2734w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    LogInstrumentation.m2734w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                LogInstrumentation.m2732v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        } else {
            this.zzi = str2;
        }
        zza(new zzdq(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            LogInstrumentation.m2734w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (z) {
            LogInstrumentation.m2735w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        LogInstrumentation.m2735w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    public final void zzb(String str) {
        zza(new zzeb(this, str));
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(new zzdr(this, str, str2, bundle));
    }

    public final void zzc(String str) {
        zza(new zzee(this, str));
    }

    public final void zza(String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza(new zzev(this, l, str, str2, bundle, z, z2));
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza(new zzej(this, false, 5, str, obj, null, null));
    }

    public final void zza(com.google.android.gms.measurement.internal.zziu zziuVar) {
        Preconditions.checkNotNull(zziuVar);
        synchronized (this.zzf) {
            for (int i = 0; i < this.zzf.size(); i++) {
                if (zziuVar.equals(this.zzf.get(i).first)) {
                    LogInstrumentation.m2734w(this.zzc, "OnEventListener already registered.");
                    return;
                }
            }
            zzd zzdVar = new zzd(zziuVar);
            this.zzf.add(new Pair<>(zziuVar, zzdVar));
            if (this.zzj != null) {
                try {
                    this.zzj.registerOnMeasurementEventListener(zzdVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    LogInstrumentation.m2734w(this.zzc, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza(new zzet(this, zzdVar));
        }
    }

    public final void zzj() {
        zza(new zzea(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        this.zzd.execute(zzbVar);
    }

    public final void zza(Bundle bundle) {
        zza(new zzds(this, bundle));
    }

    public final void zzb(Bundle bundle) {
        zza(new zzdy(this, bundle));
    }

    public final void zzc(Bundle bundle) {
        zza(new zzdx(this, bundle));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza(new zzdw(this, activity, str, str2));
    }

    public final void zza(boolean z) {
        zza(new zzes(this, z));
    }

    public final void zzd(Bundle bundle) {
        zza(new zzer(this, bundle));
    }

    public final void zza(com.google.android.gms.measurement.internal.zziv zzivVar) {
        zza zzaVar = new zza(zzivVar);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzaVar);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                LogInstrumentation.m2734w(this.zzc, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zza(new zzem(this, zzaVar));
    }

    public final void zza(Boolean bool) {
        zza(new zzdv(this, bool));
    }

    public final void zza(long j) {
        zza(new zzec(this, j));
    }

    public final void zza(Intent intent) {
        zza(new zzeu(this, intent));
    }

    public final void zzd(String str) {
        zza(new zzdt(this, str));
    }

    public final void zzb(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(new zzdp(this, str, str2, obj, z));
    }

    public final void zzb(com.google.android.gms.measurement.internal.zziu zziuVar) {
        Pair<com.google.android.gms.measurement.internal.zziu, zzd> pair;
        Preconditions.checkNotNull(zziuVar);
        synchronized (this.zzf) {
            int i = 0;
            while (true) {
                if (i >= this.zzf.size()) {
                    pair = null;
                    break;
                } else {
                    if (zziuVar.equals(this.zzf.get(i).first)) {
                        pair = this.zzf.get(i);
                        break;
                    }
                    i++;
                }
            }
            if (pair == null) {
                LogInstrumentation.m2734w(this.zzc, "OnEventListener had not been registered.");
                return;
            }
            this.zzf.remove(pair);
            zzd zzdVar = (zzd) pair.second;
            if (this.zzj != null) {
                try {
                    this.zzj.unregisterOnMeasurementEventListener(zzdVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    LogInstrumentation.m2734w(this.zzc, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza(new zzew(this, zzdVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    private final boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean zzb(Context context) {
        return new com.google.android.gms.measurement.internal.zzhd(context, com.google.android.gms.measurement.internal.zzhd.zza(context)).zza("google_app_id") != null;
    }
}
