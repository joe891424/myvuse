package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznb extends zzjb<zznb, zza> implements zzkm {
    private static final zznb zze;
    private static volatile zzkx<zznb> zzf;
    private byte zzd = 2;
    private zzjl<zzmt> zzc = zzo();

    private zznb() {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zza extends zzjb.zzb<zznb, zza> implements zzkm {
        private zza() {
            super(zznb.zze);
        }

        /* synthetic */ zza(zzna zznaVar) {
            this();
        }
    }

    public final List<zzmt> zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzc.size();
    }

    public final zzmt zza(int i) {
        return this.zzc.get(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zznb>] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    @Override // com.google.android.gms.internal.vision.zzjb
    protected final Object zza(int i, Object obj, Object obj2) {
        ?? r2;
        zzna zznaVar = null;
        switch (zzna.zza[i - 1]) {
            case 1:
                return new zznb();
            case 2:
                return new zza(zznaVar);
            case 3:
                return zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzc", zzmt.class});
            case 4:
                return zze;
            case 5:
                zzkx<zznb> zzkxVar = zzf;
                Object obj3 = zzkxVar;
                if (zzkxVar == null) {
                    synchronized (zznb.class) {
                        zzkx<zznb> zzkxVar2 = zzf;
                        r2 = zzkxVar2;
                        if (zzkxVar2 == null) {
                            ?? zzaVar = new zzjb.zza(zze);
                            zzf = zzaVar;
                            r2 = zzaVar;
                        }
                        break;
                    }
                    obj3 = r2;
                }
                return obj3;
            case 6:
                return Byte.valueOf(this.zzd);
            case 7:
                this.zzd = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zznb zzc() {
        return zze;
    }

    static {
        zznb zznbVar = new zznb();
        zze = zznbVar;
        zzjb.zza((Class<zznb>) zznb.class, zznbVar);
    }
}
