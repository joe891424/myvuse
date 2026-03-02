package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzip implements zzlj {
    private final zzil zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final zzhx zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    public static zzip zza(zzil zzilVar) {
        if (zzilVar.zzc != null) {
            return zzilVar.zzc;
        }
        return new zzip(zzilVar);
    }

    private final Object zza(zzmo zzmoVar, Class<?> cls, zzix zzixVar) throws IOException {
        switch (zzis.zza[zzmoVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzle.zza().zza((Class) cls), zzixVar);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final <T> T zza(zzli<T> zzliVar, zzix zzixVar) throws IOException {
        T tZza = zzliVar.zza();
        zzc(tZza, zzliVar, zzixVar);
        zzliVar.zzc(tZza);
        return tZza;
    }

    private final <T> T zzb(zzli<T> zzliVar, zzix zzixVar) throws IOException {
        T tZza = zzliVar.zza();
        zzd(tZza, zzliVar, zzixVar);
        zzliVar.zzc(tZza);
        return tZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    private zzip(zzil zzilVar) {
        zzil zzilVar2 = (zzil) zzjn.zza(zzilVar, "input");
        this.zza = zzilVar2;
        zzilVar2.zzc = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final <T> void zza(T t, zzli<T> zzliVar, zzix zzixVar) throws IOException {
        zzb(3);
        zzc(t, zzliVar, zzixVar);
    }

    private final <T> void zzc(T t, zzli<T> zzliVar, zzix zzixVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzliVar.zza(t, this, zzixVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzjt.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final <T> void zzb(T t, zzli<T> zzliVar, zzix zzixVar) throws IOException {
        zzb(2);
        zzd(t, zzliVar, zzixVar);
    }

    private final <T> void zzd(T t, zzli<T> zzliVar, zzix zzixVar) throws IOException {
        int iZzj = this.zza.zzj();
        if (this.zza.zza >= this.zza.zzb) {
            throw new zzjt("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzb = this.zza.zzb(iZzj);
        this.zza.zza++;
        zzliVar.zza(t, this, zzixVar);
        this.zza.zzc(0);
        zzil zzilVar = this.zza;
        zzilVar.zza--;
        this.zza.zzd(iZzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zza(List<Boolean> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzhvVar.zza(this.zza.zzu());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzhvVar.zza(this.zza.zzu());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzb(List<zzhx> list) throws IOException {
        int iZzi;
        if ((this.zzb & 7) != 2) {
            throw zzjt.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == this.zzb);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzc(List<Double> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zziw) {
            zziw zziwVar = (zziw) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zziwVar.zza(this.zza.zza());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zziwVar.zza(this.zza.zza());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Double.valueOf(this.zza.zza()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Double.valueOf(this.zza.zza()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzd(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjlVar.zzd(this.zza.zzd());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjlVar.zzd(this.zza.zzd());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zze(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzjlVar.zzd(this.zza.zze());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i == 5) {
                do {
                    zzjlVar.zzd(this.zza.zze());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Integer.valueOf(this.zza.zze()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzf(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzkfVar.zza(this.zza.zzk());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzkfVar.zza(this.zza.zzk());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzk()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Long.valueOf(this.zza.zzk()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzg(List<Float> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjg) {
            zzjg zzjgVar = (zzjg) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzjgVar.zza(this.zza.zzb());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i == 5) {
                do {
                    zzjgVar.zza(this.zza.zzb());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Float.valueOf(this.zza.zzb()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzjt.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlj
    @Deprecated
    public final <T> void zza(List<T> list, zzli<T> zzliVar, zzix zzixVar) throws IOException {
        int iZzi;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzjt.zza();
        }
        do {
            list.add(zza(zzliVar, zzixVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == i);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzh(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjlVar.zzd(this.zza.zzf());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjlVar.zzd(this.zza.zzf());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzi(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzkfVar.zza(this.zza.zzl());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkfVar.zza(this.zza.zzl());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzl()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzl()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.zzkl<K, V> r9, com.google.android.gms.internal.measurement.zzix r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzb(r0)
            com.google.android.gms.internal.measurement.zzil r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.measurement.zzil r2 = r7.zza
            int r1 = r2.zzb(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L14:
            int r4 = r7.zzc()     // Catch: java.lang.Throwable -> L64
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5b
            com.google.android.gms.internal.measurement.zzil r5 = r7.zza     // Catch: java.lang.Throwable -> L64
            boolean r5 = r5.zzt()     // Catch: java.lang.Throwable -> L64
            if (r5 != 0) goto L5b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L46
            if (r4 == r0) goto L39
            boolean r4 = r7.zzt()     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.measurement.zzjt r4 = new com.google.android.gms.internal.measurement.zzjt     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            r4.<init>(r6)     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            throw r4     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
        L39:
            com.google.android.gms.internal.measurement.zzmo r4 = r9.zzc     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            V r5 = r9.zzd     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            goto L14
        L46:
            com.google.android.gms.internal.measurement.zzmo r4 = r9.zza     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: com.google.android.gms.internal.measurement.zzjs -> L4e java.lang.Throwable -> L64
            goto L14
        L4e:
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L64
            if (r4 == 0) goto L55
            goto L14
        L55:
            com.google.android.gms.internal.measurement.zzjt r8 = new com.google.android.gms.internal.measurement.zzjt     // Catch: java.lang.Throwable -> L64
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L64
            throw r8     // Catch: java.lang.Throwable -> L64
        L5b:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.internal.measurement.zzil r8 = r7.zza
            r8.zzd(r1)
            return
        L64:
            r8 = move-exception
            com.google.android.gms.internal.measurement.zzil r9 = r7.zza
            r9.zzd(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzip.zza(java.util.Map, com.google.android.gms.internal.measurement.zzkl, com.google.android.gms.internal.measurement.zzix):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzlj
    public final <T> void zzb(List<T> list, zzli<T> zzliVar, zzix zzixVar) throws IOException {
        int iZzi;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzjt.zza();
        }
        do {
            list.add(zzb(zzliVar, zzixVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == i);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzj(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzjlVar.zzd(this.zza.zzg());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i == 5) {
                do {
                    zzjlVar.zzd(this.zza.zzg());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzk(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzkfVar.zza(this.zza.zzn());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzkfVar.zza(this.zza.zzn());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzn()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Long.valueOf(this.zza.zzn()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzl(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjlVar.zzd(this.zza.zzh());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjlVar.zzd(this.zza.zzh());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzm(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzkfVar.zza(this.zza.zzo());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkfVar.zza(this.zza.zzo());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzo()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzn(List<String> list) throws IOException {
        zza(list, false);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int iZzi;
        int iZzi2;
        if ((this.zzb & 7) != 2) {
            throw zzjt.zza();
        }
        if ((list instanceof zzkb) && !z) {
            zzkb zzkbVar = (zzkb) list;
            do {
                zzkbVar.zza(zzp());
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi2 = this.zza.zzi();
                }
            } while (iZzi2 == this.zzb);
            this.zzd = iZzi2;
            return;
        }
        do {
            list.add(z ? zzr() : zzq());
            if (this.zza.zzt()) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == this.zzb);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzp(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjl) {
            zzjl zzjlVar = (zzjl) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjlVar.zzd(this.zza.zzj());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjlVar.zzd(this.zza.zzj());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final void zzq(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkf) {
            zzkf zzkfVar = (zzkf) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzkfVar.zza(this.zza.zzp());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkfVar.zza(this.zza.zzp());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzjt.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzjt.zza();
    }

    private final void zza(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw zzjt.zzh();
        }
    }

    private final void zzb(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzjt.zza();
        }
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzjt.zzg();
        }
    }

    private static void zzd(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzjt.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzt() throws IOException {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zze(i);
    }
}
