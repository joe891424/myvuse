package com.newrelic.agent.android.instrumentation.okhttp3;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes6.dex */
public class ResponseBuilderExtension extends Response.Builder {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private Response.Builder impl;

    public ResponseBuilderExtension(Response.Builder builder) {
        this.impl = builder;
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder request(Request request) {
        return this.impl.request(request);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder protocol(Protocol protocol) {
        return this.impl.protocol(protocol);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder code(int i) {
        return this.impl.code(i);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder message(String str) {
        return this.impl.message(str);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder handshake(Handshake handshake) {
        return this.impl.handshake(handshake);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder header(String str, String str2) {
        return this.impl.header(str, str2);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder addHeader(String str, String str2) {
        return this.impl.addHeader(str, str2);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder removeHeader(String str) {
        return this.impl.removeHeader(str);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder headers(Headers headers) {
        return this.impl.headers(headers);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder body(ResponseBody responseBody) {
        return this.impl.body(responseBody);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder networkResponse(Response response) {
        return this.impl.networkResponse(response);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder cacheResponse(Response response) {
        return this.impl.cacheResponse(response);
    }

    @Override // okhttp3.Response.Builder
    public Response.Builder priorResponse(Response response) {
        return this.impl.priorResponse(response);
    }

    @Override // okhttp3.Response.Builder
    public Response build() {
        return this.impl.build();
    }
}
