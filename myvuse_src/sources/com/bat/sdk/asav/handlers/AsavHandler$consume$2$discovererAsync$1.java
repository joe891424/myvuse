package com.bat.sdk.asav.handlers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: AsavHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.bat.sdk.asav.handlers.AsavHandler$consume$2$discovererAsync$1", m5608f = "AsavHandler.kt", m5609i = {}, m5610l = {31, 31}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class AsavHandler$consume$2$discovererAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Deferred<Unit>> $advertiserAsync;
    Object L$0;
    int label;
    final /* synthetic */ AsavHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsavHandler$consume$2$discovererAsync$1(AsavHandler asavHandler, Ref.ObjectRef<Deferred<Unit>> objectRef, Continuation<? super AsavHandler$consume$2$discovererAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = asavHandler;
        this.$advertiserAsync = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsavHandler$consume$2$discovererAsync$1(this.this$0, this.$advertiserAsync, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AsavHandler$consume$2$discovererAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.throwOnFailure(r7)
            goto L46
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            java.lang.Object r1 = r6.L$0
            com.bat.sdk.asav.handlers.AsavHandler r1 = (com.bat.sdk.asav.handlers.AsavHandler) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L36
        L23:
            kotlin.ResultKt.throwOnFailure(r7)
            com.bat.sdk.asav.handlers.AsavHandler r1 = r6.this$0
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r1.interceptResponse(r7)
            if (r7 != r0) goto L36
            return r0
        L36:
            com.bat.sdk.asav.response.AsavChannelResponse r7 = (com.bat.sdk.asav.response.AsavChannelResponse) r7
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = r1.onResponseAvailable(r7, r5)
            if (r7 != r0) goto L46
            return r0
        L46:
            kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Deferred<kotlin.Unit>> r7 = r6.$advertiserAsync
            T r7 = r7.element
            kotlinx.coroutines.Deferred r7 = (kotlinx.coroutines.Deferred) r7
            if (r7 == 0) goto L55
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r7, r4, r3, r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L55:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.asav.handlers.AsavHandler$consume$2$discovererAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
