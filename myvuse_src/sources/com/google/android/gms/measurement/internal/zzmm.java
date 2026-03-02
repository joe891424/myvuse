package com.google.android.gms.measurement.internal;

import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmm {
    final /* synthetic */ zzml zza;
    private zzmp zzb;

    zzmm(zzml zzmlVar) {
        this.zza = zzmlVar;
    }

    final void zza(long j) {
        this.zzb = new zzmp(this, this.zza.zzb().currentTimeMillis(), j);
        this.zza.zzc.postDelayed(this.zzb, FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS);
    }

    final void zza() {
        this.zza.zzt();
        if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        this.zza.zzk().zzn.zza(false);
        this.zza.zza(false);
    }
}
