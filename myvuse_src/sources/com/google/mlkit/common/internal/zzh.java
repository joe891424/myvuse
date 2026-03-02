package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.model.CustomRemoteModel;
import com.google.mlkit.common.model.RemoteModelManager;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzh implements ComponentFactory {
    static final ComponentFactory zza = new zzh();

    private zzh() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new RemoteModelManager.RemoteModelManagerRegistration(CustomRemoteModel.class, componentContainer.getProvider(com.google.mlkit.common.internal.model.zzg.class));
    }
}
