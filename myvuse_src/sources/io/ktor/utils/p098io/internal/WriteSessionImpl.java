package io.ktor.utils.p098io.internal;

import io.ktor.utils.p098io.ByteBufferChannel;
import io.ktor.utils.p098io.WriterSuspendSession;
import io.ktor.utils.p098io.core.IoBuffer;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: WriteSessionImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0001\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0019\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m5598d2 = {"Lio/ktor/utils/io/internal/WriteSessionImpl;", "Lio/ktor/utils/io/WriterSuspendSession;", "channel", "Lio/ktor/utils/io/ByteBufferChannel;", "(Lio/ktor/utils/io/ByteBufferChannel;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "current", "locked", "", "ringBufferCapacity", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "view", "Lio/ktor/utils/io/core/IoBuffer;", "begin", "", "complete", "flush", "request", "min", "tryAwait", RsaJsonWebKey.MODULUS_MEMBER_NAME, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitJoinSwitch", "written", "writtenFailed", "", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class WriteSessionImpl implements WriterSuspendSession {
    private ByteBuffer byteBuffer;
    private ByteBufferChannel current;
    private int locked;
    private RingBufferCapacity ringBufferCapacity;
    private IoBuffer view;

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 */
    /* JADX INFO: compiled from: WriteSessionImpl.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.internal.WriteSessionImpl", m5608f = "WriteSessionImpl.kt", m5609i = {0}, m5610l = {86}, m5611m = "tryAwaitJoinSwitch", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C53461 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53461(Continuation<? super C53461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriteSessionImpl.this.tryAwaitJoinSwitch(0, this);
        }
    }

    public WriteSessionImpl(ByteBufferChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.current = channel.resolveChannelInstance$ktor_io();
        this.byteBuffer = IoBuffer.INSTANCE.getEmpty().getMemory();
        this.view = IoBuffer.INSTANCE.getEmpty();
        this.ringBufferCapacity = this.current.currentState$ktor_io().capacity;
    }

    public final void begin() {
        ByteBufferChannel byteBufferChannelResolveChannelInstance$ktor_io = this.current.resolveChannelInstance$ktor_io();
        this.current = byteBufferChannelResolveChannelInstance$ktor_io;
        ByteBuffer byteBuffer = byteBufferChannelResolveChannelInstance$ktor_io.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return;
        }
        this.byteBuffer = byteBuffer;
        IoBuffer ioBuffer = new IoBuffer(this.current.currentState$ktor_io().backingBuffer);
        this.view = ioBuffer;
        ioBuffer.resetFromContentToWrite(this.byteBuffer);
        this.ringBufferCapacity = this.current.currentState$ktor_io().capacity;
    }

    public final void complete() {
        int i = this.locked;
        if (i > 0) {
            this.ringBufferCapacity.completeRead(i);
            this.locked = 0;
        }
        this.current.restoreStateAfterWrite$ktor_io();
        this.current.tryTerminate$ktor_io();
    }

    @Override // io.ktor.utils.p098io.WriterSession
    public IoBuffer request(int min) {
        int iTryWriteAtLeast = this.locked + this.ringBufferCapacity.tryWriteAtLeast(0);
        this.locked = iTryWriteAtLeast;
        if (iTryWriteAtLeast < min) {
            return null;
        }
        this.current.prepareWriteBuffer$ktor_io(this.byteBuffer, iTryWriteAtLeast);
        if (this.byteBuffer.remaining() < min) {
            return null;
        }
        this.view.resetFromContentToWrite(this.byteBuffer);
        return this.view;
    }

    @Override // io.ktor.utils.p098io.WriterSession
    public void written(int n) {
        int i;
        if (n < 0 || n > (i = this.locked)) {
            writtenFailed(n);
            throw new KotlinNothingValueException();
        }
        this.locked = i - n;
        this.current.bytesWrittenFromSession$ktor_io(this.byteBuffer, this.ringBufferCapacity, n);
    }

    private final Void writtenFailed(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Written bytes count shouldn't be negative: ", Integer.valueOf(n)));
        }
        throw new IllegalStateException("Unable to mark " + n + " bytes as written: only " + this.locked + " were pre-locked.");
    }

    @Override // io.ktor.utils.p098io.WriterSuspendSession
    public Object tryAwait(int i, Continuation<? super Unit> continuation) throws Throwable {
        if (this.current.getJoining() != null) {
            Object objTryAwaitJoinSwitch = tryAwaitJoinSwitch(i, continuation);
            return objTryAwaitJoinSwitch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTryAwaitJoinSwitch : Unit.INSTANCE;
        }
        int i2 = this.locked;
        if (i2 >= i) {
            return Unit.INSTANCE;
        }
        if (i2 > 0) {
            this.ringBufferCapacity.completeRead(i2);
            this.locked = 0;
        }
        Object objTryWriteSuspend$ktor_io = this.current.tryWriteSuspend$ktor_io(i, continuation);
        return objTryWriteSuspend$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTryWriteSuspend$ktor_io : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object tryAwaitJoinSwitch(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.p098io.internal.WriteSessionImpl.C53461
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = (io.ktor.utils.p098io.internal.WriteSessionImpl.C53461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = new io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.internal.WriteSessionImpl r5 = (io.ktor.utils.p098io.internal.WriteSessionImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L60
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r4.locked
            if (r6 <= 0) goto L45
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r4.ringBufferCapacity
            r2.completeRead(r6)
            r6 = 0
            r4.locked = r6
        L45:
            r4.flush()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.restoreStateAfterWrite$ktor_io()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.tryTerminate$ktor_io()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.tryWriteSuspend$ktor_io(r5, r0)
            if (r5 != r1) goto L5f
            return r1
        L5f:
            r5 = r4
        L60:
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.ByteBufferChannel r6 = r6.resolveChannelInstance$ktor_io()
            r5.current = r6
            java.nio.ByteBuffer r6 = r6.setupStateForWrite$ktor_io()
            if (r6 != 0) goto L6f
            goto L8f
        L6f:
            r5.byteBuffer = r6
            io.ktor.utils.io.core.IoBuffer r6 = new io.ktor.utils.io.core.IoBuffer
            io.ktor.utils.io.ByteBufferChannel r0 = r5.current
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r0.currentState$ktor_io()
            java.nio.ByteBuffer r0 = r0.backingBuffer
            r6.<init>(r0)
            r5.view = r6
            java.nio.ByteBuffer r0 = r5.byteBuffer
            r6.resetFromContentToWrite(r0)
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.currentState$ktor_io()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.capacity
            r5.ringBufferCapacity = r6
        L8f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.internal.WriteSessionImpl.tryAwaitJoinSwitch(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.WriterSession
    public void flush() {
        this.current.flush();
    }
}
