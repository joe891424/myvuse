package com.google.mlkit.vision.common.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzb implements OnFailureListener {
    static final OnFailureListener zza = new zzb();

    private zzb() {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        MobileVisionBase.zzb.m2360e("MobileVisionBase", "Error preloading model resource", exc);
    }
}
