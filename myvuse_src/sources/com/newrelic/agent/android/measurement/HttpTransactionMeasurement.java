package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Util;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class HttpTransactionMeasurement extends BaseMeasurement {
    private final String appData;
    private final long bytesReceived;
    private final long bytesSent;
    private final int errorCode;
    private final String httpMethod;
    private Map<String, String> params;
    private String responseBody;
    private final int statusCode;
    private final double totalTime;
    private Map<String, Object> traceAttributes;
    private TraceContext traceContext;
    private String url;

    public HttpTransactionMeasurement(String str, String str2, int i, int i2, long j, double d, long j2, long j3, String str3) {
        super(MeasurementType.Network);
        String strSanitizeUrl = Util.sanitizeUrl(str);
        setName(strSanitizeUrl);
        setScope(TraceMachine.getCurrentScope());
        setStartTime(j);
        setEndTime(j + ((long) ((int) d)));
        setExclusiveTime((int) (1000.0d * d));
        this.url = strSanitizeUrl;
        this.httpMethod = str2;
        this.statusCode = i;
        this.bytesSent = j2;
        this.bytesReceived = j3;
        this.totalTime = d;
        this.appData = str3;
        this.errorCode = i2;
        this.responseBody = null;
        this.params = null;
        this.traceContext = null;
    }

    public HttpTransactionMeasurement(String str, String str2, int i, int i2, long j, double d, long j2, long j3, String str3, String str4) {
        this(str, str2, i, i2, j, d, j2, j3, str3);
        this.responseBody = str4;
    }

    public HttpTransactionMeasurement(TransactionData transactionData) {
        this(transactionData.getUrl(), transactionData.getHttpMethod(), transactionData.getStatusCode(), transactionData.getErrorCode(), transactionData.getTimestamp(), transactionData.getTime(), transactionData.getBytesSent(), transactionData.getBytesReceived(), transactionData.getAppData());
        this.responseBody = transactionData.getResponseBody();
        this.params = transactionData.getParams();
        this.traceContext = transactionData.getTraceContext();
        this.traceAttributes = transactionData.getTraceAttributes();
    }

    @Override // com.newrelic.agent.android.measurement.BaseMeasurement, com.newrelic.agent.android.measurement.Measurement
    public double asDouble() {
        return this.totalTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHttpMethod() {
        return this.httpMethod;
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

    public String getResponseBody() {
        return this.responseBody;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public TraceContext getTraceContext() {
        return this.traceContext;
    }

    public Map<String, Object> getTraceAttributes() {
        return this.traceAttributes;
    }

    @Override // com.newrelic.agent.android.measurement.BaseMeasurement
    public String toString() {
        return "HttpTransactionMeasurement{url='" + this.url + "', httpMethod='" + this.httpMethod + "', totalTime=" + this.totalTime + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", appData='" + this.appData + "', responseBody='" + this.responseBody + "', params='" + String.valueOf(this.params) + "'}";
    }
}
