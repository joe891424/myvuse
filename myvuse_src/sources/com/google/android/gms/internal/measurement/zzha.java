package com.google.android.gms.internal.measurement;

import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzha extends zzgw<Long> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzgw
    @Nullable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        LogInstrumentation.m2728e("PhenotypeFlag", "Invalid long value for " + super.zzb() + ": " + String.valueOf(obj));
        return null;
    }

    zzha(zzhe zzheVar, String str, Long l, boolean z) {
        super(zzheVar, str, l);
    }
}
