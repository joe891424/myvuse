package com.google.android.gms.internal.mlkit_vision_common;

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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgo {
    private static zzo<String> zza;
    private final String zzb;
    private final String zzc;
    private final SharedPrefManager zzd;
    private final Task<String> zze;
    private final Task<String> zzf;
    private final String zzg;
    private final Map<zzex, Long> zzh = new HashMap();
    private final Map<zzex, Object> zzi = new HashMap();
    private final zzgt zzj;

    public zzgo(Context context, SharedPrefManager sharedPrefManager, zzgt zzgtVar, final String str, byte[] bArr) {
        this.zzb = context.getPackageName();
        this.zzc = CommonUtils.getAppVersion(context);
        this.zzd = sharedPrefManager;
        this.zzj = zzgtVar;
        this.zzg = str;
        this.zze = MLTaskExecutor.getInstance().scheduleCallable(new Callable(str) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzgk
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
        this.zzf = mLTaskExecutor.scheduleCallable(zzgl.zza(sharedPrefManager));
    }

    private static synchronized zzo<String> zzc() {
        zzo<String> zzoVar = zza;
        if (zzoVar != null) {
            return zzoVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzl zzlVar = new zzl();
        for (int i = 0; i < locales.size(); i++) {
            zzlVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzo<String> zzoVarZzc = zzlVar.zzc();
        zza = zzoVarZzc;
        return zzoVarZzc;
    }

    public final void zza(zzgn zzgnVar, final zzex zzexVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzh.get(zzexVar) != null && jElapsedRealtime - this.zzh.get(zzexVar).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.zzh.put(zzexVar, Long.valueOf(jElapsedRealtime));
        final zzgj zzgjVarZza = zzgnVar.zza();
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zzgjVarZza, zzexVar, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzgm
            private final zzgo zza;
            private final zzex zzb;
            private final zzgj zzc;

            {
                this.zza = this;
                this.zzc = zzgjVarZza;
                this.zzb = zzexVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(this.zzc, this.zzb);
            }
        });
    }

    final /* synthetic */ void zzb(zzgj zzgjVar, zzex zzexVar) {
        zzgjVar.zze(zzexVar);
        String strZzb = zzgjVar.zzb();
        zzge zzgeVar = new zzge();
        zzgeVar.zza(this.zzb);
        zzgeVar.zzb(this.zzc);
        zzgeVar.zze(zzc());
        zzgeVar.zzg(true);
        zzgeVar.zzd(strZzb);
        zzgeVar.zzc(this.zze.isSuccessful() ? this.zze.getResult() : LibraryVersion.getInstance().getVersion(this.zzg));
        zzgeVar.zzf(this.zzf.isSuccessful() ? this.zzf.getResult() : this.zzd.getMlSdkInstanceId());
        zzgeVar.zzh(true);
        zzgeVar.zzi(10);
        zzgjVar.zzd(zzgeVar.zzj());
        this.zzj.zza(zzgjVar);
    }
}
