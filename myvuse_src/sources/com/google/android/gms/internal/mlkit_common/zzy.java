package com.google.android.gms.internal.mlkit_common;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzy {
    private static final Logger zza = Logger.getLogger(zzy.class.getName());
    private static final zzx zzb = new zzx(null);

    private zzy() {
    }

    static boolean zza(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static String zzb(@NullableDecl String str) {
        return str == null ? "" : str;
    }
}
