package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzjk;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfj {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zza extends zzjk<zza, C5971zza> implements zzks {
        private static final zza zzc;
        private static volatile zzld<zza> zzd;
        private int zze;
        private boolean zzi;
        private zzjq<zzb> zzf = zzce();
        private zzjq<zzc> zzg = zzce();
        private zzjq<zzf> zzh = zzce();
        private zzjq<zzb> zzj = zzce();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zzb extends zzjk<zzb, C5972zza> implements zzks {
            private static final zzb zzc;
            private static volatile zzld<zzb> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfj$zza$zzb$zza, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
            public static final class C5972zza extends zzjk.zza<zzb, C5972zza> implements zzks {
                private C5972zza() {
                    super(zzb.zzc);
                }

                /* synthetic */ C5972zza(zzfi zzfiVar) {
                    this();
                }
            }

            public final zzd zzb() {
                zzd zzdVarZza = zzd.zza(this.zzg);
                return zzdVarZza == null ? zzd.CONSENT_STATUS_UNSPECIFIED : zzdVarZza;
            }

            public final zze zzc() {
                zze zzeVarZza = zze.zza(this.zzf);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            @Override // com.google.android.gms.internal.measurement.zzjk
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfi zzfiVar = null;
                switch (zzfi.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C5972zza(zzfiVar);
                    case 3:
                        return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zzd.zzb()});
                    case 4:
                        return zzc;
                    case 5:
                        zzld<zzb> zzcVar = zzd;
                        if (zzcVar == null) {
                            synchronized (zzb.class) {
                                zzcVar = zzd;
                                if (zzcVar == null) {
                                    zzcVar = new zzjk.zzc<>(zzc);
                                    zzd = zzcVar;
                                }
                                break;
                            }
                        }
                        return zzcVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzc = zzbVar;
                zzjk.zza((Class<zzb>) zzb.class, zzbVar);
            }

            private zzb() {
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zzc extends zzjk<zzc, C5973zza> implements zzks {
            private static final zzc zzc;
            private static volatile zzld<zzc> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfj$zza$zzc$zza, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
            public static final class C5973zza extends zzjk.zza<zzc, C5973zza> implements zzks {
                private C5973zza() {
                    super(zzc.zzc);
                }

                /* synthetic */ C5973zza(zzfi zzfiVar) {
                    this();
                }
            }

            public final zze zzb() {
                zze zzeVarZza = zze.zza(this.zzg);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            public final zze zzc() {
                zze zzeVarZza = zze.zza(this.zzf);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            @Override // com.google.android.gms.internal.measurement.zzjk
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfi zzfiVar = null;
                switch (zzfi.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new C5973zza(zzfiVar);
                    case 3:
                        return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zze.zzb()});
                    case 4:
                        return zzc;
                    case 5:
                        zzld<zzc> zzcVar = zzd;
                        if (zzcVar == null) {
                            synchronized (zzc.class) {
                                zzcVar = zzd;
                                if (zzcVar == null) {
                                    zzcVar = new zzjk.zzc<>(zzc);
                                    zzd = zzcVar;
                                }
                                break;
                            }
                        }
                        return zzcVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zzc = zzcVar;
                zzjk.zza((Class<zzc>) zzc.class, zzcVar);
            }

            private zzc() {
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zzf extends zzjk<zzf, C5974zza> implements zzks {
            private static final zzf zzc;
            private static volatile zzld<zzf> zzd;
            private int zze;
            private String zzf = "";
            private String zzg = "";

            /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfj$zza$zzf$zza, reason: collision with other inner class name */
            /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
            public static final class C5974zza extends zzjk.zza<zzf, C5974zza> implements zzks {
                private C5974zza() {
                    super(zzf.zzc);
                }

                /* synthetic */ C5974zza(zzfi zzfiVar) {
                    this();
                }
            }

            @Override // com.google.android.gms.internal.measurement.zzjk
            protected final Object zza(int i, Object obj, Object obj2) {
                zzfi zzfiVar = null;
                switch (zzfi.zza[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C5974zza(zzfiVar);
                    case 3:
                        return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                    case 4:
                        return zzc;
                    case 5:
                        zzld<zzf> zzcVar = zzd;
                        if (zzcVar == null) {
                            synchronized (zzf.class) {
                                zzcVar = zzd;
                                if (zzcVar == null) {
                                    zzcVar = new zzjk.zzc<>(zzc);
                                    zzd = zzcVar;
                                }
                                break;
                            }
                        }
                        return zzcVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public final String zzb() {
                return this.zzf;
            }

            static {
                zzf zzfVar = new zzf();
                zzc = zzfVar;
                zzjk.zza((Class<zzf>) zzf.class, zzfVar);
            }

            private zzf() {
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzfj$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class C5971zza extends zzjk.zza<zza, C5971zza> implements zzks {
            private C5971zza() {
                super(zza.zzc);
            }

            /* synthetic */ C5971zza(zzfi zzfiVar) {
                this();
            }
        }

        public static zza zzb() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfi zzfiVar = null;
            switch (zzfi.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C5971zza(zzfiVar);
                case 3:
                    return zza(zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", zzb.class, "zzg", zzc.class, "zzh", zzf.class, "zzi", "zzj", zzb.class});
                case 4:
                    return zzc;
                case 5:
                    zzld<zza> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zza.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjk.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public enum zzd implements zzjm {
            CONSENT_STATUS_UNSPECIFIED(0),
            GRANTED(1),
            DENIED(2);

            private final int zze;

            @Override // com.google.android.gms.internal.measurement.zzjm
            public final int zza() {
                return this.zze;
            }

            public static zzd zza(int i) {
                if (i == 0) {
                    return CONSENT_STATUS_UNSPECIFIED;
                }
                if (i == 1) {
                    return GRANTED;
                }
                if (i != 2) {
                    return null;
                }
                return DENIED;
            }

            public static zzjp zzb() {
                return zzfk.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zzd(int i) {
                this.zze = i;
            }
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public enum zze implements zzjm {
            CONSENT_TYPE_UNSPECIFIED(0),
            AD_STORAGE(1),
            ANALYTICS_STORAGE(2),
            AD_USER_DATA(3),
            AD_PERSONALIZATION(4);

            private final int zzg;

            @Override // com.google.android.gms.internal.measurement.zzjm
            public final int zza() {
                return this.zzg;
            }

            public static zze zza(int i) {
                if (i == 0) {
                    return CONSENT_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return AD_STORAGE;
                }
                if (i == 2) {
                    return ANALYTICS_STORAGE;
                }
                if (i == 3) {
                    return AD_USER_DATA;
                }
                if (i != 4) {
                    return null;
                }
                return AD_PERSONALIZATION;
            }

            public static zzjp zzb() {
                return zzfl.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzg);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zze(int i) {
                this.zzg = i;
            }
        }

        public final List<zzf> zzc() {
            return this.zzh;
        }

        public final List<zzb> zzd() {
            return this.zzf;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final List<zzb> zzf() {
            return this.zzj;
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzjk.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public final boolean zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            return (this.zze & 1) != 0;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zzb extends zzjk<zzb, zza> implements zzks {
        private static final zzb zzc;
        private static volatile zzld<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzjq<zzf> zzg = zzce();
        private boolean zzh;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzb, zza> implements zzks {
            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzfi zzfiVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfi zzfiVar = null;
            switch (zzfi.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfiVar);
                case 3:
                    return zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzf.class, "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzld<zzb> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzb.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjk.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzb() {
            return this.zzf;
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzjk.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zzc extends zzjk<zzc, zza> implements zzks {
        private static final zzc zzc;
        private static volatile zzld<zzc> zzd;
        private int zze;
        private String zzf = "";
        private boolean zzg;
        private boolean zzh;
        private int zzi;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzc, zza> implements zzks {
            public final int zza() {
                return ((zzc) this.zza).zza();
            }

            public final zza zza(String str) {
                zzaj();
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final String zzb() {
                return ((zzc) this.zza).zzc();
            }

            private zza() {
                super(zzc.zzc);
            }

            /* synthetic */ zza(zzfi zzfiVar) {
                this();
            }

            public final boolean zzc() {
                return ((zzc) this.zza).zzd();
            }

            public final boolean zzd() {
                return ((zzc) this.zza).zze();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzf();
            }

            public final boolean zzf() {
                return ((zzc) this.zza).zzg();
            }

            public final boolean zzg() {
                return ((zzc) this.zza).zzh();
            }
        }

        public final int zza() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfi zzfiVar = null;
            switch (zzfi.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfiVar);
                case 3:
                    return zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzld<zzc> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzc.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjk.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzc() {
            return this.zzf;
        }

        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzjk.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zzd extends zzjk<zzd, zza> implements zzks {
        private static final zzd zzc;
        private static volatile zzld<zzd> zzd;
        private int zze;
        private long zzf;
        private int zzh;
        private boolean zzm;
        private zza zzr;
        private zze zzs;
        private zzh zzt;
        private zzf zzu;
        private String zzg = "";
        private zzjq<zzg> zzi = zzce();
        private zzjq<zzc> zzj = zzce();
        private zzjq<zzff.zza> zzk = zzce();
        private String zzl = "";
        private zzjq<zzft.zzc> zzn = zzce();
        private zzjq<zzb> zzo = zzce();
        private String zzp = "";
        private String zzq = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzd, zza> implements zzks {
            public final int zza() {
                return ((zzd) this.zza).zzb();
            }

            public final zzc zza(int i) {
                return ((zzd) this.zza).zza(i);
            }

            public final zza zzb() {
                zzaj();
                ((zzd) this.zza).zzt();
                return this;
            }

            public final zza zza(int i, zzc.zza zzaVar) {
                zzaj();
                ((zzd) this.zza).zza(i, (zzc) ((zzjk) zzaVar.zzag()));
                return this;
            }

            public final String zzc() {
                return ((zzd) this.zza).zzj();
            }

            public final List<zzff.zza> zzd() {
                return Collections.unmodifiableList(((zzd) this.zza).zzk());
            }

            public final List<zzb> zze() {
                return Collections.unmodifiableList(((zzd) this.zza).zzl());
            }

            private zza() {
                super(zzd.zzc);
            }

            /* synthetic */ zza(zzfi zzfiVar) {
                this();
            }
        }

        public final int zza() {
            return this.zzn.size();
        }

        public final int zzb() {
            return this.zzj.size();
        }

        public final long zzc() {
            return this.zzf;
        }

        public final zza zzd() {
            zza zzaVar = this.zzr;
            return zzaVar == null ? zza.zzb() : zzaVar;
        }

        public final zzc zza(int i) {
            return this.zzj.get(i);
        }

        public static zza zze() {
            return zzc.zzbz();
        }

        public static zzd zzg() {
            return zzc;
        }

        public final zzh zzh() {
            zzh zzhVar = this.zzt;
            return zzhVar == null ? zzh.zzc() : zzhVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfi zzfiVar = null;
            switch (zzfi.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfiVar);
                case 3:
                    return zza(zzc, "\u0001\u0010\u0000\u0001\u0001\u0012\u0010\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzg.class, "zzj", zzc.class, "zzk", zzff.zza.class, "zzl", "zzm", "zzn", zzft.zzc.class, "zzo", zzb.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
                case 4:
                    return zzc;
                case 5:
                    zzld<zzd> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzd.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjk.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzi() {
            return this.zzg;
        }

        public final String zzj() {
            return this.zzp;
        }

        public final List<zzff.zza> zzk() {
            return this.zzk;
        }

        public final List<zzb> zzl() {
            return this.zzo;
        }

        public final List<zzft.zzc> zzm() {
            return this.zzn;
        }

        public final List<zzg> zzn() {
            return this.zzi;
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzjk.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt() {
            this.zzk = zzce();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zzc zzcVar) {
            zzcVar.getClass();
            zzjq<zzc> zzjqVar = this.zzj;
            if (!zzjqVar.zzc()) {
                this.zzj = zzjk.zza(zzjqVar);
            }
            this.zzj.set(i, zzcVar);
        }

        public final boolean zzo() {
            return this.zzm;
        }

        public final boolean zzp() {
            return (this.zze & 128) != 0;
        }

        public final boolean zzq() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzr() {
            return (this.zze & 512) != 0;
        }

        public final boolean zzs() {
            return (this.zze & 1) != 0;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zze extends zzjk<zze, zza> implements zzks {
        private static final zze zzc;
        private static volatile zzld<zze> zzd;
        private int zze;
        private int zzf = 14;
        private int zzg = 11;
        private int zzh = 60;

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zze, zza> implements zzks {
            private zza() {
                super(zze.zzc);
            }

            /* synthetic */ zza(zzfi zzfiVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfi zzfiVar = null;
            switch (zzfi.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzfiVar);
                case 3:
                    return zza(zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzld<zze> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zze.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjk.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
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
            zzc = zzeVar;
            zzjk.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zzf extends zzjk<zzf, zza> implements zzks {
        private static final zzf zzc;
        private static volatile zzld<zzf> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzf, zza> implements zzks {
            private zza() {
                super(zzf.zzc);
            }

            /* synthetic */ zza(zzfi zzfiVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfi zzfiVar = null;
            switch (zzfi.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzfiVar);
                case 3:
                    return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzld<zzf> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzf.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjk.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
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
            zzc = zzfVar;
            zzjk.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zzg extends zzjk<zzg, zza> implements zzks {
        private static final zzg zzc;
        private static volatile zzld<zzg> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzg, zza> implements zzks {
            private zza() {
                super(zzg.zzc);
            }

            /* synthetic */ zza(zzfi zzfiVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfi zzfiVar = null;
            switch (zzfi.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzfiVar);
                case 3:
                    return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzld<zzg> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzg.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjk.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        static {
            zzg zzgVar = new zzg();
            zzc = zzgVar;
            zzjk.zza((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zzh extends zzjk<zzh, zza> implements zzks {
        private static final zzh zzc;
        private static volatile zzld<zzh> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private int zzi;

        public final int zza() {
            return this.zzi;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzh, zza> implements zzks {
            private zza() {
                super(zzh.zzc);
            }

            /* synthetic */ zza(zzfi zzfiVar) {
                this();
            }
        }

        public static zzh zzc() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfi zzfiVar = null;
            switch (zzfi.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(zzfiVar);
                case 3:
                    return zza(zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzld<zzh> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzh.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzjk.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                            break;
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzd() {
            return this.zzg;
        }

        public final String zze() {
            return this.zzf;
        }

        static {
            zzh zzhVar = new zzh();
            zzc = zzhVar;
            zzjk.zza((Class<zzh>) zzh.class, zzhVar);
        }

        private zzh() {
        }
    }
}
