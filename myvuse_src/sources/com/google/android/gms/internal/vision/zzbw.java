package com.google.android.gms.internal.vision;

import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum zzbw implements zzje {
    RGBA(0),
    NV12(5),
    NV21(1),
    YV12(6),
    YV21(7),
    RGB(2),
    GRAY(3),
    GRAY16(4);

    private static final zzjh<zzbw> zzi = new zzjh<zzbw>() { // from class: com.google.android.gms.internal.vision.zzbz
        @Override // com.google.android.gms.internal.vision.zzjh
        public final /* synthetic */ zzje zza(int i) {
            return zzbw.zza(i);
        }
    };
    private final int zzj;

    @Override // com.google.android.gms.internal.vision.zzje
    public final int zza() {
        return this.zzj;
    }

    public static zzbw zza(int i) {
        switch (i) {
            case 0:
                return RGBA;
            case 1:
                return NV21;
            case 2:
                return RGB;
            case 3:
                return GRAY;
            case 4:
                return GRAY16;
            case 5:
                return NV12;
            case 6:
                return YV12;
            case 7:
                return YV21;
            default:
                return null;
        }
    }

    public static zzjg zzb() {
        return zzby.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzj);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    zzbw(int i) {
        this.zzj = i;
    }
}
