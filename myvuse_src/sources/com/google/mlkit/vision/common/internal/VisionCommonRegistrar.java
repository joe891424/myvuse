package com.google.mlkit.vision.common.internal;

import com.google.android.gms.internal.mlkit_vision_common.zzo;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class VisionCommonRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List<Component<?>> getComponents() {
        return zzo.zzg(Component.builder(MultiFlavorDetectorCreator.class).add(Dependency.setOf((Class<?>) MultiFlavorDetectorCreator.Registration.class)).factory(zzd.zza).build());
    }
}
