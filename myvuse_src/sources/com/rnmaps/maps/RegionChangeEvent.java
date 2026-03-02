package com.rnmaps.maps;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.salesforce.marketingcloud.storage.p047db.C4349h;

/* JADX INFO: loaded from: classes6.dex */
public class RegionChangeEvent extends Event<RegionChangeEvent> {
    private final LatLngBounds bounds;
    private final boolean continuous;
    private final boolean isGesture;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    public RegionChangeEvent(int i, LatLngBounds latLngBounds, boolean z, boolean z2) {
        super(i);
        this.bounds = latLngBounds;
        this.continuous = z;
        this.isGesture = z2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("continuous", this.continuous);
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        LatLng center = this.bounds.getCenter();
        writableNativeMap2.putDouble(C4349h.a.f5610b, center.latitude);
        writableNativeMap2.putDouble(C4349h.a.f5611c, center.longitude);
        writableNativeMap2.putDouble("latitudeDelta", this.bounds.northeast.latitude - this.bounds.southwest.latitude);
        writableNativeMap2.putDouble("longitudeDelta", this.bounds.northeast.longitude - this.bounds.southwest.longitude);
        writableNativeMap.putMap("region", writableNativeMap2);
        writableNativeMap.putBoolean("isGesture", this.isGesture);
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), writableNativeMap);
    }
}
