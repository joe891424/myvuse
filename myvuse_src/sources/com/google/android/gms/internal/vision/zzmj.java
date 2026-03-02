package com.google.android.gms.internal.vision;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmj extends zzme {
    zzmj() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.vision.zzme
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zza(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzmj.zza(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.vision.zzme
    final String zzb(byte[] bArr, int i, int i2) throws zzjk {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bZza = zzma.zza(bArr, i);
            if (!zzmf.zzd(bZza)) {
                break;
            }
            i++;
            zzmf.zzb(bZza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bZza2 = zzma.zza(bArr, i);
            if (zzmf.zzd(bZza2)) {
                int i7 = i5 + 1;
                zzmf.zzb(bZza2, cArr, i5);
                while (i6 < i3) {
                    byte bZza3 = zzma.zza(bArr, i6);
                    if (!zzmf.zzd(bZza3)) {
                        break;
                    }
                    i6++;
                    zzmf.zzb(bZza3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (zzmf.zze(bZza2)) {
                if (i6 >= i3) {
                    throw zzjk.zzh();
                }
                i += 2;
                zzmf.zzb(bZza2, zzma.zza(bArr, i6), cArr, i5);
                i5++;
            } else if (zzmf.zzf(bZza2)) {
                if (i6 < i3 - 1) {
                    int i8 = i + 2;
                    i += 3;
                    zzmf.zzb(bZza2, zzma.zza(bArr, i6), zzma.zza(bArr, i8), cArr, i5);
                    i5++;
                } else {
                    throw zzjk.zzh();
                }
            } else {
                if (i6 >= i3 - 2) {
                    throw zzjk.zzh();
                }
                byte bZza4 = zzma.zza(bArr, i6);
                int i9 = i + 3;
                byte bZza5 = zzma.zza(bArr, i + 2);
                i += 4;
                zzmf.zzb(bZza2, bZza4, bZza5, zzma.zza(bArr, i9), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.vision.zzme
    final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        String str;
        String str2;
        int i3;
        long j2;
        long j3;
        char cCharAt;
        long j4 = i;
        long j5 = ((long) i2) + j4;
        int length = charSequence.length();
        String str3 = " at index ";
        String str4 = "Failed writing ";
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(length - 1)).append(" at index ").append(i + i2).toString());
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzma.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 >= 128 || j4 >= j5) {
                if (cCharAt2 >= 2048 || j4 > j5 - 2) {
                    str = str3;
                    str2 = str4;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j4 > j5 - 3) {
                        if (j4 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char cCharAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    j2 = 1;
                                    zzma.zza(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                    j3 = j5;
                                    zzma.zza(bArr, j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j6 = j4 + 3;
                                    zzma.zza(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 += 4;
                                    zzma.zza(bArr, j6, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new zzmg(i4 - 1, length);
                        }
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                            throw new zzmg(i4, length);
                        }
                        throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append(str2).append(cCharAt2).append(str).append(j4).toString());
                    }
                    zzma.zza(bArr, j4, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j7 = j4 + 2;
                    zzma.zza(bArr, j4 + 1, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    j4 += 3;
                    zzma.zza(bArr, j7, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    str = str3;
                    str2 = str4;
                    long j8 = j4 + j;
                    zzma.zza(bArr, j4, (byte) ((cCharAt2 >>> 6) | 960));
                    j4 += 2;
                    zzma.zza(bArr, j8, (byte) ((cCharAt2 & '?') | 128));
                }
                j3 = j5;
                j2 = 1;
            } else {
                zzma.zza(bArr, j4, (byte) cCharAt2);
                j3 = j5;
                str2 = str4;
                j2 = j;
                j4 += j;
                str = str3;
            }
            i4++;
            str3 = str;
            str4 = str2;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzmd.zzb(i);
        }
        if (i2 == 1) {
            return zzmd.zzb(i, zzma.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzmd.zzb(i, zzma.zza(bArr, j), zzma.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
