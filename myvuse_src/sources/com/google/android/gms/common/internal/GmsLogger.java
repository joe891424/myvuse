package com.google.android.gms.common.internal;

import android.util.Log;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class GmsLogger {
    private final String zza;
    private final String zzb;

    public GmsLogger(String str) {
        this(str, null);
    }

    private final String zza(String str) {
        String str2 = this.zzb;
        return str2 == null ? str : str2.concat(str);
    }

    private final String zzb(String str, Object... objArr) {
        String str2 = this.zzb;
        String str3 = String.format(str, objArr);
        return str2 == null ? str3 : str2.concat(str3);
    }

    public boolean canLog(int i) {
        return Log.isLoggable(this.zza, i);
    }

    public boolean canLogPii() {
        return false;
    }

    /* JADX INFO: renamed from: d */
    public void m2357d(String str, String str2) {
        if (canLog(3)) {
            LogInstrumentation.m2726d(str, zza(str2));
        }
    }

    /* JADX INFO: renamed from: e */
    public void m2359e(String str, String str2) {
        if (canLog(6)) {
            LogInstrumentation.m2728e(str, zza(str2));
        }
    }

    public void efmt(String str, String str2, Object... objArr) {
        if (canLog(6)) {
            LogInstrumentation.m2728e(str, zzb(str2, objArr));
        }
    }

    /* JADX INFO: renamed from: i */
    public void m2361i(String str, String str2) {
        if (canLog(4)) {
            LogInstrumentation.m2730i(str, zza(str2));
        }
    }

    public void pii(String str, String str2) {
    }

    public void pii(String str, String str2, Throwable th) {
    }

    /* JADX INFO: renamed from: v */
    public void m2363v(String str, String str2) {
        if (canLog(2)) {
            LogInstrumentation.m2732v(str, zza(str2));
        }
    }

    /* JADX INFO: renamed from: w */
    public void m2365w(String str, String str2) {
        if (canLog(5)) {
            LogInstrumentation.m2734w(str, zza(str2));
        }
    }

    public void wfmt(String str, String str2, Object... objArr) {
        if (canLog(5)) {
            LogInstrumentation.m2734w(this.zza, zzb(str2, objArr));
        }
    }

    public void wtf(String str, String str2, Throwable th) {
        if (canLog(7)) {
            LogInstrumentation.m2729e(str, zza(str2), th);
            Log.wtf(str, zza(str2), th);
        }
    }

    public GmsLogger(String str, String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    /* JADX INFO: renamed from: d */
    public void m2358d(String str, String str2, Throwable th) {
        if (canLog(3)) {
            LogInstrumentation.m2727d(str, zza(str2), th);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m2360e(String str, String str2, Throwable th) {
        if (canLog(6)) {
            LogInstrumentation.m2729e(str, zza(str2), th);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m2362i(String str, String str2, Throwable th) {
        if (canLog(4)) {
            LogInstrumentation.m2731i(str, zza(str2), th);
        }
    }

    /* JADX INFO: renamed from: v */
    public void m2364v(String str, String str2, Throwable th) {
        if (canLog(2)) {
            LogInstrumentation.m2733v(str, zza(str2), th);
        }
    }

    /* JADX INFO: renamed from: w */
    public void m2366w(String str, String str2, Throwable th) {
        if (canLog(5)) {
            LogInstrumentation.m2735w(str, zza(str2), th);
        }
    }
}
