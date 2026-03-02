package io.ktor.utils.p098io;

import androidx.concurrent.futures.C0526xc40028dd;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConditionJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\bH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u000b\u001a\u00020\b2\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m5598d2 = {"Lio/ktor/utils/io/Condition;", "", "predicate", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "cond", "Lkotlin/coroutines/Continuation;", "", "getPredicate", "()Lkotlin/jvm/functions/Function0;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "check", "signal", "toString", "", "Companion", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class Condition {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicReferenceFieldUpdater<Condition, Continuation<Unit>> updater;
    private volatile Continuation<? super Unit> cond;
    private final Function0<Boolean> predicate;

    public Condition(Function0<Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.predicate = predicate;
    }

    public final Function0<Boolean> getPredicate() {
        return this.predicate;
    }

    public final boolean check() {
        return this.predicate.invoke().booleanValue();
    }

    public final void signal() {
        Continuation<? super Unit> continuation = this.cond;
        if (continuation != null && this.predicate.invoke().booleanValue() && C0526xc40028dd.m1169m(updater, this, continuation, null)) {
            Continuation continuationIntercepted = IntrinsicsKt.intercepted(continuation);
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.INSTANCE;
            continuationIntercepted.resumeWith(Result.m7233constructorimpl(unit));
        }
    }

    private final Object await$$forInline(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (getPredicate().invoke().booleanValue()) {
            return Unit.INSTANCE;
        }
        InlineMarker.mark(0);
        if (!C0526xc40028dd.m1169m(updater, this, null, continuation)) {
            throw new IllegalStateException();
        }
        if (getPredicate().invoke().booleanValue() && C0526xc40028dd.m1169m(updater, this, continuation, null)) {
            coroutine_suspended = Unit.INSTANCE;
        } else {
            function0.invoke();
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public final Object await(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (getPredicate().invoke().booleanValue()) {
            return Unit.INSTANCE;
        }
        if (!C0526xc40028dd.m1169m(updater, this, null, continuation)) {
            throw new IllegalStateException();
        }
        if (getPredicate().invoke().booleanValue() && C0526xc40028dd.m1169m(updater, this, continuation, null)) {
            coroutine_suspended = Unit.INSTANCE;
        } else {
            function0.invoke();
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }

    private final Object await$$forInline(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (getPredicate().invoke().booleanValue()) {
            return Unit.INSTANCE;
        }
        InlineMarker.mark(0);
        if (!C0526xc40028dd.m1169m(updater, this, null, continuation)) {
            throw new IllegalStateException();
        }
        if (getPredicate().invoke().booleanValue() && C0526xc40028dd.m1169m(updater, this, continuation, null)) {
            coroutine_suspended = Unit.INSTANCE;
        } else {
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public final Object await(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (getPredicate().invoke().booleanValue()) {
            return Unit.INSTANCE;
        }
        if (!C0526xc40028dd.m1169m(updater, this, null, continuation)) {
            throw new IllegalStateException();
        }
        if (getPredicate().invoke().booleanValue() && C0526xc40028dd.m1169m(updater, this, continuation, null)) {
            coroutine_suspended = Unit.INSTANCE;
        } else {
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }

    public String toString() {
        return "Condition(cond=" + this.cond + ')';
    }

    /* JADX INFO: compiled from: ConditionJVM.kt */
    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002¨\u0006\t"}, m5598d2 = {"Lio/ktor/utils/io/Condition$Companion;", "", "()V", "updater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lio/ktor/utils/io/Condition;", "Lkotlin/coroutines/Continuation;", "", "getUpdater$annotations", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getUpdater$annotations() {
        }

        private Companion() {
        }
    }

    static {
        AtomicReferenceFieldUpdater<Condition, Continuation<Unit>> atomicReferenceFieldUpdaterNewUpdater = AtomicReferenceFieldUpdater.newUpdater(Condition.class, Continuation.class, "cond");
        if (atomicReferenceFieldUpdaterNewUpdater == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.atomic.AtomicReferenceFieldUpdater<io.ktor.utils.io.Condition, kotlin.coroutines.Continuation<kotlin.Unit>?>");
        }
        updater = atomicReferenceFieldUpdaterNewUpdater;
    }
}
