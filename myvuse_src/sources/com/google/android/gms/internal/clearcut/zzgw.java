package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgw {

    public static final class zza extends zzcg<zza, C5967zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        private static final zza zzbir;
        private zzcn<zzb> zzbiq = zzbb();

        /* JADX INFO: renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zza, reason: collision with other inner class name */
        public static final class C5967zza extends zzcg.zza<zza, C5967zza> implements zzdq {
            private C5967zza() {
                super(zza.zzbir);
            }

            /* synthetic */ C5967zza(zzgx zzgxVar) {
                this();
            }
        }

        public static final class zzb extends zzcg<zzb, C5968zza> implements zzdq {
            private static volatile zzdz<zzb> zzbg;
            private static final zzb zzbiv;
            private int zzbb;
            private String zzbis = "";
            private long zzbit;
            private long zzbiu;
            private int zzya;

            /* JADX INFO: renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza, reason: collision with other inner class name */
            public static final class C5968zza extends zzcg.zza<zzb, C5968zza> implements zzdq {
                private C5968zza() {
                    super(zzb.zzbiv);
                }

                /* synthetic */ C5968zza(zzgx zzgxVar) {
                    this();
                }

                public final C5968zza zzn(String str) {
                    zzbf();
                    ((zzb) this.zzjt).zzm(str);
                    return this;
                }

                public final C5968zza zzr(long j) {
                    zzbf();
                    ((zzb) this.zzjt).zzp(j);
                    return this;
                }

                public final C5968zza zzs(long j) {
                    zzbf();
                    ((zzb) this.zzjt).zzq(j);
                    return this;
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzbiv = zzbVar;
                zzcg.zza((Class<zzb>) zzb.class, zzbVar);
            }

            private zzb() {
            }

            public static C5968zza zzfz() {
                return (C5968zza) ((zzcg.zza) zzbiv.zza(zzcg.zzg.zzkh, (Object) null, (Object) null));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzm(String str) {
                str.getClass();
                this.zzbb |= 2;
                this.zzbis = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzp(long j) {
                this.zzbb |= 4;
                this.zzbit = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzq(long j) {
                this.zzbb |= 8;
                this.zzbiu = j;
            }

            public final int getEventCode() {
                return this.zzya;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v13 */
            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb>] */
            /* JADX WARN: Type inference failed for: r3v17 */
            /* JADX WARN: Type inference failed for: r3v18 */
            @Override // com.google.android.gms.internal.clearcut.zzcg
            protected final Object zza(int i, Object obj, Object obj2) {
                ?? r3;
                zzgx zzgxVar = null;
                switch (zzgx.zzba[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C5968zza(zzgxVar);
                    case 3:
                        return zza(zzbiv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003", new Object[]{"zzbb", "zzya", "zzbis", "zzbit", "zzbiu"});
                    case 4:
                        return zzbiv;
                    case 5:
                        zzdz<zzb> zzdzVar = zzbg;
                        Object obj3 = zzdzVar;
                        if (zzdzVar == null) {
                            synchronized (zzb.class) {
                                zzdz<zzb> zzdzVar2 = zzbg;
                                r3 = zzdzVar2;
                                if (zzdzVar2 == null) {
                                    ?? zzbVar = new zzcg.zzb(zzbiv);
                                    zzbg = zzbVar;
                                    r3 = zzbVar;
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

            public final boolean zzfv() {
                return (this.zzbb & 1) == 1;
            }

            public final String zzfw() {
                return this.zzbis;
            }

            public final long zzfx() {
                return this.zzbit;
            }

            public final long zzfy() {
                return this.zzbiu;
            }
        }

        static {
            zza zzaVar = new zza();
            zzbir = zzaVar;
            zzcg.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza zzft() {
            return zzbir;
        }

        public static zza zzi(byte[] bArr) throws zzco {
            return (zza) zzcg.zzb(zzbir, bArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza>] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        @Override // com.google.android.gms.internal.clearcut.zzcg
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r1;
            zzgx zzgxVar = null;
            switch (zzgx.zzba[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C5967zza(zzgxVar);
                case 3:
                    return zza(zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbiq", zzb.class});
                case 4:
                    return zzbir;
                case 5:
                    zzdz<zza> zzdzVar = zzbg;
                    Object obj3 = zzdzVar;
                    if (zzdzVar == null) {
                        synchronized (zza.class) {
                            zzdz<zza> zzdzVar2 = zzbg;
                            r1 = zzdzVar2;
                            if (zzdzVar2 == null) {
                                ?? zzbVar = new zzcg.zzb(zzbir);
                                zzbg = zzbVar;
                                r1 = zzbVar;
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

        public final List<zzb> zzfs() {
            return this.zzbiq;
        }
    }
}
