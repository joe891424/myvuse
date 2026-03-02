package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zze {
    private final String zza;
    private final zzd zzb;
    private zzd zzc;

    /* synthetic */ zze(String str, zzc zzcVar) {
        zzd zzdVar = new zzd(null);
        this.zzb = zzdVar;
        this.zzc = zzdVar;
        this.zza = str;
    }

    private final zze zze(String str, @NullableDecl Object obj) {
        zzd zzdVar = new zzd(null);
        this.zzc.zzc = zzdVar;
        this.zzc = zzdVar;
        zzdVar.zzb = obj;
        str.getClass();
        zzdVar.zza = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzd zzdVar = this.zzb.zzc;
        String str = "";
        while (zzdVar != null) {
            Object obj = zzdVar.zzb;
            sb.append(str);
            String str2 = zzdVar.zza;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r2.length() - 1);
            }
            zzdVar = zzdVar.zzc;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zze zza(String str, @NullableDecl Object obj) {
        zze(str, obj);
        return this;
    }

    public final zze zzb(String str, boolean z) {
        zze("trackingEnabled", String.valueOf(z));
        return this;
    }

    public final zze zzc(String str, float f) {
        zze(str, String.valueOf(f));
        return this;
    }

    public final zze zzd(String str, int i) {
        zze(str, String.valueOf(i));
        return this;
    }
}
