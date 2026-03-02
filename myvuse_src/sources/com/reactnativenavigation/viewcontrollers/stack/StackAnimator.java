package com.reactnativenavigation.viewcontrollers.stack;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.ViewGroup;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.StackAnimationOptions;
import com.reactnativenavigation.utils.ViewExtensionsKt;
import com.reactnativenavigation.viewcontrollers.common.BaseAnimator;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.element.TransitionAnimatorCreator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: StackAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J>\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J>\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J>\u0010$\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\n2\u0006\u0010%\u001a\u00020#2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\b\u0010(\u001a\u00020\nH\u0014J\u001c\u0010)\u001a\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010*\u001a\u00020\n2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010+\u001a\u00020\n2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0014\u0010,\u001a\u00020\u00162\n\u0010-\u001a\u0006\u0012\u0002\b\u00030\tH\u0007J\u0016\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tH\u0016J>\u00101\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J6\u00102\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00103\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\nH\u0082@¢\u0006\u0002\u00104J>\u00105\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J<\u0010\"\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00103\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ0\u00106\u001a\u0002072\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00108\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\nH\u0002J>\u00109\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00103\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J<\u0010%\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00108\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fR,\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR,\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/stack/StackAnimator;", "Lcom/reactnativenavigation/viewcontrollers/common/BaseAnimator;", "context", "Landroid/content/Context;", "transitionAnimatorCreator", "Lcom/reactnativenavigation/views/element/TransitionAnimatorCreator;", "(Landroid/content/Context;Lcom/reactnativenavigation/views/element/TransitionAnimatorCreator;)V", "runningPopAnimations", "", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "Landroid/animation/AnimatorSet;", "getRunningPopAnimations$annotations", "()V", "getRunningPopAnimations", "()Ljava/util/Map;", "runningPushAnimations", "getRunningPushAnimations$annotations", "getRunningPushAnimations", "runningSetRootAnimations", "getRunningSetRootAnimations$annotations", "getRunningSetRootAnimations", "animatePop", "", "appearing", "disappearing", "disappearingOptions", "Lcom/reactnativenavigation/options/Options;", "additionalAnimations", "", "Landroid/animation/Animator;", "onAnimationEnd", "Ljava/lang/Runnable;", "animatePushWithoutElementTransitions", "set", "push", "Lcom/reactnativenavigation/options/StackAnimationOptions;", "animateSetRoot", "setRoot", "cancelAllAnimations", "cancelPushAnimations", "createAnimatorSet", "createPopAnimator", "createPushAnimator", "createSetRootAnimator", "endPushAnimation", "view", "isChildInTransition", "", "child", "pop", "popWithElementTransitions", "resolvedOptions", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/options/Options;Landroid/animation/AnimatorSet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "popWithoutElementTransitions", "pushWithElementTransition", "Lkotlinx/coroutines/Job;", "options", "pushWithoutElementTransitions", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class StackAnimator extends BaseAnimator {
    private final Map<ViewController<?>, AnimatorSet> runningPopAnimations;
    private final Map<ViewController<?>, AnimatorSet> runningPushAnimations;
    private final Map<ViewController<?>, AnimatorSet> runningSetRootAnimations;
    private final TransitionAnimatorCreator transitionAnimatorCreator;

    /* JADX INFO: renamed from: com.reactnativenavigation.viewcontrollers.stack.StackAnimator$popWithElementTransitions$1 */
    /* JADX INFO: compiled from: StackAnimator.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.viewcontrollers.stack.StackAnimator", m5608f = "StackAnimator.kt", m5609i = {0, 0, 0}, m5610l = {129}, m5611m = "popWithElementTransitions", m5612n = {"disappearing", "set", "fade"}, m5613s = {"L$0", "L$1", "L$2"})
    static final class C40011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C40011(Continuation<? super C40011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StackAnimator.this.popWithElementTransitions(null, null, null, null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StackAnimator(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getRunningPopAnimations$annotations() {
    }

    public static /* synthetic */ void getRunningPushAnimations$annotations() {
    }

    public static /* synthetic */ void getRunningSetRootAnimations$annotations() {
    }

    public /* synthetic */ StackAnimator(Context context, TransitionAnimatorCreator transitionAnimatorCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new TransitionAnimatorCreator(null, 1, null) : transitionAnimatorCreator);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackAnimator(Context context, TransitionAnimatorCreator transitionAnimatorCreator) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(transitionAnimatorCreator, "transitionAnimatorCreator");
        this.transitionAnimatorCreator = transitionAnimatorCreator;
        this.runningPushAnimations = new HashMap();
        this.runningPopAnimations = new HashMap();
        this.runningSetRootAnimations = new HashMap();
    }

    public final Map<ViewController<?>, AnimatorSet> getRunningPushAnimations() {
        return this.runningPushAnimations;
    }

    public final Map<ViewController<?>, AnimatorSet> getRunningPopAnimations() {
        return this.runningPopAnimations;
    }

    public final Map<ViewController<?>, AnimatorSet> getRunningSetRootAnimations() {
        return this.runningSetRootAnimations;
    }

    public final void cancelPushAnimations() {
        Iterator<T> it2 = this.runningPushAnimations.values().iterator();
        while (it2.hasNext()) {
            ((Animator) it2.next()).cancel();
        }
    }

    public boolean isChildInTransition(ViewController<?> child) {
        return this.runningPushAnimations.containsKey(child) || this.runningPopAnimations.containsKey(child) || this.runningSetRootAnimations.containsKey(child);
    }

    public final void cancelAllAnimations() {
        this.runningPushAnimations.clear();
        this.runningPopAnimations.clear();
        this.runningSetRootAnimations.clear();
    }

    public final void setRoot(final ViewController<?> appearing, final ViewController<?> disappearing, Options options, final List<? extends Animator> additionalAnimations, Runnable onAnimationEnd) {
        Intrinsics.checkNotNullParameter(appearing, "appearing");
        Intrinsics.checkNotNullParameter(disappearing, "disappearing");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(additionalAnimations, "additionalAnimations");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        final AnimatorSet animatorSetCreateSetRootAnimator = createSetRootAnimator(appearing, onAnimationEnd);
        this.runningSetRootAnimations.put(appearing, animatorSetCreateSetRootAnimator);
        final StackAnimationOptions stackAnimationOptions = options.animations.setStackRoot;
        if (stackAnimationOptions.waitForRender.isTrue()) {
            appearing.getView().setAlpha(0.0f);
            appearing.addOnAppearedListener(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackAnimator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    StackAnimator.setRoot$lambda$0(appearing, this, animatorSetCreateSetRootAnimator, stackAnimationOptions, disappearing, additionalAnimations);
                }
            });
        } else {
            animateSetRoot(animatorSetCreateSetRootAnimator, stackAnimationOptions, appearing, disappearing, additionalAnimations);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRoot$lambda$0(ViewController appearing, StackAnimator this$0, AnimatorSet set, StackAnimationOptions setRoot, ViewController disappearing, List additionalAnimations) {
        Intrinsics.checkNotNullParameter(appearing, "$appearing");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(set, "$set");
        Intrinsics.checkNotNullParameter(setRoot, "$setRoot");
        Intrinsics.checkNotNullParameter(disappearing, "$disappearing");
        Intrinsics.checkNotNullParameter(additionalAnimations, "$additionalAnimations");
        appearing.getView().setAlpha(1.0f);
        this$0.animateSetRoot(set, setRoot, appearing, disappearing, additionalAnimations);
    }

    public final void push(ViewController<?> appearing, ViewController<?> disappearing, Options resolvedOptions, List<? extends Animator> additionalAnimations, Runnable onAnimationEnd) {
        Intrinsics.checkNotNullParameter(appearing, "appearing");
        Intrinsics.checkNotNullParameter(disappearing, "disappearing");
        Intrinsics.checkNotNullParameter(resolvedOptions, "resolvedOptions");
        Intrinsics.checkNotNullParameter(additionalAnimations, "additionalAnimations");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        AnimatorSet animatorSetCreatePushAnimator = createPushAnimator(appearing, onAnimationEnd);
        this.runningPushAnimations.put(appearing, animatorSetCreatePushAnimator);
        if (resolvedOptions.animations.push.getSharedElements().hasValue()) {
            pushWithElementTransition(appearing, disappearing, resolvedOptions, animatorSetCreatePushAnimator);
        } else {
            pushWithoutElementTransitions(appearing, disappearing, resolvedOptions, animatorSetCreatePushAnimator, additionalAnimations);
        }
    }

    public void pop(ViewController<?> appearing, ViewController<?> disappearing, Options disappearingOptions, List<? extends Animator> additionalAnimations, Runnable onAnimationEnd) {
        Intrinsics.checkNotNullParameter(appearing, "appearing");
        Intrinsics.checkNotNullParameter(disappearing, "disappearing");
        Intrinsics.checkNotNullParameter(disappearingOptions, "disappearingOptions");
        Intrinsics.checkNotNullParameter(additionalAnimations, "additionalAnimations");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        if (this.runningPushAnimations.containsKey(disappearing)) {
            AnimatorSet animatorSet = this.runningPushAnimations.get(disappearing);
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.cancel();
            onAnimationEnd.run();
            return;
        }
        animatePop(appearing, disappearing, disappearingOptions, additionalAnimations, onAnimationEnd);
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.viewcontrollers.stack.StackAnimator$animatePop$1 */
    /* JADX INFO: compiled from: StackAnimator.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.viewcontrollers.stack.StackAnimator$animatePop$1", m5608f = "StackAnimator.kt", m5609i = {}, m5610l = {119}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C39961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Animator> $additionalAnimations;
        final /* synthetic */ ViewController<?> $appearing;
        final /* synthetic */ ViewController<?> $disappearing;
        final /* synthetic */ Options $disappearingOptions;
        final /* synthetic */ Runnable $onAnimationEnd;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C39961(ViewController<?> viewController, Runnable runnable, Options options, ViewController<?> viewController2, List<? extends Animator> list, Continuation<? super C39961> continuation) {
            super(2, continuation);
            this.$disappearing = viewController;
            this.$onAnimationEnd = runnable;
            this.$disappearingOptions = options;
            this.$appearing = viewController2;
            this.$additionalAnimations = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StackAnimator.this.new C39961(this.$disappearing, this.$onAnimationEnd, this.$disappearingOptions, this.$appearing, this.$additionalAnimations, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C39961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnimatorSet animatorSetCreatePopAnimator = StackAnimator.this.createPopAnimator(this.$disappearing, this.$onAnimationEnd);
                if (this.$disappearingOptions.animations.pop.getSharedElements().hasValue()) {
                    this.label = 1;
                    if (StackAnimator.this.popWithElementTransitions(this.$appearing, this.$disappearing, this.$disappearingOptions, animatorSetCreatePopAnimator, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    StackAnimator.this.popWithoutElementTransitions(this.$appearing, this.$disappearing, this.$disappearingOptions, animatorSetCreatePopAnimator, this.$additionalAnimations);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void animatePop(ViewController<?> appearing, ViewController<?> disappearing, Options disappearingOptions, List<? extends Animator> additionalAnimations, Runnable onAnimationEnd) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new C39961(disappearing, onAnimationEnd, disappearingOptions, appearing, additionalAnimations, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object popWithElementTransitions(com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r10, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r11, com.reactnativenavigation.options.Options r12, android.animation.AnimatorSet r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.reactnativenavigation.viewcontrollers.stack.StackAnimator.C40011
            if (r0 == 0) goto L14
            r0 = r14
            com.reactnativenavigation.viewcontrollers.stack.StackAnimator$popWithElementTransitions$1 r0 = (com.reactnativenavigation.viewcontrollers.stack.StackAnimator.C40011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.reactnativenavigation.viewcontrollers.stack.StackAnimator$popWithElementTransitions$1 r0 = new com.reactnativenavigation.viewcontrollers.stack.StackAnimator$popWithElementTransitions$1
            r0.<init>(r14)
        L19:
            r6 = r0
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r7 = 1
            if (r1 == 0) goto L40
            if (r1 != r7) goto L38
            java.lang.Object r10 = r6.L$2
            com.reactnativenavigation.options.StackAnimationOptions r10 = (com.reactnativenavigation.options.StackAnimationOptions) r10
            java.lang.Object r11 = r6.L$1
            r13 = r11
            android.animation.AnimatorSet r13 = (android.animation.AnimatorSet) r13
            java.lang.Object r11 = r6.L$0
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController r11 = (com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L74
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            kotlin.ResultKt.throwOnFailure(r14)
            com.reactnativenavigation.options.AnimationsOptions r12 = r12.animations
            com.reactnativenavigation.options.StackAnimationOptions r12 = r12.pop
            com.reactnativenavigation.options.animations.ViewAnimationOptions r14 = r12.content
            com.reactnativenavigation.options.AnimationOptions r14 = r14.exit
            boolean r14 = r14.isFadeAnimation()
            if (r14 == 0) goto L53
            r14 = r12
            goto L57
        L53:
            com.reactnativenavigation.options.FadeAnimation r14 = com.reactnativenavigation.options.FadeAnimation.INSTANCE
            com.reactnativenavigation.options.StackAnimationOptions r14 = (com.reactnativenavigation.options.StackAnimationOptions) r14
        L57:
            com.reactnativenavigation.views.element.TransitionAnimatorCreator r1 = r9.transitionAnimatorCreator
            r2 = r12
            com.reactnativenavigation.options.LayoutAnimation r2 = (com.reactnativenavigation.options.LayoutAnimation) r2
            com.reactnativenavigation.options.animations.ViewAnimationOptions r12 = r14.content
            com.reactnativenavigation.options.AnimationOptions r3 = r12.exit
            r6.L$0 = r11
            r6.L$1 = r13
            r6.L$2 = r14
            r6.label = r7
            r4 = r11
            r5 = r10
            java.lang.Object r10 = r1.create(r2, r3, r4, r5, r6)
            if (r10 != r0) goto L71
            return r0
        L71:
            r8 = r14
            r14 = r10
            r10 = r8
        L74:
            android.animation.AnimatorSet r14 = (android.animation.AnimatorSet) r14
            r12 = 2
            android.animation.Animator[] r12 = new android.animation.Animator[r12]
            com.reactnativenavigation.options.animations.ViewAnimationOptions r10 = r10.content
            com.reactnativenavigation.options.AnimationOptions r10 = r10.exit
            android.view.ViewGroup r11 = r11.getView()
            java.lang.String r0 = "getView(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            android.view.View r11 = (android.view.View) r11
            android.animation.Animator r10 = r10.getAnimation(r11)
            r11 = 0
            r12[r11] = r10
            r12[r7] = r14
            r13.playTogether(r12)
            java.util.ArrayList r10 = r14.getListeners()
            java.lang.String r11 = "getListeners(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        La3:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lb3
            java.lang.Object r11 = r10.next()
            android.animation.Animator$AnimatorListener r11 = (android.animation.Animator.AnimatorListener) r11
            r13.addListener(r11)
            goto La3
        Lb3:
            r14.removeAllListeners()
            r13.start()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.viewcontrollers.stack.StackAnimator.popWithElementTransitions(com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, com.reactnativenavigation.options.Options, android.animation.AnimatorSet, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void popWithoutElementTransitions(ViewController<?> appearing, ViewController<?> disappearing, Options disappearingOptions, AnimatorSet set, List<? extends Animator> additionalAnimations) {
        StackAnimationOptions stackAnimationOptions = disappearingOptions.animations.pop;
        AnimationOptions animationOptions = stackAnimationOptions.content.exit;
        ViewGroup view = disappearing.getView();
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        AnimatorSet defaultPopAnimation = getDefaultPopAnimation(disappearing.getView());
        Intrinsics.checkNotNullExpressionValue(defaultPopAnimation, "getDefaultPopAnimation(...)");
        List listMutableListOf = CollectionsKt.mutableListOf(animationOptions.getAnimation(view, defaultPopAnimation));
        listMutableListOf.addAll(additionalAnimations);
        if (stackAnimationOptions.content.enter.hasValue()) {
            AnimationOptions animationOptions2 = stackAnimationOptions.content.enter;
            ViewGroup view2 = appearing.getView();
            Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
            listMutableListOf.add(animationOptions2.getAnimation(view2));
        }
        set.playTogether(CollectionsKt.toList(listMutableListOf));
        set.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnimatorSet createPopAnimator(final ViewController<?> disappearing, final Runnable onAnimationEnd) {
        AnimatorSet animatorSetCreateAnimatorSet = createAnimatorSet();
        this.runningPopAnimations.put(disappearing, animatorSetCreateAnimatorSet);
        animatorSetCreateAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackAnimator.createPopAnimator.1
            private boolean cancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (StackAnimator.this.getRunningPopAnimations().containsKey(disappearing)) {
                    this.cancelled = true;
                    StackAnimator.this.getRunningPopAnimations().remove(disappearing);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (StackAnimator.this.getRunningPopAnimations().containsKey(disappearing)) {
                    StackAnimator.this.getRunningPopAnimations().remove(disappearing);
                    if (this.cancelled) {
                        return;
                    }
                    onAnimationEnd.run();
                }
            }
        });
        return animatorSetCreateAnimatorSet;
    }

    private final AnimatorSet createPushAnimator(final ViewController<?> appearing, final Runnable onAnimationEnd) {
        AnimatorSet animatorSetCreateAnimatorSet = createAnimatorSet();
        animatorSetCreateAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackAnimator.createPushAnimator.1
            private boolean isCancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (StackAnimator.this.getRunningPushAnimations().containsKey(appearing)) {
                    this.isCancelled = true;
                    StackAnimator.this.getRunningPushAnimations().remove(appearing);
                    onAnimationEnd.run();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (StackAnimator.this.getRunningPushAnimations().containsKey(appearing) && !this.isCancelled) {
                    StackAnimator.this.getRunningPushAnimations().remove(appearing);
                    onAnimationEnd.run();
                }
            }
        });
        return animatorSetCreateAnimatorSet;
    }

    private final AnimatorSet createSetRootAnimator(final ViewController<?> appearing, final Runnable onAnimationEnd) {
        AnimatorSet animatorSetCreateAnimatorSet = createAnimatorSet();
        animatorSetCreateAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackAnimator.createSetRootAnimator.1
            private boolean isCancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (StackAnimator.this.getRunningSetRootAnimations().containsKey(appearing)) {
                    this.isCancelled = true;
                    StackAnimator.this.getRunningSetRootAnimations().remove(appearing);
                    onAnimationEnd.run();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (StackAnimator.this.getRunningSetRootAnimations().containsKey(appearing) && !this.isCancelled) {
                    StackAnimator.this.getRunningSetRootAnimations().remove(appearing);
                    onAnimationEnd.run();
                }
            }
        });
        return animatorSetCreateAnimatorSet;
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.viewcontrollers.stack.StackAnimator$pushWithElementTransition$1 */
    /* JADX INFO: compiled from: StackAnimator.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.viewcontrollers.stack.StackAnimator$pushWithElementTransition$1", m5608f = "StackAnimator.kt", m5609i = {1}, m5610l = {226, 228}, m5611m = "invokeSuspend", m5612n = {"fade"}, m5613s = {"L$0"})
    static final class C40021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewController<?> $appearing;
        final /* synthetic */ ViewController<?> $disappearing;
        final /* synthetic */ Options $options;
        final /* synthetic */ AnimatorSet $set;
        Object L$0;
        int label;
        final /* synthetic */ StackAnimator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C40021(ViewController<?> viewController, Options options, StackAnimator stackAnimator, ViewController<?> viewController2, AnimatorSet animatorSet, Continuation<? super C40021> continuation) {
            super(2, continuation);
            this.$appearing = viewController;
            this.$options = options;
            this.this$0 = stackAnimator;
            this.$disappearing = viewController2;
            this.$set = animatorSet;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C40021(this.$appearing, this.$options, this.this$0, this.$disappearing, this.$set, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C40021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00c5 A[LOOP:0: B:22:0x00bf->B:24:0x00c5, LOOP_END] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 218
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.viewcontrollers.stack.StackAnimator.C40021.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Job pushWithElementTransition(ViewController<?> appearing, ViewController<?> disappearing, Options options, AnimatorSet set) {
        return BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new C40021(appearing, options, this, disappearing, set, null), 2, null);
    }

    private final void pushWithoutElementTransitions(final ViewController<?> appearing, final ViewController<?> disappearing, Options resolvedOptions, final AnimatorSet set, final List<? extends Animator> additionalAnimations) {
        final StackAnimationOptions stackAnimationOptions = resolvedOptions.animations.push;
        if (stackAnimationOptions.waitForRender.isTrue()) {
            appearing.getView().setAlpha(0.0f);
            appearing.addOnAppearedListener(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackAnimator$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    StackAnimator.pushWithoutElementTransitions$lambda$2(appearing, this, set, stackAnimationOptions, disappearing, additionalAnimations);
                }
            });
        } else {
            animatePushWithoutElementTransitions(set, stackAnimationOptions, appearing, disappearing, additionalAnimations);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pushWithoutElementTransitions$lambda$2(ViewController appearing, StackAnimator this$0, AnimatorSet set, StackAnimationOptions push, ViewController disappearing, List additionalAnimations) {
        Intrinsics.checkNotNullParameter(appearing, "$appearing");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(set, "$set");
        Intrinsics.checkNotNullParameter(push, "$push");
        Intrinsics.checkNotNullParameter(disappearing, "$disappearing");
        Intrinsics.checkNotNullParameter(additionalAnimations, "$additionalAnimations");
        appearing.getView().setAlpha(1.0f);
        this$0.animatePushWithoutElementTransitions(set, push, appearing, disappearing, additionalAnimations);
    }

    private final void animatePushWithoutElementTransitions(AnimatorSet set, StackAnimationOptions push, ViewController<?> appearing, final ViewController<?> disappearing, List<? extends Animator> additionalAnimations) {
        AnimationOptions animationOptions = push.content.enter;
        ViewGroup view = appearing.getView();
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        AnimatorSet defaultPushAnimation = getDefaultPushAnimation(appearing.getView());
        Intrinsics.checkNotNullExpressionValue(defaultPushAnimation, "getDefaultPushAnimation(...)");
        List listMutableListOf = CollectionsKt.mutableListOf(animationOptions.getAnimation(view, defaultPushAnimation));
        listMutableListOf.addAll(additionalAnimations);
        if (push.content.exit.hasValue()) {
            AnimationOptions animationOptions2 = push.content.exit;
            ViewGroup view2 = disappearing.getView();
            Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
            listMutableListOf.add(animationOptions2.getAnimation(view2));
        }
        set.playTogether(CollectionsKt.toList(listMutableListOf));
        set.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackAnimator$animatePushWithoutElementTransitions$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                if (disappearing.isDestroyed()) {
                    return;
                }
                ViewGroup view3 = disappearing.getView();
                Intrinsics.checkNotNullExpressionValue(view3, "getView(...)");
                ViewExtensionsKt.resetViewProperties(view3);
            }
        });
        set.start();
    }

    private final void animateSetRoot(AnimatorSet set, StackAnimationOptions setRoot, ViewController<?> appearing, ViewController<?> disappearing, List<? extends Animator> additionalAnimations) {
        AnimationOptions animationOptions = setRoot.content.enter;
        ViewGroup view = appearing.getView();
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        AnimatorSet defaultSetStackRootAnimation = getDefaultSetStackRootAnimation(appearing.getView());
        Intrinsics.checkNotNullExpressionValue(defaultSetStackRootAnimation, "getDefaultSetStackRootAnimation(...)");
        List listMutableListOf = CollectionsKt.mutableListOf(animationOptions.getAnimation(view, defaultSetStackRootAnimation));
        listMutableListOf.addAll(additionalAnimations);
        if (setRoot.content.exit.hasValue()) {
            AnimationOptions animationOptions2 = setRoot.content.exit;
            ViewGroup view2 = disappearing.getView();
            Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
            listMutableListOf.add(animationOptions2.getAnimation(view2));
        }
        set.playTogether(CollectionsKt.toList(listMutableListOf));
        set.start();
    }

    protected AnimatorSet createAnimatorSet() {
        return new AnimatorSet();
    }

    public final void endPushAnimation(ViewController<?> view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.runningPushAnimations.containsKey(view)) {
            AnimatorSet animatorSet = this.runningPushAnimations.get(view);
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.end();
        }
    }
}
