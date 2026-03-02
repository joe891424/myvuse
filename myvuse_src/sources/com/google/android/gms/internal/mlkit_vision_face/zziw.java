package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zziw {
    private static zzax<String> zza;
    private final String zzb;
    private final String zzc;
    private final SharedPrefManager zzd;
    private final Task<String> zze;
    private final Task<String> zzf;
    private final String zzg;
    private final Map<zzhc, Long> zzh = new HashMap();
    private final Map<zzhc, zzaz<Object, Long>> zzi = new HashMap();
    private final zzjb zzj;

    public zziw(Context context, SharedPrefManager sharedPrefManager, zzjb zzjbVar, final String str, byte[] bArr) {
        this.zzb = context.getPackageName();
        this.zzc = CommonUtils.getAppVersion(context);
        this.zzd = sharedPrefManager;
        this.zzj = zzjbVar;
        this.zzg = str;
        this.zze = MLTaskExecutor.getInstance().scheduleCallable(new Callable(str) { // from class: com.google.android.gms.internal.mlkit_vision_face.zzir
            private final String zza;

            {
                this.zza = str;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LibraryVersion.getInstance().getVersion(this.zza);
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzf = mLTaskExecutor.scheduleCallable(zzis.zza(sharedPrefManager));
    }

    static long zzc(List<Long> list, double d) {
        return list.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) list.size()))) - 1, 0)).longValue();
    }

    private final boolean zzf(zzhc zzhcVar, long j, long j2) {
        return this.zzh.get(zzhcVar) == null || j - this.zzh.get(zzhcVar).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    private static synchronized zzax<String> zzg() {
        zzax<String> zzaxVar = zza;
        if (zzaxVar != null) {
            return zzaxVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzau zzauVar = new zzau();
        for (int i = 0; i < locales.size(); i++) {
            zzauVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzax<String> zzaxVarZzc = zzauVar.zzc();
        zza = zzaxVarZzc;
        return zzaxVarZzc;
    }

    public final void zza(zziv zzivVar, zzhc zzhcVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zzf(zzhcVar, jElapsedRealtime, 30L)) {
            this.zzh.put(zzhcVar, Long.valueOf(jElapsedRealtime));
            zzd(zzivVar.zza(), zzhcVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K> void zzb(K k, long j, zzhc zzhcVar, zziu<K> zziuVar) {
        if (!this.zzi.containsKey(zzhcVar)) {
            this.zzi.put(zzhcVar, zzad.zzr());
        }
        zzaz<Object, Long> zzazVar = this.zzi.get(zzhcVar);
        zzazVar.zzd(k, Long.valueOf(j));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zzf(zzhcVar, jElapsedRealtime, 30L)) {
            this.zzh.put(zzhcVar, Long.valueOf(jElapsedRealtime));
            for (Object obj : zzazVar.zzp()) {
                List<Long> listZzb = zzazVar.zzb(obj);
                Collections.sort(listZzb);
                zzgh zzghVar = new zzgh();
                Iterator<Long> it2 = listZzb.iterator();
                long jLongValue = 0;
                while (it2.hasNext()) {
                    jLongValue += it2.next().longValue();
                }
                zzghVar.zzc(Long.valueOf(jLongValue / ((long) listZzb.size())));
                zzghVar.zza(Long.valueOf(zzc(listZzb, 100.0d)));
                zzghVar.zzf(Long.valueOf(zzc(listZzb, 75.0d)));
                zzghVar.zze(Long.valueOf(zzc(listZzb, 50.0d)));
                zzghVar.zzd(Long.valueOf(zzc(listZzb, 25.0d)));
                zzghVar.zzb(Long.valueOf(zzc(listZzb, 0.0d)));
                zzd(zziuVar.zza(obj, zzazVar.zzb(obj).size(), zzghVar.zzg()), zzhcVar);
            }
            this.zzi.remove(zzhcVar);
        }
    }

    public final void zzd(final zziq zziqVar, final zzhc zzhcVar) {
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zziqVar, zzhcVar, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_face.zzit
            private final zziw zza;
            private final zzhc zzb;
            private final zziq zzc;

            {
                this.zza = this;
                this.zzc = zziqVar;
                this.zzb = zzhcVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze(this.zzc, this.zzb);
            }
        });
    }

    final /* synthetic */ void zze(zziq zziqVar, zzhc zzhcVar) {
        zziqVar.zze(zzhcVar);
        String strZzb = zziqVar.zzb();
        zzil zzilVar = new zzil();
        zzilVar.zza(this.zzb);
        zzilVar.zzb(this.zzc);
        zzilVar.zze(zzg());
        zzilVar.zzg(true);
        zzilVar.zzd(strZzb);
        zzilVar.zzc(this.zze.isSuccessful() ? this.zze.getResult() : LibraryVersion.getInstance().getVersion(this.zzg));
        zzilVar.zzf(this.zzf.isSuccessful() ? this.zzf.getResult() : this.zzd.getMlSdkInstanceId());
        zzilVar.zzh(true);
        zzilVar.zzi(10);
        zziqVar.zzd(zzilVar.zzj());
        this.zzj.zza(zziqVar);
    }
}
