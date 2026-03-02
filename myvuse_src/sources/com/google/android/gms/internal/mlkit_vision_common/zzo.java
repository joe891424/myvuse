package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzo<E> extends zzk<E> implements List<E>, RandomAccess {
    private static final zzr<Object> zza = new zzm(zzp.zza, 0);

    zzo() {
    }

    public static <E> zzo<E> zzg(E e) {
        Object[] objArr = {e};
        if (objArr[0] != null) {
            return zzh(objArr, 1);
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index 0");
        throw new NullPointerException(sb.toString());
    }

    static <E> zzo<E> zzh(Object[] objArr, int i) {
        return i == 0 ? (zzo<E>) zzp.zza : new zzp(objArr, i);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzb.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it2 = iterator();
                Iterator<E> it3 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it3.hasNext() || !zzb.zza(it2.next(), it3.next())) {
                            break;
                        }
                    } else if (!it3.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzk
    /* JADX INFO: renamed from: zza */
    public final zzq<E> iterator() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzk
    int zze(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public zzo<E> subList(int i, int i2) {
        zzf.zzc(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? (zzo<E>) zzp.zza : new zzn(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzr<E> listIterator(int i) {
        zzf.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? (zzr<E>) zza : new zzm(this, i);
    }
}
