package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzbm<F, T> implements Iterator<T> {
    final Iterator<? extends F> zza;

    zzbm(Iterator<? extends F> it2) {
        it2.getClass();
        this.zza = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return zza(this.zza.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }

    abstract T zza(F f);
}
