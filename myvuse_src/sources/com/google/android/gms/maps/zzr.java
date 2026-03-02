package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbd;
import com.google.android.gms.maps.model.PointOfInterest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzr extends zzbd {
    final /* synthetic */ GoogleMap.OnPoiClickListener zza;

    zzr(GoogleMap googleMap, GoogleMap.OnPoiClickListener onPoiClickListener) {
        this.zza = onPoiClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzbe
    public final void zzb(PointOfInterest pointOfInterest) throws RemoteException {
        this.zza.onPoiClick(pointOfInterest);
    }
}
