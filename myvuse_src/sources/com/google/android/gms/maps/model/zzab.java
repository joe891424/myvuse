package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzab extends zzal {
    final /* synthetic */ TileProvider zza;

    zzab(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zza = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    public final Tile zzb(int i, int i2, int i3) {
        return this.zza.getTile(i, i2, i3);
    }
}
