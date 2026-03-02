package com.newrelic.agent.android.instrumentation.okhttp3;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes6.dex */
public class PrebufferedResponseBody extends ResponseBody {
    private final long contentLength;
    private final ResponseBody impl;
    private final BufferedSource source;

    public PrebufferedResponseBody(ResponseBody responseBody) {
        BufferedSource source = responseBody.getSource();
        if (responseBody.getContentLength() == -1) {
            Buffer buffer = new Buffer();
            try {
                source.readAll(buffer);
                source = buffer;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.impl = responseBody;
        this.source = source;
        this.contentLength = responseBody.getContentLength() >= 0 ? responseBody.getContentLength() : source.getBufferField().size();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.impl.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentLength */
    public long getContentLength() {
        long contentLength = this.impl.getContentLength();
        return ((int) contentLength) != 0 ? contentLength : this.source.getBufferField().size();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: source */
    public BufferedSource getSource() {
        return this.source;
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.impl.close();
    }
}
