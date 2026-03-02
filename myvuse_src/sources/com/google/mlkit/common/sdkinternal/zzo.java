package com.google.mlkit.common.sdkinternal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzo implements ComponentFactory {
    static final ComponentFactory zza = new zzo();

    private zzo() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return SharedPrefManager.zzc(componentContainer);
    }
}
