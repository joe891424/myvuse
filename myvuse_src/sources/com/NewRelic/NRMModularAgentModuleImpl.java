package com.NewRelic;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.newrelic.agent.android.ApplicationFramework;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.NewRelic;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.NetworkFailure;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes.dex */
public class NRMModularAgentModuleImpl {
    public static final String NAME = "NRMModularAgent";
    private final ReactApplicationContext reactContext;

    public NRMModularAgentModuleImpl(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
    }

    @Nonnull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void startAgent(String str, String str2, String str3, ReadableMap readableMap) {
        String str4;
        String str5;
        String str6;
        if (str != null) {
            LogInstrumentation.m2734w("NRMA", "calling start agent for RN bridge is deprecated. The agent automatically starts on creation.");
            Map<String, Object> mapMapToAttributes = mapToAttributes(readableMap);
            if (((Boolean) mapMapToAttributes.get("analyticsEventEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.AnalyticsEvents);
            } else {
                NewRelic.disableFeature(FeatureFlag.AnalyticsEvents);
            }
            if (((Boolean) mapMapToAttributes.get("networkRequestEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.NetworkRequests);
            } else {
                NewRelic.disableFeature(FeatureFlag.NetworkRequests);
            }
            if (((Boolean) mapMapToAttributes.get("networkErrorRequestEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.NetworkErrorRequests);
            } else {
                NewRelic.disableFeature(FeatureFlag.NetworkErrorRequests);
            }
            if (((Boolean) mapMapToAttributes.get("httpResponseBodyCaptureEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.HttpResponseBodyCapture);
            } else {
                NewRelic.disableFeature(FeatureFlag.HttpResponseBodyCapture);
            }
            if (((Boolean) mapMapToAttributes.get("crashReportingEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.CrashReporting);
            } else {
                NewRelic.disableFeature(FeatureFlag.CrashReporting);
            }
            if (((Boolean) mapMapToAttributes.get("interactionTracingEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.InteractionTracing);
            } else {
                NewRelic.disableFeature(FeatureFlag.InteractionTracing);
            }
            if (((Boolean) mapMapToAttributes.get("fedRampEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.FedRampEnabled);
            } else {
                NewRelic.disableFeature(FeatureFlag.FedRampEnabled);
            }
            if (((Boolean) mapMapToAttributes.get("offlineStorageEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.OfflineStorage);
            } else {
                NewRelic.disableFeature(FeatureFlag.OfflineStorage);
            }
            if (((Boolean) mapMapToAttributes.get("nativeCrashReportingEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.NativeReporting);
            } else {
                NewRelic.disableFeature(FeatureFlag.NativeReporting);
            }
            if (((Boolean) mapMapToAttributes.get("backgroundReportingEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.BackgroundReporting);
            } else {
                NewRelic.disableFeature(FeatureFlag.BackgroundReporting);
            }
            if (((Boolean) mapMapToAttributes.get("distributedTracingEnabled")).booleanValue()) {
                NewRelic.enableFeature(FeatureFlag.DistributedTracing);
            } else {
                NewRelic.disableFeature(FeatureFlag.DistributedTracing);
            }
            HashMap map = new HashMap();
            boolean z = true;
            map.put(RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR, 1);
            map.put("WARNING", 2);
            int iIntValue = 3;
            map.put("INFO", 3);
            map.put("VERBOSE", 4);
            map.put("AUDIT", 6);
            if (mapMapToAttributes.get("logLevel") != null && (str6 = (String) mapMapToAttributes.get("logLevel")) != null) {
                String upperCase = str6.toUpperCase();
                if (map.containsKey(upperCase)) {
                    iIntValue = ((Integer) map.get(upperCase)).intValue();
                }
            }
            boolean z2 = mapMapToAttributes.get("collectorAddress") == null || ((String) mapMapToAttributes.get("collectorAddress")).isEmpty();
            if (mapMapToAttributes.get("crashCollectorAddress") != null && !((String) mapMapToAttributes.get("crashCollectorAddress")).isEmpty()) {
                z = false;
            }
            if (z2 && z) {
                NewRelic.withApplicationToken(str).withApplicationFramework(ApplicationFramework.ReactNative, str2).withLoggingEnabled(((Boolean) mapMapToAttributes.get("loggingEnabled")).booleanValue()).withLogLevel(iIntValue).start(this.reactContext);
            } else {
                if (!z2) {
                    str4 = (String) mapMapToAttributes.get("collectorAddress");
                } else {
                    str4 = "mobile-collector.newrelic.com";
                }
                if (!z) {
                    str5 = (String) mapMapToAttributes.get("crashCollectorAddress");
                } else {
                    str5 = "mobile-crash.newrelic.com";
                }
                NewRelic.withApplicationToken(str).withApplicationFramework(ApplicationFramework.ReactNative, str2).withLoggingEnabled(((Boolean) mapMapToAttributes.get("loggingEnabled")).booleanValue()).withLogLevel(iIntValue).usingCollectorAddress(str4).usingCrashCollectorAddress(str5).start(this.reactContext);
            }
            NewRelic.setAttribute("React Native Version", str3);
            StatsEngine.get().inc("Supportability/Mobile/Android/ReactNative/Agent/" + str2);
            StatsEngine.get().inc("Supportability/Mobile/Android/ReactNative/Framework/" + str3);
        }
    }

    Map<String, Object> mapToAttributes(ReadableMap readableMap) {
        HashMap map = new HashMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            switch (C13351.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(strNextKey).ordinal()]) {
                case 1:
                    LogInstrumentation.m2734w("NRMA", "TODO!! Skipping NULL attribute in react-native shim recordCustomEvent ");
                    break;
                case 2:
                    map.put(strNextKey, Boolean.valueOf(readableMap.getBoolean(strNextKey)));
                    break;
                case 3:
                    map.put(strNextKey, Double.valueOf(readableMap.getDouble(strNextKey)));
                    break;
                case 4:
                    map.put(strNextKey, readableMap.getString(strNextKey));
                    break;
                case 5:
                    LogInstrumentation.m2734w("NRMA", "TODO!! Skipping MAP attribute in react-native shim recordCustomEvent ");
                    break;
                case 6:
                    LogInstrumentation.m2734w("NRMA", "TODO!! Skipping ARRAY attribute in react-native shim recordCustomEvent ");
                    break;
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: com.NewRelic.NRMModularAgentModuleImpl$1 */
    static /* synthetic */ class C13351 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    List<String> mapToList(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            if (readableArray.getType(i) == ReadableType.String) {
                arrayList.add(readableArray.getString(i));
            }
        }
        return arrayList;
    }

    @ReactMethod
    public void isAgentStarted(Promise promise) {
        promise.resolve(Boolean.valueOf(NewRelic.isStarted()));
    }

    @ReactMethod
    public void setJSAppVersion(String str) {
        NewRelic.setAttribute("JSBundleId", str);
    }

    @ReactMethod
    public void analyticsEventEnabled(boolean z) {
        if (z) {
            NewRelic.enableFeature(FeatureFlag.AnalyticsEvents);
        } else {
            NewRelic.disableFeature(FeatureFlag.AnalyticsEvents);
        }
    }

    @ReactMethod
    public void networkRequestEnabled(boolean z) {
        if (z) {
            NewRelic.enableFeature(FeatureFlag.NetworkRequests);
        } else {
            NewRelic.disableFeature(FeatureFlag.NetworkRequests);
        }
    }

    @ReactMethod
    public void networkErrorRequestEnabled(boolean z) {
        if (z) {
            NewRelic.enableFeature(FeatureFlag.NetworkErrorRequests);
        } else {
            NewRelic.disableFeature(FeatureFlag.NetworkErrorRequests);
        }
    }

    @ReactMethod
    public void httpResponseBodyCaptureEnabled(boolean z) {
        if (z) {
            NewRelic.enableFeature(FeatureFlag.HttpResponseBodyCapture);
        } else {
            NewRelic.disableFeature(FeatureFlag.HttpResponseBodyCapture);
        }
    }

    @ReactMethod
    public void recordCustomEvent(String str, String str2, ReadableMap readableMap) {
        NewRelic.recordCustomEvent(str, str2, mapToAttributes(readableMap));
    }

    @ReactMethod
    public void addHTTPHeadersTrackingFor(ReadableArray readableArray) {
        NewRelic.addHTTPHeadersTrackingFor(mapToList(readableArray));
    }

    @ReactMethod
    public void crashNow(String str) {
        if (str.isEmpty()) {
            NewRelic.crashNow();
        } else {
            NewRelic.crashNow(str);
        }
    }

    @ReactMethod
    public void currentSessionId(Promise promise) {
        try {
            promise.resolve(NewRelic.currentSessionId());
        } catch (Exception e) {
            e.printStackTrace();
            NewRelic.recordHandledException(e);
            promise.reject(e);
        }
    }

    @ReactMethod
    public void noticeNetworkFailure(String str, String str2, double d, double d2, String str3) {
        HashMap map = new HashMap();
        map.put("Unknown", NetworkFailure.Unknown);
        map.put("BadURL", NetworkFailure.BadURL);
        map.put("TimedOut", NetworkFailure.TimedOut);
        map.put("CannotConnectToHost", NetworkFailure.CannotConnectToHost);
        map.put("DNSLookupFailed", NetworkFailure.DNSLookupFailed);
        map.put("BadServerResponse", NetworkFailure.BadServerResponse);
        map.put("SecureConnectionFailed", NetworkFailure.SecureConnectionFailed);
        NewRelic.noticeNetworkFailure(str, str2, (long) d, (long) d2, (NetworkFailure) map.get(str3));
    }

    @ReactMethod
    public void recordMetric(String str, String str2, double d, String str3, String str4) {
        HashMap map = new HashMap();
        map.put("PERCENT", MetricUnit.PERCENT);
        map.put("BYTES", MetricUnit.BYTES);
        map.put("SECONDS", MetricUnit.SECONDS);
        map.put("BYTES_PER_SECOND", MetricUnit.BYTES_PER_SECOND);
        map.put("OPERATIONS", MetricUnit.OPERATIONS);
        if (d < 0.0d) {
            NewRelic.recordMetric(str, str2);
        } else if (str3 == null || str4 == null) {
            NewRelic.recordMetric(str, str2, d);
        } else {
            NewRelic.recordMetric(str, str2, 1, d, d, (MetricUnit) map.get(str3), (MetricUnit) map.get(str4));
        }
    }

    @ReactMethod
    public void removeAllAttributes() {
        NewRelic.removeAllAttributes();
    }

    @ReactMethod
    public void setMaxEventBufferTime(int i) {
        NewRelic.setMaxEventBufferTime(i);
    }

    @ReactMethod
    public void setMaxOfflineStorageSize(int i) {
        NewRelic.setMaxOfflineStorageSize(i);
    }

    @ReactMethod
    public void setMaxEventPoolSize(int i) {
        NewRelic.setMaxEventPoolSize(i);
    }

    @ReactMethod
    public void setStringAttribute(String str, String str2) {
        NewRelic.setAttribute(str, str2);
    }

    @ReactMethod
    public void setBoolAttribute(String str, boolean z) {
        NewRelic.setAttribute(str, z);
    }

    @ReactMethod
    public void setNumberAttribute(String str, Double d) {
        if (d.doubleValue() == d.longValue()) {
            NewRelic.setAttribute(str, d.longValue());
        } else {
            NewRelic.setAttribute(str, d.doubleValue());
        }
    }

    @ReactMethod
    public void removeAttribute(String str) {
        NewRelic.removeAttribute(str);
    }

    @ReactMethod
    public void incrementAttribute(String str, Double d) {
        if (d.doubleValue() == d.longValue()) {
            NewRelic.incrementAttribute(str, d.longValue());
        } else {
            NewRelic.incrementAttribute(str, d.doubleValue());
        }
    }

    @ReactMethod
    public void setUserId(String str) {
        NewRelic.setUserId(str);
    }

    @ReactMethod
    public void recordBreadcrumb(String str, ReadableMap readableMap) {
        NewRelic.recordBreadcrumb(str, mapToAttributes(readableMap));
    }

    @ReactMethod
    public void startInteraction(String str, Promise promise) {
        try {
            promise.resolve(NewRelic.startInteraction(str));
        } catch (Exception e) {
            e.printStackTrace();
            NewRelic.recordHandledException(e);
            promise.reject(e);
        }
    }

    @ReactMethod
    public void endInteraction(String str) {
        NewRelic.endInteraction(str);
    }

    @ReactMethod
    public void setInteractionName(String str) {
        NewRelic.setInteractionName(str);
    }

    @ReactMethod
    public void nativeLog(String str, String str2) {
        NewRelic.setInteractionName("Console Events");
        HashMap map = new HashMap();
        map.put("Name", str);
        map.put("Message", str2);
        NewRelic.recordBreadcrumb("Console Logs", map);
        NewRelic.recordCustomEvent("Console Events", "", map);
    }

    @ReactMethod
    public void noticeHttpTransaction(String str, String str2, int i, int i2, int i3, int i4, int i5, String str3) {
        NewRelic.noticeHttpTransaction(str, str2, i, i2, i3, i4, i5, str3);
    }

    @ReactMethod
    public void logAttributes(ReadableMap readableMap) {
        NewRelic.logAttributes(mapToAttributes(readableMap));
    }

    @ReactMethod
    public void recordStack(String str, String str2, String str3, boolean z, String str4) {
        try {
            HashMap map = new HashMap();
            map.put("Name", str);
            map.put("Message", str2);
            map.put("isFatal", Boolean.valueOf(z));
            map.put("jsAppVersion", str4);
            if (str3 != null) {
                if (str3.length() > 4095) {
                    str3 = str3.substring(0, 4094);
                }
                map.put("errorStack", str3);
            }
            NewRelic.recordBreadcrumb("JS Errors", map);
            NewRelic.recordCustomEvent("JS Errors", "", map);
            StatsEngine.get().inc("Supportability/Mobile/ReactNative/JSError");
        } catch (IllegalArgumentException e) {
            LogInstrumentation.m2734w("NRMA", e.getMessage());
        }
    }

    @ReactMethod
    public void shutdown() {
        NewRelic.shutdown();
    }

    @ReactMethod
    public void recordHandledException(ReadableMap readableMap) {
        if (readableMap == null) {
            LogInstrumentation.m2734w("NRMA", "Null dictionary given to recordHandledException");
        }
        HashMap<String, Object> hashMap = readableMap.toHashMap();
        hashMap.remove("app");
        hashMap.remove("platform");
        if (!hashMap.containsKey("stackFrames")) {
            LogInstrumentation.m2734w("NRMA", "No stack frames in recordHandledException");
            return;
        }
        NewRelicReactNativeException newRelicReactNativeException = new NewRelicReactNativeException((String) hashMap.get("message"), generateStackTraceElements((Map) hashMap.get("stackFrames")));
        hashMap.remove("stackFrames");
        NewRelic.recordHandledException((Exception) newRelicReactNativeException, (Map<String, Object>) hashMap);
    }

    private StackTraceElement[] generateStackTraceElements(Map<String, Object> map) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < map.size(); i++) {
                Map map2 = (Map) map.get(Integer.toString(i));
                arrayList.add(new StackTraceElement(" ", (String) map2.getOrDefault("methodName", ""), (String) map2.getOrDefault("file", ""), map2.get("lineNumber") != null ? ((Double) Objects.requireNonNull(map2.get("lineNumber"))).intValue() : 1));
            }
            return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]);
        } catch (Exception e) {
            NewRelic.recordHandledException(e);
            return null;
        }
    }
}
