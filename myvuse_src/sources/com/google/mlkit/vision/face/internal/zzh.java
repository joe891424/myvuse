package com.google.mlkit.vision.face.internal;

import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzgl;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzgn;
import com.google.android.gms.internal.mlkit_vision_face.zzgo;
import com.google.android.gms.internal.mlkit_vision_face.zzgp;
import com.google.mlkit.vision.face.FaceDetectorOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzh {
    public static zzgp zza(FaceDetectorOptions faceDetectorOptions) {
        zzgk zzgkVar = new zzgk();
        int iZza = faceDetectorOptions.zza();
        zzgkVar.zza(iZza != 1 ? iZza != 2 ? zzgn.UNKNOWN_LANDMARKS : zzgn.ALL_LANDMARKS : zzgn.NO_LANDMARKS);
        int iZzc = faceDetectorOptions.zzc();
        zzgkVar.zzb(iZzc != 1 ? iZzc != 2 ? zzgl.UNKNOWN_CLASSIFICATIONS : zzgl.ALL_CLASSIFICATIONS : zzgl.NO_CLASSIFICATIONS);
        int iZzd = faceDetectorOptions.zzd();
        zzgkVar.zzc(iZzd != 1 ? iZzd != 2 ? zzgo.UNKNOWN_PERFORMANCE : zzgo.ACCURATE : zzgo.FAST);
        int iZzb = faceDetectorOptions.zzb();
        zzgkVar.zzd(iZzb != 1 ? iZzb != 2 ? zzgm.UNKNOWN_CONTOURS : zzgm.ALL_CONTOURS : zzgm.NO_CONTOURS);
        zzgkVar.zze(Boolean.valueOf(faceDetectorOptions.zze()));
        zzgkVar.zzf(Float.valueOf(faceDetectorOptions.zzf()));
        return zzgkVar.zzg();
    }
}
