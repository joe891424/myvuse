package com.google.android.gms.internal.vision;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.internal.vision.zzjb;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzmt extends zzjb.zzc<zzmt, zzc> implements zzkm {
    private static final zzmt zzs;
    private static volatile zzkx<zzmt> zzt;
    private int zzd;
    private zzb zze;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private long zzn;
    private long zzo;
    private long zzp;
    private float zzq;
    private byte zzr = 2;
    private zzjl<zze> zzf = zzo();
    private zzjl<zzd> zzl = zzo();
    private zzjl<zza> zzm = zzo();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zza extends zzjb<zza, C5980zza> implements zzkm {
        private static final zza zzh;
        private static volatile zzkx<zza> zzi;
        private int zzc;
        private int zzd;
        private String zze = "";
        private float zzf;
        private float zzg;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public enum zzb implements zzje {
            TYPE_UNKNOWN(0),
            FREE_FORM(1),
            FEMALE(2),
            MALE(3),
            AGE(5),
            NON_HUMAN(6),
            GLASSES(7),
            DARK_GLASSES(8),
            HEADWEAR(9),
            EYES_VISIBLE(10),
            LEFT_EYELID_CLOSED(16),
            RIGHT_EYELID_CLOSED(17),
            MOUTH_OPEN(11),
            FACIAL_HAIR(12),
            LONG_HAIR(13),
            FRONTAL_GAZE(14),
            SMILING(15),
            UNDER_EXPOSED(18),
            BLURRED(19),
            LEFT_EYE_VISIBLE(20),
            RIGHT_EYE_VISIBLE(21),
            LEFT_EAR_VISIBLE(22),
            RIGHT_EAR_VISIBLE(23),
            NOSE_TIP_VISIBLE(24),
            MOUTH_CENTER_VISIBLE(25);

            private static final zzjh<zzb> zzz = new zzmu();
            private final int zzaa;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzaa;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 0:
                        return TYPE_UNKNOWN;
                    case 1:
                        return FREE_FORM;
                    case 2:
                        return FEMALE;
                    case 3:
                        return MALE;
                    case 4:
                    default:
                        return null;
                    case 5:
                        return AGE;
                    case 6:
                        return NON_HUMAN;
                    case 7:
                        return GLASSES;
                    case 8:
                        return DARK_GLASSES;
                    case 9:
                        return HEADWEAR;
                    case 10:
                        return EYES_VISIBLE;
                    case 11:
                        return MOUTH_OPEN;
                    case 12:
                        return FACIAL_HAIR;
                    case 13:
                        return LONG_HAIR;
                    case 14:
                        return FRONTAL_GAZE;
                    case 15:
                        return SMILING;
                    case 16:
                        return LEFT_EYELID_CLOSED;
                    case 17:
                        return RIGHT_EYELID_CLOSED;
                    case 18:
                        return UNDER_EXPOSED;
                    case 19:
                        return BLURRED;
                    case 20:
                        return LEFT_EYE_VISIBLE;
                    case 21:
                        return RIGHT_EYE_VISIBLE;
                    case 22:
                        return LEFT_EAR_VISIBLE;
                    case 23:
                        return RIGHT_EAR_VISIBLE;
                    case 24:
                        return NOSE_TIP_VISIBLE;
                    case 25:
                        return MOUTH_CENTER_VISIBLE;
                }
            }

            public static zzjg zzb() {
                return zzmv.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzaa);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zzb(int i) {
                this.zzaa = i;
            }
        }

        private zza() {
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.vision.zzmt$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class C5980zza extends zzjb.zzb<zza, C5980zza> implements zzkm {
            private C5980zza() {
                super(zza.zzh);
            }

            /* synthetic */ C5980zza(zzms zzmsVar) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final float zzb() {
            return this.zzf;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v12 */
        /* JADX WARN: Type inference failed for: r7v13, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzmt$zza>] */
        /* JADX WARN: Type inference failed for: r7v16 */
        /* JADX WARN: Type inference failed for: r7v17 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r7;
            zzms zzmsVar = null;
            switch (zzms.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C5980zza(zzmsVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzkx<zza> zzkxVar = zzi;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zza.class) {
                            zzkx<zza> zzkxVar2 = zzi;
                            r7 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzh);
                                zzi = zzaVar;
                                r7 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r7;
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
            zzh = zzaVar;
            zzjb.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zzb extends zzjb<zzb, zza> implements zzkm {
        private static final zzb zzh;
        private static volatile zzkx<zzb> zzi;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;
        private float zzg;

        private zzb() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zzb, zza> implements zzkm {
            private zza() {
                super(zzb.zzh);
            }

            /* synthetic */ zza(zzms zzmsVar) {
                this();
            }
        }

        public final float zza() {
            return this.zzd;
        }

        public final float zzb() {
            return this.zze;
        }

        public final float zzc() {
            return this.zzf;
        }

        public final float zzd() {
            return this.zzg;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzmt$zzb>] */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r3;
            zzms zzmsVar = null;
            switch (zzms.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzmsVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzkx<zzb> zzkxVar = zzi;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzb.class) {
                            zzkx<zzb> zzkxVar2 = zzi;
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

        public static zzb zze() {
            return zzh;
        }

        static {
            zzb zzbVar = new zzb();
            zzh = zzbVar;
            zzjb.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zzd extends zzjb<zzd, zza> implements zzkm {
        private static final zzd zzh;
        private static volatile zzkx<zzd> zzi;
        private int zzc;
        private int zzd;
        private zzht zze = zzht.zza;
        private String zzf = "";
        private float zzg;

        private zzd() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zzd, zza> implements zzkm {
            private zza() {
                super(zzd.zzh);
            }

            /* synthetic */ zza(zzms zzmsVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzmt$zzd>] */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r3;
            zzms zzmsVar = null;
            switch (zzms.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzmsVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ခ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzkx<zzd> zzkxVar = zzi;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzd.class) {
                            zzkx<zzd> zzkxVar2 = zzi;
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
            zzd zzdVar = new zzd();
            zzh = zzdVar;
            zzjb.zza((Class<zzd>) zzd.class, zzdVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zze extends zzjb<zze, zza> implements zzkm {
        private static final zze zzj;
        private static volatile zzkx<zze> zzk;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;
        private int zzg = 15000;
        private int zzh;
        private float zzi;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public enum zzb implements zzje {
            LEFT_EYE(0),
            RIGHT_EYE(1),
            LEFT_OF_LEFT_EYEBROW(2),
            RIGHT_OF_LEFT_EYEBROW(3),
            LEFT_OF_RIGHT_EYEBROW(4),
            RIGHT_OF_RIGHT_EYEBROW(5),
            MIDPOINT_BETWEEN_EYES(6),
            NOSE_TIP(9),
            UPPER_LIP(10),
            LOWER_LIP(11),
            MOUTH_LEFT(12),
            MOUTH_RIGHT(13),
            MOUTH_CENTER(45),
            NOSE_BOTTOM_RIGHT(43),
            NOSE_BOTTOM_LEFT(44),
            NOSE_BOTTOM_CENTER(200),
            LEFT_EYE_TOP_BOUNDARY(220),
            LEFT_EYE_RIGHT_CORNER(221),
            LEFT_EYE_BOTTOM_BOUNDARY(222),
            LEFT_EYE_LEFT_CORNER(223),
            RIGHT_EYE_TOP_BOUNDARY(ISO7816Kt.INS_CREATE_FILE),
            RIGHT_EYE_RIGHT_CORNER(JfifUtil.MARKER_APP1),
            RIGHT_EYE_BOTTOM_BOUNDARY(226),
            RIGHT_EYE_LEFT_CORNER(227),
            LEFT_EYEBROW_UPPER_MIDPOINT(300),
            RIGHT_EYEBROW_UPPER_MIDPOINT(302),
            LEFT_EAR_TRAGION(240),
            RIGHT_EAR_TRAGION(241),
            LEFT_EYE_PUPIL(304),
            RIGHT_EYE_PUPIL(305),
            FOREHEAD_GLABELLA(312),
            CHIN_GNATHION(314),
            CHIN_LEFT_GONION(315),
            CHIN_RIGHT_GONION(TypedValues.AttributesType.TYPE_PATH_ROTATE),
            LEFT_CHEEK_CENTER(238),
            RIGHT_CHEEK_CENTER(239),
            LEFT_EAR_TOP(242),
            RIGHT_EAR_TOP(243),
            LANDMARK_UNKNOWN(15000);

            private static final zzjh<zzb> zzan = new zzmw();
            private final int zzao;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzao;
            }

            public static zzb zza(int i) {
                if (i == 200) {
                    return NOSE_BOTTOM_CENTER;
                }
                if (i == 300) {
                    return LEFT_EYEBROW_UPPER_MIDPOINT;
                }
                if (i == 302) {
                    return RIGHT_EYEBROW_UPPER_MIDPOINT;
                }
                if (i == 312) {
                    return FOREHEAD_GLABELLA;
                }
                if (i == 15000) {
                    return LANDMARK_UNKNOWN;
                }
                if (i == 304) {
                    return LEFT_EYE_PUPIL;
                }
                if (i != 305) {
                    switch (i) {
                        case 0:
                            return LEFT_EYE;
                        case 1:
                            return RIGHT_EYE;
                        case 2:
                            return LEFT_OF_LEFT_EYEBROW;
                        case 3:
                            return RIGHT_OF_LEFT_EYEBROW;
                        case 4:
                            return LEFT_OF_RIGHT_EYEBROW;
                        case 5:
                            return RIGHT_OF_RIGHT_EYEBROW;
                        case 6:
                            return MIDPOINT_BETWEEN_EYES;
                        default:
                            switch (i) {
                                case 9:
                                    return NOSE_TIP;
                                case 10:
                                    return UPPER_LIP;
                                case 11:
                                    return LOWER_LIP;
                                case 12:
                                    return MOUTH_LEFT;
                                case 13:
                                    return MOUTH_RIGHT;
                                default:
                                    switch (i) {
                                        case 43:
                                            return NOSE_BOTTOM_RIGHT;
                                        case 44:
                                            return NOSE_BOTTOM_LEFT;
                                        case 45:
                                            return MOUTH_CENTER;
                                        default:
                                            switch (i) {
                                                case 220:
                                                    return LEFT_EYE_TOP_BOUNDARY;
                                                case 221:
                                                    return LEFT_EYE_RIGHT_CORNER;
                                                case 222:
                                                    return LEFT_EYE_BOTTOM_BOUNDARY;
                                                case 223:
                                                    return LEFT_EYE_LEFT_CORNER;
                                                case ISO7816Kt.INS_CREATE_FILE /* 224 */:
                                                    return RIGHT_EYE_TOP_BOUNDARY;
                                                case JfifUtil.MARKER_APP1 /* 225 */:
                                                    return RIGHT_EYE_RIGHT_CORNER;
                                                case 226:
                                                    return RIGHT_EYE_BOTTOM_BOUNDARY;
                                                case 227:
                                                    return RIGHT_EYE_LEFT_CORNER;
                                                default:
                                                    switch (i) {
                                                        case 238:
                                                            return LEFT_CHEEK_CENTER;
                                                        case 239:
                                                            return RIGHT_CHEEK_CENTER;
                                                        case 240:
                                                            return LEFT_EAR_TRAGION;
                                                        case 241:
                                                            return RIGHT_EAR_TRAGION;
                                                        case 242:
                                                            return LEFT_EAR_TOP;
                                                        case 243:
                                                            return RIGHT_EAR_TOP;
                                                        default:
                                                            switch (i) {
                                                                case 314:
                                                                    return CHIN_GNATHION;
                                                                case 315:
                                                                    return CHIN_LEFT_GONION;
                                                                case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                                                                    return CHIN_RIGHT_GONION;
                                                                default:
                                                                    return null;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                return RIGHT_EYE_PUPIL;
            }

            public static zzjg zzb() {
                return zzmx.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzao);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zzb(int i) {
                this.zzao = i;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public enum zzc implements zzje {
            VISIBILITY_UNKNOWN(0),
            VISIBLE(1),
            OCCLUDED_SELF(2),
            OCCLUDED_OTHER(3);

            private static final zzjh<zzc> zze = new zzmz();
            private final int zzf;

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zzc zza(int i) {
                if (i == 0) {
                    return VISIBILITY_UNKNOWN;
                }
                if (i == 1) {
                    return VISIBLE;
                }
                if (i == 2) {
                    return OCCLUDED_SELF;
                }
                if (i != 3) {
                    return null;
                }
                return OCCLUDED_OTHER;
            }

            public static zzjg zzb() {
                return zzmy.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zzc(int i) {
                this.zzf = i;
            }
        }

        private zze() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        public static final class zza extends zzjb.zzb<zze, zza> implements zzkm {
            private zza() {
                super(zze.zzj);
            }

            /* synthetic */ zza(zzms zzmsVar) {
                this();
            }
        }

        public final float zza() {
            return this.zzd;
        }

        public final float zzb() {
            return this.zze;
        }

        public final zzb zzc() {
            zzb zzbVarZza = zzb.zza(this.zzg);
            return zzbVarZza == null ? zzb.LANDMARK_UNKNOWN : zzbVarZza;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v13, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzmt$zze>] */
        /* JADX WARN: Type inference failed for: r10v16 */
        /* JADX WARN: Type inference failed for: r10v17 */
        @Override // com.google.android.gms.internal.vision.zzjb
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r10;
            zzms zzmsVar = null;
            switch (zzms.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzmsVar);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzb.zzb(), "zzh", zzc.zzb(), "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzkx<zze> zzkxVar = zzk;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zze.class) {
                            zzkx<zze> zzkxVar2 = zzk;
                            r10 = zzkxVar2;
                            if (zzkxVar2 == null) {
                                ?? zzaVar = new zzjb.zza(zzj);
                                zzk = zzaVar;
                                r10 = zzaVar;
                            }
                            break;
                        }
                        obj3 = r10;
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
            zzj = zzeVar;
            zzjb.zza((Class<zze>) zze.class, zzeVar);
        }
    }

    private zzmt() {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    public static final class zzc extends zzjb.zzd<zzmt, zzc> implements zzkm {
        private zzc() {
            super(zzmt.zzs);
        }

        /* synthetic */ zzc(zzms zzmsVar) {
            this();
        }
    }

    public final zzb zzb() {
        zzb zzbVar = this.zze;
        return zzbVar == null ? zzb.zze() : zzbVar;
    }

    public final List<zze> zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zzd & 2) != 0;
    }

    public final float zze() {
        return this.zzg;
    }

    public final float zzf() {
        return this.zzh;
    }

    public final float zzs() {
        return this.zzi;
    }

    public final float zzt() {
        return this.zzj;
    }

    public final List<zza> zzu() {
        return this.zzm;
    }

    public final long zzv() {
        return this.zzo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzmt>] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    @Override // com.google.android.gms.internal.vision.zzjb
    protected final Object zza(int i, Object obj, Object obj2) {
        ?? r0;
        zzms zzmsVar = null;
        switch (zzms.zza[i - 1]) {
            case 1:
                return new zzmt();
            case 2:
                return new zzc(zzmsVar);
            case 3:
                return zza(zzs, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0003\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001\u0004ခ\u0002\u0005ခ\u0003\u0006ခ\u0004\u0007\u001b\b\u001b\tဃ\u0007\nခ\t\u000bဃ\b\fဃ\u0006\rခ\u0005", new Object[]{"zzd", "zze", "zzf", zze.class, "zzg", "zzh", "zzi", "zzj", "zzl", zzd.class, "zzm", zza.class, "zzo", "zzq", "zzp", "zzn", "zzk"});
            case 4:
                return zzs;
            case 5:
                zzkx<zzmt> zzkxVar = zzt;
                Object obj3 = zzkxVar;
                if (zzkxVar == null) {
                    synchronized (zzmt.class) {
                        zzkx<zzmt> zzkxVar2 = zzt;
                        r0 = zzkxVar2;
                        if (zzkxVar2 == null) {
                            ?? zzaVar = new zzjb.zza(zzs);
                            zzt = zzaVar;
                            r0 = zzaVar;
                        }
                        break;
                    }
                    obj3 = r0;
                }
                return obj3;
            case 6:
                return Byte.valueOf(this.zzr);
            case 7:
                this.zzr = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzmt zzw() {
        return zzs;
    }

    static {
        zzmt zzmtVar = new zzmt();
        zzs = zzmtVar;
        zzjb.zza((Class<zzmt>) zzmt.class, zzmtVar);
    }
}
