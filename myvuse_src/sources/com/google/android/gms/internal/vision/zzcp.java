package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzcp implements zzje {
    LANDMARK_TYPE_UNKNOWN(0),
    NO_LANDMARK(1),
    ALL_LANDMARKS(2),
    CONTOUR_LANDMARKS(3);

    private static final zzjh<zzcp> zze = new zzjh<zzcp>() { // from class: com.google.android.gms.internal.vision.zzcr
        @Override // com.google.android.gms.internal.vision.zzjh
        public final /* synthetic */ zzje zza(int i) {
            return zzcp.zza(i);
        }
    };
    private final int zzf;

    @Override // com.google.android.gms.internal.vision.zzje
    public final int zza() {
        return this.zzf;
    }

    public static zzcp zza(int i) {
        if (i == 0) {
            return LANDMARK_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return NO_LANDMARK;
        }
        if (i == 2) {
            return ALL_LANDMARKS;
        }
        if (i != 3) {
            return null;
        }
        return CONTOUR_LANDMARKS;
    }

    public static zzjg zzb() {
        return zzcq.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzf);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    zzcp(int i) {
        this.zzf = i;
    }
}
