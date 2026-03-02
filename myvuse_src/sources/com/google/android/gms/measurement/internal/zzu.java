package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zznz;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzu {
    private String zza;
    private boolean zzb;
    private zzfn.zzl zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzs zzh;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzfn$zzc$zza, com.google.android.gms.internal.measurement.zzjk$zza] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.measurement.zzfn$zzl$zza] */
    final zzfn.zzc zza(int i) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? Zzb = zzfn.zzc.zzb();
        Zzb.zza(i);
        Zzb.zza(this.zzb);
        zzfn.zzl zzlVar = this.zzc;
        if (zzlVar != null) {
            Zzb.zza(zzlVar);
        }
        ?? Zzd = zzfn.zzl.zze().zzb(zznp.zza(this.zzd)).zzd(zznp.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            Iterator<Integer> it2 = this.zzf.keySet().iterator();
            while (it2.hasNext()) {
                int iIntValue = it2.next().intValue();
                Long l = this.zzf.get(Integer.valueOf(iIntValue));
                if (l != null) {
                    arrayList.add((zzfn.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzfn.zzd.zzc().zza(iIntValue).zza(l.longValue()).zzag()));
                }
            }
        }
        if (arrayList != null) {
            Zzd.zza(arrayList);
        }
        if (this.zzg == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.zzg.size());
            for (Integer num : this.zzg.keySet()) {
                zzfn.zzm.zza zzaVarZza = zzfn.zzm.zzc().zza(num.intValue());
                List<Long> list = this.zzg.get(num);
                if (list != null) {
                    Collections.sort(list);
                    zzaVarZza.zza(list);
                }
                arrayList2.add((zzfn.zzm) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZza.zzag()));
            }
        }
        Zzd.zzc(arrayList2);
        Zzb.zza(Zzd);
        return (zzfn.zzc) ((com.google.android.gms.internal.measurement.zzjk) Zzb.zzag());
    }

    private zzu(zzs zzsVar, String str) {
        this.zzh = zzsVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzu(zzs zzsVar, String str, zzfn.zzl zzlVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzsVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzlVar;
    }

    final void zza(zzab zzabVar) {
        int iZza = zzabVar.zza();
        if (zzabVar.zzc != null) {
            this.zze.set(iZza, zzabVar.zzc.booleanValue());
        }
        if (zzabVar.zzd != null) {
            this.zzd.set(iZza, zzabVar.zzd.booleanValue());
        }
        if (zzabVar.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(iZza));
            long jLongValue = zzabVar.zze.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(iZza), Long.valueOf(jLongValue));
            }
        }
        if (zzabVar.zzf != null) {
            List<Long> arrayList = this.zzg.get(Integer.valueOf(iZza));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzg.put(Integer.valueOf(iZza), arrayList);
            }
            if (zzabVar.zzc()) {
                arrayList.clear();
            }
            if (zznz.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbj) && zzabVar.zzb()) {
                arrayList.clear();
            }
            if (zznz.zza() && this.zzh.zze().zzf(this.zza, zzbh.zzbj)) {
                long jLongValue2 = zzabVar.zzf.longValue() / 1000;
                if (arrayList.contains(Long.valueOf(jLongValue2))) {
                    return;
                }
                arrayList.add(Long.valueOf(jLongValue2));
                return;
            }
            arrayList.add(Long.valueOf(zzabVar.zzf.longValue() / 1000));
        }
    }
}
