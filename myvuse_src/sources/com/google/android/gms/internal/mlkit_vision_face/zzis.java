package com.google.android.gms.internal.mlkit_vision_face;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzis implements Callable {
    private final SharedPrefManager zza;

    private zzis(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    static Callable zza(SharedPrefManager sharedPrefManager) {
        return new zzis(sharedPrefManager);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}
