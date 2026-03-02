package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import androidx.core.content.PermissionChecker;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgp implements zzgo {
    private static zzgp zza;

    @Nullable
    private final Context zzb;

    @Nullable
    private final ContentObserver zzc;

    static zzgp zza(Context context) {
        zzgp zzgpVar;
        synchronized (zzgp.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzgp(context) : new zzgp();
            }
            zzgpVar = zza;
        }
        return zzgpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzgo
    @Nullable
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        Context context = this.zzb;
        if (context != null && !zzgf.zza(context)) {
            try {
                return (String) zzgn.zza(new zzgq() { // from class: com.google.android.gms.internal.measurement.zzgs
                    @Override // com.google.android.gms.internal.measurement.zzgq
                    public final Object zza() {
                        return this.zza.zzb(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                LogInstrumentation.m2729e("GservicesLoader", "Unable to read GServices for: " + str, e);
            }
        }
        return null;
    }

    final /* synthetic */ String zzb(String str) {
        return zzfw.zza(this.zzb.getContentResolver(), str, null);
    }

    private zzgp() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzgp(Context context) {
        this.zzb = context;
        zzgr zzgrVar = new zzgr(this, null);
        this.zzc = zzgrVar;
        context.getContentResolver().registerContentObserver(zzfv.zza, true, zzgrVar);
    }

    static synchronized void zza() {
        Context context;
        zzgp zzgpVar = zza;
        if (zzgpVar != null && (context = zzgpVar.zzb) != null && zzgpVar.zzc != null) {
            context.getContentResolver().unregisterContentObserver(zza.zzc);
        }
        zza = null;
    }
}
