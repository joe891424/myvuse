package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpc implements Supplier<zzpb> {
    private static zzpc zza = new zzpc();
    private final Supplier<zzpb> zzb = Suppliers.ofInstance(new zzpe());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpb get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpb) zza.get()).zza();
    }
}
