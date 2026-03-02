package com.google.mlkit.common.model;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class RemoteModelManager {
    private final Map<Class<? extends RemoteModel>, Provider<? extends RemoteModelManagerInterface<? extends RemoteModel>>> zza = new HashMap();

    /* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
    public static class RemoteModelManagerRegistration {
        private final Class<? extends RemoteModel> zza;
        private final Provider<? extends RemoteModelManagerInterface<? extends RemoteModel>> zzb;

        /* JADX WARN: Multi-variable type inference failed */
        public <RemoteT extends RemoteModel> RemoteModelManagerRegistration(Class<RemoteT> cls, Provider<? extends RemoteModelManagerInterface<RemoteT>> provider) {
            this.zza = cls;
            this.zzb = provider;
        }

        final Class<? extends RemoteModel> zza() {
            return this.zza;
        }

        final Provider<? extends RemoteModelManagerInterface<? extends RemoteModel>> zzb() {
            return this.zzb;
        }
    }

    public RemoteModelManager(Set<RemoteModelManagerRegistration> set) {
        for (RemoteModelManagerRegistration remoteModelManagerRegistration : set) {
            this.zza.put(remoteModelManagerRegistration.zza(), remoteModelManagerRegistration.zzb());
        }
    }

    public static synchronized RemoteModelManager getInstance() {
        return (RemoteModelManager) MlKitContext.getInstance().get(RemoteModelManager.class);
    }

    private final RemoteModelManagerInterface<RemoteModel> zza(Class<? extends RemoteModel> cls) {
        return (RemoteModelManagerInterface) ((Provider) Preconditions.checkNotNull(this.zza.get(cls))).get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Task<Void> deleteDownloadedModel(RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        return zza(remoteModel.getClass()).deleteDownloadedModel(remoteModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Task<Void> download(RemoteModel remoteModel, DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions cannot be null");
        if (this.zza.containsKey(remoteModel.getClass())) {
            return zza(remoteModel.getClass()).download(remoteModel, downloadConditions);
        }
        String simpleName = remoteModel.getClass().getSimpleName();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 70);
        sb.append("Feature model '");
        sb.append(simpleName);
        sb.append("' doesn't have a corresponding modelmanager registered.");
        return Tasks.forException(new MlKitException(sb.toString(), 13));
    }

    public <T extends RemoteModel> Task<Set<T>> getDownloadedModels(Class<T> cls) {
        return ((RemoteModelManagerInterface) ((Provider) Preconditions.checkNotNull(this.zza.get(cls))).get()).getDownloadedModels();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Task<Boolean> isModelDownloaded(RemoteModel remoteModel) {
        Preconditions.checkNotNull(remoteModel, "RemoteModel cannot be null");
        return zza(remoteModel.getClass()).isModelDownloaded(remoteModel);
    }
}
