package com.google.android.gms.vision.face;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzbi;
import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
import com.google.android.gms.vision.face.internal.client.zzl;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ChimeraNativeBaseFaceDetectorCreator extends zzl {
    protected abstract zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzfVar) throws RemoteException;

    @Override // com.google.android.gms.vision.face.internal.client.zzi
    public zzh newFaceDetector(IObjectWrapper iObjectWrapper, zzf zzfVar) throws RemoteException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbi.zzb(context);
        DynamiteClearcutLogger dynamiteClearcutLogger = new DynamiteClearcutLogger(context);
        try {
            try {
                zzh zzhVarZza = zza(context, context, dynamiteClearcutLogger, zzfVar);
                if (zzhVarZza != null) {
                    zza(dynamiteClearcutLogger, context, zzfVar, null, SystemClock.elapsedRealtime() - jElapsedRealtime);
                }
                return zzhVarZza;
            } catch (RemoteException e) {
                e.getMessage();
                throw e;
            }
        } finally {
        }
    }

    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, Context context, zzf zzfVar, String str, long j) {
        zzfi.zzg.zza zzaVarZza = zzfi.zzg.zza();
        if (zzfVar.zza == 1) {
            zzaVarZza.zza(zzfi.zzg.zzd.MODE_ACCURATE);
        } else if (zzfVar.zza == 0) {
            zzaVarZza.zza(zzfi.zzg.zzd.MODE_FAST);
        } else if (zzfVar.zza == 2) {
            zzaVarZza.zza(zzfi.zzg.zzd.MODE_SELFIE);
        }
        if (zzfVar.zzb == 1) {
            zzaVarZza.zza(zzfi.zzg.zzc.LANDMARK_ALL);
        } else if (zzfVar.zzb == 0) {
            zzaVarZza.zza(zzfi.zzg.zzc.LANDMARK_NONE);
        } else if (zzfVar.zzb == 2) {
            zzaVarZza.zza(zzfi.zzg.zzc.LANDMARK_CONTOUR);
        }
        if (zzfVar.zzc == 1) {
            zzaVarZza.zza(zzfi.zzg.zzb.CLASSIFICATION_ALL);
        } else if (zzfVar.zzc == 0) {
            zzaVarZza.zza(zzfi.zzg.zzb.CLASSIFICATION_NONE);
        }
        zzaVarZza.zza(zzfVar.zzd).zzb(zzfVar.zze).zza(zzfVar.zzf);
        zzfi.zzk.zza zzaVarZza2 = zzfi.zzk.zza().zza(OptionalModuleUtils.FACE).zza(j).zza(zzaVarZza);
        if (str != null) {
            zzaVarZza2.zzb(str);
        }
        zzaVarZza2.zza(LogUtils.zza(context));
        dynamiteClearcutLogger.zza(2, (zzfi.zzo) ((zzjb) zzfi.zzo.zza().zza(zzaVarZza2).zzf()));
    }
}
