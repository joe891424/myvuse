package com.google.android.gms.internal.mlkit_vision_face;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzy extends zzw implements ListIterator {
    final /* synthetic */ zzz zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(zzz zzzVar) {
        super(zzzVar);
        this.zzd = zzzVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean zIsEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzaa.zzl(this.zzd.zzf);
        if (zIsEmpty) {
            this.zzd.zzc();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(zzz zzzVar, int i) {
        super(zzzVar, ((List) zzzVar.zzb).listIterator(i));
        this.zzd = zzzVar;
    }
}
