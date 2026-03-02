package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzq extends zzbc {
    final /* synthetic */ zzs zza;

    zzq(zzs zzsVar) {
        this.zza = zzsVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbc, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Set setEntrySet = this.zza.zza.entrySet();
        setEntrySet.getClass();
        try {
            return setEntrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry> iterator() {
        return new zzr(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbc, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        zzaa.zzo(this.zza.zzb, ((Map.Entry) obj).getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbc
    final Map zza() {
        return this.zza;
    }
}
