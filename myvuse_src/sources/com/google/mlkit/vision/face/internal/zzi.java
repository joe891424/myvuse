package com.google.mlkit.vision.face.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzi implements ComponentFactory {
    static final ComponentFactory zza = new zzi();

    private zzi() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        int i = FaceRegistrar.zza;
        return new zzd((MlKitContext) componentContainer.get(MlKitContext.class));
    }
}
