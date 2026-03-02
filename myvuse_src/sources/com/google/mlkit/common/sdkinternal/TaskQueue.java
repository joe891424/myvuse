package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzaw;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class TaskQueue {
    private boolean zzb;
    private final Object zza = new Object();
    private final Queue<zzr> zzc = new ArrayDeque();
    private final AtomicReference<Thread> zzd = new AtomicReference<>();

    private final void zzc(Executor executor, final Runnable runnable) {
        try {
            executor.execute(new Runnable(this, runnable) { // from class: com.google.mlkit.common.sdkinternal.zzp
                private final TaskQueue zza;
                private final Runnable zzb;

                {
                    this.zza = this;
                    this.zzb = runnable;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TaskQueue taskQueue = this.zza;
                    Runnable runnable2 = this.zzb;
                    zzs zzsVar = new zzs(taskQueue, null);
                    try {
                        runnable2.run();
                        zzsVar.close();
                    } catch (Throwable th) {
                        try {
                            zzsVar.close();
                        } catch (Throwable th2) {
                            zzaw.zza(th, th2);
                        }
                        throw th;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            zzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd() {
        synchronized (this.zza) {
            if (this.zzc.isEmpty()) {
                this.zzb = false;
            } else {
                zzr zzrVarRemove = this.zzc.remove();
                zzc(zzrVarRemove.zza, zzrVarRemove.zzb);
            }
        }
    }

    public void checkIsRunningOnCurrentThread() {
        Preconditions.checkState(Thread.currentThread().equals(this.zzd.get()));
    }

    public void submit(Executor executor, Runnable runnable) {
        synchronized (this.zza) {
            if (this.zzb) {
                this.zzc.add(new zzr(executor, runnable, null));
            } else {
                this.zzb = true;
                zzc(executor, runnable);
            }
        }
    }
}
