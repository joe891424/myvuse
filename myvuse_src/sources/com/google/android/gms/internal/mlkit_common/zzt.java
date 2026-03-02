package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzt {
    private final String zza;
    private final zzs zzb;
    private zzs zzc;

    /* synthetic */ zzt(String str, zzr zzrVar) {
        zzs zzsVar = new zzs(null);
        this.zzb = zzsVar;
        this.zzc = zzsVar;
        str.getClass();
        this.zza = str;
    }

    private final zzt zzc(String str, @NullableDecl Object obj) {
        zzs zzsVar = new zzs(null);
        this.zzc.zzc = zzsVar;
        this.zzc = zzsVar;
        zzsVar.zzb = obj;
        zzsVar.zza = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzs zzsVar = this.zzb.zzc;
        String str = "";
        while (zzsVar != null) {
            Object obj = zzsVar.zzb;
            sb.append(str);
            String str2 = zzsVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzsVar = zzsVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzt zza(String str, @NullableDecl Object obj) {
        zzc(str, obj);
        return this;
    }

    public final zzt zzb(String str, boolean z) {
        zzc("isManifestFile", String.valueOf(z));
        return this;
    }
}
