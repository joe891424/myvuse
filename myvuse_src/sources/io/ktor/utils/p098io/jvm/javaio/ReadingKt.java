package io.ktor.utils.p098io.jvm.javaio;

import io.ktor.utils.p098io.ByteReadChannel;
import io.ktor.utils.p098io.ByteWriteChannel;
import io.ktor.utils.p098io.CoroutinesKt;
import io.ktor.utils.p098io.WriterScope;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import io.ktor.utils.p098io.pool.ByteArrayPoolKt;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: Reading.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a$\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007\u001a+\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\fH\u0007¢\u0006\u0002\b\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m5598d2 = {"copyTo", "", "Ljava/io/InputStream;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Ljava/io/InputStream;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toByteReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "", "toByteReadChannelWithArrayPool", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ReadingKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.ReadingKt$copyTo$1 */
    /* JADX INFO: compiled from: Reading.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.jvm.javaio.ReadingKt", m5608f = "Reading.kt", m5609i = {0, 0, 0, 0, 0, 0, 0}, m5610l = {28}, m5611m = "copyTo", m5612n = {"$this$copyTo", "channel", "buffer", "limit", "copied", "bufferSize", "rc"}, m5613s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "I$0"})
    static final class C53471 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C53471(Continuation<? super C53471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadingKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007c A[Catch: all -> 0x004a, TryCatch #0 {all -> 0x004a, blocks: (B:12:0x003d, B:35:0x00ad, B:27:0x007c, B:31:0x008d, B:36:0x00b8, B:24:0x006e), top: B:43:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[LOOP:0: B:25:0x0078->B:49:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a4 -> B:35:0x00ad). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(java.io.InputStream r18, io.ktor.utils.p098io.ByteWriteChannel r19, long r20, kotlin.coroutines.Continuation<? super java.lang.Long> r22) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.jvm.javaio.ReadingKt.copyTo(java.io.InputStream, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(InputStream inputStream, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(inputStream, byteWriteChannel, j, continuation);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        return toByteReadChannel(inputStream, coroutineContext, objectPool);
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1 */
    /* JADX INFO: compiled from: Reading.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1", m5608f = "Reading.kt", m5609i = {0, 0}, m5610l = {60}, m5611m = "invokeSuspend", m5612n = {"$this$writer", "buffer"}, m5613s = {"L$0", "L$1"})
    static final class C53481 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        final /* synthetic */ InputStream $this_toByteReadChannel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C53481(ObjectPool<ByteBuffer> objectPool, InputStream inputStream, Continuation<? super C53481> continuation) {
            super(2, continuation);
            this.$pool = objectPool;
            this.$this_toByteReadChannel = inputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C53481 c53481 = new C53481(this.$pool, this.$this_toByteReadChannel, continuation);
            c53481.L$0 = obj;
            return c53481;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((C53481) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            ByteBuffer byteBufferBorrow;
            WriterScope writerScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WriterScope writerScope2 = (WriterScope) this.L$0;
                byteBufferBorrow = this.$pool.borrow();
                writerScope = writerScope2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteBufferBorrow = (ByteBuffer) this.L$1;
                writerScope = (WriterScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } finally {
                    try {
                    } catch (Throwable th) {
                    }
                }
            }
            while (true) {
                int i2 = this.$this_toByteReadChannel.read(byteBufferBorrow.array(), byteBufferBorrow.arrayOffset() + byteBufferBorrow.position(), byteBufferBorrow.remaining());
                if (i2 < 0) {
                    break;
                }
                if (i2 != 0) {
                    this.L$0 = writerScope;
                    this.L$1 = byteBufferBorrow;
                    this.label = 1;
                    if (writerScope.getChannel().writeFully(byteBufferBorrow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            this.$pool.recycle(byteBufferBorrow);
            this.$this_toByteReadChannel.close();
            return Unit.INSTANCE;
        }
    }

    @ExperimentalIoApi
    public static final ByteReadChannel toByteReadChannel(InputStream inputStream, CoroutineContext context, ObjectPool<ByteBuffer> pool) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pool, "pool");
        return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, context, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new C53481(pool, inputStream, null)).getChannel();
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannelWithArrayPool$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        if ((i & 2) != 0) {
            objectPool = ByteArrayPoolKt.getByteArrayPool();
        }
        return toByteReadChannelWithArrayPool(inputStream, coroutineContext, objectPool);
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2 */
    /* JADX INFO: compiled from: Reading.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2", m5608f = "Reading.kt", m5609i = {0, 0}, m5610l = {89}, m5611m = "invokeSuspend", m5612n = {"$this$writer", "buffer"}, m5613s = {"L$0", "L$1"})
    static final class C53492 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ObjectPool<byte[]> $pool;
        final /* synthetic */ InputStream $this_toByteReadChannel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C53492(ObjectPool<byte[]> objectPool, InputStream inputStream, Continuation<? super C53492> continuation) {
            super(2, continuation);
            this.$pool = objectPool;
            this.$this_toByteReadChannel = inputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C53492 c53492 = new C53492(this.$pool, this.$this_toByteReadChannel, continuation);
            c53492.L$0 = obj;
            return c53492;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((C53492) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            byte[] bArrBorrow;
            WriterScope writerScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WriterScope writerScope2 = (WriterScope) this.L$0;
                bArrBorrow = this.$pool.borrow();
                writerScope = writerScope2;
            } else if (i == 1) {
                bArrBorrow = (byte[]) this.L$1;
                writerScope = (WriterScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    try {
                        writerScope.getChannel().close(th);
                        this.$pool.recycle(bArrBorrow);
                    } catch (Throwable th2) {
                        this.$pool.recycle(bArrBorrow);
                        this.$this_toByteReadChannel.close();
                        throw th2;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (true) {
                int i2 = this.$this_toByteReadChannel.read(bArrBorrow, 0, bArrBorrow.length);
                if (i2 < 0) {
                    this.$pool.recycle(bArrBorrow);
                    break;
                }
                if (i2 != 0) {
                    this.L$0 = writerScope;
                    this.L$1 = bArrBorrow;
                    this.label = 1;
                    if (writerScope.getChannel().writeFully(bArrBorrow, 0, i2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            this.$this_toByteReadChannel.close();
            return Unit.INSTANCE;
        }
    }

    @ExperimentalIoApi
    public static final ByteReadChannel toByteReadChannelWithArrayPool(InputStream inputStream, CoroutineContext context, ObjectPool<byte[]> pool) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pool, "pool");
        return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, context, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new C53492(pool, inputStream, null)).getChannel();
    }
}
