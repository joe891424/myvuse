package com.google.mlkit.vision.common.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class MobileVisionBase<DetectionResultT> implements Closeable, LifecycleObserver {
    public static final /* synthetic */ int zza = 0;
    private static final GmsLogger zzb = new GmsLogger("MobileVisionBase", "");
    private final AtomicBoolean zzc = new AtomicBoolean(false);
    private final MLTask<DetectionResultT, InputImage> zzd;
    private final CancellationTokenSource zze;
    private final Executor zzf;

    public MobileVisionBase(MLTask<DetectionResultT, InputImage> mLTask, Executor executor) {
        this.zzd = mLTask;
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        this.zze = cancellationTokenSource;
        this.zzf = executor;
        mLTask.pin();
        mLTask.callAfterLoad(executor, zza.zza, cancellationTokenSource.getToken()).addOnFailureListener(zzb.zza);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.zzc.getAndSet(true)) {
            return;
        }
        this.zze.cancel();
        this.zzd.unpin(this.zzf);
    }

    public synchronized Task<DetectionResultT> processBase(final InputImage inputImage) {
        Preconditions.checkNotNull(inputImage, "InputImage can not be null");
        if (this.zzc.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        }
        if (inputImage.getWidth() < 32 || inputImage.getHeight() < 32) {
            return Tasks.forException(new MlKitException("InputImage width and height should be at least 32!", 3));
        }
        return this.zzd.callAfterLoad(this.zzf, new Callable(this, inputImage) { // from class: com.google.mlkit.vision.common.internal.zzc
            private final MobileVisionBase zza;
            private final InputImage zzb;

            {
                this.zza = this;
                this.zzb = inputImage;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(this.zzb);
            }
        }, this.zze.getToken());
    }

    final /* synthetic */ Object zza(InputImage inputImage) throws Exception {
        return this.zzd.run(inputImage);
    }
}
