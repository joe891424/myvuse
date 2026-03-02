package com.reactnativenavigation.views.element;

import com.reactnativenavigation.options.ElementTransitionOptions;
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
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/reactnativenavigation/views/element/ElementTransition;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.reactnativenavigation.views.element.TransitionSetCreator$createElementTransitions$2$1$1", m5608f = "TransitionSetCreator.kt", m5609i = {0, 0, 1}, m5610l = {50, 54}, m5611m = "invokeSuspend", m5612n = {"$this$async", "transition", "transition"}, m5613s = {"L$0", "L$1", "L$0"})
final class TransitionSetCreator$createElementTransitions$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ElementTransition>, Object> {
    final /* synthetic */ ViewController<?> $fromScreen;
    final /* synthetic */ ElementTransitionOptions $it;
    final /* synthetic */ ViewController<?> $toScreen;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransitionSetCreator$createElementTransitions$2$1$1(ElementTransitionOptions elementTransitionOptions, ViewController<?> viewController, ViewController<?> viewController2, Continuation<? super TransitionSetCreator$createElementTransitions$2$1$1> continuation) {
        super(2, continuation);
        this.$it = elementTransitionOptions;
        this.$fromScreen = viewController;
        this.$toScreen = viewController2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransitionSetCreator$createElementTransitions$2$1$1 transitionSetCreator$createElementTransitions$2$1$1 = new TransitionSetCreator$createElementTransitions$2$1$1(this.$it, this.$fromScreen, this.$toScreen, continuation);
        transitionSetCreator$createElementTransitions$2$1$1.L$0 = obj;
        return transitionSetCreator$createElementTransitions$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ElementTransition> continuation) {
        return ((TransitionSetCreator$createElementTransitions$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r8.L$1
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController r0 = (com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController) r0
            java.lang.Object r1 = r8.L$0
            com.reactnativenavigation.views.element.ElementTransition r1 = (com.reactnativenavigation.views.element.ElementTransition) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L7e
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            java.lang.Object r1 = r8.L$1
            com.reactnativenavigation.views.element.ElementTransition r1 = (com.reactnativenavigation.views.element.ElementTransition) r1
            java.lang.Object r3 = r8.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r9)
            goto L57
        L2e:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            com.reactnativenavigation.views.element.ElementTransition r1 = new com.reactnativenavigation.views.element.ElementTransition
            com.reactnativenavigation.options.ElementTransitionOptions r4 = r8.$it
            r1.<init>(r4)
            com.reactnativenavigation.views.element.finder.ExistingViewFinder r4 = new com.reactnativenavigation.views.element.finder.ExistingViewFinder
            r4.<init>()
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r5 = r8.$fromScreen
            java.lang.String r6 = r1.getId()
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.L$0 = r9
            r8.L$1 = r1
            r8.label = r3
            java.lang.Object r9 = r4.find(r5, r6, r7)
            if (r9 != r0) goto L57
            return r0
        L57:
            android.view.View r9 = (android.view.View) r9
            if (r9 == 0) goto L64
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r0 = r8.$fromScreen
            r1.setView(r9)
            r1.setViewController(r0)
            goto L88
        L64:
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r9 = r8.$toScreen
            com.reactnativenavigation.views.element.finder.ExistingViewFinder r3 = new com.reactnativenavigation.views.element.finder.ExistingViewFinder
            r3.<init>()
            java.lang.String r4 = r1.getId()
            r8.L$0 = r1
            r8.L$1 = r9
            r8.label = r2
            java.lang.Object r2 = r3.find(r9, r4, r8)
            if (r2 != r0) goto L7c
            return r0
        L7c:
            r0 = r9
            r9 = r2
        L7e:
            android.view.View r9 = (android.view.View) r9
            if (r9 == 0) goto L88
            r1.setView(r9)
            r1.setViewController(r0)
        L88:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.views.element.TransitionSetCreator$createElementTransitions$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
