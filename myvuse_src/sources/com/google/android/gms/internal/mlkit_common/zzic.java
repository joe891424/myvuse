package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzic {
    private static zzaj<String> zza;
    private final String zzb;
    private final String zzc;
    private final SharedPrefManager zzd;
    private final Task<String> zze;
    private final Task<String> zzf;
    private final String zzg;
    private final Map<zzfz, Long> zzh = new HashMap();
    private final Map<zzfz, Object> zzi = new HashMap();
    private final zzij zzj;

    public zzic(Context context, SharedPrefManager sharedPrefManager, zzij zzijVar, final String str, byte[] bArr) {
        this.zzb = context.getPackageName();
        this.zzc = CommonUtils.getAppVersion(context);
        this.zzd = sharedPrefManager;
        this.zzj = zzijVar;
        this.zzg = str;
        this.zze = MLTaskExecutor.getInstance().scheduleCallable(new Callable(str) { // from class: com.google.android.gms.internal.mlkit_common.zzhy
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
        this.zzf = mLTaskExecutor.scheduleCallable(zzhz.zza(sharedPrefManager));
    }

    private final zzhq zzg(String str, int i) {
        zzhp zzhpVar = new zzhp();
        zzhpVar.zza(this.zzb);
        zzhpVar.zzb(this.zzc);
        zzhpVar.zze(zzh());
        zzhpVar.zzg(true);
        zzhpVar.zzd(str);
        zzhpVar.zzc(this.zze.isSuccessful() ? this.zze.getResult() : LibraryVersion.getInstance().getVersion(this.zzg));
        zzhpVar.zzf(this.zzf.isSuccessful() ? this.zzf.getResult() : this.zzd.getMlSdkInstanceId());
        zzhpVar.zzh(true);
        zzhpVar.zzi(10);
        return zzhpVar.zzj();
    }

    private static synchronized zzaj<String> zzh() {
        zzaj<String> zzajVar = zza;
        if (zzajVar != null) {
            return zzajVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzag zzagVar = new zzag();
        for (int i = 0; i < locales.size(); i++) {
            zzagVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzaj<String> zzajVarZzc = zzagVar.zzc();
        zza = zzajVarZzc;
        return zzajVarZzc;
    }

    public final void zza(final zzhx zzhxVar, final zzfz zzfzVar) {
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zzhxVar, zzfzVar, bArr) { // from class: com.google.android.gms.internal.mlkit_common.zzia
            private final zzic zza;
            private final zzfz zzb;
            private final zzhx zzc;

            {
                this.zza = this;
                this.zzc = zzhxVar;
                this.zzb = zzfzVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf(this.zzc, this.zzb);
            }
        });
    }

    public final void zzb(final zzhx zzhxVar, final RemoteModel remoteModel, final zzie zzieVar) {
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zzhxVar, zzieVar, remoteModel, bArr) { // from class: com.google.android.gms.internal.mlkit_common.zzib
            private final zzic zza;
            private final zzie zzb;
            private final RemoteModel zzc;
            private final zzhx zzd;

            {
                this.zza = this;
                this.zzd = zzhxVar;
                this.zzb = zzieVar;
                this.zzc = remoteModel;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze(this.zzd, this.zzb, this.zzc);
            }
        });
    }

    public final void zzc(zzhx zzhxVar, RemoteModel remoteModel, boolean z, int i) {
        zzid zzidVarZzh = zzie.zzh();
        zzidVarZzh.zzc(false);
        zzidVarZzh.zze(remoteModel.getModelType());
        zzidVarZzh.zzf(zzgf.FAILED);
        zzidVarZzh.zza(zzfy.DOWNLOAD_FAILED);
        zzidVarZzh.zzg(i);
        zzb(zzhxVar, remoteModel, zzidVarZzh.zzh());
    }

    public final void zzd(zzhx zzhxVar, RemoteModel remoteModel, zzfy zzfyVar, boolean z, ModelType modelType, zzgf zzgfVar) {
        zzid zzidVarZzh = zzie.zzh();
        zzidVarZzh.zzc(z);
        zzidVarZzh.zze(modelType);
        zzidVarZzh.zza(zzfyVar);
        zzidVarZzh.zzf(zzgfVar);
        zzb(zzhxVar, remoteModel, zzidVarZzh.zzh());
    }

    final /* synthetic */ void zze(zzhx zzhxVar, zzie zzieVar, RemoteModel remoteModel) {
        zzhxVar.zzf(zzfz.MODEL_DOWNLOAD);
        zzhxVar.zze(zzg(zzieVar.zzb(), 0));
        zzhxVar.zzg(zzin.zza(remoteModel, this.zzd, zzieVar));
        this.zzj.zza(zzhxVar);
    }

    final /* synthetic */ void zzf(zzhx zzhxVar, zzfz zzfzVar) {
        zzhxVar.zzf(zzfzVar);
        zzhxVar.zze(zzg(zzhxVar.zzb(), 0));
        this.zzj.zza(zzhxVar);
    }
}
