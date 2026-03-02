package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpd implements Supplier<zzpg> {
    private static zzpd zza = new zzpd();
    private final Supplier<zzpg> zzb = Suppliers.ofInstance(new zzpf());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpg get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpg) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzpg) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzpg) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzpg) zza.get()).zzd();
    }

    @SideEffectFree
    public static boolean zze() {
        return ((zzpg) zza.get()).zze();
    }

    @SideEffectFree
    public static boolean zzf() {
        return ((zzpg) zza.get()).zzf();
    }

    @SideEffectFree
    public static boolean zzg() {
        return ((zzpg) zza.get()).zzg();
    }

    @SideEffectFree
    public static boolean zzh() {
        return ((zzpg) zza.get()).zzh();
    }
}
