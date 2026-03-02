package com.google.android.gms.internal.mlkit_vision_face;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzm<T> extends zzh<T> {
    private final T zza;

    zzm(T t) {
        this.zza = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzm) {
            return this.zza.equals(((zzm) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzh
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzh
    public final T zzb(T t) {
        return this.zza;
    }
}
