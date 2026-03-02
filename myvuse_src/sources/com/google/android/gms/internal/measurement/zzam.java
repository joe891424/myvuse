package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzam implements Iterator<zzaq> {
    private final /* synthetic */ Iterator zza;

    @Override // java.util.Iterator
    public final /* synthetic */ zzaq next() {
        return new zzas((String) this.zza.next());
    }

    zzam(Iterator it2) {
        this.zza = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
