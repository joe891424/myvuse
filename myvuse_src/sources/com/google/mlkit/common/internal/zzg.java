package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzg implements ComponentFactory {
    static final ComponentFactory zza = new zzg();

    private zzg() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new com.google.mlkit.common.internal.model.zzg((MlKitContext) componentContainer.get(MlKitContext.class));
    }
}
