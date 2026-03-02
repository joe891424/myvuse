package com.rnmaps.maps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.salesforce.marketingcloud.storage.p047db.C4349h;
import com.surajit.rnrg.RadialGradientManager;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes6.dex */
@ReactModule(name = MapModule.NAME)
public class MapModule extends ReactContextBaseJavaModule {
    public static final String NAME = "AirMapModule";
    private static final String SNAPSHOT_FORMAT_JPG = "jpg";
    private static final String SNAPSHOT_FORMAT_PNG = "png";
    private static final String SNAPSHOT_RESULT_BASE64 = "base64";
    private static final String SNAPSHOT_RESULT_FILE = "file";

    public MapModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("legalNotice", "This license information is displayed in Settings > Google > Open Source on any device running Google Play services.");
        return map;
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    @ReactMethod
    public void takeSnapshot(final int i, ReadableMap readableMap, final Promise promise) {
        Bitmap.CompressFormat compressFormat;
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final String string = readableMap.hasKey("format") ? readableMap.getString("format") : SNAPSHOT_FORMAT_PNG;
        if (string.equals(SNAPSHOT_FORMAT_PNG)) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = string.equals(SNAPSHOT_FORMAT_JPG) ? Bitmap.CompressFormat.JPEG : null;
        }
        final Bitmap.CompressFormat compressFormat2 = compressFormat;
        final double d = readableMap.hasKey("quality") ? readableMap.getDouble("quality") : 1.0d;
        DisplayMetrics displayMetrics = reactApplicationContext.getResources().getDisplayMetrics();
        final Integer numValueOf = Integer.valueOf(readableMap.hasKey("width") ? (int) (((double) displayMetrics.density) * readableMap.getDouble("width")) : 0);
        final Integer numValueOf2 = Integer.valueOf(readableMap.hasKey("height") ? (int) (((double) displayMetrics.density) * readableMap.getDouble("height")) : 0);
        final String string2 = readableMap.hasKey("result") ? readableMap.getString("result") : "file";
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.rnmaps.maps.MapModule.1
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                MapView mapView = (MapView) nativeViewHierarchyManager.resolveView(i);
                if (mapView == null) {
                    promise.reject("AirMapView not found");
                } else if (mapView.map == null) {
                    promise.reject("AirMapView.map is not valid");
                } else {
                    mapView.map.snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.rnmaps.maps.MapModule.1.1
                        @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                        public void onSnapshotReady(Bitmap bitmap) {
                            if (bitmap == null) {
                                promise.reject("Failed to generate bitmap, snapshot = null");
                                return;
                            }
                            if (numValueOf.intValue() != 0 && numValueOf2.intValue() != 0 && (numValueOf.intValue() != bitmap.getWidth() || numValueOf2.intValue() != bitmap.getHeight())) {
                                bitmap = Bitmap.createScaledBitmap(bitmap, numValueOf.intValue(), numValueOf2.intValue(), true);
                            }
                            if (string2.equals("file")) {
                                try {
                                    File fileCreateTempFile = File.createTempFile("AirMapSnapshot", "." + string, reactApplicationContext.getCacheDir());
                                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                                    bitmap.compress(compressFormat2, (int) (d * 100.0d), fileOutputStream);
                                    MapModule.closeQuietly(fileOutputStream);
                                    promise.resolve(Uri.fromFile(fileCreateTempFile).toString());
                                    return;
                                } catch (Exception e) {
                                    promise.reject(e);
                                    return;
                                }
                            }
                            if (string2.equals("base64")) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                bitmap.compress(compressFormat2, (int) (d * 100.0d), byteArrayOutputStream);
                                MapModule.closeQuietly(byteArrayOutputStream);
                                promise.resolve(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                            }
                        }
                    });
                }
            }
        });
    }

    @ReactMethod
    public void getCamera(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.rnmaps.maps.MapModule.2
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                MapView mapView = (MapView) nativeViewHierarchyManager.resolveView(i);
                if (mapView == null) {
                    promise.reject("AirMapView not found");
                    return;
                }
                if (mapView.map == null) {
                    promise.reject("AirMapView.map is not valid");
                    return;
                }
                CameraPosition cameraPosition = mapView.map.getCameraPosition();
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble(C4349h.a.f5610b, cameraPosition.target.latitude);
                writableNativeMap.putDouble(C4349h.a.f5611c, cameraPosition.target.longitude);
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putMap(RadialGradientManager.PROP_CENTER, writableNativeMap);
                writableNativeMap2.putDouble("heading", cameraPosition.bearing);
                writableNativeMap2.putDouble("zoom", cameraPosition.zoom);
                writableNativeMap2.putDouble("pitch", cameraPosition.tilt);
                promise.resolve(writableNativeMap2);
            }
        });
    }

    @ReactMethod
    public void getAddressFromCoordinates(final int i, final ReadableMap readableMap, final Promise promise) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.rnmaps.maps.MapModule.3
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                MapView mapView = (MapView) nativeViewHierarchyManager.resolveView(i);
                if (mapView == null) {
                    promise.reject("AirMapView not found");
                    return;
                }
                if (mapView.map == null) {
                    promise.reject("AirMapView.map is not valid");
                    return;
                }
                ReadableMap readableMap2 = readableMap;
                if (readableMap2 == null || !readableMap2.hasKey(C4349h.a.f5610b) || !readableMap.hasKey(C4349h.a.f5611c)) {
                    promise.reject("Invalid coordinate format");
                    return;
                }
                try {
                    List<Address> fromLocation = new Geocoder(reactApplicationContext).getFromLocation(readableMap.getDouble(C4349h.a.f5610b), readableMap.getDouble(C4349h.a.f5611c), 1);
                    if (fromLocation.isEmpty()) {
                        promise.reject("Can not get address location");
                        return;
                    }
                    Address address = fromLocation.get(0);
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putString("name", address.getFeatureName());
                    writableNativeMap.putString("locality", address.getLocality());
                    writableNativeMap.putString("thoroughfare", address.getThoroughfare());
                    writableNativeMap.putString("subThoroughfare", address.getSubThoroughfare());
                    writableNativeMap.putString("subLocality", address.getSubLocality());
                    writableNativeMap.putString("administrativeArea", address.getAdminArea());
                    writableNativeMap.putString("subAdministrativeArea", address.getSubAdminArea());
                    writableNativeMap.putString(HintConstants.AUTOFILL_HINT_POSTAL_CODE, address.getPostalCode());
                    writableNativeMap.putString(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, address.getCountryCode());
                    writableNativeMap.putString("country", address.getCountryName());
                    promise.resolve(writableNativeMap);
                } catch (IOException unused) {
                    promise.reject("Can not get address location");
                }
            }
        });
    }

    @ReactMethod
    public void pointForCoordinate(final int i, ReadableMap readableMap, final Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final double d = reactApplicationContext.getResources().getDisplayMetrics().density;
        final LatLng latLng = new LatLng(readableMap.hasKey(C4349h.a.f5610b) ? readableMap.getDouble(C4349h.a.f5610b) : 0.0d, readableMap.hasKey(C4349h.a.f5611c) ? readableMap.getDouble(C4349h.a.f5611c) : 0.0d);
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.rnmaps.maps.MapModule.4
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                MapView mapView = (MapView) nativeViewHierarchyManager.resolveView(i);
                if (mapView == null) {
                    promise.reject("AirMapView not found");
                    return;
                }
                if (mapView.map == null) {
                    promise.reject("AirMapView.map is not valid");
                    return;
                }
                Point screenLocation = mapView.map.getProjection().toScreenLocation(latLng);
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble(EllipticCurveJsonWebKey.X_MEMBER_NAME, ((double) screenLocation.x) / d);
                writableNativeMap.putDouble(EllipticCurveJsonWebKey.Y_MEMBER_NAME, ((double) screenLocation.y) / d);
                promise.resolve(writableNativeMap);
            }
        });
    }

    @ReactMethod
    public void coordinateForPoint(final int i, ReadableMap readableMap, final Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        double d = reactApplicationContext.getResources().getDisplayMetrics().density;
        final Point point = new Point(readableMap.hasKey(EllipticCurveJsonWebKey.X_MEMBER_NAME) ? (int) (readableMap.getDouble(EllipticCurveJsonWebKey.X_MEMBER_NAME) * d) : 0, readableMap.hasKey(EllipticCurveJsonWebKey.Y_MEMBER_NAME) ? (int) (readableMap.getDouble(EllipticCurveJsonWebKey.Y_MEMBER_NAME) * d) : 0);
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.rnmaps.maps.MapModule.5
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                MapView mapView = (MapView) nativeViewHierarchyManager.resolveView(i);
                if (mapView == null) {
                    promise.reject("AirMapView not found");
                    return;
                }
                if (mapView.map == null) {
                    promise.reject("AirMapView.map is not valid");
                    return;
                }
                LatLng latLngFromScreenLocation = mapView.map.getProjection().fromScreenLocation(point);
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble(C4349h.a.f5610b, latLngFromScreenLocation.latitude);
                writableNativeMap.putDouble(C4349h.a.f5611c, latLngFromScreenLocation.longitude);
                promise.resolve(writableNativeMap);
            }
        });
    }

    @ReactMethod
    public void getMapBoundaries(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() { // from class: com.rnmaps.maps.MapModule.6
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.facebook.react.uimanager.UIBlock
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                MapView mapView = (MapView) nativeViewHierarchyManager.resolveView(i);
                if (mapView == null) {
                    promise.reject("AirMapView not found");
                    return;
                }
                if (mapView.map == null) {
                    promise.reject("AirMapView.map is not valid");
                    return;
                }
                double[][] mapBoundaries = mapView.getMapBoundaries();
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                writableNativeMap2.putDouble(C4349h.a.f5611c, mapBoundaries[0][0]);
                writableNativeMap2.putDouble(C4349h.a.f5610b, mapBoundaries[0][1]);
                writableNativeMap3.putDouble(C4349h.a.f5611c, mapBoundaries[1][0]);
                writableNativeMap3.putDouble(C4349h.a.f5610b, mapBoundaries[1][1]);
                writableNativeMap.putMap("northEast", writableNativeMap2);
                writableNativeMap.putMap("southWest", writableNativeMap3);
                promise.resolve(writableNativeMap);
            }
        });
    }
}
