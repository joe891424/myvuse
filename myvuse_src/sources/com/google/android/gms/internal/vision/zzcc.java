package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzcc implements zzje {
    ROTATION_0(0),
    ROTATION_90(1),
    ROTATION_180(2),
    ROTATION_270(3);

    private static final zzjh<zzcc> zze = new zzjh<zzcc>() { // from class: com.google.android.gms.internal.vision.zzce
        @Override // com.google.android.gms.internal.vision.zzjh
        public final /* synthetic */ zzje zza(int i) {
            return zzcc.zza(i);
        }
    };
    private final int zzf;

    @Override // com.google.android.gms.internal.vision.zzje
    public final int zza() {
        return this.zzf;
    }

    public static zzcc zza(int i) {
        if (i == 0) {
            return ROTATION_0;
        }
        if (i == 1) {
            return ROTATION_90;
        }
        if (i == 2) {
            return ROTATION_180;
        }
        if (i != 3) {
            return null;
        }
        return ROTATION_270;
    }

    public static zzjg zzb() {
        return zzcd.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzf);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    zzcc(int i) {
        this.zzf = i;
    }
}
