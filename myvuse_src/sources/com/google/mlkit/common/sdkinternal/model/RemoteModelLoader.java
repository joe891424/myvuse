package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzic;
import com.google.android.gms.internal.mlkit_common.zzim;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class RemoteModelLoader {
    private static final GmsLogger zza = new GmsLogger("RemoteModelLoader", "");
    private static final Map<String, RemoteModelLoader> zzb = new HashMap();
    private final MlKitContext zzc;
    private final RemoteModel zzd;
    private final RemoteModelDownloadManager zze;
    private final RemoteModelFileManager zzf;
    private final RemoteModelLoaderHelper zzg;
    private final zzic zzh;
    private boolean zzi;

    private RemoteModelLoader(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.zzf = remoteModelFileManager;
        this.zzi = true;
        this.zze = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.zzg = remoteModelLoaderHelper;
        this.zzc = mlKitContext;
        this.zzd = remoteModel;
        this.zzh = zzim.zza("common");
    }

    public static synchronized RemoteModelLoader getInstance(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        String uniqueModelNameForPersist;
        Map<String, RemoteModelLoader> map;
        uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
        map = zzb;
        if (!map.containsKey(uniqueModelNameForPersist)) {
            map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
        }
        return map.get(uniqueModelNameForPersist);
    }

    private final MappedByteBuffer zza(File file) throws MlKitException {
        try {
            return zzb(file.getAbsolutePath());
        } catch (Exception e) {
            this.zzf.zzb(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e);
        }
    }

    private final MappedByteBuffer zzb(String str) throws MlKitException {
        return this.zzg.loadModelAtPath(str);
    }

    public RemoteModel getRemoteModel() {
        return this.zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d6 A[Catch: all -> 0x0117, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:30:0x00d6, B:32:0x00e5, B:34:0x00ed, B:37:0x00f3, B:38:0x0111, B:39:0x0112, B:10:0x002f, B:12:0x005b, B:15:0x0064, B:17:0x0078, B:19:0x0082, B:21:0x008e, B:23:0x0096, B:18:0x007d, B:24:0x00a8, B:26:0x00b0, B:27:0x00c7), top: B:46:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0112 A[Catch: all -> 0x0117, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:30:0x00d6, B:32:0x00e5, B:34:0x00ed, B:37:0x00f3, B:38:0x0111, B:39:0x0112, B:10:0x002f, B:12:0x005b, B:15:0x0064, B:17:0x0078, B:19:0x0082, B:21:0x008e, B:23:0x0096, B:18:0x007d, B:24:0x00a8, B:26:0x00b0, B:27:0x00c7), top: B:46:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.nio.MappedByteBuffer load() throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelLoader.load():java.nio.MappedByteBuffer");
    }
}
