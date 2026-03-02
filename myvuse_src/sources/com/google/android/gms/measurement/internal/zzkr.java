package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzpi;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkr extends zznb {
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.zznb
    protected final boolean zzc() {
        return false;
    }

    public zzkr(zznc zzncVar) {
        super(zzncVar);
    }

    public final byte[] zza(zzbf zzbfVar, String str) {
        zznq next;
        zzfn.zzj.zza zzaVar;
        Bundle bundle;
        zzfn.zzi.zza zzaVar2;
        zzf zzfVar;
        byte[] bArr;
        long j;
        zzbb zzbbVarZza;
        zzt();
        this.zzu.zzy();
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotEmpty(str);
        if (!zze().zze(str, zzbh.zzbf)) {
            zzj().zzc().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzbfVar.zza) && !"_iapx".equals(zzbfVar.zza)) {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str, zzbfVar.zza);
            return null;
        }
        zzfn.zzi.zza zzaVarZzb = zzfn.zzi.zzb();
        zzh().zzp();
        try {
            zzf zzfVarZze = zzh().zze(str);
            if (zzfVarZze == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzfVarZze.zzar()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            zzfn.zzj.zza zzaVarZzp = zzfn.zzj.zzv().zzh(1).zzp("android");
            if (!TextUtils.isEmpty(zzfVarZze.zzac())) {
                zzaVarZzp.zzb(zzfVarZze.zzac());
            }
            if (!TextUtils.isEmpty(zzfVarZze.zzae())) {
                zzaVarZzp.zzd((String) Preconditions.checkNotNull(zzfVarZze.zzae()));
            }
            if (!TextUtils.isEmpty(zzfVarZze.zzaf())) {
                zzaVarZzp.zze((String) Preconditions.checkNotNull(zzfVarZze.zzaf()));
            }
            if (zzfVarZze.zze() != -2147483648L) {
                zzaVarZzp.zze((int) zzfVarZze.zze());
            }
            zzaVarZzp.zzf(zzfVarZze.zzq()).zzd(zzfVarZze.zzo());
            String strZzah = zzfVarZze.zzah();
            String strZzaa = zzfVarZze.zzaa();
            if (!TextUtils.isEmpty(strZzah)) {
                zzaVarZzp.zzm(strZzah);
            } else if (!TextUtils.isEmpty(strZzaa)) {
                zzaVarZzp.zza(strZzaa);
            }
            zzaVarZzp.zzj(zzfVarZze.zzw());
            zzin zzinVarZzb = this.zzf.zzb(str);
            zzaVarZzp.zzc(zzfVarZze.zzn());
            if (this.zzu.zzac() && zze().zzk(zzaVarZzp.zzs()) && zzinVarZzb.zzi() && !TextUtils.isEmpty(null)) {
                zzaVarZzp.zzj((String) null);
            }
            zzaVarZzp.zzg(zzinVarZzb.zzg());
            if (zzinVarZzb.zzi() && zzfVarZze.zzaq()) {
                Pair<String, Boolean> pairZza = zzn().zza(zzfVarZze.zzac(), zzinVarZzb);
                if (zzfVarZze.zzaq() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                    zzaVarZzp.zzq(zza((String) pairZza.first, Long.toString(zzbfVar.zzd)));
                    if (pairZza.second != null) {
                        zzaVarZzp.zzc(((Boolean) pairZza.second).booleanValue());
                    }
                }
            }
            zzf().zzac();
            zzfn.zzj.zza zzaVarZzi = zzaVarZzp.zzi(Build.MODEL);
            zzf().zzac();
            zzaVarZzi.zzo(Build.VERSION.RELEASE).zzj((int) zzf().zzg()).zzs(zzf().zzh());
            if (zzinVarZzb.zzj() && zzfVarZze.zzad() != null) {
                zzaVarZzp.zzc(zza((String) Preconditions.checkNotNull(zzfVarZze.zzad()), Long.toString(zzbfVar.zzd)));
            }
            if (!TextUtils.isEmpty(zzfVarZze.zzag())) {
                zzaVarZzp.zzl((String) Preconditions.checkNotNull(zzfVarZze.zzag()));
            }
            String strZzac = zzfVarZze.zzac();
            List<zznq> listZzk = zzh().zzk(strZzac);
            Iterator<zznq> it2 = listZzk.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if ("_lte".equals(next.zzc)) {
                    break;
                }
            }
            if (next == null || next.zze == null) {
                zznq zznqVar = new zznq(strZzac, "auto", "_lte", zzb().currentTimeMillis(), 0L);
                listZzk.add(zznqVar);
                zzh().zza(zznqVar);
            }
            zzfn.zzn[] zznVarArr = new zzfn.zzn[listZzk.size()];
            for (int i = 0; i < listZzk.size(); i++) {
                zzfn.zzn.zza zzaVarZzb2 = zzfn.zzn.zze().zza(listZzk.get(i).zzc).zzb(listZzk.get(i).zzd);
                mo2390g_().zza(zzaVarZzb2, listZzk.get(i).zze);
                zznVarArr[i] = (zzfn.zzn) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzb2.zzag());
            }
            zzaVarZzp.zze(Arrays.asList(zznVarArr));
            mo2390g_().zza(zzaVarZzp);
            this.zzf.zza(zzfVarZze, zzaVarZzp);
            zzga zzgaVarZza = zzga.zza(zzbfVar);
            zzq().zza(zzgaVarZza.zzb, zzh().zzd(str));
            zzq().zza(zzgaVarZza, zze().zzb(str));
            Bundle bundle2 = zzgaVarZza.zzb;
            bundle2.putLong("_c", 1L);
            zzj().zzc().zza("Marking in-app purchase as real-time");
            bundle2.putLong(NotificationMessage.NOTIF_KEY_REQUEST_ID, 1L);
            bundle2.putString("_o", zzbfVar.zzc);
            if (zzq().zzd(zzaVarZzp.zzs(), zzfVarZze.zzam())) {
                zzq().zza(bundle2, "_dbg", (Object) 1L);
                zzq().zza(bundle2, NotificationMessage.NOTIF_KEY_REQUEST_ID, (Object) 1L);
            }
            zzbb zzbbVarZzd = zzh().zzd(str, zzbfVar.zza);
            if (zzbbVarZzd == null) {
                zzaVar = zzaVarZzp;
                bundle = bundle2;
                zzaVar2 = zzaVarZzb;
                zzfVar = zzfVarZze;
                bArr = null;
                zzbbVarZza = new zzbb(str, zzbfVar.zza, 0L, 0L, zzbfVar.zzd, 0L, null, null, null, null);
                j = 0;
            } else {
                zzaVar = zzaVarZzp;
                bundle = bundle2;
                zzaVar2 = zzaVarZzb;
                zzfVar = zzfVarZze;
                bArr = null;
                j = zzbbVarZzd.zzf;
                zzbbVarZza = zzbbVarZzd.zza(zzbfVar.zzd);
            }
            zzh().zza(zzbbVarZza);
            zzay zzayVar = new zzay(this.zzu, zzbfVar.zzc, str, zzbfVar.zza, zzbfVar.zzd, j, bundle);
            zzfn.zze.zza zzaVarZza = zzfn.zze.zze().zzb(zzayVar.zzc).zza(zzayVar.zzb).zza(zzayVar.zzd);
            for (String str2 : zzayVar.zze) {
                zzfn.zzg.zza zzaVarZza2 = zzfn.zzg.zze().zza(str2);
                Object objZzc = zzayVar.zze.zzc(str2);
                if (objZzc != null) {
                    mo2390g_().zza(zzaVarZza2, objZzc);
                    zzaVarZza.zza(zzaVarZza2);
                }
            }
            zzfn.zzj.zza zzaVar3 = zzaVar;
            zzaVar3.zza(zzaVarZza).zza(zzfn.zzk.zza().zza(zzfn.zzf.zza().zza(zzbbVarZza.zzc).zza(zzbfVar.zza)));
            zzaVar3.zza(zzg().zza(zzfVar.zzac(), Collections.emptyList(), zzaVar3.zzaa(), Long.valueOf(zzaVarZza.zzc()), Long.valueOf(zzaVarZza.zzc())));
            if (zzaVarZza.zzg()) {
                zzaVar3.zzi(zzaVarZza.zzc()).zze(zzaVarZza.zzc());
            }
            long jZzs = zzfVar.zzs();
            if (jZzs != 0) {
                zzaVar3.zzg(jZzs);
            }
            long jZzu = zzfVar.zzu();
            if (jZzu != 0) {
                zzaVar3.zzh(jZzu);
            } else if (jZzs != 0) {
                zzaVar3.zzh(jZzs);
            }
            String strZzal = zzfVar.zzal();
            if (zzpi.zza() && zze().zze(str, zzbh.zzbt) && strZzal != null) {
                zzaVar3.zzr(strZzal);
            }
            zzfVar.zzap();
            zzaVar3.zzf((int) zzfVar.zzt()).zzl(95001L).zzk(zzb().currentTimeMillis()).zzd(Boolean.TRUE.booleanValue());
            this.zzf.zza(zzaVar3.zzs(), zzaVar3);
            zzfn.zzi.zza zzaVar4 = zzaVar2;
            zzaVar4.zza(zzaVar3);
            zzf zzfVar2 = zzfVar;
            zzfVar2.zzr(zzaVar3.zzf());
            zzfVar2.zzp(zzaVar3.zze());
            zzh().zza(zzfVar2, false, false);
            zzh().zzw();
            try {
                return mo2390g_().zzb(((zzfn.zzi) ((com.google.android.gms.internal.measurement.zzjk) zzaVar4.zzag())).zzbx());
            } catch (IOException e) {
                zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzfw.zza(str), e);
                return bArr;
            }
        } catch (SecurityException e2) {
            zzj().zzc().zza("Resettable device id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            zzj().zzc().zza("app instance id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzh().zzu();
        }
    }
}
