package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzix {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    com.google.android.gms.internal.measurement.zzdl zzg;
    boolean zzh;
    Long zzi;
    String zzj;

    public zzix(Context context, com.google.android.gms.internal.measurement.zzdl zzdlVar, Long l) {
        this.zzh = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzdlVar != null) {
            this.zzg = zzdlVar;
            this.zzb = zzdlVar.zzf;
            this.zzc = zzdlVar.zze;
            this.zzd = zzdlVar.zzd;
            this.zzh = zzdlVar.zzc;
            this.zzf = zzdlVar.zzb;
            this.zzj = zzdlVar.zzh;
            if (zzdlVar.zzg != null) {
                this.zze = Boolean.valueOf(zzdlVar.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
