package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzox implements Supplier<zzpa> {
    private static zzox zza = new zzox();
    private final Supplier<zzpa> zzb = Suppliers.ofInstance(new zzoz());

    @SideEffectFree
    public static double zza() {
        return ((zzpa) zza.get()).zza();
    }

    @SideEffectFree
    public static long zzb() {
        return ((zzpa) zza.get()).zzb();
    }

    @SideEffectFree
    public static long zzc() {
        return ((zzpa) zza.get()).zzc();
    }

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpa get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static String zzd() {
        return ((zzpa) zza.get()).zzd();
    }

    @SideEffectFree
    public static boolean zze() {
        return ((zzpa) zza.get()).zze();
    }
}
