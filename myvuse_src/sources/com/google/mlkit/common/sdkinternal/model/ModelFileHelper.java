package com.google.mlkit.common.sdkinternal.model;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import java.io.File;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class ModelFileHelper {
    public static final int INVALID_INDEX = -1;
    private final MlKitContext zzf;
    private static final GmsLogger zze = new GmsLogger("ModelFileHelper", "");
    public static final String zza = String.format("com.google.mlkit.%s.models", "automl");
    public static final String zzb = String.format("com.google.mlkit.%s.models", "translate");
    public static final String zzc = String.format("com.google.mlkit.%s.models", "custom");
    static final String zzd = String.format("com.google.mlkit.%s.models", Constants.SENSITIVITY_BASE);

    public ModelFileHelper(MlKitContext mlKitContext) {
        this.zzf = mlKitContext;
    }

    private final File zzc(String str, ModelType modelType, boolean z) throws MlKitException {
        File modelDirUnsafe = getModelDirUnsafe(str, modelType, z);
        if (!modelDirUnsafe.exists()) {
            GmsLogger gmsLogger = zze;
            String strValueOf = String.valueOf(modelDirUnsafe.getAbsolutePath());
            gmsLogger.m2357d("ModelFileHelper", strValueOf.length() != 0 ? "model folder does not exist, creating one: ".concat(strValueOf) : new String("model folder does not exist, creating one: "));
            if (!modelDirUnsafe.mkdirs()) {
                String strValueOf2 = String.valueOf(modelDirUnsafe);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf2).length() + 31);
                sb.append("Failed to create model folder: ");
                sb.append(strValueOf2);
                throw new MlKitException(sb.toString(), 13);
            }
        } else if (!modelDirUnsafe.isDirectory()) {
            String strValueOf3 = String.valueOf(modelDirUnsafe);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf3).length() + 71);
            sb2.append("Can not create model folder, since an existing file has the same name: ");
            sb2.append(strValueOf3);
            throw new MlKitException(sb2.toString(), 6);
        }
        return modelDirUnsafe;
    }

    public synchronized void deleteAllModels(ModelType modelType, String str) {
        deleteRecursively(getModelDirUnsafe(str, modelType, false));
        deleteRecursively(getModelDirUnsafe(str, modelType, true));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean deleteRecursively(java.io.File r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            boolean r1 = r8.isDirectory()
            r2 = 1
            if (r1 == 0) goto L2c
            java.io.File[] r1 = r8.listFiles()
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            java.io.File[] r1 = (java.io.File[]) r1
            int r3 = r1.length
            r4 = r0
            r5 = r2
        L18:
            if (r4 >= r3) goto L2a
            r6 = r1[r4]
            if (r5 == 0) goto L26
            boolean r5 = r7.deleteRecursively(r6)
            if (r5 == 0) goto L26
            r5 = r2
            goto L27
        L26:
            r5 = r0
        L27:
            int r4 = r4 + 1
            goto L18
        L2a:
            if (r5 == 0) goto L33
        L2c:
            boolean r8 = r8.delete()
            if (r8 == 0) goto L33
            return r2
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.ModelFileHelper.deleteRecursively(java.io.File):boolean");
    }

    public void deleteTempFilesInPrivateFolder(String str, ModelType modelType) throws MlKitException {
        File fileZzc = zzc(str, modelType, true);
        if (deleteRecursively(fileZzc)) {
            return;
        }
        GmsLogger gmsLogger = zze;
        String strValueOf = String.valueOf(fileZzc != null ? fileZzc.getAbsolutePath() : null);
        gmsLogger.m2359e("ModelFileHelper", strValueOf.length() != 0 ? "Failed to delete the temp labels file directory: ".concat(strValueOf) : new String("Failed to delete the temp labels file directory: "));
    }

    public int getLatestCachedModelVersion(File file) {
        File[] fileArrListFiles = file.listFiles();
        int iMax = -1;
        if (fileArrListFiles != null && (fileArrListFiles.length) != 0) {
            for (File file2 : fileArrListFiles) {
                try {
                    iMax = Math.max(iMax, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    GmsLogger gmsLogger = zze;
                    String strValueOf = String.valueOf(file2.getName());
                    gmsLogger.m2357d("ModelFileHelper", strValueOf.length() != 0 ? "Contains non-integer file name ".concat(strValueOf) : new String("Contains non-integer file name "));
                }
            }
        }
        return iMax;
    }

    public File getModelDir(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, false);
    }

    public File getModelDirUnsafe(String str, ModelType modelType, boolean z) {
        String str2;
        ModelType modelType2 = ModelType.UNKNOWN;
        int iOrdinal = modelType.ordinal();
        if (iOrdinal == 1) {
            str2 = zzd;
        } else if (iOrdinal == 2) {
            str2 = zza;
        } else if (iOrdinal == 3) {
            str2 = zzb;
        } else {
            if (iOrdinal != 5) {
                String strName = modelType.name();
                StringBuilder sb = new StringBuilder(String.valueOf(strName).length() + 69);
                sb.append("Unknown model type ");
                sb.append(strName);
                sb.append(". Cannot find a dir to store the downloaded model.");
                throw new IllegalArgumentException(sb.toString());
            }
            str2 = zzc;
        }
        File file = new File(this.zzf.getApplicationContext().getNoBackupFilesDir(), str2);
        if (z) {
            file = new File(file, "temp");
        }
        return new File(file, str);
    }

    public File getModelTempDir(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }

    public File getTempFileInPrivateFolder(String str, ModelType modelType, String str2) throws MlKitException {
        File fileZzc = zzc(str, modelType, true);
        if (fileZzc.exists() && fileZzc.isFile() && !fileZzc.delete()) {
            String strValueOf = String.valueOf(fileZzc.getAbsolutePath());
            throw new MlKitException(strValueOf.length() != 0 ? "Failed to delete the temp labels file: ".concat(strValueOf) : new String("Failed to delete the temp labels file: "), 13);
        }
        if (!fileZzc.exists()) {
            GmsLogger gmsLogger = zze;
            String strValueOf2 = String.valueOf(fileZzc.getAbsolutePath());
            gmsLogger.m2357d("ModelFileHelper", strValueOf2.length() != 0 ? "Temp labels folder does not exist, creating one: ".concat(strValueOf2) : new String("Temp labels folder does not exist, creating one: "));
            if (!fileZzc.mkdirs()) {
                throw new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", 13);
            }
        }
        return new File(fileZzc, str2);
    }

    public boolean modelExistsLocally(String str, ModelType modelType) throws MlKitException {
        String strZza;
        if (modelType == ModelType.UNKNOWN || (strZza = zza(str, modelType)) == null) {
            return false;
        }
        File file = new File(strZza);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, com.google.mlkit.common.sdkinternal.Constants.MODEL_FILE_NAME);
        GmsLogger gmsLogger = zze;
        String strValueOf = String.valueOf(file2.getAbsolutePath());
        gmsLogger.m2361i("ModelFileHelper", strValueOf.length() != 0 ? "Model file path: ".concat(strValueOf) : new String("Model file path: "));
        if (modelType != ModelType.AUTOML) {
            return file2.exists();
        }
        if (file2.exists()) {
            File file3 = new File(file, com.google.mlkit.common.sdkinternal.Constants.AUTOML_IMAGE_LABELING_LABELS_FILE_NAME);
            File file4 = new File(file, com.google.mlkit.common.sdkinternal.Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME);
            if (file3.exists() && file4.exists()) {
                return true;
            }
        }
        return false;
    }

    public final String zza(String str, ModelType modelType) throws MlKitException {
        File modelDir = getModelDir(str, modelType);
        int latestCachedModelVersion = getLatestCachedModelVersion(modelDir);
        if (latestCachedModelVersion == -1) {
            return null;
        }
        String absolutePath = modelDir.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 12);
        sb.append(absolutePath);
        sb.append("/");
        sb.append(latestCachedModelVersion);
        return sb.toString();
    }

    public final File zzb(String str, ModelType modelType) throws MlKitException {
        return zzc(str, modelType, true);
    }
}
