package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzci {
    public static final zzjb.zze<zzmt, List<zzb>> zza = zzjb.zza(zzmt.zzw(), zzb.zzd(), null, 202056002, zzml.zzk, false, zzb.class);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zzb extends zzjb<zzb, zza> implements zzkm {
        private static final zzb zzf;
        private static volatile zzkx<zzb> zzg;
        private int zzc;
        private int zzd;
        private zzjl<C5978zzb> zze = zzo();

        /* JADX INFO: renamed from: com.google.android.gms.internal.vision.zzci$zzb$zzb, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class C5978zzb extends zzjb<C5978zzb, zza> implements zzkm {
            private static final C5978zzb zzg;
            private static volatile zzkx<C5978zzb> zzh;
            private int zzc;
            private float zzd;
            private float zze;
            private float zzf;

            private C5978zzb() {
            }

            /* JADX INFO: renamed from: com.google.android.gms.internal.vision.zzci$zzb$zzb$zza */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
            public static final class zza extends zzjb.zzb<C5978zzb, zza> implements zzkm {
                private zza() {
                    super(C5978zzb.zzg);
                }

                /* synthetic */ zza(zzcj zzcjVar) {
                    this();
                }
            }

            public final float zza() {
                return this.zzd;
            }

            public final float zzb() {
                return this.zze;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzci$zzb$zzb>] */
            /* JADX WARN: Type inference failed for: r2v17 */
            /* JADX WARN: Type inference failed for: r2v18 */
            @Override // com.google.android.gms.internal.vision.zzjb
            protected final Object zza(int i, Object obj, Object obj2) {
                ?? r2;
                zzcj zzcjVar = null;
                switch (zzcj.zza[i - 1]) {
                    case 1:
                        return new C5978zzb();
                    case 2:
                        return new zza(zzcjVar);
                    case 3:
                        return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzkx<C5978zzb> zzkxVar = zzh;
                        Object obj3 = zzkxVar;
                        if (zzkxVar == null) {
                            synchronized (C5978zzb.class) {
                                zzkx<C5978zzb> zzkxVar2 = zzh;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzg);
                                    zzh = zzaVar;
                                    r2 = zzaVar;
                                }
                                break;
                            }
                            obj3 = r2;
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
                C5978zzb c5978zzb = new C5978zzb();
                zzg = c5978zzb;
                zzjb.zza((Class<C5978zzb>) C5978zzb.class, c5978zzb);
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public enum zzc implements zzje {
            CONTOUR_UNKNOWN(0),
            FACE_OVAL(1),
            LEFT_EYEBROW_TOP(2),
            LEFT_EYEBROW_BOTTOM(3),
            RIGHT_EYEBROW_TOP(4),
            RIGHT_EYEBROW_BOTTOM(5),
            LEFT_EYE(6),
            RIGHT_EYE(7),
            UPPER_LIP_TOP(8),
            UPPER_LIP_BOTTOM(9),
            LOWER_LIP_TOP(10),
            LOWER_LIP_BOTTOM(11),
            NOSE_BRIDGE(12),
            NOSE_BOTTOM(13),
            LEFT_CHEEK_CENTER(14),
            RIGHT_CHEEK_CENTER(15);

            private static final zzjh<zzc> zzq = new zzcn();
            private final int zzr;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzr;
            }

            public static zzc zza(int i) {
                switch (i) {
                    case 0:
                        return CONTOUR_UNKNOWN;
                    case 1:
                        return FACE_OVAL;
                    case 2:
                        return LEFT_EYEBROW_TOP;
                    case 3:
                        return LEFT_EYEBROW_BOTTOM;
                    case 4:
                        return RIGHT_EYEBROW_TOP;
                    case 5:
                        return RIGHT_EYEBROW_BOTTOM;
                    case 6:
                        return LEFT_EYE;
                    case 7:
                        return RIGHT_EYE;
                    case 8:
                        return UPPER_LIP_TOP;
                    case 9:
                        return UPPER_LIP_BOTTOM;
                    case 10:
                        return LOWER_LIP_TOP;
                    case 11:
                        return LOWER_LIP_BOTTOM;
                    case 12:
                        return NOSE_BRIDGE;
                    case 13:
                        return NOSE_BOTTOM;
                    case 14:
                        return LEFT_CHEEK_CENTER;
                    case 15:
                        return RIGHT_CHEEK_CENTER;
                    default:
                        return null;
                }
            }

            public static zzjg zzb() {
                return zzco.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzr);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zzc(int i) {
                this.zzr = i;
            }
        }

        private zzb() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zzb, zza> implements zzkm {
            private zza() {
                super(zzb.zzf);
            }

            /* synthetic */ zza(zzcj zzcjVar) {
                this();
            }
        }

        public final zzc zza() {
            zzc zzcVarZza = zzc.zza(this.zzd);
            return zzcVarZza == null ? zzc.CONTOUR_UNKNOWN : zzcVarZza;
        }

        public final List<C5978zzb> zzb() {
            return this.zze;
        }

        public final int zzc() {
            return this.zze.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzci$zzb>] */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r3;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzcjVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zzc.zzb(), "zze", C5978zzb.class});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zzb> zzkxVar = zzg;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzb.class) {
                            zzkx<zzb> zzkxVar2 = zzg;
                            r3 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzf);
                                zzg = zzaVar;
                                r3 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r3;
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

        public static zzb zzd() {
            return zzf;
        }

        static {
            zzb zzbVar = new zzb();
            zzf = zzbVar;
            zzjb.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zzc extends zzjb<zzc, zza> implements zzkm {
        private static final zzc zzf;
        private static volatile zzkx<zzc> zzg;
        private int zzc;
        private zznb zzd;
        private byte zze = 2;

        private zzc() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zzc, zza> implements zzkm {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzcj zzcjVar) {
                this();
            }
        }

        public final zznb zza() {
            zznb zznbVar = this.zzd;
            return zznbVar == null ? zznb.zzc() : zznbVar;
        }

        public static zzc zza(byte[] bArr, zzio zzioVar) throws zzjk {
            return (zzc) zzjb.zza(zzf, bArr, zzioVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzci$zzc>] */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzcjVar);
                case 3:
                    return zza(zzf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᐉ\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zzc> zzkxVar = zzg;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzc.class) {
                            zzkx<zzc> zzkxVar2 = zzg;
                            r2 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzf);
                                zzg = zzaVar;
                                r2 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zze);
                case 7:
                    this.zze = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzf = zzcVar;
            zzjb.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zza extends zzjb<zza, C5977zza> implements zzkm {
        private static final zza zzf;
        private static volatile zzkx<zza> zzg;
        private int zzc;
        private zzg zzd;
        private zzg zze;

        private zza() {
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.vision.zzci$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class C5977zza extends zzjb.zzb<zza, C5977zza> implements zzkm {
            private C5977zza() {
                super(zza.zzf);
            }

            public final C5977zza zza(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(zzgVar);
                return this;
            }

            public final C5977zza zzb(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(zzgVar);
                return this;
            }

            /* synthetic */ C5977zza(zzcj zzcjVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            this.zzd = zzgVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzg zzgVar) {
            zzgVar.getClass();
            this.zze = zzgVar;
            this.zzc |= 2;
        }

        public static C5977zza zza() {
            return zzf.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzci$zza>] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r1;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C5977zza(zzcjVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zza> zzkxVar = zzg;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zza.class) {
                            zzkx<zza> zzkxVar2 = zzg;
                            r1 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzf);
                                zzg = zzaVar;
                                r1 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r1;
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
            zza zzaVar = new zza();
            zzf = zzaVar;
            zzjb.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zzd extends zzjb<zzd, zza> implements zzkm {
        private static final zzd zzp;
        private static volatile zzkx<zzd> zzq;
        private int zzc;
        private boolean zzh;
        private boolean zzi;
        private boolean zzl;
        private zze zzm;
        private zza zzn;
        private zzf zzo;
        private float zzd = 0.1f;
        private int zze = 1;
        private int zzf = 1;
        private int zzg = 1;
        private float zzj = 45.0f;
        private float zzk = 0.5f;

        private zzd() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zzd, zza> implements zzkm {
            private zza() {
                super(zzd.zzp);
            }

            public final zza zza(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(f);
                return this;
            }

            public final zza zza(zzcp zzcpVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(zzcpVar);
                return this;
            }

            public final zza zza(zzck zzckVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(zzckVar);
                return this;
            }

            public final zza zza(zzct zzctVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(zzctVar);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(z);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zzc(true);
                return this;
            }

            public final zza zza(zze.zza zzaVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza((zze) ((zzjb) zzaVar.zzf()));
                return this;
            }

            public final zza zza(zza.C5977zza c5977zza) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza((zza) ((zzjb) c5977zza.zzf()));
                return this;
            }

            public final zza zza(zzf.zza zzaVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza((zzf) ((zzjb) zzaVar.zzf()));
                return this;
            }

            /* synthetic */ zza(zzcj zzcjVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(float f) {
            this.zzc |= 1;
            this.zzd = f;
        }

        public final zzcp zza() {
            zzcp zzcpVarZza = zzcp.zza(this.zze);
            return zzcpVarZza == null ? zzcp.NO_LANDMARK : zzcpVarZza;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzcp zzcpVar) {
            this.zze = zzcpVar.zza();
            this.zzc |= 2;
        }

        public final zzck zzb() {
            zzck zzckVarZza = zzck.zza(this.zzf);
            return zzckVarZza == null ? zzck.NO_CLASSIFICATION : zzckVarZza;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzck zzckVar) {
            this.zzf = zzckVar.zza();
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzct zzctVar) {
            this.zzg = zzctVar.zza();
            this.zzc |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 16;
            this.zzh = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 32;
            this.zzi = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zzc |= 256;
            this.zzl = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zze zzeVar) {
            zzeVar.getClass();
            this.zzm = zzeVar;
            this.zzc |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            zzaVar.getClass();
            this.zzn = zzaVar;
            this.zzc |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            this.zzo = zzfVar;
            this.zzc |= 2048;
        }

        public static zza zzc() {
            return zzp.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzci$zzd>] */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r0;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzcjVar);
                case 3:
                    return zza(zzp, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ခ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ခ\u0006\bခ\u0007\tဇ\b\nဉ\t\u000bဉ\n\fဉ\u000b", new Object[]{"zzc", "zzd", "zze", zzcp.zzb(), "zzf", zzck.zzb(), "zzg", zzct.zzb(), "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
                case 4:
                    return zzp;
                case 5:
                    zzkx<zzd> zzkxVar = zzq;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzd.class) {
                            zzkx<zzd> zzkxVar2 = zzq;
                            r0 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzp);
                                zzq = zzaVar;
                                r0 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r0;
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
            zzd zzdVar = new zzd();
            zzp = zzdVar;
            zzjb.zza((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zze extends zzjb<zze, zza> implements zzkm {
        private static final zze zzg;
        private static volatile zzkx<zze> zzh;
        private int zzc;
        private zzg zzd;
        private zzg zze;
        private zzg zzf;

        private zze() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zze, zza> implements zzkm {
            private zza() {
                super(zze.zzg);
            }

            public final zza zza(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(zzgVar);
                return this;
            }

            public final zza zzb(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zze) this.zza).zzb(zzgVar);
                return this;
            }

            public final zza zzc(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zze) this.zza).zzc(zzgVar);
                return this;
            }

            /* synthetic */ zza(zzcj zzcjVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            this.zzd = zzgVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzg zzgVar) {
            zzgVar.getClass();
            this.zze = zzgVar;
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzg zzgVar) {
            zzgVar.getClass();
            this.zzf = zzgVar;
            this.zzc |= 4;
        }

        public static zza zza() {
            return zzg.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzci$zze>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzcjVar);
                case 3:
                    return zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzkx<zze> zzkxVar = zzh;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zze.class) {
                            zzkx<zze> zzkxVar2 = zzh;
                            r2 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzg);
                                zzh = zzaVar;
                                r2 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r2;
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
            zze zzeVar = new zze();
            zzg = zzeVar;
            zzjb.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zzf extends zzjb<zzf, zza> implements zzkm {
        private static final zzf zzh;
        private static volatile zzkx<zzf> zzi;
        private int zzc;
        private zzg zzd;
        private zzg zze;
        private zzg zzf;
        private zzg zzg;

        private zzf() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zzf, zza> implements zzkm {
            private zza() {
                super(zzf.zzh);
            }

            public final zza zza(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza(zzgVar);
                return this;
            }

            public final zza zzb(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zzb(zzgVar);
                return this;
            }

            public final zza zzc(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zzc(zzgVar);
                return this;
            }

            public final zza zzd(zzg zzgVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zzd(zzgVar);
                return this;
            }

            /* synthetic */ zza(zzcj zzcjVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            this.zzd = zzgVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzg zzgVar) {
            zzgVar.getClass();
            this.zze = zzgVar;
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzg zzgVar) {
            zzgVar.getClass();
            this.zzf = zzgVar;
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(zzg zzgVar) {
            zzgVar.getClass();
            this.zzg = zzgVar;
            this.zzc |= 8;
        }

        public static zza zza() {
            return zzh.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzci$zzf>] */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r3;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzcjVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzkx<zzf> zzkxVar = zzi;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzf.class) {
                            zzkx<zzf> zzkxVar2 = zzi;
                            r3 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzh);
                                zzi = zzaVar;
                                r3 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r3;
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
            zzf zzfVar = new zzf();
            zzh = zzfVar;
            zzjb.zza((Class<zzf>) zzf.class, zzfVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zzg extends zzjb<zzg, zza> implements zzkm {
        private static final zzg zzf;
        private static volatile zzkx<zzg> zzg;
        private int zzc;
        private zzht zzd = zzht.zza;
        private String zze = "";

        private zzg() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zzg, zza> implements zzkm {
            private zza() {
                super(zzg.zzf);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzcj zzcjVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public static zza zza() {
            return zzf.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzci$zzg>] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r1;
            zzcj zzcjVar = null;
            switch (zzcj.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzcjVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zzg> zzkxVar = zzg;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzg.class) {
                            zzkx<zzg> zzkxVar2 = zzg;
                            r1 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzf);
                                zzg = zzaVar;
                                r1 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r1;
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
            zzg zzgVar = new zzg();
            zzf = zzgVar;
            zzjb.zza((Class<zzg>) zzg.class, zzgVar);
        }
    }
}
