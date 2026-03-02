package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzao;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class MlKitThreadPool extends zzao {
    private static final ThreadLocal<Deque<Runnable>> zza = new ThreadLocal<>();
    private final ThreadPoolExecutor zzb;

    public MlKitThreadPool() {
        final ThreadFactory threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(threadFactoryDefaultThreadFactory) { // from class: com.google.mlkit.common.sdkinternal.zzi
            private final ThreadFactory zza;

            {
                this.zza = threadFactoryDefaultThreadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(final Runnable runnable) {
                return this.zza.newThread(new Runnable(runnable) { // from class: com.google.mlkit.common.sdkinternal.zzk
                    private final Runnable zza;

                    {
                        this.zza = runnable;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        MlKitThreadPool.zzd(this.zza);
                    }
                });
            }
        });
        this.zzb = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    static final /* synthetic */ void zzd(Runnable runnable) {
        zza.set(new ArrayDeque());
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zze(Deque<Runnable> deque, Runnable runnable) {
        Preconditions.checkNotNull(deque);
        deque.add(runnable);
        if (deque.size() <= 1) {
            do {
                runnable.run();
                deque.removeFirst();
                runnable = deque.peekFirst();
            } while (runnable != null);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzao, java.util.concurrent.Executor
    public final void execute(final Runnable runnable) {
        Deque<Runnable> deque = zza.get();
        if (deque == null || deque.size() > 1) {
            this.zzb.execute(new Runnable(runnable) { // from class: com.google.mlkit.common.sdkinternal.zzj
                private final Runnable zza;

                {
                    this.zza = runnable;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MlKitThreadPool.zze(MlKitThreadPool.zza.get(), this.zza);
                }
            });
        } else {
            zze(deque, runnable);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzao, com.google.android.gms.internal.mlkit_common.zzac
    protected final /* bridge */ /* synthetic */ Object zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzao
    protected final ExecutorService zzb() {
        return this.zzb;
    }
}
