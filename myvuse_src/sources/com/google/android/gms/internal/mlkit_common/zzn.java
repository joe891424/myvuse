package com.google.android.gms.internal.mlkit_common;

import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzn {
    final long zza;
    final long zzb;
    final boolean zzc;

    private zzn(long j, long j2, boolean z) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = z;
    }

    static zzn zza(final FileDescriptor fileDescriptor) throws IOException {
        StructStat structStat = (StructStat) zzc(new Callable(fileDescriptor) { // from class: com.google.android.gms.internal.mlkit_common.zzh
            private final FileDescriptor zza;

            {
                this.zza = fileDescriptor;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Os.fstat(this.zza);
            }
        });
        return new zzn(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    static zzn zzb(final String str) throws IOException {
        StructStat structStat = (StructStat) zzc(new Callable(str) { // from class: com.google.android.gms.internal.mlkit_common.zzi
            private final String zza;

            {
                this.zza = str;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Os.lstat(this.zza);
            }
        });
        return new zzn(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    private static <T> T zzc(Callable<T> callable) throws IOException {
        try {
            return callable.call();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
