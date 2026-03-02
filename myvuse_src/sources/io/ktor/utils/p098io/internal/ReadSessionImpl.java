package io.ktor.utils.p098io.internal;

import io.ktor.utils.p098io.ByteBufferChannel;
import io.ktor.utils.p098io.SuspendableReadSession;
import io.ktor.utils.p098io.core.IoBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ReadSessionImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m5598d2 = {"Lio/ktor/utils/io/internal/ReadSessionImpl;", "Lio/ktor/utils/io/SuspendableReadSession;", "channel", "Lio/ktor/utils/io/ByteBufferChannel;", "(Lio/ktor/utils/io/ByteBufferChannel;)V", "availableForRead", "", "getAvailableForRead", "()I", "lastAvailable", "lastView", "Lio/ktor/utils/io/core/IoBuffer;", "await", "", "atLeast", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completed", "", "newView", "discard", RsaJsonWebKey.MODULUS_MEMBER_NAME, "request", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ReadSessionImpl implements SuspendableReadSession {
    private final ByteBufferChannel channel;
    private int lastAvailable;
    private IoBuffer lastView;

    public ReadSessionImpl(ByteBufferChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.lastView = IoBuffer.INSTANCE.getEmpty();
    }

    public final void completed() {
        completed(IoBuffer.INSTANCE.getEmpty());
    }

    private final void completed(IoBuffer newView) {
        int i = this.lastAvailable;
        IoBuffer ioBuffer = this.lastView;
        int writePosition = i - (ioBuffer.getWritePosition() - ioBuffer.getReadPosition());
        if (writePosition > 0) {
            this.channel.mo7224consumed(writePosition);
        }
        this.lastView = newView;
        IoBuffer ioBuffer2 = newView;
        this.lastAvailable = ioBuffer2.getWritePosition() - ioBuffer2.getReadPosition();
    }

    @Override // io.ktor.utils.p098io.ReadSession
    public int getAvailableForRead() {
        return this.channel.getAvailableForRead();
    }

    @Override // io.ktor.utils.p098io.ReadSession
    public int discard(int n) {
        completed();
        int iMin = Math.min(getAvailableForRead(), n);
        this.channel.mo7224consumed(iMin);
        return iMin;
    }

    @Override // io.ktor.utils.p098io.ReadSession
    public IoBuffer request(int atLeast) {
        ByteBuffer byteBufferRequest = this.channel.request(0, atLeast);
        if (byteBufferRequest == null) {
            return null;
        }
        IoBuffer ioBuffer = new IoBuffer(byteBufferRequest);
        ioBuffer.resetForRead();
        completed(ioBuffer);
        return ioBuffer;
    }

    @Override // io.ktor.utils.p098io.SuspendableReadSession
    public Object await(int i, Continuation<? super Boolean> continuation) {
        completed();
        return this.channel.awaitAtLeast(i, continuation);
    }
}
