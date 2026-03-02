package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzig {
    private final zzir zza;
    private final byte[] zzb;

    public final zzhx zza() {
        this.zza.zzb();
        return new zzik(this.zzb);
    }

    public final zzir zzb() {
        return this.zza;
    }

    private zzig(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzir.zzb(bArr);
    }
}
