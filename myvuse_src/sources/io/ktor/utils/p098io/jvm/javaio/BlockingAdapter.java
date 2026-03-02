package io.ktor.utils.p098io.jvm.javaio;

import androidx.concurrent.futures.C0526xc40028dd;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.uimanager.ViewProps;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoopKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\"\u0018\u00002\u00020\u0010B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0007H¤@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0084Hø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010\u001b\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00058\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b%\u0010&R$\u0010\u001a\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00058\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u001a\u0010$\u001a\u0004\b'\u0010&R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010(\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, m5598d2 = {"Lio/ktor/utils/io/jvm/javaio/BlockingAdapter;", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "rc", "", BackgroundFetch.ACTION_FINISH, "(I)V", "loop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Thread;", "thread", "parkingLoop", "(Ljava/lang/Thread;)V", "", "rendezvous", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "()V", "jobToken", "submitAndAwait", "(Ljava/lang/Object;)I", "", "buffer", TypedValues.CycleType.S_WAVE_OFFSET, "length", "([BII)I", "Lkotlinx/coroutines/DisposableHandle;", "disposable", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlin/coroutines/Continuation;", ViewProps.END, "Lkotlin/coroutines/Continuation;", "<set-?>", "I", "getLength", "()I", "getOffset", "Lkotlinx/coroutines/Job;", "getParent", "()Lkotlinx/coroutines/Job;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
abstract class BlockingAdapter {
    static final /* synthetic */ AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(BlockingAdapter.class, Object.class, "state");
    private final DisposableHandle disposable;
    private final Continuation<Unit> end;
    private int length;
    private int offset;
    private final Job parent;
    volatile /* synthetic */ int result;
    volatile /* synthetic */ Object state;

    /* JADX WARN: Multi-variable type inference failed */
    public BlockingAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private static /* synthetic */ void getState$annotations() {
    }

    protected abstract Object loop(Continuation<? super Unit> continuation);

    public BlockingAdapter(Job job) {
        this.parent = job;
        Continuation<Unit> continuation = new Continuation<Unit>() { // from class: io.ktor.utils.io.jvm.javaio.BlockingAdapter$end$1
            private final CoroutineContext context;

            {
                this.context = this.this$0.getParent() != null ? UnsafeBlockingTrampoline.INSTANCE.plus(this.this$0.getParent()) : UnsafeBlockingTrampoline.INSTANCE;
            }

            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return this.context;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) {
                Object obj;
                boolean z;
                Throwable thM7236exceptionOrNullimpl;
                Job parent;
                Object objM7236exceptionOrNullimpl = Result.m7236exceptionOrNullimpl(result);
                if (objM7236exceptionOrNullimpl == null) {
                    objM7236exceptionOrNullimpl = Unit.INSTANCE;
                }
                BlockingAdapter blockingAdapter = this.this$0;
                do {
                    obj = blockingAdapter.state;
                    z = obj instanceof Thread;
                    if (!(z ? true : obj instanceof Continuation ? true : Intrinsics.areEqual(obj, this))) {
                        return;
                    }
                } while (!C0526xc40028dd.m1169m(BlockingAdapter.state$FU, blockingAdapter, obj, objM7236exceptionOrNullimpl));
                if (z) {
                    PollersKt.getParkingImpl().unpark(obj);
                } else if ((obj instanceof Continuation) && (thM7236exceptionOrNullimpl = Result.m7236exceptionOrNullimpl(result)) != null) {
                    Result.Companion companion = Result.INSTANCE;
                    ((Continuation) obj).resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(thM7236exceptionOrNullimpl)));
                }
                if (Result.m7239isFailureimpl(result) && !(Result.m7236exceptionOrNullimpl(result) instanceof CancellationException) && (parent = this.this$0.getParent()) != null) {
                    Job.DefaultImpls.cancel$default(parent, (CancellationException) null, 1, (Object) null);
                }
                DisposableHandle disposableHandle = this.this$0.disposable;
                if (disposableHandle == null) {
                    return;
                }
                disposableHandle.dispose();
            }
        };
        this.end = continuation;
        this.state = this;
        this.result = 0;
        this.disposable = job == null ? null : job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.jvm.javaio.BlockingAdapter$disposable$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th != null) {
                    Continuation continuation2 = this.this$0.end;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(th)));
                }
            }
        });
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new BlockingAdapter$block$1(this, null), 1)).invoke(continuation);
        if (!(this.state != this)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ BlockingAdapter(Job job, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : job);
    }

    public final Job getParent() {
        return this.parent;
    }

    protected final int getOffset() {
        return this.offset;
    }

    protected final int getLength() {
        return this.length;
    }

    public final void shutdown() {
        DisposableHandle disposableHandle = this.disposable;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Continuation<Unit> continuation = this.end;
        CancellationException cancellationException = new CancellationException("Stream closed");
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m7233constructorimpl(ResultKt.createFailure(cancellationException)));
    }

    public final int submitAndAwait(byte[] buffer, int offset, int length) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.offset = offset;
        this.length = length;
        return submitAndAwait(buffer);
    }

    public final int submitAndAwait(Object jobToken) throws Throwable {
        Object obj;
        Object noWhenBranchMatchedException;
        Intrinsics.checkNotNullParameter(jobToken, "jobToken");
        Thread thread = Thread.currentThread();
        Continuation continuation = null;
        do {
            obj = this.state;
            if (obj instanceof Continuation) {
                continuation = (Continuation) obj;
                noWhenBranchMatchedException = thread;
            } else {
                if (obj instanceof Unit) {
                    return this.result;
                }
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                if (obj instanceof Thread) {
                    throw new IllegalStateException("There is already thread owning adapter");
                }
                if (Intrinsics.areEqual(obj, this)) {
                    throw new IllegalStateException("Not yet started");
                }
                noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNullExpressionValue(noWhenBranchMatchedException, "when (value) {\n         …Exception()\n            }");
        } while (!C0526xc40028dd.m1169m(state$FU, this, obj, noWhenBranchMatchedException));
        Intrinsics.checkNotNull(continuation);
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m7233constructorimpl(jobToken));
        Intrinsics.checkNotNullExpressionValue(thread, "thread");
        parkingLoop(thread);
        Object obj2 = this.state;
        if (obj2 instanceof Throwable) {
            throw ((Throwable) obj2);
        }
        return this.result;
    }

    private final void parkingLoop(Thread thread) {
        if (this.state != thread) {
            return;
        }
        while (true) {
            long jProcessNextEventInCurrentThread = EventLoopKt.processNextEventInCurrentThread();
            if (this.state != thread) {
                return;
            }
            if (jProcessNextEventInCurrentThread > 0) {
                PollersKt.getParkingImpl().park(jProcessNextEventInCurrentThread);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object rendezvous$$forInline(int i, Continuation<Object> continuation) {
        Object obj;
        Continuation continuationIntercepted;
        this.result = i;
        InlineMarker.mark(0);
        Object obj2 = null;
        while (true) {
            Object obj3 = this.state;
            if (obj3 instanceof Thread) {
                continuationIntercepted = IntrinsicsKt.intercepted(continuation);
                obj = obj3;
            } else {
                if (!Intrinsics.areEqual(obj3, this)) {
                    throw new IllegalStateException("Already suspended or in finished state");
                }
                obj = obj2;
                continuationIntercepted = IntrinsicsKt.intercepted(continuation);
            }
            if (C0526xc40028dd.m1169m(state$FU, this, obj3, continuationIntercepted)) {
                if (obj != null) {
                    PollersKt.getParkingImpl().unpark(obj);
                }
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                InlineMarker.mark(1);
                return coroutine_suspended;
            }
            obj2 = obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final Object rendezvous(int i, Continuation<Object> continuation) {
        Object obj;
        Continuation continuationIntercepted;
        this.result = i;
        Object obj2 = null;
        while (true) {
            Object obj3 = this.state;
            if (obj3 instanceof Thread) {
                continuationIntercepted = IntrinsicsKt.intercepted(continuation);
                obj = obj3;
            } else {
                if (!Intrinsics.areEqual(obj3, this)) {
                    throw new IllegalStateException("Already suspended or in finished state");
                }
                obj = obj2;
                continuationIntercepted = IntrinsicsKt.intercepted(continuation);
            }
            if (C0526xc40028dd.m1169m(state$FU, this, obj3, continuationIntercepted)) {
                if (obj != null) {
                    PollersKt.getParkingImpl().unpark(obj);
                }
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return coroutine_suspended;
            }
            obj2 = obj;
        }
    }

    protected final void finish(int rc) {
        this.result = rc;
    }
}
