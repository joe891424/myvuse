package com.google.android.gms.internal.mlkit_common;

import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzam<E> extends zzal<E> implements ListIterator<E> {
    protected zzam() {
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
