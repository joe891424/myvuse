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
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.AbstractHttpMessage;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class HttpResponseEntityImpl implements HttpEntity, StreamCompleteListener {
    private static final String ENCODING_CHUNKED = "chunked";
    private static final String TRANSFER_ENCODING_HEADER = "Transfer-Encoding";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final long contentLengthFromHeader;
    private CountingInputStream contentStream;
    private final HttpEntity impl;
    private final TransactionState transactionState;

    public HttpResponseEntityImpl(HttpEntity httpEntity, TransactionState transactionState, long j) {
        this.impl = httpEntity;
        this.transactionState = transactionState;
        this.contentLengthFromHeader = j;
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
        CountingInputStream countingInputStream = this.contentStream;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        try {
            Object obj = this.impl;
            boolean zIsChunked = true;
            if (obj instanceof AbstractHttpMessage) {
                Header lastHeader = ((AbstractHttpMessage) obj).getLastHeader("Transfer-Encoding");
                if (lastHeader != null && ENCODING_CHUNKED.equalsIgnoreCase(lastHeader.getValue())) {
                    zIsChunked = false;
                }
            } else if (obj instanceof HttpEntityWrapper) {
                zIsChunked = true ^ ((HttpEntityWrapper) obj).isChunked();
            }
            try {
                CountingInputStream countingInputStream2 = new CountingInputStream(this.impl.getContent(), zIsChunked);
                this.contentStream = countingInputStream2;
                countingInputStream2.addStreamCompleteListener(this);
            } catch (IllegalArgumentException e) {
                log.error("HttpResponseEntityImpl: " + e.toString());
            }
            return this.contentStream;
        } catch (IOException e2) {
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
        if (!this.transactionState.isComplete()) {
            CountingOutputStream countingOutputStream = null;
            try {
                CountingOutputStream countingOutputStream2 = new CountingOutputStream(outputStream);
                try {
                    this.impl.writeTo(countingOutputStream2);
                    if (this.transactionState.isComplete()) {
                        return;
                    }
                    long j = this.contentLengthFromHeader;
                    if (j >= 0) {
                        this.transactionState.setBytesReceived(j);
                    } else {
                        this.transactionState.setBytesReceived(countingOutputStream2.getCount());
                    }
                    addTransactionAndErrorData(this.transactionState);
                } catch (IOException e) {
                    e = e;
                    countingOutputStream = countingOutputStream2;
                    if (countingOutputStream != null) {
                        handleException(e, Long.valueOf(countingOutputStream.getCount()));
                    }
                    throw e;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } else {
            this.impl.writeTo(outputStream);
        }
    }

    @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener
    public void streamComplete(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        if (this.transactionState.isComplete()) {
            return;
        }
        long j = this.contentLengthFromHeader;
        if (j >= 0) {
            this.transactionState.setBytesReceived(j);
        } else {
            this.transactionState.setBytesReceived(streamCompleteEvent.getBytes());
        }
        addTransactionAndErrorData(this.transactionState);
    }

    @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListener
    public void streamError(StreamCompleteEvent streamCompleteEvent) {
        ((StreamCompleteListenerSource) streamCompleteEvent.getSource()).removeStreamCompleteListener(this);
        TransactionStateUtil.setErrorCodeFromException(this.transactionState, streamCompleteEvent.getException());
        if (this.transactionState.isComplete()) {
            return;
        }
        this.transactionState.setBytesReceived(streamCompleteEvent.getBytes());
    }

    private void addTransactionAndErrorData(TransactionState transactionState) {
        String bufferAsString;
        InputStream content;
        TransactionData transactionDataEnd = transactionState.end();
        if (transactionDataEnd == null) {
            return;
        }
        if (transactionState.isErrorOrFailure()) {
            try {
                content = getContent();
            } catch (Exception e) {
                log.error("HttpResponseEntityImpl: " + String.valueOf(e));
            }
            if (!(content instanceof CountingInputStream)) {
                bufferAsString = "";
            } else {
                bufferAsString = ((CountingInputStream) content).getBufferAsString();
            }
            Header contentType = this.impl.getContentType();
            TreeMap treeMap = new TreeMap();
            if (contentType != null && contentType.getValue() != null && !"".equals(contentType.getValue())) {
                treeMap.put("content_type", contentType.getValue());
            }
            treeMap.put(Constants.Transactions.CONTENT_LENGTH, new StringBuilder().append(transactionState.getBytesReceived()).toString());
            transactionDataEnd.setResponseBody(bufferAsString);
            transactionDataEnd.setParams(treeMap);
        }
        TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
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
            this.transactionState.setBytesReceived(l.longValue());
        }
        TransactionData transactionDataEnd = this.transactionState.end();
        if (transactionDataEnd != null) {
            transactionDataEnd.setResponseBody(exc.toString());
            TaskQueue.queue(new HttpTransactionMeasurement(transactionDataEnd));
        }
    }
}
