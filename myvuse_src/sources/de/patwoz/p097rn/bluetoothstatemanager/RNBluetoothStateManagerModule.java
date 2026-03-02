package de.patwoz.p097rn.bluetoothstatemanager;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import de.patwoz.p097rn.bluetoothstatemanager.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RNBluetoothStateManagerModule extends ReactContextBaseJavaModule {
    private static final String EVENT_BLUETOOTH_STATE_CHANGE = "EVENT_BLUETOOTH_STATE_CHANGE";
    private static final int REQUEST_ENABLE_BT = 795;
    private final Intent INTENT_OPEN_BLUETOOTH_SETTINGS;
    private final Intent INTENT_REQUEST_ENABLE_BLUETOOTH;
    private final BroadcastReceiver mReceiver;
    private final ReactApplicationContext reactContext;
    private final ActivityEventListener requestToEnableListener;
    private Promise requestToEnablePromise;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNBluetoothStateManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.INTENT_OPEN_BLUETOOTH_SETTINGS = new Intent("android.settings.BLUETOOTH_SETTINGS");
        this.INTENT_REQUEST_ENABLE_BLUETOOTH = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        this.mReceiver = new BroadcastReceiver() { // from class: de.patwoz.rn.bluetoothstatemanager.RNBluetoothStateManagerModule.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action == null || !action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    return;
                }
                RNBluetoothStateManagerModule.this.sendEvent(RNBluetoothStateManagerModule.EVENT_BLUETOOTH_STATE_CHANGE, BridgeUtils.fromBluetoothState(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)));
            }
        };
        this.requestToEnableListener = new BaseActivityEventListener() { // from class: de.patwoz.rn.bluetoothstatemanager.RNBluetoothStateManagerModule.2
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                if (i != RNBluetoothStateManagerModule.REQUEST_ENABLE_BT) {
                    return;
                }
                if (RNBluetoothStateManagerModule.this.requestToEnablePromise == null) {
                    LogInstrumentation.m2734w("RNBluetoothStateManager", "onActivityResult() :: Result code:" + i2 + " ::'requestToEnablePromise' should be defined!");
                } else if (i2 == 0) {
                    RNBluetoothStateManagerModule.this.requestToEnablePromise.reject("CANCELED", "The user canceled the action.");
                } else if (i2 == -1) {
                    RNBluetoothStateManagerModule.this.requestToEnablePromise.resolve(true);
                } else {
                    LogInstrumentation.m2734w("RNBluetoothStateManager", "onActivityResult() :: Result code:" + i2 + " :: Unhandled result code");
                }
                RNBluetoothStateManagerModule.this.removeRequestToEnableListener();
            }
        };
        this.reactContext = reactApplicationContext;
        if (BluetoothUtils.isBluetoothSupported()) {
            startListenForBluetoothStateChange();
        }
    }

    private void destroy() {
        if (BluetoothUtils.isBluetoothSupported()) {
            stopListenForBluetoothStateChange();
        }
        removeRequestToEnableListener();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNBluetoothStateManager";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put(EVENT_BLUETOOTH_STATE_CHANGE, EVENT_BLUETOOTH_STATE_CHANGE);
        return map;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        destroy();
    }

    @ReactMethod
    public void getState(Promise promise) {
        if (handleIfBluetoothNotSupported(promise, false)) {
            promise.resolve(Constants.BluetoothState.UNSUPPORTED);
        } else {
            promise.resolve(BridgeUtils.fromBluetoothState(BluetoothAdapter.getDefaultAdapter().getState()));
        }
    }

    private void setBluetooth(boolean z) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (z) {
            defaultAdapter.enable();
        } else {
            defaultAdapter.disable();
        }
    }

    @ReactMethod
    public void enable(Promise promise) {
        Activity activityHandleCurrentActivity;
        if (handleIfBluetoothNotSupported(promise) || (activityHandleCurrentActivity = handleCurrentActivity(promise)) == null) {
            return;
        }
        if (BluetoothUtils.hasBluetoothAdminPermission(activityHandleCurrentActivity)) {
            setBluetooth(true);
            promise.resolve(null);
        } else {
            promise.reject("UNAUTHORIZED", "You are not authorized to do this.");
        }
    }

    @ReactMethod
    public void disable(Promise promise) {
        Activity activityHandleCurrentActivity;
        if (handleIfBluetoothNotSupported(promise) || (activityHandleCurrentActivity = handleCurrentActivity(promise)) == null) {
            return;
        }
        if (BluetoothUtils.hasBluetoothAdminPermission(activityHandleCurrentActivity)) {
            setBluetooth(false);
            promise.resolve(null);
        } else {
            promise.reject("UNAUTHORIZED", "You are not authorized to do this.");
        }
    }

    @ReactMethod
    public void openSettings(Promise promise) {
        Activity activityHandleCurrentActivity;
        if (handleIfBluetoothNotSupported(promise) || (activityHandleCurrentActivity = handleCurrentActivity(promise)) == null) {
            return;
        }
        activityHandleCurrentActivity.startActivity(this.INTENT_OPEN_BLUETOOTH_SETTINGS);
        promise.resolve(null);
    }

    private void startListenForBluetoothStateChange() {
        this.reactContext.registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    private void stopListenForBluetoothStateChange() {
        this.reactContext.unregisterReceiver(this.mReceiver);
    }

    private void addRequestToEnableListener(Promise promise) {
        this.requestToEnablePromise = promise;
        this.reactContext.addActivityEventListener(this.requestToEnableListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRequestToEnableListener() {
        this.reactContext.removeActivityEventListener(this.requestToEnableListener);
        this.requestToEnablePromise = null;
    }

    @ReactMethod
    public void requestToEnable(Promise promise) {
        Activity activityHandleCurrentActivity = handleCurrentActivity(promise);
        if (activityHandleCurrentActivity == null) {
            return;
        }
        addRequestToEnableListener(promise);
        activityHandleCurrentActivity.startActivityForResult(this.INTENT_REQUEST_ENABLE_BLUETOOTH, REQUEST_ENABLE_BT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    private boolean handleIfBluetoothNotSupported(Promise promise, boolean z) {
        if (BluetoothUtils.isBluetoothSupported()) {
            return false;
        }
        if (!z) {
            return true;
        }
        promise.reject("BLUETOOTH_NOT_SUPPORTED", "This device doesn't support Bluetooth");
        return true;
    }

    private boolean handleIfBluetoothNotSupported(Promise promise) {
        return handleIfBluetoothNotSupported(promise, true);
    }

    private Activity handleCurrentActivity(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject("INTERNAL_ERROR", "There is no activity");
        }
        return currentActivity;
    }
}
