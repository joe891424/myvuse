package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class JSONObjectInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, MetricCategory.class.getName(), "JSON"));

    JSONObjectInstrumentation() {
    }

    public static JSONObject init(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Failed to initialize JSONObject: json string is null.");
        }
        try {
            TraceMachine.enterMethod(null, "JSONObject#<init>", categoryParams);
            JSONObject jSONObject = new JSONObject(str);
            TraceMachine.exitMethod();
            return jSONObject;
        } catch (JSONException e) {
            TraceMachine.exitMethod();
            throw e;
        }
    }

    public static String toString(JSONObject jSONObject) {
        TraceMachine.enterMethod(null, "JSONObject#toString", categoryParams);
        String string = jSONObject.toString();
        TraceMachine.exitMethod();
        return string;
    }

    public static String toString(JSONObject jSONObject, int i) throws JSONException {
        try {
            TraceMachine.enterMethod(null, "JSONObject#toString", categoryParams);
            String string = jSONObject.toString(i);
            TraceMachine.exitMethod();
            return string;
        } catch (JSONException e) {
            TraceMachine.exitMethod();
            throw e;
        }
    }
}
