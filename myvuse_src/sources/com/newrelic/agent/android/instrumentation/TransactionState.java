package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Util;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class TransactionState {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private String appData;
    private String contentType;
    private String httpMethod;
    private TraceContext trace;
    private TransactionData transactionData;
    private String url;
    private int statusCode = 0;
    private int errorCode = 0;
    private long bytesSent = 0;
    private long bytesReceived = 0;
    private long endTime = 0;
    private String carrier = "unknown";
    private String wanType = "unknown";
    private State state = State.READY;
    private long startTime = System.currentTimeMillis();
    private Map<String, String> params = new HashMap();

    enum State {
        READY,
        SENT,
        COMPLETE
    }

    public static boolean isRequestError(int i) {
        return ((long) i) >= 400;
    }

    public static boolean isRequestFailure(int i) {
        return i != 0;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public TransactionState() {
        if (FeatureFlag.featureEnabled(FeatureFlag.DefaultInteractions)) {
            TraceMachine.enterNetworkSegment("External/unknownhost");
        }
    }

    public TraceContext getTrace() {
        return this.trace;
    }

    public void setTrace(TraceContext traceContext) {
        if (!isSent()) {
            this.trace = traceContext;
            return;
        }
        log.debug("setCatPayload(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setCarrier(String str) {
        if (!isSent()) {
            this.carrier = str;
            TraceMachine.setCurrentTraceParam(AnalyticsAttribute.CARRIER_ATTRIBUTE, str);
        } else {
            log.debug("setCarrier(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public void setWanType(String str) {
        if (!isSent()) {
            this.wanType = str;
            TraceMachine.setCurrentTraceParam("wan_type", str);
        } else {
            log.debug("setWanType(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public void setAppData(String str) {
        if (!isComplete()) {
            this.appData = str;
            TraceMachine.setCurrentTraceParam("encoded_app_data", str);
        } else {
            log.debug("setAppData(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public void setUrl(String str) {
        String strSanitizeUrl = Util.sanitizeUrl(str);
        if (strSanitizeUrl == null) {
            return;
        }
        if (!isSent()) {
            this.url = strSanitizeUrl;
            try {
                if (FeatureFlag.featureEnabled(FeatureFlag.DefaultInteractions)) {
                    TraceMachine.setCurrentDisplayName("External/" + new URL(strSanitizeUrl).getHost());
                }
            } catch (MalformedURLException unused) {
                log.error("unable to parse host name from " + strSanitizeUrl);
            }
            if (FeatureFlag.featureEnabled(FeatureFlag.DefaultInteractions)) {
                TraceMachine.setCurrentTraceParam("uri", strSanitizeUrl);
                return;
            }
            return;
        }
        log.debug("setUrl(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setHttpMethod(String str) {
        if (!isSent()) {
            this.httpMethod = str;
            TraceMachine.setCurrentTraceParam("http_method", str);
        } else {
            log.debug("setHttpMethod(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public String getUrl() {
        return this.url;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public boolean isSent() {
        return this.state == State.SENT || this.state == State.COMPLETE;
    }

    public boolean isComplete() {
        return this.state == State.COMPLETE;
    }

    public void setStatusCode(int i) {
        if (!isComplete()) {
            this.statusCode = i;
            TraceMachine.setCurrentTraceParam("status_code", Integer.valueOf(i));
        } else {
            log.debug("setStatusCode(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setErrorCode(int i) {
        if (!isComplete()) {
            this.errorCode = i;
            TraceMachine.setCurrentTraceParam("error_code", Integer.valueOf(i));
            return;
        }
        TransactionData transactionData = this.transactionData;
        if (transactionData != null) {
            transactionData.setErrorCode(i);
        }
        log.debug("setErrorCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setBytesSent(long j) {
        if (!isComplete()) {
            this.bytesSent = j;
            TraceMachine.setCurrentTraceParam("bytes_sent", Long.valueOf(j));
        } else {
            log.debug("setBytesSent(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public void setBytesReceived(long j) {
        if (!isComplete()) {
            this.bytesReceived = j;
            TraceMachine.setCurrentTraceParam("bytes_received", Long.valueOf(j));
        } else {
            log.debug("setBytesReceived(...) called on TransactionState in " + this.state.toString() + " state");
        }
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public TransactionData end() {
        if (!isComplete()) {
            this.state = State.COMPLETE;
            this.endTime = System.currentTimeMillis();
            TraceMachine.exitMethod();
        }
        return toTransactionData();
    }

    TransactionData toTransactionData() {
        float f;
        if (!isComplete()) {
            log.debug("toTransactionData() called on incomplete TransactionState");
        }
        if (this.url == null) {
            log.error("Attempted to convert a TransactionState instance with no URL into a TransactionData");
            return null;
        }
        long j = this.endTime;
        long j2 = this.startTime;
        float f2 = (j - j2) / 1000.0f;
        if (f2 < 0.0f) {
            log.error("Invalid response duration detected: start[" + j2 + "] end[" + j + "]");
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_RESPONSE_TIME_INVALID_DURATION);
            f = 0.0f;
        } else {
            f = f2;
        }
        if (this.transactionData == null) {
            this.transactionData = new TransactionData(this.url, this.httpMethod, this.carrier, f, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.appData, this.wanType, this.trace, "", this.params, null);
        }
        return this.transactionData;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public boolean isErrorOrFailure() {
        return isRequestError() || isRequestFailure();
    }

    public boolean isRequestFailure() {
        return isRequestFailure(this.errorCode);
    }

    public boolean isRequestError() {
        return isRequestError(this.statusCode);
    }

    public String toString() {
        return "TransactionState{url='" + this.url + "', httpMethod='" + this.httpMethod + "', statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", appData='" + this.appData + "', carrier='" + this.carrier + "', wanType='" + this.wanType + "', state=" + String.valueOf(this.state) + ", contentType='" + this.contentType + "', transactionData=" + String.valueOf(this.transactionData) + "}";
    }

    State setState(State state) {
        this.state = state;
        return state;
    }
}
