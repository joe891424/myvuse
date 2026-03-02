package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzpo;
import java.util.HashMap;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzna extends zzmy {
    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final Pair<zznd, Boolean> zza(String str) {
        zzf zzfVarZze;
        if (zzpo.zza() && zze().zza(zzbh.zzbu)) {
            zzq();
            if (zznt.zzf(str)) {
                zzj().zzp().zza("sgtm feature flag enabled.");
                zzf zzfVarZze2 = zzh().zze(str);
                if (zzfVarZze2 != null) {
                    String strZzad = zzfVarZze2.zzad();
                    zzfj.zzd zzdVarZzc = zzm().zzc(str);
                    if (zzdVarZzc != null && (zzfVarZze = zzh().zze(str)) != null && ((zzdVarZzc.zzr() && zzdVarZzc.zzh().zza() == 100) || zzq().zzd(str, zzfVarZze.zzam()) || (!TextUtils.isEmpty(strZzad) && strZzad.hashCode() % 100 < zzdVarZzc.zzh().zza()))) {
                        zznd zzndVar = null;
                        if (zzfVarZze2.zzat()) {
                            zzj().zzp().zza("sgtm upload enabled in manifest.");
                            zzfj.zzd zzdVarZzc2 = zzm().zzc(zzfVarZze2.zzac());
                            if (zzdVarZzc2 != null && zzdVarZzc2.zzr()) {
                                String strZze = zzdVarZzc2.zzh().zze();
                                if (!TextUtils.isEmpty(strZze)) {
                                    String strZzd = zzdVarZzc2.zzh().zzd();
                                    zzj().zzp().zza("sgtm configured with upload_url, server_info", strZze, TextUtils.isEmpty(strZzd) ? "Y" : "N");
                                    if (TextUtils.isEmpty(strZzd)) {
                                        zzndVar = new zznd(strZze);
                                    } else {
                                        HashMap map = new HashMap();
                                        map.put("x-sgtm-server-info", strZzd);
                                        if (!TextUtils.isEmpty(zzfVarZze2.zzam())) {
                                            map.put("x-gtm-server-preview", zzfVarZze2.zzam());
                                        }
                                        zzndVar = new zznd(strZze, map);
                                    }
                                }
                            }
                        }
                        if (zzndVar != null) {
                            return Pair.create(zzndVar, false);
                        }
                    }
                }
                return Pair.create(new zznd(zzb(str)), true);
            }
        }
        return Pair.create(new zznd(zzb(str)), true);
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzs zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzfv zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzfw zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzgl zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzgw zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzhg zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzmc zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzna zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    /* JADX INFO: renamed from: g_ */
    public final /* bridge */ /* synthetic */ zznp mo2390g_() {
        return super.mo2390g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    private final String zzb(String str) throws Throwable {
        String strZzf = zzm().zzf(str);
        if (!TextUtils.isEmpty(strZzf)) {
            Uri uri = Uri.parse(zzbh.zzq.zza(null));
            Uri.Builder builderBuildUpon = uri.buildUpon();
            builderBuildUpon.authority(strZzf + "." + uri.getAuthority());
            return builderBuildUpon.build().toString();
        }
        return zzbh.zzq.zza(null);
    }

    zzna(zznc zzncVar) {
        super(zzncVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }
}
