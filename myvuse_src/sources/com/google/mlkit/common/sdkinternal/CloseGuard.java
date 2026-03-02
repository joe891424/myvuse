package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfz;
import com.google.android.gms.internal.mlkit_common.zzgb;
import com.google.android.gms.internal.mlkit_common.zzhx;
import com.google.android.gms.internal.mlkit_common.zzic;
import com.google.android.gms.internal.mlkit_common.zzim;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.Closeable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class CloseGuard implements Closeable {
    public static final int API_TRANSLATE = 1;
    private final AtomicBoolean zza = new AtomicBoolean();
    private final String zzb;
    private final Cleaner.Cleanable zzc;

    /* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
    public static class Factory {
        private final Cleaner zza;

        public Factory(Cleaner cleaner) {
            this.zza = cleaner;
        }

        public CloseGuard create(Object obj, int i, Runnable runnable) {
            return new CloseGuard(obj, i, this.zza, runnable, zzim.zza("common"));
        }
    }

    CloseGuard(Object obj, final int i, Cleaner cleaner, final Runnable runnable, final zzic zzicVar) {
        this.zzb = obj.toString();
        this.zzc = cleaner.register(obj, new Runnable(this, i, zzicVar, runnable) { // from class: com.google.mlkit.common.sdkinternal.zze
            private final CloseGuard zza;
            private final int zzb;
            private final zzic zzc;
            private final Runnable zzd;

            {
                this.zza = this;
                this.zzb = i;
                this.zzc = zzicVar;
                this.zzd = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc, this.zzd);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.set(true);
        this.zzc.clean();
    }

    final /* synthetic */ void zza(int i, zzic zzicVar, Runnable runnable) {
        if (!this.zza.get()) {
            LogInstrumentation.m2728e("MlKitCloseGuard", String.format(Locale.ENGLISH, "%s has not been closed", this.zzb));
            zzgb zzgbVar = new zzgb();
            zzfw zzfwVar = new zzfw();
            zzfwVar.zza(zzfv.zza(i));
            zzgbVar.zzf(zzfwVar.zzb());
            zzicVar.zza(zzhx.zzc(zzgbVar), zzfz.HANDLE_LEAKED);
        }
        runnable.run();
    }
}
