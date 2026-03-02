package io.ktor.utils.p098io.core.internal;

import androidx.concurrent.futures.C0526xc40028dd;
import io.ktor.utils.p098io.bits.DefaultAllocator;
import io.ktor.utils.p098io.concurrent.SharedJvmKt;
import io.ktor.utils.p098io.core.Buffer;
import io.ktor.utils.p098io.core.BufferFactoryKt;
import io.ktor.utils.p098io.core.IoBuffer;
import io.ktor.utils.p098io.pool.NoPoolImpl;
import io.ktor.utils.p098io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ChunkBuffer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0016\u0018\u0000 -2\u00020/:\u0001-B,\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u001a\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001c\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001b\u0010\nR(\u0010 \u001a\u0004\u0018\u00010\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u00008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u000eR/\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010!\u001a\u0004\u0018\u00010\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(R\u0011\u0010,\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, m5598d2 = {"Lio/ktor/utils/io/core/internal/ChunkBuffer;", "Lio/ktor/utils/io/bits/Memory;", "memory", "origin", "Lio/ktor/utils/io/pool/ObjectPool;", "parentPool", "<init>", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/pool/ObjectPool;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "acquire$ktor_io", "()V", "acquire", "chunk", "appendNext", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "cleanNext", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "duplicate", "", "release$ktor_io", "()Z", "release", "pool", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "reset", "unlink$ktor_io", "unlink", "unpark$ktor_io", "unpark", "newValue", "getNext", "setNext", "next", "<set-?>", "origin$delegate", "Lkotlin/properties/ReadWriteProperty;", "getOrigin", "setOrigin", "Lio/ktor/utils/io/pool/ObjectPool;", "getParentPool$ktor_io", "()Lio/ktor/utils/io/pool/ObjectPool;", "", "getReferenceCount", "()I", "referenceCount", "Companion", "ktor-io", "Lio/ktor/utils/io/core/Buffer;"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public class ChunkBuffer extends Buffer {
    private volatile /* synthetic */ Object nextRef;

    /* JADX INFO: renamed from: origin$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty origin;
    private final ObjectPool<ChunkBuffer> parentPool;
    private volatile /* synthetic */ int refCount;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ChunkBuffer.class, "origin", "getOrigin()Lio/ktor/utils/io/core/internal/ChunkBuffer;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObjectPool<ChunkBuffer> Pool = new ObjectPool<ChunkBuffer>() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$Pool$1
        @Override // io.ktor.utils.p098io.pool.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ObjectPool.DefaultImpls.close(this);
        }

        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public int getCapacity() {
            return BufferFactoryKt.getDefaultChunkedBufferPool().getCapacity();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public ChunkBuffer borrow() {
            return BufferFactoryKt.getDefaultChunkedBufferPool().borrow();
        }

        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public void recycle(ChunkBuffer instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            if (!(instance instanceof IoBuffer)) {
                throw new IllegalArgumentException("Only IoBuffer instances can be recycled.");
            }
            BufferFactoryKt.getDefaultChunkedBufferPool().recycle(instance);
        }

        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public void dispose() {
            BufferFactoryKt.getDefaultChunkedBufferPool().dispose();
        }
    };
    private static final ObjectPool<ChunkBuffer> EmptyPool = new ObjectPool<ChunkBuffer>() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$EmptyPool$1
        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public void dispose() {
        }

        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public int getCapacity() {
            return 1;
        }

        @Override // io.ktor.utils.p098io.pool.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ObjectPool.DefaultImpls.close(this);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public ChunkBuffer borrow() {
            return ChunkBuffer.INSTANCE.getEmpty();
        }

        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public void recycle(ChunkBuffer instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            if (instance == ChunkBuffer.INSTANCE.getEmpty()) {
                return;
            }
            new RequireFailureCapture() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$EmptyPool$1$recycle$$inlined$require$1
                @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
                public Void doFail() {
                    throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.");
                }
            }.doFail();
            throw new KotlinNothingValueException();
        }
    };
    private static final ObjectPool<ChunkBuffer> NoPool = new NoPoolImpl<ChunkBuffer>() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$NoPool$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public ChunkBuffer borrow() {
            return new IoBuffer(DefaultAllocator.INSTANCE.mo6944allocSK3TCg8(4096), null, this, 0 == true ? 1 : 0);
        }

        @Override // io.ktor.utils.p098io.pool.NoPoolImpl, io.ktor.utils.p098io.pool.ObjectPool
        public void recycle(ChunkBuffer instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            if (!(instance instanceof IoBuffer)) {
                throw new IllegalArgumentException("Only IoBuffer instances can be recycled.");
            }
            DefaultAllocator.INSTANCE.mo6946free3GNKZMM(instance.getMemory());
        }
    };
    private static final ObjectPool<ChunkBuffer> NoPoolManuallyManaged = new NoPoolImpl<ChunkBuffer>() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$Companion$NoPoolManuallyManaged$1
        @Override // io.ktor.utils.p098io.pool.NoPoolImpl, io.ktor.utils.p098io.pool.ObjectPool
        public void recycle(ChunkBuffer instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
        }

        @Override // io.ktor.utils.p098io.pool.ObjectPool
        public ChunkBuffer borrow() {
            throw new UnsupportedOperationException("This pool doesn't support borrow");
        }
    };
    private static final /* synthetic */ AtomicReferenceFieldUpdater nextRef$FU = AtomicReferenceFieldUpdater.newUpdater(ChunkBuffer.class, Object.class, "nextRef");
    private static final /* synthetic */ AtomicIntegerFieldUpdater refCount$FU = AtomicIntegerFieldUpdater.newUpdater(ChunkBuffer.class, "refCount");

    public /* synthetic */ ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool objectPool, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, chunkBuffer, objectPool);
    }

    public final ObjectPool<ChunkBuffer> getParentPool$ktor_io() {
        return this.parentPool;
    }

    private ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> objectPool) {
        super(byteBuffer, null);
        this.parentPool = objectPool;
        if (chunkBuffer != this) {
            this.nextRef = null;
            this.refCount = 1;
            this.origin = new SharedJvmKt.C53371(chunkBuffer);
            return;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$special$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException("A chunk couldn't be a view of itself.");
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    private final void setOrigin(ChunkBuffer chunkBuffer) {
        this.origin.setValue(this, $$delegatedProperties[0], chunkBuffer);
    }

    public final ChunkBuffer getOrigin() {
        return (ChunkBuffer) this.origin.getValue(this, $$delegatedProperties[0]);
    }

    public final ChunkBuffer getNext() {
        return (ChunkBuffer) this.nextRef;
    }

    public final void setNext(ChunkBuffer chunkBuffer) {
        if (chunkBuffer == null) {
            cleanNext();
        } else {
            appendNext(chunkBuffer);
        }
    }

    /* JADX INFO: renamed from: getReferenceCount, reason: from getter */
    public final int getRefCount() {
        return this.refCount;
    }

    private final void appendNext(ChunkBuffer chunk) {
        if (!C0526xc40028dd.m1169m(nextRef$FU, this, null, chunk)) {
            throw new IllegalStateException("This chunk has already a next chunk.");
        }
    }

    public final ChunkBuffer cleanNext() {
        return (ChunkBuffer) nextRef$FU.getAndSet(this, null);
    }

    @Override // io.ktor.utils.p098io.core.Buffer
    /* JADX INFO: renamed from: duplicate */
    public ChunkBuffer makeView() {
        ChunkBuffer origin = getOrigin();
        if (origin == null) {
            origin = this;
        }
        origin.acquire$ktor_io();
        ChunkBuffer chunkBuffer = new ChunkBuffer(getMemory(), origin, getParentPool$ktor_io(), null);
        duplicateTo(chunkBuffer);
        return chunkBuffer;
    }

    public void release(ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        if (release$ktor_io()) {
            ChunkBuffer origin = getOrigin();
            if (origin != null) {
                unlink$ktor_io();
                origin.release(pool);
            } else {
                ObjectPool<ChunkBuffer> objectPool = this.parentPool;
                if (objectPool != null) {
                    pool = objectPool;
                }
                pool.recycle(this);
            }
        }
    }

    public final void unlink$ktor_io() {
        if (!refCount$FU.compareAndSet(this, 0, -1)) {
            throw new IllegalStateException("Unable to unlink: buffer is in use.");
        }
        cleanNext();
        setOrigin(null);
    }

    @Override // io.ktor.utils.p098io.core.Buffer
    public final void reset() {
        if (getOrigin() == null) {
            super.reset();
            setAttachment(null);
            this.nextRef = null;
            return;
        }
        new RequireFailureCapture() { // from class: io.ktor.utils.io.core.internal.ChunkBuffer$reset$$inlined$require$1
            @Override // io.ktor.utils.p098io.core.internal.RequireFailureCapture
            public Void doFail() {
                throw new IllegalArgumentException("Unable to reset buffer with origin");
            }
        }.doFail();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: compiled from: ChunkBuffer.kt */
    @Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u00048F¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, m5598d2 = {"Lio/ktor/utils/io/core/internal/ChunkBuffer$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "getEmpty$annotations", "getEmpty", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "EmptyPool", "Lio/ktor/utils/io/pool/ObjectPool;", "getEmptyPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "NoPool", "getNoPool$ktor_io$annotations", "getNoPool$ktor_io", "NoPoolManuallyManaged", "getNoPoolManuallyManaged$ktor_io", "Pool", "getPool", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEmpty$annotations() {
        }

        public static /* synthetic */ void getNoPool$ktor_io$annotations() {
        }

        private Companion() {
        }

        public final ObjectPool<ChunkBuffer> getPool() {
            return ChunkBuffer.Pool;
        }

        public final ChunkBuffer getEmpty() {
            return IoBuffer.INSTANCE.getEmpty();
        }

        public final ObjectPool<ChunkBuffer> getEmptyPool() {
            return ChunkBuffer.EmptyPool;
        }

        public final ObjectPool<ChunkBuffer> getNoPool$ktor_io() {
            return ChunkBuffer.NoPool;
        }

        public final ObjectPool<ChunkBuffer> getNoPoolManuallyManaged$ktor_io() {
            return ChunkBuffer.NoPoolManuallyManaged;
        }
    }

    public final void acquire$ktor_io() {
        int i;
        do {
            i = this.refCount;
            if (i <= 0) {
                throw new IllegalStateException("Unable to acquire chunk: it is already released.");
            }
        } while (!refCount$FU.compareAndSet(this, i, i + 1));
    }

    public final void unpark$ktor_io() {
        int i;
        do {
            i = this.refCount;
            if (i < 0) {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            }
            if (i > 0) {
                throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
            }
        } while (!refCount$FU.compareAndSet(this, i, 1));
    }

    public final boolean release$ktor_io() {
        int i;
        int i2;
        do {
            i = this.refCount;
            if (i <= 0) {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
            i2 = i - 1;
        } while (!refCount$FU.compareAndSet(this, i, i2));
        return i2 == 0;
    }
}
