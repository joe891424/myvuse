package com.google.mlkit.common.sdkinternal.model;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzaw;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzgf;
import com.google.android.gms.internal.mlkit_common.zzhx;
import com.google.android.gms.internal.mlkit_common.zzim;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelValidator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class RemoteModelFileManager {
    private static final GmsLogger zza = new GmsLogger("RemoteModelFileManager", "");
    private final MlKitContext zzb;
    private final String zzc;
    private final ModelType zzd;
    private final ModelValidator zze;
    private final RemoteModelFileMover zzf;
    private final SharedPrefManager zzg;
    private final ModelFileHelper zzh;

    public RemoteModelFileManager(MlKitContext mlKitContext, RemoteModel remoteModel, ModelValidator modelValidator, ModelFileHelper modelFileHelper, RemoteModelFileMover remoteModelFileMover) {
        this.zzb = mlKitContext;
        ModelType modelType = remoteModel.getModelType();
        this.zzd = modelType;
        this.zzc = modelType == ModelType.TRANSLATE ? remoteModel.getModelNameForBackend() : remoteModel.getUniqueModelNameForPersist();
        this.zze = modelValidator;
        this.zzg = SharedPrefManager.getInstance(mlKitContext);
        this.zzh = modelFileHelper;
        this.zzf = remoteModelFileMover;
    }

    public File getModelDirUnsafe(boolean z) {
        return this.zzh.getModelDirUnsafe(this.zzc, this.zzd, z);
    }

    public synchronized File moveModelToPrivateFolder(ParcelFileDescriptor parcelFileDescriptor, String str, RemoteModel remoteModel) throws MlKitException {
        File file;
        FileOutputStream fileOutputStream;
        MlKitException mlKitException;
        ModelValidator modelValidator;
        file = new File(this.zzh.zzb(this.zzc, this.zzd), "to_be_validated_model.tmp");
        ModelValidator.ValidationResult validationResultValidateModel = null;
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                try {
                    autoCloseInputStream.close();
                } catch (Throwable th2) {
                    zzaw.zza(th, th2);
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = autoCloseInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                    autoCloseInputStream.close();
                    throw th;
                }
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                autoCloseInputStream.close();
                boolean zZza = ModelUtils.zza(file, str);
                if (zZza && (modelValidator = this.zze) != null) {
                    validationResultValidateModel = modelValidator.validateModel(file, remoteModel);
                    if (validationResultValidateModel.getErrorCode().equals(ModelValidator.ValidationResult.ErrorCode.TFLITE_VERSION_INCOMPATIBLE)) {
                        String appVersion = CommonUtils.getAppVersion(this.zzb.getApplicationContext());
                        this.zzg.setIncompatibleModelInfo(remoteModel, str, appVersion);
                        GmsLogger gmsLogger = zza;
                        String strValueOf = String.valueOf(str);
                        gmsLogger.m2357d("RemoteModelFileManager", strValueOf.length() != 0 ? "Model is not compatible. Model hash: ".concat(strValueOf) : new String("Model is not compatible. Model hash: "));
                        String strValueOf2 = String.valueOf(appVersion);
                        gmsLogger.m2357d("RemoteModelFileManager", strValueOf2.length() != 0 ? "The current app version is: ".concat(strValueOf2) : new String("The current app version is: "));
                    }
                }
                if (zZza && (validationResultValidateModel == null || validationResultValidateModel.isValid())) {
                }
                if (zZza) {
                    mlKitException = new MlKitException("Model is not compatible with TFLite run time", 100);
                } else {
                    GmsLogger gmsLogger2 = zza;
                    String strValueOf3 = String.valueOf(str);
                    gmsLogger2.m2357d("RemoteModelFileManager", strValueOf3.length() != 0 ? "Hash does not match with expected: ".concat(strValueOf3) : new String("Hash does not match with expected: "));
                    zzim.zza("common").zzd(zzhx.zzd(), remoteModel, zzfy.MODEL_HASH_MISMATCH, true, this.zzd, zzgf.SUCCEEDED);
                    mlKitException = new MlKitException("Hash does not match with expected", 102);
                }
                if (file.delete()) {
                    throw mlKitException;
                }
                GmsLogger gmsLogger3 = zza;
                String strValueOf4 = String.valueOf(file.getAbsolutePath());
                gmsLogger3.m2357d("RemoteModelFileManager", strValueOf4.length() != 0 ? "Failed to delete the temp file: ".concat(strValueOf4) : new String("Failed to delete the temp file: "));
                throw mlKitException;
            } finally {
            }
        } catch (IOException e) {
            GmsLogger gmsLogger4 = zza;
            String strValueOf5 = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf5).length() + 56);
            sb.append("Failed to copy downloaded model file to private folder: ");
            sb.append(strValueOf5);
            gmsLogger4.m2359e("RemoteModelFileManager", sb.toString());
            return null;
        }
        return this.zzf.moveAllFilesFromPrivateTempToPrivateDestination(file);
    }

    public final synchronized boolean zza(File file) throws MlKitException {
        File modelDir = this.zzh.getModelDir(this.zzc, this.zzd);
        if (!modelDir.exists()) {
            return false;
        }
        File[] fileArrListFiles = modelDir.listFiles();
        boolean z = true;
        if (fileArrListFiles == null) {
            return true;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.equals(file) && !this.zzh.deleteRecursively(file2)) {
                z = false;
            }
        }
        return z;
    }

    public final synchronized void zzb(File file) {
        File modelDirUnsafe = getModelDirUnsafe(false);
        if (modelDirUnsafe.exists()) {
            File[] fileArrListFiles = modelDirUnsafe.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.equals(file)) {
                    this.zzh.deleteRecursively(file);
                    return;
                }
            }
        }
    }

    public final synchronized File zzc(File file) throws MlKitException {
        File file2 = new File(String.valueOf(this.zzh.getModelDir(this.zzc, this.zzd).getAbsolutePath()).concat("/0"));
        if (file2.exists()) {
            return file;
        }
        return file.renameTo(file2) ? file2 : file;
    }

    public final synchronized String zzd() throws MlKitException {
        return this.zzh.zza(this.zzc, this.zzd);
    }
}
