package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgi extends zzhh {
    private final Context zza;

    @Nullable
    private final Supplier<Optional<zzgu>> zzb;

    public final int hashCode() {
        int iHashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        Supplier<Optional<zzgu>> supplier = this.zzb;
        return iHashCode ^ (supplier == null ? 0 : supplier.hashCode());
    }

    @Override // com.google.android.gms.internal.measurement.zzhh
    final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhh
    @Nullable
    final Supplier<Optional<zzgu>> zzb() {
        return this.zzb;
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.zza) + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    zzgi(Context context, @Nullable Supplier<Optional<zzgu>> supplier) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = supplier;
    }

    public final boolean equals(Object obj) {
        Supplier<Optional<zzgu>> supplier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhh) {
            zzhh zzhhVar = (zzhh) obj;
            if (this.zza.equals(zzhhVar.zza()) && ((supplier = this.zzb) != null ? supplier.equals(zzhhVar.zzb()) : zzhhVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }
}
