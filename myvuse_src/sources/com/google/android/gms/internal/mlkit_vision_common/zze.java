package com.google.android.gms.internal.mlkit_vision_common;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zze {
    private static final Logger zza = Logger.getLogger(zze.class.getName());
    private static final zzd zzb = new zzd(null);

    private zze() {
    }

    static boolean zza(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }
}
