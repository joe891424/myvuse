package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zznz;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzs extends zznb {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzu> zzc;
    private Long zzd;
    private Long zze;

    private final zzu zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zznb
    protected final boolean zzc() {
        return false;
    }

    final List<zzfn.zzc> zza(String str, List<zzfn.zze> list, List<zzfn.zzn> list2, Long l, Long l2) {
        return zza(str, list, list2, l, l2, false);
    }

    final List<zzfn.zzc> zza(String str, List<zzfn.zze> list, List<zzfn.zzn> list2, Long l, Long l2, boolean z) {
        boolean z2;
        Map<Integer, zzfn.zzl> map;
        List<zzff.zzb> list3;
        Map<Integer, List<zzff.zzb>> map2;
        Map<Integer, zzfn.zzl> map3;
        Iterator it2;
        Iterator<zzfn.zzm> it3;
        Map<Integer, List<Integer>> map4;
        Iterator<Integer> it4;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator<zzfn.zze> it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it5.next().zzg())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = zznz.zza() && zze().zzf(this.zza, zzbh.zzbj);
        boolean z4 = zznz.zza() && zze().zzf(this.zza, zzbh.zzbi);
        if (z2) {
            zzan zzanVarZzh = zzh();
            String str2 = this.zza;
            zzanVarZzh.zzak();
            zzanVarZzh.zzt();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseM2388e_ = zzanVarZzh.m2388e_();
                String[] strArr = {str2};
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    sQLiteDatabaseM2388e_.update("events", contentValues, "app_id = ?", strArr);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    SQLiteInstrumentation.update(sQLiteDatabaseM2388e_, "events", contentValues, "app_id = ?", strArr);
                }
            } catch (SQLiteException e) {
                zzanVarZzh.zzj().zzg().zza("Error resetting session-scoped event counts. appId", zzfw.zza(str2), e);
            }
        }
        Map<Integer, List<zzff.zzb>> mapEmptyMap = Collections.emptyMap();
        if (z4 && z3) {
            mapEmptyMap = zzh().zzm(this.zza);
        }
        Map<Integer, zzfn.zzl> mapZzl = zzh().zzl(this.zza);
        if (!mapZzl.isEmpty()) {
            HashSet hashSet = new HashSet(mapZzl.keySet());
            if (z2) {
                String str3 = this.zza;
                Map<Integer, List<Integer>> mapZzn = zzh().zzn(this.zza);
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(mapZzl);
                ArrayMap arrayMap = new ArrayMap();
                if (!mapZzl.isEmpty()) {
                    Iterator<Integer> it6 = mapZzl.keySet().iterator();
                    while (it6.hasNext()) {
                        int iIntValue = it6.next().intValue();
                        zzfn.zzl zzlVar = mapZzl.get(Integer.valueOf(iIntValue));
                        List<Integer> list4 = mapZzn.get(Integer.valueOf(iIntValue));
                        if (list4 == null || list4.isEmpty()) {
                            map4 = mapZzn;
                            it4 = it6;
                            arrayMap.put(Integer.valueOf(iIntValue), zzlVar);
                            mapZzn = map4;
                            it6 = it4;
                        } else {
                            List<Long> listZza = mo2390g_().zza(zzlVar.zzi(), list4);
                            if (!listZza.isEmpty()) {
                                zzfn.zzl.zza zzaVarZzb = zzlVar.zzca().zzb().zzb(listZza);
                                zzaVarZzb.zzd().zzd(mo2390g_().zza(zzlVar.zzk(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (zzfn.zzd zzdVar : zzlVar.zzh()) {
                                    Map<Integer, List<Integer>> map5 = mapZzn;
                                    Iterator<Integer> it7 = it6;
                                    if (!list4.contains(Integer.valueOf(zzdVar.zza()))) {
                                        arrayList.add(zzdVar);
                                    }
                                    mapZzn = map5;
                                    it6 = it7;
                                }
                                map4 = mapZzn;
                                it4 = it6;
                                zzaVarZzb.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (zzfn.zzm zzmVar : zzlVar.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zzmVar.zzb()))) {
                                        arrayList2.add(zzmVar);
                                    }
                                }
                                zzaVarZzb.zzc().zzc(arrayList2);
                                arrayMap.put(Integer.valueOf(iIntValue), (zzfn.zzl) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzb.zzag()));
                                mapZzn = map4;
                                it6 = it4;
                            }
                        }
                    }
                }
                map = arrayMap;
            } else {
                map = mapZzl;
            }
            Iterator it8 = hashSet.iterator();
            while (it8.hasNext()) {
                int iIntValue2 = ((Integer) it8.next()).intValue();
                zzfn.zzl zzlVar2 = map.get(Integer.valueOf(iIntValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap2 = new ArrayMap();
                if (zzlVar2 != null && zzlVar2.zza() != 0) {
                    for (zzfn.zzd zzdVar2 : zzlVar2.zzh()) {
                        if (zzdVar2.zzf()) {
                            arrayMap2.put(Integer.valueOf(zzdVar2.zza()), zzdVar2.zze() ? Long.valueOf(zzdVar2.zzb()) : null);
                        }
                    }
                }
                ArrayMap arrayMap3 = new ArrayMap();
                if (zzlVar2 != null && zzlVar2.zzc() != 0) {
                    Iterator<zzfn.zzm> it9 = zzlVar2.zzj().iterator();
                    while (it9.hasNext()) {
                        zzfn.zzm next = it9.next();
                        if (!next.zzf() || next.zza() <= 0) {
                            it3 = it9;
                        } else {
                            it3 = it9;
                            arrayMap3.put(Integer.valueOf(next.zzb()), Long.valueOf(next.zza(next.zza() - 1)));
                        }
                        it9 = it3;
                    }
                }
                if (zzlVar2 != null) {
                    int i = 0;
                    while (i < (zzlVar2.zzd() << 6)) {
                        if (zznp.zza(zzlVar2.zzk(), i)) {
                            map3 = map;
                            it2 = it8;
                            zzj().zzp().zza("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i));
                            bitSet2.set(i);
                            if (zznp.zza(zzlVar2.zzi(), i)) {
                                bitSet.set(i);
                            }
                            i++;
                            map = map3;
                            it8 = it2;
                        } else {
                            map3 = map;
                            it2 = it8;
                        }
                        arrayMap2.remove(Integer.valueOf(i));
                        i++;
                        map = map3;
                        it8 = it2;
                    }
                }
                Map<Integer, zzfn.zzl> map6 = map;
                Iterator it10 = it8;
                zzfn.zzl zzlVar3 = mapZzl.get(Integer.valueOf(iIntValue2));
                if (z4 && z3 && (list3 = mapEmptyMap.get(Integer.valueOf(iIntValue2))) != null && this.zze != null && this.zzd != null) {
                    for (zzff.zzb zzbVar : list3) {
                        int iZzb = zzbVar.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzbVar.zzi()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        if (arrayMap2.containsKey(Integer.valueOf(iZzb))) {
                            map2 = mapEmptyMap;
                            arrayMap2.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        } else {
                            map2 = mapEmptyMap;
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap3.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                        mapEmptyMap = map2;
                    }
                }
                this.zzc.put(Integer.valueOf(iIntValue2), new zzu(this, this.zza, zzlVar3, bitSet, bitSet2, arrayMap2, arrayMap3));
                map = map6;
                it8 = it10;
                mapEmptyMap = mapEmptyMap;
                mapZzl = mapZzl;
            }
        }
        if (com.google.android.gms.internal.measurement.zznh.zza() && zze().zzf(null, zzbh.zzdc)) {
            zza(list, z);
            if (z) {
                return new ArrayList();
            }
            zza(list2);
            return zzu();
        }
        zza(list, true);
        zza(list2);
        return zzu();
    }

    private final List<zzfn.zzc> zzu() {
        long jInsertWithOnConflict;
        ArrayList arrayList = new ArrayList();
        Set<Integer> setKeySet = this.zzc.keySet();
        setKeySet.removeAll(this.zzb);
        Iterator<Integer> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            int iIntValue = it2.next().intValue();
            zzu zzuVar = this.zzc.get(Integer.valueOf(iIntValue));
            Preconditions.checkNotNull(zzuVar);
            zzfn.zzc zzcVarZza = zzuVar.zza(iIntValue);
            arrayList.add(zzcVarZza);
            zzan zzanVarZzh = zzh();
            String str = this.zza;
            zzfn.zzl zzlVarZzd = zzcVarZza.zzd();
            zzanVarZzh.zzak();
            zzanVarZzh.zzt();
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotNull(zzlVarZzd);
            byte[] bArrZzbx = zzlVarZzd.zzbx();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(iIntValue));
            contentValues.put("current_results", bArrZzbx);
            try {
                SQLiteDatabase sQLiteDatabaseM2388e_ = zzanVarZzh.m2388e_();
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict("audience_filter_values", null, contentValues, 5);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "audience_filter_values", null, contentValues, 5);
                }
                if (jInsertWithOnConflict == -1) {
                    zzanVarZzh.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzfw.zza(str));
                }
            } catch (SQLiteException e) {
                zzanVarZzh.zzj().zzg().zza("Error storing filter results. appId", zzfw.zza(str), e);
            }
        }
        return arrayList;
    }

    zzs(zznc zzncVar) {
        super(zzncVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(List<zzfn.zze> list, boolean z) {
        zzbb zzbbVar;
        int i;
        Map<Integer, List<zzff.zzb>> map;
        long j;
        if (list.isEmpty()) {
            return;
        }
        String str = null;
        zzw zzwVar = new zzw(this);
        ArrayMap arrayMap = new ArrayMap();
        for (zzfn.zze zzeVar : list) {
            zzfn.zze zzeVarZza = zzwVar.zza(this.zza, zzeVar);
            if (zzeVarZza != null) {
                zzan zzanVarZzh = zzh();
                String str2 = this.zza;
                String strZzg = zzeVarZza.zzg();
                zzbb zzbbVarZzd = zzanVarZzh.zzd(str2, zzeVar.zzg());
                if (zzbbVarZzd == null) {
                    zzanVarZzh.zzj().zzu().zza("Event aggregate wasn't created during raw event logging. appId, event", zzfw.zza(str2), zzanVarZzh.zzi().zza(strZzg));
                    zzbbVar = new zzbb(str2, zzeVar.zzg(), 1L, 1L, 1L, zzeVar.zzd(), 0L, null, null, null, null);
                } else {
                    zzbbVar = new zzbb(zzbbVarZzd.zza, zzbbVarZzd.zzb, zzbbVarZzd.zzc + 1, zzbbVarZzd.zzd + 1, zzbbVarZzd.zze + 1, zzbbVarZzd.zzf, zzbbVarZzd.zzg, zzbbVarZzd.zzh, zzbbVarZzd.zzi, zzbbVarZzd.zzj, zzbbVarZzd.zzk);
                }
                zzbb zzbbVar2 = zzbbVar;
                zzh().zza(zzbbVar2);
                if (!com.google.android.gms.internal.measurement.zznh.zza() || !zze().zzf(str, zzbh.zzdc) || !z) {
                    long j2 = zzbbVar2.zzc;
                    String strZzg2 = zzeVarZza.zzg();
                    Map<Integer, List<zzff.zzb>> mapZzf = (Map) arrayMap.get(strZzg2);
                    if (mapZzf == null) {
                        mapZzf = zzh().zzf(this.zza, strZzg2);
                        arrayMap.put(strZzg2, mapZzf);
                    }
                    Map<Integer, List<zzff.zzb>> map2 = mapZzf;
                    Iterator<Integer> it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        int iIntValue = it2.next().intValue();
                        if (this.zzb.contains(Integer.valueOf(iIntValue))) {
                            zzj().zzp().zza("Skipping failed audience ID", Integer.valueOf(iIntValue));
                        } else {
                            Iterator<zzff.zzb> it3 = map2.get(Integer.valueOf(iIntValue)).iterator();
                            boolean zZza = true;
                            while (true) {
                                if (!it3.hasNext()) {
                                    i = iIntValue;
                                    map = map2;
                                    j = j2;
                                    break;
                                }
                                zzff.zzb next = it3.next();
                                zzy zzyVar = new zzy(this, this.zza, iIntValue, next);
                                i = iIntValue;
                                map = map2;
                                j = j2;
                                zZza = zzyVar.zza(this.zzd, this.zze, zzeVarZza, j2, zzbbVar2, zza(iIntValue, next.zzb()));
                                if (zZza) {
                                    zza(Integer.valueOf(i)).zza(zzyVar);
                                    iIntValue = i;
                                    map2 = map;
                                    j2 = j;
                                } else {
                                    this.zzb.add(Integer.valueOf(i));
                                    break;
                                }
                            }
                            if (!zZza) {
                                this.zzb.add(Integer.valueOf(i));
                            }
                            map2 = map;
                            j2 = j;
                            str = null;
                        }
                    }
                }
            }
        }
    }

    private final void zza(List<zzfn.zzn> list) {
        zzff.zze next;
        if (list.isEmpty()) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzfn.zzn zznVar : list) {
            String strZzg = zznVar.zzg();
            Map<Integer, List<zzff.zze>> mapZzg = (Map) arrayMap.get(strZzg);
            if (mapZzg == null) {
                mapZzg = zzh().zzg(this.zza, strZzg);
                arrayMap.put(strZzg, mapZzg);
            }
            Iterator<Integer> it2 = mapZzg.keySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    int iIntValue = it2.next().intValue();
                    if (this.zzb.contains(Integer.valueOf(iIntValue))) {
                        zzj().zzp().zza("Skipping failed audience ID", Integer.valueOf(iIntValue));
                        break;
                    }
                    Iterator<zzff.zze> it3 = mapZzg.get(Integer.valueOf(iIntValue)).iterator();
                    boolean zZza = true;
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        next = it3.next();
                        if (zzj().zza(2)) {
                            zzj().zzp().zza("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue), next.zzi() ? Integer.valueOf(next.zza()) : null, zzi().zzc(next.zze()));
                            zzj().zzp().zza("Filter definition", mo2390g_().zza(next));
                        }
                        if (!next.zzi() || next.zza() > 256) {
                            break;
                        }
                        zzaa zzaaVar = new zzaa(this, this.zza, iIntValue, next);
                        zZza = zzaaVar.zza(this.zzd, this.zze, zznVar, zza(iIntValue, next.zza()));
                        if (zZza) {
                            zza(Integer.valueOf(iIntValue)).zza(zzaaVar);
                        } else {
                            this.zzb.add(Integer.valueOf(iIntValue));
                            break;
                        }
                    }
                    zzj().zzu().zza("Invalid property filter ID. appId, id", zzfw.zza(this.zza), String.valueOf(next.zzi() ? Integer.valueOf(next.zza()) : null));
                    zZza = false;
                    if (!zZza) {
                        this.zzb.add(Integer.valueOf(iIntValue));
                    }
                }
            }
        }
    }

    private final boolean zza(int i, int i2) {
        zzu zzuVar = this.zzc.get(Integer.valueOf(i));
        if (zzuVar == null) {
            return false;
        }
        return zzuVar.zzd.get(i2);
    }
}
