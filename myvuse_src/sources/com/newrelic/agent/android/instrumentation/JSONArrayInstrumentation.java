package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
public class JSONArrayInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, MetricCategory.class.getName(), "JSON"));

    JSONArrayInstrumentation() {
    }

    public static JSONArray init(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Failed to initialize JSONArray: json string is null.");
        }
        try {
            TraceMachine.enterMethod("JSONArray#<init>", categoryParams);
            JSONArray jSONArray = new JSONArray(str);
            TraceMachine.exitMethod();
            return jSONArray;
        } catch (JSONException e) {
            TraceMachine.exitMethod();
            throw e;
        }
    }

    public static String toString(JSONArray jSONArray) {
        TraceMachine.enterMethod("JSONArray#toString", categoryParams);
        String string = jSONArray.toString();
        TraceMachine.exitMethod();
        return string;
    }

    public static String toString(JSONArray jSONArray, int i) throws JSONException {
        try {
            TraceMachine.enterMethod("JSONArray#toString", categoryParams);
            String string = jSONArray.toString(i);
            TraceMachine.exitMethod();
            return string;
        } catch (JSONException e) {
            TraceMachine.exitMethod();
            throw e;
        }
    }
}
