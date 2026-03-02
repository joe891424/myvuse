package com.reactnativenavigation.views.element;

import com.facebook.soloader.Elf64_Ehdr;
import com.reactnativenavigation.options.ElementTransitionOptions;
import com.reactnativenavigation.options.ElementTransitions;
import com.reactnativenavigation.options.SharedElementTransitionOptions;
import com.reactnativenavigation.options.SharedElements;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: TransitionSetCreator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0086@¢\u0006\u0002\u0010\nJ4\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J4\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/TransitionSetCreator;", "", "()V", "create", "Lcom/reactnativenavigation/views/element/TransitionSet;", "animation", "Lcom/reactnativenavigation/options/LayoutAnimation;", "fromScreen", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "toScreen", "(Lcom/reactnativenavigation/options/LayoutAnimation;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createElementTransitions", "", "Lcom/reactnativenavigation/views/element/ElementTransition;", "elementTransitions", "Lcom/reactnativenavigation/options/ElementTransitions;", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/options/ElementTransitions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSharedElementTransitions", "Lcom/reactnativenavigation/views/element/Transition;", "sharedElements", "Lcom/reactnativenavigation/options/SharedElements;", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/options/SharedElements;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TransitionSetCreator {

    /* JADX INFO: renamed from: com.reactnativenavigation.views.element.TransitionSetCreator$create$1 */
    /* JADX INFO: compiled from: TransitionSetCreator.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.views.element.TransitionSetCreator", m5608f = "TransitionSetCreator.kt", m5609i = {0, 0, 0, 0, 0}, m5610l = {19, 20}, m5611m = "create", m5612n = {"this", "animation", "fromScreen", "toScreen", "$this$create_u24lambda_u240"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$5"})
    static final class C40201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C40201(Continuation<? super C40201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransitionSetCreator.this.create(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object create(com.reactnativenavigation.options.LayoutAnimation r8, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r9, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r10, kotlin.coroutines.Continuation<? super com.reactnativenavigation.views.element.TransitionSet> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.reactnativenavigation.views.element.TransitionSetCreator.C40201
            if (r0 == 0) goto L14
            r0 = r11
            com.reactnativenavigation.views.element.TransitionSetCreator$create$1 r0 = (com.reactnativenavigation.views.element.TransitionSetCreator.C40201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.reactnativenavigation.views.element.TransitionSetCreator$create$1 r0 = new com.reactnativenavigation.views.element.TransitionSetCreator$create$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5e
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r8 = r0.L$1
            com.reactnativenavigation.views.element.TransitionSet r8 = (com.reactnativenavigation.views.element.TransitionSet) r8
            java.lang.Object r9 = r0.L$0
            com.reactnativenavigation.views.element.TransitionSet r9 = (com.reactnativenavigation.views.element.TransitionSet) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lac
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            java.lang.Object r8 = r0.L$6
            com.reactnativenavigation.views.element.TransitionSet r8 = (com.reactnativenavigation.views.element.TransitionSet) r8
            java.lang.Object r9 = r0.L$5
            com.reactnativenavigation.views.element.TransitionSet r9 = (com.reactnativenavigation.views.element.TransitionSet) r9
            java.lang.Object r10 = r0.L$4
            com.reactnativenavigation.views.element.TransitionSet r10 = (com.reactnativenavigation.views.element.TransitionSet) r10
            java.lang.Object r2 = r0.L$3
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController r2 = (com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController) r2
            java.lang.Object r4 = r0.L$2
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController r4 = (com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController) r4
            java.lang.Object r5 = r0.L$1
            com.reactnativenavigation.options.LayoutAnimation r5 = (com.reactnativenavigation.options.LayoutAnimation) r5
            java.lang.Object r6 = r0.L$0
            com.reactnativenavigation.views.element.TransitionSetCreator r6 = (com.reactnativenavigation.views.element.TransitionSetCreator) r6
            kotlin.ResultKt.throwOnFailure(r11)
            goto L89
        L5e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.reactnativenavigation.views.element.TransitionSet r11 = new com.reactnativenavigation.views.element.TransitionSet
            r11.<init>()
            com.reactnativenavigation.options.SharedElements r2 = r8.getSharedElements()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r11
            r0.L$5 = r11
            r0.L$6 = r11
            r0.label = r4
            java.lang.Object r2 = r7.createSharedElementTransitions(r9, r10, r2, r0)
            if (r2 != r1) goto L81
            return r1
        L81:
            r6 = r7
            r5 = r8
            r4 = r9
            r8 = r11
            r9 = r8
            r11 = r2
            r2 = r10
            r10 = r9
        L89:
            java.util.List r11 = (java.util.List) r11
            r8.addAll(r11)
            com.reactnativenavigation.options.ElementTransitions r8 = r5.getElementTransitions()
            r0.L$0 = r10
            r0.L$1 = r9
            r11 = 0
            r0.L$2 = r11
            r0.L$3 = r11
            r0.L$4 = r11
            r0.L$5 = r11
            r0.L$6 = r11
            r0.label = r3
            java.lang.Object r11 = r6.createElementTransitions(r4, r2, r8, r0)
            if (r11 != r1) goto Laa
            return r1
        Laa:
            r8 = r9
            r9 = r10
        Lac:
            java.util.List r11 = (java.util.List) r11
            r8.addAll(r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.views.element.TransitionSetCreator.create(com.reactnativenavigation.options.LayoutAnimation, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.views.element.TransitionSetCreator$createSharedElementTransitions$2 */
    /* JADX INFO: compiled from: TransitionSetCreator.kt */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lcom/reactnativenavigation/views/element/SharedElementTransition;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.views.element.TransitionSetCreator$createSharedElementTransitions$2", m5608f = "TransitionSetCreator.kt", m5609i = {}, m5610l = {37}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C40222 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SharedElementTransition>>, Object> {
        final /* synthetic */ ViewController<?> $fromScreen;
        final /* synthetic */ SharedElements $sharedElements;
        final /* synthetic */ ViewController<?> $toScreen;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40222(SharedElements sharedElements, ViewController<?> viewController, ViewController<?> viewController2, Continuation<? super C40222> continuation) {
            super(2, continuation);
            this.$sharedElements = sharedElements;
            this.$toScreen = viewController;
            this.$fromScreen = viewController2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C40222 c40222 = new C40222(this.$sharedElements, this.$toScreen, this.$fromScreen, continuation);
            c40222.L$0 = obj;
            return c40222;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SharedElementTransition>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<SharedElementTransition>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<SharedElementTransition>> continuation) {
            return ((C40222) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                List<SharedElementTransitionOptions> list = this.$sharedElements.get();
                ViewController<?> viewController = this.$toScreen;
                ViewController<?> viewController2 = this.$fromScreen;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new TransitionSetCreator$createSharedElementTransitions$2$1$1(viewController, (SharedElementTransitionOptions) it2.next(), viewController2, null), 3, null));
                }
                this.label = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
                if (((SharedElementTransition) obj2).isValid()) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createSharedElementTransitions(ViewController<?> viewController, ViewController<?> viewController2, SharedElements sharedElements, Continuation<? super List<? extends Transition>> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C40222(sharedElements, viewController2, viewController, null), continuation);
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.views.element.TransitionSetCreator$createElementTransitions$2 */
    /* JADX INFO: compiled from: TransitionSetCreator.kt */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lcom/reactnativenavigation/views/element/ElementTransition;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.views.element.TransitionSetCreator$createElementTransitions$2", m5608f = "TransitionSetCreator.kt", m5609i = {}, m5610l = {Elf64_Ehdr.e_shstrndx}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C40212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ElementTransition>>, Object> {
        final /* synthetic */ ElementTransitions $elementTransitions;
        final /* synthetic */ ViewController<?> $fromScreen;
        final /* synthetic */ ViewController<?> $toScreen;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40212(ElementTransitions elementTransitions, ViewController<?> viewController, ViewController<?> viewController2, Continuation<? super C40212> continuation) {
            super(2, continuation);
            this.$elementTransitions = elementTransitions;
            this.$fromScreen = viewController;
            this.$toScreen = viewController2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C40212 c40212 = new C40212(this.$elementTransitions, this.$fromScreen, this.$toScreen, continuation);
            c40212.L$0 = obj;
            return c40212;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ElementTransition>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<ElementTransition>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ElementTransition>> continuation) {
            return ((C40212) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ArrayList<ElementTransitionOptions> transitions = this.$elementTransitions.getTransitions();
                ViewController<?> viewController = this.$fromScreen;
                ViewController<?> viewController2 = this.$toScreen;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(transitions, 10));
                Iterator<T> it2 = transitions.iterator();
                while (it2.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new TransitionSetCreator$createElementTransitions$2$1$1((ElementTransitionOptions) it2.next(), viewController, viewController2, null), 3, null));
                }
                this.label = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
                if (((ElementTransition) obj2).isValid()) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createElementTransitions(ViewController<?> viewController, ViewController<?> viewController2, ElementTransitions elementTransitions, Continuation<? super List<ElementTransition>> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C40212(elementTransitions, viewController, viewController2, null), continuation);
    }
}
