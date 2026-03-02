package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzja<T extends zzjc<T>> {
    private static final zzja zzb = new zzja(true);
    final zzln<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    static int zza(zzmo zzmoVar, int i, Object obj) {
        int iZzf = zzir.zzf(i);
        if (zzmoVar == zzmo.zzj) {
            zzjn.zza((zzkq) obj);
            iZzf <<= 1;
        }
        return iZzf + zza(zzmoVar, obj);
    }

    private static int zza(zzmo zzmoVar, Object obj) {
        switch (zzjd.zzb[zzmoVar.ordinal()]) {
            case 1:
                return zzir.zza(((Double) obj).doubleValue());
            case 2:
                return zzir.zza(((Float) obj).floatValue());
            case 3:
                return zzir.zzb(((Long) obj).longValue());
            case 4:
                return zzir.zze(((Long) obj).longValue());
            case 5:
                return zzir.zzc(((Integer) obj).intValue());
            case 6:
                return zzir.zza(((Long) obj).longValue());
            case 7:
                return zzir.zzb(((Integer) obj).intValue());
            case 8:
                return zzir.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzir.zza((zzkq) obj);
            case 10:
                if (obj instanceof zzju) {
                    return zzir.zza((zzju) obj);
                }
                return zzir.zzb((zzkq) obj);
            case 11:
                if (obj instanceof zzhx) {
                    return zzir.zza((zzhx) obj);
                }
                return zzir.zza((String) obj);
            case 12:
                if (obj instanceof zzhx) {
                    return zzir.zza((zzhx) obj);
                }
                return zzir.zza((byte[]) obj);
            case 13:
                return zzir.zzg(((Integer) obj).intValue());
            case 14:
                return zzir.zzd(((Integer) obj).intValue());
            case 15:
                return zzir.zzc(((Long) obj).longValue());
            case 16:
                return zzir.zze(((Integer) obj).intValue());
            case 17:
                return zzir.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzjm) {
                    return zzir.zza(((zzjm) obj).zza());
                }
                return zzir.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzjc<?> zzjcVar, Object obj) {
        zzmo zzmoVarZzb = zzjcVar.zzb();
        int iZza = zzjcVar.zza();
        if (zzjcVar.zze()) {
            List list = (List) obj;
            int iZza2 = 0;
            if (zzjcVar.zzd()) {
                if (list.isEmpty()) {
                    return 0;
                }
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    iZza2 += zza(zzmoVarZzb, it2.next());
                }
                return zzir.zzf(iZza) + iZza2 + zzir.zzg(iZza2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                iZza2 += zza(zzmoVarZzb, iZza, it3.next());
            }
            return iZza2;
        }
        return zza(zzmoVarZzb, iZza, obj);
    }

    public final int zza() {
        int iZza = 0;
        for (int i = 0; i < this.zza.zzb(); i++) {
            iZza += zza((Map.Entry) this.zza.zzb(i));
        }
        Iterator it2 = this.zza.zzc().iterator();
        while (it2.hasNext()) {
            iZza += zza((Map.Entry) it2.next());
        }
        return iZza;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzmy.MESSAGE && !key.zze() && !key.zzd()) {
            if (value instanceof zzju) {
                return zzir.zza(entry.getKey().zza(), (zzju) value);
            }
            return zzir.zza(entry.getKey().zza(), (zzkq) value);
        }
        return zza((zzjc<?>) key, value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzjc<T>> zzja<T> zzb() {
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzja zzjaVar = new zzja();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zzjaVar.zzb((zzjc) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it2 = this.zza.zzc().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            zzjaVar.zzb((zzjc) entry.getKey(), entry.getValue());
        }
        zzjaVar.zzd = this.zzd;
        return zzjaVar;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzkz) {
            return ((zzkz) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzju)) {
            return obj;
        }
        throw new NoSuchMethodError();
    }

    final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zzd) {
            return new zzjz(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzd) {
            return new zzjz(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zzja() {
        this.zza = zzln.zza(16);
    }

    private zzja(zzln<T, Object> zzlnVar) {
        this.zza = zzlnVar;
        zze();
    }

    private zzja(boolean z) {
        this(zzln.zza(0));
        zze();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            if (entryZzb.getValue() instanceof zzjk) {
                ((zzjk) entryZzb.getValue()).zzch();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zza(zzja<T> zzjaVar) {
        for (int i = 0; i < zzjaVar.zza.zzb(); i++) {
            zzb((Map.Entry) zzjaVar.zza.zzb(i));
        }
        Iterator it2 = zzjaVar.zza.zzc().iterator();
        while (it2.hasNext()) {
            zzb((Map.Entry) it2.next());
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzkq zzkqVarZzag;
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzju;
        if (key.zze()) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objZza = zza((zzjc) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it2 = ((List) value).iterator();
            while (it2.hasNext()) {
                ((List) objZza).add(zza(it2.next()));
            }
            this.zza.put(key, objZza);
            return;
        }
        if (key.zzc() != zzmy.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(key, zza(value));
            return;
        }
        Object objZza2 = zza((zzjc) key);
        if (objZza2 == null) {
            this.zza.put(key, zza(value));
            if (z) {
                this.zzd = true;
                return;
            }
            return;
        }
        if (z) {
            throw new NoSuchMethodError();
        }
        if (objZza2 instanceof zzkz) {
            zzkqVarZzag = key.zza((zzkz) objZza2, (zzkz) value);
        } else {
            zzkqVarZzag = key.zza(((zzkq) objZza2).zzcg(), (zzkq) value).zzag();
        }
        this.zza.put(key, zzkqVarZzag);
    }

    private final void zzb(T t, Object obj) {
        if (t.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zzc(t, obj2);
            }
            obj = arrayList;
        } else {
            zzc(t, obj);
        }
        if (obj instanceof zzju) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    private static void zzc(T t, Object obj) {
        zzmo zzmoVarZzb = t.zzb();
        zzjn.zza(obj);
        boolean z = true;
        switch (zzjd.zza[zzmoVarZzb.zzb().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzhx) && !(obj instanceof byte[])) {
                    z = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzjm)) {
                    z = false;
                }
                break;
            case 9:
                if (!(obj instanceof zzkq) && !(obj instanceof zzju)) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zza()), t.zzb().zzb(), obj.getClass().getName()));
        }
    }

    static void zza(zzir zzirVar, zzmo zzmoVar, int i, Object obj) throws IOException {
        if (zzmoVar == zzmo.zzj) {
            zzkq zzkqVar = (zzkq) obj;
            zzjn.zza(zzkqVar);
            zzirVar.zzj(i, 3);
            zzkqVar.zza(zzirVar);
            zzirVar.zzj(i, 4);
        }
        zzirVar.zzj(i, zzmoVar.zza());
        switch (zzjd.zzb[zzmoVar.ordinal()]) {
            case 1:
                zzirVar.zzb(((Double) obj).doubleValue());
                break;
            case 2:
                zzirVar.zzb(((Float) obj).floatValue());
                break;
            case 3:
                zzirVar.zzh(((Long) obj).longValue());
                break;
            case 4:
                zzirVar.zzh(((Long) obj).longValue());
                break;
            case 5:
                zzirVar.zzi(((Integer) obj).intValue());
                break;
            case 6:
                zzirVar.zzf(((Long) obj).longValue());
                break;
            case 7:
                zzirVar.zzh(((Integer) obj).intValue());
                break;
            case 8:
                zzirVar.zzb(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzkq) obj).zza(zzirVar);
                break;
            case 10:
                zzirVar.zzc((zzkq) obj);
                break;
            case 11:
                if (obj instanceof zzhx) {
                    zzirVar.zzb((zzhx) obj);
                } else {
                    zzirVar.zzb((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzhx) {
                    zzirVar.zzb((zzhx) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzirVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzirVar.zzk(((Integer) obj).intValue());
                break;
            case 14:
                zzirVar.zzh(((Integer) obj).intValue());
                break;
            case 15:
                zzirVar.zzf(((Long) obj).longValue());
                break;
            case 16:
                zzirVar.zzj(((Integer) obj).intValue());
                break;
            case 17:
                zzirVar.zzg(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzjm) {
                    zzirVar.zzi(((zzjm) obj).zza());
                } else {
                    zzirVar.zzi(((Integer) obj).intValue());
                }
                break;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzja) {
            return this.zza.equals(((zzja) obj).zza);
        }
        return false;
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzc(this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it2 = this.zza.zzc().iterator();
        while (it2.hasNext()) {
            if (!zzc((Map.Entry) it2.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzjc<T>> boolean zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() != zzmy.MESSAGE) {
            return true;
        }
        if (key.zze()) {
            Iterator it2 = ((List) entry.getValue()).iterator();
            while (it2.hasNext()) {
                if (!zzb(it2.next())) {
                    return false;
                }
            }
            return true;
        }
        return zzb(entry.getValue());
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzks) {
            return ((zzks) obj).mo2383i_();
        }
        if (obj instanceof zzju) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
