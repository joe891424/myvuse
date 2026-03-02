package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznn implements Supplier<zznq> {
    private static zznn zza = new zznn();
    private final Supplier<zznq> zzb = Suppliers.ofInstance(new zznp());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznq get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zznq) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zznq) zza.get()).zzb();
    }
}
