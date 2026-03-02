package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzoq implements Supplier<zzop> {
    private static zzoq zza = new zzoq();
    private final Supplier<zzop> zzb = Suppliers.ofInstance(new zzos());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzop get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzop) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzop) zza.get()).zzb();
    }
}
