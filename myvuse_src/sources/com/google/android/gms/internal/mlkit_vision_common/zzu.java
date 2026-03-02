package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzu {
    private final ConcurrentHashMap<zzt, List<Throwable>> zza = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzb = new ReferenceQueue<>();

    zzu() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        ReferenceQueue<Throwable> referenceQueue = this.zzb;
        while (true) {
            Reference<? extends Throwable> referencePoll = referenceQueue.poll();
            if (referencePoll == null) {
                break;
            }
            this.zza.remove(referencePoll);
            referenceQueue = this.zzb;
        }
        List<Throwable> list = this.zza.get(new zzt(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> listPutIfAbsent = this.zza.putIfAbsent(new zzt(th, this.zzb), vector);
        return listPutIfAbsent == null ? vector : listPutIfAbsent;
    }
}
