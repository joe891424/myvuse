package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.internal.mlkit_common.zzap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class MLTaskExecutor {
    private static final Object zza = new Object();
    private static MLTaskExecutor zzb;
    private Handler zzc;

    private MLTaskExecutor(Looper looper) {
        this.zzc = new com.google.android.gms.internal.mlkit_common.zza(looper);
    }

    public static MLTaskExecutor getInstance() {
        MLTaskExecutor mLTaskExecutor;
        synchronized (zza) {
            if (zzb == null) {
                HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                handlerThread.start();
                zzb = new MLTaskExecutor(handlerThread.getLooper());
            }
            mLTaskExecutor = zzb;
        }
        return mLTaskExecutor;
    }

    public static Executor workerThreadExecutor() {
        return zzh.zza;
    }

    public Handler getHandler() {
        return this.zzc;
    }

    public <ResultT> Task<ResultT> scheduleCallable(final Callable<ResultT> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        scheduleRunnable(new Runnable(callable, taskCompletionSource) { // from class: com.google.mlkit.common.sdkinternal.zzf
            private final Callable zza;
            private final TaskCompletionSource zzb;

            {
                this.zza = callable;
                this.zzb = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Callable callable2 = this.zza;
                TaskCompletionSource taskCompletionSource2 = this.zzb;
                try {
                    taskCompletionSource2.setResult(callable2.call());
                } catch (MlKitException e) {
                    taskCompletionSource2.setException(e);
                } catch (Exception e2) {
                    taskCompletionSource2.setException(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e2));
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    public void scheduleRunnable(Runnable runnable) {
        workerThreadExecutor().execute(runnable);
    }

    public void scheduleRunnableDelayed(Runnable runnable, long j) {
        this.zzc.postDelayed(runnable, j);
    }

    public <ResultT> Task<ResultT> scheduleTaskCallable(Callable<Task<ResultT>> callable) {
        return (Task<ResultT>) scheduleCallable(callable).continueWithTask(zzap.zza(), zzg.zza);
    }
}
