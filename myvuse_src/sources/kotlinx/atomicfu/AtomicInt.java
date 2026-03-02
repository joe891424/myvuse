package kotlinx.atomicfu;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.atomicfu.TraceBase;

/* JADX INFO: compiled from: AtomicFU.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003J\u001f\u0010\t\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0086\nJ\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003J\u0011\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\nJ'\u0010\u000b\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\nJ\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006#"}, m5598d2 = {"Lkotlinx/atomicfu/AtomicInt;", "", "value", "", "trace", "Lkotlinx/atomicfu/TraceBase;", "(ILkotlinx/atomicfu/TraceBase;)V", "getTrace", "()Lkotlinx/atomicfu/TraceBase;", "getValue", "()I", "setValue", "(I)V", "addAndGet", "delta", "compareAndSet", "", "expect", "update", "decrementAndGet", "getAndAdd", "getAndDecrement", "getAndIncrement", "getAndSet", "thisRef", "property", "Lkotlin/reflect/KProperty;", "incrementAndGet", "lazySet", "", "minusAssign", "plusAssign", "toString", "", "Companion", "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
public final class AtomicInt {
    private static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: FU */
    @Deprecated
    private static final AtomicIntegerFieldUpdater<AtomicInt> f8331FU = AtomicIntegerFieldUpdater.newUpdater(AtomicInt.class, "value");
    private final TraceBase trace;
    private volatile int value;

    public AtomicInt(int i, TraceBase trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.trace = trace;
        this.value = i;
    }

    public final TraceBase getTrace() {
        return this.trace;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        this.value = i;
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("set(" + i + ')');
        }
        InterceptorKt.getInterceptor().afterSet(this, i);
    }

    public final int getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getValue();
    }

    public final void setValue(Object thisRef, KProperty<?> property, int value) {
        Intrinsics.checkNotNullParameter(property, "property");
        setValue(value);
    }

    public final void lazySet(int value) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        f8331FU.lazySet(this, value);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("lazySet(" + value + ')');
        }
        InterceptorKt.getInterceptor().afterSet(this, value);
    }

    public final boolean compareAndSet(int expect, int update) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        boolean zCompareAndSet = f8331FU.compareAndSet(this, expect, update);
        if (zCompareAndSet) {
            if (this.trace != TraceBase.None.INSTANCE) {
                this.trace.append("CAS(" + expect + ", " + update + ')');
            }
            InterceptorKt.getInterceptor().afterRMW(this, expect, update);
        }
        return zCompareAndSet;
    }

    public final int getAndSet(int value) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        int andSet = f8331FU.getAndSet(this, value);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("getAndSet(" + value + "):" + andSet);
        }
        InterceptorKt.getInterceptor().afterRMW(this, andSet, value);
        return andSet;
    }

    public final int getAndIncrement() {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        int andIncrement = f8331FU.getAndIncrement(this);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("getAndInc():" + andIncrement);
        }
        InterceptorKt.getInterceptor().afterRMW(this, andIncrement, andIncrement + 1);
        return andIncrement;
    }

    public final int getAndDecrement() {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        int andDecrement = f8331FU.getAndDecrement(this);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("getAndDec():" + andDecrement);
        }
        InterceptorKt.getInterceptor().afterRMW(this, andDecrement, andDecrement - 1);
        return andDecrement;
    }

    public final int getAndAdd(int delta) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        int andAdd = f8331FU.getAndAdd(this, delta);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("getAndAdd(" + delta + "):" + andAdd);
        }
        InterceptorKt.getInterceptor().afterRMW(this, andAdd, delta + andAdd);
        return andAdd;
    }

    public final int addAndGet(int delta) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        int iAddAndGet = f8331FU.addAndGet(this, delta);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("addAndGet(" + delta + "):" + iAddAndGet);
        }
        InterceptorKt.getInterceptor().afterRMW(this, iAddAndGet - delta, iAddAndGet);
        return iAddAndGet;
    }

    public final int incrementAndGet() {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        int iIncrementAndGet = f8331FU.incrementAndGet(this);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("incAndGet():" + iIncrementAndGet);
        }
        InterceptorKt.getInterceptor().afterRMW(this, iIncrementAndGet - 1, iIncrementAndGet);
        return iIncrementAndGet;
    }

    public final int decrementAndGet() {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        int iDecrementAndGet = f8331FU.decrementAndGet(this);
        if (this.trace != TraceBase.None.INSTANCE) {
            this.trace.append("decAndGet():" + iDecrementAndGet);
        }
        InterceptorKt.getInterceptor().afterRMW(this, iDecrementAndGet + 1, iDecrementAndGet);
        return iDecrementAndGet;
    }

    public final void plusAssign(int delta) {
        getAndAdd(delta);
    }

    public final void minusAssign(int delta) {
        getAndAdd(-delta);
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    /* JADX INFO: compiled from: AtomicFU.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m5598d2 = {"Lkotlinx/atomicfu/AtomicInt$Companion;", "", "()V", "FU", "Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;", "Lkotlinx/atomicfu/AtomicInt;", "kotlin.jvm.PlatformType", "atomicfu"}, m5599k = 1, m5600mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
