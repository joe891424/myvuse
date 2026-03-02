package com.google.mlkit.vision.face.internal;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.face.FaceDetectorOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzd extends LazyInstanceMap<FaceDetectorOptions, zzg> {
    private final MlKitContext zza;

    public zzd(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ zzg create(FaceDetectorOptions faceDetectorOptions) {
        return new zzg(this.zza.getApplicationContext(), faceDetectorOptions);
    }
}
