package com.google.android.gms.internal.mlkit_vision_face;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzav<E> extends zzo<E> {
    private final zzax<E> zza;

    zzav(zzax<E> zzaxVar, int i) {
        super(zzaxVar.size(), i);
        this.zza = zzaxVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzo
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
