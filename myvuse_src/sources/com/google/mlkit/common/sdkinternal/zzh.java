package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
enum zzh implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        MLTaskExecutor.getInstance().zzc.post(runnable);
    }
}
