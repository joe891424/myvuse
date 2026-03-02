package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznh implements Supplier<zznk> {
    private static zznh zza = new zznh();
    private final Supplier<zznk> zzb = Suppliers.ofInstance(new zznj());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zznk get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zznk) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zznk) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zznk) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zznk) zza.get()).zzd();
    }
}
