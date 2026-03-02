package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbj<E> extends zzax<E> {
    static final zzax<Object> zza = new zzbj(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzbj(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzl.zzb(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return (E) this.zzb[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzas
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzas
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzas
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzax, com.google.android.gms.internal.mlkit_vision_face.zzas
    final int zze(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
