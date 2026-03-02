package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
class zzz extends zzx implements List {
    final /* synthetic */ zzaa zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzz(@NullableDecl zzaa zzaaVar, Object obj, @NullableDecl List list, zzx zzxVar) {
        super(zzaaVar, obj, list, zzxVar);
        this.zzf = zzaaVar;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        zza();
        boolean zIsEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzaa.zzl(this.zzf);
        if (zIsEmpty) {
            zzc();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.zzb).addAll(i, collection);
        if (!zAddAll) {
            return zAddAll;
        }
        zzaa.zzm(this.zzf, this.zzb.size() - size);
        if (size != 0) {
            return zAddAll;
        }
        zzc();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zza();
        return ((List) this.zzb).get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        zza();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        zza();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zza();
        return new zzy(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        zza();
        Object objRemove = ((List) this.zzb).remove(i);
        zzaa.zzk(this.zzf);
        zzb();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        zza();
        return ((List) this.zzb).set(i, obj);
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        zza();
        zzaa zzaaVar = this.zzf;
        Object obj = this.zza;
        List listSubList = ((List) this.zzb).subList(i, i2);
        zzx zzxVar = this.zzc;
        if (zzxVar == null) {
            zzxVar = this;
        }
        return zzaaVar.zzg(obj, listSubList, zzxVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        zza();
        return new zzy(this, i);
    }
}
