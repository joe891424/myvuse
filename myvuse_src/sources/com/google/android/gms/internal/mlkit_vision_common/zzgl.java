package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzgl implements Callable {
    private final SharedPrefManager zza;

    private zzgl(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    static Callable zza(SharedPrefManager sharedPrefManager) {
        return new zzgl(sharedPrefManager);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}
