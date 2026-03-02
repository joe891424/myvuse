package com.newrelic.agent.android.instrumentation.p045io;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public class CountingInputStream extends InputStream implements StreamCompleteListenerSource {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private ByteBuffer buffer;
    private long count;
    private final boolean enableBuffering;
    private final InputStream impl;
    private final StreamCompleteListenerManager listenerManager;

    public CountingInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public CountingInputStream(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, z, 4096);
    }

    CountingInputStream(InputStream inputStream, boolean z, int i) throws IOException {
        this(inputStream, z ? ByteBuffer.allocate(i) : null);
    }

    CountingInputStream(InputStream inputStream, ByteBuffer byteBuffer) throws IOException {
        this.count = 0L;
        if (inputStream == null) {
            throw new IOException("CountingInputStream: input stream cannot be null");
        }
        this.impl = inputStream;
        this.buffer = byteBuffer;
        boolean z = byteBuffer != null;
        this.enableBuffering = z;
        this.listenerManager = new StreamCompleteListenerManager();
        if (z) {
            fillBuffer();
        }
    }

    @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.addStreamCompleteListener(streamCompleteListener);
    }

    @Override // com.newrelic.agent.android.instrumentation.p045io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.listenerManager.removeStreamCompleteListener(streamCompleteListener);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes(1L)) {
                    int buffer = readBuffer();
                    if (buffer >= 0) {
                        this.count++;
                    }
                    return buffer;
                }
            }
        }
        try {
            int i = this.impl.read();
            if (i >= 0) {
                this.count++;
            } else {
                notifyStreamComplete();
            }
            return i;
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int length = bArr.length;
        int bufferBytes = 0;
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes(length)) {
                    int bufferBytes2 = readBufferBytes(bArr);
                    if (bufferBytes2 >= 0) {
                        this.count += (long) bufferBytes2;
                        return bufferBytes2;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int iRemaining = this.buffer.remaining();
                if (iRemaining > 0) {
                    bufferBytes = readBufferBytes(bArr, 0, iRemaining);
                    if (bufferBytes < 0) {
                        throw new IOException("partial read from buffer failed");
                    }
                    length -= bufferBytes;
                    this.count += (long) bufferBytes;
                }
            }
        }
        try {
            int i = this.impl.read(bArr, bufferBytes, length);
            if (i >= 0) {
                this.count += (long) i;
                return i + bufferBytes;
            }
            if (bufferBytes > 0) {
                return bufferBytes;
            }
            notifyStreamComplete();
            return i;
        } catch (IOException e) {
            log.error(e.toString());
            System.out.println("NOTIFY STREAM ERROR: " + String.valueOf(e));
            e.printStackTrace();
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int bufferBytes = 0;
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes(i2)) {
                    int bufferBytes2 = readBufferBytes(bArr, i, i2);
                    if (bufferBytes2 >= 0) {
                        this.count += (long) bufferBytes2;
                        return bufferBytes2;
                    }
                    throw new IOException("readBufferBytes failed");
                }
                int iRemaining = this.buffer.remaining();
                if (iRemaining > 0) {
                    bufferBytes = readBufferBytes(bArr, i, iRemaining);
                    if (bufferBytes < 0) {
                        throw new IOException("partial read from buffer failed");
                    }
                    i2 -= bufferBytes;
                    this.count += (long) bufferBytes;
                }
            }
        }
        try {
            int i3 = this.impl.read(bArr, i + bufferBytes, i2);
            if (i3 >= 0) {
                this.count += (long) i3;
                return i3 + bufferBytes;
            }
            if (bufferBytes > 0) {
                return bufferBytes;
            }
            notifyStreamComplete();
            return i3;
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.enableBuffering) {
            synchronized (this.buffer) {
                if (bufferHasBytes(j)) {
                    this.count += j;
                    return j;
                }
                j -= (long) this.buffer.remaining();
                if (j > 0) {
                    ByteBuffer byteBuffer = this.buffer;
                } else {
                    throw new IOException("partial read from buffer (skip) failed");
                }
            }
        }
        try {
            long jSkip = this.impl.skip(j);
            this.count += jSkip;
            return jSkip;
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return (this.enableBuffering ? this.buffer.remaining() : 0) + this.impl.available();
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.impl.close();
            notifyStreamComplete();
        } catch (IOException e) {
            notifyStreamError(e);
            throw e;
        } catch (Exception e2) {
            log.error(e2.getLocalizedMessage());
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (markSupported()) {
            this.impl.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.impl.markSupported();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (markSupported()) {
            try {
                this.impl.reset();
            } catch (IOException e) {
                notifyStreamError(e);
                throw e;
            }
        }
    }

    private int readBuffer() {
        if (bufferEmpty()) {
            return -1;
        }
        return this.buffer.get();
    }

    private int readBufferBytes(byte[] bArr) {
        return readBufferBytes(bArr, 0, bArr.length);
    }

    private int readBufferBytes(byte[] bArr, int i, int i2) {
        if (bufferEmpty()) {
            return -1;
        }
        int iRemaining = this.buffer.remaining();
        this.buffer.get(bArr, i, i2);
        return iRemaining - this.buffer.remaining();
    }

    private boolean bufferHasBytes(long j) {
        return ((long) this.buffer.remaining()) >= j;
    }

    private boolean bufferEmpty() {
        return !this.buffer.hasRemaining();
    }

    public void fillBuffer() {
        int i;
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer == null || !byteBuffer.hasArray()) {
            return;
        }
        synchronized (this.buffer) {
            int i2 = 0;
            while (i2 < this.buffer.capacity() && (i = this.impl.read(this.buffer.array(), i2, this.buffer.capacity() - i2)) > 0) {
                try {
                    i2 += i;
                } catch (Exception e) {
                    log.error(e.getLocalizedMessage());
                } catch (NoSuchMethodError e2) {
                    log.error(e2.toString());
                    try {
                        this.buffer.limit(i2);
                    } catch (NoSuchMethodError e3) {
                        log.error(e3.toString());
                        try {
                            this.buffer = ByteBuffer.wrap(this.buffer.array(), 0, i2);
                        } catch (IndexOutOfBoundsException e4) {
                            log.error(e4.toString());
                        }
                    }
                }
            }
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

    public String getBufferAsString() {
        String str;
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            synchronized (byteBuffer) {
                byte[] bArr = new byte[this.buffer.limit()];
                for (int i = 0; i < this.buffer.limit(); i++) {
                    bArr[i] = this.buffer.get(i);
                }
                str = new String(bArr);
            }
            return str;
        }
        return "";
    }
}
