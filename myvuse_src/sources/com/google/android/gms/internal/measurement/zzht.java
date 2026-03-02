package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzht {
    static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    static int zza(byte[] bArr, int i, zzhw zzhwVar) throws zzjt {
        int iZzc = zzc(bArr, i, zzhwVar);
        int i2 = zzhwVar.zza;
        if (i2 < 0) {
            throw zzjt.zzf();
        }
        if (i2 > bArr.length - iZzc) {
            throw zzjt.zzh();
        }
        if (i2 == 0) {
            zzhwVar.zzc = zzhx.zza;
            return iZzc;
        }
        zzhwVar.zzc = zzhx.zza(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static int zza(zzli zzliVar, byte[] bArr, int i, int i2, int i3, zzhw zzhwVar) throws IOException {
        Object objZza = zzliVar.zza();
        int iZza = zza(objZza, zzliVar, bArr, i, i2, i3, zzhwVar);
        zzliVar.zzc(objZza);
        zzhwVar.zzc = objZza;
        return iZza;
    }

    static int zza(zzli zzliVar, byte[] bArr, int i, int i2, zzhw zzhwVar) throws IOException {
        Object objZza = zzliVar.zza();
        int iZza = zza(objZza, zzliVar, bArr, i, i2, zzhwVar);
        zzliVar.zzc(objZza);
        zzhwVar.zzc = objZza;
        return iZza;
    }

    static int zza(zzli<?> zzliVar, int i, byte[] bArr, int i2, int i3, zzjq<?> zzjqVar, zzhw zzhwVar) throws IOException {
        int iZza = zza(zzliVar, bArr, i2, i3, zzhwVar);
        zzjqVar.add(zzhwVar.zzc);
        while (iZza < i3) {
            int iZzc = zzc(bArr, iZza, zzhwVar);
            if (i != zzhwVar.zza) {
                break;
            }
            iZza = zza(zzliVar, bArr, iZzc, i3, zzhwVar);
            zzjqVar.add(zzhwVar.zzc);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzjq<?> zzjqVar, zzhw zzhwVar) throws IOException {
        zzjl zzjlVar = (zzjl) zzjqVar;
        int iZzc = zzc(bArr, i, zzhwVar);
        int i2 = zzhwVar.zza + iZzc;
        while (iZzc < i2) {
            iZzc = zzc(bArr, iZzc, zzhwVar);
            zzjlVar.zzd(zzhwVar.zza);
        }
        if (iZzc == i2) {
            return iZzc;
        }
        throw zzjt.zzh();
    }

    static int zzb(byte[] bArr, int i, zzhw zzhwVar) throws zzjt {
        int iZzc = zzc(bArr, i, zzhwVar);
        int i2 = zzhwVar.zza;
        if (i2 < 0) {
            throw zzjt.zzf();
        }
        if (i2 == 0) {
            zzhwVar.zzc = "";
            return iZzc;
        }
        zzhwVar.zzc = zzmi.zzb(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzmf zzmfVar, zzhw zzhwVar) throws zzjt {
        if ((i >>> 3) == 0) {
            throw zzjt.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzd = zzd(bArr, i2, zzhwVar);
            zzmfVar.zza(i, Long.valueOf(zzhwVar.zzb));
            return iZzd;
        }
        if (i4 == 1) {
            zzmfVar.zza(i, Long.valueOf(zzd(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzc = zzc(bArr, i2, zzhwVar);
            int i5 = zzhwVar.zza;
            if (i5 < 0) {
                throw zzjt.zzf();
            }
            if (i5 > bArr.length - iZzc) {
                throw zzjt.zzh();
            }
            if (i5 == 0) {
                zzmfVar.zza(i, zzhx.zza);
            } else {
                zzmfVar.zza(i, zzhx.zza(bArr, iZzc, i5));
            }
            return iZzc + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzmfVar.zza(i, Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            }
            throw zzjt.zzc();
        }
        zzmf zzmfVarZzd = zzmf.zzd();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzc2 = zzc(bArr, i2, zzhwVar);
            int i8 = zzhwVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzc2;
                break;
            }
            int iZza = zza(i7, bArr, iZzc2, i3, zzmfVarZzd, zzhwVar);
            i7 = i8;
            i2 = iZza;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzjt.zzg();
        }
        zzmfVar.zza(i, zzmfVarZzd);
        return i2;
    }

    static int zzc(byte[] bArr, int i, zzhw zzhwVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            zzhwVar.zza = b;
            return i2;
        }
        return zza(b, bArr, i2, zzhwVar);
    }

    static int zza(int i, byte[] bArr, int i2, zzhw zzhwVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzhwVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzhwVar.zza = i5 | (b2 << Ascii.f3757SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzhwVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzhwVar.zza = i9 | (b4 << Ascii.f3750FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzhwVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzjq<?> zzjqVar, zzhw zzhwVar) {
        zzjl zzjlVar = (zzjl) zzjqVar;
        int iZzc = zzc(bArr, i2, zzhwVar);
        zzjlVar.zzd(zzhwVar.zza);
        while (iZzc < i3) {
            int iZzc2 = zzc(bArr, iZzc, zzhwVar);
            if (i != zzhwVar.zza) {
                break;
            }
            iZzc = zzc(bArr, iZzc2, zzhwVar);
            zzjlVar.zzd(zzhwVar.zza);
        }
        return iZzc;
    }

    static int zzd(byte[] bArr, int i, zzhw zzhwVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzhwVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzhwVar.zzb = j2;
        return i3;
    }

    static int zza(Object obj, zzli zzliVar, byte[] bArr, int i, int i2, int i3, zzhw zzhwVar) throws IOException {
        int iZza = ((zzku) zzliVar).zza(obj, bArr, i, i2, i3, zzhwVar);
        zzhwVar.zzc = obj;
        return iZza;
    }

    static int zza(Object obj, zzli zzliVar, byte[] bArr, int i, int i2, zzhw zzhwVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzhwVar);
            i3 = zzhwVar.zza;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzjt.zzh();
        }
        int i5 = i3 + i4;
        zzliVar.zza(obj, bArr, i4, i5, zzhwVar);
        zzhwVar.zzc = obj;
        return i5;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzhw zzhwVar) throws zzjt {
        if ((i >>> 3) == 0) {
            throw zzjt.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzd(bArr, i2, zzhwVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzc(bArr, i2, zzhwVar) + zzhwVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzjt.zzc();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzc(bArr, i2, zzhwVar);
            i6 = zzhwVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzhwVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzjt.zzg();
        }
        return i2;
    }

    static long zzd(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
