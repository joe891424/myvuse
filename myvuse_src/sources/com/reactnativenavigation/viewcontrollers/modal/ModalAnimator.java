package com.reactnativenavigation.viewcontrollers.modal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.options.FadeAnimation;
import com.reactnativenavigation.options.StackAnimationOptions;
import com.reactnativenavigation.options.TransitionAnimationOptions;
import com.reactnativenavigation.utils.ScreenAnimationListener;
import com.reactnativenavigation.viewcontrollers.common.BaseAnimator;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.element.TransitionAnimatorCreator;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* JADX INFO: compiled from: ModalAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\u0014\u001a\u00020\u000f2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\u00020\u000f2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J2\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J6\u0010\u001e\u001a\u00020\u001b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010 J2\u0010!\u001a\u00020\u001b2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u000e2\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J0\u0010\"\u001a\u00020\u001b2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u000e2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J2\u0010#\u001a\u00020\u001b2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u000e2\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR.\u0010\f\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/modal/ModalAnimator;", "Lcom/reactnativenavigation/viewcontrollers/common/BaseAnimator;", "context", "Landroid/content/Context;", "transitionAnimatorCreator", "Lcom/reactnativenavigation/views/element/TransitionAnimatorCreator;", "defaultAnimation", "Lcom/reactnativenavigation/options/StackAnimationOptions;", "(Landroid/content/Context;Lcom/reactnativenavigation/views/element/TransitionAnimatorCreator;Lcom/reactnativenavigation/options/StackAnimationOptions;)V", "isRunning", "", "()Z", "runningAnimators", "", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "Landroid/animation/AnimatorSet;", "getRunningAnimators$react_native_navigation_reactNative71Release$annotations", "()V", "getRunningAnimators$react_native_navigation_reactNative71Release", "()Ljava/util/Map;", "createDismissAnimator", "disappearing", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/reactnativenavigation/utils/ScreenAnimationListener;", "createShowModalAnimator", "appearing", "dismiss", "", "animationOptions", "Lcom/reactnativenavigation/options/TransitionAnimationOptions;", "setupDismissAnimationWithSharedElementTransition", "set", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/options/TransitionAnimationOptions;Landroid/animation/AnimatorSet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "showModalWithElementTransition", "showModalWithoutElementTransition", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ModalAnimator extends BaseAnimator {
    private final StackAnimationOptions defaultAnimation;
    private final Map<ViewController<?>, AnimatorSet> runningAnimators;
    private final TransitionAnimatorCreator transitionAnimatorCreator;

    /* JADX INFO: renamed from: com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$setupDismissAnimationWithSharedElementTransition$1 */
    /* JADX INFO: compiled from: ModalAnimator.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.viewcontrollers.modal.ModalAnimator", m5608f = "ModalAnimator.kt", m5609i = {0, 0, 0}, m5610l = {155}, m5611m = "setupDismissAnimationWithSharedElementTransition", m5612n = {"disappearing", "set", "disappearFade"}, m5613s = {"L$0", "L$1", "L$2"})
    static final class C39871 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C39871(Continuation<? super C39871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ModalAnimator.this.setupDismissAnimationWithSharedElementTransition(null, null, null, null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModalAnimator(Context context) {
        this(context, null, null, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModalAnimator(Context context, TransitionAnimatorCreator transitionAnimatorCreator) {
        this(context, transitionAnimatorCreator, null, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(transitionAnimatorCreator, "transitionAnimatorCreator");
    }

    /* JADX INFO: renamed from: getRunningAnimators$react_native_navigation_reactNative71Release$annotations */
    public static /* synthetic */ void m2798xdb68de1b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ModalAnimator(Context context, TransitionAnimatorCreator transitionAnimatorCreator, FadeAnimation fadeAnimation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new TransitionAnimatorCreator(null, 1, 0 == true ? 1 : 0) : transitionAnimatorCreator, (i & 4) != 0 ? FadeAnimation.INSTANCE : fadeAnimation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalAnimator(Context context, TransitionAnimatorCreator transitionAnimatorCreator, StackAnimationOptions defaultAnimation) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(transitionAnimatorCreator, "transitionAnimatorCreator");
        Intrinsics.checkNotNullParameter(defaultAnimation, "defaultAnimation");
        this.transitionAnimatorCreator = transitionAnimatorCreator;
        this.defaultAnimation = defaultAnimation;
        this.runningAnimators = new HashMap();
    }

    public final boolean isRunning() {
        return !this.runningAnimators.isEmpty();
    }

    public final Map<ViewController<?>, AnimatorSet> getRunningAnimators$react_native_navigation_reactNative71Release() {
        return this.runningAnimators;
    }

    public void show(ViewController<?> appearing, ViewController<?> disappearing, TransitionAnimationOptions animationOptions, ScreenAnimationListener listener) {
        Intrinsics.checkNotNullParameter(appearing, "appearing");
        Intrinsics.checkNotNullParameter(animationOptions, "animationOptions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AnimatorSet animatorSetCreateShowModalAnimator = createShowModalAnimator(appearing, listener);
        this.runningAnimators.put(appearing, animatorSetCreateShowModalAnimator);
        if (animationOptions.hasElementTransitions() && disappearing != null) {
            showModalWithElementTransition(appearing, disappearing, animationOptions, animatorSetCreateShowModalAnimator);
        } else {
            showModalWithoutElementTransition(appearing, disappearing, animationOptions, animatorSetCreateShowModalAnimator);
        }
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$showModalWithElementTransition$1 */
    /* JADX INFO: compiled from: ModalAnimator.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$showModalWithElementTransition$1", m5608f = "ModalAnimator.kt", m5609i = {1}, m5610l = {54, 56}, m5611m = "invokeSuspend", m5612n = {"appearingFade"}, m5613s = {"L$0"})
    static final class C39881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TransitionAnimationOptions $animationOptions;
        final /* synthetic */ ViewController<?> $appearing;
        final /* synthetic */ ViewController<?> $disappearing;
        final /* synthetic */ AnimatorSet $set;
        Object L$0;
        int label;
        final /* synthetic */ ModalAnimator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C39881(ViewController<?> viewController, TransitionAnimationOptions transitionAnimationOptions, ModalAnimator modalAnimator, ViewController<?> viewController2, AnimatorSet animatorSet, Continuation<? super C39881> continuation) {
            super(2, continuation);
            this.$appearing = viewController;
            this.$animationOptions = transitionAnimationOptions;
            this.this$0 = modalAnimator;
            this.$disappearing = viewController2;
            this.$set = animatorSet;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C39881(this.$appearing, this.$animationOptions, this.this$0, this.$disappearing, this.$set, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C39881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00bf A[LOOP:0: B:22:0x00b9->B:24:0x00bf, LOOP_END] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.viewcontrollers.modal.ModalAnimator.C39881.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void showModalWithElementTransition(ViewController<?> appearing, ViewController<?> disappearing, TransitionAnimationOptions animationOptions, AnimatorSet set) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new C39881(appearing, animationOptions, this, disappearing, set, null), 2, null);
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$showModalWithoutElementTransition$1 */
    /* JADX INFO: compiled from: ModalAnimator.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$showModalWithoutElementTransition$1", m5608f = "ModalAnimator.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C39891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TransitionAnimationOptions $animationOptions;
        final /* synthetic */ ViewController<?> $appearing;
        final /* synthetic */ ViewController<?> $disappearing;
        final /* synthetic */ AnimatorSet $set;
        int label;
        final /* synthetic */ ModalAnimator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C39891(TransitionAnimationOptions transitionAnimationOptions, ViewController<?> viewController, ModalAnimator modalAnimator, ViewController<?> viewController2, AnimatorSet animatorSet, Continuation<? super C39891> continuation) {
            super(2, continuation);
            this.$animationOptions = transitionAnimationOptions;
            this.$appearing = viewController;
            this.this$0 = modalAnimator;
            this.$disappearing = viewController2;
            this.$set = animatorSet;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C39891(this.$animationOptions, this.$appearing, this.this$0, this.$disappearing, this.$set, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C39891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnimatorSet animation;
            Animator animation2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$animationOptions.getEnter().hasValue()) {
                AnimationOptions enter = this.$animationOptions.getEnter();
                ViewGroup view = this.$appearing.getView();
                Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
                animation = enter.getAnimation(view);
            } else {
                AnimatorSet defaultPushAnimation = this.this$0.getDefaultPushAnimation(this.$appearing.getView());
                Intrinsics.checkNotNullExpressionValue(defaultPushAnimation, "getDefaultPushAnimation(...)");
                animation = defaultPushAnimation;
            }
            Unit unit = null;
            if (this.$disappearing == null || !this.$animationOptions.getExit().hasValue()) {
                animation2 = null;
            } else {
                AnimationOptions exit = this.$animationOptions.getExit();
                ViewGroup view2 = this.$disappearing.getView();
                Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
                animation2 = exit.getAnimation(view2);
            }
            if (animation2 != null) {
                this.$set.playTogether(animation, animation2);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.$set.playTogether(animation);
            }
            this.$set.start();
            return Unit.INSTANCE;
        }
    }

    private final void showModalWithoutElementTransition(ViewController<?> appearing, ViewController<?> disappearing, TransitionAnimationOptions animationOptions, AnimatorSet set) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new C39891(animationOptions, appearing, this, disappearing, set, null), 2, null);
    }

    /* JADX INFO: renamed from: com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$dismiss$1 */
    /* JADX INFO: compiled from: ModalAnimator.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$dismiss$1", m5608f = "ModalAnimator.kt", m5609i = {0}, m5610l = {87}, m5611m = "invokeSuspend", m5612n = {"set"}, m5613s = {"L$0"})
    static final class C39861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TransitionAnimationOptions $animationOptions;
        final /* synthetic */ ViewController<?> $appearing;
        final /* synthetic */ ViewController<?> $disappearing;
        final /* synthetic */ ScreenAnimationListener $listener;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C39861(ViewController<?> viewController, ScreenAnimationListener screenAnimationListener, TransitionAnimationOptions transitionAnimationOptions, ViewController<?> viewController2, Continuation<? super C39861> continuation) {
            super(2, continuation);
            this.$disappearing = viewController;
            this.$listener = screenAnimationListener;
            this.$animationOptions = transitionAnimationOptions;
            this.$appearing = viewController2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ModalAnimator.this.new C39861(this.$disappearing, this.$listener, this.$animationOptions, this.$appearing, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C39861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnimatorSet animatorSetCreateDismissAnimator;
            Animator animation;
            AnimatorSet animation2;
            ViewController<?> viewController;
            AnimatorSet animatorSet;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!ModalAnimator.this.getRunningAnimators$react_native_navigation_reactNative71Release().containsKey(this.$disappearing)) {
                    animatorSetCreateDismissAnimator = ModalAnimator.this.createDismissAnimator(this.$disappearing, this.$listener);
                    if (this.$animationOptions.hasElementTransitions() && (viewController = this.$appearing) != null) {
                        this.L$0 = animatorSetCreateDismissAnimator;
                        this.label = 1;
                        if (ModalAnimator.this.setupDismissAnimationWithSharedElementTransition(this.$disappearing, viewController, this.$animationOptions, animatorSetCreateDismissAnimator, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        animatorSet = animatorSetCreateDismissAnimator;
                    } else {
                        Unit unit = null;
                        if (this.$appearing == null || !this.$animationOptions.getEnter().hasValue()) {
                            animation = null;
                        } else {
                            AnimationOptions enter = this.$animationOptions.getEnter();
                            ViewGroup view = this.$appearing.getView();
                            Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
                            animation = enter.getAnimation(view);
                        }
                        if (this.$animationOptions.getExit().hasValue()) {
                            AnimationOptions exit = this.$animationOptions.getExit();
                            ViewGroup view2 = this.$disappearing.getView();
                            Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
                            animation2 = exit.getAnimation(view2);
                        } else {
                            AnimatorSet defaultPopAnimation = ModalAnimator.this.getDefaultPopAnimation(this.$disappearing.getView());
                            Intrinsics.checkNotNullExpressionValue(defaultPopAnimation, "getDefaultPopAnimation(...)");
                            animation2 = defaultPopAnimation;
                        }
                        if (animation != null) {
                            animatorSetCreateDismissAnimator.playTogether(animation, animation2);
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            animatorSetCreateDismissAnimator.playTogether(animation2);
                        }
                        animatorSetCreateDismissAnimator.start();
                        return Unit.INSTANCE;
                    }
                } else {
                    AnimatorSet animatorSet2 = ModalAnimator.this.getRunningAnimators$react_native_navigation_reactNative71Release().get(this.$disappearing);
                    if (animatorSet2 != null) {
                        animatorSet2.cancel();
                    }
                    this.$listener.onEnd();
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                animatorSet = (AnimatorSet) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            animatorSetCreateDismissAnimator = animatorSet;
            animatorSetCreateDismissAnimator.start();
            return Unit.INSTANCE;
        }
    }

    public void dismiss(ViewController<?> appearing, ViewController<?> disappearing, TransitionAnimationOptions animationOptions, ScreenAnimationListener listener) {
        Intrinsics.checkNotNullParameter(disappearing, "disappearing");
        Intrinsics.checkNotNullParameter(animationOptions, "animationOptions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new C39861(disappearing, listener, animationOptions, appearing, null), 2, null);
    }

    private final AnimatorSet createShowModalAnimator(final ViewController<?> appearing, final ScreenAnimationListener listener) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalAnimator.createShowModalAnimator.1
            private boolean isCancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                listener.onStart();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.isCancelled = true;
                this.getRunningAnimators$react_native_navigation_reactNative71Release().remove(appearing);
                listener.onCancel();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.getRunningAnimators$react_native_navigation_reactNative71Release().remove(appearing);
                if (this.isCancelled) {
                    return;
                }
                listener.onEnd();
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnimatorSet createDismissAnimator(final ViewController<?> disappearing, final ScreenAnimationListener listener) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalAnimator.createDismissAnimator.1
            private boolean isCancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                listener.onStart();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.isCancelled = true;
                this.getRunningAnimators$react_native_navigation_reactNative71Release().remove(disappearing);
                listener.onCancel();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.getRunningAnimators$react_native_navigation_reactNative71Release().remove(disappearing);
                if (this.isCancelled) {
                    return;
                }
                listener.onEnd();
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setupDismissAnimationWithSharedElementTransition(com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r10, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r11, com.reactnativenavigation.options.TransitionAnimationOptions r12, android.animation.AnimatorSet r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof com.reactnativenavigation.viewcontrollers.modal.ModalAnimator.C39871
            if (r0 == 0) goto L14
            r0 = r14
            com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$setupDismissAnimationWithSharedElementTransition$1 r0 = (com.reactnativenavigation.viewcontrollers.modal.ModalAnimator.C39871) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$setupDismissAnimationWithSharedElementTransition$1 r0 = new com.reactnativenavigation.viewcontrollers.modal.ModalAnimator$setupDismissAnimationWithSharedElementTransition$1
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
            com.reactnativenavigation.options.AnimationOptions r10 = (com.reactnativenavigation.options.AnimationOptions) r10
            java.lang.Object r11 = r6.L$1
            r13 = r11
            android.animation.AnimatorSet r13 = (android.animation.AnimatorSet) r13
            java.lang.Object r11 = r6.L$0
            com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController r11 = (com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L73
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            kotlin.ResultKt.throwOnFailure(r14)
            com.reactnativenavigation.options.AnimationOptions r14 = r12.getExit()
            boolean r14 = r14.isFadeAnimation()
            if (r14 == 0) goto L52
            com.reactnativenavigation.options.AnimationOptions r14 = r12.getExit()
            goto L58
        L52:
            com.reactnativenavigation.options.StackAnimationOptions r14 = r9.defaultAnimation
            com.reactnativenavigation.options.animations.ViewAnimationOptions r14 = r14.content
            com.reactnativenavigation.options.AnimationOptions r14 = r14.exit
        L58:
            com.reactnativenavigation.views.element.TransitionAnimatorCreator r1 = r9.transitionAnimatorCreator
            r2 = r12
            com.reactnativenavigation.options.LayoutAnimation r2 = (com.reactnativenavigation.options.LayoutAnimation) r2
            r6.L$0 = r10
            r6.L$1 = r13
            r6.L$2 = r14
            r6.label = r7
            r3 = r14
            r4 = r10
            r5 = r11
            java.lang.Object r11 = r1.create(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L6f
            return r0
        L6f:
            r8 = r11
            r11 = r10
            r10 = r14
            r14 = r8
        L73:
            android.animation.AnimatorSet r14 = (android.animation.AnimatorSet) r14
            r12 = 2
            android.animation.Animator[] r12 = new android.animation.Animator[r12]
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
        L9e:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lae
            java.lang.Object r11 = r10.next()
            android.animation.Animator$AnimatorListener r11 = (android.animation.Animator.AnimatorListener) r11
            r13.addListener(r11)
            goto L9e
        Lae:
            r14.removeAllListeners()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.viewcontrollers.modal.ModalAnimator.setupDismissAnimationWithSharedElementTransition(com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, com.reactnativenavigation.options.TransitionAnimationOptions, android.animation.AnimatorSet, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
