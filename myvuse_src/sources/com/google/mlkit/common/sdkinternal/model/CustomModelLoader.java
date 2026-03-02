package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzic;
import com.google.android.gms.internal.mlkit_common.zzim;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.CustomRemoteModel;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class CustomModelLoader {
    private static final GmsLogger zza = new GmsLogger("CustomModelLoader", "");
    private static final Map<String, CustomModelLoader> zzb = new HashMap();
    private final MlKitContext zzc;
    private final LocalModel zzd;
    private final CustomRemoteModel zze;
    private final RemoteModelDownloadManager zzf;
    private final RemoteModelFileManager zzg;
    private final zzic zzh;
    private boolean zzi;

    /* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
    public interface CustomModelLoaderHelper {
        void logLoad() throws MlKitException;

        boolean tryLoad(LocalModel localModel) throws MlKitException;
    }

    private CustomModelLoader(MlKitContext mlKitContext, LocalModel localModel, CustomRemoteModel customRemoteModel) {
        if (customRemoteModel != null) {
            RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, customRemoteModel, null, new ModelFileHelper(mlKitContext), new com.google.mlkit.common.internal.model.zza(mlKitContext, customRemoteModel.getUniqueModelNameForPersist()));
            this.zzg = remoteModelFileManager;
            this.zzf = RemoteModelDownloadManager.getInstance(mlKitContext, customRemoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
            this.zzi = true;
        } else {
            this.zzg = null;
            this.zzf = null;
        }
        this.zzc = mlKitContext;
        this.zzd = localModel;
        this.zze = customRemoteModel;
        this.zzh = zzim.zza("common");
    }

    public static synchronized CustomModelLoader getInstance(MlKitContext mlKitContext, LocalModel localModel, CustomRemoteModel customRemoteModel) {
        String string;
        Map<String, CustomModelLoader> map;
        string = customRemoteModel == null ? ((LocalModel) Preconditions.checkNotNull(localModel)).toString() : customRemoteModel.getUniqueModelNameForPersist();
        map = zzb;
        if (!map.containsKey(string)) {
            map.put(string, new CustomModelLoader(mlKitContext, localModel, customRemoteModel));
        }
        return map.get(string);
    }

    private final void zza() throws MlKitException {
        ((RemoteModelDownloadManager) Preconditions.checkNotNull(this.zzf)).removeOrCancelDownload();
    }

    private final File zzb() throws MlKitException {
        String strZzd = ((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzd();
        if (strZzd == null) {
            zza.m2357d("CustomModelLoader", "No existing model file");
            return null;
        }
        File file = new File(strZzd);
        File[] fileArrListFiles = file.listFiles();
        return ((File[]) Preconditions.checkNotNull(fileArrListFiles)).length == 1 ? fileArrListFiles[0] : file;
    }

    private static final LocalModel zzc(File file) {
        if (file.isDirectory()) {
            LocalModel.Builder builder = new LocalModel.Builder();
            builder.setAbsoluteManifestFilePath(new File(file.getAbsolutePath(), Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME).toString());
            return builder.build();
        }
        LocalModel.Builder builder2 = new LocalModel.Builder();
        builder2.setAbsoluteFilePath(file.getAbsolutePath());
        return builder2.build();
    }

    public synchronized LocalModel createLocalModelByLatestExistingModel() throws MlKitException {
        zza.m2357d("CustomModelLoader", "Try to get the latest existing model file.");
        File fileZzb = zzb();
        if (fileZzb == null) {
            return null;
        }
        return zzc(fileZzb);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bd A[Catch: all -> 0x00c3, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0023, B:9:0x002b, B:28:0x00bd, B:10:0x0030, B:12:0x005c, B:15:0x0065, B:17:0x0075, B:19:0x007f, B:18:0x007a, B:20:0x008a, B:22:0x0092, B:23:0x00ae), top: B:34:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.google.mlkit.common.model.LocalModel createLocalModelByNewlyDownloadedModel() throws com.google.mlkit.common.MlKitException {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.mlkit.common.sdkinternal.model.CustomModelLoader.zza     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = "CustomModelLoader"
            java.lang.String r2 = "Try to get newly downloaded model file."
            r0.m2357d(r1, r2)     // Catch: java.lang.Throwable -> Lc3
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r8.zzf     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)     // Catch: java.lang.Throwable -> Lc3
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = (com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager) r1     // Catch: java.lang.Throwable -> Lc3
            java.lang.Long r1 = r1.getDownloadingId()     // Catch: java.lang.Throwable -> Lc3
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r2 = r8.zzf     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = r2.getDownloadingModelHash()     // Catch: java.lang.Throwable -> Lc3
            r3 = 0
            if (r1 == 0) goto Lae
            if (r2 != 0) goto L23
            goto Lae
        L23:
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r4 = r8.zzf     // Catch: java.lang.Throwable -> Lc3
            java.lang.Integer r4 = r4.getDownloadingModelStatusCode()     // Catch: java.lang.Throwable -> Lc3
            if (r4 != 0) goto L30
            r8.zza()     // Catch: java.lang.Throwable -> Lc3
            goto Lb8
        L30:
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> Lc3
            int r6 = r6.length()     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            int r6 = r6 + 22
            r7.<init>(r6)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = "Download Status code: "
            r7.append(r6)     // Catch: java.lang.Throwable -> Lc3
            r7.append(r5)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = "CustomModelLoader"
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Throwable -> Lc3
            r0.m2357d(r5, r6)     // Catch: java.lang.Throwable -> Lc3
            int r5 = r4.intValue()     // Catch: java.lang.Throwable -> Lc3
            r6 = 8
            if (r5 != r6) goto L8a
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r8.zzf     // Catch: java.lang.Throwable -> Lc3
            java.io.File r1 = r1.zzb(r2)     // Catch: java.lang.Throwable -> Lc3
            if (r1 != 0) goto L65
            goto Lb8
        L65:
            java.lang.String r4 = r1.getParent()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = "Moved the downloaded model to private folder successfully: "
            int r6 = r4.length()     // Catch: java.lang.Throwable -> Lc3
            if (r6 == 0) goto L7a
            java.lang.String r4 = r5.concat(r4)     // Catch: java.lang.Throwable -> Lc3
            goto L7f
        L7a:
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> Lc3
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lc3
        L7f:
            java.lang.String r5 = "CustomModelLoader"
            r0.m2357d(r5, r4)     // Catch: java.lang.Throwable -> Lc3
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r0 = r8.zzf     // Catch: java.lang.Throwable -> Lc3
            r0.updateLatestModelHashAndType(r2)     // Catch: java.lang.Throwable -> Lc3
            goto Lb9
        L8a:
            int r0 = r4.intValue()     // Catch: java.lang.Throwable -> Lc3
            r2 = 16
            if (r0 != r2) goto Lb8
            com.google.android.gms.internal.mlkit_common.zzic r0 = r8.zzh     // Catch: java.lang.Throwable -> Lc3
            com.google.android.gms.internal.mlkit_common.zzhx r2 = com.google.android.gms.internal.mlkit_common.zzhx.zzd()     // Catch: java.lang.Throwable -> Lc3
            com.google.mlkit.common.model.CustomRemoteModel r4 = r8.zze     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch: java.lang.Throwable -> Lc3
            com.google.mlkit.common.model.RemoteModel r4 = (com.google.mlkit.common.model.RemoteModel) r4     // Catch: java.lang.Throwable -> Lc3
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r5 = r8.zzf     // Catch: java.lang.Throwable -> Lc3
            int r1 = r5.getFailureReason(r1)     // Catch: java.lang.Throwable -> Lc3
            r5 = 0
            r0.zzc(r2, r4, r5, r1)     // Catch: java.lang.Throwable -> Lc3
            r8.zza()     // Catch: java.lang.Throwable -> Lc3
            goto Lb8
        Lae:
            java.lang.String r1 = "CustomModelLoader"
            java.lang.String r2 = "No new model is downloading."
            r0.m2357d(r1, r2)     // Catch: java.lang.Throwable -> Lc3
            r8.zza()     // Catch: java.lang.Throwable -> Lc3
        Lb8:
            r1 = r3
        Lb9:
            if (r1 != 0) goto Lbd
            monitor-exit(r8)
            return r3
        Lbd:
            com.google.mlkit.common.model.LocalModel r0 = zzc(r1)     // Catch: java.lang.Throwable -> Lc3
            monitor-exit(r8)
            return r0
        Lc3:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lc3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.CustomModelLoader.createLocalModelByNewlyDownloadedModel():com.google.mlkit.common.model.LocalModel");
    }

    public void deleteLatestExistingModel() throws MlKitException {
        File fileZzb = zzb();
        if (fileZzb != null) {
            ((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzb(fileZzb);
            SharedPrefManager.getInstance(this.zzc).clearLatestModelHash((RemoteModel) Preconditions.checkNotNull(this.zze));
        }
    }

    public void deleteOldModels(LocalModel localModel) throws MlKitException {
        File parentFile = new File((String) Preconditions.checkNotNull(localModel.getAbsoluteFilePath())).getParentFile();
        if (!((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zza((File) Preconditions.checkNotNull(parentFile))) {
            zza.m2359e("CustomModelLoader", "Failed to delete old models");
        } else {
            zza.m2357d("CustomModelLoader", "All old models are deleted.");
            this.zzg.zzc(parentFile);
        }
    }

    public synchronized void load(CustomModelLoaderHelper customModelLoaderHelper) throws MlKitException {
        LocalModel localModelCreateLocalModelByLatestExistingModel = this.zzd;
        if (localModelCreateLocalModelByLatestExistingModel == null) {
            localModelCreateLocalModelByLatestExistingModel = createLocalModelByNewlyDownloadedModel();
        }
        if (localModelCreateLocalModelByLatestExistingModel == null) {
            localModelCreateLocalModelByLatestExistingModel = createLocalModelByLatestExistingModel();
        }
        if (localModelCreateLocalModelByLatestExistingModel == null) {
            throw new MlKitException("Model is not available.", 14);
        }
        while (!customModelLoaderHelper.tryLoad(localModelCreateLocalModelByLatestExistingModel)) {
            if (this.zze != null) {
                deleteLatestExistingModel();
                localModelCreateLocalModelByLatestExistingModel = createLocalModelByLatestExistingModel();
            } else {
                localModelCreateLocalModelByLatestExistingModel = null;
            }
            if (localModelCreateLocalModelByLatestExistingModel == null) {
                customModelLoaderHelper.logLoad();
                return;
            }
        }
        if (this.zze != null && this.zzi) {
            deleteOldModels((LocalModel) Preconditions.checkNotNull(localModelCreateLocalModelByLatestExistingModel));
            this.zzi = false;
        }
        customModelLoaderHelper.logLoad();
    }
}
