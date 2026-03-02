package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzal extends zzab {
    final /* synthetic */ zzan zza;

    @NullableDecl
    private final Object zzb;
    private int zzc;

    zzal(zzan zzanVar, int i) {
        this.zza = zzanVar;
        this.zzb = zzanVar.zzb[i];
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i == -1 || i >= this.zza.size() || !zzg.zza(this.zzb, this.zza.zzb[this.zzc])) {
            this.zzc = this.zza.zzr(this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzab, java.util.Map.Entry
    @NullableDecl
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzab, java.util.Map.Entry
    @NullableDecl
    public final Object getValue() {
        Map mapZzc = this.zza.zzc();
        if (mapZzc != null) {
            return mapZzc.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return this.zza.zzc[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzab, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapZzc = this.zza.zzc();
        if (mapZzc != null) {
            return mapZzc.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object[] objArr = this.zza.zzc;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }
}
