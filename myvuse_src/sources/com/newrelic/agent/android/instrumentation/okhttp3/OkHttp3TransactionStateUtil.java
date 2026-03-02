package com.newrelic.agent.android.instrumentation.okhttp3;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.HttpHeaders;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceHeader;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes6.dex */
public class OkHttp3TransactionStateUtil extends TransactionStateUtil {
    public static void inspectAndInstrument(TransactionState transactionState, Request request) {
        if (request == null) {
            log.debug("Missing request");
            return;
        }
        inspectAndInstrument(transactionState, request.url().getUrl(), request.method());
        try {
            RequestBody requestBodyBody = request.body();
            if (requestBodyBody == null || requestBodyBody.contentLength() <= 0) {
                return;
            }
            transactionState.setBytesSent(requestBodyBody.contentLength());
        } catch (IOException e) {
            log.debug("Could not determine request length: " + String.valueOf(e));
        }
    }

    public static Response inspectAndInstrumentResponse(TransactionState transactionState, Response response) {
        String strHeader;
        int iCode;
        long jExhaustiveContentLength;
        long j = 0;
        if (response == null) {
            log.debug("Missing response");
            strHeader = "";
            iCode = 500;
        } else {
            Request request = response.request();
            addHeadersAsCustomAttribute(transactionState, request);
            if (request != null && request.url() != null) {
                String url = request.url().getUrl();
                if (!url.isEmpty()) {
                    inspectAndInstrument(transactionState, url, request.method());
                }
            }
            strHeader = response.header(Constants.Network.APP_DATA_HEADER);
            iCode = response.code();
            try {
                jExhaustiveContentLength = exhaustiveContentLength(response);
            } catch (Exception unused) {
                jExhaustiveContentLength = 0;
            }
            if (jExhaustiveContentLength < 0) {
                log.debug("OkHttp3TransactionStateUtil: Missing body or content length");
            }
            j = jExhaustiveContentLength;
        }
        inspectAndInstrumentResponse(transactionState, strHeader, (int) j, iCode);
        return addTransactionAndErrorData(transactionState, response);
    }

    private static long exhaustiveContentLength(Response response) {
        if (response == null) {
            return -1L;
        }
        long contentLength = response.body() != null ? response.body().getContentLength() : -1L;
        if (contentLength >= 0) {
            return contentLength;
        }
        String strHeader = response.header("Content-Length");
        if (strHeader != null && strHeader.length() > 0) {
            try {
                return Long.parseLong(strHeader);
            } catch (NumberFormatException e) {
                log.debug("Failed to parse content length: " + String.valueOf(e));
                return contentLength;
            }
        }
        Response responseNetworkResponse = response.networkResponse();
        if (responseNetworkResponse == null) {
            return contentLength;
        }
        String strHeader2 = responseNetworkResponse.header("Content-Length");
        if (strHeader2 == null || strHeader2.length() <= 0) {
            return responseNetworkResponse.body() != null ? responseNetworkResponse.body().getContentLength() : contentLength;
        }
        try {
            return Long.parseLong(strHeader2);
        } catch (NumberFormatException e2) {
            log.debug("Failed to parse network response content length: " + String.valueOf(e2));
            return contentLength;
        }
    }

    protected static Response addTransactionAndErrorData(TransactionState transactionState, Response response) {
        TransactionData transactionDataEnd = transactionState.end();
        if (transactionDataEnd != null) {
            if (response != null && transactionState.isErrorOrFailure()) {
                String strHeader = response.header("Content-Type");
                TreeMap treeMap = new TreeMap();
                if (strHeader != null && !strHeader.isEmpty()) {
                    treeMap.put("content_type", strHeader);
                }
                treeMap.put(Constants.Transactions.CONTENT_LENGTH, new StringBuilder().append(transactionState.getBytesReceived()).toString());
                String strMessage = "";
                try {
                    long jExhaustiveContentLength = exhaustiveContentLength(response);
                    if (jExhaustiveContentLength > 0) {
                        strMessage = response.peekBody(jExhaustiveContentLength).string();
                    }
                } catch (Exception unused) {
                    if (response.message() != null) {
                        log.debug("Missing response body, using response message");
                        strMessage = response.message();
                    }
                }
                transactionDataEnd.setResponseBody(strMessage);
                transactionDataEnd.getParams().putAll(treeMap);
            }
            TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
            setDistributedTraceHeaders(transactionState, response);
        }
        return response;
    }

    public static Request setDistributedTraceHeaders(TransactionState transactionState, Request request) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing) && !HarvestConfiguration.getDefaultHarvestConfiguration().getAccount_id().isEmpty()) {
            try {
                Request.Builder builderNewBuilder = request.newBuilder();
                TraceContext trace = transactionState.getTrace();
                if (trace != null) {
                    for (TraceHeader traceHeader : trace.getHeaders()) {
                        builderNewBuilder = builderNewBuilder.header(traceHeader.getHeaderName(), traceHeader.getHeaderValue());
                    }
                    TraceContext.reportSupportabilityMetrics();
                }
                return builderNewBuilder.build();
            } catch (Exception e) {
                log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e);
                TraceContext.reportSupportabilityExceptionMetric(e);
            }
        }
        return request;
    }

    public static Response setDistributedTraceHeaders(TransactionState transactionState, Response response) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing) && !HarvestConfiguration.getDefaultHarvestConfiguration().getAccount_id().isEmpty()) {
            try {
                Response.Builder builderNewBuilder = response.newBuilder();
                TraceContext trace = transactionState.getTrace();
                if (trace != null) {
                    Headers headers = response.headers();
                    for (TraceHeader traceHeader : trace.getHeaders()) {
                        if (headers.get(traceHeader.getHeaderName()) == null) {
                            builderNewBuilder = builderNewBuilder.addHeader(traceHeader.getHeaderName(), traceHeader.getHeaderValue());
                        }
                    }
                }
                return builderNewBuilder.build();
            } catch (Exception e) {
                log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e);
                TraceContext.reportSupportabilityExceptionMetric(e);
            }
        }
        return response;
    }

    public static void addHeadersAsCustomAttribute(TransactionState transactionState, Request request) {
        HashMap map = new HashMap();
        for (String str : HttpHeaders.getInstance().getHttpHeaders()) {
            if (request.headers().get(str) != null) {
                map.put(HttpHeaders.translateApolloHeader(str), request.headers().get(str));
            }
        }
        transactionState.setParams(map);
    }
}
