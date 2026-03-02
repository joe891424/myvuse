package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzj implements ComponentFactory {
    static final ComponentFactory zza = new zzj();

    private zzj() {
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new zzc((Context) componentContainer.get(Context.class), (ExecutorSelector) componentContainer.get(ExecutorSelector.class));
    }
}
