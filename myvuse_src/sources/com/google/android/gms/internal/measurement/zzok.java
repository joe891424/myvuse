package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzok implements Supplier<zzoj> {
    private static zzok zza = new zzok();
    private final Supplier<zzoj> zzb = Suppliers.ofInstance(new zzom());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoj get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzoj) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzoj) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzoj) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzoj) zza.get()).zzd();
    }

    @SideEffectFree
    public static boolean zze() {
        return ((zzoj) zza.get()).zze();
    }
}
