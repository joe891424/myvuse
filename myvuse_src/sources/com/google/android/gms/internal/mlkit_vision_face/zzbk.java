package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractSet;
import java.util.Collection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzbk<E> extends AbstractSet<E> {
    zzbk() {
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return zzbl.zzb(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        collection.getClass();
        return super.retainAll(collection);
    }
}
