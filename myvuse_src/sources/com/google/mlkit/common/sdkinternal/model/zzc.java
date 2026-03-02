package com.google.mlkit.common.sdkinternal.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzgf;
import com.google.android.gms.internal.mlkit_common.zzhx;
import com.google.android.gms.internal.mlkit_common.zzic;
import com.google.android.gms.internal.mlkit_common.zzid;
import com.google.android.gms.internal.mlkit_common.zzie;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzc extends BroadcastReceiver {
    final /* synthetic */ RemoteModelDownloadManager zza;
    private final long zzb;
    private final TaskCompletionSource<Void> zzc;

    /* synthetic */ zzc(RemoteModelDownloadManager remoteModelDownloadManager, long j, TaskCompletionSource taskCompletionSource, zzb zzbVar) {
        this.zza = remoteModelDownloadManager;
        this.zzb = j;
        this.zzc = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        if (longExtra != this.zzb) {
            return;
        }
        Integer downloadingModelStatusCode = this.zza.getDownloadingModelStatusCode();
        synchronized (this.zza) {
            try {
                this.zza.zze.getApplicationContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                RemoteModelDownloadManager.zza.m2366w("ModelDownloadManager", "Exception thrown while trying to unregister the broadcast receiver for the download", e);
            }
            this.zza.zzc.remove(this.zzb);
            this.zza.zzd.remove(this.zzb);
        }
        if (downloadingModelStatusCode != null) {
            if (downloadingModelStatusCode.intValue() == 16) {
                zzic zzicVar = this.zza.zzi;
                zzhx zzhxVarZzd = zzhx.zzd();
                RemoteModel remoteModel = this.zza.zzg;
                RemoteModelDownloadManager remoteModelDownloadManager = this.zza;
                Long lValueOf = Long.valueOf(longExtra);
                zzicVar.zzc(zzhxVarZzd, remoteModel, false, remoteModelDownloadManager.getFailureReason(lValueOf));
                this.zzc.setException(this.zza.zzn(lValueOf));
                return;
            }
            if (downloadingModelStatusCode.intValue() == 8) {
                zzic zzicVar2 = this.zza.zzi;
                zzhx zzhxVarZzd2 = zzhx.zzd();
                RemoteModel remoteModel2 = this.zza.zzg;
                zzid zzidVarZzh = zzie.zzh();
                zzidVarZzh.zza(zzfy.NO_ERROR);
                zzidVarZzh.zzd(true);
                zzidVarZzh.zze(this.zza.zzg.getModelType());
                zzidVarZzh.zzf(zzgf.SUCCEEDED);
                zzicVar2.zzb(zzhxVarZzd2, remoteModel2, zzidVarZzh.zzh());
                this.zzc.setResult(null);
                return;
            }
        }
        this.zza.zzi.zzc(zzhx.zzd(), this.zza.zzg, false, 0);
        this.zzc.setException(new MlKitException("Model downloading failed", 13));
    }
}
