package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgy {
    public static void zza(zzgo zzgoVar, final int i, final int i2, long j, final int i3, final int i4, final int i5, final int i6) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        zzgoVar.zza(new zzgn(i, i2, i5, i3, i4, jElapsedRealtime, i6) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzgx
            private final int zza;
            private final int zzb;
            private final int zzc;
            private final int zzd;
            private final int zze;
            private final long zzf;
            private final int zzg;

            {
                this.zza = i;
                this.zzb = i2;
                this.zzc = i5;
                this.zzd = i3;
                this.zze = i4;
                this.zzf = jElapsedRealtime;
                this.zzg = i6;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzgn
            public final zzgj zza() {
                int i7 = this.zza;
                int i8 = this.zzb;
                int i9 = this.zzc;
                int i10 = this.zzd;
                int i11 = this.zze;
                long j2 = this.zzf;
                int i12 = this.zzg;
                zzer zzerVar = new zzer();
                zzerVar.zzc(i7 != -1 ? i7 != 35 ? i7 != 842094169 ? i7 != 16 ? i7 != 17 ? zzen.UNKNOWN_FORMAT : zzen.NV21 : zzen.NV16 : zzen.YV12 : zzen.YUV_420_888 : zzen.BITMAP);
                zzerVar.zzb(i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? zzes.ANDROID_MEDIA_IMAGE : zzes.FILEPATH : zzes.BYTEBUFFER : zzes.BYTEARRAY : zzes.BITMAP);
                zzerVar.zzd(Integer.valueOf(i9));
                zzerVar.zzf(Integer.valueOf(i10));
                zzerVar.zze(Integer.valueOf(i11));
                zzerVar.zza(Long.valueOf(j2));
                zzerVar.zzg(Integer.valueOf(i12));
                zzet zzetVarZzh = zzerVar.zzh();
                zzez zzezVar = new zzez();
                zzezVar.zzc(zzetVarZzh);
                return zzgj.zzc(zzezVar);
            }
        }, zzex.INPUT_IMAGE_CONSTRUCTION);
    }
}
