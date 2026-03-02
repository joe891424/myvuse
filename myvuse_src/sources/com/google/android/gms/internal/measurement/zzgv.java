package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import com.google.common.base.Optional;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgv {
    private static volatile Optional<Boolean> zza = Optional.absent();
    private static final Object zzb = new Object();

    private static boolean zza(Context context) {
        return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0;
    }

    public static boolean zza(Context context, Uri uri) {
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            LogInstrumentation.m2728e("PhenotypeClientHelper", authority + " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            return false;
        }
        if (zza.isPresent()) {
            return zza.get().booleanValue();
        }
        synchronized (zzb) {
            if (zza.isPresent()) {
                return zza.get().booleanValue();
            }
            if (!"com.google.android.gms".equals(context.getPackageName())) {
                ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", Build.VERSION.SDK_INT < 29 ? 0 : 268435456);
                if (providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                }
                zza = Optional.m2408of(Boolean.valueOf(z));
                return zza.get().booleanValue();
            }
            if (zza(context)) {
                z = true;
            }
            zza = Optional.m2408of(Boolean.valueOf(z));
            return zza.get().booleanValue();
        }
    }
}
