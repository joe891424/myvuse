package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class HttpTransaction extends HarvestableArray {
    private String appData;
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private int errorCode;
    private String httpMethod;
    private Map<String, String> params;
    private String responseBody;
    private int statusCode;
    private Long timestamp;
    private double totalTime;
    private Map<String, Object> traceAttributes;
    private TraceContext traceContext;
    private String url;
    private String wanType;

    @Override // com.newrelic.agent.android.harvest.type.HarvestableArray, com.newrelic.agent.android.harvest.type.BaseHarvestable, com.newrelic.agent.android.harvest.type.Harvestable
    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(SafeJsonPrimitive.factory(this.url));
        jsonArray.add(SafeJsonPrimitive.factory(this.carrier));
        jsonArray.add(SafeJsonPrimitive.factory(Double.valueOf(this.totalTime)));
        jsonArray.add(SafeJsonPrimitive.factory(Integer.valueOf(this.statusCode)));
        jsonArray.add(SafeJsonPrimitive.factory(Integer.valueOf(this.errorCode)));
        jsonArray.add(SafeJsonPrimitive.factory(Long.valueOf(this.bytesSent)));
        jsonArray.add(SafeJsonPrimitive.factory(Long.valueOf(this.bytesReceived)));
        String str = this.appData;
        jsonArray.add(str == null ? null : SafeJsonPrimitive.factory(str));
        jsonArray.add(SafeJsonPrimitive.factory(this.wanType));
        jsonArray.add(SafeJsonPrimitive.factory(this.httpMethod));
        return jsonArray;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setHttpMethod(String str) {
        this.httpMethod = str;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public void setWanType(String str) {
        this.wanType = str;
    }

    public void setTotalTime(double d) {
        this.totalTime = d;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setBytesSent(long j) {
        this.bytesSent = j;
    }

    public void setBytesReceived(long j) {
        this.bytesReceived = j;
    }

    public void setAppData(String str) {
        this.appData = str;
    }

    public void setResponseBody(String str) {
        if (FeatureFlag.featureEnabled(FeatureFlag.HttpResponseBodyCapture)) {
            if (str == null || str.isEmpty()) {
                this.responseBody = null;
            } else {
                this.responseBody = str;
            }
        }
    }

    public Map<String, Object> getTraceAttributes() {
        return this.traceAttributes;
    }

    public void setTraceAttributes(Map<String, Object> map) {
        this.traceAttributes = map;
    }

    public void setTraceContext(TraceContext traceContext) {
        this.traceContext = traceContext;
    }

    public TraceContext getTraceContext() {
        return this.traceContext;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public double getTotalTime() {
        return this.totalTime;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public String getAppData() {
        return this.appData;
    }

    public String getWanType() {
        return this.wanType;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public String toString() {
        return "HttpTransaction{url='" + this.url + "', carrier='" + this.carrier + "', wanType='" + this.wanType + "', httpMethod='" + this.httpMethod + "', totalTime=" + this.totalTime + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", appData='" + this.appData + "', responseBody='" + this.responseBody + "', params='" + String.valueOf(this.params) + "', timestamp=" + this.timestamp + "}";
    }
}
