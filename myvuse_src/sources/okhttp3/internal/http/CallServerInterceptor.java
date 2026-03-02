package okhttp3.internal.http;

import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: compiled from: CallServerInterceptor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m5598d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", "code", "", "okhttp"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    private final boolean shouldIgnoreAndWaitForRealResponse(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [okhttp3.Response] */
    /* JADX WARN: Type inference failed for: r10v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22, types: [okhttp3.Response$Builder] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Object, okhttp3.Response$Builder] */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v4, types: [okhttp3.Response$Builder] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, okhttp3.internal.connection.Exchange] */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        ?? PermitsRequestBody;
        ?? responseHeaders;
        Response.Builder builderBody;
        Response responseBuild;
        Response.Builder builderBody2;
        ?? r10;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        ?? exchange = realInterceptorChain.getExchange();
        Intrinsics.checkNotNull(exchange);
        Request request = realInterceptorChain.getRequest();
        RequestBody requestBodyBody = request.body();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            exchange.writeRequestHeaders(request);
            PermitsRequestBody = HttpMethod.permitsRequestBody(request.method());
            try {
                if (PermitsRequestBody != 0 && requestBodyBody != null) {
                    if (StringsKt.equals("100-continue", request.header(com.google.common.net.HttpHeaders.EXPECT), true)) {
                        exchange.flushRequest();
                        PermitsRequestBody = exchange.readResponseHeaders(true);
                        try {
                            exchange.responseHeadersStart();
                            z = false;
                            r10 = PermitsRequestBody;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (e instanceof ConnectionShutdownException) {
                                throw e;
                            }
                            responseHeaders = PermitsRequestBody;
                            if (!exchange.getHasFailure()) {
                                throw e;
                            }
                        }
                    } else {
                        z = true;
                        r10 = 0;
                    }
                    if (r10 == 0) {
                        if (requestBodyBody.isDuplex()) {
                            exchange.flushRequest();
                            requestBodyBody.writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
                            PermitsRequestBody = r10;
                        } else {
                            BufferedSink bufferedSinkBuffer = Okio.buffer(exchange.createRequestBody(request, false));
                            requestBodyBody.writeTo(bufferedSinkBuffer);
                            bufferedSinkBuffer.close();
                            PermitsRequestBody = r10;
                        }
                    } else {
                        exchange.noRequestBody();
                        PermitsRequestBody = r10;
                        if (!exchange.getConnection().isMultiplexed$okhttp()) {
                            exchange.noNewExchangesOnConnection();
                            PermitsRequestBody = r10;
                        }
                    }
                } else {
                    exchange.noRequestBody();
                    z = true;
                    PermitsRequestBody = 0;
                }
                if (requestBodyBody == null || !requestBodyBody.isDuplex()) {
                    exchange.finishRequest();
                }
                e = null;
                responseHeaders = PermitsRequestBody;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            z = true;
            PermitsRequestBody = 0;
        }
        if (responseHeaders == 0) {
            try {
                responseHeaders = exchange.readResponseHeaders(false);
                Intrinsics.checkNotNull(responseHeaders);
                if (z) {
                    exchange.responseHeadersStart();
                    z = false;
                }
            } catch (IOException e4) {
                if (e != null) {
                    ExceptionsKt.addSuppressed(e, e4);
                    throw e;
                }
                throw e4;
            }
        }
        Response responseBuild2 = responseHeaders.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int iCode = responseBuild2.code();
        ?? r102 = responseBuild2;
        if (shouldIgnoreAndWaitForRealResponse(iCode)) {
            Response.Builder responseHeaders2 = exchange.readResponseHeaders(false);
            Intrinsics.checkNotNull(responseHeaders2);
            if (z) {
                exchange.responseHeadersStart();
            }
            Response responseBuild3 = responseHeaders2.request(request).handshake(exchange.getConnection().getHandshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            iCode = responseBuild3.code();
            r102 = responseBuild3;
        }
        exchange.responseHeadersEnd(r102);
        if (this.forWebSocket && iCode == 101) {
            Response.Builder builderNewBuilder = !(r102 instanceof Response.Builder) ? r102.newBuilder() : OkHttp3Instrumentation.newBuilder((Response.Builder) r102);
            ResponseBody responseBody = Util.EMPTY_RESPONSE;
            if (builderNewBuilder instanceof Response.Builder) {
                Response.Builder builder = builderNewBuilder;
                builderBody2 = OkHttp3Instrumentation.body(builderNewBuilder, responseBody);
            } else {
                builderBody2 = builderNewBuilder.body(responseBody);
            }
            responseBuild = builderBody2.build();
        } else {
            Response.Builder builderNewBuilder2 = !(r102 instanceof Response.Builder) ? r102.newBuilder() : OkHttp3Instrumentation.newBuilder((Response.Builder) r102);
            ResponseBody responseBodyOpenResponseBody = exchange.openResponseBody(r102);
            if (builderNewBuilder2 instanceof Response.Builder) {
                Response.Builder builder2 = builderNewBuilder2;
                builderBody = OkHttp3Instrumentation.body(builderNewBuilder2, responseBodyOpenResponseBody);
            } else {
                builderBody = builderNewBuilder2.body(responseBodyOpenResponseBody);
            }
            responseBuild = builderBody.build();
        }
        if (StringsKt.equals("close", responseBuild.request().header(com.google.common.net.HttpHeaders.CONNECTION), true) || StringsKt.equals("close", Response.header$default(responseBuild, com.google.common.net.HttpHeaders.CONNECTION, null, 2, null), true)) {
            exchange.noNewExchangesOnConnection();
        }
        if (iCode == 204 || iCode == 205) {
            ResponseBody responseBodyBody = responseBuild.body();
            if ((responseBodyBody != null ? responseBodyBody.getContentLength() : -1L) > 0) {
                StringBuilder sbAppend = new StringBuilder("HTTP ").append(iCode).append(" had non-zero Content-Length: ");
                ResponseBody responseBodyBody2 = responseBuild.body();
                throw new ProtocolException(sbAppend.append(responseBodyBody2 != null ? Long.valueOf(responseBodyBody2.getContentLength()) : null).toString());
            }
        }
        return responseBuild;
    }
}
