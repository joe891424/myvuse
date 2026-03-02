package com.newrelic.agent.android.instrumentation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class GsonInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(AnalyticsAttribute.EVENT_CATEGORY_ATTRIBUTE, MetricCategory.class.getName(), "JSON"));

    public static String toJson(Gson gson, Object obj) {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        String json = gson.toJson(obj);
        TraceMachine.exitMethod();
        return json;
    }

    public static String toJson(Gson gson, Object obj, Type type) {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        String json = gson.toJson(obj, type);
        TraceMachine.exitMethod();
        return json;
    }

    public static void toJson(Gson gson, Object obj, Appendable appendable) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(Gson gson, Object obj, Type type, Appendable appendable) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, type, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(Gson gson, Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, type, jsonWriter);
        TraceMachine.exitMethod();
    }

    public static String toJson(Gson gson, JsonElement jsonElement) {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        String json = gson.toJson(jsonElement);
        TraceMachine.exitMethod();
        return json;
    }

    public static void toJson(Gson gson, JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(jsonElement, appendable);
        TraceMachine.exitMethod();
    }

    public static void toJson(Gson gson, JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(jsonElement, jsonWriter);
        TraceMachine.exitMethod();
    }

    public static <T> T fromJson(Gson gson, String str, Class<T> cls) throws JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T t = (T) gson.fromJson(str, (Class) cls);
        TraceMachine.exitMethod();
        return t;
    }

    public static <T> T fromJson(Gson gson, String str, Type type) throws JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T t = (T) gson.fromJson(str, type);
        TraceMachine.exitMethod();
        return t;
    }

    public static <T> T fromJson(Gson gson, Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T t = (T) gson.fromJson(reader, (Class) cls);
        TraceMachine.exitMethod();
        return t;
    }

    public static <T> T fromJson(Gson gson, Reader reader, Type type) throws JsonSyntaxException, JsonIOException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T t = (T) gson.fromJson(reader, type);
        TraceMachine.exitMethod();
        return t;
    }

    public static <T> T fromJson(Gson gson, JsonReader jsonReader, Type type) throws JsonSyntaxException, JsonIOException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T t = (T) gson.fromJson(jsonReader, type);
        TraceMachine.exitMethod();
        return t;
    }

    public static <T> T fromJson(Gson gson, JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T t = (T) gson.fromJson(jsonElement, (Class) cls);
        TraceMachine.exitMethod();
        return t;
    }

    public static <T> T fromJson(Gson gson, JsonElement jsonElement, Type type) throws JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T t = (T) gson.fromJson(jsonElement, type);
        TraceMachine.exitMethod();
        return t;
    }
}
