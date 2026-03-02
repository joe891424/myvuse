package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.model.RemoteModelManager;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzc implements ComponentFactory {
    static final ComponentFactory zza = new zzc();

    private zzc() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        int i = CommonComponentRegistrar.zza;
        return new RemoteModelManager(componentContainer.setOf(RemoteModelManager.RemoteModelManagerRegistration.class));
    }
}
