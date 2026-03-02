package io.ktor.utils.p098io;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LookAheadSession.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0087\bø\u0001\u0000\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0087Hø\u0001\u0001¢\u0006\u0002\u0010\u000b\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\f"}, m5598d2 = {"consumeEachRemaining", "", "Lio/ktor/utils/io/LookAheadSession;", "visitor", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/LookAheadSuspendSession;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class LookAheadSessionKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1 */
    /* JADX INFO: compiled from: LookAheadSession.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.LookAheadSessionKt", m5608f = "LookAheadSession.kt", m5609i = {0, 0, 1, 1, 1}, m5610l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 60}, m5611m = "consumeEachRemaining", m5612n = {"$this$consumeEachRemaining", "visitor", "$this$consumeEachRemaining", "visitor", "s"}, m5613s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
    static final class C53301 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53301(Continuation<? super C53301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LookAheadSessionKt.consumeEachRemaining(null, null, this);
        }
    }

    @ExperimentalIoApi
    public static final void consumeEachRemaining(LookAheadSession lookAheadSession, Function1<? super ByteBuffer, Boolean> visitor) {
        boolean z;
        Intrinsics.checkNotNullParameter(lookAheadSession, "<this>");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        do {
            z = false;
            ByteBuffer byteBufferRequest = lookAheadSession.request(0, 1);
            if (byteBufferRequest != null) {
                int iRemaining = byteBufferRequest.remaining();
                boolean zBooleanValue = visitor.invoke(byteBufferRequest).booleanValue();
                lookAheadSession.mo7224consumed(iRemaining);
                z = zBooleanValue;
            }
        } while (z);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006e -> B:17:0x004e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0085 -> B:31:0x0088). Please report as a decompilation issue!!! */
    @io.ktor.utils.p098io.core.ExperimentalIoApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object consumeEachRemaining(io.ktor.utils.p098io.LookAheadSuspendSession r6, kotlin.jvm.functions.Function2<? super java.nio.ByteBuffer, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.p098io.LookAheadSessionKt.C53301
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1 r0 = (io.ktor.utils.p098io.LookAheadSessionKt.C53301) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1 r0 = new io.ktor.utils.io.LookAheadSessionKt$consumeEachRemaining$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.LookAheadSuspendSession r2 = (io.ktor.utils.p098io.LookAheadSuspendSession) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L88
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.LookAheadSuspendSession r7 = (io.ktor.utils.p098io.LookAheadSuspendSession) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L65
        L4b:
            kotlin.ResultKt.throwOnFailure(r8)
        L4e:
            r8 = 0
            java.nio.ByteBuffer r8 = r6.request(r8, r4)
            if (r8 != 0) goto L72
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.awaitAtLeast(r4, r0)
            if (r8 != r1) goto L62
            return r1
        L62:
            r5 = r7
            r7 = r6
            r6 = r5
        L65:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L6e
            goto L93
        L6e:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L4e
        L72:
            int r2 = r8.remaining()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r8 = r7.invoke(r8, r0)
            if (r8 != r1) goto L85
            return r1
        L85:
            r5 = r2
            r2 = r6
            r6 = r5
        L88:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2.mo7224consumed(r6)
            if (r8 != 0) goto L96
        L93:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L96:
            r6 = r2
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.LookAheadSessionKt.consumeEachRemaining(io.ktor.utils.io.LookAheadSuspendSession, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @ExperimentalIoApi
    private static final Object consumeEachRemaining$$forInline(LookAheadSuspendSession lookAheadSuspendSession, Function2<? super ByteBuffer, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        while (true) {
            ByteBuffer byteBufferRequest = lookAheadSuspendSession.request(0, 1);
            if (byteBufferRequest == null) {
                InlineMarker.mark(0);
                Object objAwaitAtLeast = lookAheadSuspendSession.awaitAtLeast(1, continuation);
                InlineMarker.mark(1);
                if (!((Boolean) objAwaitAtLeast).booleanValue()) {
                    break;
                }
            } else {
                int iRemaining = byteBufferRequest.remaining();
                boolean zBooleanValue = ((Boolean) function2.invoke(byteBufferRequest, continuation)).booleanValue();
                lookAheadSuspendSession.mo7224consumed(iRemaining);
                if (!zBooleanValue) {
                    break;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
