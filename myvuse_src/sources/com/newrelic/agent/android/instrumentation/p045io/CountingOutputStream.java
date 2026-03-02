package com.newrelic.agent.android.instrumentation.p045io;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final OutputStream impl;
    private long count = 0;
    private final StreamCompleteListenerManager listenerManager = new StreamCompleteListenerManager();

    public CountingOutputStream(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IOException("CountingOutputStream: output stream cannot be null");
        }
        this.impl = outputStream;
    }

    @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.addStreamCompleteListener(streamCompleteListener);
    }

    @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.removeStreamCompleteListener(streamCompleteListener);
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.impl.write(i);
            this.count++;
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.impl.write(bArr);
            this.count += (long) bArr.length;
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.impl.write(bArr, i, i2);
            this.count += (long) i2;
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.impl.flush();
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.impl.close();
            notifyStreamComplete();
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        } catch (Exception e2) {
            log.warn(e2.toString());
        }
    }

    private void notifyStreamComplete() {
        if (this.listenerManager.isComplete()) {
            return;
        }
        this.listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, this.count));
    }

    private void notifyStreamError(Exception exc) {
        if (this.listenerManager.isComplete()) {
            return;
        }
        this.listenerManager.notifyStreamError(new StreamCompleteEvent(this, this.count, exc));
    }
}
