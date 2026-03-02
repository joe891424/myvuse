package com.google.android.gms.internal.measurement;

import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzch implements zzci {
    @Override // com.google.android.gms.internal.measurement.zzci
    public final String zza(String str, zzck zzckVar, int i) {
        return str;
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final /* synthetic */ String zza(String str) {
        return zza(str, zzck.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final /* synthetic */ String zza(File file, String str) {
        return zza(file, str, zzck.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final /* synthetic */ String zza(String str, zzck zzckVar) {
        return zza(str, zzckVar, 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final /* synthetic */ String zza(File file, String str, zzck zzckVar) {
        return zza(new File(file, str).getPath(), zzckVar);
    }

    zzch() {
    }
}
