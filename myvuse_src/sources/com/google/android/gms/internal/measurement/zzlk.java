package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlk {
    private static final zzmc<?, ?> zza = new zzme();

    static int zza(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzir.zza(i, true);
    }

    static int zza(List<?> list) {
        return list.size();
    }

    static int zza(int i, List<zzhx> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzf = size * zzir.zzf(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzf += zzir.zza(list.get(i2));
        }
        return iZzf;
    }

    static int zzb(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzir.zzf(i));
    }

    static int zzb(List<Integer> list) {
        int iZza;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            iZza = 0;
            while (i < size) {
                iZza += zzir.zza(zzjlVar.zzb(i));
                i++;
            }
        } else {
            iZza = 0;
            while (i < size) {
                iZza += zzir.zza(list.get(i).intValue());
                i++;
            }
        }
        return iZza;
    }

    static int zzc(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzir.zzb(i, 0);
    }

    static int zzc(List<?> list) {
        return list.size() << 2;
    }

    static int zzd(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzir.zza(i, 0L);
    }

    static int zzd(List<?> list) {
        return list.size() << 3;
    }

    static int zza(int i, List<zzkq> list, zzli zzliVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZza = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZza += zzir.zza(i, list.get(i2), zzliVar);
        }
        return iZza;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzir.zzf(i));
    }

    static int zze(List<Integer> list) {
        int iZzc;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            iZzc = 0;
            while (i < size) {
                iZzc += zzir.zzc(zzjlVar.zzb(i));
                i++;
            }
        } else {
            iZzc = 0;
            while (i < size) {
                iZzc += zzir.zzc(list.get(i).intValue());
                i++;
            }
        }
        return iZzc;
    }

    static int zzf(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzf(list) + (list.size() * zzir.zzf(i));
    }

    static int zzf(List<Long> list) {
        int iZzb;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            iZzb = 0;
            while (i < size) {
                iZzb += zzir.zzb(zzkfVar.zzb(i));
                i++;
            }
        } else {
            iZzb = 0;
            while (i < size) {
                iZzb += zzir.zzb(list.get(i).longValue());
                i++;
            }
        }
        return iZzb;
    }

    static int zza(int i, Object obj, zzli zzliVar) {
        if (obj instanceof zzjy) {
            return zzir.zzb(i, (zzjy) obj);
        }
        return zzir.zzb(i, (zzkq) obj, zzliVar);
    }

    static int zzb(int i, List<?> list, zzli zzliVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzf = zzir.zzf(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzjy) {
                iZza = zzir.zza((zzjy) obj);
            } else {
                iZza = zzir.zza((zzkq) obj, zzliVar);
            }
            iZzf += iZza;
        }
        return iZzf;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzir.zzf(i));
    }

    static int zzg(List<Integer> list) {
        int iZze;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            iZze = 0;
            while (i < size) {
                iZze += zzir.zze(zzjlVar.zzb(i));
                i++;
            }
        } else {
            iZze = 0;
            while (i < size) {
                iZze += zzir.zze(list.get(i).intValue());
                i++;
            }
        }
        return iZze;
    }

    static int zzh(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzir.zzf(i));
    }

    static int zzh(List<Long> list) {
        int iZzd;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            iZzd = 0;
            while (i < size) {
                iZzd += zzir.zzd(zzkfVar.zzb(i));
                i++;
            }
        } else {
            iZzd = 0;
            while (i < size) {
                iZzd += zzir.zzd(list.get(i).longValue());
                i++;
            }
        }
        return iZzd;
    }

    static int zzb(int i, List<?> list) {
        int iZza;
        int iZza2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzf = zzir.zzf(i) * size;
        if (list instanceof zzkb) {
            zzkb zzkbVar = (zzkb) list;
            while (i2 < size) {
                Object objZza = zzkbVar.zza(i2);
                if (objZza instanceof zzhx) {
                    iZza2 = zzir.zza((zzhx) objZza);
                } else {
                    iZza2 = zzir.zza((String) objZza);
                }
                iZzf += iZza2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzhx) {
                    iZza = zzir.zza((zzhx) obj);
                } else {
                    iZza = zzir.zza((String) obj);
                }
                iZzf += iZza;
                i2++;
            }
        }
        return iZzf;
    }

    static int zzi(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzir.zzf(i));
    }

    static int zzi(List<Integer> list) {
        int iZzg;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            iZzg = 0;
            while (i < size) {
                iZzg += zzir.zzg(zzjlVar.zzb(i));
                i++;
            }
        } else {
            iZzg = 0;
            while (i < size) {
                iZzg += zzir.zzg(list.get(i).intValue());
                i++;
            }
        }
        return iZzg;
    }

    static int zzj(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzir.zzf(i));
    }

    static int zzj(List<Long> list) {
        int iZze;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            iZze = 0;
            while (i < size) {
                iZze += zzir.zze(zzkfVar.zzb(i));
                i++;
            }
        } else {
            iZze = 0;
            while (i < size) {
                iZze += zzir.zze(list.get(i).longValue());
                i++;
            }
        }
        return iZze;
    }

    public static zzmc<?, ?> zza() {
        return zza;
    }

    static <UT, UB> UB zza(Object obj, int i, List<Integer> list, zzjp zzjpVar, UB ub, zzmc<UT, UB> zzmcVar) {
        if (zzjpVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = list.get(i3).intValue();
                if (zzjpVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(obj, i, iIntValue, ub, zzmcVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                int iIntValue2 = it2.next().intValue();
                if (!zzjpVar.zza(iIntValue2)) {
                    ub = (UB) zza(obj, i, iIntValue2, ub, zzmcVar);
                    it2.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(Object obj, int i, int i2, UB ub, zzmc<UT, UB> zzmcVar) {
        if (ub == null) {
            ub = zzmcVar.zzc(obj);
        }
        zzmcVar.zzb(ub, i, i2);
        return ub;
    }

    static <T, FT extends zzjc<FT>> void zza(zziz<FT> zzizVar, T t, T t2) {
        zzja<T> zzjaVarZza = zzizVar.zza(t2);
        if (zzjaVarZza.zza.isEmpty()) {
            return;
        }
        zzizVar.zzb(t).zza((zzja) zzjaVarZza);
    }

    static <T> void zza(zzkn zzknVar, T t, T t2, long j) {
        zzmh.zza(t, j, zzknVar.zza(zzmh.zze(t, j), zzmh.zze(t2, j)));
    }

    static <T, UT, UB> void zza(zzmc<UT, UB> zzmcVar, T t, T t2) {
        zzmcVar.zzc(t, zzmcVar.zza(zzmcVar.zzd(t), zzmcVar.zzd(t2)));
    }

    public static void zza(Class<?> cls) {
        zzjk.class.isAssignableFrom(cls);
    }

    public static void zza(int i, List<Boolean> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zza(i, list, z);
    }

    public static void zza(int i, List<zzhx> list, zzmx zzmxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zza(i, list);
    }

    public static void zzb(int i, List<Double> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzb(i, list, z);
    }

    public static void zzc(int i, List<Integer> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Integer> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zze(i, list, z);
    }

    public static void zzf(int i, List<Float> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzf(i, list, z);
    }

    public static void zza(int i, List<?> list, zzmx zzmxVar, zzli zzliVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zza(i, list, zzliVar);
    }

    public static void zzg(int i, List<Integer> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzg(i, list, z);
    }

    public static void zzh(int i, List<Long> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzh(i, list, z);
    }

    public static void zzb(int i, List<?> list, zzmx zzmxVar, zzli zzliVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzb(i, list, zzliVar);
    }

    public static void zzi(int i, List<Integer> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzi(i, list, z);
    }

    public static void zzj(int i, List<Long> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzj(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzk(i, list, z);
    }

    public static void zzl(int i, List<Long> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzl(i, list, z);
    }

    public static void zzb(int i, List<String> list, zzmx zzmxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzb(i, list);
    }

    public static void zzm(int i, List<Integer> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzm(i, list, z);
    }

    public static void zzn(int i, List<Long> list, zzmx zzmxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzmxVar.zzn(i, list, z);
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
