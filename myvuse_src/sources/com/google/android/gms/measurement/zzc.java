package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zziu;
import com.google.android.gms.measurement.internal.zziv;
import com.google.android.gms.measurement.internal.zzkk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzc extends AppMeasurement.zza {
    private final zzkk zza;

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final int zza(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Boolean zzb() {
        return (Boolean) this.zza.zza(4);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Double zzc() {
        return (Double) this.zza.zza(2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Integer zzd() {
        return (Integer) this.zza.zza(3);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Long zze() {
        return (Long) this.zza.zza(1);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final String zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final String zzg() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final String zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final String zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final String zzj() {
        return (String) this.zza.zza(0);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final List<Bundle> zza(String str, String str2) {
        return this.zza.zza(str, str2);
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Map<String, Object> zza(boolean z) {
        return this.zza.zza((String) null, (String) null, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    public zzc(zzkk zzkkVar) {
        super();
        Preconditions.checkNotNull(zzkkVar);
        this.zza = zzkkVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zzb(String str) {
        this.zza.zzb(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zzc(String str) {
        this.zza.zzc(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zza(zziu zziuVar) {
        this.zza.zza(zziuVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zza(Bundle bundle) {
        this.zza.zza(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zza(zziv zzivVar) {
        this.zza.zza(zzivVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkk
    public final void zzb(zziu zziuVar) {
        this.zza.zzb(zziuVar);
    }
}
