package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzil {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzip zzc;

    public static int zza(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract float zzb() throws IOException;

    public abstract int zzb(int i) throws zzjt;

    public abstract int zzc();

    public abstract void zzc(int i) throws zzjt;

    public abstract int zzd() throws IOException;

    public abstract void zzd(int i);

    public abstract int zze() throws IOException;

    public abstract boolean zze(int i) throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzhx zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public abstract boolean zzt() throws IOException;

    public abstract boolean zzu() throws IOException;

    static zzil zza(byte[] bArr, int i, int i2, boolean z) {
        zzio zzioVar = new zzio(bArr, i2);
        try {
            zzioVar.zzb(i2);
            return zzioVar;
        } catch (zzjt e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zzil() {
        this.zzb = zzd;
    }
}
