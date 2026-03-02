package com.google.android.gms.internal.measurement;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhd extends zzgw<Boolean> {
    @Override // com.google.android.gms.internal.measurement.zzgw
    @Nullable
    final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzfv.zzc.matcher(str).matches()) {
                return true;
            }
            if (zzfv.zzd.matcher(str).matches()) {
                return false;
            }
        }
        LogInstrumentation.m2728e("PhenotypeFlag", "Invalid boolean value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }

    zzhd(zzhe zzheVar, String str, Boolean bool, boolean z) {
        super(zzheVar, str, bool);
    }
}
