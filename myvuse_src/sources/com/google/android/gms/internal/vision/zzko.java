package com.google.android.gms.internal.vision;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import com.facebook.soloader.Elf64_Ehdr;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzko<T> implements zzlc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzma.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzkk zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzks zzo;
    private final zzju zzp;
    private final zzlu<?, ?> zzq;
    private final zziq<?> zzr;
    private final zzkh zzs;

    private zzko(int[] iArr, Object[] objArr, int i, int i2, zzkk zzkkVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzks zzksVar, zzju zzjuVar, zzlu<?, ?> zzluVar, zziq<?> zziqVar, zzkh zzkhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzkkVar instanceof zzjb;
        this.zzj = z;
        this.zzh = zziqVar != null && zziqVar.zza(zzkkVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzksVar;
        this.zzp = zzjuVar;
        this.zzq = zzluVar;
        this.zzr = zziqVar;
        this.zzg = zzkkVar;
        this.zzs = zzkhVar;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0388  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.android.gms.internal.vision.zzko<T> zza(java.lang.Class<T> r31, com.google.android.gms.internal.vision.zzki r32, com.google.android.gms.internal.vision.zzks r33, com.google.android.gms.internal.vision.zzju r34, com.google.android.gms.internal.vision.zzlu<?, ?> r35, com.google.android.gms.internal.vision.zziq<?> r36, com.google.android.gms.internal.vision.zzkh r37) {
        /*
            Method dump skipped, instruction units count: 1037
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Class, com.google.android.gms.internal.vision.zzki, com.google.android.gms.internal.vision.zzks, com.google.android.gms.internal.vision.zzju, com.google.android.gms.internal.vision.zzlu, com.google.android.gms.internal.vision.zziq, com.google.android.gms.internal.vision.zzkh):com.google.android.gms.internal.vision.zzko");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            throw new RuntimeException(new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length()).append("Field ").append(str).append(" for ").append(name).append(" not found. Known fields are ").append(string).toString());
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.vision.zzlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(T r10, T r11) {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final int zza(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzd = zzd(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzd;
            int iHashCode = 37;
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzjf.zza(Double.doubleToLongBits(zzma.zze(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzma.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzjf.zza(zzma.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzjf.zza(zzma.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzma.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzjf.zza(zzma.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzma.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzjf.zza(zzma.zzc(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzma.zzf(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZzf = zzma.zzf(t, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzma.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzma.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzma.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzma.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzjf.zza(zzma.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzma.zza(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzjf.zza(zzma.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZzf2 = zzma.zzf(t, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i2 * 53;
                    iZza = zzma.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzma.zzf(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(Double.doubleToLongBits(zzb(t, j)));
                        i2 = i + iZza;
                    }
                    break;
                case 52:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzc(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 54:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 56:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 57:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case Elf64_Ehdr.e_shentsize /* 58 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(zzf(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 59:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzma.zzf(t, j)).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 60:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzma.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzma.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 64:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 65:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzd(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjf.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 68:
                    if (zza(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzma.zzf(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzq.zzb(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzr.zza(t).hashCode() : iHashCode2;
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zzb(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzd = zzd(i);
            long j = 1048575 & iZzd;
            int i2 = this.zzc[i];
            switch ((iZzd & 267386880) >>> 20) {
                case 0:
                    if (zza((Object) t2, i)) {
                        zzma.zza(t, j, zzma.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 1:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 2:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 3:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 4:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 5:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 6:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 7:
                    if (zza((Object) t2, i)) {
                        zzma.zza(t, j, zzma.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 8:
                    if (zza((Object) t2, i)) {
                        zzma.zza(t, j, zzma.zzf(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((Object) t2, i)) {
                        zzma.zza(t, j, zzma.zzf(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 11:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 12:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 13:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 14:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 15:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 16:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzle.zza(this.zzs, t, t2, j);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case 52:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case 54:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case Elf64_Ehdr.e_shentsize /* 58 */:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzma.zza(t, j, zzma.zzf(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zza(t2, i2, i)) {
                        zzma.zza(t, j, zzma.zzf(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzle.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzle.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long jZzd = zzd(i) & 1048575;
        if (zza((Object) t2, i)) {
            Object objZzf = zzma.zzf(t, jZzd);
            Object objZzf2 = zzma.zzf(t2, jZzd);
            if (objZzf != null && objZzf2 != null) {
                zzma.zza(t, jZzd, zzjf.zza(objZzf, objZzf2));
                zzb((Object) t, i);
            } else if (objZzf2 != null) {
                zzma.zza(t, jZzd, objZzf2);
                zzb((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int iZzd = zzd(i);
        int i2 = this.zzc[i];
        long j = iZzd & 1048575;
        if (zza(t2, i2, i)) {
            Object objZzf = zza(t, i2, i) ? zzma.zzf(t, j) : null;
            Object objZzf2 = zzma.zzf(t2, j);
            if (objZzf != null && objZzf2 != null) {
                zzma.zza(t, j, zzjf.zza(objZzf, objZzf2));
                zzb(t, i2, i);
            } else if (objZzf2 != null) {
                zzma.zza(t, j, objZzf2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0809 A[PHI: r5
      0x0809: PHI (r5v4 int) = 
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v16 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v17 int)
      (r5v1 int)
     binds: [B:204:0x04b2, B:366:0x08ad, B:360:0x0891, B:357:0x087f, B:354:0x0870, B:351:0x0863, B:348:0x0856, B:344:0x084b, B:341:0x0840, B:338:0x0833, B:335:0x0826, B:332:0x0813, B:305:0x0722, B:302:0x070d, B:299:0x06f8, B:296:0x06e3, B:293:0x06ce, B:290:0x06b9, B:287:0x06a3, B:284:0x068d, B:281:0x0677, B:278:0x0661, B:275:0x064b, B:272:0x0635, B:269:0x061f, B:266:0x0609, B:261:0x05d5, B:258:0x05c8, B:255:0x05b8, B:252:0x05a8, B:249:0x0598, B:246:0x058a, B:243:0x057d, B:240:0x0570, B:234:0x0552, B:231:0x053e, B:228:0x052c, B:225:0x051c, B:222:0x050c, B:346:0x0852, B:219:0x04ff, B:216:0x04f1, B:213:0x04e1, B:210:0x04d1, B:327:0x0808, B:207:0x04bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.vision.zzlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(T r19) {
        /*
            Method dump skipped, instruction units count: 2726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zzb(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzlu<UT, UB> zzluVar, T t) {
        return zzluVar.zzf(zzluVar.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzma.zzf(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.vision.zzlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r14, com.google.android.gms.internal.vision.zzmr r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 2916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, com.google.android.gms.internal.vision.zzmr):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzb(T r18, com.google.android.gms.internal.vision.zzmr r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zzb(java.lang.Object, com.google.android.gms.internal.vision.zzmr):void");
    }

    private final <K, V> void zza(zzmr zzmrVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzmrVar.zza(i, this.zzs.zzb(zzb(i2)), this.zzs.zzc(obj));
        }
    }

    private static <UT, UB> void zza(zzlu<UT, UB> zzluVar, T t, zzmr zzmrVar) throws IOException {
        zzluVar.zza(zzluVar.zzb(t), zzmrVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05cc A[LOOP:5: B:162:0x05c8->B:164:0x05cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05d9  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.vision.zzlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r13, com.google.android.gms.internal.vision.zzld r14, com.google.android.gms.internal.vision.zzio r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, com.google.android.gms.internal.vision.zzld, com.google.android.gms.internal.vision.zzio):void");
    }

    private static zzlx zze(Object obj) {
        zzjb zzjbVar = (zzjb) obj;
        zzlx zzlxVar = zzjbVar.zzb;
        if (zzlxVar != zzlx.zza()) {
            return zzlxVar;
        }
        zzlx zzlxVarZzb = zzlx.zzb();
        zzjbVar.zzb = zzlxVarZzb;
        return zzlxVarZzb;
    }

    private static int zza(byte[] bArr, int i, int i2, zzml zzmlVar, Class<?> cls, zzhn zzhnVar) throws IOException {
        switch (zzkr.zza[zzmlVar.ordinal()]) {
            case 1:
                int iZzb = zzhl.zzb(bArr, i, zzhnVar);
                zzhnVar.zzc = Boolean.valueOf(zzhnVar.zzb != 0);
                return iZzb;
            case 2:
                return zzhl.zze(bArr, i, zzhnVar);
            case 3:
                zzhnVar.zzc = Double.valueOf(zzhl.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzhnVar.zzc = Integer.valueOf(zzhl.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzhnVar.zzc = Long.valueOf(zzhl.zzb(bArr, i));
                return i + 8;
            case 8:
                zzhnVar.zzc = Float.valueOf(zzhl.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZza = zzhl.zza(bArr, i, zzhnVar);
                zzhnVar.zzc = Integer.valueOf(zzhnVar.zza);
                return iZza;
            case 12:
            case 13:
                int iZzb2 = zzhl.zzb(bArr, i, zzhnVar);
                zzhnVar.zzc = Long.valueOf(zzhnVar.zzb);
                return iZzb2;
            case 14:
                return zzhl.zza(zzky.zza().zza((Class) cls), bArr, i, i2, zzhnVar);
            case 15:
                int iZza2 = zzhl.zza(bArr, i, zzhnVar);
                zzhnVar.zzc = Integer.valueOf(zzif.zze(zzhnVar.zza));
                return iZza2;
            case 16:
                int iZzb3 = zzhl.zzb(bArr, i, zzhnVar);
                zzhnVar.zzc = Long.valueOf(zzif.zza(zzhnVar.zzb));
                return iZzb3;
            case 17:
                return zzhl.zzd(bArr, i, zzhnVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzhn zzhnVar) throws IOException {
        int iZza;
        int iZza2 = i;
        Unsafe unsafe = zzb;
        zzjl zzjlVarZza = (zzjl) unsafe.getObject(t, j2);
        if (!zzjlVarZza.zza()) {
            int size = zzjlVarZza.size();
            zzjlVarZza = zzjlVarZza.zza(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzjlVarZza);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzin zzinVar = (zzin) zzjlVarZza;
                    int iZza3 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i8 = zzhnVar.zza + iZza3;
                    while (iZza3 < i8) {
                        zzinVar.zza(zzhl.zzc(bArr, iZza3));
                        iZza3 += 8;
                    }
                    if (iZza3 == i8) {
                        return iZza3;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 1) {
                    zzin zzinVar2 = (zzin) zzjlVarZza;
                    zzinVar2.zza(zzhl.zzc(bArr, i));
                    while (true) {
                        int i9 = iZza2 + 8;
                        if (i9 >= i2) {
                            return i9;
                        }
                        iZza2 = zzhl.zza(bArr, i9, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return i9;
                        }
                        zzinVar2.zza(zzhl.zzc(bArr, iZza2));
                    }
                }
                return iZza2;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzja zzjaVar = (zzja) zzjlVarZza;
                    int iZza4 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i10 = zzhnVar.zza + iZza4;
                    while (iZza4 < i10) {
                        zzjaVar.zza(zzhl.zzd(bArr, iZza4));
                        iZza4 += 4;
                    }
                    if (iZza4 == i10) {
                        return iZza4;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 5) {
                    zzja zzjaVar2 = (zzja) zzjlVarZza;
                    zzjaVar2.zza(zzhl.zzd(bArr, i));
                    while (true) {
                        int i11 = iZza2 + 4;
                        if (i11 >= i2) {
                            return i11;
                        }
                        iZza2 = zzhl.zza(bArr, i11, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return i11;
                        }
                        zzjaVar2.zza(zzhl.zzd(bArr, iZza2));
                    }
                }
                return iZza2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzjy zzjyVar = (zzjy) zzjlVarZza;
                    int iZza5 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i12 = zzhnVar.zza + iZza5;
                    while (iZza5 < i12) {
                        iZza5 = zzhl.zzb(bArr, iZza5, zzhnVar);
                        zzjyVar.zza(zzhnVar.zzb);
                    }
                    if (iZza5 == i12) {
                        return iZza5;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 0) {
                    zzjy zzjyVar2 = (zzjy) zzjlVarZza;
                    int iZzb = zzhl.zzb(bArr, iZza2, zzhnVar);
                    zzjyVar2.zza(zzhnVar.zzb);
                    while (iZzb < i2) {
                        int iZza6 = zzhl.zza(bArr, iZzb, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return iZzb;
                        }
                        iZzb = zzhl.zzb(bArr, iZza6, zzhnVar);
                        zzjyVar2.zza(zzhnVar.zzb);
                    }
                    return iZzb;
                }
                return iZza2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzhl.zza(bArr, iZza2, (zzjl<?>) zzjlVarZza, zzhnVar);
                }
                if (i5 == 0) {
                    return zzhl.zza(i3, bArr, i, i2, (zzjl<?>) zzjlVarZza, zzhnVar);
                }
                return iZza2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzjy zzjyVar3 = (zzjy) zzjlVarZza;
                    int iZza7 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i13 = zzhnVar.zza + iZza7;
                    while (iZza7 < i13) {
                        zzjyVar3.zza(zzhl.zzb(bArr, iZza7));
                        iZza7 += 8;
                    }
                    if (iZza7 == i13) {
                        return iZza7;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 1) {
                    zzjy zzjyVar4 = (zzjy) zzjlVarZza;
                    zzjyVar4.zza(zzhl.zzb(bArr, i));
                    while (true) {
                        int i14 = iZza2 + 8;
                        if (i14 >= i2) {
                            return i14;
                        }
                        iZza2 = zzhl.zza(bArr, i14, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return i14;
                        }
                        zzjyVar4.zza(zzhl.zzb(bArr, iZza2));
                    }
                }
                return iZza2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzjd zzjdVar = (zzjd) zzjlVarZza;
                    int iZza8 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i15 = zzhnVar.zza + iZza8;
                    while (iZza8 < i15) {
                        zzjdVar.zzc(zzhl.zza(bArr, iZza8));
                        iZza8 += 4;
                    }
                    if (iZza8 == i15) {
                        return iZza8;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 5) {
                    zzjd zzjdVar2 = (zzjd) zzjlVarZza;
                    zzjdVar2.zzc(zzhl.zza(bArr, i));
                    while (true) {
                        int i16 = iZza2 + 4;
                        if (i16 >= i2) {
                            return i16;
                        }
                        iZza2 = zzhl.zza(bArr, i16, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return i16;
                        }
                        zzjdVar2.zzc(zzhl.zza(bArr, iZza2));
                    }
                }
                return iZza2;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzhr zzhrVar = (zzhr) zzjlVarZza;
                    iZza = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i17 = zzhnVar.zza + iZza;
                    while (iZza < i17) {
                        iZza = zzhl.zzb(bArr, iZza, zzhnVar);
                        zzhrVar.zza(zzhnVar.zzb != 0);
                    }
                    if (iZza != i17) {
                        throw zzjk.zza();
                    }
                    return iZza;
                }
                if (i5 == 0) {
                    zzhr zzhrVar2 = (zzhr) zzjlVarZza;
                    iZza2 = zzhl.zzb(bArr, iZza2, zzhnVar);
                    zzhrVar2.zza(zzhnVar.zzb != 0);
                    while (iZza2 < i2) {
                        int iZza9 = zzhl.zza(bArr, iZza2, zzhnVar);
                        if (i3 == zzhnVar.zza) {
                            iZza2 = zzhl.zzb(bArr, iZza9, zzhnVar);
                            zzhrVar2.zza(zzhnVar.zzb != 0);
                        }
                    }
                }
                return iZza2;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZza10 = zzhl.zza(bArr, iZza2, zzhnVar);
                        int i18 = zzhnVar.zza;
                        if (i18 < 0) {
                            throw zzjk.zzb();
                        }
                        if (i18 == 0) {
                            zzjlVarZza.add("");
                        } else {
                            zzjlVarZza.add(new String(bArr, iZza10, i18, zzjf.zza));
                            iZza10 += i18;
                        }
                        while (iZza10 < i2) {
                            int iZza11 = zzhl.zza(bArr, iZza10, zzhnVar);
                            if (i3 != zzhnVar.zza) {
                                return iZza10;
                            }
                            iZza10 = zzhl.zza(bArr, iZza11, zzhnVar);
                            int i19 = zzhnVar.zza;
                            if (i19 < 0) {
                                throw zzjk.zzb();
                            }
                            if (i19 == 0) {
                                zzjlVarZza.add("");
                            } else {
                                zzjlVarZza.add(new String(bArr, iZza10, i19, zzjf.zza));
                                iZza10 += i19;
                            }
                        }
                        return iZza10;
                    }
                    int iZza12 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i20 = zzhnVar.zza;
                    if (i20 < 0) {
                        throw zzjk.zzb();
                    }
                    if (i20 == 0) {
                        zzjlVarZza.add("");
                    } else {
                        int i21 = iZza12 + i20;
                        if (!zzmd.zza(bArr, iZza12, i21)) {
                            throw zzjk.zzh();
                        }
                        zzjlVarZza.add(new String(bArr, iZza12, i20, zzjf.zza));
                        iZza12 = i21;
                    }
                    while (iZza12 < i2) {
                        int iZza13 = zzhl.zza(bArr, iZza12, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return iZza12;
                        }
                        iZza12 = zzhl.zza(bArr, iZza13, zzhnVar);
                        int i22 = zzhnVar.zza;
                        if (i22 < 0) {
                            throw zzjk.zzb();
                        }
                        if (i22 == 0) {
                            zzjlVarZza.add("");
                        } else {
                            int i23 = iZza12 + i22;
                            if (!zzmd.zza(bArr, iZza12, i23)) {
                                throw zzjk.zzh();
                            }
                            zzjlVarZza.add(new String(bArr, iZza12, i22, zzjf.zza));
                            iZza12 = i23;
                        }
                    }
                    return iZza12;
                }
                return iZza2;
            case 27:
                if (i5 == 2) {
                    return zzhl.zza(zza(i6), i3, bArr, i, i2, zzjlVarZza, zzhnVar);
                }
                return iZza2;
            case 28:
                if (i5 == 2) {
                    int iZza14 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i24 = zzhnVar.zza;
                    if (i24 < 0) {
                        throw zzjk.zzb();
                    }
                    if (i24 > bArr.length - iZza14) {
                        throw zzjk.zza();
                    }
                    if (i24 == 0) {
                        zzjlVarZza.add(zzht.zza);
                    } else {
                        zzjlVarZza.add(zzht.zza(bArr, iZza14, i24));
                        iZza14 += i24;
                    }
                    while (iZza14 < i2) {
                        int iZza15 = zzhl.zza(bArr, iZza14, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return iZza14;
                        }
                        iZza14 = zzhl.zza(bArr, iZza15, zzhnVar);
                        int i25 = zzhnVar.zza;
                        if (i25 < 0) {
                            throw zzjk.zzb();
                        }
                        if (i25 > bArr.length - iZza14) {
                            throw zzjk.zza();
                        }
                        if (i25 == 0) {
                            zzjlVarZza.add(zzht.zza);
                        } else {
                            zzjlVarZza.add(zzht.zza(bArr, iZza14, i25));
                            iZza14 += i25;
                        }
                    }
                    return iZza14;
                }
                return iZza2;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZza = zzhl.zza(i3, bArr, i, i2, (zzjl<?>) zzjlVarZza, zzhnVar);
                    }
                    return iZza2;
                }
                iZza = zzhl.zza(bArr, iZza2, (zzjl<?>) zzjlVarZza, zzhnVar);
                zzjb zzjbVar = (zzjb) t;
                zzlx zzlxVar = zzjbVar.zzb;
                if (zzlxVar == zzlx.zza()) {
                    zzlxVar = null;
                }
                zzlx zzlxVar2 = (zzlx) zzle.zza(i4, zzjlVarZza, zzc(i6), zzlxVar, this.zzq);
                if (zzlxVar2 != null) {
                    zzjbVar.zzb = zzlxVar2;
                }
                return iZza;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzjd zzjdVar3 = (zzjd) zzjlVarZza;
                    int iZza16 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i26 = zzhnVar.zza + iZza16;
                    while (iZza16 < i26) {
                        iZza16 = zzhl.zza(bArr, iZza16, zzhnVar);
                        zzjdVar3.zzc(zzif.zze(zzhnVar.zza));
                    }
                    if (iZza16 == i26) {
                        return iZza16;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 0) {
                    zzjd zzjdVar4 = (zzjd) zzjlVarZza;
                    int iZza17 = zzhl.zza(bArr, iZza2, zzhnVar);
                    zzjdVar4.zzc(zzif.zze(zzhnVar.zza));
                    while (iZza17 < i2) {
                        int iZza18 = zzhl.zza(bArr, iZza17, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return iZza17;
                        }
                        iZza17 = zzhl.zza(bArr, iZza18, zzhnVar);
                        zzjdVar4.zzc(zzif.zze(zzhnVar.zza));
                    }
                    return iZza17;
                }
                return iZza2;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzjy zzjyVar5 = (zzjy) zzjlVarZza;
                    int iZza19 = zzhl.zza(bArr, iZza2, zzhnVar);
                    int i27 = zzhnVar.zza + iZza19;
                    while (iZza19 < i27) {
                        iZza19 = zzhl.zzb(bArr, iZza19, zzhnVar);
                        zzjyVar5.zza(zzif.zza(zzhnVar.zzb));
                    }
                    if (iZza19 == i27) {
                        return iZza19;
                    }
                    throw zzjk.zza();
                }
                if (i5 == 0) {
                    zzjy zzjyVar6 = (zzjy) zzjlVarZza;
                    int iZzb2 = zzhl.zzb(bArr, iZza2, zzhnVar);
                    zzjyVar6.zza(zzif.zza(zzhnVar.zzb));
                    while (iZzb2 < i2) {
                        int iZza20 = zzhl.zza(bArr, iZzb2, zzhnVar);
                        if (i3 != zzhnVar.zza) {
                            return iZzb2;
                        }
                        iZzb2 = zzhl.zzb(bArr, iZza20, zzhnVar);
                        zzjyVar6.zza(zzif.zza(zzhnVar.zzb));
                    }
                    return iZzb2;
                }
                return iZza2;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                if (i5 == 3) {
                    zzlc zzlcVarZza = zza(i6);
                    int i28 = (i3 & (-8)) | 4;
                    iZza2 = zzhl.zza(zzlcVarZza, bArr, i, i2, i28, zzhnVar);
                    zzjlVarZza.add(zzhnVar.zzc);
                    while (iZza2 < i2) {
                        int iZza21 = zzhl.zza(bArr, iZza2, zzhnVar);
                        if (i3 == zzhnVar.zza) {
                            iZza2 = zzhl.zza(zzlcVarZza, bArr, iZza21, i2, i28, zzhnVar);
                            zzjlVarZza.add(zzhnVar.zzc);
                        }
                    }
                }
                return iZza2;
            default:
                return iZza2;
        }
    }

    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzhn zzhnVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzb = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzd(object)) {
            Object objZzf = this.zzs.zzf(objZzb);
            this.zzs.zza(objZzf, object);
            unsafe.putObject(t, j, objZzf);
            object = objZzf;
        }
        zzkf<?, ?> zzkfVarZzb = this.zzs.zzb(objZzb);
        Map<?, ?> mapZza = this.zzs.zza(object);
        int iZza = zzhl.zza(bArr, i, zzhnVar);
        int i4 = zzhnVar.zza;
        if (i4 < 0 || i4 > i2 - iZza) {
            throw zzjk.zza();
        }
        int i5 = i4 + iZza;
        K k = zzkfVarZzb.zzb;
        V v = zzkfVarZzb.zzd;
        while (iZza < i5) {
            int iZza2 = iZza + 1;
            int i6 = bArr[iZza];
            if (i6 < 0) {
                iZza2 = zzhl.zza(i6, bArr, iZza2, zzhnVar);
                i6 = zzhnVar.zza;
            }
            int i7 = iZza2;
            int i8 = i6 >>> 3;
            int i9 = i6 & 7;
            if (i8 == 1) {
                if (i9 == zzkfVarZzb.zza.zzb()) {
                    iZza = zza(bArr, i7, i2, zzkfVarZzb.zza, (Class<?>) null, zzhnVar);
                    k = (K) zzhnVar.zzc;
                } else {
                    iZza = zzhl.zza(i6, bArr, i7, i2, zzhnVar);
                }
            } else if (i8 == 2 && i9 == zzkfVarZzb.zzc.zzb()) {
                iZza = zza(bArr, i7, i2, zzkfVarZzb.zzc, zzkfVarZzb.zzd.getClass(), zzhnVar);
                v = zzhnVar.zzc;
            } else {
                iZza = zzhl.zza(i6, bArr, i7, i2, zzhnVar);
            }
        }
        if (iZza != i5) {
            throw zzjk.zzg();
        }
        mapZza.put(k, v);
        return i5;
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzhn zzhnVar) throws IOException {
        int iZzb;
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(zzhl.zzc(bArr, i)));
                iZzb = i + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(zzhl.zzd(bArr, i)));
                iZzb = i + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzhl.zzb(bArr, i, zzhnVar);
                unsafe.putObject(t, j, Long.valueOf(zzhnVar.zzb));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case Elf64_Ehdr.e_shstrndx /* 62 */:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzhl.zza(bArr, i, zzhnVar);
                unsafe.putObject(t, j, Integer.valueOf(zzhnVar.zza));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(zzhl.zzb(bArr, i)));
                iZzb = i + 8;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(zzhl.zza(bArr, i)));
                iZzb = i + 4;
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case Elf64_Ehdr.e_shentsize /* 58 */:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzhl.zzb(bArr, i, zzhnVar);
                unsafe.putObject(t, j, Boolean.valueOf(zzhnVar.zzb != 0));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzhl.zza(bArr, i, zzhnVar);
                int i9 = zzhnVar.zza;
                if (i9 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzmd.zza(bArr, iZza, iZza + i9)) {
                        throw zzjk.zzh();
                    }
                    unsafe.putObject(t, j, new String(bArr, iZza, i9, zzjf.zza));
                    iZza += i9;
                }
                unsafe.putInt(t, j2, i4);
                return iZza;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iZza2 = zzhl.zza(zza(i8), bArr, i, i2, zzhnVar);
                Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, zzhnVar.zzc);
                } else {
                    unsafe.putObject(t, j, zzjf.zza(object, zzhnVar.zzc));
                }
                unsafe.putInt(t, j2, i4);
                return iZza2;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                if (i5 != 2) {
                    return i;
                }
                iZzb = zzhl.zze(bArr, i, zzhnVar);
                unsafe.putObject(t, j, zzhnVar.zzc);
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                if (i5 != 0) {
                    return i;
                }
                int iZza3 = zzhl.zza(bArr, i, zzhnVar);
                int i10 = zzhnVar.zza;
                zzjg zzjgVarZzc = zzc(i8);
                if (zzjgVarZzc == null || zzjgVarZzc.zza(i10)) {
                    unsafe.putObject(t, j, Integer.valueOf(i10));
                    iZzb = iZza3;
                    unsafe.putInt(t, j2, i4);
                    return iZzb;
                }
                zze(t).zza(i3, Long.valueOf(i10));
                return iZza3;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzhl.zza(bArr, i, zzhnVar);
                unsafe.putObject(t, j, Integer.valueOf(zzif.zze(zzhnVar.zza)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (i5 != 0) {
                    return i;
                }
                iZzb = zzhl.zzb(bArr, i, zzhnVar);
                unsafe.putObject(t, j, Long.valueOf(zzif.zza(zzhnVar.zzb)));
                unsafe.putInt(t, j2, i4);
                return iZzb;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                iZzb = zzhl.zza(zza(i8), bArr, i, i2, (i3 & (-8)) | 4, zzhnVar);
                Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                if (object2 == null) {
                    unsafe.putObject(t, j, zzhnVar.zzc);
                } else {
                    unsafe.putObject(t, j, zzjf.zza(object2, zzhnVar.zzc));
                }
                unsafe.putInt(t, j2, i4);
                return iZzb;
            default:
                return i;
        }
    }

    private final zzlc zza(int i) {
        int i2 = (i / 3) << 1;
        zzlc zzlcVar = (zzlc) this.zzd[i2];
        if (zzlcVar != null) {
            return zzlcVar;
        }
        zzlc<T> zzlcVarZza = zzky.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzlcVarZza;
        return zzlcVarZza;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzjg zzc(int i) {
        return (zzjg) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:197:0x065a, code lost:
    
        if (r2 == r4) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x065c, code lost:
    
        r31.putInt(r13, r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0662, code lost:
    
        r2 = r8.zzm;
        r4 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0667, code lost:
    
        if (r2 >= r8.zzn) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0669, code lost:
    
        r4 = (com.google.android.gms.internal.vision.zzlx) r8.zza(r13, r8.zzl[r2], r4, (com.google.android.gms.internal.vision.zzlu<UT, com.google.android.gms.internal.vision.zzlx>) r8.zzq);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0679, code lost:
    
        if (r4 == null) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x067b, code lost:
    
        r8.zzq.zzb(r13, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0680, code lost:
    
        if (r9 != 0) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0682, code lost:
    
        if (r0 != r6) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0689, code lost:
    
        throw com.google.android.gms.internal.vision.zzjk.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x068a, code lost:
    
        if (r0 > r6) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x068c, code lost:
    
        if (r3 != r9) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x068e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0693, code lost:
    
        throw com.google.android.gms.internal.vision.zzjk.zzg();
     */
    /* JADX WARN: Removed duplicated region for block: B:178:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zza(T r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.vision.zzhn r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.zzhn):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02d1, code lost:
    
        if (r0 == r5) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02d5, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r10 = r20;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x031a, code lost:
    
        if (r0 == r15) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x033d, code lost:
    
        if (r0 == r15) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x033f, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0094. Please report as an issue. */
    @Override // com.google.android.gms.internal.vision.zzlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.vision.zzhn r35) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 956
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzhn):void");
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long jZzd = zzd(this.zzl[i2]) & 1048575;
            Object objZzf = zzma.zzf(t, jZzd);
            if (objZzf != null) {
                zzma.zza(t, jZzd, this.zzs.zze(objZzf));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzlu<UT, UB> zzluVar) {
        zzjg zzjgVarZzc;
        int i2 = this.zzc[i];
        Object objZzf = zzma.zzf(obj, zzd(i) & 1048575);
        return (objZzf == null || (zzjgVarZzc = zzc(i)) == null) ? ub : (UB) zza(i, i2, this.zzs.zza(objZzf), zzjgVarZzc, ub, zzluVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjg zzjgVar, UB ub, zzlu<UT, UB> zzluVar) {
        zzkf<?, ?> zzkfVarZzb = this.zzs.zzb(zzb(i));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            if (!zzjgVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzluVar.zza();
                }
                zzib zzibVarZzc = zzht.zzc(zzkc.zza(zzkfVarZzb, next.getKey(), next.getValue()));
                try {
                    zzkc.zza(zzibVarZzc.zzb(), zzkfVarZzb, next.getKey(), next.getValue());
                    zzluVar.zza(ub, i2, zzibVarZzc.zza());
                    it2.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.vision.zzlc] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.vision.zzlc] */
    @Override // com.google.android.gms.internal.vision.zzlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzd(T r18) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zzd(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzlc zzlcVar) {
        return zzlcVar.zzd(zzma.zzf(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzmr zzmrVar) throws IOException {
        if (obj instanceof String) {
            zzmrVar.zza(i, (String) obj);
        } else {
            zzmrVar.zza(i, (zzht) obj);
        }
    }

    private final void zza(Object obj, int i, zzld zzldVar) throws IOException {
        if (zzf(i)) {
            zzma.zza(obj, i & 1048575, zzldVar.zzm());
        } else if (this.zzi) {
            zzma.zza(obj, i & 1048575, zzldVar.zzl());
        } else {
            zzma.zza(obj, i & 1048575, zzldVar.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzma.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzma.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzma.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzma.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzma.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((Object) t, i) == zza((Object) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int iZze = zze(i);
        long j = iZze & 1048575;
        if (j != 1048575) {
            return (zzma.zza(t, j) & (1 << (iZze >>> 20))) != 0;
        }
        int iZzd = zzd(i);
        long j2 = iZzd & 1048575;
        switch ((iZzd & 267386880) >>> 20) {
            case 0:
                return zzma.zze(t, j2) != 0.0d;
            case 1:
                return zzma.zzd(t, j2) != 0.0f;
            case 2:
                return zzma.zzb(t, j2) != 0;
            case 3:
                return zzma.zzb(t, j2) != 0;
            case 4:
                return zzma.zza(t, j2) != 0;
            case 5:
                return zzma.zzb(t, j2) != 0;
            case 6:
                return zzma.zza(t, j2) != 0;
            case 7:
                return zzma.zzc(t, j2);
            case 8:
                Object objZzf = zzma.zzf(t, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzht) {
                    return !zzht.zza.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzma.zzf(t, j2) != null;
            case 10:
                return !zzht.zza.equals(zzma.zzf(t, j2));
            case 11:
                return zzma.zza(t, j2) != 0;
            case 12:
                return zzma.zza(t, j2) != 0;
            case 13:
                return zzma.zza(t, j2) != 0;
            case 14:
                return zzma.zzb(t, j2) != 0;
            case 15:
                return zzma.zza(t, j2) != 0;
            case 16:
                return zzma.zzb(t, j2) != 0;
            case 17:
                return zzma.zzf(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzb(T t, int i) {
        int iZze = zze(i);
        long j = 1048575 & iZze;
        if (j == 1048575) {
            return;
        }
        zzma.zza((Object) t, j, (1 << (iZze >>> 20)) | zzma.zza(t, j));
    }

    private final boolean zza(T t, int i, int i2) {
        return zzma.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzma.zza((Object) t, zze(i2) & 1048575, i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
