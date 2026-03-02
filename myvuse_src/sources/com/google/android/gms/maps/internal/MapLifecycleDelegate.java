package com.google.android.gms.maps.internal;

import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.maps.OnMapReadyCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface MapLifecycleDelegate extends LifecycleDelegate {
    void getMapAsync(OnMapReadyCallback onMapReadyCallback);
}
