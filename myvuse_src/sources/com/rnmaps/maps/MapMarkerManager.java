package com.rnmaps.maps;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.salesforce.marketingcloud.storage.p047db.C4349h;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes6.dex */
public class MapMarkerManager extends ViewGroupManager<MapMarker> {
    private final Map<String, AirMapMarkerSharedIcon> sharedIcons = new ConcurrentHashMap();

    public static class AirMapMarkerSharedIcon {
        private Bitmap bitmap;
        private BitmapDescriptor iconBitmapDescriptor;
        private final Map<MapMarker, Boolean> markers = new WeakHashMap();
        private boolean loadImageStarted = false;

        public synchronized boolean shouldLoadImage() {
            if (this.loadImageStarted) {
                return false;
            }
            this.loadImageStarted = true;
            return true;
        }

        public synchronized void addMarker(MapMarker mapMarker) {
            this.markers.put(mapMarker, true);
            BitmapDescriptor bitmapDescriptor = this.iconBitmapDescriptor;
            if (bitmapDescriptor != null) {
                mapMarker.setIconBitmapDescriptor(bitmapDescriptor, this.bitmap);
            }
        }

        public synchronized void removeMarker(MapMarker mapMarker) {
            this.markers.remove(mapMarker);
        }

        public synchronized boolean hasMarker() {
            return this.markers.isEmpty();
        }

        public synchronized void updateIcon(BitmapDescriptor bitmapDescriptor, Bitmap bitmap) {
            this.iconBitmapDescriptor = bitmapDescriptor;
            this.bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            if (this.markers.isEmpty()) {
                return;
            }
            for (Map.Entry<MapMarker, Boolean> entry : this.markers.entrySet()) {
                if (entry.getKey() != null) {
                    entry.getKey().setIconBitmapDescriptor(bitmapDescriptor, bitmap);
                }
            }
        }
    }

    public AirMapMarkerSharedIcon getSharedIcon(String str) {
        AirMapMarkerSharedIcon airMapMarkerSharedIcon = this.sharedIcons.get(str);
        if (airMapMarkerSharedIcon == null) {
            synchronized (this) {
                airMapMarkerSharedIcon = this.sharedIcons.get(str);
                if (airMapMarkerSharedIcon == null) {
                    airMapMarkerSharedIcon = new AirMapMarkerSharedIcon();
                    this.sharedIcons.put(str, airMapMarkerSharedIcon);
                }
            }
        }
        return airMapMarkerSharedIcon;
    }

    public void removeSharedIconIfEmpty(String str) {
        AirMapMarkerSharedIcon airMapMarkerSharedIcon = this.sharedIcons.get(str);
        if (airMapMarkerSharedIcon == null || airMapMarkerSharedIcon.hasMarker()) {
            return;
        }
        synchronized (this) {
            AirMapMarkerSharedIcon airMapMarkerSharedIcon2 = this.sharedIcons.get(str);
            if (airMapMarkerSharedIcon2 != null && !airMapMarkerSharedIcon2.hasMarker()) {
                this.sharedIcons.remove(str);
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapMarker";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapMarker createViewInstance(ThemedReactContext themedReactContext) {
        return new MapMarker(themedReactContext, this);
    }

    @ReactProp(name = "coordinate")
    public void setCoordinate(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setCoordinate(readableMap);
    }

    @ReactProp(name = "title")
    public void setTitle(MapMarker mapMarker, String str) {
        mapMarker.setTitle(str);
    }

    @ReactProp(name = ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER)
    public void setIdentifier(MapMarker mapMarker, String str) {
        mapMarker.setIdentifier(str);
    }

    @ReactProp(name = "description")
    public void setDescription(MapMarker mapMarker, String str) {
        mapMarker.setSnippet(str);
    }

    @ReactProp(name = "anchor")
    public void setAnchor(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setAnchor((readableMap == null || !readableMap.hasKey(EllipticCurveJsonWebKey.X_MEMBER_NAME)) ? 0.5d : readableMap.getDouble(EllipticCurveJsonWebKey.X_MEMBER_NAME), (readableMap == null || !readableMap.hasKey(EllipticCurveJsonWebKey.Y_MEMBER_NAME)) ? 1.0d : readableMap.getDouble(EllipticCurveJsonWebKey.Y_MEMBER_NAME));
    }

    @ReactProp(name = "calloutAnchor")
    public void setCalloutAnchor(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setCalloutAnchor((readableMap == null || !readableMap.hasKey(EllipticCurveJsonWebKey.X_MEMBER_NAME)) ? 0.5d : readableMap.getDouble(EllipticCurveJsonWebKey.X_MEMBER_NAME), (readableMap == null || !readableMap.hasKey(EllipticCurveJsonWebKey.Y_MEMBER_NAME)) ? 0.0d : readableMap.getDouble(EllipticCurveJsonWebKey.Y_MEMBER_NAME));
    }

    @ReactProp(name = "image")
    public void setImage(MapMarker mapMarker, String str) {
        mapMarker.setImage(str);
    }

    @ReactProp(name = "icon")
    public void setIcon(MapMarker mapMarker, String str) {
        mapMarker.setImage(str);
    }

    @ReactProp(customType = "Color", defaultInt = SupportMenu.CATEGORY_MASK, name = "pinColor")
    public void setPinColor(MapMarker mapMarker, int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        mapMarker.setMarkerHue(fArr[0]);
    }

    @ReactProp(defaultFloat = 0.0f, name = "rotation")
    public void setMarkerRotation(MapMarker mapMarker, float f) {
        mapMarker.setRotation(f);
    }

    @ReactProp(defaultBoolean = false, name = "flat")
    public void setFlat(MapMarker mapMarker, boolean z) {
        mapMarker.setFlat(z);
    }

    @ReactProp(defaultBoolean = false, name = "draggable")
    public void setDraggable(MapMarker mapMarker, boolean z) {
        mapMarker.setDraggable(z);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    @ReactProp(defaultFloat = 0.0f, name = ViewProps.Z_INDEX)
    public void setZIndex(MapMarker mapMarker, float f) {
        super.setZIndex(mapMarker, f);
        mapMarker.setZIndex(Math.round(f));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    @ReactProp(defaultFloat = 1.0f, name = ViewProps.OPACITY)
    public void setOpacity(MapMarker mapMarker, float f) {
        super.setOpacity(mapMarker, f);
        mapMarker.setOpacity(f);
    }

    @ReactProp(defaultBoolean = true, name = "tracksViewChanges")
    public void setTracksViewChanges(MapMarker mapMarker, boolean z) {
        mapMarker.setTracksViewChanges(z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(MapMarker mapMarker, View view, int i) {
        if (view instanceof MapCallout) {
            mapMarker.setCalloutView((MapCallout) view);
        } else {
            super.addView(mapMarker, view, i);
            mapMarker.update(true);
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(MapMarker mapMarker, int i) {
        super.removeViewAt(mapMarker, i);
        mapMarker.update(true);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(MapMarker mapMarker, String str, ReadableArray readableArray) {
        str.hashCode();
        switch (str) {
            case "animateMarkerToCoordinate":
                if (readableArray != null) {
                    ReadableMap map = readableArray.getMap(0);
                    int i = readableArray.getInt(1);
                    mapMarker.animateToCoodinate(new LatLng(map.getDouble(C4349h.a.f5610b), map.getDouble(C4349h.a.f5611c)), Integer.valueOf(i));
                    break;
                }
                break;
            case "redraw":
                mapMarker.updateMarkerIcon();
                break;
            case "hideCallout":
                ((Marker) mapMarker.getFeature()).hideInfoWindow();
                break;
            case "showCallout":
                ((Marker) mapMarker.getFeature()).showInfoWindow();
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onPress", MapBuilder.m1349of("registrationName", "onPress")).put("onCalloutPress", MapBuilder.m1349of("registrationName", "onCalloutPress")).put("onDragStart", MapBuilder.m1349of("registrationName", "onDragStart")).put("onDrag", MapBuilder.m1349of("registrationName", "onDrag")).put("onDragEnd", MapBuilder.m1349of("registrationName", "onDragEnd")).build();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("onSelect", MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1349of("bubbled", "onSelect"))).put("onDeselect", MapBuilder.m1349of("phasedRegistrationNames", MapBuilder.m1349of("bubbled", "onDeselect"))).build();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(MapMarker mapMarker, Object obj) {
        HashMap map = (HashMap) obj;
        mapMarker.update((int) ((Float) map.get("width")).floatValue(), (int) ((Float) map.get("height")).floatValue());
    }
}
