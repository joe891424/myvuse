package com.google.android.gms.internal.mlkit_vision_face;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjd extends LazyInstanceMap<String, zziw> {
    private final zzjb zza = new zzjb(MlKitContext.getInstance().getApplicationContext());

    private zzjd() {
    }

    /* synthetic */ zzjd(zzjc zzjcVar) {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ zziw create(String str) {
        MlKitContext mlKitContext = MlKitContext.getInstance();
        zzjb zzjbVar = this.zza;
        return new zziw(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), zzjbVar, str, null);
    }
}
