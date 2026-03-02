package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzgf;
import com.google.android.gms.internal.mlkit_common.zzhx;
import com.google.android.gms.internal.mlkit_common.zzic;
import com.google.android.gms.internal.mlkit_common.zzim;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class RemoteModelDownloadManager {
    private static final GmsLogger zza = new GmsLogger("ModelDownloadManager", "");
    private static final Map<RemoteModel, RemoteModelDownloadManager> zzb = new HashMap();
    private final LongSparseArray<zzc> zzc = new LongSparseArray<>();
    private final LongSparseArray<TaskCompletionSource<Void>> zzd = new LongSparseArray<>();
    private final MlKitContext zze;
    private final DownloadManager zzf;
    private final RemoteModel zzg;
    private final ModelType zzh;
    private final zzic zzi;
    private final SharedPrefManager zzj;
    private final ModelFileHelper zzk;
    private final ModelInfoRetrieverInterop zzl;
    private final RemoteModelFileManager zzm;
    private DownloadConditions zzn;

    RemoteModelDownloadManager(MlKitContext mlKitContext, RemoteModel remoteModel, ModelFileHelper modelFileHelper, RemoteModelFileManager remoteModelFileManager, ModelInfoRetrieverInterop modelInfoRetrieverInterop, zzic zzicVar) {
        this.zze = mlKitContext;
        this.zzh = remoteModel.getModelType();
        this.zzg = remoteModel;
        DownloadManager downloadManager = (DownloadManager) mlKitContext.getApplicationContext().getSystemService("download");
        this.zzf = downloadManager;
        this.zzi = zzicVar;
        if (downloadManager == null) {
            zza.m2357d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.zzk = modelFileHelper;
        this.zzj = SharedPrefManager.getInstance(mlKitContext);
        this.zzl = modelInfoRetrieverInterop;
        this.zzm = remoteModelFileManager;
    }

    public static synchronized RemoteModelDownloadManager getInstance(MlKitContext mlKitContext, RemoteModel remoteModel, ModelFileHelper modelFileHelper, RemoteModelFileManager remoteModelFileManager, ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        Map<RemoteModel, RemoteModelDownloadManager> map;
        map = zzb;
        if (!map.containsKey(remoteModel)) {
            map.put(remoteModel, new RemoteModelDownloadManager(mlKitContext, remoteModel, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop, zzim.zza("common")));
        }
        return map.get(remoteModel);
    }

    private final synchronized Long zzj(DownloadManager.Request request, ModelInfo modelInfo) {
        DownloadManager downloadManager = this.zzf;
        if (downloadManager == null) {
            return null;
        }
        long jEnqueue = downloadManager.enqueue(request);
        GmsLogger gmsLogger = zza;
        StringBuilder sb = new StringBuilder(53);
        sb.append("Schedule a new downloading task: ");
        sb.append(jEnqueue);
        gmsLogger.m2357d("ModelDownloadManager", sb.toString());
        this.zzj.setDownloadingModelInfo(jEnqueue, modelInfo);
        this.zzi.zzd(zzhx.zzd(), this.zzg, zzfy.NO_ERROR, false, modelInfo.getModelType(), zzgf.SCHEDULED);
        return Long.valueOf(jEnqueue);
    }

    private final synchronized Long zzk(ModelInfo modelInfo, DownloadConditions downloadConditions) throws MlKitException {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        String downloadingModelHash = this.zzj.getDownloadingModelHash(this.zzg);
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        if (downloadingModelHash != null && downloadingModelHash.equals(modelInfo.getModelHash()) && downloadingModelStatusCode != null) {
            Integer downloadingModelStatusCode2 = getDownloadingModelStatusCode();
            if (downloadingModelStatusCode2 == null || (downloadingModelStatusCode2.intValue() != 8 && downloadingModelStatusCode2.intValue() != 16)) {
                this.zzi.zzd(zzhx.zzd(), this.zzg, zzfy.NO_ERROR, false, this.zzg.getModelType(), zzgf.DOWNLOADING);
            }
            zza.m2357d("ModelDownloadManager", "New model is already in downloading, do nothing.");
            return null;
        }
        GmsLogger gmsLogger = zza;
        gmsLogger.m2357d("ModelDownloadManager", "Need to download a new model.");
        removeOrCancelDownload();
        DownloadManager.Request request = new DownloadManager.Request(modelInfo.getModelUri());
        if (this.zzk.modelExistsLocally(modelInfo.getModelNameForPersist(), modelInfo.getModelType())) {
            gmsLogger.m2357d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
            this.zzi.zzd(zzhx.zzd(), this.zzg, zzfy.NO_ERROR, false, modelInfo.getModelType(), zzgf.UPDATE_AVAILABLE);
        }
        request.setRequiresCharging(downloadConditions.isChargingRequired());
        if (downloadConditions.isWifiRequired()) {
            request.setAllowedNetworkTypes(2);
        }
        return zzj(request, modelInfo);
    }

    private final synchronized zzc zzl(long j) {
        zzc zzcVar = this.zzc.get(j);
        if (zzcVar != null) {
            return zzcVar;
        }
        zzc zzcVar2 = new zzc(this, j, zzm(j), null);
        this.zzc.put(j, zzcVar2);
        return zzcVar2;
    }

    private final synchronized TaskCompletionSource<Void> zzm(long j) {
        TaskCompletionSource<Void> taskCompletionSource = this.zzd.get(j);
        if (taskCompletionSource != null) {
            return taskCompletionSource;
        }
        TaskCompletionSource<Void> taskCompletionSource2 = new TaskCompletionSource<>();
        this.zzd.put(j, taskCompletionSource2);
        return taskCompletionSource2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MlKitException zzn(Long l) {
        DownloadManager downloadManager = this.zzf;
        Cursor cursorQuery = null;
        if (downloadManager != null && l != null) {
            cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        int i = 13;
        String string = "Model downloading failed";
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE));
            if (i2 == 1006) {
                string = "Model downloading failed due to insufficient space on the device.";
                i = 101;
            } else {
                StringBuilder sb = new StringBuilder(84);
                sb.append("Model downloading failed due to error code: ");
                sb.append(i2);
                sb.append(" from Android DownloadManager");
                string = sb.toString();
            }
        }
        return new MlKitException(string, i);
    }

    private final Task<Void> zzo(long j) {
        this.zze.getApplicationContext().registerReceiver(zzl(j), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, MLTaskExecutor.getInstance().getHandler());
        return zzm(j).getTask();
    }

    public Task<Void> ensureModelDownloaded() {
        MlKitException mlKitException;
        ModelInfo modelInfoZza;
        this.zzi.zzd(zzhx.zzd(), this.zzg, zzfy.NO_ERROR, false, ModelType.UNKNOWN, zzgf.EXPLICITLY_REQUESTED);
        Long lZzk = null;
        try {
            modelInfoZza = zza();
            mlKitException = null;
        } catch (MlKitException e) {
            mlKitException = e;
            modelInfoZza = null;
        }
        try {
            Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
            Long downloadingId = getDownloadingId();
            if (!modelExistsLocally() && (downloadingModelStatusCode == null || downloadingModelStatusCode.intValue() != 8)) {
                if (downloadingModelStatusCode != null && downloadingModelStatusCode.intValue() == 16) {
                    MlKitException mlKitExceptionZzn = zzn(downloadingId);
                    removeOrCancelDownload();
                    return Tasks.forException(mlKitExceptionZzn);
                }
                if (downloadingModelStatusCode != null && ((downloadingModelStatusCode.intValue() == 4 || downloadingModelStatusCode.intValue() == 2 || downloadingModelStatusCode.intValue() == 1) && downloadingId != null && getDownloadingModelHash() != null)) {
                    this.zzi.zzd(zzhx.zzd(), this.zzg, zzfy.NO_ERROR, false, this.zzg.getModelType(), zzgf.DOWNLOADING);
                    return zzo(downloadingId.longValue());
                }
                if (modelInfoZza != null) {
                    lZzk = zzk(modelInfoZza, this.zzn);
                }
                return lZzk == null ? Tasks.forException(new MlKitException("Failed to schedule the download task", 13, mlKitException)) : zzo(lZzk.longValue());
            }
            if (modelInfoZza != null) {
                Long lZzk2 = zzk(modelInfoZza, this.zzn);
                if (lZzk2 != null) {
                    return zzo(lZzk2.longValue());
                }
                zza.m2361i("ModelDownloadManager", "Didn't schedule download for the updated model");
            }
            return Tasks.forResult(null);
        } catch (MlKitException e2) {
            return Tasks.forException(new MlKitException("Failed to ensure the model is downloaded.", 13, e2));
        }
    }

    public synchronized ParcelFileDescriptor getDownloadedFile() {
        Long downloadingId = getDownloadingId();
        DownloadManager downloadManager = this.zzf;
        ParcelFileDescriptor parcelFileDescriptorOpenDownloadedFile = null;
        if (downloadManager == null || downloadingId == null) {
            return null;
        }
        try {
            parcelFileDescriptorOpenDownloadedFile = downloadManager.openDownloadedFile(downloadingId.longValue());
        } catch (FileNotFoundException unused) {
            zza.m2359e("ModelDownloadManager", "Downloaded file is not found");
        }
        return parcelFileDescriptorOpenDownloadedFile;
    }

    public synchronized Long getDownloadingId() {
        return this.zzj.getDownloadingModelId(this.zzg);
    }

    public synchronized String getDownloadingModelHash() {
        return this.zzj.getDownloadingModelHash(this.zzg);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.lang.Integer getDownloadingModelStatusCode() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Long r0 = r8.getDownloadingId()     // Catch: java.lang.Throwable -> L7e
            android.app.DownloadManager r1 = r8.zzf     // Catch: java.lang.Throwable -> L7e
            r2 = 0
            if (r1 == 0) goto L7c
            if (r0 != 0) goto Le
            goto L7c
        Le:
            android.app.DownloadManager$Query r3 = new android.app.DownloadManager$Query     // Catch: java.lang.Throwable -> L7e
            r3.<init>()     // Catch: java.lang.Throwable -> L7e
            long r4 = r0.longValue()     // Catch: java.lang.Throwable -> L7e
            r0 = 1
            long[] r6 = new long[r0]     // Catch: java.lang.Throwable -> L7e
            r7 = 0
            r6[r7] = r4     // Catch: java.lang.Throwable -> L7e
            android.app.DownloadManager$Query r3 = r3.setFilterById(r6)     // Catch: java.lang.Throwable -> L7e
            android.database.Cursor r1 = r1.query(r3)     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L3e
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            java.lang.String r3 = "status"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L3c
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3c
            goto L3f
        L3c:
            r0 = move-exception
            goto L73
        L3e:
            r3 = r2
        L3f:
            if (r3 != 0) goto L48
            if (r1 == 0) goto L46
            r1.close()     // Catch: java.lang.Throwable -> L7e
        L46:
            monitor-exit(r8)
            return r2
        L48:
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r5 = 2
            if (r4 == r5) goto L6d
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r5 = 4
            if (r4 == r5) goto L6d
            int r4 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            if (r4 == r0) goto L6d
            int r0 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r4 = 8
            if (r0 == r4) goto L6d
            int r0 = r3.intValue()     // Catch: java.lang.Throwable -> L3c
            r4 = 16
            if (r0 == r4) goto L6d
            goto L6e
        L6d:
            r2 = r3
        L6e:
            r1.close()     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r8)
            return r2
        L73:
            r1.close()     // Catch: java.lang.Throwable -> L77
            goto L7b
        L77:
            r1 = move-exception
            com.google.android.gms.internal.mlkit_common.zzaw.zza(r0, r1)     // Catch: java.lang.Throwable -> L7e
        L7b:
            throw r0     // Catch: java.lang.Throwable -> L7e
        L7c:
            monitor-exit(r8)
            return r2
        L7e:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L7e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.getDownloadingModelStatusCode():java.lang.Integer");
    }

    public int getFailureReason(Long l) {
        int columnIndex;
        DownloadManager downloadManager = this.zzf;
        Cursor cursorQuery = null;
        if (downloadManager != null && l != null) {
            cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        if (cursorQuery == null || !cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex(AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE)) == -1) {
            return 0;
        }
        return cursorQuery.getInt(columnIndex);
    }

    public boolean isModelDownloadedAndValid() throws MlKitException {
        try {
            if (modelExistsLocally()) {
                return true;
            }
        } catch (MlKitException unused) {
            zza.m2357d("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long downloadingId = getDownloadingId();
        String downloadingModelHash = getDownloadingModelHash();
        if (downloadingId == null || downloadingModelHash == null) {
            zza.m2357d("ModelDownloadManager", "No new model is downloading.");
            removeOrCancelDownload();
            return false;
        }
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        GmsLogger gmsLogger = zza;
        String strValueOf = String.valueOf(downloadingModelStatusCode);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
        sb.append("Download Status code: ");
        sb.append(strValueOf);
        gmsLogger.m2357d("ModelDownloadManager", sb.toString());
        if (downloadingModelStatusCode != null) {
            return Objects.equal(downloadingModelStatusCode, 8) && zzb(downloadingModelHash) != null;
        }
        removeOrCancelDownload();
        return false;
    }

    public boolean modelExistsLocally() throws MlKitException {
        return this.zzk.modelExistsLocally(this.zzg.getUniqueModelNameForPersist(), this.zzh);
    }

    public synchronized void removeOrCancelDownload() throws MlKitException {
        Long downloadingId = getDownloadingId();
        if (this.zzf != null && downloadingId != null) {
            GmsLogger gmsLogger = zza;
            String strValueOf = String.valueOf(downloadingId);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 44);
            sb.append("Cancel or remove existing downloading task: ");
            sb.append(strValueOf);
            gmsLogger.m2357d("ModelDownloadManager", sb.toString());
            if (this.zzf.remove(downloadingId.longValue()) > 0 || getDownloadingModelStatusCode() == null) {
                this.zzk.deleteTempFilesInPrivateFolder(this.zzg.getUniqueModelNameForPersist(), this.zzg.getModelType());
                this.zzj.clearDownloadingModelInfo(this.zzg);
            }
        }
    }

    public void setDownloadConditions(DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.zzn = downloadConditions;
    }

    public synchronized void updateLatestModelHashAndType(String str) throws MlKitException {
        this.zzj.setLatestModelHash(this.zzg, str);
        removeOrCancelDownload();
    }

    final synchronized ModelInfo zza() throws MlKitException {
        boolean zModelExistsLocally = modelExistsLocally();
        if (zModelExistsLocally) {
            this.zzi.zzd(zzhx.zzd(), this.zzg, zzfy.NO_ERROR, false, this.zzg.getModelType(), zzgf.LIVE);
        }
        ModelInfoRetrieverInterop modelInfoRetrieverInterop = this.zzl;
        if (modelInfoRetrieverInterop == null) {
            throw new MlKitException("Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.", 14);
        }
        ModelInfo modelInfoRetrieveRemoteModelInfo = modelInfoRetrieverInterop.retrieveRemoteModelInfo(this.zzg);
        if (modelInfoRetrieveRemoteModelInfo == null) {
            return null;
        }
        MlKitContext mlKitContext = this.zze;
        RemoteModel remoteModel = this.zzg;
        String modelHash = modelInfoRetrieveRemoteModelInfo.getModelHash();
        SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(mlKitContext);
        boolean zEquals = modelHash.equals(sharedPrefManager.getIncompatibleModelHash(remoteModel));
        boolean z = false;
        boolean z2 = true;
        if (zEquals && CommonUtils.getAppVersion(mlKitContext.getApplicationContext()).equals(sharedPrefManager.getPreviousAppVersion())) {
            zza.m2359e("ModelDownloadManager", "The model is incompatible with TFLite and the app is not upgraded, do not download");
            z2 = false;
        }
        if (!zModelExistsLocally) {
            this.zzj.clearLatestModelHash(this.zzg);
        }
        boolean zEquals2 = modelInfoRetrieveRemoteModelInfo.getModelHash().equals(SharedPrefManager.getInstance(this.zze).getLatestModelHash(this.zzg));
        boolean z3 = !zEquals2;
        if (!z2) {
            z = z3;
        } else if (!zModelExistsLocally || !zEquals2) {
            return modelInfoRetrieveRemoteModelInfo;
        }
        if (zModelExistsLocally && (z ^ z2)) {
            return null;
        }
        String modelName = this.zzg.getModelName();
        StringBuilder sb = new StringBuilder(String.valueOf(modelName).length() + 46);
        sb.append("The model ");
        sb.append(modelName);
        sb.append(" is incompatible with TFLite runtime");
        throw new MlKitException(sb.toString(), 100);
    }

    public final File zzb(String str) throws MlKitException {
        GmsLogger gmsLogger = zza;
        gmsLogger.m2357d("ModelDownloadManager", "Model downloaded successfully");
        this.zzi.zzd(zzhx.zzd(), this.zzg, zzfy.NO_ERROR, true, this.zzh, zzgf.SUCCEEDED);
        ParcelFileDescriptor downloadedFile = getDownloadedFile();
        if (downloadedFile == null) {
            removeOrCancelDownload();
            return null;
        }
        gmsLogger.m2357d("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.zzm.moveModelToPrivateFolder(downloadedFile, str, this.zzg);
        } finally {
            removeOrCancelDownload();
        }
    }
}
