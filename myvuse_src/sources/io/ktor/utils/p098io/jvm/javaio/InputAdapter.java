package io.ktor.utils.p098io.jvm.javaio;

import io.ktor.utils.p098io.ByteReadChannel;
import io.ktor.utils.p098io.ByteReadChannelKt;
import java.io.InputStream;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\"\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m5598d2 = {"Lio/ktor/utils/io/jvm/javaio/InputAdapter;", "Ljava/io/InputStream;", "parent", "Lkotlinx/coroutines/Job;", "channel", "Lio/ktor/utils/io/ByteReadChannel;", "(Lkotlinx/coroutines/Job;Lio/ktor/utils/io/ByteReadChannel;)V", "context", "Lkotlinx/coroutines/CompletableJob;", "loop", "io/ktor/utils/io/jvm/javaio/InputAdapter$loop$1", "Lio/ktor/utils/io/jvm/javaio/InputAdapter$loop$1;", "single", "", "available", "", "close", "", "read", "b", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
final class InputAdapter extends InputStream {
    private final ByteReadChannel channel;
    private final CompletableJob context;
    private final InputAdapter$loop$1 loop;
    private byte[] single;

    public InputAdapter(Job job, ByteReadChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        BlockingKt.ensureParkingAllowed();
        this.context = JobKt.Job(job);
        this.loop = new InputAdapter$loop$1(this, job);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.channel.getAvailableForRead();
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.single;
        if (bArr == null) {
            bArr = new byte[1];
            this.single = bArr;
        }
        int iSubmitAndAwait = this.loop.submitAndAwait(bArr, 0, 1);
        if (iSubmitAndAwait == -1) {
            return -1;
        }
        if (iSubmitAndAwait != 1) {
            throw new IllegalStateException(Intrinsics.stringPlus("rc should be 1 or -1 but got ", Integer.valueOf(iSubmitAndAwait)).toString());
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b, int off, int len) {
        InputAdapter$loop$1 inputAdapter$loop$1;
        inputAdapter$loop$1 = this.loop;
        Intrinsics.checkNotNull(b);
        return inputAdapter$loop$1.submitAndAwait(b, off, len);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
        ByteReadChannelKt.cancel(this.channel);
        if (!this.context.isCompleted()) {
            Job.DefaultImpls.cancel$default((Job) this.context, (CancellationException) null, 1, (Object) null);
        }
        this.loop.shutdown();
    }
}
