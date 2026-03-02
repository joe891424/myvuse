package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzoe implements Supplier<zzod> {
    private static zzoe zza = new zzoe();
    private final Supplier<zzod> zzb = Suppliers.ofInstance(new zzog());

    @Override // com.google.common.base.Supplier
    public final /* synthetic */ zzod get() {
        return this.zzb.get();
    }

    @SideEffectFree
    public static boolean zza() {
        return ((zzod) zza.get()).zza();
    }
}
