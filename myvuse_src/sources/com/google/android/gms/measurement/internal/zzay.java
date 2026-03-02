package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzay {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzba zze;
    private final String zzf;

    final zzay zza(zzhj zzhjVar, long j) {
        return new zzay(zzhjVar, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        return "Event{appId='" + this.zza + "', name='" + this.zzb + "', params=" + String.valueOf(this.zze) + "}";
    }

    zzay(zzhj zzhjVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzba zzbaVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzhjVar.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId", zzfw.zza(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it2 = bundle2.keySet().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (next == null) {
                    zzhjVar.zzj().zzg().zza("Param name can't be null");
                    it2.remove();
                } else {
                    Object objZzb = zzhjVar.zzt().zzb(next, bundle2.get(next));
                    if (objZzb == null) {
                        zzhjVar.zzj().zzu().zza("Param value can't be null", zzhjVar.zzk().zzb(next));
                        it2.remove();
                    } else {
                        zzhjVar.zzt().zza(bundle2, next, objZzb);
                    }
                }
            }
            zzbaVar = new zzba(bundle2);
        } else {
            zzbaVar = new zzba(new Bundle());
        }
        this.zze = zzbaVar;
    }

    private zzay(zzhj zzhjVar, String str, String str2, String str3, long j, long j2, zzba zzbaVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbaVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzhjVar.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId, name", zzfw.zza(str2), zzfw.zza(str3));
        }
        this.zze = zzbaVar;
    }
}
