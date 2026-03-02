package com.newrelic.agent.android.instrumentation.okhttp2;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes6.dex */
public class PrebufferedResponseBody extends ResponseBody {
    ResponseBody impl;
    private BufferedSource source;

    public PrebufferedResponseBody(ResponseBody responseBody, BufferedSource bufferedSource) {
        this.impl = responseBody;
        this.source = bufferedSource;
    }

    public MediaType contentType() {
        return this.impl.contentType();
    }

    public long contentLength() {
        try {
            long jContentLength = this.impl.contentLength();
            return ((int) jContentLength) != 0 ? jContentLength : this.source.getBufferField().size();
        } catch (IOException unused) {
            return this.source.getBufferField().size();
        }
    }

    public BufferedSource source() {
        return this.source;
    }

    public void close() throws IOException {
        this.impl.close();
    }
}
