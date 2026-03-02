package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbl {
    static boolean zza(Set<?> set, Iterator<?> it2) {
        boolean zRemove = false;
        while (it2.hasNext()) {
            zRemove |= set.remove(it2.next());
        }
        return true == zRemove;
    }

    static boolean zzb(Set<?> set, Collection<?> collection) {
        collection.getClass();
        if (collection instanceof zzbi) {
            collection = ((zzbi) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zza(set, collection.iterator());
        }
        Iterator<?> it2 = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }
}
