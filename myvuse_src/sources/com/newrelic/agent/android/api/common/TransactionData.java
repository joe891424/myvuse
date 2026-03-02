package com.newrelic.agent.android.api.common;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class TransactionData {
    private final String appData;
    private final long bytesReceived;
    private final long bytesSent;
    private final String carrier;
    private int errorCode;
    private final Object errorCodeLock;
    private final String httpMethod;
    private Map<String, String> params;
    private String responseBody;
    private final int statusCode;
    private final float time;
    private final long timestamp;
    private Map<String, Object> traceAttributes;
    private final TraceContext traceContext;
    private final String url;
    private final String wanType;

    public TransactionData(String str, String str2, String str3, float f, int i, int i2, long j, long j2, String str4, String str5, TraceContext traceContext, Map<String, Object> map) {
        this.errorCodeLock = new Object();
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0 && (iIndexOf = str.indexOf(59)) < 0) {
            iIndexOf = str.length();
        }
        this.url = str.substring(0, iIndexOf);
        this.httpMethod = str2;
        this.carrier = str3;
        this.time = f;
        this.statusCode = i;
        this.errorCode = i2;
        this.bytesSent = j;
        this.bytesReceived = j2;
        this.appData = str4;
        this.wanType = str5;
        this.timestamp = System.currentTimeMillis();
        this.responseBody = null;
        this.params = new HashMap();
        this.traceContext = traceContext;
        this.traceAttributes = map;
    }

    public TransactionData(String str, String str2, String str3, float f, int i, int i2, long j, long j2, String str4, String str5, TraceContext traceContext, String str6, Map<String, String> map, Map<String, Object> map2) {
        this(str, str2, str3, f, i, i2, j, j2, str4, str5, traceContext, map2);
        this.responseBody = str6;
        this.params = map;
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

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getErrorCode() {
        int i;
        synchronized (this.errorCodeLock) {
            i = this.errorCode;
        }
        return i;
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

    public long getTimestamp() {
        return this.timestamp;
    }

    public float getTime() {
        return this.time;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setErrorCode(int i) {
        synchronized (this.errorCodeLock) {
            this.errorCode = i;
        }
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

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public TraceContext getTraceContext() {
        return this.traceContext;
    }

    public Map<String, Object> getTraceAttributes() {
        return this.traceAttributes;
    }

    public void setTraceAttributes(Map<String, Object> map) {
        this.traceAttributes = map;
    }

    public List<Object> asList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.url);
        arrayList.add(this.carrier);
        arrayList.add(Float.valueOf(this.time));
        arrayList.add(Integer.valueOf(this.statusCode));
        arrayList.add(Integer.valueOf(this.errorCode));
        arrayList.add(Long.valueOf(this.bytesSent));
        arrayList.add(Long.valueOf(this.bytesReceived));
        arrayList.add(this.appData);
        return arrayList;
    }

    public String toString() {
        return "TransactionData{timestamp=" + this.timestamp + ", url='" + this.url + "', httpMethod='" + this.httpMethod + "', carrier='" + this.carrier + "', time=" + this.time + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", errorCodeLock=" + String.valueOf(this.errorCodeLock) + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", appData='" + this.appData + "', wanType='" + this.wanType + "'}";
    }
}
