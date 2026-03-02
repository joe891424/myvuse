package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

/* JADX INFO: compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzat extends com.google.android.gms.maps.internal.zzar {
    final /* synthetic */ OnMapReadyCallback zza;

    zzat(zzau zzauVar, OnMapReadyCallback onMapReadyCallback) {
        this.zza = onMapReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzas
    public final void zzb(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.zza.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
