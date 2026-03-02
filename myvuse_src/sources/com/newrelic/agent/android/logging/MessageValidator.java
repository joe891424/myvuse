package com.newrelic.agent.android.logging;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface MessageValidator {
    public static final String[] ANONYMIZATION_TARGETS = {"http?//{.*}/{.*}", "{.*}\\@{.*}\\.{.*}"};
    public static final String INVALID_KEYSET = "{}\\[\\]]";
    public static final int MAX_MESSAGE_LEN = 32768;

    default String validate(String str) {
        if (str == null || str.isEmpty()) {
            return LogReporting.INVALID_MSG;
        }
        return str.length() > 32768 ? str.substring(0, 32767) : str;
    }

    default Map<String, Object> validate(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (!map.containsKey("message")) {
            map.put("message", LogReporting.INVALID_MSG);
        }
        if (!map.containsKey(FirebaseAnalytics.Param.LEVEL)) {
            map.put(FirebaseAnalytics.Param.LEVEL, LogLevel.INFO.name());
        }
        return map;
    }

    default Throwable validate(Throwable th) {
        return th != null ? th : new IllegalArgumentException();
    }

    default Map<String, Object> anonymize(Map<String, Object> map) {
        return validate(map);
    }
}
