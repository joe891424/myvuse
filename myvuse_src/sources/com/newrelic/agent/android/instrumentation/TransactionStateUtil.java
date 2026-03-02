package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.HttpHeaders;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceHeader;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.Constants;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class TransactionStateUtil {
    protected static final long CONTENTLENGTH_UNKNOWN = -1;
    protected static final AgentLog log = AgentLogManager.getAgentLog();

    public static void inspectAndInstrument(TransactionState transactionState, String str, String str2) {
        transactionState.setUrl(str);
        transactionState.setHttpMethod(str2);
        transactionState.setCarrier(Agent.getActiveNetworkCarrier());
        transactionState.setWanType(Agent.getActiveNetworkWanType());
    }

    public static void inspectAndInstrument(TransactionState transactionState, HttpURLConnection httpURLConnection) {
        inspectAndInstrument(transactionState, httpURLConnection.getURL().toString(), httpURLConnection.getRequestMethod());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionState, String str, int i, int i2) {
        if (str != null && !str.equals("")) {
            transactionState.setAppData(str);
        }
        if (i >= 0) {
            transactionState.setBytesReceived(i);
        }
        transactionState.setStatusCode(i2);
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionState, HttpURLConnection httpURLConnection) {
        String headerField = null;
        int contentLength = -1;
        int responseCode = 0;
        try {
            contentLength = httpURLConnection.getContentLength();
            responseCode = httpURLConnection.getResponseCode();
            headerField = httpURLConnection.getHeaderField(Constants.Network.APP_DATA_HEADER);
        } catch (IOException e) {
            log.debug("Failed to retrieve response data due to an I/O exception: " + e.getLocalizedMessage());
        } catch (IllegalStateException e2) {
            log.debug("Failed to retrieve response data on a closed connection: " + e2.getLocalizedMessage());
        } catch (NullPointerException e3) {
            log.error("Failed to retrieve response code due to underlying (Harmony?) NPE" + e3.getLocalizedMessage());
        }
        inspectAndInstrumentResponse(transactionState, headerField, contentLength, responseCode);
    }

    public static void setErrorCodeFromException(TransactionState transactionState, Exception exc) {
        int iExceptionToErrorCode = ExceptionHelper.exceptionToErrorCode(exc);
        log.error("TransactionStateUtil: Attempting to convert network exception " + exc.getClass().getName() + " to error code.");
        transactionState.setErrorCode(iExceptionToErrorCode);
    }

    public static void setTrace(TransactionState transactionState) {
        if (transactionState.getTrace() == null) {
            transactionState.setTrace(DistributedTracing.getInstance().startTrace(transactionState));
        }
    }

    static void setDistributedTraceHeaders(TransactionState transactionState, HttpURLConnection httpURLConnection) {
        if (!FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing) || HarvestConfiguration.getDefaultHarvestConfiguration().getAccount_id().isEmpty()) {
            return;
        }
        try {
            TraceContext trace = transactionState.getTrace();
            if (trace != null) {
                for (TraceHeader traceHeader : trace.getHeaders()) {
                    httpURLConnection.addRequestProperty(traceHeader.getHeaderName(), traceHeader.getHeaderValue());
                }
                TraceContext.reportSupportabilityMetrics();
            }
        } catch (Exception e) {
            log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e);
            TraceContext.reportSupportabilityExceptionMetric(e);
        }
    }

    public static void setCrossProcessHeader(HttpURLConnection httpURLConnection) {
        try {
            String crossProcessId = Agent.getCrossProcessId();
            if (crossProcessId != null) {
                httpURLConnection.setRequestProperty(Constants.Network.CROSS_PROCESS_ID_HEADER, crossProcessId);
            }
        } catch (Exception e) {
            log.error("setCrossProcessHeader: " + e.getLocalizedMessage());
        }
    }

    public static void addHeadersAsCustomAttribute(TransactionState transactionState, String str, String str2) {
        if (HttpHeaders.getInstance().getHttpHeaders().contains(str)) {
            if (transactionState.getParams() != null) {
                transactionState.getParams().put(str, str2);
                return;
            }
            HashMap map = new HashMap();
            map.put(str, str2);
            transactionState.setParams(map);
        }
    }
}
