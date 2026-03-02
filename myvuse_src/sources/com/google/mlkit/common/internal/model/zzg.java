package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzfj;
import com.google.android.gms.internal.mlkit_common.zzfr;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzgb;
import com.google.android.gms.internal.mlkit_common.zzgj;
import com.google.android.gms.internal.mlkit_common.zzhx;
import com.google.android.gms.internal.mlkit_common.zzic;
import com.google.android.gms.internal.mlkit_common.zzim;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.CustomRemoteModel;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.ModelInfoRetrieverInterop;
import com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzg implements RemoteModelManagerInterface<CustomRemoteModel> {
    private final MlKitContext zza;
    private final zzic zzb;

    public zzg(MlKitContext mlKitContext) {
        zzic zzicVarZza = zzim.zza("common");
        this.zza = mlKitContext;
        this.zzb = zzicVarZza;
    }

    private final RemoteModelDownloadManager zze(CustomRemoteModel customRemoteModel) {
        MlKitContext mlKitContext = this.zza;
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, customRemoteModel, null, new ModelFileHelper(mlKitContext), new zza(this.zza, customRemoteModel.getUniqueModelNameForPersist()));
        MlKitContext mlKitContext2 = this.zza;
        return RemoteModelDownloadManager.getInstance(mlKitContext2, customRemoteModel, new ModelFileHelper(mlKitContext2), remoteModelFileManager, (ModelInfoRetrieverInterop) this.zza.get(ModelInfoRetrieverInterop.class));
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task deleteDownloadedModel(RemoteModel remoteModel) {
        final CustomRemoteModel customRemoteModel = (CustomRemoteModel) remoteModel;
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, customRemoteModel, taskCompletionSource) { // from class: com.google.mlkit.common.internal.model.zzb
            private final zzg zza;
            private final CustomRemoteModel zzb;
            private final TaskCompletionSource zzc;

            {
                this.zza = this;
                this.zzb = customRemoteModel;
                this.zzc = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(this.zzb, this.zzc);
            }
        });
        return taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener(this) { // from class: com.google.mlkit.common.internal.model.zzc
            private final zzg zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzc(task);
            }
        });
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task download(RemoteModel remoteModel, DownloadConditions downloadConditions) {
        final RemoteModelDownloadManager remoteModelDownloadManagerZze = zze((CustomRemoteModel) remoteModel);
        remoteModelDownloadManagerZze.setDownloadConditions(downloadConditions);
        return Tasks.forResult(null).onSuccessTask(MLTaskExecutor.workerThreadExecutor(), new SuccessContinuation(remoteModelDownloadManagerZze) { // from class: com.google.mlkit.common.internal.model.zzf
            private final RemoteModelDownloadManager zza;

            {
                this.zza = remoteModelDownloadManagerZze;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.zza.ensureModelDownloaded();
            }
        });
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final Task<Set<CustomRemoteModel>> getDownloadedModels() {
        return Tasks.forException(new MlKitException("Custom Remote model does not support listing downloaded models", 12));
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task isModelDownloaded(RemoteModel remoteModel) {
        final CustomRemoteModel customRemoteModel = (CustomRemoteModel) remoteModel;
        return MLTaskExecutor.getInstance().scheduleCallable(new Callable(this, customRemoteModel) { // from class: com.google.mlkit.common.internal.model.zzd
            private final zzg zza;
            private final CustomRemoteModel zzb;

            {
                this.zza = this;
                this.zzb = customRemoteModel;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzb(this.zzb);
            }
        }).addOnCompleteListener(new OnCompleteListener(this) { // from class: com.google.mlkit.common.internal.model.zze
            private final zzg zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zza(task);
            }
        });
    }

    final /* synthetic */ void zza(Task task) {
        boolean zBooleanValue = ((Boolean) task.getResult()).booleanValue();
        zzic zzicVar = this.zzb;
        zzgb zzgbVar = new zzgb();
        zzfr zzfrVar = new zzfr();
        zzfrVar.zza(zzgj.CUSTOM);
        zzfrVar.zzb(Boolean.valueOf(zBooleanValue));
        zzgbVar.zzd(zzfrVar.zzc());
        zzicVar.zza(zzhx.zzc(zzgbVar), zzfz.REMOTE_MODEL_IS_DOWNLOADED);
    }

    final /* synthetic */ Boolean zzb(CustomRemoteModel customRemoteModel) throws Exception {
        return Boolean.valueOf(zze(customRemoteModel).isModelDownloadedAndValid());
    }

    final /* synthetic */ void zzc(Task task) {
        boolean zIsSuccessful = task.isSuccessful();
        zzic zzicVar = this.zzb;
        zzgb zzgbVar = new zzgb();
        zzfj zzfjVar = new zzfj();
        zzfjVar.zza(zzgj.CUSTOM);
        zzfjVar.zzb(Boolean.valueOf(zIsSuccessful));
        zzgbVar.zze(zzfjVar.zzc());
        zzicVar.zza(zzhx.zzc(zzgbVar), zzfz.REMOTE_MODEL_DELETE_ON_DEVICE);
    }

    final /* synthetic */ void zzd(CustomRemoteModel customRemoteModel, TaskCompletionSource taskCompletionSource) {
        try {
            new ModelFileHelper(this.zza).deleteAllModels(ModelType.CUSTOM, (String) Preconditions.checkNotNull(customRemoteModel.getModelName()));
            taskCompletionSource.setResult(null);
        } catch (RuntimeException e) {
            taskCompletionSource.setException(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e));
        }
    }
}
