package br.com.dopaminamob.gpsstate;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GPSStateModule extends ReactContextBaseJavaModule {
    private static final String EVENT_STATUS_CHANGE = "OnStatusChange";
    private static final int REQUEST_CODE_AUTHORIZATION = 2308;
    private static final int STATUS_AUTHORIZED = 3;
    private static final int STATUS_AUTHORIZED_ALWAYS = 3;
    private static final int STATUS_AUTHORIZED_WHENINUSE = 4;
    private static final int STATUS_DENIED = 2;
    private static final int STATUS_NOT_DETERMINED = 0;
    private static final int STATUS_RESTRICTED = 1;
    private int currentStatus;
    private int deviceSdkVersion;
    private boolean isListen;
    private PermissionListener listener;
    private LocationManager locationManager;
    private BroadcastReceiver mGpsSwitchStateReceiver;
    private int targetSdkVersion;

    public GPSStateModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.isListen = false;
        this.targetSdkVersion = -1;
        this.deviceSdkVersion = Build.VERSION.SDK_INT;
        this.currentStatus = 0;
        this.mGpsSwitchStateReceiver = null;
        this.listener = new PermissionListener() { // from class: br.com.dopaminamob.gpsstate.GPSStateModule.1
            @Override // com.facebook.react.modules.core.PermissionListener
            public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i != GPSStateModule.REQUEST_CODE_AUTHORIZATION) {
                    return true;
                }
                GPSStateModule gPSStateModule = GPSStateModule.this;
                gPSStateModule.sendEvent(gPSStateModule.getGpsState());
                return true;
            }
        };
        this.locationManager = (LocationManager) reactApplicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION);
        try {
            this.targetSdkVersion = reactApplicationContext.getPackageManager().getPackageInfo(reactApplicationContext.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "GPSState";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("NOT_DETERMINED", 0);
        map.put("RESTRICTED", 1);
        map.put("DENIED", 2);
        map.put("AUTHORIZED", 3);
        map.put("AUTHORIZED_ALWAYS", 3);
        map.put("AUTHORIZED_WHENINUSE", 4);
        return map;
    }

    @ReactMethod
    void startListen() {
        stopListen();
        try {
            this.mGpsSwitchStateReceiver = new GPSProvideChangeReceiver();
            getReactApplicationContext().registerReceiver(this.mGpsSwitchStateReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
            this.isListen = true;
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    void stopListen() {
        this.isListen = false;
        try {
            if (this.mGpsSwitchStateReceiver != null) {
                getReactApplicationContext().unregisterReceiver(this.mGpsSwitchStateReceiver);
                this.mGpsSwitchStateReceiver = null;
            }
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    void getStatus(Promise promise) {
        promise.resolve(Integer.valueOf(getGpsState()));
    }

    @ReactMethod
    void openSettings(boolean z) {
        String str;
        Intent intent = new Intent();
        String packageName = getReactApplicationContext().getPackageName();
        if (z && _NativeIsDeviceMOrAbove()) {
            intent.setData(Uri.fromParts("package", packageName, null));
            str = "android.settings.APPLICATION_DETAILS_SETTINGS";
        } else {
            str = "android.settings.LOCATION_SOURCE_SETTINGS";
        }
        intent.setAction(str);
        getCurrentActivity().startActivityForResult(intent, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ReactMethod
    public void requestAuthorization() {
        if (_NativeIsDeviceMOrAbove()) {
            String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
            Activity currentActivity = getCurrentActivity();
            if (currentActivity instanceof ReactActivity) {
                ((ReactActivity) currentActivity).requestPermissions(strArr, REQUEST_CODE_AUTHORIZATION, this.listener);
            } else if (currentActivity instanceof PermissionAwareActivity) {
                ((PermissionAwareActivity) currentActivity).requestPermissions(strArr, REQUEST_CODE_AUTHORIZATION, this.listener);
            } else {
                ActivityCompat.requestPermissions(currentActivity, strArr, REQUEST_CODE_AUTHORIZATION);
            }
        }
    }

    @ReactMethod
    void isMarshmallowOrAbove(Promise promise) {
        promise.resolve(Boolean.valueOf(_NativeIsDeviceMOrAbove()));
    }

    boolean _NativeIsDeviceMOrAbove() {
        return this.deviceSdkVersion >= 23;
    }

    boolean _NativeIsTargetMOrAbove() {
        return this.targetSdkVersion >= 23;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int getGpsState() {
        /*
            r4 = this;
            boolean r0 = r4.isGpsEnabled()
            boolean r1 = r4._NativeIsDeviceMOrAbove()
            r2 = 3
            r3 = 1
            if (r1 == 0) goto L19
            boolean r1 = r4.isPermissionGranted()
            if (r0 == 0) goto L17
            if (r1 == 0) goto L15
            goto L1b
        L15:
            r2 = 2
            goto L1b
        L17:
            r2 = r3
            goto L1b
        L19:
            if (r0 == 0) goto L17
        L1b:
            r4.currentStatus = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: br.com.dopaminamob.gpsstate.GPSStateModule.getGpsState():int");
    }

    int getPermission() {
        return ActivityCompat.checkSelfPermission(getReactApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
    }

    boolean isPermissionGranted() {
        return getPermission() == 0;
    }

    boolean isGpsEnabled() {
        return this.locationManager.isProviderEnabled("gps");
    }

    void sendEvent(int i) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("status", i);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVENT_STATUS_CHANGE, writableMapCreateMap);
    }

    private final class GPSProvideChangeReceiver extends BroadcastReceiver {
        private GPSProvideChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
                GPSStateModule gPSStateModule = GPSStateModule.this;
                gPSStateModule.sendEvent(gPSStateModule.getGpsState());
            }
        }
    }
}
