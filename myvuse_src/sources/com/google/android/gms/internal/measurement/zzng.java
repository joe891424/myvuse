package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzng implements Supplier<zznf> {
    private static zzng zza = new zzng();
    private final Supplier<zznf> zzb = Suppliers.ofInstance(new zzni());

    @SideEffectFree
    public static long zza() {
        return ((zznf) zza.get()).zza();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznf get() {
        return this.zzb.get();
    }
}
