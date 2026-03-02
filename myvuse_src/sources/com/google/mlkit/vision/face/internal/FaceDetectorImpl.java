package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.zzhc;
import com.google.android.gms.internal.mlkit_vision_face.zzhe;
import com.google.android.gms.internal.mlkit_vision_face.zzhn;
import com.google.android.gms.internal.mlkit_vision_face.zziq;
import com.google.android.gms.internal.mlkit_vision_face.zziw;
import com.google.android.gms.internal.mlkit_vision_face.zzje;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public class FaceDetectorImpl extends MobileVisionBase<List<Face>> implements FaceDetector {
    static final FaceDetectorOptions zzb = new FaceDetectorOptions.Builder().build();

    /* synthetic */ FaceDetectorImpl(Context context, ExecutorSelector executorSelector, FaceDetectorOptions faceDetectorOptions, zzb zzbVar) {
        zzg zzgVar = new zzg(context, faceDetectorOptions);
        Executor executorToUse = executorSelector.getExecutorToUse(faceDetectorOptions.zzg());
        zziw zziwVarZza = zzje.zza("play-services-mlkit-face-detection");
        super(zzgVar, executorToUse);
        zzhe zzheVar = new zzhe();
        zzhn zzhnVar = new zzhn();
        zzhnVar.zzc(zzh.zza(faceDetectorOptions));
        zzheVar.zzd(zzhnVar.zzf());
        zziwVarZza.zzd(zziq.zzc(zzheVar), zzhc.ON_DEVICE_FACE_CREATE);
    }

    @Override // com.google.mlkit.vision.face.FaceDetector, com.google.mlkit.vision.common.internal.Detector
    public final Task<List<Face>> process(InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
