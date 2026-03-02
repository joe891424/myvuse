package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzh extends com.google.android.gms.maps.internal.zzax {
    final /* synthetic */ GoogleMap.OnMyLocationButtonClickListener zza;

    zzh(GoogleMap googleMap, GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        this.zza = onMyLocationButtonClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzay
    public final boolean zzb() throws RemoteException {
        return this.zza.onMyLocationButtonClick();
    }
}
