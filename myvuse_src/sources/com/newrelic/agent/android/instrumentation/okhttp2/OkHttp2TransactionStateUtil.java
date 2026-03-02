package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceHeader;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.TreeMap;
import okio.Buffer;

/* JADX INFO: loaded from: classes6.dex */
public class OkHttp2TransactionStateUtil extends TransactionStateUtil {
    public static void inspectAndInstrument(TransactionState transactionState, Request request) {
        if (request == null) {
            log.debug("Missing request");
            return;
        }
        if (!transactionState.isSent()) {
            inspectAndInstrument(transactionState, request.urlString(), request.method());
        }
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
        int iCode;
        String strHeader = "";
        long jExhaustiveContentLength = 0;
        if (response == null) {
            log.debug("Missing response");
            iCode = 500;
        } else {
            Request request = response.request();
            if (request != null && request.url() != null) {
                String string = request.url().toString();
                if (!string.isEmpty()) {
                    inspectAndInstrument(transactionState, string, request.method());
                }
            }
            iCode = -1;
            try {
                strHeader = response.header(Constants.Network.APP_DATA_HEADER);
                iCode = response.code();
                jExhaustiveContentLength = exhaustiveContentLength(response);
            } catch (Exception unused) {
                log.debug("OkHttp2TransactionStateUtil: Missing body or content length");
            }
        }
        inspectAndInstrumentResponse(transactionState, strHeader, (int) jExhaustiveContentLength, iCode);
        return addTransactionAndErrorData(transactionState, response);
    }

    protected static Response addTransactionAndErrorData(TransactionState transactionState, Response response) {
        String strMessage = "Missing response body, using response message";
        TransactionData transactionDataEnd = transactionState.end();
        if (transactionDataEnd != null) {
            if (response != null && transactionState.isErrorOrFailure()) {
                String strHeader = response.header("Content-Type");
                TreeMap treeMap = new TreeMap();
                if (strHeader != null && !strHeader.isEmpty()) {
                    treeMap.put("content_type", strHeader);
                }
                treeMap.put(Constants.Transactions.CONTENT_LENGTH, new StringBuilder().append(transactionState.getBytesReceived()).toString());
                String strMessage2 = "";
                try {
                    if (response.body() != null) {
                        ResponseBody responseBodyBody = response.body();
                        ByteBuffer byteBufferWrap = ByteBuffer.wrap(responseBodyBody.bytes());
                        response = response.newBuilder().body(new PrebufferedResponseBody(responseBodyBody, new Buffer().write(byteBufferWrap.array()))).build();
                        strMessage2 = new String(byteBufferWrap.array());
                    } else if (response.message() != null) {
                        log.debug("Missing response body, using response message");
                        strMessage = response.message();
                        strMessage2 = strMessage;
                    }
                } catch (Exception unused) {
                    if (response.message() != null) {
                        log.debug(strMessage);
                        strMessage2 = response.message();
                    }
                }
                transactionDataEnd.setResponseBody(strMessage2);
                transactionDataEnd.getParams().putAll(treeMap);
                response = setDistributedTraceHeaders(transactionState, response);
            }
            TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
        }
        return response;
    }

    private static long exhaustiveContentLength(Response response) {
        long jContentLength = -1;
        if (response == null) {
            return -1L;
        }
        if (response.body() != null) {
            try {
                jContentLength = response.body().contentLength();
            } catch (IOException e) {
                log.debug("Failed to parse content length: " + e.toString());
            }
        }
        if (jContentLength >= 0) {
            return jContentLength;
        }
        String strHeader = response.header("Content-Length");
        if (strHeader != null && strHeader.length() > 0) {
            try {
                return Long.parseLong(strHeader);
            } catch (NumberFormatException e2) {
                log.debug("Failed to parse content length: " + e2.toString());
                return jContentLength;
            }
        }
        Response responseNetworkResponse = response.networkResponse();
        if (responseNetworkResponse == null) {
            return jContentLength;
        }
        String strHeader2 = responseNetworkResponse.header("Content-Length");
        if (strHeader2 != null && strHeader2.length() > 0) {
            try {
                return Long.parseLong(strHeader2);
            } catch (NumberFormatException e3) {
                log.debug("Failed to parse content length: " + e3.toString());
                return jContentLength;
            }
        }
        if (responseNetworkResponse.body() == null) {
            return jContentLength;
        }
        try {
            return responseNetworkResponse.body().contentLength();
        } catch (IOException e4) {
            log.debug("Failed to parse network response content length: " + e4.toString());
            e4.printStackTrace();
            return jContentLength;
        }
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
                }
                TraceContext.reportSupportabilityMetrics();
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
                    for (TraceHeader traceHeader : trace.getHeaders()) {
                        builderNewBuilder = builderNewBuilder.header(traceHeader.getHeaderName(), traceHeader.getHeaderValue());
                    }
                }
                TraceContext.reportSupportabilityMetrics();
                return builderNewBuilder.build();
            } catch (Exception e) {
                log.error("setDistributedTraceHeaders: Unable to add trace headers. ", e);
                TraceContext.reportSupportabilityExceptionMetric(e);
            }
        }
        return response;
    }
}
