package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzns implements Supplier<zznr> {
    private static zzns zza = new zzns();
    private final Supplier<zznr> zzb = Suppliers.ofInstance(new zznu());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznr get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zznr) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zznr) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zznr) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zznr) zza.get()).zzd();
    }
}
