package com.qualtrics.digital;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Okio;

/* JADX INFO: loaded from: classes6.dex */
public class RequestInterceptor implements Interceptor {
    public static final String CONTENT_LENGTH = "content-length";
    public static final String CONTENT_TYPE = "content-type";
    public static final String LOG_TAG = "Qualtrics";

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        IQualtricsRequestInterceptor requestHandler = RequestInterceptorProvider.getInstance().getRequestHandler();
        Request request = chain.request();
        if (requestHandler == null) {
            return chain.proceed(request);
        }
        WebResourceResponse webResourceResponseHandleRequest = requestHandler.handleRequest(createWebResourceRequest(request), request.body() != null ? request.body().toString() : null);
        if (webResourceResponseHandleRequest == null) {
            QualtricsLog.logError("null response returned from IQualtricsRequestInterceptor.");
            return createEmptyOkResponse(request);
        }
        return createOkhttpResponse(request, webResourceResponseHandleRequest);
    }

    private WebResourceRequest createWebResourceRequest(final Request request) {
        return new WebResourceRequest() { // from class: com.qualtrics.digital.RequestInterceptor.1
            @Override // android.webkit.WebResourceRequest
            public boolean hasGesture() {
                return false;
            }

            @Override // android.webkit.WebResourceRequest
            public boolean isForMainFrame() {
                return false;
            }

            @Override // android.webkit.WebResourceRequest
            public boolean isRedirect() {
                return false;
            }

            @Override // android.webkit.WebResourceRequest
            public Uri getUrl() {
                return Uri.parse(request.url().uri().toString());
            }

            @Override // android.webkit.WebResourceRequest
            public String getMethod() {
                return request.method();
            }

            @Override // android.webkit.WebResourceRequest
            public Map<String, String> getRequestHeaders() {
                HashMap map = new HashMap();
                for (String str : request.headers().names()) {
                    map.put(str, request.header(str));
                }
                if (request.body() != null && !map.containsKey(RequestInterceptor.CONTENT_TYPE) && request.body().getContentType() != null) {
                    map.put(RequestInterceptor.CONTENT_TYPE, request.body().getContentType().getMediaType());
                }
                return map;
            }
        };
    }

    private Response createOkhttpResponse(Request request, WebResourceResponse webResourceResponse) {
        Response.Builder builderCode = new Response.Builder().request(request).protocol(Protocol.HTTP_2).message(webResourceResponse.getReasonPhrase()).code(webResourceResponse.getStatusCode());
        for (Map.Entry<String, String> entry : webResourceResponse.getResponseHeaders().entrySet()) {
            builderCode.addHeader(entry.getKey(), entry.getValue());
        }
        ResponseBody responseBodyCreateOkResponseBody = createOkResponseBody(webResourceResponse);
        if (builderCode instanceof Response.Builder) {
            OkHttp3Instrumentation.body(builderCode, responseBodyCreateOkResponseBody);
        } else {
            builderCode.body(responseBodyCreateOkResponseBody);
        }
        return builderCode.build();
    }

    private ResponseBody createOkResponseBody(WebResourceResponse webResourceResponse) {
        InputStream data = webResourceResponse.getData();
        String mimeType = webResourceResponse.getMimeType();
        String value = null;
        for (Map.Entry<String, String> entry : webResourceResponse.getResponseHeaders().entrySet()) {
            if (entry.getKey().toLowerCase().equals(CONTENT_LENGTH)) {
                value = entry.getValue();
            }
            if (mimeType == null && entry.getKey().toLowerCase().equals(CONTENT_TYPE)) {
                mimeType = entry.getValue();
            }
        }
        if (data != null) {
            return ResponseBody.create(mimeType != null ? MediaType.parse(mimeType) : null, value != null ? Integer.parseInt(value) : 0L, Okio.buffer(Okio.source(data)));
        }
        return null;
    }

    private Response createEmptyOkResponse(Request request) {
        Response.Builder builderCode = new Response.Builder().request(request).protocol(Protocol.HTTP_2).message("").code(500);
        ResponseBody responseBodyCreate = ResponseBody.create((MediaType) null, 0L, Okio.buffer(Okio.source(new ByteArrayInputStream(new byte[0]))));
        return (!(builderCode instanceof Response.Builder) ? builderCode.body(responseBodyCreate) : OkHttp3Instrumentation.body(builderCode, responseBodyCreate)).build();
    }
}
