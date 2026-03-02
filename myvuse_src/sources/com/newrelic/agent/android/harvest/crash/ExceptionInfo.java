package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes6.dex */
public class ExceptionInfo extends HarvestableObject {
    private String className;
    private String message;

    public ExceptionInfo() {
    }

    public ExceptionInfo(Throwable th) {
        this.className = th.getClass().getName();
        if (th.getMessage() != null) {
            this.message = th.getMessage();
        } else {
            this.message = "";
        }
    }

    public String getClassName() {
        return this.className;
    }

    public String getMessage() {
        return this.message;
    }

    @Override // com.newrelic.agent.android.harvest.type.HarvestableObject, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        String str = this.className;
        if (str == null) {
            str = "";
        }
        jsonObject.add("name", new JsonPrimitive(str));
        String str2 = this.message;
        jsonObject.add(HexAttribute.HEX_ATTR_CAUSE, new JsonPrimitive(str2 != null ? str2 : ""));
        return jsonObject;
    }

    public static ExceptionInfo newFromJson(JsonObject jsonObject) {
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.className = jsonObject.has("name") ? jsonObject.get("name").getAsString() : "";
        exceptionInfo.message = jsonObject.has(HexAttribute.HEX_ATTR_CAUSE) ? jsonObject.get(HexAttribute.HEX_ATTR_CAUSE).getAsString() : "";
        return exceptionInfo;
    }
}
