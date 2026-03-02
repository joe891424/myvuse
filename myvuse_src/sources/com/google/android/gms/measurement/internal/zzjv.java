package com.google.android.gms.measurement.internal;

import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzjv extends zzav {
    private final /* synthetic */ zziz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjv(zziz zzizVar, zzil zzilVar) {
        super(zzilVar);
        this.zza = zzizVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzav
    public final void zzb() {
        if (this.zza.zzu.zzah()) {
            this.zza.zzp.zza(FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS);
        }
    }
}
