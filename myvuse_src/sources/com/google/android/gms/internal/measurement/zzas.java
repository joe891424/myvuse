package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzas implements zzaq, Iterable<zzaq> {
    private final String zza;

    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x063d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bb A[PHI: r19
      0x00bb: PHI (r19v21 byte) = 
      (r19v0 byte)
      (r19v0 byte)
      (r19v5 byte)
      (r19v0 byte)
      (r19v6 byte)
      (r19v0 byte)
      (r19v7 byte)
      (r19v0 byte)
      (r19v8 byte)
      (r19v0 byte)
      (r19v9 byte)
      (r19v0 byte)
      (r19v10 byte)
      (r19v0 byte)
      (r19v11 byte)
      (r19v0 byte)
      (r19v12 byte)
      (r19v0 byte)
      (r19v13 byte)
      (r19v0 byte)
      (r19v14 byte)
      (r19v0 byte)
      (r19v15 byte)
      (r19v0 byte)
      (r19v16 byte)
      (r19v0 byte)
      (r19v17 byte)
     binds: [B:42:0x00b8, B:95:0x0145, B:97:0x0149, B:91:0x0139, B:93:0x013d, B:87:0x012f, B:89:0x0132, B:83:0x0125, B:85:0x0128, B:79:0x011b, B:81:0x011e, B:75:0x0111, B:77:0x0114, B:71:0x0107, B:73:0x010a, B:67:0x00fb, B:69:0x00fe, B:63:0x00f1, B:65:0x00f4, B:59:0x00e7, B:61:0x00ea, B:55:0x00dd, B:57:0x00e0, B:51:0x00d3, B:53:0x00d6, B:47:0x00c9, B:49:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd A[PHI: r4 r19
      0x00bd: PHI (r4v49 java.lang.String) = (r4v5 java.lang.String), (r4v6 java.lang.String), (r4v50 java.lang.String) binds: [B:103:0x0164, B:99:0x0153, B:43:0x00bb] A[DONT_GENERATE, DONT_INLINE]
      0x00bd: PHI (r19v20 byte) = (r19v0 byte), (r19v0 byte), (r19v21 byte) binds: [B:103:0x0164, B:99:0x0153, B:43:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014d  */
    @Override // com.google.android.gms.internal.measurement.zzaq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r21, com.google.android.gms.internal.measurement.zzh r22, java.util.List<com.google.android.gms.internal.measurement.zzaq> r23) {
        /*
            Method dump skipped, instruction units count: 1774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzas.zza(java.lang.String, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        return new zzas(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        return this.zza;
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return new zzav(this);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzaq> iterator() {
        return new zzau(this);
    }

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.zza.equals(((zzas) obj).zza);
        }
        return false;
    }
}
