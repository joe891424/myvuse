package com.reactnativenavigation.views.element;

import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TransitionSetCreator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/reactnativenavigation/views/element/SharedElementTransition;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.reactnativenavigation.views.element.TransitionSetCreator$createSharedElementTransitions$2$1$1", m5608f = "TransitionSetCreator.kt", m5609i = {0, 1}, m5610l = {32, 33}, m5611m = "invokeSuspend", m5612n = {"$this$invokeSuspend_u24lambda_u242", "$this$invokeSuspend_u24lambda_u242"}, m5613s = {"L$2", "L$1"})
final class TransitionSetCreator$createSharedElementTransitions$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SharedElementTransition>, Object> {
    final /* synthetic */ ViewController<?> $fromScreen;
    final /* synthetic */ SharedElementTransitionOptions $it;
    final /* synthetic */ ViewController<?> $toScreen;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransitionSetCreator$createSharedElementTransitions$2$1$1(ViewController<?> viewController, SharedElementTransitionOptions sharedElementTransitionOptions, ViewController<?> viewController2, Continuation<? super TransitionSetCreator$createSharedElementTransitions$2$1$1> continuation) {
        super(2, continuation);
        this.$toScreen = viewController;
        this.$it = sharedElementTransitionOptions;
        this.$fromScreen = viewController2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransitionSetCreator$createSharedElementTransitions$2$1$1(this.$toScreen, this.$it, this.$fromScreen, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SharedElementTransition> continuation) {
        return ((TransitionSetCreator$createSharedElementTransitions$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L32
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r7.L$1
            com.reactnativenavigation.views.element.SharedElementTransition r0 = (com.reactnativenavigation.views.element.SharedElementTransition) r0
            java.lang.Object r1 = r7.L$0
            com.reactnativenavigation.views.element.SharedElementTransition r1 = (com.reactnativenavigation.views.element.SharedElementTransition) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L80
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L22:
            java.lang.Object r1 = r7.L$2
            com.reactnativenavigation.views.element.SharedElementTransition r1 = (com.reactnativenavigation.views.element.SharedElementTransition) r1
            java.lang.Object r3 = r7.L$1
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController r3 = (com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController) r3
            java.lang.Object r4 = r7.L$0
            com.reactnativenavigation.views.element.SharedElementTransition r4 = (com.reactnativenavigation.views.element.SharedElementTransition) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5e
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            com.reactnativenavigation.views.element.SharedElementTransition r8 = new com.reactnativenavigation.views.element.SharedElementTransition
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r1 = r7.$toScreen
            com.reactnativenavigation.options.SharedElementTransitionOptions r4 = r7.$it
            r8.<init>(r1, r4)
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r1 = r7.$fromScreen
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r4 = r7.$toScreen
            com.reactnativenavigation.views.element.finder.ExistingViewFinder r5 = new com.reactnativenavigation.views.element.finder.ExistingViewFinder
            r5.<init>()
            java.lang.String r6 = r8.getFromId()
            r7.L$0 = r8
            r7.L$1 = r4
            r7.L$2 = r8
            r7.label = r3
            java.lang.Object r1 = r5.find(r1, r6, r7)
            if (r1 != r0) goto L5a
            return r0
        L5a:
            r3 = r4
            r4 = r8
            r8 = r1
            r1 = r4
        L5e:
            android.view.View r8 = (android.view.View) r8
            if (r8 == 0) goto L65
            r1.setFrom(r8)
        L65:
            com.reactnativenavigation.views.element.finder.ExistingViewFinder r8 = new com.reactnativenavigation.views.element.finder.ExistingViewFinder
            r8.<init>()
            java.lang.String r5 = r1.getToId()
            r7.L$0 = r4
            r7.L$1 = r1
            r6 = 0
            r7.L$2 = r6
            r7.label = r2
            java.lang.Object r8 = r8.find(r3, r5, r7)
            if (r8 != r0) goto L7e
            return r0
        L7e:
            r0 = r1
            r1 = r4
        L80:
            android.view.View r8 = (android.view.View) r8
            if (r8 == 0) goto L87
            r0.setTo(r8)
        L87:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.views.element.TransitionSetCreator$createSharedElementTransitions$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
