package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzil extends LazyInstanceMap<String, zzic> {
    private final zzij zza = new zzij(MlKitContext.getInstance().getApplicationContext());

    private zzil() {
    }

    /* synthetic */ zzil(zzik zzikVar) {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ zzic create(String str) {
        MlKitContext mlKitContext = MlKitContext.getInstance();
        zzij zzijVar = this.zza;
        return new zzic(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), zzijVar, str, null);
    }
}
