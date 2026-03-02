package com.google.mlkit.common.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zza implements ComponentFactory {
    static final ComponentFactory zza = new zza();

    private zza() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        int i = CommonComponentRegistrar.zza;
        return new ModelFileHelper((MlKitContext) componentContainer.get(MlKitContext.class));
    }
}
