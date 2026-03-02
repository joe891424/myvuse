package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpv implements Supplier<zzpy> {
    private static zzpv zza = new zzpv();
    private final Supplier<zzpy> zzb = Suppliers.ofInstance(new zzpx());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzpy get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzpy) zza.get()).zza();
    }
}
