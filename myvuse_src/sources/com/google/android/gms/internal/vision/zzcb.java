package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcb extends zzjb<zzcb, zza> implements zzkm {
    private static final zzcb zzk;
    private static volatile zzkx<zzcb> zzl;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private String zzj = "";

    private zzcb() {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zza extends zzjb.zzb<zzcb, zza> implements zzkm {
        private zza() {
            super(zzcb.zzk);
        }

        public final zza zza(int i) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzcb) this.zza).zza(i);
            return this;
        }

        public final zza zzb(int i) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzcb) this.zza).zzc(i);
            return this;
        }

        public final zza zza(zzbw zzbwVar) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzcb) this.zza).zza(zzbwVar);
            return this;
        }

        public final zza zza(zzcc zzccVar) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzcb) this.zza).zza(zzccVar);
            return this;
        }

        public final zza zza(long j) {
            if (this.zzb) {
                zzb();
                this.zzb = false;
            }
            ((zzcb) this.zza).zza(j);
            return this;
        }

        /* synthetic */ zza(zzca zzcaVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i) {
        this.zzc |= 1;
        this.zzd = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(int i) {
        this.zzc |= 2;
        this.zze = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzbw zzbwVar) {
        this.zzf = zzbwVar.zza();
        this.zzc |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzcc zzccVar) {
        this.zzg = zzccVar.zza();
        this.zzc |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(long j) {
        this.zzc |= 32;
        this.zzi = j;
    }

    public static zza zza() {
        return zzk.zzj();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzcb>] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    @Override // com.google.android.gms.internal.vision.zzjb
    protected final Object zza(int i, Object obj, Object obj2) {
        ?? r11;
        zzca zzcaVar = null;
        switch (zzca.zza[i - 1]) {
            case 1:
                return new zzcb();
            case 2:
                return new zza(zzcaVar);
            case 3:
                return zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ဂ\u0005\u0007ဈ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzbw.zzb(), "zzg", zzcc.zzb(), "zzh", "zzi", "zzj"});
            case 4:
                return zzk;
            case 5:
                zzkx<zzcb> zzkxVar = zzl;
                Object obj3 = zzkxVar;
                if (zzkxVar == null) {
                    synchronized (zzcb.class) {
                        zzkx<zzcb> zzkxVar2 = zzl;
                        r11 = zzkxVar2;
                        if (zzkxVar2 == null) {
                            ?? zzaVar = new zzjb.zza(zzk);
                            zzl = zzaVar;
                            r11 = zzaVar;
                        }
                        break;
                    }
                    obj3 = r11;
                }
                return obj3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzcb zzcbVar = new zzcb();
        zzk = zzcbVar;
        zzjb.zza((Class<zzcb>) zzcb.class, zzcbVar);
    }
}
