package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjk;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzft {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zza extends zzjk<zza, C5976zza> implements zzks {
        private static final zza zzc;
        private static volatile zzld<zza> zzd;
        private zzjq<zzb> zze = zzce();

        public final int zza() {
            return this.zze.size();
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzft$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class C5976zza extends zzjk.zza<zza, C5976zza> implements zzks {
            private C5976zza() {
                super(zza.zzc);
            }

            /* synthetic */ C5976zza(zzfs zzfsVar) {
                this();
            }
        }

        public static zza zzc() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C5976zza(zzfsVar);
                case 3:
                    return zza(zzc, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzb.class});
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

        public final List<zzb> zzd() {
            return this.zze;
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzjk.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
    public static final class zzb extends zzjk<zzb, zza> implements zzks {
        private static final zzb zzc;
        private static volatile zzld<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzjq<zzd> zzg = zzce();

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzb, zza> implements zzks {
            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzd.class});
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

        public final List<zzd> zzc() {
            return this.zzg;
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
        private zzjq<zzd> zzf = zzce();
        private zza zzg;

        public final zza zza() {
            zza zzaVar = this.zzg;
            return zzaVar == null ? zza.zzc() : zzaVar;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzc, zza> implements zzks {
            private zza() {
                super(zzc.zzc);
            }

            /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zza(zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzd.class, "zzg"});
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

        public final List<zzd> zzc() {
            return this.zzf;
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
    public static final class zzd extends zzjk<zzd, zza> implements zzks {
        private static final zzd zzc;
        private static volatile zzld<zzd> zzd;
        private int zze;
        private int zzf;
        private zzjq<zzd> zzg = zzce();
        private String zzh = "";
        private String zzi = "";
        private boolean zzj;
        private double zzk;

        public final double zza() {
            return this.zzk;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public static final class zza extends zzjk.zza<zzd, zza> implements zzks {
            private zza() {
                super(zzd.zzc);
            }

            /* synthetic */ zza(zzfs zzfsVar) {
                this();
            }
        }

        public final zzb zzb() {
            zzb zzbVarZza = zzb.zza(this.zzf);
            return zzbVarZza == null ? zzb.UNKNOWN : zzbVarZza;
        }

        @Override // com.google.android.gms.internal.measurement.zzjk
        protected final Object zza(int i, Object obj, Object obj2) {
            zzfs zzfsVar = null;
            switch (zzfs.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzfsVar);
                case 3:
                    return zza(zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", zzd.class, "zzh", "zzi", "zzj", "zzk"});
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

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
        public enum zzb implements zzjm {
            UNKNOWN(0),
            STRING(1),
            NUMBER(2),
            BOOLEAN(3),
            STATEMENT(4);

            private final int zzg;

            @Override // com.google.android.gms.internal.measurement.zzjm
            public final int zza() {
                return this.zzg;
            }

            public static zzb zza(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return STRING;
                }
                if (i == 2) {
                    return NUMBER;
                }
                if (i == 3) {
                    return BOOLEAN;
                }
                if (i != 4) {
                    return null;
                }
                return STATEMENT;
            }

            public static zzjp zzb() {
                return zzfu.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzg);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zzb(int i) {
                this.zzg = i;
            }
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzi;
        }

        public final List<zzd> zzf() {
            return this.zzg;
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzjk.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public final boolean zzg() {
            return this.zzj;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 4) != 0;
        }
    }
}
