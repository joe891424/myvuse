package com.google.android.gms.vision.face;

import android.content.Context;
import com.google.android.gms.internal.vision.zzq;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.internal.client.zzh;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeFaceDetectorV2Creator extends ChimeraNativeBaseFaceDetectorCreator {
    @Override // com.google.android.gms.vision.face.ChimeraNativeBaseFaceDetectorCreator
    protected final zzh zza(Context context, Context context2, DynamiteClearcutLogger dynamiteClearcutLogger, zzf zzfVar) {
        if (zzq.zza(context2, OptionalModuleUtils.FACE, "libface_detector_v2_jni.so")) {
            return new NativeFaceDetectorV2Impl(context, context2, dynamiteClearcutLogger, zzfVar, new FaceDetectorV2Jni());
        }
        return null;
    }
}
