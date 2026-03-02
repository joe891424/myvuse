package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzof implements Supplier<zzoi> {
    private static zzof zza = new zzof();
    private final Supplier<zzoi> zzb = Suppliers.ofInstance(new zzoh());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzoi get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzoi) zza.get()).zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return ((zzoi) zza.get()).zzb();
    }
}
