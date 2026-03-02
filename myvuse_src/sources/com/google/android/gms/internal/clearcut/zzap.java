package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* JADX INFO: loaded from: classes3.dex */
public final class zzap {

    public static final class zza extends zzcg<zza, C5964zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        private static final zza zzes;
        private int zzbb;
        private int zzel;
        private int zzem;
        private int zzen;
        private int zzeo;
        private int zzep;
        private int zzeq;
        private int zzer;

        /* JADX INFO: renamed from: com.google.android.gms.internal.clearcut.zzap$zza$zza, reason: collision with other inner class name */
        public static final class C5964zza extends zzcg.zza<zza, C5964zza> implements zzdq {
            private C5964zza() {
                super(zza.zzes);
            }

            /* synthetic */ C5964zza(zzaq zzaqVar) {
                this();
            }
        }

        public enum zzb implements zzcj {
            UNKNOWN(0),
            ON(1),
            OFF(2);

            private static final zzck<zzb> zzbq = new zzar();
            private final int value;

            zzb(int i) {
                this.value = i;
            }

            public static zzck<zzb> zzd() {
                return zzbq;
            }

            public static zzb zze(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return ON;
                }
                if (i != 2) {
                    return null;
                }
                return OFF;
            }

            @Override // com.google.android.gms.internal.clearcut.zzcj
            public final int zzc() {
                return this.value;
            }
        }

        static {
            zza zzaVar = new zza();
            zzes = zzaVar;
            zzcg.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzap$zza>] */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        @Override // com.google.android.gms.internal.clearcut.zzcg
        protected final Object zza(int i, Object obj, Object obj2) {
            ?? r0;
            zzaq zzaqVar = null;
            switch (zzaq.zzba[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C5964zza(zzaqVar);
                case 3:
                    return zza(zzes, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002\u0004\f\u0003\u0005\f\u0004\u0006\f\u0005\u0007\f\u0006", new Object[]{"zzbb", "zzel", zzb.zzd(), "zzem", zzb.zzd(), "zzen", zzb.zzd(), "zzeo", zzb.zzd(), "zzep", zzb.zzd(), "zzeq", zzb.zzd(), "zzer", zzb.zzd()});
                case 4:
                    return zzes;
                case 5:
                    zzdz<zza> zzdzVar = zzbg;
                    Object obj3 = zzdzVar;
                    if (zzdzVar == null) {
                        synchronized (zza.class) {
                            zzdz<zza> zzdzVar2 = zzbg;
                            r0 = zzdzVar2;
                            if (zzdzVar2 == null) {
                                ?? zzbVar = new zzcg.zzb(zzes);
                                zzbg = zzbVar;
                                r0 = zzbVar;
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
    }
}
