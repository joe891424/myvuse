package com.google.mlkit.vision.face.internal;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face.zzax;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes2.dex */
public class FaceRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List<Component<?>> getComponents() {
        return zzax.zzg(Component.builder(zzd.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(zzi.zza).build(), Component.builder(zzc.class).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) ExecutorSelector.class)).factory(zzj.zza).build());
    }
}
