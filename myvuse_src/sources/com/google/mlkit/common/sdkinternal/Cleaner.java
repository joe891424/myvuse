package com.google.mlkit.common.sdkinternal;

import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class Cleaner {
    private final ReferenceQueue<Object> zza = new ReferenceQueue<>();
    private final Set<zzd> zzb = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
    public interface Cleanable {
        void clean();
    }

    private Cleaner() {
    }

    public static Cleaner create() {
        Cleaner cleaner = new Cleaner();
        cleaner.register(cleaner, zza.zza);
        final ReferenceQueue<Object> referenceQueue = cleaner.zza;
        final Set<zzd> set = cleaner.zzb;
        Thread thread = new Thread(new Runnable(referenceQueue, set) { // from class: com.google.mlkit.common.sdkinternal.zzb
            private final ReferenceQueue zza;
            private final Set zzb;

            {
                this.zza = referenceQueue;
                this.zzb = set;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue2 = this.zza;
                Set set2 = this.zzb;
                while (!set2.isEmpty()) {
                    try {
                        ((zzd) referenceQueue2.remove()).clean();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }, "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return cleaner;
    }

    public Cleanable register(Object obj, Runnable runnable) {
        zzd zzdVar = new zzd(obj, this.zza, this.zzb, runnable, null);
        this.zzb.add(zzdVar);
        return zzdVar;
    }
}
