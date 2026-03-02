package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzit implements zzmx {
    private final zzir zza;

    public static zzit zza(zzir zzirVar) {
        return zzirVar.zza != null ? zzirVar.zza : new zzit(zzirVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final int zza() {
        return 1;
    }

    private zzit(zzir zzirVar) {
        zzir zzirVar2 = (zzir) zzjn.zza(zzirVar, "output");
        this.zza = zzirVar2;
        zzirVar2.zza = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, boolean z) throws IOException {
        this.zza.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzhv)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzir.zza(list.get(i3).booleanValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).booleanValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        zzhv zzhvVar = (zzhv) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zzhvVar.size(); i4++) {
                iZza2 += zzir.zza(zzhvVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zzhvVar.size()) {
                this.zza.zzb(zzhvVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzhvVar.size()) {
            this.zza.zzb(i, zzhvVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, zzhx zzhxVar) throws IOException {
        this.zza.zzc(i, zzhxVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, List<zzhx> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzc(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zziw)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzir.zza(list.get(i3).doubleValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).doubleValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        zziw zziwVar = (zziw) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zziwVar.size(); i4++) {
                iZza2 += zzir.zza(zziwVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zziwVar.size()) {
                this.zza.zzb(zziwVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zziwVar.size()) {
            this.zza.zzb(i, zziwVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzj(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzjl)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzir.zza(list.get(i3).intValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzi(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzjl zzjlVar = (zzjl) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zzjlVar.size(); i4++) {
                iZza2 += zzir.zza(zzjlVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zzjlVar.size()) {
                this.zza.zzi(zzjlVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzjlVar.size()) {
            this.zza.zzh(i, zzjlVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzjl)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzb = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzb += zzir.zzb(list.get(i3).intValue());
                }
                this.zza.zzk(iZzb);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzjl zzjlVar = (zzjl) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzb2 = 0;
            for (int i4 = 0; i4 < zzjlVar.size(); i4++) {
                iZzb2 += zzir.zzb(zzjlVar.zzb(i4));
            }
            this.zza.zzk(iZzb2);
            while (i2 < zzjlVar.size()) {
                this.zza.zzh(zzjlVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzjlVar.size()) {
            this.zza.zzg(i, zzjlVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkf)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzir.zza(list.get(i3).longValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzf(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzkf zzkfVar = (zzkf) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zzkfVar.size(); i4++) {
                iZza2 += zzir.zza(zzkfVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zzkfVar.size()) {
                this.zza.zzf(zzkfVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkfVar.size()) {
            this.zza.zzf(i, zzkfVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzjg)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZza = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZza += zzir.zza(list.get(i3).floatValue());
                }
                this.zza.zzk(iZza);
                while (i2 < list.size()) {
                    this.zza.zzb(list.get(i2).floatValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzb(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        zzjg zzjgVar = (zzjg) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZza2 = 0;
            for (int i4 = 0; i4 < zzjgVar.size(); i4++) {
                iZza2 += zzir.zza(zzjgVar.zzb(i4));
            }
            this.zza.zzk(iZza2);
            while (i2 < zzjgVar.size()) {
                this.zza.zzb(zzjgVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzjgVar.size()) {
            this.zza.zzb(i, zzjgVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, Object obj, zzli zzliVar) throws IOException {
        zzir zzirVar = this.zza;
        zzirVar.zzj(i, 3);
        zzliVar.zza((zzkq) obj, zzirVar.zza);
        zzirVar.zzj(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, List<?> list, zzli zzliVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzliVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzjl)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzir.zzc(list.get(i3).intValue());
                }
                this.zza.zzk(iZzc);
                while (i2 < list.size()) {
                    this.zza.zzi(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzjl zzjlVar = (zzjl) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzjlVar.size(); i4++) {
                iZzc2 += zzir.zzc(zzjlVar.zzb(i4));
            }
            this.zza.zzk(iZzc2);
            while (i2 < zzjlVar.size()) {
                this.zza.zzi(zzjlVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzjlVar.size()) {
            this.zza.zzh(i, zzjlVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzb(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkf)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzb = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzb += zzir.zzb(list.get(i3).longValue());
                }
                this.zza.zzk(iZzb);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzkf zzkfVar = (zzkf) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzb2 = 0;
            for (int i4 = 0; i4 < zzkfVar.size(); i4++) {
                iZzb2 += zzir.zzb(zzkfVar.zzb(i4));
            }
            this.zza.zzk(iZzb2);
            while (i2 < zzkfVar.size()) {
                this.zza.zzh(zzkfVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkfVar.size()) {
            this.zza.zzh(i, zzkfVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final <K, V> void zza(int i, zzkl<K, V> zzklVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzj(i, 2);
            this.zza.zzk(zzki.zza(zzklVar, entry.getKey(), entry.getValue()));
            zzki.zza(this.zza, zzklVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzb(int i, Object obj, zzli zzliVar) throws IOException {
        this.zza.zzc(i, (zzkq) obj, zzliVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzb(int i, List<?> list, zzli zzliVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzliVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzhx) {
            this.zza.zzd(i, (zzhx) obj);
        } else {
            this.zza.zzb(i, (zzkq) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzd(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzjl)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzd = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzd += zzir.zzd(list.get(i3).intValue());
                }
                this.zza.zzk(iZzd);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzjl zzjlVar = (zzjl) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzd2 = 0;
            for (int i4 = 0; i4 < zzjlVar.size(); i4++) {
                iZzd2 += zzir.zzd(zzjlVar.zzb(i4));
            }
            this.zza.zzk(iZzd2);
            while (i2 < zzjlVar.size()) {
                this.zza.zzh(zzjlVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzjlVar.size()) {
            this.zza.zzg(i, zzjlVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkf)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzc = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzc += zzir.zzc(list.get(i3).longValue());
                }
                this.zza.zzk(iZzc);
                while (i2 < list.size()) {
                    this.zza.zzf(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzf(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzkf zzkfVar = (zzkf) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzc2 = 0;
            for (int i4 = 0; i4 < zzkfVar.size(); i4++) {
                iZzc2 += zzir.zzc(zzkfVar.zzb(i4));
            }
            this.zza.zzk(iZzc2);
            while (i2 < zzkfVar.size()) {
                this.zza.zzf(zzkfVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkfVar.size()) {
            this.zza.zzf(i, zzkfVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zze(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzjl)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZze = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZze += zzir.zze(list.get(i3).intValue());
                }
                this.zza.zzk(iZze);
                while (i2 < list.size()) {
                    this.zza.zzj(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzi(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzjl zzjlVar = (zzjl) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZze2 = 0;
            for (int i4 = 0; i4 < zzjlVar.size(); i4++) {
                iZze2 += zzir.zze(zzjlVar.zzb(i4));
            }
            this.zza.zzk(iZze2);
            while (i2 < zzjlVar.size()) {
                this.zza.zzj(zzjlVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzjlVar.size()) {
            this.zza.zzi(i, zzjlVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkf)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzd = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzd += zzir.zzd(list.get(i3).longValue());
                }
                this.zza.zzk(iZzd);
                while (i2 < list.size()) {
                    this.zza.zzg(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzg(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzkf zzkfVar = (zzkf) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzd2 = 0;
            for (int i4 = 0; i4 < zzkfVar.size(); i4++) {
                iZzd2 += zzir.zzd(zzkfVar.zzb(i4));
            }
            this.zza.zzk(iZzd2);
            while (i2 < zzkfVar.size()) {
                this.zza.zzg(zzkfVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkfVar.size()) {
            this.zza.zzg(i, zzkfVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzj(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zza(int i, String str) throws IOException {
        this.zza.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzkb) {
            zzkb zzkbVar = (zzkb) list;
            while (i2 < list.size()) {
                Object objZza = zzkbVar.zza(i2);
                if (objZza instanceof String) {
                    this.zza.zzb(i, (String) objZza);
                } else {
                    this.zza.zzc(i, (zzhx) objZza);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzjl)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZzg = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZzg += zzir.zzg(list.get(i3).intValue());
                }
                this.zza.zzk(iZzg);
                while (i2 < list.size()) {
                    this.zza.zzk(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzk(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        zzjl zzjlVar = (zzjl) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZzg2 = 0;
            for (int i4 = 0; i4 < zzjlVar.size(); i4++) {
                iZzg2 += zzir.zzg(zzjlVar.zzb(i4));
            }
            this.zza.zzk(iZzg2);
            while (i2 < zzjlVar.size()) {
                this.zza.zzk(zzjlVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzjlVar.size()) {
            this.zza.zzk(i, zzjlVar.zzb(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zze(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzkf)) {
            if (z) {
                this.zza.zzj(i, 2);
                int iZze = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    iZze += zzir.zze(list.get(i3).longValue());
                }
                this.zza.zzk(iZze);
                while (i2 < list.size()) {
                    this.zza.zzh(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                this.zza.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        zzkf zzkfVar = (zzkf) list;
        if (z) {
            this.zza.zzj(i, 2);
            int iZze2 = 0;
            for (int i4 = 0; i4 < zzkfVar.size(); i4++) {
                iZze2 += zzir.zze(zzkfVar.zzb(i4));
            }
            this.zza.zzk(iZze2);
            while (i2 < zzkfVar.size()) {
                this.zza.zzh(zzkfVar.zzb(i2));
                i2++;
            }
            return;
        }
        while (i2 < zzkfVar.size()) {
            this.zza.zzh(i, zzkfVar.zzb(i2));
            i2++;
        }
    }
}
