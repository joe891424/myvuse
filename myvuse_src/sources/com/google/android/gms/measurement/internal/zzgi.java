package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgi {
    private final zziq zza;

    static zzgi zza(String str) {
        return new zzgi((TextUtils.isEmpty(str) || str.length() > 1) ? zziq.UNINITIALIZED : zzin.zza(str.charAt(0)));
    }

    final zziq zza() {
        return this.zza;
    }

    final String zzb() {
        return String.valueOf(zzin.zza(this.zza));
    }

    zzgi(zziq zziqVar) {
        this.zza = zziqVar;
    }
}
