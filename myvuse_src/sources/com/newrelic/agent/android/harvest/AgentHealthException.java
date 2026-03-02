package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class AgentHealthException extends HarvestableArray {
    private final AtomicLong count;
    private String exceptionClass;
    private Map<String, String> extras;
    private String message;
    private StackTraceElement[] stackTrace;
    private String threadName;

    public AgentHealthException(Exception exc) {
        this(exc, Thread.currentThread().getName());
    }

    public AgentHealthException(Exception exc, String str) {
        this(exc.getClass().getName(), exc.getMessage(), str, exc.getStackTrace());
    }

    public AgentHealthException(String str, String str2, String str3, StackTraceElement[] stackTraceElementArr) {
        this(str, str2, str3, stackTraceElementArr, null);
    }

    public AgentHealthException(String str, String str2, String str3, StackTraceElement[] stackTraceElementArr, Map<String, String> map) {
        this.count = new AtomicLong(1L);
        this.exceptionClass = str;
        this.message = str2;
        this.threadName = str3;
        this.stackTrace = stackTraceElementArr;
        this.extras = map;
    }

    public void increment() {
        this.count.getAndIncrement();
    }

    public void increment(long j) {
        this.count.getAndAdd(j);
    }

    public String getExceptionClass() {
        return this.exceptionClass;
    }

    public String getMessage() {
        return this.message;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }

    public long getCount() {
        return this.count.get();
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public String getSourceClass() {
        return this.stackTrace[0].getClassName();
    }

    public String getSourceMethod() {
        return this.stackTrace[0].getMethodName();
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(SafeJsonPrimitive.factory(this.exceptionClass));
        String str = this.message;
        if (str == null) {
            str = "";
        }
        jsonArray.add(SafeJsonPrimitive.factory(str));
        jsonArray.add(SafeJsonPrimitive.factory(this.threadName));
        jsonArray.add(stackTraceToJson());
        jsonArray.add(SafeJsonPrimitive.factory(Long.valueOf(this.count.get())));
        jsonArray.add(extrasToJson());
        return jsonArray;
    }

    private JsonArray stackTraceToJson() {
        JsonArray jsonArray = new JsonArray();
        for (StackTraceElement stackTraceElement : this.stackTrace) {
            jsonArray.add(SafeJsonPrimitive.factory(stackTraceElement.toString()));
        }
        return jsonArray;
    }

    private JsonObject extrasToJson() {
        JsonObject jsonObject = new JsonObject();
        Map<String, String> map = this.extras;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jsonObject.add(entry.getKey(), SafeJsonPrimitive.factory(entry.getValue()));
            }
        }
        return jsonObject;
    }
}
