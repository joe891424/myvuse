package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.HttpHeaders;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.instrumentation.HttpURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes6.dex */
public class OkHttp2Instrumentation {
    static final String CACHED_RESPONSE_CLASS = "com.squareup.okhttp.Cache$CacheResponseBody";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    private OkHttp2Instrumentation() {
    }

    public static Request build(Request.Builder builder) {
        return new RequestBuilderExtension(builder).build();
    }

    public static Call newCall(OkHttpClient okHttpClient, Request request) {
        TransactionState transactionState = new TransactionState();
        addHeadersAsCustomAttribute(transactionState, request);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            try {
                transactionState.setTrace(DistributedTracing.getInstance().startTrace(transactionState));
                Request distributedTraceHeaders = OkHttp2TransactionStateUtil.setDistributedTraceHeaders(transactionState, request);
                return new CallExtension(okHttpClient, distributedTraceHeaders, okHttpClient.newCall(distributedTraceHeaders), transactionState);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return new CallExtension(okHttpClient, request, okHttpClient.newCall(request), transactionState);
    }

    private static void addHeadersAsCustomAttribute(TransactionState transactionState, Request request) {
        HashMap map = new HashMap();
        for (String str : HttpHeaders.getInstance().getHttpHeaders()) {
            if (request.headers().get(str) != null) {
                map.put(HttpHeaders.translateApolloHeader(str), request.headers().get(str));
            }
        }
        transactionState.setParams(map);
    }

    public static Response.Builder body(Response.Builder builder, ResponseBody responseBody) {
        return new ResponseBuilderExtension(builder).body(responseBody);
    }

    public static Response.Builder newBuilder(Response.Builder builder) {
        return new ResponseBuilderExtension(builder);
    }

    public static HttpURLConnection open(OkUrlFactory okUrlFactory, URL url) {
        HttpURLConnection httpURLConnectionOpen = okUrlFactory.open(url);
        String protocol = url.getProtocol();
        if (protocol.equals("http")) {
            return new HttpURLConnectionExtension(httpURLConnectionOpen);
        }
        if (protocol.equals("https") && (httpURLConnectionOpen instanceof HttpsURLConnection)) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) httpURLConnectionOpen);
        }
        return new HttpURLConnectionExtension(httpURLConnectionOpen);
    }

    public static ResponseBody body(Response response) {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            try {
                if (responseBodyBody instanceof PrebufferedResponseBody) {
                    PrebufferedResponseBody prebufferedResponseBody = (PrebufferedResponseBody) responseBodyBody;
                    if (prebufferedResponseBody.impl.getClass().getName().equalsIgnoreCase(CACHED_RESPONSE_CLASS)) {
                        return prebufferedResponseBody.impl;
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return responseBodyBody;
    }
}
