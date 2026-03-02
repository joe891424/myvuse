package p105os.juanamd.backgroundtimer;

import android.os.Handler;
import android.os.PowerManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class BackgroundTimerAndroidModule extends ReactContextBaseJavaModule {
    private static final String TAG = "RNBackgroundTimerAndroid";
    private static final String TIMER_EVENT = "RNBackgroundTimerAndroid.timer";
    private Handler handler;
    private Map<Integer, TimerData> timerDataMap;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public BackgroundTimerAndroidModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.timerDataMap = new HashMap();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void setTimer(int i, double d, boolean z, Promise promise) {
        try {
            setTimer(i, (long) d, z);
            promise.resolve(null);
            LogInstrumentation.m2726d(TAG, "setTimer for id: " + String.valueOf(i) + " for " + String.valueOf(d) + " ms. Repeats: " + String.valueOf(z));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    private void setTimer(int i, long j, boolean z) {
        if (this.handler == null) {
            this.handler = new Handler();
        }
        Runnable intervalRunnable = z ? getIntervalRunnable(i, j) : getTimeoutRunnable(i);
        this.handler.postDelayed(intervalRunnable, j);
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getReactApplicationContext().getSystemService("power")).newWakeLock(1, TAG);
        if (z) {
            wakeLockNewWakeLock.acquire();
        } else {
            wakeLockNewWakeLock.acquire(j);
        }
        this.timerDataMap.put(Integer.valueOf(i), new TimerData(i, intervalRunnable, wakeLockNewWakeLock));
    }

    private Runnable getTimeoutRunnable(final int i) {
        return new Runnable() { // from class: os.juanamd.backgroundtimer.BackgroundTimerAndroidModule.1
            @Override // java.lang.Runnable
            public void run() {
                BackgroundTimerAndroidModule.this.timerDataMap.remove(Integer.valueOf(i));
                BackgroundTimerAndroidModule.this.sendTimerEventToJS(i);
            }
        };
    }

    private Runnable getIntervalRunnable(final int i, final long j) {
        return new Runnable() { // from class: os.juanamd.backgroundtimer.BackgroundTimerAndroidModule.2
            @Override // java.lang.Runnable
            public void run() {
                BackgroundTimerAndroidModule.this.sendTimerEventToJS(i);
                BackgroundTimerAndroidModule.this.handler.postDelayed(this, j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTimerEventToJS(int i) {
        if (getReactApplicationContext().hasActiveCatalystInstance()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(TIMER_EVENT, Integer.valueOf(i));
            LogInstrumentation.m2726d(TAG, "send timer event for id: " + String.valueOf(i));
        } else {
            LogInstrumentation.m2726d(TAG, "could not send event as there is no active react instance. Event id: " + String.valueOf(i));
        }
    }

    @ReactMethod
    public void clearTimer(int i, Promise promise) {
        try {
            clearTimer(i);
            promise.resolve(null);
            LogInstrumentation.m2726d(TAG, "clearTimer for id: " + String.valueOf(i));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    private void clearTimer(int i) {
        TimerData timerData = this.timerDataMap.get(Integer.valueOf(i));
        if (timerData != null) {
            if (timerData.wakeLock.isHeld()) {
                timerData.wakeLock.release();
            }
            this.handler.removeCallbacks(timerData.runnable);
            this.timerDataMap.remove(Integer.valueOf(i));
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        for (TimerData timerData : this.timerDataMap.values()) {
            if (timerData != null) {
                try {
                    if (timerData.wakeLock.isHeld()) {
                        timerData.wakeLock.release();
                    }
                } catch (Exception e) {
                    LogInstrumentation.m2729e(TAG, "Could not release wakeLock of id: " + timerData.f8365id, e);
                }
            }
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("TIMER_EVENT", TIMER_EVENT);
        return map;
    }

    private class TimerData {

        /* JADX INFO: renamed from: id */
        public int f8365id;
        public Runnable runnable;
        public PowerManager.WakeLock wakeLock;

        public TimerData(int i, Runnable runnable, PowerManager.WakeLock wakeLock) {
            this.f8365id = i;
            this.runnable = runnable;
            this.wakeLock = wakeLock;
        }
    }
}
