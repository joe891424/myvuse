package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRuntime;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class MlKitContext {
    private static final AtomicReference<MlKitContext> zzb = new AtomicReference<>();
    private ComponentRuntime zza;

    private MlKitContext() {
    }

    public static MlKitContext getInstance() {
        MlKitContext mlKitContext = zzb.get();
        Preconditions.checkState(mlKitContext != null, "MlKitContext has not been initialized");
        return mlKitContext;
    }

    public static MlKitContext zza(Context context) {
        MlKitContext mlKitContext = new MlKitContext();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        ComponentRuntime componentRuntime = new ComponentRuntime(TaskExecutors.MAIN_THREAD, ComponentDiscovery.forContext(context, MlKitComponentDiscoveryService.class).discover(), Component.m2595of(context, (Class<Context>) Context.class, (Class<? super Context>[]) new Class[0]), Component.m2595of(mlKitContext, (Class<MlKitContext>) MlKitContext.class, (Class<? super MlKitContext>[]) new Class[0]));
        mlKitContext.zza = componentRuntime;
        componentRuntime.initializeEagerComponents(true);
        Preconditions.checkState(zzb.getAndSet(mlKitContext) == null, "MlKitContext is already initialized");
        return mlKitContext;
    }

    public <T> T get(Class<T> cls) {
        Preconditions.checkState(zzb.get() == this, "MlKitContext has been deleted");
        Preconditions.checkNotNull(this.zza);
        return (T) this.zza.get(cls);
    }

    public Context getApplicationContext() {
        return (Context) get(Context.class);
    }
}
