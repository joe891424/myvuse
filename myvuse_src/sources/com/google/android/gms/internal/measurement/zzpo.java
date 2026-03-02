package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpo implements Supplier<zzpn> {
    private static zzpo zza = new zzpo();
    private final Supplier<zzpn> zzb = Suppliers.ofInstance(new zzpq());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpn get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpn) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzpn) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzpn) zza.get()).zzc();
    }
}
