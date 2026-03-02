package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes6.dex */
public class ResponseBuilderExtension extends Response.Builder {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private Response.Builder impl;

    public ResponseBuilderExtension(Response.Builder builder) {
        this.impl = builder;
    }

    public Response.Builder request(Request request) {
        return this.impl.request(request);
    }

    public Response.Builder protocol(Protocol protocol) {
        return this.impl.protocol(protocol);
    }

    public Response.Builder code(int i) {
        return this.impl.code(i);
    }

    public Response.Builder message(String str) {
        return this.impl.message(str);
    }

    public Response.Builder handshake(Handshake handshake) {
        return this.impl.handshake(handshake);
    }

    public Response.Builder header(String str, String str2) {
        return this.impl.header(str, str2);
    }

    public Response.Builder addHeader(String str, String str2) {
        return this.impl.addHeader(str, str2);
    }

    public Response.Builder removeHeader(String str) {
        return this.impl.removeHeader(str);
    }

    public Response.Builder headers(Headers headers) {
        return this.impl.headers(headers);
    }

    public Response.Builder body(ResponseBody responseBody) {
        BufferedSource bufferedSourceSource;
        if (responseBody != null) {
            try {
                if (!responseBody.getClass().getName().equalsIgnoreCase("com.squareup.okhttp.Cache$CacheResponseBody") && (bufferedSourceSource = responseBody.source()) != null) {
                    Buffer buffer = new Buffer();
                    bufferedSourceSource.readAll(buffer);
                    return this.impl.body(new PrebufferedResponseBody(responseBody, buffer));
                }
            } catch (IOException e) {
                log.error("IOException reading from source: ", e);
            } catch (IllegalStateException unused) {
            }
        }
        return this.impl.body(responseBody);
    }

    public Response.Builder networkResponse(Response response) {
        return this.impl.networkResponse(response);
    }

    public Response.Builder cacheResponse(Response response) {
        return this.impl.cacheResponse(response);
    }

    public Response.Builder priorResponse(Response response) {
        return this.impl.priorResponse(response);
    }

    public Response build() {
        return this.impl.build();
    }
}
