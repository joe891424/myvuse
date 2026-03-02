package io.ktor.utils.p098io.internal;

import com.newrelic.agent.android.agentdata.HexAttribute;
import io.ktor.utils.p098io.NativeUtilsJvmKt;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: AwaitingSlot.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020\u000eB\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0002J\u0013\u0010\t\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m5598d2 = {"Lio/ktor/utils/io/internal/AwaitingSlot;", "<init>", "()V", "", HexAttribute.HEX_ATTR_CAUSE, "", "cancel", "(Ljava/lang/Throwable;)V", "resume", "sleep", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "trySuspend", "ktor-io", ""}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class AwaitingSlot {
    private static final /* synthetic */ AtomicReferenceFieldUpdater suspension$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitingSlot.class, Object.class, "suspension");
    private volatile /* synthetic */ Object suspension = null;

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.AwaitingSlot$sleep$1 */
    /* JADX INFO: compiled from: AwaitingSlot.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.internal.AwaitingSlot", m5608f = "AwaitingSlot.kt", m5609i = {0}, m5610l = {28}, m5611m = "sleep", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C53411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53411(Continuation<? super C53411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwaitingSlot.this.sleep(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1 */
    /* JADX INFO: compiled from: AwaitingSlot.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.internal.AwaitingSlot", m5608f = "AwaitingSlot.kt", m5609i = {0}, m5610l = {LockFreeTaskQueueCore.CLOSED_SHIFT}, m5611m = "trySuspend", m5612n = {"suspended"}, m5613s = {"I$0"})
    static final class C53421 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C53421(Continuation<? super C53421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwaitingSlot.this.trySuspend(this);
        }
    }

    public AwaitingSlot() {
        NativeUtilsJvmKt.makeShared(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sleep(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.p098io.internal.AwaitingSlot.C53411
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.internal.AwaitingSlot$sleep$1 r0 = (io.ktor.utils.p098io.internal.AwaitingSlot.C53411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.internal.AwaitingSlot$sleep$1 r0 = new io.ktor.utils.io.internal.AwaitingSlot$sleep$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.internal.AwaitingSlot r0 = (io.ktor.utils.p098io.internal.AwaitingSlot) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.trySuspend(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            r0 = r4
        L45:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L50
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L50:
            r0.resume()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.internal.AwaitingSlot.sleep(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void resume() {
        CompletableJob completableJob = (CompletableJob) suspension$FU.getAndSet(this, null);
        if (completableJob == null) {
            return;
        }
        completableJob.complete();
    }

    public final void cancel(Throwable cause) {
        CompletableJob completableJob = (CompletableJob) suspension$FU.getAndSet(this, null);
        if (completableJob == null) {
            return;
        }
        if (cause != null) {
            completableJob.completeExceptionally(cause);
        } else {
            completableJob.complete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object trySuspend(kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.internal.AwaitingSlot.C53421
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1 r0 = (io.ktor.utils.p098io.internal.AwaitingSlot.C53421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1 r0 = new io.ktor.utils.io.internal.AwaitingSlot$trySuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            int r0 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L53
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            kotlinx.coroutines.CompletableJob r2 = kotlinx.coroutines.JobKt.Job$default(r7, r4, r7)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = io.ktor.utils.p098io.internal.AwaitingSlot.suspension$FU
            boolean r7 = androidx.concurrent.futures.C0526xc40028dd.m1169m(r5, r6, r7, r2)
            if (r7 == 0) goto L52
            r0.I$0 = r4
            r0.label = r4
            java.lang.Object r7 = r2.join(r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r0 = r4
            goto L53
        L52:
            r0 = r3
        L53:
            if (r0 == 0) goto L56
            r3 = r4
        L56:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.internal.AwaitingSlot.trySuspend(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
