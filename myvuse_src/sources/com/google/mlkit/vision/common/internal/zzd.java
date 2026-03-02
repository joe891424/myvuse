package com.google.mlkit.vision.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzd implements ComponentFactory {
    static final ComponentFactory zza = new zzd();

    private zzd() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        int i = VisionCommonRegistrar.zza;
        return new MultiFlavorDetectorCreator(componentContainer.setOf(MultiFlavorDetectorCreator.Registration.class));
    }
}
