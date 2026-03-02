package com.newrelic.agent.android.instrumentation.okhttp3;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.HttpHeaders;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.instrumentation.HttpURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkUrlFactory;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.StreamAllocation;

/* JADX INFO: loaded from: classes6.dex */
public class OkHttp3Instrumentation {
    private static final AgentLog log = AgentLogManager.getAgentLog();

    private OkHttp3Instrumentation() {
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
                Request distributedTraceHeaders = OkHttp3TransactionStateUtil.setDistributedTraceHeaders(transactionState, request);
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

    public static class OkHttp35 {
        public static void setCallWebSocket(Internal internal, Call call) {
            try {
                if (call instanceof CallExtension) {
                    call = ((CallExtension) call).getImpl();
                }
                Method method = Internal.class.getMethod("setCallWebSocket", Call.class);
                if (method != null) {
                    method.invoke(internal, call);
                } else {
                    OkHttp3Instrumentation.logReflectionError("setCallWebSocket(Lokhttp3/Call;)V");
                }
            } catch (Exception e) {
                OkHttp3Instrumentation.log.error("OkHttp3Instrumentation: " + e.getMessage());
            }
        }

        public static StreamAllocation callEngineGetStreamAllocation(Internal internal, Call call) {
            try {
                if (call instanceof CallExtension) {
                    call = ((CallExtension) call).getImpl();
                }
                Method method = Internal.class.getMethod("callEngineGetStreamAllocation", Call.class);
                if (method != null) {
                    return (StreamAllocation) method.invoke(internal, call);
                }
                OkHttp3Instrumentation.logReflectionError("callEngineGetStreamAllocation(Lokhttp3/Call;)Lokhttp3/internal/connection/StreamAllocation;");
                return null;
            } catch (Exception e) {
                OkHttp3Instrumentation.log.error("OkHttp3Instrumentation: " + e.getMessage());
                return null;
            }
        }

        public static Call newWebSocketCall(Internal internal, OkHttpClient okHttpClient, Request request) {
            CallExtension callExtension;
            try {
                Method method = Internal.class.getMethod("newWebSocketCall", OkHttpClient.class, Request.class);
                if (method != null) {
                    TransactionState transactionState = new TransactionState();
                    if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
                        transactionState.setTrace(DistributedTracing.getInstance().startTrace(transactionState));
                        Request distributedTraceHeaders = OkHttp3TransactionStateUtil.setDistributedTraceHeaders(transactionState, request);
                        callExtension = new CallExtension(okHttpClient, distributedTraceHeaders, (Call) method.invoke(internal, okHttpClient, distributedTraceHeaders), transactionState);
                    } else {
                        callExtension = new CallExtension(okHttpClient, request, (Call) method.invoke(internal, okHttpClient, request), transactionState);
                    }
                    return callExtension;
                }
                OkHttp3Instrumentation.logReflectionError("newWebSocketCall(Lokhttp3/OkHttpClient;Lokhttp3/Request;)Lokhttp3/Call;");
                return null;
            } catch (Exception e) {
                OkHttp3Instrumentation.log.error("OkHttp3Instrumentation: " + e.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logReflectionError(String str) {
        String property = System.getProperty("line.separator");
        log.error("Unable to resolve method \"" + str + "\"." + property + "This is usually due to building the app with unsupported OkHttp versions." + property + "Check your build configuration for compatibility.");
    }
}
