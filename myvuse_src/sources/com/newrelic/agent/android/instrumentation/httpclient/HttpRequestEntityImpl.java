package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.p045io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.p045io.CountingOutputStream;
import com.newrelic.agent.android.instrumentation.p045io.StreamCompleteEvent;
import com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener;
import com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListenerSource;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class HttpRequestEntityImpl implements HttpEntity, StreamCompleteListener {
    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpRequestEntityImpl(HttpEntity httpEntity, TransactionState transactionState) {
        this.impl = httpEntity;
        this.transactionState = transactionState;
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws IOException {
        try {
            this.impl.consumeContent();
        } catch (IOException e) {
            handleException(e);
            throw e;
        }
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IllegalStateException, IOException {
        try {
            if (!this.transactionState.isSent()) {
                CountingInputStream countingInputStream = new CountingInputStream(this.impl.getContent());
                countingInputStream.addStreamCompleteListener(this);
                return countingInputStream;
            }
            return this.impl.getContent();
        } catch (IOException e) {
            handleException(e);
            throw e;
        } catch (IllegalStateException e2) {
            handleException(e2);
            throw e2;
        }
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
        try {
            if (!this.transactionState.isSent()) {
                CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
                this.impl.writeTo(countingOutputStream);
                this.transactionState.setBytesSent(countingOutputStream.getCount());
                return;
            }
            this.impl.writeTo(outputStream);
        } catch (IOException e) {
            handleException(e);
            throw e;
        }
    }

    @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener
    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        this.transactionState.setBytesSent(streamCompleteEvent.getBytes());
    }

    @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener
    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        handleException(streamCompleteEvent.getException(), Long.valueOf(streamCompleteEvent.getBytes()));
    }

    protected void handleException(Exception exc) {
        handleException(exc, null);
    }

    protected void handleException(Exception exc, Long l) {
        TransactionStateUtil.setErrorCodeFromException(this.transactionState, exc);
        if (this.transactionState.isComplete()) {
            return;
        }
        if (l != null) {
            this.transactionState.setBytesSent(l.longValue());
        }
        TransactionData transactionDataEnd = this.transactionState.end();
        if (transactionDataEnd != null) {
            transactionDataEnd.setResponseBody(exc.toString());
            TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
        }
    }
}
