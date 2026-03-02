package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznb implements Supplier<zzne> {
    private static zznb zza = new zznb();
    private final Supplier<zzne> zzb = Suppliers.ofInstance(new zznd());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzne get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzne) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzne) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzne) zza.get()).zzc();
    }
}
