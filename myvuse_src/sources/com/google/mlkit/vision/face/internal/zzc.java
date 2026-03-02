package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.vision.face.FaceDetectorOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzc {
    private final Context zza;
    private final ExecutorSelector zzb;

    zzc(Context context, ExecutorSelector executorSelector) {
        this.zza = context;
        this.zzb = executorSelector;
    }

    public final FaceDetectorImpl zza() {
        return zzb(FaceDetectorImpl.zzb);
    }

    public final FaceDetectorImpl zzb(FaceDetectorOptions faceDetectorOptions) {
        Preconditions.checkNotNull(faceDetectorOptions, "You must provide a valid FaceDetectorOptions.");
        return new FaceDetectorImpl(this.zza, this.zzb, faceDetectorOptions, null);
    }
}
