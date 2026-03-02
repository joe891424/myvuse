package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzin {
    private static final GmsLogger zza = new GmsLogger("RemoteModelUtils", "");

    public static zzgg zza(RemoteModel remoteModel, SharedPrefManager sharedPrefManager, zzie zzieVar) {
        ModelType modelTypeZze = zzieVar.zze();
        String modelHash = remoteModel.getModelHash();
        zzgn zzgnVar = new zzgn();
        zzgi zzgiVar = new zzgi();
        zzgiVar.zza(remoteModel.getModelNameForBackend());
        zzgiVar.zzb(zzgk.CLOUD);
        zzgiVar.zzc(zzaa.zza(modelHash));
        ModelType modelType = ModelType.UNKNOWN;
        int iOrdinal = modelTypeZze.ordinal();
        zzgiVar.zzd(iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 5 ? iOrdinal != 6 ? zzgj.TYPE_UNKNOWN : zzgj.BASE_DIGITAL_INK : zzgj.CUSTOM : zzgj.BASE_TRANSLATE : zzgj.AUTOML_IMAGE_LABELING);
        zzgnVar.zza(zzgiVar.zze());
        zzgp zzgpVarZzb = zzgnVar.zzb();
        zzge zzgeVar = new zzge();
        zzgeVar.zzc(zzieVar.zza());
        zzgeVar.zze(zzieVar.zzf());
        zzgeVar.zzf(Long.valueOf(zzieVar.zzg()));
        zzgeVar.zza(zzgpVarZzb);
        if (zzieVar.zzc()) {
            long modelDownloadBeginTimeMs = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs == 0) {
                zza.m2365w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = sharedPrefManager.getModelFirstUseTimeMs(remoteModel);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    sharedPrefManager.setModelFirstUseTimeMs(remoteModel, modelFirstUseTimeMs);
                }
                zzgeVar.zzb(Long.valueOf(modelFirstUseTimeMs - modelDownloadBeginTimeMs));
            }
        }
        if (zzieVar.zzd()) {
            long modelDownloadBeginTimeMs2 = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs2 == 0) {
                zza.m2365w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                zzgeVar.zzd(Long.valueOf(SystemClock.elapsedRealtime() - modelDownloadBeginTimeMs2));
            }
        }
        return zzgeVar.zzg();
    }
}
