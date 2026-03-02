package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzck implements zzje {
    CLASSIFICATION_TYPE_UNKNOWN(0),
    NO_CLASSIFICATION(1),
    ALL_CLASSIFICATIONS(2);

    private static final zzjh<zzck> zzd = new zzjh<zzck>() { // from class: com.google.android.gms.internal.vision.zzcm
        @Override // com.google.android.gms.internal.vision.zzjh
        public final /* synthetic */ zzje zza(int i) {
            return zzck.zza(i);
        }
    };
    private final int zze;

    @Override // com.google.android.gms.internal.vision.zzje
    public final int zza() {
        return this.zze;
    }

    public static zzck zza(int i) {
        if (i == 0) {
            return CLASSIFICATION_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return NO_CLASSIFICATION;
        }
        if (i != 2) {
            return null;
        }
        return ALL_CLASSIFICATIONS;
    }

    public static zzjg zzb() {
        return zzcl.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zze);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    zzck(int i) {
        this.zze = i;
    }
}
