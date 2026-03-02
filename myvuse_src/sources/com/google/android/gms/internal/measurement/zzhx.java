package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhx implements Serializable, Iterable<Byte> {
    public static final zzhx zza = new zzik(zzjn.zzb);
    private static final zzie zzb = new zzij();
    private int zzc = 0;

    static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract zzhx zza(int i, int i2);

    abstract void zza(zzhy zzhyVar) throws IOException;

    abstract byte zzb(int i);

    public abstract int zzb();

    protected abstract int zzb(int i, int i2, int i3);

    static int zza(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public final int hashCode() {
        int iZzb = this.zzc;
        if (iZzb == 0) {
            int iZzb2 = zzb();
            iZzb = zzb(iZzb2, 0, iZzb2);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zzc = iZzb;
        }
        return iZzb;
    }

    protected final int zza() {
        return this.zzc;
    }

    static zzig zzc(int i) {
        return new zzig(i);
    }

    public static zzhx zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzhx zza(byte[] bArr, int i, int i2) {
        zza(i, i + i2, bArr.length);
        return new zzik(zzb.zza(bArr, i, i2));
    }

    public static zzhx zza(String str) {
        return new zzik(str.getBytes(zzjn.zza));
    }

    static zzhx zzb(byte[] bArr) {
        return new zzik(bArr);
    }

    public final String toString() {
        String strZza;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer numValueOf = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            strZza = zzly.zza(this);
        } else {
            strZza = zzly.zza(zza(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, numValueOf, strZza);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzia(this);
    }

    static {
        new zzhz();
    }

    zzhx() {
    }
}
