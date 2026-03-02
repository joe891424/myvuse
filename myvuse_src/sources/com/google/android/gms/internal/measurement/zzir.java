package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzir extends zzhy {
    private static final Logger zzb = Logger.getLogger(zzir.class.getName());
    private static final boolean zzc = zzmh.zzc();
    zzit zza;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
    private static class zzb extends zzir {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        @Override // com.google.android.gms.internal.measurement.zzir
        public final int zza() {
            return this.zzc - this.zzd;
        }

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i2;
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zza(byte b) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zzd;
                this.zzd = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
                this.zzd += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzb(int i, boolean z) throws IOException {
            zzj(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzk(i2);
            zzc(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzc(int i, zzhx zzhxVar) throws IOException {
            zzj(i, 2);
            zzb(zzhxVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzb(zzhx zzhxVar) throws IOException {
            zzk(zzhxVar.zzb());
            zzhxVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzg(int i, int i2) throws IOException {
            zzj(i, 5);
            zzh(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzh(int i) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zzd;
                int i3 = i2 + 1;
                this.zzd = i3;
                bArr[i2] = (byte) i;
                int i4 = i2 + 2;
                this.zzd = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i2 + 3;
                this.zzd = i5;
                bArr[i4] = (byte) (i >> 16);
                this.zzd = i2 + 4;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzf(int i, long j) throws IOException {
            zzj(i, 1);
            zzf(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzf(long j) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zzd;
                int i2 = i + 1;
                this.zzd = i2;
                bArr[i] = (byte) j;
                int i3 = i + 2;
                this.zzd = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i + 3;
                this.zzd = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i + 4;
                this.zzd = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i + 5;
                this.zzd = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i + 6;
                this.zzd = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i + 7;
                this.zzd = i8;
                bArr[i7] = (byte) (j >> 48);
                this.zzd = i + 8;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzh(int i, int i2) throws IOException {
            zzj(i, 0);
            zzi(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzi(int i) throws IOException {
            if (i >= 0) {
                zzk(i);
            } else {
                zzh(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        final void zzc(int i, zzkq zzkqVar, zzli zzliVar) throws IOException {
            zzj(i, 2);
            zzk(((zzho) zzkqVar).zza(zzliVar));
            zzliVar.zza(zzkqVar, this.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzc(zzkq zzkqVar) throws IOException {
            zzk(zzkqVar.zzby());
            zzkqVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzb(int i, zzkq zzkqVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzc(zzkqVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzd(int i, zzhx zzhxVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzhxVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzb(String str) throws IOException {
            int i = this.zzd;
            try {
                int iZzg = zzg(str.length() * 3);
                int iZzg2 = zzg(str.length());
                if (iZzg2 == iZzg) {
                    int i2 = i + iZzg2;
                    this.zzd = i2;
                    int iZza = zzmi.zza(str, this.zzb, i2, zza());
                    this.zzd = i;
                    zzk((iZza - i) - iZzg2);
                    this.zzd = iZza;
                    return;
                }
                zzk(zzmi.zza(str));
                this.zzd = zzmi.zza(str, this.zzb, this.zzd, zza());
            } catch (zzml e) {
                this.zzd = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzj(int i, int i2) throws IOException {
            zzk((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzk(int i, int i2) throws IOException {
            zzj(i, 0);
            zzk(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzk(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i2 = this.zzd;
                    this.zzd = i2 + 1;
                    bArr[i2] = (byte) (i | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
                }
            }
            byte[] bArr2 = this.zzb;
            int i3 = this.zzd;
            this.zzd = i3 + 1;
            bArr2[i3] = (byte) i;
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzh(int i, long j) throws IOException {
            zzj(i, 0);
            zzh(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzir
        public final void zzh(long j) throws IOException {
            if (zzir.zzc && zza() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    zzmh.zza(bArr, i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                zzmh.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.zzb;
                    int i3 = this.zzd;
                    this.zzd = i3 + 1;
                    bArr3[i3] = (byte) (((int) j) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
                }
            }
            byte[] bArr4 = this.zzb;
            int i4 = this.zzd;
            this.zzd = i4 + 1;
            bArr4[i4] = (byte) j;
        }
    }

    public static int zza(double d) {
        return 8;
    }

    public static int zza(float f) {
        return 4;
    }

    public static int zza(long j) {
        return 8;
    }

    public static int zza(boolean z) {
        return 1;
    }

    public static int zzb(int i) {
        return 4;
    }

    public static int zzc(long j) {
        return 8;
    }

    public static int zzd(int i) {
        return 4;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private static int zzl(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zzb(int i, zzkq zzkqVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzhx zzhxVar) throws IOException;

    public abstract void zzb(String str) throws IOException;

    abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(int i, zzhx zzhxVar) throws IOException;

    abstract void zzc(int i, zzkq zzkqVar, zzli zzliVar) throws IOException;

    public abstract void zzc(zzkq zzkqVar) throws IOException;

    public abstract void zzd(int i, zzhx zzhxVar) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzh(int i) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(long j) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzk(int i, int i2) throws IOException;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zza(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static int zza(int i, boolean z) {
        return zzg(i << 3) + 1;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zza(int i, zzhx zzhxVar) {
        int iZzg = zzg(i << 3);
        int iZzb = zzhxVar.zzb();
        return iZzg + zzg(iZzb) + iZzb;
    }

    public static int zza(zzhx zzhxVar) {
        int iZzb = zzhxVar.zzb();
        return zzg(iZzb) + iZzb;
    }

    public static int zza(int i, double d) {
        return zzg(i << 3) + 8;
    }

    public static int zza(int i, int i2) {
        return zzg(i << 3) + zze(i2);
    }

    public static int zza(int i) {
        return zze(i);
    }

    public static int zzb(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zza(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zza(int i, float f) {
        return zzg(i << 3) + 4;
    }

    @Deprecated
    static int zza(int i, zzkq zzkqVar, zzli zzliVar) {
        return (zzg(i << 3) << 1) + ((zzho) zzkqVar).zza(zzliVar);
    }

    @Deprecated
    public static int zza(zzkq zzkqVar) {
        return zzkqVar.zzby();
    }

    public static int zzc(int i, int i2) {
        return zzg(i << 3) + zze(i2);
    }

    public static int zzc(int i) {
        return zze(i);
    }

    public static int zzb(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zzb(long j) {
        return zze(j);
    }

    public static int zza(int i, zzjy zzjyVar) {
        return (zzg(8) << 1) + zzf(2, i) + zzb(3, zzjyVar);
    }

    public static int zzb(int i, zzjy zzjyVar) {
        int iZzg = zzg(i << 3);
        int iZza = zzjyVar.zza();
        return iZzg + zzg(iZza) + iZza;
    }

    public static int zza(zzjy zzjyVar) {
        int iZza = zzjyVar.zza();
        return zzg(iZza) + iZza;
    }

    public static int zza(int i, zzkq zzkqVar) {
        return (zzg(8) << 1) + zzf(2, i) + zzg(24) + zzb(zzkqVar);
    }

    static int zzb(int i, zzkq zzkqVar, zzli zzliVar) {
        return zzg(i << 3) + zza(zzkqVar, zzliVar);
    }

    public static int zzb(zzkq zzkqVar) {
        int iZzby = zzkqVar.zzby();
        return zzg(iZzby) + iZzby;
    }

    static int zza(zzkq zzkqVar, zzli zzliVar) {
        int iZza = ((zzho) zzkqVar).zza(zzliVar);
        return zzg(iZza) + iZza;
    }

    public static int zzb(int i, zzhx zzhxVar) {
        return (zzg(8) << 1) + zzf(2, i) + zza(3, zzhxVar);
    }

    public static int zzd(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzc(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zze(int i, int i2) {
        return zzg(i << 3) + zzg(zzl(i2));
    }

    public static int zze(int i) {
        return zzg(zzl(i));
    }

    public static int zzd(int i, long j) {
        return zzg(i << 3) + zze(zzi(j));
    }

    public static int zzd(long j) {
        return zze(zzi(j));
    }

    public static int zza(int i, String str) {
        return zzg(i << 3) + zza(str);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzmi.zza(str);
        } catch (zzml unused) {
            length = str.getBytes(zzjn.zza).length;
        }
        return zzg(length) + length;
    }

    public static int zzf(int i) {
        return zzg(i << 3);
    }

    public static int zzf(int i, int i2) {
        return zzg(i << 3) + zzg(i2);
    }

    public static int zzg(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zze(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zze(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzir zzb(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    private zzir() {
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zza(String str, zzml zzmlVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzmlVar);
        byte[] bytes = str.getBytes(zzjn.zza);
        try {
            zzk(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        }
    }

    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public final void zzb(int i, double d) throws IOException {
        zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(double d) throws IOException {
        zzf(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(float f) throws IOException {
        zzh(Float.floatToRawIntBits(f));
    }

    public final void zzi(int i, int i2) throws IOException {
        zzk(i, zzl(i2));
    }

    public final void zzj(int i) throws IOException {
        zzk(zzl(i));
    }

    public final void zzg(int i, long j) throws IOException {
        zzh(i, zzi(j));
    }

    public final void zzg(long j) throws IOException {
        zzh(zzi(j));
    }
}
