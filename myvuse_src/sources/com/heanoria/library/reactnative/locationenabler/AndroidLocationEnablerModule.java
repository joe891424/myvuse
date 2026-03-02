package com.heanoria.library.reactnative.locationenabler;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import io.branch.rnbranch.RNBranchModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidLocationEnablerModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5597d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001%B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0015\u001a\u00020\u0010H\u0002J,\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 H\u0016J\u0012\u0010!\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m5598d2 = {"Lcom/heanoria/library/reactnative/locationenabler/AndroidLocationEnablerModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/facebook/react/bridge/ActivityEventListener;", "Lcom/google/android/gms/tasks/OnCompleteListener;", "Lcom/google/android/gms/location/LocationSettingsResponse;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "context", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "createRequest", "Lcom/google/android/gms/location/LocationRequest;", "timeInterval", "", AndroidLocationEnablerModule.LOCATION_WAIT_FOR_ACCURATE_PARAMS_KEY, "", "getName", "", "isLocationEnabled", "", "isLocationProviderEnabled", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "intent", "Landroid/content/Intent;", "onComplete", "task", "Lcom/google/android/gms/tasks/Task;", "onNewIntent", "promptForEnableLocationIfNeeded", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "Lcom/facebook/react/bridge/ReadableMap;", "Companion", "react-native-android-location-enabler_release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class AndroidLocationEnablerModule extends ReactContextBaseJavaModule implements ActivityEventListener, OnCompleteListener<LocationSettingsResponse> {
    public static final int DEFAULT_INTERVAL_DURATION = 10000;
    public static final boolean DEFAULT_WAIT_FOR_ACCURATE = true;
    public static final String ERR_FAILED_OPEN_DIALOG_CODE = "ERR02";
    public static final String ERR_INTERNAL_ERROR = "ERR03";
    public static final String ERR_SETTINGS_CHANGE_UNAVAILABLE_CODE = "ERR01";
    public static final String ERR_USER_DENIED_CODE = "ERR00";
    public static final String LOCATION_INTERVAL_DURATION_PARAMS_KEY = "interval";
    public static final String LOCATION_WAIT_FOR_ACCURATE_PARAMS_KEY = "waitForAccurate";
    public static final String NAME = "AndroidLocationEnabler";
    public static final int REQUEST_CHECK_SETTINGS = 42;
    public static final String TAG = "LocationEnablerModule";
    private final ReactApplicationContext context;
    private Promise promise;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidLocationEnablerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.context = reactContext;
        reactContext.addActivityEventListener(this);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void isLocationEnabled(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getCurrentActivity() == null) {
            return;
        }
        Object systemService = this.context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        promise.resolve(Boolean.valueOf(LocationManagerCompat.isLocationEnabled((LocationManager) systemService)));
    }

    @ReactMethod
    public final void promptForEnableLocationIfNeeded(ReadableMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (getCurrentActivity() == null) {
            return;
        }
        this.promise = promise;
        int i = (params == null || !params.hasKey(LOCATION_INTERVAL_DURATION_PARAMS_KEY)) ? DEFAULT_INTERVAL_DURATION : params.getInt(LOCATION_INTERVAL_DURATION_PARAMS_KEY);
        boolean z = (params == null || !params.hasKey(LOCATION_WAIT_FOR_ACCURATE_PARAMS_KEY)) ? true : params.getBoolean(LOCATION_WAIT_FOR_ACCURATE_PARAMS_KEY);
        LogInstrumentation.m2730i(TAG, "passed interval " + i);
        LocationSettingsRequest locationSettingsRequestBuild = new LocationSettingsRequest.Builder().addLocationRequest(createRequest(i, z)).setAlwaysShow(true).build();
        Intrinsics.checkNotNullExpressionValue(locationSettingsRequestBuild, "build(...)");
        Task<LocationSettingsResponse> taskCheckLocationSettings = LocationServices.getSettingsClient(this.context).checkLocationSettings(locationSettingsRequestBuild);
        Intrinsics.checkNotNullExpressionValue(taskCheckLocationSettings, "checkLocationSettings(...)");
        taskCheckLocationSettings.addOnCompleteListener(this);
    }

    private final LocationRequest createRequest(long timeInterval, boolean waitForAccurate) {
        LocationRequest.Builder builder = new LocationRequest.Builder(100, timeInterval);
        builder.setWaitForAccurateLocation(waitForAccurate);
        LocationRequest locationRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(locationRequestBuild, "build(...)");
        return locationRequestBuild;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task<LocationSettingsResponse> task) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        LogInstrumentation.m2730i(TAG, "OnComplete");
        try {
            task.getResult(ApiException.class);
            Promise promise = this.promise;
            if (promise != null) {
                promise.resolve("already-enabled");
            }
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            if (statusCode != 6) {
                if (statusCode != 8502) {
                    return;
                }
                Promise promise2 = this.promise;
                if (promise2 != null) {
                    promise2.reject(new AndroidLocationEnablerException(ERR_SETTINGS_CHANGE_UNAVAILABLE_CODE));
                }
                this.promise = null;
                return;
            }
            try {
                Intrinsics.checkNotNull(e, "null cannot be cast to non-null type com.google.android.gms.common.api.ResolvableApiException");
                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                Activity currentActivity = this.context.getCurrentActivity();
                if (currentActivity != null) {
                    resolvableApiException.startResolutionForResult(currentActivity, 42);
                }
            } catch (IntentSender.SendIntentException e2) {
                IntentSender.SendIntentException sendIntentException = e2;
                LogInstrumentation.m2729e(TAG, "Failed to show dialog", sendIntentException);
                Promise promise3 = this.promise;
                if (promise3 != null) {
                    promise3.reject(new AndroidLocationEnablerException(ERR_FAILED_OPEN_DIALOG_CODE, sendIntentException));
                }
                this.promise = null;
            } catch (ClassCastException e3) {
                Promise promise4 = this.promise;
                if (promise4 != null) {
                    promise4.reject(new AndroidLocationEnablerException(ERR_INTERNAL_ERROR, e3));
                }
                this.promise = null;
            }
        }
    }

    private final boolean isLocationProviderEnabled() {
        Activity currentActivity = getCurrentActivity();
        Object systemService = currentActivity != null ? currentActivity.getSystemService(FirebaseAnalytics.Param.LOCATION) : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return ((LocationManager) systemService).isProviderEnabled("gps");
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
        LogInstrumentation.m2730i(TAG, "On activityResult : " + requestCode);
        if (requestCode == 42) {
            if (resultCode == -1 || isLocationProviderEnabled()) {
                LogInstrumentation.m2730i(TAG, "User has enabled the location service");
                Promise promise = this.promise;
                if (promise != null) {
                    promise.resolve(ViewProps.ENABLED);
                }
            } else {
                Promise promise2 = this.promise;
                if (promise2 != null) {
                    promise2.reject(new AndroidLocationEnablerException(ERR_USER_DENIED_CODE));
                }
            }
            this.promise = null;
        }
    }
}
