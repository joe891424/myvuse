package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.vision.zzfi;
import com.google.android.gms.internal.vision.zzgd;
import com.google.android.gms.internal.vision.zzgh;
import com.google.android.gms.internal.vision.zzgl;
import com.google.android.gms.internal.vision.zzjb;
import com.google.android.gms.internal.vision.zzq;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.LogUtils;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public class FaceDetectorCreator extends zzgl {
    @Override // com.google.android.gms.internal.vision.zzgi
    public zzgh newFaceDetector(IObjectWrapper iObjectWrapper, zzgd zzgdVar) throws RemoteException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        DynamiteClearcutLogger dynamiteClearcutLogger = new DynamiteClearcutLogger(context);
        if (zzq.zza(context, OptionalModuleUtils.FACE, "libface_detector_v2_jni.so")) {
            zza(dynamiteClearcutLogger, context, zzgdVar, null, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return new zzb(context, zzgdVar, new FaceDetectorV2Jni(), dynamiteClearcutLogger);
        }
        LogInstrumentation.m2728e("FaceDetectorCreator", "Failed to load library libface_detector_v2_jni.so");
        zza(dynamiteClearcutLogger, context, zzgdVar, "Failed to load library libface_detector_v2_jni.so", SystemClock.elapsedRealtime() - jElapsedRealtime);
        throw com.google.android.gms.vision.internal.zza.zza("Failed to load library libface_detector_v2_jni.so");
    }

    private static void zza(DynamiteClearcutLogger dynamiteClearcutLogger, Context context, zzgd zzgdVar, String str, long j) {
        zzfi.zzg.zzd zzdVar;
        zzfi.zzg.zzc zzcVar;
        zzfi.zzg.zzb zzbVar;
        zzfi.zzg.zza zzaVarZza = zzfi.zzg.zza();
        if (zzgdVar.zzd() == 2) {
            zzaVarZza.zza(zzfi.zzg.zzd.MODE_SELFIE).zza(zzfi.zzg.zzc.LANDMARK_CONTOUR).zza(true);
        } else {
            if (zzgdVar.zza() == 2) {
                zzdVar = zzfi.zzg.zzd.MODE_ACCURATE;
            } else {
                zzdVar = zzfi.zzg.zzd.MODE_FAST;
            }
            zzfi.zzg.zza zzaVarZza2 = zzaVarZza.zza(zzdVar);
            if (zzgdVar.zzb() == 2) {
                zzcVar = zzfi.zzg.zzc.LANDMARK_ALL;
            } else {
                zzcVar = zzfi.zzg.zzc.LANDMARK_NONE;
            }
            zzaVarZza2.zza(zzcVar).zza(false);
        }
        if (zzgdVar.zzc() == 2) {
            zzbVar = zzfi.zzg.zzb.CLASSIFICATION_ALL;
        } else {
            zzbVar = zzfi.zzg.zzb.CLASSIFICATION_NONE;
        }
        zzaVarZza.zza(zzbVar).zzb(zzgdVar.zze()).zza(zzgdVar.zzf());
        zzfi.zzk.zza zzaVarZza3 = zzfi.zzk.zza().zza(OptionalModuleUtils.FACE).zza(j).zza(zzaVarZza).zza(LogUtils.zza(context));
        if (str != null) {
            zzaVarZza3.zzb(str);
        }
        dynamiteClearcutLogger.zza(2, (zzfi.zzo) ((zzjb) zzfi.zzo.zza().zza(zzaVarZza3).zza(true).zzf()));
    }
}
