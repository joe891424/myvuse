package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhz implements Callable {
    private final SharedPrefManager zza;

    private zzhz(SharedPrefManager sharedPrefManager) {
        this.zza = sharedPrefManager;
    }

    static Callable zza(SharedPrefManager sharedPrefManager) {
        return new zzhz(sharedPrefManager);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zza.getMlSdkInstanceId();
    }
}
