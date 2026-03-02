package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ThreadInfo extends HarvestableObject {
    protected boolean crashed;
    protected StackTraceElement[] stackTrace;
    protected String state;
    protected long threadId;
    protected String threadName;
    protected int threadPriority;

    public ThreadInfo() {
    }

    public ThreadInfo(Throwable th) {
        this(Thread.currentThread(), th.getStackTrace());
        this.crashed = true;
    }

    public ThreadInfo(Thread thread, StackTraceElement[] stackTraceElementArr) {
        this.crashed = false;
        this.threadId = thread.getId();
        this.threadName = thread.getName();
        this.threadPriority = thread.getPriority();
        this.state = thread.getState().toString();
        this.stackTrace = stackTraceElementArr;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public List<ThreadInfo> allThreads() {
        ArrayList arrayList = new ArrayList();
        long threadId = getThreadId();
        arrayList.add(this);
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (key.getId() != threadId) {
                arrayList.add(new ThreadInfo(key, value));
            }
        }
        return arrayList;
    }

    public static List<ThreadInfo> extractThreads(Throwable th) {
        return new ThreadInfo(th).allThreads();
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableObject, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("crashed", SafeJsonPrimitive.factory(Boolean.valueOf(this.crashed)));
        jsonObject.add("state", SafeJsonPrimitive.factory(this.state));
        jsonObject.add("threadNumber", SafeJsonPrimitive.factory(Long.valueOf(this.threadId)));
        jsonObject.add("threadId", SafeJsonPrimitive.factory(this.threadName));
        jsonObject.add("priority", SafeJsonPrimitive.factory(Integer.valueOf(this.threadPriority)));
        jsonObject.add("stack", getStackAsJson());
        return jsonObject;
    }

    public static ThreadInfo newFromJson(JsonObject jsonObject) {
        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.crashed = jsonObject.get("crashed").getAsBoolean();
        threadInfo.state = jsonObject.get("state").getAsString();
        threadInfo.threadId = jsonObject.get("threadNumber").getAsLong();
        threadInfo.threadName = jsonObject.get("threadId").getAsString();
        threadInfo.threadPriority = jsonObject.get("priority").getAsInt();
        threadInfo.stackTrace = threadInfo.stackTraceFromJson(jsonObject.get("stack").getAsJsonArray());
        return threadInfo;
    }

    public StackTraceElement[] stackTraceFromJson(JsonArray jsonArray) {
        String asString;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[jsonArray.size()];
        int i = 0;
        for (JsonElement jsonElement : jsonArray) {
            if (jsonElement.getAsJsonObject().get("fileName") == null) {
                asString = "unknown";
            } else {
                asString = jsonElement.getAsJsonObject().get("fileName").getAsString();
            }
            stackTraceElementArr[i] = new StackTraceElement(jsonElement.getAsJsonObject().get(HexAttribute.HEX_ATTR_CLASS_NAME).getAsString(), jsonElement.getAsJsonObject().get("methodName").getAsString(), asString, jsonElement.getAsJsonObject().get("lineNumber").getAsInt());
            i++;
        }
        return stackTraceElementArr;
    }

    public List<ThreadInfo> newListFromJson(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it2 = jsonArray.iterator();
        while (it2.hasNext()) {
            arrayList.add(newFromJson(it2.next().getAsJsonObject()));
        }
        return arrayList;
    }

    private JsonArray getStackAsJson() {
        JsonArray jsonArray = new JsonArray();
        for (StackTraceElement stackTraceElement : this.stackTrace) {
            JsonObject jsonObject = new JsonObject();
            if (stackTraceElement.getFileName() != null) {
                jsonObject.add("fileName", SafeJsonPrimitive.factory(stackTraceElement.getFileName()));
            }
            jsonObject.add(HexAttribute.HEX_ATTR_CLASS_NAME, SafeJsonPrimitive.factory(stackTraceElement.getClassName()));
            jsonObject.add("methodName", SafeJsonPrimitive.factory(stackTraceElement.getMethodName()));
            jsonObject.add("lineNumber", SafeJsonPrimitive.factory(Integer.valueOf(stackTraceElement.getLineNumber())));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
