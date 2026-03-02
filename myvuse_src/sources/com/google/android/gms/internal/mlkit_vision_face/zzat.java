package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzat<K, V> extends zzab<K, V> implements Serializable {

    @NullableDecl
    final K zza;

    @NullableDecl
    final V zzb;

    zzat(@NullableDecl K k, @NullableDecl V v) {
        this.zza = k;
        this.zzb = v;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzab, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzab, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzab, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
