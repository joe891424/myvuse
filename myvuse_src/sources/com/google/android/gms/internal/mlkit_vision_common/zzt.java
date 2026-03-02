package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzt extends WeakReference<Throwable> {
    private final int zza;

    public zzt(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzt zztVar = (zzt) obj;
            if (this.zza == zztVar.zza && get() == zztVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }
}
