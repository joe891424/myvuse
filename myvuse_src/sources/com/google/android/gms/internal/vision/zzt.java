package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.vision.C2304L;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzt<T> {
    private final Context zza;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private T zzh;
    private final Object zzb = new Object();
    private boolean zzf = false;
    private boolean zzg = false;

    public zzt(Context context, String str, String str2) {
        this.zza = context;
        this.zzc = str;
        String strValueOf = String.valueOf("com.google.android.gms.vision.dynamite.");
        String strValueOf2 = String.valueOf(str2);
        this.zzd = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        this.zze = str2;
    }

    protected abstract T zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException;

    protected abstract void zza() throws RemoteException;

    public final boolean zzb() {
        return zzd() != null;
    }

    public final void zzc() {
        synchronized (this.zzb) {
            if (this.zzh == null) {
                return;
            }
            try {
                zza();
            } catch (RemoteException e) {
                LogInstrumentation.m2729e(this.zzc, "Could not finalize native handle", e);
            }
        }
    }

    @RequiresNonNull({"context", "thickFeatureName", "featureName"})
    protected final T zzd() {
        DynamiteModule dynamiteModuleLoad;
        synchronized (this.zzb) {
            T t = this.zzh;
            if (t != null) {
                return t;
            }
            try {
                dynamiteModuleLoad = DynamiteModule.load(this.zza, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, this.zzd);
            } catch (DynamiteModule.LoadingException unused) {
                String str = String.format("%s.%s", "com.google.android.gms.vision", this.zze);
                C2304L.m2392d("Cannot load thick client module, fall back to load optional module %s", str);
                try {
                    dynamiteModuleLoad = DynamiteModule.load(this.zza, DynamiteModule.PREFER_REMOTE, str);
                } catch (DynamiteModule.LoadingException e) {
                    C2304L.m2395e(e, "Error loading optional module %s", str);
                    if (!this.zzf) {
                        C2304L.m2392d("Broadcasting download intent for dependency %s", this.zze);
                        String str2 = this.zze;
                        Intent intent = new Intent();
                        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
                        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", str2);
                        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
                        this.zza.sendBroadcast(intent);
                        this.zzf = true;
                    }
                    dynamiteModuleLoad = null;
                }
            }
            if (dynamiteModuleLoad != null) {
                try {
                    this.zzh = zza(dynamiteModuleLoad, this.zza);
                } catch (RemoteException | DynamiteModule.LoadingException e2) {
                    LogInstrumentation.m2729e(this.zzc, "Error creating remote native handle", e2);
                }
            }
            boolean z = this.zzg;
            if (!z && this.zzh == null) {
                LogInstrumentation.m2734w(this.zzc, "Native handle not yet available. Reverting to no-op handle.");
                this.zzg = true;
            } else if (z && this.zzh != null) {
                LogInstrumentation.m2734w(this.zzc, "Native handle is now available.");
            }
            return this.zzh;
        }
    }
}
