package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzow implements Supplier<zzov> {
    private static zzow zza = new zzow();
    private final Supplier<zzov> zzb = Suppliers.ofInstance(new zzoy());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzov get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzov) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzov) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzov) zza.get()).zzc();
    }
}
