package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzct implements zzje {
    MODE_TYPE_UNKNOWN(0),
    FAST(1),
    ACCURATE(2),
    SELFIE(3);

    private static final zzjh<zzct> zze = new zzjh<zzct>() { // from class: com.google.android.gms.internal.vision.zzcs
        @Override // com.google.android.gms.internal.vision.zzjh
        public final /* synthetic */ zzje zza(int i) {
            return zzct.zza(i);
        }
    };
    private final int zzf;

    @Override // com.google.android.gms.internal.vision.zzje
    public final int zza() {
        return this.zzf;
    }

    public static zzct zza(int i) {
        if (i == 0) {
            return MODE_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return FAST;
        }
        if (i == 2) {
            return ACCURATE;
        }
        if (i != 3) {
            return null;
        }
        return SELFIE;
    }

    public static zzjg zzb() {
        return zzcu.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzf);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    zzct(int i) {
        this.zzf = i;
    }
}
