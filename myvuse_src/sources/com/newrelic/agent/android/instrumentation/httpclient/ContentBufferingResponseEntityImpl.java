package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.instrumentation.p045io.CountingInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class ContentBufferingResponseEntityImpl implements HttpEntity {
    private CountingInputStream contentStream;
    final HttpEntity impl;

    public ContentBufferingResponseEntityImpl(HttpEntity httpEntity) {
        if (httpEntity == null) {
            throw new IllegalArgumentException("Missing wrapped entity");
        }
        this.impl = httpEntity;
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws IOException {
        this.impl.consumeContent();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IllegalStateException, IOException {
        CountingInputStream countingInputStream = this.contentStream;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        CountingInputStream countingInputStream2 = new CountingInputStream(this.impl.getContent(), true);
        this.contentStream = countingInputStream2;
        return countingInputStream2;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.impl.getContentEncoding();
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.impl.getContentLength();
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.impl.getContentType();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.impl.isChunked();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.impl.isRepeatable();
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.impl.isStreaming();
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        this.impl.writeTo(outputStream);
    }
}
