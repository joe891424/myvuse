package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
final class zzan<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Object zzd = new Object();

    @NullableDecl
    transient int[] zza;

    @NullableDecl
    transient Object[] zzb;

    @NullableDecl
    transient Object[] zzc;

    @NullableDecl
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;

    @NullableDecl
    private transient Set<K> zzh;

    @NullableDecl
    private transient Set<Map.Entry<K, V>> zzi;

    @NullableDecl
    private transient Collection<V> zzj;

    zzan() {
        zza(3);
    }

    static /* synthetic */ int zzn(zzan zzanVar) {
        int i = zzanVar.zzg;
        zzanVar.zzg = i - 1;
        return i;
    }

    private final void zzo(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & (-32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzp() {
        return (1 << (this.zzf & 31)) - 1;
    }

    private final int zzq(int i, int i2, int i3, int i4) {
        Object objZza = zzao.zza(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzao.zzc(objZza, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i6 = 0; i6 <= i; i6++) {
            int iZzb = zzao.zzb(obj, i6);
            while (iZzb != 0) {
                int i7 = iZzb - 1;
                int i8 = iArr[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iZzb2 = zzao.zzb(objZza, i10);
                zzao.zzc(objZza, i10, iZzb);
                iArr[i7] = ((~i5) & i9) | (iZzb2 & i5);
                iZzb = i8 & i;
            }
        }
        this.zze = objZza;
        zzo(i5);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzr(@NullableDecl Object obj) {
        if (zzb()) {
            return -1;
        }
        int iZza = zzap.zza(obj);
        int iZzp = zzp();
        int iZzb = zzao.zzb(this.zze, iZza & iZzp);
        if (iZzb != 0) {
            int i = ~iZzp;
            int i2 = iZza & i;
            do {
                int i3 = iZzb - 1;
                int i4 = this.zza[i3];
                if ((i4 & i) == i2 && zzg.zza(obj, this.zzb[i3])) {
                    return i3;
                }
                iZzb = i4 & iZzp;
            } while (iZzb != 0);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public final Object zzs(@NullableDecl Object obj) {
        if (zzb()) {
            return zzd;
        }
        int iZzp = zzp();
        int iZze = zzao.zze(obj, null, iZzp, this.zze, this.zza, this.zzb, null);
        if (iZze == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[iZze];
        zze(iZze, iZzp);
        this.zzg--;
        zzd();
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzb()) {
            return;
        }
        zzd();
        Map<K, V> mapZzc = zzc();
        if (mapZzc != null) {
            this.zzf = zzbp.zza(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            mapZzc.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(this.zzb, 0, this.zzg, (Object) null);
        Arrays.fill(this.zzc, 0, this.zzg, (Object) null);
        Object obj = this.zze;
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(this.zza, 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@NullableDecl Object obj) {
        Map<K, V> mapZzc = zzc();
        return mapZzc != null ? mapZzc.containsKey(obj) : zzr(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@NullableDecl Object obj) {
        Map<K, V> mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzg.zza(obj, this.zzc[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        zzai zzaiVar = new zzai(this);
        this.zzi = zzaiVar;
        return zzaiVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(@NullableDecl Object obj) {
        Map<K, V> mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.get(obj);
        }
        int iZzr = zzr(obj);
        if (iZzr == -1) {
            return null;
        }
        return (V) this.zzc[iZzr];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        zzak zzakVar = new zzak(this);
        this.zzh = zzakVar;
        return zzakVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V put(@NullableDecl K k, @NullableDecl V v) {
        int iMin;
        if (zzb()) {
            zzl.zza(zzb(), "Arrays already allocated");
            int i = this.zzf;
            int iMax = Math.max(i + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzao.zza(iMax2);
            zzo(iMax2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map<K, V> mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.put(k, v);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        Object[] objArr2 = this.zzc;
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int iZza = zzap.zza(k);
        int iZzp = zzp();
        int i4 = iZza & iZzp;
        int iZzb = zzao.zzb(this.zze, i4);
        if (iZzb != 0) {
            int i5 = ~iZzp;
            int i6 = iZza & i5;
            int i7 = 0;
            while (true) {
                int i8 = iZzb - 1;
                int i9 = iArr[i8];
                int i10 = i9 & i5;
                if (i10 == i6 && zzg.zza(k, objArr[i8])) {
                    V v2 = (V) objArr2[i8];
                    objArr2[i8] = v;
                    return v2;
                }
                int i11 = i9 & iZzp;
                i7++;
                if (i11 != 0) {
                    iZzb = i11;
                } else {
                    if (i7 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzp() + 1, 1.0f);
                        int iZzf = zzf();
                        while (iZzf >= 0) {
                            linkedHashMap.put(this.zzb[iZzf], this.zzc[iZzf]);
                            iZzf = zzg(iZzf);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzd();
                        return (V) linkedHashMap.put(k, v);
                    }
                    if (i3 > iZzp) {
                        iZzp = zzq(iZzp, zzao.zzd(iZzp), iZza, i2);
                    } else {
                        iArr[i8] = (i3 & iZzp) | i10;
                    }
                }
            }
        } else if (i3 > iZzp) {
            iZzp = zzq(iZzp, zzao.zzd(iZzp), iZza, i2);
        } else {
            zzao.zzc(this.zze, i4, i3);
        }
        int length = this.zza.length;
        if (i3 > length && (iMin = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(this.zza, iMin);
            this.zzb = Arrays.copyOf(this.zzb, iMin);
            this.zzc = Arrays.copyOf(this.zzc, iMin);
        }
        this.zza[i2] = (~iZzp) & iZza;
        this.zzb[i2] = k;
        this.zzc[i2] = v;
        this.zzg = i3;
        zzd();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map<K, V> mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.remove(obj);
        }
        V v = (V) zzs(obj);
        if (v == zzd) {
            return null;
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map<K, V> mapZzc = zzc();
        return mapZzc != null ? mapZzc.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzam zzamVar = new zzam(this);
        this.zzj = zzamVar;
        return zzamVar;
    }

    final void zza(int i) {
        this.zzf = zzbp.zza(12, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    final boolean zzb() {
        return this.zze == null;
    }

    @NullableDecl
    final Map<K, V> zzc() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void zzd() {
        this.zzf += 32;
    }

    final void zze(int i, int i2) {
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            this.zzb[i] = null;
            this.zzc[i] = null;
            this.zza[i] = 0;
            return;
        }
        Object[] objArr = this.zzb;
        Object obj = objArr[i3];
        objArr[i] = obj;
        Object[] objArr2 = this.zzc;
        objArr2[i] = objArr2[i3];
        objArr[i3] = null;
        objArr2[i3] = null;
        int[] iArr = this.zza;
        iArr[i] = iArr[i3];
        iArr[i3] = 0;
        int iZza = zzap.zza(obj) & i2;
        int iZzb = zzao.zzb(this.zze, iZza);
        if (iZzb == size) {
            zzao.zzc(this.zze, iZza, i + 1);
            return;
        }
        while (true) {
            int i4 = iZzb - 1;
            int[] iArr2 = this.zza;
            int i5 = iArr2[i4];
            int i6 = i5 & i2;
            if (i6 == size) {
                iArr2[i4] = ((i + 1) & i2) | ((~i2) & i5);
                return;
            }
            iZzb = i6;
        }
    }

    final int zzf() {
        return isEmpty() ? -1 : 0;
    }

    final int zzg(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    zzan(int i) {
        zza(12);
    }
}
