package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlr extends zzlu {
    private final /* synthetic */ zzln zza;

    @Override // com.google.android.gms.internal.measurement.zzlu, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzlp(this.zza);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzlr(zzln zzlnVar) {
        super(zzlnVar);
        this.zza = zzlnVar;
    }
}
