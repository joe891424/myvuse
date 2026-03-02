package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgv extends LazyInstanceMap<String, zzgo> {
    private final zzgt zza = new zzgt(MlKitContext.getInstance().getApplicationContext());

    private zzgv() {
    }

    /* synthetic */ zzgv(zzgu zzguVar) {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ zzgo create(String str) {
        MlKitContext mlKitContext = MlKitContext.getInstance();
        zzgt zzgtVar = this.zza;
        return new zzgo(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), zzgtVar, str, null);
    }
}
