package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
class zzik extends zzii {
    protected final byte[] zzb;

    @Override // com.google.android.gms.internal.measurement.zzhx
    public byte zza(int i) {
        return this.zzb[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzhx
    byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzhx
    protected final int zzb(int i, int i2, int i3) {
        return zzjn.zza(i, this.zzb, zzc(), i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzhx
    public int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzhx
    public final zzhx zza(int i, int i2) {
        int iZza = zza(0, i2, zzb());
        if (iZza == 0) {
            return zzhx.zza;
        }
        return new zzib(this.zzb, zzc(), iZza);
    }

    zzik(byte[] bArr) {
        super();
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzhx
    final void zza(zzhy zzhyVar) throws IOException {
        zzhyVar.zza(this.zzb, zzc(), zzb());
    }

    @Override // com.google.android.gms.internal.measurement.zzhx
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhx) || zzb() != ((zzhx) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (obj instanceof zzik) {
            zzik zzikVar = (zzik) obj;
            int iZza = zza();
            int iZza2 = zzikVar.zza();
            if (iZza == 0 || iZza2 == 0 || iZza == iZza2) {
                return zza(zzikVar, 0, zzb());
            }
            return false;
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzii
    final boolean zza(zzhx zzhxVar, int i, int i2) {
        if (i2 > zzhxVar.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        }
        if (i2 > zzhxVar.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzhxVar.zzb());
        }
        if (zzhxVar instanceof zzik) {
            zzik zzikVar = (zzik) zzhxVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzikVar.zzb;
            int iZzc = zzc() + i2;
            int iZzc2 = zzc();
            int iZzc3 = zzikVar.zzc();
            while (iZzc2 < iZzc) {
                if (bArr[iZzc2] != bArr2[iZzc3]) {
                    return false;
                }
                iZzc2++;
                iZzc3++;
            }
            return true;
        }
        return zzhxVar.zza(0, i2).equals(zza(0, i2));
    }
}
