package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhl {
    private final boolean zza;

    public zzhl(zzhk zzhkVar) {
        Preconditions.checkNotNull(zzhkVar, "BuildInfo must be non-null");
        this.zza = !zzhkVar.zza();
    }

    public final boolean zza(String str) {
        Preconditions.checkNotNull(str, "flagName must not be null");
        if (this.zza) {
            return zzhn.zza.get().containsValue(str);
        }
        return true;
    }
}
