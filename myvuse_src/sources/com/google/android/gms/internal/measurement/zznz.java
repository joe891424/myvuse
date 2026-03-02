package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznz implements Supplier<zzoc> {
    private static zznz zza = new zznz();
    private final Supplier<zzoc> zzb = Suppliers.ofInstance(new zzob());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoc get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzoc) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzoc) zza.get()).zzb();
    }

    @SideEffectFree
    public static boolean zzc() {
        return ((zzoc) zza.get()).zzc();
    }

    @SideEffectFree
    public static boolean zzd() {
        return ((zzoc) zza.get()).zzd();
    }
}
