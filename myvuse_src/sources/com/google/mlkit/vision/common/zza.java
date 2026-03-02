package com.google.mlkit.vision.common;

import android.media.Image;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zza {
    private final Image zza;

    zza(Image image) {
        this.zza = image;
    }

    final Image zza() {
        return this.zza;
    }

    final Image.Plane[] zzb() {
        return this.zza.getPlanes();
    }
}
